package com.github.a.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes15.dex */
final class e {
    private static a pJo = new a("loop");
    private static a pJp = new a("writer");

    public static Handler eBy() {
        return pJo.getHandler();
    }

    public static Handler eBz() {
        return pJp.getHandler();
    }

    /* loaded from: classes15.dex */
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
