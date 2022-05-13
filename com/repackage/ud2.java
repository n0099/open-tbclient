package com.repackage;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class ud2 implements sd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<sd2> a;

    public ud2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new CopyOnWriteArrayList();
    }

    @Override // com.repackage.sd2
    public void a() {
        List<sd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (sd2 sd2Var : this.a) {
            if (sd2Var != null) {
                sd2Var.a();
            }
        }
    }

    @Override // com.repackage.sd2
    public void b() {
        List<sd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (sd2 sd2Var : this.a) {
            sd2Var.b();
        }
    }

    @Override // com.repackage.sd2
    public void c() {
        List<sd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (sd2 sd2Var : this.a) {
            sd2Var.c();
        }
    }

    @Override // com.repackage.sd2
    public void d() {
        List<sd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (sd2 sd2Var : this.a) {
            sd2Var.d();
        }
    }

    @Override // com.repackage.sd2
    public void e() {
        List<sd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (sd2 sd2Var : this.a) {
            sd2Var.e();
        }
    }

    @Override // com.repackage.sd2
    public void f() {
        List<sd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (sd2 sd2Var : this.a) {
            sd2Var.f();
        }
    }

    @Override // com.repackage.sd2
    public void g() {
        List<sd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (sd2 sd2Var : this.a) {
            sd2Var.g();
        }
    }

    public void h(@NonNull sd2 sd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sd2Var) == null) {
            this.a.add(sd2Var);
        }
    }

    public void i(@NonNull sd2 sd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sd2Var) == null) {
            this.a.remove(sd2Var);
        }
    }

    @Override // com.repackage.sd2
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            List<sd2> list = this.a;
            if (list == null || list.size() <= 0) {
                return false;
            }
            while (true) {
                for (sd2 sd2Var : this.a) {
                    z = z || sd2Var.onKeyDown(i, keyEvent);
                }
                return z;
            }
        }
        return invokeIL.booleanValue;
    }
}
