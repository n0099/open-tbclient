package tv.chushou.basis.rxjava.thread;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public interface ThreadHandler {
    public static final ThreadHandler DEFAULT = new ThreadHandler() { // from class: tv.chushou.basis.rxjava.thread.ThreadHandler.1
        private Executor executor;
        private Handler handler;

        @Override // tv.chushou.basis.rxjava.thread.ThreadHandler
        public Executor getExecutor() {
            if (this.executor == null) {
                this.executor = Executors.newCachedThreadPool();
            }
            return this.executor;
        }

        @Override // tv.chushou.basis.rxjava.thread.ThreadHandler
        public Handler getHandler() {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            return this.handler;
        }
    };

    Executor getExecutor();

    Handler getHandler();
}
