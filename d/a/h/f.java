package d.a.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f42392a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str);
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f42393e;

        /* renamed from: f  reason: collision with root package name */
        public a f42394f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f42395g;

        public b(f fVar, String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42395g = fVar;
            this.f42393e = str;
            this.f42394f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map e2 = this.f42395g.e(this.f42393e);
                if (e2 != null) {
                    arrayList2 = (ArrayList) e2.get(HttpDnsCacheForHost.JSON_KEY_IPV6);
                    arrayList = (ArrayList) e2.get("ipv4");
                } else {
                    arrayList = null;
                    arrayList2 = null;
                }
                this.f42394f.a(((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? -1 : 0, arrayList, arrayList2, 60L, this.f42393e);
            }
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f42392a == null) {
                synchronized (f.class) {
                    if (f42392a == null) {
                        f42392a = new f();
                    }
                }
            }
            return f42392a;
        }
        return (f) invokeV.objValue;
    }

    public BDHttpDnsResult a(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, ArrayList> e2 = e(str);
            ArrayList arrayList2 = null;
            if (e2 != null) {
                arrayList2 = e2.get("ipv4");
                arrayList = e2.get(HttpDnsCacheForHost.JSON_KEY_IPV6);
            } else {
                arrayList = null;
            }
            return ((arrayList2 == null || arrayList2.isEmpty()) && (arrayList == null || arrayList.isEmpty())) ? new BDHttpDnsResult(BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve) : new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList2, arrayList);
        }
        return (BDHttpDnsResult) invokeL.objValue;
    }

    public void d(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) || str == null || str.isEmpty()) {
            return;
        }
        l.a().b().execute(new b(this, str, aVar));
    }

    public final Map<String, ArrayList> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName == null || allByName.length == 0) {
                    k.a("Dns resolve failed, host(%s), get empty resolve result", str);
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                for (InetAddress inetAddress : allByName) {
                    if (inetAddress instanceof Inet4Address) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (e.e(hostAddress)) {
                            arrayList.add(hostAddress);
                        }
                    } else if (inetAddress instanceof Inet6Address) {
                        String hostAddress2 = inetAddress.getHostAddress();
                        if (e.g(hostAddress2)) {
                            arrayList2.add(hostAddress2);
                        }
                    }
                }
                hashMap.put("ipv4", arrayList);
                hashMap.put(HttpDnsCacheForHost.JSON_KEY_IPV6, arrayList2);
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    k.a("Dns resolve failed, host(%s), get no valid resolve result", str);
                    return null;
                }
                k.a("Dns resolve successful, host(%s), ipv4List(%s), ipv6List(%s)", str, arrayList.toString(), arrayList2.toString());
                return hashMap;
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
                k.a("Dns resolve failed, host(%s), caught UnknownHostException", str);
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }
}
