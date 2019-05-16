package com.xiaomi.push.service;

import java.util.List;
/* loaded from: classes3.dex */
public class m implements com.xiaomi.tinyData.e {
    private final XMPushService a;

    public m(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.tinyData.e
    public void a(List<com.xiaomi.xmpush.thrift.f> list, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.a("TinyData LongConnUploader.upload items size:" + list.size() + "  ts:" + System.currentTimeMillis());
        this.a.a(new n(this, 4, str, list, str2));
    }
}
