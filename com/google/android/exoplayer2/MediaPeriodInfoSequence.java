package com.google.android.exoplayer2;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
/* loaded from: classes4.dex */
public final class MediaPeriodInfoSequence {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Timeline.Period period;
    public int repeatMode;
    public boolean shuffleModeEnabled;
    public Timeline timeline;
    public final Timeline.Window window;

    /* renamed from: com.google.android.exoplayer2.MediaPeriodInfoSequence$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class MediaPeriodInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long contentPositionUs;
        public final long durationUs;
        public final long endPositionUs;
        public final MediaSource.MediaPeriodId id;
        public final boolean isFinal;
        public final boolean isLastInTimelinePeriod;
        public final long startPositionUs;

        public /* synthetic */ MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2, AnonymousClass1 anonymousClass1) {
            this(mediaPeriodId, j, j2, j3, j4, z, z2);
        }

        public MediaPeriodInfo copyWithPeriodIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? new MediaPeriodInfo(this.id.copyWithPeriodIndex(i), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal) : (MediaPeriodInfo) invokeI.objValue;
        }

        public MediaPeriodInfo copyWithStartPositionUs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new MediaPeriodInfo(this.id, j, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal) : (MediaPeriodInfo) invokeJ.objValue;
        }

        public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {mediaPeriodId, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = mediaPeriodId;
            this.startPositionUs = j;
            this.endPositionUs = j2;
            this.contentPositionUs = j3;
            this.durationUs = j4;
            this.isLastInTimelinePeriod = z;
            this.isFinal = z2;
        }
    }

    public MediaPeriodInfoSequence() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
    }

    private MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{mediaPeriodId, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            if (mediaPeriodId.isAd()) {
                if (this.period.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j);
                }
                return null;
            }
            int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j2);
            return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, j2, adGroupIndexAfterPositionUs == -1 ? Long.MIN_VALUE : this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs));
        }
        return (MediaPeriodInfo) invokeCommon.objValue;
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(int i, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
            MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i, i2, i3);
            boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, Long.MIN_VALUE);
            boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
            return new MediaPeriodInfo(mediaPeriodId, i3 == this.period.getPlayedAdCount(i2) ? this.period.getAdResumePositionUs() : 0L, Long.MIN_VALUE, j, this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup), isLastInPeriod, isLastInTimeline, null);
        }
        return (MediaPeriodInfo) invokeCommon.objValue;
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i);
            boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j2);
            boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
            this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            return new MediaPeriodInfo(mediaPeriodId, j, j2, C.TIME_UNSET, j2 == Long.MIN_VALUE ? this.period.getDurationUs() : j2, isLastInPeriod, isLastInTimeline, null);
        }
        return (MediaPeriodInfo) invokeCommon.objValue;
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, this, mediaPeriodId, j)) == null) {
            int adGroupCount = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdGroupCount();
            if (adGroupCount == 0) {
                return true;
            }
            int i = adGroupCount - 1;
            boolean isAd = mediaPeriodId.isAd();
            if (this.period.getAdGroupTimeUs(i) != Long.MIN_VALUE) {
                return !isAd && j == Long.MIN_VALUE;
            }
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i);
            if (adCountInAdGroup == -1) {
                return false;
            }
            if (isAd && mediaPeriodId.adGroupIndex == i && mediaPeriodId.adIndexInAdGroup == adCountInAdGroup + (-1)) {
                return true;
            }
            return !isAd && this.period.getPlayedAdCount(i) == adCountInAdGroup;
        }
        return invokeLJ.booleanValue;
    }

    private boolean isLastInTimeline(MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, this, mediaPeriodId, z)) == null) ? !this.timeline.getWindow(this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).windowIndex, this.window).isDynamic && this.timeline.isLastPeriod(mediaPeriodId.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z : invokeLZ.booleanValue;
    }

    public MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, playbackInfo)) == null) ? getMediaPeriodInfo(playbackInfo.periodId, playbackInfo.contentPositionUs, playbackInfo.startPositionUs) : (MediaPeriodInfo) invokeL.objValue;
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaPeriodInfo, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (mediaPeriodInfo.isLastInTimelinePeriod) {
                int nextPeriodIndex = this.timeline.getNextPeriodIndex(mediaPeriodInfo.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
                if (nextPeriodIndex == -1) {
                    return null;
                }
                int i = this.timeline.getPeriod(nextPeriodIndex, this.period).windowIndex;
                long j3 = 0;
                if (this.timeline.getWindow(i, this.window).firstPeriodIndex == nextPeriodIndex) {
                    Pair<Integer, Long> periodPosition = this.timeline.getPeriodPosition(this.window, this.period, i, C.TIME_UNSET, Math.max(0L, (j + mediaPeriodInfo.durationUs) - j2));
                    if (periodPosition == null) {
                        return null;
                    }
                    nextPeriodIndex = ((Integer) periodPosition.first).intValue();
                    j3 = ((Long) periodPosition.second).longValue();
                }
                return getMediaPeriodInfo(resolvePeriodPositionForAds(nextPeriodIndex, j3), j3, j3);
            }
            MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
            if (mediaPeriodId.isAd()) {
                int i2 = mediaPeriodId.adGroupIndex;
                this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
                int adCountInAdGroup = this.period.getAdCountInAdGroup(i2);
                if (adCountInAdGroup == -1) {
                    return null;
                }
                int i3 = mediaPeriodId.adIndexInAdGroup + 1;
                if (i3 < adCountInAdGroup) {
                    if (this.period.isAdAvailable(i2, i3)) {
                        return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i2, i3, mediaPeriodInfo.contentPositionUs);
                    }
                    return null;
                }
                int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(mediaPeriodInfo.contentPositionUs);
                return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, mediaPeriodInfo.contentPositionUs, adGroupIndexAfterPositionUs == -1 ? Long.MIN_VALUE : this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs));
            }
            long j4 = mediaPeriodInfo.endPositionUs;
            if (j4 != Long.MIN_VALUE) {
                int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j4);
                if (this.period.isAdAvailable(adGroupIndexForPositionUs, 0)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, adGroupIndexForPositionUs, 0, mediaPeriodInfo.endPositionUs);
                }
                return null;
            }
            int adGroupCount = this.period.getAdGroupCount();
            if (adGroupCount != 0) {
                int i4 = adGroupCount - 1;
                if (this.period.getAdGroupTimeUs(i4) == Long.MIN_VALUE && !this.period.hasPlayedAdGroup(i4) && this.period.isAdAvailable(i4, 0)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i4, 0, this.period.getDurationUs());
                }
            }
            return null;
        }
        return (MediaPeriodInfo) invokeCommon.objValue;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaPeriodInfo)) == null) ? getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.id) : (MediaPeriodInfo) invokeL.objValue;
    }

    public MediaSource.MediaPeriodId resolvePeriodPositionForAds(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            this.timeline.getPeriod(i, this.period);
            int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j);
            if (adGroupIndexForPositionUs == -1) {
                return new MediaSource.MediaPeriodId(i);
            }
            return new MediaSource.MediaPeriodId(i, adGroupIndexForPositionUs, this.period.getPlayedAdCount(adGroupIndexForPositionUs));
        }
        return (MediaSource.MediaPeriodId) invokeCommon.objValue;
    }

    public void setRepeatMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.repeatMode = i;
        }
    }

    public void setShuffleModeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.shuffleModeEnabled = z;
        }
    }

    public void setTimeline(Timeline timeline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, timeline) == null) {
            this.timeline = timeline;
        }
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, mediaPeriodInfo, i)) == null) ? getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.id.copyWithPeriodIndex(i)) : (MediaPeriodInfo) invokeLI.objValue;
    }

    private MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, MediaSource.MediaPeriodId mediaPeriodId) {
        InterceptResult invokeLL;
        long j;
        long durationUs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, mediaPeriodInfo, mediaPeriodId)) == null) {
            long j2 = mediaPeriodInfo.startPositionUs;
            long j3 = mediaPeriodInfo.endPositionUs;
            boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j3);
            boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
            this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            if (mediaPeriodId.isAd()) {
                durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
            } else if (j3 == Long.MIN_VALUE) {
                durationUs = this.period.getDurationUs();
            } else {
                j = j3;
                return new MediaPeriodInfo(mediaPeriodId, j2, j3, mediaPeriodInfo.contentPositionUs, j, isLastInPeriod, isLastInTimeline, null);
            }
            j = durationUs;
            return new MediaPeriodInfo(mediaPeriodId, j2, j3, mediaPeriodInfo.contentPositionUs, j, isLastInPeriod, isLastInTimeline, null);
        }
        return (MediaPeriodInfo) invokeLL.objValue;
    }
}
