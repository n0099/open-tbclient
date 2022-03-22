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
/* loaded from: classes7.dex */
public final class v implements d {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f43966b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43967c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public File f43968d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178790, "Lcom/vivo/push/util/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178790, "Lcom/vivo/push/util/v;");
                return;
            }
        }
        a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".vivo/pushsdk/config";
        f43966b = a + File.separator + "config.txt";
        f43967c = "SdcardCache";
    }

    public v() {
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

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(a);
                boolean mkdirs = !file.exists() ? file.mkdirs() : true;
                if (mkdirs) {
                    File file2 = new File(f43966b);
                    this.f43968d = file2;
                    if (!file2.exists()) {
                        try {
                            this.f43968d.createNewFile();
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

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            Properties a2 = a();
            String str3 = f43966b;
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

    @Override // com.vivo.push.util.d
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
            bufferedInputStream = new BufferedInputStream(new FileInputStream(f43966b));
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
