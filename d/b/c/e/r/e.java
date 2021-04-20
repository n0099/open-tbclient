package d.b.c.e.r;

import com.baidu.adp.lib.util.BdLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.c.e.r.b f42567a;

    /* loaded from: classes.dex */
    public interface a {
        String a();

        int b();

        String c();

        void close() throws IOException;

        long d();

        String getLocalDns();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* loaded from: classes.dex */
    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SocketChannel f42568a;

        /* renamed from: b  reason: collision with root package name */
        public long f42569b;

        /* renamed from: c  reason: collision with root package name */
        public String f42570c;

        /* renamed from: d  reason: collision with root package name */
        public String f42571d;

        /* renamed from: e  reason: collision with root package name */
        public String f42572e;

        public b(String str, int i, d0 d0Var) throws Exception {
            this.f42568a = null;
            this.f42569b = 0L;
            this.f42570c = null;
            this.f42571d = null;
            this.f42572e = null;
            this.f42568a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42570c = inetSocketAddress.getAddress().getHostAddress();
                this.f42569b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42568a.socket().connect(inetSocketAddress, d0Var.e());
            this.f42568a.socket().setSoTimeout(d0Var.f());
            this.f42568a.socket().setTcpNoDelay(d0Var.g());
            this.f42571d = d.b.c.e.p.l.m();
            this.f42572e = d.b.c.e.p.l.n();
        }

        @Override // d.b.c.e.r.e.a
        public String a() {
            return this.f42570c;
        }

        @Override // d.b.c.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.c.e.r.e.a
        public String c() {
            return this.f42572e;
        }

        @Override // d.b.c.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f42568a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.b.c.e.r.e.a
        public long d() {
            return this.f42569b;
        }

        @Override // d.b.c.e.r.e.a
        public String getLocalDns() {
            return this.f42571d;
        }

        @Override // d.b.c.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f42568a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.b.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f42568a.read(byteBuffer);
        }

        @Override // d.b.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f42568a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f42573a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f42574b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f42575c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f42576d;

        /* renamed from: e  reason: collision with root package name */
        public long f42577e;

        /* renamed from: f  reason: collision with root package name */
        public String f42578f;

        /* renamed from: g  reason: collision with root package name */
        public String f42579g;

        /* renamed from: h  reason: collision with root package name */
        public String f42580h;

        public c(String str, int i, d0 d0Var) throws Exception {
            this.f42573a = null;
            this.f42574b = null;
            this.f42575c = null;
            this.f42576d = null;
            this.f42577e = 0L;
            this.f42578f = null;
            this.f42579g = null;
            this.f42580h = null;
            this.f42573a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42578f = inetSocketAddress.getAddress().getHostAddress();
                this.f42577e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42573a.connect(inetSocketAddress, d0Var.e());
            this.f42573a.setSoTimeout(d0Var.f());
            this.f42573a.setTcpNoDelay(d0Var.g());
            this.f42574b = this.f42573a.getInputStream();
            this.f42575c = this.f42573a.getOutputStream();
            this.f42576d = new byte[1024];
            this.f42579g = d.b.c.e.p.l.m();
            this.f42580h = d.b.c.e.p.l.n();
        }

        @Override // d.b.c.e.r.e.a
        public String a() {
            return this.f42578f;
        }

        @Override // d.b.c.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.c.e.r.e.a
        public String c() {
            return this.f42580h;
        }

        @Override // d.b.c.e.r.e.a
        public void close() throws IOException {
            try {
                this.f42574b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f42575c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f42573a;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e4) {
                    throw e4;
                } catch (Throwable unused) {
                }
            }
        }

        @Override // d.b.c.e.r.e.a
        public long d() {
            return this.f42577e;
        }

        @Override // d.b.c.e.r.e.a
        public String getLocalDns() {
            return this.f42579g;
        }

        @Override // d.b.c.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f42573a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.b.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f42574b.read(this.f42576d);
            if (read > 0) {
                byteBuffer.put(this.f42576d, 0, read);
            }
            return read;
        }

        @Override // d.b.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f42575c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i, d0 d0Var, boolean z) throws Exception {
        d.b.c.e.r.b bVar = f42567a;
        if (bVar != null) {
            return bVar.a(str, i, d0Var);
        }
        if (z) {
            return new b(str, i, d0Var);
        }
        return new c(str, i, d0Var);
    }
}
