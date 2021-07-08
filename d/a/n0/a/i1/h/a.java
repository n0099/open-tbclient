package d.a.n0.a.i1.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.e0.d;
import d.a.n0.a.p.d.c1;
/* loaded from: classes7.dex */
public class a implements d.a.n0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c1 f45637a;

    /* renamed from: b  reason: collision with root package name */
    public String f45638b;

    /* renamed from: c  reason: collision with root package name */
    public c f45639c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45640d;

    /* renamed from: e  reason: collision with root package name */
    public Context f45641e;

    public a(Context context, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45641e = context;
        this.f45639c = cVar;
        this.f45638b = cVar.n;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f45638b)) {
            return;
        }
        d.a.n0.a.i1.b.a(this);
    }

    @Override // d.a.n0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45639c.f43478g : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45638b : (String) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45639c : (c) invokeV.objValue;
    }

    public c1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f45637a == null) {
                d.g("VrVideo", "create player");
                this.f45637a = d.a.n0.a.c1.a.s0().create();
            }
            return this.f45637a;
        }
        return (c1) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.f45639c;
            return cVar != null ? cVar.x : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            d.g("VrVideo", "Open Player " + cVar.n);
            c1 c1Var = this.f45637a;
            if (c1Var != null) {
                c1Var.e(cVar, this.f45641e);
            }
            this.f45639c = cVar;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            d.a("VrVideo", "update 接口");
            c1 c1Var = this.f45637a;
            if (c1Var != null) {
                c1Var.d(cVar, true);
            }
            this.f45639c = cVar;
        }
    }

    @Override // d.a.n0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // d.a.n0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                if (this.f45640d) {
                    e().resume();
                }
                e().b();
            } else if (this.f45637a != null) {
                this.f45640d = e().isPlaying();
                e().pause();
                e().c();
            }
        }
    }

    @Override // d.a.n0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.g("VrVideo", "onBackPressed");
            c1 c1Var = this.f45637a;
            return c1Var != null && c1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.g("VrVideo", MissionEvent.MESSAGE_DESTROY);
            c1 c1Var = this.f45637a;
            if (c1Var != null) {
                c1Var.stop();
                this.f45637a = null;
            }
            d.a.n0.a.i1.b.j(this);
        }
    }
}
