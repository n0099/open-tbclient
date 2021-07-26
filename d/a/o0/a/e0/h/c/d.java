package d.a.o0.a.e0.h.c;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.h.c.c;
import d.a.o0.a.k;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends c.b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f44689b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2017439686, "Ld/a/o0/a/e0/h/c/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2017439686, "Ld/a/o0/a/e0/h/c/d$a;");
                    return;
                }
            }
            f44689b = k.f46335a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c.a aVar) {
            super(aVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.o0.a.e0.h.c.c.b
        public Map<String, String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Upgrade", "websocket");
                hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
                try {
                    hashMap.put("Sec-WebSocket-Accept", d.a.o0.a.e0.h.d.a.g(this.f44688a.f44683a.get("sec-websocket-key")));
                } catch (NoSuchAlgorithmException e2) {
                    if (f44689b) {
                        Log.e("HandShakeResponse", "make accept key fail for error invalid algorithm", e2);
                    }
                }
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        @Override // d.a.o0.a.e0.h.c.c.b
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "101 Switching Protocols" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public String f44690b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c.a aVar) {
            super(aVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.o0.a.e0.h.c.c.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f44690b == null) {
                    this.f44690b = new d.a.o0.a.e0.h.b().toString();
                }
                return this.f44690b;
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.o0.a.e0.h.c.c.b
        public Map<String, String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json; charset=UTF-8");
                hashMap.put(Util.ACCEPT_RANGES, "bytes");
                hashMap.put(HTTP.CONN_DIRECTIVE, "keep-alive");
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        @Override // d.a.o0.a.e0.h.c.c.b
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "200 OK" : (String) invokeV.objValue;
        }
    }

    public static c.b a(c.a aVar) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            if (aVar == null || (map = aVar.f44683a) == null || map.size() < 1) {
                return null;
            }
            if (d.a.o0.a.e0.h.d.a.f(aVar.f44683a)) {
                aVar.f44687e = true;
                return new a(aVar);
            }
            aVar.f44687e = false;
            return new b(aVar);
        }
        return (c.b) invokeL.objValue;
    }
}
