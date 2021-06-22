package d.a.m0.a.e0.h.d;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketException;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import d.a.m0.a.k;
import d.a.m0.t.d;
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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45339g = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f45341b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f45342c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0668a f45343d;

    /* renamed from: a  reason: collision with root package name */
    public int f45340a = 1;

    /* renamed from: e  reason: collision with root package name */
    public WebSocketFrame.OpCode f45344e = null;

    /* renamed from: f  reason: collision with root package name */
    public final List<WebSocketFrame> f45345f = new LinkedList();

    /* renamed from: d.a.m0.a.e0.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0668a {
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
        int i2 = this.f45340a;
        this.f45340a = 3;
        if (i2 == 2) {
            j(new WebSocketFrame.b(closeCode, str));
        } else {
            b();
        }
    }

    public final void b() {
        if (this.f45340a == 4) {
            return;
        }
        d.d(this.f45341b);
        d.d(this.f45342c);
        this.f45340a = 4;
        this.f45343d.onClose();
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
        if (this.f45340a == 3) {
            b();
        } else {
            a(closeCode, str);
        }
    }

    public final void d(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f45344e != null && f45339g) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.f45344e = webSocketFrame.f();
            this.f45345f.clear();
            this.f45345f.add(webSocketFrame);
        } else if (webSocketFrame.h()) {
            if (this.f45344e != null) {
                this.f45345f.add(webSocketFrame);
                this.f45343d.a(new WebSocketFrame(this.f45344e, this.f45345f));
                this.f45344e = null;
                this.f45345f.clear();
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else if (this.f45344e != null) {
            this.f45345f.add(webSocketFrame);
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
            if (f45339g) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (webSocketFrame.h() && webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f45344e == null) {
                if (webSocketFrame.f() != WebSocketFrame.OpCode.Text && webSocketFrame.f() != WebSocketFrame.OpCode.Binary) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
                }
                this.f45343d.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            d(webSocketFrame);
        }
    }

    public void h(InputStream inputStream, OutputStream outputStream) {
        this.f45341b = inputStream;
        this.f45342c = outputStream;
        this.f45340a = 2;
        InterfaceC0668a interfaceC0668a = this.f45343d;
        if (interfaceC0668a != null) {
            interfaceC0668a.c();
        }
        i();
    }

    public final void i() {
        while (this.f45340a == 2) {
            try {
                try {
                    e(WebSocketFrame.k(this.f45341b));
                } catch (IOException e2) {
                    if (this.f45343d != null) {
                        this.f45343d.b(e2);
                    }
                    d.a.m0.a.e0.d.c("V8WebSocket", "parse web socket frame fail", e2);
                }
            } finally {
                b();
            }
        }
    }

    public synchronized void j(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.t(this.f45342c);
    }

    public void k(InterfaceC0668a interfaceC0668a) {
        this.f45343d = interfaceC0668a;
    }
}
