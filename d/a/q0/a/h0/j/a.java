package d.a.q0.a.h0.j;

import android.net.Uri;
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
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48137a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f48138b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705506573, "Ld/a/q0/a/h0/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705506573, "Ld/a/q0/a/h0/j/a;");
                return;
            }
        }
        f48137a = k.f49133a;
        HashSet hashSet = new HashSet();
        f48138b = hashSet;
        hashSet.add("https");
        f48138b.add("http");
        f48138b.add("sms");
        f48138b.add("tel");
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

    @Override // d.a.q0.a.h0.j.d
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // d.a.q0.a.h0.j.d
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    @Override // d.a.q0.a.h0.j.d
    public boolean c(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null || (parse = Uri.parse(str)) == null) {
                return true;
            }
            boolean contains = f48138b.contains(parse.getScheme());
            if (f48137a) {
                StringBuilder sb = new StringBuilder();
                sb.append(contains ? "legal schemes : " : "illegal schemes : ");
                sb.append(parse.getScheme());
                Log.d("WebViewWidgetListener", sb.toString());
            }
            return !contains;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.a.h0.j.d
    public void d(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
        }
    }

    @Override // d.a.q0.a.h0.j.d
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // d.a.q0.a.h0.j.d
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }
}
