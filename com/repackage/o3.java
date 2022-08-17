package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes7.dex */
public abstract class o3 implements h7 {
    public static /* synthetic */ Interceptable $ic;
    public static float h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public int b;
    public Texture.TextureFilter c;
    public Texture.TextureFilter d;
    public Texture.TextureWrap e;
    public Texture.TextureWrap f;
    public float g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964033311, "Lcom/repackage/o3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964033311, "Lcom/repackage/o3;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o3(int i) {
        this(i, e1.e.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            float f = h;
            if (f > 0.0f) {
                return f;
            }
            if (e1.b.a("GL_EXT_texture_filter_anisotropic")) {
                FloatBuffer c = BufferUtils.c(16);
                c.position(0);
                c.limit(c.capacity());
                e1.f.i(34047, c);
                float f2 = c.get(0);
                h = f2;
                return f2;
            }
            h = 1.0f;
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    public static void q(int i, TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, textureData) == null) {
            r(i, textureData, 0);
        }
    }

    public static void r(int i, TextureData textureData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), textureData, Integer.valueOf(i2)}) == null) || textureData == null) {
            return;
        }
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        if (textureData.getType() == TextureData.TextureDataType.Custom) {
            textureData.b(i);
            return;
        }
        Pixmap c = textureData.c();
        boolean g = textureData.g();
        if (textureData.d() != c.h()) {
            Pixmap pixmap = new Pixmap(c.n(), c.l(), textureData.d());
            pixmap.o(Pixmap.Blending.None);
            pixmap.a(c, 0, 0, 0, 0, c.n(), c.l());
            if (textureData.g()) {
                c.dispose();
            }
            c = pixmap;
            g = true;
        }
        e1.e.g(3317, 1);
        if (textureData.f()) {
            w5.a(i, c, c.n(), c.l());
        } else {
            e1.e.q(i, i2, c.j(), c.n(), c.l(), 0, c.i(), c.k(), c.m());
        }
        if (g) {
            c.dispose();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e1.e.N(this.a, this.b);
        }
    }

    public void delete() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i = this.b) == 0) {
            return;
        }
        e1.e.S(i);
        this.b = 0;
    }

    @Override // com.repackage.h7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            delete();
        }
    }

    public Texture.TextureFilter f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (Texture.TextureFilter) invokeV.objValue;
    }

    public Texture.TextureFilter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (Texture.TextureFilter) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.intValue;
    }

    public Texture.TextureWrap j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (Texture.TextureWrap) invokeV.objValue;
    }

    public Texture.TextureWrap k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : (Texture.TextureWrap) invokeV.objValue;
    }

    public void l(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textureFilter, textureFilter2) == null) {
            this.c = textureFilter;
            this.d = textureFilter2;
            a();
            e1.e.j(this.a, 10241, textureFilter.getGLEnum());
            e1.e.j(this.a, 10240, textureFilter2.getGLEnum());
        }
    }

    public void m(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, textureWrap, textureWrap2) == null) {
            this.e = textureWrap;
            this.f = textureWrap2;
            a();
            e1.e.j(this.a, 10242, textureWrap.getGLEnum());
            e1.e.j(this.a, 10243, textureWrap2.getGLEnum());
        }
    }

    public float n(float f, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)})) == null) {
            float g = g();
            if (g == 1.0f) {
                return 1.0f;
            }
            float min = Math.min(f, g);
            if (!z && com.badlogic.gdx.math.d.f(min, this.g, 0.1f)) {
                return this.g;
            }
            e1.f.u(3553, 34046, min);
            this.g = min;
            return min;
        }
        return invokeCommon.floatValue;
    }

    public void o(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048587, this, textureFilter, textureFilter2, z) == null) {
            if (textureFilter != null && (z || this.c != textureFilter)) {
                e1.e.j(this.a, 10241, textureFilter.getGLEnum());
                this.c = textureFilter;
            }
            if (textureFilter2 != null) {
                if (z || this.d != textureFilter2) {
                    e1.e.j(this.a, 10240, textureFilter2.getGLEnum());
                    this.d = textureFilter2;
                }
            }
        }
    }

    public void p(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, textureWrap, textureWrap2, z) == null) {
            if (textureWrap != null && (z || this.e != textureWrap)) {
                e1.e.j(this.a, 10242, textureWrap.getGLEnum());
                this.e = textureWrap;
            }
            if (textureWrap2 != null) {
                if (z || this.f != textureWrap2) {
                    e1.e.j(this.a, 10243, textureWrap2.getGLEnum());
                    this.f = textureWrap2;
                }
            }
        }
    }

    public o3(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
        this.c = textureFilter;
        this.d = textureFilter;
        Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
        this.e = textureWrap;
        this.f = textureWrap;
        this.g = 1.0f;
        this.a = i;
        this.b = i2;
    }
}
