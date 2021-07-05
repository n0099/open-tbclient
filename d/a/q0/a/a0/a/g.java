package d.a.q0.a.a0.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/remove");
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
                super((d.a.q0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.q0.a.a0.b.a k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                d.a.q0.a.e0.d.b("SwanAppCanvas", "remove action parse model is null");
                return false;
            }
            d.a.q0.a.c0.c.d.a aVar = (d.a.q0.a.c0.c.d.a) d.a.q0.a.c0.d.a.a(k);
            if (aVar == null) {
                d.a.q0.a.e0.d.b("SwanAppCanvas", "remove canvas fail: fina a null component");
                unitedSchemeEntity.result = l(1001);
                return false;
            }
            d.a.q0.a.c0.b.c C = aVar.C();
            boolean a2 = C.a();
            if (!a2) {
                d.a.q0.a.e0.d.b("SwanAppCanvas", "remove canvas fail: " + C.f46784b);
            }
            j(unitedSchemeEntity, callbackHandler, a2);
            return a2;
        }
        return invokeLLLL.booleanValue;
    }
}
