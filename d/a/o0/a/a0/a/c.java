package d.a.o0.a.a0.a;

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
import d.a.o0.a.v2.q;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.o0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a0.b.c f43709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f43710f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43711g;

        public a(c cVar, d.a.o0.a.a0.b.c cVar2, CanvasView canvasView, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, canvasView, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43709e = cVar2;
            this.f43710f = canvasView;
            this.f43711g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject k = this.f43709e.k(this.f43710f);
                String str = this.f43709e.f43984i;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f43711g.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(k, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/getImageData");
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
                super((d.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        d.a.o0.a.h0.g.f J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.o0.a.a0.b.c m = m(unitedSchemeEntity);
            if (m == null) {
                d.a.o0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(m.f43982g) && (J = d.a.o0.a.g1.f.V().J()) != null) {
                m.f43982g = J.g3();
            }
            if (!TextUtils.isEmpty(m.f43982g) && !TextUtils.isEmpty(m.f43981f)) {
                CanvasView a2 = d.a.o0.a.c0.c.d.b.a.a(m);
                if (a2 == null) {
                    d.a.o0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                q.j(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.o0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData slave id = " + m.f43982g + " ; canvas id = " + m.f43981f);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public d.a.o0.a.a0.b.c m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new d.a.o0.a.a0.b.c(str);
        }
        return (d.a.o0.a.a0.b.c) invokeL.objValue;
    }
}
