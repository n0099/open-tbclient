package d.a.g0.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class b implements d.a.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public a f40239a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f40240b;

    @Override // d.a.g0.m.b
    public final String a() {
        if (TextUtils.isEmpty(this.f40240b)) {
            String a2 = this.f40239a.a("OUID");
            this.f40240b = a2;
            return a2;
        }
        return this.f40240b;
    }

    @Override // d.a.g0.m.b
    public final void a(Context context, d.a.g0.m.c cVar) {
        a aVar = new a(context, cVar);
        this.f40239a = aVar;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        aVar.f40235b.bindService(intent, aVar.f40238e, 1);
    }
}
