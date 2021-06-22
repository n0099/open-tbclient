package d.a.m0.c.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import d.a.m0.a.v2.q;
import d.a.m0.c.a.k.e;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f50239e;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.c.a.k.c f50243d;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.c.a.i.g f50240a = new d.a.m0.c.a.i.g();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f50242c = false;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<d.a.m0.c.a.i.c> f50241b = new ConcurrentLinkedQueue<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.c.a.k.c f50245f;

        public a(String str, d.a.m0.c.a.k.c cVar) {
            this.f50244e = str;
            this.f50245f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.n.j.j.b.c().d();
            g.this.j(this.f50244e, this.f50245f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements e.b {
        public b() {
        }

        @Override // d.a.m0.c.a.k.e.b
        public void a(boolean z, byte[] bArr) {
            String str;
            d.a.m0.c.a.i.e a2;
            str = "";
            try {
                try {
                    if (d.a.m0.c.a.a.f50231a) {
                        Log.d("BDTLS", "doHandShake response");
                    }
                    if (z && bArr != null && (a2 = d.a.m0.c.a.j.b.a(bArr)) != null) {
                        byte i2 = a2.i();
                        byte[] f2 = a2.f();
                        if (f2 != null) {
                            if (d.a.m0.c.a.a.f50231a) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i2));
                            }
                            if (i2 == 21) {
                                if (d.a.m0.c.a.a.f50231a) {
                                    Log.d("BDTLS", "doHandShake alert");
                                }
                                Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f2);
                                if (parseFrom != null) {
                                    if (d.a.m0.c.a.a.f50231a) {
                                        Log.d("BDTLS", "bdtls ubc handshake alert");
                                    }
                                    str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                    f.b(g.this.f50240a, parseFrom);
                                }
                            } else if (i2 == 22) {
                                if (d.a.m0.c.a.j.a.a(g.this.f50240a, f2) != null) {
                                    if (d.a.m0.c.a.a.f50231a) {
                                        Log.d("BDTLS", "doHandShake serverHello");
                                    }
                                    g.this.f50240a.s(1);
                                    f.a("serverHello");
                                    while (true) {
                                        d.a.m0.c.a.i.c cVar = (d.a.m0.c.a.i.c) g.this.f50241b.poll();
                                        if (cVar == null) {
                                            return;
                                        }
                                        g.this.g(cVar.b(), cVar.a());
                                    }
                                } else {
                                    str = "params decode error";
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (d.a.m0.c.a.a.f50231a) {
                        e2.printStackTrace();
                        Log.d("BDTLS", "exception=" + e2.getMessage());
                    }
                }
                g.this.n(str);
            } finally {
                g.this.f50242c = false;
            }
        }
    }

    public static g l() {
        if (f50239e == null) {
            synchronized (g.class) {
                if (f50239e == null) {
                    f50239e = new g();
                }
            }
        }
        return f50239e;
    }

    public final void g(String str, d.a.m0.c.a.k.c cVar) {
        byte[] b2;
        if (cVar == null) {
            o(-1, null);
        } else if (str == null && TextUtils.equals(cVar.b(), "POST")) {
            o(-1, cVar);
        } else {
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
            }
            if (TextUtils.equals(cVar.b(), "GET")) {
                b2 = e.f().b(this.f50240a, null);
            } else {
                b2 = e.f().b(this.f50240a, str);
            }
            if (b2 != null) {
                if (d.a.m0.c.a.a.f50231a) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                cVar.i(true);
                this.f50243d = cVar;
                cVar.h(b2);
                return;
            }
            o(-1, cVar);
        }
    }

    public void h() {
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.f50242c) {
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.f50242c = true;
        byte[] e2 = e.f().e(this.f50240a);
        if (e2 != null && e2.length > 0) {
            new d.a.m0.c.a.k.e().a(e2, new b());
            return;
        }
        this.f50242c = false;
        n("record data error");
    }

    public final void i(String str, d.a.m0.c.a.k.c cVar) {
        if (cVar != null && TextUtils.equals(cVar.b(), "GET")) {
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            cVar.i(false);
            this.f50243d = cVar;
            cVar.h(null);
        } else if (cVar != null && str != null) {
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            cVar.i(false);
            this.f50243d = cVar;
            cVar.h(str.getBytes());
        } else {
            o(-1, cVar);
        }
    }

    public final void j(String str, d.a.m0.c.a.k.c cVar) {
        if (this.f50240a.h() != 2) {
            if (!this.f50240a.j()) {
                if (this.f50241b == null) {
                    this.f50241b = new ConcurrentLinkedQueue<>();
                }
                this.f50241b.offer(new d.a.m0.c.a.i.c(str, cVar));
                h();
                return;
            }
            g(str, cVar);
            return;
        }
        i(str, cVar);
    }

    public boolean k() {
        d.a.m0.c.a.k.c cVar = this.f50243d;
        if (cVar == null) {
            return false;
        }
        return cVar.c();
    }

    public d.a.m0.c.a.i.g m() {
        if (this.f50240a == null) {
            this.f50240a = new d.a.m0.c.a.i.g();
        }
        return this.f50240a;
    }

    public final void n(String str) {
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i2 = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.f50240a.s(i2);
        while (true) {
            d.a.m0.c.a.i.c poll = this.f50241b.poll();
            if (poll == null) {
                return;
            }
            if (i2 == 2) {
                i(poll.b(), poll.a());
            } else {
                d.a.m0.c.a.k.c a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i2, d.a.m0.c.a.k.c cVar) {
        if (cVar != null) {
            cVar.f(i2);
        }
    }

    public void p(String str, d.a.m0.c.a.k.c cVar) {
        q.k(new a(str, cVar), "SessionController");
    }
}
