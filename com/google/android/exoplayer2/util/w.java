package com.google.android.exoplayer2.util;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes6.dex */
public final class w {
    public static boolean g(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return v(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean v(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean h(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return w(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean w(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }

    public static String i(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
