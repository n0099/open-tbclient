package com.huawei.hms.hatool;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.pga;
import com.baidu.tieba.tga;
import com.baidu.tieba.uga;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public c0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b.i().getFilesDir().getPath();
    }

    public static boolean b(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return false;
            }
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        y.c("hmsSdk", "delete file failed : " + file2.getName());
                    }
                } else if (file2.isDirectory()) {
                    b(file2);
                }
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b(new File(b.i().getFilesDir().getPath() + "/hms"));
        }
        return invokeV.booleanValue;
    }

    public String a() {
        InterceptResult invokeV;
        String b;
        String b2;
        String b3;
        String b4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String c = c();
            if (b()) {
                y.c("hmsSdk", "refresh components");
                b = tga.d(128);
                a("aprpap", b);
                b2 = tga.d(128);
                a("febdoc", b2);
                b3 = tga.d(128);
                a("marfil", b3);
                b4 = tga.d(128);
                a("maywnj", b4);
                g0.b(b.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
            } else {
                b = b("aprpap");
                b2 = b("febdoc");
                b3 = b("marfil");
                b4 = b("maywnj");
            }
            return uga.a(pga.b(a(b, b2, b3, c), uga.b(b4), 10000, 16));
        }
        return (String) invokeV.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.a + "/hms/component/".replace(NativeConstants.COMPONENT, str);
        }
        return (String) invokeL.objValue;
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            File file = new File(a(str));
            String a = a(str);
            File file2 = new File(a, "hianalytics_" + str);
            if (!file.exists() && file.mkdirs()) {
                y.c("hmsSdk", "file directory is mkdirs");
            }
            if (a(file2)) {
                t0.a(file2, str2);
            } else {
                y.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
            }
        }
    }

    public final boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, file)) == null) {
            if (file.exists()) {
                return true;
            }
            try {
                return file.createNewFile();
            } catch (IOException unused) {
                y.f("hmsSdk", "create new file error!");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final char[] a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, str4)) == null) {
            byte[] b = uga.b(str);
            byte[] b2 = uga.b(str2);
            byte[] b3 = uga.b(str3);
            byte[] b4 = uga.b(str4);
            int length = b.length;
            if (length > b2.length) {
                length = b2.length;
            }
            if (length > b3.length) {
                length = b3.length;
            }
            if (length > b4.length) {
                length = b4.length;
            }
            char[] cArr = new char[length];
            for (int i = 0; i < length; i++) {
                cArr[i] = (char) (((b[i] ^ b2[i]) ^ b3[i]) ^ b4[i]);
            }
            return cArr;
        }
        return (char[]) invokeLLLL.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String a = a(str);
            File file = new File(a, "hianalytics_" + str);
            if (a(file)) {
                return t0.a(file);
            }
            String d = tga.d(128);
            t0.a(file, d);
            return d;
        }
        return (String) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long a = g0.a(b.i(), "Privacy_MY", "assemblyFlash", -1L);
            if (-1 != a) {
                return System.currentTimeMillis() - a > 31536000000L;
            }
            y.c("hmsSdk", "First init components");
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc" : (String) invokeV.objValue;
    }
}
