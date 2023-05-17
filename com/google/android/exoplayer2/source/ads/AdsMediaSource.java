package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class AdsMediaSource implements MediaSource {
    public static final String TAG = "AdsMediaSource";
    public long[][] adDurationsUs;
    public MediaSource[][] adGroupMediaSources;
    public final Map<MediaPeriod, MediaSource> adMediaSourceByMediaPeriod;
    public AdPlaybackState adPlaybackState;
    public final ViewGroup adUiViewGroup;
    public final AdsLoader adsLoader;
    public final ComponentListener componentListener;
    public Object contentManifest;
    public final MediaSource contentMediaSource;
    public Timeline contentTimeline;
    public final DataSource.Factory dataSourceFactory;
    @Nullable
    public final Handler eventHandler;
    @Nullable
    public final AdsListener eventListener;
    public MediaSource.Listener listener;
    public final Handler mainHandler;
    public final Timeline.Period period;
    public ExoPlayer player;
    public Handler playerHandler;
    public volatile boolean released;

    /* loaded from: classes9.dex */
    public interface AdsListener {
        void onAdClicked();

        void onAdLoadError(IOException iOException);

        void onAdTapped();
    }

    /* loaded from: classes9.dex */
    public final class ComponentListener implements AdsLoader.EventListener, ExtractorMediaSource.EventListener {
        public ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(final AdPlaybackState adPlaybackState) {
            if (AdsMediaSource.this.released) {
                return;
            }
            AdsMediaSource.this.playerHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AdsMediaSource.this.released) {
                        return;
                    }
                    AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener, com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener
        public void onLoadError(final IOException iOException) {
            if (AdsMediaSource.this.released) {
                return;
            }
            AdsMediaSource.this.playerHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AdsMediaSource.this.released) {
                        return;
                    }
                    AdsMediaSource.this.onLoadError(iOException);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdClicked() {
            if (AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!AdsMediaSource.this.released) {
                            AdsMediaSource.this.eventListener.onAdClicked();
                        }
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdTapped() {
            if (AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!AdsMediaSource.this.released) {
                            AdsMediaSource.this.eventListener.onAdTapped();
                        }
                    }
                });
            }
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader, ViewGroup viewGroup) {
        this(mediaSource, factory, adsLoader, viewGroup, null, null);
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader, ViewGroup viewGroup, @Nullable Handler handler, @Nullable AdsListener adsListener) {
        this.contentMediaSource = mediaSource;
        this.dataSourceFactory = factory;
        this.adsLoader = adsLoader;
        this.adUiViewGroup = viewGroup;
        this.eventHandler = handler;
        this.eventListener = adsListener;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.componentListener = new ComponentListener();
        this.adMediaSourceByMediaPeriod = new HashMap();
        this.period = new Timeline.Period();
        this.adGroupMediaSources = new MediaSource[0];
        this.adDurationsUs = new long[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdSourceInfoRefreshed(int i, int i2, Timeline timeline) {
        boolean z = true;
        if (timeline.getPeriodCount() != 1) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.adDurationsUs[i][i2] = timeline.getPeriod(0, this.period).getDurationUs();
        maybeUpdateSourceInfo();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(final ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Assertions.checkArgument(z);
        this.listener = listener;
        this.player = exoPlayer;
        this.playerHandler = new Handler();
        this.contentMediaSource.prepareSource(exoPlayer, false, new MediaSource.Listener() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.1
            @Override // com.google.android.exoplayer2.source.MediaSource.Listener
            public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
                AdsMediaSource.this.onContentSourceInfoRefreshed(timeline, obj);
            }
        });
        this.mainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.2
            @Override // java.lang.Runnable
            public void run() {
                AdsMediaSource.this.adsLoader.attachPlayer(exoPlayer, AdsMediaSource.this.componentListener, AdsMediaSource.this.adUiViewGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        if (this.adPlaybackState == null) {
            MediaSource[][] mediaSourceArr = new MediaSource[adPlaybackState.adGroupCount];
            this.adGroupMediaSources = mediaSourceArr;
            Arrays.fill(mediaSourceArr, new MediaSource[0]);
            long[][] jArr = new long[adPlaybackState.adGroupCount];
            this.adDurationsUs = jArr;
            Arrays.fill(jArr, new long[0]);
        }
        this.adPlaybackState = adPlaybackState;
        maybeUpdateSourceInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadError(final IOException iOException) {
        Log.w(TAG, "Ad load error", iOException);
        Handler handler = this.eventHandler;
        if (handler != null && this.eventListener != null) {
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!AdsMediaSource.this.released) {
                        AdsMediaSource.this.eventListener.onAdLoadError(iOException);
                    }
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        if (this.adMediaSourceByMediaPeriod.containsKey(mediaPeriod)) {
            this.adMediaSourceByMediaPeriod.remove(mediaPeriod).releasePeriod(mediaPeriod);
        } else {
            this.contentMediaSource.releasePeriod(mediaPeriod);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onContentSourceInfoRefreshed(Timeline timeline, Object obj) {
        this.contentTimeline = timeline;
        this.contentManifest = obj;
        maybeUpdateSourceInfo();
    }

    private void maybeUpdateSourceInfo() {
        Timeline timeline;
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState != null && (timeline = this.contentTimeline) != null) {
            if (adPlaybackState.adGroupCount != 0) {
                Timeline timeline2 = this.contentTimeline;
                AdPlaybackState adPlaybackState2 = this.adPlaybackState;
                timeline = new SinglePeriodAdTimeline(timeline2, adPlaybackState2.adGroupTimesUs, adPlaybackState2.adCounts, adPlaybackState2.adsLoadedCounts, adPlaybackState2.adsPlayedCounts, this.adDurationsUs, adPlaybackState2.adResumePositionUs, adPlaybackState2.contentDurationUs);
            }
            this.listener.onSourceInfoRefreshed(this, timeline, this.contentManifest);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        MediaSource[][] mediaSourceArr;
        this.contentMediaSource.maybeThrowSourceInfoRefreshError();
        for (MediaSource[] mediaSourceArr2 : this.adGroupMediaSources) {
            for (MediaSource mediaSource : mediaSourceArr2) {
                if (mediaSource != null) {
                    mediaSource.maybeThrowSourceInfoRefreshError();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        MediaSource[][] mediaSourceArr;
        this.released = true;
        this.contentMediaSource.releaseSource();
        for (MediaSource[] mediaSourceArr2 : this.adGroupMediaSources) {
            for (MediaSource mediaSource : mediaSourceArr2) {
                if (mediaSource != null) {
                    mediaSource.releaseSource();
                }
            }
        }
        this.mainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.4
            @Override // java.lang.Runnable
            public void run() {
                AdsMediaSource.this.adsLoader.detachPlayer();
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        if (this.adPlaybackState.adGroupCount > 0 && mediaPeriodId.isAd()) {
            final int i = mediaPeriodId.adGroupIndex;
            final int i2 = mediaPeriodId.adIndexInAdGroup;
            if (this.adGroupMediaSources[i].length <= i2) {
                ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(this.adPlaybackState.adUris[i][i2], this.dataSourceFactory, new DefaultExtractorsFactory(), this.mainHandler, this.componentListener);
                MediaSource[][] mediaSourceArr = this.adGroupMediaSources;
                int length = mediaSourceArr[mediaPeriodId.adGroupIndex].length;
                if (i2 >= length) {
                    int i3 = i2 + 1;
                    mediaSourceArr[i] = (MediaSource[]) Arrays.copyOf(mediaSourceArr[i], i3);
                    long[][] jArr = this.adDurationsUs;
                    jArr[i] = Arrays.copyOf(jArr[i], i3);
                    Arrays.fill(this.adDurationsUs[i], length, i3, (long) C.TIME_UNSET);
                }
                this.adGroupMediaSources[i][i2] = extractorMediaSource;
                extractorMediaSource.prepareSource(this.player, false, new MediaSource.Listener() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.3
                    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
                        AdsMediaSource.this.onAdSourceInfoRefreshed(i, i2, timeline);
                    }
                });
            }
            MediaSource mediaSource = this.adGroupMediaSources[i][i2];
            MediaPeriod createPeriod = mediaSource.createPeriod(new MediaSource.MediaPeriodId(0), allocator);
            this.adMediaSourceByMediaPeriod.put(createPeriod, mediaSource);
            return createPeriod;
        }
        return this.contentMediaSource.createPeriod(mediaPeriodId, allocator);
    }
}
