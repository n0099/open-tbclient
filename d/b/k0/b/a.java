package d.b.k0.b;

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
    public String f64792a;

    /* renamed from: b  reason: collision with root package name */
    public String f64793b;

    /* renamed from: f  reason: collision with root package name */
    public long f64797f;

    /* renamed from: g  reason: collision with root package name */
    public long f64798g;

    /* renamed from: c  reason: collision with root package name */
    public int f64794c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f64795d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f64796e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f64799h = -1;
    public long i = -1;

    public a(String str) {
        this.f64797f = -1L;
        this.f64798g = -1L;
        this.f64792a = str;
        this.f64798g = System.nanoTime() / 1000;
        this.f64797f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f64794c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f64794c = -2;
        } else if (exc instanceof ConnectException) {
            this.f64794c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f64794c = -3;
        } else if (exc instanceof BindException) {
            this.f64794c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f64794c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f64794c = -9;
        } else if (exc instanceof RemoteException) {
            this.f64794c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f64794c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f64794c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f64794c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f64794c = -11;
        } else {
            this.f64794c = -14;
        }
    }

    public void b() {
        this.f64799h = (System.nanoTime() / 1000) - this.f64798g;
    }

    public void c() {
        this.i = (System.nanoTime() / 1000) - this.f64798g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f64792a, this.f64793b, Integer.valueOf(this.f64794c), Integer.valueOf(this.f64795d), Long.valueOf(this.f64796e), Long.valueOf(this.f64797f), Long.valueOf(this.f64799h), Long.valueOf(this.i)));
        turbonetEngine.g(this.f64792a, this.f64793b, this.f64794c, this.f64795d, this.f64796e, this.f64797f, this.f64799h, this.i);
    }
}
