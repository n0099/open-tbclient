package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.aj;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class by extends aj.a {
    public final /* synthetic */ bw a;

    public by(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo295a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public void run() {
        String c;
        Context context;
        Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        c = this.a.c();
        context = this.a.f152a;
        cb cbVar = new cb(c, new WeakReference(context));
        context2 = this.a.f152a;
        ci.a(context2).a(cbVar);
        this.a.b("check_time");
    }
}
