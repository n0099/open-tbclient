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
            JsonValue l = jsonValue.l("animations");
            if (l == null) {
                return;
            }
            v4Var2.e.e(l.j);
            JsonValue jsonValue2 = l.f;
            while (jsonValue2 != null) {
                JsonValue l2 = jsonValue2.l("bones");
                if (l2 != null) {
                    u4 u4Var = new u4();
                    v4Var2.e.a(u4Var);
                    u4Var.b.e(l2.j);
                    u4Var.a = jsonValue2.q("id");
                    for (JsonValue jsonValue3 = l2.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        z4 z4Var = new z4();
                        u4Var.b.a(z4Var);
                        z4Var.a = jsonValue3.q("boneId");
                        JsonValue l3 = jsonValue3.l("keyframes");
                        float f = 1000.0f;
                        float f2 = 0.0f;
                        int i = 2;
                        int i2 = 1;
                        int i3 = 0;
                        int i4 = 3;
                        if (l3 != null && l3.u()) {
                            JsonValue jsonValue4 = l3.f;
                            while (jsonValue4 != null) {
                                float o = jsonValue4.o("keytime", f2) / f;
                                JsonValue l4 = jsonValue4.l("translation");
                                if (l4 != null && l4.j == i4) {
                                    if (z4Var.b == null) {
                                        z4Var.b = new a7<>();
                                    }
                                    a5<Vector3> a5Var = new a5<>();
                                    a5Var.a = o;
                                    a5Var.b = new Vector3(l4.n(i3), l4.n(i2), l4.n(i));
                                    z4Var.b.a(a5Var);
                                }
                                JsonValue l5 = jsonValue4.l("rotation");
                                if (l5 != null && l5.j == 4) {
                                    if (z4Var.c == null) {
                                        z4Var.c = new a7<>();
                                    }
                                    a5<Quaternion> a5Var2 = new a5<>();
                                    a5Var2.a = o;
                                    a5Var2.b = new Quaternion(l5.n(0), l5.n(i2), l5.n(i), l5.n(3));
                                    z4Var.c.a(a5Var2);
                                }
                                JsonValue l6 = jsonValue4.l("scale");
                                if (l6 != null && l6.j == 3) {
                                    if (z4Var.d == null) {
                                        z4Var.d = new a7<>();
                                    }
                                    a5<Vector3> a5Var3 = new a5<>();
                                    a5Var3.a = o;
                                    a5Var3.b = new Vector3(l6.n(0), l6.n(1), l6.n(2));
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
                            JsonValue l7 = jsonValue3.l("translation");
                            if (l7 != null && l7.u()) {
                                a7<a5<Vector3>> a7Var = new a7<>();
                                z4Var.b = a7Var;
                                a7Var.e(l7.j);
                                for (JsonValue jsonValue5 = l7.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                    a5<Vector3> a5Var4 = new a5<>();
                                    z4Var.b.a(a5Var4);
                                    a5Var4.a = jsonValue5.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l8 = jsonValue5.l("value");
                                    if (l8 != null && l8.j >= 3) {
                                        a5Var4.b = new Vector3(l8.n(0), l8.n(1), l8.n(2));
                                    }
                                }
                            }
                            JsonValue l9 = jsonValue3.l("rotation");
                            if (l9 != null && l9.u()) {
                                a7<a5<Quaternion>> a7Var2 = new a7<>();
                                z4Var.c = a7Var2;
                                a7Var2.e(l9.j);
                                for (JsonValue jsonValue6 = l9.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                    a5<Quaternion> a5Var5 = new a5<>();
                                    z4Var.c.a(a5Var5);
                                    a5Var5.a = jsonValue6.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l10 = jsonValue6.l("value");
                                    if (l10 != null && l10.j >= 4) {
                                        a5Var5.b = new Quaternion(l10.n(0), l10.n(1), l10.n(2), l10.n(3));
                                    }
                                }
                            }
                            JsonValue l11 = jsonValue3.l("scaling");
                            if (l11 != null && l11.u()) {
                                a7<a5<Vector3>> a7Var3 = new a7<>();
                                z4Var.d = a7Var3;
                                a7Var3.e(l11.j);
                                for (JsonValue jsonValue7 = l11.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                    a5<Vector3> a5Var6 = new a5<>();
                                    z4Var.d.a(a5Var6);
                                    a5Var6.a = jsonValue7.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l12 = jsonValue7.l("value");
                                    if (l12 != null && l12.j >= 3) {
                                        a5Var6.b = new Vector3(l12.n(0), l12.n(1), l12.n(2));
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
                String j = jsonValue2.j();
                if (j.equals("POSITION")) {
                    a7Var.a(s3.f());
                } else if (j.equals("NORMAL")) {
                    a7Var.a(s3.e());
                } else if (j.equals("COLOR")) {
                    a7Var.a(s3.d());
                } else if (j.equals("COLORPACKED")) {
                    a7Var.a(s3.c());
                } else if (j.equals("TANGENT")) {
                    a7Var.a(s3.g());
                } else if (j.equals("BINORMAL")) {
                    a7Var.a(s3.a());
                } else if (j.startsWith("TEXCOORD")) {
                    a7Var.a(s3.h(i));
                    i++;
                } else if (j.startsWith("BLENDWEIGHT")) {
                    a7Var.a(s3.b(i2));
                    i2++;
                } else {
                    throw new GdxRuntimeException("Unknown vertex attribute '" + j + "', should be one of position, normal, uv, tangent or binormal");
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
                return new k3(jsonValue.n(0), jsonValue.n(1), jsonValue.n(2), 1.0f);
            }
            throw new GdxRuntimeException("Expected Color values <> than three.");
        }
        return (k3) invokeL.objValue;
    }

    public void m(v4 v4Var, JsonValue jsonValue, String str) {
        JsonValue l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, v4Var, jsonValue, str) == null) || (l = jsonValue.l("materials")) == null) {
            return;
        }
        v4Var.c.e(l.j);
        for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
            ModelMaterial modelMaterial = new ModelMaterial();
            String r = jsonValue2.r("id", null);
            if (r != null) {
                modelMaterial.a = r;
                JsonValue l2 = jsonValue2.l("diffuse");
                if (l2 != null) {
                    modelMaterial.c = l(l2);
                }
                JsonValue l3 = jsonValue2.l("ambient");
                if (l3 != null) {
                    modelMaterial.b = l(l3);
                }
                JsonValue l4 = jsonValue2.l("emissive");
                if (l4 != null) {
                    modelMaterial.e = l(l4);
                }
                JsonValue l5 = jsonValue2.l("specular");
                if (l5 != null) {
                    modelMaterial.d = l(l5);
                }
                JsonValue l6 = jsonValue2.l("reflection");
                if (l6 != null) {
                    modelMaterial.f = l(l6);
                }
                modelMaterial.g = jsonValue2.o("shininess", 0.0f);
                modelMaterial.h = jsonValue2.o(NativeConstants.OPACITY, 1.0f);
                JsonValue l7 = jsonValue2.l("textures");
                if (l7 != null) {
                    for (JsonValue jsonValue3 = l7.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        c5 c5Var = new c5();
                        if (jsonValue3.r("id", null) != null) {
                            String r2 = jsonValue3.r(BreakpointSQLiteKey.FILENAME, null);
                            if (r2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                String str2 = "/";
                                sb.append((str.length() == 0 || str.endsWith("/")) ? "" : "");
                                sb.append(r2);
                                c5Var.a = sb.toString();
                                c5Var.b = t(jsonValue3.l("uvTranslation"), 0.0f, 0.0f);
                                c5Var.c = t(jsonValue3.l("uvScaling"), 1.0f, 1.0f);
                                String r3 = jsonValue3.r("type", null);
                                if (r3 != null) {
                                    c5Var.d = r(r3);
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
        JsonValue l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, v4Var, jsonValue) == null) || (l = jsonValue.l("meshes")) == null) {
            return;
        }
        v4Var.b.e(l.j);
        for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
            w4 w4Var = new w4();
            jsonValue2.r("id", "");
            w4Var.a = k(jsonValue2.K("attributes"));
            w4Var.b = jsonValue2.K("vertices").e();
            JsonValue K = jsonValue2.K("parts");
            a7 a7Var = new a7();
            for (JsonValue jsonValue3 = K.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                x4 x4Var = new x4();
                String r = jsonValue3.r("id", null);
                if (r != null) {
                    a7.b it = a7Var.iterator();
                    while (it.hasNext()) {
                        if (((x4) it.next()).a.equals(r)) {
                            throw new GdxRuntimeException("Mesh part with id '" + r + "' already in defined");
                        }
                    }
                    x4Var.a = r;
                    String r2 = jsonValue3.r("type", null);
                    if (r2 != null) {
                        x4Var.c = s(r2);
                        x4Var.b = jsonValue3.K("indices").i();
                        a7Var.a(x4Var);
                    } else {
                        throw new GdxRuntimeException("No primitive type given for mesh part '" + r + "'");
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
            JsonValue K = a.K("version");
            v4Var.a[0] = K.p(0);
            v4Var.a[1] = K.p(1);
            short[] sArr = v4Var.a;
            if (sArr[0] == 0 && sArr[1] == 1) {
                a.r("id", "");
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
            JsonValue l = jsonValue.l("nodes");
            if (l != null) {
                v4Var.d.e(l.j);
                for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
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
            String r = jsonValue.r("id", null);
            if (r != null) {
                y4Var.a = r;
                String str4 = "translation";
                JsonValue l = jsonValue.l("translation");
                if (l == null || l.j == 3) {
                    boolean z = true;
                    y4Var.b = l == null ? null : new Vector3(l.n(0), l.n(1), l.n(2));
                    String str5 = "rotation";
                    JsonValue l2 = jsonValue.l("rotation");
                    if (l2 == null || l2.j == 4) {
                        y4Var.c = l2 == null ? null : new Quaternion(l2.n(0), l2.n(1), l2.n(2), l2.n(3));
                        JsonValue l3 = jsonValue.l("scale");
                        if (l3 == null || l3.j == 3) {
                            y4Var.d = l3 == null ? null : new Vector3(l3.n(0), l3.n(1), l3.n(2));
                            jsonValue.r("mesh", null);
                            JsonValue l4 = jsonValue.l("parts");
                            if (l4 != null) {
                                y4Var.e = new b5[l4.j];
                                JsonValue jsonValue2 = l4.f;
                                int i2 = 0;
                                while (jsonValue2 != null) {
                                    b5 b5Var = new b5();
                                    String r2 = jsonValue2.r("meshpartid", str3);
                                    String r3 = jsonValue2.r("materialid", str3);
                                    if (r2 != null && r3 != null) {
                                        b5Var.a = r3;
                                        b5Var.b = r2;
                                        JsonValue l5 = jsonValue2.l("bones");
                                        if (l5 != null) {
                                            b5Var.c = new b7<>(z, l5.j, String.class, Matrix4.class);
                                            JsonValue jsonValue3 = l5.f;
                                            while (jsonValue3 != null) {
                                                String r4 = jsonValue3.r("node", null);
                                                if (r4 != null) {
                                                    Matrix4 matrix4 = new Matrix4();
                                                    JsonValue l6 = jsonValue3.l(str4);
                                                    if (l6 == null || l6.j < 3) {
                                                        str = str4;
                                                    } else {
                                                        str = str4;
                                                        matrix4.translate(l6.n(0), l6.n(1), l6.n(2));
                                                    }
                                                    JsonValue l7 = jsonValue3.l(str5);
                                                    if (l7 == null || l7.j < 4) {
                                                        str2 = str5;
                                                        i = 3;
                                                    } else {
                                                        str2 = str5;
                                                        i = 3;
                                                        matrix4.rotate(l4Var.e.set(l7.n(0), l7.n(1), l7.n(2), l7.n(3)));
                                                    }
                                                    JsonValue l8 = jsonValue3.l("scale");
                                                    if (l8 != null && l8.j >= i) {
                                                        matrix4.scale(l8.n(0), l8.n(1), l8.n(2));
                                                    }
                                                    b5Var.c.e(r4, matrix4);
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
                                        throw new GdxRuntimeException("Node " + r + " part is missing meshPartId or materialId");
                                    }
                                }
                            }
                            JsonValue l9 = jsonValue.l(CriusAttrConstants.CHILDREN);
                            if (l9 != null) {
                                y4Var.f = new y4[l9.j];
                                JsonValue jsonValue4 = l9.f;
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
                return new Vector2(jsonValue.n(0), jsonValue.n(1));
            }
            throw new GdxRuntimeException("Expected Vector2 values <> than two.");
        }
        return (Vector2) invokeCommon.objValue;
    }
}
