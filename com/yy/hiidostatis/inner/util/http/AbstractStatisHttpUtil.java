package com.yy.hiidostatis.inner.util.http;

import android.text.TextUtils;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.TConst;
import com.yy.hiidostatis.inner.util.http.HttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.util.Random;
/* loaded from: classes10.dex */
public abstract class AbstractStatisHttpUtil implements IStatisHttpUtil {
    public String lastRemoteIp;
    public int lastTryTimes;
    public CacheIp mCacheIp;
    public Throwable mThrowable;
    public String reasonPhrase;
    public int statusCode;
    public String testServer;
    public int mRetryTimeHost = 2;
    public int mTryTimeIp = 2;

    public abstract String[] getUrlAddress();

    public abstract String getUrlFormat();

    public abstract String getUrlService();

    public abstract boolean sendContent(String str, String str2, int i);

    public String[] getFallbackIps() {
        if (HiidoSDK.isDebugMode) {
            return TConst.TEST_IP;
        }
        String str = this.testServer;
        if (str != null && str.length() != 0) {
            return new String[0];
        }
        return getUrlAddress();
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public Throwable getLastError() {
        return this.mThrowable;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public int getLastStatusCode() {
        return this.statusCode;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public int getLastTryTimes() {
        return this.lastTryTimes;
    }

    public String getServerAddr() {
        String urlService;
        if (HiidoSDK.isDebugMode) {
            return TConst.TEST_URL;
        }
        String str = this.testServer;
        if (str != null && str.length() != 0) {
            urlService = this.testServer;
        } else {
            urlService = getUrlService();
        }
        L.brief("return hiido server %s", urlService);
        return urlService;
    }

    private boolean getByUrlConn(String str, String str2) throws IOException {
        this.statusCode = -1;
        this.reasonPhrase = null;
        HttpUtil.HttpResp byUrlConn = HttpUtil.getByUrlConn(str, str2);
        this.statusCode = byUrlConn.statusCode;
        this.reasonPhrase = byUrlConn.reason;
        return byUrlConn.isSucceed;
    }

    private boolean postByUrlConn(String str, String str2) throws IOException {
        this.statusCode = -1;
        this.reasonPhrase = null;
        HttpUtil.HttpResp postByUrlConn = HttpUtil.postByUrlConn(str, str2);
        this.statusCode = postByUrlConn.statusCode;
        this.reasonPhrase = postByUrlConn.reason;
        this.lastRemoteIp = postByUrlConn.remoteIp;
        return postByUrlConn.isSucceed;
    }

    public boolean get(String str, String str2) throws IOException {
        return getByUrlConn(str, str2);
    }

    public boolean post(String str, String str2) throws IOException {
        return postByUrlConn(str, str2);
    }

    public String asUrl(String str) {
        return String.format(getUrlFormat(), str);
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public boolean sendSync(String str) {
        L.brief("to send content %s", str);
        return sendSyncByTrying(str);
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setCacheIp(CacheIp cacheIp) {
        this.mCacheIp = cacheIp;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setLastTryTimes(int i) {
        this.lastTryTimes = i;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setRetryTimeHost(int i) {
        this.mRetryTimeHost = i;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setTestServer(String str) {
        this.testServer = str;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public void setTryTimeIp(int i) {
        this.mTryTimeIp = i;
    }

    public boolean sendSyncByTrying(String str) {
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
            int i = this.mTryTimeIp;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
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
                i = i2;
            }
        }
        return false;
    }
}
