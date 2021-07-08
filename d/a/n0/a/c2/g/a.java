package d.a.n0.a.c2.g;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.n0.a.a2.d;
import d.a.n0.a.f1.e.c;
import d.a.n0.a.k;
import d.a.n0.a.q2.e;
import d.a.n0.a.r1.h;
import d.a.n0.a.v2.o0;
import d.a.n0.r.n;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class a extends UnitedSchemeBaseInterceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43934a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f43935b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(232876236, "Ld/a/n0/a/c2/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(232876236, "Ld/a/n0/a/c2/g/a;");
                return;
            }
        }
        f43934a = k.f45831a;
        HashSet hashSet = new HashSet();
        f43935b = hashSet;
        hashSet.add("_baiduboxapp");
        f43935b.add("callback");
        f43935b.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        f43935b.add("_naExtParams");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            if (uri == null) {
                return "";
            }
            HashSet hashSet = new HashSet();
            hashSet.add("_naExtParams");
            return o0.m(uri, hashSet);
        }
        return (String) invokeL.objValue;
    }

    public final String b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) ? o0.i(uri.getEncodedQuery(), f43935b) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "aiapps_launch_interceptor" : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0280  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        String str;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
                return false;
            }
            if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            }
            String j = o0.j(uri);
            if (f43934a) {
                Log.d("SwanLaunchInterceptor", "mAppId: " + j);
            }
            String h2 = SwanLauncher.h();
            d.g().r().L().I0(h2);
            if (TextUtils.isEmpty(j)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                aVar.j(1L);
                aVar.h(1L);
                aVar.e("appId is empty");
                e.a().f(aVar);
                d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
                dVar.q(d.a.n0.a.j2.k.m(0));
                dVar.p(aVar);
                dVar.l("scheme", uri.toString());
                d.a.n0.a.j2.k.L(dVar);
                h.k(aVar);
                return true;
            }
            String n = o0.n(j, uri, true);
            if (f43934a) {
                Log.d("SwanLaunchInterceptor", "pagePath: " + n);
            }
            String b2 = b(uri);
            if (f43934a) {
                Log.d("SwanLaunchInterceptor", "query: " + b2);
            }
            d.a.n0.a.c1.a.g0().b(d.a.n0.a.r1.l.e.o());
            n.f().b(d.a.n0.a.r1.l.e.f());
            String uri2 = uri.toString();
            d.a.n0.a.e0.d.g("SwanLaunchInterceptor", "launch scheme = " + uri2);
            String str2 = uri2;
            String queryParameter = uri.getQueryParameter("_naExtParams");
            if (!TextUtils.isEmpty(queryParameter)) {
                str2 = a(uri);
            }
            c.a aVar2 = (c.a) ((c.a) ((c.a) new c.a().u0(j)).J0(str2)).I0(h2);
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(b2)) {
                aVar2.Q0(n + "?" + b2);
            } else if (!TextUtils.isEmpty(n)) {
                aVar2.Q0(n);
            }
            String param = unitedSchemeEntity.getParam("_baiduboxapp");
            if (TextUtils.isEmpty(param)) {
                str = null;
            } else {
                try {
                    jSONObject = new JSONObject(param);
                    aVar2.H0(jSONObject.optString("from"));
                    aVar2.O0(jSONObject.optString("notinhis"));
                    optJSONObject = jSONObject.optJSONObject("ext");
                    str = jSONObject.optString(BeanConstants.CHANNEL_ID_NAVI);
                } catch (JSONException e2) {
                    e = e2;
                    str = null;
                }
                try {
                    aVar2.q0("srcAppId", jSONObject.optString("srcAppId"));
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar2.q0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    aVar2.q0("srcAppPage", jSONObject.optString("srcAppPage"));
                    JSONObject b3 = d.a.n0.t.c.b(aVar2.T(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
                    if (b3 != null) {
                        aVar2.q0(UBCCloudControlProcessor.UBC_KEY, b3.toString());
                    }
                    if (optJSONObject != null) {
                        aVar2.x0(optJSONObject.optString("clkid"));
                        aVar2.q0("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar2.q0(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                        aVar2.p0("click_time", optJSONObject.optLong(PrefetchEvent.STATE_CLICK, -1L));
                    }
                    String optString = jSONObject.optString("veloce");
                    if (!TextUtils.isEmpty(optString)) {
                        long optLong = new JSONObject(optString).optLong("starttime");
                        if (optLong > 0) {
                            aVar2.w("veloce_start_time", optLong);
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    if (f43934a) {
                        Log.d("SwanLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    aVar2.y("tool_ip", unitedSchemeEntity.getParam("tip"));
                    aVar2.y("tool_port", unitedSchemeEntity.getParam("tport"));
                    aVar2.y("projectId", unitedSchemeEntity.getParam("projectId"));
                    aVar2.y("fromHost", unitedSchemeEntity.getParam("fromHost"));
                    aVar2.y("spuId", unitedSchemeEntity.getParam("spuId"));
                    aVar2.y("contentId", unitedSchemeEntity.getParam("contentId"));
                    if (TextUtils.isEmpty(queryParameter)) {
                    }
                    if (f43934a) {
                    }
                    String param2 = unitedSchemeEntity.getParam("cb");
                    SwanLauncher.j().n(aVar2, bundle);
                    d.a.n0.a.f1.a.l(str, j, callbackHandler, unitedSchemeEntity, param2);
                    return true;
                }
            }
            aVar2.y("tool_ip", unitedSchemeEntity.getParam("tip"));
            aVar2.y("tool_port", unitedSchemeEntity.getParam("tport"));
            aVar2.y("projectId", unitedSchemeEntity.getParam("projectId"));
            aVar2.y("fromHost", unitedSchemeEntity.getParam("fromHost"));
            aVar2.y("spuId", unitedSchemeEntity.getParam("spuId"));
            aVar2.y("contentId", unitedSchemeEntity.getParam("contentId"));
            if (TextUtils.isEmpty(queryParameter)) {
                bundle = new Bundle();
                bundle.putString("_naExtParams", queryParameter);
            } else {
                bundle = null;
            }
            if (f43934a) {
                Log.d("SwanLaunchInterceptor", "launchParams: " + aVar2 + " \n_naExtParmas: " + queryParameter);
            }
            String param22 = unitedSchemeEntity.getParam("cb");
            SwanLauncher.j().n(aVar2, bundle);
            d.a.n0.a.f1.a.l(str, j, callbackHandler, unitedSchemeEntity, param22);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
