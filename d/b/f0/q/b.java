package d.b.f0.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.b.f0.m.c;
/* loaded from: classes2.dex */
public final class b implements d.b.f0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f43061a;

    /* renamed from: b  reason: collision with root package name */
    public a f43062b;

    @Override // d.b.f0.m.b
    public final String a() {
        a aVar = this.f43062b;
        Context context = this.f43061a;
        if (TextUtils.isEmpty(aVar.f43060d)) {
            aVar.f43060d = aVar.a(context, aVar.f43059c);
        }
        return aVar.f43060d;
    }

    @Override // d.b.f0.m.b
    public final void a(Context context, c cVar) {
        this.f43061a = context;
        a aVar = new a();
        this.f43062b = aVar;
        aVar.f43059c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f43058b = cls;
            aVar.f43057a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f43059c = aVar.f43058b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f43058b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f43058b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }
}
