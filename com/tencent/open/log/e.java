package com.tencent.open.log;

import android.util.Log;
/* loaded from: classes8.dex */
public final class e extends Tracer {
    public static final e a = new e();

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i == 32) {
                                Log.e(str, str2, th);
                                return;
                            }
                            return;
                        }
                        Log.e(str, str2, th);
                        return;
                    }
                    Log.w(str, str2, th);
                    return;
                }
                Log.i(str, str2, th);
                return;
            }
            Log.d(str, str2, th);
            return;
        }
        Log.v(str, str2, th);
    }
}
