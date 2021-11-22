package com.ss.android.socialbase.downloader.impls;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b implements com.ss.android.socialbase.downloader.downloader.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int a(int i2, com.ss.android.socialbase.downloader.network.l lVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, lVar)) == null) {
            if (lVar.ordinal() <= com.ss.android.socialbase.downloader.network.l.f70631b.ordinal()) {
                return 1;
            }
            return lVar == com.ss.android.socialbase.downloader.network.l.f70632c ? i2 - 1 : i2;
        }
        return invokeIL.intValue;
    }
}
