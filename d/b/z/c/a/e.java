package d.b.z.c.a;

import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.nps.interfa.ISignatureVerifier_SignatureVerifier_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static e f64870b = new e();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.b.c<ISignatureVerifier> f64871a;

    public e() {
        c();
    }

    public static e a() {
        return f64870b;
    }

    public ISignatureVerifier b() {
        return this.f64871a.get();
    }

    public void c() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.f64871a = b2;
        b2.a(new ISignatureVerifier_SignatureVerifier_Provider());
    }
}
