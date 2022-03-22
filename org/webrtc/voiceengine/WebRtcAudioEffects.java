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
import com.tachikoma.core.component.button.StyleHelper;
import java.util.UUID;
import javax.annotation.Nullable;
import org.webrtc.Logging;
/* loaded from: classes8.dex */
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

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65538, null, z) == null) && !z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static boolean canUseAcousticEchoCanceler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            boolean z = (!isAcousticEchoCancelerSupported() || WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler() || isAcousticEchoCancelerBlacklisted() || isAcousticEchoCancelerExcludedByUUID()) ? false : true;
            Logging.d(TAG, "canUseAcousticEchoCanceler: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean canUseNoiseSuppressor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            boolean z = (!isNoiseSuppressorSupported() || WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor() || isNoiseSuppressorBlacklisted() || isNoiseSuppressorExcludedByUUID()) ? false : true;
            Logging.d(TAG, "canUseNoiseSuppressor: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static WebRtcAudioEffects create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new WebRtcAudioEffects() : (WebRtcAudioEffects) invokeV.objValue;
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, uuid)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            return (AudioEffect.EFFECT_TYPE_AEC.equals(uuid) && isAcousticEchoCancelerSupported()) || (AudioEffect.EFFECT_TYPE_NS.equals(uuid) && isNoiseSuppressorSupported());
        }
        return invokeL.booleanValue;
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

    public static boolean isAcousticEchoCancelerSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? isAcousticEchoCancelerEffectAvailable() : invokeV.booleanValue;
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

    public static boolean isNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? isNoiseSuppressorEffectAvailable() : invokeV.booleanValue;
    }

    public void enable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            Logging.d(TAG, "enable(audioSession=" + i + SmallTailInfo.EMOTION_SUFFIX);
            boolean z = true;
            assertTrue(this.aec == null);
            assertTrue(this.ns == null);
            boolean isAcousticEchoCancelerSupported = isAcousticEchoCancelerSupported();
            String str = SapiOptions.KEY_CACHE_ENABLED;
            if (isAcousticEchoCancelerSupported) {
                AcousticEchoCanceler create = AcousticEchoCanceler.create(i);
                this.aec = create;
                if (create != null) {
                    boolean enabled = create.getEnabled();
                    boolean z2 = this.shouldEnableAec && canUseAcousticEchoCanceler();
                    if (this.aec.setEnabled(z2) != 0) {
                        Logging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("AcousticEchoCanceler: was ");
                    sb.append(enabled ? SapiOptions.KEY_CACHE_ENABLED : StyleHelper.KEY_ONDISABLE);
                    sb.append(", enable: ");
                    sb.append(z2);
                    sb.append(", is now: ");
                    sb.append(this.aec.getEnabled() ? SapiOptions.KEY_CACHE_ENABLED : StyleHelper.KEY_ONDISABLE);
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
                    z = (this.shouldEnableNs && canUseNoiseSuppressor()) ? false : false;
                    if (this.ns.setEnabled(z) != 0) {
                        Logging.e(TAG, "Failed to set the NoiseSuppressor state");
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("NoiseSuppressor: was ");
                    sb2.append(enabled2 ? SapiOptions.KEY_CACHE_ENABLED : StyleHelper.KEY_ONDISABLE);
                    sb2.append(", enable: ");
                    sb2.append(z);
                    sb2.append(", is now: ");
                    if (!this.ns.getEnabled()) {
                        str = StyleHelper.KEY_ONDISABLE;
                    }
                    sb2.append(str);
                    Logging.d(TAG, sb2.toString());
                    return;
                }
                Logging.e(TAG, "Failed to create the NoiseSuppressor instance");
            }
        }
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
