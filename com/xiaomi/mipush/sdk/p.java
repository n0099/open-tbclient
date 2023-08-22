package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.aj;
import com.xiaomi.push.hh;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.bd;
/* loaded from: classes10.dex */
public final class p extends aj.a {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ig f87a;

    public p(ig igVar, Context context) {
        this.f87a = igVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo300a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        ig igVar = this.f87a;
        if (igVar != null) {
            igVar.a(bd.a());
            ao.a(this.a.getApplicationContext()).a((ao) this.f87a, hh.Notification, true, (hu) null, true);
        }
    }
}
