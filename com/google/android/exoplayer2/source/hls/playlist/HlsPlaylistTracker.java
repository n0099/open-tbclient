package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes7.dex */
public final class HlsPlaylistTracker implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HlsDataSourceFactory dataSourceFactory;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public final Loader initialPlaylistLoader;
    public final Uri initialPlaylistUri;
    public boolean isLive;
    public final List<PlaylistEventListener> listeners;
    public HlsMasterPlaylist masterPlaylist;
    public final int minRetryCount;
    public final IdentityHashMap<HlsMasterPlaylist.HlsUrl, MediaPlaylistBundle> playlistBundles;
    public final ParsingLoadable.Parser<HlsPlaylist> playlistParser;
    public final Handler playlistRefreshHandler;
    public HlsMasterPlaylist.HlsUrl primaryHlsUrl;
    public final PrimaryPlaylistListener primaryPlaylistListener;
    public HlsMediaPlaylist primaryUrlSnapshot;

    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long blacklistUntilMs;
        public long earliestNextLoadTimeMs;
        public long lastSnapshotChangeMs;
        public long lastSnapshotLoadMs;
        public boolean loadPending;
        public final ParsingLoadable<HlsPlaylist> mediaPlaylistLoadable;
        public final Loader mediaPlaylistLoader;
        public IOException playlistError;
        public HlsMediaPlaylist playlistSnapshot;
        public final HlsMasterPlaylist.HlsUrl playlistUrl;
        public final /* synthetic */ HlsPlaylistTracker this$0;

        public MediaPlaylistBundle(HlsPlaylistTracker hlsPlaylistTracker, HlsMasterPlaylist.HlsUrl hlsUrl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlsPlaylistTracker, hlsUrl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = hlsPlaylistTracker;
            this.playlistUrl = hlsUrl;
            this.mediaPlaylistLoader = new Loader("HlsPlaylistTracker:MediaPlaylist");
            this.mediaPlaylistLoadable = new ParsingLoadable<>(hlsPlaylistTracker.dataSourceFactory.createDataSource(4), UriUtil.resolveToUri(hlsPlaylistTracker.masterPlaylist.baseUri, hlsUrl.url), 4, hlsPlaylistTracker.playlistParser);
        }

        private boolean blacklistPlaylist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                this.blacklistUntilMs = SystemClock.elapsedRealtime() + 60000;
                this.this$0.notifyPlaylistBlacklisting(this.playlistUrl, 60000L);
                return this.this$0.primaryHlsUrl == this.playlistUrl && !this.this$0.maybeSelectNewPrimaryUrl();
            }
            return invokeV.booleanValue;
        }

        private void loadPlaylistImmediately() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                this.mediaPlaylistLoader.startLoading(this.mediaPlaylistLoadable, this, this.this$0.minRetryCount);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processLoadedPlaylist(HlsMediaPlaylist hlsMediaPlaylist) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, hlsMediaPlaylist) == null) {
                HlsMediaPlaylist hlsMediaPlaylist2 = this.playlistSnapshot;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.lastSnapshotLoadMs = elapsedRealtime;
                HlsMediaPlaylist latestPlaylistSnapshot = this.this$0.getLatestPlaylistSnapshot(hlsMediaPlaylist2, hlsMediaPlaylist);
                this.playlistSnapshot = latestPlaylistSnapshot;
                if (latestPlaylistSnapshot != hlsMediaPlaylist2) {
                    this.playlistError = null;
                    this.lastSnapshotChangeMs = elapsedRealtime;
                    this.this$0.onPlaylistUpdated(this.playlistUrl, latestPlaylistSnapshot);
                } else if (!latestPlaylistSnapshot.hasEndTag) {
                    int size = hlsMediaPlaylist.mediaSequence + hlsMediaPlaylist.segments.size();
                    HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
                    if (size < hlsMediaPlaylist3.mediaSequence) {
                        this.playlistError = new PlaylistResetException(this.playlistUrl.url, null);
                    } else if (elapsedRealtime - this.lastSnapshotChangeMs > C.usToMs(hlsMediaPlaylist3.targetDurationUs) * 3.5d) {
                        this.playlistError = new PlaylistStuckException(this.playlistUrl.url, null);
                        blacklistPlaylist();
                    }
                }
                HlsMediaPlaylist hlsMediaPlaylist4 = this.playlistSnapshot;
                long j2 = hlsMediaPlaylist4.targetDurationUs;
                if (hlsMediaPlaylist4 == hlsMediaPlaylist2) {
                    j2 /= 2;
                }
                this.earliestNextLoadTimeMs = elapsedRealtime + C.usToMs(j2);
                if (this.playlistUrl != this.this$0.primaryHlsUrl || this.playlistSnapshot.hasEndTag) {
                    return;
                }
                loadPlaylist();
            }
        }

        public HlsMediaPlaylist getPlaylistSnapshot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.playlistSnapshot : (HlsMediaPlaylist) invokeV.objValue;
        }

        public boolean isSnapshotValid() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.playlistSnapshot == null) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long max = Math.max(30000L, C.usToMs(this.playlistSnapshot.durationUs));
                HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
                return hlsMediaPlaylist.hasEndTag || (i2 = hlsMediaPlaylist.playlistType) == 2 || i2 == 1 || this.lastSnapshotLoadMs + max > elapsedRealtime;
            }
            return invokeV.booleanValue;
        }

        public void loadPlaylist() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.blacklistUntilMs = 0L;
                if (this.loadPending || this.mediaPlaylistLoader.isLoading()) {
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.earliestNextLoadTimeMs) {
                    this.loadPending = true;
                    this.this$0.playlistRefreshHandler.postDelayed(this, this.earliestNextLoadTimeMs - elapsedRealtime);
                    return;
                }
                loadPlaylistImmediately();
            }
        }

        public void maybeThrowPlaylistRefreshError() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mediaPlaylistLoader.maybeThrowError();
                IOException iOException = this.playlistError;
                if (iOException != null) {
                    throw iOException;
                }
            }
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.mediaPlaylistLoader.release();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.loadPending = false;
                loadPlaylistImmediately();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                this.this$0.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, 4, j2, j3, parsingLoadable.bytesLoaded());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                HlsPlaylist result = parsingLoadable.getResult();
                if (result instanceof HlsMediaPlaylist) {
                    processLoadedPlaylist((HlsMediaPlaylist) result);
                    this.this$0.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, 4, j2, j3, parsingLoadable.bytesLoaded());
                    return;
                }
                this.playlistError = new ParserException("Loaded playlist has unexpected type.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
                boolean z = iOException instanceof ParserException;
                this.this$0.eventDispatcher.loadError(parsingLoadable.dataSpec, 4, j2, j3, parsingLoadable.bytesLoaded(), iOException, z);
                if (z) {
                    return 3;
                }
                return ChunkedTrackBlacklistUtil.shouldBlacklist(iOException) ? blacklistPlaylist() : true ? 0 : 2;
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface PlaylistEventListener {
        void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j2);

        void onPlaylistChanged();
    }

    /* loaded from: classes7.dex */
    public static final class PlaylistResetException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String url;

        public /* synthetic */ PlaylistResetException(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        public PlaylistResetException(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
        }
    }

    /* loaded from: classes7.dex */
    public static final class PlaylistStuckException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String url;

        public /* synthetic */ PlaylistStuckException(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        public PlaylistStuckException(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
        }
    }

    /* loaded from: classes7.dex */
    public interface PrimaryPlaylistListener {
        void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist);
    }

    public HlsPlaylistTracker(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, int i2, PrimaryPlaylistListener primaryPlaylistListener, ParsingLoadable.Parser<HlsPlaylist> parser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, hlsDataSourceFactory, eventDispatcher, Integer.valueOf(i2), primaryPlaylistListener, parser};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.initialPlaylistUri = uri;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.eventDispatcher = eventDispatcher;
        this.minRetryCount = i2;
        this.primaryPlaylistListener = primaryPlaylistListener;
        this.playlistParser = parser;
        this.listeners = new ArrayList();
        this.initialPlaylistLoader = new Loader("HlsPlaylistTracker:MasterPlaylist");
        this.playlistBundles = new IdentityHashMap<>();
        this.playlistRefreshHandler = new Handler();
    }

    private void createBundles(List<HlsMasterPlaylist.HlsUrl> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                HlsMasterPlaylist.HlsUrl hlsUrl = list.get(i2);
                this.playlistBundles.put(hlsUrl, new MediaPlaylistBundle(this, hlsUrl));
            }
        }
    }

    public static HlsMediaPlaylist.Segment getFirstOldOverlappingSegment(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, hlsMediaPlaylist, hlsMediaPlaylist2)) == null) {
            int i2 = hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence;
            List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
            if (i2 < list.size()) {
                return list.get(i2);
            }
            return null;
        }
        return (HlsMediaPlaylist.Segment) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HlsMediaPlaylist getLatestPlaylistSnapshot(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, hlsMediaPlaylist, hlsMediaPlaylist2)) == null) {
            if (hlsMediaPlaylist2.isNewerThan(hlsMediaPlaylist)) {
                return hlsMediaPlaylist2.copyWith(getLoadedPlaylistStartTimeUs(hlsMediaPlaylist, hlsMediaPlaylist2), getLoadedPlaylistDiscontinuitySequence(hlsMediaPlaylist, hlsMediaPlaylist2));
            }
            return hlsMediaPlaylist2.hasEndTag ? hlsMediaPlaylist.copyWithEndTag() : hlsMediaPlaylist;
        }
        return (HlsMediaPlaylist) invokeLL.objValue;
    }

    private int getLoadedPlaylistDiscontinuitySequence(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        InterceptResult invokeLL;
        HlsMediaPlaylist.Segment firstOldOverlappingSegment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, hlsMediaPlaylist, hlsMediaPlaylist2)) == null) {
            if (hlsMediaPlaylist2.hasDiscontinuitySequence) {
                return hlsMediaPlaylist2.discontinuitySequence;
            }
            HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryUrlSnapshot;
            int i2 = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.discontinuitySequence : 0;
            return (hlsMediaPlaylist == null || (firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) ? i2 : (hlsMediaPlaylist.discontinuitySequence + firstOldOverlappingSegment.relativeDiscontinuitySequence) - hlsMediaPlaylist2.segments.get(0).relativeDiscontinuitySequence;
        }
        return invokeLL.intValue;
    }

    private long getLoadedPlaylistStartTimeUs(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, hlsMediaPlaylist, hlsMediaPlaylist2)) == null) {
            if (hlsMediaPlaylist2.hasProgramDateTime) {
                return hlsMediaPlaylist2.startTimeUs;
            }
            HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryUrlSnapshot;
            long j2 = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.startTimeUs : 0L;
            if (hlsMediaPlaylist == null) {
                return j2;
            }
            int size = hlsMediaPlaylist.segments.size();
            HlsMediaPlaylist.Segment firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
            if (firstOldOverlappingSegment != null) {
                return hlsMediaPlaylist.startTimeUs + firstOldOverlappingSegment.relativeStartTimeUs;
            }
            return size == hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence ? hlsMediaPlaylist.getEndTimeUs() : j2;
        }
        return invokeLL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeSelectNewPrimaryUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            List<HlsMasterPlaylist.HlsUrl> list = this.masterPlaylist.variants;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(list.get(i2));
                if (elapsedRealtime > mediaPlaylistBundle.blacklistUntilMs) {
                    this.primaryHlsUrl = mediaPlaylistBundle.playlistUrl;
                    mediaPlaylistBundle.loadPlaylist();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void maybeSetPrimaryUrl(HlsMasterPlaylist.HlsUrl hlsUrl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, hlsUrl) == null) && hlsUrl != this.primaryHlsUrl && this.masterPlaylist.variants.contains(hlsUrl)) {
            HlsMediaPlaylist hlsMediaPlaylist = this.primaryUrlSnapshot;
            if (hlsMediaPlaylist == null || !hlsMediaPlaylist.hasEndTag) {
                this.primaryHlsUrl = hlsUrl;
                this.playlistBundles.get(hlsUrl).loadPlaylist();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPlaylistBlacklisting(HlsMasterPlaylist.HlsUrl hlsUrl, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65555, this, hlsUrl, j2) == null) {
            int size = this.listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.listeners.get(i2).onPlaylistBlacklisted(hlsUrl, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlaylistUpdated(HlsMasterPlaylist.HlsUrl hlsUrl, HlsMediaPlaylist hlsMediaPlaylist) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, hlsUrl, hlsMediaPlaylist) == null) {
            if (hlsUrl == this.primaryHlsUrl) {
                if (this.primaryUrlSnapshot == null) {
                    this.isLive = !hlsMediaPlaylist.hasEndTag;
                }
                this.primaryUrlSnapshot = hlsMediaPlaylist;
                this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(hlsMediaPlaylist);
            }
            int size = this.listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.listeners.get(i2).onPlaylistChanged();
            }
        }
    }

    public void addListener(PlaylistEventListener playlistEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, playlistEventListener) == null) {
            this.listeners.add(playlistEventListener);
        }
    }

    public HlsMasterPlaylist getMasterPlaylist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.masterPlaylist : (HlsMasterPlaylist) invokeV.objValue;
    }

    public HlsMediaPlaylist getPlaylistSnapshot(HlsMasterPlaylist.HlsUrl hlsUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hlsUrl)) == null) {
            HlsMediaPlaylist playlistSnapshot = this.playlistBundles.get(hlsUrl).getPlaylistSnapshot();
            if (playlistSnapshot != null) {
                maybeSetPrimaryUrl(hlsUrl);
            }
            return playlistSnapshot;
        }
        return (HlsMediaPlaylist) invokeL.objValue;
    }

    public boolean isLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isLive : invokeV.booleanValue;
    }

    public boolean isSnapshotValid(HlsMasterPlaylist.HlsUrl hlsUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hlsUrl)) == null) ? this.playlistBundles.get(hlsUrl).isSnapshotValid() : invokeL.booleanValue;
    }

    public void maybeThrowPlaylistRefreshError(HlsMasterPlaylist.HlsUrl hlsUrl) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hlsUrl) == null) {
            this.playlistBundles.get(hlsUrl).maybeThrowPlaylistRefreshError();
        }
    }

    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.initialPlaylistLoader.maybeThrowError();
            HlsMasterPlaylist.HlsUrl hlsUrl = this.primaryHlsUrl;
            if (hlsUrl != null) {
                maybeThrowPlaylistRefreshError(hlsUrl);
            }
        }
    }

    public void refreshPlaylist(HlsMasterPlaylist.HlsUrl hlsUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hlsUrl) == null) {
            this.playlistBundles.get(hlsUrl).loadPlaylist();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.initialPlaylistLoader.release();
            for (MediaPlaylistBundle mediaPlaylistBundle : this.playlistBundles.values()) {
                mediaPlaylistBundle.release();
            }
            this.playlistRefreshHandler.removeCallbacksAndMessages(null);
            this.playlistBundles.clear();
        }
    }

    public void removeListener(PlaylistEventListener playlistEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, playlistEventListener) == null) {
            this.listeners.remove(playlistEventListener);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.initialPlaylistLoader.startLoading(new ParsingLoadable(this.dataSourceFactory.createDataSource(4), this.initialPlaylistUri, 4, this.playlistParser), this, this.minRetryCount);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, 4, j2, j3, parsingLoadable.bytesLoaded());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
        HlsMasterPlaylist hlsMasterPlaylist;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            HlsPlaylist result = parsingLoadable.getResult();
            boolean z = result instanceof HlsMediaPlaylist;
            if (z) {
                hlsMasterPlaylist = HlsMasterPlaylist.createSingleVariantMasterPlaylist(result.baseUri);
            } else {
                hlsMasterPlaylist = (HlsMasterPlaylist) result;
            }
            this.masterPlaylist = hlsMasterPlaylist;
            this.primaryHlsUrl = hlsMasterPlaylist.variants.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(hlsMasterPlaylist.variants);
            arrayList.addAll(hlsMasterPlaylist.audios);
            arrayList.addAll(hlsMasterPlaylist.subtitles);
            createBundles(arrayList);
            MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(this.primaryHlsUrl);
            if (z) {
                mediaPlaylistBundle.processLoadedPlaylist((HlsMediaPlaylist) result);
            } else {
                mediaPlaylistBundle.loadPlaylist();
            }
            this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, 4, j2, j3, parsingLoadable.bytesLoaded());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.eventDispatcher.loadError(parsingLoadable.dataSpec, 4, j2, j3, parsingLoadable.bytesLoaded(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }
}
