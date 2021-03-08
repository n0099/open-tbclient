package com.yy.mediaframework.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes6.dex */
public class SafeDispatchHandler extends Handler {
    public SafeDispatchHandler(Looper looper) {
        super(looper);
    }

    public SafeDispatchHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    public SafeDispatchHandler() {
    }

    public SafeDispatchHandler(Handler.Callback callback) {
        super(callback);
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Exception e) {
            YMFLog.error(this, "[Util    ]", "dispatchMessage exception:%s", e.toString());
        }
    }
}
