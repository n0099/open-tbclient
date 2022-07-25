package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a7;
import com.repackage.b7;
import com.repackage.w7;
/* loaded from: classes6.dex */
public class g4 implements h7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a7<f4> a;
    public final a7<q4> b;
    public final a7<o4> c;
    public final a7<Mesh> d;
    public final a7<p4> e;
    public final a7<h7> f;
    public w7<t4, b7<String, Matrix4>> g;

    public g4() {
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
        this.a = new a7<>();
        this.b = new a7<>();
        this.c = new a7<>();
        this.d = new a7<>();
        this.e = new a7<>();
        this.f = new a7<>();
        this.g = new w7<>();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.b.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.b.get(i2).d(true);
            }
            for (int i3 = 0; i3 < i; i3++) {
                this.b.get(i3).b(true);
            }
        }
    }

    @Override // com.repackage.h7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a7.b<h7> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public f4 f(ModelMaterial modelMaterial, o5 o5Var) {
        InterceptResult invokeLL;
        Texture load;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, o5Var)) == null) {
            f4 f4Var = new f4();
            f4Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                f4Var.h(new i4(i4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                f4Var.h(new i4(i4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                f4Var.h(new i4(i4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                f4Var.h(new i4(i4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                f4Var.h(new i4(i4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                f4Var.h(new j4(j4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                f4Var.h(new h4(770, 771, modelMaterial.h));
            }
            w7 w7Var = new w7();
            a7<c5> a7Var = modelMaterial.i;
            if (a7Var != null) {
                a7.b<c5> it = a7Var.iterator();
                while (it.hasNext()) {
                    c5 next = it.next();
                    if (w7Var.a(next.a)) {
                        load = (Texture) w7Var.c(next.a);
                    } else {
                        load = o5Var.load(next.a);
                        w7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    n5 n5Var = new n5(load);
                    n5Var.b = load.h();
                    n5Var.c = load.f();
                    n5Var.d = load.j();
                    n5Var.e = load.k();
                    Vector2 vector2 = next.b;
                    float f = vector2 == null ? 0.0f : vector2.x;
                    Vector2 vector22 = next.b;
                    float f2 = vector22 == null ? 0.0f : vector22.y;
                    Vector2 vector23 = next.c;
                    float f3 = vector23 == null ? 1.0f : vector23.x;
                    Vector2 vector24 = next.c;
                    float f4 = vector24 == null ? 1.0f : vector24.y;
                    int i = next.d;
                    if (i == 2) {
                        f4Var.h(new k4(k4.j, n5Var, f, f2, f3, f4));
                    } else if (i == 3) {
                        f4Var.h(new k4(k4.o, n5Var, f, f2, f3, f4));
                    } else if (i == 4) {
                        f4Var.h(new k4(k4.n, n5Var, f, f2, f3, f4));
                    } else if (i == 5) {
                        f4Var.h(new k4(k4.k, n5Var, f, f2, f3, f4));
                    } else if (i == 7) {
                        f4Var.h(new k4(k4.m, n5Var, f, f2, f3, f4));
                    } else if (i == 8) {
                        f4Var.h(new k4(k4.l, n5Var, f, f2, f3, f4));
                    } else if (i == 10) {
                        f4Var.h(new k4(k4.p, n5Var, f, f2, f3, f4));
                    }
                }
            }
            return f4Var;
        }
        return (f4) invokeLL.objValue;
    }

    public void g(w4 w4Var) {
        x4[] x4VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, w4Var) == null) {
            int i = 0;
            for (x4 x4Var : w4Var.c) {
                i += x4Var.b.length;
            }
            boolean z = i > 0;
            t3 t3Var = new t3(w4Var.a);
            int length = w4Var.b.length / (t3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i, t3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(w4Var.b, mesh.m(), w4Var.b.length, 0);
            mesh.j().clear();
            int i2 = 0;
            for (x4 x4Var2 : w4Var.c) {
                p4 p4Var = new p4();
                p4Var.a = x4Var2.a;
                p4Var.b = x4Var2.c;
                p4Var.c = i2;
                p4Var.d = z ? x4Var2.b.length : length;
                p4Var.e = mesh;
                if (z) {
                    mesh.j().put(x4Var2.b);
                }
                i2 += p4Var.d;
                this.e.a(p4Var);
            }
            mesh.j().position(0);
            a7.b<p4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public Iterable<h7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (Iterable) invokeV.objValue;
    }

    public q4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? j(str, true) : (q4) invokeL.objValue;
    }

    public q4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? k(str, z, false) : (q4) invokeLZ.objValue;
    }

    public q4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? q4.f(this.b, str, z, z2) : (q4) invokeCommon.objValue;
    }

    public void l(v4 v4Var, o5 o5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v4Var, o5Var) == null) {
            o(v4Var.b);
            n(v4Var.c, o5Var);
            q(v4Var.d);
            m(v4Var.e);
            a();
        }
    }

    public void m(Iterable<u4> iterable) {
        a7<s4<Quaternion>> a7Var;
        a7<s4<Vector3>> a7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (u4 u4Var : iterable) {
                o4 o4Var = new o4();
                String str = u4Var.a;
                a7.b<z4> it = u4Var.b.iterator();
                while (it.hasNext()) {
                    z4 next = it.next();
                    q4 i = i(next.a);
                    if (i != null) {
                        r4 r4Var = new r4();
                        if (next.b != null) {
                            a7<s4<Vector3>> a7Var3 = new a7<>();
                            r4Var.a = a7Var3;
                            a7Var3.e(next.b.b);
                            a7.b<a5<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                a5<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > o4Var.a) {
                                    o4Var.a = f;
                                }
                                a7<s4<Vector3>> a7Var4 = r4Var.a;
                                float f2 = next2.a;
                                Vector3 vector3 = next2.b;
                                a7Var4.a(new s4<>(f2, new Vector3(vector3 == null ? i.d : vector3)));
                            }
                        }
                        if (next.c != null) {
                            a7<s4<Quaternion>> a7Var5 = new a7<>();
                            r4Var.b = a7Var5;
                            a7Var5.e(next.c.b);
                            a7.b<a5<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                a5<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > o4Var.a) {
                                    o4Var.a = f3;
                                }
                                a7<s4<Quaternion>> a7Var6 = r4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion = next3.b;
                                a7Var6.a(new s4<>(f4, new Quaternion(quaternion == null ? i.e : quaternion)));
                            }
                        }
                        if (next.d != null) {
                            a7<s4<Vector3>> a7Var7 = new a7<>();
                            r4Var.c = a7Var7;
                            a7Var7.e(next.d.b);
                            a7.b<a5<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                a5<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > o4Var.a) {
                                    o4Var.a = f5;
                                }
                                a7<s4<Vector3>> a7Var8 = r4Var.c;
                                float f6 = next4.a;
                                Vector3 vector32 = next4.b;
                                a7Var8.a(new s4<>(f6, new Vector3(vector32 == null ? i.f : vector32)));
                            }
                        }
                        a7<s4<Vector3>> a7Var9 = r4Var.a;
                        if ((a7Var9 != null && a7Var9.b > 0) || (((a7Var = r4Var.b) != null && a7Var.b > 0) || ((a7Var2 = r4Var.c) != null && a7Var2.b > 0))) {
                            o4Var.b.a(r4Var);
                        }
                    }
                }
                if (o4Var.b.b > 0) {
                    this.c.a(o4Var);
                }
            }
        }
    }

    public void n(Iterable<ModelMaterial> iterable, o5 o5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, o5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, o5Var));
            }
        }
    }

    public void o(Iterable<w4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (w4 w4Var : iterable) {
                g(w4Var);
            }
        }
    }

    public q4 p(y4 y4Var) {
        InterceptResult invokeL;
        p4 p4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, y4Var)) == null) {
            q4 q4Var = new q4();
            q4Var.a = y4Var.a;
            Vector3 vector3 = y4Var.b;
            if (vector3 != null) {
                q4Var.d.set(vector3);
            }
            Quaternion quaternion = y4Var.c;
            if (quaternion != null) {
                q4Var.e.set(quaternion);
            }
            Vector3 vector32 = y4Var.d;
            if (vector32 != null) {
                q4Var.f.set(vector32);
            }
            b5[] b5VarArr = y4Var.e;
            if (b5VarArr != null) {
                for (b5 b5Var : b5VarArr) {
                    f4 f4Var = null;
                    if (b5Var.b != null) {
                        a7.b<p4> it = this.e.iterator();
                        while (it.hasNext()) {
                            p4Var = it.next();
                            if (b5Var.b.equals(p4Var.a)) {
                                break;
                            }
                        }
                    }
                    p4Var = null;
                    if (b5Var.a != null) {
                        a7.b<f4> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            f4 next = it2.next();
                            if (b5Var.a.equals(next.d)) {
                                f4Var = next;
                                break;
                            }
                        }
                    }
                    if (p4Var != null && f4Var != null) {
                        t4 t4Var = new t4();
                        q4Var.i.a(t4Var);
                        b7<String, Matrix4> b7Var = b5Var.c;
                        if (b7Var != null) {
                            this.g.i(t4Var, b7Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + q4Var.a);
                    }
                }
            }
            y4[] y4VarArr = y4Var.f;
            if (y4VarArr != null) {
                for (y4 y4Var2 : y4VarArr) {
                    q4Var.a(p(y4Var2));
                }
            }
            return q4Var;
        }
        return (q4) invokeL.objValue;
    }

    public void q(Iterable<y4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (y4 y4Var : iterable) {
                this.b.a(p(y4Var));
            }
            w7.a<t4, b7<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                w7.b next = b.next();
                K k = next.a;
                if (((t4) k).a == null) {
                    ((t4) k).a = new b7<>(q4.class, Matrix4.class);
                }
                ((t4) next.a).a.clear();
                b7.a a = ((b7) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    w7.b next2 = a.next();
                    ((t4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public g4(v4 v4Var, o5 o5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v4Var, o5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new a7<>();
        this.b = new a7<>();
        this.c = new a7<>();
        this.d = new a7<>();
        this.e = new a7<>();
        this.f = new a7<>();
        this.g = new w7<>();
        l(v4Var, o5Var);
    }
}
