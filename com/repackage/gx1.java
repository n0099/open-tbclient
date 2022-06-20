package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gx1 extends p13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx1(p03 p03Var) {
        super(p03Var, "/swanAPI/remoteDebug");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p03Var};
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

    @Override // com.repackage.p13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, sz2Var)) == null) {
            sw1.i("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.p13
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, sz2 sz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, sz2Var)) == null) {
            sw1.i("RemoteDebugAction", "handleSubAction subAction: " + str);
            if (!jx1.d()) {
                sw1.c("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            SwanAppActivity x = rz2.K().x();
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -279631955) {
                if (hashCode == 1013845168 && str.equals("/swanAPI/remoteDebug/reload")) {
                    c = 0;
                }
            } else if (str.equals("/swanAPI/remoteDebug/shutdown")) {
                c = 1;
            }
            if (c == 0) {
                sw1.i("RemoteDebugAction", "Remote Debug reload");
                if (x != null) {
                    Intent intent = x.getIntent();
                    jx1.f();
                    rz2.K().o(new String[0]);
                    rz2.K().m(intent.getExtras(), "update_tag_by_remote_debug");
                }
                return true;
            } else if (c != 1) {
                return super.i(context, unitedSchemeEntity, callbackHandler, str, sz2Var);
            } else {
                if (x != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    } else {
                        x.finish();
                    }
                    System.exit(0);
                }
                return true;
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
