package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public class bo extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f38189a;

    public bo(Context context) {
        this.f38189a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f38189a).m63a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo172a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f38189a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f38189a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e2);
        }
    }
}
