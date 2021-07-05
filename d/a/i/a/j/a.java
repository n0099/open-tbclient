package d.a.i.a.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f45698b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> f45699a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-392613928, "Ld/a/i/a/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-392613928, "Ld/a/i/a/j/a;");
                return;
            }
        }
        f45698b = new a();
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
                return;
            }
        }
        this.f45699a = new HashMap();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f45698b : (a) invokeV.objValue;
    }

    public void a(int i2, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, onRequestPermissionsResultCallback) == null) || this.f45699a == null) {
            return;
        }
        synchronized (a.class) {
            if (this.f45699a.containsKey(Integer.valueOf(i2))) {
                this.f45699a.remove(Integer.valueOf(i2));
            }
            this.f45699a.put(Integer.valueOf(i2), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.f45699a;
            if (map == null || !map.containsKey(Integer.valueOf(i2))) {
                return null;
            }
            return this.f45699a.get(Integer.valueOf(i2));
        }
        return (ActivityCompat.OnRequestPermissionsResultCallback) invokeI.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (a.class) {
                if (this.f45699a != null && this.f45699a.containsKey(Integer.valueOf(i2))) {
                    this.f45699a.remove(Integer.valueOf(i2));
                }
            }
        }
    }
}
