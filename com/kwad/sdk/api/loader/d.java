package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class d implements Thread.UncaughtExceptionHandler {
    public static d g;
    @Nullable
    public IKsAdSDK b;
    public Thread.UncaughtExceptionHandler c;
    public int d;
    public long f;
    public Context h;
    public boolean a = false;
    public final AtomicBoolean e = new AtomicBoolean();

    public d(Context context) {
        this.h = context;
    }

    public static d a(Context context) {
        if (g == null) {
            synchronized (d.class) {
                if (g == null) {
                    g = new d(context);
                }
            }
        }
        return g;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        try {
            if (this.a) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.f + ",mMaxDuration:" + this.d + ",mIsCancel:" + this.e.get());
            }
            if (!this.e.get() && this.f > 0 && System.currentTimeMillis() - this.f <= this.d) {
                if (this.b != null) {
                    Object dM = this.b.dM("filterStack", th);
                    if (dM instanceof Boolean) {
                        z = ((Boolean) dM).booleanValue();
                        if (this.h != null && z) {
                            r.a(this.h, g.d, true);
                        }
                    }
                }
                z = true;
                if (this.h != null) {
                    r.a(this.h, g.d, true);
                }
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.c;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
