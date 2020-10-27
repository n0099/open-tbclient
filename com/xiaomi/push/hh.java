package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes12.dex */
public class hh implements XMPushService.l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4949a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f431a;

    /* renamed from: a  reason: collision with other field name */
    private Context f432a;
    private boolean b;

    public hh(Context context) {
        this.f432a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f432a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f431a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f431a = Math.max(60, this.f431a);
    }

    public static void a(boolean z) {
        f4949a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f432a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f431a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f432a) || hlVar == null || TextUtils.isEmpty(a(this.f432a.getPackageName())) || !new File(this.f432a.getFilesDir(), "tiny_data.data").exists() || f4949a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f432a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m390a(this.f432a) || i.m393b(this.f432a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo341a() {
        a(this.f432a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f432a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f4949a = true;
            hi.a(this.f432a, a2);
        }
    }
}
