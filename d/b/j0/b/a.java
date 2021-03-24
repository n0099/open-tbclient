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
    public String f63791a;

    /* renamed from: b  reason: collision with root package name */
    public String f63792b;

    /* renamed from: f  reason: collision with root package name */
    public long f63796f;

    /* renamed from: g  reason: collision with root package name */
    public long f63797g;

    /* renamed from: c  reason: collision with root package name */
    public int f63793c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f63794d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f63795e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f63798h = -1;
    public long i = -1;

    public a(String str) {
        this.f63796f = -1L;
        this.f63797g = -1L;
        this.f63791a = str;
        this.f63797g = System.nanoTime() / 1000;
        this.f63796f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f63793c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f63793c = -2;
        } else if (exc instanceof ConnectException) {
            this.f63793c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f63793c = -3;
        } else if (exc instanceof BindException) {
            this.f63793c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f63793c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f63793c = -9;
        } else if (exc instanceof RemoteException) {
            this.f63793c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f63793c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f63793c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f63793c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f63793c = -11;
        } else {
            this.f63793c = -14;
        }
    }

    public void b() {
        this.f63798h = (System.nanoTime() / 1000) - this.f63797g;
    }

    public void c() {
        this.i = (System.nanoTime() / 1000) - this.f63797g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f63791a, this.f63792b, Integer.valueOf(this.f63793c), Integer.valueOf(this.f63794d), Long.valueOf(this.f63795e), Long.valueOf(this.f63796f), Long.valueOf(this.f63798h), Long.valueOf(this.i)));
        turbonetEngine.g(this.f63791a, this.f63792b, this.f63793c, this.f63794d, this.f63795e, this.f63796f, this.f63798h, this.i);
    }
}
