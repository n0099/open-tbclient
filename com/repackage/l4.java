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
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.repackage.a7;
import com.repackage.t1;
/* loaded from: classes6.dex */
public class l4 extends t1<t1.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c7 d;
    public final Quaternion e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l4(c7 c7Var, r1 r1Var) {
        super(r1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c7Var, r1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Quaternion();
        this.d = c7Var;
    }

    @Override // com.repackage.t1
    public v4 h(j3 j3Var, t1.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, j3Var, aVar)) == null) ? o(j3Var) : (v4) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r15v7, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r8v8, types: [T, com.badlogic.gdx.math.Quaternion] */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v17, types: [T, com.badlogic.gdx.math.Quaternion] */
    public void j(v4 v4Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v4Var, jsonValue) == null) {
            v4 v4Var2 = v4Var;
            JsonValue m = jsonValue.m("animations");
            if (m == null) {
                return;
            }
            v4Var2.e.e(m.j);
            JsonValue jsonValue2 = m.f;
            while (jsonValue2 != null) {
                JsonValue m2 = jsonValue2.m("bones");
                if (m2 != null) {
                    u4 u4Var = new u4();
                    v4Var2.e.a(u4Var);
                    u4Var.b.e(m2.j);
                    u4Var.a = jsonValue2.r("id");
                    for (JsonValue jsonValue3 = m2.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        z4 z4Var = new z4();
                        u4Var.b.a(z4Var);
                        z4Var.a = jsonValue3.r("boneId");
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
                                    if (z4Var.b == null) {
                                        z4Var.b = new a7<>();
                                    }
                                    a5<Vector3> a5Var = new a5<>();
                                    a5Var.a = p;
                                    a5Var.b = new Vector3(m4.o(i3), m4.o(i2), m4.o(i));
                                    z4Var.b.a(a5Var);
                                }
                                JsonValue m5 = jsonValue4.m("rotation");
                                if (m5 != null && m5.j == 4) {
                                    if (z4Var.c == null) {
                                        z4Var.c = new a7<>();
                                    }
                                    a5<Quaternion> a5Var2 = new a5<>();
                                    a5Var2.a = p;
                                    a5Var2.b = new Quaternion(m5.o(0), m5.o(i2), m5.o(i), m5.o(3));
                                    z4Var.c.a(a5Var2);
                                }
                                JsonValue m6 = jsonValue4.m("scale");
                                if (m6 != null && m6.j == 3) {
                                    if (z4Var.d == null) {
                                        z4Var.d = new a7<>();
                                    }
                                    a5<Vector3> a5Var3 = new a5<>();
                                    a5Var3.a = p;
                                    a5Var3.b = new Vector3(m6.o(0), m6.o(1), m6.o(2));
                                    z4Var.d.a(a5Var3);
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
                                a7<a5<Vector3>> a7Var = new a7<>();
                                z4Var.b = a7Var;
                                a7Var.e(m7.j);
                                for (JsonValue jsonValue5 = m7.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                    a5<Vector3> a5Var4 = new a5<>();
                                    z4Var.b.a(a5Var4);
                                    a5Var4.a = jsonValue5.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m8 = jsonValue5.m("value");
                                    if (m8 != null && m8.j >= 3) {
                                        a5Var4.b = new Vector3(m8.o(0), m8.o(1), m8.o(2));
                                    }
                                }
                            }
                            JsonValue m9 = jsonValue3.m("rotation");
                            if (m9 != null && m9.v()) {
                                a7<a5<Quaternion>> a7Var2 = new a7<>();
                                z4Var.c = a7Var2;
                                a7Var2.e(m9.j);
                                for (JsonValue jsonValue6 = m9.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                    a5<Quaternion> a5Var5 = new a5<>();
                                    z4Var.c.a(a5Var5);
                                    a5Var5.a = jsonValue6.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m10 = jsonValue6.m("value");
                                    if (m10 != null && m10.j >= 4) {
                                        a5Var5.b = new Quaternion(m10.o(0), m10.o(1), m10.o(2), m10.o(3));
                                    }
                                }
                            }
                            JsonValue m11 = jsonValue3.m("scaling");
                            if (m11 != null && m11.v()) {
                                a7<a5<Vector3>> a7Var3 = new a7<>();
                                z4Var.d = a7Var3;
                                a7Var3.e(m11.j);
                                for (JsonValue jsonValue7 = m11.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                    a5<Vector3> a5Var6 = new a5<>();
                                    z4Var.d.a(a5Var6);
                                    a5Var6.a = jsonValue7.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m12 = jsonValue7.m("value");
                                    if (m12 != null && m12.j >= 3) {
                                        a5Var6.b = new Vector3(m12.o(0), m12.o(1), m12.o(2));
                                    }
                                }
                            }
                        }
                    }
                }
                jsonValue2 = jsonValue2.h;
                v4Var2 = v4Var;
            }
        }
    }

    public s3[] k(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonValue)) == null) {
            a7 a7Var = new a7();
            int i = 0;
            int i2 = 0;
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                String k = jsonValue2.k();
                if (k.equals("POSITION")) {
                    a7Var.a(s3.f());
                } else if (k.equals("NORMAL")) {
                    a7Var.a(s3.e());
                } else if (k.equals("COLOR")) {
                    a7Var.a(s3.d());
                } else if (k.equals("COLORPACKED")) {
                    a7Var.a(s3.c());
                } else if (k.equals("TANGENT")) {
                    a7Var.a(s3.g());
                } else if (k.equals("BINORMAL")) {
                    a7Var.a(s3.a());
                } else if (k.startsWith("TEXCOORD")) {
                    a7Var.a(s3.h(i));
                    i++;
                } else if (k.startsWith("BLENDWEIGHT")) {
                    a7Var.a(s3.b(i2));
                    i2++;
                } else {
                    throw new GdxRuntimeException("Unknown vertex attribute '" + k + "', should be one of position, normal, uv, tangent or binormal");
                }
            }
            return (s3[]) a7Var.n(s3.class);
        }
        return (s3[]) invokeL.objValue;
    }

    public k3 l(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsonValue)) == null) {
            if (jsonValue.j >= 3) {
                return new k3(jsonValue.o(0), jsonValue.o(1), jsonValue.o(2), 1.0f);
            }
            throw new GdxRuntimeException("Expected Color values <> than three.");
        }
        return (k3) invokeL.objValue;
    }

    public void m(v4 v4Var, JsonValue jsonValue, String str) {
        JsonValue m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, v4Var, jsonValue, str) == null) || (m = jsonValue.m("materials")) == null) {
            return;
        }
        v4Var.c.e(m.j);
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
                        c5 c5Var = new c5();
                        if (jsonValue3.s("id", null) != null) {
                            String s2 = jsonValue3.s(BreakpointSQLiteKey.FILENAME, null);
                            if (s2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                String str2 = "/";
                                sb.append((str.length() == 0 || str.endsWith("/")) ? "" : "");
                                sb.append(s2);
                                c5Var.a = sb.toString();
                                c5Var.b = t(jsonValue3.m("uvTranslation"), 0.0f, 0.0f);
                                c5Var.c = t(jsonValue3.m("uvScaling"), 1.0f, 1.0f);
                                String s3 = jsonValue3.s("type", null);
                                if (s3 != null) {
                                    c5Var.d = r(s3);
                                    if (modelMaterial.i == null) {
                                        modelMaterial.i = new a7<>();
                                    }
                                    modelMaterial.i.a(c5Var);
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
                v4Var.c.a(modelMaterial);
            } else {
                throw new GdxRuntimeException("Material needs an id.");
            }
        }
    }

    public void n(v4 v4Var, JsonValue jsonValue) {
        JsonValue m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, v4Var, jsonValue) == null) || (m = jsonValue.m("meshes")) == null) {
            return;
        }
        v4Var.b.e(m.j);
        for (JsonValue jsonValue2 = m.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
            w4 w4Var = new w4();
            jsonValue2.s("id", "");
            w4Var.a = k(jsonValue2.L("attributes"));
            w4Var.b = jsonValue2.L("vertices").f();
            JsonValue L = jsonValue2.L("parts");
            a7 a7Var = new a7();
            for (JsonValue jsonValue3 = L.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                x4 x4Var = new x4();
                String s = jsonValue3.s("id", null);
                if (s != null) {
                    a7.b it = a7Var.iterator();
                    while (it.hasNext()) {
                        if (((x4) it.next()).a.equals(s)) {
                            throw new GdxRuntimeException("Mesh part with id '" + s + "' already in defined");
                        }
                    }
                    x4Var.a = s;
                    String s2 = jsonValue3.s("type", null);
                    if (s2 != null) {
                        x4Var.c = s(s2);
                        x4Var.b = jsonValue3.L("indices").j();
                        a7Var.a(x4Var);
                    } else {
                        throw new GdxRuntimeException("No primitive type given for mesh part '" + s + "'");
                    }
                } else {
                    throw new GdxRuntimeException("Not id given for mesh part");
                }
            }
            w4Var.c = (x4[]) a7Var.n(x4.class);
            v4Var.b.a(w4Var);
        }
    }

    public v4 o(j3 j3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, j3Var)) == null) {
            JsonValue a = this.d.a(j3Var);
            v4 v4Var = new v4();
            JsonValue L = a.L("version");
            v4Var.a[0] = L.q(0);
            v4Var.a[1] = L.q(1);
            short[] sArr = v4Var.a;
            if (sArr[0] == 0 && sArr[1] == 1) {
                a.s("id", "");
                n(v4Var, a);
                m(v4Var, a, j3Var.i().j());
                p(v4Var, a);
                j(v4Var, a);
                return v4Var;
            }
            throw new GdxRuntimeException("Model version not supported");
        }
        return (v4) invokeL.objValue;
    }

    public a7<y4> p(v4 v4Var, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, v4Var, jsonValue)) == null) {
            JsonValue m = jsonValue.m("nodes");
            if (m != null) {
                v4Var.d.e(m.j);
                for (JsonValue jsonValue2 = m.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    v4Var.d.a(q(jsonValue2));
                }
            }
            return v4Var.d;
        }
        return (a7) invokeLL.objValue;
    }

    public y4 q(JsonValue jsonValue) {
        InterceptResult invokeL;
        String str;
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonValue)) == null) {
            l4 l4Var = this;
            y4 y4Var = new y4();
            String str3 = null;
            String s = jsonValue.s("id", null);
            if (s != null) {
                y4Var.a = s;
                String str4 = "translation";
                JsonValue m = jsonValue.m("translation");
                if (m == null || m.j == 3) {
                    boolean z = true;
                    y4Var.b = m == null ? null : new Vector3(m.o(0), m.o(1), m.o(2));
                    String str5 = "rotation";
                    JsonValue m2 = jsonValue.m("rotation");
                    if (m2 == null || m2.j == 4) {
                        y4Var.c = m2 == null ? null : new Quaternion(m2.o(0), m2.o(1), m2.o(2), m2.o(3));
                        JsonValue m3 = jsonValue.m("scale");
                        if (m3 == null || m3.j == 3) {
                            y4Var.d = m3 == null ? null : new Vector3(m3.o(0), m3.o(1), m3.o(2));
                            jsonValue.s("mesh", null);
                            JsonValue m4 = jsonValue.m("parts");
                            if (m4 != null) {
                                y4Var.e = new b5[m4.j];
                                JsonValue jsonValue2 = m4.f;
                                int i2 = 0;
                                while (jsonValue2 != null) {
                                    b5 b5Var = new b5();
                                    String s2 = jsonValue2.s("meshpartid", str3);
                                    String s3 = jsonValue2.s("materialid", str3);
                                    if (s2 != null && s3 != null) {
                                        b5Var.a = s3;
                                        b5Var.b = s2;
                                        JsonValue m5 = jsonValue2.m("bones");
                                        if (m5 != null) {
                                            b5Var.c = new b7<>(z, m5.j, String.class, Matrix4.class);
                                            JsonValue jsonValue3 = m5.f;
                                            while (jsonValue3 != null) {
                                                String s4 = jsonValue3.s("node", null);
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
                                                        matrix4.rotate(l4Var.e.set(m7.o(0), m7.o(1), m7.o(2), m7.o(3)));
                                                    }
                                                    JsonValue m8 = jsonValue3.m("scale");
                                                    if (m8 != null && m8.j >= i) {
                                                        matrix4.scale(m8.o(0), m8.o(1), m8.o(2));
                                                    }
                                                    b5Var.c.f(s4, matrix4);
                                                    jsonValue3 = jsonValue3.h;
                                                    l4Var = this;
                                                    str4 = str;
                                                    str5 = str2;
                                                } else {
                                                    throw new GdxRuntimeException("Bone node ID missing");
                                                }
                                            }
                                            continue;
                                        }
                                        y4Var.e[i2] = b5Var;
                                        jsonValue2 = jsonValue2.h;
                                        i2++;
                                        str3 = null;
                                        l4Var = this;
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
                                y4Var.f = new y4[m9.j];
                                JsonValue jsonValue4 = m9.f;
                                int i3 = 0;
                                while (jsonValue4 != null) {
                                    y4Var.f[i3] = q(jsonValue4);
                                    jsonValue4 = jsonValue4.h;
                                    i3++;
                                }
                            }
                            return y4Var;
                        }
                        throw new GdxRuntimeException("Node scale incomplete");
                    }
                    throw new GdxRuntimeException("Node rotation incomplete");
                }
                throw new GdxRuntimeException("Node translation incomplete");
            }
            throw new GdxRuntimeException("Node id missing.");
        }
        return (y4) invokeL.objValue;
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
            if (str.equalsIgnoreCase(HlsPlaylistParser.METHOD_NONE)) {
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
