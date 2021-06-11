package d.b.c.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f69263a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f69264b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f69265c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f69263a = bVar;
            this.f69264b = proxy;
            this.f69265c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f69263a;
    }

    public Proxy b() {
        return this.f69264b;
    }

    public InetSocketAddress c() {
        return this.f69265c;
    }

    public boolean d() {
        return this.f69263a.f69241i != null && this.f69264b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f69263a.equals(this.f69263a) && eVar.f69264b.equals(this.f69264b) && eVar.f69265c.equals(this.f69265c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f69263a.hashCode()) * 31) + this.f69264b.hashCode()) * 31) + this.f69265c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f69265c + "}";
    }
}
