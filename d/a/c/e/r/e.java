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
    public static d.a.c.e.r.b f42686a;

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
        public SocketChannel f42687a;

        /* renamed from: b  reason: collision with root package name */
        public long f42688b;

        /* renamed from: c  reason: collision with root package name */
        public String f42689c;

        /* renamed from: d  reason: collision with root package name */
        public String f42690d;

        /* renamed from: e  reason: collision with root package name */
        public String f42691e;

        public b(String str, int i2, d0 d0Var) throws Exception {
            this.f42687a = null;
            this.f42688b = 0L;
            this.f42689c = null;
            this.f42690d = null;
            this.f42691e = null;
            this.f42687a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f42689c = inetSocketAddress.getAddress().getHostAddress();
                this.f42688b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42687a.socket().connect(inetSocketAddress, d0Var.e());
            this.f42687a.socket().setSoTimeout(d0Var.f());
            this.f42687a.socket().setTcpNoDelay(d0Var.g());
            this.f42690d = d.a.c.e.p.l.m();
            this.f42691e = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f42691e;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f42688b;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f42687a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.a.c.e.r.e.a
        public String d() {
            return this.f42689c;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f42690d;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f42687a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f42687a.read(byteBuffer);
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f42687a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f42692a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f42693b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f42694c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f42695d;

        /* renamed from: e  reason: collision with root package name */
        public long f42696e;

        /* renamed from: f  reason: collision with root package name */
        public String f42697f;

        /* renamed from: g  reason: collision with root package name */
        public String f42698g;

        /* renamed from: h  reason: collision with root package name */
        public String f42699h;

        public c(String str, int i2, d0 d0Var) throws Exception {
            this.f42692a = null;
            this.f42693b = null;
            this.f42694c = null;
            this.f42695d = null;
            this.f42696e = 0L;
            this.f42697f = null;
            this.f42698g = null;
            this.f42699h = null;
            this.f42692a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f42697f = inetSocketAddress.getAddress().getHostAddress();
                this.f42696e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42692a.connect(inetSocketAddress, d0Var.e());
            this.f42692a.setSoTimeout(d0Var.f());
            this.f42692a.setTcpNoDelay(d0Var.g());
            this.f42693b = this.f42692a.getInputStream();
            this.f42694c = this.f42692a.getOutputStream();
            this.f42695d = new byte[1024];
            this.f42698g = d.a.c.e.p.l.m();
            this.f42699h = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f42699h;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f42696e;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            try {
                this.f42693b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f42694c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f42692a;
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
            return this.f42697f;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f42698g;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f42692a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f42693b.read(this.f42695d);
            if (read > 0) {
                byteBuffer.put(this.f42695d, 0, read);
            }
            return read;
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f42694c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i2, d0 d0Var, boolean z) throws Exception {
        d.a.c.e.r.b bVar = f42686a;
        if (bVar != null) {
            return bVar.a(str, i2, d0Var);
        }
        if (z) {
            return new b(str, i2, d0Var);
        }
        return new c(str, i2, d0Var);
    }
}
