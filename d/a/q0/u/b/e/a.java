package d.a.q0.u.b.e;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.p.d.k0;
import d.a.p0.m0.d;
import d.a.p0.m0.e;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes8.dex */
public class a implements k0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f63093b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f63094a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-344654954, "Ld/a/q0/u/b/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-344654954, "Ld/a/q0/u/b/e/a;");
                return;
            }
        }
        f63093b = k.f46335a;
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

    @Override // d.a.o0.a.p.d.k0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (f63093b) {
                Log.e("DefaultSwanAppLifecycle", "onAppBackground");
            }
            long l = d.a.p0.s.d0.b.j().l("smart_app_tid", 0L);
            String p = d.a.p0.s.d0.b.j().p("smart_app_id", "");
            String p2 = d.a.p0.s.d0.b.j().p("smart_app_name", "");
            if (this.f63094a == 0 || l == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f63094a;
            d dVar = new d();
            dVar.v(currentTimeMillis);
            dVar.p(g());
            dVar.y(l);
            dVar.f52770i = p;
            dVar.j = p2;
            dVar.u(h());
            e.b().h(true);
            e.b().i(TbadkApplication.getInst().getApplicationContext(), dVar, i());
            d.a.p0.s.d0.b.j().w("smart_app_tid", 0L);
        }
    }

    @Override // d.a.o0.a.p.d.k0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // d.a.o0.a.p.d.k0
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f63093b) {
                Log.e("DefaultSwanAppLifecycle", "onAppForeground" + d.a.o0.a.a2.e.i().f43885f);
            }
            this.f63094a = System.currentTimeMillis();
        }
    }

    @Override // d.a.o0.a.p.d.k0
    public void d(@NonNull SwanAppActivity swanAppActivity, int i2, @Nullable d.a.o0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i2, bVar) == null) {
            if (f63093b) {
                Log.e("DefaultSwanAppLifecycle", "onAppExit");
            }
            if (d.a.p0.s.d0.b.j().g("key_ai_app_guide_display", true)) {
                d.a.p0.s.d0.b.j().t("key_ai_app_guide_display", false);
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra(DealIntentService.KEY_CLASS, 38);
                swanAppActivity.startService(intent);
            }
        }
    }

    @Override // d.a.o0.a.p.d.k0
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // d.a.o0.a.p.d.k0
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a061" : (String) invokeV.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("a001");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public d.a.p0.m0.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (d.a.p0.m0.b) invokeV.objValue;
    }
}
