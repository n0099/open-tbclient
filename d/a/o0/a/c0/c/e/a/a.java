package d.a.o0.a.c0.c.e.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c0.b.c;
import d.a.o0.a.c2.e;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.c2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/coverview");
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
                super((e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.c2.f.b
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/coverview" : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.c2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("Component-Action-CoverView", "insert");
            }
            d.a.o0.a.c0.c.e.c.b q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-CoverView", "model is null");
                return false;
            }
            c w = new d.a.o0.a.c0.c.e.c.a(context, q).w();
            boolean a2 = w.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f43986b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // d.a.o0.a.c2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("Component-Action-CoverView", "remove");
            }
            d.a.o0.a.c0.c.e.c.b q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-CoverView", "model is null");
                return false;
            }
            d.a.o0.a.c0.c.e.c.a aVar = (d.a.o0.a.c0.c.e.c.a) d.a.o0.a.c0.d.a.a(q);
            if (aVar == null) {
                String str2 = "can't find coverView component:#" + q.f43981f;
                d.b("Component-Action-CoverView", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            c C = aVar.C();
            boolean a2 = C.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f43986b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // d.a.o0.a.c2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("Component-Action-CoverView", "update");
            }
            d.a.o0.a.c0.c.e.c.b q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-CoverView", "model is null");
                return false;
            }
            d.a.o0.a.c0.c.e.c.a aVar = (d.a.o0.a.c0.c.e.c.a) d.a.o0.a.c0.d.a.a(q);
            if (aVar == null) {
                String str2 = "can't find coverView component:#" + q.f43981f;
                d.b("Component-Action-CoverView", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            c G = aVar.G(q);
            boolean a2 = G.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f43986b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final d.a.o0.a.c0.c.e.c.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-CoverView", "params is null");
                return null;
            }
            d.a.o0.a.c0.c.e.c.b bVar = new d.a.o0.a.c0.c.e.c.b();
            try {
                bVar.a(k);
            } catch (JSONException e2) {
                e2.printStackTrace();
                d.c("Component-Action-CoverView", "model parse exception:", e2);
            }
            return bVar;
        }
        return (d.a.o0.a.c0.c.e.c.b) invokeL.objValue;
    }
}
