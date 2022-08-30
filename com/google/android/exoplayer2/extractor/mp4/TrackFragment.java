package com.google.android.exoplayer2.extractor.mp4;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class TrackFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int[] sampleCompositionTimeOffsetTable;
    public int sampleCount;
    public long[] sampleDecodingTimeTable;
    public ParsableByteArray sampleEncryptionData;
    public int sampleEncryptionDataLength;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable;
    public boolean[] sampleIsSyncFrameTable;
    public int[] sampleSizeTable;
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition;
    public int[] trunLength;

    public TrackFragment() {
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

    public void fillEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorInput) == null) {
            extractorInput.readFully(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
            this.sampleEncryptionData.setPosition(0);
            this.sampleEncryptionDataNeedsFill = false;
        }
    }

    public long getSamplePresentationTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.sampleDecodingTimeTable[i] + this.sampleCompositionTimeOffsetTable[i] : invokeI.longValue;
    }

    public void initEncryptionData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            ParsableByteArray parsableByteArray = this.sampleEncryptionData;
            if (parsableByteArray == null || parsableByteArray.limit() < i) {
                this.sampleEncryptionData = new ParsableByteArray(i);
            }
            this.sampleEncryptionDataLength = i;
            this.definesEncryptionData = true;
            this.sampleEncryptionDataNeedsFill = true;
        }
    }

    public void initTables(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.trunCount = i;
            this.sampleCount = i2;
            int[] iArr = this.trunLength;
            if (iArr == null || iArr.length < i) {
                this.trunDataPosition = new long[i];
                this.trunLength = new int[i];
            }
            int[] iArr2 = this.sampleSizeTable;
            if (iArr2 == null || iArr2.length < i2) {
                int i3 = (i2 * 125) / 100;
                this.sampleSizeTable = new int[i3];
                this.sampleCompositionTimeOffsetTable = new int[i3];
                this.sampleDecodingTimeTable = new long[i3];
                this.sampleIsSyncFrameTable = new boolean[i3];
                this.sampleHasSubsampleEncryptionTable = new boolean[i3];
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.trunCount = 0;
            this.nextFragmentDecodeTime = 0L;
            this.definesEncryptionData = false;
            this.sampleEncryptionDataNeedsFill = false;
            this.trackEncryptionBox = null;
        }
    }

    public void fillEncryptionData(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parsableByteArray) == null) {
            parsableByteArray.readBytes(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
            this.sampleEncryptionData.setPosition(0);
            this.sampleEncryptionDataNeedsFill = false;
        }
    }
}
