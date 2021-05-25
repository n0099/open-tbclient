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
    public String f63837a;

    /* renamed from: b  reason: collision with root package name */
    public String f63838b;

    /* renamed from: f  reason: collision with root package name */
    public long f63842f;

    /* renamed from: g  reason: collision with root package name */
    public long f63843g;

    /* renamed from: c  reason: collision with root package name */
    public int f63839c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f63840d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f63841e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f63844h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f63845i = -1;

    public a(String str) {
        this.f63842f = -1L;
        this.f63843g = -1L;
        this.f63837a = str;
        this.f63843g = System.nanoTime() / 1000;
        this.f63842f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f63839c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f63839c = -2;
        } else if (exc instanceof ConnectException) {
            this.f63839c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f63839c = -3;
        } else if (exc instanceof BindException) {
            this.f63839c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f63839c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f63839c = -9;
        } else if (exc instanceof RemoteException) {
            this.f63839c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f63839c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f63839c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f63839c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f63839c = -11;
        } else {
            this.f63839c = -14;
        }
    }

    public void b() {
        this.f63844h = (System.nanoTime() / 1000) - this.f63843g;
    }

    public void c() {
        this.f63845i = (System.nanoTime() / 1000) - this.f63843g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f63837a, this.f63838b, Integer.valueOf(this.f63839c), Integer.valueOf(this.f63840d), Long.valueOf(this.f63841e), Long.valueOf(this.f63842f), Long.valueOf(this.f63844h), Long.valueOf(this.f63845i)));
        turbonetEngine.g(this.f63837a, this.f63838b, this.f63839c, this.f63840d, this.f63841e, this.f63842f, this.f63844h, this.f63845i);
    }
}
