package d.a.m0.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m0.e.i;
import d.a.m0.k.e;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f43441b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f43442c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43443a;

    /* loaded from: classes7.dex */
    public class a extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f43444f;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43444f = cVar;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    String b2 = new d.a.m0.f.d(this.f43444f.f43443a, null).b();
                    if (TextUtils.isEmpty(b2)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    if (jSONObject.optInt("0") == 0) {
                        c.f43442c = jSONObject.optInt("1") == 2;
                    }
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    public c(Context context) {
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
        this.f43443a = context;
    }

    public static c b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f43441b == null) {
                synchronized (c.class) {
                    if (f43441b == null) {
                        f43441b = new c(context);
                    }
                }
            }
            return f43441b;
        }
        return (c) invokeL.objValue;
    }

    public String c(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String d2 = new d.a.m0.f.d(this.f43443a, null).d(jSONObject, j);
                        if (!TextUtils.isEmpty(d2)) {
                            return d2;
                        }
                    }
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e.c().b(new a(this));
        }
    }

    public String e(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String j2 = new d.a.m0.f.d(this.f43443a, null).j(jSONObject, j);
                        if (!TextUtils.isEmpty(j2)) {
                            return j2;
                        }
                    }
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public synchronized boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                try {
                    if (g()) {
                        return true;
                    }
                    d.a.m0.f.d dVar = new d.a.m0.f.d(this.f43443a, null);
                    String i2 = dVar.i();
                    if (TextUtils.isEmpty(i2)) {
                        for (int i3 = 0; i3 < 3; i3++) {
                            i2 = dVar.i();
                            if (!TextUtils.isEmpty(i2)) {
                                break;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(i2)) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(i2);
                    int optInt = jSONObject.optInt("0", -1);
                    if (optInt == 2) {
                        d.a.m0.b.a.h(this.f43443a).N(false);
                    } else {
                        d.a.m0.b.a.h(this.f43443a).N(true);
                    }
                    if (optInt == 1 || optInt == 3) {
                        return true;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("1");
                    if (optJSONObject == null) {
                        return false;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("yd_config");
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("app_id");
                        String optString2 = optJSONObject2.optString("app_key");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            i.j("cm", optString, optString2);
                        }
                        int optInt2 = optJSONObject2.optInt("status", -1);
                        if (optInt2 == 1) {
                            d.a.m0.b.a.h(this.f43443a).n(true);
                        } else if (optInt2 == 2) {
                            d.a.m0.b.a.h(this.f43443a).n(false);
                        }
                        d.a.m0.b.a.h(this.f43443a).Y(optJSONObject2.toString());
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
                    if (optJSONObject3 != null) {
                        String optString3 = optJSONObject3.optString("app_id");
                        String optString4 = optJSONObject3.optString("app_key");
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            i.j(Config.EXCEPTION_CRASH_TYPE, optString3, optString4);
                        }
                        int optInt3 = optJSONObject3.optInt("status", -1);
                        if (optInt3 == 1) {
                            d.a.m0.b.a.h(this.f43443a).x(true);
                        } else if (optInt3 == 2) {
                            d.a.m0.b.a.h(this.f43443a).x(false);
                        }
                        d.a.m0.b.a.h(this.f43443a).B(optJSONObject3.toString());
                    }
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
                    if (optJSONObject4 != null) {
                        String optString5 = optJSONObject4.optString("app_id");
                        String optString6 = optJSONObject4.optString("app_key");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            i.j("cu", optString5, optString6);
                        }
                        int optInt4 = optJSONObject4.optInt("status", -1);
                        if (optInt4 == 1) {
                            d.a.m0.b.a.h(this.f43443a).D(true);
                        } else if (optInt4 == 2) {
                            d.a.m0.b.a.h(this.f43443a).D(false);
                        }
                        d.a.m0.b.a.h(this.f43443a).Q(optJSONObject4.toString());
                    }
                    JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
                    if (optJSONObject5 != null) {
                        String optString7 = optJSONObject5.optString("app_key", "");
                        String optString8 = optJSONObject5.optString("secret_key", "");
                        if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            d.a.m0.a.f43422b = optString7;
                            d.a.m0.a.f43423c = optString8;
                            d.a.m0.b.a.h(this.f43443a).C(optString7, optString8);
                        }
                    }
                    d.a.m0.b.a.h(this.f43443a).U(optJSONObject.optString("encrypt_key", ""));
                    JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
                    if (optJSONObject6 != null) {
                        if ("1".equals(optJSONObject6.optString("1", "1"))) {
                            d.a.m0.b.a.h(this.f43443a).I(true);
                        } else {
                            d.a.m0.b.a.h(this.f43443a).I(false);
                        }
                        d.a.m0.b.a.h(this.f43443a).z(optJSONObject6.optInt("2"));
                    }
                    d.a.m0.b.a.h(this.f43443a).l(jSONObject.optLong("3", 300L) * 1000);
                    d.a.m0.b.a.h(this.f43443a).P(System.currentTimeMillis());
                    return true;
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (System.currentTimeMillis() - d.a.m0.b.a.h(this.f43443a).i0() > d.a.m0.b.a.h(this.f43443a).E()) {
                    return false;
                }
                String o0 = d.a.m0.b.a.h(this.f43443a).o0();
                String S = d.a.m0.b.a.h(this.f43443a).S();
                String f0 = d.a.m0.b.a.h(this.f43443a).f0();
                if (TextUtils.isEmpty(o0) && TextUtils.isEmpty(S) && TextUtils.isEmpty(f0)) {
                    return false;
                }
                if (!TextUtils.isEmpty(o0)) {
                    JSONObject jSONObject = new JSONObject(o0);
                    String string = jSONObject.getString("app_id");
                    String string2 = jSONObject.getString("app_key");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        i.j("cm", string, string2);
                    }
                }
                if (!TextUtils.isEmpty(S)) {
                    JSONObject jSONObject2 = new JSONObject(S);
                    String string3 = jSONObject2.getString("app_id");
                    String string4 = jSONObject2.getString("app_key");
                    if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                        i.j(Config.EXCEPTION_CRASH_TYPE, string3, string4);
                    }
                }
                if (TextUtils.isEmpty(f0)) {
                    return true;
                }
                JSONObject jSONObject3 = new JSONObject(f0);
                String optString = jSONObject3.optString("app_id");
                String optString2 = jSONObject3.optString("app_key");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return true;
                }
                i.j("cu", optString, optString2);
                return true;
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
