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
/* loaded from: classes7.dex */
public class q3 extends o3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, a7<q3>> j;
    public transient /* synthetic */ FieldHolder $fh;
    public r3 i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964031389, "Lcom/repackage/q3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964031389, "Lcom/repackage/q3;");
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
        a7<q3> a7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, application) == null) || (a7Var = j.get(application)) == null) {
            return;
        }
        for (int i = 0; i < a7Var.b; i++) {
            a7Var.get(i).w();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i.a() : invokeV.booleanValue;
    }

    public final void v(r3 r3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r3Var) == null) {
            if (this.i != null && r3Var.a() != this.i.a()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = r3Var;
            a();
            e1.g.O(35866, 0, r3Var.b(), r3Var.getWidth(), r3Var.getHeight(), r3Var.d(), 0, r3Var.b(), r3Var.e(), null);
            if (!r3Var.isPrepared()) {
                r3Var.prepare();
            }
            r3Var.c();
            l(this.c, this.d);
            m(this.e, this.f);
            e1.e.N(this.a, 0);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (u()) {
                this.b = e1.e.a();
                v(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
    }
}
