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
/* loaded from: classes7.dex */
public class t34 implements qi1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yf3> a;
    public FrameLayout b;
    public boolean c;
    public boolean d;

    public t34(@NonNull FrameLayout frameLayout) {
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

    @Override // com.repackage.qi1
    public boolean a(View view2, fr2 fr2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, fr2Var)) == null) {
            if (d(view2)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fr2Var.f(), fr2Var.c());
                layoutParams.leftMargin = fr2Var.d();
                layoutParams.topMargin = fr2Var.e();
                this.b.updateViewLayout(view2, layoutParams);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.qi1
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.booleanValue;
    }

    @Override // com.repackage.qi1
    public boolean c(View view2, fr2 fr2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, fr2Var)) == null) {
            if (view2 == null || fr2Var == null) {
                return false;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fr2Var.f(), fr2Var.c());
            layoutParams.leftMargin = fr2Var.d();
            layoutParams.topMargin = fr2Var.e();
            this.b.addView(view2, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.qi1
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

    @Override // com.repackage.qi1
    public synchronized void e(yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yf3Var) == null) {
            synchronized (this) {
                if (yf3Var == null) {
                    return;
                }
                if (!this.a.contains(yf3Var)) {
                    this.a.add(yf3Var);
                }
            }
        }
    }

    @Override // com.repackage.qi1
    public synchronized void f(yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yf3Var) == null) {
            synchronized (this) {
                if (yf3Var == null) {
                    return;
                }
                this.a.remove(yf3Var);
            }
        }
    }

    @Override // com.repackage.qi1
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d = z;
        }
    }

    @Override // com.repackage.qi1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.repackage.qi1
    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (FrameLayout) invokeV.objValue;
    }

    @Override // com.repackage.qi1
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

    public final synchronized yf3[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.a.isEmpty()) {
                    return null;
                }
                yf3[] yf3VarArr = new yf3[this.a.size()];
                this.a.toArray(yf3VarArr);
                return yf3VarArr;
            }
        }
        return (yf3[]) invokeV.objValue;
    }

    public void k() {
        yf3[] j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (j = j()) == null) {
            return;
        }
        for (yf3 yf3Var : j) {
            yf3Var.d();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            yf3[] j = j();
            if (j != null) {
                for (yf3 yf3Var : j) {
                    yf3Var.onViewDestroy();
                }
            }
            i();
        }
    }

    public void m() {
        yf3[] j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (j = j()) == null) {
            return;
        }
        for (yf3 yf3Var : j) {
            yf3Var.k();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.repackage.qi1
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
