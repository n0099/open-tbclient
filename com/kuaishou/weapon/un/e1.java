package com.kuaishou.weapon.un;

import android.content.Context;
import android.location.Location;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.jni.W;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public e1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    private JSONObject a() {
        InterceptResult invokeV;
        Location a;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                d dVar = new d(this.a);
                boolean b2 = dVar.b(d.Z0);
                if (dVar.a(d.E0, 1) == 1 && b2) {
                    jSONObject.put("01003", w1.b(this.a, l1.c()));
                    if (l1.d() != null) {
                        str = l1.d()[0];
                        str2 = l1.d()[1];
                    } else {
                        str = null;
                        str2 = null;
                    }
                    jSONObject.put("01004", w1.a(this.a, 1, str2));
                    jSONObject.put("01019", w1.a(this.a, 0, str));
                }
                if (dVar.a(d.F0, 1) == 1 && b2) {
                    jSONObject.put("01007", w1.e(this.a));
                    jSONObject.put("01008", w1.b(this.a, 1));
                    jSONObject.put("01020", w1.b(this.a, 2));
                }
                if (dVar.a(d.G0, 1) == 1 && b2) {
                    jSONObject.put("01011", w1.d(this.a));
                    jSONObject.put("01012", w1.a(this.a, 1));
                    jSONObject.put("01021", w1.a(this.a, 2));
                }
                if (dVar.a(d.H0, 1) == 1 && b2) {
                    jSONObject.put("01016", x0.f(this.a));
                }
                if (dVar.a(d.w0, 1) == 1) {
                    if (b2) {
                        jSONObject.put("01013", w1.a(this.a, l1.a()));
                    }
                    jSONObject.put("01015", x0.t(this.a));
                    jSONObject.put("02001", b1.q());
                    jSONObject.put("02002", b1.e());
                    jSONObject.put("02003", b1.r());
                    jSONObject.put("02004", b1.l());
                    jSONObject.put("02005", b1.t());
                    jSONObject.put("02006", b1.i());
                    jSONObject.put("02007", b1.c());
                    jSONObject.put("02008", b1.n());
                    jSONObject.put("02009", b1.y());
                    jSONObject.put("02010", b1.x());
                    jSONObject.put("02011", b1.w());
                    jSONObject.put("02012", b1.d());
                    jSONObject.put("02013", b1.f());
                    jSONObject.put("02014", b1.j());
                    jSONObject.put("02015", b1.p());
                    jSONObject.put("02016", b1.A());
                    jSONObject.put("02017", b1.a());
                    jSONObject.put("02018", b1.k());
                    jSONObject.put("02020", b1.z());
                    jSONObject.put("02021", b1.e(this.a));
                    jSONObject.put("02022", b1.g(this.a));
                    jSONObject.put("02023", f1.a(this.a));
                    jSONObject.put("02024", f1.b(this.a));
                    jSONObject.put("02030", b1.b(this.a));
                    jSONObject.put("02031", b1.s());
                    jSONObject.put("02032", b1.g());
                    jSONObject.put("02033", b1.o());
                    jSONObject.put("02034", b1.m());
                    jSONObject.put("02035", b1.b());
                    jSONObject.put("02037", b1.h());
                    jSONObject.put("02038", b1.u());
                    jSONObject.put("02039", x0.a());
                    jSONObject.put("02040", x0.b());
                    jSONObject.put("02041", x0.r(this.a));
                    jSONObject.put("02042", x0.a(this.a));
                    jSONObject.put("02043", x0.q(this.a));
                    jSONObject.put("02044", b1.v());
                }
                if (dVar.a(d.x0, 1) == 1) {
                    jSONObject.put("03001", c1.a());
                    jSONObject.put("03002", c1.b());
                    jSONObject.put("03003", c1.a(this.a));
                    jSONObject.put("03004", b1.f(this.a));
                    jSONObject.put("03007", w1.c(this.a));
                    jSONObject.put("03008", w1.b(this.a));
                    jSONObject.put("03011", t.a(this.a));
                    jSONObject.put("03012", t.a());
                    jSONObject.put("03014", x0.y(this.a));
                    jSONObject.put("03020", w1.a(this.a));
                }
                if (dVar.a(d.K0, 1) == 1) {
                    jSONObject.put("03019", x0.i(this.a));
                }
                if (dVar.a(d.L0, 1) == 1) {
                    jSONObject.put("03018", x0.b(this.a));
                }
                if (dVar.a(d.J0, 1) == 1 && b2) {
                    jSONObject.put("03028", x0.s(this.a));
                }
                if (dVar.a(d.y0, 1) == 1) {
                    try {
                        z0 b3 = a1.b();
                        jSONObject.put("04001", a1.a());
                        jSONObject.put("04002", b3.c());
                        jSONObject.put("04003", b3.a());
                        jSONObject.put("04004", b3.b());
                    } catch (Exception unused) {
                    }
                }
                if (dVar.a(d.I0, 1) == 1 && b2) {
                    String c2 = w1.c(this.a, l1.g());
                    if (c2 == null) {
                        jSONObject.put("07005", "");
                    } else {
                        jSONObject.put("07005", c2);
                    }
                }
                if (w1.a(this.a, l1.f()) != null) {
                    jSONObject.put("09002", a.getLatitude() + "");
                    jSONObject.put("09003", a.getLongitude() + "");
                }
                jSONObject.put("11001", W.loadSuccess ? 1 : 0);
                jSONObject.put("11003", r1.r);
                jSONObject.put("11005", W.loadSoCount);
                jSONObject.put("11006", b2 ? 1 : 0);
                jSONObject.put("11008", dVar.a(d.U, d.S));
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                return jSONObject;
            } catch (Throwable th) {
                x0.a(th);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        JSONObject a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject a2 = new d1(str, q0.f55259f).a(this.a);
                if (a2 == null || (a = a()) == null) {
                    return null;
                }
                a2.put("module_section", a);
                return a2.toString();
            } catch (Throwable th) {
                x0.a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
