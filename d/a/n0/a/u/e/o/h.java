package d.a.n0.a.u.e.o;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f47792f;

        public a(h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47792f = hVar;
            this.f47791e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.n0.a.e2.c.d.h(iVar)) {
                    boolean a2 = d.a.n0.u.d.c.a(this.f47792f.i(), "android.permission.READ_CONTACTS");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("isAuthorized", a2);
                        this.f47792f.d(this.f47791e, new d.a.n0.a.u.h.b(0, jSONObject));
                        this.f47792f.u(a2);
                        return;
                    } catch (JSONException e2) {
                        if (d.a.n0.a.u.c.d.f47438c) {
                            e2.printStackTrace();
                        }
                        this.f47792f.d(this.f47791e, new d.a.n0.a.u.h.b(1001));
                        return;
                    }
                }
                int b2 = iVar.b();
                this.f47792f.d(this.f47791e, new d.a.n0.a.u.h.b(b2, d.a.n0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull d.a.n0.a.u.c.b bVar) {
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

    public d.a.n0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-Base", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.n0.a.u.h.b(201, "cb is empty");
                }
                d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
                if (Q == null) {
                    return new d.a.n0.a.u.h.b(201);
                }
                Q.T().g(i(), "scope_phone_contact_authorize", new a(this, optString));
                return new d.a.n0.a.u.h.b(0);
            }
            d.a.n0.a.e0.d.b("Api-Base", "parse fail");
            return bVar;
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
            fVar.f45821e = String.valueOf(z);
            fVar.a("appid", d.a.n0.a.a2.d.g().getAppId());
            fVar.a("appname", d.a.n0.a.a2.d.g().r().O());
            d.a.n0.a.j2.k.u("1717", fVar);
        }
    }
}
