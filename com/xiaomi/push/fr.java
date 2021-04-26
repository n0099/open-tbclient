package com.xiaomi.push;

import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes7.dex */
public final class fr {

    /* renamed from: a  reason: collision with root package name */
    public static int f38426a = 5000;

    /* renamed from: a  reason: collision with other field name */
    public static Vector<String> f407a = new Vector<>();

    /* renamed from: b  reason: collision with root package name */
    public static int f38427b = 330000;

    /* renamed from: c  reason: collision with root package name */
    public static int f38428c = 600000;

    /* renamed from: d  reason: collision with root package name */
    public static int f38429d = 330000;

    static {
        try {
            for (ClassLoader classLoader : m320a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        inputStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(inputStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals(PushClientConstants.TAG_CLASS_NAME)) {
                                    a(newPullParser);
                                } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                    f38426a = a(newPullParser, f38426a);
                                } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                    f38427b = a(newPullParser, f38427b);
                                } else if (newPullParser.getName().equals("mechName")) {
                                    f407a.add(newPullParser.nextText());
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static int a() {
        return f38427b;
    }

    public static int a(XmlPullParser xmlPullParser, int i2) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m319a() {
        return "3.1.0";
    }

    public static void a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException unused) {
            PrintStream printStream = System.err;
            printStream.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ClassLoader[] m320a() {
        ClassLoader[] classLoaderArr = {fr.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            ClassLoader classLoader = classLoaderArr[i2];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public static int b() {
        return f38428c;
    }
}
