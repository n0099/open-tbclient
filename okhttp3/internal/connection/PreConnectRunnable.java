package okhttp3.internal.connection;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public static Map<HttpUrl, Integer> mPreConnectHttpUrlMap;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient mClient;
    public HttpUrl mHttpUrl;
    public PreConnectParams mParams;
    public int mPreConnectNum;

    public PreConnectRunnable(OkHttpClient okHttpClient, HttpUrl httpUrl, int i, Map<HttpUrl, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient, httpUrl, Integer.valueOf(i), map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClient = okHttpClient;
        this.mParams = okHttpClient.getPreConnectParams();
        this.mHttpUrl = httpUrl;
        this.mPreConnectNum = i;
        mPreConnectHttpUrlMap = map;
    }

    public static Address createAddress(OkHttpClient okHttpClient, HttpUrl httpUrl) {
        InterceptResult invokeLL;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, okHttpClient, httpUrl)) == null) {
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
        return (Address) invokeLL.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<HttpUrl, Integer> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (map = mPreConnectHttpUrlMap) != null && map.size() >= 1) {
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
