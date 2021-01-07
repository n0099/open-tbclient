package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes6.dex */
public class hh implements XMPushService.l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14386a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f513a;

    /* renamed from: a  reason: collision with other field name */
    private Context f514a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14387b;

    public hh(Context context) {
        this.f514a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f514a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.f14387b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f513a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f513a = Math.max(60, this.f513a);
    }

    public static void a(boolean z) {
        f14386a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f514a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f513a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f514a) || hlVar == null || TextUtils.isEmpty(a(this.f514a.getPackageName())) || !new File(this.f514a.getFilesDir(), "tiny_data.data").exists() || f14386a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f514a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m420a(this.f514a) || i.m423b(this.f514a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo371a() {
        a(this.f514a);
        if (this.f14387b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m84a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f514a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m84a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f14386a = true;
            hi.a(this.f514a, a2);
        }
    }
}
