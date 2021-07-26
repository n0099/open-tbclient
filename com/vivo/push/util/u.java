package com.vivo.push.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes6.dex */
public final class u implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39490a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f39491b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39492c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public File f39493d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178759, "Lcom/vivo/push/util/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178759, "Lcom/vivo/push/util/u;");
                return;
            }
        }
        f39490a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".vivo/pushsdk/config";
        f39491b = f39490a + File.separator + "config.txt";
        f39492c = "SdcardCache";
    }

    public u() {
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

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(f39490a);
                boolean mkdirs = !file.exists() ? file.mkdirs() : true;
                if (mkdirs) {
                    File file2 = new File(f39491b);
                    this.f39493d = file2;
                    if (!file2.exists()) {
                        try {
                            this.f39493d.createNewFile();
                            return true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                }
                return mkdirs;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            Properties a2 = a();
            String str3 = f39491b;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    a2.setProperty(str, str2);
                    fileOutputStream = new FileOutputStream(str3);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                a2.store(fileOutputStream, (String) null);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? a().getProperty(str, str2) : (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Properties a() {
        InterceptResult invokeV;
        BufferedInputStream bufferedInputStream;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (Properties) invokeV.objValue;
        }
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(f39491b));
            try {
                try {
                    properties.load(bufferedInputStream);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            bufferedInputStream = null;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
        try {
            bufferedInputStream.close();
        } catch (IOException unused2) {
            return properties;
        }
    }
}
