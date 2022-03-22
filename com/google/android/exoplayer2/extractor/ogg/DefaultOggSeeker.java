package com.google.android.exoplayer2.extractor.ogg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class DefaultOggSeeker implements OggSeeker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_OFFSET = 30000;
    public static final int MATCH_BYTE_RANGE = 100000;
    public static final int MATCH_RANGE = 72000;
    public static final int STATE_IDLE = 3;
    public static final int STATE_READ_LAST_PAGE = 1;
    public static final int STATE_SEEK = 2;
    public static final int STATE_SEEK_TO_END = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public long end;
    public long endGranule;
    public final long endPosition;
    public final OggPageHeader pageHeader;
    public long positionBeforeSeekToEnd;
    public long start;
    public long startGranule;
    public final long startPosition;
    public int state;
    public final StreamReader streamReader;
    public long targetGranule;
    public long totalGranules;

    /* renamed from: com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class OggSeekMap implements SeekMap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultOggSeeker this$0;

        public OggSeekMap(DefaultOggSeeker defaultOggSeeker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultOggSeeker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultOggSeeker;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.streamReader.convertGranuleToTime(this.this$0.totalGranules) : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getPosition(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                if (j == 0) {
                    return this.this$0.startPosition;
                }
                long convertTimeToGranule = this.this$0.streamReader.convertTimeToGranule(j);
                DefaultOggSeeker defaultOggSeeker = this.this$0;
                return defaultOggSeeker.getEstimatedPosition(defaultOggSeeker.startPosition, convertTimeToGranule, 30000L);
            }
            return invokeJ.longValue;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ OggSeekMap(DefaultOggSeeker defaultOggSeeker, AnonymousClass1 anonymousClass1) {
            this(defaultOggSeeker);
        }
    }

    public DefaultOggSeeker(long j, long j2, StreamReader streamReader, int i, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), streamReader, Integer.valueOf(i), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pageHeader = new OggPageHeader();
        Assertions.checkArgument(j >= 0 && j2 > j);
        this.streamReader = streamReader;
        this.startPosition = j;
        this.endPosition = j2;
        if (i == j2 - j) {
            this.totalGranules = j3;
            this.state = 3;
            return;
        }
        this.state = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEstimatedPosition(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = this.endPosition;
            long j5 = this.startPosition;
            long j6 = j + (((j2 * (j4 - j5)) / this.totalGranules) - j3);
            if (j6 >= j5) {
                j5 = j6;
            }
            long j7 = this.endPosition;
            return j5 >= j7 ? j7 - 1 : j5;
        }
        return invokeCommon.longValue;
    }

    public long getNextSeekPosition(long j, ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, extractorInput)) == null) {
            if (this.start == this.end) {
                return -(this.startGranule + 2);
            }
            long position = extractorInput.getPosition();
            if (!skipToNextPage(extractorInput, this.end)) {
                long j2 = this.start;
                if (j2 != position) {
                    return j2;
                }
                throw new IOException("No ogg page can be found.");
            }
            this.pageHeader.populate(extractorInput, false);
            extractorInput.resetPeekPosition();
            OggPageHeader oggPageHeader = this.pageHeader;
            long j3 = j - oggPageHeader.granulePosition;
            int i = oggPageHeader.headerSize + oggPageHeader.bodySize;
            int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            if (i2 >= 0 && j3 <= 72000) {
                extractorInput.skipFully(i);
                return -(this.pageHeader.granulePosition + 2);
            }
            if (i2 < 0) {
                this.end = position;
                this.endGranule = this.pageHeader.granulePosition;
            } else {
                long j4 = i;
                long position2 = extractorInput.getPosition() + j4;
                this.start = position2;
                this.startGranule = this.pageHeader.granulePosition;
                if ((this.end - position2) + j4 < 100000) {
                    extractorInput.skipFully(i);
                    return -(this.startGranule + 2);
                }
            }
            long j5 = this.end;
            long j6 = this.start;
            if (j5 - j6 < 100000) {
                this.end = j6;
                return j6;
            }
            long position3 = extractorInput.getPosition() - (i * (i2 <= 0 ? 2 : 1));
            long j7 = this.end;
            long j8 = this.start;
            return Math.min(Math.max(position3 + ((j3 * (j7 - j8)) / (this.endGranule - this.startGranule)), j8), this.end - 1);
        }
        return invokeJL.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, extractorInput)) == null) {
            int i = this.state;
            if (i == 0) {
                long position = extractorInput.getPosition();
                this.positionBeforeSeekToEnd = position;
                this.state = 1;
                long j = this.endPosition - 65307;
                if (j > position) {
                    return j;
                }
            } else if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                long j2 = this.targetGranule;
                long j3 = 0;
                if (j2 != 0) {
                    long nextSeekPosition = getNextSeekPosition(j2, extractorInput);
                    if (nextSeekPosition >= 0) {
                        return nextSeekPosition;
                    }
                    j3 = skipToPageOfGranule(extractorInput, this.targetGranule, -(nextSeekPosition + 2));
                }
                this.state = 3;
                return -(j3 + 2);
            }
            this.totalGranules = readGranuleOfLastPage(extractorInput);
            this.state = 3;
            return this.positionBeforeSeekToEnd;
        }
        return invokeL.longValue;
    }

    public long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) {
            skipToNextPage(extractorInput);
            this.pageHeader.reset();
            while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
                this.pageHeader.populate(extractorInput, false);
                OggPageHeader oggPageHeader = this.pageHeader;
                extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
            }
            return this.pageHeader.granulePosition;
        }
        return invokeL.longValue;
    }

    public void resetSeeking() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.start = this.startPosition;
            this.end = this.endPosition;
            this.startGranule = 0L;
            this.endGranule = this.totalGranules;
        }
    }

    public void skipToNextPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, extractorInput) == null) && !skipToNextPage(extractorInput, this.endPosition)) {
            throw new EOFException();
        }
    }

    public long skipToPageOfGranule(ExtractorInput extractorInput, long j, long j2) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{extractorInput, Long.valueOf(j), Long.valueOf(j2)})) != null) {
            return invokeCommon.longValue;
        }
        this.pageHeader.populate(extractorInput, false);
        while (true) {
            OggPageHeader oggPageHeader = this.pageHeader;
            if (oggPageHeader.granulePosition < j) {
                extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
                OggPageHeader oggPageHeader2 = this.pageHeader;
                long j3 = oggPageHeader2.granulePosition;
                oggPageHeader2.populate(extractorInput, false);
                j2 = j3;
            } else {
                extractorInput.resetPeekPosition();
                return j2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long startSeek(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            int i = this.state;
            Assertions.checkArgument(i == 3 || i == 2);
            this.targetGranule = j != 0 ? this.streamReader.convertTimeToGranule(j) : 0L;
            this.state = 2;
            resetSeeking();
            return this.targetGranule;
        }
        return invokeJ.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public OggSeekMap createSeekMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.totalGranules != 0) {
                return new OggSeekMap(this, null);
            }
            return null;
        }
        return (OggSeekMap) invokeV.objValue;
    }

    public boolean skipToNextPage(ExtractorInput extractorInput, long j) throws IOException, InterruptedException {
        InterceptResult invokeLJ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048583, this, extractorInput, j)) != null) {
            return invokeLJ.booleanValue;
        }
        long min = Math.min(j + 3, this.endPosition);
        int i2 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i3 = 0;
            if (extractorInput.getPosition() + i2 > min && (i2 = (int) (min - extractorInput.getPosition())) < 4) {
                return false;
            }
            extractorInput.peekFully(bArr, 0, i2, false);
            while (true) {
                i = i2 - 3;
                if (i3 < i) {
                    if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        extractorInput.skipFully(i3);
                        return true;
                    }
                    i3++;
                }
            }
            extractorInput.skipFully(i);
        }
    }
}
