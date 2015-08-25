package com.cloudera.se.util;

import com.cloudera.se.avro.TickerExplicit;
import com.cloudera.se.avro.TickerInline;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by jholoman on 8/23/15.
 */
public class DemoUtils {

    List<String> stockList;

    public DemoUtils() {
     ClassLoader classLoader = this.getClass().getClassLoader();

    InputStream inputStream = classLoader.getResourceAsStream("stocks.txt");

    stockList = getList("/stocks.txt");

    }

    private List<String> getList (String filename) {
        List<String> lines = new ArrayList<String>();

        try {
            File file = new File(filename);
            lines = IOUtils.readLines(this.getClass().getResourceAsStream(filename), "UTF-8");
            //lines = FileUtils.readLines(file, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String getSymbol(){
        String randomLine = stockList.get(RandomUtils.nextInt(0, 8939));
        return randomLine;
    }

    public double getRandomDouble(){
       return round(RandomUtils.nextDouble(0.00, 15.00),4);
    }
    public String getUTC(){
        final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        return f.format(new Date());
    }

    public void setTickerExplicitFields(TickerExplicit te){
        te.setSymobl(getSymbol());
        te.setBidPrice(getRandomDouble());
        te.setAskPrice(getRandomDouble());
        te.setSource("explicit");
        te.setPriceTimeUtc(getUTC());
        te.setLocalTimestamp(System.currentTimeMillis());
    }

    public void setTickerInlineFields(TickerInline ti) {
        ti.setSource("inline");
        ti.setLocalTimestamp(System.currentTimeMillis());
        String payload = getSymbol() + "|" + getRandomDouble() + "|" + getRandomDouble() +"|" + getUTC();
        System.out.println(payload);
        ti.setPayload(payload);
    }
}
