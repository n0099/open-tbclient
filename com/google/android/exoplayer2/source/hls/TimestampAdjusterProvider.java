package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.TimestampAdjuster;
/* loaded from: classes7.dex */
public final class TimestampAdjusterProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray timestampAdjusters;

    public TimestampAdjusterProvider() {
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
        this.timestampAdjusters = new SparseArray();
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.timestampAdjusters.clear();
        }
    }

    public TimestampAdjuster getAdjuster(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            TimestampAdjuster timestampAdjuster = (TimestampAdjuster) this.timestampAdjusters.get(i);
            if (timestampAdjuster == null) {
                TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(Long.MAX_VALUE);
                this.timestampAdjusters.put(i, timestampAdjuster2);
                return timestampAdjuster2;
            }
            return timestampAdjuster;
        }
        return (TimestampAdjuster) invokeI.objValue;
    }
}
