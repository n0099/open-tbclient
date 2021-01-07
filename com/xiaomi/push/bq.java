package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bq extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bp f14190a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.f14190a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo196a() {
        return 10052;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        cfVar = this.f14190a.f217a;
        if (cfVar != null) {
            cfVar2 = this.f14190a.f217a;
            context = this.f14190a.f214a;
            cfVar2.a(context);
            this.f14190a.b("upload_time");
        }
    }
}
