package d.l.a.e.b.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes10.dex */
public abstract class o extends a implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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

    @Override // d.l.a.e.b.f.u
    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        o(11, downloadInfo, null, true);
    }

    @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            super.b(downloadInfo);
            o(-2, downloadInfo, null, false);
        }
    }

    @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
            super.c(downloadInfo);
            o(2, downloadInfo, null, false);
        }
    }

    @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) {
            super.f(downloadInfo);
            o(-3, downloadInfo, null, false);
        }
    }

    @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
            super.g(downloadInfo);
            q(downloadInfo);
        }
    }

    @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void h(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, downloadInfo, baseException) == null) {
            super.h(downloadInfo, baseException);
            o(-1, downloadInfo, baseException, false);
        }
    }

    @Override // d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void l(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) {
            super.l(downloadInfo);
            p(downloadInfo);
            o(1, downloadInfo, null, true);
        }
    }

    public abstract d.l.a.e.b.p.a n();

    public final void o(int i2, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), downloadInfo, baseException, Boolean.valueOf(z)}) == null) || downloadInfo == null || !downloadInfo.canShowNotification() || i2 == 4) {
            return;
        }
        d.l.a.e.b.p.a l = d.l.a.e.b.p.b.a().l(downloadInfo.getId());
        if (l == null) {
            l = n();
        }
        l.k(downloadInfo.getTotalBytes());
        if (i2 == -3) {
            l.d(downloadInfo.getTotalBytes());
        } else {
            l.d(downloadInfo.getCurBytes());
        }
        l.b(i2, baseException, z);
    }

    public final void p(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, downloadInfo) == null) && downloadInfo != null && downloadInfo.canShowNotification()) {
            d.l.a.e.b.p.a l = d.l.a.e.b.p.b.a().l(downloadInfo.getId());
            if (l == null) {
                d.l.a.e.b.p.b.a().e(n());
                return;
            }
            l.h(downloadInfo);
        }
    }

    public final void q(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, downloadInfo) == null) && downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            d.l.a.e.b.p.a l = d.l.a.e.b.p.b.a().l(downloadInfo.getId());
            if (l == null) {
                l = n();
            }
            l.e(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }
}
