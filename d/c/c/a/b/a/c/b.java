package d.c.c.a.b.a.c;

import d.c.c.a.b.o;
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
    public final List<o> f66126a;

    /* renamed from: b  reason: collision with root package name */
    public int f66127b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66128c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66129d;

    public b(List<o> list) {
        this.f66126a = list;
    }

    public o a(SSLSocket sSLSocket) throws IOException {
        o oVar;
        int i = this.f66127b;
        int size = this.f66126a.size();
        while (true) {
            if (i >= size) {
                oVar = null;
                break;
            }
            oVar = this.f66126a.get(i);
            if (oVar.c(sSLSocket)) {
                this.f66127b = i + 1;
                break;
            }
            i++;
        }
        if (oVar != null) {
            this.f66128c = c(sSLSocket);
            d.c.c.a.b.a.b.f66124a.e(oVar, sSLSocket, this.f66129d);
            return oVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f66129d + ", modes=" + this.f66126a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f66129d = true;
        if (!this.f66128c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    public final boolean c(SSLSocket sSLSocket) {
        for (int i = this.f66127b; i < this.f66126a.size(); i++) {
            if (this.f66126a.get(i).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
