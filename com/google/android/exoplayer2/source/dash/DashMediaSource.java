package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes9.dex */
public final class DashMediaSource implements MediaSource {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS = 30000;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_PREFER_MANIFEST_MS = -1;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    public static final int NOTIFY_MANIFEST_INTERVAL_MS = 5000;
    public static final String TAG = "DashMediaSource";
    public final DashChunkSource.Factory chunkSourceFactory;
    public DataSource dataSource;
    public long elapsedRealtimeOffsetMs;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public int firstPeriodId;
    public Handler handler;
    public final long livePresentationDelayMs;
    public Loader loader;
    public LoaderErrorThrower loaderErrorThrower;
    public DashManifest manifest;
    public final ManifestCallback manifestCallback;
    public final DataSource.Factory manifestDataSourceFactory;
    public long manifestLoadEndTimestamp;
    public long manifestLoadStartTimestamp;
    public final ParsingLoadable.Parser<? extends DashManifest> manifestParser;
    public Uri manifestUri;
    public final Object manifestUriLock;
    public final int minLoadableRetryCount;
    public final SparseArray<DashMediaPeriod> periodsById;
    public final Runnable refreshManifestRunnable;
    public final boolean sideloadedManifest;
    public final Runnable simulateManifestRefreshRunnable;
    public MediaSource.Listener sourceListener;

    /* loaded from: classes9.dex */
    public static final class DashTimeline extends Timeline {
        public final int firstPeriodId;
        public final DashManifest manifest;
        public final long offsetInFirstPeriodUs;
        public final long presentationStartTimeMs;
        public final long windowDefaultStartPositionUs;
        public final long windowDurationUs;
        public final long windowStartTimeMs;

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        public DashTimeline(long j, long j2, int i, long j3, long j4, long j5, DashManifest dashManifest) {
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.firstPeriodId = i;
            this.offsetInFirstPeriodUs = j3;
            this.windowDurationUs = j4;
            this.windowDefaultStartPositionUs = j5;
            this.manifest = dashManifest;
        }

        private long getAdjustedWindowDefaultStartPositionUs(long j) {
            long j2 = this.windowDefaultStartPositionUs;
            if (!this.manifest.dynamic) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.windowDurationUs) {
                    return C.TIME_UNSET;
                }
            }
            long j3 = this.offsetInFirstPeriodUs + j2;
            long periodDurationUs = this.manifest.getPeriodDurationUs(0);
            int i = 0;
            while (i < this.manifest.getPeriodCount() - 1 && j3 >= periodDurationUs) {
                j3 -= periodDurationUs;
                i++;
                periodDurationUs = this.manifest.getPeriodDurationUs(i);
            }
            Period period = this.manifest.getPeriod(i);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            if (adaptationSetIndex == -1) {
                return j2;
            }
            DashSegmentIndex index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex();
            if (index != null && index.getSegmentCount(periodDurationUs) != 0) {
                return (j2 + index.getTimeUs(index.getSegmentNum(j3, periodDurationUs))) - j3;
            }
            return j2;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            int intValue;
            int i;
            if (!(obj instanceof Integer) || (intValue = ((Integer) obj).intValue()) < (i = this.firstPeriodId) || intValue >= i + getPeriodCount()) {
                return -1;
            }
            return intValue - this.firstPeriodId;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            String str;
            Assertions.checkIndex(i, 0, this.manifest.getPeriodCount());
            Integer num = null;
            if (z) {
                str = this.manifest.getPeriod(i).id;
            } else {
                str = null;
            }
            if (z) {
                num = Integer.valueOf(this.firstPeriodId + Assertions.checkIndex(i, 0, this.manifest.getPeriodCount()));
            }
            return period.set(str, num, 0, this.manifest.getPeriodDurationUs(i), C.msToUs(this.manifest.getPeriod(i).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.manifest.getPeriodCount();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            Assertions.checkIndex(i, 0, 1);
            long adjustedWindowDefaultStartPositionUs = getAdjustedWindowDefaultStartPositionUs(j);
            long j2 = this.presentationStartTimeMs;
            long j3 = this.windowStartTimeMs;
            DashManifest dashManifest = this.manifest;
            return window.set(null, j2, j3, true, dashManifest.dynamic, adjustedWindowDefaultStartPositionUs, this.windowDurationUs, 0, dashManifest.getPeriodCount() - 1, this.offsetInFirstPeriodUs);
        }
    }

