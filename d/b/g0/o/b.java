package d.b.g0.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class b implements d.b.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public a f43737a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f43738b;

    @Override // d.b.g0.m.b
    public final String a() {
        if (TextUtils.isEmpty(this.f43738b)) {
            String a2 = this.f43737a.a("OUID");
            this.f43738b = a2;
            return a2;
        }
        return this.f43738b;
    }

    @Override // d.b.g0.m.b
    public final void a(Context context, d.b.g0.m.c cVar) {
        a aVar = new a(context, cVar);
        this.f43737a = aVar;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        aVar.f43733b.bindService(intent, aVar.f43736e, 1);
    }
}
