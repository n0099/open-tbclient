package okhttp3.internal.connection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;
/* loaded from: classes9.dex */
public class PreConnect {
    public static /* synthetic */ Interceptable $ic;
    public static final Call NONE;
    public static Map<String, Integer> preConnectUrlMap;
    public static volatile ScheduledExecutorService scheduledExecutorService;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class PreConnectTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static List<String> mPreConnectAllowlist;
        public transient /* synthetic */ FieldHolder $fh;
        public OkHttpClient mClient;
        public ConnectionPool mConnectionPool;
        public Map<HttpUrl, Integer> mPreConnectHttpUrlMap;
        public Map<String, Integer> mPreConnectUrlMap;
        public int maxSingleHostPreConnectNum;

        public PreConnectTask(OkHttpClient okHttpClient, Map<String, Integer> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttpClient, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mClient = okHttpClient;
            this.maxSingleHostPreConnectNum = okHttpClient.getPreConnectParams().getMaxSingleHostPreConnectNum();
            mPreConnectAllowlist = okHttpClient.getPreConnectParams().getPreConnectUrlsAllowlist();
            this.mConnectionPool = this.mClient.connectionPool();
            this.mPreConnectUrlMap = map;
            this.mPreConnectHttpUrlMap = new HashMap();
            for (Map.Entry<String, Integer> entry : this.mPreConnectUrlMap.entrySet()) {
                if (mPreConnectAllowlist.contains(entry.getKey())) {
                    this.mPreConnectHttpUrlMap.put(PreConnect.getHttpUrl(entry.getKey()), Integer.valueOf(Math.min(entry.getValue().intValue(), this.maxSingleHostPreConnectNum)));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mConnectionPool.getPreConnectAlive(this.mPreConnectHttpUrlMap) < this.mClient.getPreConnectParams().getMaxPreConnectNum()) {
                for (Map.Entry<HttpUrl, Integer> entry : this.mPreConnectHttpUrlMap.entrySet()) {
                    if (this.mConnectionPool.connectionsCount(entry.getKey().host(), false) < entry.getValue().intValue()) {
                        PreConnect.buildPreConnect(this.mClient, entry.getKey(), entry.getValue().intValue(), this.mPreConnectHttpUrlMap);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1855269513, "Lokhttp3/internal/connection/PreConnect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1855269513, "Lokhttp3/internal/connection/PreConnect;");
                return;
            }
        }
        NONE = new Call() { // from class: okhttp3.internal.connection.PreConnect.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // okhttp3.Call
            public void cancel() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // okhttp3.Call
            public Call clone() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (Call) invokeV.objValue;
            }

            @Override // okhttp3.Call
            public void enqueue(Callback callback) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, callback) == null) {
                }
            }

            @Override // okhttp3.Call
            public Response execute() throws IOException {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return null;
                }
                return (Response) invokeV.objValue;
            }

            @Override // okhttp3.Call
            public boolean isCanceled() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // okhttp3.Call
            public boolean isExecuted() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // okhttp3.Call
            public Request request() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) {
                    return null;
                }
                return (Request) invokeV.objValue;
            }

            @Override // okhttp3.Call
            public Timeout timeout() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return null;
                }
                return (Timeout) invokeV.objValue;
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
    }

    public PreConnect() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ScheduledExecutorService scheduledExecutorService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (scheduledExecutorService == null) {
                synchronized (PreConnect.class) {
                    if (scheduledExecutorService == null) {
                        scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
                    }
                }
            }
            return scheduledExecutorService;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public static void buildPreConnect(OkHttpClient okHttpClient, HttpUrl httpUrl, int i, Map<HttpUrl, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, okHttpClient, httpUrl, i, map) == null) {
            okHttpClient.dispatcher().executorService().execute(new PreConnectRunnable(okHttpClient, httpUrl, i, map));
        }
    }

    public static void buildPreConnectWithoutDelay(OkHttpClient okHttpClient, List<String> list, Map<String, Integer> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, okHttpClient, list, map) == null) && map != null && map.size() >= 1) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (list.contains(entry.getKey())) {
                    hashMap.put(getHttpUrl(entry.getKey()), Integer.valueOf(Math.min(entry.getValue().intValue(), okHttpClient.getPreConnectParams().getMaxSingleHostPreConnectNum())));
                }
            }
            for (Map.Entry entry2 : hashMap.entrySet()) {
                buildPreConnect(okHttpClient, (HttpUrl) entry2.getKey(), ((Integer) entry2.getValue()).intValue(), hashMap);
            }
        }
    }

    public static HttpUrl getHttpUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
                }
                return HttpUrl.parse(str);
            }
            throw new NullPointerException("url == null");
        }
        return (HttpUrl) invokeL.objValue;
    }

    public static Map<String, Integer> getPreConnectUrlMap(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            HashMap hashMap = new HashMap();
            if (list != null && list.size() > 0) {
                for (String str : list) {
                    if (str.contains("|")) {
                        String[] split = str.split(WebChromeClient.PARAM_SEPARATOR);
                        hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static void startPreConnect(OkHttpClient okHttpClient) {
        Map<String, Integer> preConnectUrlMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, okHttpClient) == null) {
            PreConnectParams preConnectParams = okHttpClient.getPreConnectParams();
            List<String> preConnectUrlsAllowlist = preConnectParams.getPreConnectUrlsAllowlist();
            List<String> preConnectNoDelayUrlsWithNum = preConnectParams.getPreConnectNoDelayUrlsWithNum();
            List<String> preConnectDelayUrlsWithNum = preConnectParams.getPreConnectDelayUrlsWithNum();
            int preConnectDelayTimeMs = preConnectParams.getPreConnectDelayTimeMs();
            int preConnectPeriodTimeMs = preConnectParams.getPreConnectPeriodTimeMs();
            if (preConnectParams.getPreConnectEnabled() && preConnectDelayTimeMs > 0 && preConnectPeriodTimeMs > 0 && preConnectUrlsAllowlist != null && preConnectUrlsAllowlist.size() >= 1) {
                if ((preConnectDelayUrlsWithNum != null && preConnectDelayUrlsWithNum.size() >= 1) || (preConnectNoDelayUrlsWithNum != null && preConnectNoDelayUrlsWithNum.size() >= 1)) {
                    preConnectUrlMap = getPreConnectUrlMap(preConnectDelayUrlsWithNum);
                    if (preConnectNoDelayUrlsWithNum != null && preConnectNoDelayUrlsWithNum.size() > 0 && (preConnectUrlMap2 = getPreConnectUrlMap(preConnectNoDelayUrlsWithNum)) != null && preConnectUrlMap2.size() > 0) {
                        buildPreConnectWithoutDelay(okHttpClient, preConnectUrlsAllowlist, preConnectUrlMap2);
                        for (Map.Entry<String, Integer> entry : preConnectUrlMap2.entrySet()) {
                            if (preConnectUrlMap.containsKey(entry.getKey())) {
                                int intValue = entry.getValue().intValue();
                                int intValue2 = preConnectUrlMap.get(entry.getKey()).intValue();
                                Map<String, Integer> map = preConnectUrlMap;
                                String key = entry.getKey();
                                if (intValue <= intValue2) {
                                    intValue = intValue2;
                                }
                                map.put(key, Integer.valueOf(intValue));
                            } else {
                                preConnectUrlMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    Map<String, Integer> map2 = preConnectUrlMap;
                    if (map2 != null && map2.size() > 0) {
                        scheduledExecutorService().scheduleAtFixedRate(new PreConnectTask(okHttpClient, preConnectUrlMap), preConnectDelayTimeMs, preConnectPeriodTimeMs, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
    }
}
