package com.repackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a7;
import com.repackage.o7;
/* loaded from: classes5.dex */
public class d5 implements o7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j5 a;
    public a7<k5> b;
    public m5<?, ?> c;
    public float d;

    public d5() {
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
        new Matrix4();
        new Vector3(1.0f, 1.0f, 1.0f);
        this.b = new a7<>(true, 3, k5.class);
        d(0.016666668f);
    }

    @Override // com.repackage.o7.c
    public void a(o7 o7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, o7Var, jsonValue) == null) {
            String str = (String) o7Var.l("name", String.class, jsonValue);
            this.a = (j5) o7Var.l("emitter", j5.class, jsonValue);
            this.b.b((a7) o7Var.m("influencers", a7.class, k5.class, jsonValue));
            this.c = (m5) o7Var.l("renderer", m5.class, jsonValue);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.dispose();
            a7.b<k5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public void c(m1 m1Var, h5 h5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, m1Var, h5Var) == null) {
            this.a.f(m1Var, h5Var);
            a7.b<k5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().f(m1Var, h5Var);
            }
            this.c.f(m1Var, h5Var);
        }
    }

    public final void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.d = f;
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            update(e1.b.e());
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            d(f);
            this.a.update();
            a7.b<k5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }
}
