package d.a.o0.n.o;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import d.a.o0.n.h.h;
import d.a.o0.n.i.l.a;
import d.a.o0.n.j.i.l;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PMSAppInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            PMSAppInfo pMSAppInfo = new PMSAppInfo();
            pMSAppInfo.appKey = jSONObject.optString("app_key");
            pMSAppInfo.appName = jSONObject.optString("app_name");
            pMSAppInfo.description = jSONObject.optString("app_desc");
            pMSAppInfo.appStatus = jSONObject.optInt("app_status");
            pMSAppInfo.statusDetail = jSONObject.optString("status_detail");
            pMSAppInfo.statusDesc = jSONObject.optString("status_desc");
            pMSAppInfo.resumeDate = jSONObject.optString("resume_date");
            pMSAppInfo.subjectInfo = jSONObject.optString("subject_info");
            pMSAppInfo.maxAge = jSONObject.optLong("max_age");
            pMSAppInfo.appCategory = jSONObject.optInt("sub_category");
            pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
            pMSAppInfo.serviceCategory = jSONObject.optString("service_category");
            pMSAppInfo.webViewDomains = jSONObject.optString("webview_domains");
            pMSAppInfo.domainConfig = jSONObject.optString("domain_config");
            pMSAppInfo.webAction = jSONObject.optString("web_action");
            pMSAppInfo.domains = jSONObject.optString("domains");
            pMSAppInfo.serverExt = jSONObject.optString("ext");
            pMSAppInfo.appSign = jSONObject.optLong("app_sign");
            pMSAppInfo.payProtected = jSONObject.optInt("pay_protected", PMSConstants.PayProtected.NO_PAY_PROTECTED.type);
            pMSAppInfo.customerService = jSONObject.optInt("customer_service", PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type);
            pMSAppInfo.globalNotice = jSONObject.optInt("global_notice", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.globalPrivate = jSONObject.optInt("global_private", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.paNumber = jSONObject.optString("pa_number");
            String optString = m(pMSAppInfo.serverExt).optString("quick_app_key");
            if (!TextUtils.isEmpty(optString)) {
                pMSAppInfo.quickAppKey = optString;
            }
            JSONObject optJSONObject = m(pMSAppInfo.serverExt).optJSONObject(SwanAppBearInfo.BEAR_INFO);
            if (optJSONObject != null) {
                pMSAppInfo.bearInfo = optJSONObject.toString();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("plugins");
            if (optJSONArray != null) {
                pMSAppInfo.pluginInfo = optJSONArray.toString();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("brand");
            if (optJSONObject2 != null) {
                pMSAppInfo.brandsInfo = optJSONObject2.toString();
            }
            d.a.o0.n.c.b().l(jSONObject.optJSONArray("ban_page"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
            d.a.o0.n.c.b().r(pMSAppInfo, jSONObject.optJSONObject("scope_list"), jSONObject.optInt("service_degrade", 0) != 0);
            pMSAppInfo.webUrl = jSONObject.optString("web_url");
            pMSAppInfo.csProtocolVersion = PMSConstants.b.a();
            return pMSAppInfo;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    public static boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && 1 == jSONObject.optInt("reset_env", 0) : invokeL.booleanValue;
    }

    public static d.a.o0.n.h.b c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (d.a.o0.n.h.b) i(jSONObject, new d.a.o0.n.h.b());
        }
        return (d.a.o0.n.h.b) invokeL.objValue;
    }

    public static d.a.o0.n.h.d d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (d.a.o0.n.h.d) i(jSONObject, new d.a.o0.n.h.d());
        }
        return (d.a.o0.n.h.d) invokeL.objValue;
    }

    public static d.a.o0.n.i.l.a e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d.a.o0.n.i.l.a aVar = new d.a.o0.n.i.l.a();
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    a.C1155a c1155a = new a.C1155a();
                    c1155a.f51209a = optJSONObject.optInt("errno");
                    c1155a.f51210b = optJSONObject.optString("bundle_id");
                    c1155a.f51211c = optJSONObject.optInt("category");
                    c1155a.f51212d = j(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
                    c1155a.f51213e = k(optJSONObject.optJSONArray("sub"));
                    c1155a.f51214f = a(optJSONObject.optJSONObject("app_info"));
                    d.a.o0.n.c.b().p(c1155a.f51210b, optJSONObject, c1155a.f51212d, c1155a.f51213e);
                    arrayList.add(c1155a);
                }
            }
            aVar.f51208a = arrayList;
            return aVar;
        }
        return (d.a.o0.n.i.l.a) invokeL.objValue;
    }

    public static d.a.o0.n.i.l.b f(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d.a.o0.n.i.l.b bVar = new d.a.o0.n.i.l.b();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                bVar.f51216a = j(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
                bVar.f51217b = k(optJSONObject.optJSONArray("sub"));
                d.a.o0.n.c.b().p(str, optJSONObject, bVar.f51216a, bVar.f51217b);
            }
            bVar.f51218c = d(jSONObject.optJSONObject("framework"));
            bVar.f51220e = c(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
            bVar.f51219d = a(jSONObject.optJSONObject("app_info"));
            return bVar;
        }
        return (d.a.o0.n.i.l.b) invokeLL.objValue;
    }

    public static d.a.o0.n.i.l.c g(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d.a.o0.n.i.l.c cVar = new d.a.o0.n.i.l.c();
            cVar.f51221a = l(jSONObject);
            return cVar;
        }
        return (d.a.o0.n.i.l.c) invokeL.objValue;
    }

    public static d.a.o0.n.i.l.d h(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d.a.o0.n.i.l.d dVar = new d.a.o0.n.i.l.d();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                dVar.f51222a = k(optJSONObject.optJSONArray("sub"));
                d.a.o0.n.c.b().p(str, optJSONObject, null, dVar.f51222a);
            }
            return dVar;
        }
        return (d.a.o0.n.i.l.d) invokeLL.objValue;
    }

    public static <T extends d.a.o0.n.h.e> T i(JSONObject jSONObject, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, t)) == null) {
            if (jSONObject == null || t == null) {
                return null;
            }
            t.f51140g = jSONObject.optString("bundle_id");
            t.f51141h = jSONObject.optInt("category");
            t.j = jSONObject.optString("version_name");
            t.f51142i = jSONObject.optInt("version_code");
            t.k = jSONObject.optLong("size");
            t.l = jSONObject.optString(PackageTable.MD5);
            t.m = jSONObject.optString("sign");
            t.n = jSONObject.optString("download_url");
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public static d.a.o0.n.h.f j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d.a.o0.n.h.f fVar = (d.a.o0.n.h.f) i(jSONObject, new d.a.o0.n.h.f());
            fVar.o = jSONObject.optInt("pkg_type");
            fVar.p = jSONObject.optString("ext");
            return fVar;
        }
        return (d.a.o0.n.h.f) invokeL.objValue;
    }

    public static List<d.a.o0.n.h.g> k(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    d.a.o0.n.h.g gVar = (d.a.o0.n.h.g) i(optJSONObject, new d.a.o0.n.h.g());
                    gVar.q = optJSONObject.optInt("pkg_type");
                    gVar.p = optJSONObject.optString("sub_path");
                    gVar.r = optJSONObject.optBoolean("independent");
                    gVar.s = optJSONObject.optString("ext");
                    arrayList.add(gVar);
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static h l(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            h hVar = new h();
            i(jSONObject, hVar);
            long optLong = jSONObject.optLong("max_age");
            if (optLong < 0) {
                optLong = 0;
            }
            hVar.o = optLong;
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    public static JSONObject m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static d.a.o0.n.i.l.e n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d.a.o0.n.i.l.e eVar = new d.a.o0.n.i.l.e();
            eVar.f51223a = jSONObject.optLong("max_age");
            long optLong = jSONObject.optLong("lastsynctime");
            if (optLong > 0) {
                l.f51284c = optLong;
            }
            eVar.f51224b = jSONObject;
            return eVar;
        }
        return (d.a.o0.n.i.l.e) invokeL.objValue;
    }
}
