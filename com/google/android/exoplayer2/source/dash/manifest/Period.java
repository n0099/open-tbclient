package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class Period {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<AdaptationSet> adaptationSets;
    public final String id;
    public final long startMs;

    public Period(String str, long j, List<AdaptationSet> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = str;
        this.startMs = j;
        this.adaptationSets = Collections.unmodifiableList(list);
    }

    public int getAdaptationSetIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int size = this.adaptationSets.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.adaptationSets.get(i2).type == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }
}
