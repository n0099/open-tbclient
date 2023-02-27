package com.kuaishou.weapon.p0;

import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(334582921, "Lcom/kuaishou/weapon/p0/b0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(334582921, "Lcom/kuaishou/weapon/p0/b0;");
        }
    }

    public b0() {
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

    public static synchronized b0 a() {
        InterceptResult invokeV;
        b0 b0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b0.class) {
                if (a == null) {
                    synchronized (b0.class) {
                        if (a == null) {
                            a = new b0();
                        }
                    }
                }
                b0Var = a;
            }
            return b0Var;
        }
        return (b0) invokeV.objValue;
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        InterceptResult invokeL;
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                process = Runtime.getRuntime().exec("sh");
                try {
                    bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                    try {
                        bufferedInputStream = new BufferedInputStream(process.getInputStream());
                    } catch (Exception unused) {
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = null;
                    }
                } catch (Exception unused2) {
                    bufferedOutputStream = null;
                    bufferedInputStream = null;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception unused7) {
                process = null;
            } catch (Throwable th3) {
                th = th3;
                process = null;
            }
            try {
                bufferedOutputStream.write(str.getBytes());
                bufferedOutputStream.write(10);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                process.waitFor();
                String a2 = a(bufferedInputStream);
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused8) {
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException unused9) {
                }
                if (process != null) {
                    process.destroy();
                }
                return a2;
            } catch (Exception unused10) {
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                Object invoke = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod("get", String.class).invoke(null, str);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
