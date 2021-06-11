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
    public final d.b.c.a.b.b f68964a;

    /* renamed from: b  reason: collision with root package name */
    public final d f68965b;

    /* renamed from: c  reason: collision with root package name */
    public final i f68966c;

    /* renamed from: d  reason: collision with root package name */
    public final t f68967d;

    /* renamed from: f  reason: collision with root package name */
    public int f68969f;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f68968e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f68970g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public final List<d.b.c.a.b.e> f68971h = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.b.c.a.b.e> f68972a;

        /* renamed from: b  reason: collision with root package name */
        public int f68973b = 0;

        public a(List<d.b.c.a.b.e> list) {
            this.f68972a = list;
        }

        public boolean a() {
            return this.f68973b < this.f68972a.size();
        }

        public d.b.c.a.b.e b() {
            if (a()) {
                List<d.b.c.a.b.e> list = this.f68972a;
                int i2 = this.f68973b;
                this.f68973b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }

        public List<d.b.c.a.b.e> c() {
            return new ArrayList(this.f68972a);
        }
    }

    public e(d.b.c.a.b.b bVar, d dVar, i iVar, t tVar) {
        this.f68964a = bVar;
        this.f68965b = dVar;
        this.f68966c = iVar;
        this.f68967d = tVar;
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
        if (eVar.b().type() != Proxy.Type.DIRECT && this.f68964a.h() != null) {
            this.f68964a.h().connectFailed(this.f68964a.a().g(), eVar.b().address(), iOException);
        }
        this.f68965b.a(eVar);
    }

    public final void c(s sVar, Proxy proxy) {
        List<Proxy> n;
        if (proxy != null) {
            this.f68968e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f68964a.h().select(sVar.g());
            if (select != null && !select.isEmpty()) {
                n = d.b.c.a.b.a.e.m(select);
            } else {
                n = d.b.c.a.b.a.e.n(Proxy.NO_PROXY);
            }
            this.f68968e = n;
        }
        this.f68969f = 0;
    }

    public final void d(Proxy proxy) throws IOException {
        String v;
        int w;
        this.f68970g = new ArrayList();
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
            v = this.f68964a.a().v();
            w = this.f68964a.a().w();
        }
        if (w >= 1 && w <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f68970g.add(InetSocketAddress.createUnresolved(v, w));
                return;
            }
            this.f68967d.i(this.f68966c, v);
            List<InetAddress> a2 = this.f68964a.c().a(v);
            if (!a2.isEmpty()) {
                this.f68967d.j(this.f68966c, v, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f68970g.add(new InetSocketAddress(a2.get(i2), w));
                }
                return;
            }
            throw new UnknownHostException(this.f68964a.c() + " returned no addresses for " + v);
        }
        throw new SocketException("No route to " + v + ":" + w + "; port is out of range");
    }

    public boolean e() {
        return g() || !this.f68971h.isEmpty();
    }

    public a f() throws IOException {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            while (g()) {
                Proxy h2 = h();
                int size = this.f68970g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.b.c.a.b.e eVar = new d.b.c.a.b.e(this.f68964a, h2, this.f68970g.get(i2));
                    if (this.f68965b.c(eVar)) {
                        this.f68971h.add(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f68971h);
                this.f68971h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean g() {
        return this.f68969f < this.f68968e.size();
    }

    public final Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f68968e;
            int i2 = this.f68969f;
            this.f68969f = i2 + 1;
            Proxy proxy = list.get(i2);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f68964a.a().v() + "; exhausted proxy configurations: " + this.f68968e);
    }
}
