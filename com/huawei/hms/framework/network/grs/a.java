package com.huawei.hms.framework.network.grs;

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
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String e = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public final GrsBaseInfo a;
    public com.huawei.hms.framework.network.grs.e.a b;
    public h c;
    public com.huawei.hms.framework.network.grs.e.c d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0542a implements com.huawei.hms.framework.network.grs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Map<String, String> b;
        public IQueryUrlsCallBack c;
        public Context d;
        public GrsBaseInfo e;
        public com.huawei.hms.framework.network.grs.e.a f;

        public C0542a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, map, iQueryUrlsCallBack, context, grsBaseInfo, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = map;
            this.c = iQueryUrlsCallBack;
            this.d = context;
            this.e = grsBaseInfo;
            this.f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, String> map = this.b;
                if (map != null && !map.isEmpty()) {
                    Logger.i(a.e, "get expired cache localUrls");
                    this.c.onCallBackSuccess(this.b);
                } else if (this.b != null) {
                    this.c.onCallBackFail(-3);
                } else {
                    Logger.i(a.e, "access local config for return a domain.");
                    this.c.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true));
                }
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                Map<String, String> a = a.a(dVar.j(), this.a);
                if (a.isEmpty()) {
                    Map<String, String> map = this.b;
                    if (map != null && !map.isEmpty()) {
                        Logger.i(a.e, "get expired cache localUrls");
                        this.c.onCallBackSuccess(this.b);
                        return;
                    } else if (this.b != null) {
                        this.c.onCallBackFail(-5);
                        return;
                    } else {
                        Logger.i(a.e, "access local config for return a domain.");
                        a = com.huawei.hms.framework.network.grs.f.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true);
                    }
                } else {
                    Logger.i(a.e, "get url is from remote server");
                }
                this.c.onCallBackSuccess(a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements com.huawei.hms.framework.network.grs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public IQueryUrlCallBack c;
        public String d;
        public Context e;
        public GrsBaseInfo f;
        public com.huawei.hms.framework.network.grs.e.a g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, iQueryUrlCallBack, str3, context, grsBaseInfo, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = iQueryUrlCallBack;
            this.d = str3;
            this.e = context;
            this.f = grsBaseInfo;
            this.g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.d)) {
                    Logger.i(a.e, "get expired cache localUrl");
                    this.c.onCallBackSuccess(this.d);
                } else if (!TextUtils.isEmpty(this.d)) {
                    this.c.onCallBackFail(-3);
                } else {
                    Logger.i(a.e, "access local config for return a domain.");
                    this.c.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true));
                }
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            String a;
            IQueryUrlCallBack iQueryUrlCallBack;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                Map<String, String> a2 = a.a(dVar.j(), this.a);
                if (a2.containsKey(this.b)) {
                    Logger.i(a.e, "get url is from remote server");
                    iQueryUrlCallBack = this.c;
                    a = a2.get(this.b);
                } else if (!TextUtils.isEmpty(this.d)) {
                    Logger.i(a.e, "get expired cache localUrl");
                    this.c.onCallBackSuccess(this.d);
                    return;
                } else if (!TextUtils.isEmpty(this.d)) {
                    this.c.onCallBackFail(-5);
                    return;
                } else {
                    Logger.i(a.e, "access local config for return a domain.");
                    a = com.huawei.hms.framework.network.grs.f.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true);
                    iQueryUrlCallBack = this.c;
                }
                iQueryUrlCallBack.onCallBackSuccess(a);
            }
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, h hVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {grsBaseInfo, aVar, hVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = grsBaseInfo;
        this.b = aVar;
        this.c = hVar;
        this.d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, context, z)) == null) ? new CountryCodeBean(context, z) : (CountryCodeBean) invokeLZ.objValue;
    }

    public static Map<String, Map<String, String>> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
            if (TextUtils.isEmpty(str)) {
                Logger.v(e, "isSpExpire jsonValue is null.");
                return concurrentHashMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (!TextUtils.isEmpty(next)) {
                        concurrentHashMap.put(next, a(jSONObject2));
                    }
                }
                return concurrentHashMap;
            } catch (JSONException e2) {
                Logger.w(e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
                return concurrentHashMap;
            }
        }
        return (Map) invokeL.objValue;
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, bVar, context)) == null) {
            Map<String, String> a = this.b.a(this.a, str, bVar, context);
            if (a == null || a.isEmpty()) {
                Map<String, String> a2 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, false);
                return a2 != null ? a2 : new HashMap();
            }
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return a;
        }
        return (Map) invokeLLL.objValue;
    }

    public static Map<String, String> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(str)) {
                Logger.w(e, "isSpExpire jsonValue from server is null.");
                return hashMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
                if (jSONObject2 == null) {
                    Logger.w(e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                    return hashMap;
                }
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next).toString());
                }
                return hashMap;
            } catch (JSONException e2) {
                Logger.w(e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
                return hashMap;
            }
        }
        return (Map) invokeLL.objValue;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = jSONObject.get(next).toString();
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                        concurrentHashMap.put(next, obj);
                    }
                }
                return concurrentHashMap;
            } catch (JSONException e2) {
                Logger.w(e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
                return concurrentHashMap;
            }
        }
        return (Map) invokeL.objValue;
    }

    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            com.huawei.hms.framework.network.grs.g.d a = this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), str, this.d);
            return a == null ? "" : a.m() ? this.b.a().a(this.a.getGrsParasKey(true, true, context), "") : a.j();
        }
        return (String) invokeLL.objValue;
    }

    public String a(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, context)) == null) {
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            String str3 = a(str, bVar, context).get(str2);
            if (bVar.a() && !TextUtils.isEmpty(str3)) {
                Logger.i(e, "get unexpired cache localUrl: %s", StringUtils.anonymizeMessage(str3));
                com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
                return str3;
            }
            String str4 = a(a(context, str), str).get(str2);
            if (!TextUtils.isEmpty(str4)) {
                Logger.i(e, "get url is from remote server");
                com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
                return str4;
            }
            if (TextUtils.isEmpty(str3)) {
                Logger.i(e, "access local config for return a domain.");
                str3 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, str2, true);
            } else {
                Logger.i(e, "get expired cache localUrl");
            }
            Logger.i(e, "synGetGrsUrl: %s", StringUtils.anonymizeMessage(str3));
            return str3;
        }
        return (String) invokeLLL.objValue;
    }

    public Map<String, String> a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, context)) == null) {
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            Map<String, String> a = a(str, bVar, context);
            if (bVar.a() && !a.isEmpty()) {
                Logger.i(e, "get unexpired cache localUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a).toString()));
                com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
                return a;
            }
            Map<String, String> a2 = a(a(context, str), str);
            if (!a2.isEmpty()) {
                Logger.i(e, "get url is from remote server");
                com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
                return a2;
            }
            if (a.isEmpty()) {
                Logger.i(e, "access local config for return a domain.");
                a = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, true);
            } else {
                Logger.i(e, "get expired cache localUrls");
            }
            String str2 = e;
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.anonymizeMessage(a != null ? new JSONObject(a).toString() : "");
            Logger.i(str2, "synGetGrsUrls: %s", objArr);
            return a;
        }
        return (Map) invokeLL.objValue;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, iQueryUrlsCallBack, context) == null) {
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            Map<String, String> a = a(str, bVar, context);
            if (!bVar.a()) {
                this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), new C0542a(str, a, iQueryUrlsCallBack, context, this.a, this.b), str, this.d);
                return;
            }
            Logger.i(e, "get unexpired cache localUrls");
            if (a.isEmpty()) {
                iQueryUrlsCallBack.onCallBackFail(-5);
                return;
            }
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            Logger.i(e, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(a);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, iQueryUrlCallBack, context) == null) {
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            String str3 = a(str, bVar, context).get(str2);
            if (!bVar.a()) {
                this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.a, this.b), str, this.d);
                return;
            }
            Logger.i(e, "get unexpired cache localUrl");
            if (TextUtils.isEmpty(str3)) {
                iQueryUrlCallBack.onCallBackFail(-5);
                return;
            }
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            Logger.i(e, "ayncGetGrsUrl: %s", StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
