package com.github.a.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
final class e {
    private static a pGv = new a("loop");
    private static a pGw = new a("writer");

    public static Handler eyk() {
        return pGv.getHandler();
    }

    public static Handler eyl() {
        return pGw.getHandler();
    }

    /* loaded from: classes6.dex */
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
