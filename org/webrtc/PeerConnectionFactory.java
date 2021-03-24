package org.webrtc;

import android.content.Context;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.Logging;
import org.webrtc.NativeLibrary;
import org.webrtc.PeerConnection;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.LegacyAudioDeviceModule;
/* loaded from: classes.dex */
public class PeerConnectionFactory {
    public static final String TAG = "PeerConnectionFactory";
    public static final String TRIAL_ENABLED = "Enabled";
    public static final String VIDEO_CAPTURER_THREAD_NAME = "VideoCapturerThread";
    @Deprecated
    public static final String VIDEO_FRAME_EMIT_TRIAL = "VideoFrameEmit";
    public static volatile boolean internalTracerInitialized;
    @Nullable
    public static Thread networkThread;
    @Nullable
    public static Thread signalingThread;
    @Nullable
    public static Thread workerThread;
    public long nativeFactory;

    /* loaded from: classes.dex */
    public static class Builder {
        public AudioDecoderFactoryFactory audioDecoderFactoryFactory;
        @Nullable
        public AudioDeviceModule audioDeviceModule;
        public AudioEncoderFactoryFactory audioEncoderFactoryFactory;
        @Nullable
        public AudioProcessingFactory audioProcessingFactory;
        @Nullable
        public FecControllerFactoryFactoryInterface fecControllerFactoryFactory;
        @Nullable
        public MediaTransportFactoryFactory mediaTransportFactoryFactory;
        @Nullable
        public Options options;
        @Nullable
        public VideoDecoderFactory videoDecoderFactory;
        @Nullable
        public VideoEncoderFactory videoEncoderFactory;

        public Builder() {
            this.audioDeviceModule = new LegacyAudioDeviceModule();
            this.audioEncoderFactoryFactory = new BuiltinAudioEncoderFactoryFactory();
            this.audioDecoderFactoryFactory = new BuiltinAudioDecoderFactoryFactory();
        }

        public PeerConnectionFactory createPeerConnectionFactory() {
            return new PeerConnectionFactory(this.options, this.audioDeviceModule, this.audioEncoderFactoryFactory, this.audioDecoderFactoryFactory, this.videoEncoderFactory, this.videoDecoderFactory, this.audioProcessingFactory, this.fecControllerFactoryFactory, this.mediaTransportFactoryFactory);
        }

        public Builder setAudioDecoderFactoryFactory(AudioDecoderFactoryFactory audioDecoderFactoryFactory) {
            if (audioDecoderFactoryFactory != null) {
                this.audioDecoderFactoryFactory = audioDecoderFactoryFactory;
                return this;
            }
            throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioDecoderFactoryFactory.");
        }

        public Builder setAudioDeviceModule(AudioDeviceModule audioDeviceModule) {
            this.audioDeviceModule = audioDeviceModule;
            return this;
        }

        public Builder setAudioEncoderFactoryFactory(AudioEncoderFactoryFactory audioEncoderFactoryFactory) {
            if (audioEncoderFactoryFactory != null) {
                this.audioEncoderFactoryFactory = audioEncoderFactoryFactory;
                return this;
            }
            throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioEncoderFactoryFactory.");
        }

        public Builder setAudioProcessingFactory(AudioProcessingFactory audioProcessingFactory) {
            if (audioProcessingFactory != null) {
                this.audioProcessingFactory = audioProcessingFactory;
                return this;
            }
            throw new NullPointerException("PeerConnectionFactory builder does not accept a null AudioProcessingFactory.");
        }

        public Builder setFecControllerFactoryFactoryInterface(FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface) {
            this.fecControllerFactoryFactory = fecControllerFactoryFactoryInterface;
            return this;
        }

        public Builder setMediaTransportFactoryFactory(MediaTransportFactoryFactory mediaTransportFactoryFactory) {
            this.mediaTransportFactoryFactory = mediaTransportFactoryFactory;
            return this;
        }

        public Builder setOptions(Options options) {
            this.options = options;
            return this;
        }

        public Builder setVideoDecoderFactory(VideoDecoderFactory videoDecoderFactory) {
            this.videoDecoderFactory = videoDecoderFactory;
            return this;
        }

