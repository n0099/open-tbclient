package com.google.android.exoplayer2.extractor.mkv;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class Sniffer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ID_EBML = 440786851;
    public static final int SEARCH_LENGTH = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public int peekLength;
    public final ParsableByteArray scratch;

    public Sniffer() {
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
        this.scratch = new ParsableByteArray(8);
    }

    private long readUint(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, extractorInput)) == null) {
            int i2 = 0;
            extractorInput.peekFully(this.scratch.data, 0, 1);
            int i3 = this.scratch.data[0] & 255;
            if (i3 == 0) {
                return Long.MIN_VALUE;
            }
            int i4 = 128;
            int i5 = 0;
            while ((i3 & i4) == 0) {
                i4 >>= 1;
                i5++;
            }
            int i6 = i3 & (~i4);
            extractorInput.peekFully(this.scratch.data, 1, i5);
            while (i2 < i5) {
                i2++;
                i6 = (this.scratch.data[i2] & 255) + (i6 << 8);
            }
            this.peekLength += i5 + 1;
            return i6;
        }
        return invokeL.longValue;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        long readUint;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, extractorInput)) != null) {
            return invokeL.booleanValue;
        }
        long length = extractorInput.getLength();
        long j2 = 1024;
        int i3 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i3 != 0 && length <= 1024) {
            j2 = length;
        }
        int i4 = (int) j2;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i5 = this.peekLength + 1;
            this.peekLength = i5;
            if (i5 == i4) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.scratch.data[0] & 255);
        }
        long readUint2 = readUint(extractorInput);
        long j3 = this.peekLength;
        if (readUint2 == Long.MIN_VALUE) {
            return false;
        }
        if (i3 != 0 && j3 + readUint2 >= length) {
            return false;
        }
        while (true) {
            int i6 = this.peekLength;
            long j4 = j3 + readUint2;
            if (i6 >= j4) {
                return ((long) i6) == j4;
            } else if (readUint(extractorInput) != Long.MIN_VALUE && (readUint(extractorInput)) >= 0 && readUint <= 2147483647L) {
                if (i2 != 0) {
                    extractorInput.advancePeekPosition((int) readUint);
                    this.peekLength = (int) (this.peekLength + readUint);
                }
            }
        }
    }
}
