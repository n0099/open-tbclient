package d.b.h0.a.e0.s;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.f2.d;
import d.b.h0.a.i2.p;
import d.b.h0.a.j1.i;
import d.b.h0.a.k;
import d.b.h0.a.t.c.h.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44983e = k.f45772a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f44984f = null;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44985g;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public volatile String f44986a = null;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public volatile String f44987b = null;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f44988c = false;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f44989d = new LinkedHashMap();

    /* renamed from: d.b.h0.a.e0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0714a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppConfigData f44990e;

        public RunnableC0714a(SwanAppConfigData swanAppConfigData) {
            this.f44990e = swanAppConfigData;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h(this.f44990e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements StatResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44992a;

        public b(String str) {
            this.f44992a = str;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            if (a.f44983e) {
                Log.d("SwanPrelink", "doPrelink: onFail: " + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
            if (a.f44983e) {
                Log.d("SwanPrelink", "doPrelink: onSuccess: " + i);
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            if (a.f44983e) {
                StringBuilder sb = new StringBuilder();
                sb.append("doPrelink: parseResponse: url: ");
                sb.append(this.f44992a);
                sb.append(" response: ");
                sb.append(response == null ? StringUtil.NULL_STRING : Integer.valueOf(response.code()));
                Log.d("SwanPrelink", sb.toString());
            }
            if (networkStatRecord != null) {
                long j = networkStatRecord.dnsEndTs - networkStatRecord.dnsStartTs;
                long j2 = networkStatRecord.connTs - networkStatRecord.startTs;
                if (a.f44983e) {
                    Log.d("SwanPrelink", "doPrelink: hit: url: " + this.f44992a + " firstPrelinkUrlHost: " + a.this.f44986a);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("doPrelink: networkStatRecord: \n");
                    sb2.append(networkStatRecord.toUBCJson());
                    Log.d("SwanPrelink", sb2.toString());
                    Log.d("SwanPrelink", "doPrelink: isConnReused: " + networkStatRecord.isConnReused);
                    Log.d("SwanPrelink", "doPrelink: dnsTime: " + j + " connTime: " + j2);
                }
                int code = response != null ? response.code() : 0;
                a aVar = a.this;
                aVar.l("预连接请求返回", "code=" + code + " dns解析时长=" + j + "ms 网络连接时长=" + j2 + "ms url=" + this.f44992a);
            }
            return response;
        }
    }

    static {
        d.b.h0.a.w0.a.N().getSwitch("swan_hot_start_prelink_switch", false);
        f44985g = false;
    }

    public static a e() {
        if (f44984f == null) {
            synchronized (a.class) {
                if (f44984f == null) {
                    f44984f = new a();
                }
            }
        }
        return f44984f;
    }

    public final void d(@NonNull String str) {
        if (f44983e) {
            Log.d("SwanPrelink", "doPrelink: " + str);
        }
        d.b.h0.k.d.a aVar = new d.b.h0.k.d.a();
        aVar.f49601b = "HEAD";
        HttpRequestBuilder a2 = d.b.h0.k.e.b.a(aVar);
        a2.setHeader("Referer", c.d());
        aVar.f49600a = str;
        aVar.f49605f = true;
        aVar.f49606g = false;
        aVar.f49607h = true;
        d.b.h0.k.e.a.f().s(a2, aVar);
        HttpRequest build = a2.enableStat(true).build();
        l("校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
        build.executeStat(new b(str));
    }

    public final boolean f() {
        return this.f44986a != null;
    }

    public void g(@NonNull String str, @NonNull HttpUrl httpUrl) {
        if (f() && this.f44987b == null) {
            if (!TextUtils.equals(httpUrl.host(), this.f44986a)) {
                if (f44983e) {
                    Log.d("SwanPrelink", "onBusinessRequest: miss: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.f44986a);
                    return;
                }
                return;
            }
            this.f44987b = str;
            if (f44983e) {
                Log.d("SwanPrelink", "onBusinessRequest: hit: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.f44986a);
            }
            l("业务方触发第一个同域名请求", "url=" + httpUrl);
        }
    }

    public final void h(@NonNull SwanAppConfigData swanAppConfigData) {
        if (f44983e) {
            Log.d("SwanPrelink", "start prelink");
        }
        SwanAppConfigData.d dVar = swanAppConfigData.j;
        if (dVar == null) {
            if (f44983e) {
                Log.d("SwanPrelink", "prelink: prelink config is null");
            }
            l("校验失败", "app.json 中未配置 prelinks");
            return;
        }
        ArrayList<String> arrayList = dVar.f12293a;
        if (arrayList == null) {
            if (f44983e) {
                Log.d("SwanPrelink", "prelink: prelink config urls are null");
            }
            l("校验失败", "app.json 中未配置 prelinks");
            return;
        }
        int size = arrayList.size();
        if (size <= 0) {
            if (f44983e) {
                Log.d("SwanPrelink", "prelink: prelink config urls are empty");
            }
            l("校验失败", "配置的 prelinks 内容为空");
            return;
        }
        if (f44983e) {
            Log.d("SwanPrelink", "prelink: urls " + arrayList.toString());
        }
        HttpUrl parse = HttpUrl.parse(arrayList.get(0));
        this.f44986a = parse == null ? null : parse.host();
        boolean p = d.b.h0.a.w0.a.N().p();
        if (f44983e) {
            Log.d("SwanPrelink", "prelink: isPrelinkEnable " + p);
        }
        if (!p) {
            if (f44983e) {
                Log.d("SwanPrelink", "prelink: miss prelink");
            }
            l("校验失败", "未命中 prelink ab 开关");
            return;
        }
        if (f44983e) {
            Log.d("SwanPrelink", "prelink: hit prelink");
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            String str = arrayList.get(i2);
            if (i >= 1) {
                if (f44983e) {
                    Log.w("SwanPrelink", "prelink: the number of prelink cannot exceed 1 url: " + str);
                    return;
                }
                return;
            }
            i++;
            if (TextUtils.isEmpty(str)) {
                if (f44983e) {
                    Log.w("SwanPrelink", "prelink: url cannot be empty");
                }
                l("校验失败", "配置的 url 为空");
            } else {
                HttpUrl e2 = c.e(str);
                if (e2 == null) {
                    if (f44983e) {
                        Log.w("SwanPrelink", "prelink: url cannot be " + str);
                    }
                    l("校验失败", "配置的 url 非法，参考 request api url 要求。url=" + str);
                } else {
                    String httpUrl = e2.toString();
                    if (d.b.h0.a.s1.a.b.c("request", httpUrl, "") != 0) {
                        if (f44983e) {
                            Log.w("SwanPrelink", "prelink: url check fail " + httpUrl);
                        }
                        l("校验失败", "配置的 url 非法，参考 request api url 要求。url=" + str);
                    } else {
                        d(httpUrl);
                    }
                }
            }
        }
    }

    public void i(SwanAppConfigData swanAppConfigData) {
        if (f44983e) {
            Log.d("SwanPrelink", "prelinkAsync: start prelinkAsync");
        }
        if (swanAppConfigData == null) {
            if (f44983e) {
                throw new RuntimeException("prelinkAsync: configData cannot be null");
            }
            return;
        }
        p.k(new RunnableC0714a(swanAppConfigData), "SwanPrelink");
    }

    public synchronized void j() {
        if (f44983e) {
            Log.d("SwanPrelink", "release: ");
        }
        if (f44984f == null) {
            return;
        }
        f44984f = null;
    }

    public void k() {
        if (f44983e) {
            this.f44987b = null;
            this.f44988c = false;
            this.f44986a = null;
        }
    }

    public synchronized void l(@NonNull String str, @NonNull String str2) {
        if (this.f44989d.containsKey(str)) {
            return;
        }
        this.f44989d.put(str, str2);
        d.k.d(m());
    }

    @NonNull
    public final synchronized String m() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("========== prelink start ==========");
        sb.append(Part.CRLF);
        for (Map.Entry<String, String> entry : this.f44989d.entrySet()) {
            if (entry != null) {
                sb.append("----- ");
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\r\n\r\n");
            }
        }
        sb.append("========== prelink end ==========");
        sb.append(Part.CRLF);
        return sb.toString();
    }

    public void n(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        HttpUrl httpUrl2;
        NetworkStatRecord networkStatRecord2;
        long j;
        long j2;
        if (!f() || this.f44988c || this.f44987b == null) {
            return;
        }
        if (!TextUtils.equals(this.f44987b, str)) {
            if (f44983e) {
                Log.d("SwanPrelink", "tryRecordNetworkStat: miss : tag: " + str + " firstBusinessRequestTag:" + this.f44987b + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.f44986a);
                return;
            }
            return;
        }
        this.f44988c = true;
        if (networkStatRecord == null) {
            if (f44983e) {
                Log.w("SwanPrelink", "tryRecordNetworkStat: networkStateRecord cannot be null");
                return;
            }
            return;
        }
        long j3 = networkStatRecord.dnsEndTs;
        long j4 = networkStatRecord.dnsStartTs;
        long j5 = networkStatRecord.connTs;
        long j6 = networkStatRecord.startTs;
        long j7 = j3 - j4;
        long j8 = j5 - j6;
        if (f44983e) {
            StringBuilder sb = new StringBuilder();
            j = j3;
            sb.append("tryRecordNetworkStat: hit: tag: ");
            sb.append(str);
            sb.append(" firstBusinessRequestTag:");
            sb.append(this.f44987b);
            sb.append(" url: ");
            httpUrl2 = httpUrl;
            j2 = j7;
            sb.append(httpUrl2);
            sb.append(" firstPrelinkUrlHost: ");
            sb.append(this.f44986a);
            Log.d("SwanPrelink", sb.toString());
            Log.d("SwanPrelink", "tryRecordNetworkStat: networkStatRecord: \n" + networkStatRecord.toUBCJson());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("tryRecordNetworkStat: isConnReused: ");
            networkStatRecord2 = networkStatRecord;
            sb2.append(networkStatRecord2.isConnReused);
            Log.d("SwanPrelink", sb2.toString());
            Log.d("SwanPrelink", "tryRecordNetworkStat: dnsTime: " + j2 + " connTime: " + j8);
        } else {
            httpUrl2 = httpUrl;
            networkStatRecord2 = networkStatRecord;
            j = j3;
            j2 = j7;
        }
        l("业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord2.isConnReused + " dns解析时长=" + j2 + "ms 网络连接时长=" + j8 + "ms url=" + httpUrl2);
        HybridUbcFlow o = i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
        ubcFlowEvent.h(j6);
        o.A(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
        ubcFlowEvent2.h(j5);
        o.A(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
        ubcFlowEvent3.h(j4);
        o.A(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
        ubcFlowEvent4.h(j);
        o.A(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("request_network_response");
        ubcFlowEvent5.h(networkStatRecord2.responseTs);
        o.A(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("request_send_header");
        ubcFlowEvent6.h(networkStatRecord2.sendHeaderTs);
        o.A(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_receive_header");
        ubcFlowEvent7.h(networkStatRecord2.receiveHeaderTs);
        o.A(ubcFlowEvent7);
    }
}
