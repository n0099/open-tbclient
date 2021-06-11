package d.m.a.a;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f70254a = 255;

    public static String a() {
        return f70254a != 0 ? "" : "https://bds.snssdk.com";
    }

    public static synchronized void b(int i2) {
        synchronized (a.class) {
            f70254a = i2;
        }
    }

    public static String c() {
        return f70254a != 0 ? "" : "https://sdfp.snssdk.com";
    }
}
