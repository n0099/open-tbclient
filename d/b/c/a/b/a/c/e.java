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
    public final d.b.c.a.b.b f65233a;

    /* renamed from: b  reason: collision with root package name */
    public final d f65234b;

    /* renamed from: c  reason: collision with root package name */
    public final i f65235c;

    /* renamed from: d  reason: collision with root package name */
    public final t f65236d;

    /* renamed from: f  reason: collision with root package name */
    public int f65238f;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f65237e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f65239g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public final List<d.b.c.a.b.e> f65240h = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.b.c.a.b.e> f65241a;

        /* renamed from: b  reason: collision with root package name */
        public int f65242b = 0;

        public a(List<d.b.c.a.b.e> list) {
            this.f65241a = list;
        }

        public boolean a() {
            return this.f65242b < this.f65241a.size();
        }

        public d.b.c.a.b.e b() {
            if (a()) {
                List<d.b.c.a.b.e> list = this.f65241a;
                int i2 = this.f65242b;
                this.f65242b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }

        public List<d.b.c.a.b.e> c() {
            return new ArrayList(this.f65241a);
        }
    }

    public e(d.b.c.a.b.b bVar, d dVar, i iVar, t tVar) {
        this.f65233a = bVar;
        this.f65234b = dVar;
        this.f65235c = iVar;
        this.f65236d = tVar;
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
        if (eVar.b().type() != Proxy.Type.DIRECT && this.f65233a.h() != null) {
            this.f65233a.h().connectFailed(this.f65233a.a().g(), eVar.b().address(), iOException);
        }
        this.f65234b.a(eVar);
    }

    public final void c(s sVar, Proxy proxy) {
        List<Proxy> n;
        if (proxy != null) {
            this.f65237e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f65233a.h().select(sVar.g());
            if (select != null && !select.isEmpty()) {
                n = d.b.c.a.b.a.e.m(select);
            } else {
                n = d.b.c.a.b.a.e.n(Proxy.NO_PROXY);
            }
            this.f65237e = n;
        }
        this.f65238f = 0;
    }

    public final void d(Proxy proxy) throws IOException {
        String v;
        int w;
        this.f65239g = new ArrayList();
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
            v = this.f65233a.a().v();
            w = this.f65233a.a().w();
        }
        if (w >= 1 && w <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f65239g.add(InetSocketAddress.createUnresolved(v, w));
                return;
            }
            this.f65236d.i(this.f65235c, v);
            List<InetAddress> a2 = this.f65233a.c().a(v);
            if (!a2.isEmpty()) {
                this.f65236d.j(this.f65235c, v, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f65239g.add(new InetSocketAddress(a2.get(i2), w));
                }
                return;
            }
            throw new UnknownHostException(this.f65233a.c() + " returned no addresses for " + v);
        }
        throw new SocketException("No route to " + v + ":" + w + "; port is out of range");
    }

    public boolean e() {
        return g() || !this.f65240h.isEmpty();
    }

    public a f() throws IOException {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            while (g()) {
                Proxy h2 = h();
                int size = this.f65239g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.b.c.a.b.e eVar = new d.b.c.a.b.e(this.f65233a, h2, this.f65239g.get(i2));
                    if (this.f65234b.c(eVar)) {
                        this.f65240h.add(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f65240h);
                this.f65240h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean g() {
        return this.f65238f < this.f65237e.size();
    }

    public final Proxy h() throws IOException {
        if (g()) {
            List<Proxy> list = this.f65237e;
            int i2 = this.f65238f;
            this.f65238f = i2 + 1;
            Proxy proxy = list.get(i2);
            d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f65233a.a().v() + "; exhausted proxy configurations: " + this.f65237e);
    }
}
