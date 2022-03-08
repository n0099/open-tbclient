package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
/* loaded from: classes7.dex */
public final class AudioTagPayloadReader extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    public static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    public static final int AUDIO_FORMAT_AAC = 10;
    public static final int AUDIO_FORMAT_ALAW = 7;
    public static final int AUDIO_FORMAT_MP3 = 2;
    public static final int AUDIO_FORMAT_ULAW = 8;
    public static final int[] AUDIO_SAMPLING_RATE_TABLE;
    public transient /* synthetic */ FieldHolder $fh;
    public int audioFormat;
    public boolean hasOutputFormat;
    public boolean hasParsedAudioDataHeader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-784492810, "Lcom/google/android/exoplayer2/extractor/flv/AudioTagPayloadReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-784492810, "Lcom/google/android/exoplayer2/extractor/flv/AudioTagPayloadReader;");
                return;
            }
        }
        AUDIO_SAMPLING_RATE_TABLE = new int[]{5512, 11025, 22050, 44100};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trackOutput};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TrackOutput) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parsableByteArray)) == null) {
            if (!this.hasParsedAudioDataHeader) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int i2 = (readUnsignedByte >> 4) & 15;
                this.audioFormat = i2;
                if (i2 == 2) {
                    this.output.format(Format.createAudioSampleFormat(null, MimeTypes.AUDIO_MPEG, null, -1, -1, 1, AUDIO_SAMPLING_RATE_TABLE[(readUnsignedByte >> 2) & 3], null, null, 0, null));
                    this.hasOutputFormat = true;
                } else if (i2 == 7 || i2 == 8) {
                    this.output.format(Format.createAudioSampleFormat(null, this.audioFormat == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW, null, -1, -1, 1, 8000, (readUnsignedByte & 1) == 1 ? 2 : 3, null, null, 0, null));
                    this.hasOutputFormat = true;
                } else if (i2 != 10) {
                    throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.audioFormat);
                }
                this.hasParsedAudioDataHeader = true;
            } else {
                parsableByteArray.skipBytes(1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void parsePayload(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parsableByteArray, j2) == null) {
            if (this.audioFormat == 2) {
                int bytesLeft = parsableByteArray.bytesLeft();
                this.output.sampleData(parsableByteArray, bytesLeft);
                this.output.sampleMetadata(j2, 1, bytesLeft, 0, null);
                return;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 0 && !this.hasOutputFormat) {
                int bytesLeft2 = parsableByteArray.bytesLeft();
                byte[] bArr = new byte[bytesLeft2];
                parsableByteArray.readBytes(bArr, 0, bytesLeft2);
                Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                this.output.format(Format.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((Integer) parseAacAudioSpecificConfig.second).intValue(), ((Integer) parseAacAudioSpecificConfig.first).intValue(), Collections.singletonList(bArr), null, 0, null));
                this.hasOutputFormat = true;
            } else if (this.audioFormat != 10 || readUnsignedByte == 1) {
                int bytesLeft3 = parsableByteArray.bytesLeft();
                this.output.sampleData(parsableByteArray, bytesLeft3);
                this.output.sampleMetadata(j2, 1, bytesLeft3, 0, null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
