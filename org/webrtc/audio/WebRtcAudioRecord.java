package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes9.dex */
public class WebRtcAudioRecord {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    public static final int BITS_PER_SAMPLE = 16;
    public static final int BUFFERS_PER_SECOND = 100;
    public static final int BUFFER_SIZE_FACTOR = 2;
    public static final int CALLBACK_BUFFER_SIZE_MS = 10;
    public static final int DEFAULT_AUDIO_SOURCE = 7;
    public static final int EXT_RECORDSTATE_RECORDING = 3;
    public static final int EXT_RECORDSTATE_STOPPED = 1;
    public static final int EXT_STATE_INITIALIZED = 1;
    public static final int EXT_STATE_UNINITIALIZED = 0;
    public static final String TAG = "WebRtcAudioRecordExternal";
    public transient /* synthetic */ FieldHolder $fh;
    public final AudioManager audioManager;
    public AudioRecord audioRecord;
    public final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
    public final int audioSource;
    public AudioRecordThread audioThread;
    public ByteBuffer byteBuffer;
    public final Context context;
    public final WebRtcAudioEffects effects;
    public byte[] emptyBytes;
    public final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
    public final boolean externalAudioRecord;
    public JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    public final boolean isAcousticEchoCancelerSupported;
    public final boolean isNoiseSuppressorSupported;
    public int mExtRecordState;
    public final Object mExtRecordStateLock;
    public volatile boolean microphoneMute;
    public long nativeAudioRecord;

