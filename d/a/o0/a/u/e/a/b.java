package d.a.o0.a.u.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.j2.k;
import d.a.o0.a.p.b.a.h;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f47950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47951f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47952g;

        public a(b bVar, h hVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, hVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47950e = hVar;
            this.f47951f = callbackHandler;
            this.f47952g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<JSONObject> iVar) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar.c() && b.s(iVar.f44872a)) {
                    JSONObject optJSONObject = iVar.f44872a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        k.N("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(iVar.b());
                    this.f47950e.g(this.f47951f, wrapCallbackParams.toString());
                    k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "result failed");
                }
                this.f47951f.handleSchemeDispatchCallback(this.f47952g, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.o0.a.u.c.b bVar) {
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
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean s(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0") : invokeL.booleanValue;
    }

    public d.a.o0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-CheckSession", "start check session");
            }
            k.N("checkSession", "create");
            h j = d.a.o0.a.c1.b.j();
            CallbackHandler h2 = a().h();
            e Q = e.Q();
            if (Q == null) {
                j.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty swanApp");
                return new d.a.o0.a.u.h.b(1001, "empty swanApp");
            }
            String D = Q.D();
            if (TextUtils.isEmpty(D)) {
                j.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty app key");
                return new d.a.o0.a.u.h.b(1001, "empty app key");
            }
            JSONObject m = d.a.o0.a.u.c.d.m(str);
            if (m == null) {
                j.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty joParams");
                return new d.a.o0.a.u.h.b(201, "empty joParams");
            }
            String optString = m.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new d.a.o0.a.u.h.b(201, "empty cb");
            }
            Context i2 = i();
            if (!Q.j().e(i2)) {
                j.g(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "account not login");
                return new d.a.o0.a.u.h.b(10004, "user not logged in");
            }
            k.N("checkSession", "checkSession");
            d.a.o0.a.e2.c.j.c g2 = d.a.o0.a.a2.d.g().y().a().b().g(i2, D);
            g2.r("checkSession");
            g2.p(new a(this, j, h2, optString));
            g2.a();
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
