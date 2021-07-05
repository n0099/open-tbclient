package d.a.s0.q.d.h;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.q.d.e;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f64704a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.s0.q.d.c f64705b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f64706c;

    /* renamed from: d  reason: collision with root package name */
    public int f64707d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f64708e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2032450551, "Ld/a/s0/q/d/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2032450551, "Ld/a/s0/q/d/h/a;");
        }
    }

    public a(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadCacheKey};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64704a = new Object();
        this.f64707d = 0;
        this.f64708e = new HashSet();
        this.f64706c = downloadCacheKey;
        this.f64705b = new d.a.s0.q.d.c();
    }

    @Override // d.a.s0.q.d.h.c
    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || this.f64706c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f64706c);
        b2.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f64708e) {
            dVar.c(this.f64706c, b2.getPercent());
        }
    }

    @Override // d.a.s0.q.d.h.c
    public void b(String str, StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) || this.f64706c == null) {
            return;
        }
        e.c().b(this.f64706c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f64708e) {
            dVar.f(this.f64706c, stopStatus);
        }
    }

    @Override // d.a.s0.q.d.h.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f64706c == null) {
            return;
        }
        e.c().b(this.f64706c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f64708e) {
            dVar.e(this.f64706c);
        }
    }

    @Override // d.a.s0.q.d.h.c
    public void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) || this.f64706c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f64706c);
        b2.extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f64708e) {
            dVar.g(this.f64706c, b2.getPercent());
        }
    }

    public boolean e(d dVar) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            synchronized (this.f64704a) {
                add = this.f64708e.add(dVar);
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64708e.isEmpty() : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f64706c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f64706c);
        this.f64705b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f64706c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f64708e) {
            dVar.b(this.f64706c);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f64706c == null) {
            return;
        }
        e.c().b(this.f64706c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f64708e) {
            dVar.d(this.f64706c);
        }
    }

    public boolean i(d dVar) {
        InterceptResult invokeL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
            synchronized (this.f64704a) {
                remove = this.f64708e.remove(dVar);
            }
            return remove;
        }
        return invokeL.booleanValue;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, adDownloadData}) == null) {
            this.f64705b.b(i2, str, str2, adDownloadData);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f64707d = i2;
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f64707d : invokeV.intValue;
    }

    @Override // d.a.s0.q.d.h.c
    public void onSuccess(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || this.f64706c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f64706c);
        this.f64705b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f64706c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        e.c().b(this.f64706c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f64708e) {
            dVar.a(this.f64706c, str2, false);
        }
    }
}
