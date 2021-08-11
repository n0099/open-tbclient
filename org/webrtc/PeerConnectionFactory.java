package org.webrtc;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.rtc.RTCLoadManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.Logging;
import org.webrtc.NativeLibrary;
import org.webrtc.PeerConnection;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.LegacyAudioDeviceModule;
/* loaded from: classes2.dex */
public class PeerConnectionFactory {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeFactory;

    /* renamed from: org.webrtc.PeerConnectionFactory$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.audioDeviceModule = new LegacyAudioDeviceModule();
            this.audioEncoderFactoryFactory = new BuiltinAudioEncoderFactoryFactory();
            this.audioDecoderFactoryFactory = new BuiltinAudioDecoderFactoryFactory();
        }

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public PeerConnectionFactory createPeerConnectionFactory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new PeerConnectionFactory(this.options, this.audioDeviceModule, this.audioEncoderFactoryFactory, this.audioDecoderFactoryFactory, this.videoEncoderFactory, this.videoDecoderFactory, this.audioProcessingFactory, this.fecControllerFactoryFactory, this.mediaTransportFactoryFactory, null) : (PeerConnectionFactory) invokeV.objValue;
        }

        public Builder setAudioDecoderFactoryFactory(AudioDecoderFactoryFactory audioDecoderFactoryFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, audioDecoderFactoryFactory)) == null) {
                if (audioDecoderFactoryFactory != null) {
                    this.audioDecoderFactoryFactory = audioDecoderFactoryFactory;
                    return this;
                }
                throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioDecoderFactoryFactory.");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAudioDeviceModule(AudioDeviceModule audioDeviceModule) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, audioDeviceModule)) == null) {
                this.audioDeviceModule = audioDeviceModule;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAudioEncoderFactoryFactory(AudioEncoderFactoryFactory audioEncoderFactoryFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, audioEncoderFactoryFactory)) == null) {
                if (audioEncoderFactoryFactory != null) {
                    this.audioEncoderFactoryFactory = audioEncoderFactoryFactory;
                    return this;
                }
                throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioEncoderFactoryFactory.");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAudioProcessingFactory(AudioProcessingFactory audioProcessingFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, audioProcessingFactory)) == null) {
                if (audioProcessingFactory != null) {
                    this.audioProcessingFactory = audioProcessingFactory;
                    return this;
                }
                throw new NullPointerException("PeerConnectionFactory builder does not accept a null AudioProcessingFactory.");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFecControllerFactoryFactoryInterface(FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fecControllerFactoryFactoryInterface)) == null) {
                this.fecControllerFactoryFactory = fecControllerFactoryFactoryInterface;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMediaTransportFactoryFactory(MediaTransportFactoryFactory mediaTransportFactoryFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mediaTransportFactoryFactory)) == null) {
                this.mediaTransportFactoryFactory = mediaTransportFactoryFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOptions(Options options) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, options)) == null) {
                this.options = options;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoDecoderFactory(VideoDecoderFactory videoDecoderFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoDecoderFactory)) == null) {
                this.videoDecoderFactory = videoDecoderFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoEncoderFactory(VideoEncoderFactory videoEncoderFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, videoEncoderFactory)) == null) {
                this.videoEncoderFactory = videoEncoderFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class InitializationOptions {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context applicationContext;
        public final boolean enableInternalTracer;
        public final String fieldTrials;
        @Nullable
        public Loggable loggable;
        @Nullable
        public Logging.Severity loggableSeverity;
        public final NativeLibraryLoader nativeLibraryLoader;
        public final String nativeLibraryName;

        /* loaded from: classes2.dex */
        public static class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Context applicationContext;
            public boolean enableInternalTracer;
            public String fieldTrials;
            @Nullable
            public Loggable loggable;
            @Nullable
            public Logging.Severity loggableSeverity;
            public NativeLibraryLoader nativeLibraryLoader;
            public String nativeLibraryName;

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
                this.fieldTrials = "";
                this.nativeLibraryLoader = new NativeLibrary.DefaultLoader();
                this.nativeLibraryName = RTCLoadManager.JINGLE_LIB_NAME;
                this.applicationContext = context;
            }

            public InitializationOptions createInitializationOptions() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new InitializationOptions(this.applicationContext, this.fieldTrials, this.enableInternalTracer, this.nativeLibraryLoader, this.nativeLibraryName, this.loggable, this.loggableSeverity, null) : (InitializationOptions) invokeV.objValue;
            }

            public Builder setEnableInternalTracer(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                    this.enableInternalTracer = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            public Builder setFieldTrials(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    this.fieldTrials = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setInjectableLogger(Loggable loggable, Logging.Severity severity) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, loggable, severity)) == null) {
                    this.loggable = loggable;
                    this.loggableSeverity = severity;
                    return this;
                }
                return (Builder) invokeLL.objValue;
            }

            public Builder setNativeLibraryLoader(NativeLibraryLoader nativeLibraryLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, nativeLibraryLoader)) == null) {
                    this.nativeLibraryLoader = nativeLibraryLoader;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNativeLibraryName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    this.nativeLibraryName = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        public InitializationOptions(Context context, String str, boolean z, NativeLibraryLoader nativeLibraryLoader, String str2, @Nullable Loggable loggable, @Nullable Logging.Severity severity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Boolean.valueOf(z), nativeLibraryLoader, str2, loggable, severity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.applicationContext = context;
            this.fieldTrials = str;
            this.enableInternalTracer = z;
            this.nativeLibraryLoader = nativeLibraryLoader;
            this.nativeLibraryName = str2;
            this.loggable = loggable;
            this.loggableSeverity = severity;
        }

        public /* synthetic */ InitializationOptions(Context context, String str, boolean z, NativeLibraryLoader nativeLibraryLoader, String str2, Loggable loggable, Logging.Severity severity, AnonymousClass1 anonymousClass1) {
            this(context, str, z, nativeLibraryLoader, str2, loggable, severity);
        }

        public static Builder builder(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Builder(context) : (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class Options {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ADAPTER_TYPE_ANY = 32;
        public static final int ADAPTER_TYPE_CELLULAR = 4;
        public static final int ADAPTER_TYPE_ETHERNET = 1;
        public static final int ADAPTER_TYPE_LOOPBACK = 16;
        public static final int ADAPTER_TYPE_UNKNOWN = 0;
        public static final int ADAPTER_TYPE_VPN = 8;
        public static final int ADAPTER_TYPE_WIFI = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean disableEncryption;
        public boolean disableNetworkMonitor;
        public int networkIgnoreMask;

        public Options() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @CalledByNative("Options")
        public boolean getDisableEncryption() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.disableEncryption : invokeV.booleanValue;
        }

        @CalledByNative("Options")
        public boolean getDisableNetworkMonitor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.disableNetworkMonitor : invokeV.booleanValue;
        }

        @CalledByNative("Options")
        public int getNetworkIgnoreMask() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.networkIgnoreMask : invokeV.intValue;
        }
    }

    @CalledByNative
    public PeerConnectionFactory(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        checkInitializeHasBeenCalled();
        if (j2 == 0) {
            throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
        }
        this.nativeFactory = j2;
    }

    public PeerConnectionFactory(Options options, @Nullable AudioDeviceModule audioDeviceModule, AudioEncoderFactoryFactory audioEncoderFactoryFactory, AudioDecoderFactoryFactory audioDecoderFactoryFactory, @Nullable VideoEncoderFactory videoEncoderFactory, @Nullable VideoDecoderFactory videoDecoderFactory, @Nullable AudioProcessingFactory audioProcessingFactory, @Nullable FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface, @Nullable MediaTransportFactoryFactory mediaTransportFactoryFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {options, audioDeviceModule, audioEncoderFactoryFactory, audioDecoderFactoryFactory, videoEncoderFactory, videoDecoderFactory, audioProcessingFactory, fecControllerFactoryFactoryInterface, mediaTransportFactoryFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        checkInitializeHasBeenCalled();
        long nativeCreatePeerConnectionFactory = nativeCreatePeerConnectionFactory(ContextUtils.getApplicationContext(), options, audioDeviceModule == null ? 0L : audioDeviceModule.getNativeAudioDeviceModulePointer(), audioEncoderFactoryFactory.createNativeAudioEncoderFactory(), audioDecoderFactoryFactory.createNativeAudioDecoderFactory(), videoEncoderFactory, videoDecoderFactory, audioProcessingFactory == null ? 0L : audioProcessingFactory.createNative(), fecControllerFactoryFactoryInterface == null ? 0L : fecControllerFactoryFactoryInterface.createNative(), mediaTransportFactoryFactory == null ? 0L : mediaTransportFactoryFactory.createNativeMediaTransportFactory());
        this.nativeFactory = nativeCreatePeerConnectionFactory;
        if (nativeCreatePeerConnectionFactory == 0) {
            throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
        }
    }

    public /* synthetic */ PeerConnectionFactory(Options options, AudioDeviceModule audioDeviceModule, AudioEncoderFactoryFactory audioEncoderFactoryFactory, AudioDecoderFactoryFactory audioDecoderFactoryFactory, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, AudioProcessingFactory audioProcessingFactory, FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface, MediaTransportFactoryFactory mediaTransportFactoryFactory, AnonymousClass1 anonymousClass1) {
        this(options, audioDeviceModule, audioEncoderFactoryFactory, audioDecoderFactoryFactory, videoEncoderFactory, videoDecoderFactory, audioProcessingFactory, fecControllerFactoryFactoryInterface, mediaTransportFactoryFactory);
    }

    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new Builder(null) : (Builder) invokeV.objValue;
    }

    private void checkInitializeHasBeenCalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (!NativeLibrary.isLoaded() || ContextUtils.getApplicationContext() == null) {
                throw new IllegalStateException("PeerConnectionFactory.initialize was not called before creating a PeerConnectionFactory.");
            }
        }
    }

    private void checkPeerConnectionFactoryExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.nativeFactory == 0) {
            throw new IllegalStateException("PeerConnectionFactory has been disposed.");
        }
    }

    public static String fieldTrialsFindFullName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? NativeLibrary.isLoaded() ? nativeFindFieldTrialsFullName(str) : "" : (String) invokeL.objValue;
    }

    public static void initialize(InitializationOptions initializationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, initializationOptions) == null) {
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
    }

    @Deprecated
    public static void initializeFieldTrials(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            nativeInitializeFieldTrials(str);
        }
    }

    public static void initializeInternalTracer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            internalTracerInitialized = true;
            nativeInitializeInternalTracer();
        }
    }

    public static native long nativeCreateAudioSource(long j2, MediaConstraints mediaConstraints);

    public static native long nativeCreateAudioTrack(long j2, String str, long j3);

    public static native long nativeCreateLocalMediaStream(long j2, String str);

    public static native long nativeCreatePeerConnection(long j2, PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, long j3, SSLCertificateVerifier sSLCertificateVerifier);

    public static native long nativeCreatePeerConnectionFactory(Context context, Options options, long j2, long j3, long j4, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, long j5, long j6, long j7);

    public static native long nativeCreateVideoSource(long j2, boolean z, boolean z2);

    public static native long nativeCreateVideoTrack(long j2, String str, long j3);

    public static native void nativeDeleteLoggable();

    public static native String nativeFindFieldTrialsFullName(String str);

    public static native void nativeFreeFactory(long j2);

    public static native long nativeGetNativePeerConnectionFactory(long j2);

    public static native void nativeInitializeAndroidGlobals();

    public static native void nativeInitializeFieldTrials(String str);

    public static native void nativeInitializeInternalTracer();

    public static native void nativeInjectLoggable(JNILogging jNILogging, int i2);

    public static native void nativeInvokeThreadsCallbacks(long j2);

    public static native void nativeShutdownInternalTracer();

    public static native boolean nativeStartAecDump(long j2, int i2, int i3);

    public static native boolean nativeStartInternalTracingCapture(String str);

    public static native void nativeStopAecDump(long j2);

    public static native void nativeStopInternalTracingCapture();

    @CalledByNative
    public static void onNetworkThreadReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            networkThread = Thread.currentThread();
            Logging.d(TAG, "onNetworkThreadReady");
        }
    }

    @CalledByNative
    public static void onSignalingThreadReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            signalingThread = Thread.currentThread();
            Logging.d(TAG, "onSignalingThreadReady");
        }
    }

    @CalledByNative
    public static void onWorkerThreadReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            workerThread = Thread.currentThread();
            Logging.d(TAG, "onWorkerThreadReady");
        }
    }

    public static void printStackTrace(@Nullable Thread thread, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65570, null, thread, str) == null) || thread == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            Logging.d(TAG, str + " stacks trace:");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Logging.d(TAG, stackTraceElement.toString());
            }
        }
    }

    public static void printStackTraces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, null) == null) {
            printStackTrace(networkThread, "Network thread");
            printStackTrace(workerThread, "Worker thread");
            printStackTrace(signalingThread, "Signaling thread");
        }
    }

    public static void shutdownInternalTracer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, null) == null) {
            internalTracerInitialized = false;
            nativeShutdownInternalTracer();
        }
    }

    public static boolean startInternalTracingCapture(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) ? nativeStartInternalTracingCapture(str) : invokeL.booleanValue;
    }

    public static void stopInternalTracingCapture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, null) == null) {
            nativeStopInternalTracingCapture();
        }
    }

    public AudioSource createAudioSource(MediaConstraints mediaConstraints) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaConstraints)) == null) {
            checkPeerConnectionFactoryExists();
            return new AudioSource(nativeCreateAudioSource(this.nativeFactory, mediaConstraints));
        }
        return (AudioSource) invokeL.objValue;
    }

    public AudioTrack createAudioTrack(String str, AudioSource audioSource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, audioSource)) == null) {
            checkPeerConnectionFactoryExists();
            return new AudioTrack(nativeCreateAudioTrack(this.nativeFactory, str, audioSource.getNativeAudioSource()));
        }
        return (AudioTrack) invokeLL.objValue;
    }

    public MediaStream createLocalMediaStream(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            checkPeerConnectionFactoryExists();
            return new MediaStream(nativeCreateLocalMediaStream(this.nativeFactory, str));
        }
        return (MediaStream) invokeL.objValue;
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(List<PeerConnection.IceServer> list, MediaConstraints mediaConstraints, PeerConnection.Observer observer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, list, mediaConstraints, observer)) == null) ? createPeerConnection(new PeerConnection.RTCConfiguration(list), mediaConstraints, observer) : (PeerConnection) invokeLLL.objValue;
    }

    @Nullable
    public PeerConnection createPeerConnection(List<PeerConnection.IceServer> list, PeerConnection.Observer observer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, list, observer)) == null) ? createPeerConnection(new PeerConnection.RTCConfiguration(list), observer) : (PeerConnection) invokeLL.objValue;
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, PeerConnection.Observer observer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, rTCConfiguration, mediaConstraints, observer)) == null) ? createPeerConnectionInternal(rTCConfiguration, mediaConstraints, observer, null) : (PeerConnection) invokeLLL.objValue;
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, rTCConfiguration, observer)) == null) ? createPeerConnection(rTCConfiguration, (MediaConstraints) null, observer) : (PeerConnection) invokeLL.objValue;
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnectionDependencies peerConnectionDependencies) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, rTCConfiguration, peerConnectionDependencies)) == null) ? createPeerConnectionInternal(rTCConfiguration, null, peerConnectionDependencies.getObserver(), peerConnectionDependencies.getSSLCertificateVerifier()) : (PeerConnection) invokeLL.objValue;
    }

    @Nullable
    public PeerConnection createPeerConnectionInternal(PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rTCConfiguration, mediaConstraints, observer, sSLCertificateVerifier)) == null) {
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
        return (PeerConnection) invokeLLLL.objValue;
    }

    public VideoSource createVideoSource(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) ? createVideoSource(z, true) : (VideoSource) invokeZ.objValue;
    }

    public VideoSource createVideoSource(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            checkPeerConnectionFactoryExists();
            return new VideoSource(nativeCreateVideoSource(this.nativeFactory, z, z2));
        }
        return (VideoSource) invokeCommon.objValue;
    }

    public VideoTrack createVideoTrack(String str, VideoSource videoSource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, videoSource)) == null) {
            checkPeerConnectionFactoryExists();
            return new VideoTrack(nativeCreateVideoTrack(this.nativeFactory, str, videoSource.getNativeVideoTrackSource()));
        }
        return (VideoTrack) invokeLL.objValue;
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            checkPeerConnectionFactoryExists();
            nativeFreeFactory(this.nativeFactory);
            networkThread = null;
            workerThread = null;
            signalingThread = null;
            MediaCodecVideoEncoder.disposeEglContext();
            MediaCodecVideoDecoder.disposeEglContext();
            this.nativeFactory = 0L;
        }
    }

    public long getNativeOwnedFactoryAndThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            checkPeerConnectionFactoryExists();
            return this.nativeFactory;
        }
        return invokeV.longValue;
    }

    public long getNativePeerConnectionFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            checkPeerConnectionFactoryExists();
            return nativeGetNativePeerConnectionFactory(this.nativeFactory);
        }
        return invokeV.longValue;
    }

    public boolean startAecDump(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) {
            checkPeerConnectionFactoryExists();
            return nativeStartAecDump(this.nativeFactory, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public void stopAecDump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            checkPeerConnectionFactoryExists();
            nativeStopAecDump(this.nativeFactory);
        }
    }

    public void threadsCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            checkPeerConnectionFactoryExists();
            nativeInvokeThreadsCallbacks(this.nativeFactory);
        }
    }
}
