package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes18.dex */
public class hh implements XMPushService.l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4951a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f436a;

    /* renamed from: a  reason: collision with other field name */
    private Context f437a;
    private boolean b;

    public hh(Context context) {
        this.f437a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f437a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadSwitch.a(), true);
        this.f436a = com.xiaomi.push.service.ak.a(context).a(hr.TinyDataUploadFrequency.a(), 7200);
        this.f436a = Math.max(60, this.f436a);
    }

    public static void a(boolean z) {
        f4951a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f437a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f436a);
    }

    private boolean a(hl hlVar) {
        if (!az.b(this.f437a) || hlVar == null || TextUtils.isEmpty(a(this.f437a.getPackageName())) || !new File(this.f437a.getFilesDir(), "tiny_data.data").exists() || f4951a) {
            return false;
        }
        return !com.xiaomi.push.service.ak.a(this.f437a).a(hr.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m393a(this.f437a) || i.m396b(this.f437a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo344a() {
        a(this.f437a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m57a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hl a2 = hk.a(this.f437a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m57a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f4951a = true;
            hi.a(this.f437a, a2);
        }
    }
}
