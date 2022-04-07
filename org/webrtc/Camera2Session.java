package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.repackage.ky9;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.webrtc.Camera2Session;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraSession;
import org.webrtc.VideoFrame;
@TargetApi(21)
/* loaded from: classes8.dex */
public class Camera2Session implements CameraSession {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Camera2Session";
    public static final Histogram camera2ResolutionHistogram;
    public static final Histogram camera2StartTimeMsHistogram;
    public static final Histogram camera2StopTimeMsHistogram;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context applicationContext;
    public final CameraSession.CreateSessionCallback callback;
    public CameraCharacteristics cameraCharacteristics;
    @Nullable
    public CameraDevice cameraDevice;
    public final String cameraId;
    public final CameraManager cameraManager;
    public int cameraOrientation;
    public final Handler cameraThreadHandler;
    public CameraEnumerationAndroid.CaptureFormat captureFormat;
    @Nullable
    public CameraCaptureSession captureSession;
    public final long constructionTimeNs;
    public final CameraSession.Events events;
    public boolean firstFrameReported;
    public int fpsUnitFactor;
    public final int framerate;
    public final int height;
    public boolean isCameraFrontFacing;
    public SessionState state;
    @Nullable
    public Surface surface;
    public final SurfaceTextureHelper surfaceTextureHelper;
    public final int width;

    /* renamed from: org.webrtc.Camera2Session$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class CameraCaptureCallback extends CameraCaptureSession.CaptureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CameraCaptureCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cameraCaptureSession, captureRequest, captureFailure) == null) {
                Logging.d(Camera2Session.TAG, "Capture failed: " + captureFailure);
            }
        }

        public /* synthetic */ CameraCaptureCallback(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public class CameraStateCallback extends CameraDevice.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Camera2Session this$0;

        public CameraStateCallback(Camera2Session camera2Session) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {camera2Session};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = camera2Session;
        }

