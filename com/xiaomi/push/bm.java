package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bm extends ai.a {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar) {
        this.a = bkVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo152a() {
        return 10054;
    }

    @Override // java.lang.Runnable
    public void run() {
        String c;
        Context context;
        Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        c = this.a.c();
        context = this.a.f151a;
        bp bpVar = new bp(c, new WeakReference(context));
        context2 = this.a.f151a;
        bw.a(context2).a(bpVar);
        this.a.b("check_time");
    }
}
