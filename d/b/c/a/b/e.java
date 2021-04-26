package d.b.c.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f64803a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f64804b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f64805c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f64803a = bVar;
            this.f64804b = proxy;
            this.f64805c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f64803a;
    }

    public Proxy b() {
        return this.f64804b;
    }

    public InetSocketAddress c() {
        return this.f64805c;
    }

    public boolean d() {
        return this.f64803a.f64781i != null && this.f64804b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f64803a.equals(this.f64803a) && eVar.f64804b.equals(this.f64804b) && eVar.f64805c.equals(this.f64805c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f64803a.hashCode()) * 31) + this.f64804b.hashCode()) * 31) + this.f64805c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f64805c + "}";
    }
}