    /* loaded from: classes9.dex */
    public class AudioRecordThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean keepAlive;
        public final /* synthetic */ WebRtcAudioRecord this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioRecordThread(WebRtcAudioRecord webRtcAudioRecord, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webRtcAudioRecord, str};
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
            this.this$0 = webRtcAudioRecord;
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
                WebRtcAudioRecord.assertTrue(this.this$0.audioRecord.getRecordingState() == 3);
                System.nanoTime();
                while (this.keepAlive) {
                    int read = this.this$0.audioRecord.read(this.this$0.byteBuffer, this.this$0.byteBuffer.capacity());
                    if (read == this.this$0.byteBuffer.capacity()) {
                        if (this.this$0.microphoneMute) {
                            this.this$0.byteBuffer.clear();
                            this.this$0.byteBuffer.put(this.this$0.emptyBytes);
                        }
                        if (this.keepAlive) {
                            WebRtcAudioRecord webRtcAudioRecord = this.this$0;
                            webRtcAudioRecord.nativeDataIsRecorded(webRtcAudioRecord.nativeAudioRecord, read);
                        }
                        if (this.this$0.audioSamplesReadyCallback != null) {
                            this.this$0.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(this.this$0.audioRecord.getAudioFormat(), this.this$0.audioRecord.getChannelCount(), this.this$0.audioRecord.getSampleRate(), Arrays.copyOfRange(this.this$0.byteBuffer.array(), this.this$0.byteBuffer.arrayOffset(), this.this$0.byteBuffer.capacity() + this.this$0.byteBuffer.arrayOffset())));
                        }
                    } else {
                        String str = "AudioRecord.read failed: " + read;
                        Logging.e(WebRtcAudioRecord.TAG, str);
                        if (read == -3) {
                            this.keepAlive = false;
                            this.this$0.reportWebRtcAudioRecordError(str);
                        }
                    }
                }
                try {
                    if (this.this$0.audioRecord != null) {
                        this.this$0.audioRecord.stop();
                    }
                } catch (IllegalStateException e2) {
                    Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e2.getMessage());
                }
            }
        }

        public void stopThread() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Logging.d(WebRtcAudioRecord.TAG, "stopThread");
                this.keepAlive = false;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @CalledByNative
    public WebRtcAudioRecord(Context context, AudioManager audioManager) {
        this(context, audioManager, 7, false, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, audioManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AudioManager) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue(), (JavaAudioDeviceModule.AudioRecordErrorCallback) objArr2[4], (JavaAudioDeviceModule.SamplesReadyCallback) objArr2[5], ((Boolean) objArr2[6]).booleanValue(), ((Boolean) objArr2[7]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public WebRtcAudioRecord(Context context, AudioManager audioManager, int i2, boolean z, JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback, JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, audioManager, Integer.valueOf(i2), Boolean.valueOf(z), audioRecordErrorCallback, samplesReadyCallback, Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExtRecordState = 0;
        this.mExtRecordStateLock = new Object();
        this.externalSamplesCallback = new JavaAudioDeviceModule.ExternalSamplesReadyCallback(this) { // from class: org.webrtc.audio.WebRtcAudioRecord.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebRtcAudioRecord this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.ExternalSamplesReadyCallback
            public void onWebRtcAudioExternalSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
                int length;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, audioSamples) == null) && this.this$0.getExtRecordState() == 3 && audioSamples != null && audioSamples.getData() != null && (length = audioSamples.getData().length) == this.this$0.byteBuffer.capacity()) {
                    if (this.this$0.byteBuffer.position() == 0) {
                        this.this$0.byteBuffer.put(audioSamples.getData(), 0, length);
                        this.this$0.byteBuffer.flip();
                    }
                    if (this.this$0.microphoneMute) {
                        this.this$0.byteBuffer.clear();
                        this.this$0.byteBuffer.put(this.this$0.emptyBytes);
                    }
                    WebRtcAudioRecord webRtcAudioRecord = this.this$0;
                    webRtcAudioRecord.nativeDataIsRecorded(webRtcAudioRecord.nativeAudioRecord, length);
                }
            }
        };
        this.effects = new WebRtcAudioEffects();
        this.audioRecord = null;
        this.audioThread = null;
        this.microphoneMute = false;
        this.externalAudioRecord = z;
        if (z2 && !WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            throw new IllegalArgumentException("HW AEC not supported");
        }
        if (z3 && !WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            throw new IllegalArgumentException("HW NS not supported");
        }
        this.context = context;
        this.audioManager = audioManager;
        this.audioSource = i2;
        this.errorCallback = audioRecordErrorCallback;
        this.audioSamplesReadyCallback = samplesReadyCallback;
        this.isAcousticEchoCancelerSupported = z2;
        this.isNoiseSuppressorSupported = z3;
    }

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65548, null, z) == null) && !z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) ? i2 == 1 ? 16 : 12 : invokeI.intValue;
    }

    @CalledByNative
    private boolean enableBuiltInAEC(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65550, this, z)) == null) {
            Logging.d(TAG, "enableBuiltInAEC(" + z + SmallTailInfo.EMOTION_SUFFIX);
            if (this.externalAudioRecord) {
                Logging.e(TAG, "Can not support builtIn AEC in external record mode");
                return false;
            }
            return this.effects.setAEC(z);
        }
        return invokeZ.booleanValue;
    }

    @CalledByNative
    private boolean enableBuiltInNS(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65551, this, z)) == null) {
            Logging.d(TAG, "enableBuiltInNS(" + z + SmallTailInfo.EMOTION_SUFFIX);
            if (this.externalAudioRecord) {
                Logging.e(TAG, "Can not support builtIn NS in external record mode");
                return false;
            }
            return this.effects.setNS(z);
        }
        return invokeZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExtRecordState() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            synchronized (this.mExtRecordStateLock) {
                i2 = this.mExtRecordState;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @CalledByNative
    private int initRecording(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65553, this, i2, i3)) == null) {
            Logging.d(TAG, "initRecording(sampleRate=" + i2 + ", channels=" + i3 + SmallTailInfo.EMOTION_SUFFIX);
            if (this.audioRecord != null || (this.externalAudioRecord && this.mExtRecordState != 0)) {
                reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
                return -1;
            }
            int i4 = i2 / 100;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3 * 2 * i4);
            this.byteBuffer = allocateDirect;
            if (!allocateDirect.hasArray()) {
                reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
                return -1;
            }
            Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
            this.emptyBytes = new byte[this.byteBuffer.capacity()];
            nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
            int channelCountToConfiguration = channelCountToConfiguration(i3);
            int minBufferSize = AudioRecord.getMinBufferSize(i2, channelCountToConfiguration, 2);
            if (minBufferSize == -1 || minBufferSize == -2) {
                reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
                return -1;
            }
            Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
            int max = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
            Logging.d(TAG, "bufferSizeInBytes: " + max);
            if (this.externalAudioRecord) {
                this.mExtRecordState = 1;
                return i4;
            }
            try {
                AudioRecord audioRecord = new AudioRecord(this.audioSource, i2, channelCountToConfiguration, 2, max);
                this.audioRecord = audioRecord;
                if (audioRecord == null || audioRecord.getState() != 1) {
                    reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                    releaseAudioResources();
                    return -1;
                }
                this.effects.enable(this.audioRecord.getAudioSessionId());
                logMainParameters();
                logMainParametersExtended();
                return i4;
            } catch (IllegalArgumentException e2) {
                reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + e2.getMessage());
                releaseAudioResources();
                return -1;
            }
        }
        return invokeII.intValue;
    }

    private void logMainParameters() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
        }
    }

    @TargetApi(23)
    private void logMainParametersExtended() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && WebRtcAudioUtils.runningOnMarshmallowOrHigher()) {
            Logging.d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
        }
    }

    private native void nativeCacheDirectBufferAddress(long j, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(long j, int i2);

    private void releaseAudioResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            Logging.d(TAG, "releaseAudioResources");
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.release();
                this.audioRecord = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            Logging.e(TAG, "Run-time recording error: " + str);
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
            if (audioRecordErrorCallback != null) {
                audioRecordErrorCallback.onWebRtcAudioRecordError(str);
            }
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
            Logging.e(TAG, "Init recording error: " + str);
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
            if (audioRecordErrorCallback != null) {
                audioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
            }
        }
    }

    private void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, this, audioRecordStartErrorCode, str) == null) {
            Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
            if (audioRecordErrorCallback != null) {
                audioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
            }
        }
    }

    @CalledByNative
    private boolean startRecording() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            Logging.d(TAG, LightappBusinessClient.MTD_START_AUDIO_RECORD);
            if (this.externalAudioRecord) {
                this.mExtRecordState = 3;
                return true;
            }
            assertTrue(this.audioRecord != null);
            assertTrue(this.audioThread == null);
            try {
                this.audioRecord.startRecording();
                if (this.audioRecord.getRecordingState() == 3) {
                    AudioRecordThread audioRecordThread = new AudioRecordThread(this, "AudioRecordJavaThread");
                    this.audioThread = audioRecordThread;
                    audioRecordThread.start();
                    return true;
                }
                JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH;
                reportWebRtcAudioRecordStartError(audioRecordStartErrorCode, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
                return false;
            } catch (IllegalStateException e2) {
                JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode2 = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION;
                reportWebRtcAudioRecordStartError(audioRecordStartErrorCode2, "AudioRecord.startRecording failed: " + e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    private boolean stopRecording() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            Logging.d(TAG, "stopRecording");
            if (this.externalAudioRecord) {
                this.mExtRecordState = 0;
                return true;
            }
            assertTrue(this.audioThread != null);
            this.audioThread.stopThread();
            if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
                Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
                WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            }
            this.audioThread = null;
            this.effects.release();
            releaseAudioResources();
            return true;
        }
        return invokeV.booleanValue;
    }

    public JavaAudioDeviceModule.ExternalSamplesReadyCallback getExternalSamplesCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.externalSamplesCallback : (JavaAudioDeviceModule.ExternalSamplesReadyCallback) invokeV.objValue;
    }

    @CalledByNative
    public boolean isAcousticEchoCancelerSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isAcousticEchoCancelerSupported : invokeV.booleanValue;
    }

    @CalledByNative
    public boolean isNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isNoiseSuppressorSupported : invokeV.booleanValue;
    }

    public void setMicrophoneMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            Logging.w(TAG, "setMicrophoneMute(" + z + SmallTailInfo.EMOTION_SUFFIX);
            this.microphoneMute = z;
        }
    }

    @CalledByNative
    public void setNativeAudioRecord(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.nativeAudioRecord = j;
        }
    }
}
