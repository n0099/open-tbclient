package d.n.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f67411a = 255;

    public static String a() {
        return f67411a != 0 ? "" : "https://bds.snssdk.com";
    }

    public static synchronized void b(int i) {
        synchronized (a.class) {
            f67411a = i;
        }
    }

    public static String c() {
        return f67411a != 0 ? "" : "https://sdfp.snssdk.com";
    }
}
