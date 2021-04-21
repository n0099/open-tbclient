package d.b.s.a.b;

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
import d.b.s.a.a.a;
import d.b.s.a.c.f;
import d.b.s.a.e.b;
import d.b.s.a.g.d;
import d.b.s.a.g.e;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class c implements b.a, Observer {

    /* renamed from: h  reason: collision with root package name */
    public static volatile d.b.s.a.b.b f65540h = new d.b.s.a.b.b();
    public static volatile c i;

    /* renamed from: e  reason: collision with root package name */
    public Context f65541e;

    /* renamed from: f  reason: collision with root package name */
    public int f65542f = -1;

    /* renamed from: g  reason: collision with root package name */
    public b f65543g;

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
                d.b.s.a.f.a.a(context).b(new a());
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
            if (i == null) {
                synchronized (c.class) {
                    if (i == null) {
                        i = new c();
                    }
                }
            }
            cVar = i;
        }
        return cVar;
    }

    public static int g() {
        return f65540h.f65539a;
    }

    @Override // d.b.s.a.e.b.a
    public void a(String str) {
        this.f65542f = -1;
        j(0);
        d.b.s.a.a.d.w(this.f65541e, "2Y", "accessToken success");
    }

    public void c(Context context, String str, String str2, int i2) {
        if (f65540h.f65539a != -2 && f65540h.f65539a != 0) {
            d(context, str, str2, i2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SocketConnect state is ");
        sb.append(f65540h.f65539a == 0 ? "connected" : "connecting");
        d.a("LCPClientManager", sb.toString());
    }

    public synchronized void d(Context context, String str, String str2, int i2) {
        String str3;
        a.d dVar;
        if (context != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                this.f65541e = context;
                if (TextUtils.isEmpty(e.b(context))) {
                    e.q(context, str);
                }
                if (TextUtils.isEmpty(e.e(context))) {
                    e.s(context, str2);
                }
                f.T(context).addObserver(i);
                if (f65540h.f65539a != -2 && f65540h.f65539a != 0) {
                    if (this.f65543g == null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        b bVar = new b();
                        this.f65543g = bVar;
                        context.registerReceiver(bVar, intentFilter);
                    }
                    if (d.b.s.a.a.d.j(context)) {
                        String str4 = "1N";
                        long j = 0;
                        String str5 = "ext";
                        try {
                            String[] e2 = d.b.s.a.a.d.e(context);
                            if (e2.length >= 3) {
                                j = Long.valueOf(e2[0]).longValue();
                                str4 = e2[1];
                                str5 = e2[2];
                            }
                            dVar = new a.d(context);
                            dVar.e(String.valueOf(d.b.s.a.a.d.f(context)));
                            dVar.f(str4);
                            dVar.g(d.b.s.a.a.d.d(context));
                            dVar.h(j);
                            dVar.d(str5);
                            dVar.a(501110L);
                        } catch (Exception unused) {
                            d.b("LCPClientManager", "LcpTrack init request getLoginFlag Exception ");
                            dVar = new a.d(context);
                            dVar.e(String.valueOf(d.b.s.a.a.d.f(context)));
                            dVar.f(str4);
                            dVar.g(d.b.s.a.a.d.d(context));
                            dVar.h(j);
                            dVar.d(str3);
                            dVar.a(501110L);
                        }
                        dVar.b();
                        d.b.s.a.a.b.k(context);
                        d.b.s.a.a.d.v(context);
                        d.b.s.a.a.d.w(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                        d.b.s.a.a.d.x(context, i2);
                    }
                    if (!e.k(context)) {
                        if (this.f65542f < 0) {
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
                sb.append(f65540h.f65539a == 0 ? "connected" : "connecting");
                d.a("LCPClientManager", sb.toString());
            }
        }
    }

    public final void e() {
        Context context = this.f65541e;
        c(context, e.b(context), e.e(this.f65541e), d.b.s.a.a.d.f(this.f65541e));
    }

    public void h(@NonNull BLCPRequest bLCPRequest, @Nullable d.b.s.a.b.d.b bVar) {
        Context context = this.f65541e;
        if (context == null || !e.m(context)) {
            if (bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6413a, bLCPRequest.f6414b, bLCPRequest.f6416d, new byte[0]);
            }
        } else if (f65540h.f65539a != 0) {
            if (!(bLCPRequest instanceof d.b.s.a.b.d.a) && bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6413a, bLCPRequest.f6414b, bLCPRequest.f6416d, new byte[0]);
            }
            if (f65540h.f65539a == -1) {
                e();
            }
        } else {
            f.T(this.f65541e).I(bLCPRequest, bVar);
            if (bLCPRequest.f6414b == 1 && bLCPRequest.f6413a == 4) {
                d.a("LCPClientManager", "云控登录打点");
                Context context2 = this.f65541e;
                d.b.s.a.g.a.a(context2, 1L, "invoke", bLCPRequest.f6416d + "");
            }
            if (bLCPRequest.f6414b == 50 && bLCPRequest.f6413a == 2) {
                Context context3 = this.f65541e;
                d.b.s.a.g.a.a(context3, 50L, "invoke", bLCPRequest.f6416d + "");
            }
        }
    }

    public void i() {
        Context context = this.f65541e;
        if (context != null) {
            f.T(context).c0();
        }
    }

    public final void j(int i2) {
        Context context = this.f65541e;
        if (context == null || !e.m(context)) {
            return;
        }
        if (i2 == 0) {
            d.a("LCPClientManager", "socketAction createSocket");
            f65540h.f65539a = -2;
            f.T(this.f65541e).i0();
        } else if (i2 != 1) {
        } else {
            d.a("LCPClientManager", "socketAction closeSocket");
            f.T(this.f65541e).j0("socketAction closeSocket:", f.T(this.f65541e).x);
        }
    }

    public void k() {
        Context context;
        Context context2 = this.f65541e;
        if (context2 != null && RequsetNetworkUtils.isConnected(context2)) {
            this.f65542f++;
            d.a("LCPClientManager", "no token, so request token, and tryCount = " + this.f65542f);
            if (this.f65542f < 3) {
                d.b.s.a.a.d.w(this.f65541e, "2N", "accessToken is null");
                d.b.s.a.e.b bVar = new d.b.s.a.e.b(this.f65541e, this);
                d.b.s.a.e.c.e(bVar, bVar);
                return;
            }
            this.f65542f = -1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("context = ");
        sb.append(this.f65541e);
        sb.append(", net :");
        sb.append(this.f65541e == null ? "" : Boolean.valueOf(!RequsetNetworkUtils.isConnected(context)));
        d.a("LCPClientManager", sb.toString());
    }

    @Override // d.b.s.a.e.b.a
    public void onFailure(int i2, String str) {
        d.b("LCPClientManager", "getToken :" + str);
        k();
        d.b.s.a.a.d.w(this.f65541e, "2N_1", "accessToken fail");
        if (this.f65542f == 2) {
            f65540h.f65539a = -1;
            f.T(this.f65541e).a0();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof d.b.s.a.b.b) {
            f65540h.f65539a = ((d.b.s.a.b.b) obj).f65539a;
            d.a("LCPClientManager", "Manager update connectState :" + f65540h.f65539a);
        }
    }
}
