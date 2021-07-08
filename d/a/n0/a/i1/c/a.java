package d.a.n0.a.i1.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.h0.u.g;
import d.a.n0.a.k;
import d.a.n0.a.v2.d0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45342a;

    /* renamed from: b  reason: collision with root package name */
    public String f45343b;

    /* renamed from: c  reason: collision with root package name */
    public String f45344c;

    /* renamed from: d  reason: collision with root package name */
    public String f45345d;

    /* renamed from: e  reason: collision with root package name */
    public String f45346e;

    /* renamed from: f  reason: collision with root package name */
    public String f45347f;

    /* renamed from: g  reason: collision with root package name */
    public String f45348g;

    /* renamed from: h  reason: collision with root package name */
    public String f45349h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45350i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public int o;
    public String p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public String u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1234182711, "Ld/a/n0/a/i1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1234182711, "Ld/a/n0/a/i1/c/a;");
                return;
            }
        }
        v = k.f45831a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45342a = "";
        this.f45343b = "";
        this.f45344c = "";
        this.f45345d = "";
        this.f45346e = "";
        this.f45347f = "";
        this.f45348g = "";
        this.f45349h = "";
        this.f45350i = false;
        this.j = "";
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.q = false;
    }

    public static a b(JSONObject jSONObject, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, aVar)) == null) {
            a aVar2 = new a();
            if (jSONObject != null) {
                aVar2.f45342a = jSONObject.optString("audioId", aVar.f45342a);
                aVar2.f45343b = jSONObject.optString("slaveId", aVar.f45343b);
                aVar2.f45344c = jSONObject.optString("src", aVar.f45344c);
                aVar2.q = e.i() != null && d.a.n0.a.k2.b.E(aVar2.f45344c);
                aVar2.f45345d = jSONObject.optString("title", aVar.f45345d);
                aVar2.f45346e = jSONObject.optString("epname", aVar.f45346e);
                aVar2.f45347f = jSONObject.optString("singer", aVar.f45347f);
                aVar2.f45348g = jSONObject.optString("coverImgUrl", aVar.f45348g);
                aVar2.f45349h = jSONObject.optString("lrcURL", aVar.f45349h);
                aVar2.f45350i = jSONObject.optBoolean("showFloatView", aVar.f45350i);
                aVar2.j = jSONObject.optString("floatPosition", aVar.j);
                aVar2.k = jSONObject.optInt("startTime", aVar.k);
                aVar2.l = jSONObject.optInt("position", aVar.l);
                aVar2.p = jSONObject.optString("cb", aVar.p);
                aVar2.m = jSONObject.optString("param", aVar.m);
                aVar2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String Y = g.N().Y();
                if (!TextUtils.isEmpty(Y)) {
                    aVar2.s = Y;
                }
                String b2 = d0.b();
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f45344c)) {
                    aVar2.t = b2;
                }
                String j = d.a.n0.a.l2.b.l().j(aVar2.f45344c);
                if (!TextUtils.isEmpty(j)) {
                    aVar2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return aVar2;
        }
        return (a) invokeLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("src", str);
                jSONObject.putOpt("title", this.f45345d);
                jSONObject.putOpt("epname", this.f45346e);
                jSONObject.putOpt("singer", this.f45347f);
                jSONObject.putOpt("coverImgUrl", this.f45348g);
                jSONObject.putOpt("lrcURL", this.f45349h);
                jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
                jSONObject.putOpt("appid", e.V());
                jSONObject.putOpt("user-agent", this.s);
                jSONObject.putOpt(TiebaStatic.Params.REFER, this.t);
                jSONObject.putOpt("Cookie", this.u);
            } catch (JSONException e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "playerId : " + this.f45342a + "; slaveId : " + this.f45343b + "; url : " + this.f45344c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
        }
        return (String) invokeV.objValue;
    }
}
