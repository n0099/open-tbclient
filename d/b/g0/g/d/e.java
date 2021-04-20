package d.b.g0.g.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.model.Bdtls$Alert;
import d.b.g0.a.i2.p;
import d.b.g0.g.d.g.g;
import d.b.g0.g.d.i.d;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f48425d = new e();

    /* renamed from: a  reason: collision with root package name */
    public g f48426a = new g();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f48428c = false;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<d.b.g0.g.d.g.c> f48427b = new ConcurrentLinkedQueue<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.d.i.b f48430f;

        public a(String str, d.b.g0.g.d.i.b bVar) {
            this.f48429e = str;
            this.f48430f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.j(this.f48429e, this.f48430f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.b.g0.g.d.i.d.b
        public void a(boolean z, byte[] bArr) {
            String str;
            d.b.g0.g.d.g.e a2;
            str = "";
            try {
                try {
                    if (d.b.g0.g.d.a.f48420a) {
                        Log.d("BDTLS", "doHandShake response");
                    }
                    if (z && bArr != null && (a2 = d.b.g0.g.d.h.b.a(bArr)) != null) {
                        byte h2 = a2.h();
                        byte[] e2 = a2.e();
                        if (e2 != null) {
                            if (d.b.g0.g.d.a.f48420a) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) h2));
                            }
                            if (h2 == 21) {
                                if (d.b.g0.g.d.a.f48420a) {
                                    Log.d("BDTLS", "doHandShake alert");
                                }
                                Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(e2);
                                if (parseFrom != null) {
                                    if (d.b.g0.g.d.a.f48420a) {
                                        Log.d("BDTLS", "bdtls ubc handshake alert");
                                    }
                                    str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                    f.b(e.this.f48426a, parseFrom);
                                }
                            } else if (h2 == 22) {
                                if (d.b.g0.g.d.h.a.a(e.this.f48426a, e2) != null) {
                                    if (d.b.g0.g.d.a.f48420a) {
                                        Log.d("BDTLS", "doHandShake serverHello");
                                    }
                                    e.this.f48426a.s(1);
                                    f.a("serverHello");
                                    while (true) {
                                        d.b.g0.g.d.g.c cVar = (d.b.g0.g.d.g.c) e.this.f48427b.poll();
                                        if (cVar == null) {
                                            return;
                                        }
                                        e.this.g(cVar.b(), cVar.a());
                                    }
                                } else {
                                    str = "params decode error";
                                }
                            }
                        }
                    }
                } catch (Exception e3) {
                    if (d.b.g0.g.d.a.f48420a) {
                        e3.printStackTrace();
                        Log.d("BDTLS", "exception=" + e3.getMessage());
                    }
                }
                e.this.m(str);
            } finally {
                e.this.f48428c = false;
            }
        }
    }

    public static e l() {
        return f48425d;
    }

    public final void g(String str, d.b.g0.g.d.i.b bVar) {
        byte[] b2;
        if (str != null && bVar != null) {
            if (TextUtils.equals(bVar.b(), "GET")) {
                b2 = d.f().b(this.f48426a, null);
            } else {
                b2 = d.f().b(this.f48426a, str);
            }
            if (b2 != null) {
                if (d.b.g0.g.d.a.f48420a) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                bVar.h(true);
                bVar.g(b2);
                return;
            }
            n(-1, bVar);
            return;
        }
        n(-1, null);
    }

    public void h() {
        if (d.b.g0.g.d.a.f48420a) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.f48428c) {
            if (d.b.g0.g.d.a.f48420a) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.f48428c = true;
        byte[] e2 = d.f().e(this.f48426a);
        if (e2 != null && e2.length > 0) {
            new d.b.g0.g.d.i.d().a(e2, new b());
            return;
        }
        this.f48428c = false;
        m("record data error");
    }

    public final void i(String str, d.b.g0.g.d.i.b bVar) {
        if (bVar != null && str != null) {
            if (d.b.g0.g.d.a.f48420a) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.h(false);
            bVar.g(str.getBytes());
            return;
        }
        n(-1, bVar);
    }

    public final void j(String str, d.b.g0.g.d.i.b bVar) {
        if (this.f48426a.h() != 2) {
            if (!this.f48426a.j()) {
                if (this.f48427b == null) {
                    this.f48427b = new ConcurrentLinkedQueue<>();
                }
                this.f48427b.offer(new d.b.g0.g.d.g.c(str, bVar));
                h();
                return;
            }
            g(str, bVar);
            return;
        }
        i(str, bVar);
    }

    public g k() {
        if (this.f48426a == null) {
            this.f48426a = new g();
        }
        return this.f48426a;
    }

    public final void m(String str) {
        if (d.b.g0.g.d.a.f48420a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.f48426a.s(i);
        while (true) {
            d.b.g0.g.d.g.c poll = this.f48427b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                d.b.g0.g.d.i.b a2 = poll.a();
                if (a2 != null) {
                    a2.d(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void n(int i, d.b.g0.g.d.i.b bVar) {
        if (bVar != null) {
            bVar.e(i);
        }
    }

    public void o(String str, d.b.g0.g.d.i.b bVar) {
        p.l(new a(str, bVar), "SessionController");
    }
}
