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
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.c.a.b.b f64504a;

    /* renamed from: b  reason: collision with root package name */
    public final d f64505b;

    /* renamed from: c  reason: collision with root package name */
    public final i f64506c;

    /* renamed from: d  reason: collision with root package name */
    public final t f64507d;

    /* renamed from: f  reason: collision with root package name */
    public int f64509f;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f64508e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f64510g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public final List<d.b.c.a.b.e> f64511h = new ArrayList();

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.b.c.a.b.e> f64512a;

        /* renamed from: b  reason: collision with root package name */
        public int f64513b = 0;

        public a(List<d.b.c.a.b.e> list) {
            this.f64512a = list;
        }

        public boolean a() {
            return this.f64513b < this.f64512a.size();
        }

        public d.b.c.a.b.e b() {
            if (a()) {
                List<d.b.c.a.b.e> list = this.f64512a;
                int i2 = this.f64513b;
                this.f64513b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }

        public List<d.b.c.a.b.e> c() {
            return new ArrayList(this.f64512a);
        }
    }

    public e(d.b.c.a.b.b bVar, d dVar, i iVar, t tVar) {
        this.f64504a = bVar;
        this.f64505b = dVar;
        this.f64506c = iVar;
        this.f64507d = tVar;
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
        if (eVar.b().type() != Proxy.Type.DIRECT && this.f64504a.h() != null) {
            this.f64504a.h().connectFailed(this.f64504a.a().g(), eVar.b().address(), iOException);
        }
        this.f64505b.a(eVar);
    }

    public final void c(s sVar, Proxy proxy) {
        List<Proxy> n;
        if (proxy != null) {
            this.f64508e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f64504a.h().select(sVar.g());
            if (select != null && !select.isEmpty()) {
                n = d.b.c.a.b.a.e.m(select);
            } else {
                n = d.b.c.a.b.a.e.n(Proxy.NO_PROXY);
            }
            this.f64508e = n;
        }
        this.f64509f = 0;
    }

    public final void d(Proxy proxy) throws IOException {
        String v;
        int w;
        this.f64510g = new ArrayList();
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
            v = this.f64504a.a().v();
            w = this.f64504a.a().w();
        }
        if (w >= 1 && w <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f64510g.add(InetSocketAddress.createUnresolved(v, w));
                return;
            }
            this.f64507d.i(this.f64506c, v);
            List<InetAddress> a2 = this.f64504a.c().a(v);
            if (!a2.isEmpty()) {
                this.f64507d.j(this.f64506c, v, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f64510g.add(new InetSocketAddress(a2.get(i2), w));
                }
                return;
            }
            throw new UnknownHostException(this.f64504a.c() + " returned no addresses for " + v);
        }
        throw new SocketException("No route to " + v + ":" + w + "; port is out of range");
    }

    public boolean e() {
        return g() || !this.f64511h.isEmpty();
    }

    public a f() throws IOException {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            while (g()) {
                Proxy h2 = h();
                int size = this.f64510g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.b.c.a.b.e eVar = new d.b.c.a.b.e(this.f64504a, h2, this.f64510g.get(i2));
                    if (this.f64505b.c(eVar)) {
                        this.f64511h.add(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f64511h);
                this.f64511h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean g() {
        return this.f64509f < this.f64508e.size();
    }

    public final Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f64508e;
            int i2 = this.f64509f;
            this.f64509f = i2 + 1;
            Proxy proxy = list.get(i2);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f64504a.a().v() + "; exhausted proxy configurations: " + this.f64508e);
    }
}
