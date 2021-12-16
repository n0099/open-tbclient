package com.google.android.exoplayer2.source;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class MergingMediaSource$IllegalMergeException extends IOException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REASON_PERIOD_COUNT_MISMATCH = 1;
    public static final int REASON_WINDOWS_ARE_DYNAMIC = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int reason;

    public MergingMediaSource$IllegalMergeException(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reason = i2;
    }
}
