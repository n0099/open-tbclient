package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes12.dex */
public class hh implements XMPushService.l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4951a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f434a;

    /* renamed from: a  reason: collision with other field name */
    private Context f435a;
    private boolean b;

    public hh(Context context) {
        this.f435a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f435a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f434a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f434a = Math.max(60, this.f434a);
    }

    public static void a(boolean z) {
        f4951a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f435a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f434a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f435a) || hlVar == null || TextUtils.isEmpty(a(this.f435a.getPackageName())) || !new File(this.f435a.getFilesDir(), "tiny_data.data").exists() || f4951a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f435a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m391a(this.f435a) || i.m394b(this.f435a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo342a() {
        a(this.f435a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m55a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f435a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m55a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f4951a = true;
            hi.a(this.f435a, a2);
        }
    }
}
