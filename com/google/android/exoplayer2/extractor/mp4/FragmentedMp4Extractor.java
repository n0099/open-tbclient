package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
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
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.CencSampleEncryptionInformationGroupEntry;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
/* loaded from: classes7.dex */
public final class FragmentedMp4Extractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExtractorsFactory FACTORY;
    public static final int FLAG_ENABLE_CEA608_TRACK = 8;
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_SIDELOADED = 16;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 32;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    public static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE;
    public static final int SAMPLE_GROUP_TYPE_seig;
    public static final int STATE_READING_ATOM_HEADER = 0;
    public static final int STATE_READING_ATOM_PAYLOAD = 1;
    public static final int STATE_READING_ENCRYPTION_DATA = 2;
    public static final int STATE_READING_SAMPLE_CONTINUE = 4;
    public static final int STATE_READING_SAMPLE_START = 3;
    public static final String TAG = "FragmentedMp4Extractor";
    public transient /* synthetic */ FieldHolder $fh;
    public ParsableByteArray atomData;
    public final ParsableByteArray atomHeader;
    public int atomHeaderBytesRead;
    public long atomSize;
    public int atomType;
    public TrackOutput[] cea608TrackOutputs;
    public final Stack<Atom.ContainerAtom> containerAtoms;
    public TrackBundle currentTrackBundle;
    public final ParsableByteArray defaultInitializationVector;
    public long durationUs;
    public final ParsableByteArray encryptionSignalByte;
    public long endOfMdatPosition;
    public TrackOutput eventMessageTrackOutput;
    public final byte[] extendedTypeScratch;
    public ExtractorOutput extractorOutput;
    public final int flags;
    public boolean haveOutputSeekMap;
    public final ParsableByteArray nalBuffer;
    public final ParsableByteArray nalPrefix;
    public final ParsableByteArray nalStartCode;
    public int parserState;
    public int pendingMetadataSampleBytes;
    public final LinkedList<MetadataSampleInfo> pendingMetadataSampleInfos;
    public boolean processSeiNalUnitPayload;
    public int sampleBytesWritten;
    public int sampleCurrentNalBytesRemaining;
    public int sampleSize;
    public long segmentIndexEarliestPresentationTimeUs;
    public final DrmInitData sideloadedDrmInitData;
    public final Track sideloadedTrack;
    public final TimestampAdjuster timestampAdjuster;
    public final SparseArray<TrackBundle> trackBundles;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Flags {
    }

    /* loaded from: classes7.dex */
    public static final class MetadataSampleInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.presentationTimeDeltaUs = j2;
            this.size = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class TrackBundle {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        public DefaultSampleValues defaultSampleValues;
        public final TrackFragment fragment;
        public final TrackOutput output;
        public Track track;

        public TrackBundle(TrackOutput trackOutput) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {trackOutput};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fragment = new TrackFragment();
            this.output = trackOutput;
        }

        public void init(Track track, DefaultSampleValues defaultSampleValues) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, track, defaultSampleValues) == null) {
                this.track = (Track) Assertions.checkNotNull(track);
                this.defaultSampleValues = (DefaultSampleValues) Assertions.checkNotNull(defaultSampleValues);
                this.output.format(track.format);
                reset();
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.fragment.reset();
                this.currentSampleIndex = 0;
                this.currentTrackRunIndex = 0;
                this.currentSampleInTrackRun = 0;
            }
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drmInitData) == null) {
                TrackEncryptionBox sampleDescriptionEncryptionBox = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
                this.output.format(this.track.format.copyWithDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-245264718, "Lcom/google/android/exoplayer2/extractor/mp4/FragmentedMp4Extractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-245264718, "Lcom/google/android/exoplayer2/extractor/mp4/FragmentedMp4Extractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
            public Extractor[] createExtractors() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new FragmentedMp4Extractor()} : (Extractor[]) invokeV.objValue;
            }
        };
        SAMPLE_GROUP_TYPE_seig = Util.getIntegerCodeForString(CencSampleEncryptionInformationGroupEntry.TYPE);
        PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentedMp4Extractor() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int appendSampleEncryptionData(TrackBundle trackBundle) {
        InterceptResult invokeL;
        ParsableByteArray parsableByteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, trackBundle)) == null) {
            TrackFragment trackFragment = trackBundle.fragment;
            int i2 = trackFragment.header.sampleDescriptionIndex;
            TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = trackBundle.track.getSampleDescriptionEncryptionBox(i2);
            }
            int i3 = trackEncryptionBox.initializationVectorSize;
            if (i3 != 0) {
                parsableByteArray = trackFragment.sampleEncryptionData;
            } else {
                byte[] bArr = trackEncryptionBox.defaultInitializationVector;
                this.defaultInitializationVector.reset(bArr, bArr.length);
                parsableByteArray = this.defaultInitializationVector;
                i3 = bArr.length;
            }
            boolean z = trackFragment.sampleHasSubsampleEncryptionTable[trackBundle.currentSampleIndex];
            this.encryptionSignalByte.data[0] = (byte) ((z ? 128 : 0) | i3);
            this.encryptionSignalByte.setPosition(0);
            TrackOutput trackOutput = trackBundle.output;
            trackOutput.sampleData(this.encryptionSignalByte, 1);
            trackOutput.sampleData(parsableByteArray, i3);
            if (z) {
                ParsableByteArray parsableByteArray2 = trackFragment.sampleEncryptionData;
                int readUnsignedShort = parsableByteArray2.readUnsignedShort();
                parsableByteArray2.skipBytes(-2);
                int i4 = (readUnsignedShort * 6) + 2;
                trackOutput.sampleData(parsableByteArray2, i4);
                return i3 + 1 + i4;
            }
            return i3 + 1;
        }
        return invokeL.intValue;
    }

    private void enterReadingAtomHeaderState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.parserState = 0;
            this.atomHeaderBytesRead = 0;
        }
    }

    public static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                Atom.LeafAtom leafAtom = list.get(i2);
                if (leafAtom.type == Atom.TYPE_pssh) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    byte[] bArr = leafAtom.data.data;
                    UUID parseUuid = PsshAtomUtil.parseUuid(bArr);
                    if (parseUuid != null) {
                        arrayList.add(new DrmInitData.SchemeData(parseUuid, MimeTypes.VIDEO_MP4, bArr));
                    }
                }
            }
            if (arrayList == null) {
                return null;
            }
            return new DrmInitData(arrayList);
        }
        return (DrmInitData) invokeL.objValue;
    }

    public static TrackBundle getNextFragmentRun(SparseArray<TrackBundle> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sparseArray)) == null) {
            int size = sparseArray.size();
            TrackBundle trackBundle = null;
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                TrackBundle valueAt = sparseArray.valueAt(i2);
                int i3 = valueAt.currentTrackRunIndex;
                TrackFragment trackFragment = valueAt.fragment;
                if (i3 != trackFragment.trunCount) {
                    long j3 = trackFragment.trunDataPosition[i3];
                    if (j3 < j2) {
                        trackBundle = valueAt;
                        j2 = j3;
                    }
                }
            }
            return trackBundle;
        }
        return (TrackBundle) invokeL.objValue;
    }

    private void maybeInitExtraTracks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if ((this.flags & 4) != 0 && this.eventMessageTrackOutput == null) {
                TrackOutput track = this.extractorOutput.track(this.trackBundles.size(), 4);
                this.eventMessageTrackOutput = track;
                track.format(Format.createSampleFormat(null, MimeTypes.APPLICATION_EMSG, Long.MAX_VALUE));
            }
            if ((this.flags & 8) == 0 || this.cea608TrackOutputs != null) {
                return;
            }
            TrackOutput track2 = this.extractorOutput.track(this.trackBundles.size() + 1, 3);
            track2.format(Format.createTextSampleFormat(null, MimeTypes.APPLICATION_CEA608, 0, null));
            this.cea608TrackOutputs = new TrackOutput[]{track2};
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, containerAtom) == null) {
            int i2 = containerAtom.type;
            if (i2 == Atom.TYPE_moov) {
                onMoovContainerAtomRead(containerAtom);
            } else if (i2 == Atom.TYPE_moof) {
                onMoofContainerAtomRead(containerAtom);
            } else if (this.containerAtoms.isEmpty()) {
            } else {
                this.containerAtoms.peek().add(containerAtom);
            }
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, parsableByteArray) == null) || this.eventMessageTrackOutput == null) {
            return;
        }
        parsableByteArray.setPosition(12);
        parsableByteArray.readNullTerminatedString();
        parsableByteArray.readNullTerminatedString();
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000L, parsableByteArray.readUnsignedInt());
        parsableByteArray.setPosition(12);
        int bytesLeft = parsableByteArray.bytesLeft();
        this.eventMessageTrackOutput.sampleData(parsableByteArray, bytesLeft);
        long j2 = this.segmentIndexEarliestPresentationTimeUs;
        if (j2 != C.TIME_UNSET) {
            this.eventMessageTrackOutput.sampleMetadata(j2 + scaleLargeTimestamp, 1, bytesLeft, 0, null);
            return;
        }
        this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(scaleLargeTimestamp, bytesLeft));
        this.pendingMetadataSampleBytes += bytesLeft;
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, this, leafAtom, j2) == null) {
            if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(leafAtom);
                return;
            }
            int i2 = leafAtom.type;
            if (i2 == Atom.TYPE_sidx) {
                Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j2);
                this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
                this.extractorOutput.seekMap((SeekMap) parseSidx.second);
                this.haveOutputSeekMap = true;
            } else if (i2 == Atom.TYPE_emsg) {
                onEmsgLeafAtomRead(leafAtom.data);
            }
        }
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, containerAtom) == null) {
            parseMoof(containerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
            DrmInitData drmInitDataFromAtoms = this.sideloadedDrmInitData != null ? null : getDrmInitDataFromAtoms(containerAtom.leafChildren);
            if (drmInitDataFromAtoms != null) {
                int size = this.trackBundles.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.trackBundles.valueAt(i2).updateDrmInitData(drmInitDataFromAtoms);
                }
            }
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, containerAtom) == null) {
            int i4 = 0;
            Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
            DrmInitData drmInitData = this.sideloadedDrmInitData;
            if (drmInitData == null) {
                drmInitData = getDrmInitDataFromAtoms(containerAtom.leafChildren);
            }
            Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
            SparseArray sparseArray = new SparseArray();
            int size = containerAtomOfType.leafChildren.size();
            long j2 = -9223372036854775807L;
            for (int i5 = 0; i5 < size; i5++) {
                Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i5);
                int i6 = leafAtom.type;
                if (i6 == Atom.TYPE_trex) {
                    Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                    sparseArray.put(((Integer) parseTrex.first).intValue(), parseTrex.second);
                } else if (i6 == Atom.TYPE_mehd) {
                    j2 = parseMehd(leafAtom.data);
                }
            }
            SparseArray sparseArray2 = new SparseArray();
            int size2 = containerAtom.containerChildren.size();
            int i7 = 0;
            while (i7 < size2) {
                Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i7);
                if (containerAtom2.type == Atom.TYPE_trak) {
                    i2 = i7;
                    i3 = size2;
                    Track parseTrak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), j2, drmInitData, (this.flags & 32) != 0, false);
                    if (parseTrak != null) {
                        sparseArray2.put(parseTrak.id, parseTrak);
                    }
                } else {
                    i2 = i7;
                    i3 = size2;
                }
                i7 = i2 + 1;
                size2 = i3;
            }
            int size3 = sparseArray2.size();
            if (this.trackBundles.size() == 0) {
                while (i4 < size3) {
                    Track track = (Track) sparseArray2.valueAt(i4);
                    TrackBundle trackBundle = new TrackBundle(this.extractorOutput.track(i4, track.type));
                    trackBundle.init(track, (DefaultSampleValues) sparseArray.get(track.id));
                    this.trackBundles.put(track.id, trackBundle);
                    this.durationUs = Math.max(this.durationUs, track.durationUs);
                    i4++;
                }
                maybeInitExtraTracks();
                this.extractorOutput.endTracks();
                return;
            }
            Assertions.checkState(this.trackBundles.size() == size3);
            while (i4 < size3) {
                Track track2 = (Track) sparseArray2.valueAt(i4);
                this.trackBundles.get(track2.id).init(track2, (DefaultSampleValues) sparseArray.get(track2.id));
                i4++;
            }
        }
    }

    public static long parseMehd(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(8);
            return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
        }
        return invokeL.longValue;
    }

    public static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i2, byte[] bArr) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65552, null, containerAtom, sparseArray, i2, bArr) == null) {
            int size = containerAtom.containerChildren.size();
            for (int i3 = 0; i3 < size; i3++) {
                Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i3);
                if (containerAtom2.type == Atom.TYPE_traf) {
                    parseTraf(containerAtom2, sparseArray, i2, bArr);
                }
            }
        }
    }

    public static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, parsableByteArray, trackFragment) == null) {
            parsableByteArray.setPosition(8);
            int readInt = parsableByteArray.readInt();
            if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
                parsableByteArray.skipBytes(8);
            }
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == 1) {
                trackFragment.auxiliaryDataPosition += Atom.parseFullAtomVersion(readInt) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                return;
            }
            throw new ParserException("Unexpected saio entry count: " + readUnsignedIntToInt);
        }
    }

    public static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, trackEncryptionBox, parsableByteArray, trackFragment) == null) {
            int i3 = trackEncryptionBox.initializationVectorSize;
            parsableByteArray.setPosition(8);
            if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
                parsableByteArray.skipBytes(8);
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == trackFragment.sampleCount) {
                if (readUnsignedByte == 0) {
                    boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
                    i2 = 0;
                    for (int i4 = 0; i4 < readUnsignedIntToInt; i4++) {
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        i2 += readUnsignedByte2;
                        zArr[i4] = readUnsignedByte2 > i3;
                    }
                } else {
                    i2 = (readUnsignedByte * readUnsignedIntToInt) + 0;
                    Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, readUnsignedByte > i3);
                }
                trackFragment.initEncryptionData(i2);
                return;
            }
            throw new ParserException("Length mismatch: " + readUnsignedIntToInt + StringUtil.ARRAY_ELEMENT_SEPARATOR + trackFragment.sampleCount);
        }
    }

    public static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, parsableByteArray, trackFragment) == null) {
            parseSenc(parsableByteArray, 0, trackFragment);
        }
    }

    public static void parseSgpd(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, String str, TrackFragment trackFragment) throws ParserException {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65557, null, parsableByteArray, parsableByteArray2, str, trackFragment) == null) {
            parsableByteArray.setPosition(8);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() != SAMPLE_GROUP_TYPE_seig) {
                return;
            }
            if (Atom.parseFullAtomVersion(readInt) == 1) {
                parsableByteArray.skipBytes(4);
            }
            if (parsableByteArray.readInt() == 1) {
                parsableByteArray2.setPosition(8);
                int readInt2 = parsableByteArray2.readInt();
                if (parsableByteArray2.readInt() != SAMPLE_GROUP_TYPE_seig) {
                    return;
                }
                int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt2);
                if (parseFullAtomVersion == 1) {
                    if (parsableByteArray2.readUnsignedInt() == 0) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                } else if (parseFullAtomVersion >= 2) {
                    parsableByteArray2.skipBytes(4);
                }
                if (parsableByteArray2.readUnsignedInt() == 1) {
                    parsableByteArray2.skipBytes(1);
                    int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                    int i2 = (readUnsignedByte & 240) >> 4;
                    int i3 = readUnsignedByte & 15;
                    boolean z = parsableByteArray2.readUnsignedByte() == 1;
                    if (z) {
                        int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                        byte[] bArr2 = new byte[16];
                        parsableByteArray2.readBytes(bArr2, 0, 16);
                        if (z && readUnsignedByte2 == 0) {
                            int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                            byte[] bArr3 = new byte[readUnsignedByte3];
                            parsableByteArray2.readBytes(bArr3, 0, readUnsignedByte3);
                            bArr = bArr3;
                        } else {
                            bArr = null;
                        }
                        trackFragment.definesEncryptionData = true;
                        trackFragment.trackEncryptionBox = new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i2, i3, bArr);
                        return;
                    }
                    return;
                }
                throw new ParserException("Entry count in sgpd != 1 (unsupported).");
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    public static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        InterceptResult invokeLJ;
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65558, null, parsableByteArray, j2)) == null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            parsableByteArray.skipBytes(4);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            if (parseFullAtomVersion == 0) {
                readUnsignedLongToLong = parsableByteArray.readUnsignedInt();
                readUnsignedLongToLong2 = parsableByteArray.readUnsignedInt();
            } else {
                readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
                readUnsignedLongToLong2 = parsableByteArray.readUnsignedLongToLong();
            }
            long j3 = readUnsignedLongToLong;
            long j4 = j2 + readUnsignedLongToLong2;
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(j3, 1000000L, readUnsignedInt);
            parsableByteArray.skipBytes(2);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int[] iArr = new int[readUnsignedShort];
            long[] jArr = new long[readUnsignedShort];
            long[] jArr2 = new long[readUnsignedShort];
            long[] jArr3 = new long[readUnsignedShort];
            long j5 = j3;
            long j6 = scaleLargeTimestamp;
            int i2 = 0;
            while (i2 < readUnsignedShort) {
                int readInt = parsableByteArray.readInt();
                if ((readInt & Integer.MIN_VALUE) == 0) {
                    long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                    iArr[i2] = readInt & Integer.MAX_VALUE;
                    jArr[i2] = j4;
                    jArr3[i2] = j6;
                    long j7 = j5 + readUnsignedInt2;
                    long[] jArr4 = jArr2;
                    long[] jArr5 = jArr3;
                    int i3 = readUnsignedShort;
                    int[] iArr2 = iArr;
                    long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j7, 1000000L, readUnsignedInt);
                    jArr4[i2] = scaleLargeTimestamp2 - jArr5[i2];
                    parsableByteArray.skipBytes(4);
                    j4 += iArr2[i2];
                    i2++;
                    iArr = iArr2;
                    jArr3 = jArr5;
                    jArr2 = jArr4;
                    jArr = jArr;
                    readUnsignedShort = i3;
                    j5 = j7;
                    j6 = scaleLargeTimestamp2;
                } else {
                    throw new ParserException("Unhandled indirect reference");
                }
            }
            return Pair.create(Long.valueOf(scaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
        }
        return (Pair) invokeLJ.objValue;
    }

    public static long parseTfdt(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(8);
            return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
        }
        return invokeL.longValue;
    }

    public static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65560, null, parsableByteArray, sparseArray, i2)) == null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
            int readInt = parsableByteArray.readInt();
            if ((i2 & 16) != 0) {
                readInt = 0;
            }
            TrackBundle trackBundle = sparseArray.get(readInt);
            if (trackBundle == null) {
                return null;
            }
            if ((parseFullAtomFlags & 1) != 0) {
                long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
                TrackFragment trackFragment = trackBundle.fragment;
                trackFragment.dataPosition = readUnsignedLongToLong;
                trackFragment.auxiliaryDataPosition = readUnsignedLongToLong;
            }
            DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
            trackBundle.fragment.header = new DefaultSampleValues((parseFullAtomFlags & 2) != 0 ? parsableByteArray.readUnsignedIntToInt() - 1 : defaultSampleValues.sampleDescriptionIndex, (parseFullAtomFlags & 8) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.duration, (parseFullAtomFlags & 16) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.size, (parseFullAtomFlags & 32) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.flags);
            return trackBundle;
        }
        return (TrackBundle) invokeLLI.objValue;
    }

    public static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i2, byte[] bArr) throws ParserException {
        TrackBundle parseTfhd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65561, null, containerAtom, sparseArray, i2, bArr) == null) || (parseTfhd = parseTfhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, sparseArray, i2)) == null) {
            return;
        }
        TrackFragment trackFragment = parseTfhd.fragment;
        long j2 = trackFragment.nextFragmentDecodeTime;
        parseTfhd.reset();
        if (containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt) != null && (i2 & 2) == 0) {
            j2 = parseTfdt(containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt).data);
        }
        parseTruns(containerAtom, parseTfhd, j2, i2);
        TrackEncryptionBox sampleDescriptionEncryptionBox = parseTfhd.track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
        if (leafAtomOfType != null) {
            parseSaiz(sampleDescriptionEncryptionBox, leafAtomOfType.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
        if (leafAtomOfType2 != null) {
            parseSaio(leafAtomOfType2.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
        if (leafAtomOfType3 != null) {
            parseSenc(leafAtomOfType3.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_sbgp);
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_sgpd);
        if (leafAtomOfType4 != null && leafAtomOfType5 != null) {
            parseSgpd(leafAtomOfType4.data, leafAtomOfType5.data, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
        }
        int size = containerAtom.leafChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i3);
            if (leafAtom.type == Atom.TYPE_uuid) {
                parseUuid(leafAtom.data, trackFragment, bArr);
            }
        }
    }

    public static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(12);
            return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readUnsignedIntToInt() - 1, parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readInt()));
        }
        return (Pair) invokeL.objValue;
    }

    public static int parseTrun(TrackBundle trackBundle, int i2, long j2, int i3, ParsableByteArray parsableByteArray, int i4) {
        InterceptResult invokeCommon;
        boolean z;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{trackBundle, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), parsableByteArray, Integer.valueOf(i4)})) == null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
            Track track = trackBundle.track;
            TrackFragment trackFragment = trackBundle.fragment;
            DefaultSampleValues defaultSampleValues = trackFragment.header;
            trackFragment.trunLength[i2] = parsableByteArray.readUnsignedIntToInt();
            long[] jArr = trackFragment.trunDataPosition;
            jArr[i2] = trackFragment.dataPosition;
            if ((parseFullAtomFlags & 1) != 0) {
                jArr[i2] = jArr[i2] + parsableByteArray.readInt();
            }
            boolean z6 = (parseFullAtomFlags & 4) != 0;
            int i7 = defaultSampleValues.flags;
            if (z6) {
                i7 = parsableByteArray.readUnsignedIntToInt();
            }
            boolean z7 = (parseFullAtomFlags & 256) != 0;
            boolean z8 = (parseFullAtomFlags & 512) != 0;
            boolean z9 = (parseFullAtomFlags & 1024) != 0;
            boolean z10 = (parseFullAtomFlags & 2048) != 0;
            long[] jArr2 = track.editListDurations;
            long j3 = 0;
            if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
                j3 = Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000L, track.timescale);
            }
            int[] iArr = trackFragment.sampleSizeTable;
            int[] iArr2 = trackFragment.sampleCompositionTimeOffsetTable;
            long[] jArr3 = trackFragment.sampleDecodingTimeTable;
            boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
            int i8 = i7;
            boolean z11 = track.type == 2 && (i3 & 1) != 0;
            int i9 = i4 + trackFragment.trunLength[i2];
            long j4 = track.timescale;
            long j5 = j3;
            long j6 = i2 > 0 ? trackFragment.nextFragmentDecodeTime : j2;
            int i10 = i4;
            while (i10 < i9) {
                int readUnsignedIntToInt = z7 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.duration;
                if (z8) {
                    z = z7;
                    i5 = parsableByteArray.readUnsignedIntToInt();
                } else {
                    z = z7;
                    i5 = defaultSampleValues.size;
                }
                if (i10 == 0 && z6) {
                    z2 = z6;
                    i6 = i8;
                } else if (z9) {
                    z2 = z6;
                    i6 = parsableByteArray.readInt();
                } else {
                    z2 = z6;
                    i6 = defaultSampleValues.flags;
                }
                if (z10) {
                    z3 = z10;
                    z4 = z8;
                    z5 = z9;
                    iArr2[i10] = (int) ((parsableByteArray.readInt() * 1000) / j4);
                } else {
                    z3 = z10;
                    z4 = z8;
                    z5 = z9;
                    iArr2[i10] = 0;
                }
                jArr3[i10] = Util.scaleLargeTimestamp(j6, 1000L, j4) - j5;
                iArr[i10] = i5;
                zArr[i10] = ((i6 >> 16) & 1) == 0 && (!z11 || i10 == 0);
                i10++;
                j6 += readUnsignedIntToInt;
                j4 = j4;
                z7 = z;
                z6 = z2;
                z10 = z3;
                z8 = z4;
                z9 = z5;
            }
            trackFragment.nextFragmentDecodeTime = j6;
            return i9;
        }
        return invokeCommon.intValue;
    }

    public static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{containerAtom, trackBundle, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            List<Atom.LeafAtom> list = containerAtom.leafChildren;
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Atom.LeafAtom leafAtom = list.get(i5);
                if (leafAtom.type == Atom.TYPE_trun) {
                    ParsableByteArray parsableByteArray = leafAtom.data;
                    parsableByteArray.setPosition(12);
                    int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                    if (readUnsignedIntToInt > 0) {
                        i4 += readUnsignedIntToInt;
                        i3++;
                    }
                }
            }
            trackBundle.currentTrackRunIndex = 0;
            trackBundle.currentSampleInTrackRun = 0;
            trackBundle.currentSampleIndex = 0;
            trackBundle.fragment.initTables(i3, i4);
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                Atom.LeafAtom leafAtom2 = list.get(i8);
                if (leafAtom2.type == Atom.TYPE_trun) {
                    i7 = parseTrun(trackBundle, i6, j2, i2, leafAtom2.data, i7);
                    i6++;
                }
            }
        }
    }

    public static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65565, null, parsableByteArray, trackFragment, bArr) == null) {
            parsableByteArray.setPosition(8);
            parsableByteArray.readBytes(bArr, 0, 16);
            if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
                parseSenc(parsableByteArray, 16, trackFragment);
            }
        }
    }

    private void processAtomEnded(long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65566, this, j2) == null) {
            while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j2) {
                onContainerAtomRead(this.containerAtoms.pop());
            }
            enterReadingAtomHeaderState();
        }
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, extractorInput)) == null) {
            if (this.atomHeaderBytesRead == 0) {
                if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                    return false;
                }
                this.atomHeaderBytesRead = 8;
                this.atomHeader.setPosition(0);
                this.atomSize = this.atomHeader.readUnsignedInt();
                this.atomType = this.atomHeader.readInt();
            }
            long j2 = this.atomSize;
            if (j2 == 1) {
                extractorInput.readFully(this.atomHeader.data, 8, 8);
                this.atomHeaderBytesRead += 8;
                this.atomSize = this.atomHeader.readUnsignedLongToLong();
            } else if (j2 == 0) {
                long length = extractorInput.getLength();
                if (length == -1 && !this.containerAtoms.isEmpty()) {
                    length = this.containerAtoms.peek().endPosition;
                }
                if (length != -1) {
                    this.atomSize = (length - extractorInput.getPosition()) + this.atomHeaderBytesRead;
                }
            }
            if (this.atomSize >= this.atomHeaderBytesRead) {
                long position = extractorInput.getPosition() - this.atomHeaderBytesRead;
                if (this.atomType == Atom.TYPE_moof) {
                    int size = this.trackBundles.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        TrackFragment trackFragment = this.trackBundles.valueAt(i2).fragment;
                        trackFragment.atomPosition = position;
                        trackFragment.auxiliaryDataPosition = position;
                        trackFragment.dataPosition = position;
                    }
                }
                int i3 = this.atomType;
                if (i3 == Atom.TYPE_mdat) {
                    this.currentTrackBundle = null;
                    this.endOfMdatPosition = position + this.atomSize;
                    if (!this.haveOutputSeekMap) {
                        this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                        this.haveOutputSeekMap = true;
                    }
                    this.parserState = 2;
                    return true;
                }
                if (shouldParseContainerAtom(i3)) {
                    long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
                    this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, position2));
                    if (this.atomSize == this.atomHeaderBytesRead) {
                        processAtomEnded(position2);
                    } else {
                        enterReadingAtomHeaderState();
                    }
                } else if (shouldParseLeafAtom(this.atomType)) {
                    if (this.atomHeaderBytesRead == 8) {
                        long j3 = this.atomSize;
                        if (j3 <= 2147483647L) {
                            ParsableByteArray parsableByteArray = new ParsableByteArray((int) j3);
                            this.atomData = parsableByteArray;
                            System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
                            this.parserState = 1;
                        } else {
                            throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                        }
                    } else {
                        throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                    }
                } else if (this.atomSize <= 2147483647L) {
                    this.atomData = null;
                    this.parserState = 1;
                } else {
                    throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
                }
                return true;
            }
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        return invokeL.booleanValue;
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, extractorInput) == null) {
            int i2 = ((int) this.atomSize) - this.atomHeaderBytesRead;
            ParsableByteArray parsableByteArray = this.atomData;
            if (parsableByteArray != null) {
                extractorInput.readFully(parsableByteArray.data, 8, i2);
                onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), extractorInput.getPosition());
            } else {
                extractorInput.skipFully(i2);
            }
            processAtomEnded(extractorInput.getPosition());
        }
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, extractorInput) == null) {
            int size = this.trackBundles.size();
            TrackBundle trackBundle = null;
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                TrackFragment trackFragment = this.trackBundles.valueAt(i2).fragment;
                if (trackFragment.sampleEncryptionDataNeedsFill) {
                    long j3 = trackFragment.auxiliaryDataPosition;
                    if (j3 < j2) {
                        trackBundle = this.trackBundles.valueAt(i2);
                        j2 = j3;
                    }
                }
            }
            if (trackBundle == null) {
                this.parserState = 3;
                return;
            }
            int position = (int) (j2 - extractorInput.getPosition());
            if (position >= 0) {
                extractorInput.skipFully(position);
                trackBundle.fragment.fillEncryptionData(extractorInput);
                return;
            }
            throw new ParserException("Offset to encryption data was negative.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.exoplayer2.extractor.TrackOutput] */
    private boolean readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        ?? r12;
        TrackOutput.CryptoData cryptoData;
        int sampleData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, this, extractorInput)) == null) {
            int i2 = 4;
            int i3 = 1;
            int i4 = 0;
            if (this.parserState == 3) {
                if (this.currentTrackBundle == null) {
                    TrackBundle nextFragmentRun = getNextFragmentRun(this.trackBundles);
                    if (nextFragmentRun == null) {
                        int position = (int) (this.endOfMdatPosition - extractorInput.getPosition());
                        if (position >= 0) {
                            extractorInput.skipFully(position);
                            enterReadingAtomHeaderState();
                            return false;
                        }
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    int position2 = (int) (nextFragmentRun.fragment.trunDataPosition[nextFragmentRun.currentTrackRunIndex] - extractorInput.getPosition());
                    if (position2 < 0) {
                        position2 = 0;
                    }
                    extractorInput.skipFully(position2);
                    this.currentTrackBundle = nextFragmentRun;
                }
                TrackBundle trackBundle = this.currentTrackBundle;
                TrackFragment trackFragment = trackBundle.fragment;
                this.sampleSize = trackFragment.sampleSizeTable[trackBundle.currentSampleIndex];
                if (trackFragment.definesEncryptionData) {
                    int appendSampleEncryptionData = appendSampleEncryptionData(trackBundle);
                    this.sampleBytesWritten = appendSampleEncryptionData;
                    this.sampleSize += appendSampleEncryptionData;
                } else {
                    this.sampleBytesWritten = 0;
                }
                if (this.currentTrackBundle.track.sampleTransformation == 1) {
                    this.sampleSize -= 8;
                    extractorInput.skipFully(8);
                }
                this.parserState = 4;
                this.sampleCurrentNalBytesRemaining = 0;
            }
            TrackBundle trackBundle2 = this.currentTrackBundle;
            TrackFragment trackFragment2 = trackBundle2.fragment;
            Track track = trackBundle2.track;
            ?? r9 = trackBundle2.output;
            int i5 = trackBundle2.currentSampleIndex;
            int i6 = track.nalUnitLengthFieldLength;
            if (i6 == 0) {
                while (true) {
                    int i7 = this.sampleBytesWritten;
                    int i8 = this.sampleSize;
                    if (i7 >= i8) {
                        break;
                    }
                    this.sampleBytesWritten += r9.sampleData(extractorInput, i8 - i7, false);
                }
            } else {
                byte[] bArr = this.nalPrefix.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i9 = i6 + 1;
                int i10 = 4 - i6;
                while (this.sampleBytesWritten < this.sampleSize) {
                    int i11 = this.sampleCurrentNalBytesRemaining;
                    if (i11 == 0) {
                        extractorInput.readFully(bArr, i10, i9);
                        this.nalPrefix.setPosition(i4);
                        this.sampleCurrentNalBytesRemaining = this.nalPrefix.readUnsignedIntToInt() - i3;
                        this.nalStartCode.setPosition(i4);
                        r9.sampleData(this.nalStartCode, i2);
                        r9.sampleData(this.nalPrefix, i3);
                        this.processSeiNalUnitPayload = this.cea608TrackOutputs != null && NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, bArr[i2]);
                        this.sampleBytesWritten += 5;
                        this.sampleSize += i10;
                    } else {
                        if (this.processSeiNalUnitPayload) {
                            this.nalBuffer.reset(i11);
                            extractorInput.readFully(this.nalBuffer.data, i4, this.sampleCurrentNalBytesRemaining);
                            r9.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                            sampleData = this.sampleCurrentNalBytesRemaining;
                            ParsableByteArray parsableByteArray = this.nalBuffer;
                            int unescapeStream = NalUnitUtil.unescapeStream(parsableByteArray.data, parsableByteArray.limit());
                            this.nalBuffer.setPosition(MimeTypes.VIDEO_H265.equals(track.format.sampleMimeType) ? 1 : 0);
                            this.nalBuffer.setLimit(unescapeStream);
                            CeaUtil.consume(trackFragment2.getSamplePresentationTime(i5) * 1000, this.nalBuffer, this.cea608TrackOutputs);
                        } else {
                            sampleData = r9.sampleData(extractorInput, i11, false);
                        }
                        this.sampleBytesWritten += sampleData;
                        this.sampleCurrentNalBytesRemaining -= sampleData;
                        i2 = 4;
                        i3 = 1;
                        i4 = 0;
                    }
                }
            }
            long samplePresentationTime = trackFragment2.getSamplePresentationTime(i5) * 1000;
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster != null) {
                samplePresentationTime = timestampAdjuster.adjustSampleTimestamp(samplePresentationTime);
            }
            boolean z = trackFragment2.sampleIsSyncFrameTable[i5];
            if (trackFragment2.definesEncryptionData) {
                boolean z2 = z | true;
                TrackEncryptionBox trackEncryptionBox = trackFragment2.trackEncryptionBox;
                if (trackEncryptionBox == null) {
                    trackEncryptionBox = track.getSampleDescriptionEncryptionBox(trackFragment2.header.sampleDescriptionIndex);
                }
                r12 = z2;
                cryptoData = trackEncryptionBox.cryptoData;
            } else {
                r12 = z;
                cryptoData = null;
            }
            r9.sampleMetadata(samplePresentationTime, r12, this.sampleSize, 0, cryptoData);
            while (!this.pendingMetadataSampleInfos.isEmpty()) {
                MetadataSampleInfo removeFirst = this.pendingMetadataSampleInfos.removeFirst();
                int i12 = this.pendingMetadataSampleBytes;
                int i13 = removeFirst.size;
                int i14 = i12 - i13;
                this.pendingMetadataSampleBytes = i14;
                this.eventMessageTrackOutput.sampleMetadata(samplePresentationTime + removeFirst.presentationTimeDeltaUs, 1, i13, i14, null);
            }
            TrackBundle trackBundle3 = this.currentTrackBundle;
            trackBundle3.currentSampleIndex++;
            int i15 = trackBundle3.currentSampleInTrackRun + 1;
            trackBundle3.currentSampleInTrackRun = i15;
            int[] iArr = trackFragment2.trunLength;
            int i16 = trackBundle3.currentTrackRunIndex;
            if (i15 == iArr[i16]) {
                trackBundle3.currentTrackRunIndex = i16 + 1;
                trackBundle3.currentSampleInTrackRun = 0;
                this.currentTrackBundle = null;
            }
            this.parserState = 3;
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean shouldParseContainerAtom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65571, null, i2)) == null) ? i2 == Atom.TYPE_moov || i2 == Atom.TYPE_trak || i2 == Atom.TYPE_mdia || i2 == Atom.TYPE_minf || i2 == Atom.TYPE_stbl || i2 == Atom.TYPE_moof || i2 == Atom.TYPE_traf || i2 == Atom.TYPE_mvex || i2 == Atom.TYPE_edts : invokeI.booleanValue;
    }

    public static boolean shouldParseLeafAtom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i2)) == null) ? i2 == Atom.TYPE_hdlr || i2 == Atom.TYPE_mdhd || i2 == Atom.TYPE_mvhd || i2 == Atom.TYPE_sidx || i2 == Atom.TYPE_stsd || i2 == Atom.TYPE_tfdt || i2 == Atom.TYPE_tfhd || i2 == Atom.TYPE_tkhd || i2 == Atom.TYPE_trex || i2 == Atom.TYPE_trun || i2 == Atom.TYPE_pssh || i2 == Atom.TYPE_saiz || i2 == Atom.TYPE_saio || i2 == Atom.TYPE_senc || i2 == Atom.TYPE_uuid || i2 == Atom.TYPE_sbgp || i2 == Atom.TYPE_sgpd || i2 == Atom.TYPE_elst || i2 == Atom.TYPE_mehd || i2 == Atom.TYPE_emsg : invokeI.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorOutput) == null) {
            this.extractorOutput = extractorOutput;
            Track track = this.sideloadedTrack;
            if (track != null) {
                TrackBundle trackBundle = new TrackBundle(extractorOutput.track(0, track.type));
                trackBundle.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
                this.trackBundles.put(0, trackBundle);
                maybeInitExtraTracks();
                this.extractorOutput.endTracks();
            }
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
            int i2 = this.parserState;
            if (i2 != 0) {
                if (i2 == 1) {
                    readAtomPayload(extractorInput);
                } else if (i2 != 2) {
                    if (readSample(extractorInput)) {
                        return 0;
                    }
                } else {
                    readEncryptionData(extractorInput);
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
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
    public void seek(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            int size = this.trackBundles.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.trackBundles.valueAt(i2).reset();
            }
            this.pendingMetadataSampleInfos.clear();
            this.pendingMetadataSampleBytes = 0;
            this.containerAtoms.clear();
            enterReadingAtomHeaderState();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) ? Sniffer.sniffFragmented(extractorInput) : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentedMp4Extractor(int i2) {
        this(i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (TimestampAdjuster) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static void parseSenc(ParsableByteArray parsableByteArray, int i2, TrackFragment trackFragment) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, parsableByteArray, i2, trackFragment) == null) {
            parsableByteArray.setPosition(i2 + 8);
            int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
            if ((parseFullAtomFlags & 1) == 0) {
                boolean z = (parseFullAtomFlags & 2) != 0;
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt == trackFragment.sampleCount) {
                    Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z);
                    trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
                    trackFragment.fillEncryptionData(parsableByteArray);
                    return;
                }
                throw new ParserException("Length mismatch: " + readUnsignedIntToInt + StringUtil.ARRAY_ELEMENT_SEPARATOR + trackFragment.sampleCount);
            }
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentedMp4Extractor(int i2, TimestampAdjuster timestampAdjuster) {
        this(i2, timestampAdjuster, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), timestampAdjuster};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (TimestampAdjuster) objArr2[1], (Track) objArr2[2], (DrmInitData) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public FragmentedMp4Extractor(int i2, TimestampAdjuster timestampAdjuster, Track track, DrmInitData drmInitData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), timestampAdjuster, track, drmInitData};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.flags = i2 | (track != null ? 16 : 0);
        this.timestampAdjuster = timestampAdjuster;
        this.sideloadedTrack = track;
        this.sideloadedDrmInitData = drmInitData;
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        this.encryptionSignalByte = new ParsableByteArray(1);
        this.defaultInitializationVector = new ParsableByteArray();
        this.extendedTypeScratch = new byte[16];
        this.containerAtoms = new Stack<>();
        this.pendingMetadataSampleInfos = new LinkedList<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = C.TIME_UNSET;
        this.segmentIndexEarliestPresentationTimeUs = C.TIME_UNSET;
        enterReadingAtomHeaderState();
    }
}
