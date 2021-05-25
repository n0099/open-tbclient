package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f40945a;

    public static synchronized j a() {
        j jVar;
        synchronized (k.class) {
            if (f40945a == null) {
                f40945a = new j();
            }
            jVar = f40945a;
        }
        return jVar;
    }
}
