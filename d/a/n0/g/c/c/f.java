package d.a.n0.g.c.c;

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
import d.a.n0.a.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends d.a.n0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f49624c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2144706659, "Ld/a/n0/g/c/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2144706659, "Ld/a/n0/g/c/c/f;");
                return;
            }
        }
        f49624c = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f() {
        super("openApp");
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

    @Override // d.a.n0.g.f.a
    public d.a.n0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.n0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (f49624c) {
                Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                bVar.onFail(31010, "package name is empty");
                return null;
            }
            d.a.n0.g.c.i.c.a(optString, "openApp", null, null, null);
            if (!d.a.n0.g.c.e.a.h(AppRuntime.getAppContext(), optString)) {
                bVar.onFail(31011, "app is not installed");
                d.a.n0.g.c.i.c.a(optString, "openApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(31011), null);
                return null;
            }
            if (d.a.n0.g.c.e.a.l(AppRuntime.getAppContext(), optString)) {
                bVar.a(null);
                d.a.n0.g.c.i.c.a(optString, "openApp", "success", null, null);
            } else {
                bVar.onFail(31019, "open app fail");
                d.a.n0.g.c.i.c.a(optString, "openApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(31019), null);
            }
            return null;
        }
        return (d.a.n0.a.u.h.b) invokeLL.objValue;
    }
}
