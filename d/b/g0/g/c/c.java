package d.b.g0.g.c;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f48326a;

    public static synchronized int a() {
        int i;
        synchronized (c.class) {
            i = f48326a;
            f48326a = i + 1;
        }
        return i;
    }
}
