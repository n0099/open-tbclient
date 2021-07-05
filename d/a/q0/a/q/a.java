package d.a.q0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.g1.f;
import d.a.q0.a.u.e.o.k;
import d.a.q0.a.v2.q0;
/* loaded from: classes8.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0919a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50060e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.l1.b f50061f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f50062g;

        public RunnableC0919a(a aVar, UnitedSchemeEntity unitedSchemeEntity, d.a.q0.a.l1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, unitedSchemeEntity, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50062g = aVar;
            this.f50060e = unitedSchemeEntity;
            this.f50061f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50062g.k(this.f50060e, this.f50061f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/openAdWebPage");
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

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("AdLandingAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String o = d.a.q0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            String n = d.a.q0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            if (TextUtils.isEmpty(o)) {
                d.a.q0.a.e0.d.b("AdLanding", "adLanding: url is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (f.V().W() == null) {
                d.a.q0.a.e0.d.g("AdLandingAction", "open page failed");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else {
                d.a.q0.a.l1.b g2 = d.a.q0.a.l1.b.g(o, o);
                g2.f49292f = n;
                if (k.e().g()) {
                    l(unitedSchemeEntity, g2);
                } else {
                    k(unitedSchemeEntity, g2);
                }
                d.a.q0.a.e0.d.g("AdLanding", "open adLanding page finish");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, d.a.q0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, bVar) == null) || d.a.q0.a.h0.g.k.Q2("adLanding", bVar)) {
            return;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
    }

    public final void l(UnitedSchemeEntity unitedSchemeEntity, d.a.q0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, bVar) == null) {
            k.e().h();
            q0.Y(new RunnableC0919a(this, unitedSchemeEntity, bVar), 200L);
        }
    }
}
