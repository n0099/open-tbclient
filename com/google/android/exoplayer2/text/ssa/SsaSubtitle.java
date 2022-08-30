package com.google.android.exoplayer2.text.ssa;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class SsaSubtitle implements Subtitle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long[] cueTimesUs;
    public final Cue[] cues;

    public SsaSubtitle(Cue[] cueArr, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cueArr, jArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            int binarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j, true, false);
            if (binarySearchFloor != -1) {
                Cue[] cueArr = this.cues;
                if (cueArr[binarySearchFloor] != null) {
                    return Collections.singletonList(cueArr[binarySearchFloor]);
                }
            }
            return Collections.emptyList();
        }
        return (List) invokeJ.objValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Assertions.checkArgument(i >= 0);
            Assertions.checkArgument(i < this.cueTimesUs.length);
            return this.cueTimesUs[i];
        }
        return invokeI.longValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cueTimesUs.length : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            int binarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j, false, false);
            if (binarySearchCeil < this.cueTimesUs.length) {
                return binarySearchCeil;
            }
            return -1;
        }
        return invokeJ.intValue;
    }
}