    /* loaded from: classes9.dex */
    public static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {
        public Iso8601Parser() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        public ManifestCallback() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j, j2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
            return DashMediaSource.this.onManifestLoadError(parsingLoadable, j, j2, iOException);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
            DashMediaSource.this.onManifestLoadCompleted(parsingLoadable, j, j2);
        }
    }

    /* loaded from: classes9.dex */
    public static final class PeriodSeekInfo {
        public final long availableEndTimeUs;
        public final long availableStartTimeUs;
        public final boolean isIndexExplicit;

        public PeriodSeekInfo(boolean z, long j, long j2) {
            this.isIndexExplicit = z;
            this.availableStartTimeUs = j;
            this.availableEndTimeUs = j2;
        }

        public static PeriodSeekInfo createPeriodSeekInfo(Period period, long j) {
            int i;
            int size = period.adaptationSets.size();
            int i2 = 0;
            long j2 = Long.MAX_VALUE;
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            long j3 = 0;
            while (i3 < size) {
                DashSegmentIndex index = period.adaptationSets.get(i3).representations.get(i2).getIndex();
                if (index == null) {
                    return new PeriodSeekInfo(true, 0L, j);
                }
                z2 |= index.isExplicit();
                int segmentCount = index.getSegmentCount(j);
                if (segmentCount == 0) {
                    i = i3;
                    z = true;
                    j3 = 0;
                    j2 = 0;
                } else if (!z) {
                    int firstSegmentNum = index.getFirstSegmentNum();
                    i = i3;
                    j3 = Math.max(j3, index.getTimeUs(firstSegmentNum));
                    if (segmentCount != -1) {
                        int i4 = (firstSegmentNum + segmentCount) - 1;
                        j2 = Math.min(j2, index.getTimeUs(i4) + index.getDurationUs(i4, j));
                    }
                } else {
                    i = i3;
                }
                i3 = i + 1;
                i2 = 0;
            }
            return new PeriodSeekInfo(z2, j3, j2);
        }
    }

    /* loaded from: classes9.dex */
    public final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        public UtcTimestampCallback() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j, j2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
            return DashMediaSource.this.onUtcTimestampLoadError(parsingLoadable, j, j2, iOException);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
            DashMediaSource.this.onUtcTimestampLoadCompleted(parsingLoadable, j, j2);
        }
    }

    /* loaded from: classes9.dex */
    public static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        public XsDateTimeParser() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    private long getNowUnixTimeUs() {
        if (this.elapsedRealtimeOffsetMs != 0) {
            return C.msToUs(SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs);
        }
        return C.msToUs(System.currentTimeMillis());
    }

    private void scheduleManifestRefresh() {
        DashManifest dashManifest = this.manifest;
        if (!dashManifest.dynamic) {
            return;
        }
        long j = dashManifest.minUpdatePeriod;
        if (j == 0) {
            j = 5000;
        }
        this.handler.postDelayed(this.refreshManifestRunnable, Math.max(0L, (this.manifestLoadStartTimestamp + j) - SystemClock.elapsedRealtime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        Uri uri;
        synchronized (this.manifestUriLock) {
            uri = this.manifestUri;
        }
        startLoading(new ParsingLoadable(this.dataSource, uri, 4, this.manifestParser), this.manifestCallback, this.minLoadableRetryCount);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.loaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.dataSource = null;
        this.loaderErrorThrower = null;
        Loader loader = this.loader;
        if (loader != null) {
            loader.release();
            this.loader = null;
        }
        this.manifestLoadStartTimestamp = 0L;
        this.manifestLoadEndTimestamp = 0L;
        this.manifest = null;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.elapsedRealtimeOffsetMs = 0L;
        this.periodsById.clear();
    }

    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, new DashManifestParser(), factory2, i, j, handler, adaptiveMediaSourceEventListener);
    }

    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, factory2, 3, -1L, handler, adaptiveMediaSourceEventListener);
    }

    public DashMediaSource(Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, i, j, handler, adaptiveMediaSourceEventListener);
    }

    public DashMediaSource(DashManifest dashManifest, Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        boolean z;
        this.manifest = dashManifest;
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.minLoadableRetryCount = i;
        this.livePresentationDelayMs = j;
        if (dashManifest != null) {
            z = true;
        } else {
            z = false;
        }
        this.sideloadedManifest = z;
        this.eventDispatcher = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
        this.manifestUriLock = new Object();
        this.periodsById = new SparseArray<>();
        if (this.sideloadedManifest) {
            Assertions.checkState(!dashManifest.dynamic);
            this.manifestCallback = null;
            this.refreshManifestRunnable = null;
            this.simulateManifestRefreshRunnable = null;
            return;
        }
        this.manifestCallback = new ManifestCallback();
        this.refreshManifestRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource.1
            @Override // java.lang.Runnable
            public void run() {
                DashMediaSource.this.startLoadingManifest();
            }
        };
        this.simulateManifestRefreshRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource.2
            @Override // java.lang.Runnable
            public void run() {
                DashMediaSource.this.processManifest(false);
            }
        };
    }

    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(dashManifest, null, null, null, factory, i, -1L, handler, adaptiveMediaSourceEventListener);
    }

    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(dashManifest, factory, 3, handler, adaptiveMediaSourceEventListener);
    }

    public int onManifestLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, z);
        if (z) {
            return 3;
        }
        return 0;
    }

    public int onUtcTimestampLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, true);
        onUtcTimestampResolutionError(iOException);
        return 2;
    }

    private void onUtcTimestampResolutionError(IOException iOException) {
        Log.e(TAG, "Failed to resolve UtcTiming element.", iOException);
        processManifest(true);
    }

    private void onUtcTimestampResolved(long j) {
        this.elapsedRealtimeOffsetMs = j;
        processManifest(true);
    }

    private void resolveUtcTimingElementDirect(UtcTimingElement utcTimingElement) {
        try {
            onUtcTimestampResolved(Util.parseXsDateTime(utcTimingElement.value) - this.manifestLoadEndTimestamp);
        } catch (ParserException e) {
            onUtcTimestampResolutionError(e);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.release();
        this.periodsById.remove(dashMediaPeriod.id);
    }

    public void replaceManifestUri(Uri uri) {
        synchronized (this.manifestUriLock) {
            this.manifestUri = uri;
        }
    }

    private void resolveUtcTimingElementHttp(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        startLoading(new ParsingLoadable(this.dataSource, Uri.parse(utcTimingElement.value), 5, parser), new UtcTimestampCallback(), 1);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        int i = mediaPeriodId.periodIndex;
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(this.firstPeriodId + i, this.manifest, i, this.chunkSourceFactory, this.minLoadableRetryCount, this.eventDispatcher.copyWithMediaTimeOffsetMs(this.manifest.getPeriod(i).startMs), this.elapsedRealtimeOffsetMs, this.loaderErrorThrower, allocator);
        this.periodsById.put(dashMediaPeriod.id, dashMediaPeriod);
        return dashMediaPeriod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processManifest(boolean z) {
        long j;
        boolean z2;
        long periodDurationUs;
        for (int i = 0; i < this.periodsById.size(); i++) {
            int keyAt = this.periodsById.keyAt(i);
            if (keyAt >= this.firstPeriodId) {
                this.periodsById.valueAt(i).updateManifest(this.manifest, keyAt - this.firstPeriodId);
            }
        }
        int periodCount = this.manifest.getPeriodCount() - 1;
        PeriodSeekInfo createPeriodSeekInfo = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(0), this.manifest.getPeriodDurationUs(0));
        PeriodSeekInfo createPeriodSeekInfo2 = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(periodCount), this.manifest.getPeriodDurationUs(periodCount));
        long j2 = createPeriodSeekInfo.availableStartTimeUs;
        long j3 = createPeriodSeekInfo2.availableEndTimeUs;
        long j4 = 0;
        if (this.manifest.dynamic && !createPeriodSeekInfo2.isIndexExplicit) {
            j3 = Math.min((getNowUnixTimeUs() - C.msToUs(this.manifest.availabilityStartTime)) - C.msToUs(this.manifest.getPeriod(periodCount).startMs), j3);
            long j5 = this.manifest.timeShiftBufferDepth;
            if (j5 != C.TIME_UNSET) {
                long msToUs = j3 - C.msToUs(j5);
                while (msToUs < 0 && periodCount > 0) {
                    periodCount--;
                    msToUs += this.manifest.getPeriodDurationUs(periodCount);
                }
                if (periodCount == 0) {
                    periodDurationUs = Math.max(j2, msToUs);
                } else {
                    periodDurationUs = this.manifest.getPeriodDurationUs(0);
                }
                j2 = periodDurationUs;
            }
            j = j2;
            z2 = true;
        } else {
            j = j2;
            z2 = false;
        }
        long j6 = j3 - j;
        for (int i2 = 0; i2 < this.manifest.getPeriodCount() - 1; i2++) {
            j6 += this.manifest.getPeriodDurationUs(i2);
        }
        DashManifest dashManifest = this.manifest;
        if (dashManifest.dynamic) {
            long j7 = this.livePresentationDelayMs;
            if (j7 == -1) {
                long j8 = dashManifest.suggestedPresentationDelay;
                if (j8 == C.TIME_UNSET) {
                    j8 = 30000;
                }
                j7 = j8;
            }
            j4 = j6 - C.msToUs(j7);
            if (j4 < 5000000) {
                j4 = Math.min(5000000L, j6 / 2);
            }
        }
        DashManifest dashManifest2 = this.manifest;
        long usToMs = dashManifest2.availabilityStartTime + dashManifest2.getPeriod(0).startMs + C.usToMs(j);
        DashManifest dashManifest3 = this.manifest;
        this.sourceListener.onSourceInfoRefreshed(this, new DashTimeline(dashManifest3.availabilityStartTime, usToMs, this.firstPeriodId, j, j6, j4, dashManifest3), this.manifest);
        if (!this.sideloadedManifest) {
            this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
            if (z2) {
                this.handler.postDelayed(this.simulateManifestRefreshRunnable, 5000L);
            }
            if (z) {
                scheduleManifestRefresh();
            }
        }
    }

    private void resolveUtcTimingElement(UtcTimingElement utcTimingElement) {
        String str = utcTimingElement.schemeIdUri;
        if (!Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") && !Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            if (!Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") && !Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                if (!Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                    onUtcTimestampResolutionError(new IOException("Unsupported UTC timing scheme"));
                    return;
                } else {
                    resolveUtcTimingElementHttp(utcTimingElement, new XsDateTimeParser());
                    return;
                }
            }
            resolveUtcTimingElementHttp(utcTimingElement, new Iso8601Parser());
            return;
        }
        resolveUtcTimingElementDirect(utcTimingElement);
    }

    private <T> void startLoading(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i) {
        this.eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.loader.startLoading(parsingLoadable, callback, i));
    }

    public void onLoadCanceled(ParsingLoadable<?> parsingLoadable, long j, long j2) {
        this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
    }

    public void onUtcTimestampLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        onUtcTimestampResolved(parsingLoadable.getResult().longValue() - j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        this.sourceListener = listener;
        if (this.sideloadedManifest) {
            this.loaderErrorThrower = new LoaderErrorThrower.Dummy();
            processManifest(false);
            return;
        }
        this.dataSource = this.manifestDataSourceFactory.createDataSource();
        Loader loader = new Loader("Loader:DashMediaSource");
        this.loader = loader;
        this.loaderErrorThrower = loader;
        this.handler = new Handler();
        startLoadingManifest();
    }

    public void onManifestLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
        int periodCount;
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        DashManifest result = parsingLoadable.getResult();
        DashManifest dashManifest = this.manifest;
        int i = 0;
        if (dashManifest == null) {
            periodCount = 0;
        } else {
            periodCount = dashManifest.getPeriodCount();
        }
        long j3 = result.getPeriod(0).startMs;
        while (i < periodCount && this.manifest.getPeriod(i).startMs < j3) {
            i++;
        }
        if (periodCount - i > result.getPeriodCount()) {
            Log.w(TAG, "Out of sync manifest");
            scheduleManifestRefresh();
            return;
        }
        this.manifest = result;
        this.manifestLoadStartTimestamp = j - j2;
        this.manifestLoadEndTimestamp = j;
        if (result.location != null) {
            synchronized (this.manifestUriLock) {
                if (parsingLoadable.dataSpec.uri == this.manifestUri) {
                    this.manifestUri = this.manifest.location;
                }
            }
        }
        if (periodCount == 0) {
            UtcTimingElement utcTimingElement = this.manifest.utcTiming;
            if (utcTimingElement != null) {
                resolveUtcTimingElement(utcTimingElement);
                return;
            } else {
                processManifest(true);
                return;
            }
        }
        this.firstPeriodId += i;
        processManifest(true);
    }
}
