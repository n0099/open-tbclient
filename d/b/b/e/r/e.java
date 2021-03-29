package d.b.b.e.r;

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
    public static d.b.b.e.r.b f42070a;

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
        public SocketChannel f42071a;

        /* renamed from: b  reason: collision with root package name */
        public long f42072b;

        /* renamed from: c  reason: collision with root package name */
        public String f42073c;

        /* renamed from: d  reason: collision with root package name */
        public String f42074d;

        /* renamed from: e  reason: collision with root package name */
        public String f42075e;

        public b(String str, int i, d0 d0Var) throws Exception {
            this.f42071a = null;
            this.f42072b = 0L;
            this.f42073c = null;
            this.f42074d = null;
            this.f42075e = null;
            this.f42071a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42073c = inetSocketAddress.getAddress().getHostAddress();
                this.f42072b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42071a.socket().connect(inetSocketAddress, d0Var.e());
            this.f42071a.socket().setSoTimeout(d0Var.f());
            this.f42071a.socket().setTcpNoDelay(d0Var.g());
            this.f42074d = d.b.b.e.p.l.m();
            this.f42075e = d.b.b.e.p.l.n();
        }

        @Override // d.b.b.e.r.e.a
        public String a() {
            return this.f42073c;
        }

        @Override // d.b.b.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.b.e.r.e.a
        public String c() {
            return this.f42075e;
        }

        @Override // d.b.b.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f42071a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.b.b.e.r.e.a
        public long d() {
            return this.f42072b;
        }

        @Override // d.b.b.e.r.e.a
        public String getLocalDns() {
            return this.f42074d;
        }

        @Override // d.b.b.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f42071a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.b.b.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f42071a.read(byteBuffer);
        }

        @Override // d.b.b.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f42071a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f42076a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f42077b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f42078c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f42079d;

        /* renamed from: e  reason: collision with root package name */
        public long f42080e;

        /* renamed from: f  reason: collision with root package name */
        public String f42081f;

        /* renamed from: g  reason: collision with root package name */
        public String f42082g;

        /* renamed from: h  reason: collision with root package name */
        public String f42083h;

        public c(String str, int i, d0 d0Var) throws Exception {
            this.f42076a = null;
            this.f42077b = null;
            this.f42078c = null;
            this.f42079d = null;
            this.f42080e = 0L;
            this.f42081f = null;
            this.f42082g = null;
            this.f42083h = null;
            this.f42076a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42081f = inetSocketAddress.getAddress().getHostAddress();
                this.f42080e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42076a.connect(inetSocketAddress, d0Var.e());
            this.f42076a.setSoTimeout(d0Var.f());
            this.f42076a.setTcpNoDelay(d0Var.g());
            this.f42077b = this.f42076a.getInputStream();
            this.f42078c = this.f42076a.getOutputStream();
            this.f42079d = new byte[1024];
            this.f42082g = d.b.b.e.p.l.m();
            this.f42083h = d.b.b.e.p.l.n();
        }

        @Override // d.b.b.e.r.e.a
        public String a() {
            return this.f42081f;
        }

        @Override // d.b.b.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.b.e.r.e.a
        public String c() {
            return this.f42083h;
        }

        @Override // d.b.b.e.r.e.a
        public void close() throws IOException {
            try {
                this.f42077b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f42078c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f42076a;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e4) {
                    throw e4;
                } catch (Throwable unused) {
                }
            }
        }

        @Override // d.b.b.e.r.e.a
        public long d() {
            return this.f42080e;
        }

        @Override // d.b.b.e.r.e.a
        public String getLocalDns() {
            return this.f42082g;
        }

        @Override // d.b.b.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f42076a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.b.b.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f42077b.read(this.f42079d);
            if (read > 0) {
                byteBuffer.put(this.f42079d, 0, read);
            }
            return read;
        }

        @Override // d.b.b.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f42078c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i, d0 d0Var, boolean z) throws Exception {
        d.b.b.e.r.b bVar = f42070a;
        if (bVar != null) {
            return bVar.a(str, i, d0Var);
        }
        if (z) {
            return new b(str, i, d0Var);
        }
        return new c(str, i, d0Var);
    }
}
