package com.xiaomi.push.service;

import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import java.util.List;
/* loaded from: classes12.dex */
public class i implements hl {

    /* renamed from: a  reason: collision with root package name */
    private final XMPushService f5104a;

    public i(XMPushService xMPushService) {
        this.f5104a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f5104a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.hl
    public void a(List<hq> list, String str, String str2) {
        this.f5104a.a(new j(this, 4, str, list, str2));
    }
}
