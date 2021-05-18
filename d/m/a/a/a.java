package d.m.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f66425a = 255;

    public static String a() {
        return f66425a != 0 ? "" : "https://bds.snssdk.com";
    }

    public static synchronized void b(int i2) {
        synchronized (a.class) {
            f66425a = i2;
        }
    }

    public static String c() {
        return f66425a != 0 ? "" : "https://sdfp.snssdk.com";
    }
}
