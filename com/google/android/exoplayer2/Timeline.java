package com.google.android.exoplayer2;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes6.dex */
public abstract class Timeline {
    public static /* synthetic */ Interceptable $ic;
    public static final Timeline EMPTY;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class Period {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] adCounts;
        public long[][] adDurationsUs;
        public long[] adGroupTimesUs;
        public long adResumePositionUs;
        public int[] adsLoadedCounts;
        public int[] adsPlayedCounts;
        public long durationUs;
        public Object id;
        public long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public Period() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int getAdCountInAdGroup(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.adCounts[i] : invokeI.intValue;
        }

        public long getAdDurationUs(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
                long[][] jArr = this.adDurationsUs;
                return i2 >= jArr[i].length ? C.TIME_UNSET : jArr[i][i2];
            }
            return invokeII.longValue;
        }

        public int getAdGroupCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long[] jArr = this.adGroupTimesUs;
                if (jArr == null) {
                    return 0;
                }
                return jArr.length;
            }
            return invokeV.intValue;
        }

        public int getAdGroupIndexAfterPositionUs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (this.adGroupTimesUs == null) {
                    return -1;
                }
                int i = 0;
                while (true) {
                    long[] jArr = this.adGroupTimesUs;
                    if (i >= jArr.length || jArr[i] == Long.MIN_VALUE || (j < jArr[i] && !hasPlayedAdGroup(i))) {
                        break;
                    }
                    i++;
                }
                if (i < this.adGroupTimesUs.length) {
                    return i;
                }
                return -1;
            }
            return invokeJ.intValue;
        }

        public int getAdGroupIndexForPositionUs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                long[] jArr = this.adGroupTimesUs;
                if (jArr == null) {
                    return -1;
                }
                int length = jArr.length - 1;
                while (length >= 0) {
                    long[] jArr2 = this.adGroupTimesUs;
                    if (jArr2[length] != Long.MIN_VALUE && jArr2[length] <= j) {
                        break;
                    }
                    length--;
                }
                if (length < 0 || hasPlayedAdGroup(length)) {
                    return -1;
                }
                return length;
            }
            return invokeJ.intValue;
        }

        public long getAdGroupTimeUs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.adGroupTimesUs[i] : invokeI.longValue;
        }

        public long getAdResumePositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.adResumePositionUs : invokeV.longValue;
        }

        public long getDurationMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? C.usToMs(this.durationUs) : invokeV.longValue;
        }

        public long getDurationUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.durationUs : invokeV.longValue;
        }

        public int getPlayedAdCount(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? this.adsPlayedCounts[i] : invokeI.intValue;
        }

        public long getPositionInWindowMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? C.usToMs(this.positionInWindowUs) : invokeV.longValue;
        }

        public long getPositionInWindowUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.positionInWindowUs : invokeV.longValue;
        }

        public boolean hasPlayedAdGroup(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                int[] iArr = this.adCounts;
                return iArr[i] != -1 && this.adsPlayedCounts[i] == iArr[i];
            }
            return invokeI.booleanValue;
        }

        public boolean isAdAvailable(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) ? i2 < this.adsLoadedCounts[i] : invokeII.booleanValue;
        }

        public Period set(Object obj, Object obj2, int i, long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{obj, obj2, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) ? set(obj, obj2, i, j, j2, null, null, null, null, null, C.TIME_UNSET) : (Period) invokeCommon.objValue;
        }

        public Period set(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{obj, obj2, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), jArr, iArr, iArr2, iArr3, jArr2, Long.valueOf(j3)})) == null) {
                this.id = obj;
                this.uid = obj2;
                this.windowIndex = i;
                this.durationUs = j;
                this.positionInWindowUs = j2;
                this.adGroupTimesUs = jArr;
                this.adCounts = iArr;
                this.adsLoadedCounts = iArr2;
                this.adsPlayedCounts = iArr3;
                this.adDurationsUs = jArr2;
                this.adResumePositionUs = j3;
                return this;
            }
            return (Period) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Window {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public Object id;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public long windowStartTimeMs;

        public Window() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public long getDefaultPositionMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? C.usToMs(this.defaultPositionUs) : invokeV.longValue;
        }

        public long getDefaultPositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.defaultPositionUs : invokeV.longValue;
        }

        public long getDurationMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? C.usToMs(this.durationUs) : invokeV.longValue;
        }

        public long getDurationUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.durationUs : invokeV.longValue;
        }

        public long getPositionInFirstPeriodMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? C.usToMs(this.positionInFirstPeriodUs) : invokeV.longValue;
        }

        public long getPositionInFirstPeriodUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.positionInFirstPeriodUs : invokeV.longValue;
        }

        public Window set(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{obj, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j5)})) == null) {
                this.id = obj;
                this.presentationStartTimeMs = j;
                this.windowStartTimeMs = j2;
                this.isSeekable = z;
                this.isDynamic = z2;
                this.defaultPositionUs = j3;
                this.durationUs = j4;
                this.firstPeriodIndex = i;
                this.lastPeriodIndex = i2;
                this.positionInFirstPeriodUs = j5;
                return this;
            }
            return (Window) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1477642596, "Lcom/google/android/exoplayer2/Timeline;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1477642596, "Lcom/google/android/exoplayer2/Timeline;");
                return;
            }
        }
        EMPTY = new Timeline() { // from class: com.google.android.exoplayer2.Timeline.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.exoplayer2.Timeline
            public int getIndexOfPeriod(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                    return -1;
                }
                return invokeL.intValue;
            }

            @Override // com.google.android.exoplayer2.Timeline
            public Period getPeriod(int i, Period period, boolean z) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), period, Boolean.valueOf(z)})) == null) {
                    throw new IndexOutOfBoundsException();
                }
                return (Period) invokeCommon.objValue;
            }

            @Override // com.google.android.exoplayer2.Timeline
            public int getPeriodCount() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.google.android.exoplayer2.Timeline
            public Window getWindow(int i, Window window, boolean z, long j) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                    throw new IndexOutOfBoundsException();
                }
                return (Window) invokeCommon.objValue;
            }

            @Override // com.google.android.exoplayer2.Timeline
            public int getWindowCount() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }
        };
    }

    public Timeline() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getFirstWindowIndex(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? isEmpty() ? -1 : 0 : invokeZ.intValue;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (isEmpty()) {
                return -1;
            }
            return getWindowCount() - 1;
        }
        return invokeZ.intValue;
    }

    public final int getNextPeriodIndex(int i, Period period, Window window, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), period, window, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = getPeriod(i, period).windowIndex;
            if (getWindow(i3, window).lastPeriodIndex == i) {
                int nextWindowIndex = getNextWindowIndex(i3, i2, z);
                if (nextWindowIndex == -1) {
                    return -1;
                }
                return getWindow(nextWindowIndex, window).firstPeriodIndex;
            }
            return i + 1;
        }
        return invokeCommon.intValue;
    }

    public int getNextWindowIndex(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 == 0) {
                if (i == getLastWindowIndex(z)) {
                    return -1;
                }
                return i + 1;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    return i == getLastWindowIndex(z) ? getFirstWindowIndex(z) : i + 1;
                }
                throw new IllegalStateException();
            } else {
                return i;
            }
        }
        return invokeCommon.intValue;
    }

    public final Period getPeriod(int i, Period period) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, period)) == null) ? getPeriod(i, period, false) : (Period) invokeIL.objValue;
    }

    public abstract Period getPeriod(int i, Period period, boolean z);

    public abstract int getPeriodCount();

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{window, period, Integer.valueOf(i), Long.valueOf(j)})) == null) ? getPeriodPosition(window, period, i, j, 0L) : (Pair) invokeCommon.objValue;
    }

    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 == 0) {
                if (i == getFirstWindowIndex(z)) {
                    return -1;
                }
                return i - 1;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    return i == getFirstWindowIndex(z) ? getLastWindowIndex(z) : i - 1;
                }
                throw new IllegalStateException();
            } else {
                return i;
            }
        }
        return invokeCommon.intValue;
    }

    public final Window getWindow(int i, Window window) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, window)) == null) ? getWindow(i, window, false) : (Window) invokeIL.objValue;
    }

    public abstract Window getWindow(int i, Window window, boolean z, long j);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getWindowCount() == 0 : invokeV.booleanValue;
    }

    public final boolean isLastPeriod(int i, Period period, Window window, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), period, window, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? getNextPeriodIndex(i, period, window, i2, z) == -1 : invokeCommon.booleanValue;
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{window, period, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Assertions.checkIndex(i, 0, getWindowCount());
            getWindow(i, window, false, j2);
            if (j == C.TIME_UNSET) {
                j = window.getDefaultPositionUs();
                if (j == C.TIME_UNSET) {
                    return null;
                }
            }
            int i2 = window.firstPeriodIndex;
            long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j;
            long durationUs = getPeriod(i2, period).getDurationUs();
            while (durationUs != C.TIME_UNSET && positionInFirstPeriodUs >= durationUs && i2 < window.lastPeriodIndex) {
                positionInFirstPeriodUs -= durationUs;
                i2++;
                durationUs = getPeriod(i2, period).getDurationUs();
            }
            return Pair.create(Integer.valueOf(i2), Long.valueOf(positionInFirstPeriodUs));
        }
        return (Pair) invokeCommon.objValue;
    }

    public final Window getWindow(int i, Window window, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z)})) == null) ? getWindow(i, window, z, 0L) : (Window) invokeCommon.objValue;
    }
}
