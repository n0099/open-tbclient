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
public class ij3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ij3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ij3() {
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

    public static ij3 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (ij3.class) {
                    if (a == null) {
                        a = new ij3();
                    }
                }
            }
            return a;
        }
        return (ij3) invokeV.objValue;
    }

    public static byte[] g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public byte[] b(tj3 tj3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tj3Var, str)) == null) {
            if (tj3Var == null) {
                return null;
            }
            try {
                rj3 a2 = rj3.j.a();
                a2.r((byte) 23);
                byte[] i = tj3Var.i();
                if (i != null && i.length > 0 && i.length <= 32767) {
                    a2.q((short) i.length);
                    a2.o(i);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, tj3Var.c());
                    a2.k(aesEncrypt.length);
                    a2.j(aesEncrypt);
                }
                a2.l(wc4.e().d().longValue());
                return vj3.b(a2);
            } catch (Exception e) {
                if (ej3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public sj3 c(tj3 tj3Var, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tj3Var, bArr)) == null) {
            sj3 sj3Var = new sj3();
            try {
                rj3 a2 = vj3.a(bArr);
                byte i = a2.i();
                if (i == 21) {
                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.f());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (ej3.a) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        jj3.b(tj3Var, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            sj3Var.d(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            sj3Var.d(2);
                        } else {
                            sj3Var.d(-1);
                        }
                        if (ej3.a) {
                            if (parseFrom.getDescription() != null) {
                                if (ej3.a) {
                                    Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                                }
                            } else if (ej3.a) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert messag=null");
                            }
                        }
                    } else {
                        sj3Var.d(-1);
                    }
                } else if (i == 23) {
                    sj3Var.c(new String(AES.aesDecrypt(a2.a(), tj3Var.c())));
                    sj3Var.d(1);
                }
            } catch (Exception e) {
                if (ej3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                sj3Var.d(-1);
            }
            return sj3Var;
        }
        return (sj3) invokeLL.objValue;
    }

    public byte[] e(tj3 tj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tj3Var)) == null) {
            if (tj3Var == null) {
                return null;
            }
            try {
                byte[] b = uj3.b(tj3Var, new qj3());
                if (b == null) {
                    return null;
                }
                rj3 a2 = rj3.j.a();
                a2.r((byte) 22);
                a2.q((short) b.length);
                a2.l(wc4.e().d().longValue());
                a2.o(b);
                return vj3.b(a2);
            } catch (Exception e) {
                if (ej3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
