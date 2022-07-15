package com.kuaishou.weapon.p0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
/* renamed from: com.kuaishou.weapon.p0.י  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0428 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static volatile C0428 f607;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1651731610, "Lcom/kuaishou/weapon/p0/י;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1651731610, "Lcom/kuaishou/weapon/p0/י;");
        }
    }

    public C0428() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static synchronized C0428 m824() {
        InterceptResult invokeV;
        C0428 c0428;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (C0428.class) {
                if (f607 == null) {
                    synchronized (C0428.class) {
                        if (f607 == null) {
                            f607 = new C0428();
                        }
                    }
                }
                c0428 = f607;
            }
            return c0428;
        }
        return (C0428) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m825(BufferedInputStream bufferedInputStream) {
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
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String m826(String str) {
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
                String m825 = m825(bufferedInputStream);
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
                return m825;
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m827(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                Object invoke = Class.forName("android.os.SystemProperties").getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(null, str);
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
