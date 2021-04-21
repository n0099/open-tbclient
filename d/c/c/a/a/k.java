package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f66083a = Logger.getLogger(k.class.getName());

    /* loaded from: classes5.dex */
    public static class a implements p {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f66084e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OutputStream f66085f;

        public a(r rVar, OutputStream outputStream) {
            this.f66084e = rVar;
            this.f66085f = outputStream;
        }

        @Override // d.c.c.a.a.p
        public r a() {
            return this.f66084e;
        }

        @Override // d.c.c.a.a.p
        public void b(d.c.c.a.a.c cVar, long j) throws IOException {
            s.c(cVar.f66070f, 0L, j);
            while (j > 0) {
                this.f66084e.h();
                n nVar = cVar.f66069e;
                int min = (int) Math.min(j, nVar.f66097c - nVar.f66096b);
                this.f66085f.write(nVar.f66095a, nVar.f66096b, min);
                int i = nVar.f66096b + min;
                nVar.f66096b = i;
                long j2 = min;
                j -= j2;
                cVar.f66070f -= j2;
                if (i == nVar.f66097c) {
                    cVar.f66069e = nVar.e();
                    o.b(nVar);
                }
            }
        }

        @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f66085f.close();
        }

        @Override // d.c.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            this.f66085f.flush();
        }

        public String toString() {
            return "sink(" + this.f66085f + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends d.c.c.a.a.a {
        public final /* synthetic */ Socket k;

        public c(Socket socket) {
            this.k = socket;
        }

        @Override // d.c.c.a.a.a
        public void p() {
            try {
                this.k.close();
            } catch (AssertionError e2) {
                if (k.g(e2)) {
                    Logger logger = k.f66083a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.k, (Throwable) e2);
                    return;
                }
                throw e2;
            } catch (Exception e3) {
                Logger logger2 = k.f66083a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.k, (Throwable) e3);
            }
        }

        @Override // d.c.c.a.a.a
        public IOException r(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public static d a(p pVar) {
        return new l(pVar);
    }

    public static e b(q qVar) {
        return new m(qVar);
    }

    public static p c(OutputStream outputStream, r rVar) {
        if (outputStream != null) {
            if (rVar != null) {
                return new a(rVar, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static p d(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                d.c.c.a.a.a i = i(socket);
                return i.i(c(socket.getOutputStream(), i));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static q e(InputStream inputStream) {
        return f(inputStream, new r());
    }

    public static q f(InputStream inputStream, r rVar) {
        if (inputStream != null) {
            if (rVar != null) {
                return new b(rVar, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static boolean g(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static q h(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                d.c.c.a.a.a i = i(socket);
                return i.j(f(socket.getInputStream(), i));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static d.c.c.a.a.a i(Socket socket) {
        return new c(socket);
    }

    /* loaded from: classes5.dex */
    public static class b implements q {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f66086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InputStream f66087f;

        public b(r rVar, InputStream inputStream) {
            this.f66086e = rVar;
            this.f66087f = inputStream;
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i == 0) {
                return 0L;
            } else {
                try {
                    this.f66086e.h();
                    n D = cVar.D(1);
                    int read = this.f66087f.read(D.f66095a, D.f66097c, (int) Math.min(j, 8192 - D.f66097c));
                    if (read == -1) {
                        return -1L;
                    }
                    D.f66097c += read;
                    long j2 = read;
                    cVar.f66070f += j2;
                    return j2;
                } catch (AssertionError e2) {
                    if (k.g(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f66087f.close();
        }

        public String toString() {
            return "source(" + this.f66087f + SmallTailInfo.EMOTION_SUFFIX;
        }

        @Override // d.c.c.a.a.q
        public r a() {
            return this.f66086e;
        }
    }
}
