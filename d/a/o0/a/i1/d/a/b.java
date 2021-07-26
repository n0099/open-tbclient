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
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.v2.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f45902c;

    /* renamed from: d  reason: collision with root package name */
    public String f45903d;

    /* renamed from: e  reason: collision with root package name */
    public String f45904e;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45906f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45907g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45908h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f45909i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45909i = bVar;
            this.f45905e = callbackHandler;
            this.f45906f = unitedSchemeEntity;
            this.f45907g = context;
            this.f45908h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.f45909i.v(this.f45907g, this.f45906f, this.f45905e, this.f45908h);
                    return;
                }
                d.a.o0.a.e2.c.d.o(iVar, this.f45905e, this.f45906f);
                d.a.o0.a.e0.d.b("chooseImage", "camera authorize failure");
            }
        }
    }

    /* renamed from: d.a.o0.a.i1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0785b implements d.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45911b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45912c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f45913d;

        public C0785b(b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, unitedSchemeEntity, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45913d = bVar;
            this.f45910a = unitedSchemeEntity;
            this.f45911b = callbackHandler;
            this.f45912c = eVar;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f44085b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f45913d.t(this.f45910a, this.f45911b, this.f45912c);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45911b, this.f45910a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f45913d.f45904e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45914a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45915b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45916c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45917d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f45919f;

        public c(b bVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45919f = bVar;
            this.f45914a = context;
            this.f45915b = unitedSchemeEntity;
            this.f45916c = callbackHandler;
            this.f45917d = eVar;
            this.f45918e = z;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f44085b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f45919f.x(this.f45914a, this.f45915b, this.f45916c, this.f45917d, this.f45918e);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45916c, this.f45915b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f45919f.f45904e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45920a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45921b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45922c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f45923d;

        public d(b bVar, d.a.o0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45923d = bVar;
            this.f45920a = eVar;
            this.f45921b = callbackHandler;
            this.f45922c = unitedSchemeEntity;
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
                            Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    d.a.o0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f45921b, this.f45922c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.o0.a.i1.d.c.d.m(arrayList, this.f45920a, "Image"), 0).toString(), this.f45923d.f45904e);
                }
                d.a.o0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.o0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.d.d.d f45925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45926c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45927d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f45928e;

        public e(b bVar, d.a.o0.a.a2.e eVar, d.a.o0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, dVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45928e = bVar;
            this.f45924a = eVar;
            this.f45925b = dVar;
            this.f45926c = callbackHandler;
            this.f45927d = unitedSchemeEntity;
        }

        @Override // d.a.o0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                d.a.o0.a.e0.d.g("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                d.a.o0.a.i1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", d.a.o0.a.g1.f.V().I().k());
                bundle.putBoolean("compressed", TextUtils.equals(this.f45928e.f45903d, "compressed"));
                bundle.putString("swanAppId", this.f45924a.f43885f);
                bundle.putParcelableArrayList("mediaModels", d.a.o0.a.i1.d.c.e.e());
                d.a.o0.a.i1.d.c.d.h(this.f45924a.x(), bundle, this.f45925b);
            }
        }

        @Override // d.a.o0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f45926c, this.f45927d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f45928e.f45904e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45930f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f45931g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f45932h;

        public f(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45932h = bVar;
            this.f45929e = callbackHandler;
            this.f45930f = unitedSchemeEntity;
            this.f45931g = eVar;
        }

        @Override // d.a.o0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.o0.a.e0.d.g("chooseImage", str);
                UnitedSchemeUtility.safeCallback(this.f45929e, this.f45930f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f45932h.f45904e);
            }
        }

        @Override // d.a.o0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.a.o0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f45929e, this.f45930f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.o0.a.i1.d.c.d.m(list, this.f45931g, "Image"), 0).toString(), this.f45932h.f45904e);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f45929e, this.f45930f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f45932h.f45904e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseImage");
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
            if (eVar != null && eVar.x() != null) {
                if (eVar.d0()) {
                    if (a0.f44085b) {
                        Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.f45904e = optString;
                if (TextUtils.isEmpty(optString)) {
                    d.a.o0.a.e0.d.b("chooseImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(d2.optString("count"));
                    this.f45902c = parseInt;
                    if (parseInt < 1 || parseInt > 9) {
                        this.f45902c = 9;
                    }
                } catch (NumberFormatException unused) {
                    d.a.o0.a.e0.d.b("chooseImage", "count format error");
                    this.f45902c = 9;
                }
                this.f45903d = r(d2.optJSONArray("sizeType"));
                JSONArray optJSONArray = d2.optJSONArray("sourceType");
                String s = s(optJSONArray);
                d.a.o0.a.e0.d.g("chooseImage", "sizeType: " + this.f45903d + ",sourceType: " + s);
                if (TextUtils.equals(s, "album")) {
                    u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
                } else {
                    eVar.T().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.o0.a.e0.d.b("chooseImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String r(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            boolean z = true;
            return (jSONArray != null && jSONArray.length() == 1 && TextUtils.equals("original", jSONArray.optString(0))) ? false : false ? "original" : "compressed";
        }
        return (String) invokeL.objValue;
    }

    public final String s(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            boolean z = true;
            return (jSONArray != null && jSONArray.length() == 1 && TextUtils.equals("camera", jSONArray.optString(0))) ? false : false ? "camera" : "album";
        }
        return (String) invokeL.objValue;
    }

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, eVar) == null) {
            d.a.o0.a.i1.d.c.b.f(eVar.x(), eVar.f43885f, new e(this, eVar, new d(this, eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
        }
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            d.a.o0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(this, context, unitedSchemeEntity, callbackHandler, eVar, z));
        }
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            d.a.o0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0785b(this, unitedSchemeEntity, callbackHandler, eVar));
        }
    }

    public final boolean w(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return true;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.equals("camera", jSONArray.optString(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "Image");
            bundle.putBoolean("isShowCamera", z);
            bundle.putInt("count", this.f45902c);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", TextUtils.equals(this.f45903d, "compressed"));
            bundle.putString("swanAppId", eVar.f43885f);
            bundle.putString("swanTmpPath", d.a.o0.a.g1.f.V().I().k());
            d.a.o0.a.i1.d.c.d.l(context, bundle, new f(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
