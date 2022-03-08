package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class DefaultDashChunkSource implements DashChunkSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] adaptationSetIndices;
    public final DataSource dataSource;
    public final long elapsedRealtimeOffsetMs;
    public IOException fatalError;
    public long liveEdgeTimeUs;
    public DashManifest manifest;
    public final LoaderErrorThrower manifestLoaderErrorThrower;
    public final int maxSegmentsPerLoad;
    public boolean missingLastSegment;
    public int periodIndex;
    public final RepresentationHolder[] representationHolders;
    public final TrackSelection trackSelection;
    public final int trackType;

    /* loaded from: classes7.dex */
    public static final class Factory implements DashChunkSource.Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataSource.Factory dataSourceFactory;
        public final int maxSegmentsPerLoad;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory(DataSource.Factory factory) {
            this(factory, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {factory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((DataSource.Factory) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i2, int[] iArr, TrackSelection trackSelection, int i3, long j2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{loaderErrorThrower, dashManifest, Integer.valueOf(i2), iArr, trackSelection, Integer.valueOf(i3), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new DefaultDashChunkSource(loaderErrorThrower, dashManifest, i2, iArr, trackSelection, i3, this.dataSourceFactory.createDataSource(), j2, this.maxSegmentsPerLoad, z, z2) : (DashChunkSource) invokeCommon.objValue;
        }

        public Factory(DataSource.Factory factory, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {factory, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.dataSourceFactory = factory;
            this.maxSegmentsPerLoad = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class RepresentationHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ChunkExtractorWrapper extractorWrapper;
        public long periodDurationUs;
        public Representation representation;
        public DashSegmentIndex segmentIndex;
        public int segmentNumShift;

        public RepresentationHolder(long j2, int i2, Representation representation, boolean z, boolean z2) {
            Extractor fragmentedMp4Extractor;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), representation, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.periodDurationUs = j2;
            this.representation = representation;
            String str = representation.format.containerMimeType;
            if (mimeTypeIsRawText(str)) {
                this.extractorWrapper = null;
            } else {
                if (MimeTypes.APPLICATION_RAWCC.equals(str)) {
                    fragmentedMp4Extractor = new RawCcExtractor(representation.format);
                } else if (mimeTypeIsWebm(str)) {
                    fragmentedMp4Extractor = new MatroskaExtractor(1);
                } else {
                    int i5 = z ? 4 : 0;
                    fragmentedMp4Extractor = new FragmentedMp4Extractor(z2 ? i5 | 8 : i5);
                }
                this.extractorWrapper = new ChunkExtractorWrapper(fragmentedMp4Extractor, i2, representation.format);
            }
            this.segmentIndex = representation.getIndex();
        }

        public static boolean mimeTypeIsRawText(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str) : invokeL.booleanValue;
        }

        public static boolean mimeTypeIsWebm(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM) : invokeL.booleanValue;
        }

        public int getFirstSegmentNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift : invokeV.intValue;
        }

        public int getSegmentCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.segmentIndex.getSegmentCount(this.periodDurationUs) : invokeV.intValue;
        }

        public long getSegmentEndTimeUs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? getSegmentStartTimeUs(i2) + this.segmentIndex.getDurationUs(i2 - this.segmentNumShift, this.periodDurationUs) : invokeI.longValue;
        }

        public int getSegmentNum(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? this.segmentIndex.getSegmentNum(j2, this.periodDurationUs) + this.segmentNumShift : invokeJ.intValue;
        }

        public long getSegmentStartTimeUs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.segmentIndex.getTimeUs(i2 - this.segmentNumShift) : invokeI.longValue;
        }

        public RangedUri getSegmentUrl(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.segmentIndex.getSegmentUrl(i2 - this.segmentNumShift) : (RangedUri) invokeI.objValue;
        }

        public void updateRepresentation(long j2, Representation representation) throws BehindLiveWindowException {
            int segmentCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j2, representation) == null) {
                DashSegmentIndex index = this.representation.getIndex();
                DashSegmentIndex index2 = representation.getIndex();
                this.periodDurationUs = j2;
                this.representation = representation;
                if (index == null) {
                    return;
                }
                this.segmentIndex = index2;
                if (index.isExplicit() && (segmentCount = index.getSegmentCount(this.periodDurationUs)) != 0) {
                    int firstSegmentNum = (index.getFirstSegmentNum() + segmentCount) - 1;
                    long timeUs = index.getTimeUs(firstSegmentNum) + index.getDurationUs(firstSegmentNum, this.periodDurationUs);
                    int firstSegmentNum2 = index2.getFirstSegmentNum();
                    long timeUs2 = index2.getTimeUs(firstSegmentNum2);
                    int i2 = (timeUs > timeUs2 ? 1 : (timeUs == timeUs2 ? 0 : -1));
                    if (i2 == 0) {
                        this.segmentNumShift += (firstSegmentNum + 1) - firstSegmentNum2;
                    } else if (i2 >= 0) {
                        this.segmentNumShift += index.getSegmentNum(timeUs2, this.periodDurationUs) - firstSegmentNum2;
                    } else {
                        throw new BehindLiveWindowException();
                    }
                }
            }
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i2, int[] iArr, TrackSelection trackSelection, int i3, DataSource dataSource, long j2, int i4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {loaderErrorThrower, dashManifest, Integer.valueOf(i2), iArr, trackSelection, Integer.valueOf(i3), dataSource, Long.valueOf(j2), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndices = iArr;
        this.trackSelection = trackSelection;
        this.trackType = i3;
        this.dataSource = dataSource;
        this.periodIndex = i2;
        this.elapsedRealtimeOffsetMs = j2;
        this.maxSegmentsPerLoad = i4;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i2);
        this.liveEdgeTimeUs = C.TIME_UNSET;
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[trackSelection.length()];
        for (int i7 = 0; i7 < this.representationHolders.length; i7++) {
            this.representationHolders[i7] = new RepresentationHolder(periodDurationUs, i3, representations.get(trackSelection.getIndexInTrackGroup(i7)), z, z2);
        }
    }

    private long getNowUnixTimeUs() {
        InterceptResult invokeV;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.elapsedRealtimeOffsetMs != 0) {
                currentTimeMillis = SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            return currentTimeMillis * 1000;
        }
        return invokeV.longValue;
    }

    private ArrayList<Representation> getRepresentations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
            ArrayList<Representation> arrayList = new ArrayList<>();
            for (int i2 : this.adaptationSetIndices) {
                arrayList.addAll(list.get(i2).representations);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i2, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{representationHolder, dataSource, format, Integer.valueOf(i2), obj, rangedUri, rangedUri2})) == null) {
            String str = representationHolder.representation.baseUrl;
            if (rangedUri == null || (rangedUri2 = rangedUri.attemptMerge(rangedUri2, str)) != null) {
                rangedUri = rangedUri2;
            }
            return new InitializationChunk(dataSource, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, representationHolder.representation.getCacheKey()), format, i2, obj, representationHolder.extractorWrapper);
        }
        return (Chunk) invokeCommon.objValue;
    }

    public static Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource, int i2, Format format, int i3, Object obj, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{representationHolder, dataSource, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            Representation representation = representationHolder.representation;
            long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(i4);
            RangedUri segmentUrl = representationHolder.getSegmentUrl(i4);
            String str = representation.baseUrl;
            if (representationHolder.extractorWrapper == null) {
                return new SingleSampleMediaChunk(dataSource, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i3, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs(i4), i4, i2, format);
            }
            int i6 = 1;
            int i7 = 1;
            while (i6 < i5) {
                RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder.getSegmentUrl(i4 + i6), str);
                if (attemptMerge == null) {
                    break;
                }
                i7++;
                i6++;
                segmentUrl = attemptMerge;
            }
            return new ContainerMediaChunk(dataSource, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i3, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs((i4 + i7) - 1), i4, i7, -representation.presentationTimeOffsetUs, representationHolder.extractorWrapper);
        }
        return (Chunk) invokeCommon.objValue;
    }

    private long resolveTimeToLiveEdgeUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, this, j2)) == null) {
            return this.manifest.dynamic && (this.liveEdgeTimeUs > C.TIME_UNSET ? 1 : (this.liveEdgeTimeUs == C.TIME_UNSET ? 0 : -1)) != 0 ? this.liveEdgeTimeUs - j2 : C.TIME_UNSET;
        }
        return invokeJ.longValue;
    }

    private void updateLiveEdgeTimeUs(RepresentationHolder representationHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, this, representationHolder, i2) == null) {
            this.liveEdgeTimeUs = this.manifest.dynamic ? representationHolder.getSegmentEndTimeUs(i2) : C.TIME_UNSET;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void getNextChunk(MediaChunk mediaChunk, long j2, long j3, ChunkHolder chunkHolder) {
        int i2;
        int nextChunkIndex;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mediaChunk, Long.valueOf(j2), Long.valueOf(j3), chunkHolder}) == null) && this.fatalError == null) {
            this.trackSelection.updateSelectedTrack(j2, j3 - j2, resolveTimeToLiveEdgeUs(j2));
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.getSelectedIndex()];
            ChunkExtractorWrapper chunkExtractorWrapper = representationHolder.extractorWrapper;
            if (chunkExtractorWrapper != null) {
                Representation representation = representationHolder.representation;
                RangedUri initializationUri = chunkExtractorWrapper.getSampleFormats() == null ? representation.getInitializationUri() : null;
                RangedUri indexUri = representationHolder.segmentIndex == null ? representation.getIndexUri() : null;
                if (initializationUri != null || indexUri != null) {
                    chunkHolder.chunk = newInitializationChunk(representationHolder, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initializationUri, indexUri);
                    return;
                }
            }
            int segmentCount = representationHolder.getSegmentCount();
            boolean z = false;
            if (segmentCount == 0) {
                DashManifest dashManifest = this.manifest;
                chunkHolder.endOfStream = (!dashManifest.dynamic || this.periodIndex < dashManifest.getPeriodCount() - 1) ? true : true;
                return;
            }
            int firstSegmentNum = representationHolder.getFirstSegmentNum();
            if (segmentCount == -1) {
                long nowUnixTimeUs = (getNowUnixTimeUs() - C.msToUs(this.manifest.availabilityStartTime)) - C.msToUs(this.manifest.getPeriod(this.periodIndex).startMs);
                long j4 = this.manifest.timeShiftBufferDepth;
                if (j4 != C.TIME_UNSET) {
                    firstSegmentNum = Math.max(firstSegmentNum, representationHolder.getSegmentNum(nowUnixTimeUs - C.msToUs(j4)));
                }
                i2 = representationHolder.getSegmentNum(nowUnixTimeUs);
            } else {
                i2 = segmentCount + firstSegmentNum;
            }
            int i3 = i2 - 1;
            updateLiveEdgeTimeUs(representationHolder, i3);
            if (mediaChunk == null) {
                nextChunkIndex = Util.constrainValue(representationHolder.getSegmentNum(j3), firstSegmentNum, i3);
            } else {
                nextChunkIndex = mediaChunk.getNextChunkIndex();
                if (nextChunkIndex < firstSegmentNum) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            int i4 = nextChunkIndex;
            if (i4 <= i3 && (!this.missingLastSegment || i4 < i3)) {
                chunkHolder.chunk = newMediaChunk(representationHolder, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), i4, Math.min(this.maxSegmentsPerLoad, (i3 - i4) + 1));
                return;
            }
            DashManifest dashManifest2 = this.manifest;
            chunkHolder.endOfStream = (!dashManifest2.dynamic || this.periodIndex < dashManifest2.getPeriodCount() - 1) ? true : true;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j2, List<? extends MediaChunk> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, list)) == null) {
            if (this.fatalError == null && this.trackSelection.length() >= 2) {
                return this.trackSelection.evaluateQueueSize(j2, list);
            }
            return list.size();
        }
        return invokeJL.intValue;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            IOException iOException = this.fatalError;
            if (iOException == null) {
                this.manifestLoaderErrorThrower.maybeThrowError();
                return;
            }
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chunk) == null) && (chunk instanceof InitializationChunk)) {
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat)];
            if (representationHolder.segmentIndex != null || (seekMap = representationHolder.extractorWrapper.getSeekMap()) == null) {
                return;
            }
            representationHolder.segmentIndex = new DashWrappingSegmentIndex((ChunkIndex) seekMap);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        RepresentationHolder representationHolder;
        int segmentCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{chunk, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0 && ((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                    this.missingLastSegment = true;
                    return true;
                }
                TrackSelection trackSelection = this.trackSelection;
                return ChunkedTrackBlacklistUtil.maybeBlacklistTrack(trackSelection, trackSelection.indexOf(chunk.trackFormat), exc);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest dashManifest, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, dashManifest, i2) == null) {
            try {
                this.manifest = dashManifest;
                this.periodIndex = i2;
                long periodDurationUs = dashManifest.getPeriodDurationUs(i2);
                ArrayList<Representation> representations = getRepresentations();
                for (int i3 = 0; i3 < this.representationHolders.length; i3++) {
                    this.representationHolders[i3].updateRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i3)));
                }
            } catch (BehindLiveWindowException e2) {
                this.fatalError = e2;
            }
        }
    }
}
