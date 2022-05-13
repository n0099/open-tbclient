package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qs2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile qs2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ts2> a;
    public AtomicInteger b;
    public CopyOnWriteArrayList<rs2> c;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;
        public final /* synthetic */ ArrayMap c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qs2 e;

        public a(qs2 qs2Var, String str, List list, ArrayMap arrayMap, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs2Var, str, list, arrayMap, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qs2Var;
            this.a = str;
            this.b = list;
            this.c = arrayMap;
            this.d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.e.d(this.b);
                ux1.l("SwanAppUpdateManager", "update request failure: ", exc);
                n73.z(this.d, -1, exc.toString());
                z73.b(SwanInterfaceType.UPDATE, 2101, this.d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                String appId = t03.J().getAppId();
                if (TextUtils.equals(this.a, appId)) {
                    this.e.s(this.a, response, this.b, this.c);
                    ux1.k("SwanAppUpdateManager", "response code = " + response.code());
                    if (!response.isSuccessful()) {
                        n73.z(this.d, response.code(), response.message());
                    }
                    return response;
                }
                ux1.k("SwanAppUpdateManager", "invalid response requestAppId:" + this.a + ";currentAppId:" + appId);
                this.e.d(this.b);
                qs2.x(this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;

        public b(qs2 qs2Var, rs2 rs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs2Var, rs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755369631, "Lcom/repackage/qs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755369631, "Lcom/repackage/qs2;");
                return;
            }
        }
        d = eh1.a;
    }

    public qs2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        k();
    }

    public static qs2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (qs2.class) {
                    if (e == null) {
                        e = new qs2();
                    }
                }
            }
            return e;
        }
        return (qs2) invokeV.objValue;
    }

    public static void x(String str) {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || (a0 = u03.a0()) == null) {
            return;
        }
        nc3 nc3Var = new nc3();
        nc3Var.k(5L);
        nc3Var.i(53L);
        v73 v73Var = new v73();
        v73Var.p(nc3Var);
        v73Var.r(a0.V());
        v73Var.q(n73.n(a0.l()));
        v73Var.m(a0.getAppId());
        v73Var.a("requestAppId", str);
        n73.R(v73Var);
    }

    public final void A(@NonNull List<ts2> list, @NonNull ArrayMap<String, String> arrayMap) {
        u03 L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, arrayMap) == null) || list.size() == 0 || (L = u03.L()) == null) {
            return;
        }
        String q = L.d0().q("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(q)) {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
        for (ts2 ts2Var : list) {
            String str = arrayMap.get(ts2Var.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + ts2Var.a() + " , version => " + str);
                }
                jSONObject.put(ts2Var.a(), str);
            } catch (JSONException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
        }
        L.d0().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<ts2> list, @NonNull ArrayMap<String, String> arrayMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, arrayMap)) == null) {
            if (list.size() == 0) {
                return null;
            }
            String N = t03.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return null;
            }
            String T = u03.L().X().T();
            if (TextUtils.isEmpty(T)) {
                T = "NA";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", N);
                jSONObject.put("source", T);
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            for (ts2 ts2Var : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = arrayMap.containsKey(ts2Var.a()) ? arrayMap.get(ts2Var.a()) : "";
                    if (d) {
                        Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + ts2Var.a() + " , version => " + str);
                    }
                    jSONObject2.put("version", str);
                    jSONObject.put(ts2Var.a(), jSONObject2);
                } catch (JSONException e3) {
                    if (d) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void d(@NonNull List<ts2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestFail: ");
            }
            n(list);
            o(false);
        }
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<ts2> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, jSONObject, list, arrayMap, str2) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
            }
            t();
            boolean z = false;
            for (ts2 ts2Var : list) {
                JSONObject optJSONObject = jSONObject.optJSONObject(ts2Var.a());
                if (optJSONObject == null) {
                    ts2Var.b();
                } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                    ts2Var.b();
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        ts2Var.c();
                    } else {
                        if (d) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + ts2Var.a() + " update");
                        }
                        ts2Var.d(str, optJSONObject2, str2);
                        String optString = optJSONObject.optString("version", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (d) {
                                Log.d("SwanAppUpdateManager", "doRequestSuccess: " + ts2Var.a() + " update , version " + optString);
                            }
                            arrayMap.put(ts2Var.a(), optString);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                A(list, arrayMap);
            }
            o(true);
        }
    }

    public final void f(@NonNull List<ts2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list.size() == 0) {
                ux1.k("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
                p();
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
            }
            if (this.b.incrementAndGet() > 1) {
                ux1.k("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            ArrayMap<String, String> i = i(this.a);
            JSONObject c = c(list, i);
            if (c == null) {
                ux1.k("SwanAppUpdateManager", "doUpdate: finish => build params is null");
                p();
                return;
            }
            if (d) {
                Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
            }
            FormBody build = new FormBody.Builder().add("data", c.toString()).build();
            String b2 = bk2.o().b();
            ux1.k("SwanAppUpdateManager", "appId =" + t03.J().getAppId() + ", update url = " + b2 + ",body=" + c);
            j(t03.J().getAppId(), b2, build, list, i);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (t03.J().D()) {
                return t03.J().r().d0().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            }
            return System.currentTimeMillis();
        }
        return invokeV.longValue;
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<ts2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            if (list.size() == 0) {
                return arrayMap;
            }
            for (ts2 ts2Var : list) {
                arrayMap.put(ts2Var.a(), "");
            }
            u03 L = u03.L();
            if (L == null) {
                return arrayMap;
            }
            String q = L.d0().q("update_nodes_version", "");
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                for (ts2 ts2Var2 : list) {
                    arrayMap.put(ts2Var2.a(), jSONObject.optString(ts2Var2.a(), ""));
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public final void j(String str, String str2, RequestBody requestBody, List<ts2> list, ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, requestBody, list, arrayMap) == null) {
            v74 v74Var = new v74(str2, requestBody, new a(this, str, list, arrayMap, str2));
            v74Var.f = true;
            v74Var.g = true;
            v74Var.h = false;
            v74Var.k = 20;
            w74.g().e(v74Var);
            z73.a(SwanInterfaceType.UPDATE);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            l();
            this.b = new AtomicInteger(0);
            this.c = new CopyOnWriteArrayList<>();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(new ss2());
            this.a.add(new us2());
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            long h = h();
            if (h <= 0) {
                return true;
            }
            return System.currentTimeMillis() - h > cd4.b(t03.J().getAppId());
        }
        return invokeV.booleanValue;
    }

    public final void n(@NonNull List<ts2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            for (ts2 ts2Var : list) {
                ts2Var.b();
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
            }
            if (this.b.decrementAndGet() > 0) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
                }
                this.b.set(0);
                if (!z) {
                    update();
                    return;
                } else {
                    p();
                    return;
                }
            }
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
            }
            this.b.set(0);
            Iterator<rs2> it = this.c.iterator();
            while (it.hasNext()) {
                s53.l(new b(this, it.next()));
            }
            this.c.clear();
        }
    }

    public void q(@NonNull c93 c93Var, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, c93Var, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node start");
            }
            String string = c93Var.getString("node_data_accredit_list", "");
            ux1.k("SwanAppUpdateManager", "prefName: " + c93Var.h() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject3 = new JSONObject();
                ud3.f(jSONObject3, "list", jSONObject);
                String jSONObject4 = jSONObject3.toString();
                c93Var.putString("node_data_accredit_list", jSONObject4);
                c93Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                if (d) {
                    Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
                }
            } else {
                HashMap<String, JSONObject> r = r(jSONObject);
                if (r != null && r.size() != 0) {
                    JSONObject d2 = ud3.d(string);
                    JSONObject optJSONObject = d2.optJSONObject("list");
                    if (optJSONObject == null) {
                        ud3.f(d2, "list", jSONObject);
                        c93Var.putString("node_data_accredit_list", d2.toString());
                        c93Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                        ux1.k("SwanAppUpdateManager", "local has cache data, but list node is empty");
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObject2 = r.get(next)) != null) {
                            ud3.f(optJSONObject, next, jSONObject2);
                        }
                    }
                    ud3.f(d2, "list", optJSONObject);
                    c93Var.putString("node_data_accredit_list", d2.toString());
                    String string2 = c93Var.getString("cur_request_id", "");
                    if (!TextUtils.isEmpty(string2) && (length = string2.length()) > 100) {
                        string2 = string2.substring(length - 100);
                    }
                    c93Var.putString("cur_request_id", string2 + ";merge:" + System.currentTimeMillis());
                    ux1.k("SwanAppUpdateManager", "prefName: " + c93Var.h() + ",mergeAccredit = " + d2);
                } else {
                    ux1.k("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final HashMap<String, JSONObject> r(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            HashMap<String, JSONObject> hashMap = new HashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                    hashMap.put(next, optJSONObject);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public final void s(String str, Response response, @NonNull List<ts2> list, @NonNull ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, response, list, arrayMap) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onResponse: update request return");
            }
            String str2 = null;
            if (!response.isSuccessful()) {
                d(list);
                z73.c(SwanInterfaceType.UPDATE, 2104, null, response);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d(list);
                z73.c(SwanInterfaceType.UPDATE, 2103, null, response);
                return;
            }
            try {
                str2 = body.string();
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            ux1.k("SwanAppUpdateManager", "response body = " + str2);
            if (TextUtils.isEmpty(str2)) {
                d(list);
                z73.c(SwanInterfaceType.UPDATE, 2103, str2, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    d(list);
                    z73.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                    return;
                }
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                ux1.k("SwanAppUpdateManager", "request_id = " + optString);
                if (optJSONObject == null) {
                    d(list);
                } else {
                    e(str, optJSONObject, list, arrayMap, optString);
                }
            } catch (JSONException e3) {
                if (d) {
                    e3.printStackTrace();
                }
                d(list);
                z73.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && t03.J().D()) {
            t03.J().r().d0().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "release: ");
            }
            if (e == null) {
                return;
            }
            this.c.clear();
            e = null;
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            update(null);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (t03.J().D()) {
                t03.J().r().d0().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
            }
            y();
        }
    }

    public void w(ts2 ts2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ts2Var) == null) {
            if (ts2Var == null) {
                if (d) {
                    Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                    return;
                }
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "resetNodeVersion: " + ts2Var.a());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(ts2Var);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(ts2Var.a(), "");
            A(arrayList, arrayMap);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean m = t03.J().r().d0().m("swan_service_update_degraded", false);
            ux1.i("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
            if (m) {
                return;
            }
            z(null);
        }
    }

    public void z(@Nullable rs2 rs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, rs2Var) == null) {
            if (m()) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
                }
                update(rs2Var);
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
            }
            if (rs2Var != null) {
                rs2Var.a();
            }
        }
    }

    public void update(@Nullable rs2 rs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, rs2Var) == null) {
            if (rs2Var != null) {
                this.c.add(rs2Var);
            }
            f(this.a);
        }
    }
}
