package com.kuaishou.weapon.p0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
/* loaded from: classes10.dex */
public class aa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aa a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(334583479, "Lcom/kuaishou/weapon/p0/aa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(334583479, "Lcom/kuaishou/weapon/p0/aa;");
        }
    }

    public aa() {
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

    public static synchronized aa a() {
        InterceptResult invokeV;
        aa aaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (aa.class) {
                if (a == null) {
                    synchronized (aa.class) {
                        if (a == null) {
                            a = new aa();
                        }
                    }
                }
                aaVar = a;
            }
            return aaVar;
        }
        return (aa) invokeV.objValue;
    }

    public static String a(BufferedInputStream bufferedInputStream) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bufferedInputStream)) == null) {
            if (bufferedInputStream == null) {
                return "";
            }
            byte[] bArr = new byte[512];
            StringBuilder sb = new StringBuilder();
            do {
                try {
                    read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        sb.append(new String(bArr, 0, read));
                        continue;
                    }
                } catch (Exception unused) {
                }
            } while (read >= 512);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                Object invoke = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(null, str);
                if (invoke == null) {
                    return null;
                }
                return (String) invoke;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0048 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: java.io.BufferedInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str) {
        InterceptResult invokeL;
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                process = Runtime.getRuntime().exec("sh");
            } catch (Exception unused) {
                process = null;
                bufferedOutputStream = null;
            } catch (Throwable th) {
                th = th;
                process = null;
                bufferedInputStream = null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                try {
                    bufferedInputStream3 = new BufferedInputStream(process.getInputStream());
                } catch (Exception unused2) {
                    bufferedInputStream2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream3 = null;
                }
                try {
                    bufferedOutputStream.write(str.getBytes());
                    bufferedOutputStream.write(10);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    process.waitFor();
                    String a2 = a(bufferedInputStream3);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    try {
                        bufferedInputStream3.close();
                    } catch (IOException unused4) {
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return a2;
                } catch (Exception unused5) {
                    bufferedInputStream2 = bufferedInputStream3;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (bufferedInputStream2 != 0) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    bufferedInputStream = bufferedInputStream3;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException unused8) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception unused10) {
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedOutputStream;
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream2 != 0) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
