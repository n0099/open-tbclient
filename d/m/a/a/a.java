package d.m.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f66270a = 255;

    public static String a() {
        return f66270a != 0 ? "" : "https://bds.snssdk.com";
    }

    public static synchronized void b(int i) {
        synchronized (a.class) {
            f66270a = i;
        }
    }

    public static String c() {
        return f66270a != 0 ? "" : "https://sdfp.snssdk.com";
    }
}
