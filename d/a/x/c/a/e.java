package d.a.x.c.a;

import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.nps.interfa.ISignatureVerifier_SignatureVerifier_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static e f64154b = new e();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.c0.a.b.c<ISignatureVerifier> f64155a;

    public e() {
        c();
    }

    public static e a() {
        return f64154b;
    }

    public ISignatureVerifier b() {
        return this.f64155a.get();
    }

    public void c() {
        d.a.c0.a.b.a b2 = d.a.c0.a.b.a.b();
        this.f64155a = b2;
        b2.a(new ISignatureVerifier_SignatureVerifier_Provider());
    }
}
