package com.google.android.exoplayer2.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes5.dex */
public final class SinglePeriodTimeline extends Timeline {
    public static /* synthetic */ Interceptable $ic;
    public static final Object ID;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isDynamic;
    public final boolean isSeekable;
    public final long periodDurationUs;
    public final long presentationStartTimeMs;
    public final long windowDefaultStartPositionUs;
    public final long windowDurationUs;
    public final long windowPositionInPeriodUs;
    public final long windowStartTimeMs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1479553797, "Lcom/google/android/exoplayer2/source/SinglePeriodTimeline;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1479553797, "Lcom/google/android/exoplayer2/source/SinglePeriodTimeline;");
                return;
            }
        }
        ID = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SinglePeriodTimeline(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? ID.equals(obj) ? 0 : -1 : invokeL.intValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), period, Boolean.valueOf(z)})) == null) {
            Assertions.checkIndex(i, 0, 1);
            Object obj = z ? ID : null;
            return period.set(obj, obj, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
        }
        return (Timeline.Period) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            Assertions.checkIndex(i, 0, 1);
            Object obj = z ? ID : null;
            long j2 = this.windowDefaultStartPositionUs;
            if (this.isDynamic) {
                j2 += j;
                if (j2 > this.windowDurationUs) {
                    j2 = C.TIME_UNSET;
                }
            }
            return window.set(obj, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, this.isDynamic, j2, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
        }
        return (Timeline.Window) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(C.TIME_UNSET, C.TIME_UNSET, j, j2, j3, j4, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), ((Boolean) objArr2[6]).booleanValue(), ((Boolean) objArr2[7]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.presentationStartTimeMs = j;
        this.windowStartTimeMs = j2;
        this.periodDurationUs = j3;
        this.windowDurationUs = j4;
        this.windowPositionInPeriodUs = j5;
        this.windowDefaultStartPositionUs = j6;
        this.isSeekable = z;
        this.isDynamic = z2;
    }
}
