package com.google.android.exoplayer2.extractor.mp4;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes7.dex */
public final class TrackSampleTable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;

    public TrackSampleTable(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, iArr, Integer.valueOf(i2), jArr2, iArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Assertions.checkArgument(iArr.length == jArr2.length);
        Assertions.checkArgument(jArr.length == jArr2.length);
        Assertions.checkArgument(iArr2.length == jArr2.length);
        this.offsets = jArr;
        this.sizes = iArr;
        this.maximumSize = i2;
        this.timestampsUs = jArr2;
        this.flags = iArr2;
        this.sampleCount = jArr.length;
    }

    public int getIndexOfEarlierOrEqualSynchronizationSample(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            for (int binarySearchFloor = Util.binarySearchFloor(this.timestampsUs, j2, true, false); binarySearchFloor >= 0; binarySearchFloor--) {
                if ((this.flags[binarySearchFloor] & 1) != 0) {
                    return binarySearchFloor;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public int getIndexOfLaterOrEqualSynchronizationSample(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            for (int binarySearchCeil = Util.binarySearchCeil(this.timestampsUs, j2, true, false); binarySearchCeil < this.timestampsUs.length; binarySearchCeil++) {
                if ((this.flags[binarySearchCeil] & 1) != 0) {
                    return binarySearchCeil;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }
}
