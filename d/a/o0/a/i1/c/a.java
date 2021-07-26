package d.a.o0.a.i1.c;

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
import d.a.o0.a.a2.e;
import d.a.o0.a.h0.u.g;
import d.a.o0.a.k;
import d.a.o0.a.v2.d0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45846a;

    /* renamed from: b  reason: collision with root package name */
    public String f45847b;

    /* renamed from: c  reason: collision with root package name */
    public String f45848c;

    /* renamed from: d  reason: collision with root package name */
    public String f45849d;

    /* renamed from: e  reason: collision with root package name */
    public String f45850e;

    /* renamed from: f  reason: collision with root package name */
    public String f45851f;

    /* renamed from: g  reason: collision with root package name */
    public String f45852g;

    /* renamed from: h  reason: collision with root package name */
    public String f45853h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45854i;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1363265430, "Ld/a/o0/a/i1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1363265430, "Ld/a/o0/a/i1/c/a;");
                return;
            }
        }
        v = k.f46335a;
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
        this.f45846a = "";
        this.f45847b = "";
        this.f45848c = "";
        this.f45849d = "";
        this.f45850e = "";
        this.f45851f = "";
        this.f45852g = "";
        this.f45853h = "";
        this.f45854i = false;
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
                aVar2.f45846a = jSONObject.optString("audioId", aVar.f45846a);
                aVar2.f45847b = jSONObject.optString("slaveId", aVar.f45847b);
                aVar2.f45848c = jSONObject.optString("src", aVar.f45848c);
                aVar2.q = e.i() != null && d.a.o0.a.k2.b.E(aVar2.f45848c);
                aVar2.f45849d = jSONObject.optString("title", aVar.f45849d);
                aVar2.f45850e = jSONObject.optString("epname", aVar.f45850e);
                aVar2.f45851f = jSONObject.optString("singer", aVar.f45851f);
                aVar2.f45852g = jSONObject.optString("coverImgUrl", aVar.f45852g);
                aVar2.f45853h = jSONObject.optString("lrcURL", aVar.f45853h);
                aVar2.f45854i = jSONObject.optBoolean("showFloatView", aVar.f45854i);
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
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f45848c)) {
                    aVar2.t = b2;
                }
                String j = d.a.o0.a.l2.b.l().j(aVar2.f45848c);
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
                jSONObject.putOpt("title", this.f45849d);
                jSONObject.putOpt("epname", this.f45850e);
                jSONObject.putOpt("singer", this.f45851f);
                jSONObject.putOpt("coverImgUrl", this.f45852g);
                jSONObject.putOpt("lrcURL", this.f45853h);
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
            return "playerId : " + this.f45846a + "; slaveId : " + this.f45847b + "; url : " + this.f45848c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
        }
        return (String) invokeV.objValue;
    }
}
