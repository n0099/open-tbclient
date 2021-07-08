package com.yy.hiidostatis.inner.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public class FileUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final boolean isExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new File(str).exists() : invokeL.booleanValue;
    }

    public static final String readFile(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String trim = new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                    try {
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        L.debug("FileUtil", e2.getMessage(), new Object[0]);
                    }
                    return trim;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                L.debug("FileUtil", e3.getMessage(), new Object[0]);
                                return null;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                L.debug("FileUtil", e4.getMessage(), new Object[0]);
                                throw th3;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th3;
                    }
                }
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static final void saveFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdir();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str2.getBytes("UTF-8"));
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    L.debug("FileUtil", th2.getMessage(), new Object[0]);
                }
            } catch (Throwable th3) {
                fileOutputStream2 = fileOutputStream;
                th = th3;
                try {
                    th.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th4) {
                            L.debug("FileUtil", th4.getMessage(), new Object[0]);
                        }
                    }
                } catch (Throwable th5) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th6) {
                            L.debug("FileUtil", th6.getMessage(), new Object[0]);
                        }
                    }
                    throw th5;
                }
            }
        }
    }

    public static boolean writeFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) != null) {
            return invokeLL.booleanValue;
        }
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(str);
            try {
                printWriter2.print(str2);
                printWriter2.flush();
                printWriter2.close();
                return true;
            } catch (Throwable th) {
                th = th;
                printWriter = printWriter2;
                try {
                    th.printStackTrace();
                    return false;
                } finally {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
