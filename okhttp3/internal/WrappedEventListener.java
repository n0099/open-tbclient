package okhttp3.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class WrappedEventListener extends EventListener {
    public static EventListener sGloablEventListener;
    public EventListener interalListener;

    public WrappedEventListener(EventListener eventListener) {
        this.interalListener = eventListener;
    }

    public static void setGlobalEventListener(EventListener eventListener) {
        sGloablEventListener = eventListener;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchEnd(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.callThreadSwitchEnd(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.callThreadSwitchEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchInQueue(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.callThreadSwitchInQueue(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.callThreadSwitchInQueue(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchStart(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.callThreadSwitchStart(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.callThreadSwitchStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.secureConnectStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.callFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.dnsStart(call, str);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.requestBodyEnd(call, j);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.requestHeadersEnd(call, request);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.responseBodyEnd(call, j);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        EventListener eventListener = this.interalListener;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
        EventListener eventListener2 = sGloablEventListener;
        if (eventListener2 != null) {
            eventListener2.dnsEnd(call, str, list);
        }
    }
}
