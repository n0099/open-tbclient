package org.java_websocket.drafts;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tieba.aca;
import com.baidu.tieba.bca;
import com.baidu.tieba.eba;
import com.baidu.tieba.gca;
import com.baidu.tieba.kba;
import com.baidu.tieba.mba;
import com.baidu.tieba.pba;
import com.baidu.tieba.sba;
import com.baidu.tieba.tba;
import com.baidu.tieba.uba;
import com.baidu.tieba.vba;
import com.baidu.tieba.wba;
import com.baidu.tieba.xba;
import com.baidu.tieba.yba;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HTTP;
import org.java_websocket.WebSocket;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes9.dex */
public abstract class Draft {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebSocket.Role a;
    public Framedata.Opcode b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1598359753, "Lorg/java_websocket/drafts/Draft;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1598359753, "Lorg/java_websocket/drafts/Draft;");
        }
    }

    public abstract HandshakeState a(tba tbaVar, aca acaVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(tba tbaVar) throws InvalidHandshakeException;

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType l();

    public abstract uba m(uba ubaVar) throws InvalidHandshakeException;

    public abstract vba n(tba tbaVar, bca bcaVar) throws InvalidHandshakeException;

    public abstract void o(eba ebaVar, Framedata framedata) throws InvalidDataException;

    public abstract void s();

    public abstract List<Framedata> u(ByteBuffer byteBuffer) throws InvalidDataException;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class CloseHandshakeType {
        public static final /* synthetic */ CloseHandshakeType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloseHandshakeType NONE;
        public static final CloseHandshakeType ONEWAY;
        public static final CloseHandshakeType TWOWAY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(686912656, "Lorg/java_websocket/drafts/Draft$CloseHandshakeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(686912656, "Lorg/java_websocket/drafts/Draft$CloseHandshakeType;");
                    return;
                }
            }
            NONE = new CloseHandshakeType(HlsPlaylistParser.METHOD_NONE, 0);
            ONEWAY = new CloseHandshakeType("ONEWAY", 1);
            CloseHandshakeType closeHandshakeType = new CloseHandshakeType("TWOWAY", 2);
            TWOWAY = closeHandshakeType;
            $VALUES = new CloseHandshakeType[]{NONE, ONEWAY, closeHandshakeType};
        }

        public CloseHandshakeType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CloseHandshakeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CloseHandshakeType) Enum.valueOf(CloseHandshakeType.class, str);
            }
            return (CloseHandshakeType) invokeL.objValue;
        }

        public static CloseHandshakeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CloseHandshakeType[]) $VALUES.clone();
            }
            return (CloseHandshakeType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class HandshakeState {
        public static final /* synthetic */ HandshakeState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HandshakeState MATCHED;
        public static final HandshakeState NOT_MATCHED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039289231, "Lorg/java_websocket/drafts/Draft$HandshakeState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2039289231, "Lorg/java_websocket/drafts/Draft$HandshakeState;");
                    return;
                }
            }
            MATCHED = new HandshakeState("MATCHED", 0);
            HandshakeState handshakeState = new HandshakeState("NOT_MATCHED", 1);
            NOT_MATCHED = handshakeState;
            $VALUES = new HandshakeState[]{MATCHED, handshakeState};
        }

        public HandshakeState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static HandshakeState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (HandshakeState) Enum.valueOf(HandshakeState.class, str);
            }
            return (HandshakeState) invokeL.objValue;
        }

        public static HandshakeState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (HandshakeState[]) $VALUES.clone();
            }
            return (HandshakeState[]) invokeV.objValue;
        }
    }

    public Draft() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return getClass().getSimpleName();
        }
        return (String) invokeV.objValue;
    }

    public static ByteBuffer p(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, byteBuffer)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            byte b = 48;
            while (byteBuffer.hasRemaining()) {
                byte b2 = byteBuffer.get();
                allocate.put(b2);
                if (b == 13 && b2 == 10) {
                    allocate.limit(allocate.position() - 2);
                    allocate.position(0);
                    return allocate;
                }
                b = b2;
            }
            byteBuffer.position(byteBuffer.position() - allocate.position());
            return null;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static String q(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            ByteBuffer p = p(byteBuffer);
            if (p == null) {
                return null;
            }
            return gca.d(p.array(), 0, p.limit());
        }
        return (String) invokeL.objValue;
    }

    public int d(int i) throws LimitExedeedException, InvalidDataException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i >= 0) {
                return i;
            }
            throw new InvalidDataException(1002, "Negative count");
        }
        return invokeI.intValue;
    }

    public int r(yba ybaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, ybaVar)) == null) {
            String d = ybaVar.d("Sec-WebSocket-Version");
            if (d.length() > 0) {
                try {
                    return new Integer(d.trim()).intValue();
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void t(WebSocket.Role role) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, role) == null) {
            this.a = role;
        }
    }

    public yba v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, byteBuffer)) == null) {
            return w(byteBuffer, this.a);
        }
        return (yba) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [com.baidu.tieba.xba, com.baidu.tieba.bca] */
    public static vba w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        InterceptResult invokeLL;
        wba wbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer, role)) == null) {
            String q = q(byteBuffer);
            if (q != null) {
                String[] split = q.split(" ", 3);
                if (split.length == 3) {
                    if (role == WebSocket.Role.CLIENT) {
                        if (ADConfigError.REQUEST_HAS_SUCCESS_BEFORE.equals(split[1])) {
                            if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                                ?? xbaVar = new xba();
                                xbaVar.h(Short.parseShort(split[1]));
                                xbaVar.c(split[2]);
                                wbaVar = xbaVar;
                            } else {
                                throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                            }
                        } else {
                            throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                        }
                    } else if ("GET".equalsIgnoreCase(split[0])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                            wba wbaVar2 = new wba();
                            wbaVar2.b(split[1]);
                            wbaVar = wbaVar2;
                        } else {
                            throw new InvalidHandshakeException("Invalid status line received: " + split[2] + " Status line: " + q);
                        }
                    } else {
                        throw new InvalidHandshakeException("Invalid request method received: " + split[0] + " Status line: " + q);
                    }
                    String q2 = q(byteBuffer);
                    while (q2 != null && q2.length() > 0) {
                        String[] split2 = q2.split(":", 2);
                        if (split2.length == 2) {
                            if (wbaVar.e(split2[0])) {
                                String str = split2[0];
                                wbaVar.put(str, wbaVar.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                            } else {
                                wbaVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
                            }
                            q2 = q(byteBuffer);
                        } else {
                            throw new InvalidHandshakeException("not an http header");
                        }
                    }
                    if (q2 != null) {
                        return wbaVar;
                    }
                    throw new IncompleteHandshakeException();
                }
                throw new InvalidHandshakeException();
            }
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        return (vba) invokeLL.objValue;
    }

    public boolean c(yba ybaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ybaVar)) == null) {
            if (ybaVar.d("Upgrade").equalsIgnoreCase("websocket") && ybaVar.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains("upgrade")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLLZ;
        pba pbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, opcode, byteBuffer, z)) == null) {
            if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
                throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
            }
            if (this.b != null) {
                pbaVar = new mba();
            } else {
                this.b = opcode;
                if (opcode == Framedata.Opcode.BINARY) {
                    pbaVar = new kba();
                } else if (opcode == Framedata.Opcode.TEXT) {
                    pbaVar = new sba();
                } else {
                    pbaVar = null;
                }
            }
            pbaVar.j(byteBuffer);
            pbaVar.i(z);
            try {
                pbaVar.h();
                if (z) {
                    this.b = null;
                } else {
                    this.b = opcode;
                }
                return Collections.singletonList(pbaVar);
            } catch (InvalidDataException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return (List) invokeLLZ.objValue;
    }

    public List<ByteBuffer> j(yba ybaVar, WebSocket.Role role) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, ybaVar, role)) == null) {
            return k(ybaVar, role, true);
        }
        return (List) invokeLL.objValue;
    }

    public List<ByteBuffer> k(yba ybaVar, WebSocket.Role role, boolean z) {
        InterceptResult invokeLLZ;
        byte[] bArr;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, ybaVar, role, z)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (ybaVar instanceof tba) {
                sb.append("GET ");
                sb.append(((tba) ybaVar).f());
                sb.append(" HTTP/1.1");
            } else if (ybaVar instanceof aca) {
                sb.append("HTTP/1.1 101 ");
                sb.append(((aca) ybaVar).a());
            } else {
                throw new IllegalArgumentException("unknown role");
            }
            sb.append("\r\n");
            Iterator<String> g = ybaVar.g();
            while (g.hasNext()) {
                String next = g.next();
                String d = ybaVar.d(next);
                sb.append(next);
                sb.append(": ");
                sb.append(d);
                sb.append("\r\n");
            }
            sb.append("\r\n");
            byte[] a = gca.a(sb.toString());
            if (z) {
                bArr = ybaVar.getContent();
            } else {
                bArr = null;
            }
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(length + a.length);
            allocate.put(a);
            if (bArr != null) {
                allocate.put(bArr);
            }
            allocate.flip();
            return Collections.singletonList(allocate);
        }
        return (List) invokeLLZ.objValue;
    }
}
