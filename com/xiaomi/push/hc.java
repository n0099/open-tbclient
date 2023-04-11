package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes8.dex */
public class hc implements XMPushService.n {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    public int f465a;

    /* renamed from: a  reason: collision with other field name */
    public Context f466a;
    public boolean b;

    public hc(Context context) {
        this.f466a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f466a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ba.a(context).a(hm.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.ba.a(context).a(hm.TinyDataUploadFrequency.a(), 7200);
        this.f465a = a2;
        this.f465a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f466a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f465a);
    }

    private boolean a(hg hgVar) {
        if (!bi.b(this.f466a) || hgVar == null || TextUtils.isEmpty(a(this.f466a.getPackageName())) || !new File(this.f466a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ba.a(this.f466a).a(hm.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m529a(this.f466a) || i.m531b(this.f466a);
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a  reason: collision with other method in class */
    public void mo468a() {
        a(this.f466a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m101a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hg a2 = hf.a(this.f466a).a();
            if (a(a2)) {
                a = true;
                hd.a(this.f466a, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m101a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        }
    }
}
