package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public final class HlsMediaSource implements MediaSource, HlsPlaylistTracker.PrimaryPlaylistListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final HlsDataSourceFactory dataSourceFactory;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public final HlsExtractorFactory extractorFactory;
    public final Uri manifestUri;
    public final int minLoadableRetryCount;
    public final ParsingLoadable.Parser<HlsPlaylist> playlistParser;
    public HlsPlaylistTracker playlistTracker;
    public MediaSource.Listener sourceListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1535935499, "Lcom/google/android/exoplayer2/source/hls/HlsMediaSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1535935499, "Lcom/google/android/exoplayer2/source/hls/HlsMediaSource;");
                return;
            }
        }
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HlsMediaSource(Uri uri, DataSource.Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, 3, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], ((Integer) objArr2[2]).intValue(), (Handler) objArr2[3], (AdaptiveMediaSourceEventListener) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            Assertions.checkArgument(mediaPeriodId.periodIndex == 0);
            return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, allocator);
        }
        return (MediaPeriod) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        SinglePeriodTimeline singlePeriodTimeline;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hlsMediaPlaylist) == null) {
            long j2 = hlsMediaPlaylist.hasProgramDateTime ? 0L : -9223372036854775807L;
            long usToMs = hlsMediaPlaylist.hasProgramDateTime ? C.usToMs(hlsMediaPlaylist.startTimeUs) : -9223372036854775807L;
            long j3 = hlsMediaPlaylist.startOffsetUs;
            if (this.playlistTracker.isLive()) {
                long j4 = hlsMediaPlaylist.hasEndTag ? hlsMediaPlaylist.startTimeUs + hlsMediaPlaylist.durationUs : -9223372036854775807L;
                List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
                if (j3 == C.TIME_UNSET) {
                    j = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).relativeStartTimeUs;
                } else {
                    j = j3;
                }
                singlePeriodTimeline = new SinglePeriodTimeline(j2, usToMs, j4, hlsMediaPlaylist.durationUs, hlsMediaPlaylist.startTimeUs, j, true, !hlsMediaPlaylist.hasEndTag);
            } else {
                long j5 = j3 == C.TIME_UNSET ? 0L : j3;
                long j6 = hlsMediaPlaylist.startTimeUs;
                long j7 = hlsMediaPlaylist.durationUs;
                singlePeriodTimeline = new SinglePeriodTimeline(j2, usToMs, j6 + j7, j7, j6, j5, true, false);
            }
            this.sourceListener.onSourceInfoRefreshed(this, singlePeriodTimeline, new HlsManifest(this.playlistTracker.getMasterPlaylist(), hlsMediaPlaylist));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            Assertions.checkState(this.playlistTracker == null);
            HlsPlaylistTracker hlsPlaylistTracker = new HlsPlaylistTracker(this.manifestUri, this.dataSourceFactory, this.eventDispatcher, this.minLoadableRetryCount, this, this.playlistParser);
            this.playlistTracker = hlsPlaylistTracker;
            this.sourceListener = listener;
            hlsPlaylistTracker.start();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPeriod) == null) {
            ((HlsMediaPeriod) mediaPeriod).release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HlsPlaylistTracker hlsPlaylistTracker = this.playlistTracker;
            if (hlsPlaylistTracker != null) {
                hlsPlaylistTracker.release();
                this.playlistTracker = null;
            }
            this.sourceListener = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HlsMediaSource(Uri uri, DataSource.Factory factory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, new DefaultHlsDataSourceFactory(factory), HlsExtractorFactory.DEFAULT, i, handler, adaptiveMediaSourceEventListener, new HlsPlaylistParser());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, Integer.valueOf(i), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (HlsDataSourceFactory) objArr2[1], (HlsExtractorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (Handler) objArr2[4], (AdaptiveMediaSourceEventListener) objArr2[5], (ParsingLoadable.Parser) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public HlsMediaSource(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, ParsingLoadable.Parser<HlsPlaylist> parser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, hlsDataSourceFactory, hlsExtractorFactory, Integer.valueOf(i), handler, adaptiveMediaSourceEventListener, parser};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.manifestUri = uri;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.minLoadableRetryCount = i;
        this.playlistParser = parser;
        this.eventDispatcher = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
    }
}
