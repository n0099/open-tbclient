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
    public String f63792a;

    /* renamed from: b  reason: collision with root package name */
    public String f63793b;

    /* renamed from: f  reason: collision with root package name */
    public long f63797f;

    /* renamed from: g  reason: collision with root package name */
    public long f63798g;

    /* renamed from: c  reason: collision with root package name */
    public int f63794c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f63795d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f63796e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f63799h = -1;
    public long i = -1;

    public a(String str) {
        this.f63797f = -1L;
        this.f63798g = -1L;
        this.f63792a = str;
        this.f63798g = System.nanoTime() / 1000;
        this.f63797f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f63794c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f63794c = -2;
        } else if (exc instanceof ConnectException) {
            this.f63794c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f63794c = -3;
        } else if (exc instanceof BindException) {
            this.f63794c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f63794c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f63794c = -9;
        } else if (exc instanceof RemoteException) {
            this.f63794c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f63794c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f63794c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f63794c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f63794c = -11;
        } else {
            this.f63794c = -14;
        }
    }

    public void b() {
        this.f63799h = (System.nanoTime() / 1000) - this.f63798g;
    }

    public void c() {
        this.i = (System.nanoTime() / 1000) - this.f63798g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f63792a, this.f63793b, Integer.valueOf(this.f63794c), Integer.valueOf(this.f63795d), Long.valueOf(this.f63796e), Long.valueOf(this.f63797f), Long.valueOf(this.f63799h), Long.valueOf(this.i)));
        turbonetEngine.g(this.f63792a, this.f63793b, this.f63794c, this.f63795d, this.f63796e, this.f63797f, this.f63799h, this.i);
    }
}
