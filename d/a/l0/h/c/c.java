package d.a.l0.h.c;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f50848a;

    public static synchronized int a() {
        int i2;
        synchronized (c.class) {
            i2 = f50848a;
            f50848a = i2 + 1;
        }
        return i2;
    }
}
