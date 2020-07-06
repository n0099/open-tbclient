package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes8.dex */
public class hh implements XMPushService.l {
    private static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f439a;

    /* renamed from: a  reason: collision with other field name */
    private Context f440a;
    private boolean b;

    public hh(Context context) {
        this.f440a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f440a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f439a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f439a = Math.max(60, this.f439a);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f440a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f439a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f440a) || hlVar == null || TextUtils.isEmpty(a(this.f440a.getPackageName())) || !new File(this.f440a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f440a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m384a(this.f440a) || i.m387b(this.f440a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo335a() {
        a(this.f440a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f440a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m48a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            hi.a(this.f440a, a2);
        }
    }
}
