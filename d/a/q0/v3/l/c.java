package d.a.q0.v3.l;

import android.media.AudioRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
            short[] sArr = new short[minBufferSize];
            AudioRecord audioRecord2 = null;
            try {
                audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
            } catch (Exception unused) {
            }
            try {
                audioRecord.startRecording();
                if (audioRecord.getRecordingState() != 3) {
                    c(audioRecord);
                    audioRecord.release();
                    return -2;
                } else if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                    c(audioRecord);
                    audioRecord.release();
                    return -2;
                } else {
                    c(audioRecord);
                    audioRecord.release();
                    return 1;
                }
            } catch (Exception unused2) {
                audioRecord2 = audioRecord;
                if (audioRecord2 != null) {
                    audioRecord2.release();
                }
                return -2;
            }
        }
        return invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a() != -2 : invokeV.booleanValue;
    }

    public static void c(AudioRecord audioRecord) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, audioRecord) == null) || audioRecord == null) {
            return;
        }
        try {
            audioRecord.stop();
        } catch (Throwable unused) {
        }
    }
}
