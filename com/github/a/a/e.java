package com.github.a.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes7.dex */
final class e {
    private static a psk = new a("loop");
    private static a psl = new a("writer");

    public static Handler exM() {
        return psk.getHandler();
    }

    public static Handler exN() {
        return psl.getHandler();
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
