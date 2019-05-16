package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.h;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bi extends h.a {
    private Context a;

    public bi(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 10;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(com.xiaomi.push.service.aq.a(), false);
        d a = d.a(this.a);
        aiVar.c(com.xiaomi.xmpush.thrift.r.SyncMIID.aa);
        aiVar.b(a.c());
        aiVar.d(this.a.getPackageName());
        HashMap hashMap = new HashMap();
        com.xiaomi.channel.commonutils.android.h.a(hashMap, Constants.EXTRA_KEY_MIID, com.xiaomi.push.service.o.a(this.a).c());
        aiVar.h = hashMap;
        az.a(this.a).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null);
    }
}
