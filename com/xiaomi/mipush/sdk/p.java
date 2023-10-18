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
    public final /* synthetic */ ig f86a;

    public p(ig igVar, Context context) {
        this.f86a = igVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo302a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        ig igVar = this.f86a;
        if (igVar != null) {
            igVar.a(bd.a());
            ao.a(this.a.getApplicationContext()).a((ao) this.f86a, hh.Notification, true, (hu) null, true);
        }
    }
}
