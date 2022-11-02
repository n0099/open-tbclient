package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
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
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class SsMediaSource implements MediaSource, Loader.Callback<ParsingLoadable<SsManifest>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    public static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    public transient /* synthetic */ FieldHolder $fh;
    public final SsChunkSource.Factory chunkSourceFactory;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public final long livePresentationDelayMs;
    public SsManifest manifest;
    public DataSource manifestDataSource;
    public final DataSource.Factory manifestDataSourceFactory;
    public long manifestLoadStartTimestamp;
    public Loader manifestLoader;
    public LoaderErrorThrower manifestLoaderErrorThrower;
    public final ParsingLoadable.Parser<? extends SsManifest> manifestParser;
    public Handler manifestRefreshHandler;
    public final Uri manifestUri;
    public final ArrayList<SsMediaPeriod> mediaPeriods;
    public final int minLoadableRetryCount;
    public MediaSource.Listener sourceListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-392138067, "Lcom/google/android/exoplayer2/source/smoothstreaming/SsMediaSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-392138067, "Lcom/google/android/exoplayer2/source/smoothstreaming/SsMediaSource;");
                return;
            }
        }
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    private void scheduleManifestRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65545, this) != null) || !this.manifest.isLive) {
            return;
        }
        this.manifestRefreshHandler.postDelayed(new Runnable(this) { // from class: com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SsMediaSource this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.this$0.startLoadingManifest();
            }
        }, Math.max(0L, (this.manifestLoadStartTimestamp + 5000) - SystemClock.elapsedRealtime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.manifestDataSource, this.manifestUri, 4, this.manifestParser);
            this.eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.manifestLoader.startLoading(parsingLoadable, this, this.minLoadableRetryCount));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.sourceListener = null;
            this.manifest = null;
            this.manifestDataSource = null;
            this.manifestLoadStartTimestamp = 0L;
            Loader loader = this.manifestLoader;
            if (loader != null) {
                loader.release();
                this.manifestLoader = null;
            }
            Handler handler = this.manifestRefreshHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.manifestRefreshHandler = null;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, new SsManifestParser(), factory2, i, j, handler, adaptiveMediaSourceEventListener);
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
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (ParsingLoadable.Parser) objArr2[2], (SsChunkSource.Factory) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue(), (Handler) objArr2[6], (AdaptiveMediaSourceEventListener) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, factory2, 3, 30000L, handler, adaptiveMediaSourceEventListener);
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
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (SsChunkSource.Factory) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (Handler) objArr2[5], (AdaptiveMediaSourceEventListener) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SsMediaSource(Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
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
                this((SsManifest) objArr2[0], (Uri) objArr2[1], (DataSource.Factory) objArr2[2], (ParsingLoadable.Parser) objArr2[3], (SsChunkSource.Factory) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (AdaptiveMediaSourceEventListener) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public SsMediaSource(SsManifest ssManifest, Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ssManifest, uri, factory, parser, factory2, Integer.valueOf(i), Long.valueOf(j), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (ssManifest != null && ssManifest.isLive) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkState(z);
        this.manifest = ssManifest;
        if (uri == null) {
            uri = null;
        } else if (!Util.toLowerInvariant(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.minLoadableRetryCount = i;
        this.livePresentationDelayMs = j;
        this.eventDispatcher = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
        this.mediaPeriods = new ArrayList<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SsMediaSource(SsManifest ssManifest, SsChunkSource.Factory factory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(ssManifest, null, null, null, factory, i, 30000L, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {ssManifest, factory, Integer.valueOf(i), handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SsManifest) objArr2[0], (Uri) objArr2[1], (DataSource.Factory) objArr2[2], (ParsingLoadable.Parser) objArr2[3], (SsChunkSource.Factory) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (AdaptiveMediaSourceEventListener) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SsMediaSource(SsManifest ssManifest, SsChunkSource.Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(ssManifest, factory, 3, handler, adaptiveMediaSourceEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ssManifest, factory, handler, adaptiveMediaSourceEventListener};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SsManifest) objArr2[0], (SsChunkSource.Factory) objArr2[1], ((Integer) objArr2[2]).intValue(), (Handler) objArr2[3], (AdaptiveMediaSourceEventListener) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mediaPeriod) == null) {
            ((SsMediaPeriod) mediaPeriod).release();
            this.mediaPeriods.remove(mediaPeriod);
        }
    }

    private void processManifest() {
        SsManifest.StreamElement[] streamElementArr;
        long j;
        SinglePeriodTimeline singlePeriodTimeline;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            for (int i = 0; i < this.mediaPeriods.size(); i++) {
                this.mediaPeriods.get(i).updateManifest(this.manifest);
            }
            long j3 = Long.MIN_VALUE;
            long j4 = Long.MAX_VALUE;
            for (SsManifest.StreamElement streamElement : this.manifest.streamElements) {
                if (streamElement.chunkCount > 0) {
                    j4 = Math.min(j4, streamElement.getStartTimeUs(0));
                    j3 = Math.max(j3, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
                }
            }
            if (j4 == Long.MAX_VALUE) {
                if (this.manifest.isLive) {
                    j2 = -9223372036854775807L;
                } else {
                    j2 = 0;
                }
                singlePeriodTimeline = new SinglePeriodTimeline(j2, 0L, 0L, 0L, true, this.manifest.isLive);
            } else {
                SsManifest ssManifest = this.manifest;
                if (ssManifest.isLive) {
                    long j5 = ssManifest.dvrWindowLengthUs;
                    if (j5 != C.TIME_UNSET && j5 > 0) {
                        j4 = Math.max(j4, j3 - j5);
                    }
                    long j6 = j4;
                    long j7 = j3 - j6;
                    long msToUs = j7 - C.msToUs(this.livePresentationDelayMs);
                    if (msToUs < 5000000) {
                        msToUs = Math.min(5000000L, j7 / 2);
                    }
                    singlePeriodTimeline = new SinglePeriodTimeline(C.TIME_UNSET, j7, j6, msToUs, true, true);
                } else {
                    long j8 = ssManifest.durationUs;
                    if (j8 != C.TIME_UNSET) {
                        j = j8;
                    } else {
                        j = j3 - j4;
                    }
                    singlePeriodTimeline = new SinglePeriodTimeline(j4 + j, j, j4, 0L, true, false);
                }
            }
            this.sourceListener.onSourceInfoRefreshed(this, singlePeriodTimeline, this.manifest);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            if (mediaPeriodId.periodIndex == 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.manifest, this.chunkSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, this.manifestLoaderErrorThrower, allocator);
            this.mediaPeriods.add(ssMediaPeriod);
            return ssMediaPeriod;
        }
        return (MediaPeriod) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
            this.manifest = parsingLoadable.getResult();
            this.manifestLoadStartTimestamp = j - j2;
            processManifest();
            scheduleManifestRefresh();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            this.sourceListener = listener;
            if (this.manifest != null) {
                this.manifestLoaderErrorThrower = new LoaderErrorThrower.Dummy();
                processManifest();
                return;
            }
            this.manifestDataSource = this.manifestDataSourceFactory.createDataSource();
            Loader loader = new Loader("Loader:Manifest");
            this.manifestLoader = loader;
            this.manifestLoaderErrorThrower = loader;
            this.manifestRefreshHandler = new Handler();
            startLoadingManifest();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{parsingLoadable, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, z);
            if (z) {
                return 3;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }
}
