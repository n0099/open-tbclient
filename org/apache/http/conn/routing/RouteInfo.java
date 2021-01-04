package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;
@Deprecated
/* loaded from: classes6.dex */
public interface RouteInfo {

    /* loaded from: classes6.dex */
    public enum LayerType {
        LAYERED,
        PLAIN
    }

    /* loaded from: classes6.dex */
    public enum TunnelType {
        PLAIN,
        TUNNELLED
    }

    int getHopCount();

    HttpHost getHopTarget(int i);

    LayerType getLayerType();

    InetAddress getLocalAddress();

    HttpHost getProxyHost();

    HttpHost getTargetHost();

    TunnelType getTunnelType();

    boolean isLayered();

    boolean isSecure();

    boolean isTunnelled();
}
