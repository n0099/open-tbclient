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
/* loaded from: classes7.dex */
public final class MediaPeriodInfoSequence {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Timeline.Period period;
    public int repeatMode;
    public boolean shuffleModeEnabled;
    public Timeline timeline;
    public final Timeline.Window window;

    /* renamed from: com.google.android.exoplayer2.MediaPeriodInfoSequence$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
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

        public /* synthetic */ MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, boolean z, boolean z2, AnonymousClass1 anonymousClass1) {
            this(mediaPeriodId, j2, j3, j4, j5, z, z2);
        }

        public MediaPeriodInfo copyWithPeriodIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new MediaPeriodInfo(this.id.copyWithPeriodIndex(i2), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal) : (MediaPeriodInfo) invokeI.objValue;
        }

        public MediaPeriodInfo copyWithStartPositionUs(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new MediaPeriodInfo(this.id, j2, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal) : (MediaPeriodInfo) invokeJ.objValue;
        }

        public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {mediaPeriodId, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = mediaPeriodId;
            this.startPositionUs = j2;
            this.endPositionUs = j3;
            this.contentPositionUs = j4;
            this.durationUs = j5;
            this.isLastInTimelinePeriod = z;
            this.isFinal = z2;
        }
    }

    public MediaPeriodInfoSequence() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
    }

    private MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{mediaPeriodId, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            if (mediaPeriodId.isAd()) {
                if (this.period.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j2);
                }
                return null;
            }
            int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j3);
            return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, j3, adGroupIndexAfterPositionUs == -1 ? Long.MIN_VALUE : this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs));
        }
        return (MediaPeriodInfo) invokeCommon.objValue;
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(int i2, int i3, int i4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)})) == null) {
            MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i2, i3, i4);
            boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, Long.MIN_VALUE);
            boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
            return new MediaPeriodInfo(mediaPeriodId, i4 == this.period.getPlayedAdCount(i3) ? this.period.getAdResumePositionUs() : 0L, Long.MIN_VALUE, j2, this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup), isLastInPeriod, isLastInTimeline, null);
        }
        return (MediaPeriodInfo) invokeCommon.objValue;
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i2);
            boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j3);
            boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
            this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            return new MediaPeriodInfo(mediaPeriodId, j2, j3, C.TIME_UNSET, j3 == Long.MIN_VALUE ? this.period.getDurationUs() : j3, isLastInPeriod, isLastInTimeline, null);
        }
        return (MediaPeriodInfo) invokeCommon.objValue;
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, this, mediaPeriodId, j2)) == null) {
            int adGroupCount = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdGroupCount();
            if (adGroupCount == 0) {
                return true;
            }
            int i2 = adGroupCount - 1;
            boolean isAd = mediaPeriodId.isAd();
            if (this.period.getAdGroupTimeUs(i2) != Long.MIN_VALUE) {
                return !isAd && j2 == Long.MIN_VALUE;
            }
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i2);
            if (adCountInAdGroup == -1) {
                return false;
            }
            if (isAd && mediaPeriodId.adGroupIndex == i2 && mediaPeriodId.adIndexInAdGroup == adCountInAdGroup + (-1)) {
                return true;
            }
            return !isAd && this.period.getPlayedAdCount(i2) == adCountInAdGroup;
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

    public MediaPeriodInfo getNextMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaPeriodInfo, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (mediaPeriodInfo.isLastInTimelinePeriod) {
                int nextPeriodIndex = this.timeline.getNextPeriodIndex(mediaPeriodInfo.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
                if (nextPeriodIndex == -1) {
                    return null;
                }
                int i2 = this.timeline.getPeriod(nextPeriodIndex, this.period).windowIndex;
                long j4 = 0;
                if (this.timeline.getWindow(i2, this.window).firstPeriodIndex == nextPeriodIndex) {
                    Pair<Integer, Long> periodPosition = this.timeline.getPeriodPosition(this.window, this.period, i2, C.TIME_UNSET, Math.max(0L, (j2 + mediaPeriodInfo.durationUs) - j3));
                    if (periodPosition == null) {
                        return null;
                    }
                    nextPeriodIndex = ((Integer) periodPosition.first).intValue();
                    j4 = ((Long) periodPosition.second).longValue();
                }
                return getMediaPeriodInfo(resolvePeriodPositionForAds(nextPeriodIndex, j4), j4, j4);
            }
            MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
            if (mediaPeriodId.isAd()) {
                int i3 = mediaPeriodId.adGroupIndex;
                this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
                int adCountInAdGroup = this.period.getAdCountInAdGroup(i3);
                if (adCountInAdGroup == -1) {
                    return null;
                }
                int i4 = mediaPeriodId.adIndexInAdGroup + 1;
                if (i4 < adCountInAdGroup) {
                    if (this.period.isAdAvailable(i3, i4)) {
                        return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i3, i4, mediaPeriodInfo.contentPositionUs);
                    }
                    return null;
                }
                int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(mediaPeriodInfo.contentPositionUs);
                return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, mediaPeriodInfo.contentPositionUs, adGroupIndexAfterPositionUs == -1 ? Long.MIN_VALUE : this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs));
            }
            long j5 = mediaPeriodInfo.endPositionUs;
            if (j5 != Long.MIN_VALUE) {
                int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j5);
                if (this.period.isAdAvailable(adGroupIndexForPositionUs, 0)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, adGroupIndexForPositionUs, 0, mediaPeriodInfo.endPositionUs);
                }
                return null;
            }
            int adGroupCount = this.period.getAdGroupCount();
            if (adGroupCount != 0) {
                int i5 = adGroupCount - 1;
                if (this.period.getAdGroupTimeUs(i5) == Long.MIN_VALUE && !this.period.hasPlayedAdGroup(i5) && this.period.isAdAvailable(i5, 0)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i5, 0, this.period.getDurationUs());
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

    public MediaSource.MediaPeriodId resolvePeriodPositionForAds(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            this.timeline.getPeriod(i2, this.period);
            int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j2);
            if (adGroupIndexForPositionUs == -1) {
                return new MediaSource.MediaPeriodId(i2);
            }
            return new MediaSource.MediaPeriodId(i2, adGroupIndexForPositionUs, this.period.getPlayedAdCount(adGroupIndexForPositionUs));
        }
        return (MediaSource.MediaPeriodId) invokeCommon.objValue;
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.repeatMode = i2;
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

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, mediaPeriodInfo, i2)) == null) ? getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.id.copyWithPeriodIndex(i2)) : (MediaPeriodInfo) invokeLI.objValue;
    }

    private MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, MediaSource.MediaPeriodId mediaPeriodId) {
        InterceptResult invokeLL;
        long j2;
        long durationUs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, mediaPeriodInfo, mediaPeriodId)) == null) {
            long j3 = mediaPeriodInfo.startPositionUs;
            long j4 = mediaPeriodInfo.endPositionUs;
            boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j4);
            boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
            this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            if (mediaPeriodId.isAd()) {
                durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
            } else if (j4 == Long.MIN_VALUE) {
                durationUs = this.period.getDurationUs();
            } else {
                j2 = j4;
                return new MediaPeriodInfo(mediaPeriodId, j3, j4, mediaPeriodInfo.contentPositionUs, j2, isLastInPeriod, isLastInTimeline, null);
            }
            j2 = durationUs;
            return new MediaPeriodInfo(mediaPeriodId, j3, j4, mediaPeriodInfo.contentPositionUs, j2, isLastInPeriod, isLastInTimeline, null);
        }
        return (MediaPeriodInfo) invokeLL.objValue;
    }
}
