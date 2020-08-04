package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cb;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class bu implements Runnable {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f148a;

    public bu(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f148a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        if (this.f148a == null || (context = this.f148a.get()) == null) {
            return;
        }
        if (ch.a(this.a) <= bt.f146a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bx a = bx.a(this.a);
        bw a2 = bw.a(this.a);
        a.a(a2);
        a2.a(bv.a(context, this.a, 1000));
        cb.a(context).a((cb.a) a);
    }
}
