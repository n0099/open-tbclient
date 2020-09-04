package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class br extends ai.a {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo166a() {
        return 10054;
    }

    @Override // java.lang.Runnable
    public void run() {
        String c;
        Context context;
        Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        c = this.a.c();
        context = this.a.f135a;
        bu buVar = new bu(c, new WeakReference(context));
        context2 = this.a.f135a;
        cb.a(context2).a(buVar);
        this.a.b("check_time");
    }
}
