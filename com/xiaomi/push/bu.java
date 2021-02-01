package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cb;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f13896a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f222a;

    public bu(String str, WeakReference<Context> weakReference) {
        this.f13896a = str;
        this.f222a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        if (this.f222a == null || (context = this.f222a.get()) == null) {
            return;
        }
        if (ch.a(this.f13896a) <= bt.f220a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bx a2 = bx.a(this.f13896a);
        bw a3 = bw.a(this.f13896a);
        a2.a(a3);
        a3.a(bv.a(context, this.f13896a, 1000));
        cb.a(context).a((cb.a) a2);
    }
}
