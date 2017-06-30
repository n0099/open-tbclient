package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.xmpush.thrift.ae;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class aa extends f.a {
    private Context a;

    public aa(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.f.a
    public int a() {
        return 13;
    }

    @Override // java.lang.Runnable
    public void run() {
        ae aeVar = new ae(MiPushClient.generatePacketID(), false);
        a a = a.a(this.a);
        aeVar.c(com.xiaomi.xmpush.thrift.o.SyncMIID.N);
        aeVar.b(a.c());
        aeVar.d(this.a.getPackageName());
        HashMap hashMap = new HashMap();
        com.xiaomi.channel.commonutils.android.h.a(hashMap, Constants.EXTRA_KEY_MIID, com.xiaomi.push.service.k.a(this.a).c());
        aeVar.h = hashMap;
        u.a(this.a).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
    }
}
