package d.a.o0.e.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
import d.a.o0.a.d0.c;
import d.a.o0.a.k;
import d.a.o0.a.k2.g.h;
import d.a.o0.a.u2.a;
import d.a.o0.a.v2.o0;
import d.a.o0.t.f;
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
/* loaded from: classes7.dex */
public class a implements d.a.o0.a.u2.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49747a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.e.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1050a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0950a f49748a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49749b;

        public C1050a(a aVar, a.InterfaceC0950a interfaceC0950a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, interfaceC0950a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49748a = interfaceC0950a;
            this.f49749b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            a.InterfaceC0950a interfaceC0950a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) || (interfaceC0950a = this.f49748a) == null) {
                return;
            }
            interfaceC0950a.c(jSONObject, this.f49749b);
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
            a.InterfaceC0950a interfaceC0950a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (interfaceC0950a = this.f49748a) == null) {
                return;
            }
            interfaceC0950a.c(null, null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(269812778, "Ld/a/o0/e/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(269812778, "Ld/a/o0/e/r/a;");
                return;
            }
        }
        f49747a = k.f46335a;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oname_list", jSONArray);
                return RequestBody.create(d.a.o0.a.n1.f.f46829a, jSONObject.toString());
            } catch (JSONException e2) {
                if (f49747a) {
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
                if (f49747a) {
                    Log.i("getServerTimeDelta", "deltaTime sDate:" + parse + "  sTime:" + time + "   diff:" + j2);
                }
            }
        }
    }

    @Override // d.a.o0.a.u2.a
    public boolean a(String str, d.a.o0.a.j1.d.a aVar) {
        InterceptResult invokeLL;
        PutObjectResponse putObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, aVar)) == null) {
            if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.f46220a) && !TextUtils.isEmpty(aVar.f46221b) && !TextUtils.isEmpty(aVar.f46222c) && !TextUtils.isEmpty(aVar.f46225f)) {
                try {
                    BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
                    bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(aVar.f46220a, aVar.f46221b, aVar.f46222c));
                    bosClientConfiguration.setEndpoint("bj.bcebos.com");
                    BosClient bosClient = new BosClient(bosClientConfiguration);
                    File file = new File(str);
                    if (file.exists() && (putObject = bosClient.putObject(new PutObjectRequest(aVar.f46223d, aVar.f46225f, file))) != null) {
                        if (!TextUtils.isEmpty(putObject.getETag())) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    if (f49747a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.o0.a.u2.a
    public void b(Context context, String str, a.InterfaceC0950a interfaceC0950a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, interfaceC0950a) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String v = c.v(d.a.o0.a.c1.a.n().e());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        for (Map.Entry<String, String> entry : d.a.o0.a.d0.b.b().f44444d.entrySet()) {
            v = o0.a(v, entry.getKey(), entry.getValue());
        }
        String c2 = c(d(context), str.substring(str.lastIndexOf(".")));
        RequestBody e2 = e(c2);
        if (e2 == null) {
            return;
        }
        d.a.o0.m.d.a aVar = new d.a.o0.m.d.a(v, e2, new C1050a(this, interfaceC0950a, c2));
        if (d.a.o0.m.e.a.g().c()) {
            aVar.f51102f = true;
        }
        aVar.f51103g = false;
        aVar.f51099c = hashMap;
        d.a.o0.m.e.a.g().e(aVar);
    }
}
