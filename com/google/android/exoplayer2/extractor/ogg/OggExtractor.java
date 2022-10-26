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
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes7.dex */
public class OggExtractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExtractorsFactory FACTORY;
    public static final int MAX_VERIFICATION_BYTES = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public ExtractorOutput output;
    public StreamReader streamReader;
    public boolean streamReaderInitialized;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1176282077, "Lcom/google/android/exoplayer2/extractor/ogg/OggExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1176282077, "Lcom/google/android/exoplayer2/extractor/ogg/OggExtractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ogg.OggExtractor.1
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new OggExtractor()} : (Extractor[]) invokeV.objValue;
            }
        };
    }

    public OggExtractor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ParsableByteArray resetPosition(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(0);
            return parsableByteArray;
        }
        return (ParsableByteArray) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorOutput) == null) {
            this.output = extractorOutput;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) {
            try {
                return sniffInternal(extractorInput);
            } catch (ParserException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean sniffInternal(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, extractorInput)) == null) {
            OggPageHeader oggPageHeader = new OggPageHeader();
            if (oggPageHeader.populate(extractorInput, true) && (oggPageHeader.type & 2) == 2) {
                int min = Math.min(oggPageHeader.bodySize, 8);
                ParsableByteArray parsableByteArray = new ParsableByteArray(min);
                extractorInput.peekFully(parsableByteArray.data, 0, min);
                if (FlacReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                    this.streamReader = new FlacReader();
                } else if (VorbisReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                    this.streamReader = new VorbisReader();
                } else if (OpusReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                    this.streamReader = new OpusReader();
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput, positionHolder)) == null) {
            if (this.streamReader == null) {
                if (sniffInternal(extractorInput)) {
                    extractorInput.resetPeekPosition();
                } else {
                    throw new ParserException("Failed to determine bitstream type");
                }
            }
            if (!this.streamReaderInitialized) {
                TrackOutput track = this.output.track(0, 1);
                this.output.endTracks();
                this.streamReader.init(this.output, track);
                this.streamReaderInitialized = true;
            }
            return this.streamReader.read(extractorInput, positionHolder);
        }
        return invokeLL.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        StreamReader streamReader;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (streamReader = this.streamReader) != null) {
            streamReader.seek(j, j2);
        }
    }
}
