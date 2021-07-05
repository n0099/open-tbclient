package d.l.a.e.a.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.f.o;
import d.l.a.e.b.g.e;
/* loaded from: classes10.dex */
public class b extends o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f74582b;

    /* renamed from: c  reason: collision with root package name */
    public int f74583c;

    /* renamed from: d  reason: collision with root package name */
    public String f74584d;

    /* renamed from: e  reason: collision with root package name */
    public String f74585e;

    /* renamed from: f  reason: collision with root package name */
    public String f74586f;

    /* renamed from: g  reason: collision with root package name */
    public String f74587g;

    /* renamed from: h  reason: collision with root package name */
    public d.l.a.e.b.p.a f74588h;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.f74582b = context.getApplicationContext();
        } else {
            this.f74582b = e.n();
        }
        this.f74583c = i2;
        this.f74584d = str;
        this.f74585e = str2;
        this.f74586f = str3;
        this.f74587g = str4;
    }

    @Override // d.l.a.e.b.f.o, d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.b(downloadInfo);
    }

    @Override // d.l.a.e.b.f.o, d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.c(downloadInfo);
    }

    @Override // d.l.a.e.b.f.o, d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) || downloadInfo == null || this.f74582b == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.f(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            d.l.a.e.a.h.c.a(downloadInfo);
        }
    }

    @Override // d.l.a.e.b.f.o, d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.g(downloadInfo);
    }

    @Override // d.l.a.e.b.f.o, d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void h(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, downloadInfo, baseException) == null) || downloadInfo == null || this.f74582b == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.h(downloadInfo, baseException);
    }

    @Override // d.l.a.e.b.f.o, d.l.a.e.b.f.a, d.l.a.e.b.f.b
    public void l(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.l(downloadInfo);
    }

    @Override // d.l.a.e.b.f.o
    public d.l.a.e.b.p.a n() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f74588h == null && (context = this.f74582b) != null) {
                return new a(context, this.f74583c, this.f74584d, this.f74585e, this.f74586f, this.f74587g);
            }
            return this.f74588h;
        }
        return (d.l.a.e.b.p.a) invokeV.objValue;
    }

    public b(d.l.a.e.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74582b = e.n();
        this.f74588h = aVar;
    }
}
