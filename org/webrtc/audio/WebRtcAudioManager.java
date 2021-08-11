package org.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public class WebRtcAudioManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BITS_PER_SAMPLE = 16;
    public static final int DEFAULT_FRAME_PER_BUFFER = 256;
    public static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    public static final String TAG = "WebRtcAudioManagerExternal";
    public transient /* synthetic */ FieldHolder $fh;

    public WebRtcAudioManager() {
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

    @CalledByNative
    public static AudioManager getAudioManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : (AudioManager) invokeL.objValue;
    }

    @CalledByNative
    public static int getInputBufferSize(Context context, AudioManager audioManager, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, context, audioManager, i2, i3)) == null) ? isLowLatencyInputSupported(context) ? getLowLatencyFramesPerBuffer(audioManager) : getMinInputFrameSize(i2, i3) : invokeLLII.intValue;
    }

    public static int getLowLatencyFramesPerBuffer(AudioManager audioManager) {
        InterceptResult invokeL;
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, audioManager)) == null) {
            if (Build.VERSION.SDK_INT >= 17 && (property = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) != null) {
                return Integer.parseInt(property);
            }
            return 256;
        }
        return invokeL.intValue;
    }

    public static int getMinInputFrameSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) {
            return AudioRecord.getMinBufferSize(i2, i3 == 1 ? 16 : 12, 2) / (i3 * 2);
        }
        return invokeII.intValue;
    }

    public static int getMinOutputFrameSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            return AudioTrack.getMinBufferSize(i2, i3 == 1 ? 4 : 12, 2) / (i3 * 2);
        }
        return invokeII.intValue;
    }

    @CalledByNative
    public static int getOutputBufferSize(Context context, AudioManager audioManager, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(AdIconUtil.BAIDU_LOGO_ID, null, context, audioManager, i2, i3)) == null) ? isLowLatencyOutputSupported(context) ? getLowLatencyFramesPerBuffer(audioManager) : getMinOutputFrameSize(i2, i3) : invokeLLII.intValue;
    }

    @CalledByNative
    public static int getSampleRate(AudioManager audioManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, audioManager)) == null) {
            if (WebRtcAudioUtils.runningOnEmulator()) {
                Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
                return 8000;
            }
            int sampleRateForApiLevel = getSampleRateForApiLevel(audioManager);
            Logging.d(TAG, "Sample rate is set to " + sampleRateForApiLevel + " Hz");
            return sampleRateForApiLevel;
        }
        return invokeL.intValue;
    }

    public static int getSampleRateForApiLevel(AudioManager audioManager) {
        InterceptResult invokeL;
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, audioManager)) == null) {
            if (Build.VERSION.SDK_INT >= 17 && (property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE")) != null) {
                return Integer.parseInt(property);
            }
            return 16000;
        }
        return invokeL.intValue;
    }

    public static boolean isLowLatencyInputSupported(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? Build.VERSION.SDK_INT >= 21 && isLowLatencyOutputSupported(context) : invokeL.booleanValue;
    }

    public static boolean isLowLatencyOutputSupported(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency") : invokeL.booleanValue;
    }
}
