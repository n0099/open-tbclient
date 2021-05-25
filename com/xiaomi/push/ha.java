package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes7.dex */
public class ha implements XMPushService.l {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f37706a = false;

    /* renamed from: a  reason: collision with other field name */
    public int f463a;

    /* renamed from: a  reason: collision with other field name */
    public Context f464a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37707b;

    public ha(Context context) {
        this.f464a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f464a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.f37707b = com.xiaomi.push.service.aq.a(context).a(hk.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.aq.a(context).a(hk.TinyDataUploadFrequency.a(), 7200);
        this.f463a = a2;
        this.f463a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        f37706a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f464a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f463a);
    }

    private boolean a(he heVar) {
        if (!bg.b(this.f464a) || heVar == null || TextUtils.isEmpty(a(this.f464a.getPackageName())) || !new File(this.f464a.getFilesDir(), "tiny_data.data").exists() || f37706a) {
            return false;
        }
        return !com.xiaomi.push.service.aq.a(this.f464a).a(hk.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m424a(this.f464a) || i.m427b(this.f464a);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo357a() {
        a(this.f464a);
        if (this.f37707b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m57a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            he a2 = hd.a(this.f464a).a();
            if (a(a2)) {
                f37706a = true;
                hb.a(this.f464a, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        }
    }
}
