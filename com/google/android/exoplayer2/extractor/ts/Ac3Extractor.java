package com.google.android.exoplayer2.extractor.ts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class Ac3Extractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AC3_SYNC_WORD = 2935;
    public static final ExtractorsFactory FACTORY;
    public static final int ID3_TAG;
    public static final int MAX_SNIFF_BYTES = 8192;
    public static final int MAX_SYNC_FRAME_SIZE = 2786;
    public transient /* synthetic */ FieldHolder $fh;
    public final long firstSampleTimestampUs;
    public final Ac3Reader reader;
    public final ParsableByteArray sampleData;
    public boolean startedPacket;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2076313665, "Lcom/google/android/exoplayer2/extractor/ts/Ac3Extractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2076313665, "Lcom/google/android/exoplayer2/extractor/ts/Ac3Extractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.Ac3Extractor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
            public Extractor[] createExtractors() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new Ac3Extractor()} : (Extractor[]) invokeV.objValue;
            }
        };
        ID3_TAG = Util.getIntegerCodeForString("ID3");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Ac3Extractor() {
        this(0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorOutput) == null) {
            this.reader.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
            extractorOutput.endTracks();
            extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput, positionHolder)) == null) {
            int read = extractorInput.read(this.sampleData.data, 0, MAX_SYNC_FRAME_SIZE);
            if (read == -1) {
                return -1;
            }
            this.sampleData.setPosition(0);
            this.sampleData.setLimit(read);
            if (!this.startedPacket) {
                this.reader.packetStarted(this.firstSampleTimestampUs, true);
                this.startedPacket = true;
            }
            this.reader.consume(this.sampleData);
            return 0;
        }
        return invokeLL.intValue;
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
            this.startedPacket = false;
            this.reader.seek();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        r8.resetPeekPosition();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        if ((r4 - r3) < 8192) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        return false;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, extractorInput)) != null) {
            return invokeL.booleanValue;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.peekFully(parsableByteArray.data, 0, 10);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != ID3_TAG) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
            i += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                extractorInput.peekFully(parsableByteArray.data, 0, 5);
                parsableByteArray.setPosition(0);
                if (parsableByteArray.readUnsignedShort() != 2935) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                int parseAc3SyncframeSize = Ac3Util.parseAc3SyncframeSize(parsableByteArray.data);
                if (parseAc3SyncframeSize == -1) {
                    return false;
                }
                extractorInput.advancePeekPosition(parseAc3SyncframeSize - 5);
            }
            extractorInput.advancePeekPosition(i2);
        }
    }

    public Ac3Extractor(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.firstSampleTimestampUs = j;
        this.reader = new Ac3Reader();
        this.sampleData = new ParsableByteArray((int) MAX_SYNC_FRAME_SIZE);
    }
}
