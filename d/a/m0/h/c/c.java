package d.a.m0.h.c;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f50956a;

    public static synchronized int a() {
        int i2;
        synchronized (c.class) {
            i2 = f50956a;
            f50956a = i2 + 1;
        }
        return i2;
    }
}
