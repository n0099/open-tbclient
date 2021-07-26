package d.a.o0.h.o0;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.p.b.a.n;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.o0.a.w2.c> f50673a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f50674b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50675c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50676d;

    public c(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50673a = new ArrayList<>();
        this.f50676d = false;
        this.f50674b = frameLayout;
    }

    @Override // d.a.o0.a.p.b.a.n
    public boolean a(View view, d.a.o0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, aVar)) == null) {
            if (d(view)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.i(), aVar.f());
                layoutParams.leftMargin = aVar.g();
                layoutParams.topMargin = aVar.h();
                this.f50674b.updateViewLayout(view, layoutParams);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.o0.a.p.b.a.n
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50675c : invokeV.booleanValue;
    }

    @Override // d.a.o0.a.p.b.a.n
    public boolean c(View view, d.a.o0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar)) == null) {
            if (view == null || aVar == null) {
                return false;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.i(), aVar.f());
            layoutParams.leftMargin = aVar.g();
            layoutParams.topMargin = aVar.h();
            this.f50674b.addView(view, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.o0.a.p.b.a.n
    public boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            if (view == null) {
                return false;
            }
            ViewParent parent = view.getParent();
            FrameLayout frameLayout = this.f50674b;
            return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.o0.a.p.b.a.n
    public synchronized void e(d.a.o0.a.w2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return;
                }
                if (!this.f50673a.contains(cVar)) {
                    this.f50673a.add(cVar);
                }
            }
        }
    }

    @Override // d.a.o0.a.p.b.a.n
    public synchronized void f(d.a.o0.a.w2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return;
                }
                this.f50673a.remove(cVar);
            }
        }
    }

    @Override // d.a.o0.a.p.b.a.n
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f50676d = z;
        }
    }

    @Override // d.a.o0.a.p.b.a.n
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f50674b.getContext() : (Context) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.b.a.n
    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f50674b : (FrameLayout) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.b.a.n
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f50676d : invokeV.booleanValue;
    }

    public final synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f50673a.clear();
            }
        }
    }

    public final synchronized d.a.o0.a.w2.c[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.f50673a.isEmpty()) {
                    return null;
                }
                d.a.o0.a.w2.c[] cVarArr = new d.a.o0.a.w2.c[this.f50673a.size()];
                this.f50673a.toArray(cVarArr);
                return cVarArr;
            }
        }
        return (d.a.o0.a.w2.c[]) invokeV.objValue;
    }

    public void k() {
        d.a.o0.a.w2.c[] j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (j = j()) == null) {
            return;
        }
        for (d.a.o0.a.w2.c cVar : j) {
            cVar.f();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.o0.a.w2.c[] j = j();
            if (j != null) {
                for (d.a.o0.a.w2.c cVar : j) {
                    cVar.k();
                }
            }
            i();
        }
    }

    public void m() {
        d.a.o0.a.w2.c[] j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (j = j()) == null) {
            return;
        }
        for (d.a.o0.a.w2.c cVar : j) {
            cVar.n();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f50675c = z;
        }
    }

    @Override // d.a.o0.a.p.b.a.n
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            if (d(view)) {
                this.f50674b.removeView(view);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
