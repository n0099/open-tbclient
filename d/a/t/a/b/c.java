package d.a.t.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.a.t.a.a.d;
import d.a.t.a.a.g;
import d.a.t.a.f.b;
import d.a.t.a.h.e;
import d.a.t.a.h.f;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class c implements b.a, Observer {

    /* renamed from: h  reason: collision with root package name */
    public static volatile d.a.t.a.b.b f68264h = new d.a.t.a.b.b();

    /* renamed from: i  reason: collision with root package name */
    public static volatile c f68265i;

    /* renamed from: e  reason: collision with root package name */
    public Context f68266e;

    /* renamed from: f  reason: collision with root package name */
    public int f68267f = -1;

    /* renamed from: g  reason: collision with root package name */
    public b f68268g;

    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e("netchange");
            }
        }

        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e.a("LCPClientManager", "NetStatusReceiver changed");
            if (RequsetNetworkUtils.isNetworkAvailable(context) && f.m(context)) {
                e.b("LCPClientManager", "NetStatusReceiver reconnect");
                d.a.t.a.g.a.a(context).b(new a());
            }
        }
    }

    static {
        new LinkedHashMap();
    }

    public c() {
        new LinkedBlockingQueue();
    }

    public static synchronized c f() {
        c cVar;
        synchronized (c.class) {
            if (f68265i == null) {
                synchronized (c.class) {
                    if (f68265i == null) {
                        f68265i = new c();
                    }
                }
            }
            cVar = f68265i;
        }
        return cVar;
    }

    public static int g() {
        return f68264h.f68263a;
    }

    @Override // d.a.t.a.f.b.a
    public void a(String str) {
        d.a.t.a.a.a.h(this.f68266e).g(601110).d("P3", "accessToken success").d("con_err_code", "P3");
        this.f68267f = -1;
        l(0);
    }

    public void c(Context context, String str, String str2, int i2, String str3) {
        if (f68264h.f68263a != -2 && f68264h.f68263a != 0) {
            if (!TextUtils.isEmpty(str3) && UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE.equals(str3)) {
                d.h(context).f();
            }
            d(context, str, str2, i2, str3);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SocketConnect state is ");
        sb.append(f68264h.f68263a == 0 ? "connected" : "connecting");
        e.a("LCPClientManager", sb.toString());
    }

    public synchronized void d(Context context, String str, String str2, int i2, String str3) {
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
            this.f68266e = context;
            if (TextUtils.isEmpty(f.b(context))) {
                f.q(context, str);
            }
            if (TextUtils.isEmpty(f.e(context))) {
                f.s(context, str2);
            }
            d.a.t.a.c.f.S(context).addObserver(f68265i);
            if (f68264h.f68263a != -2 && f68264h.f68263a != 0) {
                if (this.f68268g == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    b bVar = new b();
                    this.f68268g = bVar;
                    context.registerReceiver(bVar, intentFilter);
                }
                if (g.f(context) && !d.i().booleanValue()) {
                    d.h(context).e(context, String.valueOf(601110), 10);
                    g.m(context, i2);
                }
                if (!f.k(context)) {
                    if (this.f68267f < 0) {
                        d.a.t.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3).c("token_begin", System.currentTimeMillis());
                        m();
                    }
                    return;
                }
                e.b("LCPClientManager", "token is not null ");
                d.a.t.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3);
                l(0);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SocketConnect state is ");
            sb.append(f68264h.f68263a == 0 ? "connected" : "connecting");
            e.a("LCPClientManager", sb.toString());
            return;
        }
        e.a("LCPClientManager", "flow 参数错误、网络错误无法连接 增加打点");
        d.a.t.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("P0", "connect param not correct or net unconnected").d("con_err_code", "P0").c("flow_end_time", System.currentTimeMillis()).d("source", str3).e();
    }

    public final void e(String str) {
        Context context = this.f68266e;
        c(context, f.b(context), f.e(this.f68266e), g.c(this.f68266e), str);
    }

    public void h(@NonNull BLCPRequest bLCPRequest, @Nullable d.a.t.a.b.d.b bVar) {
        Context context = this.f68266e;
        if (context == null || !f.m(context)) {
            if (bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6365a, bLCPRequest.f6366b, bLCPRequest.f6368d, new byte[0]);
            }
        } else if (f68264h.f68263a != 0) {
            if (!(bLCPRequest instanceof d.a.t.a.b.d.a) && bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6365a, bLCPRequest.f6366b, bLCPRequest.f6368d, new byte[0]);
            }
            if (f68264h.f68263a == -1 || !k()) {
                e("invoke");
            }
        } else {
            d.a.t.a.c.f.S(this.f68266e).H(bLCPRequest, bVar);
            if (bLCPRequest.f6366b == 1 && bLCPRequest.f6365a == 4) {
                e.a("LCPClientManager", "云控登录打点");
                Context context2 = this.f68266e;
                d.a.t.a.h.b.a(context2, 1L, "invoke", bLCPRequest.f6368d + "");
            }
            if (bLCPRequest.f6366b == 50 && bLCPRequest.f6365a == 2) {
                Context context3 = this.f68266e;
                d.a.t.a.h.b.a(context3, 50L, "invoke", bLCPRequest.f6368d + "");
            }
        }
    }

    public void i() {
        Context context = this.f68266e;
        if (context != null) {
            d.a.t.a.c.f.S(context).b0();
        }
    }

    public void j(Context context) {
        if (context != null) {
            this.f68266e = context;
        }
    }

    public final boolean k() {
        Context context = this.f68266e;
        return context == null || d.a.t.a.c.f.S(context).R().f68263a != -1;
    }

    public final void l(int i2) {
        Context context = this.f68266e;
        if (context == null || !f.m(context)) {
            return;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            e.a("LCPClientManager", "socketAction closeSocket");
            d.a.t.a.c.f.S(this.f68266e).i0("socketAction closeSocket:", d.a.t.a.c.f.S(this.f68266e).x);
            return;
        }
        e.a("LCPClientManager", "socketAction createSocket");
        f68264h.f68263a = -2;
        d.a.t.a.a.a.h(this.f68266e).g(601110).d("P8", "socketAction createSocket").d("con_err_code", "P8");
        d.a.t.a.c.f.S(this.f68266e).h0();
    }

    public void m() {
        Context context;
        Context context2 = this.f68266e;
        if (context2 != null && RequsetNetworkUtils.isConnected(context2)) {
            this.f68267f++;
            d.a.t.a.a.a.h(this.f68266e).g(601110).b("token_count", this.f68267f);
            e.a("LCPClientManager", "no token, so request token, and tryCount = " + this.f68267f);
            if (this.f68267f < 3) {
                d.a.t.a.f.b bVar = new d.a.t.a.f.b(this.f68266e, this);
                d.a.t.a.f.c.e(bVar, bVar);
                return;
            }
            this.f68267f = -1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("context = ");
        sb.append(this.f68266e);
        sb.append(", net :");
        sb.append(this.f68266e == null ? "" : Boolean.valueOf(!RequsetNetworkUtils.isConnected(context)));
        e.a("LCPClientManager", sb.toString());
        d.a.t.a.a.a.h(this.f68266e).g(601110).d("P1", "token request net unconnected").d("con_err_code", "P1").c("flow_end_time", System.currentTimeMillis()).e();
    }

    @Override // d.a.t.a.f.b.a
    public void onFailure(int i2, String str) {
        e.b("LCPClientManager", "getToken :" + str);
        d.a.t.a.a.c g2 = d.a.t.a.a.a.h(this.f68266e).g(601110);
        g2.d("P4", "getToken errCode:" + i2 + ",errMsg:" + str).d("con_err_code", "P4");
        m();
        if (this.f68267f == 2) {
            d.a.t.a.a.c c2 = d.a.t.a.a.a.h(this.f68266e).g(601110).c("flow_end_time", System.currentTimeMillis());
            c2.d("P5", "token request count is max:" + this.f68267f).d("con_err_code", "P5").e();
            f68264h.f68263a = -1;
            d.a.t.a.c.f.S(this.f68266e).Z();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof d.a.t.a.b.b) {
            f68264h.f68263a = ((d.a.t.a.b.b) obj).f68263a;
            e.a("LCPClientManager", "Manager update connectState :" + f68264h.f68263a);
        }
    }
}
