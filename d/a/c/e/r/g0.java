package d.a.c.e.r;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.common.others.lang.StringUtil;
import d.a.c.e.r.e;
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
    public static long f42610g;

    /* renamed from: a  reason: collision with root package name */
    public final Random f42611a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f42612b;

    /* renamed from: c  reason: collision with root package name */
    public final Looper f42613c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a f42614d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f42615e;

    /* renamed from: f  reason: collision with root package name */
    public final a f42616f;

    public g0(Looper looper, Handler handler, e.a aVar, d0 d0Var) {
        super(looper);
        this.f42611a = new Random();
        this.f42613c = looper;
        this.f42612b = handler;
        this.f42614d = aVar;
        this.f42615e = d0Var;
        this.f42616f = new a(d0Var.b() + 14, 262144);
    }

    public void a() {
        synchronized (g0.class) {
            f42610g = 0L;
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
            j = f42610g;
        }
        return j;
    }

    public final boolean d() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public final String e() {
        byte[] bArr = new byte[16];
        this.f42611a.nextBytes(bArr);
        return d.a.c.e.p.c.j(bArr);
    }

    public final void f(Object obj) {
        Message obtainMessage = this.f42612b.obtainMessage();
        obtainMessage.obj = obj;
        this.f42612b.sendMessage(obtainMessage);
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
            c cVar = message.obj instanceof s ? ((s) message.obj).f42651a : null;
            this.f42616f.n();
            if (!h(message.obj)) {
                f(new x(cVar));
                return;
            }
            this.f42616f.q();
            if (cVar != null) {
                f(new b0(cVar));
            }
            while (this.f42616f.s() > 0) {
                if (this.f42614d == null) {
                    f(new n(new SocketException("write socket = null")));
                    return;
                }
                int write = this.f42614d.write(this.f42616f.r());
                if (write > 0) {
                    synchronized (g0.class) {
                        f42610g += write;
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
            this.f42613c.quit();
        } catch (Exception unused) {
        }
        try {
            this.f42614d.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void j(k kVar) throws IOException, WebSocketException {
        if (kVar.f42637a.length <= this.f42615e.c()) {
            m(2, true, kVar.f42637a);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void k(l lVar) throws IOException {
        this.f42616f.t("GET " + (lVar.f42642c != null ? lVar.f42641b + "?" + lVar.f42642c : lVar.f42641b) + " HTTP/1.1");
        this.f42616f.o();
        this.f42616f.t("Host: " + lVar.f42640a);
        this.f42616f.o();
        this.f42616f.t("Upgrade: WebSocket");
        this.f42616f.o();
        this.f42616f.t("Connection: Upgrade");
        this.f42616f.o();
        this.f42616f.t("Sec-WebSocket-Key: " + e());
        this.f42616f.o();
        d0 d0Var = this.f42615e;
        if (d0Var != null && d0Var.i() != null && this.f42615e.i().length() > 0) {
            this.f42616f.t("Sec-WebSocket-Extensions: " + this.f42615e.i());
            this.f42616f.o();
        }
        String str = lVar.f42643d;
        if (str != null && !str.equals("")) {
            this.f42616f.t("Origin: " + lVar.f42643d);
            this.f42616f.o();
        }
        String[] strArr = lVar.f42644e;
        if (strArr != null && strArr.length > 0) {
            this.f42616f.t("Sec-WebSocket-Protocol: ");
            int i2 = 0;
            while (true) {
                String[] strArr2 = lVar.f42644e;
                if (i2 >= strArr2.length) {
                    break;
                }
                this.f42616f.t(strArr2[i2]);
                this.f42616f.t(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                i2++;
            }
            this.f42616f.o();
        }
        this.f42616f.t("Sec-WebSocket-Version: 13");
        this.f42616f.o();
        List<BasicNameValuePair> list = lVar.f42645f;
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f42616f.t(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.f42616f.o();
            }
        }
        this.f42616f.o();
    }

    public final void l(m mVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (mVar.f42646a > 0) {
            String str = mVar.f42647b;
            if (str == null || str.equals("")) {
                bArr = new byte[2];
            } else {
                byte[] bytes = mVar.f42647b.getBytes("UTF-8");
                bArr = new byte[bytes.length + 2];
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    bArr[i2 + 2] = bytes[i2];
                }
            }
            if (bArr.length <= 125) {
                int i3 = mVar.f42646a;
                bArr[0] = (byte) ((i3 >> 8) & 255);
                bArr[1] = (byte) (i3 & 255);
                m(8, true, bArr);
                return;
            }
            throw new WebSocketException("close payload exceeds 125 octets");
        }
        m(8, true, null);
    }

    public void m(int i2, boolean z, byte[] bArr) throws IOException {
        if (bArr != null) {
            n(i2, z, bArr, 0, bArr.length);
        } else {
            n(i2, z, null, 0, 0);
        }
    }

    public void n(int i2, boolean z, byte[] bArr, int i3, int i4) throws IOException {
        int i5;
        byte b2;
        byte b3 = ByteCompanionObject.MIN_VALUE;
        if (z) {
            b2 = (byte) com.alipay.sdk.encrypt.a.f1885g;
            i5 = i2;
        } else {
            i5 = i2;
            b2 = 0;
        }
        this.f42616f.write((byte) (b2 | ((byte) i5)));
        if (!this.f42615e.a()) {
            b3 = 0;
        }
        long j = i4;
        if (j <= 125) {
            this.f42616f.write((byte) (b3 | ((byte) j)));
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.f42616f.write((byte) (b3 | 126));
            this.f42616f.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (j & 255)});
        } else {
            this.f42616f.write((byte) (b3 | ByteCompanionObject.MAX_VALUE));
            this.f42616f.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)});
        }
        if (this.f42615e.a()) {
            this.f42616f.write(0);
            this.f42616f.write(0);
            this.f42616f.write(0);
            this.f42616f.write(0);
        }
        if (j > 0) {
            this.f42615e.a();
            this.f42616f.write(bArr, i3, i4);
        }
    }

    public final boolean o(s sVar) throws IOException, WebSocketException {
        byte[] e2 = sVar.f42651a.e();
        if (e2 == null) {
            return false;
        }
        if (e2.length <= this.f42615e.c()) {
            m(2, true, e2);
            return true;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void p(t tVar) throws IOException, WebSocketException {
        byte[] bArr = tVar.f42652a;
        if (bArr != null && bArr.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        m(9, true, tVar.f42652a);
    }

    public final void q(u uVar) throws IOException, WebSocketException {
        byte[] bArr = uVar.f42653a;
        if (bArr != null && bArr.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        m(10, true, uVar.f42653a);
    }

    public final void r(w wVar) throws IOException, WebSocketException {
        if (wVar.f42655a.length <= this.f42615e.c()) {
            m(1, true, wVar.f42655a);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void s(c0 c0Var) throws IOException, WebSocketException {
        byte[] bytes = c0Var.f42573a.getBytes("UTF-8");
        if (bytes.length <= this.f42615e.c()) {
            m(1, true, bytes);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }
}
