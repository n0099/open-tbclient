package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.ETC1;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p5 implements TextureData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j3 a;
    public ETC1.a b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;

    public p5(j3 j3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.a = j3Var;
        this.c = z;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.f) {
                if (!e1.b.a("GL_OES_compressed_ETC1_RGB8_texture")) {
                    Pixmap a = ETC1.a(this.b, Pixmap.Format.RGB565);
                    e1.e.q(i, 0, a.j(), a.n(), a.l(), 0, a.i(), a.k(), a.m());
                    if (this.c) {
                        w5.a(i, a, a.n(), a.l());
                    }
                    a.dispose();
                    this.c = false;
                } else {
                    m3 m3Var = e1.e;
                    int i2 = ETC1.b;
                    int i3 = this.d;
                    int i4 = this.e;
                    int capacity = this.b.c.capacity();
                    ETC1.a aVar = this.b;
                    m3Var.h(i, 0, i2, i3, i4, 0, capacity - aVar.d, aVar.c);
                    if (f()) {
                        e1.f.F(3553);
                    }
                }
                this.b.dispose();
                this.b = null;
                this.f = false;
                return;
            }
            throw new GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
        }
        return (Pixmap) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap.Format d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Pixmap.Format.RGB565 : (Pixmap.Format) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public TextureData.TextureDataType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TextureData.TextureDataType.Custom : (TextureData.TextureDataType) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.f) {
                if (this.a == null && this.b == null) {
                    throw new GdxRuntimeException("Can only load once from ETC1Data");
                }
                j3 j3Var = this.a;
                if (j3Var != null) {
                    this.b = new ETC1.a(j3Var);
                }
                ETC1.a aVar = this.b;
                this.d = aVar.a;
                this.e = aVar.b;
                this.f = true;
                return;
            }
            throw new GdxRuntimeException("Already prepared");
        }
    }
}