        public Builder setVideoEncoderFactory(VideoEncoderFactory videoEncoderFactory) {
            this.videoEncoderFactory = videoEncoderFactory;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class InitializationOptions {
        public final Context applicationContext;
        public final boolean enableInternalTracer;
        public final String fieldTrials;
        @Nullable
        public Loggable loggable;
        @Nullable
        public Logging.Severity loggableSeverity;
        public final NativeLibraryLoader nativeLibraryLoader;
        public final String nativeLibraryName;

        /* loaded from: classes.dex */
        public static class Builder {
            public final Context applicationContext;
            public boolean enableInternalTracer;
            @Nullable
            public Loggable loggable;
            @Nullable
            public Logging.Severity loggableSeverity;
            public String fieldTrials = "";
            public NativeLibraryLoader nativeLibraryLoader = new NativeLibrary.DefaultLoader();
            public String nativeLibraryName = "jingle_peerconnection_so";

            public Builder(Context context) {
                this.applicationContext = context;
            }

            public InitializationOptions createInitializationOptions() {
                return new InitializationOptions(this.applicationContext, this.fieldTrials, this.enableInternalTracer, this.nativeLibraryLoader, this.nativeLibraryName, this.loggable, this.loggableSeverity);
            }

            public Builder setEnableInternalTracer(boolean z) {
                this.enableInternalTracer = z;
                return this;
            }

            public Builder setFieldTrials(String str) {
                this.fieldTrials = str;
                return this;
            }

            public Builder setInjectableLogger(Loggable loggable, Logging.Severity severity) {
                this.loggable = loggable;
                this.loggableSeverity = severity;
                return this;
            }

            public Builder setNativeLibraryLoader(NativeLibraryLoader nativeLibraryLoader) {
                this.nativeLibraryLoader = nativeLibraryLoader;
                return this;
            }

            public Builder setNativeLibraryName(String str) {
                this.nativeLibraryName = str;
                return this;
            }
        }

        public InitializationOptions(Context context, String str, boolean z, NativeLibraryLoader nativeLibraryLoader, String str2, @Nullable Loggable loggable, @Nullable Logging.Severity severity) {
            this.applicationContext = context;
            this.fieldTrials = str;
            this.enableInternalTracer = z;
            this.nativeLibraryLoader = nativeLibraryLoader;
            this.nativeLibraryName = str2;
            this.loggable = loggable;
            this.loggableSeverity = severity;
        }

        public static Builder builder(Context context) {
            return new Builder(context);
        }
    }

    /* loaded from: classes7.dex */
    public static class Options {
        public static final int ADAPTER_TYPE_ANY = 32;
        public static final int ADAPTER_TYPE_CELLULAR = 4;
        public static final int ADAPTER_TYPE_ETHERNET = 1;
        public static final int ADAPTER_TYPE_LOOPBACK = 16;
        public static final int ADAPTER_TYPE_UNKNOWN = 0;
        public static final int ADAPTER_TYPE_VPN = 8;
        public static final int ADAPTER_TYPE_WIFI = 2;
        public boolean disableEncryption;
        public boolean disableNetworkMonitor;
        public int networkIgnoreMask;

        @CalledByNative("Options")
        public boolean getDisableEncryption() {
            return this.disableEncryption;
        }

        @CalledByNative("Options")
        public boolean getDisableNetworkMonitor() {
            return this.disableNetworkMonitor;
        }

        @CalledByNative("Options")
        public int getNetworkIgnoreMask() {
            return this.networkIgnoreMask;
        }
    }

    @CalledByNative
    public PeerConnectionFactory(long j) {
        checkInitializeHasBeenCalled();
        if (j == 0) {
            throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
        }
        this.nativeFactory = j;
    }

    public PeerConnectionFactory(Options options, @Nullable AudioDeviceModule audioDeviceModule, AudioEncoderFactoryFactory audioEncoderFactoryFactory, AudioDecoderFactoryFactory audioDecoderFactoryFactory, @Nullable VideoEncoderFactory videoEncoderFactory, @Nullable VideoDecoderFactory videoDecoderFactory, @Nullable AudioProcessingFactory audioProcessingFactory, @Nullable FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface, @Nullable MediaTransportFactoryFactory mediaTransportFactoryFactory) {
        checkInitializeHasBeenCalled();
        long nativeCreatePeerConnectionFactory = nativeCreatePeerConnectionFactory(ContextUtils.getApplicationContext(), options, audioDeviceModule == null ? 0L : audioDeviceModule.getNativeAudioDeviceModulePointer(), audioEncoderFactoryFactory.createNativeAudioEncoderFactory(), audioDecoderFactoryFactory.createNativeAudioDecoderFactory(), videoEncoderFactory, videoDecoderFactory, audioProcessingFactory == null ? 0L : audioProcessingFactory.createNative(), fecControllerFactoryFactoryInterface == null ? 0L : fecControllerFactoryFactoryInterface.createNative(), mediaTransportFactoryFactory == null ? 0L : mediaTransportFactoryFactory.createNativeMediaTransportFactory());
        this.nativeFactory = nativeCreatePeerConnectionFactory;
        if (nativeCreatePeerConnectionFactory == 0) {
            throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private void checkInitializeHasBeenCalled() {
        if (!NativeLibrary.isLoaded() || ContextUtils.getApplicationContext() == null) {
            throw new IllegalStateException("PeerConnectionFactory.initialize was not called before creating a PeerConnectionFactory.");
        }
    }

    private void checkPeerConnectionFactoryExists() {
        if (this.nativeFactory == 0) {
            throw new IllegalStateException("PeerConnectionFactory has been disposed.");
        }
    }

    public static String fieldTrialsFindFullName(String str) {
        return NativeLibrary.isLoaded() ? nativeFindFieldTrialsFullName(str) : "";
    }

    public static void initialize(InitializationOptions initializationOptions) {
        ContextUtils.initialize(initializationOptions.applicationContext);
        NativeLibrary.initialize(initializationOptions.nativeLibraryLoader, initializationOptions.nativeLibraryName);
        nativeInitializeAndroidGlobals();
        nativeInitializeFieldTrials(initializationOptions.fieldTrials);
        if (initializationOptions.enableInternalTracer && !internalTracerInitialized) {
            initializeInternalTracer();
        }
        Loggable loggable = initializationOptions.loggable;
        if (loggable != null) {
            Logging.injectLoggable(loggable, initializationOptions.loggableSeverity);
            nativeInjectLoggable(new JNILogging(initializationOptions.loggable), initializationOptions.loggableSeverity.ordinal());
            return;
        }
        Logging.d(TAG, "PeerConnectionFactory was initialized without an injected Loggable. Any existing Loggable will be deleted.");
        Logging.deleteInjectedLoggable();
        nativeDeleteLoggable();
    }

    @Deprecated
    public static void initializeFieldTrials(String str) {
        nativeInitializeFieldTrials(str);
    }

    public static void initializeInternalTracer() {
        internalTracerInitialized = true;
        nativeInitializeInternalTracer();
    }

    public static native long nativeCreateAudioSource(long j, MediaConstraints mediaConstraints);

    public static native long nativeCreateAudioTrack(long j, String str, long j2);

    public static native long nativeCreateLocalMediaStream(long j, String str);

    public static native long nativeCreatePeerConnection(long j, PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, long j2, SSLCertificateVerifier sSLCertificateVerifier);

    public static native long nativeCreatePeerConnectionFactory(Context context, Options options, long j, long j2, long j3, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, long j4, long j5, long j6);

    public static native long nativeCreateVideoSource(long j, boolean z, boolean z2);

    public static native long nativeCreateVideoTrack(long j, String str, long j2);

    public static native void nativeDeleteLoggable();

    public static native String nativeFindFieldTrialsFullName(String str);

    public static native void nativeFreeFactory(long j);

    public static native long nativeGetNativePeerConnectionFactory(long j);

    public static native void nativeInitializeAndroidGlobals();

    public static native void nativeInitializeFieldTrials(String str);

    public static native void nativeInitializeInternalTracer();

    public static native void nativeInjectLoggable(JNILogging jNILogging, int i);

    public static native void nativeInvokeThreadsCallbacks(long j);

    public static native void nativeShutdownInternalTracer();

    public static native boolean nativeStartAecDump(long j, int i, int i2);

    public static native boolean nativeStartInternalTracingCapture(String str);

    public static native void nativeStopAecDump(long j);

    public static native void nativeStopInternalTracingCapture();

    @CalledByNative
    public static void onNetworkThreadReady() {
        networkThread = Thread.currentThread();
        Logging.d(TAG, "onNetworkThreadReady");
    }

    @CalledByNative
    public static void onSignalingThreadReady() {
        signalingThread = Thread.currentThread();
        Logging.d(TAG, "onSignalingThreadReady");
    }

    @CalledByNative
    public static void onWorkerThreadReady() {
        workerThread = Thread.currentThread();
        Logging.d(TAG, "onWorkerThreadReady");
    }

    public static void printStackTrace(@Nullable Thread thread, String str) {
        if (thread != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                Logging.d(TAG, str + " stacks trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Logging.d(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    public static void printStackTraces() {
        printStackTrace(networkThread, "Network thread");
        printStackTrace(workerThread, "Worker thread");
        printStackTrace(signalingThread, "Signaling thread");
    }

    public static void shutdownInternalTracer() {
        internalTracerInitialized = false;
        nativeShutdownInternalTracer();
    }

    public static boolean startInternalTracingCapture(String str) {
        return nativeStartInternalTracingCapture(str);
    }

    public static void stopInternalTracingCapture() {
        nativeStopInternalTracingCapture();
    }

    public AudioSource createAudioSource(MediaConstraints mediaConstraints) {
        checkPeerConnectionFactoryExists();
        return new AudioSource(nativeCreateAudioSource(this.nativeFactory, mediaConstraints));
    }

    public AudioTrack createAudioTrack(String str, AudioSource audioSource) {
        checkPeerConnectionFactoryExists();
        return new AudioTrack(nativeCreateAudioTrack(this.nativeFactory, str, audioSource.getNativeAudioSource()));
    }

    public MediaStream createLocalMediaStream(String str) {
        checkPeerConnectionFactoryExists();
        return new MediaStream(nativeCreateLocalMediaStream(this.nativeFactory, str));
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(List<PeerConnection.IceServer> list, MediaConstraints mediaConstraints, PeerConnection.Observer observer) {
        return createPeerConnection(new PeerConnection.RTCConfiguration(list), mediaConstraints, observer);
    }

    @Nullable
    public PeerConnection createPeerConnection(List<PeerConnection.IceServer> list, PeerConnection.Observer observer) {
        return createPeerConnection(new PeerConnection.RTCConfiguration(list), observer);
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, PeerConnection.Observer observer) {
        return createPeerConnectionInternal(rTCConfiguration, mediaConstraints, observer, null);
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer) {
        return createPeerConnection(rTCConfiguration, (MediaConstraints) null, observer);
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnectionDependencies peerConnectionDependencies) {
        return createPeerConnectionInternal(rTCConfiguration, null, peerConnectionDependencies.getObserver(), peerConnectionDependencies.getSSLCertificateVerifier());
    }

    @Nullable
    public PeerConnection createPeerConnectionInternal(PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier) {
        checkPeerConnectionFactoryExists();
        long createNativePeerConnectionObserver = PeerConnection.createNativePeerConnectionObserver(observer);
        if (createNativePeerConnectionObserver == 0) {
            return null;
        }
        long nativeCreatePeerConnection = nativeCreatePeerConnection(this.nativeFactory, rTCConfiguration, mediaConstraints, createNativePeerConnectionObserver, sSLCertificateVerifier);
        if (nativeCreatePeerConnection == 0) {
            return null;
        }
        return new PeerConnection(nativeCreatePeerConnection);
    }

    public VideoSource createVideoSource(boolean z) {
        return createVideoSource(z, true);
    }

    public VideoSource createVideoSource(boolean z, boolean z2) {
        checkPeerConnectionFactoryExists();
        return new VideoSource(nativeCreateVideoSource(this.nativeFactory, z, z2));
    }

    public VideoTrack createVideoTrack(String str, VideoSource videoSource) {
        checkPeerConnectionFactoryExists();
        return new VideoTrack(nativeCreateVideoTrack(this.nativeFactory, str, videoSource.getNativeVideoTrackSource()));
    }

    public void dispose() {
        checkPeerConnectionFactoryExists();
        nativeFreeFactory(this.nativeFactory);
        networkThread = null;
        workerThread = null;
        signalingThread = null;
        MediaCodecVideoEncoder.disposeEglContext();
        MediaCodecVideoDecoder.disposeEglContext();
        this.nativeFactory = 0L;
    }

    public long getNativeOwnedFactoryAndThreads() {
        checkPeerConnectionFactoryExists();
        return this.nativeFactory;
    }

    public long getNativePeerConnectionFactory() {
        checkPeerConnectionFactoryExists();
        return nativeGetNativePeerConnectionFactory(this.nativeFactory);
    }

    public boolean startAecDump(int i, int i2) {
        checkPeerConnectionFactoryExists();
        return nativeStartAecDump(this.nativeFactory, i, i2);
    }

    public void stopAecDump() {
        checkPeerConnectionFactoryExists();
        nativeStopAecDump(this.nativeFactory);
    }

    public void threadsCallbacks() {
        checkPeerConnectionFactoryExists();
        nativeInvokeThreadsCallbacks(this.nativeFactory);
    }
}
