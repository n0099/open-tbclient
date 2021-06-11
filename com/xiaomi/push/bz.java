package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.cg;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class bz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f41055a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<Context> f166a;

    public bz(String str, WeakReference<Context> weakReference) {
        this.f41055a = str;
        this.f166a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f166a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cm.a(this.f41055a) <= by.f164a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        cc a2 = cc.a(this.f41055a);
        cb a3 = cb.a(this.f41055a);
        a2.a(a3);
        a3.a(ca.a(context, this.f41055a, 1000));
        cg.a(context).a((cg.a) a2);
    }
}
