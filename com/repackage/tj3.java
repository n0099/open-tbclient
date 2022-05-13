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
/* loaded from: classes7.dex */
public class tj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public tj3() {
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

    public static tj3 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (tj3.class) {
                    if (a == null) {
                        a = new tj3();
                    }
                }
            }
            return a;
        }
        return (tj3) invokeV.objValue;
    }

    public static byte[] g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public byte[] b(ek3 ek3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ek3Var, str)) == null) {
            if (ek3Var == null) {
                return null;
            }
            try {
                ck3 a2 = ck3.j.a();
                a2.r((byte) 23);
                byte[] i = ek3Var.i();
                if (i != null && i.length > 0 && i.length <= 32767) {
                    a2.q((short) i.length);
                    a2.o(i);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, ek3Var.c());
                    a2.k(aesEncrypt.length);
                    a2.j(aesEncrypt);
                }
                a2.l(hd4.e().d().longValue());
                return gk3.b(a2);
            } catch (Exception e) {
                if (pj3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public dk3 c(ek3 ek3Var, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ek3Var, bArr)) == null) {
            dk3 dk3Var = new dk3();
            try {
                ck3 a2 = gk3.a(bArr);
                byte i = a2.i();
                if (i == 21) {
                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.f());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (pj3.a) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        uj3.b(ek3Var, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            dk3Var.d(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            dk3Var.d(2);
                        } else {
                            dk3Var.d(-1);
                        }
                        if (pj3.a) {
                            if (parseFrom.getDescription() != null) {
                                if (pj3.a) {
                                    Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                                }
                            } else if (pj3.a) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert messag=null");
                            }
                        }
                    } else {
                        dk3Var.d(-1);
                    }
                } else if (i == 23) {
                    dk3Var.c(new String(AES.aesDecrypt(a2.a(), ek3Var.c())));
                    dk3Var.d(1);
                }
            } catch (Exception e) {
                if (pj3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                dk3Var.d(-1);
            }
            return dk3Var;
        }
        return (dk3) invokeLL.objValue;
    }

    public byte[] e(ek3 ek3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ek3Var)) == null) {
            if (ek3Var == null) {
                return null;
            }
            try {
                byte[] b = fk3.b(ek3Var, new bk3());
                if (b == null) {
                    return null;
                }
                ck3 a2 = ck3.j.a();
                a2.r((byte) 22);
                a2.q((short) b.length);
                a2.l(hd4.e().d().longValue());
                a2.o(b);
                return gk3.b(a2);
            } catch (Exception e) {
                if (pj3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
