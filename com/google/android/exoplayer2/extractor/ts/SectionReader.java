package com.google.android.exoplayer2.extractor.ts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes6.dex */
public final class SectionReader implements TsPayloadReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SECTION_BUFFER_LENGTH = 32;
    public static final int MAX_SECTION_LENGTH = 4098;
    public static final int SECTION_HEADER_LENGTH = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int bytesRead;
    public final SectionPayloadReader reader;
    public final ParsableByteArray sectionData;
    public boolean sectionSyntaxIndicator;
    public int totalSectionLength;
    public boolean waitingForPayloadStart;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sectionPayloadReader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reader = sectionPayloadReader;
        this.sectionData = new ParsableByteArray(32);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void consume(ParsableByteArray parsableByteArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, parsableByteArray, z) == null) {
            int position = z ? parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte() : -1;
            if (this.waitingForPayloadStart) {
                if (!z) {
                    return;
                }
                this.waitingForPayloadStart = false;
                parsableByteArray.setPosition(position);
                this.bytesRead = 0;
            }
            while (parsableByteArray.bytesLeft() > 0) {
                int i = this.bytesRead;
                if (i < 3) {
                    if (i == 0) {
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        parsableByteArray.setPosition(parsableByteArray.getPosition() - 1);
                        if (readUnsignedByte == 255) {
                            this.waitingForPayloadStart = true;
                            return;
                        }
                    }
                    int min = Math.min(parsableByteArray.bytesLeft(), 3 - this.bytesRead);
                    parsableByteArray.readBytes(this.sectionData.data, this.bytesRead, min);
                    int i2 = this.bytesRead + min;
                    this.bytesRead = i2;
                    if (i2 == 3) {
                        this.sectionData.reset(3);
                        this.sectionData.skipBytes(1);
                        int readUnsignedByte2 = this.sectionData.readUnsignedByte();
                        int readUnsignedByte3 = this.sectionData.readUnsignedByte();
                        this.sectionSyntaxIndicator = (readUnsignedByte2 & 128) != 0;
                        this.totalSectionLength = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                        int capacity = this.sectionData.capacity();
                        int i3 = this.totalSectionLength;
                        if (capacity < i3) {
                            ParsableByteArray parsableByteArray2 = this.sectionData;
                            byte[] bArr = parsableByteArray2.data;
                            parsableByteArray2.reset(Math.min(4098, Math.max(i3, bArr.length * 2)));
                            System.arraycopy(bArr, 0, this.sectionData.data, 0, 3);
                        }
                    }
                } else {
                    int min2 = Math.min(parsableByteArray.bytesLeft(), this.totalSectionLength - this.bytesRead);
                    parsableByteArray.readBytes(this.sectionData.data, this.bytesRead, min2);
                    int i4 = this.bytesRead + min2;
                    this.bytesRead = i4;
                    int i5 = this.totalSectionLength;
                    if (i4 != i5) {
                        continue;
                    } else {
                        if (this.sectionSyntaxIndicator) {
                            if (Util.crc(this.sectionData.data, 0, i5, -1) != 0) {
                                this.waitingForPayloadStart = true;
                                return;
                            }
                            this.sectionData.reset(this.totalSectionLength - 4);
                        } else {
                            this.sectionData.reset(i5);
                        }
                        this.reader.consume(this.sectionData);
                        this.bytesRead = 0;
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timestampAdjuster, extractorOutput, trackIdGenerator) == null) {
            this.reader.init(timestampAdjuster, extractorOutput, trackIdGenerator);
            this.waitingForPayloadStart = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.waitingForPayloadStart = true;
        }
    }
}
