package d.b.h0.g.c;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f48655a;

    public static synchronized int a() {
        int i;
        synchronized (c.class) {
            i = f48655a;
            f48655a = i + 1;
        }
        return i;
    }
}
