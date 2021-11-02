package com.kwad.sdk.core.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.utils.w;
/* loaded from: classes2.dex */
public class b extends com.ksad.download.c {
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

    private String g(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, downloadTask)) == null) ? w.a(downloadTask.getUrl()) : (String) invokeL.objValue;
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadTask) == null) {
        }
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, i2, i3) == null) {
        }
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask, String str, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{downloadTask, str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask, Throwable th) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, downloadTask, th) == null) {
            if (th == null || th.getStackTrace().length <= 0) {
                str = "";
            } else {
                str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
            }
            c.a(g(downloadTask), 0, str);
        }
    }

    @Override // com.ksad.download.c
    public void b(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadTask) == null) {
            c.a(g(downloadTask), downloadTask.getTargetFilePath());
        }
    }

    @Override // com.ksad.download.c
    public void b(DownloadTask downloadTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, downloadTask, i2, i3) == null) {
            c.a(g(downloadTask), i3 > 0 ? (int) ((i2 * 100.0f) / i3) : 0, i2, i3);
        }
    }

    @Override // com.ksad.download.c
    public void c(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, downloadTask) == null) && downloadTask.getSmallFileSoFarBytes() == 0) {
            c.a(g(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public void c(DownloadTask downloadTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, downloadTask, i2, i3) == null) {
            c.b(g(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public void d(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadTask) == null) {
        }
    }

    @Override // com.ksad.download.c
    public void d(DownloadTask downloadTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, downloadTask, i2, i3) == null) {
            c.c(g(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public void e(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, downloadTask) == null) {
            c.d(g(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public void f(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadTask) == null) {
            c.e(g(downloadTask));
        }
    }
}
