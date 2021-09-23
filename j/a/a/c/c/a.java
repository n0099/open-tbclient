package j.a.a.c.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.DnsResultInfo;
import com.yy.gslbsdk.GslbEvent;
import com.yy.gslbsdk.HttpDnsService;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes2.dex */
public class a implements Dns {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HttpDnsService f79361a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f79362b;

    /* renamed from: j.a.a.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2148a implements GslbEvent.GslbEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2148a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.yy.gslbsdk.GslbEvent.GslbEventListener
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                RLog.debug(HttpDnsService.TAG, "OkHttpDns onMessage msg:" + str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f79363a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1815876159, "Lj/a/a/c/c/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1815876159, "Lj/a/a/c/c/a$b;");
                    return;
                }
            }
            f79363a = new a(null);
        }
    }

    public /* synthetic */ a(C2148a c2148a) {
        this();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f79363a : (a) invokeV.objValue;
    }

    public List<String> a(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f79361a == null) {
                RLog.error("YYPayHttpDns", "getIPListByHost error mHttpDnsService null", new Object[0]);
                return null;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            DnsResultInfo ipsByHost = this.f79361a.getIpsByHost(str);
            if (ipsByHost != null) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = ipsByHost.mIpsV6;
                if (strArr != null) {
                    arrayList.addAll(c(strArr));
                    if (ipsByHost.mIpsV6.length == 0) {
                        RLog.error("YYPayHttpDns", "getIPListByHost IpsV6 empty hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
                    }
                } else {
                    RLog.error("YYPayHttpDns", "getIPListByHost IpsV6 null hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
                }
                String[] strArr2 = ipsByHost.mIpsV4;
                if (strArr2 != null) {
                    arrayList.addAll(c(strArr2));
                    if (ipsByHost.mIpsV4.length == 0) {
                        RLog.error("YYPayHttpDns", "getIPListByHost IpsV4 empty hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
                    }
                } else {
                    RLog.error("YYPayHttpDns", "getIPListByHost IpsV4 null hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
                }
                RLog.info("YYPayHttpDns", "hostname:" + str + " mDataSource:" + ipsByHost.mDataSource + " code:" + ipsByHost.mErrorCode + " res.IPList:" + arrayList + " use duration:" + (SystemClock.uptimeMillis() - uptimeMillis));
                return arrayList;
            }
            RLog.info("YYPayHttpDns", "getIPListByDns host:" + str + "  use duration:" + (SystemClock.uptimeMillis() - uptimeMillis));
            return null;
        }
        return (List) invokeL.objValue;
    }

    public List<String> c(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<InetAddress> d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        arrayList.add(InetAddress.getByName(str));
                    } catch (UnknownHostException e2) {
                        RLog.error("YYPayHttpDns", "getByName(" + str + ") error", e2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized void e(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, str2) == null) {
            synchronized (this) {
                if (!this.f79362b) {
                    RLog.warn("YYPayHttpDns", "tryInitHttpDns but not enable appId:" + str + " hdid:" + str2);
                } else if (this.f79361a != null) {
                    RLog.warn("YYPayHttpDns", "tryInitHttpDns but mHttpDnsService exit appId:" + str + " hdid:" + str2);
                } else if (context == null) {
                    RLog.error("YYPayHttpDns", "tryInitHttpDns error context params null", new Object[0]);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    HttpDnsService service = HttpDnsService.getService(context, str, (ThreadPoolMgr.ITaskExecutor) null, str2, "CN");
                    this.f79361a = service;
                    service.setLogEnabled(Env.instance().isTestEnv());
                    this.f79361a.setGslbEventMessager(new C2148a(this));
                    this.f79361a.setHttpsEnable(true);
                    this.f79361a.setNetworkStatus(3);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(Env.instance().REVENUE_HTTP_URL);
                    if (!Env.instance().isTestEnv()) {
                        arrayList.addAll(Arrays.asList(Env.instance().BACKUP_DOMAIN_POOL));
                    }
                    RLog.info("YYPayHttpDns", "PreResolveHost hosts:" + arrayList.toString());
                    this.f79361a.setPreResolveHosts(arrayList);
                    RLog.info("YYPayHttpDns", "dns init success cost time = " + (System.currentTimeMillis() - currentTimeMillis) + " appId:" + str + " hdid:" + str2);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|(5:7|8|9|(3:18|19|20)|(2:14|15)(1:17))|27|(1:11)|18|19|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        com.yy.mobile.framework.revenuesdk.baseapi.log.RLog.error("YYPayHttpDns", "System lookup dns error", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // okhttp3.Dns
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<InetAddress> lookup(String str) {
        InterceptResult invokeL;
        List<InetAddress> list;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, str)) != null) {
            return (List) invokeL.objValue;
        }
        if (this.f79362b && this.f79361a != null) {
            RLog.info("YYPayHttpDns", "httpdns lookup ");
            try {
                list = d(a(str));
            } catch (Exception e2) {
                RLog.error("YYPayHttpDns", "lookup exception:" + e2.getLocalizedMessage(), new Object[0]);
            }
            if (list != null || list.isEmpty()) {
                RLog.info("YYPayHttpDns", "system lookup");
                list = Dns.SYSTEM.lookup(str);
            }
            return list != null ? Collections.emptyList() : list;
        }
        list = null;
        if (list != null) {
        }
        RLog.info("YYPayHttpDns", "system lookup");
        list = Dns.SYSTEM.lookup(str);
        if (list != null) {
        }
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
        this.f79361a = null;
        this.f79362b = true;
        RLog.warn("YYPayHttpDns", "new OkHttpDns:" + toString());
    }
}
