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
    public static d.b.b.e.r.b f42069a;

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
        public SocketChannel f42070a;

        /* renamed from: b  reason: collision with root package name */
        public long f42071b;

        /* renamed from: c  reason: collision with root package name */
        public String f42072c;

        /* renamed from: d  reason: collision with root package name */
        public String f42073d;

        /* renamed from: e  reason: collision with root package name */
        public String f42074e;

        public b(String str, int i, d0 d0Var) throws Exception {
            this.f42070a = null;
            this.f42071b = 0L;
            this.f42072c = null;
            this.f42073d = null;
            this.f42074e = null;
            this.f42070a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42072c = inetSocketAddress.getAddress().getHostAddress();
                this.f42071b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42070a.socket().connect(inetSocketAddress, d0Var.e());
            this.f42070a.socket().setSoTimeout(d0Var.f());
            this.f42070a.socket().setTcpNoDelay(d0Var.g());
            this.f42073d = d.b.b.e.p.l.m();
            this.f42074e = d.b.b.e.p.l.n();
        }

        @Override // d.b.b.e.r.e.a
        public String a() {
            return this.f42072c;
        }

        @Override // d.b.b.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.b.e.r.e.a
        public String c() {
            return this.f42074e;
        }

        @Override // d.b.b.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel = this.f42070a;
            if (socketChannel != null) {
                socketChannel.close();
            }
        }

        @Override // d.b.b.e.r.e.a
        public long d() {
            return this.f42071b;
        }

        @Override // d.b.b.e.r.e.a
        public String getLocalDns() {
            return this.f42073d;
        }

        @Override // d.b.b.e.r.e.a
        public boolean isConnected() {
            SocketChannel socketChannel = this.f42070a;
            if (socketChannel != null) {
                return socketChannel.isConnected();
            }
            return false;
        }

        @Override // d.b.b.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.f42070a.read(byteBuffer);
        }

        @Override // d.b.b.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.f42070a.write(byteBuffer);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public Socket f42075a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f42076b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f42077c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f42078d;

        /* renamed from: e  reason: collision with root package name */
        public long f42079e;

        /* renamed from: f  reason: collision with root package name */
        public String f42080f;

        /* renamed from: g  reason: collision with root package name */
        public String f42081g;

        /* renamed from: h  reason: collision with root package name */
        public String f42082h;

        public c(String str, int i, d0 d0Var) throws Exception {
            this.f42075a = null;
            this.f42076b = null;
            this.f42077c = null;
            this.f42078d = null;
            this.f42079e = 0L;
            this.f42080f = null;
            this.f42081g = null;
            this.f42082h = null;
            this.f42075a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f42080f = inetSocketAddress.getAddress().getHostAddress();
                this.f42079e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f42075a.connect(inetSocketAddress, d0Var.e());
            this.f42075a.setSoTimeout(d0Var.f());
            this.f42075a.setTcpNoDelay(d0Var.g());
            this.f42076b = this.f42075a.getInputStream();
            this.f42077c = this.f42075a.getOutputStream();
            this.f42078d = new byte[1024];
            this.f42081g = d.b.b.e.p.l.m();
            this.f42082h = d.b.b.e.p.l.n();
        }

        @Override // d.b.b.e.r.e.a
        public String a() {
            return this.f42080f;
        }

        @Override // d.b.b.e.r.e.a
        public int b() {
            return 0;
        }

        @Override // d.b.b.e.r.e.a
        public String c() {
            return this.f42082h;
        }

        @Override // d.b.b.e.r.e.a
        public void close() throws IOException {
            try {
                this.f42076b.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.f42077c.close();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            Socket socket = this.f42075a;
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
            return this.f42079e;
        }

        @Override // d.b.b.e.r.e.a
        public String getLocalDns() {
            return this.f42081g;
        }

        @Override // d.b.b.e.r.e.a
        public boolean isConnected() {
            Socket socket = this.f42075a;
            if (socket != null) {
                return socket.isConnected();
            }
            return false;
        }

        @Override // d.b.b.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.f42076b.read(this.f42078d);
            if (read > 0) {
                byteBuffer.put(this.f42078d, 0, read);
            }
            return read;
        }

        @Override // d.b.b.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.f42077c.write(bArr);
            }
            return remaining;
        }
    }

    public a a(String str, int i, d0 d0Var, boolean z) throws Exception {
        d.b.b.e.r.b bVar = f42069a;
        if (bVar != null) {
            return bVar.a(str, i, d0Var);
        }
        if (z) {
            return new b(str, i, d0Var);
        }
        return new c(str, i, d0Var);
    }
}
