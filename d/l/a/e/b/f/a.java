package d.l.a.e.b.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes10.dex */
public abstract class a implements b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f74691a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1799569218, "Ld/l/a/e/b/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1799569218, "Ld/l/a/e/b/f/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.l.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onPause -- " + downloadInfo.getName());
        }
    }

    @Override // d.l.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onStart -- " + downloadInfo.getName());
        }
    }

    @Override // d.l.a.e.b.f.b
    public void d(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onFirstStart -- " + downloadInfo.getName());
        }
    }

    @Override // d.l.a.e.b.f.b
    public void e(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onCanceled -- " + downloadInfo.getName());
        }
    }

    @Override // d.l.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
        }
    }

    @Override // d.l.a.e.b.f.b
    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) || !d.l.a.e.b.c.a.e() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        d.l.a.e.b.c.a.g(f74691a, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((((float) downloadInfo.getCurBytes()) / ((float) downloadInfo.getTotalBytes())) * 100.0f)));
    }

    @Override // d.l.a.e.b.f.b
    public void h(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, downloadInfo, baseException) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            d.l.a.e.b.c.a.g(str, String.format("onFailed on %s because of : %s", objArr));
        }
    }

    @Override // d.l.a.e.b.f.b
    public void i(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, downloadInfo, baseException) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            d.l.a.e.b.c.a.g(str, String.format("onRetry on %s because of : %s", objArr));
        }
    }

    @Override // d.l.a.e.b.f.b
    public void j(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo, baseException) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            d.l.a.e.b.c.a.g(str, String.format("onRetryDelay on %s because of : %s", objArr));
        }
    }

    @Override // d.l.a.e.b.f.b
    public void k(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onFirstSuccess -- " + downloadInfo.getName());
        }
    }

    @Override // d.l.a.e.b.f.b
    public void l(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onPrepare -- " + downloadInfo.getName());
        }
    }

    public void m(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, downloadInfo) == null) && d.l.a.e.b.c.a.e() && downloadInfo != null) {
            String str = f74691a;
            d.l.a.e.b.c.a.g(str, " onIntercept -- " + downloadInfo.getName());
        }
    }
}
