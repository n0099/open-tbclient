package d.a.m0.a.h0.q;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.searchbox.v8engine.net.NetRequestCallback;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.k;
import d.a.m0.a.u.e.j.d;
import d.a.m0.a.u.e.j.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46306g = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f46307h = null;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f46309b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f46310c;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f46308a = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f46311d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f46312e = false;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f46313f = new AtomicInteger(0);

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46315f;

        public a(String str, boolean z) {
            this.f46314e = str;
            this.f46315f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Set<String> g2 = d.a.m0.a.b2.a.c.g(this.f46314e);
            int i2 = 0;
            if (b.f46306g) {
                StringBuilder sb = new StringBuilder();
                sb.append("startPreLink appId=");
                sb.append(this.f46314e);
                sb.append(" preLinkSet=");
                sb.append(g2 == null ? 0 : g2.size());
                sb.append(", hotLaunch=");
                sb.append(this.f46315f);
                Log.d("SwanPrelink", sb.toString());
            }
            if (g2 != null && !g2.isEmpty()) {
                b.this.f46308a.clear();
                b.this.f46313f.set(0);
                b.this.f46309b = new ArrayList(g2);
                for (String str : g2) {
                    if (!TextUtils.isEmpty(str)) {
                        if (i2 >= 5) {
                            return;
                        }
                        String e2 = h.e(str);
                        if (!TextUtils.isEmpty(e2)) {
                            b.this.f46308a.add(e2);
                            b.this.f(i2, str, e2, true);
                            i2++;
                        }
                    }
                }
                return;
            }
            b.this.r("校验失败", "请在开发者后台配置 prelink");
        }
    }

    /* renamed from: d.a.m0.a.h0.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0756b implements StatResponseCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46318f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46319g;

        public C0756b(String str, boolean z, int i2) {
            this.f46317e = str;
            this.f46318f = z;
            this.f46319g = i2;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            if (b.f46306g) {
                Log.w("SwanPrelink", "doPrelink: onFail: " + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
            if (b.f46306g) {
                Log.i("SwanPrelink", "doPrelink: onSuccess: " + i2);
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            if (b.f46306g) {
                StringBuilder sb = new StringBuilder();
                sb.append("doPrelink: parseResponse: url: ");
                sb.append(this.f46317e);
                sb.append(" response: ");
                sb.append(response == null ? StringUtil.NULL_STRING : Integer.valueOf(response.code()));
                Log.i("SwanPrelink", sb.toString());
            }
            if (networkStatRecord != null) {
                long j = networkStatRecord.dnsEndTs - networkStatRecord.dnsStartTs;
                long j2 = networkStatRecord.connTs - networkStatRecord.startTs;
                if (b.f46306g) {
                    Log.d("SwanPrelink", "doPrelink: hit: url: " + this.f46317e);
                    Log.d("SwanPrelink", "doPrelink: isConnReused: " + networkStatRecord.isConnReused);
                    Log.d("SwanPrelink", "doPrelink: dnsTime: " + j + " connTime: " + j2);
                }
                int code = response != null ? response.code() : 0;
                if (this.f46318f) {
                    b bVar = b.this;
                    int i3 = this.f46319g;
                    bVar.q(i3, "预连接请求返回", "code=" + code + " dns解析时长=" + j + "ms 网络连接时长=" + j2 + "ms url=" + this.f46317e);
                }
            }
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements NetRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f46321a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f46322b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46323c;

        public c(boolean z, int i2, String str) {
            this.f46321a = z;
            this.f46322b = i2;
            this.f46323c = str;
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onFailed(int i2, String str) {
            if (this.f46321a) {
                b bVar = b.this;
                int i3 = this.f46322b;
                bVar.q(i3, "预连接请求返回", "code=" + i2 + " msg=" + str);
            }
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onSucceeded(String str, int i2, Map<String, String> map) {
            if (this.f46321a) {
                b bVar = b.this;
                int i3 = this.f46322b;
                bVar.q(i3, "预连接请求返回", "code=" + i2 + " url=" + this.f46323c);
            }
        }
    }

    public static b g() {
        if (f46307h == null) {
            synchronized (b.class) {
                if (f46307h == null) {
                    f46307h = new b();
                }
            }
        }
        return f46307h;
    }

    @WorkerThread
    public final void f(int i2, @NonNull String str, @NonNull String str2, boolean z) {
        if (f46306g) {
            Log.d("SwanPrelink", "doPrelink: " + str);
        }
        if (d.b()) {
            j(i2, str, str2, z);
            return;
        }
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a();
        aVar.f51752b = "HEAD";
        HttpRequestBuilder a2 = d.a.m0.m.e.b.a(aVar);
        a2.setHeader("Referer", h.d());
        aVar.f51751a = str;
        aVar.f51756f = true;
        aVar.f51757g = false;
        aVar.f51758h = true;
        d.a.m0.m.e.a.g().t(a2, aVar);
        HttpRequest build = a2.enableStat(true).build();
        if (z) {
            q(i2, "校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
        }
        build.executeStat(new C0756b(str, z, i2));
    }

    public Set<String> h(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptySet();
        }
        Set<String> g2 = d.a.m0.a.b2.a.c.g(str);
        if (g2 == null) {
            return Collections.emptySet();
        }
        if (g2.size() <= 5 || !z) {
            return g2;
        }
        int i2 = 0;
        HashSet hashSet = new HashSet(5);
        for (String str2 : g2) {
            if (!TextUtils.isEmpty(str2)) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                hashSet.add(str2);
                i2 = i3;
            }
        }
        return hashSet;
    }

    public final boolean i() {
        return !this.f46308a.isEmpty();
    }

    public final void j(int i2, @NonNull String str, @NonNull String str2, boolean z) {
        d.a.m0.a.h0.l.a P = g.N().P();
        if (P == null || !(P.g() instanceof d.a.m0.a.l0.a)) {
            return;
        }
        NetRequestParam.Builder builder = new NetRequestParam.Builder();
        builder.setUrl(str);
        builder.setMethod((byte) 2);
        NetRequestParam build = builder.build();
        build.setNetRequestCallback(new c(z, i2, str));
        d.a.m0.a.l0.a aVar = (d.a.m0.a.l0.a) P.g();
        if (aVar.n0() != null) {
            if (z) {
                q(i2, "校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
            }
            aVar.n0().execute(build);
        }
    }

    public synchronized void k(@NonNull String str, @NonNull String str2) {
        if (i()) {
            if (this.f46313f.get() == this.f46308a.size()) {
                if (f46306g) {
                    Log.d("SwanPrelink", "onBusinessRequest doRequest: " + str2);
                }
            } else if (this.f46309b == null || !this.f46309b.contains(str2)) {
                String e2 = h.e(str2);
                if (e2 != null && this.f46308a.contains(e2)) {
                    if (this.f46310c == null) {
                        this.f46310c = new ArrayMap();
                    } else if (this.f46310c.containsKey(e2)) {
                        return;
                    }
                    this.f46310c.put(e2, str);
                    if (f46306g) {
                        Log.i("SwanPrelink", "onBusinessRequest hit: " + str2);
                    }
                    q(this.f46310c.size() - 1, "业务方触发第一个同域名请求", "url=" + str2);
                    return;
                }
                if (f46306g) {
                    Log.d("SwanPrelink", "onBusinessRequest: miss tag " + str2);
                }
            }
        }
    }

    public synchronized void l(@NonNull String str, @NonNull HttpUrl httpUrl) {
        if (i()) {
            if (this.f46313f.get() == this.f46308a.size()) {
                if (f46306g) {
                    Log.d("SwanPrelink", "onBusinessRequest doRequest: " + httpUrl);
                }
                return;
            }
            String host = httpUrl.host();
            if (host != null && this.f46308a.contains(host)) {
                if (this.f46310c == null) {
                    this.f46310c = new ArrayMap();
                } else if (this.f46310c.containsKey(host)) {
                    return;
                }
                this.f46310c.put(host, str);
                if (f46306g) {
                    Log.i("SwanPrelink", "onBusinessRequest hit: " + httpUrl);
                }
                q(this.f46310c.size() - 1, "业务方触发第一个同域名请求", "url=" + httpUrl);
                return;
            }
            if (f46306g) {
                Log.d("SwanPrelink", "onBusinessRequest: miss tag " + httpUrl.toString());
            }
        }
    }

    @WorkerThread
    public void m(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46306g) {
                Log.w("SwanPrelink", "prelink url is empty");
                return;
            }
            return;
        }
        String e2 = h.e(str);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        f(-1, str, e2, false);
    }

    public synchronized void n() {
        if (f46306g) {
            Log.d("SwanPrelink", "release");
        }
        if (f46307h == null) {
            return;
        }
        f46307h = null;
    }

    public void o() {
        if (f46306g) {
            this.f46308a.clear();
            this.f46310c = null;
        }
    }

    @AnyThread
    public synchronized void p(@Nullable String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            if (f46306g) {
                Log.w("SwanPrelink", "startPreLink appId empty");
            }
        } else if (!z && this.f46312e) {
            if (f46306g) {
                Log.d("SwanPrelink", "startPreLink already");
            }
        } else {
            this.f46312e = true;
            ExecutorUtilsExt.postOnElastic(new a(str, z), "SwanPrelink", 0);
        }
    }

    public synchronized void q(@IntRange(from = -1) int i2, @NonNull String str, @NonNull String str2) {
        if (i2 >= 0) {
            str = PreferencesUtil.LEFT_MOUNT + i2 + PreferencesUtil.RIGHT_MOUNT + str;
        }
        if (this.f46311d.containsKey(str)) {
            return;
        }
        this.f46311d.put(str, str2);
        d.a.m0.a.q2.d.k.d(s());
    }

    public synchronized void r(@NonNull String str, @NonNull String str2) {
        q(-1, str, str2);
    }

    @NonNull
    public final synchronized String s() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("========== prelink start ==========");
        sb.append(Part.CRLF);
        for (Map.Entry<String, String> entry : this.f46311d.entrySet()) {
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

    public void t(@NonNull String str, @NonNull String str2, @NonNull NetInfo netInfo) {
        HybridUbcFlow d2;
        if (i() && this.f46310c != null && this.f46313f.get() != this.f46308a.size() && this.f46310c.containsValue(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("url=");
            sb.append(str2);
            sb.append("; ");
            if (netInfo.getSocket() != null) {
                sb.append("连接是否复用=");
                sb.append(netInfo.getSocket().mReused);
                sb.append("; ");
            }
            NetInfo.Timing timing = netInfo.getTiming();
            if (timing != null) {
                sb.append("DNS耗时=");
                sb.append(timing.mDns / 1000);
                sb.append("ms; ");
                sb.append("连接耗时=");
                sb.append(timing.mConnect / 1000);
                sb.append("ms; ");
            }
            q(this.f46313f.incrementAndGet() - 1, "业务方第一个同域名请求返回", sb.toString());
            if (this.f46313f.get() != 1 || (d2 = d.a.m0.a.r1.h.d("startup")) == null || timing == null) {
                return;
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
            ubcFlowEvent.h(0L);
            d2.C(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
            ubcFlowEvent2.h(timing.mConnect / 1000);
            d2.C(ubcFlowEvent2);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
            ubcFlowEvent3.h(0L);
            d2.C(ubcFlowEvent3);
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
            ubcFlowEvent4.h(timing.mDns / 1000);
            d2.C(ubcFlowEvent4);
        }
    }

    public void u(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        long j;
        if (!i() || networkStatRecord == null || this.f46310c == null || this.f46313f.get() == this.f46308a.size()) {
            return;
        }
        synchronized (b.class) {
            if (this.f46310c.containsValue(str)) {
                this.f46313f.incrementAndGet();
                long j2 = networkStatRecord.dnsEndTs;
                long j3 = networkStatRecord.dnsStartTs;
                long j4 = networkStatRecord.connTs;
                long j5 = networkStatRecord.startTs;
                long j6 = j2 - j3;
                long j7 = (j4 - j5) - j6;
                if (f46306g) {
                    j = j2;
                    Log.i("SwanPrelink", "tryRecordNetworkStat: " + httpUrl);
                    Log.i("SwanPrelink", "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused);
                    Log.i("SwanPrelink", "tryRecordNetworkStat: dnsTime: " + j6 + " connTime: " + j7);
                } else {
                    j = j2;
                }
                q(this.f46313f.get() - 1, "业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord.isConnReused + " dns解析时长=" + j6 + "ms 网络连接时长=" + j7 + "ms url=" + httpUrl);
                if (this.f46313f.get() <= 1) {
                    HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
                    ubcFlowEvent.h(j5);
                    p.C(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
                    ubcFlowEvent2.h(j4);
                    p.C(ubcFlowEvent2);
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
                    ubcFlowEvent3.h(j3);
                    p.C(ubcFlowEvent3);
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
                    ubcFlowEvent4.h(j);
                    p.C(ubcFlowEvent4);
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("request_network_response");
                    ubcFlowEvent5.h(networkStatRecord.responseTs);
                    p.C(ubcFlowEvent5);
                    UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("request_send_header");
                    ubcFlowEvent6.h(networkStatRecord.sendHeaderTs);
                    p.C(ubcFlowEvent6);
                    UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_receive_header");
                    ubcFlowEvent7.h(networkStatRecord.receiveHeaderTs);
                    p.C(ubcFlowEvent7);
                    p.A("connResued", String.valueOf(networkStatRecord.isConnReused));
                }
            }
        }
    }
}
