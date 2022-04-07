package com.google.android.exoplayer2.extractor.ogg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class OggPageHeader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EMPTY_PAGE_HEADER_SIZE = 27;
    public static final int MAX_PAGE_PAYLOAD = 65025;
    public static final int MAX_PAGE_SIZE = 65307;
    public static final int MAX_SEGMENT_COUNT = 255;
    public static final int TYPE_OGGS;
    public transient /* synthetic */ FieldHolder $fh;
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public final int[] laces;
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    public final ParsableByteArray scratch;
    public long streamSerialNumber;
    public int type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-89755335, "Lcom/google/android/exoplayer2/extractor/ogg/OggPageHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-89755335, "Lcom/google/android/exoplayer2/extractor/ogg/OggPageHeader;");
                return;
            }
        }
        TYPE_OGGS = Util.getIntegerCodeForString("OggS");
    }

    public OggPageHeader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.laces = new int[255];
        this.scratch = new ParsableByteArray(255);
    }

    public boolean populate(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, extractorInput, z)) == null) {
            this.scratch.reset();
            reset();
            if ((extractorInput.getLength() == -1 || extractorInput.getLength() - extractorInput.getPeekPosition() >= 27) && extractorInput.peekFully(this.scratch.data, 0, 27, true)) {
                if (this.scratch.readUnsignedInt() != TYPE_OGGS) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int readUnsignedByte = this.scratch.readUnsignedByte();
                    this.revision = readUnsignedByte;
                    if (readUnsignedByte != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.type = this.scratch.readUnsignedByte();
                    this.granulePosition = this.scratch.readLittleEndianLong();
                    this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
                    this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
                    this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
                    int readUnsignedByte2 = this.scratch.readUnsignedByte();
                    this.pageSegmentCount = readUnsignedByte2;
                    this.headerSize = readUnsignedByte2 + 27;
                    this.scratch.reset();
                    extractorInput.peekFully(this.scratch.data, 0, this.pageSegmentCount);
                    for (int i = 0; i < this.pageSegmentCount; i++) {
                        this.laces[i] = this.scratch.readUnsignedByte();
                        this.bodySize += this.laces[i];
                    }
                    return true;
                }
            }
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        return invokeLZ.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.revision = 0;
            this.type = 0;
            this.granulePosition = 0L;
            this.streamSerialNumber = 0L;
            this.pageSequenceNumber = 0L;
            this.pageChecksum = 0L;
            this.pageSegmentCount = 0;
            this.headerSize = 0;
            this.bodySize = 0;
        }
    }
}
