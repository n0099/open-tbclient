package com.yxcorp.kuaishou.addfp.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class b implements a {
    private static AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private a f8594a;
    private CountDownLatch c;
    private com.yxcorp.kuaishou.addfp.a.b.a qmz;

    private b() {
        this.c = null;
        this.qmz = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(b bVar) {
        return !TextUtils.isEmpty(Build.MANUFACTURER) ? Build.MANUFACTURER.toLowerCase() : "";
    }

    public static final b eJl() {
        b bVar;
        bVar = d.qmB;
        return bVar;
    }

    public final void a(Context context, a aVar) {
        try {
            if (!b.compareAndSet(false, true)) {
                com.yxcorp.kuaishou.addfp.android.b.b.b("OaHelper has been initialized,return");
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.c = new CountDownLatch(1);
            }
            new Thread(new c(this, aVar, context)).start();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            a(false, (com.yxcorp.kuaishou.addfp.a.b.a) null);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.a.a
    public final void a(boolean z, com.yxcorp.kuaishou.addfp.a.b.a aVar) {
        try {
            if (this.f8594a != null) {
                this.f8594a.a(z, aVar);
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void b() {
        if (this.c != null) {
            this.c.countDown();
        }
    }

    public final void c() {
        try {
            if (this.c == null || this.c.getCount() <= 0) {
                return;
            }
            com.yxcorp.kuaishou.addfp.android.b.b.b("awaitCdOaid");
            this.c.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(e);
        }
    }
}
