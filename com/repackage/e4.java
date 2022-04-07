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
import com.repackage.u7;
import com.repackage.y6;
import com.repackage.z6;
/* loaded from: classes5.dex */
public class e4 implements f7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y6<d4> a;
    public final y6<o4> b;
    public final y6<m4> c;
    public final y6<Mesh> d;
    public final y6<n4> e;
    public final y6<f7> f;
    public u7<r4, z6<String, Matrix4>> g;

    public e4() {
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
        this.a = new y6<>();
        this.b = new y6<>();
        this.c = new y6<>();
        this.d = new y6<>();
        this.e = new y6<>();
        this.f = new y6<>();
        this.g = new u7<>();
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

    @Override // com.repackage.f7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            y6.b<f7> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public d4 f(ModelMaterial modelMaterial, m5 m5Var) {
        InterceptResult invokeLL;
        Texture load;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, m5Var)) == null) {
            d4 d4Var = new d4();
            d4Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                d4Var.i(new g4(g4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                d4Var.i(new g4(g4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                d4Var.i(new g4(g4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                d4Var.i(new g4(g4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                d4Var.i(new g4(g4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                d4Var.i(new h4(h4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                d4Var.i(new f4(770, 771, modelMaterial.h));
            }
            u7 u7Var = new u7();
            y6<a5> y6Var = modelMaterial.i;
            if (y6Var != null) {
                y6.b<a5> it = y6Var.iterator();
                while (it.hasNext()) {
                    a5 next = it.next();
                    if (u7Var.a(next.a)) {
                        load = (Texture) u7Var.c(next.a);
                    } else {
                        load = m5Var.load(next.a);
                        u7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    l5 l5Var = new l5(load);
                    l5Var.b = load.h();
                    l5Var.c = load.f();
                    l5Var.d = load.j();
                    l5Var.e = load.k();
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
                        d4Var.i(new i4(i4.j, l5Var, f, f2, f3, f4));
                    } else if (i == 3) {
                        d4Var.i(new i4(i4.o, l5Var, f, f2, f3, f4));
                    } else if (i == 4) {
                        d4Var.i(new i4(i4.n, l5Var, f, f2, f3, f4));
                    } else if (i == 5) {
                        d4Var.i(new i4(i4.k, l5Var, f, f2, f3, f4));
                    } else if (i == 7) {
                        d4Var.i(new i4(i4.m, l5Var, f, f2, f3, f4));
                    } else if (i == 8) {
                        d4Var.i(new i4(i4.l, l5Var, f, f2, f3, f4));
                    } else if (i == 10) {
                        d4Var.i(new i4(i4.p, l5Var, f, f2, f3, f4));
                    }
                }
            }
            return d4Var;
        }
        return (d4) invokeLL.objValue;
    }

    public void g(u4 u4Var) {
        v4[] v4VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, u4Var) == null) {
            int i = 0;
            for (v4 v4Var : u4Var.c) {
                i += v4Var.b.length;
            }
            boolean z = i > 0;
            r3 r3Var = new r3(u4Var.a);
            int length = u4Var.b.length / (r3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i, r3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(u4Var.b, mesh.m(), u4Var.b.length, 0);
            mesh.j().clear();
            int i2 = 0;
            for (v4 v4Var2 : u4Var.c) {
                n4 n4Var = new n4();
                n4Var.a = v4Var2.a;
                n4Var.b = v4Var2.c;
                n4Var.c = i2;
                n4Var.d = z ? v4Var2.b.length : length;
                n4Var.e = mesh;
                if (z) {
                    mesh.j().put(v4Var2.b);
                }
                i2 += n4Var.d;
                this.e.a(n4Var);
            }
            mesh.j().position(0);
            y6.b<n4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public Iterable<f7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (Iterable) invokeV.objValue;
    }

    public o4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? j(str, true) : (o4) invokeL.objValue;
    }

    public o4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? k(str, z, false) : (o4) invokeLZ.objValue;
    }

    public o4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? o4.f(this.b, str, z, z2) : (o4) invokeCommon.objValue;
    }

    public void l(t4 t4Var, m5 m5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t4Var, m5Var) == null) {
            o(t4Var.b);
            n(t4Var.c, m5Var);
            q(t4Var.d);
            m(t4Var.e);
            a();
        }
    }

    public void m(Iterable<s4> iterable) {
        y6<q4<Quaternion>> y6Var;
        y6<q4<Vector3>> y6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (s4 s4Var : iterable) {
                m4 m4Var = new m4();
                String str = s4Var.a;
                y6.b<x4> it = s4Var.b.iterator();
                while (it.hasNext()) {
                    x4 next = it.next();
                    o4 i = i(next.a);
                    if (i != null) {
                        p4 p4Var = new p4();
                        if (next.b != null) {
                            y6<q4<Vector3>> y6Var3 = new y6<>();
                            p4Var.a = y6Var3;
                            y6Var3.e(next.b.b);
                            y6.b<y4<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                y4<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > m4Var.a) {
                                    m4Var.a = f;
                                }
                                y6<q4<Vector3>> y6Var4 = p4Var.a;
                                float f2 = next2.a;
                                Vector3 vector3 = next2.b;
                                y6Var4.a(new q4<>(f2, new Vector3(vector3 == null ? i.d : vector3)));
                            }
                        }
                        if (next.c != null) {
                            y6<q4<Quaternion>> y6Var5 = new y6<>();
                            p4Var.b = y6Var5;
                            y6Var5.e(next.c.b);
                            y6.b<y4<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                y4<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > m4Var.a) {
                                    m4Var.a = f3;
                                }
                                y6<q4<Quaternion>> y6Var6 = p4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion = next3.b;
                                y6Var6.a(new q4<>(f4, new Quaternion(quaternion == null ? i.e : quaternion)));
                            }
                        }
                        if (next.d != null) {
                            y6<q4<Vector3>> y6Var7 = new y6<>();
                            p4Var.c = y6Var7;
                            y6Var7.e(next.d.b);
                            y6.b<y4<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                y4<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > m4Var.a) {
                                    m4Var.a = f5;
                                }
                                y6<q4<Vector3>> y6Var8 = p4Var.c;
                                float f6 = next4.a;
                                Vector3 vector32 = next4.b;
                                y6Var8.a(new q4<>(f6, new Vector3(vector32 == null ? i.f : vector32)));
                            }
                        }
                        y6<q4<Vector3>> y6Var9 = p4Var.a;
                        if ((y6Var9 != null && y6Var9.b > 0) || (((y6Var = p4Var.b) != null && y6Var.b > 0) || ((y6Var2 = p4Var.c) != null && y6Var2.b > 0))) {
                            m4Var.b.a(p4Var);
                        }
                    }
                }
                if (m4Var.b.b > 0) {
                    this.c.a(m4Var);
                }
            }
        }
    }

    public void n(Iterable<ModelMaterial> iterable, m5 m5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, m5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, m5Var));
            }
        }
    }

    public void o(Iterable<u4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (u4 u4Var : iterable) {
                g(u4Var);
            }
        }
    }

    public o4 p(w4 w4Var) {
        InterceptResult invokeL;
        n4 n4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, w4Var)) == null) {
            o4 o4Var = new o4();
            o4Var.a = w4Var.a;
            Vector3 vector3 = w4Var.b;
            if (vector3 != null) {
                o4Var.d.set(vector3);
            }
            Quaternion quaternion = w4Var.c;
            if (quaternion != null) {
                o4Var.e.set(quaternion);
            }
            Vector3 vector32 = w4Var.d;
            if (vector32 != null) {
                o4Var.f.set(vector32);
            }
            z4[] z4VarArr = w4Var.e;
            if (z4VarArr != null) {
                for (z4 z4Var : z4VarArr) {
                    d4 d4Var = null;
                    if (z4Var.b != null) {
                        y6.b<n4> it = this.e.iterator();
                        while (it.hasNext()) {
                            n4Var = it.next();
                            if (z4Var.b.equals(n4Var.a)) {
                                break;
                            }
                        }
                    }
                    n4Var = null;
                    if (z4Var.a != null) {
                        y6.b<d4> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            d4 next = it2.next();
                            if (z4Var.a.equals(next.d)) {
                                d4Var = next;
                                break;
                            }
                        }
                    }
                    if (n4Var != null && d4Var != null) {
                        r4 r4Var = new r4();
                        o4Var.i.a(r4Var);
                        z6<String, Matrix4> z6Var = z4Var.c;
                        if (z6Var != null) {
                            this.g.i(r4Var, z6Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + o4Var.a);
                    }
                }
            }
            w4[] w4VarArr = w4Var.f;
            if (w4VarArr != null) {
                for (w4 w4Var2 : w4VarArr) {
                    o4Var.a(p(w4Var2));
                }
            }
            return o4Var;
        }
        return (o4) invokeL.objValue;
    }

    public void q(Iterable<w4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (w4 w4Var : iterable) {
                this.b.a(p(w4Var));
            }
            u7.a<r4, z6<String, Matrix4>> b = this.g.b();
            b.d();
            while (b.hasNext()) {
                u7.b next = b.next();
                K k = next.a;
                if (((r4) k).a == null) {
                    ((r4) k).a = new z6<>(o4.class, Matrix4.class);
                }
                ((r4) next.a).a.clear();
                z6.a b2 = ((z6) next.b).b();
                b2.iterator();
                while (b2.hasNext()) {
                    u7.b next2 = b2.next();
                    ((r4) next.a).a.f(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public e4(t4 t4Var, m5 m5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t4Var, m5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new y6<>();
        this.b = new y6<>();
        this.c = new y6<>();
        this.d = new y6<>();
        this.e = new y6<>();
        this.f = new y6<>();
        this.g = new u7<>();
        l(t4Var, m5Var);
    }
}
