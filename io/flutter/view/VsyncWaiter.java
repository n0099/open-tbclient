package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
/* loaded from: classes9.dex */
public class VsyncWaiter {
    private static VsyncWaiter instance;
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() { // from class: io.flutter.view.VsyncWaiter.1
        @Override // io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public void asyncWaitForVsync(final long j) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: io.flutter.view.VsyncWaiter.1.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j2) {
                    FlutterJNI.nativeOnVsync(j2, j2 + ((long) (1.0E9d / VsyncWaiter.this.windowManager.getDefaultDisplay().getRefreshRate())), j);
                }
            });
        }
    };
    private final WindowManager windowManager;

    public static VsyncWaiter getInstance(WindowManager windowManager) {
        if (instance == null) {
            instance = new VsyncWaiter(windowManager);
        }
        return instance;
    }

    private VsyncWaiter(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public void init() {
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
        FlutterJNI.setRefreshRateFPS(this.windowManager.getDefaultDisplay().getRefreshRate());
    }
}
