package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bl extends ai.a {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.a = bkVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo157a() {
        return 10052;
    }

    @Override // java.lang.Runnable
    public void run() {
        ca caVar;
        ca caVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        caVar = this.a.f152a;
        if (caVar != null) {
            caVar2 = this.a.f152a;
            context = this.a.f149a;
            caVar2.a(context);
            this.a.b("upload_time");
        }
    }
}
