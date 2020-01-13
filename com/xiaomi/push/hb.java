package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes6.dex */
public class hb implements XMPushService.l {
    private static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f449a;

    /* renamed from: a  reason: collision with other field name */
    private Context f450a;
    private boolean b;

    public hb(Context context) {
        this.f450a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f450a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ag.a(context).a(hl.TinyDataUploadSwitch.a(), true);
        this.f449a = com.xiaomi.push.service.ag.a(context).a(hl.TinyDataUploadFrequency.a(), 7200);
        this.f449a = Math.max(60, this.f449a);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f450a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f449a);
    }

    private boolean a(hf hfVar) {
        return (!as.b(this.f450a) || hfVar == null || TextUtils.isEmpty(a(this.f450a.getPackageName())) || !new File(this.f450a.getFilesDir(), "tiny_data.data").exists() || a) ? false : true;
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo325a() {
        a(this.f450a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m42a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hf a2 = he.a(this.f450a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m42a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            hc.a(this.f450a, a2);
        }
    }
}
