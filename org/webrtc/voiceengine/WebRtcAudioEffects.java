package org.webrtc.voiceengine;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import javax.annotation.Nullable;
import org.webrtc.Logging;
/* loaded from: classes9.dex */
public class WebRtcAudioEffects {
    public static /* synthetic */ Interceptable $ic = null;
    public static final UUID AOSP_ACOUSTIC_ECHO_CANCELER;
    public static final UUID AOSP_NOISE_SUPPRESSOR;
    public static final boolean DEBUG = false;
    public static final String TAG = "WebRtcAudioEffects";
    @Nullable
    public static AudioEffect.Descriptor[] cachedEffects;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AcousticEchoCanceler aec;
    @Nullable
    public NoiseSuppressor ns;
    public boolean shouldEnableAec;
    public boolean shouldEnableNs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-372005220, "Lorg/webrtc/voiceengine/WebRtcAudioEffects;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-372005220, "Lorg/webrtc/voiceengine/WebRtcAudioEffects;");
                return;
            }
        }
        AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
        AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    }

    public static WebRtcAudioEffects create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new WebRtcAudioEffects();
        }
        return (WebRtcAudioEffects) invokeV.objValue;
    }

    @Nullable
    public static AudioEffect.Descriptor[] getAvailableEffects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            AudioEffect.Descriptor[] descriptorArr = cachedEffects;
            if (descriptorArr != null) {
                return descriptorArr;
            }
            AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
            cachedEffects = queryEffects;
            return queryEffects;
        }
        return (AudioEffect.Descriptor[]) invokeV.objValue;
    }

    public static boolean isAcousticEchoCancelerEffectAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC);
        }
        return invokeV.booleanValue;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return isAcousticEchoCancelerEffectAvailable();
        }
        return invokeV.booleanValue;
    }

    public static boolean isNoiseSuppressorEffectAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
        }
        return invokeV.booleanValue;
    }

    public static boolean isNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return isNoiseSuppressorEffectAvailable();
        }
        return invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Logging.d(TAG, "release");
            AcousticEchoCanceler acousticEchoCanceler = this.aec;
            if (acousticEchoCanceler != null) {
                acousticEchoCanceler.release();
                this.aec = null;
            }
            NoiseSuppressor noiseSuppressor = this.ns;
            if (noiseSuppressor != null) {
                noiseSuppressor.release();
                this.ns = null;
            }
        }
    }

    public WebRtcAudioEffects() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    public static boolean canUseAcousticEchoCanceler() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (isAcousticEchoCancelerSupported() && !WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler() && !isAcousticEchoCancelerBlacklisted() && !isAcousticEchoCancelerExcludedByUUID()) {
                z = true;
            } else {
                z = false;
            }
            Logging.d(TAG, "canUseAcousticEchoCanceler: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean canUseNoiseSuppressor() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (isNoiseSuppressorSupported() && !WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor() && !isNoiseSuppressorBlacklisted() && !isNoiseSuppressorExcludedByUUID()) {
                z = true;
            } else {
                z = false;
            }
            Logging.d(TAG, "canUseNoiseSuppressor: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isAcousticEchoCancelerBlacklisted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            boolean contains = WebRtcAudioUtils.getBlackListedModelsForAecUsage().contains(Build.MODEL);
            if (contains) {
                Logging.w(TAG, Build.MODEL + " is blacklisted for HW AEC usage!");
            }
            return contains;
        }
        return invokeV.booleanValue;
    }

    public static boolean isAcousticEchoCancelerExcludedByUUID() {
        InterceptResult invokeV;
        AudioEffect.Descriptor[] availableEffects;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
                if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_AEC) && descriptor.uuid.equals(AOSP_ACOUSTIC_ECHO_CANCELER)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNoiseSuppressorBlacklisted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            boolean contains = WebRtcAudioUtils.getBlackListedModelsForNsUsage().contains(Build.MODEL);
            if (contains) {
                Logging.w(TAG, Build.MODEL + " is blacklisted for HW NS usage!");
            }
            return contains;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNoiseSuppressorExcludedByUUID() {
        InterceptResult invokeV;
        AudioEffect.Descriptor[] availableEffects;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
                if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_NS) && descriptor.uuid.equals(AOSP_NOISE_SUPPRESSOR)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65538, null, z) != null) || z) {
            return;
        }
        throw new AssertionError("Expected condition to be true");
    }

    public static boolean isEffectTypeAvailable(UUID uuid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uuid)) == null) {
            AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
            if (availableEffects == null) {
                return false;
            }
            for (AudioEffect.Descriptor descriptor : availableEffects) {
                if (descriptor.type.equals(uuid)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, uuid)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            if ((!AudioEffect.EFFECT_TYPE_AEC.equals(uuid) || !isAcousticEchoCancelerSupported()) && (!AudioEffect.EFFECT_TYPE_NS.equals(uuid) || !isNoiseSuppressorSupported())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void enable(int i) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            Logging.d(TAG, "enable(audioSession=" + i + SmallTailInfo.EMOTION_SUFFIX);
            boolean z4 = true;
            if (this.aec == null) {
                z = true;
            } else {
                z = false;
            }
            assertTrue(z);
            if (this.ns == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            assertTrue(z2);
            boolean isAcousticEchoCancelerSupported = isAcousticEchoCancelerSupported();
            String str4 = SapiOptions.KEY_CACHE_ENABLED;
            if (isAcousticEchoCancelerSupported) {
                AcousticEchoCanceler create = AcousticEchoCanceler.create(i);
                this.aec = create;
                if (create != null) {
                    boolean enabled = create.getEnabled();
                    if (this.shouldEnableAec && canUseAcousticEchoCanceler()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (this.aec.setEnabled(z3) != 0) {
                        Logging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("AcousticEchoCanceler: was ");
                    if (!enabled) {
                        str2 = "disabled";
                    } else {
                        str2 = SapiOptions.KEY_CACHE_ENABLED;
                    }
                    sb.append(str2);
                    sb.append(", enable: ");
                    sb.append(z3);
                    sb.append(", is now: ");
                    if (!this.aec.getEnabled()) {
                        str3 = "disabled";
                    } else {
                        str3 = SapiOptions.KEY_CACHE_ENABLED;
                    }
                    sb.append(str3);
                    Logging.d(TAG, sb.toString());
                } else {
                    Logging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
                }
            }
            if (isNoiseSuppressorSupported()) {
                NoiseSuppressor create2 = NoiseSuppressor.create(i);
                this.ns = create2;
                if (create2 != null) {
                    boolean enabled2 = create2.getEnabled();
                    z4 = (this.shouldEnableNs && canUseNoiseSuppressor()) ? false : false;
                    if (this.ns.setEnabled(z4) != 0) {
                        Logging.e(TAG, "Failed to set the NoiseSuppressor state");
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("NoiseSuppressor: was ");
                    if (!enabled2) {
                        str = "disabled";
                    } else {
                        str = SapiOptions.KEY_CACHE_ENABLED;
                    }
                    sb2.append(str);
                    sb2.append(", enable: ");
                    sb2.append(z4);
                    sb2.append(", is now: ");
                    if (!this.ns.getEnabled()) {
                        str4 = "disabled";
                    }
                    sb2.append(str4);
                    Logging.d(TAG, sb2.toString());
                    return;
                }
                Logging.e(TAG, "Failed to create the NoiseSuppressor instance");
            }
        }
    }

    public boolean setAEC(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            Logging.d(TAG, "setAEC(" + z + SmallTailInfo.EMOTION_SUFFIX);
            if (!canUseAcousticEchoCanceler()) {
                Logging.w(TAG, "Platform AEC is not supported");
                this.shouldEnableAec = false;
                return false;
            } else if (this.aec != null && z != this.shouldEnableAec) {
                Logging.e(TAG, "Platform AEC state can't be modified while recording");
                return false;
            } else {
                this.shouldEnableAec = z;
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean setNS(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            Logging.d(TAG, "setNS(" + z + SmallTailInfo.EMOTION_SUFFIX);
            if (!canUseNoiseSuppressor()) {
                Logging.w(TAG, "Platform NS is not supported");
                this.shouldEnableNs = false;
                return false;
            } else if (this.ns != null && z != this.shouldEnableNs) {
                Logging.e(TAG, "Platform NS state can't be modified while recording");
                return false;
            } else {
                this.shouldEnableNs = z;
                return true;
            }
        }
        return invokeZ.booleanValue;
    }
}
