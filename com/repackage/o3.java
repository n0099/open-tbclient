package com.repackage;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class o3 extends m3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, y6<o3>> j;
    public transient /* synthetic */ FieldHolder $fh;
    public p3 i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964033311, "Lcom/repackage/o3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964033311, "Lcom/repackage/o3;");
                return;
            }
        }
        j = new HashMap();
    }

    public static void s(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            j.remove(application);
        }
    }

    public static void t(Application application) {
        y6<o3> y6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, application) == null) || (y6Var = j.get(application)) == null) {
            return;
        }
        for (int i = 0; i < y6Var.b; i++) {
            y6Var.get(i).w();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i.b() : invokeV.booleanValue;
    }

    public final void v(p3 p3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p3Var) == null) {
            if (this.i != null && p3Var.b() != this.i.b()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = p3Var;
            a();
            b1.g.O(35866, 0, p3Var.c(), p3Var.getWidth(), p3Var.getHeight(), p3Var.getDepth(), 0, p3Var.c(), p3Var.e(), null);
            if (!p3Var.a()) {
                p3Var.prepare();
            }
            p3Var.d();
            l(this.c, this.d);
            m(this.e, this.f);
            b1.e.N(this.a, 0);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (u()) {
                this.b = b1.e.a();
                v(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
    }
}
