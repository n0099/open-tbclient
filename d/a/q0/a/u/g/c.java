package d.a.q0.a.u.g;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51162b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f51163c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f51164a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-297109773, "Ld/a/q0/a/u/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-297109773, "Ld/a/q0/a/u/g/c;");
                return;
            }
        }
        f51162b = k.f49133a;
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
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f51164a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f51163c == null) {
                synchronized (c.class) {
                    if (f51163c == null) {
                        f51163c = new c();
                    }
                }
            }
            return f51163c;
        }
        return (c) invokeV.objValue;
    }

    @Override // d.a.q0.a.u.g.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (f51162b) {
                Log.d("Api-Marker", "markStart: " + str);
            }
            for (int i2 = 0; i2 < this.f51164a.size(); i2++) {
                this.f51164a.get(i2).a(str);
            }
        }
    }

    @Override // d.a.q0.a.u.g.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (f51162b) {
                Log.d("Api-Marker", "markEnd: " + str);
            }
            for (int i2 = 0; i2 < this.f51164a.size(); i2++) {
                this.f51164a.get(i2).b(str);
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (f51162b) {
                    Log.d("Api-Marker", "release: ");
                }
                if (f51163c == null) {
                    return;
                }
                f51163c = null;
            }
        }
    }
}
