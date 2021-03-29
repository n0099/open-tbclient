package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public class bv extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bu f40298a;

    public bv(bu buVar) {
        this.f40298a = buVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo165a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public void run() {
        ck ckVar;
        ck ckVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        ckVar = this.f40298a.f160a;
        if (ckVar != null) {
            ckVar2 = this.f40298a.f160a;
            context = this.f40298a.f157a;
            ckVar2.a(context);
            this.f40298a.b("upload_time");
        }
    }
}
