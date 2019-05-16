package com.xiaomi.tinyData;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an;
import com.xiaomi.xmpush.thrift.g;
import java.io.File;
/* loaded from: classes3.dex */
public class a implements XMPushService.l {
    private static boolean a = false;
    private Context b;
    private boolean c;
    private int d;

    public a(Context context) {
        this.b = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.b.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.c = an.a(context).a(g.TinyDataUploadSwitch.a(), true);
        this.d = an.a(context).a(g.TinyDataUploadFrequency.a(), 7200);
        this.d = Math.max(60, this.d);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a(e eVar) {
        return (!com.xiaomi.channel.commonutils.network.d.c(this.b) || eVar == null || TextUtils.isEmpty(a(this.b.getPackageName())) || !new File(this.b.getFilesDir(), "tiny_data.data").exists() || a) ? false : true;
    }

    private boolean b() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.b.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.d);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    public void a() {
        a(this.b);
        if (this.c && b()) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            e a2 = d.a(this.b).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            b.a(this.b, a2);
        }
    }
}
