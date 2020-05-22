package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes8.dex */
public class gq {
    private static gq a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Object> f404a = new ConcurrentHashMap();
    private Map<String, Object> b = new ConcurrentHashMap();

    private gq() {
        m320a();
    }

    public static synchronized gq a() {
        gq gqVar;
        synchronized (gq.class) {
            if (a == null) {
                a = new gq();
            }
            gqVar = a;
        }
        return gqVar;
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(str).append("/>");
        if (str != null) {
            sb.append("<").append(str2).append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    private ClassLoader[] m318a() {
        ClassLoader[] classLoaderArr = {gq.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m319a(String str, String str2) {
        return this.f404a.get(a(str, str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    protected void m320a() {
        try {
            for (ClassLoader classLoader : m318a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream openStream = resources.nextElement().openStream();
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                    newPullParser.setInput(openStream, "UTF-8");
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
                                String a2 = a(nextText, nextText2);
                                if (!this.b.containsKey(a2)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (go.class.isAssignableFrom(cls)) {
                                            this.b.put(a2, cls.newInstance());
                                        } else if (gh.class.isAssignableFrom(cls)) {
                                            this.b.put(a2, cls);
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
                                String a3 = a(nextText4, nextText5);
                                if (!this.f404a.containsKey(a3)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (gp.class.isAssignableFrom(cls2)) {
                                            this.f404a.put(a3, cls2.newInstance());
                                        } else if (gk.class.isAssignableFrom(cls2)) {
                                            this.f404a.put(a3, cls2);
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

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof gp) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f404a.put(a(str, str2), obj);
    }
}
