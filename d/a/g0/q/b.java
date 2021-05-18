package d.a.g0.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.a.g0.m.c;
/* loaded from: classes2.dex */
public final class b implements d.a.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f40252a;

    /* renamed from: b  reason: collision with root package name */
    public a f40253b;

    @Override // d.a.g0.m.b
    public final String a() {
        a aVar = this.f40253b;
        Context context = this.f40252a;
        if (TextUtils.isEmpty(aVar.f40251d)) {
            aVar.f40251d = aVar.a(context, aVar.f40250c);
        }
        return aVar.f40251d;
    }

    @Override // d.a.g0.m.b
    public final void a(Context context, c cVar) {
        this.f40252a = context;
        a aVar = new a();
        this.f40253b = aVar;
        aVar.f40250c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f40249b = cls;
            aVar.f40248a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f40250c = aVar.f40249b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f40249b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f40249b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }
}
