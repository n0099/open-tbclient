package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterJNI;
/* loaded from: classes7.dex */
public class VsyncWaiter {
    public static VsyncWaiter instance;
    public final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() { // from class: io.flutter.view.VsyncWaiter.1
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
    @NonNull
    public final WindowManager windowManager;

    public VsyncWaiter(@NonNull WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    @NonNull
    public static VsyncWaiter getInstance(@NonNull WindowManager windowManager) {
        if (instance == null) {
            instance = new VsyncWaiter(windowManager);
        }
        return instance;
    }

    public void init() {
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
        FlutterJNI.setRefreshRateFPS(this.windowManager.getDefaultDisplay().getRefreshRate());
    }
}
