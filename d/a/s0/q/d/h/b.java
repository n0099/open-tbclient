package d.a.s0.q.d.h;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.q.d.e;
/* loaded from: classes9.dex */
public class b implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.s0.q.d.g.a f64709a;

    public b(@NonNull d.a.s0.q.d.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64709a = aVar;
    }

    @Override // d.a.s0.q.d.h.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, downloadCacheKey, str, z) == null) {
            AdDownloadData b2 = e.c().b(downloadCacheKey);
            this.f64709a.g(100);
            this.f64709a.h(b2.extra().getStatus());
        }
    }

    @Override // d.a.s0.q.d.h.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey) == null) {
            AdDownloadData b2 = e.c().b(downloadCacheKey);
            this.f64709a.g(100);
            this.f64709a.h(b2.extra().getStatus());
        }
    }

    @Override // d.a.s0.q.d.h.d
    public void c(@NonNull DownloadCacheKey downloadCacheKey, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadCacheKey, i2) == null) {
            this.f64709a.h(e.c().b(downloadCacheKey).extra().getStatus());
        }
    }

    @Override // d.a.s0.q.d.h.d
    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadCacheKey) == null) {
            AdDownloadData b2 = e.c().b(downloadCacheKey);
            this.f64709a.g(100);
            this.f64709a.h(b2.extra().getStatus());
        }
    }

    @Override // d.a.s0.q.d.h.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadCacheKey) == null) {
            this.f64709a.h(e.c().b(downloadCacheKey).extra().getStatus());
        }
    }

    @Override // d.a.s0.q.d.h.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, downloadCacheKey, stopStatus) == null) {
            this.f64709a.h(e.c().b(downloadCacheKey).extra().getStatus());
        }
    }

    @Override // d.a.s0.q.d.h.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, downloadCacheKey, i2) == null) {
            this.f64709a.g(e.c().b(downloadCacheKey).extra().getPercent());
        }
    }
}
