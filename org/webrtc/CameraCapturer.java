package org.webrtc;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.webrtc.CameraSession;
import org.webrtc.CameraVideoCapturer;
/* loaded from: classes9.dex */
public abstract class CameraCapturer implements CameraVideoCapturer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
    public static final int OPEN_CAMERA_DELAY_MS = 500;
    public static final int OPEN_CAMERA_TIMEOUT = 10000;
    public static final String TAG = "CameraCapturer";
    public transient /* synthetic */ FieldHolder $fh;
    public Context applicationContext;
    public final CameraEnumerator cameraEnumerator;
    public String cameraName;
    @Nullable
    public final CameraSession.Events cameraSessionEventsHandler;
    @Nullable
    public CameraVideoCapturer.CameraStatistics cameraStatistics;
    @Nullable
    public Handler cameraThreadHandler;
    public CapturerObserver capturerObserver;
    @Nullable
    public final CameraSession.CreateSessionCallback createSessionCallback;
    @Nullable
    public CameraSession currentSession;
    @Nullable
    public final CameraVideoCapturer.CameraEventsHandler eventsHandler;
    public boolean firstFrameObserved;
    public int framerate;
    public int height;
    public int openAttemptsRemaining;
    public final Runnable openCameraTimeoutRunnable;
    public boolean sessionOpening;
    public final Object stateLock;
    @Nullable
    public SurfaceTextureHelper surfaceHelper;
    @Nullable
    public CameraVideoCapturer.CameraSwitchHandler switchEventsHandler;
    public SwitchState switchState;
    public final Handler uiThreadHandler;
    public int width;

    @Override // org.webrtc.CameraVideoCapturer
    @Deprecated
    public /* synthetic */ void addMediaRecorderToCamera(MediaRecorder mediaRecorder, CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        iz9.$default$addMediaRecorderToCamera(this, mediaRecorder, mediaRecorderHandler);
    }

    public abstract void createCameraSession(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3);

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.webrtc.CameraVideoCapturer
    @Deprecated
    public /* synthetic */ void removeMediaRecorderFromCamera(CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        iz9.$default$removeMediaRecorderFromCamera(this, mediaRecorderHandler);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class SwitchState {
        public static final /* synthetic */ SwitchState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SwitchState IDLE;
        public static final SwitchState IN_PROGRESS;
        public static final SwitchState PENDING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(122288518, "Lorg/webrtc/CameraCapturer$SwitchState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(122288518, "Lorg/webrtc/CameraCapturer$SwitchState;");
                    return;
                }
            }
            IDLE = new SwitchState("IDLE", 0);
            PENDING = new SwitchState("PENDING", 1);
            SwitchState switchState = new SwitchState("IN_PROGRESS", 2);
            IN_PROGRESS = switchState;
            $VALUES = new SwitchState[]{IDLE, PENDING, switchState};
        }

        public SwitchState(String str, int i) {
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

        public static SwitchState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SwitchState) Enum.valueOf(SwitchState.class, str);
            }
            return (SwitchState) invokeL.objValue;
        }

        public static SwitchState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SwitchState[]) $VALUES.clone();
            }
            return (SwitchState[]) invokeV.objValue;
        }
    }

    public CameraCapturer(String str, @Nullable CameraVideoCapturer.CameraEventsHandler cameraEventsHandler, CameraEnumerator cameraEnumerator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cameraEventsHandler, cameraEnumerator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.createSessionCallback = new CameraSession.CreateSessionCallback(this) { // from class: org.webrtc.CameraCapturer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CameraCapturer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // org.webrtc.CameraSession.CreateSessionCallback
            public void onDone(CameraSession cameraSession) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cameraSession) == null) {
                    this.this$0.checkIsOnCameraThread();
                    Logging.d(CameraCapturer.TAG, "Create session done. Switch state: " + this.this$0.switchState);
                    this.this$0.uiThreadHandler.removeCallbacks(this.this$0.openCameraTimeoutRunnable);
                    synchronized (this.this$0.stateLock) {
                        this.this$0.capturerObserver.onCapturerStarted(true);
                        this.this$0.sessionOpening = false;
                        this.this$0.currentSession = cameraSession;
                        this.this$0.cameraStatistics = new CameraVideoCapturer.CameraStatistics(this.this$0.surfaceHelper, this.this$0.eventsHandler);
                        this.this$0.firstFrameObserved = false;
                        this.this$0.stateLock.notifyAll();
                        if (this.this$0.switchState == SwitchState.IN_PROGRESS) {
                            this.this$0.switchState = SwitchState.IDLE;
                            if (this.this$0.switchEventsHandler != null) {
                                this.this$0.switchEventsHandler.onCameraSwitchDone(this.this$0.cameraEnumerator.isFrontFacing(this.this$0.cameraName));
                                this.this$0.switchEventsHandler = null;
                            }
                        } else if (this.this$0.switchState == SwitchState.PENDING) {
                            this.this$0.switchState = SwitchState.IDLE;
                            this.this$0.switchCameraInternal(this.this$0.switchEventsHandler);
                        }
                    }
                }
            }

            @Override // org.webrtc.CameraSession.CreateSessionCallback
            public void onFailure(CameraSession.FailureType failureType, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, failureType, str2) == null) {
                    this.this$0.checkIsOnCameraThread();
                    this.this$0.uiThreadHandler.removeCallbacks(this.this$0.openCameraTimeoutRunnable);
                    synchronized (this.this$0.stateLock) {
                        this.this$0.capturerObserver.onCapturerStarted(false);
                        CameraCapturer.access$1610(this.this$0);
                        if (this.this$0.openAttemptsRemaining <= 0) {
                            Logging.w(CameraCapturer.TAG, "Opening camera failed, passing: " + str2);
                            this.this$0.sessionOpening = false;
                            this.this$0.stateLock.notifyAll();
                            if (this.this$0.switchState != SwitchState.IDLE) {
                                if (this.this$0.switchEventsHandler != null) {
                                    this.this$0.switchEventsHandler.onCameraSwitchError(str2);
                                    this.this$0.switchEventsHandler = null;
                                }
                                this.this$0.switchState = SwitchState.IDLE;
                            }
                            if (failureType == CameraSession.FailureType.DISCONNECTED) {
                                this.this$0.eventsHandler.onCameraDisconnected();
                            } else {
                                this.this$0.eventsHandler.onCameraError(str2);
                            }
                        } else {
                            Logging.w(CameraCapturer.TAG, "Opening camera failed, retry: " + str2);
                            this.this$0.createSessionInternal(500);
                        }
                    }
                }
            }
        };
        this.cameraSessionEventsHandler = new CameraSession.Events(this) { // from class: org.webrtc.CameraCapturer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CameraCapturer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // org.webrtc.CameraSession.Events
            public void onCameraClosed(CameraSession cameraSession) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cameraSession) == null) {
                    this.this$0.checkIsOnCameraThread();
                    synchronized (this.this$0.stateLock) {
                        if (cameraSession != this.this$0.currentSession && this.this$0.currentSession != null) {
                            Logging.d(CameraCapturer.TAG, "onCameraClosed from another session.");
                        } else {
                            this.this$0.eventsHandler.onCameraClosed();
                        }
                    }
                }
            }

            @Override // org.webrtc.CameraSession.Events
            public void onCameraDisconnected(CameraSession cameraSession) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraSession) == null) {
                    this.this$0.checkIsOnCameraThread();
                    synchronized (this.this$0.stateLock) {
                        if (cameraSession != this.this$0.currentSession) {
                            Logging.w(CameraCapturer.TAG, "onCameraDisconnected from another session.");
                            return;
                        }
                        this.this$0.eventsHandler.onCameraDisconnected();
                        this.this$0.stopCapture();
                    }
                }
            }

            @Override // org.webrtc.CameraSession.Events
            public void onCameraError(CameraSession cameraSession, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cameraSession, str2) == null) {
                    this.this$0.checkIsOnCameraThread();
                    synchronized (this.this$0.stateLock) {
                        if (cameraSession != this.this$0.currentSession) {
                            Logging.w(CameraCapturer.TAG, "onCameraError from another session: " + str2);
                            return;
                        }
                        this.this$0.eventsHandler.onCameraError(str2);
                        this.this$0.stopCapture();
                    }
                }
            }

            @Override // org.webrtc.CameraSession.Events
            public void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, cameraSession, videoFrame) == null) {
                    this.this$0.checkIsOnCameraThread();
                    synchronized (this.this$0.stateLock) {
                        if (cameraSession != this.this$0.currentSession) {
                            Logging.w(CameraCapturer.TAG, "onFrameCaptured from another session.");
                            return;
                        }
                        if (!this.this$0.firstFrameObserved) {
                            this.this$0.eventsHandler.onFirstFrameAvailable();
                            this.this$0.firstFrameObserved = true;
                        }
                        this.this$0.cameraStatistics.addFrame();
                        this.this$0.capturerObserver.onFrameCaptured(videoFrame);
                    }
                }
            }

            @Override // org.webrtc.CameraSession.Events
            public void onCameraOpening() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.this$0.checkIsOnCameraThread();
                    synchronized (this.this$0.stateLock) {
                        if (this.this$0.currentSession != null) {
                            Logging.w(CameraCapturer.TAG, "onCameraOpening while session was open.");
                        } else {
                            this.this$0.eventsHandler.onCameraOpening(this.this$0.cameraName);
                        }
                    }
                }
            }
        };
        this.openCameraTimeoutRunnable = new Runnable(this) { // from class: org.webrtc.CameraCapturer.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CameraCapturer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    this.this$0.eventsHandler.onCameraError("Camera failed to start within timeout.");
                }
            }
        };
        this.stateLock = new Object();
        this.switchState = SwitchState.IDLE;
        this.eventsHandler = cameraEventsHandler == null ? new CameraVideoCapturer.CameraEventsHandler(this) { // from class: org.webrtc.CameraCapturer.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CameraCapturer this$0;

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraClosed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraDisconnected() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraError(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str2) == null) {
                }
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraFreezed(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, str2) == null) {
                }
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraOpening(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048580, this, str2) == null) {
                }
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onFirstFrameAvailable() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }
        } : cameraEventsHandler;
        this.cameraEnumerator = cameraEnumerator;
        this.cameraName = str;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        if (deviceNames.length != 0) {
            if (Arrays.asList(deviceNames).contains(this.cameraName)) {
                return;
            }
            throw new IllegalArgumentException("Camera name " + this.cameraName + " does not match any known camera device.");
        }
        throw new RuntimeException("No cameras attached.");
    }

    public static /* synthetic */ int access$1610(CameraCapturer cameraCapturer) {
        int i = cameraCapturer.openAttemptsRemaining;
        cameraCapturer.openAttemptsRemaining = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSessionInternal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65568, this, i) == null) {
            this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, i + 10000);
            this.cameraThreadHandler.postDelayed(new Runnable(this) { // from class: org.webrtc.CameraCapturer.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CameraCapturer this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CameraCapturer cameraCapturer = this.this$0;
                        cameraCapturer.createCameraSession(cameraCapturer.createSessionCallback, this.this$0.cameraSessionEventsHandler, this.this$0.applicationContext, this.this$0.surfaceHelper, this.this$0.cameraName, this.this$0.width, this.this$0.height, this.this$0.framerate);
                    }
                }
            }, i);
        }
    }

    @Override // org.webrtc.CameraVideoCapturer
    public void switchCamera(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cameraSwitchHandler) == null) {
            Logging.d(TAG, "switchCamera");
            this.cameraThreadHandler.post(new Runnable(this, cameraSwitchHandler) { // from class: org.webrtc.CameraCapturer.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CameraCapturer this$0;
                public final /* synthetic */ CameraVideoCapturer.CameraSwitchHandler val$switchEventsHandler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cameraSwitchHandler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$switchEventsHandler = cameraSwitchHandler;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.switchCameraInternal(this.val$switchEventsHandler);
                }
            });
        }
    }

    private void reportCameraSwitchError(String str, @Nullable CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, this, str, cameraSwitchHandler) == null) {
            Logging.e(TAG, str);
            if (cameraSwitchHandler != null) {
                cameraSwitchHandler.onCameraSwitchError(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsOnCameraThread() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65567, this) != null) || Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
            return;
        }
        Logging.e(TAG, "Check is on camera thread failed.");
        throw new RuntimeException("Not on camera thread.");
    }

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Logging.d(TAG, "dispose");
            stopCapture();
        }
    }

    public String getCameraName() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.stateLock) {
                str = this.cameraName;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchCameraInternal(@Nullable CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, cameraSwitchHandler) == null) {
            Logging.d(TAG, "switchCamera internal");
            String[] deviceNames = this.cameraEnumerator.getDeviceNames();
            if (deviceNames.length < 2) {
                if (cameraSwitchHandler != null) {
                    cameraSwitchHandler.onCameraSwitchError("No camera to switch to.");
                    return;
                }
                return;
            }
            synchronized (this.stateLock) {
                if (this.switchState != SwitchState.IDLE) {
                    reportCameraSwitchError("Camera switch already in progress.", cameraSwitchHandler);
                } else if (!this.sessionOpening && this.currentSession == null) {
                    reportCameraSwitchError("switchCamera: camera is not running.", cameraSwitchHandler);
                } else {
                    this.switchEventsHandler = cameraSwitchHandler;
                    if (this.sessionOpening) {
                        this.switchState = SwitchState.PENDING;
                        return;
                    }
                    this.switchState = SwitchState.IN_PROGRESS;
                    Logging.d(TAG, "switchCamera: Stopping session");
                    this.cameraStatistics.release();
                    this.cameraStatistics = null;
                    this.cameraThreadHandler.post(new Runnable(this, this.currentSession) { // from class: org.webrtc.CameraCapturer.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CameraCapturer this$0;
                        public final /* synthetic */ CameraSession val$oldSession;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$oldSession = r7;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$oldSession.stop();
                            }
                        }
                    });
                    this.currentSession = null;
                    this.cameraName = deviceNames[(Arrays.asList(deviceNames).indexOf(this.cameraName) + 1) % deviceNames.length];
                    this.sessionOpening = true;
                    this.openAttemptsRemaining = 1;
                    createSessionInternal(0);
                    Logging.d(TAG, "switchCamera done");
                }
            }
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            Logging.d(TAG, "changeCaptureFormat: " + i + "x" + i2 + "@" + i3);
            synchronized (this.stateLock) {
                stopCapture();
                startCapture(i, i2, i3);
            }
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(@Nullable SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, surfaceTextureHelper, context, capturerObserver) == null) {
            this.applicationContext = context;
            this.capturerObserver = capturerObserver;
            this.surfaceHelper = surfaceTextureHelper;
            if (surfaceTextureHelper == null) {
                handler = null;
            } else {
                handler = surfaceTextureHelper.getHandler();
            }
            this.cameraThreadHandler = handler;
        }
    }

    public void printStackTrace() {
        Thread thread;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Handler handler = this.cameraThreadHandler;
            if (handler != null) {
                thread = handler.getLooper().getThread();
            } else {
                thread = null;
            }
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace.length > 0) {
                    Logging.d(TAG, "CameraCapturer stack trace:");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        Logging.d(TAG, stackTraceElement.toString());
                    }
                }
            }
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i, i2, i3) == null) {
            Logging.d(TAG, "startCapture: " + i + "x" + i2 + "@" + i3);
            if (this.applicationContext != null) {
                synchronized (this.stateLock) {
                    if (!this.sessionOpening && this.currentSession == null) {
                        this.width = i;
                        this.height = i2;
                        this.framerate = i3;
                        this.sessionOpening = true;
                        this.openAttemptsRemaining = 3;
                        createSessionInternal(0);
                        return;
                    }
                    Logging.w(TAG, "Session already open");
                    return;
                }
            }
            throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Logging.d(TAG, "Stop capture");
            synchronized (this.stateLock) {
                while (this.sessionOpening) {
                    Logging.d(TAG, "Stop capture: Waiting for session to open");
                    try {
                        this.stateLock.wait();
                    } catch (InterruptedException unused) {
                        Logging.w(TAG, "Stop capture interrupted while waiting for the session to open.");
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (this.currentSession != null) {
                    Logging.d(TAG, "Stop capture: Nulling session");
                    this.cameraStatistics.release();
                    this.cameraStatistics = null;
                    this.cameraThreadHandler.post(new Runnable(this, this.currentSession) { // from class: org.webrtc.CameraCapturer.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CameraCapturer this$0;
                        public final /* synthetic */ CameraSession val$oldSession;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$oldSession = r7;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$oldSession.stop();
                            }
                        }
                    });
                    this.currentSession = null;
                    this.capturerObserver.onCapturerStopped();
                } else {
                    Logging.d(TAG, "Stop capture: No session open");
                }
            }
            Logging.d(TAG, "Stop capture done");
        }
    }
}
