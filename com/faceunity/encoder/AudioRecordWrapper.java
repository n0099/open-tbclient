package com.faceunity.encoder;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class AudioRecordWrapper {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] AUDIO_SOURCES;
    public static int FRAMES_PER_BUFFER;
    public static int SAMPLES_PER_FRAME;
    public static int SAMPLE_RATE;
    public static AudioRecordWrapper mLastAudioRecordWrapper;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord mAudioRecord;
    public boolean mHasReleased;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2027004459, "Lcom/faceunity/encoder/AudioRecordWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2027004459, "Lcom/faceunity/encoder/AudioRecordWrapper;");
                return;
            }
        }
        AUDIO_SOURCES = new int[]{1, 0, 5, 7, 6};
        SAMPLE_RATE = MediaEncodeParams.AUDIO_SAMPLE_RATE;
        SAMPLES_PER_FRAME = 2048;
        FRAMES_PER_BUFFER = 24;
    }

    public AudioRecordWrapper() {
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
        int minBufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, 16, 2);
        int i4 = SAMPLES_PER_FRAME;
        int i5 = FRAMES_PER_BUFFER * i4;
        i5 = i5 < minBufferSize ? ((minBufferSize / i4) + 1) * i4 * 2 : i5;
        for (int i6 : AUDIO_SOURCES) {
            try {
                AudioRecord audioRecord = new AudioRecord(i6, SAMPLE_RATE, 16, 2, i5);
                this.mAudioRecord = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception unused) {
                this.mAudioRecord = null;
            }
        }
    }

    public AudioRecord getAudioRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAudioRecord : (AudioRecord) invokeV.objValue;
    }

    public boolean isReleased() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHasReleased : invokeV.booleanValue;
    }

    public int read(@NonNull ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, byteBuffer, i2)) == null) {
            AudioRecord audioRecord = this.mAudioRecord;
            if (audioRecord == null) {
                return 0;
            }
            return audioRecord.read(byteBuffer, i2);
        }
        return invokeLI.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mHasReleased) {
            return;
        }
        this.mHasReleased = true;
        AudioRecord audioRecord = this.mAudioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public void startRecording() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.mAudioRecord == null) {
            return;
        }
        AudioRecordWrapper audioRecordWrapper = mLastAudioRecordWrapper;
        if (audioRecordWrapper != null && !audioRecordWrapper.isReleased()) {
            mLastAudioRecordWrapper.release();
        }
        this.mAudioRecord.startRecording();
        mLastAudioRecordWrapper = this;
    }

    public void stop() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (audioRecord = this.mAudioRecord) == null) {
            return;
        }
        audioRecord.stop();
    }
}
