package com.google.android.exoplayer2.extractor.mkv;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = 0;
            extractorInput.peekFully(this.scratch.data, 0, 1);
            int i2 = this.scratch.data[0] & 255;
            if (i2 == 0) {
                return Long.MIN_VALUE;
            }
            int i3 = 128;
            int i4 = 0;
            while ((i2 & i3) == 0) {
                i3 >>= 1;
                i4++;
            }
            int i5 = i2 & (~i3);
            extractorInput.peekFully(this.scratch.data, 1, i4);
            while (i < i4) {
                i++;
                i5 = (this.scratch.data[i] & 255) + (i5 << 8);
            }
            this.peekLength += i4 + 1;
            return i5;
        }
        return invokeL.longValue;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        long readUint;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, extractorInput)) != null) {
            return invokeL.booleanValue;
        }
        long length = extractorInput.getLength();
        long j = 1024;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i2 != 0 && length <= 1024) {
            j = length;
        }
        int i3 = (int) j;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i4 = this.peekLength + 1;
            this.peekLength = i4;
            if (i4 == i3) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.scratch.data[0] & 255);
        }
        long readUint2 = readUint(extractorInput);
        long j2 = this.peekLength;
        if (readUint2 == Long.MIN_VALUE) {
            return false;
        }
        if (i2 != 0 && j2 + readUint2 >= length) {
            return false;
        }
        while (true) {
            int i5 = this.peekLength;
            long j3 = j2 + readUint2;
            if (i5 >= j3) {
                return ((long) i5) == j3;
            } else if (readUint(extractorInput) != Long.MIN_VALUE && (readUint(extractorInput)) >= 0 && readUint <= 2147483647L) {
                if (i != 0) {
                    extractorInput.advancePeekPosition((int) readUint);
                    this.peekLength = (int) (this.peekLength + readUint);
                }
            }
        }
    }
}
