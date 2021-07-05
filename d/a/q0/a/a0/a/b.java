package d.a.q0.a.a0.a;

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
/* loaded from: classes8.dex */
public class b extends d.a.q0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements CanvasView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46505a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46506b;

        public a(b bVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46505a = str;
            this.f46506b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.canvas.view.CanvasView.c
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (str = this.f46505a) == null) {
                return;
            }
            this.f46506b.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "draw complete").toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/drawCanvas");
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
            d.a.q0.a.a0.b.b m = m(unitedSchemeEntity);
            if (m == null) {
                d.a.q0.a.e0.d.b("SwanAppCanvas", "draw model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the params is empty");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(m.f46779f)) {
                d.a.q0.a.c0.g.a.a("SwanAppAction", "canvasId is empty ");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(m.f46780g)) {
                d.a.q0.a.c0.g.a.a("SwanAppAction", "drawCanvas slaveId is empty");
                d.a.q0.a.h0.g.f J = d.a.q0.a.g1.f.V().J();
                if (J != null) {
                    m.f46780g = J.g3();
                }
            }
            d.a.q0.a.c0.c.d.a aVar = (d.a.q0.a.c0.c.d.a) d.a.q0.a.c0.d.a.a(m);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the component is null");
                return false;
            }
            boolean H = aVar.H(m, new a(this, optString, callbackHandler));
            j(unitedSchemeEntity, callbackHandler, H);
            return H;
        }
        return invokeLLLL.booleanValue;
    }

    public d.a.q0.a.a0.b.b m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) ? new d.a.q0.a.a0.b.b(unitedSchemeEntity.getParams().get("params")) : (d.a.q0.a.a0.b.b) invokeL.objValue;
    }
}
