package d.b.c.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f65489a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f65490b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f65491c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f65489a = bVar;
            this.f65490b = proxy;
            this.f65491c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f65489a;
    }

    public Proxy b() {
        return this.f65490b;
    }

    public InetSocketAddress c() {
        return this.f65491c;
    }

    public boolean d() {
        return this.f65489a.f65467i != null && this.f65490b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f65489a.equals(this.f65489a) && eVar.f65490b.equals(this.f65490b) && eVar.f65491c.equals(this.f65491c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f65489a.hashCode()) * 31) + this.f65490b.hashCode()) * 31) + this.f65491c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f65491c + "}";
    }
}
