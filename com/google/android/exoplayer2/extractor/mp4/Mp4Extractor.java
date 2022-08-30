package com.google.android.exoplayer2.extractor.mp4;

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
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Stack;
/* loaded from: classes7.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BRAND_QUICKTIME;
    public static final ExtractorsFactory FACTORY;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    public static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    public static final int STATE_READING_ATOM_HEADER = 0;
    public static final int STATE_READING_ATOM_PAYLOAD = 1;
    public static final int STATE_READING_SAMPLE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public ParsableByteArray atomData;
    public final ParsableByteArray atomHeader;
    public int atomHeaderBytesRead;
    public long atomSize;
    public int atomType;
    public final Stack<Atom.ContainerAtom> containerAtoms;
    public long durationUs;
    public ExtractorOutput extractorOutput;
    public final int flags;
    public boolean isQuickTime;
    public final ParsableByteArray nalLength;
    public final ParsableByteArray nalStartCode;
    public int parserState;
    public int sampleBytesWritten;
    public int sampleCurrentNalBytesRemaining;
    public Mp4Track[] tracks;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Flags {
    }

    /* loaded from: classes7.dex */
    public static final class Mp4Track {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {track, trackSampleTable, trackOutput};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.track = track;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1792848033, "Lcom/google/android/exoplayer2/extractor/mp4/Mp4Extractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1792848033, "Lcom/google/android/exoplayer2/extractor/mp4/Mp4Extractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.1
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new Mp4Extractor()} : (Extractor[]) invokeV.objValue;
            }
        };
        BRAND_QUICKTIME = Util.getIntegerCodeForString("qt  ");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Mp4Extractor() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void enterReadingAtomHeaderState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.parserState = 0;
            this.atomHeaderBytesRead = 0;
        }
    }

    private int getTrackIndexOfEarliestCurrentSample() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) != null) {
            return invokeV.intValue;
        }
        int i = -1;
        long j = Long.MAX_VALUE;
        int i2 = 0;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i2 >= mp4TrackArr.length) {
                return i;
            }
            Mp4Track mp4Track = mp4TrackArr[i2];
            int i3 = mp4Track.sampleIndex;
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            if (i3 != trackSampleTable.sampleCount) {
                long j2 = trackSampleTable.offsets[i3];
                if (j2 < j) {
                    i = i2;
                    j = j2;
                }
            }
            i2++;
        }
    }

    private void processAtomEnded(long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65541, this, j) == null) {
            while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
                Atom.ContainerAtom pop = this.containerAtoms.pop();
                if (pop.type == Atom.TYPE_moov) {
                    processMoovAtom(pop);
                    this.containerAtoms.clear();
                    this.parserState = 2;
                } else if (!this.containerAtoms.isEmpty()) {
                    this.containerAtoms.peek().add(pop);
                }
            }
            if (this.parserState != 2) {
                enterReadingAtomHeaderState();
            }
        }
    }

    public static boolean processFtypAtom(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(8);
            if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                return true;
            }
            parsableByteArray.skipBytes(4);
            while (parsableByteArray.bytesLeft() > 0) {
                if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        Metadata metadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, containerAtom) == null) {
            ArrayList arrayList = new ArrayList();
            GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
            Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_udta);
            if (leafAtomOfType != null) {
                metadata = AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime);
                if (metadata != null) {
                    gaplessInfoHolder.setFromMetadata(metadata);
                }
            } else {
                metadata = null;
            }
            long j = C.TIME_UNSET;
            long j2 = Long.MAX_VALUE;
            for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
                Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
                if (containerAtom2.type == Atom.TYPE_trak) {
                    Track parseTrak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), C.TIME_UNSET, null, (this.flags & 1) != 0, this.isQuickTime);
                    if (parseTrak != null) {
                        TrackSampleTable parseStbl = AtomParsers.parseStbl(parseTrak, containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl), gaplessInfoHolder);
                        if (parseStbl.sampleCount != 0) {
                            Mp4Track mp4Track = new Mp4Track(parseTrak, parseStbl, this.extractorOutput.track(i, parseTrak.type));
                            Format copyWithMaxInputSize = parseTrak.format.copyWithMaxInputSize(parseStbl.maximumSize + 30);
                            if (parseTrak.type == 1) {
                                if (gaplessInfoHolder.hasGaplessInfo()) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding);
                                }
                                if (metadata != null) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithMetadata(metadata);
                                }
                            }
                            mp4Track.trackOutput.format(copyWithMaxInputSize);
                            long max = Math.max(j, parseTrak.durationUs);
                            arrayList.add(mp4Track);
                            long j3 = parseStbl.offsets[0];
                            if (j3 < j2) {
                                j = max;
                                j2 = j3;
                            } else {
                                j = max;
                            }
                        }
                    }
                }
            }
            this.durationUs = j;
            this.tracks = (Mp4Track[]) arrayList.toArray(new Mp4Track[arrayList.size()]);
            this.extractorOutput.endTracks();
            this.extractorOutput.seekMap(this);
        }
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, extractorInput)) == null) {
            if (this.atomHeaderBytesRead == 0) {
                if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                    return false;
                }
                this.atomHeaderBytesRead = 8;
                this.atomHeader.setPosition(0);
                this.atomSize = this.atomHeader.readUnsignedInt();
                this.atomType = this.atomHeader.readInt();
            }
            long j = this.atomSize;
            if (j == 1) {
                extractorInput.readFully(this.atomHeader.data, 8, 8);
                this.atomHeaderBytesRead += 8;
                this.atomSize = this.atomHeader.readUnsignedLongToLong();
            } else if (j == 0) {
                long length = extractorInput.getLength();
                if (length == -1 && !this.containerAtoms.isEmpty()) {
                    length = this.containerAtoms.peek().endPosition;
                }
                if (length != -1) {
                    this.atomSize = (length - extractorInput.getPosition()) + this.atomHeaderBytesRead;
                }
            }
            if (this.atomSize >= this.atomHeaderBytesRead) {
                if (shouldParseContainerAtom(this.atomType)) {
                    long position = (extractorInput.getPosition() + this.atomSize) - this.atomHeaderBytesRead;
                    this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, position));
                    if (this.atomSize == this.atomHeaderBytesRead) {
                        processAtomEnded(position);
                    } else {
                        enterReadingAtomHeaderState();
                    }
                } else if (shouldParseLeafAtom(this.atomType)) {
                    Assertions.checkState(this.atomHeaderBytesRead == 8);
                    Assertions.checkState(this.atomSize <= 2147483647L);
                    ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
                    this.atomData = parsableByteArray;
                    System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
                    this.parserState = 1;
                } else {
                    this.atomData = null;
                    this.parserState = 1;
                }
                return true;
            }
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        return invokeL.booleanValue;
    }

    private boolean readAtomPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65545, this, extractorInput, positionHolder)) != null) {
            return invokeLL.booleanValue;
        }
        long j = this.atomSize - this.atomHeaderBytesRead;
        long position = extractorInput.getPosition() + j;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, this.atomHeaderBytesRead, (int) j);
            if (this.atomType == Atom.TYPE_ftyp) {
                this.isQuickTime = processFtypAtom(this.atomData);
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(new Atom.LeafAtom(this.atomType, this.atomData));
            }
        } else if (j < 262144) {
            extractorInput.skipFully((int) j);
        } else {
            positionHolder.position = extractorInput.getPosition() + j;
            z = true;
            processAtomEnded(position);
            return (z || this.parserState == 2) ? false : true;
        }
        z = false;
        processAtomEnded(position);
        if (z) {
        }
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, extractorInput, positionHolder)) == null) {
            int trackIndexOfEarliestCurrentSample = getTrackIndexOfEarliestCurrentSample();
            if (trackIndexOfEarliestCurrentSample == -1) {
                return -1;
            }
            Mp4Track mp4Track = this.tracks[trackIndexOfEarliestCurrentSample];
            TrackOutput trackOutput = mp4Track.trackOutput;
            int i = mp4Track.sampleIndex;
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            long j = trackSampleTable.offsets[i];
            int i2 = trackSampleTable.sizes[i];
            if (mp4Track.track.sampleTransformation == 1) {
                j += 8;
                i2 -= 8;
            }
            long position = (j - extractorInput.getPosition()) + this.sampleBytesWritten;
            if (position >= 0 && position < 262144) {
                extractorInput.skipFully((int) position);
                int i3 = mp4Track.track.nalUnitLengthFieldLength;
                if (i3 == 0) {
                    while (true) {
                        int i4 = this.sampleBytesWritten;
                        if (i4 >= i2) {
                            break;
                        }
                        int sampleData = trackOutput.sampleData(extractorInput, i2 - i4, false);
                        this.sampleBytesWritten += sampleData;
                        this.sampleCurrentNalBytesRemaining -= sampleData;
                    }
                } else {
                    byte[] bArr = this.nalLength.data;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i5 = 4 - i3;
                    while (this.sampleBytesWritten < i2) {
                        int i6 = this.sampleCurrentNalBytesRemaining;
                        if (i6 == 0) {
                            extractorInput.readFully(this.nalLength.data, i5, i3);
                            this.nalLength.setPosition(0);
                            this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                            this.nalStartCode.setPosition(0);
                            trackOutput.sampleData(this.nalStartCode, 4);
                            this.sampleBytesWritten += 4;
                            i2 += i5;
                        } else {
                            int sampleData2 = trackOutput.sampleData(extractorInput, i6, false);
                            this.sampleBytesWritten += sampleData2;
                            this.sampleCurrentNalBytesRemaining -= sampleData2;
                        }
                    }
                }
                TrackSampleTable trackSampleTable2 = mp4Track.sampleTable;
                trackOutput.sampleMetadata(trackSampleTable2.timestampsUs[i], trackSampleTable2.flags[i], i2, 0, null);
                mp4Track.sampleIndex++;
                this.sampleBytesWritten = 0;
                this.sampleCurrentNalBytesRemaining = 0;
                return 0;
            }
            positionHolder.position = j;
            return 1;
        }
        return invokeLL.intValue;
    }

    public static boolean shouldParseContainerAtom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) ? i == Atom.TYPE_moov || i == Atom.TYPE_trak || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl || i == Atom.TYPE_edts : invokeI.booleanValue;
    }

    public static boolean shouldParseLeafAtom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) ? i == Atom.TYPE_mdhd || i == Atom.TYPE_mvhd || i == Atom.TYPE_hdlr || i == Atom.TYPE_stsd || i == Atom.TYPE_stts || i == Atom.TYPE_stss || i == Atom.TYPE_ctts || i == Atom.TYPE_elst || i == Atom.TYPE_stsc || i == Atom.TYPE_stsz || i == Atom.TYPE_stz2 || i == Atom.TYPE_stco || i == Atom.TYPE_co64 || i == Atom.TYPE_tkhd || i == Atom.TYPE_ftyp || i == Atom.TYPE_udta : invokeI.booleanValue;
    }

    private void updateSampleIndices(long j) {
        Mp4Track[] mp4TrackArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, this, j) == null) {
            for (Mp4Track mp4Track : this.tracks) {
                TrackSampleTable trackSampleTable = mp4Track.sampleTable;
                int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j);
                if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                    indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j);
                }
                mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.durationUs : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long j2 = Long.MAX_VALUE;
            for (Mp4Track mp4Track : this.tracks) {
                TrackSampleTable trackSampleTable = mp4Track.sampleTable;
                int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j);
                if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                    indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j);
                }
                long j3 = trackSampleTable.offsets[indexOfEarlierOrEqualSynchronizationSample];
                if (j3 < j2) {
                    j2 = j3;
                }
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extractorOutput) == null) {
            this.extractorOutput = extractorOutput;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
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
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.containerAtoms.clear();
            this.atomHeaderBytesRead = 0;
            this.sampleBytesWritten = 0;
            this.sampleCurrentNalBytesRemaining = 0;
            if (j == 0) {
                enterReadingAtomHeaderState();
            } else if (this.tracks != null) {
                updateSampleIndices(j2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, extractorInput)) == null) ? Sniffer.sniffUnfragmented(extractorInput) : invokeL.booleanValue;
    }

    public Mp4Extractor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.flags = i;
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new Stack<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }
}
