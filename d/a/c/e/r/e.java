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
    public static d.a.c.e.r.b f39266a;

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
        public SocketChannel f39267a;

        /* renamed from: b  reason: collision with root package name */
        public long f39268b;

        /* renamed from: c  reason: collision with root package name */
        public String f39269c;

        /* renamed from: d  reason: collision with root package name */
        public String f39270d;

        /* renamed from: e  reason: collision with root package name */
        public String f39271e;

        public b(String str, int i2, d0 d0Var) throws Exception {
            this.f39267a = null;
            this.f39268b = 0L;
            this.f39269c = null;
            this.f39270d = null;
            this.f39271e = null;
            this.f39267a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f39269c = inetSocketAddress.getAddress().getHostAddress();
                this.f39268b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f39267a.socket().connect(inetSocketAddress, d0Var.e());
            this.f39267a.socket().setSoTimeout(d0Var.f());
            this.f39267a.socket().setTcpNoDelay(d0Var.g());
            this.f39270d = d.a.c.e.p.l.m();
            this.f39271e = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f39271e;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f39268b;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f39267a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.a.c.e.r.e.a
        public String d() {
            return this.f39269c;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f39270d;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f39267a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f39267a.read(byteBuffer);
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f39267a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f39272a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f39273b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f39274c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f39275d;

        /* renamed from: e  reason: collision with root package name */
        public long f39276e;

        /* renamed from: f  reason: collision with root package name */
        public String f39277f;

        /* renamed from: g  reason: collision with root package name */
        public String f39278g;

        /* renamed from: h  reason: collision with root package name */
        public String f39279h;

        public c(String str, int i2, d0 d0Var) throws Exception {
            this.f39272a = null;
            this.f39273b = null;
            this.f39274c = null;
            this.f39275d = null;
            this.f39276e = 0L;
            this.f39277f = null;
            this.f39278g = null;
            this.f39279h = null;
            this.f39272a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f39277f = inetSocketAddress.getAddress().getHostAddress();
                this.f39276e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f39272a.connect(inetSocketAddress, d0Var.e());
            this.f39272a.setSoTimeout(d0Var.f());
            this.f39272a.setTcpNoDelay(d0Var.g());
            this.f39273b = this.f39272a.getInputStream();
            this.f39274c = this.f39272a.getOutputStream();
            this.f39275d = new byte[1024];
            this.f39278g = d.a.c.e.p.l.m();
            this.f39279h = d.a.c.e.p.l.n();
        }

        @Override // d.a.c.e.r.e.a
        public int a() {
            return 0;
        }

        @Override // d.a.c.e.r.e.a
        public String b() {
            return this.f39279h;
        }

        @Override // d.a.c.e.r.e.a
        public long c() {
            return this.f39276e;
        }

        @Override // d.a.c.e.r.e.a
        public void close() throws IOException {
            try {
                this.f39273b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f39274c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f39272a;
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
            return this.f39277f;
        }

        @Override // d.a.c.e.r.e.a
        public String getLocalDns() {
            return this.f39278g;
        }

        @Override // d.a.c.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f39272a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.a.c.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f39273b.read(this.f39275d);
            if (read > 0) {
                byteBuffer.put(this.f39275d, 0, read);
            }
            return read;
        }

        @Override // d.a.c.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f39274c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i2, d0 d0Var, boolean z) throws Exception {
        d.a.c.e.r.b bVar = f39266a;
        if (bVar != null) {
            return bVar.a(str, i2, d0Var);
        }
        if (z) {
            return new b(str, i2, d0Var);
        }
        return new c(str, i2, d0Var);
    }
}
