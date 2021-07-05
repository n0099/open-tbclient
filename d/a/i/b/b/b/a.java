package d.a.i.b.b.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f45710e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f45711f = 12324;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f45712a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f45713b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f45714c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45715d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2126031604, "Ld/a/i/b/b/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2126031604, "Ld/a/i/b/b/b/a;");
        }
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45714c == null) {
            return;
        }
        SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f45714c.toString());
        this.f45714c = null;
    }

    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            try {
                if (this.f45713b == null) {
                    JSONObject jSONObject = new JSONObject();
                    this.f45713b = jSONObject;
                    jSONObject.put("type", f45710e);
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f45713b.put(str, str2);
            } catch (Exception unused) {
                Log.e("staticWebkitInit JSON error");
            }
        }
    }

    public final void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            try {
                if (this.f45714c == null) {
                    JSONObject jSONObject = new JSONObject();
                    this.f45714c = jSONObject;
                    jSONObject.put("type", f45711f);
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f45714c.put(str, str2);
            } catch (Exception unused) {
                Log.e("mWebkitDownloadStatics JSON error");
            }
        }
    }
}
