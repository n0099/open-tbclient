package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cb;
import java.lang.ref.WeakReference;
/* loaded from: classes18.dex */
public class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f4594a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f144a;

    public bu(String str, WeakReference<Context> weakReference) {
        this.f4594a = str;
        this.f144a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        if (this.f144a == null || (context = this.f144a.get()) == null) {
            return;
        }
        if (ch.a(this.f4594a) <= bt.f142a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bx a2 = bx.a(this.f4594a);
        bw a3 = bw.a(this.f4594a);
        a2.a(a3);
        a3.a(bv.a(context, this.f4594a, 1000));
        cb.a(context).a((cb.a) a2);
    }
}
