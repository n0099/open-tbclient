package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.q1;
import com.repackage.y6;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes6.dex */
public class j4 extends q1<q1.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a7 d;
    public final Quaternion e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j4(a7 a7Var, o1 o1Var) {
        super(o1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a7Var, o1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((o1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Quaternion();
        this.d = a7Var;
    }

    @Override // com.repackage.q1
    public t4 h(h3 h3Var, q1.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h3Var, aVar)) == null) ? o(h3Var) : (t4) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r15v7, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r8v8, types: [T, com.badlogic.gdx.math.Quaternion] */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v17, types: [T, com.badlogic.gdx.math.Quaternion] */
    public void j(t4 t4Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t4Var, jsonValue) == null) {
            t4 t4Var2 = t4Var;
            JsonValue m = jsonValue.m("animations");
            if (m == null) {
                return;
            }
            t4Var2.e.e(m.j);
            JsonValue jsonValue2 = m.f;
            while (jsonValue2 != null) {
                JsonValue m2 = jsonValue2.m("bones");
                if (m2 != null) {
                    s4 s4Var = new s4();
                    t4Var2.e.a(s4Var);
                    s4Var.b.e(m2.j);
                    s4Var.a = jsonValue2.r("id");
                    for (JsonValue jsonValue3 = m2.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        x4 x4Var = new x4();
                        s4Var.b.a(x4Var);
                        x4Var.a = jsonValue3.r("boneId");
                        JsonValue m3 = jsonValue3.m("keyframes");
                        float f = 1000.0f;
                        float f2 = 0.0f;
                        int i = 2;
                        int i2 = 1;
                        int i3 = 0;
                        int i4 = 3;
                        if (m3 != null && m3.v()) {
                            JsonValue jsonValue4 = m3.f;
                            while (jsonValue4 != null) {
                                float p = jsonValue4.p("keytime", f2) / f;
                                JsonValue m4 = jsonValue4.m("translation");
                                if (m4 != null && m4.j == i4) {
                                    if (x4Var.b == null) {
                                        x4Var.b = new y6<>();
                                    }
                                    y4<Vector3> y4Var = new y4<>();
                                    y4Var.a = p;
                                    y4Var.b = new Vector3(m4.o(i3), m4.o(i2), m4.o(i));
                                    x4Var.b.a(y4Var);
                                }
                                JsonValue m5 = jsonValue4.m("rotation");
                                if (m5 != null && m5.j == 4) {
                                    if (x4Var.c == null) {
                                        x4Var.c = new y6<>();
                                    }
                                    y4<Quaternion> y4Var2 = new y4<>();
                                    y4Var2.a = p;
                                    y4Var2.b = new Quaternion(m5.o(0), m5.o(i2), m5.o(i), m5.o(3));
                                    x4Var.c.a(y4Var2);
                                }
                                JsonValue m6 = jsonValue4.m(AnimationProperty.SCALE);
                                if (m6 != null && m6.j == 3) {
                                    if (x4Var.d == null) {
                                        x4Var.d = new y6<>();
                                    }
                                    y4<Vector3> y4Var3 = new y4<>();
                                    y4Var3.a = p;
                                    y4Var3.b = new Vector3(m6.o(0), m6.o(1), m6.o(2));
                                    x4Var.d.a(y4Var3);
                                }
                                jsonValue4 = jsonValue4.h;
                                f = 1000.0f;
                                f2 = 0.0f;
                                i = 2;
                                i2 = 1;
                                i3 = 0;
                                i4 = 3;
                            }
                        } else {
                            JsonValue m7 = jsonValue3.m("translation");
                            if (m7 != null && m7.v()) {
                                y6<y4<Vector3>> y6Var = new y6<>();
                                x4Var.b = y6Var;
                                y6Var.e(m7.j);
                                for (JsonValue jsonValue5 = m7.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                    y4<Vector3> y4Var4 = new y4<>();
                                    x4Var.b.a(y4Var4);
                                    y4Var4.a = jsonValue5.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m8 = jsonValue5.m("value");
                                    if (m8 != null && m8.j >= 3) {
                                        y4Var4.b = new Vector3(m8.o(0), m8.o(1), m8.o(2));
                                    }
                                }
                            }
                            JsonValue m9 = jsonValue3.m("rotation");
                            if (m9 != null && m9.v()) {
                                y6<y4<Quaternion>> y6Var2 = new y6<>();
                                x4Var.c = y6Var2;
                                y6Var2.e(m9.j);
                                for (JsonValue jsonValue6 = m9.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                    y4<Quaternion> y4Var5 = new y4<>();
                                    x4Var.c.a(y4Var5);
                                    y4Var5.a = jsonValue6.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m10 = jsonValue6.m("value");
                                    if (m10 != null && m10.j >= 4) {
                                        y4Var5.b = new Quaternion(m10.o(0), m10.o(1), m10.o(2), m10.o(3));
                                    }
                                }
                            }
                            JsonValue m11 = jsonValue3.m("scaling");
                            if (m11 != null && m11.v()) {
                                y6<y4<Vector3>> y6Var3 = new y6<>();
                                x4Var.d = y6Var3;
                                y6Var3.e(m11.j);
                                for (JsonValue jsonValue7 = m11.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                    y4<Vector3> y4Var6 = new y4<>();
                                    x4Var.d.a(y4Var6);
                                    y4Var6.a = jsonValue7.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m12 = jsonValue7.m("value");
                                    if (m12 != null && m12.j >= 3) {
                                        y4Var6.b = new Vector3(m12.o(0), m12.o(1), m12.o(2));
                                    }
                                }
                            }
                        }
                    }
                }
                jsonValue2 = jsonValue2.h;
                t4Var2 = t4Var;
            }
        }
    }

    public q3[] k(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonValue)) == null) {
            y6 y6Var = new y6();
            int i = 0;
            int i2 = 0;
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                String k = jsonValue2.k();
                if (k.equals("POSITION")) {
                    y6Var.a(q3.f());
                } else if (k.equals("NORMAL")) {
                    y6Var.a(q3.e());
                } else if (k.equals("COLOR")) {
                    y6Var.a(q3.d());
                } else if (k.equals("COLORPACKED")) {
                    y6Var.a(q3.c());
                } else if (k.equals("TANGENT")) {
                    y6Var.a(q3.g());
                } else if (k.equals("BINORMAL")) {
                    y6Var.a(q3.a());
                } else if (k.startsWith("TEXCOORD")) {
                    y6Var.a(q3.h(i));
                    i++;
                } else if (k.startsWith("BLENDWEIGHT")) {
                    y6Var.a(q3.b(i2));
                    i2++;
                } else {
                    throw new GdxRuntimeException("Unknown vertex attribute '" + k + "', should be one of position, normal, uv, tangent or binormal");
                }
            }
            return (q3[]) y6Var.n(q3.class);
        }
        return (q3[]) invokeL.objValue;
    }

    public i3 l(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsonValue)) == null) {
            if (jsonValue.j >= 3) {
                return new i3(jsonValue.o(0), jsonValue.o(1), jsonValue.o(2), 1.0f);
            }
            throw new GdxRuntimeException("Expected Color values <> than three.");
        }
        return (i3) invokeL.objValue;
    }

    public void m(t4 t4Var, JsonValue jsonValue, String str) {
        JsonValue m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, t4Var, jsonValue, str) == null) || (m = jsonValue.m("materials")) == null) {
            return;
        }
        t4Var.c.e(m.j);
        for (JsonValue jsonValue2 = m.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
            ModelMaterial modelMaterial = new ModelMaterial();
            String s = jsonValue2.s("id", null);
            if (s != null) {
                modelMaterial.a = s;
                JsonValue m2 = jsonValue2.m("diffuse");
                if (m2 != null) {
                    modelMaterial.c = l(m2);
                }
                JsonValue m3 = jsonValue2.m("ambient");
                if (m3 != null) {
                    modelMaterial.b = l(m3);
                }
                JsonValue m4 = jsonValue2.m("emissive");
                if (m4 != null) {
                    modelMaterial.e = l(m4);
                }
                JsonValue m5 = jsonValue2.m("specular");
                if (m5 != null) {
                    modelMaterial.d = l(m5);
                }
                JsonValue m6 = jsonValue2.m("reflection");
                if (m6 != null) {
                    modelMaterial.f = l(m6);
                }
                modelMaterial.g = jsonValue2.p("shininess", 0.0f);
                modelMaterial.h = jsonValue2.p(NativeConstants.OPACITY, 1.0f);
                JsonValue m7 = jsonValue2.m("textures");
                if (m7 != null) {
                    for (JsonValue jsonValue3 = m7.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        a5 a5Var = new a5();
                        if (jsonValue3.s("id", null) != null) {
                            String s2 = jsonValue3.s(BreakpointSQLiteKey.FILENAME, null);
                            if (s2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                String str2 = "/";
                                sb.append((str.length() == 0 || str.endsWith("/")) ? "" : "");
                                sb.append(s2);
                                a5Var.a = sb.toString();
                                a5Var.b = t(jsonValue3.m("uvTranslation"), 0.0f, 0.0f);
                                a5Var.c = t(jsonValue3.m("uvScaling"), 1.0f, 1.0f);
                                String s3 = jsonValue3.s("type", null);
                                if (s3 != null) {
                                    a5Var.d = r(s3);
                                    if (modelMaterial.i == null) {
                                        modelMaterial.i = new y6<>();
                                    }
                                    modelMaterial.i.a(a5Var);
                                } else {
                                    throw new GdxRuntimeException("Texture needs type.");
                                }
                            } else {
                                throw new GdxRuntimeException("Texture needs filename.");
                            }
                        } else {
                            throw new GdxRuntimeException("Texture has no id.");
                        }
                    }
                    continue;
                }
                t4Var.c.a(modelMaterial);
            } else {
                throw new GdxRuntimeException("Material needs an id.");
            }
        }
    }

    public void n(t4 t4Var, JsonValue jsonValue) {
        JsonValue m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, t4Var, jsonValue) == null) || (m = jsonValue.m("meshes")) == null) {
            return;
        }
        t4Var.b.e(m.j);
        for (JsonValue jsonValue2 = m.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
            u4 u4Var = new u4();
            jsonValue2.s("id", "");
            u4Var.a = k(jsonValue2.L("attributes"));
            u4Var.b = jsonValue2.L("vertices").f();
            JsonValue L = jsonValue2.L("parts");
            y6 y6Var = new y6();
            for (JsonValue jsonValue3 = L.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                v4 v4Var = new v4();
                String s = jsonValue3.s("id", null);
                if (s != null) {
                    y6.b it = y6Var.iterator();
                    while (it.hasNext()) {
                        if (((v4) it.next()).a.equals(s)) {
                            throw new GdxRuntimeException("Mesh part with id '" + s + "' already in defined");
                        }
                    }
                    v4Var.a = s;
                    String s2 = jsonValue3.s("type", null);
                    if (s2 != null) {
                        v4Var.c = s(s2);
                        v4Var.b = jsonValue3.L("indices").j();
                        y6Var.a(v4Var);
                    } else {
                        throw new GdxRuntimeException("No primitive type given for mesh part '" + s + "'");
                    }
                } else {
                    throw new GdxRuntimeException("Not id given for mesh part");
                }
            }
            u4Var.c = (v4[]) y6Var.n(v4.class);
            t4Var.b.a(u4Var);
        }
    }

    public t4 o(h3 h3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h3Var)) == null) {
            JsonValue a = this.d.a(h3Var);
            t4 t4Var = new t4();
            JsonValue L = a.L("version");
            t4Var.a[0] = L.q(0);
            t4Var.a[1] = L.q(1);
            short[] sArr = t4Var.a;
            if (sArr[0] == 0 && sArr[1] == 1) {
                a.s("id", "");
                n(t4Var, a);
                m(t4Var, a, h3Var.i().j());
                p(t4Var, a);
                j(t4Var, a);
                return t4Var;
            }
            throw new GdxRuntimeException("Model version not supported");
        }
        return (t4) invokeL.objValue;
    }

    public y6<w4> p(t4 t4Var, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, t4Var, jsonValue)) == null) {
            JsonValue m = jsonValue.m("nodes");
            if (m != null) {
                t4Var.d.e(m.j);
                for (JsonValue jsonValue2 = m.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    t4Var.d.a(q(jsonValue2));
                }
            }
            return t4Var.d;
        }
        return (y6) invokeLL.objValue;
    }

    public w4 q(JsonValue jsonValue) {
        InterceptResult invokeL;
        String str;
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonValue)) == null) {
            j4 j4Var = this;
            w4 w4Var = new w4();
            String str3 = null;
            String s = jsonValue.s("id", null);
            if (s != null) {
                w4Var.a = s;
                String str4 = "translation";
                JsonValue m = jsonValue.m("translation");
                if (m == null || m.j == 3) {
                    boolean z = true;
                    w4Var.b = m == null ? null : new Vector3(m.o(0), m.o(1), m.o(2));
                    String str5 = "rotation";
                    JsonValue m2 = jsonValue.m("rotation");
                    if (m2 == null || m2.j == 4) {
                        w4Var.c = m2 == null ? null : new Quaternion(m2.o(0), m2.o(1), m2.o(2), m2.o(3));
                        JsonValue m3 = jsonValue.m(AnimationProperty.SCALE);
                        if (m3 == null || m3.j == 3) {
                            w4Var.d = m3 == null ? null : new Vector3(m3.o(0), m3.o(1), m3.o(2));
                            jsonValue.s("mesh", null);
                            JsonValue m4 = jsonValue.m("parts");
                            if (m4 != null) {
                                w4Var.e = new z4[m4.j];
                                JsonValue jsonValue2 = m4.f;
                                int i2 = 0;
                                while (jsonValue2 != null) {
                                    z4 z4Var = new z4();
                                    String s2 = jsonValue2.s("meshpartid", str3);
                                    String s3 = jsonValue2.s("materialid", str3);
                                    if (s2 != null && s3 != null) {
                                        z4Var.a = s3;
                                        z4Var.b = s2;
                                        JsonValue m5 = jsonValue2.m("bones");
                                        if (m5 != null) {
                                            z4Var.c = new z6<>(z, m5.j, String.class, Matrix4.class);
                                            JsonValue jsonValue3 = m5.f;
                                            while (jsonValue3 != null) {
                                                String s4 = jsonValue3.s(NodeJS.NODE, null);
                                                if (s4 != null) {
                                                    Matrix4 matrix4 = new Matrix4();
                                                    JsonValue m6 = jsonValue3.m(str4);
                                                    if (m6 == null || m6.j < 3) {
                                                        str = str4;
                                                    } else {
                                                        str = str4;
                                                        matrix4.translate(m6.o(0), m6.o(1), m6.o(2));
                                                    }
                                                    JsonValue m7 = jsonValue3.m(str5);
                                                    if (m7 == null || m7.j < 4) {
                                                        str2 = str5;
                                                        i = 3;
                                                    } else {
                                                        str2 = str5;
                                                        i = 3;
                                                        matrix4.rotate(j4Var.e.set(m7.o(0), m7.o(1), m7.o(2), m7.o(3)));
                                                    }
                                                    JsonValue m8 = jsonValue3.m(AnimationProperty.SCALE);
                                                    if (m8 != null && m8.j >= i) {
                                                        matrix4.scale(m8.o(0), m8.o(1), m8.o(2));
                                                    }
                                                    z4Var.c.f(s4, matrix4);
                                                    jsonValue3 = jsonValue3.h;
                                                    j4Var = this;
                                                    str4 = str;
                                                    str5 = str2;
                                                } else {
                                                    throw new GdxRuntimeException("Bone node ID missing");
                                                }
                                            }
                                            continue;
                                        }
                                        w4Var.e[i2] = z4Var;
                                        jsonValue2 = jsonValue2.h;
                                        i2++;
                                        str3 = null;
                                        j4Var = this;
                                        str4 = str4;
                                        str5 = str5;
                                        z = true;
                                    } else {
                                        throw new GdxRuntimeException("Node " + s + " part is missing meshPartId or materialId");
                                    }
                                }
                            }
                            JsonValue m9 = jsonValue.m(CriusAttrConstants.CHILDREN);
                            if (m9 != null) {
                                w4Var.f = new w4[m9.j];
                                JsonValue jsonValue4 = m9.f;
                                int i3 = 0;
                                while (jsonValue4 != null) {
                                    w4Var.f[i3] = q(jsonValue4);
                                    jsonValue4 = jsonValue4.h;
                                    i3++;
                                }
                            }
                            return w4Var;
                        }
                        throw new GdxRuntimeException("Node scale incomplete");
                    }
                    throw new GdxRuntimeException("Node rotation incomplete");
                }
                throw new GdxRuntimeException("Node translation incomplete");
            }
            throw new GdxRuntimeException("Node id missing.");
        }
        return (w4) invokeL.objValue;
    }

    public int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str.equalsIgnoreCase("AMBIENT")) {
                return 4;
            }
            if (str.equalsIgnoreCase("BUMP")) {
                return 8;
            }
            if (str.equalsIgnoreCase("DIFFUSE")) {
                return 2;
            }
            if (str.equalsIgnoreCase("EMISSIVE")) {
                return 3;
            }
            if (str.equalsIgnoreCase("NONE")) {
                return 1;
            }
            if (str.equalsIgnoreCase("NORMAL")) {
                return 7;
            }
            if (str.equalsIgnoreCase("REFLECTION")) {
                return 10;
            }
            if (str.equalsIgnoreCase("SHININESS")) {
                return 6;
            }
            if (str.equalsIgnoreCase("SPECULAR")) {
                return 5;
            }
            return str.equalsIgnoreCase("TRANSPARENCY") ? 9 : 0;
        }
        return invokeL.intValue;
    }

    public int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str.equals("TRIANGLES")) {
                return 4;
            }
            if (str.equals("LINES")) {
                return 1;
            }
            if (str.equals("POINTS")) {
                return 0;
            }
            if (str.equals("TRIANGLE_STRIP")) {
                return 5;
            }
            if (str.equals("LINE_STRIP")) {
                return 3;
            }
            throw new GdxRuntimeException("Unknown primitive type '" + str + "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point");
        }
        return invokeL.intValue;
    }

    public Vector2 t(JsonValue jsonValue, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{jsonValue, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (jsonValue == null) {
                return new Vector2(f, f2);
            }
            if (jsonValue.j == 2) {
                return new Vector2(jsonValue.o(0), jsonValue.o(1));
            }
            throw new GdxRuntimeException("Expected Vector2 values <> than two.");
        }
        return (Vector2) invokeCommon.objValue;
    }
}