        private String getErrorDescription(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return "Unknown camera error: " + i;
                                }
                                return "Camera service has encountered a fatal error.";
                            }
                            return "Camera device has encountered a fatal error.";
                        }
                        return "Camera device could not be opened due to a device policy.";
                    }
                    return "Camera device could not be opened because there are too many other open camera devices.";
                }
                return "Camera device is in use already.";
            }
            return (String) invokeI.objValue;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cameraDevice) == null) {
                this.this$0.checkIsOnCameraThread();
                Logging.d(Camera2Session.TAG, "Camera device closed.");
                this.this$0.events.onCameraClosed(this.this$0);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraDevice) == null) {
                this.this$0.checkIsOnCameraThread();
                boolean z = this.this$0.captureSession == null && this.this$0.state != SessionState.STOPPED;
                this.this$0.state = SessionState.STOPPED;
                this.this$0.stopInternal();
                if (z) {
                    this.this$0.callback.onFailure(CameraSession.FailureType.DISCONNECTED, "Camera disconnected / evicted.");
                } else {
                    this.this$0.events.onCameraDisconnected(this.this$0);
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cameraDevice, i) == null) {
                this.this$0.checkIsOnCameraThread();
                this.this$0.reportError(getErrorDescription(i));
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, cameraDevice) == null) {
                this.this$0.checkIsOnCameraThread();
                Logging.d(Camera2Session.TAG, "Camera opened.");
                this.this$0.cameraDevice = cameraDevice;
                this.this$0.surfaceTextureHelper.setTextureSize(this.this$0.captureFormat.width, this.this$0.captureFormat.height);
                this.this$0.surface = new Surface(this.this$0.surfaceTextureHelper.getSurfaceTexture());
                try {
                    cameraDevice.createCaptureSession(Arrays.asList(this.this$0.surface), new CaptureSessionCallback(this.this$0, null), this.this$0.cameraThreadHandler);
                } catch (CameraAccessException e) {
                    Camera2Session camera2Session = this.this$0;
                    camera2Session.reportError("Failed to create capture session. " + e);
                }
            }
        }

        public /* synthetic */ CameraStateCallback(Camera2Session camera2Session, AnonymousClass1 anonymousClass1) {
            this(camera2Session);
        }
    }

    /* loaded from: classes8.dex */
    public class CaptureSessionCallback extends CameraCaptureSession.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Camera2Session this$0;

        public CaptureSessionCallback(Camera2Session camera2Session) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {camera2Session};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = camera2Session;
        }

        private void chooseFocusMode(CaptureRequest.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, builder) == null) {
                for (int i : (int[]) this.this$0.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES)) {
                    if (i == 3) {
                        builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                        Logging.d(Camera2Session.TAG, "Using continuous video auto-focus.");
                        return;
                    }
                }
                Logging.d(Camera2Session.TAG, "Auto-focus is not available.");
            }
        }

        private void chooseStabilizationMode(CaptureRequest.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, builder) == null) {
                int[] iArr = (int[]) this.this$0.cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
                if (iArr != null) {
                    for (int i : iArr) {
                        if (i == 1) {
                            builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
                            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
                            Logging.d(Camera2Session.TAG, "Using optical stabilization.");
                            return;
                        }
                    }
                }
                for (int i2 : (int[]) this.this$0.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) {
                    if (i2 == 1) {
                        builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
                        builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
                        Logging.d(Camera2Session.TAG, "Using video stabilization.");
                        return;
                    }
                }
                Logging.d(Camera2Session.TAG, "Stabilization not available.");
            }
        }

        public /* synthetic */ void a(VideoFrame videoFrame) {
            this.this$0.checkIsOnCameraThread();
            if (this.this$0.state == SessionState.RUNNING) {
                if (!this.this$0.firstFrameReported) {
                    this.this$0.firstFrameReported = true;
                    Camera2Session.camera2StartTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.this$0.constructionTimeNs));
                }
                VideoFrame videoFrame2 = new VideoFrame(ky9.a((TextureBufferImpl) videoFrame.getBuffer(), this.this$0.isCameraFrontFacing, -this.this$0.cameraOrientation), this.this$0.getFrameOrientation(), videoFrame.getTimestampNs());
                this.this$0.events.onFrameCaptured(this.this$0, videoFrame2);
                videoFrame2.release();
                return;
            }
            Logging.d(Camera2Session.TAG, "Texture frame captured but camera is no longer running.");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraCaptureSession) == null) {
                this.this$0.checkIsOnCameraThread();
                cameraCaptureSession.close();
                this.this$0.reportError("Failed to configure capture session.");
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cameraCaptureSession) == null) {
                this.this$0.checkIsOnCameraThread();
                Logging.d(Camera2Session.TAG, "Camera capture session configured.");
                this.this$0.captureSession = cameraCaptureSession;
                try {
                    CaptureRequest.Builder createCaptureRequest = this.this$0.cameraDevice.createCaptureRequest(3);
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(Integer.valueOf(this.this$0.captureFormat.framerate.min / this.this$0.fpsUnitFactor), Integer.valueOf(this.this$0.captureFormat.framerate.max / this.this$0.fpsUnitFactor)));
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
                    chooseStabilizationMode(createCaptureRequest);
                    chooseFocusMode(createCaptureRequest);
                    createCaptureRequest.addTarget(this.this$0.surface);
                    cameraCaptureSession.setRepeatingRequest(createCaptureRequest.build(), new CameraCaptureCallback(null), this.this$0.cameraThreadHandler);
                    this.this$0.surfaceTextureHelper.startListening(new VideoSink() { // from class: com.repackage.jx9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // org.webrtc.VideoSink
                        public final void onFrame(VideoFrame videoFrame) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, videoFrame) == null) {
                                Camera2Session.CaptureSessionCallback.this.a(videoFrame);
                            }
                        }
                    });
                    Logging.d(Camera2Session.TAG, "Camera device successfully started.");
                    this.this$0.callback.onDone(this.this$0);
                } catch (CameraAccessException e) {
                    Camera2Session camera2Session = this.this$0;
                    camera2Session.reportError("Failed to start capture request. " + e);
                }
            }
        }

        public /* synthetic */ CaptureSessionCallback(Camera2Session camera2Session, AnonymousClass1 anonymousClass1) {
            this(camera2Session);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class SessionState {
        public static final /* synthetic */ SessionState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SessionState RUNNING;
        public static final SessionState STOPPED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1977178224, "Lorg/webrtc/Camera2Session$SessionState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1977178224, "Lorg/webrtc/Camera2Session$SessionState;");
                    return;
                }
            }
            RUNNING = new SessionState(TornadoLiteRuntime.STATE_RUNNING, 0);
            SessionState sessionState = new SessionState("STOPPED", 1);
            STOPPED = sessionState;
            $VALUES = new SessionState[]{RUNNING, sessionState};
        }

        public SessionState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-43205017, "Lorg/webrtc/Camera2Session;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-43205017, "Lorg/webrtc/Camera2Session;");
                return;
            }
        }
        camera2StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StartTimeMs", 1, 10000, 50);
        camera2StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StopTimeMs", 1, 10000, 50);
        camera2ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera2.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
    }

    public Camera2Session(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, CameraManager cameraManager, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {createSessionCallback, events, context, cameraManager, surfaceTextureHelper, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.state = SessionState.RUNNING;
        Logging.d(TAG, "Create new camera2 session on camera " + str);
        this.constructionTimeNs = System.nanoTime();
        this.cameraThreadHandler = new Handler();
        this.callback = createSessionCallback;
        this.events = events;
        this.applicationContext = context;
        this.cameraManager = cameraManager;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = str;
        this.width = i;
        this.height = i2;
        this.framerate = i3;
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsOnCameraThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, this) == null) && Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, CameraManager cameraManager, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{createSessionCallback, events, context, cameraManager, surfaceTextureHelper, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            new Camera2Session(createSessionCallback, events, context, cameraManager, surfaceTextureHelper, str, i, i2, i3);
        }
    }

    private void findCaptureFormat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            checkIsOnCameraThread();
            Range[] rangeArr = (Range[]) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            int fpsUnitFactor = Camera2Enumerator.getFpsUnitFactor(rangeArr);
            this.fpsUnitFactor = fpsUnitFactor;
            List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = Camera2Enumerator.convertFramerates(rangeArr, fpsUnitFactor);
            List<Size> supportedSizes = Camera2Enumerator.getSupportedSizes(this.cameraCharacteristics);
            Logging.d(TAG, "Available preview sizes: " + supportedSizes);
            Logging.d(TAG, "Available fps ranges: " + convertFramerates);
            if (!convertFramerates.isEmpty() && !supportedSizes.isEmpty()) {
                CameraEnumerationAndroid.CaptureFormat.FramerateRange closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(convertFramerates, this.framerate);
                Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(supportedSizes, this.width, this.height);
                CameraEnumerationAndroid.reportCameraResolution(camera2ResolutionHistogram, closestSupportedSize);
                this.captureFormat = new CameraEnumerationAndroid.CaptureFormat(closestSupportedSize.width, closestSupportedSize.height, closestSupportedFramerateRange);
                Logging.d(TAG, "Using capture format: " + this.captureFormat);
                return;
            }
            reportError("No supported capture formats.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrameOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            int b = ky9.b(this.applicationContext);
            if (!this.isCameraFrontFacing) {
                b = 360 - b;
            }
            return (this.cameraOrientation + b) % 360;
        }
        return invokeV.intValue;
    }

    private void openCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            checkIsOnCameraThread();
            Logging.d(TAG, "Opening camera " + this.cameraId);
            this.events.onCameraOpening();
            try {
                this.cameraManager.openCamera(this.cameraId, new CameraStateCallback(this, null), this.cameraThreadHandler);
            } catch (CameraAccessException e) {
                reportError("Failed to open camera: " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, str) == null) {
            checkIsOnCameraThread();
            Logging.e(TAG, "Error: " + str);
            boolean z = this.captureSession == null && this.state != SessionState.STOPPED;
            this.state = SessionState.STOPPED;
            stopInternal();
            if (z) {
                this.callback.onFailure(CameraSession.FailureType.ERROR, str);
            } else {
                this.events.onCameraError(this, str);
            }
        }
    }

    private void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            checkIsOnCameraThread();
            Logging.d(TAG, "start");
            try {
                CameraCharacteristics cameraCharacteristics = this.cameraManager.getCameraCharacteristics(this.cameraId);
                this.cameraCharacteristics = cameraCharacteristics;
                this.cameraOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                this.isCameraFrontFacing = ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
                findCaptureFormat();
                openCamera();
            } catch (CameraAccessException e) {
                reportError("getCameraCharacteristics(): " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            Logging.d(TAG, "Stop internal");
            checkIsOnCameraThread();
            this.surfaceTextureHelper.stopListening();
            CameraCaptureSession cameraCaptureSession = this.captureSession;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.captureSession = null;
            }
            Surface surface = this.surface;
            if (surface != null) {
                surface.release();
                this.surface = null;
            }
            CameraDevice cameraDevice = this.cameraDevice;
            if (cameraDevice != null) {
                cameraDevice.close();
                this.cameraDevice = null;
            }
            Logging.d(TAG, "Stop done");
        }
    }

    @Override // org.webrtc.CameraSession
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Logging.d(TAG, "Stop camera2 session on camera " + this.cameraId);
            checkIsOnCameraThread();
            if (this.state != SessionState.STOPPED) {
                long nanoTime = System.nanoTime();
                this.state = SessionState.STOPPED;
                stopInternal();
                camera2StopTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
            }
        }
    }
}
