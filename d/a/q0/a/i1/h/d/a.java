package d.a.q0.a.i1.h.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-734837638, "Ld/a/q0/a/i1/h/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-734837638, "Ld/a/q0/a/i1/h/d/a;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.i1.h.d.c
    public boolean a(d.a.q0.a.i1.h.a aVar, d.a.q0.a.i1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{aVar, cVar, context, unitedSchemeEntity, callbackHandler, eVar})) == null) {
            d.a.q0.a.e0.d.g("vrvideo", "open, video id:" + cVar.n + " slave id: " + cVar.f46780g);
            d(aVar, cVar, unitedSchemeEntity, callbackHandler);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.a.q0.a.i1.h.d.c
    public d.a.q0.a.i1.h.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3, jSONObject)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            d.a.q0.a.i1.a f2 = d.a.q0.a.i1.b.f(str, str2, str3);
            if (f2 == null) {
                return new d.a.q0.a.i1.h.a(context, d.a.q0.a.i1.h.c.j(jSONObject, new d.a.q0.a.i1.h.c()));
            }
            if (f2.i() instanceof d.a.q0.a.i1.h.a) {
                return (d.a.q0.a.i1.h.a) f2.i();
            }
            return null;
        }
        return (d.a.q0.a.i1.h.a) invokeLLLLL.objValue;
    }

    public final void d(d.a.q0.a.i1.h.a aVar, d.a.q0.a.i1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, cVar, unitedSchemeEntity, callbackHandler) == null) {
            aVar.g(cVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }
}
