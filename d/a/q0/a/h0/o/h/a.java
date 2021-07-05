package d.a.q0.a.h0.o.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import d.a.q0.a.h0.o.h.g.c;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.q0.a.h0.o.h.g.a> f48384a;

    /* renamed from: d.a.q0.a.h0.o.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0807a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f48385a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-381600655, "Ld/a/q0/a/h0/o/h/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-381600655, "Ld/a/q0/a/h0/o/h/a$b;");
                    return;
                }
            }
            f48385a = new a(null);
        }
    }

    public /* synthetic */ a(C0807a c0807a) {
        this();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f48385a : (a) invokeV.objValue;
    }

    public void a(d.a.q0.a.h0.o.h.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || this.f48384a.contains(aVar)) {
            return;
        }
        this.f48384a.add(aVar);
    }

    @RequiresApi(api = 21)
    public WebResourceResponse c(WebResourceRequest webResourceRequest, boolean z) {
        InterceptResult invokeLZ;
        Uri url;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webResourceRequest, z)) == null) {
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
                return null;
            }
            return d(url.toString(), webResourceRequest.getRequestHeaders(), z);
        }
        return (WebResourceResponse) invokeLZ.objValue;
    }

    public final WebResourceResponse d(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, map, z)) == null) {
            if (this.f48384a.isEmpty() || TextUtils.isEmpty(str) || str.startsWith("file://")) {
                return null;
            }
            return new c(this.f48384a, str, map, 0, z).b(str, map, z);
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    public a() {
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
        this.f48384a = new CopyOnWriteArrayList<>();
    }
}
