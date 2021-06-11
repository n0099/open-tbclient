package d.a.j0.r;

import android.content.Context;
/* loaded from: classes2.dex */
public class b implements d.a.j0.n.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f44189a;

    /* renamed from: b  reason: collision with root package name */
    public a f44190b;

    @Override // d.a.j0.n.a
    public String a() {
        a aVar = this.f44190b;
        return aVar.a(this.f44189a, aVar.f44188c);
    }

    @Override // d.a.j0.n.a
    public void a(Context context, d.a.j0.n.b bVar) {
        this.f44189a = context;
        a aVar = new a();
        this.f44190b = aVar;
        aVar.f44188c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f44187b = cls;
            aVar.f44186a = cls.newInstance();
        } catch (Throwable unused) {
        }
        try {
            aVar.f44188c = aVar.f44187b.getMethod("getOAID", Context.class);
        } catch (Throwable unused2) {
        }
        try {
            aVar.f44187b.getMethod("getVAID", Context.class);
        } catch (Throwable unused3) {
        }
        try {
            aVar.f44187b.getMethod("getAAID", Context.class);
        } catch (Throwable unused4) {
        }
        if (bVar != null) {
            bVar.a();
        }
    }
}
