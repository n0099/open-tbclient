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
import com.dxmpay.apollon.restnet.converter.b;
import com.dxmpay.apollon.utils.LogUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class RestHttpDNSEnabler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "RestHttpDNSEnabler";

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f52245b;

    /* renamed from: c  reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f52246c;

    /* renamed from: d  reason: collision with root package name */
    public static long f52247d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public long f52249b;

        /* renamed from: c  reason: collision with root package name */
        public long f52250c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            this(str, System.currentTimeMillis(), RestHttpDNSEnabler.f52247d);
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

        public a(String str, long j2, long j3) {
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
            this.f52249b = j2;
            this.f52250c = j3;
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
        f52245b = Pattern.compile(com.baidu.apollon.restnet.RestHttpDNSEnabler.f31150b);
        f52246c = new ConcurrentHashMap<>();
        f52247d = 86400L;
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

    public static void enableHttpDns(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f52246c.containsKey(str)) {
                    return;
                }
                new Thread(new Runnable(context, str) { // from class: com.dxmpay.apollon.restnet.RestHttpDNSEnabler.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f52248b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = context;
                        this.f52248b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            RestTemplate restTemplate = new RestTemplate(this.a.getApplicationContext());
                            restTemplate.setMessageConverter(new b());
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new RestNameValuePair("dn", this.f52248b));
                            try {
                                String str2 = (String) restTemplate.a("http://180.76.76.112/", arrayList, "utf-8", String.class);
                                if (str2 instanceof String) {
                                    String trim = str2.trim();
                                    if (trim.contains(" ")) {
                                        String[] split = trim.split(" ");
                                        trim = split[new Random().nextInt(split.length)];
                                    }
                                    LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "result: " + trim);
                                    if (TextUtils.isEmpty(trim) || !RestHttpDNSEnabler.a(trim)) {
                                        return;
                                    }
                                    synchronized (RestHttpDNSEnabler.f52246c) {
                                        RestHttpDNSEnabler.f52246c.put(this.f52248b, new a(trim));
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }).start();
                return;
            }
            String str2 = a;
            LogUtil.w(str2, a + " enableHttpDns params context is null or hostName is null.");
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? f52245b.matcher(str).matches() : invokeL.booleanValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && a(str)) {
            Iterator<Map.Entry<String, a>> it = f52246c.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().a.equals(str)) {
                    it.remove();
                    return;
                }
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
            for (Map.Entry<String, a> entry : f52246c.entrySet()) {
                String key = entry.getKey();
                if (key.equals(host) || (ApollonConstants.WALLET_SPECIFIC && key.endsWith("baifubao.com") && host.endsWith("baifubao.com"))) {
                    synchronized (f52246c) {
                        replaceFirst = url2.replaceFirst(host, f52246c.get(key).a);
                    }
                    return replaceFirst;
                }
            }
            return url2;
        }
        return (String) invokeL.objValue;
    }
}
