package com.yxcorp.kuaishou.addfp.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private static AtomicBoolean f14635b = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private a f14636a;
    private CountDownLatch c;
    private com.yxcorp.kuaishou.addfp.a.b.a qfU;

    private b() {
        this.c = null;
        this.qfU = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(b bVar) {
        return !TextUtils.isEmpty(Build.MANUFACTURER) ? Build.MANUFACTURER.toLowerCase() : "";
    }

    public static final b eKV() {
        b bVar;
        bVar = d.qfW;
        return bVar;
    }

    public final void a(Context context, a aVar) {
        try {
            if (!f14635b.compareAndSet(false, true)) {
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
            if (this.f14636a != null) {
                this.f14636a.a(z, aVar);
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
