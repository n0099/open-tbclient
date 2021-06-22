package d.a.m0.a.c1.c;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f44729a;

    public static synchronized j a() {
        j jVar;
        synchronized (k.class) {
            if (f44729a == null) {
                f44729a = new j();
            }
            jVar = f44729a;
        }
        return jVar;
    }
}
