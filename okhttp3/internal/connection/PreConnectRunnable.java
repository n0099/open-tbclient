package okhttp3.internal.connection;

import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
/* loaded from: classes9.dex */
public class PreConnectRunnable implements Runnable {
    public static Map<HttpUrl, Integer> mPreConnectHttpUrlMap;
    public OkHttpClient mClient;
    public HttpUrl mHttpUrl;
    public PreConnectParams mParams;
    public int mPreConnectNum;

    public PreConnectRunnable(OkHttpClient okHttpClient, HttpUrl httpUrl, int i, Map<HttpUrl, Integer> map) {
        this.mClient = okHttpClient;
        this.mParams = okHttpClient.getPreConnectParams();
        this.mHttpUrl = httpUrl;
        this.mPreConnectNum = i;
        mPreConnectHttpUrlMap = map;
    }

    public static Address createAddress(OkHttpClient okHttpClient, HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = okHttpClient.sslSocketFactory();
            hostnameVerifier = okHttpClient.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = okHttpClient.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), okHttpClient.dns(), okHttpClient.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator(), okHttpClient.proxy(), okHttpClient.protocols(), okHttpClient.connectionSpecs(), okHttpClient.proxySelector());
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<HttpUrl, Integer> map = mPreConnectHttpUrlMap;
        if (map != null && map.size() >= 1) {
            ConnectionPool connectionPool = this.mClient.connectionPool();
            Object stackTraceForCloseable = Platform.get().getStackTraceForCloseable("response.body().close()");
            for (int connectionsCount = connectionPool.connectionsCount(this.mHttpUrl.host(), false); connectionsCount < this.mPreConnectNum && !connectionPool.hostH2ConnectionExist(this.mHttpUrl.host()); connectionsCount++) {
                try {
                    new StreamAllocation(connectionPool, createAddress(this.mClient, this.mHttpUrl), PreConnect.NONE, EventListener.NONE, stackTraceForCloseable).createPreConnect(this.mClient.connectTimeoutMillis(), this.mClient.readTimeoutMillis(), this.mClient.writeTimeoutMillis(), this.mClient.pingIntervalMillis(), this.mClient.retryOnConnectionFailure(), this.mParams.getMaxPreConnectNum(), this.mPreConnectNum, mPreConnectHttpUrlMap);
                } catch (RouteException unused) {
                }
            }
        }
    }
}
