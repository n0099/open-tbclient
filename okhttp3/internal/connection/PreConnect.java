package okhttp3.internal.connection;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
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
/* loaded from: classes10.dex */
public class PreConnect {
    public static final Call NONE = new Call() { // from class: okhttp3.internal.connection.PreConnect.1
        @Override // okhttp3.Call
        public void cancel() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // okhttp3.Call
        public Call clone() {
            return null;
        }

        @Override // okhttp3.Call
        public void enqueue(Callback callback) {
        }

        @Override // okhttp3.Call
        public Response execute() throws IOException {
            return null;
        }

        @Override // okhttp3.Call
        public boolean isCanceled() {
            return false;
        }

        @Override // okhttp3.Call
        public boolean isExecuted() {
            return false;
        }

        @Override // okhttp3.Call
        public Request request() {
            return null;
        }

        @Override // okhttp3.Call
        public Timeout timeout() {
            return null;
        }
    };
    public static Map<String, Integer> preConnectUrlMap;
    public static volatile ScheduledExecutorService scheduledExecutorService;

    /* loaded from: classes10.dex */
    public static class PreConnectTask implements Runnable {
        public static List<String> mPreConnectAllowlist;
        public OkHttpClient mClient;
        public ConnectionPool mConnectionPool;
        public Map<HttpUrl, Integer> mPreConnectHttpUrlMap;
        public Map<String, Integer> mPreConnectUrlMap;
        public int maxSingleHostPreConnectNum;

        public PreConnectTask(OkHttpClient okHttpClient, Map<String, Integer> map) {
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
            if (this.mConnectionPool.getPreConnectAlive(this.mPreConnectHttpUrlMap) < this.mClient.getPreConnectParams().getMaxPreConnectNum()) {
                for (Map.Entry<HttpUrl, Integer> entry : this.mPreConnectHttpUrlMap.entrySet()) {
                    if (this.mConnectionPool.connectionsCount(entry.getKey().host(), false) < entry.getValue().intValue()) {
                        PreConnect.buildPreConnect(this.mClient, entry.getKey(), entry.getValue().intValue(), this.mPreConnectHttpUrlMap);
                    }
                }
            }
        }
    }

    public static ScheduledExecutorService scheduledExecutorService() {
        if (scheduledExecutorService == null) {
            synchronized (PreConnect.class) {
                if (scheduledExecutorService == null) {
                    scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
                }
            }
        }
        return scheduledExecutorService;
    }

    public static void buildPreConnect(OkHttpClient okHttpClient, HttpUrl httpUrl, int i, Map<HttpUrl, Integer> map) {
        okHttpClient.dispatcher().executorService().execute(new PreConnectRunnable(okHttpClient, httpUrl, i, map));
    }

    public static void buildPreConnectWithoutDelay(OkHttpClient okHttpClient, List<String> list, Map<String, Integer> map) {
        if (map != null && map.size() >= 1) {
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

    public static Map<String, Integer> getPreConnectUrlMap(List<String> list) {
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

    public static void startPreConnect(OkHttpClient okHttpClient) {
        Map<String, Integer> preConnectUrlMap2;
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
