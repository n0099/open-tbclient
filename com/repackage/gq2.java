package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gq2 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fq2 c;
    public jq2 d;
    public iq2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq2(r13 r13Var) {
        super(r13Var, "/swanAPI/vrvideo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            ux1.b("VrVideoPlayerAction", "handle entity: ", unitedSchemeEntity);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.r23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u03 u03Var) {
        InterceptResult invokeLLLLL;
        char c;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, u03Var)) == null) {
            ux1.b("VrVideoPlayerAction", "handleSubAction subAction : " + str + "params : ", r23.a(unitedSchemeEntity, "params"));
            int hashCode = str.hashCode();
            if (hashCode == 533456719) {
                if (str.equals("/swanAPI/vrvideo/open")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != 1626770505) {
                if (hashCode == 1722535054 && str.equals("/swanAPI/vrvideo/update")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("/swanAPI/vrvideo/remove")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c == 0) {
                if (this.c == null) {
                    this.c = new fq2("/swanAPI/vrvideo/open");
                }
                c2 = this.c.c(context, unitedSchemeEntity, callbackHandler, u03Var);
            } else if (c == 1) {
                if (this.d == null) {
                    this.d = new jq2("/swanAPI/vrvideo/update");
                }
                c2 = this.d.c(context, unitedSchemeEntity, callbackHandler, u03Var);
            } else if (c != 2) {
                c2 = false;
            } else {
                if (this.e == null) {
                    this.e = new iq2("/swanAPI/vrvideo/remove");
                }
                c2 = this.e.c(context, unitedSchemeEntity, callbackHandler, u03Var);
            }
            return c2 || super.i(context, unitedSchemeEntity, callbackHandler, str, u03Var);
        }
        return invokeLLLLL.booleanValue;
    }
}
