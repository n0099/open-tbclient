package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = z;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.d = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[Catch: JSONException -> 0x008c, LOOP:1: B:22:0x006c->B:24:0x0072, LOOP_END, TryCatch #0 {JSONException -> 0x008c, blocks: (B:5:0x000b, B:6:0x0016, B:8:0x001c, B:10:0x0047, B:16:0x005d, B:18:0x0064, B:22:0x006c, B:24:0x0072, B:25:0x007e, B:26:0x0085, B:12:0x004d, B:14:0x0053, B:15:0x0058), top: B:36:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray jSONArray;
        HashSet hashSet;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            try {
                ArrayList arrayList = new ArrayList(16);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                    bVar.b(next);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    bVar.c(jSONObject2.getString("name"));
                    bVar.a(jSONObject2.getString("description"));
                    JSONArray jSONArray2 = null;
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (!jSONObject2.has("countries")) {
                        Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                        hashSet = new HashSet(16);
                        if (jSONArray2 != null && jSONArray2.length() != 0) {
                            for (i = 0; i < jSONArray2.length(); i++) {
                                hashSet.add((String) jSONArray2.get(i));
                            }
                            bVar.a(hashSet);
                            arrayList.add(bVar);
                        }
                        return new ArrayList();
                    } else {
                        jSONArray = jSONObject2.getJSONArray("countries");
                    }
                    jSONArray2 = jSONArray;
                    hashSet = new HashSet(16);
                    if (jSONArray2 != null) {
                        while (i < jSONArray2.length()) {
                        }
                        bVar.a(hashSet);
                        arrayList.add(bVar);
                    }
                    return new ArrayList();
                }
                return arrayList;
            } catch (JSONException e) {
                Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
                return new ArrayList();
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.a = new com.huawei.hms.framework.network.grs.local.model.a();
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject(MimeTypes.BASE_TYPE_APPLICATION);
                String string = jSONObject.getString("name");
                long j = jSONObject.getLong("cacheControl");
                JSONArray jSONArray = jSONObject.getJSONArray("services");
                this.a.b(string);
                this.a.a(j);
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        return 0;
                    }
                }
                return -1;
            } catch (JSONException e) {
                Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, jSONObject)) == null) ? (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject) : (List) invokeLL.objValue;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.b = new ArrayList(16);
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = null;
                if (jSONObject.has("countryOrAreaGroups")) {
                    jSONObject2 = jSONObject.getJSONObject("countryOrAreaGroups");
                } else if (jSONObject.has("countryGroups")) {
                    jSONObject2 = jSONObject.getJSONObject("countryGroups");
                } else {
                    Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                }
                if (jSONObject2 == null) {
                    return -1;
                }
                if (jSONObject2.length() != 0) {
                    this.b.addAll(a(jSONObject2));
                }
                return 0;
            } catch (JSONException e) {
                Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[Catch: JSONException -> 0x0124, TryCatch #0 {JSONException -> 0x0124, blocks: (B:5:0x0010, B:6:0x0021, B:8:0x0027, B:10:0x003d, B:12:0x0046, B:13:0x005a, B:15:0x0060, B:17:0x0071, B:24:0x008a, B:25:0x00a0, B:27:0x00a6, B:29:0x00ba, B:31:0x00c0, B:33:0x00d1, B:18:0x0076, B:20:0x007c, B:22:0x0083, B:34:0x00e5, B:36:0x00f0, B:40:0x00ff, B:42:0x0109, B:44:0x0110, B:45:0x0117, B:37:0x00f5, B:39:0x00fb, B:41:0x0104), top: B:56:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110 A[Catch: JSONException -> 0x0124, TryCatch #0 {JSONException -> 0x0124, blocks: (B:5:0x0010, B:6:0x0021, B:8:0x0027, B:10:0x003d, B:12:0x0046, B:13:0x005a, B:15:0x0060, B:17:0x0071, B:24:0x008a, B:25:0x00a0, B:27:0x00a6, B:29:0x00ba, B:31:0x00c0, B:33:0x00d1, B:18:0x0076, B:20:0x007c, B:22:0x0083, B:34:0x00e5, B:36:0x00f0, B:40:0x00ff, B:42:0x0109, B:44:0x0110, B:45:0x0117, B:37:0x00f5, B:39:0x00fb, B:41:0x0104), top: B:56:0x0010 }] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        String str2;
        String string;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String str3 = "countryGroup";
            String str4 = "countryOrAreaGroup";
            try {
                JSONObject jSONObject2 = new JSONObject(str).getJSONObject("services");
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next = keys2.next();
                    com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                    cVar.b(next);
                    if (!this.g.contains(next)) {
                        this.g.add(next);
                        if (this.e) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                            cVar.c(jSONObject3.getString("routeBy"));
                            JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                            int i = 0;
                            while (i < jSONArray.length()) {
                                JSONObject jSONObject4 = (JSONObject) jSONArray.get(i);
                                com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                                if (jSONObject4.has(str4)) {
                                    string = jSONObject4.getString(str4);
                                } else if (jSONObject4.has(str3)) {
                                    string = jSONObject4.getString(str3);
                                } else {
                                    Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                    str2 = "no-country";
                                    dVar.a(str2);
                                    JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                                    String str5 = str3;
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                    keys = jSONObject5.keys();
                                    while (keys.hasNext()) {
                                        Iterator<String> it = keys;
                                        String next2 = keys.next();
                                        String string2 = jSONObject5.getString(next2);
                                        if (TextUtils.isEmpty(next2) || TextUtils.isEmpty(string2)) {
                                            keys = it;
                                        } else {
                                            concurrentHashMap.put(next2, jSONObject5.getString(next2));
                                            keys = it;
                                            str4 = str4;
                                        }
                                    }
                                    dVar.a(concurrentHashMap);
                                    cVar.a(dVar.b(), dVar);
                                    i++;
                                    str3 = str5;
                                    str4 = str4;
                                }
                                str2 = string;
                                dVar.a(str2);
                                JSONObject jSONObject52 = jSONObject4.getJSONObject("addresses");
                                String str52 = str3;
                                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                                keys = jSONObject52.keys();
                                while (keys.hasNext()) {
                                }
                                dVar.a(concurrentHashMap2);
                                cVar.a(dVar.b(), dVar);
                                i++;
                                str3 = str52;
                                str4 = str4;
                            }
                            String str6 = str3;
                            String str7 = str4;
                            List<com.huawei.hms.framework.network.grs.local.model.b> list = null;
                            if (jSONObject3.has("countryOrAreaGroups")) {
                                jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                            } else if (jSONObject3.has("countryGroups")) {
                                jSONObject = jSONObject3.getJSONObject("countryGroups");
                            } else {
                                Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                                cVar.a(list);
                                if (this.a == null) {
                                    this.a = new com.huawei.hms.framework.network.grs.local.model.a();
                                }
                                this.a.a(next, cVar);
                                str3 = str6;
                                str4 = str7;
                            }
                            list = a((JSONArray) null, jSONObject);
                            cVar.a(list);
                            if (this.a == null) {
                            }
                            this.a.a(next, cVar);
                            str3 = str6;
                            str4 = str7;
                        }
                    }
                }
                return 0;
            } catch (JSONException e) {
                Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
                return -1;
            }
        }
        return invokeL.intValue;
    }
}
