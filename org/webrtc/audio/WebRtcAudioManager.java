package org.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.Logging;
/* loaded from: classes9.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static AudioManager getAudioManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return (AudioManager) context.getSystemService("audio");
        }
        return (AudioManager) invokeL.objValue;
    }

    public static int getLowLatencyFramesPerBuffer(AudioManager audioManager) {
        InterceptResult invokeL;
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, audioManager)) == null) {
            if (Build.VERSION.SDK_INT < 17 || (property = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) == null) {
                return 256;
            }
            return Integer.parseInt(property);
        }
        return invokeL.intValue;
    }

    public static int getSampleRateForApiLevel(AudioManager audioManager) {
        InterceptResult invokeL;
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, audioManager)) == null) {
            if (Build.VERSION.SDK_INT < 17 || (property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE")) == null) {
                return 16000;
            }
            return Integer.parseInt(property);
        }
        return invokeL.intValue;
    }

    public static boolean isLowLatencyInputSupported(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isLowLatencyOutputSupported(context)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLowLatencyOutputSupported(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            return context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        }
        return invokeL.booleanValue;
    }

    public static int getInputBufferSize(Context context, AudioManager audioManager, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, context, audioManager, i, i2)) == null) {
            if (isLowLatencyInputSupported(context)) {
                return getLowLatencyFramesPerBuffer(audioManager);
            }
            return getMinInputFrameSize(i, i2);
        }
        return invokeLLII.intValue;
    }

    public static int getOutputBufferSize(Context context, AudioManager audioManager, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65542, null, context, audioManager, i, i2)) == null) {
            if (isLowLatencyOutputSupported(context)) {
                return getLowLatencyFramesPerBuffer(audioManager);
            }
            return getMinOutputFrameSize(i, i2);
        }
        return invokeLLII.intValue;
    }

    public static int getMinInputFrameSize(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            int i4 = i2 * 2;
            if (i2 == 1) {
                i3 = 16;
            } else {
                i3 = 12;
            }
            return AudioRecord.getMinBufferSize(i, i3, 2) / i4;
        }
        return invokeII.intValue;
    }

    public static int getMinOutputFrameSize(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            int i4 = i2 * 2;
            if (i2 == 1) {
                i3 = 4;
            } else {
                i3 = 12;
            }
            return AudioTrack.getMinBufferSize(i, i3, 2) / i4;
        }
        return invokeII.intValue;
    }

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
}
