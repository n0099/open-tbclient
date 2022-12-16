package okhttp3.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public static EventListener sGloablEventListener;
    public transient /* synthetic */ FieldHolder $fh;
    public EventListener interalListener;

    public WrappedEventListener(EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eventListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.interalListener = eventListener;
    }

    public static void setGlobalEventListener(EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, eventListener) == null) {
            sGloablEventListener = eventListener;
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.callEnd(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.callEnd(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.callStart(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.callStart(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchEnd(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.callThreadSwitchEnd(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.callThreadSwitchEnd(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchInQueue(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.callThreadSwitchInQueue(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.callThreadSwitchInQueue(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.callThreadSwitchStart(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.callThreadSwitchStart(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.requestBodyStart(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.requestBodyStart(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.requestHeadersStart(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.requestHeadersStart(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.responseBodyStart(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.responseBodyStart(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.responseHeadersStart(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.responseHeadersStart(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, call) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.secureConnectStart(call);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.secureConnectStart(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, iOException) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.callFailed(call, iOException);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.callFailed(call, iOException);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, call, connection) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.connectionAcquired(call, connection);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.connectionAcquired(call, connection);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, call, connection) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.connectionReleased(call, connection);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.connectionReleased(call, connection);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, call, str) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.dnsStart(call, str);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.dnsStart(call, str);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, call, j) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.requestBodyEnd(call, j);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.requestBodyEnd(call, j);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, call, request) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.requestHeadersEnd(call, request);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.requestHeadersEnd(call, request);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048593, this, call, j) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.responseBodyEnd(call, j);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.responseBodyEnd(call, j);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, call, response) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.responseHeadersEnd(call, response);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.responseHeadersEnd(call, response);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, call, handshake) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.secureConnectEnd(call, handshake);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.secureConnectEnd(call, handshake);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, call, inetSocketAddress, proxy, protocol) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.connectEnd(call, inetSocketAddress, proxy, protocol);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, call, inetSocketAddress, proxy, protocol, iOException) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, call, inetSocketAddress, proxy) == null) {
            EventListener eventListener = this.interalListener;
            if (eventListener != null) {
                eventListener.connectStart(call, inetSocketAddress, proxy);
            }
            EventListener eventListener2 = sGloablEventListener;
            if (eventListener2 != null) {
                eventListener2.connectStart(call, inetSocketAddress, proxy);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, call, str, list) == null) {
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
}
