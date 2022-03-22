package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes6.dex */
public final class DashMediaSource implements MediaSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS = 30000;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_PREFER_MANIFEST_MS = -1;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    public static final int NOTIFY_MANIFEST_INTERVAL_MS = 5000;
    public static final String TAG = "DashMediaSource";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes6.dex */
    public static final class DashTimeline extends Timeline {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int firstPeriodId;
        public final DashManifest manifest;
        public final long offsetInFirstPeriodUs;
        public final long presentationStartTimeMs;
        public final long windowDefaultStartPositionUs;
        public final long windowDurationUs;
        public final long windowStartTimeMs;

        public DashTimeline(long j, long j2, int i, long j3, long j4, long j5, DashManifest dashManifest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), dashManifest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.firstPeriodId = i;
            this.offsetInFirstPeriodUs = j3;
            this.windowDurationUs = j4;
            this.windowDefaultStartPositionUs = j5;
            this.manifest = dashManifest;
        }

        private long getAdjustedWindowDefaultStartPositionUs(long j) {
            InterceptResult invokeJ;
            DashSegmentIndex index;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
                long j2 = this.windowDefaultStartPositionUs;
                if (this.manifest.dynamic) {
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
                    return (adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationUs) == 0) ? j2 : (j2 + index.getTimeUs(index.getSegmentNum(j3, periodDurationUs))) - j3;
                }
                return j2;
            }
            return invokeJ.longValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            InterceptResult invokeL;
            int intValue;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= (i = this.firstPeriodId) && intValue < i + getPeriodCount()) {
                    return intValue - this.firstPeriodId;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), period, Boolean.valueOf(z)})) == null) {
                Assertions.checkIndex(i, 0, this.manifest.getPeriodCount());
                return period.set(z ? this.manifest.getPeriod(i).id : null, z ? Integer.valueOf(this.firstPeriodId + Assertions.checkIndex(i, 0, this.manifest.getPeriodCount())) : null, 0, this.manifest.getPeriodDurationUs(i), C.msToUs(this.manifest.getPeriod(i).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
            }
            return (Timeline.Period) invokeCommon.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.manifest.getPeriodCount() : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                Assertions.checkIndex(i, 0, 1);
                long adjustedWindowDefaultStartPositionUs = getAdjustedWindowDefaultStartPositionUs(j);
                long j2 = this.presentationStartTimeMs;
                long j3 = this.windowStartTimeMs;
                DashManifest dashManifest = this.manifest;
                return window.set(null, j2, j3, true, dashManifest.dynamic, adjustedWindowDefaultStartPositionUs, this.windowDurationUs, 0, dashManifest.getPeriodCount() - 1, this.offsetInFirstPeriodUs);
            }
            return (Timeline.Window) invokeCommon.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Iso8601Parser() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uri, inputStream)) == null) {
                String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
                } catch (ParseException e2) {
                    throw new ParserException(e2);
                }
            }
            return (Long) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DashMediaSource this$0;

        public ManifestCallback(DashMediaSource dashMediaSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dashMediaSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dashMediaSource;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.this$0.onLoadCanceled(parsingLoadable, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.this$0.onManifestLoadCompleted(parsingLoadable, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) ? this.this$0.onManifestLoadError(parsingLoadable, j, j2, iOException) : invokeCommon.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class PeriodSeekInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long availableEndTimeUs;
        public final long availableStartTimeUs;
        public final boolean isIndexExplicit;

        public PeriodSeekInfo(boolean z, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isIndexExplicit = z;
            this.availableStartTimeUs = j;
            this.availableEndTimeUs = j2;
        }

        public static PeriodSeekInfo createPeriodSeekInfo(Period period, long j) {
            InterceptResult invokeLJ;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, period, j)) == null) {
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
                    } else if (z) {
                        i = i3;
                    } else {
                        int firstSegmentNum = index.getFirstSegmentNum();
                        i = i3;
                        j3 = Math.max(j3, index.getTimeUs(firstSegmentNum));
                        if (segmentCount != -1) {
                            int i4 = (firstSegmentNum + segmentCount) - 1;
                            j2 = Math.min(j2, index.getTimeUs(i4) + index.getDurationUs(i4, j));
                        }
                    }
                    i3 = i + 1;
                    i2 = 0;
                }
                return new PeriodSeekInfo(z2, j3, j2);
            }
            return (PeriodSeekInfo) invokeLJ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DashMediaSource this$0;

        public UtcTimestampCallback(DashMediaSource dashMediaSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dashMediaSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dashMediaSource;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.this$0.onLoadCanceled(parsingLoadable, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.this$0.onUtcTimestampLoadCompleted(parsingLoadable, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) ? this.this$0.onUtcTimestampLoadError(parsingLoadable, j, j2, iOException) : invokeCommon.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public XsDateTimeParser() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uri, inputStream)) == null) ? Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine())) : (Long) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1299948587, "Lcom/google/android/exoplayer2/source/dash/DashMediaSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1299948587, "Lcom/google/android/exoplayer2/source/dash/DashMediaSource;");
                return;
            }
        }
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(dashManifest, factory, 3, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dashManifest, factory, handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DashManifest) objArr2[0], (DashChunkSource.Factory) objArr2[1], ((Integer) objArr2[2]).intValue(), (Handler) objArr2[3], (AdaptiveMediaSourceEventListener) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    private long getNowUnixTimeUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.elapsedRealtimeOffsetMs != 0) {
                return C.msToUs(SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs);
            }
            return C.msToUs(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    private void onUtcTimestampResolutionError(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, iOException) == null) {
            Log.e(TAG, "Failed to resolve UtcTiming element.", iOException);
            processManifest(true);
        }
    }

    private void onUtcTimestampResolved(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, this, j) == null) {
            this.elapsedRealtimeOffsetMs = j;
            processManifest(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processManifest(boolean z) {
        long j;
        boolean z2;
        long periodDurationUs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
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
            if (!this.manifest.dynamic || createPeriodSeekInfo2.isIndexExplicit) {
                j = j2;
                z2 = false;
            } else {
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
            if (this.sideloadedManifest) {
                return;
            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, utcTimingElement) == null) {
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
    }

    private void resolveUtcTimingElementDirect(UtcTimingElement utcTimingElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, utcTimingElement) == null) {
            try {
                onUtcTimestampResolved(Util.parseXsDateTime(utcTimingElement.value) - this.manifestLoadEndTimestamp);
            } catch (ParserException e2) {
                onUtcTimestampResolutionError(e2);
            }
        }
    }

    private void resolveUtcTimingElementHttp(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, utcTimingElement, parser) == null) {
            startLoading(new ParsingLoadable(this.dataSource, Uri.parse(utcTimingElement.value), 5, parser), new UtcTimestampCallback(), 1);
        }
    }

    private void scheduleManifestRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            DashManifest dashManifest = this.manifest;
            if (dashManifest.dynamic) {
                long j = dashManifest.minUpdatePeriod;
                if (j == 0) {
                    j = 5000;
                }
                this.handler.postDelayed(this.refreshManifestRunnable, Math.max(0L, (this.manifestLoadStartTimestamp + j) - SystemClock.elapsedRealtime()));
            }
        }
    }

    private <T> void startLoading(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65553, this, parsingLoadable, callback, i) == null) {
            this.eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.loader.startLoading(parsingLoadable, callback, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            synchronized (this.manifestUriLock) {
                uri = this.manifestUri;
            }
            startLoading(new ParsingLoadable(this.dataSource, uri, 4, this.manifestParser), this.manifestCallback, this.minLoadableRetryCount);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            int i = mediaPeriodId.periodIndex;
            DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(this.firstPeriodId + i, this.manifest, i, this.chunkSourceFactory, this.minLoadableRetryCount, this.eventDispatcher.copyWithMediaTimeOffsetMs(this.manifest.getPeriod(i).startMs), this.elapsedRealtimeOffsetMs, this.loaderErrorThrower, allocator);
            this.periodsById.put(dashMediaPeriod.id, dashMediaPeriod);
            return dashMediaPeriod;
        }
        return (MediaPeriod) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.loaderErrorThrower.maybeThrowError();
        }
    }

    public void onLoadCanceled(ParsingLoadable<?> parsingLoadable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        }
    }

    public void onManifestLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
            DashManifest result = parsingLoadable.getResult();
            DashManifest dashManifest = this.manifest;
            int i = 0;
            int periodCount = dashManifest == null ? 0 : dashManifest.getPeriodCount();
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

    public int onManifestLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public void onUtcTimestampLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
            onUtcTimestampResolved(parsingLoadable.getResult().longValue() - j);
        }
    }

    public int onUtcTimestampLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, true);
            onUtcTimestampResolutionError(iOException);
            return 2;
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
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
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPeriod) == null) {
            DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
            dashMediaPeriod.release();
            this.periodsById.remove(dashMediaPeriod.id);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
    }

    public void replaceManifestUri(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, uri) == null) {
            synchronized (this.manifestUriLock) {
                this.manifestUri = uri;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(dashManifest, null, null, null, factory, i, -1L, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {dashManifest, factory, Integer.valueOf(i), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DashManifest) objArr2[0], (Uri) objArr2[1], (DataSource.Factory) objArr2[2], (ParsingLoadable.Parser) objArr2[3], (DashChunkSource.Factory) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (AdaptiveMediaSourceEventListener) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, factory2, 3, -1L, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, factory2, handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (DashChunkSource.Factory) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (Handler) objArr2[5], (AdaptiveMediaSourceEventListener) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, new DashManifestParser(), factory2, i, j, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, factory2, Integer.valueOf(i), Long.valueOf(j), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (ParsingLoadable.Parser) objArr2[2], (DashChunkSource.Factory) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue(), (Handler) objArr2[6], (AdaptiveMediaSourceEventListener) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashMediaSource(Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, i, j, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, factory, parser, factory2, Integer.valueOf(i), Long.valueOf(j), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DashManifest) objArr2[0], (Uri) objArr2[1], (DataSource.Factory) objArr2[2], (ParsingLoadable.Parser) objArr2[3], (DashChunkSource.Factory) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (AdaptiveMediaSourceEventListener) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public DashMediaSource(DashManifest dashManifest, Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dashManifest, uri, factory, parser, factory2, Integer.valueOf(i), Long.valueOf(j), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.manifest = dashManifest;
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.minLoadableRetryCount = i;
        this.livePresentationDelayMs = j;
        this.sideloadedManifest = dashManifest != null;
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
        this.refreshManifestRunnable = new Runnable(this) { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DashMediaSource this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.startLoadingManifest();
                }
            }
        };
        this.simulateManifestRefreshRunnable = new Runnable(this) { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DashMediaSource this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.processManifest(false);
                }
            }
        };
    }
}
