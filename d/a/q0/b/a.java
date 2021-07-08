package d.a.q0.b;

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
    public String f66979a;

    /* renamed from: b  reason: collision with root package name */
    public String f66980b;

    /* renamed from: c  reason: collision with root package name */
    public int f66981c;

    /* renamed from: d  reason: collision with root package name */
    public int f66982d;

    /* renamed from: e  reason: collision with root package name */
    public long f66983e;

    /* renamed from: f  reason: collision with root package name */
    public long f66984f;

    /* renamed from: g  reason: collision with root package name */
    public long f66985g;

    /* renamed from: h  reason: collision with root package name */
    public long f66986h;

    /* renamed from: i  reason: collision with root package name */
    public long f66987i;

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
        this.f66981c = -14;
        this.f66982d = -1;
        this.f66983e = -1L;
        this.f66984f = -1L;
        this.f66985g = -1L;
        this.f66986h = -1L;
        this.f66987i = -1L;
        this.f66979a = str;
        this.f66985g = System.nanoTime() / 1000;
        this.f66984f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f66981c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f66981c = -2;
            } else if (exc instanceof ConnectException) {
                this.f66981c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f66981c = -3;
            } else if (exc instanceof BindException) {
                this.f66981c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f66981c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f66981c = -9;
            } else if (exc instanceof RemoteException) {
                this.f66981c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f66981c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f66981c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f66981c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f66981c = -11;
            } else {
                this.f66981c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f66986h = (System.nanoTime() / 1000) - this.f66985g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66987i = (System.nanoTime() / 1000) - this.f66985g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f66979a, this.f66980b, Integer.valueOf(this.f66981c), Integer.valueOf(this.f66982d), Long.valueOf(this.f66983e), Long.valueOf(this.f66984f), Long.valueOf(this.f66986h), Long.valueOf(this.f66987i)));
            turbonetEngine.g(this.f66979a, this.f66980b, this.f66981c, this.f66982d, this.f66983e, this.f66984f, this.f66986h, this.f66987i);
        }
    }
}
