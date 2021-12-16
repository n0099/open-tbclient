package com.faceunity.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.h2.a;
import c.a.s0.h2.g;
import c.a.s0.h2.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.EglCore;
import com.faceunity.gles.FullFrameRect;
import com.faceunity.gles.GeneratedTexture;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.gles.WindowSurface;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import kotlinx.coroutines.CoroutineContextKt;
@TargetApi(18)
/* loaded from: classes2.dex */
public class TextureMovieEncoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] AUDIO_SOURCES;
    public static final int IN_RECORDING = 1;
    public static final int MSG_FRAME_AVAILABLE = 2;
    public static final int MSG_QUIT = 5;
    public static final int MSG_SET_TEXTURE_ID = 3;
    public static final int MSG_START_RECORDING = 0;
    public static final int MSG_STOP_RECORDING = 1;
    public static final int MSG_UPDATE_SHARED_CONTEXT = 4;
    public static final int NONE_RECORDING = 4;
    public static final int PREPARE_RECORDING = 5;
    public static final int START_RECORDING = 2;
    public static final int STOP_RECORDING = 3;
    public static final String TAG = "TextureMovieEncoder";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public EncoderConfig config;
    public long firstNanoTime;
    public long firstTimeStampBase;
    public int frameBuffer;
    public AudioEncoderCore mAudioEncoder;
    public EglCore mEglCore;
    public int mFrameNum;
    public FullFrameRect mFullScreen;
    public volatile VideoEncoderHandler mHandler;
    public int mHeight;
    public WindowSurface mInputWindowSurface;
    public MediaMuxerWrapper mMuxer;
    public g mPostMonitorManager;
    public boolean mReady;
    public Object mReadyFence;
    public int mRecordingStatus;
    public boolean mRequestStop;
    public boolean mRunning;
    public int mTextureId;
    public VideoEncoderCore mVideoEncoder;
    public int mWidth;
    public OnEncoderStatusUpdateListener onEncoderStatusUpdateListener;
    public final Object prepareEncoderFence;
    public boolean prepareEncoderReady;
    public long prevOutputPTSUs;
    public final Object stopEncoderFence;
    public boolean stopEncoderSuccess;
    public int texture;
    public boolean videoEncoderReadyFlag;

    /* renamed from: com.faceunity.encoder.TextureMovieEncoder$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class AudioThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextureMovieEncoder this$0;

        public AudioThread(TextureMovieEncoder textureMovieEncoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textureMovieEncoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = textureMovieEncoder;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                synchronized (this.this$0.prepareEncoderFence) {
                    while (!this.this$0.prepareEncoderReady) {
                        try {
                            this.this$0.prepareEncoderFence.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.this$0.prepareEncoderReady = false;
                try {
                    AudioRecordWrapper audioRecordWrapper = new AudioRecordWrapper();
                    if (audioRecordWrapper.getAudioRecord() != null) {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(AudioRecordWrapper.SAMPLES_PER_FRAME);
                        audioRecordWrapper.startRecording();
                        this.this$0.mRecordingStatus = 1;
                        while (!this.this$0.mRequestStop) {
                            try {
                                allocateDirect.clear();
                                int read = audioRecordWrapper.read(allocateDirect, AudioRecordWrapper.SAMPLES_PER_FRAME);
                                if (read > 0) {
                                    allocateDirect.position(read);
                                    allocateDirect.flip();
                                    this.this$0.mAudioEncoder.encode(allocateDirect, read, this.this$0.getPTSUs());
                                    this.this$0.mAudioEncoder.drainEncoder();
                                }
                            } finally {
                                audioRecordWrapper.stop();
                            }
                        }
                        this.this$0.mAudioEncoder.encode(null, 0, this.this$0.getPTSUs());
                        audioRecordWrapper.release();
                        this.this$0.mAudioEncoder.release();
                    }
                } catch (Exception unused) {
                }
                synchronized (this.this$0.stopEncoderFence) {
                    this.this$0.stopEncoderSuccess = true;
                    this.this$0.stopEncoderFence.notify();
                }
            }
        }

        public /* synthetic */ AudioThread(TextureMovieEncoder textureMovieEncoder, AnonymousClass1 anonymousClass1) {
            this(textureMovieEncoder);
        }
    }

    /* loaded from: classes2.dex */
    public static class EncoderConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long firstTimeStampBase;
        public final int mBitRate;
        public final EGLContext mEglContext;
        public final int mHeight;
        public final File mOutputFile;
        public final int mWidth;

        public EncoderConfig(File file, int i2, int i3, int i4, EGLContext eGLContext, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eGLContext, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOutputFile = file;
            this.mWidth = i2;
            this.mHeight = i3;
            this.mBitRate = i4;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.firstTimeStampBase = j2;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + CoroutineContextKt.DEBUG_THREAD_NAME_SEPARATOR + this.mBitRate + " to '" + this.mOutputFile.toString() + "' ctxt=" + this.mEglContext;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnEncoderStatusUpdateListener {
        void onStartSuccess();

        void onStopSuccess();
    }

    /* loaded from: classes2.dex */
    public static class VideoEncoderHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TextureMovieEncoder> mWeakEncoder;

        public VideoEncoderHandler(TextureMovieEncoder textureMovieEncoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textureMovieEncoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWeakEncoder = new WeakReference<>(textureMovieEncoder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                Object obj = message.obj;
                TextureMovieEncoder textureMovieEncoder = this.mWeakEncoder.get();
                if (textureMovieEncoder == null) {
                    return;
                }
                if (i2 == 0) {
                    textureMovieEncoder.handleStartRecording((EncoderConfig) obj);
                } else if (i2 == 1) {
                    textureMovieEncoder.handleStopRecording();
                } else if (i2 == 2) {
                    if (textureMovieEncoder.videoEncoderReadyFlag) {
                        textureMovieEncoder.handleFrameAvailable((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                    }
                } else if (i2 == 3) {
                    if (textureMovieEncoder.videoEncoderReadyFlag) {
                        textureMovieEncoder.handleSetTexture(message.arg1);
                    }
                } else if (i2 == 4) {
                    if (textureMovieEncoder.videoEncoderReadyFlag) {
                        textureMovieEncoder.handleUpdateSharedContext((EGLContext) message.obj);
                    }
                } else if (i2 == 5) {
                    Looper.myLooper().quit();
                } else {
                    throw new RuntimeException("Unhandled msg what=" + i2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class VideoThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextureMovieEncoder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoThread(TextureMovieEncoder textureMovieEncoder, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textureMovieEncoder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = textureMovieEncoder;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                synchronized (this.this$0.mReadyFence) {
                    this.this$0.mHandler = new VideoEncoderHandler(this.this$0);
                    this.this$0.mReady = true;
                    this.this$0.mReadyFence.notify();
                }
                Looper.loop();
                synchronized (this.this$0.mReadyFence) {
                    this.this$0.mReady = this.this$0.mRunning = false;
                    this.this$0.mHandler = null;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1537608920, "Lcom/faceunity/encoder/TextureMovieEncoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1537608920, "Lcom/faceunity/encoder/TextureMovieEncoder;");
                return;
            }
        }
        AUDIO_SOURCES = new int[]{1, 0, 5, 7, 6};
    }

    public TextureMovieEncoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mReadyFence = new Object();
        this.mRecordingStatus = 4;
        this.firstTimeStampBase = 0L;
        this.firstNanoTime = 0L;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.mPostMonitorManager = kVar.get();
        }
        this.config = null;
        this.prepareEncoderFence = new Object();
        this.prepareEncoderReady = false;
        this.stopEncoderFence = new Object();
        this.stopEncoderSuccess = false;
        this.videoEncoderReadyFlag = false;
        this.mRequestStop = false;
        this.prevOutputPTSUs = 0L;
        this.mRecordingStatus = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable(float[] fArr, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65556, this, fArr, j2) == null) || this.texture == 0) {
            return;
        }
        try {
            this.mVideoEncoder.drainEncoder(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        EncoderConfig encoderConfig = this.config;
        GLES20.glViewport(0, 0, encoderConfig.mWidth, encoderConfig.mHeight);
        synchronized (TextureMovieEncoder.class) {
            this.mFullScreen.drawFrame(this.mTextureId, fArr);
        }
        WindowSurface windowSurface = this.mInputWindowSurface;
        if (windowSurface != null) {
            windowSurface.setPresentationTime(getPTSUs() * 1000);
            this.mInputWindowSurface.swapBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetTexture(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i2) == null) {
            this.mTextureId = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartRecording(EncoderConfig encoderConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, encoderConfig) == null) {
            String str = "handleStartRecording " + encoderConfig;
            this.config = encoderConfig;
            this.mFrameNum = 0;
            prepareEncoder(encoderConfig.mEglContext, encoderConfig.mWidth, encoderConfig.mHeight, encoderConfig.mBitRate, encoderConfig.mOutputFile);
            this.mRequestStop = false;
            OnEncoderStatusUpdateListener onEncoderStatusUpdateListener = this.onEncoderStatusUpdateListener;
            if (onEncoderStatusUpdateListener != null) {
                onEncoderStatusUpdateListener.onStartSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            try {
                this.mVideoEncoder.drainEncoder(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mRequestStop = true;
            releaseEncoder();
            while (!this.stopEncoderSuccess) {
                synchronized (this.stopEncoderFence) {
                    try {
                        this.stopEncoderFence.wait();
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            this.stopEncoderSuccess = false;
            OnEncoderStatusUpdateListener onEncoderStatusUpdateListener = this.onEncoderStatusUpdateListener;
            if (onEncoderStatusUpdateListener != null) {
                onEncoderStatusUpdateListener.onStopSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, eGLContext) == null) {
            String str = "handleUpdatedSharedContext " + eGLContext;
            WindowSurface windowSurface = this.mInputWindowSurface;
            if (windowSurface != null) {
                windowSurface.releaseEglSurface();
            }
            this.mFullScreen.release(false);
            EglCore eglCore = this.mEglCore;
            if (eglCore != null) {
                eglCore.release();
            }
            EglCore eglCore2 = new EglCore(eGLContext, 1);
            this.mEglCore = eglCore2;
            WindowSurface windowSurface2 = this.mInputWindowSurface;
            if (windowSurface2 != null) {
                windowSurface2.recreate(eglCore2);
                this.mInputWindowSurface.makeCurrent();
            }
            this.mFullScreen = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        }
    }

    private void prepareEncoder(EGLContext eGLContext, int i2, int i3, int i4, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, this, new Object[]{eGLContext, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), file}) == null) {
            try {
                MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(file.toString());
                this.mMuxer = mediaMuxerWrapper;
                this.mVideoEncoder = new VideoEncoderCore(i2, i3, i4, mediaMuxerWrapper);
                this.mAudioEncoder = new AudioEncoderCore(this.mMuxer);
                this.videoEncoderReadyFlag = true;
                synchronized (this.prepareEncoderFence) {
                    this.prepareEncoderReady = true;
                    this.prepareEncoderFence.notify();
                }
            } catch (IOException e2) {
                g gVar = this.mPostMonitorManager;
                if (gVar != null) {
                    gVar.b(12, a.a(e2));
                }
            } catch (IllegalStateException e3) {
                this.videoEncoderReadyFlag = false;
                g gVar2 = this.mPostMonitorManager;
                if (gVar2 != null) {
                    gVar2.b(13, a.a(e3));
                    return;
                }
                return;
            }
            EglCore eglCore = new EglCore(eGLContext, 1);
            this.mEglCore = eglCore;
            WindowSurface windowSurface = new WindowSurface(eglCore, this.mVideoEncoder.getInputSurface(), true);
            this.mInputWindowSurface = windowSurface;
            windowSurface.makeCurrent();
            this.mFullScreen = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        }
    }

    private void releaseEncoder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            try {
                this.mVideoEncoder.release();
                if (this.mInputWindowSurface != null) {
                    this.mInputWindowSurface.release();
                    this.mInputWindowSurface = null;
                }
                if (this.mFullScreen != null) {
                    this.mFullScreen.release(false);
                    this.mFullScreen = null;
                }
                if (this.mEglCore != null) {
                    this.mEglCore.release();
                    this.mEglCore = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                g gVar = this.mPostMonitorManager;
                if (gVar != null) {
                    gVar.b(14, a.a(e2));
                }
            }
        }
    }

    public boolean checkRecordingStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.mRecordingStatus == i2 : invokeI.booleanValue;
    }

    public void frameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture) == null) {
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    float[] fArr = new float[16];
                    Matrix.setIdentityM(fArr, 0);
                    long timestamp = surfaceTexture.getTimestamp();
                    if (timestamp == 0) {
                        return;
                    }
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public long getPTSUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long nanoTime = System.nanoTime();
            if (this.firstTimeStampBase != 0) {
                if (this.firstNanoTime == 0) {
                    this.firstNanoTime = nanoTime;
                }
                nanoTime = (nanoTime - this.firstNanoTime) + this.firstTimeStampBase;
            }
            long j2 = nanoTime / 1000;
            long j3 = this.prevOutputPTSUs;
            if (j2 < j3) {
                j2 += j3 - j2;
            }
            if (j2 == this.prevOutputPTSUs) {
                j2 += 100;
            }
            this.prevOutputPTSUs = j2;
            return j2;
        }
        return invokeV.longValue;
    }

    public boolean isRecording() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mReadyFence) {
                z = this.mRunning;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void setOnEncoderStatusUpdateListener(OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onEncoderStatusUpdateListener) == null) {
            this.onEncoderStatusUpdateListener = onEncoderStatusUpdateListener;
        }
    }

    public void setTextureId(FullFrameRect fullFrameRect, int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048581, this, fullFrameRect, i2, fArr) == null) || this.texture == 0) {
            return;
        }
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        GLES20.glBindFramebuffer(36160, this.frameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        if (fullFrameRect != null) {
            fullFrameRect.drawFrame(i2, fArr);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.texture, 0, null));
            }
        }
    }

    public void startRecording(EncoderConfig encoderConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, encoderConfig) == null) {
            this.mWidth = encoderConfig.mWidth;
            this.mHeight = encoderConfig.mHeight;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            this.texture = i2;
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.mWidth, this.mHeight, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            this.frameBuffer = iArr2[0];
            this.mRecordingStatus = 5;
            this.firstTimeStampBase = encoderConfig.firstTimeStampBase;
            this.firstNanoTime = System.nanoTime();
            synchronized (this.mReadyFence) {
                if (this.mRunning) {
                    return;
                }
                this.mRunning = true;
                new VideoThread(this, "TextureMovieVideoEncoder").start();
                new AudioThread(this, null).start();
                while (!this.mReady) {
                    try {
                        this.mReadyFence.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                this.mHandler.sendMessage(this.mHandler.obtainMessage(0, encoderConfig));
            }
        }
    }

    public void stopRecording() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.frameBuffer}, 0);
            GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
            this.frameBuffer = 0;
            this.texture = 0;
            MediaMuxerWrapper mediaMuxerWrapper = this.mMuxer;
            if (mediaMuxerWrapper == null || !mediaMuxerWrapper.isStarted()) {
                this.mRequestStop = true;
                VideoEncoderCore videoEncoderCore = this.mVideoEncoder;
                if (videoEncoderCore != null) {
                    videoEncoderCore.requestStop();
                }
            }
            this.mRecordingStatus = 4;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
        }
    }

    public void updateSharedContext(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eGLContext) == null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4, eGLContext));
        }
    }
}
