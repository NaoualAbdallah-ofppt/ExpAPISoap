package com.example.expapisoap;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlPullParserExample {
     public static List<Item> parseXml(Context context) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?><items><item><title>Titre 1</title><description>Description 1</description></item><item><title>Titre 2</title><description>Description 2</description></item></items>";
        List<Item> items = new ArrayList<>();
        try {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();
       parser.setInput( new StringReader( xmlString ));

            //   XmlPullParser parser = context.getResources().getXml(context.getResources().g);

            int eventType = parser.getEventType();
            Item itm = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName;
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        Log.d("aa", "Début du document XML");
                        break;
                    case XmlPullParser.START_TAG:
                        tagName = parser.getName();
                        Log.d("aa", "start:"+tagName);
                        if (tagName.equals("item")) {
                            itm = new Item();
                        } else if (tagName.equals("title") && itm != null) {
                            itm.setTitle(parser.nextText());
                            Log.d("aa",itm.getTitle());
                        } else if (tagName.equals("description") && itm != null) {
                            itm.setDescription(parser.nextText());
                            Log.d("aa",itm.getDescription());
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        tagName = parser.getName();
                        Log.d("aa","end:"+ tagName);

                        if (tagName.equals("item") && itm != null) {
                            items.add(itm);
                            itm = null;
                        }
                        break;
                    default:
                        break;
                }

                eventType = parser.next();
            }

            Log.d("aa", "Fin du document XML");
        } catch (XmlPullParserException | IOException e) {
           // e.printStackTrace();
            Log.e("aa",e.getMessage());
        }

        return items;
    }


}
