package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public class bs9 extends Draft {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ds9 c;
    public List<ds9> d;
    public ws9 e;
    public List<ws9> f;
    public Framedata g;
    public List<ByteBuffer> h;
    public ByteBuffer i;
    public final Random j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755816279, "Lcom/repackage/bs9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755816279, "Lcom/repackage/bs9;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bs9() {
        this(Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void G(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj) == null) && yr9.u) {
            System.out.println(obj);
        }
    }

    public ds9 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (ds9) invokeV.objValue;
    }

    public List<ds9> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public List<ws9> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public final ByteBuffer D() throws LimitExedeedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = 0;
            for (ByteBuffer byteBuffer : this.h) {
                j += byteBuffer.limit();
            }
            if (j <= 2147483647L) {
                ByteBuffer allocate = ByteBuffer.allocate((int) j);
                for (ByteBuffer byteBuffer2 : this.h) {
                    allocate.put(byteBuffer2);
                }
                allocate.flip();
                return allocate;
            }
            throw new LimitExedeedException("Payloadsize is to big...");
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public ws9 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (ws9) invokeV.objValue;
    }

    public final String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.format(calendar.getTime());
        }
        return (String) invokeV.objValue;
    }

    public final byte[] H(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            byte[] bArr = new byte[i];
            int i2 = (i * 8) - 8;
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final Framedata.Opcode I(byte b) throws InvalidFrameException {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048583, this, b)) == null) {
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        switch (b) {
                            case 8:
                                return Framedata.Opcode.CLOSING;
                            case 9:
                                return Framedata.Opcode.PING;
                            case 10:
                                return Framedata.Opcode.PONG;
                            default:
                                throw new InvalidFrameException("Unknown opcode " + ((int) b));
                        }
                    }
                    return Framedata.Opcode.BINARY;
                }
                return Framedata.Opcode.TEXT;
            }
            return Framedata.Opcode.CONTINUOUS;
        }
        return (Framedata.Opcode) invokeB.objValue;
    }

    public Framedata J(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        InterceptResult invokeL;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
            int remaining = byteBuffer.remaining();
            int i2 = 2;
            if (remaining >= 2) {
                byte b = byteBuffer.get();
                boolean z2 = (b >> 8) != 0;
                boolean z3 = (b & 64) != 0;
                boolean z4 = (b & 32) != 0;
                boolean z5 = (b & 16) != 0;
                byte b2 = byteBuffer.get();
                boolean z6 = (b2 & Byte.MIN_VALUE) != 0;
                byte b3 = (byte) (b2 & ByteCompanionObject.MAX_VALUE);
                Framedata.Opcode I = I((byte) (b & 15));
                if (b3 >= 0 && b3 <= 125) {
                    z = z3;
                    i = b3;
                } else if (I == Framedata.Opcode.PING || I == Framedata.Opcode.PONG || I == Framedata.Opcode.CLOSING) {
                    throw new InvalidFrameException("more than 125 octets");
                } else {
                    if (b3 != 126) {
                        i2 = 10;
                        if (remaining >= 10) {
                            byte[] bArr = new byte[8];
                            for (int i3 = 0; i3 < 8; i3++) {
                                bArr[i3] = byteBuffer.get();
                            }
                            z = z3;
                            long longValue = new BigInteger(bArr).longValue();
                            if (longValue > 2147483647L) {
                                throw new LimitExedeedException("Payloadsize is to big...");
                            }
                            i = (int) longValue;
                        } else {
                            throw new IncompleteException(10);
                        }
                    } else if (remaining >= 4) {
                        z = z3;
                        i = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                        i2 = 4;
                    } else {
                        throw new IncompleteException(4);
                    }
                }
                int i4 = i2 + (z6 ? 4 : 0) + i;
                if (remaining >= i4) {
                    d(i);
                    ByteBuffer allocate = ByteBuffer.allocate(i);
                    if (z6) {
                        byte[] bArr2 = new byte[4];
                        byteBuffer.get(bArr2);
                        for (int i5 = 0; i5 < i; i5++) {
                            allocate.put((byte) (byteBuffer.get() ^ bArr2[i5 % 4]));
                        }
                    } else {
                        allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                        byteBuffer.position(byteBuffer.position() + allocate.limit());
                    }
                    js9 g = js9.g(I);
                    g.i(z2);
                    g.k(z);
                    g.l(z4);
                    g.m(z5);
                    allocate.flip();
                    g.j(allocate);
                    A().h(g);
                    A().f(g);
                    if (yr9.u) {
                        PrintStream printStream = System.out;
                        StringBuilder sb = new StringBuilder();
                        sb.append("afterDecoding(");
                        sb.append(g.a().remaining());
                        sb.append("): {");
                        sb.append(g.a().remaining() > 1000 ? "too big to display" : new String(g.a().array()));
                        sb.append('}');
                        printStream.println(sb.toString());
                    }
                    g.h();
                    return g;
                }
                throw new IncompleteException(i4);
            }
            throw new IncompleteException(2);
        }
        return (Framedata) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(ns9 ns9Var, us9 us9Var) throws InvalidHandshakeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, ns9Var, us9Var)) == null) {
            if (!c(us9Var)) {
                G("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
                return Draft.HandshakeState.NOT_MATCHED;
            } else if (ns9Var.e("Sec-WebSocket-Key") && us9Var.e("Sec-WebSocket-Accept")) {
                if (!z(ns9Var.d("Sec-WebSocket-Key")).equals(us9Var.d("Sec-WebSocket-Accept"))) {
                    G("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
                String d = us9Var.d("Sec-WebSocket-Extensions");
                Iterator<ds9> it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ds9 next = it.next();
                    if (next.b(d)) {
                        this.c = next;
                        handshakeState = Draft.HandshakeState.MATCHED;
                        G("acceptHandshakeAsClient - Matching extension found: " + this.c.toString());
                        break;
                    }
                }
                Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
                String d2 = us9Var.d("Sec-WebSocket-Protocol");
                Iterator<ws9> it2 = this.f.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ws9 next2 = it2.next();
                    if (next2.b(d2)) {
                        this.e = next2;
                        handshakeState2 = Draft.HandshakeState.MATCHED;
                        G("acceptHandshakeAsClient - Matching protocol found: " + this.e.toString());
                        break;
                    }
                }
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                if (handshakeState2 == handshakeState3 && handshakeState == handshakeState3) {
                    return handshakeState3;
                }
                G("acceptHandshakeAsClient - No matching extension or protocol found.");
                return Draft.HandshakeState.NOT_MATCHED;
            } else {
                G("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
                return Draft.HandshakeState.NOT_MATCHED;
            }
        }
        return (Draft.HandshakeState) invokeLL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState b(ns9 ns9Var) throws InvalidHandshakeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, ns9Var)) == null) {
            if (r(ns9Var) != 13) {
                G("acceptHandshakeAsServer - Wrong websocket version.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
            String d = ns9Var.d("Sec-WebSocket-Extensions");
            Iterator<ds9> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ds9 next = it.next();
                if (next.e(d)) {
                    this.c = next;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsServer - Matching extension found: " + this.c.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String d2 = ns9Var.d("Sec-WebSocket-Protocol");
            Iterator<ws9> it2 = this.f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ws9 next2 = it2.next();
                if (next2.b(d2)) {
                    this.e = next2;
                    handshakeState2 = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsServer - Matching protocol found: " + this.e.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
            if (handshakeState2 == handshakeState3 && handshakeState == handshakeState3) {
                return handshakeState3;
            }
            G("acceptHandshakeAsServer - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        return (Draft.HandshakeState) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || bs9.class != obj.getClass()) {
                return false;
            }
            bs9 bs9Var = (bs9) obj;
            ds9 ds9Var = this.c;
            if (ds9Var == null ? bs9Var.c == null : ds9Var.equals(bs9Var.c)) {
                ws9 ws9Var = this.e;
                ws9 ws9Var2 = bs9Var.e;
                return ws9Var != null ? ws9Var.equals(ws9Var2) : ws9Var2 == null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ds9 ds9Var : B()) {
                arrayList.add(ds9Var.a());
            }
            ArrayList arrayList2 = new ArrayList();
            for (ws9 ws9Var : C()) {
                arrayList2.add(ws9Var.a());
            }
            return new bs9(arrayList, arrayList2);
        }
        return (Draft) invokeV.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer g(Framedata framedata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, framedata)) == null) {
            A().c(framedata);
            if (yr9.u) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("afterEnconding(");
                sb.append(framedata.a().remaining());
                sb.append("): {");
                sb.append(framedata.a().remaining() > 1000 ? "too big to display" : new String(framedata.a().array()));
                sb.append('}');
                printStream.println(sb.toString());
            }
            return x(framedata);
        }
        return (ByteBuffer) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            ms9 ms9Var = new ms9();
            ms9Var.j(ByteBuffer.wrap(at9.f(str)));
            ms9Var.n(z);
            try {
                ms9Var.h();
                return Collections.singletonList(ms9Var);
            } catch (InvalidDataException e) {
                throw new NotSendableException(e);
            }
        }
        return (List) invokeLZ.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ds9 ds9Var = this.c;
            int hashCode = (ds9Var != null ? ds9Var.hashCode() : 0) * 31;
            ws9 ws9Var = this.e;
            return hashCode + (ws9Var != null ? ws9Var.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> i(ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, byteBuffer, z)) == null) {
            es9 es9Var = new es9();
            es9Var.j(byteBuffer);
            es9Var.n(z);
            try {
                es9Var.h();
                return Collections.singletonList(es9Var);
            } catch (InvalidDataException e) {
                throw new NotSendableException(e);
            }
        }
        return (List) invokeLZ.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? Draft.CloseHandshakeType.TWOWAY : (Draft.CloseHandshakeType) invokeV.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public os9 m(os9 os9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, os9Var)) == null) {
            os9Var.put("Upgrade", "websocket");
            os9Var.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            byte[] bArr = new byte[16];
            this.j.nextBytes(bArr);
            os9Var.put("Sec-WebSocket-Key", ys9.g(bArr));
            os9Var.put("Sec-WebSocket-Version", "13");
            StringBuilder sb = new StringBuilder();
            for (ds9 ds9Var : this.d) {
                if (ds9Var.g() != null && ds9Var.g().length() != 0) {
                    if (sb.length() > 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb.append(ds9Var.g());
                }
            }
            if (sb.length() != 0) {
                os9Var.put("Sec-WebSocket-Extensions", sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            for (ws9 ws9Var : this.f) {
                if (ws9Var.c().length() != 0) {
                    if (sb2.length() > 0) {
                        sb2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb2.append(ws9Var.c());
                }
            }
            if (sb2.length() != 0) {
                os9Var.put("Sec-WebSocket-Protocol", sb2.toString());
            }
            return os9Var;
        }
        return (os9) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public ps9 n(ns9 ns9Var, vs9 vs9Var) throws InvalidHandshakeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, ns9Var, vs9Var)) == null) {
            vs9Var.put("Upgrade", "websocket");
            vs9Var.put(HTTP.CONN_DIRECTIVE, ns9Var.d(HTTP.CONN_DIRECTIVE));
            String d = ns9Var.d("Sec-WebSocket-Key");
            if (d != null) {
                vs9Var.put("Sec-WebSocket-Accept", z(d));
                if (A().d().length() != 0) {
                    vs9Var.put("Sec-WebSocket-Extensions", A().d());
                }
                if (E() != null && E().c().length() != 0) {
                    vs9Var.put("Sec-WebSocket-Protocol", E().c());
                }
                vs9Var.c("Web Socket Protocol Handshake");
                vs9Var.put("Server", "TooTallNate Java-WebSocket");
                vs9Var.put("Date", F());
                return vs9Var;
            }
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        return (ps9) invokeLL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public void o(yr9 yr9Var, Framedata framedata) throws InvalidDataException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, yr9Var, framedata) == null) {
            Framedata.Opcode d = framedata.d();
            if (d == Framedata.Opcode.CLOSING) {
                int i = 1005;
                if (framedata instanceof fs9) {
                    fs9 fs9Var = (fs9) framedata;
                    i = fs9Var.o();
                    str = fs9Var.p();
                } else {
                    str = "";
                }
                if (yr9Var.t() == WebSocket.READYSTATE.CLOSING) {
                    yr9Var.g(i, str, true);
                } else if (l() == Draft.CloseHandshakeType.TWOWAY) {
                    yr9Var.d(i, str, true);
                } else {
                    yr9Var.o(i, str, false);
                }
            } else if (d == Framedata.Opcode.PING) {
                yr9Var.v().onWebsocketPing(yr9Var, framedata);
            } else if (d == Framedata.Opcode.PONG) {
                yr9Var.N();
                yr9Var.v().onWebsocketPong(yr9Var, framedata);
            } else if (framedata.f() && d != Framedata.Opcode.CONTINUOUS) {
                if (this.g == null) {
                    if (d == Framedata.Opcode.TEXT) {
                        try {
                            yr9Var.v().onWebsocketMessage(yr9Var, at9.e(framedata.a()));
                            return;
                        } catch (RuntimeException e) {
                            yr9Var.v().onWebsocketError(yr9Var, e);
                            return;
                        }
                    } else if (d == Framedata.Opcode.BINARY) {
                        try {
                            yr9Var.v().onWebsocketMessage(yr9Var, framedata.a());
                            return;
                        } catch (RuntimeException e2) {
                            yr9Var.v().onWebsocketError(yr9Var, e2);
                            return;
                        }
                    } else {
                        throw new InvalidDataException(1002, "non control or continious frame expected");
                    }
                }
                throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
            } else {
                if (d != Framedata.Opcode.CONTINUOUS) {
                    if (this.g == null) {
                        this.g = framedata;
                        this.h.add(framedata.a());
                    } else {
                        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (framedata.f()) {
                    if (this.g != null) {
                        this.h.add(framedata.a());
                        if (this.g.d() == Framedata.Opcode.TEXT) {
                            ((js9) this.g).j(D());
                            ((js9) this.g).h();
                            try {
                                yr9Var.v().onWebsocketMessage(yr9Var, at9.e(this.g.a()));
                            } catch (RuntimeException e3) {
                                yr9Var.v().onWebsocketError(yr9Var, e3);
                            }
                        } else if (this.g.d() == Framedata.Opcode.BINARY) {
                            ((js9) this.g).j(D());
                            ((js9) this.g).h();
                            try {
                                yr9Var.v().onWebsocketMessage(yr9Var, this.g.a());
                            } catch (RuntimeException e4) {
                                yr9Var.v().onWebsocketError(yr9Var, e4);
                            }
                        }
                        this.g = null;
                        this.h.clear();
                    } else {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.g == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                if (d == Framedata.Opcode.TEXT && !at9.b(framedata.a())) {
                    throw new InvalidDataException(1007);
                }
                if (d != Framedata.Opcode.CONTINUOUS || this.g == null) {
                    return;
                }
                this.h.add(framedata.a());
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.i = null;
            ds9 ds9Var = this.c;
            if (ds9Var != null) {
                ds9Var.reset();
            }
            this.c = new cs9();
            this.e = null;
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String draft = super.toString();
            if (A() != null) {
                draft = draft + " extension: " + A().toString();
            }
            if (E() != null) {
                return draft + " protocol: " + E().toString();
            }
            return draft;
        }
        return (String) invokeV.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> u(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, byteBuffer)) == null) {
            while (true) {
                linkedList = new LinkedList();
                if (this.i == null) {
                    break;
                }
                try {
                    byteBuffer.mark();
                    int remaining = byteBuffer.remaining();
                    int remaining2 = this.i.remaining();
                    if (remaining2 > remaining) {
                        this.i.put(byteBuffer.array(), byteBuffer.position(), remaining);
                        byteBuffer.position(byteBuffer.position() + remaining);
                        return Collections.emptyList();
                    }
                    this.i.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                    byteBuffer.position(byteBuffer.position() + remaining2);
                    linkedList.add(J((ByteBuffer) this.i.duplicate().position(0)));
                    this.i = null;
                } catch (IncompleteException e) {
                    int preferredSize = e.getPreferredSize();
                    d(preferredSize);
                    ByteBuffer allocate = ByteBuffer.allocate(preferredSize);
                    this.i.rewind();
                    allocate.put(this.i);
                    this.i = allocate;
                }
            }
            while (byteBuffer.hasRemaining()) {
                byteBuffer.mark();
                try {
                    linkedList.add(J(byteBuffer));
                } catch (IncompleteException e2) {
                    byteBuffer.reset();
                    int preferredSize2 = e2.getPreferredSize();
                    d(preferredSize2);
                    ByteBuffer allocate2 = ByteBuffer.allocate(preferredSize2);
                    this.i = allocate2;
                    allocate2.put(byteBuffer);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public final ByteBuffer x(Framedata framedata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, framedata)) == null) {
            ByteBuffer a = framedata.a();
            int i = 0;
            boolean z = this.a == WebSocket.Role.CLIENT;
            int i2 = a.remaining() <= 125 ? 1 : a.remaining() <= 65535 ? 2 : 8;
            ByteBuffer allocate = ByteBuffer.allocate((i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0) + a.remaining());
            allocate.put((byte) (((byte) (framedata.f() ? -128 : 0)) | y(framedata.d())));
            byte[] H = H(a.remaining(), i2);
            if (i2 == 1) {
                allocate.put((byte) (H[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i2 == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(H);
            } else if (i2 == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | ByteCompanionObject.MAX_VALUE));
                allocate.put(H);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.j.nextInt());
                allocate.put(allocate2.array());
                while (a.hasRemaining()) {
                    allocate.put((byte) (a.get() ^ allocate2.get(i % 4)));
                    i++;
                }
            } else {
                allocate.put(a);
                a.flip();
            }
            allocate.flip();
            return allocate;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public final byte y(Framedata.Opcode opcode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, opcode)) == null) {
            if (opcode == Framedata.Opcode.CONTINUOUS) {
                return (byte) 0;
            }
            if (opcode == Framedata.Opcode.TEXT) {
                return (byte) 1;
            }
            if (opcode == Framedata.Opcode.BINARY) {
                return (byte) 2;
            }
            if (opcode == Framedata.Opcode.CLOSING) {
                return (byte) 8;
            }
            if (opcode == Framedata.Opcode.PING) {
                return (byte) 9;
            }
            if (opcode == Framedata.Opcode.PONG) {
                return (byte) 10;
            }
            throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
        }
        return invokeL.byteValue;
    }

    public final String z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            String trim = str.trim();
            try {
                return ys9.g(MessageDigest.getInstance("SHA1").digest((trim + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException(e);
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bs9(List<ds9> list) {
        this(list, Collections.singletonList(new xs9("")));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public bs9(List<ds9> list, List<ws9> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.c = new cs9();
        this.j = new Random();
        if (list != null && list2 != null) {
            this.d = new ArrayList(list.size());
            this.f = new ArrayList(list2.size());
            boolean z = false;
            this.h = new ArrayList();
            for (ds9 ds9Var : list) {
                if (ds9Var.getClass().equals(cs9.class)) {
                    z = true;
                }
            }
            this.d.addAll(list);
            if (!z) {
                List<ds9> list3 = this.d;
                list3.add(list3.size(), this.c);
            }
            this.f.addAll(list2);
            return;
        }
        throw new IllegalArgumentException();
    }
}
