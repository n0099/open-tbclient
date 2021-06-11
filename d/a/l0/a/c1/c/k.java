package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f44621a;

    public static synchronized j a() {
        j jVar;
        synchronized (k.class) {
            if (f44621a == null) {
                f44621a = new j();
            }
            jVar = f44621a;
        }
        return jVar;
    }
}
