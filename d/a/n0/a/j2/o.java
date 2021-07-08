package d.a.n0.a.j2;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45814f;

        public a(o oVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45813e = str;
            this.f45814f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.f45813e, "671")) {
                    d.a.n0.a.e0.d.h("ubcAndCeresStatisticEvent", "671 event=" + this.f45814f);
                }
                try {
                    d.a.n0.a.j2.b.m(this.f45813e, new JSONObject(this.f45814f));
                } catch (JSONException e2) {
                    d.a.n0.a.e0.d.h("ubcAndCeresStatisticEvent", e2.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45815e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45816f;

        public b(o oVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45815e = str;
            this.f45816f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.r.e.m(this.f45815e, this.f45816f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NonNull d.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        b.a L = d.a.n0.a.a2.d.g().r().L();
        w.f(jSONObject, "launchId", L.V());
        w.f(jSONObject, "scheme", L.W());
        w.f(jSONObject, "appid", L.H());
        w.f(jSONObject, "swan", d.a.n0.a.m2.b.i(L.i0(), L.G()));
        w.f(jSONObject, "packageVersion", L.u1());
        w.f(jSONObject, "thirdversion", L.v1());
    }

    public d.a.n0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-ubcAndCeresStatisticEvent", "start handle ubcStatisticEvent.");
                Log.d("Api-ubcAndCeresStatisticEvent", "data - " + str);
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-ubcAndCeresStatisticEvent", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) b2.second;
                String optString = jSONObject.optString("ubcId");
                String optString2 = jSONObject.optString("bizId");
                JSONObject optJSONObject = jSONObject.optJSONObject("content");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optJSONObject != null) {
                    w.f(optJSONObject, "source", d.a.n0.a.a2.d.g().r().L().T());
                    r(optJSONObject.optJSONObject("ext"));
                    d.a.n0.a.r1.k.i.c.f().e(new a(this, optString, optJSONObject.toString()), "Api-ubcAndCeresStatisticEvent");
                    d.a.n0.a.r1.k.f.j().i().d(jSONObject);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                    String str2 = null;
                    if (optJSONObject2 != null) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ext");
                        String optString3 = optJSONObject2.optString("type");
                        optJSONObject2.remove("type");
                        optJSONObject2.remove("from");
                        r(optJSONObject3);
                        str2 = optString3;
                    }
                    jSONObject.remove("ubcId");
                    try {
                        jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
                        jSONObject.putOpt("eventType", "0");
                        jSONObject.putOpt("propagation", w.f(jSONObject.optJSONObject("propagation"), "source", d.a.n0.a.a2.d.g().r().L().T()));
                        jSONObject.put("eventName", str2);
                    } catch (JSONException e2) {
                        if (d.a.n0.a.u.c.d.f47438c) {
                            e2.printStackTrace();
                        }
                    }
                    d.a.n0.a.e0.d.g("Api-ubcAndCeresStatisticEvent", "OpenStat : " + jSONObject);
                    d.a.n0.a.r1.k.i.c.f().e(new b(this, optString2, jSONObject), "OpenStatisticEvent");
                    return new d.a.n0.a.u.h.b(0);
                }
                return new d.a.n0.a.u.h.b(202);
            }
            return bVar;
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
