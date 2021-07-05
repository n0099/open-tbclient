package d.a.q0.a.i1.d.a;

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
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.s1.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48731a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48732b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48733c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.c.f f48734d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48735e;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.c.f fVar) {
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
            this.f48735e = cVar;
            this.f48731a = unitedSchemeEntity;
            this.f48732b = callbackHandler;
            this.f48733c = eVar;
            this.f48734d = fVar;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f46883b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f48735e.p(this.f48731a, this.f48732b, this.f48733c, this.f48734d);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f48732b, this.f48731a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f48734d.f48815c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48736a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48737b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48738c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48739d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.c.f f48740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f48741f;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.c.f fVar) {
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
            this.f48741f = cVar;
            this.f48736a = context;
            this.f48737b = unitedSchemeEntity;
            this.f48738c = callbackHandler;
            this.f48739d = eVar;
            this.f48740e = fVar;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f46883b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f48741f.r(this.f48736a, this.f48737b, this.f48738c, this.f48739d, this.f48740e);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f48738c, this.f48737b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f48740e.f48815c);
            }
        }
    }

    /* renamed from: d.a.q0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0828c implements d.a.q0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48742a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48743b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48744c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.c.f f48745d;

        public C0828c(c cVar, d.a.q0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.q0.a.i1.d.c.f fVar) {
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
            this.f48742a = eVar;
            this.f48743b = callbackHandler;
            this.f48744c = unitedSchemeEntity;
            this.f48745d = fVar;
        }

        @Override // d.a.q0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (a0.f46883b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    d.a.q0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f48743b, this.f48744c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.q0.a.i1.d.c.d.n(arrayList, this.f48742a), 0).toString(), this.f48745d.f48815c);
                }
                d.a.q0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.c.f f48746a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48747b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.d.d f48748c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48749d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48750e;

        public d(c cVar, d.a.q0.a.i1.d.c.f fVar, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f48746a = fVar;
            this.f48747b = eVar;
            this.f48748c = dVar;
            this.f48749d = callbackHandler;
            this.f48750e = unitedSchemeEntity;
        }

        @Override // d.a.q0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                d.a.q0.a.e0.d.g("chooseVideo", "capture success");
                d.a.q0.a.i1.d.c.e.i(d.a.q0.a.i1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", d.a.q0.a.g1.f.V().I().k());
                bundle.putBoolean("compressed", this.f48746a.f48814b);
                bundle.putString("swanAppId", this.f48747b.f46683f);
                bundle.putParcelableArrayList("mediaModels", d.a.q0.a.i1.d.c.e.e());
                d.a.q0.a.i1.d.c.d.h(this.f48747b.x(), bundle, this.f48748c);
            }
        }

        @Override // d.a.q0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f48749d, this.f48750e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f48746a.f48815c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48751e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48752f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.c.f f48753g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48754h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.q0.a.i1.d.c.f fVar, d.a.q0.a.a2.e eVar) {
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
            this.f48751e = callbackHandler;
            this.f48752f = unitedSchemeEntity;
            this.f48753g = fVar;
            this.f48754h = eVar;
        }

        @Override // d.a.q0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.q0.a.e0.d.g("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f48751e, this.f48752f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f48753g.f48815c);
            }
        }

        @Override // d.a.q0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.a.q0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f48751e, this.f48752f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.q0.a.i1.d.c.d.n(list, this.f48754h), 0).toString(), this.f48753g.f48815c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f48751e, this.f48752f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f48753g.f48815c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.q0.a.c2.e eVar) {
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

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.d0()) {
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            d.a.q0.a.i1.d.c.f a2 = d.a.q0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.f48813a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d.a.q0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0828c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            d.a.q0.a.i1.d.c.b.e(eVar.x(), eVar.f46683f, fVar.f48817e, TextUtils.equals(fVar.f48816d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d.a.q0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.f48813a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f48816d, "front"));
            bundle.putInt("maxDuration", fVar.f48817e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f48814b);
            bundle.putString("swanAppId", eVar.f46683f);
            bundle.putString("swanTmpPath", d.a.q0.a.g1.f.V().I().k());
            d.a.q0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
