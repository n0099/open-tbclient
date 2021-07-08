package d.l.a.e.b.i;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.IOException;
/* loaded from: classes8.dex */
public class k implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final i f71855a;

    /* renamed from: b  reason: collision with root package name */
    public final d.l.a.e.b.n.c f71856b;

    /* renamed from: c  reason: collision with root package name */
    public final e f71857c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, bVar, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71855a = iVar;
        this.f71856b = c(downloadInfo, iVar);
        this.f71857c = new h(bVar, this);
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71857c : (e) invokeV.objValue;
    }

    @Override // d.l.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f71856b.a(aVar.f71811a, 0, aVar.f71813c);
            this.f71855a.g(aVar.f71813c);
        }
    }

    public final d.l.a.e.b.n.c c(DownloadInfo downloadInfo, i iVar) throws BaseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, iVar)) == null) {
            d.l.a.e.b.n.c f2 = d.l.a.e.b.l.f.f(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), d.l.a.e.b.j.a.d(downloadInfo.getId()).b("flush_buffer_size_byte", -1));
            try {
                f2.a(iVar.l());
                return f2;
            } catch (IOException e2) {
                throw new BaseException((int) RevenueServerConst.ChargeCurrencyHistoryRequest, e2);
            }
        }
        return (d.l.a.e.b.n.c) invokeLL.objValue;
    }

    public void d() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f71856b.n();
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f71856b.r();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.l.a.e.b.l.f.E(this.f71856b);
        }
    }

    public i g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f71855a : (i) invokeV.objValue;
    }
}
