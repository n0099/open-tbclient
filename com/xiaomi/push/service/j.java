package com.xiaomi.push.service;

import com.xiaomi.push.he;
import com.xiaomi.push.hj;
import java.util.List;
/* loaded from: classes7.dex */
public class j implements he {

    /* renamed from: a  reason: collision with root package name */
    public final XMPushService f38971a;

    public j(XMPushService xMPushService) {
        this.f38971a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f38971a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.he
    public void a(List<hj> list, String str, String str2) {
        this.f38971a.a(new k(this, 4, str, list, str2));
    }
}
