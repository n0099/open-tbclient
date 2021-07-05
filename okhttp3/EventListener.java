package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public abstract class EventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final EventListener NONE;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1777814969, "Lokhttp3/EventListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1777814969, "Lokhttp3/EventListener;");
                return;
            }
        }
        NONE = new EventListener() { // from class: okhttp3.EventListener.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
    }

    public EventListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Factory factory(EventListener eventListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eventListener)) == null) ? new Factory(eventListener) { // from class: okhttp3.EventListener.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EventListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eventListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$listener = eventListener;
            }

            @Override // okhttp3.EventListener.Factory
            public EventListener create(Call call) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, call)) == null) ? this.val$listener : (EventListener) invokeL2.objValue;
            }
        } : (Factory) invokeL.objValue;
    }

    public void callEnd(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, call) == null) {
        }
    }

    public void callFailed(Call call, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, iOException) == null) {
        }
    }

    public void callStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, call) == null) {
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, call, inetSocketAddress, proxy, protocol) == null) {
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, call, inetSocketAddress, proxy, protocol, iOException) == null) {
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, call, inetSocketAddress, proxy) == null) {
        }
    }

    public void connectionAcquired(Call call, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, call, connection) == null) {
        }
    }

    public void connectionReleased(Call call, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, call, connection) == null) {
        }
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, call, str, list) == null) {
        }
    }

    public void dnsStart(Call call, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, call, str) == null) {
        }
    }

    public void requestBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, call, j) == null) {
        }
    }

    public void requestBodyStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, call) == null) {
        }
    }

    public void requestHeadersEnd(Call call, Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, call, request) == null) {
        }
    }

    public void requestHeadersStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, call) == null) {
        }
    }

    public void responseBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, call, j) == null) {
        }
    }

    public void responseBodyStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, call) == null) {
        }
    }

    public void responseHeadersEnd(Call call, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, call, response) == null) {
        }
    }

    public void responseHeadersStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, call) == null) {
        }
    }

    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, call, handshake) == null) {
        }
    }

    public void secureConnectStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, call) == null) {
        }
    }
}
