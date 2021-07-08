package d.a.n0.a.e0.f.e;

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
import d.a.n0.a.c2.f.a0;
/* loaded from: classes7.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/remoteDebug");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.n0.a.e0.d.g("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            d.a.n0.a.e0.d.g("RemoteDebugAction", "handleSubAction subAction: " + str);
            if (!e.d()) {
                d.a.n0.a.e0.d.b("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            SwanAppActivity x = d.a.n0.a.a2.d.g().x();
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -279631955) {
                if (hashCode == 1013845168 && str.equals("/swanAPI/remoteDebug/reload")) {
                    c2 = 0;
                }
            } else if (str.equals("/swanAPI/remoteDebug/shutdown")) {
                c2 = 1;
            }
            if (c2 == 0) {
                d.a.n0.a.e0.d.g("RemoteDebugAction", "Remote Debug reload");
                if (x != null) {
                    Intent intent = x.getIntent();
                    e.f();
                    d.a.n0.a.a2.d.g().o(new String[0]);
                    d.a.n0.a.a2.d.g().m(intent.getExtras(), "update_tag_by_remote_debug");
                }
                return true;
            } else if (c2 != 1) {
                return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
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
