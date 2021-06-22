package d.b.c.a.b.a.c;

import com.bytedance.sdk.a.b.s;
import d.b.c.a.b.i;
import d.b.c.a.b.t;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.c.a.b.b f69068a;

    /* renamed from: b  reason: collision with root package name */
    public final d f69069b;

    /* renamed from: c  reason: collision with root package name */
    public final i f69070c;

    /* renamed from: d  reason: collision with root package name */
    public final t f69071d;

    /* renamed from: f  reason: collision with root package name */
    public int f69073f;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f69072e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f69074g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public final List<d.b.c.a.b.e> f69075h = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.b.c.a.b.e> f69076a;

        /* renamed from: b  reason: collision with root package name */
        public int f69077b = 0;

        public a(List<d.b.c.a.b.e> list) {
            this.f69076a = list;
        }

        public boolean a() {
            return this.f69077b < this.f69076a.size();
        }

        public d.b.c.a.b.e b() {
            if (a()) {
                List<d.b.c.a.b.e> list = this.f69076a;
                int i2 = this.f69077b;
                this.f69077b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }

        public List<d.b.c.a.b.e> c() {
            return new ArrayList(this.f69076a);
        }
    }

    public e(d.b.c.a.b.b bVar, d dVar, i iVar, t tVar) {
        this.f69068a = bVar;
        this.f69069b = dVar;
        this.f69070c = iVar;
        this.f69071d = tVar;
        c(bVar.a(), bVar.i());
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public void b(d.b.c.a.b.e eVar, IOException iOException) {
        if (eVar.b().type() != Proxy.Type.DIRECT && this.f69068a.h() != null) {
            this.f69068a.h().connectFailed(this.f69068a.a().g(), eVar.b().address(), iOException);
        }
        this.f69069b.a(eVar);
    }

    public final void c(s sVar, Proxy proxy) {
        List<Proxy> n;
        if (proxy != null) {
            this.f69072e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f69068a.h().select(sVar.g());
            if (select != null && !select.isEmpty()) {
                n = d.b.c.a.b.a.e.m(select);
            } else {
                n = d.b.c.a.b.a.e.n(Proxy.NO_PROXY);
            }
            this.f69072e = n;
        }
        this.f69073f = 0;
    }

    public final void d(Proxy proxy) throws IOException {
        String v;
        int w;
        this.f69074g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                v = a(inetSocketAddress);
                w = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            v = this.f69068a.a().v();
            w = this.f69068a.a().w();
        }
        if (w >= 1 && w <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f69074g.add(InetSocketAddress.createUnresolved(v, w));
                return;
            }
            this.f69071d.i(this.f69070c, v);
            List<InetAddress> a2 = this.f69068a.c().a(v);
            if (!a2.isEmpty()) {
                this.f69071d.j(this.f69070c, v, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f69074g.add(new InetSocketAddress(a2.get(i2), w));
                }
                return;
            }
            throw new UnknownHostException(this.f69068a.c() + " returned no addresses for " + v);
        }
        throw new SocketException("No route to " + v + ":" + w + "; port is out of range");
    }

    public boolean e() {
        return g() || !this.f69075h.isEmpty();
    }

    public a f() throws IOException {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            while (g()) {
                Proxy h2 = h();
                int size = this.f69074g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.b.c.a.b.e eVar = new d.b.c.a.b.e(this.f69068a, h2, this.f69074g.get(i2));
                    if (this.f69069b.c(eVar)) {
                        this.f69075h.add(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f69075h);
                this.f69075h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean g() {
        return this.f69073f < this.f69072e.size();
    }

    public final Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f69072e;
            int i2 = this.f69073f;
            this.f69073f = i2 + 1;
            Proxy proxy = list.get(i2);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f69068a.a().v() + "; exhausted proxy configurations: " + this.f69072e);
    }
}
