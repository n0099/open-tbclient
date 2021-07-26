package d.a.o0.a.u.g;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48364b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f48365c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f48366a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998174351, "Ld/a/o0/a/u/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-998174351, "Ld/a/o0/a/u/g/c;");
                return;
            }
        }
        f48364b = k.f46335a;
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
        this.f48366a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f48365c == null) {
                synchronized (c.class) {
                    if (f48365c == null) {
                        f48365c = new c();
                    }
                }
            }
            return f48365c;
        }
        return (c) invokeV.objValue;
    }

    @Override // d.a.o0.a.u.g.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (f48364b) {
                Log.d("Api-Marker", "markStart: " + str);
            }
            for (int i2 = 0; i2 < this.f48366a.size(); i2++) {
                this.f48366a.get(i2).a(str);
            }
        }
    }

    @Override // d.a.o0.a.u.g.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (f48364b) {
                Log.d("Api-Marker", "markEnd: " + str);
            }
            for (int i2 = 0; i2 < this.f48366a.size(); i2++) {
                this.f48366a.get(i2).b(str);
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (f48364b) {
                    Log.d("Api-Marker", "release: ");
                }
                if (f48365c == null) {
                    return;
                }
                f48365c = null;
            }
        }
    }
}
