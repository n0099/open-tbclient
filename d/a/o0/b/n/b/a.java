package d.a.o0.b.n.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e0.d;
import d.a.o0.a.n1.i;
import d.a.o0.a.v2.o0;
import d.a.o0.a.v2.q;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.b.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1027a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f49488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49489f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49490g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f49491h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f49492i;

        public RunnableC1027a(a aVar, e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, unitedSchemeEntity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49492i = aVar;
            this.f49488e = eVar;
            this.f49489f = unitedSchemeEntity;
            this.f49490g = callbackHandler;
            this.f49491h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49492i.C(this.f49488e, this.f49489f, this.f49490g, this.f49491h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/adRequest");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.n1.i
    public boolean A(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, eVar, unitedSchemeEntity, callbackHandler, str)) == null) {
            q.i(new RunnableC1027a(this, eVar, unitedSchemeEntity, callbackHandler, str), "execRequest");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void C(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            String optString = a2.optString("cb");
            try {
                String optString2 = a2.optString("url");
                D(a2, optString2, o0.q(optString2));
                unitedSchemeEntity.putParams("params", a2.toString());
                if (super.A(eVar, unitedSchemeEntity, callbackHandler, str)) {
                    return;
                }
                d.b("AdRequest", "request fail");
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } catch (JSONException unused) {
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void D(JSONObject jSONObject, String str, boolean z) throws JSONException {
        HttpUrl parse;
        JSONObject optJSONObject;
        String str2;
        String l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, z) == null) || jSONObject == null || TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null || (optJSONObject = jSONObject.optJSONObject("extParams")) == null) {
            return;
        }
        if (z) {
            str2 = o();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("header");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            j(optJSONObject2, str2);
            jSONObject.put("header", optJSONObject2);
        } else {
            str2 = "";
        }
        if (a0.f44085b) {
            Log.d("AdRequestAction", "appendUrlQueryAndHeader: isBaiduDomain=" + z + ", cookie=" + str2);
        }
        HttpUrl.Builder newBuilder = parse.newBuilder();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (TextUtils.equals(optString, "cuid")) {
                l = d.a.o0.a.c1.a.a0().i(d.a.o0.a.c1.a.b());
            } else {
                l = (TextUtils.equals(optString, "baiduid") && z) ? o0.l(str2, "BAIDUID") : "";
            }
            if (TextUtils.isEmpty(l)) {
                l = "";
            }
            d.g("AdRequest", "key=" + next + ", value=" + l);
            newBuilder.addQueryParameter(next, l);
        }
        jSONObject.put("url", newBuilder.build().toString());
    }
}
