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
    public static d.a.c.e.r.b f40021a;

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
        public SocketChannel f40022a;

        /* renamed from: b  reason: collision with root package name */
        public long f40023b;

        /* renamed from: c  reason: collision with root package name */
        public String f40024c;

        /* renamed from: d  reason: collision with root package name */
        public String f40025d;

        /* renamed from: e  reason: collision with root package name */
        public String f40026e;

        public b(String str, int i2, d0 d0Var) throws Exception {
            this.f40022a = null;
            this.f40023b = 0L;
            this.f40024c = null;
            this.f40025d = null;
            this.f40026e = null;
            this.f40022a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f40024c = inetSocketAddress.getAddress().getHostAddress();
                this.f40023b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f40022a.socket().connect(inetSocketAddress, d0Var.e());
            this.f40022a.socket().setSoTimeout(d0Var.f());
            this.f40022a.socket().setTcpNoDelay(d0Var.g());
            this.f40025d = d.a.c.e.p.l.m();
            this.f40026e = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f40026e;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f40023b;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f40022a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.a.c.e.r.e.a
        public String d() {
            return this.f40024c;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f40025d;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f40022a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f40022a.read(byteBuffer);
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f40022a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f40027a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f40028b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f40029c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f40030d;

        /* renamed from: e  reason: collision with root package name */
        public long f40031e;

        /* renamed from: f  reason: collision with root package name */
        public String f40032f;

        /* renamed from: g  reason: collision with root package name */
        public String f40033g;

        /* renamed from: h  reason: collision with root package name */
        public String f40034h;

        public c(String str, int i2, d0 d0Var) throws Exception {
            this.f40027a = null;
            this.f40028b = null;
            this.f40029c = null;
            this.f40030d = null;
            this.f40031e = 0L;
            this.f40032f = null;
            this.f40033g = null;
            this.f40034h = null;
            this.f40027a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f40032f = inetSocketAddress.getAddress().getHostAddress();
                this.f40031e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f40027a.connect(inetSocketAddress, d0Var.e());
            this.f40027a.setSoTimeout(d0Var.f());
            this.f40027a.setTcpNoDelay(d0Var.g());
            this.f40028b = this.f40027a.getInputStream();
            this.f40029c = this.f40027a.getOutputStream();
            this.f40030d = new byte[1024];
            this.f40033g = d.a.c.e.p.l.m();
            this.f40034h = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f40034h;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f40031e;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            try {
                this.f40028b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f40029c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f40027a;
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
            return this.f40032f;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f40033g;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f40027a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f40028b.read(this.f40030d);
            if (read > 0) {
                byteBuffer.put(this.f40030d, 0, read);
            }
            return read;
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f40029c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i2, d0 d0Var, boolean z) throws Exception {
        d.a.c.e.r.b bVar = f40021a;
        if (bVar != null) {
            return bVar.a(str, i2, d0Var);
        }
        if (z) {
            return new b(str, i2, d0Var);
        }
        return new c(str, i2, d0Var);
    }
}
