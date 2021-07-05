package d.a.q0.a.n1.q;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.e0.d;
import d.a.q0.a.j2.k;
import d.a.q0.a.n1.q.c.c;
import d.a.q0.a.v2.w;
import d.a.q0.n.j.i.o;
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
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f49668d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f49669e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.q0.a.n1.q.c.b> f49670a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f49671b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.q0.a.n1.q.b.a> f49672c;

    /* renamed from: d.a.q0.a.n1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0884a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49673a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f49674b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f49675c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f49676d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49677e;

        public C0884a(a aVar, String str, List list, ArrayMap arrayMap, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, list, arrayMap, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49677e = aVar;
            this.f49673a = str;
            this.f49674b = list;
            this.f49675c = arrayMap;
            this.f49676d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f49677e.d(this.f49674b);
                d.i("SwanAppUpdateManager", "update request failure: ", exc);
                k.w(this.f49676d, -1, exc.toString());
                d.a.q0.a.j2.q.a.b(SwanInterfaceType.UPDATE, 2101, this.f49676d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                String appId = d.a.q0.a.a2.d.g().getAppId();
                if (TextUtils.equals(this.f49673a, appId)) {
                    this.f49677e.s(this.f49673a, response, this.f49674b, this.f49675c);
                    d.h("SwanAppUpdateManager", "response code = " + response.code());
                    if (!response.isSuccessful()) {
                        k.w(this.f49676d, response.code(), response.message());
                    }
                    return response;
                }
                d.h("SwanAppUpdateManager", "invalid response requestAppId:" + this.f49673a + ";currentAppId:" + appId);
                this.f49677e.d(this.f49674b);
                a.x(this.f49673a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.n1.q.b.a f49678e;

        public b(a aVar, d.a.q0.a.n1.q.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49678e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49678e.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1764399051, "Ld/a/q0/a/n1/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1764399051, "Ld/a/q0/a/n1/q/a;");
                return;
            }
        }
        f49668d = d.a.q0.a.k.f49133a;
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
                return;
            }
        }
        k();
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f49669e == null) {
                synchronized (a.class) {
                    if (f49669e == null) {
                        f49669e = new a();
                    }
                }
            }
            return f49669e;
        }
        return (a) invokeV.objValue;
    }

    public static void x(String str) {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || (Q = e.Q()) == null) {
            return;
        }
        d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
        aVar.j(5L);
        aVar.h(53L);
        d.a.q0.a.j2.p.d dVar = new d.a.q0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(Q.L());
        dVar.q(k.m(Q.l()));
        dVar.m(Q.getAppId());
        dVar.a("requestAppId", str);
        k.L(dVar);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(null);
        }
    }

    public void B(@Nullable d.a.q0.a.n1.q.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null) {
                this.f49672c.add(aVar);
            }
            f(this.f49670a);
        }
    }

    public final void C(@NonNull List<d.a.q0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, arrayMap) == null) || list.size() == 0 || (i2 = e.i()) == null) {
            return;
        }
        String q = i2.T().q("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(q)) {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException e2) {
                if (f49668d) {
                    e2.printStackTrace();
                }
            }
        }
        for (d.a.q0.a.n1.q.c.b bVar : list) {
            String str = arrayMap.get(bVar.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (f49668d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.a() + " , version => " + str);
                }
                jSONObject.put(bVar.a(), str);
            } catch (JSONException e3) {
                if (f49668d) {
                    e3.printStackTrace();
                }
            }
        }
        i2.T().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<d.a.q0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, list, arrayMap)) == null) {
            if (list.size() == 0) {
                return null;
            }
            String D = d.a.q0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D)) {
                return null;
            }
            String T = e.i().N().T();
            if (TextUtils.isEmpty(T)) {
                T = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", D);
                jSONObject.put("source", T);
            } catch (JSONException e2) {
                if (f49668d) {
                    e2.printStackTrace();
                }
            }
            for (d.a.q0.a.n1.q.c.b bVar : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = arrayMap.containsKey(bVar.a()) ? arrayMap.get(bVar.a()) : "";
                    if (f49668d) {
                        Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.a() + " , version => " + str);
                    }
                    jSONObject2.put("version", str);
                    jSONObject.put(bVar.a(), jSONObject2);
                } catch (JSONException e3) {
                    if (f49668d) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void d(@NonNull List<d.a.q0.a.n1.q.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "doRequestFail: ");
            }
            n(list);
            o(false);
        }
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<d.a.q0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, jSONObject, list, arrayMap, str2) == null) {
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
            }
            t();
            boolean z = false;
            for (d.a.q0.a.n1.q.c.b bVar : list) {
                JSONObject optJSONObject = jSONObject.optJSONObject(bVar.a());
                if (optJSONObject == null) {
                    bVar.b();
                } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                    bVar.b();
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        bVar.c();
                    } else {
                        if (f49668d) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.a() + " update");
                        }
                        bVar.d(str, optJSONObject2, str2);
                        String optString = optJSONObject.optString("version", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (f49668d) {
                                Log.d("SwanAppUpdateManager", "doRequestSuccess: " + bVar.a() + " update , version " + optString);
                            }
                            arrayMap.put(bVar.a(), optString);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                C(list, arrayMap);
            }
            o(true);
        }
    }

    public final void f(@NonNull List<d.a.q0.a.n1.q.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list.size() == 0) {
                d.h("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
                p();
                return;
            }
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
            }
            if (this.f49671b.incrementAndGet() > 1) {
                d.h("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            ArrayMap<String, String> i2 = i(this.f49670a);
            JSONObject c2 = c(list, i2);
            if (c2 == null) {
                d.h("SwanAppUpdateManager", "doUpdate: finish => build params is null");
                p();
                return;
            }
            if (f49668d) {
                Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
            }
            FormBody build = new FormBody.Builder().add("data", c2.toString()).build();
            String b2 = d.a.q0.a.c1.a.n().b();
            d.h("SwanAppUpdateManager", "appId =" + d.a.q0.a.a2.d.g().getAppId() + ", update url = " + b2 + ",body=" + c2);
            j(d.a.q0.a.a2.d.g().getAppId(), b2, build, list, i2);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (d.a.q0.a.a2.d.g().C()) {
                return d.a.q0.a.a2.d.g().r().T().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            }
            return System.currentTimeMillis();
        }
        return invokeV.longValue;
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<d.a.q0.a.n1.q.c.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            if (list.size() == 0) {
                return arrayMap;
            }
            for (d.a.q0.a.n1.q.c.b bVar : list) {
                arrayMap.put(bVar.a(), "");
            }
            e i2 = e.i();
            if (i2 == null) {
                return arrayMap;
            }
            String q = i2.T().q("update_nodes_version", "");
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                for (d.a.q0.a.n1.q.c.b bVar2 : list) {
                    arrayMap.put(bVar2.a(), jSONObject.optString(bVar2.a(), ""));
                }
            } catch (JSONException e2) {
                if (f49668d) {
                    e2.printStackTrace();
                }
            }
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public final void j(String str, String str2, RequestBody requestBody, List<d.a.q0.a.n1.q.c.b> list, ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, str, str2, requestBody, list, arrayMap) == null) {
            d.a.q0.m.d.a aVar = new d.a.q0.m.d.a(str2, requestBody, new C0884a(this, str, list, arrayMap, str2));
            aVar.f53900f = true;
            aVar.f53901g = true;
            aVar.f53902h = false;
            aVar.k = 20;
            d.a.q0.m.e.a.g().e(aVar);
            d.a.q0.a.j2.q.a.a(SwanInterfaceType.UPDATE);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            l();
            this.f49671b = new AtomicInteger(0);
            this.f49672c = new CopyOnWriteArrayList<>();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f49670a = arrayList;
            arrayList.add(new d.a.q0.a.n1.q.c.a());
            this.f49670a.add(new c());
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            long h2 = h();
            if (h2 <= 0) {
                return true;
            }
            return System.currentTimeMillis() - h2 > o.b(d.a.q0.a.a2.d.g().getAppId());
        }
        return invokeV.booleanValue;
    }

    public final void n(@NonNull List<d.a.q0.a.n1.q.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            for (d.a.q0.a.n1.q.c.b bVar : list) {
                bVar.b();
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
            }
            if (this.f49671b.decrementAndGet() > 0) {
                if (f49668d) {
                    Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
                }
                this.f49671b.set(0);
                if (!z) {
                    A();
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
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
            }
            this.f49671b.set(0);
            Iterator<d.a.q0.a.n1.q.b.a> it = this.f49672c.iterator();
            while (it.hasNext()) {
                d.a.q0.a.e2.c.d.k(new b(this, it.next()));
            }
            this.f49672c.clear();
        }
    }

    public void q(@NonNull d.a.q0.a.k2.g.b bVar, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bVar, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node start");
            }
            String string = bVar.getString("node_data_accredit_list", "");
            d.h("SwanAppUpdateManager", "prefName: " + bVar.i() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject3 = new JSONObject();
                w.f(jSONObject3, "list", jSONObject);
                String jSONObject4 = jSONObject3.toString();
                bVar.putString("node_data_accredit_list", jSONObject4);
                bVar.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                if (f49668d) {
                    Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
                }
            } else {
                HashMap<String, JSONObject> r = r(jSONObject);
                if (r != null && r.size() != 0) {
                    JSONObject d2 = w.d(string);
                    JSONObject optJSONObject = d2.optJSONObject("list");
                    if (optJSONObject == null) {
                        w.f(d2, "list", jSONObject);
                        bVar.putString("node_data_accredit_list", d2.toString());
                        bVar.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                        d.h("SwanAppUpdateManager", "local has cache data, but list node is empty");
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObject2 = r.get(next)) != null) {
                            w.f(optJSONObject, next, jSONObject2);
                        }
                    }
                    w.f(d2, "list", optJSONObject);
                    bVar.putString("node_data_accredit_list", d2.toString());
                    String string2 = bVar.getString("cur_request_id", "");
                    if (!TextUtils.isEmpty(string2) && (length = string2.length()) > 100) {
                        string2 = string2.substring(length - 100);
                    }
                    bVar.putString("cur_request_id", string2 + ";merge:" + System.currentTimeMillis());
                    d.h("SwanAppUpdateManager", "prefName: " + bVar.i() + ",mergeAccredit = " + d2);
                } else {
                    d.h("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
            }
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final HashMap<String, JSONObject> r(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONObject)) == null) {
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

    public final void s(String str, Response response, @NonNull List<d.a.q0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, str, response, list, arrayMap) == null) {
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "onResponse: update request return");
            }
            String str2 = null;
            if (!response.isSuccessful()) {
                d(list);
                d.a.q0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2104, null, response);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d(list);
                d.a.q0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, null, response);
                return;
            }
            try {
                str2 = body.string();
            } catch (IOException e2) {
                if (f49668d) {
                    e2.printStackTrace();
                }
            }
            d.h("SwanAppUpdateManager", "response body = " + str2);
            if (TextUtils.isEmpty(str2)) {
                d(list);
                d.a.q0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    d(list);
                    d.a.q0.a.j2.q.a.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                    return;
                }
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                d.h("SwanAppUpdateManager", "request_id = " + optString);
                if (optJSONObject == null) {
                    d(list);
                } else {
                    e(str, optJSONObject, list, arrayMap, optString);
                }
            } catch (JSONException e3) {
                if (f49668d) {
                    e3.printStackTrace();
                }
                d(list);
                d.a.q0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && d.a.q0.a.a2.d.g().C()) {
            d.a.q0.a.a2.d.g().r().T().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "release: ");
            }
            if (f49669e == null) {
                return;
            }
            this.f49672c.clear();
            f49669e = null;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (d.a.q0.a.a2.d.g().C()) {
                d.a.q0.a.a2.d.g().r().T().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
            }
            y();
        }
    }

    public void w(d.a.q0.a.n1.q.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (bVar == null) {
                if (f49668d) {
                    Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                    return;
                }
                return;
            }
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.a());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(bVar.a(), "");
            C(arrayList, arrayMap);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean m = d.a.q0.a.a2.d.g().r().T().m("swan_service_update_degraded", false);
            d.g("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
            if (m) {
                return;
            }
            z(null);
        }
    }

    public void z(@Nullable d.a.q0.a.n1.q.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            if (m()) {
                if (f49668d) {
                    Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
                }
                B(aVar);
                return;
            }
            if (f49668d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
            }
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
