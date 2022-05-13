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
import com.repackage.wb4;
import com.repackage.z53;
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
/* loaded from: classes7.dex */
public class y13 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public static a82 c;
    public static final pf3<List<wb4.b>, List<String>> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ y13 d;

        public a(y13 y13Var, JSONArray jSONArray, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y13Var, jSONArray, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = y13Var;
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

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y13 c;

        public b(y13 y13Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y13Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y13Var;
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

    /* loaded from: classes7.dex */
    public class c implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ String d;
        public final /* synthetic */ y13 e;

        public c(y13 y13Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y13Var, unitedSchemeEntity, callbackHandler, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y13Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = jSONArray;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                this.e.t(x53Var, this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        /* loaded from: classes7.dex */
        public class a implements h84 {
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

            @Override // com.repackage.h84
            public void a(@Nullable Map<String, String> map) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || map == null) {
                    return;
                }
                for (wb4.b bVar : this.a.a) {
                    String b = bVar.b();
                    String str = map.get(b);
                    if (!TextUtils.equals(b, str)) {
                        bVar.f(str);
                    }
                }
                d dVar = this.a;
                kz1.a(dVar.a, dVar.b, null);
            }

            @Override // com.repackage.h84
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                }
            }
        }

        public d(y13 y13Var, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y13Var, list, str};
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
                if (!hd4.e().g(!oe3.G())) {
                    kz1.a(this.a, this.b, null);
                } else if (PMSConstants.a(d84.b())) {
                    c84.e((List) y13.d.a(this.a), y13.c.c(), new a(this));
                } else {
                    ux1.c("DownloadPackagesAction", "STOP :: Not Support BDTLS");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements pf3<List<wb4.b>, List<String>> {
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
        @Override // com.repackage.pf3
        /* renamed from: b */
        public List<String> a(List<wb4.b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                if (list == null) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (wb4.b bVar : list) {
                    arrayList.add(bVar.b());
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public f(y13 y13Var, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y13Var, list, str};
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
                List<String> h = k42.h(this.a);
                if (h.isEmpty()) {
                    return;
                }
                tb4 tb4Var = new tb4((Collection<String>) h, (vd4) se3.b());
                tb4Var.e(this.b);
                tb4Var.d("1");
                r32 r32Var = new r32();
                r32Var.M(5);
                c84.f(tb4Var, r32Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755194698, "Lcom/repackage/y13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755194698, "Lcom/repackage/y13;");
                return;
            }
        }
        d = new e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y13(r13 r13Var) {
        super(r13Var, "/swanAPI/downloadPackages");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            ux1.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
            JSONObject a2 = r23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
                return false;
            } else if (!kz1.c(a2.optString("netconf", "0"))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                return false;
            } else {
                JSONArray optJSONArray = a2.optJSONArray("pageList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    od3.k(new a(this, optJSONArray, unitedSchemeEntity, callbackHandler), "DownloadPackagesAction");
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
                        od3.j(new b(this, optJSONObject, s), "handlePreDownloadByCommand");
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                } else if (u03Var == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                    return false;
                } else {
                    u03Var.d0().g(context, "mapp_pre_download", new c(this, unitedSchemeEntity, callbackHandler, optJSONArray2, s));
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
            String a2 = ws1.a(t03.J().getAppId());
            if (TextUtils.isEmpty(a2)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202, "runtime parameter error"));
                return;
            }
            a82 a82Var = c;
            if (a82Var == null || !a82Var.d(a2)) {
                c = new a82(a2, ed4.a(a2));
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
                            wb4.b bVar = new wb4.b(optString);
                            JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                            JSONArray jSONArray3 = new JSONArray();
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                ArraySet arraySet = new ArraySet();
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    String f2 = me3.f(optJSONArray.optString(i3));
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

    public final void t(x53<z53.e> x53Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, x53Var, unitedSchemeEntity, callbackHandler, jSONArray, str) == null) {
            if (!s53.h(x53Var)) {
                s53.p(x53Var, callbackHandler, unitedSchemeEntity);
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
        od3.k(new f(this, arrayList, str), "小程序端能力-批量下载");
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
                    wb4.b bVar = new wb4.b(next);
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("commands")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString = optJSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString)) {
                                try {
                                    Uri parse = Uri.parse(optString);
                                    if (parse != null) {
                                        arrayList2.add(me3.n(next, parse, false));
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
            kz1.a(arrayList, str, null);
        }
    }

    public final boolean w(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, callbackHandler)) == null) ? y(callbackHandler) : invokeL.booleanValue;
    }

    @WorkerThread
    public final void x(String str, List<wb4.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, list) == null) {
            d dVar = new d(this, list, str);
            long currentTimeMillis = System.currentTimeMillis() - Math.max(au2.a, uu2.a());
            if (currentTimeMillis < 3000) {
                od3.e(dVar, "DownloadPackagesAction", 3000 - currentTimeMillis, TimeUnit.MILLISECONDS);
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
