package d.a.c.e.r;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.c.e.r.e;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Handler f39309a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e0 f39310b;

    /* renamed from: c  reason: collision with root package name */
    public volatile g0 f39311c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f39312d;

    /* renamed from: e  reason: collision with root package name */
    public URI f39313e;

    /* renamed from: f  reason: collision with root package name */
    public String f39314f;

    /* renamed from: g  reason: collision with root package name */
    public String f39315g;

    /* renamed from: h  reason: collision with root package name */
    public int f39316h;

    /* renamed from: i  reason: collision with root package name */
    public String f39317i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public g m;
    public d0 n;
    public boolean o = false;
    public boolean p = false;
    public volatile boolean q = false;
    public long r = 0;
    public c s = null;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String message2;
            Object obj = message.obj;
            if (obj instanceof c0) {
                c0 c0Var = (c0) obj;
                if (i.this.m != null) {
                    i.this.m.a(c0Var.f39256a);
                }
            } else if (obj instanceof w) {
                w wVar = (w) obj;
                if (i.this.m != null) {
                    i.this.m.d(wVar.f39338a);
                } else if (i.this.D()) {
                    BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                }
            } else if (obj instanceof k) {
                k kVar = (k) obj;
                if (i.this.m != null) {
                    i.this.m.f(kVar);
                } else if (i.this.D()) {
                    BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                }
            } else if (obj instanceof t) {
                u uVar = new u();
                uVar.f39336a = ((t) obj).f39335a;
                i.this.f39311c.b(uVar);
            } else if (obj instanceof u) {
                u uVar2 = (u) obj;
                if (i.this.m != null) {
                    i.this.m.e();
                }
            } else {
                if (obj instanceof m) {
                    i.this.q(1, null);
                } else if (obj instanceof a0) {
                    a0 a0Var = (a0) obj;
                    if (a0Var.f39252a) {
                        if (i.this.m != null) {
                            i.this.m.onOpen(a0Var.f39253b);
                            i.this.o = true;
                            i.this.p = false;
                            if (i.this.m != null) {
                                i.this.m.c(null);
                                return;
                            }
                            return;
                        }
                        i.this.q(6, "handler already NULL");
                    }
                } else if (obj instanceof n) {
                    SocketException socketException = ((n) obj).f39331a;
                    message2 = socketException != null ? socketException.getMessage() : null;
                    i iVar = i.this;
                    iVar.q(3, "WebSockets connection lost = " + message2);
                } else if (obj instanceof v) {
                    WebSocketException webSocketException = ((v) obj).f39337a;
                    message2 = webSocketException != null ? webSocketException.getMessage() : null;
                    i iVar2 = i.this;
                    iVar2.q(4, "WebSockets protocol violation error = " + message2);
                } else if (obj instanceof p) {
                    i iVar3 = i.this;
                    iVar3.q(5, "WebSockets internal error (" + ((p) obj).f39333a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                } else if (obj instanceof z) {
                    z zVar = (z) obj;
                    i iVar4 = i.this;
                    iVar4.q(6, "Server error " + zVar.f39340a + " (" + zVar.f39341b + SmallTailInfo.EMOTION_SUFFIX);
                } else if (obj instanceof o) {
                    i iVar5 = i.this;
                    iVar5.q(2, "WebSockets connot connect:" + ((o) obj).f39332a);
                } else if (obj instanceof b0) {
                    if (i.this.m != null) {
                        i.this.m.i(((b0) message.obj).f39339a);
                    }
                } else if (obj instanceof q) {
                    i.this.s = null;
                    c cVar = ((q) message.obj).f39339a;
                    if (i.this.m != null) {
                        i.this.m.h(cVar);
                    }
                    if (i.this.m != null) {
                        i.this.m.c(cVar);
                    }
                } else if (obj instanceof x) {
                    i.this.s = null;
                    c cVar2 = ((x) message.obj).f39339a;
                    if (i.this.m != null) {
                        i.this.m.g(2, cVar2);
                    }
                    if (i.this.m != null) {
                        i.this.m.c(cVar2);
                    }
                } else {
                    i.this.G(obj);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketConnector");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e eVar = new e();
                i.this.f39312d = eVar.a(i.this.f39315g, i.this.f39316h, i.this.n, false);
                if (i.this.q) {
                    i.this.H(new m());
                    return;
                }
                try {
                    if (!i.this.f39312d.isConnected()) {
                        i.this.H(new o(2, "cannot connect"));
                        return;
                    }
                    i.this.r = System.currentTimeMillis() - currentTimeMillis;
                    i.this.t();
                    i.this.u();
                    l lVar = new l(i.this.f39315g + ":" + i.this.f39316h);
                    lVar.f39324b = i.this.f39317i;
                    lVar.f39325c = i.this.j;
                    lVar.f39327e = i.this.k;
                    lVar.f39328f = i.this.l;
                    i.this.f39311c.b(lVar);
                    if (i.this.q) {
                        i.this.H(new m());
                    }
                } catch (Throwable th) {
                    if (i.this.D()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.H(new p(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.H(new o(2, th2.getMessage()));
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this();
        }
    }

    public i() {
        s();
    }

    public long A() {
        e.a aVar = this.f39312d;
        if (aVar != null) {
            return aVar.c();
        }
        return 0L;
    }

    public String B() {
        e.a aVar = this.f39312d;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public boolean C() {
        return this.p;
    }

    public final boolean D() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public boolean E() {
        return this.o;
    }

    public boolean F() {
        return this.s != null;
    }

    public void G(Object obj) {
    }

    public final void H(Object obj) {
        Message obtainMessage = this.f39309a.obtainMessage();
        obtainMessage.obj = obj;
        this.f39309a.sendMessage(obtainMessage);
    }

    public boolean I(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.s == null && E()) {
            this.s = cVar;
            return J(cVar);
        }
        D();
        if (cVar != null) {
            cVar.a(1);
        }
        return false;
    }

    public final boolean J(c cVar) {
        if (this.f39311c == null) {
            H(new p(new Exception("mWriter = null")));
            return false;
        }
        return this.f39311c.b(new s(cVar));
    }

    public void o() {
        if (this.f39310b != null) {
            this.f39310b.a();
        }
    }

    public void p() {
        if (this.f39311c != null) {
            this.f39311c.a();
        }
    }

    public void q(int i2, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            d.a.c.c.e.c.i.a("more_log", 0, 0, IntentConfig.CLOSE, i2, str);
        }
        this.o = false;
        this.q = true;
        if (this.f39310b != null) {
            this.f39310b.p();
            this.f39310b = null;
        }
        if (this.f39311c != null) {
            this.f39311c.i();
            this.f39311c = null;
        }
        e.a aVar = this.f39312d;
        if (aVar != null) {
            try {
                aVar.close();
            } catch (Throwable th) {
                if (D()) {
                    th.printStackTrace();
                }
            }
            this.f39312d = null;
        }
        g gVar = this.m;
        this.m = null;
        if (gVar != null) {
            try {
                gVar.b(i2, str);
            } catch (Exception e2) {
                if (D()) {
                    BdLog.d(e2.getMessage());
                }
            }
        }
    }

    public void r(String str, String[] strArr, g gVar, d0 d0Var, List<BasicNameValuePair> list) throws WebSocketException {
        this.p = true;
        e.a aVar = this.f39312d;
        if (aVar != null && aVar.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            URI uri = new URI(str);
            this.f39313e = uri;
            if (!uri.getScheme().equals("ws") && !this.f39313e.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (!this.f39313e.getScheme().equals("wss")) {
                this.f39314f = this.f39313e.getScheme();
                if (this.f39313e.getPort() == -1) {
                    if (this.f39314f.equals("ws")) {
                        this.f39316h = 80;
                    } else {
                        this.f39316h = Constants.SOCKET_PORT_SSL;
                    }
                } else {
                    this.f39316h = this.f39313e.getPort();
                }
                if (this.f39313e.getHost() != null) {
                    this.f39315g = this.f39313e.getHost();
                    if (this.f39313e.getPath() != null && !this.f39313e.getPath().equals("")) {
                        this.f39317i = this.f39313e.getPath();
                        if (this.f39313e.getQuery() != null && !this.f39313e.getQuery().equals("")) {
                            this.j = this.f39313e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = gVar;
                            this.n = new d0(d0Var);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = gVar;
                        this.n = new d0(d0Var);
                        new b(this, null).start();
                        return;
                    }
                    this.f39317i = "/";
                    if (this.f39313e.getQuery() != null) {
                        this.j = this.f39313e.getQuery();
                        this.k = strArr;
                        this.l = list;
                        this.m = gVar;
                        this.n = new d0(d0Var);
                        new b(this, null).start();
                        return;
                    }
                    this.j = null;
                    this.k = strArr;
                    this.l = list;
                    this.m = gVar;
                    this.n = new d0(d0Var);
                    new b(this, null).start();
                    return;
                }
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            throw new WebSocketException("secure WebSockets not implemented");
        } catch (URISyntaxException unused) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    public void s() {
        this.f39309a = new a();
    }

    public void t() {
        this.f39310b = new e0(this.f39309a, this.f39312d, this.n, "WebSocketReader");
        this.f39310b.start();
    }

    public void u() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.f39311c = new g0(handlerThread.getLooper(), this.f39309a, this.f39312d, this.n);
    }

    public long v() {
        if (this.f39310b != null) {
            return this.f39310b.c();
        }
        return 0L;
    }

    public String w() {
        e.a aVar = this.f39312d;
        if (aVar != null) {
            return aVar.getLocalDns();
        }
        return null;
    }

    public String x() {
        e.a aVar = this.f39312d;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public long y() {
        if (this.f39311c != null) {
            return this.f39311c.c();
        }
        return 0L;
    }

    public long z() {
        return this.r;
    }
}
