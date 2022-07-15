package com.kwad.components.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String c = c(context);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            c(c);
            File file = new File(c, "packageIndex.json");
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            String c = c(context);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            return c + File.separator + str;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return Uri.parse(str).getQueryParameter("sceneId");
            } catch (Throwable unused) {
                com.kwad.sdk.core.d.b.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, str, str2) != null) {
            return;
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                com.kwad.sdk.crash.utils.b.a(zipInputStream);
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
                com.kwad.sdk.crash.utils.b.a(fileOutputStream);
            } else if (!name.contains("../")) {
                String substring = name.substring(0, name.length() - 1);
                new File(str2 + File.separator + substring).mkdirs();
            }
        }
    }

    public static File b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                return new File("/data/data/" + context.getPackageName() + "/file/");
            }
            return filesDir;
        }
        return (File) invokeL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            String c = c(context);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            return c + File.separator + str + ".zip";
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                List<String> pathSegments = Uri.parse(str).getPathSegments();
                String str2 = null;
                if (pathSegments != null && pathSegments.size() > 0) {
                    str2 = pathSegments.get(pathSegments.size() - 1);
                }
                return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
            } catch (Throwable unused) {
                com.kwad.sdk.core.d.b.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String str = b(context) + File.separator + "offlinepackage";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            String c = c(context);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            return c + File.separator + str;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            String c = c(context);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            return c + File.separator + str + File.separator + "_manifest_.json";
        }
        return (String) invokeLL.objValue;
    }
}
