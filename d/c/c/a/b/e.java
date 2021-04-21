package d.c.c.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f66415a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f66416b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f66417c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f66415a = bVar;
            this.f66416b = proxy;
            this.f66417c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f66415a;
    }

    public Proxy b() {
        return this.f66416b;
    }

    public InetSocketAddress c() {
        return this.f66417c;
    }

    public boolean d() {
        return this.f66415a.i != null && this.f66416b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f66415a.equals(this.f66415a) && eVar.f66416b.equals(this.f66416b) && eVar.f66417c.equals(this.f66417c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f66415a.hashCode()) * 31) + this.f66416b.hashCode()) * 31) + this.f66417c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f66417c + "}";
    }
}
