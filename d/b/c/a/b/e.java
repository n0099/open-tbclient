package d.b.c.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f65532a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f65533b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f65534c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f65532a = bVar;
            this.f65533b = proxy;
            this.f65534c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f65532a;
    }

    public Proxy b() {
        return this.f65533b;
    }

    public InetSocketAddress c() {
        return this.f65534c;
    }

    public boolean d() {
        return this.f65532a.f65510i != null && this.f65533b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f65532a.equals(this.f65532a) && eVar.f65533b.equals(this.f65533b) && eVar.f65534c.equals(this.f65534c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f65532a.hashCode()) * 31) + this.f65533b.hashCode()) * 31) + this.f65534c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f65534c + "}";
    }
}
