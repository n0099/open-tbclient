package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.ext.c;
import com.kwad.sdk.utils.bn;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class i {
    public static volatile i aiW;
    @Nullable
    public static a aiY;
    public e aiX;
    public volatile boolean mHasInit = false;

    /* loaded from: classes10.dex */
    public interface a {
        void b(String str, File file);

        void d(String str, Throwable th);

        int getMaxRetryCount();

        boolean wX();
    }

    public static i wU() {
        if (aiW == null) {
            synchronized (i.class) {
                if (aiW == null) {
                    aiW = new i();
                }
            }
        }
        return aiW;
    }

    public static ExecutorService wV() {
        return new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            public final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ksad-Sodler-" + this.poolNumber.getAndIncrement());
            }
        });
    }

    public final com.kwad.library.solder.lib.ext.c wO() {
        if (this.mHasInit) {
            return this.aiX.wO();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public static void a(a aVar) {
        aiY = aVar;
    }

    private synchronized void init(Context context) {
        int i;
        if (this.mHasInit) {
            return;
        }
        c.a bI = new c.a().bI("sodler");
        if (aiY != null) {
            i = aiY.getMaxRetryCount();
        } else {
            i = 1;
        }
        c.a bK = bI.bK(i);
        boolean z = false;
        c.a bg = bK.bg(false);
        if (aiY != null && aiY.wX()) {
            z = true;
        }
        com.kwad.library.solder.lib.ext.c xy = bg.bh(z).a(wV()).xy();
        d dVar = new d(context);
        c cVar = new c(context, xy);
        f fVar = new f(context);
        fVar.a(new f.a() { // from class: com.kwad.library.solder.lib.i.2
            @Override // com.kwad.library.solder.lib.a.f.a
            public final void a(com.kwad.library.solder.lib.a.e eVar, File file) {
                if (i.aiY != null) {
                    try {
                        i.aiY.b(eVar.getDownloadUrl(), file);
                    } catch (Throwable th) {
                        i.aiY.d(eVar.getDownloadUrl(), th);
                        throw new PluginError.UpdateError(th.getMessage(), 1);
                    }
                }
            }
        });
        this.aiX = new e(dVar, fVar, cVar, xy, new com.kwad.library.solder.lib.ext.a());
        this.mHasInit = true;
    }

    public final <P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> void a(Context context, @NonNull R r, com.kwad.library.solder.lib.ext.b<P, R> bVar) {
        init(context);
        r.bJ(this.aiX.wO().getRetryCount());
        r.a(new b<P, R>(bVar, new b.C0690b()) { // from class: com.kwad.library.solder.lib.i.3
            /* JADX WARN: Incorrect types in method signature: (TR;Lcom/kwad/library/solder/lib/ext/PluginError;)V */
            @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public final void a(final com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                long j;
                super.a((AnonymousClass3<P, R>) eVar, pluginError);
                com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                i.this.aiX.g(eVar);
                boolean z = eVar.xd() instanceof PluginError.UpdateError;
                Runnable runnable = new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (eVar.xe()) {
                            i.this.aiX.a(eVar, 16);
                        }
                    }
                };
                if (z) {
                    j = 1000;
                } else {
                    j = 0;
                }
                bn.runOnUiThreadDelay(runnable, j);
            }
        });
        this.aiX.a(r, 16);
    }

    public final void j(Context context, final String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (wO() != null && wO().xx() != null) {
            wO().xx().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        i.this.aiX.wR().bx(str);
                    } catch (Throwable th) {
                        Log.getStackTraceString(th);
                    }
                }
            });
        }
    }

    @Nullable
    public final com.kwad.library.solder.lib.a.a k(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        e eVar = this.aiX;
        if (eVar != null) {
            return eVar.wP().bz(str);
        }
        return null;
    }
}
