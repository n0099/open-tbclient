package com.repackage;

import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes7.dex */
public class w5 implements y5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r3 a;
    public FloatBuffer b;
    public ByteBuffer c;
    public boolean d;
    public int e;
    public boolean f;

    public w5(boolean z, int i, r3 r3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), r3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.e = b1.f.n();
        ByteBuffer e = BufferUtils.e(r3Var.b * i);
        e.limit(0);
        a(e, true, r3Var);
        f(z ? 35044 : 35048);
    }

    public void a(Buffer buffer, boolean z, r3 r3Var) {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{buffer, Boolean.valueOf(z), r3Var}) == null) {
            if (!this.f) {
                if (this.d && (byteBuffer = this.c) != null) {
                    BufferUtils.b(byteBuffer);
                }
                this.a = r3Var;
                if (buffer instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) buffer;
                    this.c = byteBuffer2;
                    this.d = z;
                    int limit = byteBuffer2.limit();
                    ByteBuffer byteBuffer3 = this.c;
                    byteBuffer3.limit(byteBuffer3.capacity());
                    this.b = this.c.asFloatBuffer();
                    this.c.limit(limit);
                    this.b.limit(limit / 4);
                    return;
                }
                throw new GdxRuntimeException("Only ByteBuffer is currently supported");
            }
            throw new GdxRuntimeException("Cannot change attributes while VBO is bound");
        }
    }

    @Override // com.repackage.y5
    public r3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (r3) invokeV.objValue;
    }

    @Override // com.repackage.y5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.b.limit() * 4) / this.a.b : invokeV.intValue;
    }

    @Override // com.repackage.y5, com.repackage.f7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            k3 k3Var = b1.f;
            k3Var.E(34962, 0);
            k3Var.b(this.e);
            this.e = 0;
            if (this.d) {
                BufferUtils.b(this.c);
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.f) {
            throw new GdxRuntimeException("Cannot change usage while VBO is bound");
        }
    }

    @Override // com.repackage.y5
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (FloatBuffer) invokeV.objValue;
    }

    @Override // com.repackage.y5
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = b1.f.n();
        }
    }
}
