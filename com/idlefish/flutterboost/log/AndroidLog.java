package com.idlefish.flutterboost.log;

import android.util.Log;
/* loaded from: classes14.dex */
public class AndroidLog implements ILog {
    @Override // com.idlefish.flutterboost.log.ILog
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.idlefish.flutterboost.log.ILog
    public void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
