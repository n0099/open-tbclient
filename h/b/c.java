package h.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.b.h.g;
import h.b.i.f;
import h.b.i.h;
import h.b.i.i;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public class c implements WebSocket {
    public static /* synthetic */ Interceptable $ic = null;
    public static int x = 16384;
    public static boolean y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f64101e;

    /* renamed from: f  reason: collision with root package name */
    public final d f64102f;

    /* renamed from: g  reason: collision with root package name */
    public SelectionKey f64103g;

    /* renamed from: h  reason: collision with root package name */
    public ByteChannel f64104h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f64105i;

    /* renamed from: j  reason: collision with root package name */
    public WebSocket.READYSTATE f64106j;

    /* renamed from: k  reason: collision with root package name */
    public List<Draft> f64107k;
    public Draft l;
    public WebSocket.Role m;
    public ByteBuffer n;
    public h.b.i.a o;
    public String p;
    public Integer q;
    public Boolean r;
    public String s;
    public long t;
    public final Object u;
    public g v;
    public Object w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1754608024, "Lh/b/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1754608024, "Lh/b/c;");
        }
    }

    public c(d dVar, Draft draft) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, draft};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64105i = false;
        this.f64106j = WebSocket.READYSTATE.NOT_YET_CONNECTED;
        this.l = null;
        this.n = ByteBuffer.allocate(0);
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = System.currentTimeMillis();
        this.u = new Object();
        if (dVar != null && (draft != null || this.m != WebSocket.Role.SERVER)) {
            this.f64101e = new LinkedBlockingQueue();
            new LinkedBlockingQueue();
            this.f64102f = dVar;
            this.m = WebSocket.Role.CLIENT;
            if (draft != null) {
                this.l = draft.f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64105i : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? t() == WebSocket.READYSTATE.OPEN : invokeV.booleanValue;
    }

    public final void C(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            if (y) {
                PrintStream printStream = System.out;
                printStream.println("open using draft: " + this.l);
            }
            L(WebSocket.READYSTATE.OPEN);
            try {
                this.f64102f.onWebsocketOpen(this, fVar);
            } catch (RuntimeException e2) {
                this.f64102f.onWebsocketError(this, e2);
            }
        }
    }

    public void D(String str) throws WebsocketNotConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str == null) {
                throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
            }
            F(this.l.h(str, this.m == WebSocket.Role.CLIENT));
        }
    }

    public void E(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
            }
            F(this.l.i(byteBuffer, this.m == WebSocket.Role.CLIENT));
        }
    }

    public final void F(Collection<Framedata> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, collection) == null) {
            if (!B()) {
                throw new WebsocketNotConnectedException();
            }
            if (collection != null) {
                ArrayList arrayList = new ArrayList();
                for (Framedata framedata : collection) {
                    if (y) {
                        PrintStream printStream = System.out;
                        printStream.println("send frame: " + framedata);
                    }
                    arrayList.add(this.l.g(framedata));
                }
                P(arrayList);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void G(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) {
            E(ByteBuffer.wrap(bArr));
        }
    }

    public void H(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, opcode, byteBuffer, z) == null) {
            F(this.l.e(opcode, byteBuffer, z));
        }
    }

    public void I(Collection<Framedata> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection) == null) {
            F(collection);
        }
    }

    public void J() throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.v == null) {
                this.v = new g();
            }
            sendFrame(this.v);
        }
    }

    public <T> void K(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, t) == null) {
            this.w = t;
        }
    }

    public final void L(WebSocket.READYSTATE readystate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, readystate) == null) {
            this.f64106j = readystate;
        }
    }

    public void M(h.b.i.b bVar) throws InvalidHandshakeException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.l.m(bVar);
            this.o = bVar;
            this.s = bVar.f();
            try {
                this.f64102f.onWebsocketHandshakeSentAsClient(this, this.o);
                P(this.l.j(this.o, this.m));
            } catch (RuntimeException e2) {
                this.f64102f.onWebsocketError(this, e2);
                throw new InvalidHandshakeException("rejected because of" + e2);
            } catch (InvalidDataException unused) {
                throw new InvalidHandshakeException("Handshake data rejected by client.");
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t = System.currentTimeMillis();
        }
    }

    public final void O(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, byteBuffer) == null) {
            if (y) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("write(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
                sb.append(ExtendedMessageFormat.END_FE);
                printStream.println(sb.toString());
            }
            this.f64101e.add(byteBuffer);
            this.f64102f.onWriteDemand(this);
        }
    }

    public final void P(List<ByteBuffer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            synchronized (this.u) {
                for (ByteBuffer byteBuffer : list) {
                    O(byteBuffer);
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b(1000);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            d(i2, "", false);
        }
    }

    public void c(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, str) == null) {
            d(i2, str, false);
        }
    }

    public synchronized void d(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (t() == WebSocket.READYSTATE.CLOSING || this.f64106j == WebSocket.READYSTATE.CLOSED) {
                    return;
                }
                if (t() == WebSocket.READYSTATE.OPEN) {
                    if (i2 == 1006) {
                        L(WebSocket.READYSTATE.CLOSING);
                        o(i2, str, false);
                        return;
                    }
                    if (this.l.l() != Draft.CloseHandshakeType.NONE) {
                        try {
                            if (!z) {
                                try {
                                    this.f64102f.onWebsocketCloseInitiated(this, i2, str);
                                } catch (RuntimeException e2) {
                                    this.f64102f.onWebsocketError(this, e2);
                                }
                            }
                            if (B()) {
                                h.b.h.b bVar = new h.b.h.b();
                                bVar.r(str);
                                bVar.q(i2);
                                bVar.h();
                                sendFrame(bVar);
                            }
                        } catch (InvalidDataException e3) {
                            this.f64102f.onWebsocketError(this, e3);
                            o(1006, "generated frame is invalid", false);
                        }
                    }
                    o(i2, str, z);
                } else if (i2 == -3) {
                    o(-3, str, true);
                } else if (i2 == 1002) {
                    o(i2, str, z);
                } else {
                    o(-1, str, false);
                }
                L(WebSocket.READYSTATE.CLOSING);
                this.n = null;
            }
        }
    }

    public void e(InvalidDataException invalidDataException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, invalidDataException) == null) {
            d(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
        }
    }

    public void f(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, str) == null) {
            g(i2, str, false);
        }
    }

    public synchronized void g(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (t() == WebSocket.READYSTATE.CLOSED) {
                    return;
                }
                if (t() == WebSocket.READYSTATE.OPEN && i2 == 1006) {
                    L(WebSocket.READYSTATE.CLOSING);
                }
                if (this.f64103g != null) {
                    this.f64103g.cancel();
                }
                if (this.f64104h != null) {
                    try {
                        this.f64104h.close();
                    } catch (IOException e2) {
                        if (e2.getMessage().equals("Broken pipe")) {
                            if (y) {
                                System.out.println("Caught IOException: Broken pipe during closeConnection()");
                            }
                        } else {
                            this.f64102f.onWebsocketError(this, e2);
                        }
                    }
                }
                try {
                    this.f64102f.onWebsocketClose(this, i2, str, z);
                } catch (RuntimeException e3) {
                    this.f64102f.onWebsocketError(this, e3);
                }
                if (this.l != null) {
                    this.l.s();
                }
                this.o = null;
                L(WebSocket.READYSTATE.CLOSED);
            }
        }
    }

    public void h(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            g(i2, "", z);
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public final void i(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, runtimeException) == null) {
            O(p(500));
            o(-1, runtimeException.getMessage(), false);
        }
    }

    public final void j(InvalidDataException invalidDataException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, invalidDataException) == null) {
            O(p(404));
            o(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
        }
    }

    public void k(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, byteBuffer) == null) {
            if (y) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("process(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
                sb.append(ExtendedMessageFormat.END_FE);
                printStream.println(sb.toString());
            }
            if (t() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
                if (t() == WebSocket.READYSTATE.OPEN) {
                    l(byteBuffer);
                }
            } else if (!m(byteBuffer) || y() || x()) {
            } else {
                if (byteBuffer.hasRemaining()) {
                    l(byteBuffer);
                } else if (this.n.hasRemaining()) {
                    l(this.n);
                }
            }
        }
    }

    public final void l(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, byteBuffer) == null) {
            try {
                for (Framedata framedata : this.l.u(byteBuffer)) {
                    if (y) {
                        PrintStream printStream = System.out;
                        printStream.println("matched frame: " + framedata);
                    }
                    this.l.o(this, framedata);
                }
            } catch (InvalidDataException e2) {
                this.f64102f.onWebsocketError(this, e2);
                e(e2);
            }
        }
    }

    public final boolean m(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        ByteBuffer byteBuffer2;
        f v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, byteBuffer)) == null) {
            if (this.n.capacity() == 0) {
                byteBuffer2 = byteBuffer;
            } else {
                if (this.n.remaining() < byteBuffer.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(this.n.capacity() + byteBuffer.remaining());
                    this.n.flip();
                    allocate.put(this.n);
                    this.n = allocate;
                }
                this.n.put(byteBuffer);
                this.n.flip();
                byteBuffer2 = this.n;
            }
            byteBuffer2.mark();
            try {
                try {
                } catch (InvalidHandshakeException e2) {
                    e(e2);
                }
            } catch (IncompleteHandshakeException e3) {
                if (this.n.capacity() == 0) {
                    byteBuffer2.reset();
                    int preferedSize = e3.getPreferedSize();
                    if (preferedSize == 0) {
                        preferedSize = byteBuffer2.capacity() + 16;
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(preferedSize);
                    this.n = allocate2;
                    allocate2.put(byteBuffer);
                } else {
                    ByteBuffer byteBuffer3 = this.n;
                    byteBuffer3.position(byteBuffer3.limit());
                    ByteBuffer byteBuffer4 = this.n;
                    byteBuffer4.limit(byteBuffer4.capacity());
                }
            }
            if (this.m == WebSocket.Role.SERVER) {
                if (this.l == null) {
                    for (Draft draft : this.f64107k) {
                        Draft f2 = draft.f();
                        try {
                            f2.t(this.m);
                            byteBuffer2.reset();
                            v = f2.v(byteBuffer2);
                        } catch (InvalidHandshakeException unused) {
                        }
                        if (!(v instanceof h.b.i.a)) {
                            j(new InvalidDataException(1002, "wrong http function"));
                            return false;
                        }
                        h.b.i.a aVar = (h.b.i.a) v;
                        if (f2.b(aVar) == Draft.HandshakeState.MATCHED) {
                            this.s = aVar.f();
                            try {
                                i onWebsocketHandshakeReceivedAsServer = this.f64102f.onWebsocketHandshakeReceivedAsServer(this, f2, aVar);
                                f2.n(aVar, onWebsocketHandshakeReceivedAsServer);
                                P(f2.j(onWebsocketHandshakeReceivedAsServer, this.m));
                                this.l = f2;
                                C(aVar);
                                return true;
                            } catch (RuntimeException e4) {
                                this.f64102f.onWebsocketError(this, e4);
                                i(e4);
                                return false;
                            } catch (InvalidDataException e5) {
                                j(e5);
                                return false;
                            }
                        }
                    }
                    if (this.l == null) {
                        j(new InvalidDataException(1002, "no draft matches"));
                    }
                    return false;
                }
                f v2 = this.l.v(byteBuffer2);
                if (!(v2 instanceof h.b.i.a)) {
                    o(1002, "wrong http function", false);
                    return false;
                }
                h.b.i.a aVar2 = (h.b.i.a) v2;
                if (this.l.b(aVar2) == Draft.HandshakeState.MATCHED) {
                    C(aVar2);
                    return true;
                }
                c(1002, "the handshake did finaly not match");
                return false;
            }
            if (this.m == WebSocket.Role.CLIENT) {
                this.l.t(this.m);
                f v3 = this.l.v(byteBuffer2);
                if (!(v3 instanceof h)) {
                    o(1002, "wrong http function", false);
                    return false;
                }
                h hVar = (h) v3;
                if (this.l.a(this.o, hVar) == Draft.HandshakeState.MATCHED) {
                    try {
                        this.f64102f.onWebsocketHandshakeReceivedAsClient(this, this.o, hVar);
                        C(hVar);
                        return true;
                    } catch (RuntimeException e6) {
                        this.f64102f.onWebsocketError(this, e6);
                        o(-1, e6.getMessage(), false);
                        return false;
                    } catch (InvalidDataException e7) {
                        o(e7.getCloseCode(), e7.getMessage(), false);
                        return false;
                    }
                }
                c(1002, "draft " + this.l + " refuses handshake");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (t() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
                h(-1, true);
            } else if (this.f64105i) {
                g(this.q.intValue(), this.p, this.r.booleanValue());
            } else if (this.l.l() == Draft.CloseHandshakeType.NONE) {
                h(1000, true);
            } else if (this.l.l() == Draft.CloseHandshakeType.ONEWAY) {
                if (this.m == WebSocket.Role.SERVER) {
                    h(1006, true);
                } else {
                    h(1000, true);
                }
            } else {
                h(1006, true);
            }
        }
    }

    public synchronized void o(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.f64105i) {
                    return;
                }
                this.q = Integer.valueOf(i2);
                this.p = str;
                this.r = Boolean.valueOf(z);
                this.f64105i = true;
                this.f64102f.onWriteDemand(this);
                try {
                    this.f64102f.onWebsocketClosing(this, i2, str, z);
                } catch (RuntimeException e2) {
                    this.f64102f.onWebsocketError(this, e2);
                }
                if (this.l != null) {
                    this.l.s();
                }
                this.o = null;
            }
        }
    }

    public final ByteBuffer p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            String str = i2 != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
            return ByteBuffer.wrap(h.b.k.c.a("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
        }
        return (ByteBuffer) invokeI.objValue;
    }

    public <T> T q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (T) this.w : (T) invokeV.objValue;
    }

    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.t : invokeV.longValue;
    }

    public InetSocketAddress s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f64102f.getLocalSocketAddress(this) : (InetSocketAddress) invokeV.objValue;
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, framedata) == null) {
            F(Collections.singletonList(framedata));
        }
    }

    public WebSocket.READYSTATE t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f64106j : (WebSocket.READYSTATE) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? super.toString() : (String) invokeV.objValue;
    }

    public InetSocketAddress u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f64102f.getRemoteSocketAddress(this) : (InetSocketAddress) invokeV.objValue;
    }

    public d v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f64102f : (d) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? !this.f64101e.isEmpty() : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? t() == WebSocket.READYSTATE.CLOSED : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? t() == WebSocket.READYSTATE.CLOSING : invokeV.booleanValue;
    }

    @Deprecated
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? t() == WebSocket.READYSTATE.CONNECTING : invokeV.booleanValue;
    }
}
