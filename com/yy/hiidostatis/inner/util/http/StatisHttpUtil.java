package com.yy.hiidostatis.inner.util.http;

import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes2.dex */
public class StatisHttpUtil extends AbstractStatisHttpUtil {
    public static final String[] ADDRESSES = {"183.61.2.91", "183.61.2.92", "183.61.2.93", "183.61.2.94", "183.61.2.95", "183.61.2.96", "183.61.2.97", "183.61.2.98"};
    public static final String URL_FORMAT = "http://%s/c.gif";
    public static final String URL_SERVICE = "";
    public String body;
    public String urlParams;

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public String getHost() {
        return "";
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlFormat() {
        return "http://%s/c.gif";
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlService() {
        return "";
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String[] getUrlAddress() {
        return ADDRESSES;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public boolean sendContent(String str, String str2, int i) {
        L.brief("hiido service address is %s", str);
        this.mThrowable = null;
        int i2 = i;
        while (true) {
            try {
            } catch (Throwable th) {
                this.mThrowable = th;
                L.debug("StatisHttpUtil", "guid:%s. http statis exception %s", Util.parseParam(str2, BaseStatisContent.GUID), th);
            }
            if (getLastTryTimes() > 0 && !ArdUtil.isNetworkReach()) {
                L.debug(this, "isNetworkReach false.", new Object[0]);
                return false;
            }
            if (i != i2) {
                L.brief("Try again to send %s with url %s, tried times %d.", str2, str, Integer.valueOf(i - i2));
            }
            this.lastTryTimes++;
            if (!get(str, str2)) {
                L.debug(this, "Failed to send %s to %s.", str2, str);
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    return false;
                }
                i2 = i3;
            } else {
                this.mThrowable = null;
                L.debug(this, "Successfully sent %s to %s", str2, str);
                return true;
            }
        }
    }
}
