package org.webrtc;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.webrtc.CameraSession;
import org.webrtc.CameraVideoCapturer;
/* loaded from: classes8.dex */
public abstract class CameraCapturer implements CameraVideoCapturer {
    public static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
    public static final int OPEN_CAMERA_DELAY_MS = 500;
    public static final int OPEN_CAMERA_TIMEOUT = 10000;
    public static final String TAG = "CameraCapturer";
    public Context applicationContext;
    public final CameraEnumerator cameraEnumerator;
    public String cameraName;
    @Nullable
    public CameraVideoCapturer.CameraStatistics cameraStatistics;
    @Nullable
    public Handler cameraThreadHandler;
    public CapturerObserver capturerObserver;
    @Nullable
    public CameraSession currentSession;
    @Nullable
    public final CameraVideoCapturer.CameraEventsHandler eventsHandler;
    public boolean firstFrameObserved;
    public int framerate;
    public int height;
    public int openAttemptsRemaining;
    public boolean sessionOpening;
    @Nullable
    public SurfaceTextureHelper surfaceHelper;
    @Nullable
    public CameraVideoCapturer.CameraSwitchHandler switchEventsHandler;
    public final Handler uiThreadHandler;
    public int width;
    @Nullable
    public final CameraSession.CreateSessionCallback createSessionCallback = new CameraSession.CreateSessionCallback() { // from class: org.webrtc.CameraCapturer.1
        @Override // org.webrtc.CameraSession.CreateSessionCallback
        public void onDone(CameraSession cameraSession) {
            CameraCapturer.this.checkIsOnCameraThread();
            Logging.d(CameraCapturer.TAG, "Create session done. Switch state: " + CameraCapturer.this.switchState);
            CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
            synchronized (CameraCapturer.this.stateLock) {
                CameraCapturer.this.capturerObserver.onCapturerStarted(true);
                CameraCapturer.this.sessionOpening = false;
                CameraCapturer.this.currentSession = cameraSession;
                CameraCapturer.this.cameraStatistics = new CameraVideoCapturer.CameraStatistics(CameraCapturer.this.surfaceHelper, CameraCapturer.this.eventsHandler);
                CameraCapturer.this.firstFrameObserved = false;
                CameraCapturer.this.stateLock.notifyAll();
                if (CameraCapturer.this.switchState == SwitchState.IN_PROGRESS) {
                    CameraCapturer.this.switchState = SwitchState.IDLE;
                    if (CameraCapturer.this.switchEventsHandler != null) {
                        CameraCapturer.this.switchEventsHandler.onCameraSwitchDone(CameraCapturer.this.cameraEnumerator.isFrontFacing(CameraCapturer.this.cameraName));
                        CameraCapturer.this.switchEventsHandler = null;
                    }
                } else if (CameraCapturer.this.switchState == SwitchState.PENDING) {
                    CameraCapturer.this.switchState = SwitchState.IDLE;
                    CameraCapturer.this.switchCameraInternal(CameraCapturer.this.switchEventsHandler);
                }
            }
        }

        @Override // org.webrtc.CameraSession.CreateSessionCallback
        public void onFailure(CameraSession.FailureType failureType, String str) {
            CameraCapturer.this.checkIsOnCameraThread();
            CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
            synchronized (CameraCapturer.this.stateLock) {
                CameraCapturer.this.capturerObserver.onCapturerStarted(false);
                CameraCapturer.access$1610(CameraCapturer.this);
                if (CameraCapturer.this.openAttemptsRemaining <= 0) {
                    Logging.w(CameraCapturer.TAG, "Opening camera failed, passing: " + str);
                    CameraCapturer.this.sessionOpening = false;
                    CameraCapturer.this.stateLock.notifyAll();
                    if (CameraCapturer.this.switchState != SwitchState.IDLE) {
                        if (CameraCapturer.this.switchEventsHandler != null) {
                            CameraCapturer.this.switchEventsHandler.onCameraSwitchError(str);
                            CameraCapturer.this.switchEventsHandler = null;
                        }
                        CameraCapturer.this.switchState = SwitchState.IDLE;
                    }
                    if (failureType == CameraSession.FailureType.DISCONNECTED) {
                        CameraCapturer.this.eventsHandler.onCameraDisconnected();
                    } else {
                        CameraCapturer.this.eventsHandler.onCameraError(str);
                    }
                } else {
                    Logging.w(CameraCapturer.TAG, "Opening camera failed, retry: " + str);
                    CameraCapturer.this.createSessionInternal(500);
                }
            }
        }
    };
    @Nullable
    public final CameraSession.Events cameraSessionEventsHandler = new CameraSession.Events() { // from class: org.webrtc.CameraCapturer.2
        @Override // org.webrtc.CameraSession.Events
        public void onCameraClosed(CameraSession cameraSession) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (cameraSession == CameraCapturer.this.currentSession || CameraCapturer.this.currentSession == null) {
                    CameraCapturer.this.eventsHandler.onCameraClosed();
                } else {
                    Logging.d(CameraCapturer.TAG, "onCameraClosed from another session.");
                }
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onCameraDisconnected(CameraSession cameraSession) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (cameraSession != CameraCapturer.this.currentSession) {
                    Logging.w(CameraCapturer.TAG, "onCameraDisconnected from another session.");
                    return;
                }
                CameraCapturer.this.eventsHandler.onCameraDisconnected();
                CameraCapturer.this.stopCapture();
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onCameraError(CameraSession cameraSession, String str) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (cameraSession == CameraCapturer.this.currentSession) {
                    CameraCapturer.this.eventsHandler.onCameraError(str);
                    CameraCapturer.this.stopCapture();
                    return;
                }
                Logging.w(CameraCapturer.TAG, "onCameraError from another session: " + str);
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onCameraOpening() {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (CameraCapturer.this.currentSession != null) {
                    Logging.w(CameraCapturer.TAG, "onCameraOpening while session was open.");
                } else {
                    CameraCapturer.this.eventsHandler.onCameraOpening(CameraCapturer.this.cameraName);
                }
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (cameraSession != CameraCapturer.this.currentSession) {
                    Logging.w(CameraCapturer.TAG, "onFrameCaptured from another session.");
                    return;
                }
                if (!CameraCapturer.this.firstFrameObserved) {
                    CameraCapturer.this.eventsHandler.onFirstFrameAvailable();
                    CameraCapturer.this.firstFrameObserved = true;
                }
                CameraCapturer.this.cameraStatistics.addFrame();
                CameraCapturer.this.capturerObserver.onFrameCaptured(videoFrame);
            }
        }
    };
    public final Runnable openCameraTimeoutRunnable = new Runnable() { // from class: org.webrtc.CameraCapturer.3
        @Override // java.lang.Runnable
        public void run() {
            CameraCapturer.this.eventsHandler.onCameraError("Camera failed to start within timeout.");
        }
    };
    public final Object stateLock = new Object();
    public SwitchState switchState = SwitchState.IDLE;

    /* loaded from: classes8.dex */
    public enum SwitchState {
        IDLE,
        PENDING,
        IN_PROGRESS
    }

    public CameraCapturer(String str, @Nullable CameraVideoCapturer.CameraEventsHandler cameraEventsHandler, CameraEnumerator cameraEnumerator) {
        this.eventsHandler = cameraEventsHandler == null ? new CameraVideoCapturer.CameraEventsHandler() { // from class: org.webrtc.CameraCapturer.4
            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraClosed() {
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraDisconnected() {
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraError(String str2) {
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraFreezed(String str2) {
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraOpening(String str2) {
            }

            @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onFirstFrameAvailable() {
            }
        } : cameraEventsHandler;
        this.cameraEnumerator = cameraEnumerator;
        this.cameraName = str;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        if (deviceNames.length == 0) {
            throw new RuntimeException("No cameras attached.");
        }
        if (Arrays.asList(deviceNames).contains(this.cameraName)) {
            return;
        }
        throw new IllegalArgumentException("Camera name " + this.cameraName + " does not match any known camera device.");
    }

    public static /* synthetic */ int access$1610(CameraCapturer cameraCapturer) {
        int i2 = cameraCapturer.openAttemptsRemaining;
        cameraCapturer.openAttemptsRemaining = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsOnCameraThread() {
        if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
            return;
        }
        Logging.e(TAG, "Check is on camera thread failed.");
        throw new RuntimeException("Not on camera thread.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSessionInternal(int i2) {
        this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, i2 + 10000);
        this.cameraThreadHandler.postDelayed(new Runnable() { // from class: org.webrtc.CameraCapturer.5
            @Override // java.lang.Runnable
            public void run() {
                CameraCapturer cameraCapturer = CameraCapturer.this;
                cameraCapturer.createCameraSession(cameraCapturer.createSessionCallback, CameraCapturer.this.cameraSessionEventsHandler, CameraCapturer.this.applicationContext, CameraCapturer.this.surfaceHelper, CameraCapturer.this.cameraName, CameraCapturer.this.width, CameraCapturer.this.height, CameraCapturer.this.framerate);
            }
        }, i2);
    }

    private void reportCameraSwitchError(String str, @Nullable CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        Logging.e(TAG, str);
        if (cameraSwitchHandler != null) {
            cameraSwitchHandler.onCameraSwitchError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchCameraInternal(@Nullable CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
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
                final CameraSession cameraSession = this.currentSession;
                this.cameraThreadHandler.post(new Runnable() { // from class: org.webrtc.CameraCapturer.8
                    @Override // java.lang.Runnable
                    public void run() {
                        cameraSession.stop();
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

    @Override // org.webrtc.CameraVideoCapturer
    @Deprecated
    public void addMediaRecorderToCamera(MediaRecorder mediaRecorder, CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        CameraVideoCapturer_CC.$default$addMediaRecorderToCamera(this, mediaRecorder, mediaRecorderHandler);
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
        Logging.d(TAG, "changeCaptureFormat: " + i2 + "x" + i3 + "@" + i4);
        synchronized (this.stateLock) {
            stopCapture();
            startCapture(i2, i3, i4);
        }
    }

    public abstract void createCameraSession(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, SurfaceTextureHelper surfaceTextureHelper, String str, int i2, int i3, int i4);

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        Logging.d(TAG, "dispose");
        stopCapture();
    }

    public String getCameraName() {
        String str;
        synchronized (this.stateLock) {
            str = this.cameraName;
        }
        return str;
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(@Nullable SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.applicationContext = context;
        this.capturerObserver = capturerObserver;
        this.surfaceHelper = surfaceTextureHelper;
        this.cameraThreadHandler = surfaceTextureHelper == null ? null : surfaceTextureHelper.getHandler();
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    public void printStackTrace() {
        Handler handler = this.cameraThreadHandler;
        Thread thread = handler != null ? handler.getLooper().getThread() : null;
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

    @Override // org.webrtc.CameraVideoCapturer
    @Deprecated
    public void removeMediaRecorderFromCamera(CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        CameraVideoCapturer_CC.$default$removeMediaRecorderFromCamera(this, mediaRecorderHandler);
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
        Logging.d(TAG, "startCapture: " + i2 + "x" + i3 + "@" + i4);
        if (this.applicationContext == null) {
            throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
        }
        synchronized (this.stateLock) {
            if (!this.sessionOpening && this.currentSession == null) {
                this.width = i2;
                this.height = i3;
                this.framerate = i4;
                this.sessionOpening = true;
                this.openAttemptsRemaining = 3;
                createSessionInternal(0);
                return;
            }
            Logging.w(TAG, "Session already open");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
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
                final CameraSession cameraSession = this.currentSession;
                this.cameraThreadHandler.post(new Runnable() { // from class: org.webrtc.CameraCapturer.6
                    @Override // java.lang.Runnable
                    public void run() {
                        cameraSession.stop();
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

    @Override // org.webrtc.CameraVideoCapturer
    public void switchCamera(final CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        Logging.d(TAG, "switchCamera");
        this.cameraThreadHandler.post(new Runnable() { // from class: org.webrtc.CameraCapturer.7
            @Override // java.lang.Runnable
            public void run() {
                CameraCapturer.this.switchCameraInternal(cameraSwitchHandler);
            }
        });
    }
}
