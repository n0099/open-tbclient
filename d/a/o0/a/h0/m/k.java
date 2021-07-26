package d.a.o0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.m.j;
import d.a.o0.a.v2.j0;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class k<T extends j> extends d.a.o0.n.f.b<d.a.o0.n.h.g> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45505f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final T f45506e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447430818, "Ld/a/o0/a/h0/m/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447430818, "Ld/a/o0/a/h0/m/k;");
                return;
            }
        }
        f45505f = d.a.o0.a.k.f46335a;
    }

    public k(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45506e = t;
    }

    @Override // d.a.o0.n.f.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.g() : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.o0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
            Bundle bundle2 = new Bundle();
            if (set.contains("event_performance_ubc")) {
                this.f45506e.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
                set.remove("event_performance_ubc");
            }
            return bundle2;
        }
        return (Bundle) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.f.c
    /* renamed from: o */
    public String d(d.a.o0.n.h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gVar)) == null) {
            if (TextUtils.isEmpty(gVar.o)) {
                gVar.o = l();
            }
            int i2 = gVar.f51141h;
            if (i2 == 0) {
                return d.a.o0.a.h0.m.r.b.b(gVar.o, String.valueOf(gVar.f51142i));
            }
            if (i2 == 1) {
                return d.a.o0.a.h0.m.r.b.d(gVar.o, String.valueOf(gVar.f51142i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull d.a.o0.n.h.g gVar, @Nullable d.a.o0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, gVar, aVar) == null) {
        }
    }

    @CallSuper
    public void q(d.a.o0.n.h.g gVar, d.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar, aVar) == null) {
            super.e(gVar, aVar);
            d.a.o0.a.e0.d.h("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + gVar.f51134a);
            d.a.o0.t.d.L(gVar.f51134a);
            if (f45505f) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + gVar + ", error=" + aVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
    /* renamed from: r */
    public final void i(d.a.o0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            super.i(gVar);
            p(gVar, t(gVar));
            if (f45505f) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + gVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
    /* renamed from: s */
    public void c(d.a.o0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            super.c(gVar);
            if (f45505f) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + gVar);
            }
        }
    }

    public final d.a.o0.a.q2.a t(d.a.o0.n.h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, gVar)) == null) {
            if (!j0.a(new File(gVar.f51134a), gVar.m)) {
                d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                aVar.j(12L);
                aVar.b(2300L);
                aVar.c("分包签名校验失败");
                return aVar;
            } else if (d.a.o0.a.h0.m.r.b.g(gVar)) {
                return null;
            } else {
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(12L);
                aVar2.b(2320L);
                aVar2.c("分包解压失败");
                return aVar2;
            }
        }
        return (d.a.o0.a.q2.a) invokeL.objValue;
    }
}
