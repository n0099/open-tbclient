package com.google.android.exoplayer2.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class MergingMediaSource implements MediaSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PERIOD_COUNT_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaSource.Listener listener;
    public final MediaSource[] mediaSources;
    public IllegalMergeException mergeError;
    public final ArrayList<MediaSource> pendingTimelineSources;
    public int periodCount;
    public Object primaryManifest;
    public Timeline primaryTimeline;
    public final Timeline.Window window;

    /* loaded from: classes7.dex */
    public static final class IllegalMergeException extends IOException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int REASON_PERIOD_COUNT_MISMATCH = 1;
        public static final int REASON_WINDOWS_ARE_DYNAMIC = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final int reason;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes7.dex */
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.reason = i;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSourceArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mediaSources = mediaSourceArr;
        this.pendingTimelineSources = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.window = new Timeline.Window();
        this.periodCount = -1;
    }

    private IllegalMergeException checkTimelineMerges(Timeline timeline) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, timeline)) == null) {
            int windowCount = timeline.getWindowCount();
            for (int i = 0; i < windowCount; i++) {
                if (timeline.getWindow(i, this.window, false).isDynamic) {
                    return new IllegalMergeException(0);
                }
            }
            if (this.periodCount == -1) {
                this.periodCount = timeline.getPeriodCount();
                return null;
            } else if (timeline.getPeriodCount() != this.periodCount) {
                return new IllegalMergeException(1);
            } else {
                return null;
            }
        }
        return (IllegalMergeException) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSourceInfoRefreshed(int i, Timeline timeline, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, this, i, timeline, obj) == null) {
            if (this.mergeError == null) {
                this.mergeError = checkTimelineMerges(timeline);
            }
            if (this.mergeError != null) {
                return;
            }
            this.pendingTimelineSources.remove(this.mediaSources[i]);
            if (i == 0) {
                this.primaryTimeline = timeline;
                this.primaryManifest = obj;
            }
            if (this.pendingTimelineSources.isEmpty()) {
                this.listener.onSourceInfoRefreshed(this, this.primaryTimeline, this.primaryManifest);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            this.listener = listener;
            int i = 0;
            while (true) {
                MediaSource[] mediaSourceArr = this.mediaSources;
                if (i < mediaSourceArr.length) {
                    mediaSourceArr[i].prepareSource(exoPlayer, false, new MediaSource.Listener(this, i) { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MergingMediaSource this$0;
                        public final /* synthetic */ int val$sourceIndex;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$sourceIndex = i;
                        }

                        @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                        public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, mediaSource, timeline, obj) == null) {
                                this.this$0.handleSourceInfoRefreshed(this.val$sourceIndex, timeline, obj);
                            }
                        }
                    });
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            int length = this.mediaSources.length;
            MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
            for (int i = 0; i < length; i++) {
                mediaPeriodArr[i] = this.mediaSources[i].createPeriod(mediaPeriodId, allocator);
            }
            return new MergingMediaPeriod(mediaPeriodArr);
        }
        return (MediaPeriod) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IllegalMergeException illegalMergeException = this.mergeError;
            if (illegalMergeException == null) {
                for (MediaSource mediaSource : this.mediaSources) {
                    mediaSource.maybeThrowSourceInfoRefreshError();
                }
                return;
            }
            throw illegalMergeException;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (MediaSource mediaSource : this.mediaSources) {
                mediaSource.releaseSource();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mediaPeriod) == null) {
            MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
            int i = 0;
            while (true) {
                MediaSource[] mediaSourceArr = this.mediaSources;
                if (i < mediaSourceArr.length) {
                    mediaSourceArr[i].releasePeriod(mergingMediaPeriod.periods[i]);
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
