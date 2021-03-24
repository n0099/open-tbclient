package d.b.f0.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.b.f0.m.c;
/* loaded from: classes3.dex */
public final class b implements d.b.f0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f43060a;

    /* renamed from: b  reason: collision with root package name */
    public a f43061b;

    @Override // d.b.f0.m.b
    public final String a() {
        a aVar = this.f43061b;
        Context context = this.f43060a;
        if (TextUtils.isEmpty(aVar.f43059d)) {
            aVar.f43059d = aVar.a(context, aVar.f43058c);
        }
        return aVar.f43059d;
    }

    @Override // d.b.f0.m.b
    public final void a(Context context, c cVar) {
        this.f43060a = context;
        a aVar = new a();
        this.f43061b = aVar;
        aVar.f43058c = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            aVar.f43057b = cls;
            aVar.f43056a = cls.newInstance();
        } catch (Exception e2) {
            Log.d("IdentifierManager", "reflect exception!", e2);
        }
        try {
            aVar.f43058c = aVar.f43057b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            Log.d("IdentifierManager", "reflect exception!", e3);
        }
        try {
            aVar.f43057b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            Log.d("IdentifierManager", "reflect exception!", e4);
        }
        try {
            aVar.f43057b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            Log.d("IdentifierManager", "reflect exception!", e5);
        }
    }
}
