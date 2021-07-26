package d.a.o0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.s1.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45933a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45934b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45935c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.d.c.f f45936d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f45937e;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, unitedSchemeEntity, callbackHandler, eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45937e = cVar;
            this.f45933a = unitedSchemeEntity;
            this.f45934b = callbackHandler;
            this.f45935c = eVar;
            this.f45936d = fVar;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f44085b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f45937e.p(this.f45933a, this.f45934b, this.f45935c, this.f45936d);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45934b, this.f45933a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f45936d.f46017c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45938a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45939b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45940c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45941d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.d.c.f f45942e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f45943f;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, unitedSchemeEntity, callbackHandler, eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45943f = cVar;
            this.f45938a = context;
            this.f45939b = unitedSchemeEntity;
            this.f45940c = callbackHandler;
            this.f45941d = eVar;
            this.f45942e = fVar;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f44085b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f45943f.r(this.f45938a, this.f45939b, this.f45940c, this.f45941d, this.f45942e);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45940c, this.f45939b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f45942e.f46017c);
            }
        }
    }

    /* renamed from: d.a.o0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0786c implements d.a.o0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45944a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45945b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45946c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.d.c.f f45947d;

        public C0786c(c cVar, d.a.o0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.o0.a.i1.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, callbackHandler, unitedSchemeEntity, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45944a = eVar;
            this.f45945b = callbackHandler;
            this.f45946c = unitedSchemeEntity;
            this.f45947d = fVar;
        }

        @Override // d.a.o0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (a0.f44085b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    d.a.o0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f45945b, this.f45946c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.o0.a.i1.d.c.d.n(arrayList, this.f45944a), 0).toString(), this.f45947d.f46017c);
                }
                d.a.o0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.d.c.f f45948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.d.d.d f45950c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45951d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45952e;

        public d(c cVar, d.a.o0.a.i1.d.c.f fVar, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, eVar, dVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45948a = fVar;
            this.f45949b = eVar;
            this.f45950c = dVar;
            this.f45951d = callbackHandler;
            this.f45952e = unitedSchemeEntity;
        }

        @Override // d.a.o0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                d.a.o0.a.e0.d.g("chooseVideo", "capture success");
                d.a.o0.a.i1.d.c.e.i(d.a.o0.a.i1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", d.a.o0.a.g1.f.V().I().k());
                bundle.putBoolean("compressed", this.f45948a.f46016b);
                bundle.putString("swanAppId", this.f45949b.f43885f);
                bundle.putParcelableArrayList("mediaModels", d.a.o0.a.i1.d.c.e.e());
                d.a.o0.a.i1.d.c.d.h(this.f45949b.x(), bundle, this.f45950c);
            }
        }

        @Override // d.a.o0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45951d, this.f45952e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f45948a.f46017c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.o0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45953e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45954f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.d.c.f f45955g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45956h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.o0.a.i1.d.c.f fVar, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, unitedSchemeEntity, fVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45953e = callbackHandler;
            this.f45954f = unitedSchemeEntity;
            this.f45955g = fVar;
            this.f45956h = eVar;
        }

        @Override // d.a.o0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.o0.a.e0.d.g("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f45953e, this.f45954f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f45955g.f46017c);
            }
        }

        @Override // d.a.o0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.a.o0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f45953e, this.f45954f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.o0.a.i1.d.c.d.n(list, this.f45956h), 0).toString(), this.f45955g.f46017c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f45953e, this.f45954f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f45955g.f46017c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseVideo");
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

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.d0()) {
                if (a0.f44085b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            d.a.o0.a.i1.d.c.f a2 = d.a.o0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.f46015a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d.a.o0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0786c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            d.a.o0.a.i1.d.c.b.e(eVar.x(), eVar.f43885f, fVar.f46019e, TextUtils.equals(fVar.f46018d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d.a.o0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.f46015a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f46018d, "front"));
            bundle.putInt("maxDuration", fVar.f46019e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f46016b);
            bundle.putString("swanAppId", eVar.f43885f);
            bundle.putString("swanTmpPath", d.a.o0.a.g1.f.V().I().k());
            d.a.o0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
