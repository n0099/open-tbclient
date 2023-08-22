package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ci;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class cb implements Runnable {
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<Context> f164a;

    public cb(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f164a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f164a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (co.a(this.a) <= ca.f162a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        ce a = ce.a(this.a);
        cd a2 = cd.a(this.a);
        a.a(a2);
        a2.a(cc.a(context, this.a, 1000));
        ci.a(context).a((ci.a) a);
    }
}
