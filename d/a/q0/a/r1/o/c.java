package d.a.q0.a.r1.o;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class c implements d.a.q0.a.r1.o.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f50477d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f50478a;

    /* renamed from: b  reason: collision with root package name */
    public long f50479b;

    /* renamed from: c  reason: collision with root package name */
    public long f50480c;

    /* loaded from: classes8.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f50481e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50481e = cVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f50481e.l()) {
                    this.f50481e.m();
                    return true;
                }
                this.f50481e.n();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019386959, "Ld/a/q0/a/r1/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1019386959, "Ld/a/q0/a/r1/o/c;");
                return;
            }
        }
        f50477d = k.f49133a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (l()) {
            this.f50478a = new b();
        }
    }

    @Override // d.a.q0.a.r1.o.a
    public void a(long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && l() && (bVar = this.f50478a) != null) {
            bVar.f(j - this.f50479b);
        }
    }

    @Override // d.a.q0.a.r1.k.e
    public void b(long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && l() && (bVar = this.f50478a) != null) {
            this.f50479b = j;
            bVar.e();
        }
    }

    @Override // d.a.q0.a.r1.k.e
    public void c(long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && l() && (bVar = this.f50478a) != null) {
            this.f50480c = j;
            bVar.l(this.f50479b, j);
            this.f50478a.a();
        }
    }

    @Override // d.a.q0.a.r1.o.a
    public void e(long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048579, this, j) == null) && l() && (bVar = this.f50478a) != null) {
            bVar.h(j - this.f50479b);
        }
    }

    @Override // d.a.q0.a.r1.o.a
    public void f(long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && l() && (bVar = this.f50478a) != null) {
            bVar.i(j - this.f50479b);
        }
    }

    @Override // d.a.q0.a.r1.o.a
    public void g(long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && l() && (bVar = this.f50478a) != null) {
            bVar.g(j - this.f50479b);
        }
    }

    @Override // d.a.q0.a.r1.o.a
    public void h(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && f50477d && view != null) {
            view.setOnLongClickListener(new a(this));
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (f50477d) {
                return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
            b bVar = this.f50478a;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
            if (this.f50478a == null) {
                this.f50478a = new b();
            }
            this.f50478a.k();
        }
    }
}
