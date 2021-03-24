package d.c.c.a.b;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f65474a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f65475b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f65476c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f65474a = bVar;
            this.f65475b = proxy;
            this.f65476c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f65474a;
    }

    public Proxy b() {
        return this.f65475b;
    }

    public InetSocketAddress c() {
        return this.f65476c;
    }

    public boolean d() {
        return this.f65474a.i != null && this.f65475b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f65474a.equals(this.f65474a) && eVar.f65475b.equals(this.f65475b) && eVar.f65476c.equals(this.f65476c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.f65474a.hashCode()) * 31) + this.f65475b.hashCode()) * 31) + this.f65476c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f65476c + "}";
    }
}
