package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class w1 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334603133, "Lcom/kuaishou/weapon/p0/w1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334603133, "Lcom/kuaishou/weapon/p0/w1;");
                return;
            }
        }
        d = new byte[0];
    }

    public w1(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = z;
        this.c = i;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                synchronized (d) {
                    JSONObject a = new n2(str, l2.j).a(this.a);
                    if (a == null) {
                        return null;
                    }
                    JSONObject a2 = a();
                    if (a2 == null) {
                        return null;
                    }
                    a.put("module_section", a2);
                    return a.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v3 double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v4 double)] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x04f3 A[Catch: all -> 0x0556, TRY_ENTER, TryCatch #2 {all -> 0x0556, blocks: (B:166:0x0398, B:168:0x03a0, B:169:0x03a5, B:172:0x03bd, B:174:0x03ca, B:176:0x03d3, B:178:0x03dc, B:180:0x03e5, B:182:0x03ee, B:184:0x03f7, B:186:0x0400, B:188:0x0409, B:190:0x0412, B:192:0x041b, B:194:0x0424, B:196:0x042d, B:198:0x0436, B:200:0x043f, B:202:0x0448, B:204:0x0451, B:206:0x045a, B:208:0x0463, B:210:0x046c, B:212:0x0475, B:216:0x04bb, B:218:0x04c6, B:220:0x04d1, B:222:0x04da, B:225:0x04f3, B:227:0x0500, B:229:0x0506, B:231:0x050f, B:233:0x0515, B:235:0x051e, B:237:0x0524, B:239:0x052d, B:240:0x0531, B:242:0x0535, B:211:0x0471, B:207:0x045f, B:203:0x044d, B:199:0x043b, B:195:0x0429, B:191:0x0417, B:187:0x0405, B:183:0x03f3, B:179:0x03e1, B:175:0x03cf, B:213:0x0479), top: B:267:0x0398 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0535 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a() {
        InterceptResult invokeV;
        Object L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                i a = i.a(this.a, "re_po_rt");
                boolean b = a.b("a1_p_s_p_s");
                boolean b2 = a.b("a1_p_s_p_s_c_b");
                jSONObject.put("11006", b ? 1 : 0);
                jSONObject.put("11029", b2 ? 1 : 0);
                if (a.a(f3.o0, 1) == 1 && (b || b2)) {
                    String j = h1.j(this.a);
                    if (!TextUtils.isEmpty(j) && !j.startsWith("RISK")) {
                        jSONObject.put("01001", g.a(j));
                    }
                    String p = h1.p(this.a);
                    if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                        jSONObject.put("01003", p);
                    }
                    String b3 = h1.b(this.a, 0);
                    if (!TextUtils.isEmpty(b3) && !b3.startsWith("RISK")) {
                        jSONObject.put("01019", b3);
                    }
                    String b4 = h1.b(this.a, 1);
                    if (!TextUtils.isEmpty(b4) && !b4.startsWith("RISK")) {
                        jSONObject.put("01004", g.a(b4));
                    }
                }
                int a2 = a.a(f3.n0, 1);
                if (a2 == 1 && (b || b2)) {
                    String c = h1.c(this.a);
                    if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                        jSONObject.put("01013", c);
                    }
                }
                if (a.a(f3.p0, 1) == 1 && (b || b2)) {
                    String r = h1.r(this.a);
                    if (!TextUtils.isEmpty(r) && !r.startsWith("RISK")) {
                        jSONObject.put("01007", r);
                    }
                }
                if (a.a(f3.q0, 1) == 1 && (b || b2)) {
                    jSONObject.put("01011", h1.o(this.a));
                }
                if (b || b2) {
                    String g = h1.g();
                    if ((TextUtils.isEmpty(g) || g.startsWith("RISK")) && g == null) {
                        jSONObject.put("07005", "");
                    } else {
                        jSONObject.put("07005", g);
                    }
                    jSONObject.put("07006", h1.d());
                }
                if (a.a(f3.s0, 1) == 1 && (b || b2)) {
                    String g2 = h1.g(this.a);
                    if (!TextUtils.isEmpty(g2) && !g2.startsWith("RISK")) {
                        jSONObject.put("01016", g2);
                    }
                }
                if (b || b2) {
                    try {
                        double e = h1.e();
                        if (e > 0.0d) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(e);
                            jSONObject.put("09002", sb.toString());
                        }
                        double f = h1.f();
                        if (f > 0.0d) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(f);
                            jSONObject.put("09003", sb2.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
                jSONObject.put("11013", Integer.parseInt(x1.a(this.a.getApplicationContext()), 2));
                jSONObject.put("11012", x1.d(this.a));
                jSONObject.put("11011", h1.u(this.a));
                try {
                    jSONObject.put("11202", h1.b(com.kwad.sdk.c.b.xm().xb()));
                    jSONObject.put("11203", h1.b(com.kwad.sdk.c.b.xm().xk()));
                    jSONObject.put("11204", h1.b(com.kwad.sdk.c.b.xm().xi()));
                    jSONObject.put("11205", h1.b(com.kwad.sdk.c.b.xm().getDeviceId()));
                    jSONObject.put("11206", h1.b(com.kwad.sdk.c.b.xm().getIccId()));
                    jSONObject.put("11207", h1.b(com.kwad.sdk.c.b.xm().xa()));
                    jSONObject.put("11208", h1.b(com.kwad.sdk.c.b.xm().xd()));
                    jSONObject.put("11209", h1.b(com.kwad.sdk.c.b.xm().xe()));
                    jSONObject.put("11210", h1.b(com.kwad.sdk.c.b.xm().xf()));
                    jSONObject.put("11211", h1.b(com.kwad.sdk.c.b.xm().getIp()));
                    jSONObject.put("11212", h1.b(com.kwad.sdk.c.b.xm().getLocation()));
                    jSONObject.put("11213", h1.b(com.kwad.sdk.c.b.xm().getOaid()));
                    jSONObject.put("11214", h1.b(com.kwad.sdk.c.b.xm().xc()));
                    jSONObject.put("11215", h1.b(com.kwad.sdk.c.b.xm().xh()));
                    jSONObject.put("11216", h1.b(com.kwad.sdk.c.b.xm().xg()));
                    jSONObject.put("11301", h1.c(com.kwad.sdk.c.b.xm().xl()));
                    jSONObject.put("11302", h1.c(com.kwad.sdk.c.b.xm().getSdkVersion()));
                    jSONObject.put("11303", h1.c(com.kwad.sdk.c.b.xm().getAppId()));
                    jSONObject.put("11104", com.kwad.sdk.c.b.xm().xi());
                    jSONObject.put("11105", com.kwad.sdk.c.b.xm().getDeviceId());
                    jSONObject.put("11106", com.kwad.sdk.c.b.xm().getIccId());
                    jSONObject.put("11107", com.kwad.sdk.c.b.xm().xa());
                    jSONObject.put("11108", com.kwad.sdk.c.b.xm().xd());
                    jSONObject.put("11109", com.kwad.sdk.c.b.xm().xe());
                    jSONObject.put("11110", com.kwad.sdk.c.b.xm().xf());
                    jSONObject.put("11111", com.kwad.sdk.c.b.xm().getIp());
                    jSONObject.put("11112", com.kwad.sdk.c.b.xm().getLocation());
                    jSONObject.put("11113", com.kwad.sdk.c.b.xm().getOaid());
                    jSONObject.put("11114", com.kwad.sdk.c.b.xm().xc());
                    jSONObject.put("11115", com.kwad.sdk.c.b.xm().xh());
                    jSONObject.put("11116", com.kwad.sdk.c.b.xm().xg());
                } catch (Throwable unused2) {
                }
                String v = h1.v(this.a);
                if (!TextUtils.isEmpty(v)) {
                    jSONObject.put("01026", v);
                }
                if (a2 == 1) {
                    try {
                        Object a3 = i0.a(this.a);
                        if (a3 != null) {
                            jSONObject.put("11015", a3);
                        }
                        if (Engine.loadSuccess) {
                            e2 e2Var = new e2(this.a);
                            jSONObject.put("02001", e2Var.a("02001") != null ? e2Var.a("02001") : l1.u());
                            jSONObject.put("02002", e2Var.a("02002") != null ? e2Var.a("02002") : l1.h());
                            jSONObject.put("02003", e2Var.a("02003") != null ? e2Var.a("02003") : l1.v());
                            jSONObject.put("02007", e2Var.a("02007") != null ? e2Var.a("02007") : l1.f());
                            jSONObject.put("02006", e2Var.a("02006") != null ? e2Var.a("02006") : l1.l());
                            jSONObject.put("02004", e2Var.a("02004") != null ? e2Var.a("02004") : l1.p());
                            jSONObject.put("02005", e2Var.a("02005") != null ? e2Var.a("02005") : l1.y());
                            jSONObject.put("02018", e2Var.a("02018") != null ? e2Var.a("02018") : l1.n());
                            jSONObject.put("02013", e2Var.a("02013") != null ? e2Var.a("02013") : l1.i());
                            if (e2Var.a("02016") != null) {
                                L = e2Var.a("02016");
                                jSONObject.put("02016", L);
                                jSONObject.put("02021", l1.e(this.a));
                                jSONObject.put("02022", l1.h(this.a));
                                jSONObject.put("02044", l1.F());
                                jSONObject.put("11009", s1.b(this.a.getApplicationContext()));
                                if (Engine.loadSuccess) {
                                    try {
                                        j1 b5 = k1.b();
                                        jSONObject.put("04001", k1.a());
                                        jSONObject.put("04002", b5.c());
                                        jSONObject.put("04003", b5.a());
                                        jSONObject.put("04004", b5.b());
                                    } catch (Exception unused3) {
                                    }
                                } else {
                                    z1 z1Var = new z1(this.a);
                                    jSONObject.put("04001", z1Var.a("04001") != null ? z1Var.a("04001") : "");
                                    jSONObject.put("04002", z1Var.a("04002") != null ? z1Var.a("04002") : "");
                                    jSONObject.put("04003", z1Var.a("04003") != null ? z1Var.a("04003") : "");
                                    jSONObject.put("04004", z1Var.a("04004") != null ? z1Var.a("04004") : "");
                                }
                            }
                        } else {
                            jSONObject.put("02001", l1.u());
                            jSONObject.put("02002", l1.h());
                            jSONObject.put("02003", l1.v());
                            jSONObject.put("02004", l1.p());
                            jSONObject.put("02005", l1.y());
                            jSONObject.put("02006", l1.l());
                            jSONObject.put("02007", l1.f());
                            jSONObject.put("02018", l1.n());
                            jSONObject.put("02013", l1.i());
                        }
                        L = l1.L();
                        jSONObject.put("02016", L);
                        jSONObject.put("02021", l1.e(this.a));
                        jSONObject.put("02022", l1.h(this.a));
                        jSONObject.put("02044", l1.F());
                        jSONObject.put("11009", s1.b(this.a.getApplicationContext()));
                        if (Engine.loadSuccess) {
                        }
                    } catch (Throwable unused4) {
                        return null;
                    }
                }
                if (this.b) {
                    jSONObject.put("20004", 1);
                }
                jSONObject.put("11017", jSONObject.toString().length());
                jSONObject.put("20000", this.c);
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                return jSONObject;
            } catch (Throwable unused5) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
