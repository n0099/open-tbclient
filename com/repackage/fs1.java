package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fs1 extends es1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements CanvasView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CallbackHandler b;

        public a(fs1 fs1Var, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs1Var, str, callbackHandler};
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
            this.b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.canvas.view.CanvasView.c
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (str = this.a) == null) {
                return;
            }
            this.b.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "draw complete").toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs1(e03 e03Var) {
        super(e03Var, "/swanAPI/canvas/drawCanvas");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e03) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            fu1 m = m(unitedSchemeEntity);
            if (m == null) {
                hw1.c("SwanAppCanvas", "draw model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the params is empty");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(m.b)) {
                aw1.a("SwanAppAction", "canvasId is empty ");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(m.c)) {
                aw1.a("SwanAppAction", "drawCanvas slaveId is empty");
                py1 H = uk2.U().H();
                if (H != null) {
                    m.c = H.s3();
                }
            }
            hv1 hv1Var = (hv1) uv1.a(m);
            if (hv1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the component is null");
                return false;
            }
            boolean F = hv1Var.F(m, new a(this, optString, callbackHandler));
            j(unitedSchemeEntity, callbackHandler, F);
            return F;
        }
        return invokeLLLL.booleanValue;
    }

    public fu1 m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) ? new fu1(unitedSchemeEntity.getParams().get("params")) : (fu1) invokeL.objValue;
    }
}
