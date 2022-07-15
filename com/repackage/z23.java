package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.el2;
import com.repackage.lz2;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z23 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FloatButton c;
    public x23 d;
    public h53 e;
    public String f;

    /* loaded from: classes7.dex */
    public class a implements af3<h53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ h03 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ z23 g;

        public a(z23 z23Var, CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, h03 h03Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z23Var, callbackHandler, str, jSONObject, context, h03Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = z23Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONObject;
            this.d = context;
            this.e = h03Var;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h53Var) == null) {
                if (h53Var == null || h53Var.d) {
                    FloatButton c = this.g.d.c();
                    if (c != null) {
                        c.setVisibility(8);
                    }
                    f53.o(10005, this.a, this.b);
                    a73.r(10005, h53Var);
                } else if (this.g.w(h53Var, this.c.optString("scheme"))) {
                    this.g.e = h53Var;
                    SwanAppActivity swanAppActivity = (SwanAppActivity) this.d;
                    this.g.d = x23.d();
                    if (this.g.d.c() == null) {
                        z23 z23Var = this.g;
                        z23Var.c = z23Var.y(this.d, this.c);
                        this.g.x(this.b, this.c, this.a, swanAppActivity);
                    }
                    this.e.U().h(this.f, Boolean.TRUE);
                } else {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z23 e;

        public b(z23 z23Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z23Var, activity, jSONObject, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z23Var;
            this.a = activity;
            this.b = jSONObject;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (be3.F(this.a, this.e.f)) {
                    String optString = this.b.optString("scheme");
                    z23 z23Var = this.e;
                    this.e.z(this.a, optString, z23Var.v(z23Var.e.i.get(0), optString), this.c, this.d);
                    return;
                }
                try {
                    String optString2 = this.b.optString(TTDownloadField.TT_DOWNLOAD_URL);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString2);
                    z = be3.e(this.a, jSONObject.toString());
                } catch (JSONException e) {
                    if (e23.b) {
                        e.printStackTrace();
                    }
                    z = false;
                }
                this.c.handleSchemeDispatchCallback(this.d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;

        public c(z23 z23Var, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z23Var, activity, str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = str;
            this.c = callbackHandler;
            this.d = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                boolean W = be3.W(this.a, this.b);
                this.c.handleSchemeDispatchCallback(this.d, UnitedSchemeUtility.wrapCallbackParams(W ? 0 : 1001, W ? "open app success" : "open app fail").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public d(z23 z23Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z23Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z23(e13 e13Var) {
        super(e13Var, "/swanAPI/showOpenAppGuide");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
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

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            JSONObject a2 = e23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
                return false;
            } else if (h03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (!(context instanceof SwanAppActivity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not instanceof SwanAppActivity");
                return false;
            } else {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = a2.optString("name");
                this.f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                    return false;
                }
                x23 d2 = x23.d();
                this.d = d2;
                d2.i(this.f);
                if (this.d.c() != null) {
                    this.c = y(context, a2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                el2.a Y = h03Var.Y();
                if (Y != null && !TextUtils.isEmpty(Y.T())) {
                    h03Var.e0().e("mapp_open_external_app", new a(this, callbackHandler, optString, a2, context, h03Var, Y.T()));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launchInfo or source is empty");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final String v(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            String str4 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    str3 = "";
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            if (next.equals("slogan_base")) {
                                str4 = jSONObject.optString(next);
                            }
                            if (str2.contains(next)) {
                                str3 = jSONObject.optString(next);
                            }
                        } catch (JSONException e) {
                            e = e;
                            if (e23.b) {
                                e.printStackTrace();
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                return str4 + str3;
                            }
                            return null;
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                    return str4 + str3;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean w(h53 h53Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, h53Var, str)) == null) {
            if (h53Var != null && !TextUtils.isEmpty(str)) {
                for (String str2 : h53Var.h) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void x(String str, JSONObject jSONObject, CallbackHandler callbackHandler, Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, str, jSONObject, callbackHandler, activity) == null) || callbackHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setDragImageListener(new b(this, activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, jSONObject)) == null) {
            this.d.g((SwanAppActivity) context, jSONObject);
            return this.d.f();
        }
        return (FloatButton) invokeLL.objValue;
    }

    public final void z(Activity activity, String str, String str2, CallbackHandler callbackHandler, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, str, str2, callbackHandler, str3) == null) || !(activity instanceof SwanAppActivity) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String string = activity.getString(R.string.obfuscated_res_0x7f0f0115);
        String string2 = activity.getString(R.string.obfuscated_res_0x7f0f010d);
        lz2.a aVar = new lz2.a(activity);
        aVar.f(true);
        aVar.x(str2);
        aVar.n(new pf3());
        aVar.m(false);
        aVar.P(string, new c(this, activity, str, callbackHandler, str3));
        aVar.C(string2, new d(this, callbackHandler, str3));
        aVar.X();
    }
}
