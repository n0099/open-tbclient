package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class BaseTrackSelection implements TrackSelection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long[] blacklistUntilTimes;
    public final Format[] formats;
    public final TrackGroup group;
    public int hashCode;
    public final int length;
    public final int[] tracks;

    /* renamed from: com.google.android.exoplayer2.trackselection.BaseTrackSelection$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class DecreasingBandwidthComparator implements Comparator<Format> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DecreasingBandwidthComparator() {
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

        public /* synthetic */ DecreasingBandwidthComparator(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Format format, Format format2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, format, format2)) == null) ? format2.bitrate - format.bitrate : invokeLL.intValue;
        }
    }

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trackGroup, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i4 = 0;
        Assertions.checkState(iArr.length > 0);
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length = iArr.length;
        this.length = length;
        this.formats = new Format[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.formats[i5] = trackGroup.getFormat(iArr[i5]);
        }
        Arrays.sort(this.formats, new DecreasingBandwidthComparator(null));
        this.tracks = new int[this.length];
        while (true) {
            int i6 = this.length;
            if (i4 < i6) {
                this.tracks[i4] = trackGroup.indexOf(this.formats[i4]);
                i4++;
            } else {
                this.blacklistUntilTimes = new long[i6];
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean isBlacklisted = isBlacklisted(i2, elapsedRealtime);
            int i3 = 0;
            while (i3 < this.length && !isBlacklisted) {
                isBlacklisted = (i3 == i2 || isBlacklisted(i3, elapsedRealtime)) ? false : true;
                i3++;
            }
            if (isBlacklisted) {
                long[] jArr = this.blacklistUntilTimes;
                jArr[i2] = Math.max(jArr[i2], elapsedRealtime + j2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
            return this.group == baseTrackSelection.group && Arrays.equals(this.tracks, baseTrackSelection.tracks);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j2, List<? extends MediaChunk> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, list)) == null) ? list.size() : invokeJL.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.formats[i2] : (Format) invokeI.objValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.tracks[i2] : invokeI.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getSelectedFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.formats[getSelectedIndex()] : (Format) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getSelectedIndexInTrackGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.tracks[getSelectedIndex()] : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.group : (TrackGroup) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.hashCode == 0) {
                this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
            }
            return this.hashCode;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, format)) == null) {
            for (int i2 = 0; i2 < this.length; i2++) {
                if (this.formats[i2] == format) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean isBlacklisted(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? this.blacklistUntilTimes[i2] > j2 : invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.tracks.length : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            for (int i3 = 0; i3 < this.length; i3++) {
                if (this.tracks[i3] == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }
}
