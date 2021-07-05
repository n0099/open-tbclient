package com.yy.hiidostatis.inner.util.http;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.TConst;
import com.yy.hiidostatis.inner.util.http.HttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.util.Random;
/* loaded from: classes8.dex */
public abstract class AbstractStatisHttpUtil implements IStatisHttpUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String lastRemoteIp;
    public int lastTryTimes;
    public CacheIp mCacheIp;
    public int mRetryTimeHost;
    public Throwable mThrowable;
    public int mTryTimeIp;
    public String reasonPhrase;
    public int statusCode;
    public String testServer;

    public AbstractStatisHttpUtil() {
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
        this.mRetryTimeHost = 2;
        this.mTryTimeIp = 2;
    }

    private boolean getByUrlConn(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            this.statusCode = -1;
            this.reasonPhrase = null;
            HttpUtil.HttpResp byUrlConn = HttpUtil.getByUrlConn(str, str2);
            this.statusCode = byUrlConn.statusCode;
            this.reasonPhrase = byUrlConn.reason;
            return byUrlConn.isSucceed;
        }
        return invokeLL.booleanValue;
    }

    private boolean postByUrlConn(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            this.statusCode = -1;
            this.reasonPhrase = null;
            HttpUtil.HttpResp postByUrlConn = HttpUtil.postByUrlConn(str, str2);
            this.statusCode = postByUrlConn.statusCode;
            this.reasonPhrase = postByUrlConn.reason;
            this.lastRemoteIp = postByUrlConn.remoteIp;
            return postByUrlConn.isSucceed;
        }
        return invokeLL.booleanValue;
    }

    public String asUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? String.format(getUrlFormat(), str) : (String) invokeL.objValue;
    }

    public boolean get(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? getByUrlConn(str, str2) : invokeLL.booleanValue;
    }

    public String[] getFallbackIps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (HiidoSDK.isDebugMode) {
                return TConst.TEST_IP;
            }
            String str = this.testServer;
            return (str == null || str.length() == 0) ? getUrlAddress() : new String[0];
        }
        return (String[]) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public Throwable getLastError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mThrowable : (Throwable) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public int getLastStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.statusCode : invokeV.intValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public int getLastTryTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.lastTryTimes : invokeV.intValue;
    }

    public String getServerAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (HiidoSDK.isDebugMode) {
                return TConst.TEST_URL;
            }
            String str = this.testServer;
            String urlService = (str == null || str.length() == 0) ? getUrlService() : this.testServer;
            L.brief("return hiido server %s", urlService);
            return urlService;
        }
        return (String) invokeV.objValue;
    }

    public abstract String[] getUrlAddress();

    public abstract String getUrlFormat();

    public abstract String getUrlService();

    public boolean post(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) ? postByUrlConn(str, str2) : invokeLL.booleanValue;
    }

    public abstract boolean sendContent(String str, String str2, int i2);

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public boolean sendSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            L.brief("to send content %s", str);
            return sendSyncByTrying(str);
        }
        return invokeL.booleanValue;
    }

    public boolean sendSyncByTrying(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            CacheIp cacheIp = this.mCacheIp;
            if (cacheIp != null) {
                if (cacheIp.isValid() && this.mCacheIp.getIp() != null && !this.mCacheIp.getIp().isEmpty()) {
                    if (sendContent(asUrl(this.mCacheIp.getIp()), str, 0)) {
                        this.mCacheIp.inc();
                        return true;
                    }
                    this.mCacheIp.reset(null);
                } else {
                    this.mCacheIp.reset(null);
                }
            }
            if (sendContent(getServerAddr(), str, this.mRetryTimeHost)) {
                return true;
            }
            String[] fallbackIps = getFallbackIps();
            if (L.isLogOn() && L.outputDebug()) {
                L.brief("fallback IPs : %s", TextUtils.join(" ", fallbackIps));
            }
            if (fallbackIps != null && fallbackIps.length != 0) {
                int i2 = this.mTryTimeIp;
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    int nextInt = new Random().nextInt(fallbackIps.length);
                    if (fallbackIps[nextInt] != null && !fallbackIps[nextInt].isEmpty() && sendContent(asUrl(fallbackIps[nextInt]), str, 0)) {
                        CacheIp cacheIp2 = this.mCacheIp;
                        if (cacheIp2 != null) {
                            cacheIp2.reset(fallbackIps[nextInt]);
                            this.mCacheIp.inc();
                        }
                        return true;
                    }
                    i2 = i3;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setCacheIp(CacheIp cacheIp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cacheIp) == null) {
            this.mCacheIp = cacheIp;
        }
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setLastTryTimes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.lastTryTimes = i2;
        }
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setRetryTimeHost(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mRetryTimeHost = i2;
        }
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setTestServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.testServer = str;
        }
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setTryTimeIp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mTryTimeIp = i2;
        }
    }
}
