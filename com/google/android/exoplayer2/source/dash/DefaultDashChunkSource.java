package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
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
        public final DataSource.Factory dataSourceFactory;
        public final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(DataSource.Factory factory, int i) {
            this.dataSourceFactory = factory;
            this.maxSegmentsPerLoad = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, long j, boolean z, boolean z2) {
            return new DefaultDashChunkSource(loaderErrorThrower, dashManifest, i, iArr, trackSelection, i2, this.dataSourceFactory.createDataSource(), j, this.maxSegmentsPerLoad, z, z2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class RepresentationHolder {
        public final ChunkExtractorWrapper extractorWrapper;
        public long periodDurationUs;
        public Representation representation;
        public DashSegmentIndex segmentIndex;
        public int segmentNumShift;

        public RepresentationHolder(long j, int i, Representation representation, boolean z, boolean z2) {
            Extractor fragmentedMp4Extractor;
            this.periodDurationUs = j;
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
                    int i2 = z ? 4 : 0;
                    fragmentedMp4Extractor = new FragmentedMp4Extractor(z2 ? i2 | 8 : i2);
                }
                this.extractorWrapper = new ChunkExtractorWrapper(fragmentedMp4Extractor, i, representation.format);
            }
            this.segmentIndex = representation.getIndex();
        }

        public static boolean mimeTypeIsRawText(String str) {
            if (!MimeTypes.isText(str) && !MimeTypes.APPLICATION_TTML.equals(str)) {
                return false;
            }
            return true;
        }

        public static boolean mimeTypeIsWebm(String str) {
            if (!str.startsWith(MimeTypes.VIDEO_WEBM) && !str.startsWith(MimeTypes.AUDIO_WEBM) && !str.startsWith(MimeTypes.APPLICATION_WEBM)) {
                return false;
            }
            return true;
        }

        public long getSegmentEndTimeUs(int i) {
            return getSegmentStartTimeUs(i) + this.segmentIndex.getDurationUs(i - this.segmentNumShift, this.periodDurationUs);
        }

        public int getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.periodDurationUs) + this.segmentNumShift;
        }

        public long getSegmentStartTimeUs(int i) {
            return this.segmentIndex.getTimeUs(i - this.segmentNumShift);
        }

        public RangedUri getSegmentUrl(int i) {
            return this.segmentIndex.getSegmentUrl(i - this.segmentNumShift);
        }

        public int getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public void updateRepresentation(long j, Representation representation) throws BehindLiveWindowException {
            int segmentCount;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation.getIndex();
            this.periodDurationUs = j;
            this.representation = representation;
            if (index == null) {
                return;
            }
            this.segmentIndex = index2;
            if (!index.isExplicit() || (segmentCount = index.getSegmentCount(this.periodDurationUs)) == 0) {
                return;
            }
            int firstSegmentNum = (index.getFirstSegmentNum() + segmentCount) - 1;
            long timeUs = index.getTimeUs(firstSegmentNum) + index.getDurationUs(firstSegmentNum, this.periodDurationUs);
            int firstSegmentNum2 = index2.getFirstSegmentNum();
            long timeUs2 = index2.getTimeUs(firstSegmentNum2);
            int i = (timeUs > timeUs2 ? 1 : (timeUs == timeUs2 ? 0 : -1));
            if (i == 0) {
                this.segmentNumShift += (firstSegmentNum + 1) - firstSegmentNum2;
            } else if (i >= 0) {
                this.segmentNumShift += index.getSegmentNum(timeUs2, this.periodDurationUs) - firstSegmentNum2;
            } else {
                throw new BehindLiveWindowException();
            }
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, DataSource dataSource, long j, int i3, boolean z, boolean z2) {
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndices = iArr;
        this.trackSelection = trackSelection;
        this.trackType = i2;
        this.dataSource = dataSource;
        this.periodIndex = i;
        this.elapsedRealtimeOffsetMs = j;
        this.maxSegmentsPerLoad = i3;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i);
        this.liveEdgeTimeUs = C.TIME_UNSET;
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[trackSelection.length()];
        for (int i4 = 0; i4 < this.representationHolders.length; i4++) {
            this.representationHolders[i4] = new RepresentationHolder(periodDurationUs, i2, representations.get(trackSelection.getIndexInTrackGroup(i4)), z, z2);
        }
    }

    private long getNowUnixTimeUs() {
        long currentTimeMillis;
        if (this.elapsedRealtimeOffsetMs != 0) {
            currentTimeMillis = SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        return currentTimeMillis * 1000;
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public static Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        String str = representationHolder.representation.baseUrl;
        if (rangedUri == null || (rangedUri2 = rangedUri.attemptMerge(rangedUri2, str)) != null) {
            rangedUri = rangedUri2;
        }
        return new InitializationChunk(dataSource, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, representationHolder.representation.getCacheKey()), format, i, obj, representationHolder.extractorWrapper);
    }

    public static Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource, int i, Format format, int i2, Object obj, int i3, int i4) {
        Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(i3);
        RangedUri segmentUrl = representationHolder.getSegmentUrl(i3);
        String str = representation.baseUrl;
        if (representationHolder.extractorWrapper == null) {
            return new SingleSampleMediaChunk(dataSource, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i2, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i5 < i4) {
            RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder.getSegmentUrl(i3 + i5), str);
            if (attemptMerge == null) {
                break;
            }
            i6++;
            i5++;
            segmentUrl = attemptMerge;
        }
        return new ContainerMediaChunk(dataSource, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i2, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs((i3 + i6) - 1), i3, i6, -representation.presentationTimeOffsetUs, representationHolder.extractorWrapper);
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        boolean z;
        if (this.manifest.dynamic && this.liveEdgeTimeUs != C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return C.TIME_UNSET;
        }
        return this.liveEdgeTimeUs - j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat)];
            if (representationHolder.segmentIndex == null && (seekMap = representationHolder.extractorWrapper.getSeekMap()) != null) {
                representationHolder.segmentIndex = new DashWrappingSegmentIndex((ChunkIndex) seekMap);
            }
        }
    }

    private void updateLiveEdgeTimeUs(RepresentationHolder representationHolder, int i) {
        long j;
        if (this.manifest.dynamic) {
            j = representationHolder.getSegmentEndTimeUs(i);
        } else {
            j = C.TIME_UNSET;
        }
        this.liveEdgeTimeUs = j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.fatalError == null && this.trackSelection.length() >= 2) {
            return this.trackSelection.evaluateQueueSize(j, list);
        }
        return list.size();
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            ArrayList<Representation> representations = getRepresentations();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                this.representationHolders[i2].updateRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i2)));
            }
        } catch (BehindLiveWindowException e) {
            this.fatalError = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void getNextChunk(MediaChunk mediaChunk, long j, long j2, ChunkHolder chunkHolder) {
        int i;
        int nextChunkIndex;
        RangedUri rangedUri;
        RangedUri rangedUri2;
        if (this.fatalError != null) {
            return;
        }
        this.trackSelection.updateSelectedTrack(j, j2 - j, resolveTimeToLiveEdgeUs(j));
        RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.getSelectedIndex()];
        ChunkExtractorWrapper chunkExtractorWrapper = representationHolder.extractorWrapper;
        if (chunkExtractorWrapper != null) {
            Representation representation = representationHolder.representation;
            if (chunkExtractorWrapper.getSampleFormats() == null) {
                rangedUri = representation.getInitializationUri();
            } else {
                rangedUri = null;
            }
            if (representationHolder.segmentIndex == null) {
                rangedUri2 = representation.getIndexUri();
            } else {
                rangedUri2 = null;
            }
            if (rangedUri != null || rangedUri2 != null) {
                chunkHolder.chunk = newInitializationChunk(representationHolder, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), rangedUri, rangedUri2);
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
            long j3 = this.manifest.timeShiftBufferDepth;
            if (j3 != C.TIME_UNSET) {
                firstSegmentNum = Math.max(firstSegmentNum, representationHolder.getSegmentNum(nowUnixTimeUs - C.msToUs(j3)));
            }
            i = representationHolder.getSegmentNum(nowUnixTimeUs);
        } else {
            i = segmentCount + firstSegmentNum;
        }
        int i2 = i - 1;
        updateLiveEdgeTimeUs(representationHolder, i2);
        if (mediaChunk == null) {
            nextChunkIndex = Util.constrainValue(representationHolder.getSegmentNum(j2), firstSegmentNum, i2);
        } else {
            nextChunkIndex = mediaChunk.getNextChunkIndex();
            if (nextChunkIndex < firstSegmentNum) {
                this.fatalError = new BehindLiveWindowException();
                return;
            }
        }
        int i3 = nextChunkIndex;
        if (i3 <= i2 && (!this.missingLastSegment || i3 < i2)) {
            chunkHolder.chunk = newMediaChunk(representationHolder, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), i3, Math.min(this.maxSegmentsPerLoad, (i2 - i3) + 1));
            return;
        }
        DashManifest dashManifest2 = this.manifest;
        chunkHolder.endOfStream = (!dashManifest2.dynamic || this.periodIndex < dashManifest2.getPeriodCount() - 1) ? true : true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc) {
        RepresentationHolder representationHolder;
        int segmentCount;
        if (!z) {
            return false;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                this.missingLastSegment = true;
                return true;
            }
        }
        TrackSelection trackSelection = this.trackSelection;
        return ChunkedTrackBlacklistUtil.maybeBlacklistTrack(trackSelection, trackSelection.indexOf(chunk.trackFormat), exc);
    }
}
