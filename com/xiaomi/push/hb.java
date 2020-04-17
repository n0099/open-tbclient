package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes8.dex */
public class hb implements XMPushService.l {
    private static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f447a;

    /* renamed from: a  reason: collision with other field name */
    private Context f448a;
    private boolean b;

    public hb(Context context) {
        this.f448a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f448a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ag.a(context).a(hl.TinyDataUploadSwitch.a(), true);
        this.f447a = com.xiaomi.push.service.ag.a(context).a(hl.TinyDataUploadFrequency.a(), 7200);
        this.f447a = Math.max(60, this.f447a);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f448a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f447a);
    }

    private boolean a(hf hfVar) {
        return (!as.b(this.f448a) || hfVar == null || TextUtils.isEmpty(a(this.f448a.getPackageName())) || !new File(this.f448a.getFilesDir(), "tiny_data.data").exists() || a) ? false : true;
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo333a() {
        a(this.f448a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hf a2 = he.a(this.f448a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m50a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            hc.a(this.f448a, a2);
        }
    }
}
