package com.github.a.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes5.dex */
final class e {
    private static a pRQ = new a("loop");
    private static a pRR = new a("writer");

    public static Handler eAQ() {
        return pRQ.getHandler();
    }

    public static Handler eAR() {
        return pRR.getHandler();
    }

    /* loaded from: classes5.dex */
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
