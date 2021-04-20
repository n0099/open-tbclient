package d.b.j0.b;

import android.os.RemoteException;
import android.util.Log;
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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f64492a;

    /* renamed from: b  reason: collision with root package name */
    public String f64493b;

    /* renamed from: f  reason: collision with root package name */
    public long f64497f;

    /* renamed from: g  reason: collision with root package name */
    public long f64498g;

    /* renamed from: c  reason: collision with root package name */
    public int f64494c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f64495d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f64496e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f64499h = -1;
    public long i = -1;

    public a(String str) {
        this.f64497f = -1L;
        this.f64498g = -1L;
        this.f64492a = str;
        this.f64498g = System.nanoTime() / 1000;
        this.f64497f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f64494c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f64494c = -2;
        } else if (exc instanceof ConnectException) {
            this.f64494c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f64494c = -3;
        } else if (exc instanceof BindException) {
            this.f64494c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f64494c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f64494c = -9;
        } else if (exc instanceof RemoteException) {
            this.f64494c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f64494c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f64494c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f64494c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f64494c = -11;
        } else {
            this.f64494c = -14;
        }
    }

    public void b() {
        this.f64499h = (System.nanoTime() / 1000) - this.f64498g;
    }

    public void c() {
        this.i = (System.nanoTime() / 1000) - this.f64498g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f64492a, this.f64493b, Integer.valueOf(this.f64494c), Integer.valueOf(this.f64495d), Long.valueOf(this.f64496e), Long.valueOf(this.f64497f), Long.valueOf(this.f64499h), Long.valueOf(this.i)));
        turbonetEngine.g(this.f64492a, this.f64493b, this.f64494c, this.f64495d, this.f64496e, this.f64497f, this.f64499h, this.i);
    }
}
