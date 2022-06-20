package com.repackage;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.a7;
import com.repackage.t1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class n4 extends t1<b> {
    public static /* synthetic */ Interceptable $ic;
    public static boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public final i7 d;
    public final i7 e;
    public final i7 f;
    public final a7<a> g;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public String b;
        public a7<Integer> c;
        public int d;
        public boolean e;
        public boolean f;

        public a(n4 n4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.c = new a7<>(200);
            this.d = 0;
            new f4("");
            this.b = "default";
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends t1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964034241, "Lcom/repackage/n4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964034241, "Lcom/repackage/n4;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n4(r1 r1Var) {
        super(r1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new i7(300);
        this.e = new i7(300);
        this.f = new i7(200);
        this.g = new a7<>(10);
    }

    public final int j(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            int parseInt = Integer.parseInt(str);
            return parseInt < 0 ? i + parseInt : parseInt - 1;
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t1
    /* renamed from: k */
    public v4 h(j3 j3Var, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, j3Var, bVar)) == null) {
            return l(j3Var, bVar != null && bVar.c);
        }
        return (v4) invokeLL.objValue;
    }

    public v4 l(j3 j3Var, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, j3Var, z)) == null) {
            if (h) {
                e1.a.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
            }
            m4 m4Var = new m4();
            a aVar = new a(this, "default");
            this.g.a(aVar);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(j3Var.m()), 4096);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("\\s+");
                    if (split.length < 1) {
                        break;
                    } else if (split[0].length() != 0 && (charAt = split[0].toLowerCase().charAt(0)) != '#') {
                        if (charAt == 'v') {
                            if (split[0].length() == 1) {
                                this.d.a(Float.parseFloat(split[1]));
                                this.d.a(Float.parseFloat(split[2]));
                                this.d.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 'n') {
                                this.e.a(Float.parseFloat(split[1]));
                                this.e.a(Float.parseFloat(split[2]));
                                this.e.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 't') {
                                this.f.a(Float.parseFloat(split[1]));
                                this.f.a(z ? 1.0f - Float.parseFloat(split[2]) : Float.parseFloat(split[2]));
                            }
                        } else if (charAt == 'f') {
                            a7<Integer> a7Var = aVar.c;
                            int i3 = 1;
                            while (i3 < split.length - 2) {
                                String[] split2 = split[1].split("/");
                                a7Var.a(Integer.valueOf(j(split2[0], this.d.b)));
                                if (split2.length > 2) {
                                    if (i3 == 1) {
                                        aVar.e = true;
                                    }
                                    a7Var.a(Integer.valueOf(j(split2[2], this.e.b)));
                                }
                                if (split2.length > 1 && split2[1].length() > 0) {
                                    if (i3 == 1) {
                                        aVar.f = true;
                                    }
                                    a7Var.a(Integer.valueOf(j(split2[1], this.f.b)));
                                }
                                int i4 = i3 + 1;
                                String[] split3 = split[i4].split("/");
                                a7Var.a(Integer.valueOf(j(split3[0], this.d.b)));
                                if (split3.length > 2) {
                                    a7Var.a(Integer.valueOf(j(split3[2], this.e.b)));
                                }
                                if (split3.length > 1 && split3[1].length() > 0) {
                                    a7Var.a(Integer.valueOf(j(split3[1], this.f.b)));
                                }
                                int i5 = i4 + 1;
                                String[] split4 = split[i5].split("/");
                                a7Var.a(Integer.valueOf(j(split4[0], this.d.b)));
                                if (split4.length > 2) {
                                    a7Var.a(Integer.valueOf(j(split4[2], this.e.b)));
                                }
                                if (split4.length > 1 && split4[1].length() > 0) {
                                    a7Var.a(Integer.valueOf(j(split4[1], this.f.b)));
                                }
                                aVar.d++;
                                i3 = i5 - 1;
                            }
                        } else {
                            if (charAt != 'o' && charAt != 'g') {
                                if (split[0].equals("mtllib")) {
                                    m4Var.b(j3Var.i().a(split[1]));
                                } else if (split[0].equals("usemtl")) {
                                    if (split.length == 1) {
                                        aVar.b = "default";
                                    } else {
                                        aVar.b = split[1].replace(IStringUtil.EXTENSION_SEPARATOR, '_');
                                    }
                                }
                            }
                            if (split.length > 1) {
                                aVar = m(split[1]);
                            } else {
                                aVar = m("default");
                            }
                        }
                    }
                } catch (IOException unused) {
                    return null;
                }
            }
            bufferedReader.close();
            int i6 = 0;
            while (true) {
                a7<a> a7Var2 = this.g;
                i = a7Var2.b;
                if (i6 >= i) {
                    break;
                }
                if (a7Var2.get(i6).d < 1) {
                    this.g.i(i6);
                    i6--;
                }
                i6++;
            }
            if (i < 1) {
                return null;
            }
            v4 v4Var = new v4();
            int i7 = 0;
            int i8 = 0;
            while (i7 < i) {
                a aVar2 = this.g.get(i7);
                a7<Integer> a7Var3 = aVar2.c;
                int i9 = a7Var3.b;
                int i10 = aVar2.d;
                boolean z2 = aVar2.e;
                boolean z3 = aVar2.f;
                int i11 = i10 * 3;
                float[] fArr = new float[i11 * ((z2 ? 3 : 0) + 3 + (z3 ? 2 : 0))];
                int i12 = 0;
                int i13 = 0;
                while (i12 < i9) {
                    int i14 = i12 + 1;
                    int intValue = a7Var3.get(i12).intValue() * 3;
                    int i15 = i13 + 1;
                    int i16 = i;
                    int i17 = i9;
                    int i18 = intValue + 1;
                    fArr[i13] = this.d.c(intValue);
                    int i19 = i15 + 1;
                    int i20 = i7;
                    fArr[i15] = this.d.c(i18);
                    int i21 = i19 + 1;
                    fArr[i19] = this.d.c(i18 + 1);
                    if (z2) {
                        int i22 = i14 + 1;
                        int intValue2 = a7Var3.get(i14).intValue() * 3;
                        int i23 = i21 + 1;
                        int i24 = intValue2 + 1;
                        fArr[i21] = this.e.c(intValue2);
                        int i25 = i23 + 1;
                        fArr[i23] = this.e.c(i24);
                        i21 = i25 + 1;
                        fArr[i25] = this.e.c(i24 + 1);
                        i14 = i22;
                    }
                    if (z3) {
                        int i26 = i14 + 1;
                        int intValue3 = a7Var3.get(i14).intValue() * 2;
                        int i27 = i21 + 1;
                        int i28 = intValue3 + 1;
                        fArr[i21] = this.f.c(intValue3);
                        i2 = i27 + 1;
                        fArr[i27] = this.f.c(i28);
                        i12 = i26;
                    } else {
                        i2 = i21;
                        i12 = i14;
                    }
                    i9 = i17;
                    i7 = i20;
                    i13 = i2;
                    i = i16;
                }
                int i29 = i7;
                int i30 = i;
                if (i11 >= 32767) {
                    i11 = 0;
                }
                short[] sArr = new short[i11];
                if (i11 > 0) {
                    for (int i31 = 0; i31 < i11; i31++) {
                        sArr[i31] = (short) i31;
                    }
                }
                a7 a7Var4 = new a7();
                a7Var4.a(new s3(1, 3, "a_position"));
                if (z2) {
                    a7Var4.a(new s3(8, 3, "a_normal"));
                }
                if (z3) {
                    a7Var4.a(new s3(16, 2, "a_texCoord0"));
                }
                i8++;
                String num = Integer.toString(i8);
                String str = "default".equals(aVar2.a) ? NodeJS.NODE + num : aVar2.a;
                if ("default".equals(aVar2.a)) {
                    String str2 = "mesh" + num;
                } else {
                    String str3 = aVar2.a;
                }
                String str4 = "default".equals(aVar2.a) ? SpeedStatsMainTable.PART + num : aVar2.a;
                y4 y4Var = new y4();
                y4Var.a = str;
                y4Var.d = new Vector3(1.0f, 1.0f, 1.0f);
                y4Var.b = new Vector3();
                y4Var.c = new Quaternion();
                b5 b5Var = new b5();
                b5Var.b = str4;
                b5Var.a = aVar2.b;
                y4Var.e = new b5[]{b5Var};
                x4 x4Var = new x4();
                x4Var.a = str4;
                x4Var.b = sArr;
                x4Var.c = 4;
                w4 w4Var = new w4();
                w4Var.a = (s3[]) a7Var4.n(s3.class);
                w4Var.b = fArr;
                w4Var.c = new x4[]{x4Var};
                v4Var.d.a(y4Var);
                v4Var.b.a(w4Var);
                v4Var.c.a(m4Var.a(aVar2.b));
                i7 = i29 + 1;
                i = i30;
            }
            i7 i7Var = this.d;
            if (i7Var.b > 0) {
                i7Var.b();
            }
            i7 i7Var2 = this.e;
            if (i7Var2.b > 0) {
                i7Var2.b();
            }
            i7 i7Var3 = this.f;
            if (i7Var3.b > 0) {
                i7Var3.b();
            }
            a7<a> a7Var5 = this.g;
            if (a7Var5.b > 0) {
                a7Var5.clear();
            }
            return v4Var;
        }
        return (v4) invokeLZ.objValue;
    }

    public final a m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            a7.b<a> it = this.g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            a aVar = new a(this, str);
            this.g.a(aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
