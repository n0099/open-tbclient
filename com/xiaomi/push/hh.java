package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes8.dex */
public class hh implements XMPushService.l {
    private static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f432a;

    /* renamed from: a  reason: collision with other field name */
    private Context f433a;
    private boolean b;

    public hh(Context context) {
        this.f433a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f433a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f432a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f432a = Math.max(60, this.f432a);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f433a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f432a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f433a) || hlVar == null || TextUtils.isEmpty(a(this.f433a.getPackageName())) || !new File(this.f433a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f433a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m388a(this.f433a) || i.m391b(this.f433a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo339a() {
        a(this.f433a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m52a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f433a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m52a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            hi.a(this.f433a, a2);
        }
    }
}
