package d.a.z.c.a;

import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.nps.interfa.ISignatureVerifier_SignatureVerifier_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static e f64894b = new e();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.e0.a.b.c<ISignatureVerifier> f64895a;

    public e() {
        c();
    }

    public static e a() {
        return f64894b;
    }

    public ISignatureVerifier b() {
        return this.f64895a.get();
    }

    public void c() {
        d.a.e0.a.b.a b2 = d.a.e0.a.b.a.b();
        this.f64895a = b2;
        b2.a(new ISignatureVerifier_SignatureVerifier_Provider());
    }
}
