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
/* loaded from: classes6.dex */
public class gt1 extends et1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gv1 a;
        public final /* synthetic */ CanvasView b;
        public final /* synthetic */ CallbackHandler c;

        public a(gt1 gt1Var, gv1 gv1Var, CanvasView canvasView, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, gv1Var, canvasView, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gv1Var;
            this.b = canvasView;
            this.c = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject i = this.a.i(this.b);
                String str = this.a.e;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.c.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt1(e13 e13Var) {
        super(e13Var, "/swanAPI/canvas/getImageData");
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
                super((e13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        pz1 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            gv1 m = m(unitedSchemeEntity);
            if (m == null) {
                hx1.c("SwanAppCanvas", "CanvasGetImageData action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(m.c) && (H = ul2.U().H()) != null) {
                m.c = H.t3();
            }
            if (!TextUtils.isEmpty(m.c) && !TextUtils.isEmpty(m.b)) {
                CanvasView a2 = iw1.a(m);
                if (a2 == null) {
                    hx1.c("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                bd3.k(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            hx1.c("SwanAppCanvas", "CanvasGetImageData slave id = " + m.c + " ; canvas id = " + m.b);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public gv1 m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new gv1(str);
        }
        return (gv1) invokeL.objValue;
    }
}
