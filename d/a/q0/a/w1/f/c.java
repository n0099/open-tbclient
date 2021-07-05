package d.a.q0.a.w1.f;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.g1.f;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.k;
import d.a.q0.a.v2.w;
import d.a.q0.a.z1.b.b.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f51493c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements d.a.q0.a.w1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51494a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51495b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51496c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f51497d;

        public a(String str, c cVar, e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cVar, eVar, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51494a = str;
            this.f51495b = unitedSchemeEntity;
            this.f51496c = callbackHandler;
            this.f51497d = context;
        }

        @Override // d.a.q0.a.w1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null) {
                    UnitedSchemeUtility.safeCallback(this.f51496c, this.f51495b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f51494a);
                } else {
                    UnitedSchemeUtility.safeCallback(this.f51496c, this.f51495b, UnitedSchemeUtility.wrapCallbackParams(1, "empty post data").toString(), this.f51494a);
                }
            }
        }

        @Override // d.a.q0.a.w1.a
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UnitedSchemeUtility.safeCallback(this.f51496c, this.f51495b, UnitedSchemeUtility.wrapCallbackParams(1001, "user cancel").toString(), this.f51494a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f51498e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-326694977, "Ld/a/q0/a/w1/f/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-326694977, "Ld/a/q0/a/w1/f/c$b;");
                    return;
                }
            }
            f51498e = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161669949, "Ld/a/q0/a/w1/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1161669949, "Ld/a/q0/a/w1/f/c;");
                return;
            }
        }
        f51493c = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.q0.a.c2.e dispatcher) {
        super(dispatcher, "/swanAPI/community/openCommunityEditor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, eVar)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (eVar != null) {
                if (eVar.d0()) {
                    if (f51493c) {
                        Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                    }
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                f V = f.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                g W = V.W();
                if (W != null && (W.m() instanceof d.a.q0.a.w1.c)) {
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                JSONObject d2 = w.d(entity.getParam("params"));
                Intrinsics.checkNotNullExpressionValue(d2, "SwanAppJSONUtils.parseString(params)");
                String optString = d2.optString("cb");
                if (optString == null || optString.length() == 0) {
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (f51493c) {
                    Log.d("OpenPublisherAction", "调起参数:" + d2);
                }
                a aVar = new a(optString, this, eVar, entity, callbackHandler, context);
                PublishParams a2 = d.a.q0.a.w1.b.a(d2);
                if (a2 != null) {
                    d.a.q0.a.w1.c cVar = new d.a.q0.a.w1.c();
                    cVar.q3(aVar);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("params", a2);
                    cVar.j1(bundle);
                    f controller = f.V();
                    Intrinsics.checkNotNullExpressionValue(controller, "controller");
                    g W2 = controller.W();
                    if (W2 != null) {
                        g.b i2 = W2.i("navigateTo");
                        i2.n(g.f48010g, g.f48012i);
                        i2.j(cVar);
                        i2.a();
                        UnitedSchemeUtility.callCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(1, "can get fragment manager").toString(), optString);
                    return false;
                }
                if (f51493c) {
                    Log.d("OpenPublisherAction", "解析调起参数失败");
                }
                j(context);
                return false;
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal app info");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            h.a aVar = new h.a(context);
            aVar.m(false);
            aVar.U(d.a.q0.a.h.swanapp_publisher_error_title);
            aVar.v(d.a.q0.a.h.swanapp_publisher_params_error);
            aVar.O(d.a.q0.a.h.aiapps_confirm, b.f51498e);
            aVar.X();
        }
    }
}
