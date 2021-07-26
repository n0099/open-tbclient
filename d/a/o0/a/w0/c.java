package d.a.o0.a.w0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.k;
import d.a.o0.a.n0.l.b;
import d.a.o0.a.n1.f;
import d.a.o0.a.v2.w;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements d.a.o0.a.m.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48652e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements d.a.o0.a.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48653a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48653a = str;
        }

        @Override // d.a.o0.a.w0.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                d.a.o0.a.j0.c.b.s(AppRuntime.getAppContext().getContentResolver(), this.f48653a, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.w0.a f48654a;

        public b(d.a.o0.a.w0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48654a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            d.a.o0.a.w0.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) || (aVar = this.f48654a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (c.f48652e) {
                    Log.d("SwanHistoryManager", "上报数据 onSuccess: response=" + jSONObject);
                }
                if (jSONObject.optInt("errno", -1) == 0) {
                    this.f48654a.onResult(true);
                    return;
                } else {
                    this.f48654a.onResult(false);
                    return;
                }
            }
            aVar.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.o0.a.w0.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (aVar = this.f48654a) == null) {
                return;
            }
            aVar.onResult(false);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(523814743, "Ld/a/o0/a/w0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(523814743, "Ld/a/o0/a/w0/c;");
                return;
            }
        }
        f48652e = k.f46335a;
    }

    @WorkerThread
    public static void c(e eVar, b.C0840b c0840b) {
        b.a L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, eVar, c0840b) == null) || eVar == null || (L = eVar.L()) == null || TextUtils.equals("1", L.c0())) {
            return;
        }
        String H = L.H();
        if (TextUtils.equals("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u", H) || TextUtils.equals("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D", H) || TextUtils.equals("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", H)) {
            return;
        }
        if (f48652e) {
            Log.d("SwanHistoryManager", "addHistory: " + L.K() + " / " + H);
        }
        d.a.o0.a.w0.b a2 = d.a.o0.a.w0.b.a(L);
        boolean c2 = d.a.o0.a.j0.c.b.c(AppRuntime.getAppContext().getContentResolver(), a2, c0840b);
        a aVar = new a(H);
        if (c2) {
            e("ADD", a2.f48643a, a2.f48647e, a2.f48644b, a2.f48649g, a2.j, aVar);
        }
        if (!f48652e || c2) {
            return;
        }
        Log.e("SwanHistoryManager", "addHistoryAsync Failed!");
    }

    public static String d(String str, String str2, long j, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cmd", str);
                if (TextUtils.isEmpty(str3)) {
                    jSONObject2.put("bundle_id", str2);
                } else {
                    jSONObject2.put("appkey", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("pkg_type", Integer.parseInt(str4));
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("version_code", Integer.parseInt(str5));
                }
                jSONObject2.put("time", j);
                jSONArray.put(jSONObject2);
                jSONObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (f48652e) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void e(String str, String str2, long j, String str3, String str4, String str5, d.a.o0.a.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5, aVar}) == null) {
            String c2 = d.a.o0.a.c1.a.n().c();
            String d2 = d(str, str2, j, str3, str4, str5);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            if (f48652e) {
                Log.d("SwanHistoryManager", "reportHistoryDataToServer: 上行参数" + d2);
            }
            b bVar = new b(aVar);
            d.a.o0.m.d.a aVar2 = new d.a.o0.m.d.a();
            aVar2.f51098b = "POST";
            aVar2.f51097a = c2;
            aVar2.f51102f = true;
            aVar2.f51103g = true;
            aVar2.f51100d = RequestBody.create(f.f46829a, d2);
            aVar2.f51101e = bVar;
            d.a.o0.m.e.a.g().e(aVar2);
        }
    }
}
