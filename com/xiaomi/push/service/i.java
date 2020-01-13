package com.xiaomi.push.service;

import com.xiaomi.push.hf;
import com.xiaomi.push.hk;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements hf {
    private final XMPushService a;

    public i(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.hf
    public void a(List<hk> list, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.m42a("TinyData LongConnUploader.upload items size:" + list.size() + "  ts:" + System.currentTimeMillis());
        this.a.a(new j(this, 4, str, list, str2));
    }
}
