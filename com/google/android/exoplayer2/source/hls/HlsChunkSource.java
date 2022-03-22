package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
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
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class HlsChunkSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public long liveEdgeTimeUs;
    public final DataSource mediaDataSource;
    public final List<Format> muxedCaptionFormats;
    public final HlsPlaylistTracker playlistTracker;
    public byte[] scratchSpace;
    public final TimestampAdjusterProvider timestampAdjusterProvider;
    public final TrackGroup trackGroup;
    public TrackSelection trackSelection;
    public final HlsMasterPlaylist.HlsUrl[] variants;

    /* loaded from: classes6.dex */
    public static final class EncryptionKeyChunk extends DataChunk {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String iv;
        public byte[] result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr, String str) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {dataSource, dataSpec, format, Integer.valueOf(i), obj, bArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((DataSource) objArr2[0], (DataSpec) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], (byte[]) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.iv = str;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        public void consume(byte[] bArr, int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, bArr, i) == null) {
                this.result = Arrays.copyOf(bArr, i);
            }
        }

        public byte[] getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.result : (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class HlsChunkHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Chunk chunk;
        public boolean endOfStream;
        public HlsMasterPlaylist.HlsUrl playlist;

        public HlsChunkHolder() {
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
            clear();
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.chunk = null;
                this.endOfStream = false;
                this.playlist = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class InitializationTrackSelection extends BaseTrackSelection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int selectedIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {trackGroup, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TrackGroup) objArr2[0], (int[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.selectedIndex : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (isBlacklisted(this.selectedIndex, elapsedRealtime)) {
                    for (int i = this.length - 1; i >= 0; i--) {
                        if (!isBlacklisted(i, elapsedRealtime)) {
                            this.selectedIndex = i;
                            return;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, HlsDataSourceFactory hlsDataSourceFactory, TimestampAdjusterProvider timestampAdjusterProvider, List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hlsExtractorFactory, hlsPlaylistTracker, hlsUrlArr, hlsDataSourceFactory, timestampAdjusterProvider, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.variants = hlsUrlArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.muxedCaptionFormats = list;
        this.liveEdgeTimeUs = C.TIME_UNSET;
        Format[] formatArr = new Format[hlsUrlArr.length];
        int[] iArr = new int[hlsUrlArr.length];
        for (int i3 = 0; i3 < hlsUrlArr.length; i3++) {
            formatArr[i3] = hlsUrlArr[i3].format;
            iArr[i3] = i3;
        }
        this.mediaDataSource = hlsDataSourceFactory.createDataSource(1);
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        TrackGroup trackGroup = new TrackGroup(formatArr);
        this.trackGroup = trackGroup;
        this.trackSelection = new InitializationTrackSelection(trackGroup, iArr);
    }

    private void clearEncryptionData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.encryptionKeyUri = null;
            this.encryptionKey = null;
            this.encryptionIvString = null;
            this.encryptionIv = null;
        }
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String str, int i, int i2, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{uri, str, Integer.valueOf(i), Integer.valueOf(i2), obj})) == null) ? new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec(uri, 0L, -1L, null, 1), this.variants[i].format, i2, obj, this.scratchSpace, str) : (EncryptionKeyChunk) invokeCommon.objValue;
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            return (this.liveEdgeTimeUs > C.TIME_UNSET ? 1 : (this.liveEdgeTimeUs == C.TIME_UNSET ? 0 : -1)) != 0 ? this.liveEdgeTimeUs - j : C.TIME_UNSET;
        }
        return invokeJ.longValue;
    }

    private void setEncryptionData(Uri uri, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri, str, bArr) == null) {
            byte[] byteArray = new BigInteger(Util.toLowerInvariant(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
            byte[] bArr2 = new byte[16];
            int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
            System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
            this.encryptionKeyUri = uri;
            this.encryptionKey = bArr;
            this.encryptionIvString = str;
            this.encryptionIv = bArr2;
        }
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, hlsMediaPlaylist) == null) {
            this.liveEdgeTimeUs = hlsMediaPlaylist.hasEndTag ? C.TIME_UNSET : hlsMediaPlaylist.getEndTimeUs();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getNextChunk(HlsMediaChunk hlsMediaChunk, long j, long j2, HlsChunkHolder hlsChunkHolder) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{hlsMediaChunk, Long.valueOf(j), Long.valueOf(j2), hlsChunkHolder}) != null) {
            return;
        }
        int indexOf = hlsMediaChunk == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        this.expectedPlaylistUrl = null;
        long j3 = j2 - j;
        long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
        if (hlsMediaChunk != null && !this.independentSegments) {
            long durationUs = hlsMediaChunk.getDurationUs();
            j3 = Math.max(0L, j3 - durationUs);
            if (resolveTimeToLiveEdgeUs != C.TIME_UNSET) {
                resolveTimeToLiveEdgeUs = Math.max(0L, resolveTimeToLiveEdgeUs - durationUs);
            }
        }
        this.trackSelection.updateSelectedTrack(j, j3, resolveTimeToLiveEdgeUs);
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z = false;
        boolean z2 = indexOf != selectedIndexInTrackGroup;
        HlsMasterPlaylist.HlsUrl hlsUrl = this.variants[selectedIndexInTrackGroup];
        if (!this.playlistTracker.isSnapshotValid(hlsUrl)) {
            hlsChunkHolder.playlist = hlsUrl;
            this.expectedPlaylistUrl = hlsUrl;
            return;
        }
        HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(hlsUrl);
        this.independentSegments = playlistSnapshot.hasIndependentSegmentsTag;
        updateLiveEdgeTimeUs(playlistSnapshot);
        if (hlsMediaChunk != null && !z2) {
            i = hlsMediaChunk.getNextChunkIndex();
        } else {
            long j4 = (hlsMediaChunk == null || this.independentSegments) ? j2 : hlsMediaChunk.startTimeUs;
            if (!playlistSnapshot.hasEndTag && j4 >= playlistSnapshot.getEndTimeUs()) {
                i = playlistSnapshot.mediaSequence + playlistSnapshot.segments.size();
            } else {
                int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) playlistSnapshot.segments, Long.valueOf(j4 - playlistSnapshot.startTimeUs), true, (!this.playlistTracker.isLive() || hlsMediaChunk == null) ? true : true);
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
                    DataSpec dataSpec = segment2 != null ? new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment2.url), segment2.byterangeOffset, segment2.byterangeLength, null) : null;
                    long j5 = hlsMediaPlaylist.startTimeUs + segment.relativeStartTimeUs;
                    int i5 = hlsMediaPlaylist.discontinuitySequence + segment.relativeDiscontinuitySequence;
                    hlsChunkHolder.chunk = new HlsMediaChunk(this.extractorFactory, this.mediaDataSource, new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null), dataSpec, hlsUrl2, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), j5, j5 + segment.durationUs, i, i5, this.isTimestampMaster, this.timestampAdjusterProvider.getAdjuster(i5), hlsMediaChunk, hlsMediaPlaylist.drmInitData, this.encryptionKey, this.encryptionIv);
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

    public TrackGroup getTrackGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.trackGroup : (TrackGroup) invokeV.objValue;
    }

    public TrackSelection getTrackSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.trackSelection : (TrackSelection) invokeV.objValue;
    }

    public void maybeThrowError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, chunk) == null) && (chunk instanceof EncryptionKeyChunk)) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            setEncryptionData(encryptionKeyChunk.dataSpec.uri, encryptionKeyChunk.iv, encryptionKeyChunk.getResult());
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{chunk, Boolean.valueOf(z), iOException})) == null) {
            if (z) {
                TrackSelection trackSelection = this.trackSelection;
                if (ChunkedTrackBlacklistUtil.maybeBlacklistTrack(trackSelection, trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), iOException)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j) {
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048582, this, hlsUrl, j) == null) || (indexOf = this.trackGroup.indexOf(hlsUrl.format)) == -1 || (indexOf2 = this.trackSelection.indexOf(indexOf)) == -1) {
            return;
        }
        this.trackSelection.blacklist(indexOf2, j);
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.fatalError = null;
        }
    }

    public void selectTracks(TrackSelection trackSelection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, trackSelection) == null) {
            this.trackSelection = trackSelection;
        }
    }

    public void setIsTimestampMaster(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.isTimestampMaster = z;
        }
    }
}
