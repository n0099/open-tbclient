package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.anr.impl.ANRMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;
/* loaded from: classes7.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_INITIAL_BITRATE = 800000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public transient /* synthetic */ FieldHolder $fh;
    public final float bandwidthFraction;
    public final BandwidthMeter bandwidthMeter;
    public final float bufferedFractionToLiveEdgeForQualityIncrease;
    public final long maxDurationForQualityDecreaseUs;
    public final int maxInitialBitrate;
    public final long minDurationForQualityIncreaseUs;
    public final long minDurationToRetainAfterDiscardUs;
    public int reason;
    public int selectedIndex;

    /* loaded from: classes7.dex */
    public static final class Factory implements TrackSelection.Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float bandwidthFraction;
        public final BandwidthMeter bandwidthMeter;
        public final float bufferedFractionToLiveEdgeForQualityIncrease;
        public final int maxDurationForQualityDecreaseMs;
        public final int maxInitialBitrate;
        public final int minDurationForQualityIncreaseMs;
        public final int minDurationToRetainAfterDiscardMs;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory(BandwidthMeter bandwidthMeter) {
            this(bandwidthMeter, AdaptiveTrackSelection.DEFAULT_MAX_INITIAL_BITRATE, 10000, 25000, 25000, 0.75f, 0.75f);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bandwidthMeter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((BandwidthMeter) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Float) objArr2[6]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory(BandwidthMeter bandwidthMeter, int i2, int i3, int i4, int i5, float f2) {
            this(bandwidthMeter, i2, i3, i4, i5, f2, 0.75f);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bandwidthMeter, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((BandwidthMeter) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Float) objArr2[6]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public AdaptiveTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, trackGroup, iArr)) == null) ? new AdaptiveTrackSelection(trackGroup, iArr, this.bandwidthMeter, this.maxInitialBitrate, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease) : (AdaptiveTrackSelection) invokeLL.objValue;
        }

        public Factory(BandwidthMeter bandwidthMeter, int i2, int i3, int i4, int i5, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bandwidthMeter, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.bandwidthMeter = bandwidthMeter;
            this.maxInitialBitrate = i2;
            this.minDurationForQualityIncreaseMs = i3;
            this.maxDurationForQualityDecreaseMs = i4;
            this.minDurationToRetainAfterDiscardMs = i5;
            this.bandwidthFraction = f2;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, bandwidthMeter, DEFAULT_MAX_INITIAL_BITRATE, 10000L, ANRMonitor.ANR_TIMEOUT_MS, ANRMonitor.ANR_TIMEOUT_MS, 0.75f, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {trackGroup, iArr, bandwidthMeter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TrackGroup) objArr2[0], (int[]) objArr2[1], (BandwidthMeter) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Float) objArr2[7]).floatValue(), ((Float) objArr2[8]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int determineIdealSelectedIndex(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) {
            long bitrateEstimate = this.bandwidthMeter.getBitrateEstimate();
            long j3 = bitrateEstimate == -1 ? this.maxInitialBitrate : ((float) bitrateEstimate) * this.bandwidthFraction;
            int i2 = 0;
            for (int i3 = 0; i3 < this.length; i3++) {
                if (j2 == Long.MIN_VALUE || !isBlacklisted(i3, j2)) {
                    if (getFormat(i3).bitrate <= j3) {
                        return i3;
                    }
                    i2 = i3;
                }
            }
            return i2;
        }
        return invokeJ.intValue;
    }

    private long minDurationForQualityIncreaseUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) {
            return (j2 > C.TIME_UNSET ? 1 : (j2 == C.TIME_UNSET ? 0 : -1)) != 0 && (j2 > this.minDurationForQualityIncreaseUs ? 1 : (j2 == this.minDurationForQualityIncreaseUs ? 0 : -1)) <= 0 ? ((float) j2) * this.bufferedFractionToLiveEdgeForQualityIncrease : this.minDurationForQualityIncreaseUs;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j2, List<? extends MediaChunk> list) {
        InterceptResult invokeJL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j2, list)) == null) {
            if (list.isEmpty()) {
                return 0;
            }
            int size = list.size();
            if (list.get(size - 1).endTimeUs - j2 < this.minDurationToRetainAfterDiscardUs) {
                return size;
            }
            Format format = getFormat(determineIdealSelectedIndex(SystemClock.elapsedRealtime()));
            for (int i4 = 0; i4 < size; i4++) {
                MediaChunk mediaChunk = list.get(i4);
                Format format2 = mediaChunk.trackFormat;
                if (mediaChunk.startTimeUs - j2 >= this.minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i2 = format2.height) != -1 && i2 < 720 && (i3 = format2.width) != -1 && i3 < 1280 && i2 < format.height) {
                    return i4;
                }
            }
            return size;
        }
        return invokeJL.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.selectedIndex : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.reason : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i2 = this.selectedIndex;
            int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime);
            this.selectedIndex = determineIdealSelectedIndex;
            if (determineIdealSelectedIndex == i2) {
                return;
            }
            if (!isBlacklisted(i2, elapsedRealtime)) {
                Format format = getFormat(i2);
                Format format2 = getFormat(this.selectedIndex);
                if (format2.bitrate > format.bitrate && j3 < minDurationForQualityIncreaseUs(j4)) {
                    this.selectedIndex = i2;
                } else if (format2.bitrate < format.bitrate && j3 >= this.maxDurationForQualityDecreaseUs) {
                    this.selectedIndex = i2;
                }
            }
            if (this.selectedIndex != i2) {
                this.reason = 3;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, int i2, long j2, long j3, long j4, float f2, float f3) {
        super(trackGroup, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {trackGroup, iArr, bandwidthMeter, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TrackGroup) objArr2[0], (int[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bandwidthMeter = bandwidthMeter;
        this.maxInitialBitrate = i2;
        this.minDurationForQualityIncreaseUs = j2 * 1000;
        this.maxDurationForQualityDecreaseUs = j3 * 1000;
        this.minDurationToRetainAfterDiscardUs = j4 * 1000;
        this.bandwidthFraction = f2;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f3;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
        this.reason = 1;
    }
}
