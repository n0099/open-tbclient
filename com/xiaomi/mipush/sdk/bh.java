package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.service.o;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bh implements o.a {
    public bh(Context context) {
        com.xiaomi.push.service.o.a(context).a(this);
    }

    private void b(String str, Context context) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.c(com.xiaomi.xmpush.thrift.r.ClientMIIDUpdate.aa);
        aiVar.b(d.a(context).c());
        aiVar.a(com.xiaomi.push.service.aq.a());
        HashMap hashMap = new HashMap();
        com.xiaomi.channel.commonutils.android.h.a(hashMap, Constants.EXTRA_KEY_MIID, str);
        aiVar.a(hashMap);
        int b = com.xiaomi.channel.commonutils.android.d.b();
        if (b >= 0) {
            aiVar.j().put("space_id", Integer.toString(b));
        }
        az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null);
    }

    public void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_miid_time", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int a = com.xiaomi.push.service.an.a(context).a(com.xiaomi.xmpush.thrift.g.SyncMIIDFrequency.a(), 21600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) > a) {
            com.xiaomi.channel.commonutils.misc.h.a(context).a((h.a) new bi(context), a);
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
        }
    }

    @Override // com.xiaomi.push.service.o.a
    public void a(String str, Context context) {
        b(str, context);
    }
}
