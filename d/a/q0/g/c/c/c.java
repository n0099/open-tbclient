package d.a.q0.g.c.c;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends d.a.q0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f52924c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1054373763, "Ld/a/q0/g/c/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1054373763, "Ld/a/q0/g/c/c/c;");
                return;
            }
        }
        f52924c = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("checkAppInstalled");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.g.f.a
    public d.a.q0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.q0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (f52924c) {
                Log.d("checkAppInstalled", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                bVar.onFail(31010, "package name is empty");
                return null;
            }
            try {
                PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(optString, 0);
                if (f52924c) {
                    Log.d("checkAppInstalled", "packageInfo: " + packageInfo);
                }
                if (packageInfo != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                    jSONObject3.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
                    jSONObject2.put("data", jSONObject3);
                    bVar.a(jSONObject2);
                } else {
                    bVar.onFail(31016, "no package info");
                }
            } catch (Exception unused) {
                bVar.onFail(31011, "app is not installed");
            }
            return null;
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }
}
