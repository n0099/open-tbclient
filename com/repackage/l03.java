package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ja4;
import com.repackage.m43;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l03 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public static n62 c;
    public static final ce3<List<ja4.b>, List<String>> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ l03 d;

        public a(l03 l03Var, JSONArray jSONArray, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l03Var, jSONArray, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = l03Var;
            this.a = jSONArray;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.r(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ l03 c;

        public b(l03 l03Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l03Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l03Var;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.v(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ String d;
        public final /* synthetic */ l03 e;

        public c(l03 l03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l03Var, unitedSchemeEntity, callbackHandler, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l03Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = jSONArray;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                this.e.t(k43Var, this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        /* loaded from: classes6.dex */
        public class a implements u64 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.repackage.u64
            public void a(@Nullable Map<String, String> map) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || map == null) {
                    return;
                }
                for (ja4.b bVar : this.a.a) {
                    String b = bVar.b();
                    String str = map.get(b);
                    if (!TextUtils.equals(b, str)) {
                        bVar.f(str);
                    }
                }
                d dVar = this.a;
                xx1.a(dVar.a, dVar.b, null);
            }

            @Override // com.repackage.u64
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                }
            }
        }

        public d(l03 l03Var, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l03Var, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ub4.e().g(!bd3.G())) {
                    xx1.a(this.a, this.b, null);
                } else if (PMSConstants.a(q64.b())) {
                    p64.e((List) l03.d.a(this.a), l03.c.c(), new a(this));
                } else {
                    hw1.c("DownloadPackagesAction", "STOP :: Not Support BDTLS");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements ce3<List<ja4.b>, List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ce3
        /* renamed from: b */
        public List<String> a(List<ja4.b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                if (list == null) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (ja4.b bVar : list) {
                    arrayList.add(bVar.b());
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public f(l03 l03Var, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l03Var, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<String> h = x22.h(this.a);
                if (h.isEmpty()) {
                    return;
                }
                ga4 ga4Var = new ga4((Collection<String>) h, (ic4) fd3.b());
                ga4Var.e(this.b);
                ga4Var.d("1");
                e22 e22Var = new e22();
                e22Var.M(5);
                p64.f(ga4Var, e22Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755582942, "Lcom/repackage/l03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755582942, "Lcom/repackage/l03;");
                return;
            }
        }
        d = new e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l03(e03 e03Var) {
        super(e03Var, "/swanAPI/downloadPackages");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            hw1.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
            JSONObject a2 = e13.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
                return false;
            } else if (!xx1.c(a2.optString("netconf", "0"))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                return false;
            } else {
                JSONArray optJSONArray = a2.optJSONArray("pageList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    bc3.k(new a(this, optJSONArray, unitedSchemeEntity, callbackHandler), "DownloadPackagesAction");
                    return true;
                }
                JSONArray optJSONArray2 = a2.optJSONArray("appKeys");
                JSONObject optJSONObject = a2.optJSONObject("appList");
                if ((optJSONArray2 == null || optJSONArray2.length() == 0) && optJSONObject == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
                    return false;
                }
                String s = s(callbackHandler);
                if (!w(callbackHandler)) {
                    if (optJSONArray2 != null) {
                        u(optJSONArray2, s, false);
                    }
                    if (optJSONObject != null) {
                        bc3.j(new b(this, optJSONObject, s), "handlePreDownloadByCommand");
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                } else if (hz2Var == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                    return false;
                } else {
                    hz2Var.d0().g(context, "mapp_pre_download", new c(this, unitedSchemeEntity, callbackHandler, optJSONArray2, s));
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject o(@NonNull JSONArray jSONArray, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, i, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    try {
                        String optString = optJSONObject.optString("appKey");
                        if (!TextUtils.isEmpty(optString)) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                            JSONArray jSONArray2 = new JSONArray();
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    jSONArray2.put(p(optJSONArray.optString(i3), i, str));
                                }
                            }
                            jSONObject.put(optString, jSONArray2);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public final JSONObject p(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str);
                jSONObject.put("status", String.valueOf(i));
                jSONObject.put("message", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public final JSONObject q(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            return p(str, z ? 0 : 402, z ? "success" : "over single max limit");
        }
        return (JSONObject) invokeLZ.objValue;
    }

    @WorkerThread
    public final void r(@NonNull JSONArray jSONArray, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, jSONArray, unitedSchemeEntity, callbackHandler) == null) {
            JSONArray jSONArray2 = jSONArray;
            String a2 = jr1.a(gz2.J().getAppId());
            if (TextUtils.isEmpty(a2)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202, "runtime parameter error"));
                return;
            }
            n62 n62Var = c;
            if (n62Var == null || !n62Var.d(a2)) {
                c = new n62(a2, rb4.a(a2));
            }
            if (c.e()) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(o(jSONArray2, 402, "over max limit"), 402, "over max limit"));
            } else if (!c.b()) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(o(jSONArray2, 402, "over time interval limit"), 402, "over time interval limit"));
            } else {
                JSONObject jSONObject = new JSONObject();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("appKey");
                        if (!TextUtils.isEmpty(optString)) {
                            ja4.b bVar = new ja4.b(optString);
                            JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                            JSONArray jSONArray3 = new JSONArray();
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                ArraySet arraySet = new ArraySet();
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    String f2 = zc3.f(optJSONArray.optString(i3));
                                    if (!TextUtils.isEmpty(f2)) {
                                        if (f2.startsWith("/")) {
                                            f2 = f2.substring(1);
                                        }
                                        i++;
                                        boolean a3 = c.a(i);
                                        if (a3) {
                                            arraySet.add(f2);
                                        }
                                        jSONArray3.put(q(optJSONArray.optString(i3), a3));
                                    }
                                }
                                bVar.l((String[]) arraySet.toArray(new String[0]));
                            }
                            if (jSONArray3.length() == 0) {
                                i++;
                                boolean a4 = c.a(i);
                                jSONArray3.put(q("", a4));
                                if (a4) {
                                    arrayList.add(bVar);
                                }
                            } else if (!bVar.k()) {
                                arrayList.add(bVar);
                            }
                            int i4 = i;
                            try {
                                jSONObject.put(optString, jSONArray3);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            i = i4;
                        }
                    }
                    i2++;
                    jSONArray2 = jSONArray;
                }
                if (arrayList.isEmpty()) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001, "over max limit"));
                    return;
                }
                x(s(callbackHandler), arrayList);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success"));
            }
        }
    }

    @NonNull
    public final String s(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, callbackHandler)) == null) ? y(callbackHandler) ? "10" : "2" : (String) invokeL.objValue;
    }

    public final void t(k43<m43.e> k43Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, k43Var, unitedSchemeEntity, callbackHandler, jSONArray, str) == null) {
            if (!f43.h(k43Var)) {
                f43.p(k43Var, callbackHandler, unitedSchemeEntity);
                return;
            }
            u(jSONArray, str, true);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void u(@Nullable JSONArray jSONArray, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048583, this, jSONArray, str, z) == null) || jSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        bc3.k(new f(this, arrayList, str), "小程序端能力-批量下载");
    }

    @AnyThread
    public final void v(@NonNull JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    ja4.b bVar = new ja4.b(next);
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("commands")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString = optJSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString)) {
                                try {
                                    Uri parse = Uri.parse(optString);
                                    if (parse != null) {
                                        arrayList2.add(zc3.n(next, parse, false));
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            bVar.l((String[]) arrayList2.toArray(new String[arrayList2.size()]));
                        }
                    }
                    arrayList.add(bVar);
                }
            }
            xx1.a(arrayList, str, null);
        }
    }

    public final boolean w(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, callbackHandler)) == null) ? y(callbackHandler) : invokeL.booleanValue;
    }

    @WorkerThread
    public final void x(String str, List<ja4.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, list) == null) {
            d dVar = new d(this, list, str);
            long currentTimeMillis = System.currentTimeMillis() - Math.max(ns2.a, ht2.a());
            if (currentTimeMillis < 3000) {
                bc3.e(dVar, "DownloadPackagesAction", 3000 - currentTimeMillis, TimeUnit.MILLISECONDS);
            } else {
                dVar.run();
            }
        }
    }

    public final boolean y(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, callbackHandler)) == null) {
            if (callbackHandler instanceof TypedCallbackHandler) {
                int invokeSourceType = ((TypedCallbackHandler) callbackHandler).getInvokeSourceType();
                return invokeSourceType == 0 || invokeSourceType == 1;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
