package d.a.c.e.r;

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
    public static d.a.c.e.r.b f42583a;

    /* loaded from: classes.dex */
    public interface a {
        int a();

        String b();

        long c();

        void close() throws IOException;

        String d();

        String getLocalDns();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* loaded from: classes.dex */
    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SocketChannel f42584a;

        /* renamed from: b  reason: collision with root package name */
        public long f42585b;

        /* renamed from: c  reason: collision with root package name */
        public String f42586c;

        /* renamed from: d  reason: collision with root package name */
        public String f42587d;

        /* renamed from: e  reason: collision with root package name */
        public String f42588e;

        public b(String str, int i2, d0 d0Var) throws Exception {
            this.f42584a = null;
            this.f42585b = 0L;
            this.f42586c = null;
            this.f42587d = null;
            this.f42588e = null;
            this.f42584a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f42586c = inetSocketAddress.getAddress().getHostAddress();
                this.f42585b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42584a.socket().connect(inetSocketAddress, d0Var.e());
            this.f42584a.socket().setSoTimeout(d0Var.f());
            this.f42584a.socket().setTcpNoDelay(d0Var.g());
            this.f42587d = d.a.c.e.p.l.m();
            this.f42588e = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f42588e;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f42585b;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f42584a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.a.c.e.r.e.a
        public String d() {
            return this.f42586c;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f42587d;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f42584a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f42584a.read(byteBuffer);
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f42584a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f42589a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f42590b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f42591c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f42592d;

        /* renamed from: e  reason: collision with root package name */
        public long f42593e;

        /* renamed from: f  reason: collision with root package name */
        public String f42594f;

        /* renamed from: g  reason: collision with root package name */
        public String f42595g;

        /* renamed from: h  reason: collision with root package name */
        public String f42596h;

        public c(String str, int i2, d0 d0Var) throws Exception {
            this.f42589a = null;
            this.f42590b = null;
            this.f42591c = null;
            this.f42592d = null;
            this.f42593e = 0L;
            this.f42594f = null;
            this.f42595g = null;
            this.f42596h = null;
            this.f42589a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f42594f = inetSocketAddress.getAddress().getHostAddress();
                this.f42593e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42589a.connect(inetSocketAddress, d0Var.e());
            this.f42589a.setSoTimeout(d0Var.f());
            this.f42589a.setTcpNoDelay(d0Var.g());
            this.f42590b = this.f42589a.getInputStream();
            this.f42591c = this.f42589a.getOutputStream();
            this.f42592d = new byte[1024];
            this.f42595g = d.a.c.e.p.l.m();
            this.f42596h = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f42596h;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f42593e;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            try {
                this.f42590b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f42591c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f42589a;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e4) {
                    throw e4;
                } catch (Throwable unused) {
                }
            }
        }

        @Override // d.a.c.e.r.e.a
        public String d() {
            return this.f42594f;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f42595g;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f42589a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f42590b.read(this.f42592d);
            if (read > 0) {
                byteBuffer.put(this.f42592d, 0, read);
            }
            return read;
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f42591c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i2, d0 d0Var, boolean z) throws Exception {
        d.a.c.e.r.b bVar = f42583a;
        if (bVar != null) {
            return bVar.a(str, i2, d0Var);
        }
        if (z) {
            return new b(str, i2, d0Var);
        }
        return new c(str, i2, d0Var);
    }
}
