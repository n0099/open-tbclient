package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class d implements Thread.UncaughtExceptionHandler {
    public static d Sh;
    @Nullable
    public IKsAdSDK Si;
    public Thread.UncaughtExceptionHandler Sj;
    public Context Sk;
    public int d;
    public long f;
    public boolean a = false;
    public final AtomicBoolean RL = new AtomicBoolean();

    public d(Context context) {
        this.Sk = context;
    }

    public static d aF(Context context) {
        if (Sh == null) {
            synchronized (d.class) {
                if (Sh == null) {
                    Sh = new d(context);
                }
            }
        }
        return Sh;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        try {
            if (this.a) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.f + ",mMaxDuration:" + this.d + ",mIsCancel:" + this.RL.get());
            }
            if (!this.RL.get() && this.f > 0 && System.currentTimeMillis() - this.f <= this.d) {
                if (this.Si != null) {
                    Object dM = this.Si.dM("filterStack", th);
                    if (dM instanceof Boolean) {
                        z = ((Boolean) dM).booleanValue();
                        if (this.Sk != null && z) {
                            t.a(this.Sk, g.a, true);
                        }
                    }
                }
                z = true;
                if (this.Sk != null) {
                    t.a(this.Sk, g.a, true);
                }
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.Sj;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.Sj;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
