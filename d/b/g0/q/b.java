package d.b.g0.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.m.c;
/* loaded from: classes2.dex */
public final class b implements d.b.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f43750a;

    /* renamed from: b  reason: collision with root package name */
    public a f43751b;

    @Override // d.b.g0.m.b
    public final String a() {
        a aVar = this.f43751b;
        Context context = this.f43750a;
        if (TextUtils.isEmpty(aVar.f43749d)) {
            aVar.f43749d = aVar.a(context, aVar.f43748c);
        }
        return aVar.f43749d;
    }

    @Override // d.b.g0.m.b
    public final void a(Context context, c cVar) {
        this.f43750a = context;
        a aVar = new a();
        this.f43751b = aVar;
        aVar.f43748c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f43747b = cls;
            aVar.f43746a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f43748c = aVar.f43747b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f43747b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f43747b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }
}
