package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public gj3() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bArr.length; i++) {
                sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
                sb.append(",");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static gj3 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (gj3.class) {
                    if (a == null) {
                        a = new gj3();
                    }
                }
            }
            return a;
        }
        return (gj3) invokeV.objValue;
    }

    public static byte[] g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public byte[] b(rj3 rj3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rj3Var, str)) == null) {
            if (rj3Var == null) {
                return null;
            }
            try {
                pj3 a2 = pj3.j.a();
                a2.r((byte) 23);
                byte[] i = rj3Var.i();
                if (i != null && i.length > 0 && i.length <= 32767) {
                    a2.q((short) i.length);
                    a2.o(i);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, rj3Var.c());
                    a2.k(aesEncrypt.length);
                    a2.j(aesEncrypt);
                }
                a2.l(uc4.e().d().longValue());
                return tj3.b(a2);
            } catch (Exception e) {
                if (cj3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public qj3 c(rj3 rj3Var, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rj3Var, bArr)) == null) {
            qj3 qj3Var = new qj3();
            try {
                pj3 a2 = tj3.a(bArr);
                byte i = a2.i();
                if (i == 21) {
                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.f());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (cj3.a) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        hj3.b(rj3Var, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            qj3Var.d(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            qj3Var.d(2);
                        } else {
                            qj3Var.d(-1);
                        }
                        if (cj3.a) {
                            if (parseFrom.getDescription() != null) {
                                if (cj3.a) {
                                    Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                                }
                            } else if (cj3.a) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert messag=null");
                            }
                        }
                    } else {
                        qj3Var.d(-1);
                    }
                } else if (i == 23) {
                    qj3Var.c(new String(AES.aesDecrypt(a2.a(), rj3Var.c())));
                    qj3Var.d(1);
                }
            } catch (Exception e) {
                if (cj3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                qj3Var.d(-1);
            }
            return qj3Var;
        }
        return (qj3) invokeLL.objValue;
    }

    public byte[] e(rj3 rj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rj3Var)) == null) {
            if (rj3Var == null) {
                return null;
            }
            try {
                byte[] b = sj3.b(rj3Var, new oj3());
                if (b == null) {
                    return null;
                }
                pj3 a2 = pj3.j.a();
                a2.r((byte) 22);
                a2.q((short) b.length);
                a2.l(uc4.e().d().longValue());
                a2.o(b);
                return tj3.b(a2);
            } catch (Exception e) {
                if (cj3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
