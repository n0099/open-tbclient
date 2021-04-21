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
    public static d.b.c.e.r.b f42807a;

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
        public SocketChannel f42808a;

        /* renamed from: b  reason: collision with root package name */
        public long f42809b;

        /* renamed from: c  reason: collision with root package name */
        public String f42810c;

        /* renamed from: d  reason: collision with root package name */
        public String f42811d;

        /* renamed from: e  reason: collision with root package name */
        public String f42812e;

        public b(String str, int i, d0 d0Var) throws Exception {
            this.f42808a = null;
            this.f42809b = 0L;
            this.f42810c = null;
            this.f42811d = null;
            this.f42812e = null;
            this.f42808a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42810c = inetSocketAddress.getAddress().getHostAddress();
                this.f42809b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42808a.socket().connect(inetSocketAddress, d0Var.e());
            this.f42808a.socket().setSoTimeout(d0Var.f());
            this.f42808a.socket().setTcpNoDelay(d0Var.g());
            this.f42811d = d.b.c.e.p.l.m();
            this.f42812e = d.b.c.e.p.l.n();
        }

        @Override // d.b.c.e.r.e.a
        public String a() {
            return this.f42810c;
        }

        @Override // d.b.c.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.c.e.r.e.a
        public String c() {
            return this.f42812e;
        }

        @Override // d.b.c.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f42808a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.b.c.e.r.e.a
        public long d() {
            return this.f42809b;
        }

        @Override // d.b.c.e.r.e.a
        public String getLocalDns() {
            return this.f42811d;
        }

        @Override // d.b.c.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f42808a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.b.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f42808a.read(byteBuffer);
        }

        @Override // d.b.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f42808a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f42813a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f42814b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f42815c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f42816d;

        /* renamed from: e  reason: collision with root package name */
        public long f42817e;

        /* renamed from: f  reason: collision with root package name */
        public String f42818f;

        /* renamed from: g  reason: collision with root package name */
        public String f42819g;

        /* renamed from: h  reason: collision with root package name */
        public String f42820h;

        public c(String str, int i, d0 d0Var) throws Exception {
            this.f42813a = null;
            this.f42814b = null;
            this.f42815c = null;
            this.f42816d = null;
            this.f42817e = 0L;
            this.f42818f = null;
            this.f42819g = null;
            this.f42820h = null;
            this.f42813a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42818f = inetSocketAddress.getAddress().getHostAddress();
                this.f42817e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42813a.connect(inetSocketAddress, d0Var.e());
            this.f42813a.setSoTimeout(d0Var.f());
            this.f42813a.setTcpNoDelay(d0Var.g());
            this.f42814b = this.f42813a.getInputStream();
            this.f42815c = this.f42813a.getOutputStream();
            this.f42816d = new byte[1024];
            this.f42819g = d.b.c.e.p.l.m();
            this.f42820h = d.b.c.e.p.l.n();
        }

        @Override // d.b.c.e.r.e.a
        public String a() {
            return this.f42818f;
        }

        @Override // d.b.c.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.c.e.r.e.a
        public String c() {
            return this.f42820h;
        }

        @Override // d.b.c.e.r.e.a
        public void close() throws IOException {
            try {
                this.f42814b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f42815c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f42813a;
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
            return this.f42817e;
        }

        @Override // d.b.c.e.r.e.a
        public String getLocalDns() {
            return this.f42819g;
        }

        @Override // d.b.c.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f42813a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.b.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f42814b.read(this.f42816d);
            if (read > 0) {
                byteBuffer.put(this.f42816d, 0, read);
            }
            return read;
        }

        @Override // d.b.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f42815c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i, d0 d0Var, boolean z) throws Exception {
        d.b.c.e.r.b bVar = f42807a;
        if (bVar != null) {
            return bVar.a(str, i, d0Var);
        }
        if (z) {
            return new b(str, i, d0Var);
        }
        return new c(str, i, d0Var);
    }
}
