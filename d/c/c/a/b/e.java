package d.c.c.a.b;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f65475a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f65476b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f65477c;

    public e(b bVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (bVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f65475a = bVar;
            this.f65476b = proxy;
            this.f65477c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public b a() {
        return this.f65475a;
    }

    public Proxy b() {
        return this.f65476b;
    }

    public InetSocketAddress c() {
        return this.f65477c;
    }

    public boolean d() {
        return this.f65475a.i != null && this.f65476b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f65475a.equals(this.f65475a) && eVar.f65476b.equals(this.f65476b) && eVar.f65477c.equals(this.f65477c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.f65475a.hashCode()) * 31) + this.f65476b.hashCode()) * 31) + this.f65477c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f65477c + "}";
    }
}
