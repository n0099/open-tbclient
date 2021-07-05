package d.a.t0.b;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f70486a;

    /* renamed from: b  reason: collision with root package name */
    public String f70487b;

    /* renamed from: c  reason: collision with root package name */
    public int f70488c;

    /* renamed from: d  reason: collision with root package name */
    public int f70489d;

    /* renamed from: e  reason: collision with root package name */
    public long f70490e;

    /* renamed from: f  reason: collision with root package name */
    public long f70491f;

    /* renamed from: g  reason: collision with root package name */
    public long f70492g;

    /* renamed from: h  reason: collision with root package name */
    public long f70493h;

    /* renamed from: i  reason: collision with root package name */
    public long f70494i;

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
        this.f70488c = -14;
        this.f70489d = -1;
        this.f70490e = -1L;
        this.f70491f = -1L;
        this.f70492g = -1L;
        this.f70493h = -1L;
        this.f70494i = -1L;
        this.f70486a = str;
        this.f70492g = System.nanoTime() / 1000;
        this.f70491f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f70488c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f70488c = -2;
            } else if (exc instanceof ConnectException) {
                this.f70488c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f70488c = -3;
            } else if (exc instanceof BindException) {
                this.f70488c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f70488c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f70488c = -9;
            } else if (exc instanceof RemoteException) {
                this.f70488c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f70488c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f70488c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f70488c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f70488c = -11;
            } else {
                this.f70488c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70493h = (System.nanoTime() / 1000) - this.f70492g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f70494i = (System.nanoTime() / 1000) - this.f70492g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f70486a, this.f70487b, Integer.valueOf(this.f70488c), Integer.valueOf(this.f70489d), Long.valueOf(this.f70490e), Long.valueOf(this.f70491f), Long.valueOf(this.f70493h), Long.valueOf(this.f70494i)));
            turbonetEngine.g(this.f70486a, this.f70487b, this.f70488c, this.f70489d, this.f70490e, this.f70491f, this.f70493h, this.f70494i);
        }
    }
}
