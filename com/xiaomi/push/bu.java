package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cb;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f4822a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f141a;

    public bu(String str, WeakReference<Context> weakReference) {
        this.f4822a = str;
        this.f141a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        if (this.f141a == null || (context = this.f141a.get()) == null) {
            return;
        }
        if (ch.a(this.f4822a) <= bt.f139a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bx a2 = bx.a(this.f4822a);
        bw a3 = bw.a(this.f4822a);
        a2.a(a3);
        a3.a(bv.a(context, this.f4822a, 1000));
        cb.a(context).a((cb.a) a2);
    }
}
