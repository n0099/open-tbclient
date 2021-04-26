package d.a.g0.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.a.g0.m.c;
/* loaded from: classes2.dex */
public final class b implements d.a.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f41007a;

    /* renamed from: b  reason: collision with root package name */
    public a f41008b;

    @Override // d.a.g0.m.b
    public final String a() {
        a aVar = this.f41008b;
        Context context = this.f41007a;
        if (TextUtils.isEmpty(aVar.f41006d)) {
            aVar.f41006d = aVar.a(context, aVar.f41005c);
        }
        return aVar.f41006d;
    }

    @Override // d.a.g0.m.b
    public final void a(Context context, c cVar) {
        this.f41007a = context;
        a aVar = new a();
        this.f41008b = aVar;
        aVar.f41005c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f41004b = cls;
            aVar.f41003a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f41005c = aVar.f41004b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f41004b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f41004b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }
}
