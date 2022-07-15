package com.repackage;

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
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b34 implements yh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<gf3> a;
    public FrameLayout b;
    public boolean c;
    public boolean d;

    public b34(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.d = false;
        this.b = frameLayout;
    }

    @Override // com.repackage.yh1
    public boolean a(View view2, nq2 nq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, nq2Var)) == null) {
            if (d(view2)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(nq2Var.f(), nq2Var.c());
                layoutParams.leftMargin = nq2Var.d();
                layoutParams.topMargin = nq2Var.e();
                this.b.updateViewLayout(view2, layoutParams);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.yh1
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.booleanValue;
    }

    @Override // com.repackage.yh1
    public boolean c(View view2, nq2 nq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, nq2Var)) == null) {
            if (view2 == null || nq2Var == null) {
                return false;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(nq2Var.f(), nq2Var.c());
            layoutParams.leftMargin = nq2Var.d();
            layoutParams.topMargin = nq2Var.e();
            this.b.addView(view2, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.yh1
    public boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            ViewParent parent = view2.getParent();
            FrameLayout frameLayout = this.b;
            return parent == frameLayout && frameLayout.indexOfChild(view2) >= 0;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.yh1
    public synchronized void e(gf3 gf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gf3Var) == null) {
            synchronized (this) {
                if (gf3Var == null) {
                    return;
                }
                if (!this.a.contains(gf3Var)) {
                    this.a.add(gf3Var);
                }
            }
        }
    }

    @Override // com.repackage.yh1
    public synchronized void f(gf3 gf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gf3Var) == null) {
            synchronized (this) {
                if (gf3Var == null) {
                    return;
                }
                this.a.remove(gf3Var);
            }
        }
    }

    @Override // com.repackage.yh1
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d = z;
        }
    }

    @Override // com.repackage.yh1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.repackage.yh1
    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (FrameLayout) invokeV.objValue;
    }

    @Override // com.repackage.yh1
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public final synchronized gf3[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.a.isEmpty()) {
                    return null;
                }
                gf3[] gf3VarArr = new gf3[this.a.size()];
                this.a.toArray(gf3VarArr);
                return gf3VarArr;
            }
        }
        return (gf3[]) invokeV.objValue;
    }

    public void k() {
        gf3[] j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (j = j()) == null) {
            return;
        }
        for (gf3 gf3Var : j) {
            gf3Var.f();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            gf3[] j = j();
            if (j != null) {
                for (gf3 gf3Var : j) {
                    gf3Var.a();
                }
            }
            i();
        }
    }

    public void m() {
        gf3[] j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (j = j()) == null) {
            return;
        }
        for (gf3 gf3Var : j) {
            gf3Var.m();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.repackage.yh1
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view2)) == null) {
            if (d(view2)) {
                this.b.removeView(view2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
