package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
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
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

        public DashTimeline(long j2, long j3, int i2, long j4, long j5, long j6, DashManifest dashManifest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), dashManifest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.presentationStartTimeMs = j2;
            this.windowStartTimeMs = j3;
            this.firstPeriodId = i2;
            this.offsetInFirstPeriodUs = j4;
            this.windowDurationUs = j5;
            this.windowDefaultStartPositionUs = j6;
            this.manifest = dashManifest;
        }

        private long getAdjustedWindowDefaultStartPositionUs(long j2) {
            InterceptResult invokeJ;
            DashSegmentIndex index;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j2)) == null) {
                long j3 = this.windowDefaultStartPositionUs;
                if (this.manifest.dynamic) {
                    if (j2 > 0) {
                        j3 += j2;
                        if (j3 > this.windowDurationUs) {
                            return C.TIME_UNSET;
                        }
                    }
                    long j4 = this.offsetInFirstPeriodUs + j3;
                    long periodDurationUs = this.manifest.getPeriodDurationUs(0);
                    int i2 = 0;
                    while (i2 < this.manifest.getPeriodCount() - 1 && j4 >= periodDurationUs) {
                        j4 -= periodDurationUs;
                        i2++;
                        periodDurationUs = this.manifest.getPeriodDurationUs(i2);
                    }
                    Period period = this.manifest.getPeriod(i2);
                    int adaptationSetIndex = period.getAdaptationSetIndex(2);
                    return (adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationUs) == 0) ? j3 : (j3 + index.getTimeUs(index.getSegmentNum(j4, periodDurationUs))) - j4;
                }
                return j3;
            }
            return invokeJ.longValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            InterceptResult invokeL;
            int intValue;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= (i2 = this.firstPeriodId) && intValue < i2 + getPeriodCount()) {
                    return intValue - this.firstPeriodId;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i2, Timeline.Period period, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), period, Boolean.valueOf(z)})) == null) {
                Assertions.checkIndex(i2, 0, this.manifest.getPeriodCount());
                return period.set(z ? this.manifest.getPeriod(i2).id : null, z ? Integer.valueOf(this.firstPeriodId + Assertions.checkIndex(i2, 0, this.manifest.getPeriodCount())) : null, 0, this.manifest.getPeriodDurationUs(i2), C.msToUs(this.manifest.getPeriod(i2).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
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
        public Timeline.Window getWindow(int i2, Timeline.Window window, boolean z, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), window, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
                Assertions.checkIndex(i2, 0, 1);
                long adjustedWindowDefaultStartPositionUs = getAdjustedWindowDefaultStartPositionUs(j2);
                long j3 = this.presentationStartTimeMs;
                long j4 = this.windowStartTimeMs;
                DashManifest dashManifest = this.manifest;
                return window.set(null, j3, j4, true, dashManifest.dynamic, adjustedWindowDefaultStartPositionUs, this.windowDurationUs, 0, dashManifest.getPeriodCount() - 1, this.offsetInFirstPeriodUs);
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

    /* loaded from: classes7.dex */
    public static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Iso8601Parser() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dashMediaSource;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                this.this$0.onLoadCanceled(parsingLoadable, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.this$0.onManifestLoadCompleted(parsingLoadable, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) ? this.this$0.onManifestLoadError(parsingLoadable, j2, j3, iOException) : invokeCommon.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class PeriodSeekInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long availableEndTimeUs;
        public final long availableStartTimeUs;
        public final boolean isIndexExplicit;

        public PeriodSeekInfo(boolean z, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isIndexExplicit = z;
            this.availableStartTimeUs = j2;
            this.availableEndTimeUs = j3;
        }

        public static PeriodSeekInfo createPeriodSeekInfo(Period period, long j2) {
            InterceptResult invokeLJ;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, period, j2)) == null) {
                int size = period.adaptationSets.size();
                int i3 = 0;
                long j3 = Long.MAX_VALUE;
                int i4 = 0;
                boolean z = false;
                boolean z2 = false;
                long j4 = 0;
                while (i4 < size) {
                    DashSegmentIndex index = period.adaptationSets.get(i4).representations.get(i3).getIndex();
                    if (index == null) {
                        return new PeriodSeekInfo(true, 0L, j2);
                    }
                    z2 |= index.isExplicit();
                    int segmentCount = index.getSegmentCount(j2);
                    if (segmentCount == 0) {
                        i2 = i4;
                        z = true;
                        j4 = 0;
                        j3 = 0;
                    } else if (z) {
                        i2 = i4;
                    } else {
                        int firstSegmentNum = index.getFirstSegmentNum();
                        i2 = i4;
                        j4 = Math.max(j4, index.getTimeUs(firstSegmentNum));
                        if (segmentCount != -1) {
                            int i5 = (firstSegmentNum + segmentCount) - 1;
                            j3 = Math.min(j3, index.getTimeUs(i5) + index.getDurationUs(i5, j2));
                        }
                    }
                    i4 = i2 + 1;
                    i3 = 0;
                }
                return new PeriodSeekInfo(z2, j4, j3);
            }
            return (PeriodSeekInfo) invokeLJ.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dashMediaSource;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                this.this$0.onLoadCanceled(parsingLoadable, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.this$0.onUtcTimestampLoadCompleted(parsingLoadable, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) ? this.this$0.onUtcTimestampLoadError(parsingLoadable, j2, j3, iOException) : invokeCommon.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public XsDateTimeParser() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            processManifest(true);
        }
    }

    private void onUtcTimestampResolved(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, this, j2) == null) {
            this.elapsedRealtimeOffsetMs = j2;
            processManifest(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processManifest(boolean z) {
        long j2;
        boolean z2;
        long periodDurationUs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            for (int i2 = 0; i2 < this.periodsById.size(); i2++) {
                int keyAt = this.periodsById.keyAt(i2);
                if (keyAt >= this.firstPeriodId) {
                    this.periodsById.valueAt(i2).updateManifest(this.manifest, keyAt - this.firstPeriodId);
                }
            }
            int periodCount = this.manifest.getPeriodCount() - 1;
            PeriodSeekInfo createPeriodSeekInfo = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(0), this.manifest.getPeriodDurationUs(0));
            PeriodSeekInfo createPeriodSeekInfo2 = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(periodCount), this.manifest.getPeriodDurationUs(periodCount));
            long j3 = createPeriodSeekInfo.availableStartTimeUs;
            long j4 = createPeriodSeekInfo2.availableEndTimeUs;
            long j5 = 0;
            if (!this.manifest.dynamic || createPeriodSeekInfo2.isIndexExplicit) {
                j2 = j3;
                z2 = false;
            } else {
                j4 = Math.min((getNowUnixTimeUs() - C.msToUs(this.manifest.availabilityStartTime)) - C.msToUs(this.manifest.getPeriod(periodCount).startMs), j4);
                long j6 = this.manifest.timeShiftBufferDepth;
                if (j6 != C.TIME_UNSET) {
                    long msToUs = j4 - C.msToUs(j6);
                    while (msToUs < 0 && periodCount > 0) {
                        periodCount--;
                        msToUs += this.manifest.getPeriodDurationUs(periodCount);
                    }
                    if (periodCount == 0) {
                        periodDurationUs = Math.max(j3, msToUs);
                    } else {
                        periodDurationUs = this.manifest.getPeriodDurationUs(0);
                    }
                    j3 = periodDurationUs;
                }
                j2 = j3;
                z2 = true;
            }
            long j7 = j4 - j2;
            for (int i3 = 0; i3 < this.manifest.getPeriodCount() - 1; i3++) {
                j7 += this.manifest.getPeriodDurationUs(i3);
            }
            DashManifest dashManifest = this.manifest;
            if (dashManifest.dynamic) {
                long j8 = this.livePresentationDelayMs;
                if (j8 == -1) {
                    long j9 = dashManifest.suggestedPresentationDelay;
                    if (j9 == C.TIME_UNSET) {
                        j9 = 30000;
                    }
                    j8 = j9;
                }
                j5 = j7 - C.msToUs(j8);
                if (j5 < 5000000) {
                    j5 = Math.min(5000000L, j7 / 2);
                }
            }
            DashManifest dashManifest2 = this.manifest;
            long usToMs = dashManifest2.availabilityStartTime + dashManifest2.getPeriod(0).startMs + C.usToMs(j2);
            DashManifest dashManifest3 = this.manifest;
            this.sourceListener.onSourceInfoRefreshed(this, new DashTimeline(dashManifest3.availabilityStartTime, usToMs, this.firstPeriodId, j2, j7, j5, dashManifest3), this.manifest);
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
                long j2 = dashManifest.minUpdatePeriod;
                if (j2 == 0) {
                    j2 = 5000;
                }
                this.handler.postDelayed(this.refreshManifestRunnable, Math.max(0L, (this.manifestLoadStartTimestamp + j2) - SystemClock.elapsedRealtime()));
            }
        }
    }

    private <T> void startLoading(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65553, this, parsingLoadable, callback, i2) == null) {
            this.eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.loader.startLoading(parsingLoadable, callback, i2));
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
            int i2 = mediaPeriodId.periodIndex;
            DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(this.firstPeriodId + i2, this.manifest, i2, this.chunkSourceFactory, this.minLoadableRetryCount, this.eventDispatcher.copyWithMediaTimeOffsetMs(this.manifest.getPeriod(i2).startMs), this.elapsedRealtimeOffsetMs, this.loaderErrorThrower, allocator);
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

    public void onLoadCanceled(ParsingLoadable<?> parsingLoadable, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded());
        }
    }

    public void onManifestLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded());
            DashManifest result = parsingLoadable.getResult();
            DashManifest dashManifest = this.manifest;
            int i2 = 0;
            int periodCount = dashManifest == null ? 0 : dashManifest.getPeriodCount();
            long j4 = result.getPeriod(0).startMs;
            while (i2 < periodCount && this.manifest.getPeriod(i2).startMs < j4) {
                i2++;
            }
            if (periodCount - i2 > result.getPeriodCount()) {
                scheduleManifestRefresh();
                return;
            }
            this.manifest = result;
            this.manifestLoadStartTimestamp = j2 - j3;
            this.manifestLoadEndTimestamp = j2;
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
            this.firstPeriodId += i2;
            processManifest(true);
        }
    }

    public int onManifestLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public void onUtcTimestampLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded());
            onUtcTimestampResolved(parsingLoadable.getResult().longValue() - j2);
        }
    }

    public int onUtcTimestampLoadError(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{parsingLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded(), iOException, true);
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
    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, int i2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(dashManifest, null, null, null, factory, i2, -1L, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {dashManifest, factory, Integer.valueOf(i2), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (DashChunkSource.Factory) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (Handler) objArr2[5], (AdaptiveMediaSourceEventListener) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, int i2, long j2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, new DashManifestParser(), factory2, i2, j2, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, factory2, Integer.valueOf(i2), Long.valueOf(j2), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (ParsingLoadable.Parser) objArr2[2], (DashChunkSource.Factory) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue(), (Handler) objArr2[6], (AdaptiveMediaSourceEventListener) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashMediaSource(Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, int i2, long j2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, i2, j2, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, factory, parser, factory2, Integer.valueOf(i2), Long.valueOf(j2), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DashManifest) objArr2[0], (Uri) objArr2[1], (DataSource.Factory) objArr2[2], (ParsingLoadable.Parser) objArr2[3], (DashChunkSource.Factory) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (AdaptiveMediaSourceEventListener) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public DashMediaSource(DashManifest dashManifest, Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, int i2, long j2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dashManifest, uri, factory, parser, factory2, Integer.valueOf(i2), Long.valueOf(j2), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.minLoadableRetryCount = i2;
        this.livePresentationDelayMs = j2;
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
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
