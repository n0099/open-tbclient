package com.google.android.exoplayer2.extractor.flv;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class FlvExtractor implements Extractor, SeekMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExtractorsFactory FACTORY;
    public static final int FLV_HEADER_SIZE = 9;
    public static final int FLV_TAG;
    public static final int FLV_TAG_HEADER_SIZE = 11;
    public static final int STATE_READING_FLV_HEADER = 1;
    public static final int STATE_READING_TAG_DATA = 4;
    public static final int STATE_READING_TAG_HEADER = 3;
    public static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
    public static final int TAG_TYPE_AUDIO = 8;
    public static final int TAG_TYPE_SCRIPT_DATA = 18;
    public static final int TAG_TYPE_VIDEO = 9;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioTagPayloadReader audioReader;
    public int bytesToNextTagHeader;
    public ExtractorOutput extractorOutput;
    public final ParsableByteArray headerBuffer;
    public ScriptTagPayloadReader metadataReader;
    public int parserState;
    public final ParsableByteArray scratch;
    public final ParsableByteArray tagData;
    public int tagDataSize;
    public final ParsableByteArray tagHeaderBuffer;
    public long tagTimestampUs;
    public int tagType;
    public VideoTagPayloadReader videoReader;

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return 0L;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1726226785, "Lcom/google/android/exoplayer2/extractor/flv/FlvExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1726226785, "Lcom/google/android/exoplayer2/extractor/flv/FlvExtractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.flv.FlvExtractor.1
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new FlvExtractor()} : (Extractor[]) invokeV.objValue;
            }
        };
        FLV_TAG = Util.getIntegerCodeForString("FLV");
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.metadataReader.getDurationUs();
        }
        return invokeV.longValue;
    }

    public FlvExtractor() {
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
        this.scratch = new ParsableByteArray(4);
        this.headerBuffer = new ParsableByteArray(9);
        this.tagHeaderBuffer = new ParsableByteArray(11);
        this.tagData = new ParsableByteArray();
        this.parserState = 1;
    }

    private ParsableByteArray prepareTagData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, extractorInput)) == null) {
            if (this.tagDataSize > this.tagData.capacity()) {
                ParsableByteArray parsableByteArray = this.tagData;
                parsableByteArray.reset(new byte[Math.max(parsableByteArray.capacity() * 2, this.tagDataSize)], 0);
            } else {
                this.tagData.setPosition(0);
            }
            this.tagData.setLimit(this.tagDataSize);
            extractorInput.readFully(this.tagData.data, 0, this.tagDataSize);
            return this.tagData;
        }
        return (ParsableByteArray) invokeL.objValue;
    }

    private boolean readTagData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        boolean z;
        ScriptTagPayloadReader scriptTagPayloadReader;
        VideoTagPayloadReader videoTagPayloadReader;
        AudioTagPayloadReader audioTagPayloadReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, extractorInput)) == null) {
            if (this.tagType == 8 && (audioTagPayloadReader = this.audioReader) != null) {
                audioTagPayloadReader.consume(prepareTagData(extractorInput), this.tagTimestampUs);
            } else if (this.tagType == 9 && (videoTagPayloadReader = this.videoReader) != null) {
                videoTagPayloadReader.consume(prepareTagData(extractorInput), this.tagTimestampUs);
            } else if (this.tagType == 18 && (scriptTagPayloadReader = this.metadataReader) != null) {
                scriptTagPayloadReader.consume(prepareTagData(extractorInput), this.tagTimestampUs);
            } else {
                extractorInput.skipFully(this.tagDataSize);
                z = false;
                this.bytesToNextTagHeader = 4;
                this.parserState = 2;
                return z;
            }
            z = true;
            this.bytesToNextTagHeader = 4;
            this.parserState = 2;
            return z;
        }
        return invokeL.booleanValue;
    }

    private boolean readTagHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, extractorInput)) == null) {
            if (!extractorInput.readFully(this.tagHeaderBuffer.data, 0, 11, true)) {
                return false;
            }
            this.tagHeaderBuffer.setPosition(0);
            this.tagType = this.tagHeaderBuffer.readUnsignedByte();
            this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
            this.tagTimestampUs = this.tagHeaderBuffer.readUnsignedInt24();
            this.tagTimestampUs = ((this.tagHeaderBuffer.readUnsignedByte() << 24) | this.tagTimestampUs) * 1000;
            this.tagHeaderBuffer.skipBytes(3);
            this.parserState = 4;
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean readFlvHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, extractorInput)) == null) {
            boolean z2 = false;
            if (!extractorInput.readFully(this.headerBuffer.data, 0, 9, true)) {
                return false;
            }
            this.headerBuffer.setPosition(0);
            this.headerBuffer.skipBytes(4);
            int readUnsignedByte = this.headerBuffer.readUnsignedByte();
            if ((readUnsignedByte & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((readUnsignedByte & 1) != 0) {
                z2 = true;
            }
            if (z && this.audioReader == null) {
                this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
            }
            if (z2 && this.videoReader == null) {
                this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
            }
            if (this.metadataReader == null) {
                this.metadataReader = new ScriptTagPayloadReader(null);
            }
            this.extractorOutput.endTracks();
            this.extractorOutput.seekMap(this);
            this.bytesToNextTagHeader = (this.headerBuffer.readInt() - 9) + 4;
            this.parserState = 2;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, extractorInput)) == null) {
            extractorInput.peekFully(this.scratch.data, 0, 3);
            this.scratch.setPosition(0);
            if (this.scratch.readUnsignedInt24() != FLV_TAG) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 2);
            this.scratch.setPosition(0);
            if ((this.scratch.readUnsignedShort() & 250) != 0) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 4);
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition(readInt);
            extractorInput.peekFully(this.scratch.data, 0, 4);
            this.scratch.setPosition(0);
            if (this.scratch.readInt() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void skipToTagHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, extractorInput) == null) {
            extractorInput.skipFully(this.bytesToNextTagHeader);
            this.bytesToNextTagHeader = 0;
            this.parserState = 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extractorOutput) == null) {
            this.extractorOutput = extractorOutput;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, extractorInput, positionHolder)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i = this.parserState;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && readTagData(extractorInput)) {
                            return 0;
                        }
                    } else if (!readTagHeader(extractorInput)) {
                        return -1;
                    }
                } else {
                    skipToTagHeader(extractorInput);
                }
            } else if (!readFlvHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.parserState = 1;
            this.bytesToNextTagHeader = 0;
        }
    }
}
