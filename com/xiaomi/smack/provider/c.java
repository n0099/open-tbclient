package com.xiaomi.smack.provider;

import com.xiaomi.smack.packet.e;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes2.dex */
public class c {
    private static c a;
    private Map<String, Object> b = new ConcurrentHashMap();
    private Map<String, Object> c = new ConcurrentHashMap();

    private c() {
        b();
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    private String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(str).append("/>");
        if (str != null) {
            sb.append("<").append(str2).append("/>");
        }
        return sb.toString();
    }

    private ClassLoader[] c() {
        ClassLoader[] classLoaderArr = {c.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public Object a(String str, String str2) {
        return this.b.get(b(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof b) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.b.put(b(str, str2), obj);
    }

    protected void b() {
        try {
            for (ClassLoader classLoader : c()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream openStream = resources.nextElement().openStream();
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                    newPullParser.setInput(openStream, HTTP.UTF_8);
                    int eventType = newPullParser.getEventType();
                    do {
                        if (eventType == 2) {
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText3 = newPullParser.nextText();
                                String b = b(nextText, nextText2);
                                if (!this.c.containsKey(b)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (a.class.isAssignableFrom(cls)) {
                                            this.c.put(b, cls.newInstance());
                                        } else if (com.xiaomi.smack.packet.b.class.isAssignableFrom(cls)) {
                                            this.c.put(b, cls);
                                        }
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText4 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText5 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText6 = newPullParser.nextText();
                                String b2 = b(nextText4, nextText5);
                                if (!this.b.containsKey(b2)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (b.class.isAssignableFrom(cls2)) {
                                            this.b.put(b2, cls2.newInstance());
                                        } else if (e.class.isAssignableFrom(cls2)) {
                                            this.b.put(b2, cls2);
                                        }
                                    } catch (ClassNotFoundException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                        eventType = newPullParser.next();
                    } while (eventType != 1);
                    try {
                        openStream.close();
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
