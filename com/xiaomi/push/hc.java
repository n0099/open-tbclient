package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes10.dex */
public class hc implements XMPushService.n {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    public int f466a;

    /* renamed from: a  reason: collision with other field name */
    public Context f467a;
    public boolean b;

    public hc(Context context) {
        this.f467a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f467a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ba.a(context).a(hm.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.ba.a(context).a(hm.TinyDataUploadFrequency.a(), 7200);
        this.f466a = a2;
        this.f466a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f467a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f466a);
    }

    private boolean a(hg hgVar) {
        if (!bi.b(this.f467a) || hgVar == null || TextUtils.isEmpty(a(this.f467a.getPackageName())) || !new File(this.f467a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ba.a(this.f467a).a(hm.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m608a(this.f467a) || i.m610b(this.f467a);
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a  reason: collision with other method in class */
    public void mo547a() {
        a(this.f467a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m180a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hg a2 = hf.a(this.f467a).a();
            if (a(a2)) {
                a = true;
                hd.a(this.f467a, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m180a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        }
    }
}
