package com.repackage;

import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* loaded from: classes7.dex */
public class z5 implements a6 {
    public static /* synthetic */ Interceptable $ic;
    public static final IntBuffer g;
    public transient /* synthetic */ FieldHolder $fh;
    public final t3 a;
    public final FloatBuffer b;
    public final ByteBuffer c;
    public final boolean d;
    public int e;
    public int f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964022678, "Lcom/repackage/z5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964022678, "Lcom/repackage/z5;");
                return;
            }
        }
        g = BufferUtils.d(1);
    }

    public z5(boolean z, int i, t3 t3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), t3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = -1;
        new l7();
        this.a = t3Var;
        ByteBuffer e = BufferUtils.e(t3Var.b * i);
        this.c = e;
        FloatBuffer asFloatBuffer = e.asFloatBuffer();
        this.b = asFloatBuffer;
        this.d = true;
        asFloatBuffer.flip();
        this.c.flip();
        this.e = e1.f.n();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.clear();
            e1.g.v(1, g);
            this.f = g.get();
        }
    }

    @Override // com.repackage.a6
    public t3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (t3) invokeV.objValue;
    }

    @Override // com.repackage.a6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.b.limit() * 4) / this.a.b : invokeV.intValue;
    }

    @Override // com.repackage.a6, com.repackage.h7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n3 n3Var = e1.g;
            n3Var.E(34962, 0);
            n3Var.b(this.e);
            this.e = 0;
            if (this.d) {
                BufferUtils.b(this.c);
            }
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f == -1) {
            return;
        }
        g.clear();
        g.put(this.f);
        g.flip();
        e1.g.A(1, g);
        this.f = -1;
    }

    @Override // com.repackage.a6
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (FloatBuffer) invokeV.objValue;
    }

    @Override // com.repackage.a6
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = e1.g.n();
            a();
        }
    }
}
