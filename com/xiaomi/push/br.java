package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class br extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bp f13893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.f13893a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo191a() {
        return 10054;
    }

    @Override // java.lang.Runnable
    public void run() {
        String c;
        Context context;
        Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        c = this.f13893a.c();
        context = this.f13893a.f213a;
        bu buVar = new bu(c, new WeakReference(context));
        context2 = this.f13893a.f213a;
        cb.a(context2).a(buVar);
        this.f13893a.b("check_time");
    }
}
