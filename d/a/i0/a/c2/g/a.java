package d.a.i0.a.c2.g;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.i0.a.a2.d;
import d.a.i0.a.f1.e.c;
import d.a.i0.a.k;
import d.a.i0.a.q2.e;
import d.a.i0.a.r1.h;
import d.a.i0.a.v2.o0;
import d.a.i0.r.n;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a extends UnitedSchemeBaseInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41128a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f41129b;

    static {
        HashSet hashSet = new HashSet();
        f41129b = hashSet;
        hashSet.add("_baiduboxapp");
        f41129b.add("callback");
        f41129b.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        f41129b.add("_naExtParams");
    }

    public final String a(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return o0.m(uri, hashSet);
    }

    public final String b(Uri uri) {
        return o0.i(uri.getEncodedQuery(), f41129b);
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x027c  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str;
        Bundle bundle;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String j = o0.j(uri);
        if (f41128a) {
            Log.d("SwanLaunchInterceptor", "mAppId: " + j);
        }
        String h2 = SwanLauncher.h();
        d.g().r().L().I0(h2);
        if (TextUtils.isEmpty(j)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(1L);
            aVar.h(1L);
            aVar.e("appId is empty");
            e.a().f(aVar);
            d.a.i0.a.j2.p.d dVar = new d.a.i0.a.j2.p.d();
            dVar.q(d.a.i0.a.j2.k.m(0));
            dVar.p(aVar);
            dVar.l("scheme", uri.toString());
            d.a.i0.a.j2.k.L(dVar);
            h.k(aVar);
            return true;
        }
        String n = o0.n(j, uri, true);
        if (f41128a) {
            Log.d("SwanLaunchInterceptor", "pagePath: " + n);
        }
        String b2 = b(uri);
        if (f41128a) {
            Log.d("SwanLaunchInterceptor", "query: " + b2);
        }
        d.a.i0.a.c1.a.g0().b(d.a.i0.a.r1.l.e.o());
        n.f().b(d.a.i0.a.r1.l.e.f());
        String uri2 = uri.toString();
        d.a.i0.a.e0.d.g("SwanLaunchInterceptor", "launch scheme = " + uri2);
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
                JSONObject jSONObject = new JSONObject(param);
                aVar2.H0(jSONObject.optString("from"));
                aVar2.O0(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str = jSONObject.optString(BeanConstants.CHANNEL_ID_NAVI);
                try {
                    aVar2.q0("srcAppId", jSONObject.optString("srcAppId"));
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar2.q0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    aVar2.q0("srcAppPage", jSONObject.optString("srcAppPage"));
                    JSONObject b3 = d.a.i0.t.c.b(aVar2.T(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
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
                } catch (JSONException e2) {
                    e = e2;
                    if (f41128a) {
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
                    if (f41128a) {
                    }
                    String param2 = unitedSchemeEntity.getParam("cb");
                    SwanLauncher.j().n(aVar2, bundle);
                    d.a.i0.a.f1.a.l(str, j, callbackHandler, unitedSchemeEntity, param2);
                    return true;
                }
            } catch (JSONException e3) {
                e = e3;
                str = null;
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
        if (f41128a) {
            Log.d("SwanLaunchInterceptor", "launchParams: " + aVar2 + " \n_naExtParmas: " + queryParameter);
        }
        String param22 = unitedSchemeEntity.getParam("cb");
        SwanLauncher.j().n(aVar2, bundle);
        d.a.i0.a.f1.a.l(str, j, callbackHandler, unitedSchemeEntity, param22);
        return true;
    }
}
