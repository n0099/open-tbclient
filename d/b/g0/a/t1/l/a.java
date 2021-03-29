package d.b.g0.a.t1.l;

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
import com.baidu.webkit.internal.ETAG;
import d.b.g0.a.f2.e;
import d.b.g0.a.i2.i0;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.r1.d;
import d.b.g0.a.y0.e.c;
import d.b.g0.a.z1.h;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class a extends UnitedSchemeBaseInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46590a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f46591b;

    static {
        HashSet hashSet = new HashSet();
        f46591b = hashSet;
        hashSet.add("_baiduboxapp");
        f46591b.add("callback");
        f46591b.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        f46591b.add("_naExtParams");
    }

    public final String a(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return i0.l(uri, hashSet);
    }

    public final String b(Uri uri) {
        return i0.h(uri.getEncodedQuery(), f46591b);
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02cb  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str;
        String str2;
        String str3;
        Bundle bundle;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String i = i0.i(uri);
        if (f46590a) {
            Log.d("SwanLaunchInterceptor", "mAppId: " + i);
        }
        String h2 = SwanLauncher.h();
        d.e().s().J().E0(h2);
        if (TextUtils.isEmpty(i)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(1L);
            aVar.h(1L);
            aVar.e("appId is empty");
            e.a().f(aVar);
            d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
            dVar.q(h.n(0));
            dVar.p(aVar);
            dVar.l("scheme", uri.toString());
            h.H(dVar);
            i.j(aVar);
            return true;
        }
        String m = i0.m(i, uri, true);
        if (f46590a) {
            Log.d("SwanLaunchInterceptor", "pagePath: " + m);
        }
        String b2 = b(uri);
        if (f46590a) {
            Log.d("SwanLaunchInterceptor", "query: " + b2);
        }
        String uri2 = uri.toString();
        d.b.g0.a.c0.c.g("SwanLaunchInterceptor", "launch scheme = " + uri2);
        String str4 = uri2;
        String queryParameter = uri.getQueryParameter("_naExtParams");
        if (!TextUtils.isEmpty(queryParameter)) {
            str4 = a(uri);
        }
        c.a aVar2 = (c.a) ((c.a) ((c.a) new c.a().q0(i)).F0(str4)).E0(h2);
        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(b2)) {
            aVar2.J0(m + "?" + b2);
        } else if (!TextUtils.isEmpty(m)) {
            aVar2.J0(m);
        }
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param)) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar2.D0(jSONObject.optString("from"));
                aVar2.H0(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString(BeanConstants.CHANNEL_ID_NAVI);
                try {
                    aVar2.m0("srcAppId", jSONObject.optString("srcAppId"));
                    if (!jSONObject.isNull("extraData")) {
                        aVar2.m0("extraData", jSONObject.optString("extraData"));
                    }
                    aVar2.m0("srcAppPage", jSONObject.optString("srcAppPage"));
                    JSONObject b3 = d.b.g0.p.c.b(aVar2.S(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY), "pre_source");
                    if (b3 != null) {
                        aVar2.m0(UBCCloudControlProcessor.UBC_KEY, b3.toString());
                    }
                    if (optJSONObject != null) {
                        str = optJSONObject.optString(ETAG.KEY_SEARCH_ID);
                        try {
                            str2 = optJSONObject.optString("url");
                            try {
                                aVar2.t0(optJSONObject.optString("clkid"));
                                aVar2.m0("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                                aVar2.m0(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                                try {
                                    aVar2.l0("click_time", optJSONObject.optLong(PrefetchEvent.STATE_CLICK, -1L));
                                    str = str;
                                    str2 = str2;
                                } catch (JSONException e2) {
                                    e = e2;
                                    str = str;
                                    str2 = str2;
                                    if (f46590a) {
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                    }
                                    aVar2.n0().putString("search_id", str);
                                    aVar2.n0().putString("search_url", str2);
                                    aVar2.n0().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                                    d.b.g0.a.z1.l.b.f(aVar2);
                                    aVar2.w("tool_ip", unitedSchemeEntity.getParam("tip"));
                                    aVar2.w("tool_port", unitedSchemeEntity.getParam("tport"));
                                    aVar2.w("projectId", unitedSchemeEntity.getParam("projectId"));
                                    aVar2.w("fromHost", unitedSchemeEntity.getParam("fromHost"));
                                    aVar2.w("spuId", unitedSchemeEntity.getParam("spuId"));
                                    aVar2.w("contentId", unitedSchemeEntity.getParam("contentId"));
                                    if (TextUtils.isEmpty(queryParameter)) {
                                    }
                                    if (f46590a) {
                                    }
                                    String param2 = unitedSchemeEntity.getParam("cb");
                                    SwanLauncher.j().n(aVar2, bundle);
                                    d.b.g0.a.y0.a.l(str3, i, callbackHandler, unitedSchemeEntity, param2);
                                    return true;
                                }
                            } catch (JSONException e3) {
                                e = e3;
                            }
                        } catch (JSONException e4) {
                            e = e4;
                            str2 = null;
                            if (f46590a) {
                                Log.d("SwanLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                            }
                            if (TextUtils.isEmpty(str)) {
                            }
                            aVar2.n0().putString("search_id", str);
                            aVar2.n0().putString("search_url", str2);
                            aVar2.n0().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                            d.b.g0.a.z1.l.b.f(aVar2);
                            aVar2.w("tool_ip", unitedSchemeEntity.getParam("tip"));
                            aVar2.w("tool_port", unitedSchemeEntity.getParam("tport"));
                            aVar2.w("projectId", unitedSchemeEntity.getParam("projectId"));
                            aVar2.w("fromHost", unitedSchemeEntity.getParam("fromHost"));
                            aVar2.w("spuId", unitedSchemeEntity.getParam("spuId"));
                            aVar2.w("contentId", unitedSchemeEntity.getParam("contentId"));
                            if (TextUtils.isEmpty(queryParameter)) {
                            }
                            if (f46590a) {
                            }
                            String param22 = unitedSchemeEntity.getParam("cb");
                            SwanLauncher.j().n(aVar2, bundle);
                            d.b.g0.a.y0.a.l(str3, i, callbackHandler, unitedSchemeEntity, param22);
                            return true;
                        }
                    } else {
                        str = null;
                        str2 = null;
                    }
                    try {
                        String optString = jSONObject.optString("veloce");
                        if (!TextUtils.isEmpty(optString)) {
                            long optLong = new JSONObject(optString).optLong("starttime");
                            if (optLong > 0) {
                                aVar2.u("veloce_start_time", optLong);
                            }
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        if (f46590a) {
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        aVar2.n0().putString("search_id", str);
                        aVar2.n0().putString("search_url", str2);
                        aVar2.n0().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                        d.b.g0.a.z1.l.b.f(aVar2);
                        aVar2.w("tool_ip", unitedSchemeEntity.getParam("tip"));
                        aVar2.w("tool_port", unitedSchemeEntity.getParam("tport"));
                        aVar2.w("projectId", unitedSchemeEntity.getParam("projectId"));
                        aVar2.w("fromHost", unitedSchemeEntity.getParam("fromHost"));
                        aVar2.w("spuId", unitedSchemeEntity.getParam("spuId"));
                        aVar2.w("contentId", unitedSchemeEntity.getParam("contentId"));
                        if (TextUtils.isEmpty(queryParameter)) {
                        }
                        if (f46590a) {
                        }
                        String param222 = unitedSchemeEntity.getParam("cb");
                        SwanLauncher.j().n(aVar2, bundle);
                        d.b.g0.a.y0.a.l(str3, i, callbackHandler, unitedSchemeEntity, param222);
                        return true;
                    }
                } catch (JSONException e6) {
                    e = e6;
                    str = null;
                }
            } catch (JSONException e7) {
                e = e7;
                str = null;
                str2 = null;
                str3 = null;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals("1002", aVar2.S())) {
            aVar2.n0().putString("search_id", str);
            aVar2.n0().putString("search_url", str2);
            aVar2.n0().putLong("search_dom_click_timestamp", System.currentTimeMillis());
            d.b.g0.a.z1.l.b.f(aVar2);
        }
        aVar2.w("tool_ip", unitedSchemeEntity.getParam("tip"));
        aVar2.w("tool_port", unitedSchemeEntity.getParam("tport"));
        aVar2.w("projectId", unitedSchemeEntity.getParam("projectId"));
        aVar2.w("fromHost", unitedSchemeEntity.getParam("fromHost"));
        aVar2.w("spuId", unitedSchemeEntity.getParam("spuId"));
        aVar2.w("contentId", unitedSchemeEntity.getParam("contentId"));
        if (TextUtils.isEmpty(queryParameter)) {
            bundle = new Bundle();
            bundle.putString("_naExtParams", queryParameter);
        } else {
            bundle = null;
        }
        if (f46590a) {
            Log.d("SwanLaunchInterceptor", "launchParams: " + aVar2 + " \n_naExtParmas: " + queryParameter);
        }
        String param2222 = unitedSchemeEntity.getParam("cb");
        SwanLauncher.j().n(aVar2, bundle);
        d.b.g0.a.y0.a.l(str3, i, callbackHandler, unitedSchemeEntity, param2222);
        return true;
    }
}
