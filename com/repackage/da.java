package com.repackage;

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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class da {
    public static /* synthetic */ Interceptable $ic;
    public static da a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964042456, "Lcom/repackage/da;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964042456, "Lcom/repackage/da;");
        }
    }

    public da() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static da f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (da.class) {
                    if (a == null) {
                        a = new da();
                    }
                }
            }
            return a;
        }
        return (da) invokeV.objValue;
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ji.a(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                lg.d(byteArrayOutputStream);
                lg.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public SocketResponsedMessage b(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        InterceptResult invokeCommon;
        SocketResponsedMessage newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), bArr, socketMessage, socketMessageTask, Boolean.valueOf(z)})) == null) {
            try {
                Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
                try {
                    newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception unused) {
                    newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
                }
                newInstance.setOrginalMessage(socketMessage);
                if (z) {
                    try {
                        newInstance.onDecodeFailedInBackGround(i, bArr, aa.c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    newInstance.decodeInBackGround(i, bArr);
                }
                return newInstance;
            } catch (Throwable th) {
                BdStatisticsManager.getInstance().error("im", socketMessage != null ? socketMessage.getClientLogID() : 0L, (String) null, "cmd", Integer.valueOf(i), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th.getMessage());
                throw new CoderException(aa.c);
            }
        }
        return (SocketResponsedMessage) invokeCommon.objValue;
    }

    public ea c(byte[] bArr) throws CoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            int f = ca.f();
            if (bArr != null && bArr.length >= f) {
                ca a2 = ca.a(bArr);
                if (a2 != null) {
                    ea eaVar = new ea();
                    eaVar.a = a2;
                    eaVar.b = bArr;
                    eaVar.c = f;
                    eaVar.d = bArr.length - f;
                    return eaVar;
                }
                throw new CoderException(aa.b);
            }
            throw new CoderException(aa.b);
        }
        return (ea) invokeL.objValue;
    }

    public ea d(ea eaVar) throws CoderException {
        InterceptResult invokeL;
        ca caVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eaVar)) == null) {
            if (eaVar != null && (caVar = eaVar.a) != null && eaVar.b != null) {
                if (caVar.d() && eaVar.d > 0) {
                    if (fa.a().b() != null) {
                        try {
                            byte[] a2 = wi.a(fa.a().b(), eaVar.b, eaVar.c, eaVar.d);
                            eaVar.b = a2;
                            eaVar.c = 0;
                            eaVar.d = a2.length;
                        } catch (Exception unused) {
                            throw new CoderException(aa.h);
                        }
                    } else {
                        throw new CoderException(aa.g);
                    }
                }
                if (caVar.c() && (i = eaVar.d) > 0) {
                    try {
                        byte[] g = g(eaVar.b, eaVar.c, i);
                        eaVar.b = g;
                        eaVar.c = 0;
                        eaVar.d = g.length;
                    } catch (Exception unused2) {
                        throw new CoderException(aa.f);
                    }
                }
                return eaVar;
            }
            throw new CoderException(aa.b);
        }
        return (ea) invokeL.objValue;
    }

    public byte[] e(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{socketMessage, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (socketMessage == null) {
                return null;
            }
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
            if (encodeExtraDataInBackGround != null) {
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + ca.g);
                if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                    allocate.putInt(encodeExtraDataInBackGround.length);
                    allocate.put(encodeExtraDataInBackGround);
                    allocate.put(encodeInBackGround);
                    encodeInBackGround = allocate.array();
                    z3 = true;
                } else {
                    throw new CoderException(aa.e);
                }
            } else {
                z3 = false;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = wi.c(fa.a().b(), encodeInBackGround);
            }
            return ca.i(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public byte[] g(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ji.c(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                lg.d(byteArrayOutputStream);
                lg.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }
}
