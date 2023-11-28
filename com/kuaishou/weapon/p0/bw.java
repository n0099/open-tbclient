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
public class bw {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334585122, "Lcom/kuaishou/weapon/p0/bw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334585122, "Lcom/kuaishou/weapon/p0/bw;");
                return;
            }
        }
        d = new byte[0];
    }

    public bw(Context context, int i, boolean z) {
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
                    JSONObject a = new cm(str, ck.l).a(this.a);
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
    public JSONObject a() {
        InterceptResult invokeV;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        String a;
        String b;
        String c;
        String g;
        String f;
        String d2;
        String e;
        String s;
        String m;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                h a2 = h.a(this.a, "re_po_rt");
                boolean e2 = a2.e("a1_p_s_p_s");
                boolean e3 = a2.e("a1_p_s_p_s_c_b");
                if (e2) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("11006", i);
                if (e3) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("11029", i2);
                if (a2.b(df.au, 1) == 1 && (e2 || e3)) {
                    String a3 = bh.a(this.a);
                    if (!TextUtils.isEmpty(a3) && !a3.startsWith("RISK")) {
                        jSONObject.put("01001", f.a(a3));
                    }
                    String c2 = bh.c(this.a);
                    if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                        jSONObject.put("01003", c2);
                    }
                    String b2 = bh.b(this.a, 0);
                    if (!TextUtils.isEmpty(b2) && !b2.startsWith("RISK")) {
                        jSONObject.put("01019", b2);
                    }
                    String b3 = bh.b(this.a, 1);
                    if (!TextUtils.isEmpty(b3) && !b3.startsWith("RISK")) {
                        jSONObject.put("01004", f.a(b3));
                    }
                }
                int b4 = a2.b(df.at, 1);
                if (b4 == 1 && (e2 || e3)) {
                    String f2 = bh.f(this.a);
                    if (!TextUtils.isEmpty(f2) && !f2.startsWith("RISK")) {
                        jSONObject.put("01013", f2);
                    }
                }
                if (a2.b(df.av, 1) == 1 && (e2 || e3)) {
                    String d3 = bh.d(this.a);
                    if (!TextUtils.isEmpty(d3) && !d3.startsWith("RISK")) {
                        jSONObject.put("01007", d3);
                    }
                }
                if (a2.b(df.aw, 1) == 1 && (e2 || e3)) {
                    jSONObject.put("01011", bh.e(this.a));
                }
                String str4 = "";
                if (e2 || e3) {
                    String h = bh.h();
                    if (!TextUtils.isEmpty(h) && !h.startsWith("RISK")) {
                        jSONObject.put("07005", h);
                    } else if (h == null) {
                        jSONObject.put("07005", "");
                    } else {
                        jSONObject.put("07005", h);
                    }
                    jSONObject.put("07006", bh.g());
                }
                if (a2.b(df.ay, 1) == 1 && (e2 || e3)) {
                    String p = bh.p(this.a);
                    if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                        jSONObject.put("01016", p);
                    }
                }
                if (e2 || e3) {
                    try {
                        double b5 = bh.b();
                        if (b5 > 0.0d) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(b5);
                            jSONObject.put("09002", sb.toString());
                        }
                        double c3 = bh.c();
                        if (c3 > 0.0d) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(c3);
                            jSONObject.put("09003", sb2.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
                jSONObject.put("11013", Integer.parseInt(bx.a(this.a.getApplicationContext()), 2));
                jSONObject.put("11012", bx.b(this.a));
                try {
                    jSONObject.put("11202", bh.b(com.kwad.sdk.f.b.Hj().GY()));
                    jSONObject.put("11204", bh.b(com.kwad.sdk.f.b.Hj().Hf()));
                    jSONObject.put("11205", bh.b(com.kwad.sdk.f.b.Hj().getDeviceId()));
                    jSONObject.put("11206", bh.b(com.kwad.sdk.f.b.Hj().getIccId()));
                    jSONObject.put("11207", bh.b(com.kwad.sdk.f.b.Hj().GX()));
                    jSONObject.put("11208", bh.b(com.kwad.sdk.f.b.Hj().Ha()));
                    jSONObject.put("11209", bh.b(com.kwad.sdk.f.b.Hj().Hb()));
                    jSONObject.put("11210", bh.b(com.kwad.sdk.f.b.Hj().Hc()));
                    jSONObject.put("11211", bh.b(com.kwad.sdk.f.b.Hj().getIp()));
                    jSONObject.put("11212", bh.b(com.kwad.sdk.f.b.Hj().getLocation()));
                    jSONObject.put("11213", bh.b(com.kwad.sdk.f.b.Hj().getOaid()));
                    jSONObject.put("11214", bh.b(com.kwad.sdk.f.b.Hj().GZ()));
                    jSONObject.put("11215", bh.b(com.kwad.sdk.f.b.Hj().He()));
                    jSONObject.put("11216", bh.b(com.kwad.sdk.f.b.Hj().Hd()));
                    jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Hj().Hi()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Hj().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Hj().getAppId()));
                    jSONObject.put("11104", com.kwad.sdk.f.b.Hj().Hf());
                    jSONObject.put("11105", com.kwad.sdk.f.b.Hj().getDeviceId());
                    jSONObject.put("11106", com.kwad.sdk.f.b.Hj().getIccId());
                    jSONObject.put("11107", com.kwad.sdk.f.b.Hj().GX());
                    jSONObject.put("11108", com.kwad.sdk.f.b.Hj().Ha());
                    jSONObject.put("11109", com.kwad.sdk.f.b.Hj().Hb());
                    jSONObject.put("11110", com.kwad.sdk.f.b.Hj().Hc());
                    jSONObject.put("11111", com.kwad.sdk.f.b.Hj().getIp());
                    jSONObject.put("11112", com.kwad.sdk.f.b.Hj().getLocation());
                    jSONObject.put("11113", com.kwad.sdk.f.b.Hj().getOaid());
                    jSONObject.put("11114", com.kwad.sdk.f.b.Hj().GZ());
                    jSONObject.put("11115", com.kwad.sdk.f.b.Hj().He());
                    jSONObject.put("11116", com.kwad.sdk.f.b.Hj().Hd());
                } catch (Throwable unused2) {
                }
                String w = bh.w(this.a);
                if (!TextUtils.isEmpty(w)) {
                    jSONObject.put("01026", w);
                }
                if (b4 == 1) {
                    try {
                        JSONObject a4 = ai.a(this.a);
                        if (a4 != null) {
                            jSONObject.put("11015", a4);
                        }
                        if (Engine.loadSuccess) {
                            ce ceVar = new ce(this.a);
                            if (ceVar.a("02001") != null) {
                                a = ceVar.a("02001");
                            } else {
                                a = bl.a();
                            }
                            jSONObject.put("02001", a);
                            if (ceVar.a("02002") != null) {
                                b = ceVar.a("02002");
                            } else {
                                b = bl.b();
                            }
                            jSONObject.put("02002", b);
                            if (ceVar.a("02003") != null) {
                                c = ceVar.a("02003");
                            } else {
                                c = bl.c();
                            }
                            jSONObject.put("02003", c);
                            if (ceVar.a("02007") != null) {
                                g = ceVar.a("02007");
                            } else {
                                g = bl.g();
                            }
                            jSONObject.put("02007", g);
                            if (ceVar.a("02006") != null) {
                                f = ceVar.a("02006");
                            } else {
                                f = bl.f();
                            }
                            jSONObject.put("02006", f);
                            if (ceVar.a("02004") != null) {
                                d2 = ceVar.a("02004");
                            } else {
                                d2 = bl.d();
                            }
                            jSONObject.put("02004", d2);
                            if (ceVar.a("02005") != null) {
                                e = ceVar.a("02005");
                            } else {
                                e = bl.e();
                            }
                            jSONObject.put("02005", e);
                            if (ceVar.a("02018") != null) {
                                s = ceVar.a("02018");
                            } else {
                                s = bl.s();
                            }
                            jSONObject.put("02018", s);
                            if (ceVar.a("02013") != null) {
                                m = ceVar.a("02013");
                            } else {
                                m = bl.m();
                            }
                            jSONObject.put("02013", m);
                            if (ceVar.a("02016") != null) {
                                q = ceVar.a("02016");
                            } else {
                                q = bl.q();
                            }
                            jSONObject.put("02016", q);
                        } else {
                            jSONObject.put("02001", bl.a());
                            jSONObject.put("02002", bl.b());
                            jSONObject.put("02003", bl.c());
                            jSONObject.put("02004", bl.d());
                            jSONObject.put("02005", bl.e());
                            jSONObject.put("02006", bl.f());
                            jSONObject.put("02007", bl.g());
                            jSONObject.put("02018", bl.s());
                            jSONObject.put("02013", bl.m());
                            jSONObject.put("02016", bl.q());
                        }
                        jSONObject.put("02021", bl.d(this.a));
                        jSONObject.put("02022", bl.c(this.a));
                        jSONObject.put("02044", bl.t());
                        jSONObject.put("11009", bs.a(this.a.getApplicationContext()));
                        if (Engine.loadSuccess) {
                            bz bzVar = new bz(this.a);
                            if (bzVar.a("04001") == null) {
                                str = "";
                            } else {
                                str = bzVar.a("04001");
                            }
                            jSONObject.put("04001", str);
                            if (bzVar.a("04002") == null) {
                                str2 = "";
                            } else {
                                str2 = bzVar.a("04002");
                            }
                            jSONObject.put("04002", str2);
                            if (bzVar.a("04003") == null) {
                                str3 = "";
                            } else {
                                str3 = bzVar.a("04003");
                            }
                            jSONObject.put("04003", str3);
                            if (bzVar.a("04004") != null) {
                                str4 = bzVar.a("04004");
                            }
                            jSONObject.put("04004", str4);
                        } else {
                            try {
                                bj b6 = bk.b();
                                jSONObject.put("04001", bk.a());
                                jSONObject.put("04002", b6.b());
                                jSONObject.put("04003", b6.c());
                                jSONObject.put("04004", b6.a());
                            } catch (Exception unused3) {
                            }
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
