package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
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
/* loaded from: classes7.dex */
public final class HlsMediaSource implements MediaSource, HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public final HlsDataSourceFactory dataSourceFactory;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public final HlsExtractorFactory extractorFactory;
    public final Uri manifestUri;
    public final int minLoadableRetryCount;
    public final ParsingLoadable.Parser<HlsPlaylist> playlistParser;
    public HlsPlaylistTracker playlistTracker;
    public MediaSource.Listener sourceListener;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        HlsPlaylistTracker hlsPlaylistTracker = this.playlistTracker;
        if (hlsPlaylistTracker != null) {
            hlsPlaylistTracker.release();
            this.playlistTracker = null;
        }
        this.sourceListener = null;
    }

    public HlsMediaSource(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, ParsingLoadable.Parser<HlsPlaylist> parser) {
        this.manifestUri = uri;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.minLoadableRetryCount = i;
        this.playlistParser = parser;
        this.eventDispatcher = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
    }

    public HlsMediaSource(Uri uri, DataSource.Factory factory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, new DefaultHlsDataSourceFactory(factory), HlsExtractorFactory.DEFAULT, i, handler, adaptiveMediaSourceEventListener, new HlsPlaylistParser());
    }

    public HlsMediaSource(Uri uri, DataSource.Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, 3, handler, adaptiveMediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        boolean z;
        if (mediaPeriodId.periodIndex == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, allocator);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        long j;
        long j2;
        long j3;
        SinglePeriodTimeline singlePeriodTimeline;
        long j4;
        long j5;
        long j6;
        if (hlsMediaPlaylist.hasProgramDateTime) {
            j = 0;
        } else {
            j = -9223372036854775807L;
        }
        if (hlsMediaPlaylist.hasProgramDateTime) {
            j2 = C.usToMs(hlsMediaPlaylist.startTimeUs);
        } else {
            j2 = -9223372036854775807L;
        }
        long j7 = hlsMediaPlaylist.startOffsetUs;
        if (this.playlistTracker.isLive()) {
            if (hlsMediaPlaylist.hasEndTag) {
                j4 = hlsMediaPlaylist.startTimeUs + hlsMediaPlaylist.durationUs;
            } else {
                j4 = -9223372036854775807L;
            }
            List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
            if (j7 == C.TIME_UNSET) {
                if (list.isEmpty()) {
                    j6 = 0;
                } else {
                    j6 = list.get(Math.max(0, list.size() - 3)).relativeStartTimeUs;
                }
                j5 = j6;
            } else {
                j5 = j7;
            }
            singlePeriodTimeline = new SinglePeriodTimeline(j, j2, j4, hlsMediaPlaylist.durationUs, hlsMediaPlaylist.startTimeUs, j5, true, !hlsMediaPlaylist.hasEndTag);
        } else {
            if (j7 == C.TIME_UNSET) {
                j3 = 0;
            } else {
                j3 = j7;
            }
            long j8 = hlsMediaPlaylist.startTimeUs;
            long j9 = hlsMediaPlaylist.durationUs;
            singlePeriodTimeline = new SinglePeriodTimeline(j, j2, j8 + j9, j9, j8, j3, true, false);
        }
        this.sourceListener.onSourceInfoRefreshed(this, singlePeriodTimeline, new HlsManifest(this.playlistTracker.getMasterPlaylist(), hlsMediaPlaylist));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        boolean z2;
        if (this.playlistTracker == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkState(z2);
        HlsPlaylistTracker hlsPlaylistTracker = new HlsPlaylistTracker(this.manifestUri, this.dataSourceFactory, this.eventDispatcher, this.minLoadableRetryCount, this, this.playlistParser);
        this.playlistTracker = hlsPlaylistTracker;
        this.sourceListener = listener;
        hlsPlaylistTracker.start();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }
}
