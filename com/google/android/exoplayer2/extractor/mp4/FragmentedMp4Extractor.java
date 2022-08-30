package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
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

        public MetadataSampleInfo(long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.presentationTimeDeltaUs = j;
            this.size = i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    private int appendSampleEncryptionData(TrackBundle trackBundle) {
        InterceptResult invokeL;
        ParsableByteArray parsableByteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, trackBundle)) == null) {
            TrackFragment trackFragment = trackBundle.fragment;
            int i = trackFragment.header.sampleDescriptionIndex;
            TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = trackBundle.track.getSampleDescriptionEncryptionBox(i);
            }
            int i2 = trackEncryptionBox.initializationVectorSize;
            if (i2 != 0) {
                parsableByteArray = trackFragment.sampleEncryptionData;
            } else {
                byte[] bArr = trackEncryptionBox.defaultInitializationVector;
                this.defaultInitializationVector.reset(bArr, bArr.length);
                parsableByteArray = this.defaultInitializationVector;
                i2 = bArr.length;
            }
            boolean z = trackFragment.sampleHasSubsampleEncryptionTable[trackBundle.currentSampleIndex];
            this.encryptionSignalByte.data[0] = (byte) ((z ? 128 : 0) | i2);
            this.encryptionSignalByte.setPosition(0);
            TrackOutput trackOutput = trackBundle.output;
            trackOutput.sampleData(this.encryptionSignalByte, 1);
            trackOutput.sampleData(parsableByteArray, i2);
            if (z) {
                ParsableByteArray parsableByteArray2 = trackFragment.sampleEncryptionData;
                int readUnsignedShort = parsableByteArray2.readUnsignedShort();
                parsableByteArray2.skipBytes(-2);
                int i3 = (readUnsignedShort * 6) + 2;
                trackOutput.sampleData(parsableByteArray2, i3);
                return i2 + 1 + i3;
            }
            return i2 + 1;
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
            for (int i = 0; i < size; i++) {
                Atom.LeafAtom leafAtom = list.get(i);
                if (leafAtom.type == Atom.TYPE_pssh) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    byte[] bArr = leafAtom.data.data;
                    UUID parseUuid = PsshAtomUtil.parseUuid(bArr);
                    if (parseUuid == null) {
                        Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                    } else {
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
            long j = Long.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TrackBundle valueAt = sparseArray.valueAt(i);
                int i2 = valueAt.currentTrackRunIndex;
                TrackFragment trackFragment = valueAt.fragment;
                if (i2 != trackFragment.trunCount) {
                    long j2 = trackFragment.trunDataPosition[i2];
                    if (j2 < j) {
                        trackBundle = valueAt;
                        j = j2;
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
            int i = containerAtom.type;
            if (i == Atom.TYPE_moov) {
                onMoovContainerAtomRead(containerAtom);
            } else if (i == Atom.TYPE_moof) {
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
        long j = this.segmentIndexEarliestPresentationTimeUs;
        if (j != C.TIME_UNSET) {
            this.eventMessageTrackOutput.sampleMetadata(j + scaleLargeTimestamp, 1, bytesLeft, 0, null);
            return;
        }
        this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(scaleLargeTimestamp, bytesLeft));
        this.pendingMetadataSampleBytes += bytesLeft;
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, this, leafAtom, j) == null) {
            if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(leafAtom);
                return;
            }
            int i = leafAtom.type;
            if (i == Atom.TYPE_sidx) {
                Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j);
                this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
                this.extractorOutput.seekMap((SeekMap) parseSidx.second);
                this.haveOutputSeekMap = true;
            } else if (i == Atom.TYPE_emsg) {
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
                for (int i = 0; i < size; i++) {
                    this.trackBundles.valueAt(i).updateDrmInitData(drmInitDataFromAtoms);
                }
            }
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, containerAtom) == null) {
            int i3 = 0;
            Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
            DrmInitData drmInitData = this.sideloadedDrmInitData;
            if (drmInitData == null) {
                drmInitData = getDrmInitDataFromAtoms(containerAtom.leafChildren);
            }
            Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
            SparseArray sparseArray = new SparseArray();
            int size = containerAtomOfType.leafChildren.size();
            long j = -9223372036854775807L;
            for (int i4 = 0; i4 < size; i4++) {
                Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i4);
                int i5 = leafAtom.type;
                if (i5 == Atom.TYPE_trex) {
                    Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                    sparseArray.put(((Integer) parseTrex.first).intValue(), parseTrex.second);
                } else if (i5 == Atom.TYPE_mehd) {
                    j = parseMehd(leafAtom.data);
                }
            }
            SparseArray sparseArray2 = new SparseArray();
            int size2 = containerAtom.containerChildren.size();
            int i6 = 0;
            while (i6 < size2) {
                Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i6);
                if (containerAtom2.type == Atom.TYPE_trak) {
                    i = i6;
                    i2 = size2;
                    Track parseTrak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), j, drmInitData, (this.flags & 32) != 0, false);
                    if (parseTrak != null) {
                        sparseArray2.put(parseTrak.id, parseTrak);
                    }
                } else {
                    i = i6;
                    i2 = size2;
                }
                i6 = i + 1;
                size2 = i2;
            }
            int size3 = sparseArray2.size();
            if (this.trackBundles.size() == 0) {
                while (i3 < size3) {
                    Track track = (Track) sparseArray2.valueAt(i3);
                    TrackBundle trackBundle = new TrackBundle(this.extractorOutput.track(i3, track.type));
                    trackBundle.init(track, (DefaultSampleValues) sparseArray.get(track.id));
                    this.trackBundles.put(track.id, trackBundle);
                    this.durationUs = Math.max(this.durationUs, track.durationUs);
                    i3++;
                }
                maybeInitExtraTracks();
                this.extractorOutput.endTracks();
                return;
            }
            Assertions.checkState(this.trackBundles.size() == size3);
            while (i3 < size3) {
                Track track2 = (Track) sparseArray2.valueAt(i3);
                this.trackBundles.get(track2.id).init(track2, (DefaultSampleValues) sparseArray.get(track2.id));
                i3++;
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

    public static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i, byte[] bArr) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65552, null, containerAtom, sparseArray, i, bArr) == null) {
            int size = containerAtom.containerChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i2);
                if (containerAtom2.type == Atom.TYPE_traf) {
                    parseTraf(containerAtom2, sparseArray, i, bArr);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, trackEncryptionBox, parsableByteArray, trackFragment) == null) {
            int i2 = trackEncryptionBox.initializationVectorSize;
            parsableByteArray.setPosition(8);
            if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
                parsableByteArray.skipBytes(8);
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == trackFragment.sampleCount) {
                if (readUnsignedByte == 0) {
                    boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
                    i = 0;
                    for (int i3 = 0; i3 < readUnsignedIntToInt; i3++) {
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        i += readUnsignedByte2;
                        zArr[i3] = readUnsignedByte2 > i2;
                    }
                } else {
                    i = (readUnsignedByte * readUnsignedIntToInt) + 0;
                    Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, readUnsignedByte > i2);
                }
                trackFragment.initEncryptionData(i);
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
                    int i = (readUnsignedByte & 240) >> 4;
                    int i2 = readUnsignedByte & 15;
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
                        trackFragment.trackEncryptionBox = new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i, i2, bArr);
                        return;
                    }
                    return;
                }
                throw new ParserException("Entry count in sgpd != 1 (unsupported).");
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    public static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j) throws ParserException {
        InterceptResult invokeLJ;
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65558, null, parsableByteArray, j)) == null) {
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
            long j2 = readUnsignedLongToLong;
            long j3 = j + readUnsignedLongToLong2;
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(j2, 1000000L, readUnsignedInt);
            parsableByteArray.skipBytes(2);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int[] iArr = new int[readUnsignedShort];
            long[] jArr = new long[readUnsignedShort];
            long[] jArr2 = new long[readUnsignedShort];
            long[] jArr3 = new long[readUnsignedShort];
            long j4 = j2;
            long j5 = scaleLargeTimestamp;
            int i = 0;
            while (i < readUnsignedShort) {
                int readInt = parsableByteArray.readInt();
                if ((readInt & Integer.MIN_VALUE) == 0) {
                    long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                    iArr[i] = readInt & Integer.MAX_VALUE;
                    jArr[i] = j3;
                    jArr3[i] = j5;
                    long j6 = j4 + readUnsignedInt2;
                    long[] jArr4 = jArr2;
                    long[] jArr5 = jArr3;
                    int i2 = readUnsignedShort;
                    int[] iArr2 = iArr;
                    long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j6, 1000000L, readUnsignedInt);
                    jArr4[i] = scaleLargeTimestamp2 - jArr5[i];
                    parsableByteArray.skipBytes(4);
                    j3 += iArr2[i];
                    i++;
                    iArr = iArr2;
                    jArr3 = jArr5;
                    jArr2 = jArr4;
                    jArr = jArr;
                    readUnsignedShort = i2;
                    j4 = j6;
                    j5 = scaleLargeTimestamp2;
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

    public static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65560, null, parsableByteArray, sparseArray, i)) == null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
            int readInt = parsableByteArray.readInt();
            if ((i & 16) != 0) {
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

    public static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i, byte[] bArr) throws ParserException {
        TrackBundle parseTfhd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65561, null, containerAtom, sparseArray, i, bArr) == null) || (parseTfhd = parseTfhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, sparseArray, i)) == null) {
            return;
        }
        TrackFragment trackFragment = parseTfhd.fragment;
        long j = trackFragment.nextFragmentDecodeTime;
        parseTfhd.reset();
        if (containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt) != null && (i & 2) == 0) {
            j = parseTfdt(containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt).data);
        }
        parseTruns(containerAtom, parseTfhd, j, i);
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
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i2);
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

    public static int parseTrun(TrackBundle trackBundle, int i, long j, int i2, ParsableByteArray parsableByteArray, int i3) {
        InterceptResult invokeCommon;
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{trackBundle, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), parsableByteArray, Integer.valueOf(i3)})) == null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
            Track track = trackBundle.track;
            TrackFragment trackFragment = trackBundle.fragment;
            DefaultSampleValues defaultSampleValues = trackFragment.header;
            trackFragment.trunLength[i] = parsableByteArray.readUnsignedIntToInt();
            long[] jArr = trackFragment.trunDataPosition;
            jArr[i] = trackFragment.dataPosition;
            if ((parseFullAtomFlags & 1) != 0) {
                jArr[i] = jArr[i] + parsableByteArray.readInt();
            }
            boolean z6 = (parseFullAtomFlags & 4) != 0;
            int i6 = defaultSampleValues.flags;
            if (z6) {
                i6 = parsableByteArray.readUnsignedIntToInt();
            }
            boolean z7 = (parseFullAtomFlags & 256) != 0;
            boolean z8 = (parseFullAtomFlags & 512) != 0;
            boolean z9 = (parseFullAtomFlags & 1024) != 0;
            boolean z10 = (parseFullAtomFlags & 2048) != 0;
            long[] jArr2 = track.editListDurations;
            long j2 = 0;
            if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
                j2 = Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000L, track.timescale);
            }
            int[] iArr = trackFragment.sampleSizeTable;
            int[] iArr2 = trackFragment.sampleCompositionTimeOffsetTable;
            long[] jArr3 = trackFragment.sampleDecodingTimeTable;
            boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
            int i7 = i6;
            boolean z11 = track.type == 2 && (i2 & 1) != 0;
            int i8 = i3 + trackFragment.trunLength[i];
            long j3 = track.timescale;
            long j4 = j2;
            long j5 = i > 0 ? trackFragment.nextFragmentDecodeTime : j;
            int i9 = i3;
            while (i9 < i8) {
                int readUnsignedIntToInt = z7 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.duration;
                if (z8) {
                    z = z7;
                    i4 = parsableByteArray.readUnsignedIntToInt();
                } else {
                    z = z7;
                    i4 = defaultSampleValues.size;
                }
                if (i9 == 0 && z6) {
                    z2 = z6;
                    i5 = i7;
                } else if (z9) {
                    z2 = z6;
                    i5 = parsableByteArray.readInt();
                } else {
                    z2 = z6;
                    i5 = defaultSampleValues.flags;
                }
                if (z10) {
                    z3 = z10;
                    z4 = z8;
                    z5 = z9;
                    iArr2[i9] = (int) ((parsableByteArray.readInt() * 1000) / j3);
                } else {
                    z3 = z10;
                    z4 = z8;
                    z5 = z9;
                    iArr2[i9] = 0;
                }
                jArr3[i9] = Util.scaleLargeTimestamp(j5, 1000L, j3) - j4;
                iArr[i9] = i4;
                zArr[i9] = ((i5 >> 16) & 1) == 0 && (!z11 || i9 == 0);
                i9++;
                j5 += readUnsignedIntToInt;
                j3 = j3;
                z7 = z;
                z6 = z2;
                z10 = z3;
                z8 = z4;
                z9 = z5;
            }
            trackFragment.nextFragmentDecodeTime = j5;
            return i8;
        }
        return invokeCommon.intValue;
    }

    public static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{containerAtom, trackBundle, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            List<Atom.LeafAtom> list = containerAtom.leafChildren;
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Atom.LeafAtom leafAtom = list.get(i4);
                if (leafAtom.type == Atom.TYPE_trun) {
                    ParsableByteArray parsableByteArray = leafAtom.data;
                    parsableByteArray.setPosition(12);
                    int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                    if (readUnsignedIntToInt > 0) {
                        i3 += readUnsignedIntToInt;
                        i2++;
                    }
                }
            }
            trackBundle.currentTrackRunIndex = 0;
            trackBundle.currentSampleInTrackRun = 0;
            trackBundle.currentSampleIndex = 0;
            trackBundle.fragment.initTables(i2, i3);
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Atom.LeafAtom leafAtom2 = list.get(i7);
                if (leafAtom2.type == Atom.TYPE_trun) {
                    i6 = parseTrun(trackBundle, i5, j, i, leafAtom2.data, i6);
                    i5++;
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

    private void processAtomEnded(long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65566, this, j) == null) {
            while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
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
                long position = extractorInput.getPosition() - this.atomHeaderBytesRead;
                if (this.atomType == Atom.TYPE_moof) {
                    int size = this.trackBundles.size();
                    for (int i = 0; i < size; i++) {
                        TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
                        trackFragment.atomPosition = position;
                        trackFragment.auxiliaryDataPosition = position;
                        trackFragment.dataPosition = position;
                    }
                }
                int i2 = this.atomType;
                if (i2 == Atom.TYPE_mdat) {
                    this.currentTrackBundle = null;
                    this.endOfMdatPosition = position + this.atomSize;
                    if (!this.haveOutputSeekMap) {
                        this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                        this.haveOutputSeekMap = true;
                    }
                    this.parserState = 2;
                    return true;
                }
                if (shouldParseContainerAtom(i2)) {
                    long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
                    this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, position2));
                    if (this.atomSize == this.atomHeaderBytesRead) {
                        processAtomEnded(position2);
                    } else {
                        enterReadingAtomHeaderState();
                    }
                } else if (shouldParseLeafAtom(this.atomType)) {
                    if (this.atomHeaderBytesRead == 8) {
                        long j2 = this.atomSize;
                        if (j2 <= 2147483647L) {
                            ParsableByteArray parsableByteArray = new ParsableByteArray((int) j2);
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
            int i = ((int) this.atomSize) - this.atomHeaderBytesRead;
            ParsableByteArray parsableByteArray = this.atomData;
            if (parsableByteArray != null) {
                extractorInput.readFully(parsableByteArray.data, 8, i);
                onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), extractorInput.getPosition());
            } else {
                extractorInput.skipFully(i);
            }
            processAtomEnded(extractorInput.getPosition());
        }
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, extractorInput) == null) {
            int size = this.trackBundles.size();
            TrackBundle trackBundle = null;
            long j = Long.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
                if (trackFragment.sampleEncryptionDataNeedsFill) {
                    long j2 = trackFragment.auxiliaryDataPosition;
                    if (j2 < j) {
                        trackBundle = this.trackBundles.valueAt(i);
                        j = j2;
                    }
                }
            }
            if (trackBundle == null) {
                this.parserState = 3;
                return;
            }
            int position = (int) (j - extractorInput.getPosition());
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
            int i = 4;
            int i2 = 1;
            int i3 = 0;
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
                        Log.w(TAG, "Ignoring negative offset to sample data.");
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
            int i4 = trackBundle2.currentSampleIndex;
            int i5 = track.nalUnitLengthFieldLength;
            if (i5 == 0) {
                while (true) {
                    int i6 = this.sampleBytesWritten;
                    int i7 = this.sampleSize;
                    if (i6 >= i7) {
                        break;
                    }
                    this.sampleBytesWritten += r9.sampleData(extractorInput, i7 - i6, false);
                }
            } else {
                byte[] bArr = this.nalPrefix.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i8 = i5 + 1;
                int i9 = 4 - i5;
                while (this.sampleBytesWritten < this.sampleSize) {
                    int i10 = this.sampleCurrentNalBytesRemaining;
                    if (i10 == 0) {
                        extractorInput.readFully(bArr, i9, i8);
                        this.nalPrefix.setPosition(i3);
                        this.sampleCurrentNalBytesRemaining = this.nalPrefix.readUnsignedIntToInt() - i2;
                        this.nalStartCode.setPosition(i3);
                        r9.sampleData(this.nalStartCode, i);
                        r9.sampleData(this.nalPrefix, i2);
                        this.processSeiNalUnitPayload = this.cea608TrackOutputs != null && NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, bArr[i]);
                        this.sampleBytesWritten += 5;
                        this.sampleSize += i9;
                    } else {
                        if (this.processSeiNalUnitPayload) {
                            this.nalBuffer.reset(i10);
                            extractorInput.readFully(this.nalBuffer.data, i3, this.sampleCurrentNalBytesRemaining);
                            r9.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                            sampleData = this.sampleCurrentNalBytesRemaining;
                            ParsableByteArray parsableByteArray = this.nalBuffer;
                            int unescapeStream = NalUnitUtil.unescapeStream(parsableByteArray.data, parsableByteArray.limit());
                            this.nalBuffer.setPosition(MimeTypes.VIDEO_H265.equals(track.format.sampleMimeType) ? 1 : 0);
                            this.nalBuffer.setLimit(unescapeStream);
                            CeaUtil.consume(trackFragment2.getSamplePresentationTime(i4) * 1000, this.nalBuffer, this.cea608TrackOutputs);
                        } else {
                            sampleData = r9.sampleData(extractorInput, i10, false);
                        }
                        this.sampleBytesWritten += sampleData;
                        this.sampleCurrentNalBytesRemaining -= sampleData;
                        i = 4;
                        i2 = 1;
                        i3 = 0;
                    }
                }
            }
            long samplePresentationTime = trackFragment2.getSamplePresentationTime(i4) * 1000;
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster != null) {
                samplePresentationTime = timestampAdjuster.adjustSampleTimestamp(samplePresentationTime);
            }
            boolean z = trackFragment2.sampleIsSyncFrameTable[i4];
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
                int i11 = this.pendingMetadataSampleBytes;
                int i12 = removeFirst.size;
                int i13 = i11 - i12;
                this.pendingMetadataSampleBytes = i13;
                this.eventMessageTrackOutput.sampleMetadata(samplePresentationTime + removeFirst.presentationTimeDeltaUs, 1, i12, i13, null);
            }
            TrackBundle trackBundle3 = this.currentTrackBundle;
            trackBundle3.currentSampleIndex++;
            int i14 = trackBundle3.currentSampleInTrackRun + 1;
            trackBundle3.currentSampleInTrackRun = i14;
            int[] iArr = trackFragment2.trunLength;
            int i15 = trackBundle3.currentTrackRunIndex;
            if (i14 == iArr[i15]) {
                trackBundle3.currentTrackRunIndex = i15 + 1;
                trackBundle3.currentSampleInTrackRun = 0;
                this.currentTrackBundle = null;
            }
            this.parserState = 3;
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean shouldParseContainerAtom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65571, null, i)) == null) ? i == Atom.TYPE_moov || i == Atom.TYPE_trak || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl || i == Atom.TYPE_moof || i == Atom.TYPE_traf || i == Atom.TYPE_mvex || i == Atom.TYPE_edts : invokeI.booleanValue;
    }

    public static boolean shouldParseLeafAtom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i)) == null) ? i == Atom.TYPE_hdlr || i == Atom.TYPE_mdhd || i == Atom.TYPE_mvhd || i == Atom.TYPE_sidx || i == Atom.TYPE_stsd || i == Atom.TYPE_tfdt || i == Atom.TYPE_tfhd || i == Atom.TYPE_tkhd || i == Atom.TYPE_trex || i == Atom.TYPE_trun || i == Atom.TYPE_pssh || i == Atom.TYPE_saiz || i == Atom.TYPE_saio || i == Atom.TYPE_senc || i == Atom.TYPE_uuid || i == Atom.TYPE_sbgp || i == Atom.TYPE_sgpd || i == Atom.TYPE_elst || i == Atom.TYPE_mehd || i == Atom.TYPE_emsg : invokeI.booleanValue;
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
            int i = this.parserState;
            if (i != 0) {
                if (i == 1) {
                    readAtomPayload(extractorInput);
                } else if (i != 2) {
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
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            int size = this.trackBundles.size();
            for (int i = 0; i < size; i++) {
                this.trackBundles.valueAt(i).reset();
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
    public FragmentedMp4Extractor(int i) {
        this(i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (TimestampAdjuster) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static void parseSenc(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, parsableByteArray, i, trackFragment) == null) {
            parsableByteArray.setPosition(i + 8);
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
    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster) {
        this(i, timestampAdjuster, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), timestampAdjuster};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (TimestampAdjuster) objArr2[1], (Track) objArr2[2], (DrmInitData) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster, Track track, DrmInitData drmInitData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), timestampAdjuster, track, drmInitData};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.flags = i | (track != null ? 16 : 0);
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
