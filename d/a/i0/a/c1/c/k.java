package d.a.i0.a.c1.c;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f40771a;

    public static synchronized j a() {
        j jVar;
        synchronized (k.class) {
            if (f40771a == null) {
                f40771a = new j();
            }
            jVar = f40771a;
        }
        return jVar;
    }
}
