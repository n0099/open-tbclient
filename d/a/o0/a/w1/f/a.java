package d.a.o0.a.w1.f;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.e;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.g1.f;
import d.a.o0.a.h0.g.g;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(903504449, "Ld/a/o0/a/w1/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(903504449, "Ld/a/o0/a/w1/f/a;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e dispatcher) {
        super(dispatcher, "/swanAPI/community/closeCommunityEditor");
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

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, eVar)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (eVar != null) {
                f V = f.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                g W = V.W();
                if (W != null) {
                    d.a.o0.a.h0.g.d m = W.m();
                    if (m instanceof d.a.o0.a.w1.c) {
                        ((d.a.o0.a.w1.c) m).d3();
                        entity.result = UnitedSchemeUtility.wrapCallbackParams(0, "");
                        return true;
                    }
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "top is not publisher");
                return false;
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal app info");
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
