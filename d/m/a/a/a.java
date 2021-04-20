package d.m.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f67264a = 255;

    public static String a() {
        return f67264a != 0 ? "" : "https://bds.snssdk.com";
    }

    public static synchronized void b(int i) {
        synchronized (a.class) {
            f67264a = i;
        }
    }

    public static String c() {
        return f67264a != 0 ? "" : "https://sdfp.snssdk.com";
    }
}
