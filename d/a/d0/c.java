package d.a.d0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f42472a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-471325642, "Ld/a/d0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-471325642, "Ld/a/d0/c;");
        }
    }

    public c() {
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

    public static synchronized c e() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (c.class) {
                if (f42472a == null) {
                    synchronized (c.class) {
                        if (f42472a == null) {
                            f42472a = new c();
                        }
                    }
                }
                cVar = f42472a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public boolean a(Activity activity, String str, d.a.d0.e.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, aVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            b.a().b(activity, str, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean b(Activity activity, String str, d.a.d0.e.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, aVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            b.a().d(activity, str, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            b.a().f(context, jSONObject);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean d(Context context, JSONObject jSONObject, d.a.d0.e.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, jSONObject, aVar)) == null) {
            if (jSONObject == null) {
                return false;
            }
            b.a().c(context, jSONObject, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
