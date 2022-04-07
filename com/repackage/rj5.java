package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rj5 implements tj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pj5 a;

    public rj5(@NonNull pj5 pj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pj5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pj5Var;
    }

    @Override // com.repackage.tj5
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, downloadCacheKey, str, z) == null) {
            AdDownloadData b = lj5.d().b(downloadCacheKey);
            this.a.a(100);
            this.a.d(b.extra().getStatus());
        }
    }

    @Override // com.repackage.tj5
    public void b(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey) == null) {
            AdDownloadData b = lj5.d().b(downloadCacheKey);
            this.a.a(100);
            this.a.d(b.extra().getStatus());
        }
    }

    @Override // com.repackage.tj5
    public void c(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadCacheKey, i) == null) {
            this.a.d(lj5.d().b(downloadCacheKey).extra().getStatus());
        }
    }

    @Override // com.repackage.tj5
    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadCacheKey) == null) {
            AdDownloadData b = lj5.d().b(downloadCacheKey);
            this.a.a(100);
            this.a.d(b.extra().getStatus());
        }
    }

    @Override // com.repackage.tj5
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadCacheKey) == null) {
            this.a.d(lj5.d().b(downloadCacheKey).extra().getStatus());
        }
    }

    @Override // com.repackage.tj5
    public void f(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, downloadCacheKey, stopStatus) == null) {
            this.a.d(lj5.d().b(downloadCacheKey).extra().getStatus());
        }
    }

    @Override // com.repackage.tj5
    public void g(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, downloadCacheKey, i) == null) {
            this.a.a(lj5.d().b(downloadCacheKey).extra().getPercent());
        }
    }
}
