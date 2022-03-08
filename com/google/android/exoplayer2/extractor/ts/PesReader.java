package com.google.android.exoplayer2.extractor.ts;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
/* loaded from: classes7.dex */
public final class PesReader implements TsPayloadReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_SIZE = 9;
    public static final int MAX_HEADER_EXTENSION_SIZE = 10;
    public static final int PES_SCRATCH_SIZE = 10;
    public static final int STATE_FINDING_HEADER = 0;
    public static final int STATE_READING_BODY = 3;
    public static final int STATE_READING_HEADER = 1;
    public static final int STATE_READING_HEADER_EXTENSION = 2;
    public static final String TAG = "PesReader";
    public transient /* synthetic */ FieldHolder $fh;
    public int bytesRead;
    public boolean dataAlignmentIndicator;
    public boolean dtsFlag;
    public int extendedHeaderLength;
    public int payloadSize;
    public final ParsableBitArray pesScratch;
    public boolean ptsFlag;
    public final ElementaryStreamReader reader;
    public boolean seenFirstDts;
    public int state;
    public long timeUs;
    public TimestampAdjuster timestampAdjuster;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {elementaryStreamReader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reader = elementaryStreamReader;
        this.pesScratch = new ParsableBitArray(new byte[10]);
        this.state = 0;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, this, parsableByteArray, bArr, i2)) == null) {
            int min = Math.min(parsableByteArray.bytesLeft(), i2 - this.bytesRead);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                parsableByteArray.skipBytes(min);
            } else {
                parsableByteArray.readBytes(bArr, this.bytesRead, min);
            }
            int i3 = this.bytesRead + min;
            this.bytesRead = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    private boolean parseHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            this.pesScratch.setPosition(0);
            int readBits = this.pesScratch.readBits(24);
            if (readBits != 1) {
                r0 = "Unexpected start code prefix: " + readBits;
                this.payloadSize = -1;
                return false;
            }
            this.pesScratch.skipBits(8);
            int readBits2 = this.pesScratch.readBits(16);
            this.pesScratch.skipBits(5);
            this.dataAlignmentIndicator = this.pesScratch.readBit();
            this.pesScratch.skipBits(2);
            this.ptsFlag = this.pesScratch.readBit();
            this.dtsFlag = this.pesScratch.readBit();
            this.pesScratch.skipBits(6);
            int readBits3 = this.pesScratch.readBits(8);
            this.extendedHeaderLength = readBits3;
            if (readBits2 == 0) {
                this.payloadSize = -1;
            } else {
                this.payloadSize = ((readBits2 + 6) - 9) - readBits3;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void parseHeaderExtension() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.pesScratch.setPosition(0);
            this.timeUs = C.TIME_UNSET;
            if (this.ptsFlag) {
                this.pesScratch.skipBits(4);
                this.pesScratch.skipBits(1);
                this.pesScratch.skipBits(1);
                long readBits = (this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15);
                this.pesScratch.skipBits(1);
                if (!this.seenFirstDts && this.dtsFlag) {
                    this.pesScratch.skipBits(4);
                    this.pesScratch.skipBits(1);
                    this.pesScratch.skipBits(1);
                    this.pesScratch.skipBits(1);
                    this.timestampAdjuster.adjustTsTimestamp((this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15));
                    this.seenFirstDts = true;
                }
                this.timeUs = this.timestampAdjuster.adjustTsTimestamp(readBits);
            }
        }
    }

    private void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            this.state = i2;
            this.bytesRead = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void consume(ParsableByteArray parsableByteArray, boolean z) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, parsableByteArray, z) == null) {
            if (z) {
                if (this.state == 3) {
                    if (this.payloadSize != -1) {
                        String str = "Unexpected start indicator: expected " + this.payloadSize + " more bytes";
                    }
                    this.reader.packetFinished();
                }
                setState(1);
            }
            while (parsableByteArray.bytesLeft() > 0) {
                int i2 = this.state;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (continueRead(parsableByteArray, this.pesScratch.data, Math.min(10, this.extendedHeaderLength)) && continueRead(parsableByteArray, null, this.extendedHeaderLength)) {
                                parseHeaderExtension();
                                this.reader.packetStarted(this.timeUs, this.dataAlignmentIndicator);
                                setState(3);
                            }
                        } else if (i2 == 3) {
                            int bytesLeft = parsableByteArray.bytesLeft();
                            int i3 = this.payloadSize;
                            int i4 = i3 != -1 ? bytesLeft - i3 : 0;
                            if (i4 > 0) {
                                bytesLeft -= i4;
                                parsableByteArray.setLimit(parsableByteArray.getPosition() + bytesLeft);
                            }
                            this.reader.consume(parsableByteArray);
                            int i5 = this.payloadSize;
                            if (i5 != -1) {
                                int i6 = i5 - bytesLeft;
                                this.payloadSize = i6;
                                if (i6 == 0) {
                                    this.reader.packetFinished();
                                    setState(1);
                                }
                            }
                        }
                    } else if (continueRead(parsableByteArray, this.pesScratch.data, 9)) {
                        setState(parseHeader() ? 2 : 0);
                    }
                } else {
                    parsableByteArray.skipBytes(parsableByteArray.bytesLeft());
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timestampAdjuster, extractorOutput, trackIdGenerator) == null) {
            this.timestampAdjuster = timestampAdjuster;
            this.reader.createTracks(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.state = 0;
            this.bytesRead = 0;
            this.seenFirstDts = false;
            this.reader.seek();
        }
    }
}
