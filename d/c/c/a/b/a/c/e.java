package d.c.c.a.b.a.c;

import com.bytedance.sdk.a.b.s;
import d.c.c.a.b.i;
import d.c.c.a.b.t;
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
    public final d.c.c.a.b.b f65197a;

    /* renamed from: b  reason: collision with root package name */
    public final d f65198b;

    /* renamed from: c  reason: collision with root package name */
    public final i f65199c;

    /* renamed from: d  reason: collision with root package name */
    public final t f65200d;

    /* renamed from: f  reason: collision with root package name */
    public int f65202f;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f65201e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f65203g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public final List<d.c.c.a.b.e> f65204h = new ArrayList();

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.c.c.a.b.e> f65205a;

        /* renamed from: b  reason: collision with root package name */
        public int f65206b = 0;

        public a(List<d.c.c.a.b.e> list) {
            this.f65205a = list;
        }

        public boolean a() {
            return this.f65206b < this.f65205a.size();
        }

        public d.c.c.a.b.e b() {
            if (a()) {
                List<d.c.c.a.b.e> list = this.f65205a;
                int i = this.f65206b;
                this.f65206b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }

        public List<d.c.c.a.b.e> c() {
            return new ArrayList(this.f65205a);
        }
    }

    public e(d.c.c.a.b.b bVar, d dVar, i iVar, t tVar) {
        this.f65197a = bVar;
        this.f65198b = dVar;
        this.f65199c = iVar;
        this.f65200d = tVar;
        c(bVar.a(), bVar.i());
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public void b(d.c.c.a.b.e eVar, IOException iOException) {
        if (eVar.b().type() != Proxy.Type.DIRECT && this.f65197a.h() != null) {
            this.f65197a.h().connectFailed(this.f65197a.a().g(), eVar.b().address(), iOException);
        }
        this.f65198b.a(eVar);
    }

    public final void c(s sVar, Proxy proxy) {
        List<Proxy> n;
        if (proxy != null) {
            this.f65201e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f65197a.h().select(sVar.g());
            if (select != null && !select.isEmpty()) {
                n = d.c.c.a.b.a.e.m(select);
            } else {
                n = d.c.c.a.b.a.e.n(Proxy.NO_PROXY);
            }
            this.f65201e = n;
        }
        this.f65202f = 0;
    }

    public final void d(Proxy proxy) throws IOException {
        String v;
        int w;
        this.f65203g = new ArrayList();
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
            v = this.f65197a.a().v();
            w = this.f65197a.a().w();
        }
        if (w >= 1 && w <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f65203g.add(InetSocketAddress.createUnresolved(v, w));
                return;
            }
            this.f65200d.i(this.f65199c, v);
            List<InetAddress> a2 = this.f65197a.c().a(v);
            if (!a2.isEmpty()) {
                this.f65200d.j(this.f65199c, v, a2);
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    this.f65203g.add(new InetSocketAddress(a2.get(i), w));
                }
                return;
            }
            throw new UnknownHostException(this.f65197a.c() + " returned no addresses for " + v);
        }
        throw new SocketException("No route to " + v + ":" + w + "; port is out of range");
    }

    public boolean e() {
        return g() || !this.f65204h.isEmpty();
    }

    public a f() throws IOException {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            while (g()) {
                Proxy h2 = h();
                int size = this.f65203g.size();
                for (int i = 0; i < size; i++) {
                    d.c.c.a.b.e eVar = new d.c.c.a.b.e(this.f65197a, h2, this.f65203g.get(i));
                    if (this.f65198b.c(eVar)) {
                        this.f65204h.add(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f65204h);
                this.f65204h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean g() {
        return this.f65202f < this.f65201e.size();
    }

    public final Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f65201e;
            int i = this.f65202f;
            this.f65202f = i + 1;
            Proxy proxy = list.get(i);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f65197a.a().v() + "; exhausted proxy configurations: " + this.f65201e);
    }
}
