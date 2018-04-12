package com.xiaomi.push.service;

import com.xiaomi.push.service.av;
import com.xiaomi.push.service.aw;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bi implements aw.b {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.service.aw.b
    public void a(ArrayList<av.b> arrayList) {
        this.a.a(new bj(this, 4, arrayList));
    }

    @Override // com.xiaomi.push.service.aw.b
    public boolean a(av.b bVar) {
        return a(this.a.getPackageName()) != null;
    }
}
