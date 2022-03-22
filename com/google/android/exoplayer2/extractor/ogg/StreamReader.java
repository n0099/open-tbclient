package com.google.android.exoplayer2.extractor.ogg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class StreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_END_OF_INPUT = 3;
    public static final int STATE_READ_HEADERS = 0;
    public static final int STATE_READ_PAYLOAD = 2;
    public static final int STATE_SKIP_HEADERS = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public long currentGranule;
    public ExtractorOutput extractorOutput;
    public boolean formatSet;
    public long lengthOfReadPacket;
    public final OggPacket oggPacket;
    public OggSeeker oggSeeker;
    public long payloadStartPosition;
    public int sampleRate;
    public boolean seekMapSet;
    public SetupData setupData;
    public int state;
    public long targetGranule;
    public TrackOutput trackOutput;

    /* renamed from: com.google.android.exoplayer2.extractor.ogg.StreamReader$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class SetupData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Format format;
        public OggSeeker oggSeeker;

        public SetupData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class UnseekableOggSeeker implements OggSeeker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public UnseekableOggSeeker() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new SeekMap.Unseekable(C.TIME_UNSET) : (SeekMap) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput)) == null) {
                return -1L;
            }
            return invokeL.longValue;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long startSeek(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }

        public /* synthetic */ UnseekableOggSeeker(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public StreamReader() {
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
        this.oggPacket = new OggPacket();
    }

    private int readHeaders(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, extractorInput)) == null) {
            boolean z = true;
            while (z) {
                if (!this.oggPacket.populate(extractorInput)) {
                    this.state = 3;
                    return -1;
                }
                this.lengthOfReadPacket = extractorInput.getPosition() - this.payloadStartPosition;
                z = readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
                if (z) {
                    this.payloadStartPosition = extractorInput.getPosition();
                }
            }
            Format format = this.setupData.format;
            this.sampleRate = format.sampleRate;
            if (!this.formatSet) {
                this.trackOutput.format(format);
                this.formatSet = true;
            }
            OggSeeker oggSeeker = this.setupData.oggSeeker;
            if (oggSeeker != null) {
                this.oggSeeker = oggSeeker;
            } else if (extractorInput.getLength() == -1) {
                this.oggSeeker = new UnseekableOggSeeker(null);
            } else {
                OggPageHeader pageHeader = this.oggPacket.getPageHeader();
                this.oggSeeker = new DefaultOggSeeker(this.payloadStartPosition, extractorInput.getLength(), this, pageHeader.headerSize + pageHeader.bodySize, pageHeader.granulePosition);
            }
            this.setupData = null;
            this.state = 2;
            this.oggPacket.trimPayload();
            return 0;
        }
        return invokeL.intValue;
    }

    private int readPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, extractorInput, positionHolder)) == null) {
            long read = this.oggSeeker.read(extractorInput);
            if (read >= 0) {
                positionHolder.position = read;
                return 1;
            }
            if (read < -1) {
                onSeekEnd(-(read + 2));
            }
            if (!this.seekMapSet) {
                this.extractorOutput.seekMap(this.oggSeeker.createSeekMap());
                this.seekMapSet = true;
            }
            if (this.lengthOfReadPacket <= 0 && !this.oggPacket.populate(extractorInput)) {
                this.state = 3;
                return -1;
            }
            this.lengthOfReadPacket = 0L;
            ParsableByteArray payload = this.oggPacket.getPayload();
            long preparePayload = preparePayload(payload);
            if (preparePayload >= 0) {
                long j = this.currentGranule;
                if (j + preparePayload >= this.targetGranule) {
                    long convertGranuleToTime = convertGranuleToTime(j);
                    this.trackOutput.sampleData(payload, payload.limit());
                    this.trackOutput.sampleMetadata(convertGranuleToTime, 1, payload.limit(), 0, null);
                    this.targetGranule = -1L;
                }
            }
            this.currentGranule += preparePayload;
            return 0;
        }
        return invokeLL.intValue;
    }

    public long convertGranuleToTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? (j * 1000000) / this.sampleRate : invokeJ.longValue;
    }

    public long convertTimeToGranule(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? (this.sampleRate * j) / 1000000 : invokeJ.longValue;
    }

    public void init(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, extractorOutput, trackOutput) == null) {
            this.extractorOutput = extractorOutput;
            this.trackOutput = trackOutput;
            reset(true);
        }
    }

    public void onSeekEnd(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.currentGranule = j;
        }
    }

    public abstract long preparePayload(ParsableByteArray parsableByteArray);

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, extractorInput, positionHolder)) == null) {
            int i = this.state;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return readPayload(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                }
                extractorInput.skipFully((int) this.payloadStartPosition);
                this.state = 2;
                return 0;
            }
            return readHeaders(extractorInput);
        }
        return invokeLL.intValue;
    }

    public abstract boolean readHeaders(ParsableByteArray parsableByteArray, long j, SetupData setupData) throws IOException, InterruptedException;

    public void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.setupData = new SetupData();
                this.payloadStartPosition = 0L;
                this.state = 0;
            } else {
                this.state = 1;
            }
            this.targetGranule = -1L;
            this.currentGranule = 0L;
        }
    }

    public final void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.oggPacket.reset();
            if (j == 0) {
                reset(!this.seekMapSet);
            } else if (this.state != 0) {
                this.targetGranule = this.oggSeeker.startSeek(j2);
                this.state = 2;
            }
        }
    }
}
