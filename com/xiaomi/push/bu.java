package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cb;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f14194a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f223a;

    public bu(String str, WeakReference<Context> weakReference) {
        this.f14194a = str;
        this.f223a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        if (this.f223a == null || (context = this.f223a.get()) == null) {
            return;
        }
        if (ch.a(this.f14194a) <= bt.f221a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bx a2 = bx.a(this.f14194a);
        bw a3 = bw.a(this.f14194a);
        a2.a(a3);
        a3.a(bv.a(context, this.f14194a, 1000));
        cb.a(context).a((cb.a) a2);
    }
}
