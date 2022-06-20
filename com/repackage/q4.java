package com.repackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a7;
/* loaded from: classes6.dex */
public class q4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;
    public final Vector3 d;
    public final Quaternion e;
    public final Vector3 f;
    public final Matrix4 g;
    public final Matrix4 h;
    public a7<t4> i;
    public q4 j;
    public final a7<q4> k;

    public q4() {
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
        this.b = true;
        this.d = new Vector3();
        this.e = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
        this.f = new Vector3(1.0f, 1.0f, 1.0f);
        this.g = new Matrix4();
        this.h = new Matrix4();
        this.i = new a7<>(2);
        this.k = new a7<>(2);
    }

    public static q4 f(a7<q4> a7Var, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{a7Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i = a7Var.b;
            if (z2) {
                for (int i2 = 0; i2 < i; i2++) {
                    q4 q4Var = a7Var.get(i2);
                    if (q4Var.a.equalsIgnoreCase(str)) {
                        return q4Var;
                    }
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    q4 q4Var2 = a7Var.get(i3);
                    if (q4Var2.a.equals(str)) {
                        return q4Var2;
                    }
                }
            }
            if (z) {
                for (int i4 = 0; i4 < i; i4++) {
                    q4 f = f(a7Var.get(i4).k, str, true, z2);
                    if (f != null) {
                        return f;
                    }
                }
                return null;
            }
            return null;
        }
        return (q4) invokeCommon.objValue;
    }

    public <T extends q4> int a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? h(-1, t) : invokeL.intValue;
    }

    public void b(boolean z) {
        Matrix4[] matrix4Arr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            a7.b<t4> it = this.i.iterator();
            while (it.hasNext()) {
                t4 next = it.next();
                b7<q4, Matrix4> b7Var = next.a;
                if (b7Var != null && (matrix4Arr = next.b) != null && (i = b7Var.c) == matrix4Arr.length) {
                    for (int i2 = 0; i2 < i; i2++) {
                        next.b[i2].set(next.a.a[i2].h).mul(next.a.b[i2]);
                    }
                }
            }
            if (z) {
                a7.b<q4> it2 = this.k.iterator();
                while (it2.hasNext()) {
                    it2.next().b(true);
                }
            }
        }
    }

    public Matrix4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.c) {
                this.g.set(this.d, this.e, this.f);
            }
            return this.g;
        }
        return (Matrix4) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c();
            e();
            if (z) {
                a7.b<q4> it = this.k.iterator();
                while (it.hasNext()) {
                    it.next().d(true);
                }
            }
        }
    }

    public Matrix4 e() {
        InterceptResult invokeV;
        q4 q4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b && (q4Var = this.j) != null) {
                this.h.set(q4Var.h).mul(this.g);
            } else {
                this.h.set(this.g);
            }
            return this.h;
        }
        return (Matrix4) invokeV.objValue;
    }

    public q4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (q4) invokeV.objValue;
    }

    public <T extends q4> int h(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, t)) == null) {
            for (q4 q4Var = this; q4Var != null; q4Var = q4Var.g()) {
                if (q4Var == t) {
                    throw new GdxRuntimeException("Cannot add a parent as a child");
                }
            }
            q4 g = t.g();
            if (g == null || g.i(t)) {
                if (i >= 0) {
                    a7<q4> a7Var = this.k;
                    if (i < a7Var.b) {
                        a7Var.insert(i, t);
                        t.j = this;
                        return i;
                    }
                }
                a7<q4> a7Var2 = this.k;
                int i2 = a7Var2.b;
                a7Var2.a(t);
                i = i2;
                t.j = this;
                return i;
            }
            throw new GdxRuntimeException("Could not remove child from its current parent");
        }
        return invokeIL.intValue;
    }

    public <T extends q4> boolean i(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            if (this.k.j(t, true)) {
                t.j = null;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
