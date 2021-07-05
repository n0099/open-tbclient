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
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.v2.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f48700c;

    /* renamed from: d  reason: collision with root package name */
    public String f48701d;

    /* renamed from: e  reason: collision with root package name */
    public String f48702e;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48704f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f48705g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48706h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f48707i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.q0.a.a2.e eVar) {
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
            this.f48707i = bVar;
            this.f48703e = callbackHandler;
            this.f48704f = unitedSchemeEntity;
            this.f48705g = context;
            this.f48706h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    this.f48707i.v(this.f48705g, this.f48704f, this.f48703e, this.f48706h);
                    return;
                }
                d.a.q0.a.e2.c.d.o(iVar, this.f48703e, this.f48704f);
                d.a.q0.a.e0.d.b("chooseImage", "camera authorize failure");
            }
        }
    }

    /* renamed from: d.a.q0.a.i1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0827b implements d.a.q0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48708a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48709b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48710c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f48711d;

        public C0827b(b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
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
            this.f48711d = bVar;
            this.f48708a = unitedSchemeEntity;
            this.f48709b = callbackHandler;
            this.f48710c = eVar;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f46883b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f48711d.t(this.f48708a, this.f48709b, this.f48710c);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f48709b, this.f48708a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f48711d.f48702e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48713b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48714c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48715d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48716e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f48717f;

        public c(b bVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, boolean z) {
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
            this.f48717f = bVar;
            this.f48712a = context;
            this.f48713b = unitedSchemeEntity;
            this.f48714c = callbackHandler;
            this.f48715d = eVar;
            this.f48716e = z;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f46883b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f48717f.x(this.f48712a, this.f48713b, this.f48714c, this.f48715d, this.f48716e);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f48714c, this.f48713b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f48717f.f48702e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48719b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48720c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f48721d;

        public d(b bVar, d.a.q0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f48721d = bVar;
            this.f48718a = eVar;
            this.f48719b = callbackHandler;
            this.f48720c = unitedSchemeEntity;
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
                            Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    d.a.q0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f48719b, this.f48720c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.q0.a.i1.d.c.d.m(arrayList, this.f48718a, "Image"), 0).toString(), this.f48721d.f48702e);
                }
                d.a.q0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.d.d f48723b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48724c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48725d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48726e;

        public e(b bVar, d.a.q0.a.a2.e eVar, d.a.q0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f48726e = bVar;
            this.f48722a = eVar;
            this.f48723b = dVar;
            this.f48724c = callbackHandler;
            this.f48725d = unitedSchemeEntity;
        }

        @Override // d.a.q0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                d.a.q0.a.e0.d.g("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                d.a.q0.a.i1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", d.a.q0.a.g1.f.V().I().k());
                bundle.putBoolean("compressed", TextUtils.equals(this.f48726e.f48701d, "compressed"));
                bundle.putString("swanAppId", this.f48722a.f46683f);
                bundle.putParcelableArrayList("mediaModels", d.a.q0.a.i1.d.c.e.e());
                d.a.q0.a.i1.d.c.d.h(this.f48722a.x(), bundle, this.f48723b);
            }
        }

        @Override // d.a.q0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f48724c, this.f48725d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f48726e.f48702e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48728f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f48729g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f48730h;

        public f(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.q0.a.a2.e eVar) {
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
            this.f48730h = bVar;
            this.f48727e = callbackHandler;
            this.f48728f = unitedSchemeEntity;
            this.f48729g = eVar;
        }

        @Override // d.a.q0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.q0.a.e0.d.g("chooseImage", str);
                UnitedSchemeUtility.safeCallback(this.f48727e, this.f48728f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f48730h.f48702e);
            }
        }

        @Override // d.a.q0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.a.q0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f48727e, this.f48728f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.q0.a.i1.d.c.d.m(list, this.f48729g, "Image"), 0).toString(), this.f48730h.f48702e);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f48727e, this.f48728f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f48730h.f48702e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.q0.a.c2.e eVar) {
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

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.x() != null) {
                if (eVar.d0()) {
                    if (a0.f46883b) {
                        Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.f48702e = optString;
                if (TextUtils.isEmpty(optString)) {
                    d.a.q0.a.e0.d.b("chooseImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(d2.optString("count"));
                    this.f48700c = parseInt;
                    if (parseInt < 1 || parseInt > 9) {
                        this.f48700c = 9;
                    }
                } catch (NumberFormatException unused) {
                    d.a.q0.a.e0.d.b("chooseImage", "count format error");
                    this.f48700c = 9;
                }
                this.f48701d = r(d2.optJSONArray("sizeType"));
                JSONArray optJSONArray = d2.optJSONArray("sourceType");
                String s = s(optJSONArray);
                d.a.q0.a.e0.d.g("chooseImage", "sizeType: " + this.f48701d + ",sourceType: " + s);
                if (TextUtils.equals(s, "album")) {
                    u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
                } else {
                    eVar.T().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.q0.a.e0.d.b("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, eVar) == null) {
            d.a.q0.a.i1.d.c.b.f(eVar.x(), eVar.f46683f, new e(this, eVar, new d(this, eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
        }
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            d.a.q0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(this, context, unitedSchemeEntity, callbackHandler, eVar, z));
        }
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            d.a.q0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0827b(this, unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "Image");
            bundle.putBoolean("isShowCamera", z);
            bundle.putInt("count", this.f48700c);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", TextUtils.equals(this.f48701d, "compressed"));
            bundle.putString("swanAppId", eVar.f46683f);
            bundle.putString("swanTmpPath", d.a.q0.a.g1.f.V().I().k());
            d.a.q0.a.i1.d.c.d.l(context, bundle, new f(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
