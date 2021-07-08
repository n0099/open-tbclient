package d.a.n0.a.u.e.o;

import android.content.Intent;
import android.net.Uri;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f47796d;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47798f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47799g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j f47800h;

        public a(j jVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47800h = jVar;
            this.f47797e = str;
            this.f47798f = str2;
            this.f47799g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.n0.a.e2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    this.f47800h.d(this.f47797e, new d.a.n0.a.u.h.b(b2, d.a.n0.a.e2.c.d.f(b2)));
                    return;
                }
                this.f47800h.t(this.f47798f, this.f47799g);
                this.f47800h.d(this.f47797e, new d.a.n0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull d.a.n0.a.u.c.b bVar) {
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

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
            fVar.f45818b = "sms_panel";
            fVar.f45821e = String.valueOf(this.f47796d);
            fVar.a("appid", d.a.n0.a.a2.d.g().getAppId());
            d.a.n0.a.j2.k.u("1639", fVar);
        }
    }

    public final String s(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f47796d = jSONArray.length();
            for (int i2 = 0; i2 < this.f47796d; i2++) {
                String optString = jSONArray.optString(i2);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                sb.append(optString);
                if (i2 != this.f47796d - 1) {
                    sb.append(";");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void t(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            i().startActivity(intent);
            r();
        }
    }

    public d.a.n0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-ShowSMSPanel", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.n0.a.e0.d.b("Api-ShowSMSPanel", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            d.a.n0.a.e0.d.a("Api-ShowSMSPanel", "params: ", jSONObject);
            String optString = jSONObject.optString("content");
            JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
            if (optJSONArray == null) {
                return new d.a.n0.a.u.h.b(202);
            }
            String s = s(optJSONArray);
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.n0.a.u.h.b(202);
                }
                d.a.n0.a.a2.d.g().r().T().g(i(), "scope_show_sms_panel", new a(this, optString2, s, optString));
                return new d.a.n0.a.u.h.b(0);
            }
            return new d.a.n0.a.u.h.b(202);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
