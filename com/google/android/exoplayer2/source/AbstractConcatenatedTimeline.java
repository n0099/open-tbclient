package com.google.android.exoplayer2.source;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Timeline;
/* loaded from: classes7.dex */
public abstract class AbstractConcatenatedTimeline extends Timeline {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int childCount;
    public final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(ShuffleOrder shuffleOrder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shuffleOrder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.shuffleOrder = shuffleOrder;
        this.childCount = shuffleOrder.getLength();
    }

    private int getNextChildIndex(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return this.shuffleOrder.getNextIndex(i2);
            }
            if (i2 < this.childCount - 1) {
                return i2 + 1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    private int getPreviousChildIndex(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return this.shuffleOrder.getPreviousIndex(i2);
            }
            if (i2 > 0) {
                return i2 - 1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public abstract int getChildIndexByChildUid(Object obj);

    public abstract int getChildIndexByPeriodIndex(int i2);

    public abstract int getChildIndexByWindowIndex(int i2);

    public abstract Object getChildUidByChildIndex(int i2);

    public abstract int getFirstPeriodIndexByChildIndex(int i2);

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (this.childCount == 0) {
                return -1;
            }
            int firstIndex = z ? this.shuffleOrder.getFirstIndex() : 0;
            while (getTimelineByChildIndex(firstIndex).isEmpty()) {
                firstIndex = getNextChildIndex(firstIndex, z);
                if (firstIndex == -1) {
                    return -1;
                }
            }
            return getFirstWindowIndexByChildIndex(firstIndex) + getTimelineByChildIndex(firstIndex).getFirstWindowIndex(z);
        }
        return invokeZ.intValue;
    }

    public abstract int getFirstWindowIndexByChildIndex(int i2);

    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        InterceptResult invokeL;
        int indexOfPeriod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                Object obj2 = pair.first;
                Object obj3 = pair.second;
                int childIndexByChildUid = getChildIndexByChildUid(obj2);
                if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(obj3)) == -1) {
                    return -1;
                }
                return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            int i2 = this.childCount;
            if (i2 == 0) {
                return -1;
            }
            int lastIndex = z ? this.shuffleOrder.getLastIndex() : i2 - 1;
            while (getTimelineByChildIndex(lastIndex).isEmpty()) {
                lastIndex = getPreviousChildIndex(lastIndex, z);
                if (lastIndex == -1) {
                    return -1;
                }
            }
            return getFirstWindowIndexByChildIndex(lastIndex) + getTimelineByChildIndex(lastIndex).getLastWindowIndex(z);
        }
        return invokeZ.intValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int childIndexByWindowIndex = getChildIndexByWindowIndex(i2);
            int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
            int nextWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getNextWindowIndex(i2 - firstWindowIndexByChildIndex, i3 == 2 ? 0 : i3, z);
            if (nextWindowIndex != -1) {
                return firstWindowIndexByChildIndex + nextWindowIndex;
            }
            int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z);
            while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
                nextChildIndex = getNextChildIndex(nextChildIndex, z);
            }
            if (nextChildIndex != -1) {
                return getFirstWindowIndexByChildIndex(nextChildIndex) + getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z);
            }
            if (i3 == 2) {
                return getFirstWindowIndex(z);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i2, Timeline.Period period, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), period, Boolean.valueOf(z)})) == null) {
            int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i2);
            int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
            getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i2 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z);
            period.windowIndex += firstWindowIndexByChildIndex;
            if (z) {
                period.uid = Pair.create(getChildUidByChildIndex(childIndexByPeriodIndex), period.uid);
            }
            return period;
        }
        return (Timeline.Period) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int childIndexByWindowIndex = getChildIndexByWindowIndex(i2);
            int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
            int previousWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getPreviousWindowIndex(i2 - firstWindowIndexByChildIndex, i3 == 2 ? 0 : i3, z);
            if (previousWindowIndex != -1) {
                return firstWindowIndexByChildIndex + previousWindowIndex;
            }
            int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z);
            while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
                previousChildIndex = getPreviousChildIndex(previousChildIndex, z);
            }
            if (previousChildIndex != -1) {
                return getFirstWindowIndexByChildIndex(previousChildIndex) + getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z);
            }
            if (i3 == 2) {
                return getLastWindowIndex(z);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public abstract Timeline getTimelineByChildIndex(int i2);

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i2, Timeline.Window window, boolean z, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), window, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
            int childIndexByWindowIndex = getChildIndexByWindowIndex(i2);
            int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
            int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
            getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i2 - firstWindowIndexByChildIndex, window, z, j2);
            window.firstPeriodIndex += firstPeriodIndexByChildIndex;
            window.lastPeriodIndex += firstPeriodIndexByChildIndex;
            return window;
        }
        return (Timeline.Window) invokeCommon.objValue;
    }
}
