package d.a.o0.z2;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import okhttp3.EventListener;
import okhttp3.Request;
@Singleton
@Service
/* loaded from: classes5.dex */
public class i implements IHttpContext {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67641b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f67642c;

    /* renamed from: a  reason: collision with root package name */
    public Context f67643a = AppRuntime.getAppContext();

    static {
        boolean isDebug = AppConfig.isDebug();
        f67641b = isDebug;
        f67641b = isDebug;
        f67642c = i.class.getSimpleName();
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest) {
        return false;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public CookieManager getCookieManager(boolean z, boolean z2) {
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public EventListener getEventListener() {
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public int getFallbackConnectDelayMs() {
        return 0;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
        if (f67641b) {
            String str = f67642c;
            Log.i(str, "baidunetwork HttpContext getNewCloneHttpDns httpRequest:" + httpRequest);
            return null;
        }
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewHttpDns() {
        if (f67641b) {
            Log.i(f67642c, "baidunetwork HttpContext getNewHttpDns!");
            return null;
        }
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public NetworkStat<Request> getNewNetworkStat() {
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void init() {
        if (f67641b) {
            Log.i(f67642c, "baidunetwork HttpContext init!");
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void prefetchDnsResult(String str) {
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
    }
}
