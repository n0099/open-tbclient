package d.a.q0.e.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import d.a.q0.a.d0.c;
import d.a.q0.a.k;
import d.a.q0.a.k2.g.h;
import d.a.q0.a.u2.a;
import d.a.q0.a.v2.o0;
import d.a.q0.t.f;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpDate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes8.dex */
public class a implements d.a.q0.a.u2.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f52545a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.e.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1092a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0992a f52546a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52547b;

        public C1092a(a aVar, a.InterfaceC0992a interfaceC0992a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, interfaceC0992a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52546a = interfaceC0992a;
            this.f52547b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            a.InterfaceC0992a interfaceC0992a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) || (interfaceC0992a = this.f52546a) == null) {
                return;
            }
            interfaceC0992a.c(jSONObject, this.f52547b);
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
                String string = response.body().string();
                a.f(response, System.currentTimeMillis());
                return new JSONObject(string);
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.InterfaceC0992a interfaceC0992a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (interfaceC0992a = this.f52546a) == null) {
                return;
            }
            interfaceC0992a.c(null, null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(949871148, "Ld/a/q0/e/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(949871148, "Ld/a/q0/e/r/a;");
                return;
            }
        }
        f52545a = k.f49133a;
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
            }
        }
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return f.d((str + System.currentTimeMillis() + str2).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return context.getExternalCacheDir() + File.separator + "favor_screenshot" + File.separator;
        }
        return (String) invokeL.objValue;
    }

    public static RequestBody e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oname_list", jSONArray);
                return RequestBody.create(d.a.q0.a.n1.f.f49627a, jSONObject.toString());
            } catch (JSONException e2) {
                if (f52545a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (RequestBody) invokeL.objValue;
    }

    public static void f(Response response, long j) {
        Date parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, response, j) == null) {
            String header = response.header("Date");
            if (TextUtils.isEmpty(header) || (parse = HttpDate.parse(header)) == null) {
                return;
            }
            long time = parse.getTime();
            if (time >= 1) {
                long j2 = j - time;
                h.a().putLong("server_time_delta", j2);
                if (f52545a) {
                    Log.i("getServerTimeDelta", "deltaTime sDate:" + parse + "  sTime:" + time + "   diff:" + j2);
                }
            }
        }
    }

    @Override // d.a.q0.a.u2.a
    public boolean a(String str, d.a.q0.a.j1.d.a aVar) {
        InterceptResult invokeLL;
        PutObjectResponse putObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, aVar)) == null) {
            if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.f49018a) && !TextUtils.isEmpty(aVar.f49019b) && !TextUtils.isEmpty(aVar.f49020c) && !TextUtils.isEmpty(aVar.f49023f)) {
                try {
                    BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
                    bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(aVar.f49018a, aVar.f49019b, aVar.f49020c));
                    bosClientConfiguration.setEndpoint("bj.bcebos.com");
                    BosClient bosClient = new BosClient(bosClientConfiguration);
                    File file = new File(str);
                    if (file.exists() && (putObject = bosClient.putObject(new PutObjectRequest(aVar.f49021d, aVar.f49023f, file))) != null) {
                        if (!TextUtils.isEmpty(putObject.getETag())) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    if (f52545a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.q0.a.u2.a
    public void b(Context context, String str, a.InterfaceC0992a interfaceC0992a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, interfaceC0992a) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String v = c.v(d.a.q0.a.c1.a.n().e());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        for (Map.Entry<String, String> entry : d.a.q0.a.d0.b.b().f47242d.entrySet()) {
            v = o0.a(v, entry.getKey(), entry.getValue());
        }
        String c2 = c(d(context), str.substring(str.lastIndexOf(".")));
        RequestBody e2 = e(c2);
        if (e2 == null) {
            return;
        }
        d.a.q0.m.d.a aVar = new d.a.q0.m.d.a(v, e2, new C1092a(this, interfaceC0992a, c2));
        if (d.a.q0.m.e.a.g().c()) {
            aVar.f53900f = true;
        }
        aVar.f53901g = false;
        aVar.f53897c = hashMap;
        d.a.q0.m.e.a.g().e(aVar);
    }
}
