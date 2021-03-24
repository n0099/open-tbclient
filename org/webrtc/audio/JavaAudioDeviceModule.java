package org.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.rtc.logreport.SLIReportInterface;
import org.webrtc.JniCommon;
import org.webrtc.Logging;
/* loaded from: classes7.dex */
public class JavaAudioDeviceModule implements AudioDeviceModule {
    public static final String TAG = "JavaAudioDeviceModule";
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

    /* loaded from: classes7.dex */
    public interface AudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    /* loaded from: classes7.dex */
    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    /* loaded from: classes7.dex */
    public static class AudioSamples {
        public final int audioFormat;
        public final int channelCount;
        public final byte[] data;
        public final int sampleRate;

        public AudioSamples(int i, int i2, int i3, byte[] bArr) {
            this.audioFormat = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.data = bArr;
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }
    }

    /* loaded from: classes7.dex */
    public interface AudioTrackErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str);
    }

    /* loaded from: classes7.dex */
    public enum AudioTrackStartErrorCode {
        AUDIO_TRACK_START_EXCEPTION,
        AUDIO_TRACK_START_STATE_MISMATCH
    }

    /* loaded from: classes7.dex */
    public static class Builder {
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
            this.audioSource = 7;
            this.useHardwareAcousticEchoCanceler = JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
            this.useHardwareNoiseSuppressor = JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
            this.context = context;
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.audioManager = audioManager;
            this.sampleRate = WebRtcAudioManager.getSampleRate(audioManager);
        }

        public AudioDeviceModule createAudioDeviceModule() {
            String str;
            String str2;
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
            return new JavaAudioDeviceModule(this.context, this.audioManager, new WebRtcAudioRecord(this.context, this.audioManager, this.audioSource, this.externalRecord, this.audioRecordErrorCallback, this.samplesReadyCallback, this.useHardwareAcousticEchoCanceler, this.useHardwareNoiseSuppressor), new WebRtcAudioTrack(this.context, this.audioManager, this.remoteSamplesReadyCallback, this.audioTrackErrorCallback), this.sampleRate, this.useStereoInput, this.useStereoOutput);
        }

        public Builder setAudioRecordErrorCallback(AudioRecordErrorCallback audioRecordErrorCallback) {
            this.audioRecordErrorCallback = audioRecordErrorCallback;
            return this;
        }

        public Builder setAudioSource(int i) {
            this.audioSource = i;
            return this;
        }

        public Builder setAudioTrackErrorCallback(AudioTrackErrorCallback audioTrackErrorCallback) {
            this.audioTrackErrorCallback = audioTrackErrorCallback;
            return this;
        }

        public Builder setExternalAudioRecord(boolean z) {
            this.externalRecord = z;
            return this;
        }

        public Builder setRemoteSamplesReadyCallback(RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
            this.remoteSamplesReadyCallback = remoteSamplesReadyCallback;
            return this;
        }

        public Builder setSampleRate(int i) {
            Logging.d(JavaAudioDeviceModule.TAG, "Sample rate overridden to: " + i);
            this.sampleRate = i;
            return this;
        }

        public Builder setSamplesReadyCallback(SamplesReadyCallback samplesReadyCallback) {
            this.samplesReadyCallback = samplesReadyCallback;
            return this;
        }

        public Builder setUseHardwareAcousticEchoCanceler(boolean z) {
            if (z && !JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                Logging.e(JavaAudioDeviceModule.TAG, "HW AEC not supported");
                z = false;
            }
            this.useHardwareAcousticEchoCanceler = z;
            return this;
        }

        public Builder setUseHardwareNoiseSuppressor(boolean z) {
            if (z && !JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                Logging.e(JavaAudioDeviceModule.TAG, "HW NS not supported");
                z = false;
            }
            this.useHardwareNoiseSuppressor = z;
            return this;
        }

        public Builder setUseStereoInput(boolean z) {
            this.useStereoInput = z;
            return this;
        }

        public Builder setUseStereoOutput(boolean z) {
            this.useStereoOutput = z;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public interface ExternalSamplesReadyCallback {
        void onWebRtcAudioExternalSamplesReady(AudioSamples audioSamples);
    }

    /* loaded from: classes7.dex */
    public interface RemoteSamplesReadyCallback {
        void onWebRtcAudioRemoteSamplesReady(AudioSamples audioSamples);
    }

    /* loaded from: classes7.dex */
    public interface SamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    public JavaAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i, boolean z, boolean z2) {
        this.nativeLock = new Object();
        this.stuckEvent = null;
        this.context = context;
        this.audioManager = audioManager;
        this.audioInput = webRtcAudioRecord;
        this.audioOutput = webRtcAudioTrack;
        this.sampleRate = i;
        this.useStereoInput = z;
        this.useStereoOutput = z2;
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static boolean isBuiltInAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.isAcousticEchoCancelerSupported();
    }

    public static boolean isBuiltInNoiseSuppressorSupported() {
        return WebRtcAudioEffects.isNoiseSuppressorSupported();
    }

    public static native long nativeCreateAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i, boolean z, boolean z2);

    public ExternalSamplesReadyCallback getExternalSamplesReadyCallback() {
        return this.audioInput.getExternalSamplesCallback();
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public long getNativeAudioDeviceModulePointer() {
        long j;
        synchronized (this.nativeLock) {
            if (this.nativeAudioDeviceModule == 0) {
                this.nativeAudioDeviceModule = nativeCreateAudioDeviceModule(this.context, this.audioManager, this.audioInput, this.audioOutput, this.sampleRate, this.useStereoInput, this.useStereoOutput);
            }
            j = this.nativeAudioDeviceModule;
        }
        return j;
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void release() {
        synchronized (this.nativeLock) {
            if (this.nativeAudioDeviceModule != 0) {
                JniCommon.nativeReleaseRef(this.nativeAudioDeviceModule);
                this.nativeAudioDeviceModule = 0L;
            }
        }
    }

    public void setEnableSLIReport(boolean z) {
        this.audioOutput.setEnableSLIReport(z);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setMicrophoneMute(boolean z) {
        Logging.d(TAG, "setMicrophoneMute: " + z);
        this.audioInput.setMicrophoneMute(z);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setSpeakerMute(boolean z) {
        Logging.d(TAG, "setSpeakerMute: " + z);
        this.audioOutput.setSpeakerMute(z);
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        this.stuckEvent = sLIReportInterface;
        WebRtcAudioTrack webRtcAudioTrack = this.audioOutput;
        if (webRtcAudioTrack != null) {
            webRtcAudioTrack.setStuckEventListener(sLIReportInterface);
        }
    }
}
