package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class AdsMediaSource implements MediaSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdsMediaSource";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public interface AdsListener {
        void onAdClicked();

        void onAdLoadError(IOException iOException);

        void onAdTapped();
    }

    /* loaded from: classes7.dex */
    public final class ComponentListener implements AdsLoader.EventListener, ExtractorMediaSource.EventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdsMediaSource this$0;

        public ComponentListener(AdsMediaSource adsMediaSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adsMediaSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adsMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adPlaybackState) != null) || this.this$0.released) {
                return;
            }
            this.this$0.playerHandler.post(new Runnable(this, adPlaybackState) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComponentListener this$1;
                public final /* synthetic */ AdPlaybackState val$adPlaybackState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adPlaybackState};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$adPlaybackState = adPlaybackState;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$1.this$0.released) {
                        return;
                    }
                    this.this$1.this$0.onAdPlaybackState(this.val$adPlaybackState);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener, com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener
        public void onLoadError(IOException iOException) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, iOException) != null) || this.this$0.released) {
                return;
            }
            this.this$0.playerHandler.post(new Runnable(this, iOException) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComponentListener this$1;
                public final /* synthetic */ IOException val$error;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iOException};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$error = iOException;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$1.this$0.released) {
                        return;
                    }
                    this.this$1.this$0.onLoadError(this.val$error);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdClicked() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.this$0.eventHandler != null && this.this$0.eventListener != null) {
                this.this$0.eventHandler.post(new Runnable(this) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComponentListener this$1;

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
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$1.this$0.released) {
                            this.this$1.this$0.eventListener.onAdClicked();
                        }
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdTapped() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.this$0.eventHandler != null && this.this$0.eventListener != null) {
                this.this$0.eventHandler.post(new Runnable(this) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComponentListener this$1;

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
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$1.this$0.released) {
                            this.this$1.this$0.eventListener.onAdTapped();
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader, ViewGroup viewGroup) {
        this(mediaSource, factory, adsLoader, viewGroup, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSource, factory, adsLoader, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaSource) objArr2[0], (DataSource.Factory) objArr2[1], (AdsLoader) objArr2[2], (ViewGroup) objArr2[3], (Handler) objArr2[4], (AdsListener) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader, ViewGroup viewGroup, @Nullable Handler handler, @Nullable AdsListener adsListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSource, factory, adsLoader, viewGroup, handler, adsListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65551, this, i, i2, timeline) == null) {
            boolean z = true;
            if (timeline.getPeriodCount() != 1) {
                z = false;
            }
            Assertions.checkArgument(z);
            this.adDurationsUs[i][i2] = timeline.getPeriod(0, this.period).getDurationUs();
            maybeUpdateSourceInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, adPlaybackState) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadError(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, iOException) == null) {
            Log.w(TAG, "Ad load error", iOException);
            Handler handler = this.eventHandler;
            if (handler != null && this.eventListener != null) {
                handler.post(new Runnable(this, iOException) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdsMediaSource this$0;
                    public final /* synthetic */ IOException val$error;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iOException};
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
                        this.val$error = iOException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.released) {
                            this.this$0.eventListener.onAdLoadError(this.val$error);
                        }
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mediaPeriod) == null) {
            if (this.adMediaSourceByMediaPeriod.containsKey(mediaPeriod)) {
                this.adMediaSourceByMediaPeriod.remove(mediaPeriod).releasePeriod(mediaPeriod);
            } else {
                this.contentMediaSource.releasePeriod(mediaPeriod);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onContentSourceInfoRefreshed(Timeline timeline, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, timeline, obj) == null) {
            this.contentTimeline = timeline;
            this.contentManifest = obj;
            maybeUpdateSourceInfo();
        }
    }

    private void maybeUpdateSourceInfo() {
        AdPlaybackState adPlaybackState;
        Timeline timeline;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && (adPlaybackState = this.adPlaybackState) != null && (timeline = this.contentTimeline) != null) {
            if (adPlaybackState.adGroupCount != 0) {
                Timeline timeline2 = this.contentTimeline;
                AdPlaybackState adPlaybackState2 = this.adPlaybackState;
                timeline = new SinglePeriodAdTimeline(timeline2, adPlaybackState2.adGroupTimesUs, adPlaybackState2.adCounts, adPlaybackState2.adsLoadedCounts, adPlaybackState2.adsPlayedCounts, this.adDurationsUs, adPlaybackState2.adResumePositionUs, adPlaybackState2.contentDurationUs);
            }
            this.listener.onSourceInfoRefreshed(this, timeline, this.contentManifest);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        MediaSource[][] mediaSourceArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.released = true;
            this.contentMediaSource.releaseSource();
            for (MediaSource[] mediaSourceArr2 : this.adGroupMediaSources) {
                for (MediaSource mediaSource : mediaSourceArr2) {
                    if (mediaSource != null) {
                        mediaSource.releaseSource();
                    }
                }
            }
            this.mainHandler.post(new Runnable(this) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdsMediaSource this$0;

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
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.adsLoader.detachPlayer();
                    }
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            if (this.adPlaybackState.adGroupCount > 0 && mediaPeriodId.isAd()) {
                int i = mediaPeriodId.adGroupIndex;
                int i2 = mediaPeriodId.adIndexInAdGroup;
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
                    extractorMediaSource.prepareSource(this.player, false, new MediaSource.Listener(this, i, i2) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AdsMediaSource this$0;
                        public final /* synthetic */ int val$adGroupIndex;
                        public final /* synthetic */ int val$adIndexInAdGroup;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$adGroupIndex = i;
                            this.val$adIndexInAdGroup = i2;
                        }

                        @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                        public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeLLL(1048576, this, mediaSource, timeline, obj) != null) {
                                return;
                            }
                            this.this$0.onAdSourceInfoRefreshed(this.val$adGroupIndex, this.val$adIndexInAdGroup, timeline);
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
        return (MediaPeriod) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        MediaSource[][] mediaSourceArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.contentMediaSource.maybeThrowSourceInfoRefreshError();
            for (MediaSource[] mediaSourceArr2 : this.adGroupMediaSources) {
                for (MediaSource mediaSource : mediaSourceArr2) {
                    if (mediaSource != null) {
                        mediaSource.maybeThrowSourceInfoRefreshError();
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            Assertions.checkArgument(z);
            this.listener = listener;
            this.player = exoPlayer;
            this.playerHandler = new Handler();
            this.contentMediaSource.prepareSource(exoPlayer, false, new MediaSource.Listener(this) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdsMediaSource this$0;

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

                @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeLLL(1048576, this, mediaSource, timeline, obj) != null) {
                        return;
                    }
                    this.this$0.onContentSourceInfoRefreshed(timeline, obj);
                }
            });
            this.mainHandler.post(new Runnable(this, exoPlayer) { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdsMediaSource this$0;
                public final /* synthetic */ ExoPlayer val$player;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, exoPlayer};
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
                    this.val$player = exoPlayer;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.adsLoader.attachPlayer(this.val$player, this.this$0.componentListener, this.this$0.adUiViewGroup);
                    }
                }
            });
        }
    }
}
