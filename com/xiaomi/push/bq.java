package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class bq extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bp f8283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.f8283a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo170a() {
        return 10052;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        cfVar = this.f8283a.f137a;
        if (cfVar != null) {
            cfVar2 = this.f8283a.f137a;
            context = this.f8283a.f134a;
            cfVar2.a(context);
            this.f8283a.b("upload_time");
        }
    }
}
