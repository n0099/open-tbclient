package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class HlsChunkSource {
    public final DataSource encryptionDataSource;
    public byte[] encryptionIv;
    public String encryptionIvString;
    public byte[] encryptionKey;
    public Uri encryptionKeyUri;
    public HlsMasterPlaylist.HlsUrl expectedPlaylistUrl;
    public final HlsExtractorFactory extractorFactory;
    public IOException fatalError;
    public boolean independentSegments;
    public boolean isTimestampMaster;
    public long liveEdgeTimeUs = C.TIME_UNSET;
    public final DataSource mediaDataSource;
    public final List<Format> muxedCaptionFormats;
    public final HlsPlaylistTracker playlistTracker;
    public byte[] scratchSpace;
    public final TimestampAdjusterProvider timestampAdjusterProvider;
    public final TrackGroup trackGroup;
    public TrackSelection trackSelection;
    public final HlsMasterPlaylist.HlsUrl[] variants;

    /* loaded from: classes9.dex */
    public static final class EncryptionKeyChunk extends DataChunk {
        public final String iv;
        public byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr, String str) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
            this.iv = str;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        public void consume(byte[] bArr, int i) throws IOException {
            this.result = Arrays.copyOf(bArr, i);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    /* loaded from: classes9.dex */
    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public HlsMasterPlaylist.HlsUrl playlist;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlist = null;
        }
    }

    /* loaded from: classes9.dex */
    public static final class InitializationTrackSelection extends BaseTrackSelection {
        public int selectedIndex;

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j, long j2, long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!isBlacklisted(this.selectedIndex, elapsedRealtime)) {
                return;
            }
            for (int i = this.length - 1; i >= 0; i--) {
                if (!isBlacklisted(i, elapsedRealtime)) {
                    this.selectedIndex = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, HlsDataSourceFactory hlsDataSourceFactory, TimestampAdjusterProvider timestampAdjusterProvider, List<Format> list) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.variants = hlsUrlArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.muxedCaptionFormats = list;
        Format[] formatArr = new Format[hlsUrlArr.length];
        int[] iArr = new int[hlsUrlArr.length];
        for (int i = 0; i < hlsUrlArr.length; i++) {
            formatArr[i] = hlsUrlArr[i].format;
            iArr[i] = i;
        }
        this.mediaDataSource = hlsDataSourceFactory.createDataSource(1);
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        TrackGroup trackGroup = new TrackGroup(formatArr);
        this.trackGroup = trackGroup;
        this.trackSelection = new InitializationTrackSelection(trackGroup, iArr);
    }

    private void clearEncryptionData() {
        this.encryptionKeyUri = null;
        this.encryptionKey = null;
        this.encryptionIvString = null;
        this.encryptionIv = null;
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            HlsMasterPlaylist.HlsUrl hlsUrl = this.expectedPlaylistUrl;
            if (hlsUrl != null) {
                this.playlistTracker.maybeThrowPlaylistRefreshError(hlsUrl);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void reset() {
        this.fatalError = null;
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String str, int i, int i2, Object obj) {
        return new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec(uri, 0L, -1L, null, 1), this.variants[i].format, i2, obj, this.scratchSpace, str);
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        boolean z;
        if (this.liveEdgeTimeUs != C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return C.TIME_UNSET;
        }
        return this.liveEdgeTimeUs - j;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        long endTimeUs;
        if (hlsMediaPlaylist.hasEndTag) {
            endTimeUs = C.TIME_UNSET;
        } else {
            endTimeUs = hlsMediaPlaylist.getEndTimeUs();
        }
        this.liveEdgeTimeUs = endTimeUs;
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            setEncryptionData(encryptionKeyChunk.dataSpec.uri, encryptionKeyChunk.iv, encryptionKeyChunk.getResult());
        }
    }

    public void selectTracks(TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    public void setIsTimestampMaster(boolean z) {
        this.isTimestampMaster = z;
    }

    private void setEncryptionData(Uri uri, String str, byte[] bArr) {
        String str2;
        int i;
        if (Util.toLowerInvariant(str).startsWith("0x")) {
            str2 = str.substring(2);
        } else {
            str2 = str;
        }
        byte[] byteArray = new BigInteger(str2, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        if (byteArray.length > 16) {
            i = byteArray.length - 16;
        } else {
            i = 0;
        }
        System.arraycopy(byteArray, i, bArr2, (16 - byteArray.length) + i, byteArray.length - i);
        this.encryptionKeyUri = uri;
        this.encryptionKey = bArr;
        this.encryptionIvString = str;
        this.encryptionIv = bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getNextChunk(HlsMediaChunk hlsMediaChunk, long j, long j2, HlsChunkHolder hlsChunkHolder) {
        int indexOf;
        boolean z;
        long j3;
        int i;
        int i2;
        if (hlsMediaChunk == null) {
            indexOf = -1;
        } else {
            indexOf = this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        }
        DataSpec dataSpec = null;
        this.expectedPlaylistUrl = null;
        long j4 = j2 - j;
        long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
        if (hlsMediaChunk != null && !this.independentSegments) {
            long durationUs = hlsMediaChunk.getDurationUs();
            j4 = Math.max(0L, j4 - durationUs);
            if (resolveTimeToLiveEdgeUs != C.TIME_UNSET) {
                resolveTimeToLiveEdgeUs = Math.max(0L, resolveTimeToLiveEdgeUs - durationUs);
            }
        }
        this.trackSelection.updateSelectedTrack(j, j4, resolveTimeToLiveEdgeUs);
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z2 = false;
        if (indexOf != selectedIndexInTrackGroup) {
            z = true;
        } else {
            z = false;
        }
        HlsMasterPlaylist.HlsUrl hlsUrl = this.variants[selectedIndexInTrackGroup];
        if (!this.playlistTracker.isSnapshotValid(hlsUrl)) {
            hlsChunkHolder.playlist = hlsUrl;
            this.expectedPlaylistUrl = hlsUrl;
            return;
        }
        HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(hlsUrl);
        this.independentSegments = playlistSnapshot.hasIndependentSegmentsTag;
        updateLiveEdgeTimeUs(playlistSnapshot);
        if (hlsMediaChunk != null && !z) {
            i = hlsMediaChunk.getNextChunkIndex();
        } else {
            if (hlsMediaChunk != null && !this.independentSegments) {
                j3 = hlsMediaChunk.startTimeUs;
            } else {
                j3 = j2;
            }
            if (!playlistSnapshot.hasEndTag && j3 >= playlistSnapshot.getEndTimeUs()) {
                i = playlistSnapshot.mediaSequence + playlistSnapshot.segments.size();
            } else {
                int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) playlistSnapshot.segments, Long.valueOf(j3 - playlistSnapshot.startTimeUs), true, (!this.playlistTracker.isLive() || hlsMediaChunk == null) ? true : true);
                int i3 = playlistSnapshot.mediaSequence;
                i = binarySearchFloor + i3;
                if (i < i3 && hlsMediaChunk != null) {
                    hlsUrl = this.variants[indexOf];
                    HlsMediaPlaylist playlistSnapshot2 = this.playlistTracker.getPlaylistSnapshot(hlsUrl);
                    i = hlsMediaChunk.getNextChunkIndex();
                    playlistSnapshot = playlistSnapshot2;
                    HlsMasterPlaylist.HlsUrl hlsUrl2 = hlsUrl;
                    HlsMediaPlaylist hlsMediaPlaylist = playlistSnapshot;
                    i2 = hlsMediaPlaylist.mediaSequence;
                    if (i >= i2) {
                        this.fatalError = new BehindLiveWindowException();
                        return;
                    }
                    int i4 = i - i2;
                    if (i4 >= hlsMediaPlaylist.segments.size()) {
                        if (hlsMediaPlaylist.hasEndTag) {
                            hlsChunkHolder.endOfStream = true;
                            return;
                        }
                        hlsChunkHolder.playlist = hlsUrl2;
                        this.expectedPlaylistUrl = hlsUrl2;
                        return;
                    }
                    HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i4);
                    String str = segment.fullSegmentEncryptionKeyUri;
                    if (str != null) {
                        Uri resolveToUri = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str);
                        if (!resolveToUri.equals(this.encryptionKeyUri)) {
                            hlsChunkHolder.chunk = newEncryptionKeyChunk(resolveToUri, segment.encryptionIV, indexOf, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
                            return;
                        } else if (!Util.areEqual(segment.encryptionIV, this.encryptionIvString)) {
                            setEncryptionData(resolveToUri, segment.encryptionIV, this.encryptionKey);
                        }
                    } else {
                        clearEncryptionData();
                    }
                    HlsMediaPlaylist.Segment segment2 = hlsMediaPlaylist.initializationSegment;
                    if (segment2 != null) {
                        dataSpec = new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment2.url), segment2.byterangeOffset, segment2.byterangeLength, null);
                    }
                    long j5 = hlsMediaPlaylist.startTimeUs + segment.relativeStartTimeUs;
                    int i5 = hlsMediaPlaylist.discontinuitySequence + segment.relativeDiscontinuitySequence;
                    TimestampAdjuster adjuster = this.timestampAdjusterProvider.getAdjuster(i5);
                    hlsChunkHolder.chunk = new HlsMediaChunk(this.extractorFactory, this.mediaDataSource, new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null), dataSpec, hlsUrl2, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), j5, j5 + segment.durationUs, i, i5, this.isTimestampMaster, adjuster, hlsMediaChunk, hlsMediaPlaylist.drmInitData, this.encryptionKey, this.encryptionIv);
                    return;
                }
            }
        }
        indexOf = selectedIndexInTrackGroup;
        HlsMasterPlaylist.HlsUrl hlsUrl22 = hlsUrl;
        HlsMediaPlaylist hlsMediaPlaylist2 = playlistSnapshot;
        i2 = hlsMediaPlaylist2.mediaSequence;
        if (i >= i2) {
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, IOException iOException) {
        if (z) {
            TrackSelection trackSelection = this.trackSelection;
            if (ChunkedTrackBlacklistUtil.maybeBlacklistTrack(trackSelection, trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), iOException)) {
                return true;
            }
        }
        return false;
    }

    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j) {
        int indexOf;
        int indexOf2 = this.trackGroup.indexOf(hlsUrl.format);
        if (indexOf2 != -1 && (indexOf = this.trackSelection.indexOf(indexOf2)) != -1) {
            this.trackSelection.blacklist(indexOf, j);
        }
    }
}
