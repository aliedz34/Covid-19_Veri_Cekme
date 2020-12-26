package com.ahmetoguzdavarci.covid19;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v4.os.IResultReceiver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;

public class IntentServis extends IntentService {

    public IntentServis() {
        super("WorkThread1");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            ResultReceiver rr=intent.getParcelableExtra("receiver");
            Bundle bundle = new Bundle();

            Document doc = Jsoup.connect("https://www.trackcorona.live/").ignoreContentType(true).get();
            Document doc1 = Jsoup.connect("https://www.worldometers.info/coronavirus/country/turkey/").ignoreContentType(true).get();
            Document doc2 = Jsoup.connect("https://www.worldometers.info/coronavirus/country/italy/").ignoreContentType(true).get();
            Document doc3 = Jsoup.connect("https://www.worldometers.info/coronavirus/country/china/").ignoreContentType(true).get();
            Document doc4 = Jsoup.connect("https://www.worldometers.info/coronavirus/country/us/").ignoreContentType(true).get();
            Document doc5 = Jsoup.connect("https://www.worldometers.info/coronavirus/country/spain/").ignoreContentType(true).get();

            Elements resultLinks = doc.select("#valueDed");
            String oluSayisi = resultLinks.text();
            bundle.putString("gelenVeri1",oluSayisi);

            resultLinks = doc.select("#valueTot");
            String vakaSayisi = resultLinks.text();
            bundle.putString("gelenVeri2",vakaSayisi);

            resultLinks = doc1.select("#maincounter-wrap > div > span");
            String turkey = resultLinks.text();
            bundle.putString("turkey",turkey);

            resultLinks = doc2.select("#maincounter-wrap > div > span");
            String italya = resultLinks.text();
            bundle.putString("italya",italya);

            resultLinks = doc3.select("#maincounter-wrap > div > span");
            String cin = resultLinks.text();
            bundle.putString("cin",cin);

            resultLinks = doc4.select("#maincounter-wrap > div > span");
            String abd = resultLinks.text();
            bundle.putString("abd",abd);

            resultLinks = doc5.select("#maincounter-wrap > div > span");
            String ispanya = resultLinks.text();
            bundle.putString("ispanya",ispanya);

            rr.send(10,bundle);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
