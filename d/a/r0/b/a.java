package d.a.r0.b;

import android.os.RemoteException;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.TurbonetEngine;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f67657a;

    /* renamed from: b  reason: collision with root package name */
    public String f67658b;

    /* renamed from: c  reason: collision with root package name */
    public int f67659c;

    /* renamed from: d  reason: collision with root package name */
    public int f67660d;

    /* renamed from: e  reason: collision with root package name */
    public long f67661e;

    /* renamed from: f  reason: collision with root package name */
    public long f67662f;

    /* renamed from: g  reason: collision with root package name */
    public long f67663g;

    /* renamed from: h  reason: collision with root package name */
    public long f67664h;

    /* renamed from: i  reason: collision with root package name */
    public long f67665i;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67659c = -14;
        this.f67660d = -1;
        this.f67661e = -1L;
        this.f67662f = -1L;
        this.f67663g = -1L;
        this.f67664h = -1L;
        this.f67665i = -1L;
        this.f67657a = str;
        this.f67663g = System.nanoTime() / 1000;
        this.f67662f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f67659c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f67659c = -2;
            } else if (exc instanceof ConnectException) {
                this.f67659c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f67659c = -3;
            } else if (exc instanceof BindException) {
                this.f67659c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f67659c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f67659c = -9;
            } else if (exc instanceof RemoteException) {
                this.f67659c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f67659c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f67659c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f67659c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f67659c = -11;
            } else {
                this.f67659c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67664h = (System.nanoTime() / 1000) - this.f67663g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67665i = (System.nanoTime() / 1000) - this.f67663g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f67657a, this.f67658b, Integer.valueOf(this.f67659c), Integer.valueOf(this.f67660d), Long.valueOf(this.f67661e), Long.valueOf(this.f67662f), Long.valueOf(this.f67664h), Long.valueOf(this.f67665i)));
            turbonetEngine.g(this.f67657a, this.f67658b, this.f67659c, this.f67660d, this.f67661e, this.f67662f, this.f67664h, this.f67665i);
        }
    }
}
