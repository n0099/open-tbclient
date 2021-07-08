package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
/* loaded from: classes9.dex */
public class WebRtcAudioTrack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    public static final int BITS_PER_SAMPLE = 16;
    public static final int BUFFERS_PER_SECOND = 100;
    public static final int CALLBACK_BUFFER_SIZE_MS = 10;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_USAGE;
    public static final String TAG = "WebRtcAudioTrack";
    @Nullable
    public static ErrorCallback errorCallback;
    @Nullable
    public static WebRtcAudioTrackErrorCallback errorCallbackOld;
    public static volatile boolean speakerMute;
    public static int usageAttribute;
    public transient /* synthetic */ FieldHolder $fh;
    public final AudioManager audioManager;
    @Nullable
    public AudioTrackThread audioThread;
    @Nullable
    public AudioTrack audioTrack;
    public ByteBuffer byteBuffer;
    public byte[] emptyBytes;
    public final long nativeAudioTrack;
    public final ThreadUtils.ThreadChecker threadChecker;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class AudioTrackStartErrorCode {
        public static final /* synthetic */ AudioTrackStartErrorCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AudioTrackStartErrorCode AUDIO_TRACK_START_EXCEPTION;
        public static final AudioTrackStartErrorCode AUDIO_TRACK_START_STATE_MISMATCH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(465429559, "Lorg/webrtc/voiceengine/WebRtcAudioTrack$AudioTrackStartErrorCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(465429559, "Lorg/webrtc/voiceengine/WebRtcAudioTrack$AudioTrackStartErrorCode;");
                    return;
                }
            }
            AUDIO_TRACK_START_EXCEPTION = new AudioTrackStartErrorCode("AUDIO_TRACK_START_EXCEPTION", 0);
            AudioTrackStartErrorCode audioTrackStartErrorCode = new AudioTrackStartErrorCode("AUDIO_TRACK_START_STATE_MISMATCH", 1);
            AUDIO_TRACK_START_STATE_MISMATCH = audioTrackStartErrorCode;
            $VALUES = new AudioTrackStartErrorCode[]{AUDIO_TRACK_START_EXCEPTION, audioTrackStartErrorCode};
        }

        public AudioTrackStartErrorCode(String str, int i2) {
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

        public static AudioTrackStartErrorCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AudioTrackStartErrorCode) Enum.valueOf(AudioTrackStartErrorCode.class, str) : (AudioTrackStartErrorCode) invokeL.objValue;
        }

        public static AudioTrackStartErrorCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AudioTrackStartErrorCode[]) $VALUES.clone() : (AudioTrackStartErrorCode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class AudioTrackThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean keepAlive;
        public final /* synthetic */ WebRtcAudioTrack this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioTrackThread(WebRtcAudioTrack webRtcAudioTrack, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webRtcAudioTrack, str};
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
            this.this$0 = webRtcAudioTrack;
            this.keepAlive = true;
        }

        private int writeBytes(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, this, audioTrack, byteBuffer, i2)) == null) ? Build.VERSION.SDK_INT >= 21 ? audioTrack.write(byteBuffer, i2, 0) : audioTrack.write(byteBuffer.array(), byteBuffer.arrayOffset(), i2) : invokeLLI.intValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                Logging.d(WebRtcAudioTrack.TAG, "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
                WebRtcAudioTrack.assertTrue(this.this$0.audioTrack.getPlayState() == 3);
                int capacity = this.this$0.byteBuffer.capacity();
                while (this.keepAlive) {
                    WebRtcAudioTrack webRtcAudioTrack = this.this$0;
                    webRtcAudioTrack.nativeGetPlayoutData(capacity, webRtcAudioTrack.nativeAudioTrack);
                    WebRtcAudioTrack.assertTrue(capacity <= this.this$0.byteBuffer.remaining());
                    if (WebRtcAudioTrack.speakerMute) {
                        this.this$0.byteBuffer.clear();
                        this.this$0.byteBuffer.put(this.this$0.emptyBytes);
                        this.this$0.byteBuffer.position(0);
                    }
                    int writeBytes = writeBytes(this.this$0.audioTrack, this.this$0.byteBuffer, capacity);
                    if (writeBytes != capacity) {
                        Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.write played invalid number of bytes: " + writeBytes);
                        if (writeBytes < 0) {
                            this.keepAlive = false;
                            WebRtcAudioTrack webRtcAudioTrack2 = this.this$0;
                            webRtcAudioTrack2.reportWebRtcAudioTrackError("AudioTrack.write failed: " + writeBytes);
                        }
                    }
                    this.this$0.byteBuffer.rewind();
                }
                if (this.this$0.audioTrack != null) {
                    Logging.d(WebRtcAudioTrack.TAG, "Calling AudioTrack.stop...");
                    try {
                        this.this$0.audioTrack.stop();
                        Logging.d(WebRtcAudioTrack.TAG, "AudioTrack.stop is done.");
                    } catch (IllegalStateException e2) {
                        Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.stop failed: " + e2.getMessage());
                    }
                }
            }
        }

        public void stopThread() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Logging.d(WebRtcAudioTrack.TAG, "stopThread");
                this.keepAlive = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface ErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str);
    }

    @Deprecated
    /* loaded from: classes9.dex */
    public interface WebRtcAudioTrackErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1454988237, "Lorg/webrtc/voiceengine/WebRtcAudioTrack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1454988237, "Lorg/webrtc/voiceengine/WebRtcAudioTrack;");
                return;
            }
        }
        int defaultUsageAttribute = getDefaultUsageAttribute();
        DEFAULT_USAGE = defaultUsageAttribute;
        usageAttribute = defaultUsageAttribute;
    }

    public WebRtcAudioTrack(long j) {
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
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioTrack = j;
        this.audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65546, null, z) == null) && !z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) ? i2 == 1 ? 4 : 12 : invokeI.intValue;
    }

    @TargetApi(21)
    public static AudioTrack createAudioTrackOnLollipopOrHigher(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65548, null, i2, i3, i4)) == null) {
            Logging.d(TAG, "createAudioTrackOnLollipopOrHigher");
            int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(0);
            Logging.d(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate);
            if (i2 != nativeOutputSampleRate) {
                Logging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
            }
            if (usageAttribute != DEFAULT_USAGE) {
                Logging.w(TAG, "A non default usage attribute is used: " + usageAttribute);
            }
            return new AudioTrack(new AudioAttributes.Builder().setUsage(usageAttribute).setContentType(1).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(i2).setChannelMask(i3).build(), i4, 1, 0);
        }
        return (AudioTrack) invokeIII.objValue;
    }

    public static AudioTrack createAudioTrackOnLowerThanLollipop(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65549, null, i2, i3, i4)) == null) ? new AudioTrack(0, i2, i3, 2, i4, 1) : (AudioTrack) invokeIII.objValue;
    }

    public static int getDefaultUsageAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? Build.VERSION.SDK_INT >= 21 ? 2 : 0 : invokeV.intValue;
    }

    private int getStreamMaxVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "getStreamMaxVolume");
            assertTrue(this.audioManager != null);
            return this.audioManager.getStreamMaxVolume(0);
        }
        return invokeV.intValue;
    }

    private int getStreamVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "getStreamVolume");
            assertTrue(this.audioManager != null);
            return this.audioManager.getStreamVolume(0);
        }
        return invokeV.intValue;
    }

    private boolean initPlayout(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65553, this, i2, i3)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "initPlayout(sampleRate=" + i2 + ", channels=" + i3 + SmallTailInfo.EMOTION_SUFFIX);
            this.byteBuffer = ByteBuffer.allocateDirect(i3 * 2 * (i2 / 100));
            StringBuilder sb = new StringBuilder();
            sb.append("byteBuffer.capacity: ");
            sb.append(this.byteBuffer.capacity());
            Logging.d(TAG, sb.toString());
            this.emptyBytes = new byte[this.byteBuffer.capacity()];
            nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
            int channelCountToConfiguration = channelCountToConfiguration(i3);
            int minBufferSize = AudioTrack.getMinBufferSize(i2, channelCountToConfiguration, 2);
            Logging.d(TAG, "AudioTrack.getMinBufferSize: " + minBufferSize);
            if (minBufferSize < this.byteBuffer.capacity()) {
                reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
                return false;
            } else if (this.audioTrack != null) {
                reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
                return false;
            } else {
                try {
                    this.audioTrack = Build.VERSION.SDK_INT >= 21 ? createAudioTrackOnLollipopOrHigher(i2, channelCountToConfiguration, minBufferSize) : createAudioTrackOnLowerThanLollipop(i2, channelCountToConfiguration, minBufferSize);
                    AudioTrack audioTrack = this.audioTrack;
                    if (audioTrack == null || audioTrack.getState() != 1) {
                        reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                        releaseAudioResources();
                        return false;
                    }
                    logMainParameters();
                    logMainParametersExtended();
                    return true;
                } catch (IllegalArgumentException e2) {
                    reportWebRtcAudioTrackInitError(e2.getMessage());
                    releaseAudioResources();
                    return false;
                }
            }
        }
        return invokeII.booleanValue;
    }

    private boolean isVolumeFixed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            return this.audioManager.isVolumeFixed();
        }
        return invokeV.booleanValue;
    }

    private void logBufferCapacityInFrames() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        Logging.d(TAG, "AudioTrack: buffer capacity in frames: " + this.audioTrack.getBufferCapacityInFrames());
    }

    private void logBufferSizeInFrames() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        Logging.d(TAG, "AudioTrack: buffer size in frames: " + this.audioTrack.getBufferSizeInFrames());
    }

    private void logMainParameters() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            Logging.d(TAG, "AudioTrack: session ID: " + this.audioTrack.getAudioSessionId() + ", channels: " + this.audioTrack.getChannelCount() + ", sample rate: " + this.audioTrack.getSampleRate() + ", max gain: " + AudioTrack.getMaxVolume());
        }
    }

    private void logMainParametersExtended() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            logBufferSizeInFrames();
            logBufferCapacityInFrames();
        }
    }

    private void logUnderrunCount() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        Logging.d(TAG, "underrun count: " + this.audioTrack.getUnderrunCount());
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeGetPlayoutData(int i2, long j);

    private void releaseAudioResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            Logging.d(TAG, "releaseAudioResources");
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack != null) {
                audioTrack.release();
                this.audioTrack = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioTrackError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, str) == null) {
            Logging.e(TAG, "Run-time playback error: " + str);
            WebRtcAudioUtils.logAudioState(TAG);
            WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
            if (webRtcAudioTrackErrorCallback != null) {
                webRtcAudioTrackErrorCallback.onWebRtcAudioTrackError(str);
            }
            ErrorCallback errorCallback2 = errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onWebRtcAudioTrackError(str);
            }
        }
    }

    private void reportWebRtcAudioTrackInitError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            Logging.e(TAG, "Init playout error: " + str);
            WebRtcAudioUtils.logAudioState(TAG);
            WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
            if (webRtcAudioTrackErrorCallback != null) {
                webRtcAudioTrackErrorCallback.onWebRtcAudioTrackInitError(str);
            }
            ErrorCallback errorCallback2 = errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onWebRtcAudioTrackInitError(str);
            }
        }
    }

    private void reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, this, audioTrackStartErrorCode, str) == null) {
            Logging.e(TAG, "Start playout error: " + audioTrackStartErrorCode + ". " + str);
            WebRtcAudioUtils.logAudioState(TAG);
            WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
            if (webRtcAudioTrackErrorCallback != null) {
                webRtcAudioTrackErrorCallback.onWebRtcAudioTrackStartError(str);
            }
            ErrorCallback errorCallback2 = errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onWebRtcAudioTrackStartError(audioTrackStartErrorCode, str);
            }
        }
    }

    public static void setAudioTrackUsageAttribute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65566, null, i2) == null) {
            synchronized (WebRtcAudioTrack.class) {
                Logging.w(TAG, "Default usage attribute is changed from: " + DEFAULT_USAGE + " to " + i2);
                usageAttribute = i2;
            }
        }
    }

    public static void setErrorCallback(ErrorCallback errorCallback2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, errorCallback2) == null) {
            Logging.d(TAG, "Set extended error callback");
            errorCallback = errorCallback2;
        }
    }

    @Deprecated
    public static void setErrorCallback(WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, webRtcAudioTrackErrorCallback) == null) {
            Logging.d(TAG, "Set error callback (deprecated");
            errorCallbackOld = webRtcAudioTrackErrorCallback;
        }
    }

    public static void setSpeakerMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65569, null, z) == null) {
            Logging.w(TAG, "setSpeakerMute(" + z + SmallTailInfo.EMOTION_SUFFIX);
            speakerMute = z;
        }
    }

    private boolean setStreamVolume(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65570, this, i2)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "setStreamVolume(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            assertTrue(this.audioManager != null);
            if (isVolumeFixed()) {
                Logging.e(TAG, "The device implements a fixed volume policy.");
                return false;
            }
            this.audioManager.setStreamVolume(0, i2, 0);
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean startPlayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "startPlayout");
            assertTrue(this.audioTrack != null);
            assertTrue(this.audioThread == null);
            try {
                this.audioTrack.play();
            } catch (IllegalStateException e2) {
                AudioTrackStartErrorCode audioTrackStartErrorCode = AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION;
                reportWebRtcAudioTrackStartError(audioTrackStartErrorCode, "AudioTrack.play failed: " + e2.getMessage());
            }
            if (this.audioTrack.getPlayState() == 3) {
                AudioTrackThread audioTrackThread = new AudioTrackThread(this, "AudioTrackJavaThread");
                this.audioThread = audioTrackThread;
                audioTrackThread.start();
                return true;
            }
            AudioTrackStartErrorCode audioTrackStartErrorCode2 = AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH;
            reportWebRtcAudioTrackStartError(audioTrackStartErrorCode2, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
            releaseAudioResources();
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean stopPlayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "stopPlayout");
            assertTrue(this.audioThread != null);
            logUnderrunCount();
            this.audioThread.stopThread();
            Logging.d(TAG, "Stopping the AudioTrackThread...");
            this.audioThread.interrupt();
            if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
                Logging.e(TAG, "Join of AudioTrackThread timed out.");
                WebRtcAudioUtils.logAudioState(TAG);
            }
            Logging.d(TAG, "AudioTrackThread has now been stopped.");
            this.audioThread = null;
            releaseAudioResources();
            return true;
        }
        return invokeV.booleanValue;
    }
}
