package d.b.c.a.a;

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
    public static final Logger f65133a = Logger.getLogger(k.class.getName());

    /* loaded from: classes5.dex */
    public static class a implements p {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f65134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OutputStream f65135f;

        public a(r rVar, OutputStream outputStream) {
            this.f65134e = rVar;
            this.f65135f = outputStream;
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return this.f65134e;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            s.c(cVar.f65119f, 0L, j);
            while (j > 0) {
                this.f65134e.h();
                n nVar = cVar.f65118e;
                int min = (int) Math.min(j, nVar.f65147c - nVar.f65146b);
                this.f65135f.write(nVar.f65145a, nVar.f65146b, min);
                int i2 = nVar.f65146b + min;
                nVar.f65146b = i2;
                long j2 = min;
                j -= j2;
                cVar.f65119f -= j2;
                if (i2 == nVar.f65147c) {
                    cVar.f65118e = nVar.e();
                    o.b(nVar);
                }
            }
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f65135f.close();
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            this.f65135f.flush();
        }

        public String toString() {
            return "sink(" + this.f65135f + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends d.b.c.a.a.a {
        public final /* synthetic */ Socket k;

        public c(Socket socket) {
            this.k = socket;
        }

        @Override // d.b.c.a.a.a
        public void p() {
            try {
                this.k.close();
            } catch (AssertionError e2) {
                if (k.g(e2)) {
                    Logger logger = k.f65133a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.k, (Throwable) e2);
                    return;
                }
                throw e2;
            } catch (Exception e3) {
                Logger logger2 = k.f65133a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.k, (Throwable) e3);
            }
        }

        @Override // d.b.c.a.a.a
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
                d.b.c.a.a.a i2 = i(socket);
                return i2.i(c(socket.getOutputStream(), i2));
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
                d.b.c.a.a.a i2 = i(socket);
                return i2.j(f(socket.getInputStream(), i2));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static d.b.c.a.a.a i(Socket socket) {
        return new c(socket);
    }

    /* loaded from: classes5.dex */
    public static class b implements q {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f65136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InputStream f65137f;

        public b(r rVar, InputStream inputStream) {
            this.f65136e = rVar;
            this.f65137f = inputStream;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i2 == 0) {
                return 0L;
            } else {
                try {
                    this.f65136e.h();
                    n D = cVar.D(1);
                    int read = this.f65137f.read(D.f65145a, D.f65147c, (int) Math.min(j, 8192 - D.f65147c));
                    if (read == -1) {
                        return -1L;
                    }
                    D.f65147c += read;
                    long j2 = read;
                    cVar.f65119f += j2;
                    return j2;
                } catch (AssertionError e2) {
                    if (k.g(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f65137f.close();
        }

        public String toString() {
            return "source(" + this.f65137f + SmallTailInfo.EMOTION_SUFFIX;
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return this.f65136e;
        }
    }
}
