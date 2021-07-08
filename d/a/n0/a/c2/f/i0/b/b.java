package d.a.n0.a.c2.f.i0.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.e2.c.f;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.h;
import d.a.n0.a.j2.k;
import d.a.n0.a.v2.q0;
import d.a.n0.a.z1.b.b.h;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public FloatButton f43701c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.a.c2.f.i0.a f43702d;

    /* renamed from: e  reason: collision with root package name */
    public f f43703e;

    /* renamed from: f  reason: collision with root package name */
    public String f43704f;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43707g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f43708h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f43709i;
        public final /* synthetic */ String j;
        public final /* synthetic */ b k;

        public a(b bVar, CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, jSONObject, context, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bVar;
            this.f43705e = callbackHandler;
            this.f43706f = str;
            this.f43707g = jSONObject;
            this.f43708h = context;
            this.f43709i = eVar;
            this.j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f44329d) {
                    FloatButton c2 = this.k.f43702d.c();
                    if (c2 != null) {
                        c2.setVisibility(8);
                    }
                    d.a.n0.a.e2.c.d.n(10005, this.f43705e, this.f43706f);
                    k.p(10005, fVar);
                } else if (this.k.w(fVar, this.f43707g.optString("scheme"))) {
                    this.k.f43703e = fVar;
                    SwanAppActivity swanAppActivity = (SwanAppActivity) this.f43708h;
                    this.k.f43702d = d.a.n0.a.c2.f.i0.a.d();
                    if (this.k.f43702d.c() == null) {
                        b bVar = this.k;
                        bVar.f43701c = bVar.y(this.f43708h, this.f43707g);
                        this.k.x(this.f43706f, this.f43707g, this.f43705e, swanAppActivity);
                    }
                    this.f43709i.J().h(this.j, Boolean.TRUE);
                } else {
                    this.f43705e.handleSchemeDispatchCallback(this.f43706f, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
                }
            }
        }
    }

    /* renamed from: d.a.n0.a.c2.f.i0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0651b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f43710a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43711b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43712c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43713d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f43714e;

        public C0651b(b bVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity, jSONObject, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43714e = bVar;
            this.f43710a = activity;
            this.f43711b = jSONObject;
            this.f43712c = callbackHandler;
            this.f43713d = str;
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
                if (q0.F(this.f43710a, this.f43714e.f43704f)) {
                    String optString = this.f43711b.optString("scheme");
                    b bVar = this.f43714e;
                    this.f43714e.z(this.f43710a, optString, bVar.v(bVar.f43703e.f44334i.get(0), optString), this.f43712c, this.f43713d);
                    return;
                }
                try {
                    String optString2 = this.f43711b.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString2);
                    z = q0.e(this.f43710a, jSONObject.toString());
                } catch (JSONException e2) {
                    if (a0.f43581b) {
                        e2.printStackTrace();
                    }
                    z = false;
                }
                this.f43712c.handleSchemeDispatchCallback(this.f43713d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f43715e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43716f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43717g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43718h;

        public c(b bVar, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity, str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43715e = activity;
            this.f43716f = str;
            this.f43717g = callbackHandler;
            this.f43718h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                boolean T = q0.T(this.f43715e, this.f43716f);
                this.f43717g.handleSchemeDispatchCallback(this.f43718h, UnitedSchemeUtility.wrapCallbackParams(T ? 0 : 1001, T ? "open app success" : "open app fail").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43720f;

        public d(b bVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43719e = callbackHandler;
            this.f43720f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f43719e.handleSchemeDispatchCallback(this.f43720f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showOpenAppGuide");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
                return false;
            } else if (eVar == null) {
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
                this.f43704f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                    return false;
                }
                d.a.n0.a.c2.f.i0.a d2 = d.a.n0.a.c2.f.i0.a.d();
                this.f43702d = d2;
                d2.i(this.f43704f);
                if (this.f43702d.c() != null) {
                    this.f43701c = y(context, a2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                b.a N = eVar.N();
                if (N != null && !TextUtils.isEmpty(N.T())) {
                    eVar.T().e("mapp_open_external_app", new a(this, callbackHandler, optString, a2, context, eVar, N.T()));
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
                        } catch (JSONException e2) {
                            e = e2;
                            if (a0.f43581b) {
                                e.printStackTrace();
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                return str4 + str3;
                            }
                            return null;
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
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

    public final boolean w(f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, str)) == null) {
            if (fVar != null && !TextUtils.isEmpty(str)) {
                for (String str2 : fVar.f44333h) {
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
        this.f43701c.setDragImageListener(new C0651b(this, activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, jSONObject)) == null) {
            this.f43702d.g((SwanAppActivity) context, jSONObject);
            return this.f43702d.f();
        }
        return (FloatButton) invokeLL.objValue;
    }

    public final void z(Activity activity, String str, String str2, CallbackHandler callbackHandler, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, str, str2, callbackHandler, str3) == null) || !(activity instanceof SwanAppActivity) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String string = activity.getString(h.aiapps_confirm);
        String string2 = activity.getString(h.aiapps_cancel);
        h.a aVar = new h.a(activity);
        aVar.f(true);
        aVar.x(str2);
        aVar.n(new d.a.n0.a.w2.h.a());
        aVar.m(false);
        aVar.P(string, new c(this, activity, str, callbackHandler, str3));
        aVar.C(string2, new d(this, callbackHandler, str3));
        aVar.X();
    }
}
