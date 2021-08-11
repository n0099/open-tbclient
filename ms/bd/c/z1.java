package ms.bd.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class z1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile z1 f78908b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Throwable f78909a;

    public z1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78909a = null;
    }

    public static z1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f78908b == null) {
                synchronized (z1.class) {
                    if (f78908b == null) {
                        f78908b = new z1();
                    }
                }
            }
            return f78908b;
        }
        return (z1) invokeV.objValue;
    }

    public synchronized Throwable a() {
        InterceptResult invokeV;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                th = this.f78909a;
            }
            return th;
        }
        return (Throwable) invokeV.objValue;
    }

    public List<Method> b(Class cls, String str) {
        InterceptResult invokeLL;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cls != null && !TextUtils.isEmpty(str)) {
                for (Method method : cls.getDeclaredMethods()) {
                    if (method != null && method.getName().equals(str)) {
                        arrayList.add(method);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
