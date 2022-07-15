package org.java_websocket.drafts;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.repackage.bp9;
import com.repackage.dq9;
import com.repackage.hp9;
import com.repackage.jp9;
import com.repackage.mp9;
import com.repackage.pp9;
import com.repackage.qp9;
import com.repackage.rp9;
import com.repackage.sp9;
import com.repackage.tp9;
import com.repackage.up9;
import com.repackage.vp9;
import com.repackage.xp9;
import com.repackage.yp9;
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
/* loaded from: classes8.dex */
public abstract class Draft {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebSocket.Role a;
    public Framedata.Opcode b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CloseHandshakeType) Enum.valueOf(CloseHandshakeType.class, str) : (CloseHandshakeType) invokeL.objValue;
        }

        public static CloseHandshakeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CloseHandshakeType[]) $VALUES.clone() : (CloseHandshakeType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HandshakeState) Enum.valueOf(HandshakeState.class, str) : (HandshakeState) invokeL.objValue;
        }

        public static HandshakeState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HandshakeState[]) $VALUES.clone() : (HandshakeState[]) invokeV.objValue;
        }
    }

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
            return dq9.d(p.array(), 0, p.limit());
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [com.repackage.up9, com.repackage.yp9] */
    public static sp9 w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        InterceptResult invokeLL;
        tp9 tp9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer, role)) == null) {
            String q = q(byteBuffer);
            if (q != null) {
                String[] split = q.split(" ", 3);
                if (split.length == 3) {
                    if (role == WebSocket.Role.CLIENT) {
                        if ("101".equals(split[1])) {
                            if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                                ?? up9Var = new up9();
                                up9Var.h(Short.parseShort(split[1]));
                                up9Var.c(split[2]);
                                tp9Var = up9Var;
                            } else {
                                throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                            }
                        } else {
                            throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                        }
                    } else if ("GET".equalsIgnoreCase(split[0])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                            tp9 tp9Var2 = new tp9();
                            tp9Var2.b(split[1]);
                            tp9Var = tp9Var2;
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
                            if (tp9Var.e(split2[0])) {
                                String str = split2[0];
                                tp9Var.put(str, tp9Var.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                            } else {
                                tp9Var.put(split2[0], split2[1].replaceFirst("^ +", ""));
                            }
                            q2 = q(byteBuffer);
                        } else {
                            throw new InvalidHandshakeException("not an http header");
                        }
                    }
                    if (q2 != null) {
                        return tp9Var;
                    }
                    throw new IncompleteHandshakeException();
                }
                throw new InvalidHandshakeException();
            }
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        return (sp9) invokeLL.objValue;
    }

    public abstract HandshakeState a(qp9 qp9Var, xp9 xp9Var) throws InvalidHandshakeException;

    public abstract HandshakeState b(qp9 qp9Var) throws InvalidHandshakeException;

    public boolean c(vp9 vp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vp9Var)) == null) ? vp9Var.d("Upgrade").equalsIgnoreCase("websocket") && vp9Var.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains("upgrade") : invokeL.booleanValue;
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

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLLZ;
        mp9 pp9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, opcode, byteBuffer, z)) == null) {
            if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
                throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
            }
            if (this.b != null) {
                pp9Var = new jp9();
            } else {
                this.b = opcode;
                if (opcode == Framedata.Opcode.BINARY) {
                    pp9Var = new hp9();
                } else {
                    pp9Var = opcode == Framedata.Opcode.TEXT ? new pp9() : null;
                }
            }
            pp9Var.j(byteBuffer);
            pp9Var.i(z);
            try {
                pp9Var.h();
                if (z) {
                    this.b = null;
                } else {
                    this.b = opcode;
                }
                return Collections.singletonList(pp9Var);
            } catch (InvalidDataException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return (List) invokeLLZ.objValue;
    }

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public List<ByteBuffer> j(vp9 vp9Var, WebSocket.Role role) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, vp9Var, role)) == null) ? k(vp9Var, role, true) : (List) invokeLL.objValue;
    }

    public List<ByteBuffer> k(vp9 vp9Var, WebSocket.Role role, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, vp9Var, role, z)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (vp9Var instanceof qp9) {
                sb.append("GET ");
                sb.append(((qp9) vp9Var).f());
                sb.append(" HTTP/1.1");
            } else if (vp9Var instanceof xp9) {
                sb.append("HTTP/1.1 101 ");
                sb.append(((xp9) vp9Var).a());
            } else {
                throw new IllegalArgumentException("unknown role");
            }
            sb.append("\r\n");
            Iterator<String> g = vp9Var.g();
            while (g.hasNext()) {
                String next = g.next();
                String d = vp9Var.d(next);
                sb.append(next);
                sb.append(": ");
                sb.append(d);
                sb.append("\r\n");
            }
            sb.append("\r\n");
            byte[] a = dq9.a(sb.toString());
            byte[] content = z ? vp9Var.getContent() : null;
            ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + a.length);
            allocate.put(a);
            if (content != null) {
                allocate.put(content);
            }
            allocate.flip();
            return Collections.singletonList(allocate);
        }
        return (List) invokeLLZ.objValue;
    }

    public abstract CloseHandshakeType l();

    public abstract rp9 m(rp9 rp9Var) throws InvalidHandshakeException;

    public abstract sp9 n(qp9 qp9Var, yp9 yp9Var) throws InvalidHandshakeException;

    public abstract void o(bp9 bp9Var, Framedata framedata) throws InvalidDataException;

    public int r(vp9 vp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, vp9Var)) == null) {
            String d = vp9Var.d("Sec-WebSocket-Version");
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

    public abstract void s();

    public void t(WebSocket.Role role) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, role) == null) {
            this.a = role;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? getClass().getSimpleName() : (String) invokeV.objValue;
    }

    public abstract List<Framedata> u(ByteBuffer byteBuffer) throws InvalidDataException;

    public vp9 v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, byteBuffer)) == null) ? w(byteBuffer, this.a) : (vp9) invokeL.objValue;
    }
}
