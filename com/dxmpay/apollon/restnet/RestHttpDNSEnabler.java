package com.dxmpay.apollon.restnet;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.utils.LogUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes12.dex */
public class RestHttpDNSEnabler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "RestHttpDNSEnabler";

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f55108b;

    /* renamed from: c  reason: collision with root package name */
    public static ConcurrentHashMap<String, b> f55109c;

    /* renamed from: d  reason: collision with root package name */
    public static long f55110d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f55111e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55112f;

        public a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55111e = context;
            this.f55112f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RestTemplate restTemplate = new RestTemplate(this.f55111e.getApplicationContext());
                restTemplate.setMessageConverter(new c.f.a.g.b.b());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("dn", this.f55112f));
                try {
                    String str = (String) restTemplate.d("http://180.76.76.112/", arrayList, "utf-8", String.class);
                    if (str instanceof String) {
                        String trim = str.trim();
                        if (trim.contains(" ")) {
                            String[] split = trim.split(" ");
                            trim = split[new Random().nextInt(split.length)];
                        }
                        LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "result: " + trim);
                        if (TextUtils.isEmpty(trim) || !RestHttpDNSEnabler.c(trim)) {
                            return;
                        }
                        synchronized (RestHttpDNSEnabler.f55109c) {
                            RestHttpDNSEnabler.f55109c.put(this.f55112f, new b(trim));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            this(str, System.currentTimeMillis(), RestHttpDNSEnabler.f55110d);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public b(String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1221558973, "Lcom/dxmpay/apollon/restnet/RestHttpDNSEnabler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1221558973, "Lcom/dxmpay/apollon/restnet/RestHttpDNSEnabler;");
                return;
            }
        }
        f55108b = Pattern.compile(com.baidu.apollon.restnet.RestHttpDNSEnabler.f33052b);
        f55109c = new ConcurrentHashMap<>();
        f55110d = 86400L;
    }

    public RestHttpDNSEnabler() {
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

    public static String a(URL url) {
        InterceptResult invokeL;
        String replaceFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, url)) == null) {
            String host = url.getHost();
            String url2 = url.toString();
            for (Map.Entry<String, b> entry : f55109c.entrySet()) {
                String key = entry.getKey();
                if (key.equals(host) || (ApollonConstants.WALLET_SPECIFIC && key.endsWith("baifubao.com") && host.endsWith("baifubao.com"))) {
                    synchronized (f55109c) {
                        replaceFirst = url2.replaceFirst(host, f55109c.get(key).a);
                    }
                    return replaceFirst;
                }
            }
            return url2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? f55108b.matcher(str).matches() : invokeL.booleanValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && c(str)) {
            Iterator<Map.Entry<String, b>> it = f55109c.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().a.equals(str)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public static void enableHttpDns(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f55109c.containsKey(str)) {
                    return;
                }
                new Thread(new a(context, str)).start();
                return;
            }
            String str2 = a;
            LogUtil.w(str2, a + " enableHttpDns params context is null or hostName is null.");
        }
    }
}
