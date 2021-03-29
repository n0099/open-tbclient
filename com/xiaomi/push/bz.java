package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cg;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class bz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f40302a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<Context> f166a;

    public bz(String str, WeakReference<Context> weakReference) {
        this.f40302a = str;
        this.f166a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f166a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cm.a(this.f40302a) <= by.f164a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        cc a2 = cc.a(this.f40302a);
        cb a3 = cb.a(this.f40302a);
        a2.a(a3);
        a3.a(ca.a(context, this.f40302a, 1000));
        cg.a(context).a((cg.a) a2);
    }
}
