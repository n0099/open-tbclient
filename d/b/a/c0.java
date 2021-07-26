package d.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes8.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f69211a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(413426076, "Ld/b/a/c0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(413426076, "Ld/b/a/c0;");
        }
    }

    public c0() {
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

    public static String a(Context context, y1 y1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, y1Var)) == null) {
            if (TextUtils.isEmpty(f69211a)) {
                synchronized (c0.class) {
                    if (!TextUtils.isEmpty(f69211a)) {
                        return f69211a;
                    }
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                    String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                    if (TextUtils.isEmpty(id)) {
                        id = y1Var.D().getString("google_aid", null);
                    } else if (!TextUtils.equals(y1Var.D().getString("google_aid", null), id)) {
                        b(context, id, y1Var);
                    }
                    f69211a = id;
                }
            }
            return f69211a;
        }
        return (String) invokeLL.objValue;
    }

    public static void b(Context context, String str, y1 y1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, str, y1Var) == null) || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        y1Var.D().edit().putString("google_aid", str).apply();
    }
}
