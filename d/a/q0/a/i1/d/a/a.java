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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.q0.a.a2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e0.d;
import d.a.q0.a.s1.f;
import d.a.q0.a.v2.w;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f48687c;

    /* renamed from: d  reason: collision with root package name */
    public String f48688d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48689e;

    /* renamed from: f  reason: collision with root package name */
    public String f48690f;

    /* renamed from: d.a.q0.a.i1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0826a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48691a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48692b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48693c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f48694d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f48695e;

        public C0826a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, unitedSchemeEntity, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48695e = aVar;
            this.f48691a = context;
            this.f48692b = unitedSchemeEntity;
            this.f48693c = callbackHandler;
            this.f48694d = eVar;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f46883b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f48695e.n(this.f48691a, this.f48692b, this.f48693c, this.f48694d);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f48693c, this.f48692b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f48695e.f48690f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48697f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f48698g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f48699h;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48699h = aVar;
            this.f48696e = callbackHandler;
            this.f48697f = unitedSchemeEntity;
            this.f48698g = eVar;
        }

        @Override // d.a.q0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.b("chooseAlbum", str);
                UnitedSchemeUtility.safeCallback(this.f48696e, this.f48697f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f48699h.f48690f);
            }
        }

        @Override // d.a.q0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.g("chooseAlbum", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f48696e, this.f48697f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.q0.a.i1.d.c.d.m(list, this.f48698g, "album"), 0).toString(), this.f48699h.f48690f);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f48696e, this.f48697f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f48699h.f48690f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseAlbum");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
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
                this.f48690f = optString;
                if (TextUtils.isEmpty(optString)) {
                    d.b("chooseAlbum", "callback is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                    return false;
                }
                this.f48687c = d2.optInt("count");
                this.f48688d = d2.optString("mode");
                this.f48689e = d2.optBoolean("compressed");
                m(context, unitedSchemeEntity, callbackHandler, eVar);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.b("chooseAlbum", "runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            d.a.q0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0826a(this, context, unitedSchemeEntity, callbackHandler, eVar));
        }
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "album");
            bundle.putBoolean("isShowCamera", false);
            bundle.putInt("count", this.f48687c);
            bundle.putString("mode", this.f48688d);
            bundle.putBoolean("compressed", this.f48689e);
            bundle.putString("swanAppId", eVar.f46683f);
            bundle.putString("swanTmpPath", d.a.q0.a.g1.f.V().I().k());
            d.a.q0.a.i1.d.c.d.l(context, bundle, new b(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
