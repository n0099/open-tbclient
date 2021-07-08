package d.a.n0.a.i1.d.a;

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
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.s1.f;
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
        public final /* synthetic */ UnitedSchemeEntity f45429a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45430b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f45431c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.i1.d.c.f f45432d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f45433e;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, d.a.n0.a.i1.d.c.f fVar) {
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
            this.f45433e = cVar;
            this.f45429a = unitedSchemeEntity;
            this.f45430b = callbackHandler;
            this.f45431c = eVar;
            this.f45432d = fVar;
        }

        @Override // d.a.n0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f43581b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f45433e.p(this.f45429a, this.f45430b, this.f45431c, this.f45432d);
            }
        }

        @Override // d.a.n0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45430b, this.f45429a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f45432d.f45513c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45434a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45435b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45436c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f45437d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.i1.d.c.f f45438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f45439f;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, d.a.n0.a.i1.d.c.f fVar) {
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
            this.f45439f = cVar;
            this.f45434a = context;
            this.f45435b = unitedSchemeEntity;
            this.f45436c = callbackHandler;
            this.f45437d = eVar;
            this.f45438e = fVar;
        }

        @Override // d.a.n0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f43581b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f45439f.r(this.f45434a, this.f45435b, this.f45436c, this.f45437d, this.f45438e);
            }
        }

        @Override // d.a.n0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45436c, this.f45435b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f45438e.f45513c);
            }
        }
    }

    /* renamed from: d.a.n0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0777c implements d.a.n0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f45440a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45441b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45442c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.i1.d.c.f f45443d;

        public C0777c(c cVar, d.a.n0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.n0.a.i1.d.c.f fVar) {
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
            this.f45440a = eVar;
            this.f45441b = callbackHandler;
            this.f45442c = unitedSchemeEntity;
            this.f45443d = fVar;
        }

        @Override // d.a.n0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (a0.f43581b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    d.a.n0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f45441b, this.f45442c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.n0.a.i1.d.c.d.n(arrayList, this.f45440a), 0).toString(), this.f45443d.f45513c);
                }
                d.a.n0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.n0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.i1.d.c.f f45444a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f45445b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.i1.d.d.d f45446c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45447d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45448e;

        public d(c cVar, d.a.n0.a.i1.d.c.f fVar, d.a.n0.a.a2.e eVar, d.a.n0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f45444a = fVar;
            this.f45445b = eVar;
            this.f45446c = dVar;
            this.f45447d = callbackHandler;
            this.f45448e = unitedSchemeEntity;
        }

        @Override // d.a.n0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                d.a.n0.a.e0.d.g("chooseVideo", "capture success");
                d.a.n0.a.i1.d.c.e.i(d.a.n0.a.i1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", d.a.n0.a.g1.f.V().I().k());
                bundle.putBoolean("compressed", this.f45444a.f45512b);
                bundle.putString("swanAppId", this.f45445b.f43381f);
                bundle.putParcelableArrayList("mediaModels", d.a.n0.a.i1.d.c.e.e());
                d.a.n0.a.i1.d.c.d.h(this.f45445b.x(), bundle, this.f45446c);
            }
        }

        @Override // d.a.n0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45447d, this.f45448e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f45444a.f45513c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.n0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45450f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.i1.d.c.f f45451g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f45452h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.n0.a.i1.d.c.f fVar, d.a.n0.a.a2.e eVar) {
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
            this.f45449e = callbackHandler;
            this.f45450f = unitedSchemeEntity;
            this.f45451g = fVar;
            this.f45452h = eVar;
        }

        @Override // d.a.n0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.n0.a.e0.d.g("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f45449e, this.f45450f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f45451g.f45513c);
            }
        }

        @Override // d.a.n0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.a.n0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f45449e, this.f45450f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.n0.a.i1.d.c.d.n(list, this.f45452h), 0).toString(), this.f45451g.f45513c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f45449e, this.f45450f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f45451g.f45513c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.n0.a.c2.e eVar) {
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

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.d0()) {
                if (a0.f43581b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            d.a.n0.a.i1.d.c.f a2 = d.a.n0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.f45511a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, d.a.n0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d.a.n0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, d.a.n0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0777c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            d.a.n0.a.i1.d.c.b.e(eVar.x(), eVar.f43381f, fVar.f45515e, TextUtils.equals(fVar.f45514d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, d.a.n0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d.a.n0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, d.a.n0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.f45511a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f45514d, "front"));
            bundle.putInt("maxDuration", fVar.f45515e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f45512b);
            bundle.putString("swanAppId", eVar.f43381f);
            bundle.putString("swanTmpPath", d.a.n0.a.g1.f.V().I().k());
            d.a.n0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
