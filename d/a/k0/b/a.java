package d.a.k0.b;

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
    public String f63083a;

    /* renamed from: b  reason: collision with root package name */
    public String f63084b;

    /* renamed from: f  reason: collision with root package name */
    public long f63088f;

    /* renamed from: g  reason: collision with root package name */
    public long f63089g;

    /* renamed from: c  reason: collision with root package name */
    public int f63085c = -14;

    /* renamed from: d  reason: collision with root package name */
    public int f63086d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f63087e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f63090h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f63091i = -1;

    public a(String str) {
        this.f63088f = -1L;
        this.f63089g = -1L;
        this.f63083a = str;
        this.f63089g = System.nanoTime() / 1000;
        this.f63088f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.f63085c = -1;
        } else if (exc instanceof UnknownHostException) {
            this.f63085c = -2;
        } else if (exc instanceof ConnectException) {
            this.f63085c = -5;
        } else if (exc instanceof ProtocolException) {
            this.f63085c = -3;
        } else if (exc instanceof BindException) {
            this.f63085c = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.f63085c = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.f63085c = -9;
        } else if (exc instanceof RemoteException) {
            this.f63085c = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.f63085c = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.f63085c = -7;
        } else if (exc instanceof SSLKeyException) {
            this.f63085c = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.f63085c = -11;
        } else {
            this.f63085c = -14;
        }
    }

    public void b() {
        this.f63090h = (System.nanoTime() / 1000) - this.f63089g;
    }

    public void c() {
        this.f63091i = (System.nanoTime() / 1000) - this.f63089g;
    }

    public void d(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f63083a, this.f63084b, Integer.valueOf(this.f63085c), Integer.valueOf(this.f63086d), Long.valueOf(this.f63087e), Long.valueOf(this.f63088f), Long.valueOf(this.f63090h), Long.valueOf(this.f63091i)));
        turbonetEngine.g(this.f63083a, this.f63084b, this.f63085c, this.f63086d, this.f63087e, this.f63088f, this.f63090h, this.f63091i);
    }
}
