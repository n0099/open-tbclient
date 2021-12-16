package org.webrtc;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.c.g0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.webrtc.Camera1Session;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraSession;
import org.webrtc.VideoFrame;
/* loaded from: classes4.dex */
public class Camera1Session implements CameraSession {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    public static final String TAG = "Camera1Session";
    public static final Histogram camera1ResolutionHistogram;
    public static final Histogram camera1StartTimeMsHistogram;
    public static final Histogram camera1StopTimeMsHistogram;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context applicationContext;
    public final Camera camera;
    public final int cameraId;
    public final Handler cameraThreadHandler;
    public final CameraEnumerationAndroid.CaptureFormat captureFormat;
    public final boolean captureToTexture;
    public final long constructionTimeNs;
    public final CameraSession.Events events;
    public boolean firstFrameReported;
    public final Camera.CameraInfo info;
    public SessionState state;
    public final SurfaceTextureHelper surfaceTextureHelper;

    /* renamed from: org.webrtc.Camera1Session$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 implements Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Camera1Session this$0;

        public AnonymousClass2(Camera1Session camera1Session) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {camera1Session};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = camera1Session;
        }

        public /* synthetic */ void a(byte[] bArr) {
            if (this.this$0.state == SessionState.RUNNING) {
                this.this$0.camera.addCallbackBuffer(bArr);
            }
        }

