package d.b.c.a.b.a.c;

import d.b.c.a.b.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<o> f64491a;

    /* renamed from: b  reason: collision with root package name */
    public int f64492b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64493c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64494d;

    public b(List<o> list) {
        this.f64491a = list;
    }

    public o a(SSLSocket sSLSocket) throws IOException {
        o oVar;
        int i2 = this.f64492b;
        int size = this.f64491a.size();
        while (true) {
            if (i2 >= size) {
                oVar = null;
                break;
            }
            oVar = this.f64491a.get(i2);
            if (oVar.c(sSLSocket)) {
                this.f64492b = i2 + 1;
                break;
            }
            i2++;
        }
        if (oVar != null) {
            this.f64493c = c(sSLSocket);
            d.b.c.a.b.a.b.f64489a.e(oVar, sSLSocket, this.f64494d);
            return oVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f64494d + ", modes=" + this.f64491a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f64494d = true;
        if (!this.f64493c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    public final boolean c(SSLSocket sSLSocket) {
        for (int i2 = this.f64492b; i2 < this.f64491a.size(); i2++) {
            if (this.f64491a.get(i2).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
