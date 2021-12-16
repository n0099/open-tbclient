package com.kwad.sdk.c.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                return new File("/data/data/" + context.getPackageName() + "/file/");
            }
            return filesDir;
        }
        return (File) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            return b2 + File.separator + str;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65538, null, str, str2) != null) {
            return;
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                q.b(zipInputStream);
                return;
            }
            String name = nextEntry.getName();
            if (!nextEntry.isDirectory()) {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                q.b(fileOutputStream);
            } else if (!name.contains(Constants.PATH_PARENT)) {
                String substring = name.substring(0, name.length() - 1);
                new File(str2 + File.separator + substring).mkdirs();
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str = a(context) + File.separator + "offlinepackage";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            return b2 + File.separator + str + ".zip";
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            a(b2);
            return b2 + File.separator + "packageIndex.json";
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            return b2 + File.separator + str;
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            return b2 + File.separator + str + File.separator + "_manifest_.json";
        }
        return (String) invokeLL.objValue;
    }
}
