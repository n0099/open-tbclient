package d.b.g0.a.c0.f.d;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketException;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import d.b.g0.a.c0.c;
import d.b.g0.a.k;
import d.b.g0.p.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44111g = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f44113b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f44114c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0641a f44115d;

    /* renamed from: a  reason: collision with root package name */
    public int f44112a = 1;

    /* renamed from: e  reason: collision with root package name */
    public WebSocketFrame.OpCode f44116e = null;

    /* renamed from: f  reason: collision with root package name */
    public final List<WebSocketFrame> f44117f = new LinkedList();

    /* renamed from: d.b.g0.a.c0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0641a {
        void a(WebSocketFrame webSocketFrame);

        void b(IOException iOException);

        void c();

        void onClose();
    }

    public static boolean f(Map<String, String> map) {
        String str = map.get("Upgrade".toLowerCase());
        String str2 = map.get(HTTP.CONN_DIRECTIVE.toLowerCase());
        return "websocket".equalsIgnoreCase(str) && (str2 != null && str2.toLowerCase().contains("Upgrade".toLowerCase()));
    }

    public static String g(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update((str + WebSocketProtocol.ACCEPT_MAGIC).getBytes());
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    public void a(WebSocketFrame.CloseCode closeCode, String str) throws IOException {
        int i = this.f44112a;
        this.f44112a = 3;
        if (i == 2) {
            j(new WebSocketFrame.b(closeCode, str));
        } else {
            b();
        }
    }

    public final void b() {
        if (this.f44112a == 4) {
            return;
        }
        d.a(this.f44113b);
        d.a(this.f44114c);
        this.f44112a = 4;
        this.f44115d.onClose();
    }

    public final void c(WebSocketFrame webSocketFrame) throws IOException {
        String str;
        WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
        if (webSocketFrame instanceof WebSocketFrame.b) {
            WebSocketFrame.b bVar = (WebSocketFrame.b) webSocketFrame;
            closeCode = bVar.v();
            str = bVar.w();
        } else {
            str = "";
        }
        if (this.f44112a == 3) {
            b();
        } else {
            a(closeCode, str);
        }
    }

    public final void d(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f44116e != null && f44111g) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.f44116e = webSocketFrame.f();
            this.f44117f.clear();
            this.f44117f.add(webSocketFrame);
        } else if (webSocketFrame.h()) {
            if (this.f44116e != null) {
                this.f44117f.add(webSocketFrame);
                this.f44115d.a(new WebSocketFrame(this.f44116e, this.f44117f));
                this.f44116e = null;
                this.f44117f.clear();
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else if (this.f44116e != null) {
            this.f44117f.add(webSocketFrame);
        } else {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        }
    }

    public final void e(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.f() == WebSocketFrame.OpCode.Close) {
            c(webSocketFrame);
        } else if (webSocketFrame.f() == WebSocketFrame.OpCode.Ping) {
            j(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.d()));
        } else if (webSocketFrame.f() == WebSocketFrame.OpCode.Pong) {
            if (f44111g) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (webSocketFrame.h() && webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f44116e == null) {
                if (webSocketFrame.f() != WebSocketFrame.OpCode.Text && webSocketFrame.f() != WebSocketFrame.OpCode.Binary) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
                }
                this.f44115d.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            d(webSocketFrame);
        }
    }

    public void h(InputStream inputStream, OutputStream outputStream) {
        this.f44113b = inputStream;
        this.f44114c = outputStream;
        this.f44112a = 2;
        InterfaceC0641a interfaceC0641a = this.f44115d;
        if (interfaceC0641a != null) {
            interfaceC0641a.c();
        }
        i();
    }

    public final void i() {
        while (this.f44112a == 2) {
            try {
                try {
                    e(WebSocketFrame.k(this.f44113b));
                } catch (IOException e2) {
                    if (this.f44115d != null) {
                        this.f44115d.b(e2);
                    }
                    c.c("V8WebSocket", "parse web socket frame fail", e2);
                }
            } finally {
                b();
            }
        }
    }

    public synchronized void j(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.t(this.f44114c);
    }

    public void k(InterfaceC0641a interfaceC0641a) {
        this.f44115d = interfaceC0641a;
    }
}
