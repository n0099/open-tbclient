package com.google.android.exoplayer2.extractor.rawcc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class RawCcExtractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_ID;
    public static final int HEADER_SIZE = 8;
    public static final int SCRATCH_SIZE = 9;
    public static final int STATE_READING_HEADER = 0;
    public static final int STATE_READING_SAMPLES = 2;
    public static final int STATE_READING_TIMESTAMP_AND_COUNT = 1;
    public static final int TIMESTAMP_SIZE_V0 = 4;
    public static final int TIMESTAMP_SIZE_V1 = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public final ParsableByteArray dataScratch;
    public final Format format;
    public int parserState;
    public int remainingSampleCount;
    public int sampleBytesWritten;
    public long timestampUs;
    public TrackOutput trackOutput;
    public int version;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2095673647, "Lcom/google/android/exoplayer2/extractor/rawcc/RawCcExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2095673647, "Lcom/google/android/exoplayer2/extractor/rawcc/RawCcExtractor;");
                return;
            }
        }
        HEADER_ID = Util.getIntegerCodeForString("RCC\u0001");
    }

    public RawCcExtractor(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {format};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.format = format;
        this.dataScratch = new ParsableByteArray(9);
        this.parserState = 0;
    }

    private boolean parseHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, extractorInput)) == null) {
            this.dataScratch.reset();
            if (extractorInput.readFully(this.dataScratch.data, 0, 8, true)) {
                if (this.dataScratch.readInt() == HEADER_ID) {
                    this.version = this.dataScratch.readUnsignedByte();
                    return true;
                }
                throw new IOException("Input not RawCC");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void parseSamples(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, extractorInput) == null) {
            while (this.remainingSampleCount > 0) {
                this.dataScratch.reset();
                extractorInput.readFully(this.dataScratch.data, 0, 3);
                this.trackOutput.sampleData(this.dataScratch, 3);
                this.sampleBytesWritten += 3;
                this.remainingSampleCount--;
            }
            int i = this.sampleBytesWritten;
            if (i > 0) {
                this.trackOutput.sampleMetadata(this.timestampUs, 1, i, 0, null);
            }
        }
    }

    private boolean parseTimestampAndSampleCount(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, extractorInput)) == null) {
            this.dataScratch.reset();
            int i = this.version;
            if (i == 0) {
                if (!extractorInput.readFully(this.dataScratch.data, 0, 5, true)) {
                    return false;
                }
                this.timestampUs = (this.dataScratch.readUnsignedInt() * 1000) / 45;
            } else if (i == 1) {
                if (!extractorInput.readFully(this.dataScratch.data, 0, 9, true)) {
                    return false;
                }
                this.timestampUs = this.dataScratch.readLong();
            } else {
                throw new ParserException("Unsupported version number: " + this.version);
            }
            this.remainingSampleCount = this.dataScratch.readUnsignedByte();
            this.sampleBytesWritten = 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorOutput) == null) {
            extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
            this.trackOutput = extractorOutput.track(0, 3);
            extractorOutput.endTracks();
            this.trackOutput.format(this.format);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput, positionHolder)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        parseSamples(extractorInput);
                        this.parserState = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (parseTimestampAndSampleCount(extractorInput)) {
                    this.parserState = 2;
                } else {
                    this.parserState = 0;
                    return -1;
                }
            } else if (!parseHeader(extractorInput)) {
                return -1;
            } else {
                this.parserState = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.parserState = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) {
            this.dataScratch.reset();
            extractorInput.peekFully(this.dataScratch.data, 0, 8);
            return this.dataScratch.readInt() == HEADER_ID;
        }
        return invokeL.booleanValue;
    }
}
