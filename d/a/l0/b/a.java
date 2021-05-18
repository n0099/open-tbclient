package d.a.l0.b;

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
    public String f63787a;

    /* renamed from: b  reason: collision with root package name */
    public String f63788b;

    /* renamed from: f  reason: collision with root package name */
    public long f63792f;

    /* renamed from: g  reason: collision with root package name */
    public long f63793g;

    /* renamed from: c  reason: collision with root package name */
    public int f63789c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f63790d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f63791e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f63794h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f63795i = -1;

    public a(String str) {
        this.f63792f = -1L;
        this.f63793g = -1L;
        this.f63787a = str;
        this.f63793g = System.nanoTime() / 1000;
        this.f63792f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f63789c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f63789c = -2;
        } else if (exc instanceof ConnectException) {
            this.f63789c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f63789c = -3;
        } else if (exc instanceof BindException) {
            this.f63789c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f63789c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f63789c = -9;
        } else if (exc instanceof RemoteException) {
            this.f63789c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f63789c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f63789c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f63789c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f63789c = -11;
        } else {
            this.f63789c = -14;
        }
    }

    public void b() {
        this.f63794h = (System.nanoTime() / 1000) - this.f63793g;
    }

    public void c() {
        this.f63795i = (System.nanoTime() / 1000) - this.f63793g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f63787a, this.f63788b, Integer.valueOf(this.f63789c), Integer.valueOf(this.f63790d), Long.valueOf(this.f63791e), Long.valueOf(this.f63792f), Long.valueOf(this.f63794h), Long.valueOf(this.f63795i)));
        turbonetEngine.g(this.f63787a, this.f63788b, this.f63789c, this.f63790d, this.f63791e, this.f63792f, this.f63794h, this.f63795i);
    }
}
