package d.a.k0.r;

import android.content.Context;
/* loaded from: classes2.dex */
public class b implements d.a.k0.n.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f44329a;

    /* renamed from: b  reason: collision with root package name */
    public a f44330b;

    @Override // d.a.k0.n.a
    public String a() {
        a aVar = this.f44330b;
        return aVar.a(this.f44329a, aVar.f44328c);
    }

    @Override // d.a.k0.n.a
    public void a(Context context, d.a.k0.n.b bVar) {
        this.f44329a = context;
        a aVar = new a();
        this.f44330b = aVar;
        aVar.f44328c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f44327b = cls;
            aVar.f44326a = cls.newInstance();
        } catch (Throwable unused) {
        }
        try {
            aVar.f44328c = aVar.f44327b.getMethod("getOAID", Context.class);
        } catch (Throwable unused2) {
        }
        try {
            aVar.f44327b.getMethod("getVAID", Context.class);
        } catch (Throwable unused3) {
        }
        try {
            aVar.f44327b.getMethod("getAAID", Context.class);
        } catch (Throwable unused4) {
        }
        if (bVar != null) {
            bVar.a();
        }
    }
}
