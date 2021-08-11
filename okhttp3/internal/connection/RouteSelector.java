package okhttp3.internal.connection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
public final class RouteSelector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Address address;
    public final Call call;
    public final EventListener eventListener;
    public List<InetSocketAddress> inetSocketAddresses;
    public int nextProxyIndex;
    public final List<Route> postponedRoutes;
    public List<Proxy> proxies;
    public final RouteDatabase routeDatabase;

    /* loaded from: classes2.dex */
    public static final class Selection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int nextRouteIndex;
        public final List<Route> routes;

        public Selection(List<Route> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.nextRouteIndex = 0;
            this.routes = list;
        }

        public List<Route> getAll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ArrayList(this.routes) : (List) invokeV.objValue;
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.nextRouteIndex < this.routes.size() : invokeV.booleanValue;
        }

        public Route next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (hasNext()) {
                    List<Route> list = this.routes;
                    int i2 = this.nextRouteIndex;
                    this.nextRouteIndex = i2 + 1;
                    return list.get(i2);
                }
                throw new NoSuchElementException();
            }
            return (Route) invokeV.objValue;
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {address, routeDatabase, call, eventListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.proxies = Collections.emptyList();
        this.inetSocketAddresses = Collections.emptyList();
        this.postponedRoutes = new ArrayList();
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        resetNextProxy(address.url(), address.proxy());
    }

    public static String getHostString(InetSocketAddress inetSocketAddress) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inetSocketAddress)) == null) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                return inetSocketAddress.getHostName();
            }
            return address.getHostAddress();
        }
        return (String) invokeL.objValue;
    }

    private boolean hasNextProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.nextProxyIndex < this.proxies.size() : invokeV.booleanValue;
    }

    private Proxy nextProxy() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (hasNextProxy()) {
                List<Proxy> list = this.proxies;
                int i2 = this.nextProxyIndex;
                this.nextProxyIndex = i2 + 1;
                Proxy proxy = list.get(i2);
                resetNextInetSocketAddress(proxy);
                return proxy;
            }
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
        }
        return (Proxy) invokeV.objValue;
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String host;
        int port;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, proxy) == null) {
            this.inetSocketAddresses = new ArrayList();
            if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
                SocketAddress address = proxy.address();
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    host = getHostString(inetSocketAddress);
                    port = inetSocketAddress.getPort();
                } else {
                    throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
                }
            } else {
                host = this.address.url().host();
                port = this.address.url().port();
            }
            if (port >= 1 && port <= 65535) {
                if (proxy.type() == Proxy.Type.SOCKS) {
                    this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(host, port));
                    return;
                }
                this.eventListener.dnsStart(this.call, host);
                List<InetAddress> lookup = this.address.dns().lookup(host);
                if (!lookup.isEmpty()) {
                    this.eventListener.dnsEnd(this.call, host, lookup);
                    int size = lookup.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.inetSocketAddresses.add(new InetSocketAddress(lookup.get(i2), port));
                    }
                    return;
                }
                throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
            }
            throw new SocketException("No route to " + host + ":" + port + "; port is out of range");
        }
    }

    private void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, httpUrl, proxy) == null) {
            if (proxy != null) {
                this.proxies = Collections.singletonList(proxy);
            } else {
                List<Proxy> select = this.address.proxySelector().select(httpUrl.uri());
                this.proxies = (select == null || select.isEmpty()) ? Util.immutableList(Proxy.NO_PROXY) : Util.immutableList(select);
            }
            this.nextProxyIndex = 0;
        }
    }

    public void connectFailed(Route route, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, route, iOException) == null) {
            if (route.proxy().type() != Proxy.Type.DIRECT && this.address.proxySelector() != null) {
                this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
            }
            this.routeDatabase.failed(route);
        }
    }

    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hasNextProxy() || !this.postponedRoutes.isEmpty() : invokeV.booleanValue;
    }

    public Selection next() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (hasNext()) {
                ArrayList arrayList = new ArrayList();
                while (hasNextProxy()) {
                    Proxy nextProxy = nextProxy();
                    int size = this.inetSocketAddresses.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Route route = new Route(this.address, nextProxy, this.inetSocketAddresses.get(i2));
                        if (this.routeDatabase.shouldPostpone(route)) {
                            this.postponedRoutes.add(route);
                        } else {
                            arrayList.add(route);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(this.postponedRoutes);
                    this.postponedRoutes.clear();
                }
                return new Selection(arrayList);
            }
            throw new NoSuchElementException();
        }
        return (Selection) invokeV.objValue;
    }
}
