package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes7.dex */
public class gj {

    /* renamed from: a  reason: collision with root package name */
    public static gj f41457a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Object> f435a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Object> f41458b = new ConcurrentHashMap();

    public gj() {
        m337a();
    }

    public static synchronized gj a() {
        gj gjVar;
        synchronized (gj.class) {
            if (f41457a == null) {
                f41457a = new gj();
            }
            gjVar = f41457a;
        }
        return gjVar;
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    private ClassLoader[] m335a() {
        ClassLoader[] classLoaderArr = {gj.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            ClassLoader classLoader = classLoaderArr[i2];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m336a(String str, String str2) {
        return this.f435a.get(a(str, str2));
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x00ff */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m337a() {
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        try {
            for (ClassLoader classLoader : m335a()) {
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
                                if (!this.f41458b.containsKey(a2)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (gh.class.isAssignableFrom(cls)) {
                                            map2 = this.f41458b;
                                            obj2 = cls.newInstance();
                                        } else if (ga.class.isAssignableFrom(cls)) {
                                            map2 = this.f41458b;
                                            obj2 = cls;
                                        }
                                        map2.put(a2, obj2);
                                    } catch (ClassNotFoundException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        eventType = newPullParser.next();
                                        if (eventType == 1) {
                                            openStream.close();
                                        }
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
                                if (!this.f435a.containsKey(a3)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (gi.class.isAssignableFrom(cls2)) {
                                            map = this.f435a;
                                            obj = cls2.newInstance();
                                        } else if (gd.class.isAssignableFrom(cls2)) {
                                            map = this.f435a;
                                            obj = cls2;
                                        }
                                        map.put(a3, obj);
                                    } catch (ClassNotFoundException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        eventType = newPullParser.next();
                                        if (eventType == 1) {
                                        }
                                    }
                                }
                            }
                        }
                        eventType = newPullParser.next();
                    } while (eventType == 1);
                    try {
                        openStream.close();
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof gi) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f435a.put(a(str, str2), obj);
    }
}
