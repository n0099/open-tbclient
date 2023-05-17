package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.huawei.hms.framework.network.grs.local.model.a a;
    public List<com.huawei.hms.framework.network.grs.local.model.b> b;
    public Map<String, String> c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<String> g;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap(16);
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = new HashSet(16);
    }

    private Map<String, String> a(List<com.huawei.hms.framework.network.grs.local.model.b> list, GrsBaseInfo grsBaseInfo, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, list, grsBaseInfo, str)) == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
            concurrentHashMap.put("no_route_country", "no-country");
            for (com.huawei.hms.framework.network.grs.local.model.b bVar : list) {
                if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                    concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.b());
                }
                if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                    concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.b());
                }
                if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                    concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.b());
                }
                if (bVar.a().contains(str)) {
                    Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                    concurrentHashMap.put(str, bVar.b());
                }
            }
            return concurrentHashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    private int b(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, context)) == null) {
            if (f(com.huawei.hms.framework.network.grs.h.c.a(str, context)) == 0) {
                Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
                return 0;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    private int f(String str) {
        InterceptResult invokeL;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (!this.e || (b = b(str)) == 0) {
                int a = a(str);
                return a != 0 ? a : e(str);
            }
            return b;
        }
        return invokeL.intValue;
    }

    private int g(String str) {
        InterceptResult invokeL;
        List<com.huawei.hms.framework.network.grs.local.model.b> list;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return (!this.e || !((list = this.b) == null || list.isEmpty()) || (c = c(str)) == 0) ? d(str) : c;
        }
        return invokeL.intValue;
    }

    public abstract int a(String str);

    public int a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, context)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(GrsApp.getInstance().getBrand("/"));
            sb.append(str);
            return b(sb.toString(), context) != 0 ? -1 : 0;
        }
        return invokeLL.intValue;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, aVar, grsBaseInfo, str, str2, Boolean.valueOf(z)})) == null) {
            Map<String, String> a = a(context, aVar, grsBaseInfo, str, z);
            if (a == null) {
                Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
                return null;
            }
            return a.get(str2);
        }
        return (String) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: JSONException -> 0x0095, LOOP:1: B:27:0x0073->B:29:0x0079, LOOP_END, TryCatch #0 {JSONException -> 0x0095, blocks: (B:10:0x0015, B:11:0x001d, B:13:0x0023, B:15:0x004e, B:21:0x0064, B:23:0x006b, B:27:0x0073, B:29:0x0079, B:30:0x0085, B:31:0x008e, B:17:0x0054, B:19:0x005a, B:20:0x005f), top: B:43:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        JSONArray jSONArray2;
        HashSet hashSet;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return new ArrayList();
            }
            try {
                ArrayList arrayList = new ArrayList(16);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                    bVar.b(jSONObject.getString("id"));
                    bVar.c(jSONObject.getString("name"));
                    bVar.a(jSONObject.getString("description"));
                    JSONArray jSONArray3 = null;
                    if (jSONObject.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject.getJSONArray("countriesOrAreas");
                    } else if (!jSONObject.has("countries")) {
                        Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                        hashSet = new HashSet(16);
                        if (jSONArray3 != null && jSONArray3.length() != 0) {
                            for (i = 0; i < jSONArray3.length(); i++) {
                                hashSet.add((String) jSONArray3.get(i));
                            }
                            bVar.a(hashSet);
                            arrayList.add(bVar);
                        }
                        return new ArrayList();
                    } else {
                        jSONArray2 = jSONObject.getJSONArray("countries");
                    }
                    jSONArray3 = jSONArray2;
                    hashSet = new HashSet(16);
                    if (jSONArray3 != null) {
                        while (i < jSONArray3.length()) {
                        }
                        bVar.a(hashSet);
                        arrayList.add(bVar);
                    }
                    return new ArrayList();
                }
                return arrayList;
            } catch (JSONException e) {
                Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
                return new ArrayList();
            }
        }
        return (List) invokeL.objValue;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, aVar, grsBaseInfo, str, Boolean.valueOf(z)})) == null) {
            com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.a;
            if (aVar2 == null) {
                Logger.w("AbstractLocalManager", "application data is null.");
                return null;
            }
            com.huawei.hms.framework.network.grs.local.model.c a = aVar2.a(str);
            if (a == null) {
                Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
                return null;
            }
            String b = e.b(context, aVar, a.b(), grsBaseInfo, z);
            if (b == null) {
                Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a.b());
                return null;
            }
            List<com.huawei.hms.framework.network.grs.local.model.b> a2 = a.a();
            com.huawei.hms.framework.network.grs.local.model.d a3 = a.a(((a2 == null || a2.size() == 0) ? this.c : a(a2, grsBaseInfo, b)).get(b));
            if (a3 == null) {
                return null;
            }
            return a3.a();
        }
        return (Map) invokeCommon.objValue;
    }

    public void a() {
        com.huawei.hms.framework.network.grs.local.model.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.a();
        this.f = true;
    }

    public void a(Context context, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                if (g(com.huawei.hms.framework.network.grs.h.c.a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                } else {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                }
            }
        }
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, grsBaseInfo) == null) {
            this.c.put("no_route_country", "no-country");
            List<com.huawei.hms.framework.network.grs.local.model.b> list = this.b;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (com.huawei.hms.framework.network.grs.local.model.b bVar : this.b) {
                if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                    this.c.put(grsBaseInfo.getIssueCountry(), bVar.b());
                }
                if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                    this.c.put(grsBaseInfo.getRegCountry(), bVar.b());
                }
                if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                    this.c.put(grsBaseInfo.getSerCountry(), bVar.b());
                }
            }
            this.b = null;
        }
    }

    public abstract int b(String str);

    public com.huawei.hms.framework.network.grs.local.model.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (com.huawei.hms.framework.network.grs.local.model.a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(JSONArray jSONArray) {
        String str;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
            String string = jSONObject.getString("name");
            cVar.b(string);
            if (!this.g.contains(string)) {
                this.g.add(string);
                if (this.e) {
                    cVar.c(jSONObject.getString("routeBy"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("servings");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i2);
                        com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                        String str2 = "countryOrAreaGroup";
                        if (!jSONObject2.has("countryOrAreaGroup")) {
                            str2 = "countryGroup";
                            if (!jSONObject2.has("countryGroup")) {
                                Logger.v("AbstractLocalManager", "maybe this service{%s} routeBy is unconditional.", string);
                                str = "no-country";
                                dVar.a(str);
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                keys = jSONObject3.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    String string2 = jSONObject3.getString(next);
                                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                                        concurrentHashMap.put(next, jSONObject3.getString(next));
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                            }
                        }
                        str = jSONObject2.getString(str2);
                        dVar.a(str);
                        JSONObject jSONObject32 = jSONObject2.getJSONObject("addresses");
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                        keys = jSONObject32.keys();
                        while (keys.hasNext()) {
                        }
                        dVar.a(concurrentHashMap2);
                        cVar.a(dVar.b(), dVar);
                    }
                    List<com.huawei.hms.framework.network.grs.local.model.b> list = null;
                    String str3 = "countryOrAreaGroups";
                    if (!jSONObject.has("countryOrAreaGroups")) {
                        str3 = "countryGroups";
                        if (!jSONObject.has("countryGroups")) {
                            Logger.i("AbstractLocalManager", "service use default countryOrAreaGroup");
                            cVar.a(list);
                            if (this.a == null) {
                                this.a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.a.a(string, cVar);
                        }
                    }
                    list = a(jSONObject.getJSONArray(str3));
                    cVar.a(list);
                    if (this.a == null) {
                    }
                    this.a.a(string, cVar);
                }
            }
        }
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.b = new ArrayList(16);
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = null;
                if (jSONObject.has("countryOrAreaGroups")) {
                    jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
                } else if (jSONObject.has("countryGroups")) {
                    jSONArray = jSONObject.getJSONArray("countryGroups");
                } else {
                    Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                }
                if (jSONArray == null) {
                    return -1;
                }
                this.b.addAll(a(jSONArray));
                return 0;
            } catch (JSONException e) {
                Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public Set<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.g : (Set) invokeV.objValue;
    }

    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            try {
                b(new JSONObject(str).getJSONArray("services"));
                return 0;
            } catch (JSONException e) {
                Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public abstract int e(String str);

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d : invokeV.booleanValue;
    }
}
