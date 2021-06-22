package d.a.p0.b;

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
    public String f67659a;

    /* renamed from: b  reason: collision with root package name */
    public String f67660b;

    /* renamed from: f  reason: collision with root package name */
    public long f67664f;

    /* renamed from: g  reason: collision with root package name */
    public long f67665g;

    /* renamed from: c  reason: collision with root package name */
    public int f67661c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f67662d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f67663e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f67666h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f67667i = -1;

    public a(String str) {
        this.f67664f = -1L;
        this.f67665g = -1L;
        this.f67659a = str;
        this.f67665g = System.nanoTime() / 1000;
        this.f67664f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f67661c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f67661c = -2;
        } else if (exc instanceof ConnectException) {
            this.f67661c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f67661c = -3;
        } else if (exc instanceof BindException) {
            this.f67661c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f67661c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f67661c = -9;
        } else if (exc instanceof RemoteException) {
            this.f67661c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f67661c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f67661c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f67661c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f67661c = -11;
        } else {
            this.f67661c = -14;
        }
    }

    public void b() {
        this.f67666h = (System.nanoTime() / 1000) - this.f67665g;
    }

    public void c() {
        this.f67667i = (System.nanoTime() / 1000) - this.f67665g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f67659a, this.f67660b, Integer.valueOf(this.f67661c), Integer.valueOf(this.f67662d), Long.valueOf(this.f67663e), Long.valueOf(this.f67664f), Long.valueOf(this.f67666h), Long.valueOf(this.f67667i)));
        turbonetEngine.g(this.f67659a, this.f67660b, this.f67661c, this.f67662d, this.f67663e, this.f67664f, this.f67666h, this.f67667i);
    }
}
