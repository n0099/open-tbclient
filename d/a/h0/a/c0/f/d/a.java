package d.a.h0.a.c0.f.d;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketException;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import d.a.h0.a.c0.c;
import d.a.h0.a.k;
import d.a.h0.p.d;
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
    public static final boolean f41730g = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f41732b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f41733c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0600a f41734d;

    /* renamed from: a  reason: collision with root package name */
    public int f41731a = 1;

    /* renamed from: e  reason: collision with root package name */
    public WebSocketFrame.OpCode f41735e = null;

    /* renamed from: f  reason: collision with root package name */
    public final List<WebSocketFrame> f41736f = new LinkedList();

    /* renamed from: d.a.h0.a.c0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0600a {
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
        int i2 = this.f41731a;
        this.f41731a = 3;
        if (i2 == 2) {
            j(new WebSocketFrame.b(closeCode, str));
        } else {
            b();
        }
    }

    public final void b() {
        if (this.f41731a == 4) {
            return;
        }
        d.a(this.f41732b);
        d.a(this.f41733c);
        this.f41731a = 4;
        this.f41734d.onClose();
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
        if (this.f41731a == 3) {
            b();
        } else {
            a(closeCode, str);
        }
    }

    public final void d(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f41735e != null && f41730g) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.f41735e = webSocketFrame.f();
            this.f41736f.clear();
            this.f41736f.add(webSocketFrame);
        } else if (webSocketFrame.h()) {
            if (this.f41735e != null) {
                this.f41736f.add(webSocketFrame);
                this.f41734d.a(new WebSocketFrame(this.f41735e, this.f41736f));
                this.f41735e = null;
                this.f41736f.clear();
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else if (this.f41735e != null) {
            this.f41736f.add(webSocketFrame);
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
            if (f41730g) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (webSocketFrame.h() && webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f41735e == null) {
                if (webSocketFrame.f() != WebSocketFrame.OpCode.Text && webSocketFrame.f() != WebSocketFrame.OpCode.Binary) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
                }
                this.f41734d.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            d(webSocketFrame);
        }
    }

    public void h(InputStream inputStream, OutputStream outputStream) {
        this.f41732b = inputStream;
        this.f41733c = outputStream;
        this.f41731a = 2;
        InterfaceC0600a interfaceC0600a = this.f41734d;
        if (interfaceC0600a != null) {
            interfaceC0600a.c();
        }
        i();
    }

    public final void i() {
        while (this.f41731a == 2) {
            try {
                try {
                    e(WebSocketFrame.k(this.f41732b));
                } catch (IOException e2) {
                    if (this.f41734d != null) {
                        this.f41734d.b(e2);
                    }
                    c.c("V8WebSocket", "parse web socket frame fail", e2);
                }
            } finally {
                b();
            }
        }
    }

    public synchronized void j(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.t(this.f41733c);
    }

    public void k(InterfaceC0600a interfaceC0600a) {
        this.f41734d = interfaceC0600a;
    }
}
