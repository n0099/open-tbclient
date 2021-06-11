package org.webrtc;

import android.media.MediaRecorder;
/* loaded from: classes8.dex */
public interface CameraVideoCapturer extends VideoCapturer {

    /* loaded from: classes8.dex */
    public interface CameraEventsHandler {
        void onCameraClosed();

        void onCameraDisconnected();

        void onCameraError(String str);

        void onCameraFreezed(String str);

        void onCameraOpening(String str);

        void onFirstFrameAvailable();
    }

    /* loaded from: classes8.dex */
    public static class CameraStatistics {
        public static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
        public static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
        public static final String TAG = "CameraStatistics";
        public final Runnable cameraObserver = new Runnable() { // from class: org.webrtc.CameraVideoCapturer.CameraStatistics.1
            @Override // java.lang.Runnable
            public void run() {
                CameraEventsHandler cameraEventsHandler;
                String str;
                int round = Math.round((CameraStatistics.this.frameCount * 1000.0f) / 2000.0f);
                Logging.d(CameraStatistics.TAG, "Camera fps: " + round + ".");
                if (CameraStatistics.this.frameCount == 0) {
                    CameraStatistics.access$104(CameraStatistics.this);
                    if (CameraStatistics.this.freezePeriodCount * 2000 >= 4000 && CameraStatistics.this.eventsHandler != null) {
                        Logging.e(CameraStatistics.TAG, "Camera freezed.");
                        if (CameraStatistics.this.surfaceTextureHelper.isTextureInUse()) {
                            cameraEventsHandler = CameraStatistics.this.eventsHandler;
                            str = "Camera failure. Client must return video buffers.";
                        } else {
                            cameraEventsHandler = CameraStatistics.this.eventsHandler;
                            str = "Camera failure.";
                        }
                        cameraEventsHandler.onCameraFreezed(str);
                        return;
                    }
                } else {
                    CameraStatistics.this.freezePeriodCount = 0;
                }
                CameraStatistics.this.frameCount = 0;
                CameraStatistics.this.surfaceTextureHelper.getHandler().postDelayed(this, 2000L);
            }
        };
        public final CameraEventsHandler eventsHandler;
        public int frameCount;
        public int freezePeriodCount;
        public final SurfaceTextureHelper surfaceTextureHelper;

        public CameraStatistics(SurfaceTextureHelper surfaceTextureHelper, CameraEventsHandler cameraEventsHandler) {
            if (surfaceTextureHelper == null) {
                throw new IllegalArgumentException("SurfaceTextureHelper is null");
            }
            this.surfaceTextureHelper = surfaceTextureHelper;
            this.eventsHandler = cameraEventsHandler;
            this.frameCount = 0;
            this.freezePeriodCount = 0;
            surfaceTextureHelper.getHandler().postDelayed(this.cameraObserver, 2000L);
        }

        public static /* synthetic */ int access$104(CameraStatistics cameraStatistics) {
            int i2 = cameraStatistics.freezePeriodCount + 1;
            cameraStatistics.freezePeriodCount = i2;
            return i2;
        }

        private void checkThread() {
            if (Thread.currentThread() != this.surfaceTextureHelper.getHandler().getLooper().getThread()) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void addFrame() {
            checkThread();
            this.frameCount++;
        }

        public void release() {
            this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
        }
    }

    /* loaded from: classes8.dex */
    public interface CameraSwitchHandler {
        void onCameraSwitchDone(boolean z);

        void onCameraSwitchError(String str);
    }

    @Deprecated
    /* loaded from: classes8.dex */
    public interface MediaRecorderHandler {
        void onMediaRecorderError(String str);

        void onMediaRecorderSuccess();
    }

    @Deprecated
    void addMediaRecorderToCamera(MediaRecorder mediaRecorder, MediaRecorderHandler mediaRecorderHandler);

    @Deprecated
    void removeMediaRecorderFromCamera(MediaRecorderHandler mediaRecorderHandler);

    void switchCamera(CameraSwitchHandler cameraSwitchHandler);
}
