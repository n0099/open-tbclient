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
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pageHeader = new OggPageHeader();
        this.packetArray = new ParsableByteArray(new byte[65025], 0);
        this.currentSegmentIndex = -1;
    }

    private int calculatePacketSize(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int i4 = 0;
            this.segmentCount = 0;
            do {
                int i5 = this.segmentCount;
                int i6 = i2 + i5;
                OggPageHeader oggPageHeader = this.pageHeader;
                if (i6 >= oggPageHeader.pageSegmentCount) {
                    break;
                }
                int[] iArr = oggPageHeader.laces;
                this.segmentCount = i5 + 1;
                i3 = iArr[i5 + i2];
                i4 += i3;
            } while (i3 == 255);
            return i4;
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
        int i2;
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
                    int i3 = oggPageHeader.headerSize;
                    if ((oggPageHeader.type & 1) == 1 && this.packetArray.limit() == 0) {
                        i3 += calculatePacketSize(0);
                        i2 = this.segmentCount + 0;
                    } else {
                        i2 = 0;
                    }
                    extractorInput.skipFully(i3);
                    this.currentSegmentIndex = i2;
                }
                int calculatePacketSize = calculatePacketSize(this.currentSegmentIndex);
                int i4 = this.currentSegmentIndex + this.segmentCount;
                if (calculatePacketSize > 0) {
                    if (this.packetArray.capacity() < this.packetArray.limit() + calculatePacketSize) {
                        ParsableByteArray parsableByteArray = this.packetArray;
                        parsableByteArray.data = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit() + calculatePacketSize);
                    }
                    ParsableByteArray parsableByteArray2 = this.packetArray;
                    extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), calculatePacketSize);
                    ParsableByteArray parsableByteArray3 = this.packetArray;
                    parsableByteArray3.setLimit(parsableByteArray3.limit() + calculatePacketSize);
                    this.populated = this.pageHeader.laces[i4 + (-1)] != 255;
                }
                if (i4 == this.pageHeader.pageSegmentCount) {
                    i4 = -1;
                }
                this.currentSegmentIndex = i4;
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
