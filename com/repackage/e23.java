package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n53;
import com.repackage.nk2;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e23 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements bf3<i53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ i03 e;
        public final /* synthetic */ e23 f;

        public a(e23 e23Var, JSONObject jSONObject, Context context, String str, CallbackHandler callbackHandler, i03 i03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e23Var, jSONObject, context, str, callbackHandler, i03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = e23Var;
            this.a = jSONObject;
            this.b = context;
            this.c = str;
            this.d = callbackHandler;
            this.e = i03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(i53 i53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i53Var) == null) {
                if (bg3.f(this.a)) {
                    this.f.p(this.f.s(t33.e(), this.a.optString("path")), this.b, this.c, this.d, this.a, this.e);
                    return;
                }
                String r = this.f.r(i53Var, this.a);
                if (!ce3.G() && TextUtils.isEmpty(r)) {
                    r = nk3.e().g(this.e.O(), this.e.k(), this.a.optString("path"));
                }
                String str = r;
                if (f23.b) {
                    Log.d("ShareAction", "final share url is " + str);
                }
                this.f.p(str, this.b, this.c, this.d, this.a, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bf3<l53<n53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ String e;
        public final /* synthetic */ e23 f;

        public b(e23 e23Var, Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e23Var, context, callbackHandler, str, jSONObject, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = e23Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = str;
            this.d = jSONObject;
            this.e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<n53.e> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                this.f.n(this.a, this.b, this.c, this.d, g53.h(l53Var), this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements nk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ e23 c;

        public c(e23 e23Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e23Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e23Var;
            this.a = callbackHandler;
            this.b = str;
        }

        @Override // com.repackage.nk2.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.q(this.a, this.b, false);
            }
        }

        @Override // com.repackage.nk2.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.q(this.a, this.b, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e23(f13 f13Var) {
        super(f13Var, "/swanAPI/share");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.f23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, i03Var)) == null) {
            if (context != null && i03Var != null) {
                if (i03Var.n0()) {
                    if (f23.b) {
                        Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject a2 = f23.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    ix1.c("Share", "params invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ix1.c("Share", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                try {
                    a2.put("iconUrl", a2.optString("imageUrl", ""));
                } catch (JSONException e) {
                    if (f23.b) {
                        Log.d("ShareAction", e.toString());
                    }
                }
                i03Var.e0().e("mapp_i_share_update_weburl", new a(this, a2, context, optString, callbackHandler, i03Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            ix1.c("Share", "context or swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            i03 b0 = i03.b0();
            if (b0 == null) {
                return null;
            }
            return q73.M(str, b0.b);
        }
        return (String) invokeL.objValue;
    }

    public final void n(@NonNull Context context, CallbackHandler callbackHandler, String str, @NonNull JSONObject jSONObject, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, callbackHandler, str, jSONObject, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("shareUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("linkUrl", str2);
                }
                if (!TextUtils.isEmpty(optString) && (ae3.q(optString) || z)) {
                    jSONObject.put("customShareUrl", true);
                    jSONObject.put("linkUrl", optString);
                }
                if (optJSONArray != null && optJSONArray.length() > 0 && !z) {
                    jSONObject.put("pannel", optJSONArray);
                }
            } catch (JSONException e) {
                if (f23.b) {
                    Log.d("ShareAction", e.toString());
                }
            }
            t(context, callbackHandler, str, jSONObject);
        }
    }

    public final JSONObject o(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        String m;
        Uri a2;
        Uri a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("imageUrl");
            if (optString.startsWith("bdfile")) {
                String m2 = m(optString);
                if (m2 == null) {
                    return jSONObject;
                }
                try {
                    jSONObject.putOpt("imageUrl", fe3.a(vl2.U().getActivity(), new File(m2)).toString());
                } catch (JSONException e) {
                    if (f23.b) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
                return jSONObject;
            }
            String optString2 = optJSONObject.optString("img_show");
            if (optString2.startsWith("bdfile")) {
                String m3 = m(optString2);
                if (m3 == null || (a3 = fe3.a(vl2.U().getActivity(), new File(m3))) == null) {
                    return jSONObject;
                }
                try {
                    optJSONObject.putOpt("img_show", a3.toString());
                    optJSONObject2.putOpt("info", optJSONObject);
                    jSONObject.putOpt("command", optJSONObject2);
                } catch (JSONException e2) {
                    if (f23.b) {
                        e2.printStackTrace();
                    }
                }
            }
            String optString3 = optJSONObject.optString("img_save");
            if (!optString3.startsWith("bdfile") || (m = m(optString3)) == null || (a2 = fe3.a(vl2.U().getActivity(), new File(m))) == null) {
                return jSONObject;
            }
            try {
                optJSONObject.putOpt("img_save", a2.toString());
                optJSONObject2.putOpt("info", optJSONObject);
                jSONObject.putOpt("command", optJSONObject2);
            } catch (JSONException e3) {
                if (f23.b) {
                    e3.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void p(String str, @NonNull Context context, @NonNull String str2, @NonNull CallbackHandler callbackHandler, @NonNull JSONObject jSONObject, @NonNull i03 i03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, context, str2, callbackHandler, jSONObject, i03Var}) == null) {
            String optString = jSONObject.optString("shareUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("pannel");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("defaultPannel");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                if (optJSONArray2 != null) {
                    try {
                        if (optJSONArray2.length() > 0) {
                            jSONObject.put("pannel", optJSONArray2);
                        }
                    } catch (JSONException e) {
                        if (f23.b) {
                            Log.d("ShareAction", e.toString());
                        }
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("linkUrl", str);
                }
                if (TextUtils.isEmpty(optString)) {
                    t(context, callbackHandler, str2, jSONObject);
                    return;
                } else if (ae3.q(optString)) {
                    jSONObject.put("linkUrl", optString);
                    jSONObject.put("customShareUrl", true);
                    t(context, callbackHandler, str2, jSONObject);
                    return;
                }
            }
            if (bg3.f(jSONObject)) {
                n(context, callbackHandler, str2, jSONObject, true, str);
            } else {
                i03Var.e0().g(context, "mapp_i_share_update_linkurl", new b(this, context, callbackHandler, str2, jSONObject, str));
            }
        }
    }

    public final void q(CallbackHandler callbackHandler, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048581, this, callbackHandler, str, z) == null) || callbackHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TiebaStatic.LogFields.RESULT, z);
        } catch (JSONException e) {
            if (f23.b) {
                Log.d("ShareAction", e.toString());
            }
        }
        int i = z ? 0 : 1001;
        ix1.i("Share", "result=" + z);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
    }

    public String r(i53 i53Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, i53Var, jSONObject)) == null) ? (i53Var == null || i53Var.d || i53Var.j != 1 || TextUtils.isEmpty(i53Var.o.optString("web_url"))) ? "" : s(i53Var.o.optString("web_url"), jSONObject.optString("path")) : (String) invokeLL.objValue;
    }

    public String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                str = str + str2;
            }
            return ae3.a(ae3.a(str, "_swebfr", "1"), "_swebFromHost", pj2.n().a());
        }
        return (String) invokeLL.objValue;
    }

    public final void t(@NonNull Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, callbackHandler, str, jSONObject) == null) {
            jSONObject.remove("defaultPannel");
            jSONObject.remove("shareUrl");
            i03 b0 = i03.b0();
            if (b0 != null) {
                String T = b0.W().T();
                String a2 = ac2.a();
                JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
                if (optJSONObject != null) {
                    id3.f(optJSONObject, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        id3.f(optJSONObject, "nid", a2);
                    }
                } else {
                    JSONObject f = id3.f(null, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        id3.f(f, "nid", a2);
                    }
                    id3.f(jSONObject, "categoryInfo", f);
                }
            }
            pj2.f0().a(context, o(jSONObject), new c(this, callbackHandler, str));
        }
    }
}
