package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class bw extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bu f40588a;

    public bw(bu buVar) {
        this.f40588a = buVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo169a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public void run() {
        String c2;
        Context context;
        Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        c2 = this.f40588a.c();
        context = this.f40588a.f157a;
        bz bzVar = new bz(c2, new WeakReference(context));
        context2 = this.f40588a.f157a;
        cg.a(context2).a(bzVar);
        this.f40588a.b("check_time");
    }
}
