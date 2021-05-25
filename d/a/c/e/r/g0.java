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
    public static long f38957g;

    /* renamed from: a  reason: collision with root package name */
    public final Random f38958a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f38959b;

    /* renamed from: c  reason: collision with root package name */
    public final Looper f38960c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a f38961d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f38962e;

    /* renamed from: f  reason: collision with root package name */
    public final a f38963f;

    public g0(Looper looper, Handler handler, e.a aVar, d0 d0Var) {
        super(looper);
        this.f38958a = new Random();
        this.f38960c = looper;
        this.f38959b = handler;
        this.f38961d = aVar;
        this.f38962e = d0Var;
        this.f38963f = new a(d0Var.b() + 14, 262144);
    }

    public void a() {
        synchronized (g0.class) {
            f38957g = 0L;
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
            j = f38957g;
        }
        return j;
    }

    public final boolean d() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public final String e() {
        byte[] bArr = new byte[16];
        this.f38958a.nextBytes(bArr);
        return d.a.c.e.p.c.j(bArr);
    }

    public final void f(Object obj) {
        Message obtainMessage = this.f38959b.obtainMessage();
        obtainMessage.obj = obj;
        this.f38959b.sendMessage(obtainMessage);
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
            c cVar = message.obj instanceof s ? ((s) message.obj).f38998a : null;
            this.f38963f.n();
            if (!h(message.obj)) {
                f(new x(cVar));
                return;
            }
            this.f38963f.q();
            if (cVar != null) {
                f(new b0(cVar));
            }
            while (this.f38963f.s() > 0) {
                if (this.f38961d == null) {
                    f(new n(new SocketException("write socket = null")));
                    return;
                }
                int write = this.f38961d.write(this.f38963f.r());
                if (write > 0) {
                    synchronized (g0.class) {
                        f38957g += write;
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
            this.f38960c.quit();
        } catch (Exception unused) {
        }
        try {
            this.f38961d.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void j(k kVar) throws IOException, WebSocketException {
        if (kVar.f38984a.length <= this.f38962e.c()) {
            m(2, true, kVar.f38984a);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void k(l lVar) throws IOException {
        this.f38963f.t("GET " + (lVar.f38989c != null ? lVar.f38988b + "?" + lVar.f38989c : lVar.f38988b) + " HTTP/1.1");
        this.f38963f.o();
        this.f38963f.t("Host: " + lVar.f38987a);
        this.f38963f.o();
        this.f38963f.t("Upgrade: WebSocket");
        this.f38963f.o();
        this.f38963f.t("Connection: Upgrade");
        this.f38963f.o();
        this.f38963f.t("Sec-WebSocket-Key: " + e());
        this.f38963f.o();
        d0 d0Var = this.f38962e;
        if (d0Var != null && d0Var.i() != null && this.f38962e.i().length() > 0) {
            this.f38963f.t("Sec-WebSocket-Extensions: " + this.f38962e.i());
            this.f38963f.o();
        }
        String str = lVar.f38990d;
        if (str != null && !str.equals("")) {
            this.f38963f.t("Origin: " + lVar.f38990d);
            this.f38963f.o();
        }
        String[] strArr = lVar.f38991e;
        if (strArr != null && strArr.length > 0) {
            this.f38963f.t("Sec-WebSocket-Protocol: ");
            int i2 = 0;
            while (true) {
                String[] strArr2 = lVar.f38991e;
                if (i2 >= strArr2.length) {
                    break;
                }
                this.f38963f.t(strArr2[i2]);
                this.f38963f.t(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                i2++;
            }
            this.f38963f.o();
        }
        this.f38963f.t("Sec-WebSocket-Version: 13");
        this.f38963f.o();
        List<BasicNameValuePair> list = lVar.f38992f;
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f38963f.t(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.f38963f.o();
            }
        }
        this.f38963f.o();
    }

    public final void l(m mVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (mVar.f38993a > 0) {
            String str = mVar.f38994b;
            if (str == null || str.equals("")) {
                bArr = new byte[2];
            } else {
                byte[] bytes = mVar.f38994b.getBytes("UTF-8");
                bArr = new byte[bytes.length + 2];
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    bArr[i2 + 2] = bytes[i2];
                }
            }
            if (bArr.length <= 125) {
                int i3 = mVar.f38993a;
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
            b2 = (byte) com.alipay.sdk.encrypt.a.f1872g;
            i5 = i2;
        } else {
            i5 = i2;
            b2 = 0;
        }
        this.f38963f.write((byte) (b2 | ((byte) i5)));
        if (!this.f38962e.a()) {
            b3 = 0;
        }
        long j = i4;
        if (j <= 125) {
            this.f38963f.write((byte) (b3 | ((byte) j)));
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.f38963f.write((byte) (b3 | 126));
            this.f38963f.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (j & 255)});
        } else {
            this.f38963f.write((byte) (b3 | ByteCompanionObject.MAX_VALUE));
            this.f38963f.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)});
        }
        if (this.f38962e.a()) {
            this.f38963f.write(0);
            this.f38963f.write(0);
            this.f38963f.write(0);
            this.f38963f.write(0);
        }
        if (j > 0) {
            this.f38962e.a();
            this.f38963f.write(bArr, i3, i4);
        }
    }

    public final boolean o(s sVar) throws IOException, WebSocketException {
        byte[] e2 = sVar.f38998a.e();
        if (e2 == null) {
            return false;
        }
        if (e2.length <= this.f38962e.c()) {
            m(2, true, e2);
            return true;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void p(t tVar) throws IOException, WebSocketException {
        byte[] bArr = tVar.f38999a;
        if (bArr != null && bArr.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        m(9, true, tVar.f38999a);
    }

    public final void q(u uVar) throws IOException, WebSocketException {
        byte[] bArr = uVar.f39000a;
        if (bArr != null && bArr.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        m(10, true, uVar.f39000a);
    }

    public final void r(w wVar) throws IOException, WebSocketException {
        if (wVar.f39002a.length <= this.f38962e.c()) {
            m(1, true, wVar.f39002a);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }

    public final void s(c0 c0Var) throws IOException, WebSocketException {
        byte[] bytes = c0Var.f38920a.getBytes("UTF-8");
        if (bytes.length <= this.f38962e.c()) {
            m(1, true, bytes);
            return;
        }
        throw new WebSocketException("message payload exceeds payload limit");
    }
}
