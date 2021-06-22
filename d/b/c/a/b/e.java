package d.b.c.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f69367a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f69368b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f69369c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f69367a = bVar;
            this.f69368b = proxy;
            this.f69369c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f69367a;
    }

    public Proxy b() {
        return this.f69368b;
    }

    public InetSocketAddress c() {
        return this.f69369c;
    }

    public boolean d() {
        return this.f69367a.f69345i != null && this.f69368b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f69367a.equals(this.f69367a) && eVar.f69368b.equals(this.f69368b) && eVar.f69369c.equals(this.f69369c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f69367a.hashCode()) * 31) + this.f69368b.hashCode()) * 31) + this.f69369c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f69369c + "}";
    }
}
