package d.a.l0.n.j.i;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f48154a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f48155b = "0";

    /* renamed from: c  reason: collision with root package name */
    public static long f48156c;

    static {
        d.a.l0.n.a b2 = d.a.l0.n.c.b();
        if (b2 != null) {
            f48155b = b2.j().getString("key_h2_heart_beat_version", "0");
        }
    }

    public static long a(int i2) {
        d.a.l0.n.a b2 = d.a.l0.n.c.b();
        return b2 != null ? b2.j().getInt("key_h2_heart_beat_timespan", i2) : i2;
    }

    public static long b(int i2) {
        d.a.l0.n.a b2 = d.a.l0.n.c.b();
        return b2 != null ? b2.j().getInt("key_h2_heart_beat_timeout", i2) : i2;
    }
}
