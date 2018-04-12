package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.k;
import com.xiaomi.xmpush.thrift.ae;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class z implements k.a {
    public z(Context context) {
        com.xiaomi.push.service.k.a(context).a(this);
    }

    private void b(String str, Context context) {
        ae aeVar = new ae();
        aeVar.c(com.xiaomi.xmpush.thrift.o.ClientMIIDUpdate.N);
        aeVar.b(a.a(context).c());
        aeVar.a(MiPushClient.generatePacketID());
        HashMap hashMap = new HashMap();
        com.xiaomi.channel.commonutils.android.h.a(hashMap, Constants.EXTRA_KEY_MIID, str);
        aeVar.a(hashMap);
        int b = com.xiaomi.channel.commonutils.android.e.b();
        if (b >= 0) {
            aeVar.i().put("space_id", Integer.toString(b));
        }
        u.a(context).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
    }

    public void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long j = sharedPreferences.getLong("last_sync_miid_time", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int a = ah.a(context).a(com.xiaomi.xmpush.thrift.e.SyncMIIDFrequency.a(), 21600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) > a) {
            com.xiaomi.channel.commonutils.misc.f.a(context).a((f.a) new aa(context), a);
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
        }
    }

    @Override // com.xiaomi.push.service.k.a
    public void a(String str, Context context) {
        b(str, context);
    }
}
