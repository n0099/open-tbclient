package d.b.w.c.a;

import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.nps.interfa.ISignatureVerifier_SignatureVerifier_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static e f65536b = new e();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a.b.c<ISignatureVerifier> f65537a;

    public e() {
        c();
    }

    public static e a() {
        return f65536b;
    }

    public ISignatureVerifier b() {
        return this.f65537a.get();
    }

    public void c() {
        d.b.b0.a.b.a b2 = d.b.b0.a.b.a.b();
        this.f65537a = b2;
        b2.a(new ISignatureVerifier_SignatureVerifier_Provider());
    }
}
