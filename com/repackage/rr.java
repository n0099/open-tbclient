package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdptask.bdtls.AES;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rr {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rr a;
    public transient /* synthetic */ FieldHolder $fh;

    public rr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr != null) {
                int i = 0;
                for (byte b : bArr) {
                    i = (i << 8) | (b & 255);
                }
                return i;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static rr c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (rr.class) {
                    if (a == null) {
                        a = new rr();
                    }
                }
            }
            return a;
        }
        return (rr) invokeV.objValue;
    }

    public static byte[] d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public ir b(jr jrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jrVar, bArr)) == null) {
            ir irVar = new ir();
            try {
                hr a2 = mr.a(bArr);
                byte i = a2.i();
                if (i == 21) {
                    xq a3 = xq.a(a2.o());
                    if (a3 != null) {
                        String b = a3.b();
                        DebugTrace debugTrace = DebugTrace.a;
                        debugTrace.a("bdtls ubc application alert : " + b);
                        if (1 == a3.d()) {
                            irVar.b(-2);
                        } else if (TextUtils.equals(b, "down grade")) {
                            irVar.b(2);
                        } else {
                            irVar.b(-1);
                        }
                        if (wq.c.h().d()) {
                            if (a3.b() != null) {
                                DebugTrace debugTrace2 = DebugTrace.a;
                                debugTrace2.a("BdtlsPostRequest response alert message=" + b);
                            } else {
                                DebugTrace.a.a("BdtlsPostRequest response alert messag=null");
                            }
                        }
                    } else {
                        irVar.b(-1);
                    }
                } else if (i == 23) {
                    irVar.c(new String(AES.aesDecrypt(a2.p(), jrVar.q())));
                    irVar.b(1);
                }
            } catch (Exception e) {
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                irVar.b(-1);
            }
            return irVar;
        }
        return (ir) invokeLL.objValue;
    }

    public byte[] e(jr jrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jrVar)) == null) {
            if (jrVar == null) {
                return null;
            }
            try {
                byte[] b = lr.b(jrVar, new fr());
                if (b == null) {
                    return null;
                }
                hr a2 = hr.i.a();
                a2.a((byte) 22);
                a2.c((short) b.length);
                a2.j(b);
                return mr.b(a2);
            } catch (Exception e) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("exception=" + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] f(jr jrVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jrVar, str)) == null) {
            if (jrVar == null) {
                return null;
            }
            try {
                hr a2 = hr.i.a();
                a2.a((byte) 23);
                byte[] r = jrVar.r();
                if (r != null && r.length > 0 && r.length <= 32767) {
                    a2.c((short) r.length);
                    a2.j(r);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, jrVar.q());
                    a2.b(aesEncrypt.length);
                    a2.l(aesEncrypt);
                }
                return mr.b(a2);
            } catch (Exception e) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("exception=" + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
