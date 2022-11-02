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

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((BandwidthMeter) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Float) objArr2[6]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory(BandwidthMeter bandwidthMeter, int i, int i2, int i3, int i4, float f) {
            this(bandwidthMeter, i, i2, i3, i4, f, 0.75f);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bandwidthMeter, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((BandwidthMeter) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Float) objArr2[6]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public Factory(BandwidthMeter bandwidthMeter, int i, int i2, int i3, int i4, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bandwidthMeter, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.bandwidthMeter = bandwidthMeter;
            this.maxInitialBitrate = i;
            this.minDurationForQualityIncreaseMs = i2;
            this.maxDurationForQualityDecreaseMs = i3;
            this.minDurationToRetainAfterDiscardMs = i4;
            this.bandwidthFraction = f;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public AdaptiveTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, trackGroup, iArr)) == null) {
                return new AdaptiveTrackSelection(trackGroup, iArr, this.bandwidthMeter, this.maxInitialBitrate, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease);
            }
            return (AdaptiveTrackSelection) invokeLL.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TrackGroup) objArr2[0], (int[]) objArr2[1], (BandwidthMeter) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Float) objArr2[7]).floatValue(), ((Float) objArr2[8]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, int i, long j, long j2, long j3, float f, float f2) {
        super(trackGroup, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {trackGroup, iArr, bandwidthMeter, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TrackGroup) objArr2[0], (int[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bandwidthMeter = bandwidthMeter;
        this.maxInitialBitrate = i;
        this.minDurationForQualityIncreaseUs = j * 1000;
        this.maxDurationForQualityDecreaseUs = j2 * 1000;
        this.minDurationToRetainAfterDiscardUs = j3 * 1000;
        this.bandwidthFraction = f;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
        this.reason = 1;
    }

    private int determineIdealSelectedIndex(long j) {
        InterceptResult invokeJ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
            long bitrateEstimate = this.bandwidthMeter.getBitrateEstimate();
            if (bitrateEstimate == -1) {
                j2 = this.maxInitialBitrate;
            } else {
                j2 = ((float) bitrateEstimate) * this.bandwidthFraction;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.length; i2++) {
                if (j == Long.MIN_VALUE || !isBlacklisted(i2, j)) {
                    if (getFormat(i2).bitrate <= j2) {
                        return i2;
                    }
                    i = i2;
                }
            }
            return i;
        }
        return invokeJ.intValue;
    }

    private long minDurationForQualityIncreaseUs(long j) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            if (j != C.TIME_UNSET && j <= this.minDurationForQualityIncreaseUs) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return ((float) j) * this.bufferedFractionToLiveEdgeForQualityIncrease;
            }
            return this.minDurationForQualityIncreaseUs;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        InterceptResult invokeJL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, list)) == null) {
            if (list.isEmpty()) {
                return 0;
            }
            int size = list.size();
            if (list.get(size - 1).endTimeUs - j < this.minDurationToRetainAfterDiscardUs) {
                return size;
            }
            Format format = getFormat(determineIdealSelectedIndex(SystemClock.elapsedRealtime()));
            for (int i3 = 0; i3 < size; i3++) {
                MediaChunk mediaChunk = list.get(i3);
                Format format2 = mediaChunk.trackFormat;
                if (mediaChunk.startTimeUs - j >= this.minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i = format2.height) != -1 && i < 720 && (i2 = format2.width) != -1 && i2 < 1280 && i < format.height) {
                    return i3;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.selectedIndex;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.reason;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = this.selectedIndex;
            int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime);
            this.selectedIndex = determineIdealSelectedIndex;
            if (determineIdealSelectedIndex == i) {
                return;
            }
            if (!isBlacklisted(i, elapsedRealtime)) {
                Format format = getFormat(i);
                Format format2 = getFormat(this.selectedIndex);
                if (format2.bitrate > format.bitrate && j2 < minDurationForQualityIncreaseUs(j3)) {
                    this.selectedIndex = i;
                } else if (format2.bitrate < format.bitrate && j2 >= this.maxDurationForQualityDecreaseUs) {
                    this.selectedIndex = i;
                }
            }
            if (this.selectedIndex != i) {
                this.reason = 3;
            }
        }
    }
}
