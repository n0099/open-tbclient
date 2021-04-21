package d.b.c.e.r;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.common.others.lang.StringUtil;
import d.b.c.e.r.e;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class g0 extends Handler {

    /* renamed from: g  reason: collision with root package name */
    public static long f42833g;

    /* renamed from: a  reason: collision with root package name */
    public final Random f42834a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f42835b;

    /* renamed from: c  reason: collision with root package name */
    public final Looper f42836c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a f42837d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f42838e;

    /* renamed from: f  reason: collision with root package name */
    public final a f42839f;

    public g0(Looper looper, Handler handler, e.a aVar, d0 d0Var) {
        super(looper);
        this.f42834a = new Random();
        this.f42836c = looper;
        this.f42835b = handler;
        this.f42837d = aVar;
        this.f42838e = d0Var;
        this.f42839f = new a(d0Var.b() + 14, 262144);
    }

    public void a() {
        synchronized (g0.class) {
            f42833g = 0L;
        }
    }

    public boolean b(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    public long c() {
        long j;
        synchronized (g0.class) {
            j = f42833g;
        }
        return j;
    }

    public final boolean d() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public final String e() {
        byte[] bArr = new byte[16];
        this.f42834a.nextBytes(bArr);
        return d.b.c.e.p.c.j(bArr);
    }

    public final void f(Object obj) {
        Message obtainMessage = this.f42835b.obtainMessage();
        obtainMessage.obj = obj;
        this.f42835b.sendMessage(obtainMessage);
    }

    public void g(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    public boolean h(Object obj) throws IOException, WebSocketException {
        if (obj instanceof s) {
            return o((s) obj);
        }
        if (obj instanceof c0) {
            s((c0) obj);
            return true;
        } else if (obj instanceof w) {
            r((w) obj);
            return true;
        } else if (obj instanceof k) {
            j((k) obj);
            return true;
        } else if (obj instanceof t) {
            p((t) obj);
            return true;
        } else if (obj instanceof u) {
            q((u) obj);
            return true;
        } else if (obj instanceof m) {
            l((m) obj);
            return true;
        } else if (obj instanceof l) {
            k((l) obj);
            return true;
        } else {
            g(obj);
            throw null;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj == null) {
                return;
            }
            c cVar = message.obj instanceof s ? ((s) message.obj).f42873a : null;
            this.f42839f.n();
            if (!h(message.obj)) {
                f(new x(cVar));
                return;
            }
            this.f42839f.q();
            if (cVar != null) {
                f(new b0(cVar));
            }
            while (this.f42839f.s() > 0) {
                if (this.f42837d == null) {
                    f(new n(new SocketException("write socket = null")));
                    return;
                }
                int write = this.f42837d.write(this.f42839f.r());
                if (write > 0) {
                    synchronized (g0.class) {
                        f42833g += write;
                    }
                }
            }
            if (cVar != null) {
                f(new q(cVar));
            }
        } catch (SocketException e2) {
            f(new n(e2));
        } catch (Exception e3) {
            if (d()) {
                e3.printStackTrace();
            }
            f(new p(e3));
        }
    }

    public void i() {
        try {
            this.f42836c.quit();
        } catch (Exception unused) {
        }
        try {
            this.f42837d.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void j(k kVar) throws IOException, WebSocketException {
        if (kVar.f42859a.length <= this.f42838e.c()) {
            m(2, true, kVar.f42859a);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void k(l lVar) throws IOException {
        this.f42839f.t("GET " + (lVar.f42864c != null ? lVar.f42863b + "?" + lVar.f42864c : lVar.f42863b) + " HTTP/1.1");
        this.f42839f.o();
        this.f42839f.t("Host: " + lVar.f42862a);
        this.f42839f.o();
        this.f42839f.t("Upgrade: WebSocket");
        this.f42839f.o();
        this.f42839f.t("Connection: Upgrade");
        this.f42839f.o();
        this.f42839f.t("Sec-WebSocket-Key: " + e());
        this.f42839f.o();
        d0 d0Var = this.f42838e;
        if (d0Var != null && d0Var.i() != null && this.f42838e.i().length() > 0) {
            this.f42839f.t("Sec-WebSocket-Extensions: " + this.f42838e.i());
            this.f42839f.o();
        }
        String str = lVar.f42865d;
        if (str != null && !str.equals("")) {
            this.f42839f.t("Origin: " + lVar.f42865d);
            this.f42839f.o();
        }
        String[] strArr = lVar.f42866e;
        if (strArr != null && strArr.length > 0) {
            this.f42839f.t("Sec-WebSocket-Protocol: ");
            int i = 0;
            while (true) {
                String[] strArr2 = lVar.f42866e;
                if (i >= strArr2.length) {
                    break;
                }
                this.f42839f.t(strArr2[i]);
                this.f42839f.t(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                i++;
            }
            this.f42839f.o();
        }
        this.f42839f.t("Sec-WebSocket-Version: 13");
        this.f42839f.o();
        List<BasicNameValuePair> list = lVar.f42867f;
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f42839f.t(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.f42839f.o();
            }
        }
        this.f42839f.o();
    }

    public final void l(m mVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (mVar.f42868a > 0) {
            String str = mVar.f42869b;
            if (str == null || str.equals("")) {
                bArr = new byte[2];
            } else {
                byte[] bytes = mVar.f42869b.getBytes("UTF-8");
                bArr = new byte[bytes.length + 2];
                for (int i = 0; i < bytes.length; i++) {
                    bArr[i + 2] = bytes[i];
                }
            }
            if (bArr.length <= 125) {
                int i2 = mVar.f42868a;
                bArr[0] = (byte) ((i2 >> 8) & 255);
                bArr[1] = (byte) (i2 & 255);
                m(8, true, bArr);
                return;
            }
            throw new WebSocketException("close payload exceeds 125 octets");
        }
        m(8, true, null);
    }

    public void m(int i, boolean z, byte[] bArr) throws IOException {
        if (bArr != null) {
            n(i, z, bArr, 0, bArr.length);
        } else {
            n(i, z, null, 0, 0);
        }
    }

    public void n(int i, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        byte b2;
        byte b3 = ByteCompanionObject.MIN_VALUE;
        if (z) {
            b2 = (byte) com.alipay.sdk.encrypt.a.f1921g;
            i4 = i;
        } else {
            i4 = i;
            b2 = 0;
        }
        this.f42839f.write((byte) (b2 | ((byte) i4)));
        if (!this.f42838e.a()) {
            b3 = 0;
        }
        long j = i3;
        if (j <= 125) {
            this.f42839f.write((byte) (b3 | ((byte) j)));
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.f42839f.write((byte) (b3 | 126));
            this.f42839f.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (j & 255)});
        } else {
            this.f42839f.write((byte) (b3 | ByteCompanionObject.MAX_VALUE));
            this.f42839f.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)});
        }
        if (this.f42838e.a()) {
            this.f42839f.write(0);
            this.f42839f.write(0);
            this.f42839f.write(0);
            this.f42839f.write(0);
        }
        if (j > 0) {
            this.f42838e.a();
            this.f42839f.write(bArr, i2, i3);
        }
    }

    public final boolean o(s sVar) throws IOException, WebSocketException {
        byte[] e2 = sVar.f42873a.e();
        if (e2 == null) {
            return false;
        }
        if (e2.length <= this.f42838e.c()) {
            m(2, true, e2);
            return true;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void p(t tVar) throws IOException, WebSocketException {
        byte[] bArr = tVar.f42874a;
        if (bArr != null && bArr.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        m(9, true, tVar.f42874a);
    }

    public final void q(u uVar) throws IOException, WebSocketException {
        byte[] bArr = uVar.f42875a;
        if (bArr != null && bArr.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        m(10, true, uVar.f42875a);
    }

    public final void r(w wVar) throws IOException, WebSocketException {
        if (wVar.f42877a.length <= this.f42838e.c()) {
            m(1, true, wVar.f42877a);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void s(c0 c0Var) throws IOException, WebSocketException {
        byte[] bytes = c0Var.f42798a.getBytes("UTF-8");
        if (bytes.length <= this.f42838e.c()) {
            m(1, true, bytes);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }
}
