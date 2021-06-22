package d.a.o0.z2;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f67650a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f67650a == null) {
                f67650a = new s();
            }
            sVar = f67650a;
        }
        return sVar;
    }
}
