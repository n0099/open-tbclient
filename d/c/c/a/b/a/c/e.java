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
    public final d.c.c.a.b.b f66138a;

    /* renamed from: b  reason: collision with root package name */
    public final d f66139b;

    /* renamed from: c  reason: collision with root package name */
    public final i f66140c;

    /* renamed from: d  reason: collision with root package name */
    public final t f66141d;

    /* renamed from: f  reason: collision with root package name */
    public int f66143f;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f66142e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f66144g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public final List<d.c.c.a.b.e> f66145h = new ArrayList();

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.c.c.a.b.e> f66146a;

        /* renamed from: b  reason: collision with root package name */
        public int f66147b = 0;

        public a(List<d.c.c.a.b.e> list) {
            this.f66146a = list;
        }

        public boolean a() {
            return this.f66147b < this.f66146a.size();
        }

        public d.c.c.a.b.e b() {
            if (a()) {
                List<d.c.c.a.b.e> list = this.f66146a;
                int i = this.f66147b;
                this.f66147b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }

        public List<d.c.c.a.b.e> c() {
            return new ArrayList(this.f66146a);
        }
    }

    public e(d.c.c.a.b.b bVar, d dVar, i iVar, t tVar) {
        this.f66138a = bVar;
        this.f66139b = dVar;
        this.f66140c = iVar;
        this.f66141d = tVar;
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
        if (eVar.b().type() != Proxy.Type.DIRECT && this.f66138a.h() != null) {
            this.f66138a.h().connectFailed(this.f66138a.a().g(), eVar.b().address(), iOException);
        }
        this.f66139b.a(eVar);
    }

    public final void c(s sVar, Proxy proxy) {
        List<Proxy> n;
        if (proxy != null) {
            this.f66142e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f66138a.h().select(sVar.g());
            if (select != null && !select.isEmpty()) {
                n = d.c.c.a.b.a.e.m(select);
            } else {
                n = d.c.c.a.b.a.e.n(Proxy.NO_PROXY);
            }
            this.f66142e = n;
        }
        this.f66143f = 0;
    }

    public final void d(Proxy proxy) throws IOException {
        String v;
        int w;
        this.f66144g = new ArrayList();
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
            v = this.f66138a.a().v();
            w = this.f66138a.a().w();
        }
        if (w >= 1 && w <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f66144g.add(InetSocketAddress.createUnresolved(v, w));
                return;
            }
            this.f66141d.i(this.f66140c, v);
            List<InetAddress> a2 = this.f66138a.c().a(v);
            if (!a2.isEmpty()) {
                this.f66141d.j(this.f66140c, v, a2);
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    this.f66144g.add(new InetSocketAddress(a2.get(i), w));
                }
                return;
            }
            throw new UnknownHostException(this.f66138a.c() + " returned no addresses for " + v);
        }
        throw new SocketException("No route to " + v + ":" + w + "; port is out of range");
    }

    public boolean e() {
        return g() || !this.f66145h.isEmpty();
    }

    public a f() throws IOException {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            while (g()) {
                Proxy h2 = h();
                int size = this.f66144g.size();
                for (int i = 0; i < size; i++) {
                    d.c.c.a.b.e eVar = new d.c.c.a.b.e(this.f66138a, h2, this.f66144g.get(i));
                    if (this.f66139b.c(eVar)) {
                        this.f66145h.add(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f66145h);
                this.f66145h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean g() {
        return this.f66143f < this.f66142e.size();
    }

    public final Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f66142e;
            int i = this.f66143f;
            this.f66143f = i + 1;
            Proxy proxy = list.get(i);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f66138a.a().v() + "; exhausted proxy configurations: " + this.f66142e);
    }
}
