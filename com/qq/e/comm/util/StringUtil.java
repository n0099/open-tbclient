package com.qq.e.comm.util;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
public class StringUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StringUtil() {
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
                for (int i = 0; i < strArr.length; i++) {
                    if (str != null && i != 0) {
                        stringBuffer.append(str);
                    }
                    stringBuffer.append(strArr[i]);
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

    public static int parseInteger(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readAll(File file) throws IOException {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            BufferedReader bufferedReader2 = null;
            if (file == null || !file.exists()) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
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
                } catch (Throwable th) {
                    bufferedReader2 = bufferedReader;
                    th = th;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused2) {
                            GDTLogger.d("Exception while close bufferreader");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                bufferedReader = null;
                throw e3;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void writeTo(String str, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, file) == null) {
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
