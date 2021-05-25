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
    public static d.a.c.e.r.b f38930a;

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
        public SocketChannel f38931a;

        /* renamed from: b  reason: collision with root package name */
        public long f38932b;

        /* renamed from: c  reason: collision with root package name */
        public String f38933c;

        /* renamed from: d  reason: collision with root package name */
        public String f38934d;

        /* renamed from: e  reason: collision with root package name */
        public String f38935e;

        public b(String str, int i2, d0 d0Var) throws Exception {
            this.f38931a = null;
            this.f38932b = 0L;
            this.f38933c = null;
            this.f38934d = null;
            this.f38935e = null;
            this.f38931a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f38933c = inetSocketAddress.getAddress().getHostAddress();
                this.f38932b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f38931a.socket().connect(inetSocketAddress, d0Var.e());
            this.f38931a.socket().setSoTimeout(d0Var.f());
            this.f38931a.socket().setTcpNoDelay(d0Var.g());
            this.f38934d = d.a.c.e.p.l.m();
            this.f38935e = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f38935e;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f38932b;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f38931a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.a.c.e.r.e.a
        public String d() {
            return this.f38933c;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f38934d;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f38931a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f38931a.read(byteBuffer);
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f38931a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f38936a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f38937b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f38938c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f38939d;

        /* renamed from: e  reason: collision with root package name */
        public long f38940e;

        /* renamed from: f  reason: collision with root package name */
        public String f38941f;

        /* renamed from: g  reason: collision with root package name */
        public String f38942g;

        /* renamed from: h  reason: collision with root package name */
        public String f38943h;

        public c(String str, int i2, d0 d0Var) throws Exception {
            this.f38936a = null;
            this.f38937b = null;
            this.f38938c = null;
            this.f38939d = null;
            this.f38940e = 0L;
            this.f38941f = null;
            this.f38942g = null;
            this.f38943h = null;
            this.f38936a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f38941f = inetSocketAddress.getAddress().getHostAddress();
                this.f38940e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f38936a.connect(inetSocketAddress, d0Var.e());
            this.f38936a.setSoTimeout(d0Var.f());
            this.f38936a.setTcpNoDelay(d0Var.g());
            this.f38937b = this.f38936a.getInputStream();
            this.f38938c = this.f38936a.getOutputStream();
            this.f38939d = new byte[1024];
            this.f38942g = d.a.c.e.p.l.m();
            this.f38943h = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f38943h;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f38940e;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            try {
                this.f38937b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f38938c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f38936a;
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
            return this.f38941f;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f38942g;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f38936a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f38937b.read(this.f38939d);
            if (read > 0) {
                byteBuffer.put(this.f38939d, 0, read);
            }
            return read;
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f38938c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i2, d0 d0Var, boolean z) throws Exception {
        d.a.c.e.r.b bVar = f38930a;
        if (bVar != null) {
            return bVar.a(str, i2, d0Var);
        }
        if (z) {
            return new b(str, i2, d0Var);
        }
        return new c(str, i2, d0Var);
    }
}