        public /* synthetic */ void b(final byte[] bArr) {
            this.this$0.cameraThreadHandler.post(new Runnable() { // from class: h.c.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        Camera1Session.AnonymousClass2.this.a(bArr);
                    }
                }
            });
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, camera) == null) {
                this.this$0.checkIsOnCameraThread();
                if (camera == this.this$0.camera) {
                    if (this.this$0.state != SessionState.RUNNING) {
                        Logging.d(Camera1Session.TAG, "Bytebuffer frame captured but camera is no longer running.");
                        return;
                    }
                    long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
                    if (!this.this$0.firstFrameReported) {
                        Camera1Session.camera1StartTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.this$0.constructionTimeNs));
                        this.this$0.firstFrameReported = true;
                    }
                    VideoFrame videoFrame = new VideoFrame(new NV21Buffer(bArr, this.this$0.captureFormat.width, this.this$0.captureFormat.height, new Runnable() { // from class: h.c.d
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Camera1Session.AnonymousClass2.this.b(bArr);
                            }
                        }
                    }), this.this$0.getFrameOrientation(), nanos);
                    this.this$0.events.onFrameCaptured(this.this$0, videoFrame);
                    videoFrame.release();
                    return;
                }
                Logging.e(Camera1Session.TAG, "Callback from a different camera. This should never happen.");
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class SessionState {
        public static final /* synthetic */ SessionState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SessionState RUNNING;
        public static final SessionState STOPPED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(60878065, "Lorg/webrtc/Camera1Session$SessionState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(60878065, "Lorg/webrtc/Camera1Session$SessionState;");
                    return;
                }
            }
            RUNNING = new SessionState("RUNNING", 0);
            SessionState sessionState = new SessionState("STOPPED", 1);
            STOPPED = sessionState;
            $VALUES = new SessionState[]{RUNNING, sessionState};
        }

        public SessionState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SessionState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SessionState) Enum.valueOf(SessionState.class, str) : (SessionState) invokeL.objValue;
        }

        public static SessionState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SessionState[]) $VALUES.clone() : (SessionState[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1764249446, "Lorg/webrtc/Camera1Session;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1764249446, "Lorg/webrtc/Camera1Session;");
                return;
            }
        }
        camera1StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StartTimeMs", 1, 10000, 50);
        camera1StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StopTimeMs", 1, 10000, 50);
        camera1ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera1.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
    }

    public Camera1Session(CameraSession.Events events, boolean z, Context context, SurfaceTextureHelper surfaceTextureHelper, int i2, Camera camera, Camera.CameraInfo cameraInfo, CameraEnumerationAndroid.CaptureFormat captureFormat, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {events, Boolean.valueOf(z), context, surfaceTextureHelper, Integer.valueOf(i2), camera, cameraInfo, captureFormat, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Logging.d(TAG, "Create new camera1 session on camera " + i2);
        this.cameraThreadHandler = new Handler();
        this.events = events;
        this.captureToTexture = z;
        this.applicationContext = context;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = i2;
        this.camera = camera;
        this.info = cameraInfo;
        this.captureFormat = captureFormat;
        this.constructionTimeNs = j2;
        surfaceTextureHelper.setTextureSize(captureFormat.width, captureFormat.height);
        startCapturing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsOnCameraThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, boolean z, Context context, SurfaceTextureHelper surfaceTextureHelper, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{createSessionCallback, events, Boolean.valueOf(z), context, surfaceTextureHelper, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            long nanoTime = System.nanoTime();
            Logging.d(TAG, "Open camera " + i2);
            events.onCameraOpening();
            try {
                Camera open = Camera.open(i2);
                if (open == null) {
                    CameraSession.FailureType failureType = CameraSession.FailureType.ERROR;
                    createSessionCallback.onFailure(failureType, "android.hardware.Camera.open returned null for camera id = " + i2);
                    return;
                }
                try {
                    open.setPreviewTexture(surfaceTextureHelper.getSurfaceTexture());
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i2, cameraInfo);
                    try {
                        Camera.Parameters parameters = open.getParameters();
                        CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat = findClosestCaptureFormat(parameters, i3, i4, i5);
                        updateCameraParameters(open, parameters, findClosestCaptureFormat, findClosestPictureSize(parameters, i3, i4), z);
                        if (!z) {
                            int frameSize = findClosestCaptureFormat.frameSize();
                            for (int i6 = 0; i6 < 3; i6++) {
                                open.addCallbackBuffer(ByteBuffer.allocateDirect(frameSize).array());
                            }
                        }
                        open.setDisplayOrientation(0);
                        createSessionCallback.onDone(new Camera1Session(events, z, context, surfaceTextureHelper, i2, open, cameraInfo, findClosestCaptureFormat, nanoTime));
                    } catch (RuntimeException e2) {
                        open.release();
                        createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e2.getMessage());
                    }
                } catch (IOException | RuntimeException e3) {
                    open.release();
                    createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e3.getMessage());
                }
            } catch (RuntimeException e4) {
                createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e4.getMessage());
            }
        }
    }

    public static CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat(Camera.Parameters parameters, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65552, null, parameters, i2, i3, i4)) == null) {
            List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = Camera1Enumerator.convertFramerates(parameters.getSupportedPreviewFpsRange());
            Logging.d(TAG, "Available fps ranges: " + convertFramerates);
            CameraEnumerationAndroid.CaptureFormat.FramerateRange closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(convertFramerates, i4);
            Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(parameters.getSupportedPreviewSizes()), i2, i3);
            CameraEnumerationAndroid.reportCameraResolution(camera1ResolutionHistogram, closestSupportedSize);
            return new CameraEnumerationAndroid.CaptureFormat(closestSupportedSize.width, closestSupportedSize.height, closestSupportedFramerateRange);
        }
        return (CameraEnumerationAndroid.CaptureFormat) invokeLIII.objValue;
    }

    public static Size findClosestPictureSize(Camera.Parameters parameters, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, parameters, i2, i3)) == null) ? CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(parameters.getSupportedPictureSizes()), i2, i3) : (Size) invokeLII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrameOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            int b2 = g0.b(this.applicationContext);
            if (this.info.facing == 0) {
                b2 = 360 - b2;
            }
            return (this.info.orientation + b2) % 360;
        }
        return invokeV.intValue;
    }

    private void listenForBytebufferFrames() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.camera.setPreviewCallbackWithBuffer(new AnonymousClass2(this));
        }
    }

    private void listenForTextureFrames() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.surfaceTextureHelper.startListening(new VideoSink() { // from class: h.c.e
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // org.webrtc.VideoSink
                public final void onFrame(VideoFrame videoFrame) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, videoFrame) == null) {
                        Camera1Session.this.a(videoFrame);
                    }
                }
            });
        }
    }

    private void startCapturing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            Logging.d(TAG, "Start capturing");
            checkIsOnCameraThread();
            this.state = SessionState.RUNNING;
            this.camera.setErrorCallback(new Camera.ErrorCallback(this) { // from class: org.webrtc.Camera1Session.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Camera1Session this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.hardware.Camera.ErrorCallback
                public void onError(int i2, Camera camera) {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, camera) == null) {
                        if (i2 == 100) {
                            str = "Camera server died!";
                        } else {
                            str = "Camera error: " + i2;
                        }
                        Logging.e(Camera1Session.TAG, str);
                        this.this$0.stopInternal();
                        if (i2 == 2) {
                            this.this$0.events.onCameraDisconnected(this.this$0);
                        } else {
                            this.this$0.events.onCameraError(this.this$0, str);
                        }
                    }
                }
            });
            if (this.captureToTexture) {
                listenForTextureFrames();
            } else {
                listenForBytebufferFrames();
            }
            try {
                this.camera.startPreview();
            } catch (RuntimeException e2) {
                stopInternal();
                this.events.onCameraError(this, e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            Logging.d(TAG, "Stop internal");
            checkIsOnCameraThread();
            SessionState sessionState = this.state;
            SessionState sessionState2 = SessionState.STOPPED;
            if (sessionState == sessionState2) {
                Logging.d(TAG, "Camera is already stopped");
                return;
            }
            this.state = sessionState2;
            this.surfaceTextureHelper.stopListening();
            this.camera.stopPreview();
            this.camera.release();
            this.events.onCameraClosed(this);
            Logging.d(TAG, "Stop done");
        }
    }

    public static void updateCameraParameters(Camera camera, Camera.Parameters parameters, CameraEnumerationAndroid.CaptureFormat captureFormat, Size size, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{camera, parameters, captureFormat, size, Boolean.valueOf(z)}) == null) {
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange = captureFormat.framerate;
            parameters.setPreviewFpsRange(framerateRange.min, framerateRange.max);
            parameters.setPreviewSize(captureFormat.width, captureFormat.height);
            parameters.setPictureSize(size.width, size.height);
            if (!z) {
                captureFormat.getClass();
                parameters.setPreviewFormat(17);
            }
            if (parameters.isVideoStabilizationSupported()) {
                parameters.setVideoStabilization(true);
            }
            if (supportedFocusModes.contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            camera.setParameters(parameters);
        }
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        checkIsOnCameraThread();
        if (this.state != SessionState.RUNNING) {
            Logging.d(TAG, "Texture frame captured but camera is no longer running.");
            return;
        }
        if (!this.firstFrameReported) {
            camera1StartTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.constructionTimeNs));
            this.firstFrameReported = true;
        }
        VideoFrame videoFrame2 = new VideoFrame(g0.a((TextureBufferImpl) videoFrame.getBuffer(), this.info.facing == 1, 0), getFrameOrientation(), videoFrame.getTimestampNs());
        this.events.onFrameCaptured(this, videoFrame2);
        videoFrame2.release();
    }

    @Override // org.webrtc.CameraSession
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Logging.d(TAG, "Stop camera1 session on camera " + this.cameraId);
            checkIsOnCameraThread();
            if (this.state != SessionState.STOPPED) {
                long nanoTime = System.nanoTime();
                stopInternal();
                camera1StopTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
            }
        }
    }
}
