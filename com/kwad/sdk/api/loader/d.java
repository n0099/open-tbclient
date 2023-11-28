package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class d implements Thread.UncaughtExceptionHandler {
    public static d alA;
    public Thread.UncaughtExceptionHandler alB;
    public int alC;
    public long alE;
    public Context mContext;
    public boolean DEBUG = false;
    public final AtomicBoolean alD = new AtomicBoolean();

    public d(Context context) {
        this.mContext = context;
    }

    public static d ax(Context context) {
        if (alA == null) {
            synchronized (d.class) {
                if (alA == null) {
                    alA = new d(context);
                }
            }
        }
        return alA;
    }

    public final void bP(int i) {
        this.alE = System.currentTimeMillis();
        this.alC = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.alB = uncaughtExceptionHandler;
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.alD.set(true);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.alE + ",mMaxDuration:" + this.alC + ",mIsCancel:" + this.alD.get());
            }
            if (!this.alD.get() && this.alE > 0 && System.currentTimeMillis() - this.alE <= this.alC) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.c("filterStack", th);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    z = true;
                }
                if (this.mContext != null && z) {
                    t.a(this.mContext, g.alK, true);
                }
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.alB;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.alB;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
