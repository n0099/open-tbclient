package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lz2;
import com.repackage.qz1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qx2 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements jx2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ Context d;

        public a(String str, qx2 qx2Var, h03 h03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, qx2Var, h03Var, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = context;
        }

        @Override // com.repackage.jx2
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null) {
                    UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.a);
                } else {
                    UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(1, "empty post data").toString(), this.a);
                }
            }
        }

        @Override // com.repackage.jx2
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "user cancel").toString(), this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56143768, "Lcom/repackage/qx2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-56143768, "Lcom/repackage/qx2$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755364826, "Lcom/repackage/qx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755364826, "Lcom/repackage/qx2;");
                return;
            }
        }
        c = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx2(e13 dispatcher) {
        super(dispatcher, "/swanAPI/community/openCommunityEditor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, h03Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (h03Var != null) {
                if (h03Var.n0()) {
                    if (c) {
                        Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                    }
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                ul2 U = ul2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                qz1 V = U.V();
                if (V != null && (V.m() instanceof lx2)) {
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                JSONObject d = hd3.d(entity.getParam("params"));
                Intrinsics.checkNotNullExpressionValue(d, "SwanAppJSONUtils.parseString(params)");
                String optString = d.optString("cb");
                if (optString == null || optString.length() == 0) {
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (c) {
                    Log.d("OpenPublisherAction", "调起参数:" + d);
                }
                a aVar = new a(optString, this, h03Var, entity, callbackHandler, context);
                PublishParams a2 = kx2.a(d);
                if (a2 != null) {
                    lx2 lx2Var = new lx2();
                    lx2Var.D3(aVar);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("params", a2);
                    lx2Var.j1(bundle);
                    ul2 controller = ul2.U();
                    Intrinsics.checkNotNullExpressionValue(controller, "controller");
                    qz1 V2 = controller.V();
                    if (V2 != null) {
                        qz1.b i = V2.i("navigateTo");
                        i.n(qz1.g, qz1.i);
                        i.j(lx2Var);
                        i.a();
                        UnitedSchemeUtility.callCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(1, "can get fragment manager").toString(), optString);
                    return false;
                }
                if (c) {
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
            lz2.a aVar = new lz2.a(context);
            aVar.m(false);
            aVar.U(R.string.obfuscated_res_0x7f0f12f1);
            aVar.v(R.string.obfuscated_res_0x7f0f12f5);
            aVar.O(R.string.obfuscated_res_0x7f0f0115, b.a);
            aVar.X();
        }
    }
}
