package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes9.dex */
public class hh implements XMPushService.l {
    private static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f438a;

    /* renamed from: a  reason: collision with other field name */
    private Context f439a;
    private boolean b;

    public hh(Context context) {
        this.f439a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f439a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f438a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f438a = Math.max(60, this.f438a);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f439a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f438a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f439a) || hlVar == null || TextUtils.isEmpty(a(this.f439a.getPackageName())) || !new File(this.f439a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f439a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m385a(this.f439a) || i.m388b(this.f439a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo336a() {
        a(this.f439a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m49a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f439a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m49a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            hi.a(this.f439a, a2);
        }
    }
}
