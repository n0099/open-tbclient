package d.b.n0.a;

import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64851a;

        static {
            int[] iArr = new int[EncryptAlgorithm.values().length];
            f64851a = iArr;
            try {
                iArr[EncryptAlgorithm.RSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static d.b.n0.a.a a(d.b.n0.a.d.a aVar) throws Exception {
        if (a.f64851a[aVar.a().ordinal()] != 1) {
            return null;
        }
        return new c(aVar.b());
    }
}
