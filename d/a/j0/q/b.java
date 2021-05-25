package d.a.j0.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.a.j0.m.c;
/* loaded from: classes2.dex */
public final class b implements d.a.j0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f40513a;

    /* renamed from: b  reason: collision with root package name */
    public a f40514b;

    @Override // d.a.j0.m.b
    public final String a() {
        a aVar = this.f40514b;
        Context context = this.f40513a;
        if (TextUtils.isEmpty(aVar.f40512d)) {
            aVar.f40512d = aVar.a(context, aVar.f40511c);
        }
        return aVar.f40512d;
    }

    @Override // d.a.j0.m.b
    public final void a(Context context, c cVar) {
        this.f40513a = context;
        a aVar = new a();
        this.f40514b = aVar;
        aVar.f40511c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f40510b = cls;
            aVar.f40509a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f40511c = aVar.f40510b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f40510b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f40510b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }
}
