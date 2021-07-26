package d.a.o0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.Domains;
import d.a.o0.f.i.r.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "sid_eid";
    public static String p = "exps";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49921a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49922b;

    /* renamed from: c  reason: collision with root package name */
    public String f49923c;

    /* renamed from: d  reason: collision with root package name */
    public String f49924d;

    /* renamed from: e  reason: collision with root package name */
    public String f49925e;

    /* renamed from: f  reason: collision with root package name */
    public String f49926f;

    /* renamed from: g  reason: collision with root package name */
    public String f49927g;

    /* renamed from: h  reason: collision with root package name */
    public String f49928h;

    /* renamed from: i  reason: collision with root package name */
    public c f49929i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1217368690, "Ld/a/o0/f/i/o/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1217368690, "Ld/a/o0/f/i/o/e;");
        }
    }

    public e(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49921a = "https://mobads.baidu.com/cpro/ui/mads.php";
        this.f49926f = "1";
        this.f49927g = "2";
        this.f49928h = "8.800201";
        this.f49922b = context;
        this.f49929i = cVar;
        if (cVar != null) {
            this.f49923c = cVar.b();
            this.f49924d = this.f49929i.e();
            this.f49925e = this.f49929i.g();
        }
        if (h.o()) {
            return;
        }
        this.j = h.b();
    }

    public abstract HashMap<String, String> a();

    public final HashMap<String, String> b() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                hashMap.put(IAdRequestParam.QUERY_WIDTH, String.valueOf(Math.round(h.i(this.f49922b) / h.d(this.f49922b))));
                hashMap.put(IAdRequestParam.QUERY_HEIGHT, String.valueOf(Math.round(h.h(this.f49922b) / h.d(this.f49922b))));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(NetworkUtils.c(false));
                hashMap.put("net", sb.toString());
                hashMap.put("n", this.f49926f);
                hashMap.put("pk", this.f49925e);
                hashMap.put("appid", this.f49924d);
                hashMap.put("sw", "" + h.i(this.f49922b));
                hashMap.put(IAdRequestParam.SCREEN_HEIGHT, "" + h.h(this.f49922b));
                hashMap.put(IAdRequestParam.SN, "" + f());
                hashMap.put(IAdRequestParam.OS, "android");
                hashMap.put("apid", "" + this.f49923c);
                hashMap.put(IAdRequestParam.CHID, "0");
                String s = d.a.o0.f.i.m.a.b().s();
                if (s.equals("0")) {
                    s = "";
                }
                hashMap.put("imei", s);
                hashMap.put("cuid", d.a.o0.f.i.m.a.b().c());
                hashMap.put(IAdRequestParam.OSV, h.f());
                hashMap.put(IAdRequestParam.PHONE_TYPE, h.e());
                hashMap.put(IAdRequestParam.APV, h.l());
                String c2 = h.c(d(), "BAIDUID");
                hashMap.put("baiduid", (TextUtils.isEmpty(c2) || c2.split(":").length <= 0) ? "" : c2.split(":")[0]);
                hashMap.put("p_ver", this.f49928h);
                hashMap.put(IAdRequestParam.RPT, this.f49927g);
                hashMap.put("tab", "2");
                hashMap.put(IAdRequestParam.REQ_ID, "");
                hashMap.put("scene", d.a.o0.f.i.m.a.b().k());
                String e2 = e();
                hashMap.put(p, e2);
                hashMap.put("eqid", d.a.o0.f.i.m.a.b().m());
                JSONObject t = d.a.o0.f.i.m.a.b().t();
                if (t != null) {
                    if (t.has(l) && (jSONObject = t.getJSONObject(l)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (n.equals(next)) {
                                    hashMap.put(m, optString);
                                    this.j = optString;
                                } else {
                                    hashMap.put(k + next, optString);
                                }
                            }
                        }
                    }
                    if (t.has(o) && (optJSONArray = t.optJSONArray(o)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (!TextUtils.isEmpty(e2)) {
                            sb2.append(e2 + ",");
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString2 = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb2.append(optString2);
                                if (i2 >= 0 && i2 < optJSONArray.length() - 1) {
                                    sb2.append(",");
                                }
                            }
                        }
                        if (sb2.length() > 0) {
                            hashMap.put(p, sb2.toString());
                        }
                    }
                }
                if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.j)) {
                    hashMap.put(n, this.j);
                }
                hashMap.put("con_name", d.a.o0.f.i.m.a.b().a());
            } catch (Exception unused) {
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.o0.f.i.m.a.b().l(Domains.BAIDU) : (String) invokeV.objValue;
    }

    public abstract String e();

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                String s = d.a.o0.f.i.m.a.b().s();
                return TextUtils.isEmpty(s) ? NetworkUtils.e(this.f49922b) : s;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HashMap<String, String> b2 = b();
            b2.putAll(a());
            return d.a.o0.f.i.r.e.a(this.f49921a, b2);
        }
        return (String) invokeV.objValue;
    }
}
