package com.github.a.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes7.dex */
final class e {
    private static a psm = new a("loop");
    private static a psn = new a("writer");

    public static Handler exN() {
        return psm.getHandler();
    }

    public static Handler exO() {
        return psn.getHandler();
    }

    /* loaded from: classes7.dex */
    private static class a {
        private Handler handler;

        public a(String str) {
            this.handler = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
        }

        public Handler getHandler() {
            return this.handler;
        }
    }
}
