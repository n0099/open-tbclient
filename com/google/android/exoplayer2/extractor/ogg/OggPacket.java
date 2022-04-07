package com.google.android.exoplayer2.extractor.ogg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class OggPacket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentSegmentIndex;
    public final ParsableByteArray packetArray;
    public final OggPageHeader pageHeader;
    public boolean populated;
    public int segmentCount;

    public OggPacket() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pageHeader = new OggPageHeader();
        this.packetArray = new ParsableByteArray(new byte[65025], 0);
        this.currentSegmentIndex = -1;
    }

    private int calculatePacketSize(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            int i3 = 0;
            this.segmentCount = 0;
            do {
                int i4 = this.segmentCount;
                int i5 = i + i4;
                OggPageHeader oggPageHeader = this.pageHeader;
                if (i5 >= oggPageHeader.pageSegmentCount) {
                    break;
                }
                int[] iArr = oggPageHeader.laces;
                this.segmentCount = i4 + 1;
                i2 = iArr[i4 + i];
                i3 += i2;
            } while (i2 == 255);
            return i3;
        }
        return invokeI.intValue;
    }

    public OggPageHeader getPageHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.pageHeader : (OggPageHeader) invokeV.objValue;
    }

    public ParsableByteArray getPayload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.packetArray : (ParsableByteArray) invokeV.objValue;
    }

    public boolean populate(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extractorInput)) == null) {
            Assertions.checkState(extractorInput != null);
            if (this.populated) {
                this.populated = false;
                this.packetArray.reset();
            }
            while (!this.populated) {
                if (this.currentSegmentIndex < 0) {
                    if (!this.pageHeader.populate(extractorInput, true)) {
                        return false;
                    }
                    OggPageHeader oggPageHeader = this.pageHeader;
                    int i2 = oggPageHeader.headerSize;
                    if ((oggPageHeader.type & 1) == 1 && this.packetArray.limit() == 0) {
                        i2 += calculatePacketSize(0);
                        i = this.segmentCount + 0;
                    } else {
                        i = 0;
                    }
                    extractorInput.skipFully(i2);
                    this.currentSegmentIndex = i;
                }
                int calculatePacketSize = calculatePacketSize(this.currentSegmentIndex);
                int i3 = this.currentSegmentIndex + this.segmentCount;
                if (calculatePacketSize > 0) {
                    if (this.packetArray.capacity() < this.packetArray.limit() + calculatePacketSize) {
                        ParsableByteArray parsableByteArray = this.packetArray;
                        parsableByteArray.data = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit() + calculatePacketSize);
                    }
                    ParsableByteArray parsableByteArray2 = this.packetArray;
                    extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), calculatePacketSize);
                    ParsableByteArray parsableByteArray3 = this.packetArray;
                    parsableByteArray3.setLimit(parsableByteArray3.limit() + calculatePacketSize);
                    this.populated = this.pageHeader.laces[i3 + (-1)] != 255;
                }
                if (i3 == this.pageHeader.pageSegmentCount) {
                    i3 = -1;
                }
                this.currentSegmentIndex = i3;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.pageHeader.reset();
            this.packetArray.reset();
            this.currentSegmentIndex = -1;
            this.populated = false;
        }
    }

    public void trimPayload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ParsableByteArray parsableByteArray = this.packetArray;
            byte[] bArr = parsableByteArray.data;
            if (bArr.length == 65025) {
                return;
            }
            parsableByteArray.data = Arrays.copyOf(bArr, Math.max(65025, parsableByteArray.limit()));
        }
    }
}
