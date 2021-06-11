package d.a.l0.a.e0.h.d;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketException;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import d.a.l0.a.k;
import d.a.l0.t.d;
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
    public static final boolean f45231g = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f45233b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f45234c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0665a f45235d;

    /* renamed from: a  reason: collision with root package name */
    public int f45232a = 1;

    /* renamed from: e  reason: collision with root package name */
    public WebSocketFrame.OpCode f45236e = null;

    /* renamed from: f  reason: collision with root package name */
    public final List<WebSocketFrame> f45237f = new LinkedList();

    /* renamed from: d.a.l0.a.e0.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0665a {
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
        int i2 = this.f45232a;
        this.f45232a = 3;
        if (i2 == 2) {
            j(new WebSocketFrame.b(closeCode, str));
        } else {
            b();
        }
    }

    public final void b() {
        if (this.f45232a == 4) {
            return;
        }
        d.d(this.f45233b);
        d.d(this.f45234c);
        this.f45232a = 4;
        this.f45235d.onClose();
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
        if (this.f45232a == 3) {
            b();
        } else {
            a(closeCode, str);
        }
    }

    public final void d(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f45236e != null && f45231g) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.f45236e = webSocketFrame.f();
            this.f45237f.clear();
            this.f45237f.add(webSocketFrame);
        } else if (webSocketFrame.h()) {
            if (this.f45236e != null) {
                this.f45237f.add(webSocketFrame);
                this.f45235d.a(new WebSocketFrame(this.f45236e, this.f45237f));
                this.f45236e = null;
                this.f45237f.clear();
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else if (this.f45236e != null) {
            this.f45237f.add(webSocketFrame);
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
            if (f45231g) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (webSocketFrame.h() && webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
            if (this.f45236e == null) {
                if (webSocketFrame.f() != WebSocketFrame.OpCode.Text && webSocketFrame.f() != WebSocketFrame.OpCode.Binary) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
                }
                this.f45235d.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            d(webSocketFrame);
        }
    }

    public void h(InputStream inputStream, OutputStream outputStream) {
        this.f45233b = inputStream;
        this.f45234c = outputStream;
        this.f45232a = 2;
        InterfaceC0665a interfaceC0665a = this.f45235d;
        if (interfaceC0665a != null) {
            interfaceC0665a.c();
        }
        i();
    }

    public final void i() {
        while (this.f45232a == 2) {
            try {
                try {
                    e(WebSocketFrame.k(this.f45233b));
                } catch (IOException e2) {
                    if (this.f45235d != null) {
                        this.f45235d.b(e2);
                    }
                    d.a.l0.a.e0.d.c("V8WebSocket", "parse web socket frame fail", e2);
                }
            } finally {
                b();
            }
        }
    }

    public synchronized void j(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.t(this.f45234c);
    }

    public void k(InterfaceC0665a interfaceC0665a) {
        this.f45235d = interfaceC0665a;
    }
}
