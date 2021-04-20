package d.b.f0.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.b.f0.m.c;
/* loaded from: classes2.dex */
public final class b implements d.b.f0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f43453a;

    /* renamed from: b  reason: collision with root package name */
    public a f43454b;

    @Override // d.b.f0.m.b
    public final String a() {
        a aVar = this.f43454b;
        Context context = this.f43453a;
        if (TextUtils.isEmpty(aVar.f43452d)) {
            aVar.f43452d = aVar.a(context, aVar.f43451c);
        }
        return aVar.f43452d;
    }

    @Override // d.b.f0.m.b
    public final void a(Context context, c cVar) {
        this.f43453a = context;
        a aVar = new a();
        this.f43454b = aVar;
        aVar.f43451c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f43450b = cls;
            aVar.f43449a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f43451c = aVar.f43450b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f43450b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f43450b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }
}
