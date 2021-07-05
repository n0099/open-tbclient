package d.a.q0.a.u.e.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f50764d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f50766f;

        public a(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50766f = dVar;
            this.f50765e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<JSONObject> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                d.a.q0.a.u.h.b bVar = new d.a.q0.a.u.h.b();
                String t = this.f50766f.t(iVar);
                if (TextUtils.isEmpty(t)) {
                    bVar.f51166b = 1001;
                    bVar.f51167c = "openid is empty";
                    this.f50766f.d(this.f50765e, bVar);
                    return;
                }
                bVar.c("openid", t);
                bVar.f51166b = 0;
                this.f50766f.d(this.f50765e, bVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111976574, "Ld/a/q0/a/u/e/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111976574, "Ld/a/q0/a/u/e/a/d;");
                return;
            }
        }
        f50764d = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public d.a.q0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (f50764d) {
                Log.d("Api-GetOpenId", "start getOpenId action, params = " + str);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-GetOpenId", str);
            if (!((d.a.q0.a.u.h.b) b2.first).isSuccess()) {
                d.a.q0.a.e0.d.b("Api-GetOpenId", "parse failed, params = " + str);
                return (d.a.q0.a.u.h.b) b2.first;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (f50764d) {
                Log.d("Api-GetOpenId", "cb: " + optString);
            }
            if (TextUtils.isEmpty(optString)) {
                return new d.a.q0.a.u.h.b(202, "cb is required");
            }
            d.a.q0.a.e2.c.j.d f2 = d.a.q0.a.a2.d.g().y().a().b().f(d.a.q0.a.a2.d.g());
            f2.p(new a(this, optString));
            f2.a();
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final String t(i<JSONObject> iVar) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar)) == null) ? (!iVar.c() || (jSONObject = iVar.f47670a) == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) ? "" : optJSONObject.optString("openid") : (String) invokeL.objValue;
    }
}
