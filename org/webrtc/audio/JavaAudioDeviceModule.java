package org.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.JniCommon;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public class JavaAudioDeviceModule implements AudioDeviceModule {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "JavaAudioDeviceModule";
    public transient /* synthetic */ FieldHolder $fh;
    public final WebRtcAudioRecord audioInput;
    public final AudioManager audioManager;
    public final WebRtcAudioTrack audioOutput;
    public final Context context;
    public long nativeAudioDeviceModule;
    public final Object nativeLock;
    public final int sampleRate;
    public SLIReportInterface stuckEvent;
    public final boolean useStereoInput;
    public final boolean useStereoOutput;

    /* renamed from: org.webrtc.audio.JavaAudioDeviceModule$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public interface AudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class AudioRecordStartErrorCode {
        public static final /* synthetic */ AudioRecordStartErrorCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AudioRecordStartErrorCode AUDIO_RECORD_START_EXCEPTION;
        public static final AudioRecordStartErrorCode AUDIO_RECORD_START_STATE_MISMATCH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-661959565, "Lorg/webrtc/audio/JavaAudioDeviceModule$AudioRecordStartErrorCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-661959565, "Lorg/webrtc/audio/JavaAudioDeviceModule$AudioRecordStartErrorCode;");
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

    /* loaded from: classes2.dex */
    public static class AudioSamples {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int audioFormat;
        public final int channelCount;
        public final byte[] data;
        public final int sampleRate;

        public AudioSamples(int i2, int i3, int i4, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.audioFormat = i2;
            this.channelCount = i3;
            this.sampleRate = i4;
            this.data = bArr;
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

    /* loaded from: classes2.dex */
    public interface AudioTrackErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class AudioTrackStartErrorCode {
        public static final /* synthetic */ AudioTrackStartErrorCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AudioTrackStartErrorCode AUDIO_TRACK_START_EXCEPTION;
        public static final AudioTrackStartErrorCode AUDIO_TRACK_START_STATE_MISMATCH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1922587583, "Lorg/webrtc/audio/JavaAudioDeviceModule$AudioTrackStartErrorCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1922587583, "Lorg/webrtc/audio/JavaAudioDeviceModule$AudioTrackStartErrorCode;");
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

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int audioContentType;
        public final AudioManager audioManager;
        public AudioRecordErrorCallback audioRecordErrorCallback;
        public int audioSource;
        public AudioTrackErrorCallback audioTrackErrorCallback;
        public final Context context;
        public boolean externalRecord;
        public RemoteSamplesReadyCallback remoteSamplesReadyCallback;
        public int sampleRate;
        public SamplesReadyCallback samplesReadyCallback;
        public boolean useHardwareAcousticEchoCanceler;
        public boolean useHardwareNoiseSuppressor;
        public boolean useStereoInput;
        public boolean useStereoOutput;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.audioSource = 7;
            this.useHardwareAcousticEchoCanceler = JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
            this.useHardwareNoiseSuppressor = JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
            this.context = context;
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.audioManager = audioManager;
            this.sampleRate = WebRtcAudioManager.getSampleRate(audioManager);
        }

        public /* synthetic */ Builder(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        public AudioDeviceModule createAudioDeviceModule() {
            InterceptResult invokeV;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Logging.d(JavaAudioDeviceModule.TAG, "createAudioDeviceModule");
                if (this.useHardwareNoiseSuppressor) {
                    str = "HW NS will be used.";
                } else {
                    if (JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                        Logging.d(JavaAudioDeviceModule.TAG, "Overriding default behavior; now using WebRTC NS!");
                    }
                    str = "HW NS will not be used.";
                }
                Logging.d(JavaAudioDeviceModule.TAG, str);
                if (this.useHardwareAcousticEchoCanceler) {
                    str2 = "HW AEC will be used.";
                } else {
                    if (JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                        Logging.d(JavaAudioDeviceModule.TAG, "Overriding default behavior; now using WebRTC AEC!");
                    }
                    str2 = "HW AEC will not be used.";
                }
                Logging.d(JavaAudioDeviceModule.TAG, str2);
                return new JavaAudioDeviceModule(this.context, this.audioManager, new WebRtcAudioRecord(this.context, this.audioManager, this.audioSource, this.externalRecord, this.audioRecordErrorCallback, this.samplesReadyCallback, this.useHardwareAcousticEchoCanceler, this.useHardwareNoiseSuppressor), new WebRtcAudioTrack(this.context, this.audioManager, this.audioContentType, this.remoteSamplesReadyCallback, this.audioTrackErrorCallback), this.sampleRate, this.useStereoInput, this.useStereoOutput, null);
            }
            return (AudioDeviceModule) invokeV.objValue;
        }

        public Builder setAudioContentType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.audioContentType = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setAudioRecordErrorCallback(AudioRecordErrorCallback audioRecordErrorCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, audioRecordErrorCallback)) == null) {
                this.audioRecordErrorCallback = audioRecordErrorCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAudioSource(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.audioSource = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setAudioTrackErrorCallback(AudioTrackErrorCallback audioTrackErrorCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, audioTrackErrorCallback)) == null) {
                this.audioTrackErrorCallback = audioTrackErrorCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExternalAudioRecord(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.externalRecord = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setRemoteSamplesReadyCallback(RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, remoteSamplesReadyCallback)) == null) {
                this.remoteSamplesReadyCallback = remoteSamplesReadyCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSampleRate(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                Logging.d(JavaAudioDeviceModule.TAG, "Sample rate overridden to: " + i2);
                this.sampleRate = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSamplesReadyCallback(SamplesReadyCallback samplesReadyCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, samplesReadyCallback)) == null) {
                this.samplesReadyCallback = samplesReadyCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setUseHardwareAcousticEchoCanceler(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                if (z && !JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                    Logging.e(JavaAudioDeviceModule.TAG, "HW AEC not supported");
                    z = false;
                }
                this.useHardwareAcousticEchoCanceler = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUseHardwareNoiseSuppressor(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                if (z && !JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                    Logging.e(JavaAudioDeviceModule.TAG, "HW NS not supported");
                    z = false;
                }
                this.useHardwareNoiseSuppressor = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUseStereoInput(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.useStereoInput = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUseStereoOutput(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.useStereoOutput = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface ExternalSamplesReadyCallback {
        void onWebRtcAudioExternalSamplesReady(AudioSamples audioSamples);
    }

    /* loaded from: classes2.dex */
    public interface RemoteSamplesReadyCallback {
        void onWebRtcAudioRemoteSamplesReady(AudioSamples audioSamples);
    }

    /* loaded from: classes2.dex */
    public interface SamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    public JavaAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, audioManager, webRtcAudioRecord, webRtcAudioTrack, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nativeLock = new Object();
        this.stuckEvent = null;
        this.context = context;
        this.audioManager = audioManager;
        this.audioInput = webRtcAudioRecord;
        this.audioOutput = webRtcAudioTrack;
        this.sampleRate = i2;
        this.useStereoInput = z;
        this.useStereoOutput = z2;
    }

    public /* synthetic */ JavaAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i2, boolean z, boolean z2, AnonymousClass1 anonymousClass1) {
        this(context, audioManager, webRtcAudioRecord, webRtcAudioTrack, i2, z, z2);
    }

    public static Builder builder(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Builder(context, null) : (Builder) invokeL.objValue;
    }

    public static boolean isBuiltInAcousticEchoCancelerSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? WebRtcAudioEffects.isAcousticEchoCancelerSupported() : invokeV.booleanValue;
    }

    public static boolean isBuiltInNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? WebRtcAudioEffects.isNoiseSuppressorSupported() : invokeV.booleanValue;
    }

    public static native long nativeCreateAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i2, boolean z, boolean z2);

    public ExternalSamplesReadyCallback getExternalSamplesReadyCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.audioInput.getExternalSamplesCallback() : (ExternalSamplesReadyCallback) invokeV.objValue;
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public long getNativeAudioDeviceModulePointer() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.nativeLock) {
                if (this.nativeAudioDeviceModule == 0) {
                    this.nativeAudioDeviceModule = nativeCreateAudioDeviceModule(this.context, this.audioManager, this.audioInput, this.audioOutput, this.sampleRate, this.useStereoInput, this.useStereoOutput);
                }
                j2 = this.nativeAudioDeviceModule;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.nativeLock) {
                if (this.nativeAudioDeviceModule != 0) {
                    JniCommon.nativeReleaseRef(this.nativeAudioDeviceModule);
                    this.nativeAudioDeviceModule = 0L;
                }
            }
        }
    }

    public void setEnableSLIReport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.audioOutput.setEnableSLIReport(z);
        }
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setMicrophoneMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            Logging.d(TAG, "setMicrophoneMute: " + z);
            this.audioInput.setMicrophoneMute(z);
        }
    }

    public void setRemoteSamplesReadyCallback(RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
        WebRtcAudioTrack webRtcAudioTrack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, remoteSamplesReadyCallback) == null) || (webRtcAudioTrack = this.audioOutput) == null) {
            return;
        }
        webRtcAudioTrack.setRemoteSamplesReadyCallback(remoteSamplesReadyCallback);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setSpeakerMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            Logging.d(TAG, "setSpeakerMute: " + z);
            this.audioOutput.setSpeakerMute(z);
        }
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sLIReportInterface) == null) {
            this.stuckEvent = sLIReportInterface;
            WebRtcAudioTrack webRtcAudioTrack = this.audioOutput;
            if (webRtcAudioTrack != null) {
                webRtcAudioTrack.setStuckEventListener(sLIReportInterface);
            }
        }
    }
}
