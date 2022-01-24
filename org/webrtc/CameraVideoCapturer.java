package org.webrtc;

import android.media.MediaRecorder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public interface CameraVideoCapturer extends VideoCapturer {

    /* loaded from: classes5.dex */
    public interface CameraEventsHandler {
        void onCameraClosed();

        void onCameraDisconnected();

        void onCameraError(String str);

        void onCameraFreezed(String str);

        void onCameraOpening(String str);

        void onFirstFrameAvailable();
    }

    /* loaded from: classes5.dex */
    public static class CameraStatistics {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
        public static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
        public static final String TAG = "CameraStatistics";
        public transient /* synthetic */ FieldHolder $fh;
        public final Runnable cameraObserver;
        public final CameraEventsHandler eventsHandler;
        public int frameCount;
        public int freezePeriodCount;
        public final SurfaceTextureHelper surfaceTextureHelper;

        public CameraStatistics(SurfaceTextureHelper surfaceTextureHelper, CameraEventsHandler cameraEventsHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {surfaceTextureHelper, cameraEventsHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cameraObserver = new Runnable(this) { // from class: org.webrtc.CameraVideoCapturer.CameraStatistics.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CameraStatistics this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int round = Math.round((this.this$0.frameCount * 1000.0f) / 2000.0f);
                        Logging.d(CameraStatistics.TAG, "Camera fps: " + round + ".");
                        if (this.this$0.frameCount != 0) {
                            this.this$0.freezePeriodCount = 0;
                        } else {
                            CameraStatistics.access$104(this.this$0);
                            if (this.this$0.freezePeriodCount * 2000 >= 4000 && this.this$0.eventsHandler != null) {
                                Logging.e(CameraStatistics.TAG, "Camera freezed.");
                                if (this.this$0.surfaceTextureHelper.isTextureInUse()) {
                                    this.this$0.eventsHandler.onCameraFreezed("Camera failure. Client must return video buffers.");
                                    return;
                                } else {
                                    this.this$0.eventsHandler.onCameraFreezed("Camera failure.");
                                    return;
                                }
                            }
                        }
                        this.this$0.frameCount = 0;
                        this.this$0.surfaceTextureHelper.getHandler().postDelayed(this, 2000L);
                    }
                }
            };
            if (surfaceTextureHelper != null) {
                this.surfaceTextureHelper = surfaceTextureHelper;
                this.eventsHandler = cameraEventsHandler;
                this.frameCount = 0;
                this.freezePeriodCount = 0;
                surfaceTextureHelper.getHandler().postDelayed(this.cameraObserver, 2000L);
                return;
            }
            throw new IllegalArgumentException("SurfaceTextureHelper is null");
        }

        public static /* synthetic */ int access$104(CameraStatistics cameraStatistics) {
            int i2 = cameraStatistics.freezePeriodCount + 1;
            cameraStatistics.freezePeriodCount = i2;
            return i2;
        }

        private void checkThread() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65544, this) == null) && Thread.currentThread() != this.surfaceTextureHelper.getHandler().getLooper().getThread()) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void addFrame() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                checkThread();
                this.frameCount++;
            }
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface CameraSwitchHandler {
        void onCameraSwitchDone(boolean z);

        void onCameraSwitchError(String str);
    }

    @Deprecated
    /* loaded from: classes5.dex */
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
