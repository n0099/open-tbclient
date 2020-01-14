package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bw;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class bp implements Runnable {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f161a;

    public bp(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f161a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        if (this.f161a == null || (context = this.f161a.get()) == null) {
            return;
        }
        if (cc.a(this.a) <= bo.f159a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bs a = bs.a(this.a);
        br a2 = br.a(this.a);
        a.a(a2);
        a2.a(bq.a(context, this.a, 1000));
        bw.a(context).a((bw.a) a);
    }
}
