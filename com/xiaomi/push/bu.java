package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cb;
import java.lang.ref.WeakReference;
/* loaded from: classes18.dex */
public class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f4824a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f146a;

    public bu(String str, WeakReference<Context> weakReference) {
        this.f4824a = str;
        this.f146a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        if (this.f146a == null || (context = this.f146a.get()) == null) {
            return;
        }
        if (ch.a(this.f4824a) <= bt.f144a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bx a2 = bx.a(this.f4824a);
        bw a3 = bw.a(this.f4824a);
        a2.a(a3);
        a3.a(bv.a(context, this.f4824a, 1000));
        cb.a(context).a((cb.a) a2);
    }
}
