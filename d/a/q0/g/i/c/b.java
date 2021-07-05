package d.a.q0.g.i.c;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.k;
import d.a.q0.a.v2.a0;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.q0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f53021c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1226148638, "Ld/a/q0/g/i/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1226148638, "Ld/a/q0/g/i/c/b;");
                return;
            }
        }
        f53021c = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("startPermissionsPage");
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
    public d.a.q0.a.u.h.b a(JSONObject jSONObject, d.a.q0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            e Q = e.Q();
            if (Q != null && Q.x() != null) {
                String str = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str)) {
                    str = str.toLowerCase(Locale.US);
                }
                if (TextUtils.equals(str, RomUtils.MANUFACTURER_OPPO)) {
                    try {
                        Intent intent = new Intent(Q.x().getPackageName());
                        intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                        Q.x().startActivity(intent);
                    } catch (Exception e2) {
                        if (f53021c) {
                            e2.printStackTrace();
                        }
                        a0.f(Q.x());
                    }
                } else {
                    a0.g(Q.x());
                }
                bVar.a(null);
            } else if (f53021c) {
                Log.d("StartPermissionsPage", "swan or activity is null");
            }
            return null;
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }
}
