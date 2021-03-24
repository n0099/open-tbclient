package okhttp3;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public final class Route {
    public final Address address;
    public final InetSocketAddress inetSocketAddress;
    public final Proxy proxy;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.address = address;
            this.proxy = proxy;
            this.inetSocketAddress = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public Address address() {
        return this.address;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.address.equals(this.address) && route.proxy.equals(this.proxy) && route.inetSocketAddress.equals(this.inetSocketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public String toString() {
        return "Route{" + this.inetSocketAddress + "}";
    }
}
