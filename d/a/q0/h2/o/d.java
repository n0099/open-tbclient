package d.a.q0.h2.o;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.h2.h.e f58307a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h2.h.e f58308b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58309c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<b2> f58310d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f58311e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58312f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<d.a.q0.h2.h.e> f58313g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<b2> f58314h;

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<b2> f58315i;
    public MutableLiveData<Boolean> j;
    public MutableLiveData<Boolean> k;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58310d = new MutableLiveData<>();
        this.f58313g = new LinkedList<>();
        this.f58314h = new MutableLiveData<>();
        this.f58315i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        new MutableLiveData();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (MutableLiveData) invokeV.objValue;
    }

    public d.a.q0.h2.h.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58308b : (d.a.q0.h2.h.e) invokeV.objValue;
    }

    public d.a.q0.h2.h.e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58307a : (d.a.q0.h2.h.e) invokeV.objValue;
    }

    public MutableLiveData<Boolean> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<b2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58315i : (MutableLiveData) invokeV.objValue;
    }

    public Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58311e : (Rect) invokeV.objValue;
    }

    public MutableLiveData<b2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58314h : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<b2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58310d : (MutableLiveData) invokeV.objValue;
    }

    public LinkedList<d.a.q0.h2.h.e> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f58313g : (LinkedList) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f58309c : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f58312f : invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (MutableLiveData) invokeV.objValue;
    }

    public void n(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f58308b = eVar;
            if (eVar != null) {
                this.f58310d.setValue(eVar.N());
                if (ListUtils.isEmpty(eVar.f())) {
                    return;
                }
                u(eVar.f().get(0));
            }
        }
    }

    public void o(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.f58307a = eVar;
            n(eVar);
            this.f58314h.setValue(null);
            this.f58310d.setValue(eVar.N());
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f58309c = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.j.setValue(Boolean.valueOf(z));
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.l.setValue(Boolean.valueOf(z));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.k.postValue(Boolean.valueOf(z));
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f58312f = z;
        }
    }

    public void u(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, b2Var) == null) {
            this.f58315i.setValue(b2Var);
        }
    }

    public void v(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rect) == null) {
            this.f58311e = rect;
        }
    }

    public void w(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, b2Var) == null) {
            this.f58314h.setValue(b2Var);
        }
    }
}
