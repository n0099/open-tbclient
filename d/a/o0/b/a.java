package d.a.o0.b;

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
    public String f67555a;

    /* renamed from: b  reason: collision with root package name */
    public String f67556b;

    /* renamed from: f  reason: collision with root package name */
    public long f67560f;

    /* renamed from: g  reason: collision with root package name */
    public long f67561g;

    /* renamed from: c  reason: collision with root package name */
    public int f67557c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f67558d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f67559e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f67562h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f67563i = -1;

    public a(String str) {
        this.f67560f = -1L;
        this.f67561g = -1L;
        this.f67555a = str;
        this.f67561g = System.nanoTime() / 1000;
        this.f67560f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f67557c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f67557c = -2;
        } else if (exc instanceof ConnectException) {
            this.f67557c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f67557c = -3;
        } else if (exc instanceof BindException) {
            this.f67557c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f67557c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f67557c = -9;
        } else if (exc instanceof RemoteException) {
            this.f67557c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f67557c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f67557c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f67557c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f67557c = -11;
        } else {
            this.f67557c = -14;
        }
    }

    public void b() {
        this.f67562h = (System.nanoTime() / 1000) - this.f67561g;
    }

    public void c() {
        this.f67563i = (System.nanoTime() / 1000) - this.f67561g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f67555a, this.f67556b, Integer.valueOf(this.f67557c), Integer.valueOf(this.f67558d), Long.valueOf(this.f67559e), Long.valueOf(this.f67560f), Long.valueOf(this.f67562h), Long.valueOf(this.f67563i)));
        turbonetEngine.g(this.f67555a, this.f67556b, this.f67557c, this.f67558d, this.f67559e, this.f67560f, this.f67562h, this.f67563i);
    }
}
