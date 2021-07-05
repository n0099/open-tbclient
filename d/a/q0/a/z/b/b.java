package d.a.q0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import h.j;
/* loaded from: classes8.dex */
public class b extends d.a.q0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f51840c;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51842f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f51843g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.z.e.a f51844h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f51845i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.q0.a.z.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51845i = bVar;
            this.f51841e = callbackHandler;
            this.f51842f = unitedSchemeEntity;
            this.f51843g = context;
            this.f51844h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    this.f51845i.q(this.f51843g, this.f51842f, this.f51841e, this.f51844h);
                    return;
                }
                d.a.q0.a.e2.c.d.o(iVar, this.f51841e, this.f51842f);
                if (this.f51845i.f51840c != null) {
                    this.f51845i.f51840c.onError(new Throwable());
                } else {
                    d.a.q0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* renamed from: d.a.q0.a.z.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1043b implements d.a.q0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f51846a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.z.e.a f51847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51848c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51849d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51850e;

        public C1043b(b bVar, Context context, d.a.q0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, aVar, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51850e = bVar;
            this.f51846a = context;
            this.f51847b = aVar;
            this.f51848c = unitedSchemeEntity;
            this.f51849d = callbackHandler;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f51850e.k(this.f51848c, this.f51849d, this.f51850e.p(this.f51846a, this.f51847b));
                d.a.q0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f51849d, this.f51848c, 10005);
                if (this.f51850e.f51840c != null) {
                    this.f51850e.f51840c.onError(new Throwable());
                } else {
                    d.a.q0.a.e0.d.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                d.a.q0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/insert");
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
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            d.a.q0.a.z.e.a aVar = (d.a.q0.a.z.e.a) r(unitedSchemeEntity);
            j x = new d.a.q0.a.c0.c.c.a(context, aVar).x();
            this.f51840c = x;
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, aVar));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, d.a.q0.a.z.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar)) == null) {
            d.a.q0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction start");
            if (context != null && aVar != null) {
                String str = aVar.f46779f;
                d.a.q0.a.l1.e.a.a aVar2 = aVar.l;
                if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.k()) {
                    j jVar = this.f51840c;
                    if (jVar == null) {
                        d.a.q0.a.c0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    jVar.onCompleted();
                    d.a.q0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                sb.append(aVar2 == null);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            sb2.append(context == null);
            sb2.append(" ; model is null ? = ");
            sb2.append(aVar == null);
            d.a.q0.a.e0.d.b("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.z.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, aVar) == null) {
            d.a.q0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            d.a.q0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C1043b(this, context, aVar, unitedSchemeEntity, callbackHandler));
        }
    }

    public d.a.q0.a.c0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new d.a.q0.a.z.e.a(l(unitedSchemeEntity)) : (d.a.q0.a.c0.b.b) invokeL.objValue;
    }
}
