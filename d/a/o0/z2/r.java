package d.a.o0.z2;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f67649a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f67649a == null) {
                f67649a = new q();
            }
            qVar = f67649a;
        }
        return qVar;
    }
}
