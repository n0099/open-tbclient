package d.a.d.c.e.c.j;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.c.e.c.h;
import d.a.d.e.p.g;
import d.a.d.e.p.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f41451a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1408486896, "Ld/a/d/c/e/c/j/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1408486896, "Ld/a/d/c/e/c/j/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f41451a == null) {
                synchronized (b.class) {
                    if (f41451a == null) {
                        f41451a = new b();
                    }
                }
            }
            return f41451a;
        }
        return (b) invokeV.objValue;
    }

    public byte[] a(byte[] bArr, int i2, int i3) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                g.a(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                d.a.d.e.m.a.d(byteArrayOutputStream);
                d.a.d.e.m.a.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public SocketResponsedMessage b(int i2, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        InterceptResult invokeCommon;
        SocketResponsedMessage newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bArr, socketMessage, socketMessageTask, Boolean.valueOf(z)})) == null) {
            try {
                Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
                try {
                    newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception unused) {
                    newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i2));
                }
                newInstance.setOrginalMessage(socketMessage);
                if (z) {
                    try {
                        newInstance.onDecodeFailedInBackGround(i2, bArr, h.f41435c);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    newInstance.decodeInBackGround(i2, bArr);
                }
                return newInstance;
            } catch (Throwable th) {
                BdStatisticsManager.getInstance().error("im", socketMessage != null ? socketMessage.getClientLogID() : 0L, (String) null, "cmd", Integer.valueOf(i2), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th.getMessage());
                throw new CoderException(h.f41435c);
            }
        }
        return (SocketResponsedMessage) invokeCommon.objValue;
    }

    public c c(byte[] bArr) throws CoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            int f2 = a.f();
            if (bArr != null && bArr.length >= f2) {
                a a2 = a.a(bArr);
                if (a2 != null) {
                    c cVar = new c();
                    cVar.f41452a = a2;
                    cVar.f41453b = bArr;
                    cVar.f41454c = f2;
                    cVar.f41455d = bArr.length - f2;
                    return cVar;
                }
                throw new CoderException(h.f41434b);
            }
            throw new CoderException(h.f41434b);
        }
        return (c) invokeL.objValue;
    }

    public c d(c cVar) throws CoderException {
        InterceptResult invokeL;
        a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            if (cVar != null && (aVar = cVar.f41452a) != null && cVar.f41453b != null) {
                if (aVar.d() && cVar.f41455d > 0) {
                    if (d.a().b() != null) {
                        try {
                            byte[] a2 = s.a(d.a().b(), cVar.f41453b, cVar.f41454c, cVar.f41455d);
                            cVar.f41453b = a2;
                            cVar.f41454c = 0;
                            cVar.f41455d = a2.length;
                        } catch (Exception unused) {
                            throw new CoderException(h.f41440h);
                        }
                    } else {
                        throw new CoderException(h.f41439g);
                    }
                }
                if (aVar.c() && (i2 = cVar.f41455d) > 0) {
                    try {
                        byte[] g2 = g(cVar.f41453b, cVar.f41454c, i2);
                        cVar.f41453b = g2;
                        cVar.f41454c = 0;
                        cVar.f41455d = g2.length;
                    } catch (Exception unused2) {
                        throw new CoderException(h.f41438f);
                    }
                }
                return cVar;
            }
            throw new CoderException(h.f41434b);
        }
        return (c) invokeL.objValue;
    }

    public byte[] e(SocketMessage socketMessage, int i2, boolean z, boolean z2) throws CoderException {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{socketMessage, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (socketMessage == null) {
                return null;
            }
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
            if (encodeExtraDataInBackGround != null) {
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.f41442g);
                if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                    allocate.putInt(encodeExtraDataInBackGround.length);
                    allocate.put(encodeExtraDataInBackGround);
                    allocate.put(encodeInBackGround);
                    encodeInBackGround = allocate.array();
                    z3 = true;
                } else {
                    throw new CoderException(h.f41437e);
                }
            } else {
                z3 = false;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = s.c(d.a().b(), encodeInBackGround);
            }
            return a.i(z2, z, socketMessage.getCmd(), i2, encodeInBackGround, z3);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public byte[] g(byte[] bArr, int i2, int i3) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                g.c(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                d.a.d.e.m.a.d(byteArrayOutputStream);
                d.a.d.e.m.a.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }
}
