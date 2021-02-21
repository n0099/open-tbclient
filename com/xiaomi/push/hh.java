package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes6.dex */
public class hh implements XMPushService.l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14088a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f512a;

    /* renamed from: a  reason: collision with other field name */
    private Context f513a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14089b;

    public hh(Context context) {
        this.f513a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f513a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.f14089b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f512a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f512a = Math.max(60, this.f512a);
    }

    public static void a(boolean z) {
        f14088a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f513a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f512a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f513a) || hlVar == null || TextUtils.isEmpty(a(this.f513a.getPackageName())) || !new File(this.f513a.getFilesDir(), "tiny_data.data").exists() || f14088a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f513a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m415a(this.f513a) || i.m418b(this.f513a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo366a() {
        a(this.f513a);
        if (this.f14089b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m79a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f513a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m79a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f14088a = true;
            hi.a(this.f513a, a2);
        }
    }
}
