package d.a.q0.e.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.z1.b.f.e;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f52471a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f52472b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1083a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Response f52473a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52474b;

        public C1083a(String str) {
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
            this.f52474b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (a.f52471a) {
                    Log.d("SwanAppExchanger", "startLaunchAction onSuccess result: " + str);
                    Log.d("SwanAppExchanger", "startLaunchAction onSuccess status: " + i2);
                }
                if (i2 != 200) {
                    String f2 = a.f(this.f52473a);
                    if (!TextUtils.isEmpty(f2)) {
                        b.a(f2);
                        return;
                    }
                    a.d("get launch scheme fail: request fail with code " + i2, this.f52474b, str, true);
                    return;
                }
                try {
                    b.a(new JSONObject(str).optString("data"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    a.d("get launch scheme fail: " + e2.getMessage(), this.f52474b, str, false);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                a.d("get launch scheme fail: network err with exception: " + exc.getMessage(), this.f52474b, "", true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.StringResponseCallback, com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                this.f52473a = response;
                return super.parseResponse(response, i2);
            }
            return (String) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(949692402, "Ld/a/q0/e/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(949692402, "Ld/a/q0/e/l/a;");
                return;
            }
        }
        f52471a = k.f49133a;
        f52472b = SchemeConfig.getSchemeHead() + "://";
    }

    public static void d(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            if (z) {
                e.g(AppRuntime.getAppContext(), "打开失败，请检查网络设置").F();
            }
            d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
            aVar.j(1L);
            aVar.h(12L);
            aVar.e(str);
            d.a.q0.a.q2.e.a().f(aVar);
            if (f52471a) {
                Log.w("SwanAppExchanger", "open aiapp fail, url : " + str2);
            }
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().setHeader("Swan-Accept", "swan/json").userAgent(d.a.q0.a.s2.a.a()).url(str).build().executeAsyncOnUIBack(new C1083a(str));
        }
    }

    public static String f(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, response)) == null) {
            if (response == null) {
                return null;
            }
            String header = response.header("Location");
            if (!TextUtils.isEmpty(header) && header.startsWith("baiduboxapp://")) {
                return header.replace("baiduboxapp://", f52472b);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
