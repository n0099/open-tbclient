package com.qq.e.comm.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes10.dex */
public class StringUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StringUtil() {
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

    public static boolean isEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str == null || str.trim().length() == 0 : invokeL.booleanValue;
    }

    public static String join(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, strArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (strArr != null) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (str != null && i2 != 0) {
                        stringBuffer.append(str);
                    }
                    stringBuffer.append(strArr[i2]);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static float parseFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, str, f2)) == null) {
            try {
                return Float.parseFloat(str);
            } catch (Throwable unused) {
                return f2;
            }
        }
        return invokeLF.floatValue;
    }

    public static int parseInteger(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public static String readAll(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            if (file != 0) {
                try {
                    if (file.exists()) {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader((File) file));
                            try {
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                }
                                String sb2 = sb.toString();
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                    GDTLogger.d("Exception while close bufferreader");
                                }
                                return sb2;
                            } catch (IOException e2) {
                                throw e2;
                            }
                        } catch (IOException e3) {
                            throw e3;
                        } catch (Throwable th) {
                            th = th;
                            file = 0;
                            if (file != 0) {
                                try {
                                    file.close();
                                } catch (Exception unused2) {
                                    GDTLogger.d("Exception while close bufferreader");
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void writeTo(String str, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, file) == null) {
            if (file == null) {
                throw new IOException("Target File Can not be null in StringUtil.writeTo");
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        }
    }
}
