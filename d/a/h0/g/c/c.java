package d.a.h0.g.c;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f46120a;

    public static synchronized int a() {
        int i2;
        synchronized (c.class) {
            i2 = f46120a;
            f46120a = i2 + 1;
        }
        return i2;
    }
}
