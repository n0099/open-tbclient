package org.webrtc.audio;

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
/* loaded from: classes9.dex */
public class WebRtcAudioEffects {
    public static /* synthetic */ Interceptable $ic = null;
    public static final UUID AOSP_ACOUSTIC_ECHO_CANCELER;
    public static final UUID AOSP_NOISE_SUPPRESSOR;
    public static final boolean DEBUG = false;
    public static final String TAG = "WebRtcAudioEffectsExternal";
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(512373566, "Lorg/webrtc/audio/WebRtcAudioEffects;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(512373566, "Lorg/webrtc/audio/WebRtcAudioEffects;");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private boolean effectTypeIsVoIP(UUID uuid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, uuid)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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

    public static boolean isAcousticEchoCancelerSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC, AOSP_ACOUSTIC_ECHO_CANCELER);
        }
        return invokeV.booleanValue;
    }

    public static boolean isEffectTypeAvailable(UUID uuid, UUID uuid2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, uuid, uuid2)) == null) {
            AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
            if (availableEffects == null) {
                return false;
            }
            for (AudioEffect.Descriptor descriptor : availableEffects) {
                if (descriptor.type.equals(uuid)) {
                    return !descriptor.uuid.equals(uuid2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return false;
            }
            return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS, AOSP_NOISE_SUPPRESSOR);
        }
        return invokeV.booleanValue;
    }

    public void enable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            Logging.d(TAG, "enable(audioSession=" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            boolean z = true;
            assertTrue(this.aec == null);
            assertTrue(this.ns == null);
            boolean isAcousticEchoCancelerSupported = isAcousticEchoCancelerSupported();
            String str = SapiOptions.KEY_CACHE_ENABLED;
            if (isAcousticEchoCancelerSupported) {
                AcousticEchoCanceler create = AcousticEchoCanceler.create(i2);
                this.aec = create;
                if (create != null) {
                    boolean enabled = create.getEnabled();
                    boolean z2 = this.shouldEnableAec && isAcousticEchoCancelerSupported();
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
                NoiseSuppressor create2 = NoiseSuppressor.create(i2);
                this.ns = create2;
                if (create2 != null) {
                    boolean enabled2 = create2.getEnabled();
                    z = (this.shouldEnableNs && isNoiseSuppressorSupported()) ? false : false;
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
            if (!isAcousticEchoCancelerSupported()) {
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
            if (!isNoiseSuppressorSupported()) {
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
