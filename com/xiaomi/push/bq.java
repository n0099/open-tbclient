package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bq extends ai.a {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo162a() {
        return 10052;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        cfVar = this.a.f136a;
        if (cfVar != null) {
            cfVar2 = this.a.f136a;
            context = this.a.f133a;
            cfVar2.a(context);
            this.a.b("upload_time");
        }
    }
}
