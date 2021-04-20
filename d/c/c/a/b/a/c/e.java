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
    public final d.c.c.a.b.b f66043a;

    /* renamed from: b  reason: collision with root package name */
    public final d f66044b;

    /* renamed from: c  reason: collision with root package name */
    public final i f66045c;

    /* renamed from: d  reason: collision with root package name */
    public final t f66046d;

    /* renamed from: f  reason: collision with root package name */
    public int f66048f;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f66047e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f66049g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public final List<d.c.c.a.b.e> f66050h = new ArrayList();

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.c.c.a.b.e> f66051a;

        /* renamed from: b  reason: collision with root package name */
        public int f66052b = 0;

        public a(List<d.c.c.a.b.e> list) {
            this.f66051a = list;
        }

        public boolean a() {
            return this.f66052b < this.f66051a.size();
        }

        public d.c.c.a.b.e b() {
            if (a()) {
                List<d.c.c.a.b.e> list = this.f66051a;
                int i = this.f66052b;
                this.f66052b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }

        public List<d.c.c.a.b.e> c() {
            return new ArrayList(this.f66051a);
        }
    }

    public e(d.c.c.a.b.b bVar, d dVar, i iVar, t tVar) {
        this.f66043a = bVar;
        this.f66044b = dVar;
        this.f66045c = iVar;
        this.f66046d = tVar;
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
        if (eVar.b().type() != Proxy.Type.DIRECT && this.f66043a.h() != null) {
            this.f66043a.h().connectFailed(this.f66043a.a().g(), eVar.b().address(), iOException);
        }
        this.f66044b.a(eVar);
    }

    public final void c(s sVar, Proxy proxy) {
        List<Proxy> n;
        if (proxy != null) {
            this.f66047e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f66043a.h().select(sVar.g());
            if (select != null && !select.isEmpty()) {
                n = d.c.c.a.b.a.e.m(select);
            } else {
                n = d.c.c.a.b.a.e.n(Proxy.NO_PROXY);
            }
            this.f66047e = n;
        }
        this.f66048f = 0;
    }

    public final void d(Proxy proxy) throws IOException {
        String v;
        int w;
        this.f66049g = new ArrayList();
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
            v = this.f66043a.a().v();
            w = this.f66043a.a().w();
        }
        if (w >= 1 && w <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f66049g.add(InetSocketAddress.createUnresolved(v, w));
                return;
            }
            this.f66046d.i(this.f66045c, v);
            List<InetAddress> a2 = this.f66043a.c().a(v);
            if (!a2.isEmpty()) {
                this.f66046d.j(this.f66045c, v, a2);
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    this.f66049g.add(new InetSocketAddress(a2.get(i), w));
                }
                return;
            }
            throw new UnknownHostException(this.f66043a.c() + " returned no addresses for " + v);
        }
        throw new SocketException("No route to " + v + ":" + w + "; port is out of range");
    }

    public boolean e() {
        return g() || !this.f66050h.isEmpty();
    }

    public a f() throws IOException {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            while (g()) {
                Proxy h2 = h();
                int size = this.f66049g.size();
                for (int i = 0; i < size; i++) {
                    d.c.c.a.b.e eVar = new d.c.c.a.b.e(this.f66043a, h2, this.f66049g.get(i));
                    if (this.f66044b.c(eVar)) {
                        this.f66050h.add(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f66050h);
                this.f66050h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean g() {
        return this.f66048f < this.f66047e.size();
    }

    public final Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f66047e;
            int i = this.f66048f;
            this.f66048f = i + 1;
            Proxy proxy = list.get(i);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f66043a.a().v() + "; exhausted proxy configurations: " + this.f66047e);
    }
}
