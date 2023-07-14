package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public class bx extends aj.a {
    public final /* synthetic */ bw a;

    public bx(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo297a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public void run() {
        cm cmVar;
        cm cmVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        cmVar = this.a.f155a;
        if (cmVar != null) {
            cmVar2 = this.a.f155a;
            context = this.a.f152a;
            cmVar2.a(context);
            this.a.b("upload_time");
        }
    }
}
