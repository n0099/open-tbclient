package d.b.f0.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class b implements d.b.f0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public a f43440a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f43441b;

    @Override // d.b.f0.m.b
    public final String a() {
        if (TextUtils.isEmpty(this.f43441b)) {
            String a2 = this.f43440a.a("OUID");
            this.f43441b = a2;
            return a2;
        }
        return this.f43441b;
    }

    @Override // d.b.f0.m.b
    public final void a(Context context, d.b.f0.m.c cVar) {
        a aVar = new a(context, cVar);
        this.f43440a = aVar;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        aVar.f43436b.bindService(intent, aVar.f43439e, 1);
    }
}
