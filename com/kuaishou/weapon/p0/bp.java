package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class bp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bp() {
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

    public static int a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    if (new File(strArr[i2]).exists()) {
                        i |= 1 << i2;
                    }
                } catch (Exception unused) {
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        r0.add(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<File> a(File file, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, file, str, i)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                File[] listFiles = file.listFiles(new FileFilter(str) { // from class: com.kuaishou.weapon.p0.bp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = str;
                    }

                    @Override // java.io.FileFilter
                    public final boolean accept(File file2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                            if (file2.isDirectory() || file2.getName().toLowerCase().contains(this.a)) {
                                return true;
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                });
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        File file2 = listFiles[i2];
                        if (file2.isFile()) {
                            break;
                        }
                        int i3 = i + 1;
                        arrayList.addAll(a(file2, str, i));
                        i2++;
                        i = i3;
                    }
                }
            } catch (Throwable unused) {
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, closeable) != null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                String str2 = Engine.soPath;
                if (!TextUtils.isEmpty(str2)) {
                    if (new File(str2 + "/lib" + str).exists()) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
            if (a(context.getFilesDir(), str, 0).size() <= 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
