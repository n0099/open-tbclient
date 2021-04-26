package d.a.s.a.b;

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
import d.a.s.a.a.a;
import d.a.s.a.c.f;
import d.a.s.a.e.b;
import d.a.s.a.g.d;
import d.a.s.a.g.e;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class c implements b.a, Observer {

    /* renamed from: h  reason: collision with root package name */
    public static volatile d.a.s.a.b.b f63861h = new d.a.s.a.b.b();

    /* renamed from: i  reason: collision with root package name */
    public static volatile c f63862i;

    /* renamed from: e  reason: collision with root package name */
    public Context f63863e;

    /* renamed from: f  reason: collision with root package name */
    public int f63864f = -1;

    /* renamed from: g  reason: collision with root package name */
    public b f63865g;

    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e();
            }
        }

        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.a("LCPClientManager", "NetStatusReceiver changed");
            if (RequsetNetworkUtils.isNetworkAvailable(context) && e.m(context)) {
                d.b("LCPClientManager", "NetStatusReceiver reconnect");
                d.a.s.a.f.a.a(context).b(new a());
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
            if (f63862i == null) {
                synchronized (c.class) {
                    if (f63862i == null) {
                        f63862i = new c();
                    }
                }
            }
            cVar = f63862i;
        }
        return cVar;
    }

    public static int g() {
        return f63861h.f63860a;
    }

    @Override // d.a.s.a.e.b.a
    public void a(String str) {
        this.f63864f = -1;
        j(0);
        d.a.s.a.a.d.w(this.f63863e, "2Y", "accessToken success");
    }

    public void c(Context context, String str, String str2, int i2) {
        if (f63861h.f63860a != -2 && f63861h.f63860a != 0) {
            d(context, str, str2, i2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SocketConnect state is ");
        sb.append(f63861h.f63860a == 0 ? "connected" : "connecting");
        d.a("LCPClientManager", sb.toString());
    }

    public synchronized void d(Context context, String str, String str2, int i2) {
        String str3;
        a.d dVar;
        if (context != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                this.f63863e = context;
                if (TextUtils.isEmpty(e.b(context))) {
                    e.q(context, str);
                }
                if (TextUtils.isEmpty(e.e(context))) {
                    e.s(context, str2);
                }
                f.T(context).addObserver(f63862i);
                if (f63861h.f63860a != -2 && f63861h.f63860a != 0) {
                    if (this.f63865g == null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        b bVar = new b();
                        this.f63865g = bVar;
                        context.registerReceiver(bVar, intentFilter);
                    }
                    if (d.a.s.a.a.d.j(context)) {
                        String str4 = "1N";
                        long j = 0;
                        String str5 = "ext";
                        try {
                            String[] e2 = d.a.s.a.a.d.e(context);
                            if (e2.length >= 3) {
                                j = Long.valueOf(e2[0]).longValue();
                                str4 = e2[1];
                                str5 = e2[2];
                            }
                            dVar = new a.d(context);
                            dVar.e(String.valueOf(d.a.s.a.a.d.f(context)));
                            dVar.f(str4);
                            dVar.g(d.a.s.a.a.d.d(context));
                            dVar.h(j);
                            dVar.d(str5);
                            dVar.a(501110L);
                        } catch (Exception unused) {
                            d.b("LCPClientManager", "LcpTrack init request getLoginFlag Exception ");
                            dVar = new a.d(context);
                            dVar.e(String.valueOf(d.a.s.a.a.d.f(context)));
                            dVar.f(str4);
                            dVar.g(d.a.s.a.a.d.d(context));
                            dVar.h(j);
                            dVar.d(str3);
                            dVar.a(501110L);
                        }
                        dVar.b();
                        d.a.s.a.a.b.k(context);
                        d.a.s.a.a.d.v(context);
                        d.a.s.a.a.d.w(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                        d.a.s.a.a.d.x(context, i2);
                    }
                    if (!e.k(context)) {
                        if (this.f63864f < 0) {
                            k();
                        }
                        return;
                    }
                    d.b("LCPClientManager", "token is not null ");
                    j(0);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("SocketConnect state is ");
                sb.append(f63861h.f63860a == 0 ? "connected" : "connecting");
                d.a("LCPClientManager", sb.toString());
            }
        }
    }

    public final void e() {
        Context context = this.f63863e;
        c(context, e.b(context), e.e(this.f63863e), d.a.s.a.a.d.f(this.f63863e));
    }

    public void h(@NonNull BLCPRequest bLCPRequest, @Nullable d.a.s.a.b.d.b bVar) {
        Context context = this.f63863e;
        if (context == null || !e.m(context)) {
            if (bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6598a, bLCPRequest.f6599b, bLCPRequest.f6601d, new byte[0]);
            }
        } else if (f63861h.f63860a != 0) {
            if (!(bLCPRequest instanceof d.a.s.a.b.d.a) && bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6598a, bLCPRequest.f6599b, bLCPRequest.f6601d, new byte[0]);
            }
            if (f63861h.f63860a == -1) {
                e();
            }
        } else {
            f.T(this.f63863e).I(bLCPRequest, bVar);
            if (bLCPRequest.f6599b == 1 && bLCPRequest.f6598a == 4) {
                d.a("LCPClientManager", "云控登录打点");
                Context context2 = this.f63863e;
                d.a.s.a.g.a.a(context2, 1L, "invoke", bLCPRequest.f6601d + "");
            }
            if (bLCPRequest.f6599b == 50 && bLCPRequest.f6598a == 2) {
                Context context3 = this.f63863e;
                d.a.s.a.g.a.a(context3, 50L, "invoke", bLCPRequest.f6601d + "");
            }
        }
    }

    public void i() {
        Context context = this.f63863e;
        if (context != null) {
            f.T(context).c0();
        }
    }

    public final void j(int i2) {
        Context context = this.f63863e;
        if (context == null || !e.m(context)) {
            return;
        }
        if (i2 == 0) {
            d.a("LCPClientManager", "socketAction createSocket");
            f63861h.f63860a = -2;
            f.T(this.f63863e).i0();
        } else if (i2 != 1) {
        } else {
            d.a("LCPClientManager", "socketAction closeSocket");
            f.T(this.f63863e).j0("socketAction closeSocket:", f.T(this.f63863e).x);
        }
    }

    public void k() {
        Context context;
        Context context2 = this.f63863e;
        if (context2 != null && RequsetNetworkUtils.isConnected(context2)) {
            this.f63864f++;
            d.a("LCPClientManager", "no token, so request token, and tryCount = " + this.f63864f);
            if (this.f63864f < 3) {
                d.a.s.a.a.d.w(this.f63863e, "2N", "accessToken is null");
                d.a.s.a.e.b bVar = new d.a.s.a.e.b(this.f63863e, this);
                d.a.s.a.e.c.e(bVar, bVar);
                return;
            }
            this.f63864f = -1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("context = ");
        sb.append(this.f63863e);
        sb.append(", net :");
        sb.append(this.f63863e == null ? "" : Boolean.valueOf(!RequsetNetworkUtils.isConnected(context)));
        d.a("LCPClientManager", sb.toString());
    }

    @Override // d.a.s.a.e.b.a
    public void onFailure(int i2, String str) {
        d.b("LCPClientManager", "getToken :" + str);
        k();
        d.a.s.a.a.d.w(this.f63863e, "2N_1", "accessToken fail");
        if (this.f63864f == 2) {
            f63861h.f63860a = -1;
            f.T(this.f63863e).a0();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof d.a.s.a.b.b) {
            f63861h.f63860a = ((d.a.s.a.b.b) obj).f63860a;
            d.a("LCPClientManager", "Manager update connectState :" + f63861h.f63860a);
        }
    }
}
