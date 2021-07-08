package org.webrtc.voiceengine;

import android.media.AudioRecord;
import android.os.Build;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
/* loaded from: classes9.dex */
public class WebRtcAudioRecord {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    public static final int BITS_PER_SAMPLE = 16;
    public static final int BUFFERS_PER_SECOND = 100;
    public static final int BUFFER_SIZE_FACTOR = 2;
    public static final int CALLBACK_BUFFER_SIZE_MS = 10;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_AUDIO_SOURCE;
    public static final String TAG = "WebRtcAudioRecord";
    @Nullable
    public static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    public static int audioSource;
    @Nullable
    public static WebRtcAudioRecordErrorCallback errorCallback;
    public static volatile boolean microphoneMute;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AudioRecord audioRecord;
    @Nullable
    public AudioRecordThread audioThread;
    public ByteBuffer byteBuffer;
    @Nullable
    public WebRtcAudioEffects effects;
    public byte[] emptyBytes;
    public final long nativeAudioRecord;

    /* renamed from: org.webrtc.voiceengine.WebRtcAudioRecord$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class AudioRecordStartErrorCode {
        public static final /* synthetic */ AudioRecordStartErrorCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AudioRecordStartErrorCode AUDIO_RECORD_START_EXCEPTION;
        public static final AudioRecordStartErrorCode AUDIO_RECORD_START_STATE_MISMATCH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1899260783, "Lorg/webrtc/voiceengine/WebRtcAudioRecord$AudioRecordStartErrorCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1899260783, "Lorg/webrtc/voiceengine/WebRtcAudioRecord$AudioRecordStartErrorCode;");
                    return;
                }
            }
            AUDIO_RECORD_START_EXCEPTION = new AudioRecordStartErrorCode("AUDIO_RECORD_START_EXCEPTION", 0);
            AudioRecordStartErrorCode audioRecordStartErrorCode = new AudioRecordStartErrorCode("AUDIO_RECORD_START_STATE_MISMATCH", 1);
            AUDIO_RECORD_START_STATE_MISMATCH = audioRecordStartErrorCode;
            $VALUES = new AudioRecordStartErrorCode[]{AUDIO_RECORD_START_EXCEPTION, audioRecordStartErrorCode};
        }

        public AudioRecordStartErrorCode(String str, int i2) {
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

        public static AudioRecordStartErrorCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AudioRecordStartErrorCode) Enum.valueOf(AudioRecordStartErrorCode.class, str) : (AudioRecordStartErrorCode) invokeL.objValue;
        }

        public static AudioRecordStartErrorCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AudioRecordStartErrorCode[]) $VALUES.clone() : (AudioRecordStartErrorCode[]) invokeV.objValue;
        }
    }

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
                        if (WebRtcAudioRecord.microphoneMute) {
                            this.this$0.byteBuffer.clear();
                            this.this$0.byteBuffer.put(this.this$0.emptyBytes);
                        }
                        if (this.keepAlive) {
                            WebRtcAudioRecord webRtcAudioRecord = this.this$0;
                            webRtcAudioRecord.nativeDataIsRecorded(read, webRtcAudioRecord.nativeAudioRecord);
                        }
                        if (WebRtcAudioRecord.audioSamplesReadyCallback != null) {
                            WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new AudioSamples(this.this$0.audioRecord, Arrays.copyOf(this.this$0.byteBuffer.array(), this.this$0.byteBuffer.capacity()), null));
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

    /* loaded from: classes9.dex */
    public static class AudioSamples {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int audioFormat;
        public final int channelCount;
        public final byte[] data;
        public final int sampleRate;

        public AudioSamples(AudioRecord audioRecord, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioRecord, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = bArr;
        }

        public /* synthetic */ AudioSamples(AudioRecord audioRecord, byte[] bArr, AnonymousClass1 anonymousClass1) {
            this(audioRecord, bArr);
        }

        public int getAudioFormat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.audioFormat : invokeV.intValue;
        }

        public int getChannelCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.channelCount : invokeV.intValue;
        }

        public byte[] getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.data : (byte[]) invokeV.objValue;
        }

        public int getSampleRate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sampleRate : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    /* loaded from: classes9.dex */
    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-4968825, "Lorg/webrtc/voiceengine/WebRtcAudioRecord;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-4968825, "Lorg/webrtc/voiceengine/WebRtcAudioRecord;");
                return;
            }
        }
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        audioSource = defaultAudioSource;
    }

    public WebRtcAudioRecord(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioRecord = j;
        this.effects = WebRtcAudioEffects.create();
    }

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65547, null, z) == null) && !z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) ? i2 == 1 ? 16 : 12 : invokeI.intValue;
    }

    private boolean enableBuiltInAEC(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65549, this, z)) == null) {
            Logging.d(TAG, "enableBuiltInAEC(" + z + ')');
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects == null) {
                Logging.e(TAG, "Built-in AEC is not supported on this platform");
                return false;
            }
            return webRtcAudioEffects.setAEC(z);
        }
        return invokeZ.booleanValue;
    }

    private boolean enableBuiltInNS(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65550, this, z)) == null) {
            Logging.d(TAG, "enableBuiltInNS(" + z + ')');
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects == null) {
                Logging.e(TAG, "Built-in NS is not supported on this platform");
                return false;
            }
            return webRtcAudioEffects.setNS(z);
        }
        return invokeZ.booleanValue;
    }

    public static int getDefaultAudioSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    private int initRecording(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65552, this, i2, i3)) == null) {
            Logging.d(TAG, "initRecording(sampleRate=" + i2 + ", channels=" + i3 + SmallTailInfo.EMOTION_SUFFIX);
            if (this.audioRecord != null) {
                reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
                return -1;
            }
            int i4 = i2 / 100;
            this.byteBuffer = ByteBuffer.allocateDirect(i3 * 2 * i4);
            Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
            this.emptyBytes = new byte[this.byteBuffer.capacity()];
            nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
            int channelCountToConfiguration = channelCountToConfiguration(i3);
            int minBufferSize = AudioRecord.getMinBufferSize(i2, channelCountToConfiguration, 2);
            if (minBufferSize == -1 || minBufferSize == -2) {
                reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
                return -1;
            }
            Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
            int max = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
            Logging.d(TAG, "bufferSizeInBytes: " + max);
            try {
                AudioRecord audioRecord = new AudioRecord(audioSource, i2, channelCountToConfiguration, 2, max);
                this.audioRecord = audioRecord;
                if (audioRecord == null || audioRecord.getState() != 1) {
                    reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                    releaseAudioResources();
                    return -1;
                }
                WebRtcAudioEffects webRtcAudioEffects = this.effects;
                if (webRtcAudioEffects != null) {
                    webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
                }
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
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
        }
    }

    private void logMainParametersExtended() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        Logging.d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int i2, long j);

    private void releaseAudioResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(65558, this, str) == null) {
            Logging.e(TAG, "Run-time recording error: " + str);
            WebRtcAudioUtils.logAudioState(TAG);
            WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
            if (webRtcAudioRecordErrorCallback != null) {
                webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(str);
            }
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            Logging.e(TAG, "Init recording error: " + str);
            WebRtcAudioUtils.logAudioState(TAG);
            WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
            if (webRtcAudioRecordErrorCallback != null) {
                webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
            }
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, this, audioRecordStartErrorCode, str) == null) {
            Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
            WebRtcAudioUtils.logAudioState(TAG);
            WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
            if (webRtcAudioRecordErrorCallback != null) {
                webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
            }
        }
    }

    public static void setAudioSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65561, null, i2) == null) {
            synchronized (WebRtcAudioRecord.class) {
                Logging.w(TAG, "Audio source is changed from: " + audioSource + " to " + i2);
                audioSource = i2;
            }
        }
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, webRtcAudioRecordErrorCallback) == null) {
            Logging.d(TAG, "Set error callback");
            errorCallback = webRtcAudioRecordErrorCallback;
        }
    }

    public static void setMicrophoneMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65563, null, z) == null) {
            Logging.w(TAG, "setMicrophoneMute(" + z + SmallTailInfo.EMOTION_SUFFIX);
            microphoneMute = z;
        }
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback webRtcAudioRecordSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, webRtcAudioRecordSamplesReadyCallback) == null) {
            audioSamplesReadyCallback = webRtcAudioRecordSamplesReadyCallback;
        }
    }

    private boolean startRecording() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            Logging.d(TAG, LightappBusinessClient.MTD_START_AUDIO_RECORD);
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
                AudioRecordStartErrorCode audioRecordStartErrorCode = AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH;
                reportWebRtcAudioRecordStartError(audioRecordStartErrorCode, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
                return false;
            } catch (IllegalStateException e2) {
                AudioRecordStartErrorCode audioRecordStartErrorCode2 = AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION;
                reportWebRtcAudioRecordStartError(audioRecordStartErrorCode2, "AudioRecord.startRecording failed: " + e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean stopRecording() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            Logging.d(TAG, "stopRecording");
            assertTrue(this.audioThread != null);
            this.audioThread.stopThread();
            if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
                Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
                WebRtcAudioUtils.logAudioState(TAG);
            }
            this.audioThread = null;
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects != null) {
                webRtcAudioEffects.release();
            }
            releaseAudioResources();
            return true;
        }
        return invokeV.booleanValue;
    }
}
