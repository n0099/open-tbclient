package com.google.android.exoplayer2.extractor.flv;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;
/* loaded from: classes4.dex */
public final class VideoTagPayloadReader extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AVC_PACKET_TYPE_AVC_NALU = 1;
    public static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    public static final int VIDEO_CODEC_AVC = 7;
    public static final int VIDEO_FRAME_KEYFRAME = 1;
    public static final int VIDEO_FRAME_VIDEO_INFO = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public int frameType;
    public boolean hasOutputFormat;
    public final ParsableByteArray nalLength;
    public final ParsableByteArray nalStartCode;
    public int nalUnitLengthFieldLength;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trackOutput};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TrackOutput) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parsableByteArray)) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i = (readUnsignedByte >> 4) & 15;
            int i2 = readUnsignedByte & 15;
            if (i2 == 7) {
                this.frameType = i;
                return i != 5;
            }
            throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void parsePayload(ParsableByteArray parsableByteArray, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parsableByteArray, j) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            long readInt24 = j + (parsableByteArray.readInt24() * 1000);
            if (readUnsignedByte == 0 && !this.hasOutputFormat) {
                ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.bytesLeft()]);
                parsableByteArray.readBytes(parsableByteArray2.data, 0, parsableByteArray.bytesLeft());
                AvcConfig parse = AvcConfig.parse(parsableByteArray2);
                this.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                this.output.format(Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, parse.width, parse.height, -1.0f, parse.initializationData, -1, parse.pixelWidthAspectRatio, null));
                this.hasOutputFormat = true;
            } else if (readUnsignedByte == 1 && this.hasOutputFormat) {
                byte[] bArr = this.nalLength.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i = 4 - this.nalUnitLengthFieldLength;
                int i2 = 0;
                while (parsableByteArray.bytesLeft() > 0) {
                    parsableByteArray.readBytes(this.nalLength.data, i, this.nalUnitLengthFieldLength);
                    this.nalLength.setPosition(0);
                    int readUnsignedIntToInt = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    this.output.sampleData(this.nalStartCode, 4);
                    this.output.sampleData(parsableByteArray, readUnsignedIntToInt);
                    i2 = i2 + 4 + readUnsignedIntToInt;
                }
                this.output.sampleMetadata(readInt24, this.frameType == 1 ? 1 : 0, i2, 0, null);
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
