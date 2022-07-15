package com.kwai.filedownloader.e;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.utils.ak;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 65536;
    public static long b = 2000;
    public static String c;
    public static Boolean d;
    public static Boolean e;
    public static final Pattern f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185680580, "Lcom/kwai/filedownloader/e/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1185680580, "Lcom/kwai/filedownloader/e/f;");
                return;
            }
        }
        f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    }

    public f() {
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

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? com.kwai.filedownloader.download.b.a().b().b(str, str2, false) : invokeLL.intValue;
    }

    public static int a(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, str, str2, z)) == null) ? com.kwai.filedownloader.download.b.a().b().b(str, str2, z) : invokeLLZ.intValue;
    }

    public static String a(int i, com.kwai.filedownloader.kwai.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bVar)) == null) {
            if (bVar != null) {
                String a2 = bVar.a(Util.ETAG);
                if (d.a) {
                    d.c(f.class, "etag find %s for task(%d)", a2, Integer.valueOf(i));
                }
                return a2;
            }
            throw new RuntimeException("connection is null when findEtag");
        }
        return (String) invokeIL.objValue;
    }

    public static String a(com.kwai.filedownloader.kwai.b bVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bVar, str)) == null) {
            String d2 = d(bVar.a("Content-Disposition"));
            if (TextUtils.isEmpty(d2)) {
                d2 = j(str);
            }
            return d2.replaceAll("\\/", "_");
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? c(e(), j(str)) : (String) invokeL.objValue;
    }

    public static String a(String str, boolean z, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, Boolean.valueOf(z), str2})) == null) {
            if (str == null) {
                return null;
            }
            if (z) {
                if (str2 == null) {
                    return null;
                }
                return c(str, str2);
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, objArr)) == null) ? String.format(Locale.ENGLISH, str, objArr) : (String) invokeLL.objValue;
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i) == null) {
            if (!a(c.a())) {
                throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
            }
            a = i;
        }
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j) == null) {
            if (!a(c.a())) {
                throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
            }
            b = j;
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.a().getSystemService("connectivity");
            if (connectivityManager == null) {
                d.d(f.class, "failed to get connectivity manager!", new Object[0]);
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65548, null, i, cVar)) == null) ? a(i, cVar, (Boolean) null) : invokeIL.booleanValue;
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar, Boolean bool) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65549, null, i, cVar, bool)) == null) {
            if (cVar == null) {
                if (d.a) {
                    d.c(f.class, "can't continue %d model == null", Integer.valueOf(i));
                }
                return false;
            } else if (cVar.e() == null) {
                if (d.a) {
                    d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i));
                }
                return false;
            } else {
                return a(i, cVar, cVar.e(), null);
            }
        }
        return invokeILL.booleanValue;
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar, String str, Boolean bool) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), cVar, str, bool})) == null) {
            if (str == null) {
                if (d.a) {
                    d.c(f.class, "can't continue %d path = null", Integer.valueOf(i));
                    return false;
                }
                return false;
            }
            File file = new File(str);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!exists || isDirectory) {
                if (d.a) {
                    d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
                    return false;
                }
                return false;
            }
            long length = file.length();
            long g = cVar.g();
            if (cVar.m() <= 1 && g == 0) {
                if (d.a) {
                    d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                    return false;
                }
                return false;
            }
            long h = cVar.h();
            if (length < g || (h != -1 && (length > h || g >= h))) {
                if (d.a) {
                    d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(g), Long.valueOf(h));
                    return false;
                }
                return false;
            } else if (bool == null || bool.booleanValue() || h != length) {
                return true;
            } else {
                if (d.a) {
                    d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                    return false;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j > ((long) c()) && j2 > d() : invokeCommon.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        boolean endsWith;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            Boolean bool = d;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (e.a().d) {
                endsWith = true;
            } else if (((ActivityManager) context.getSystemService("activity")) == null) {
                d.d(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            } else {
                endsWith = ak.a(context).endsWith(":filedownloader");
            }
            Boolean valueOf = Boolean.valueOf(endsWith);
            d = valueOf;
            return valueOf.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static long b(int i, com.kwai.filedownloader.kwai.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65553, null, i, bVar)) == null) {
            long k = k(bVar.a("Content-Length"));
            String a2 = bVar.a("Transfer-Encoding");
            if (k < 0) {
                if (!(a2 != null && a2.equals("chunked"))) {
                    if (!e.a().c) {
                        throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                    }
                    if (d.a) {
                        d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                    }
                }
                return -1L;
            }
            return k;
        }
        return invokeIL.longValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a("FileDownloader/%s", BuildConfig.VERSION_NAME) : (String) invokeV.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? a("%s.temp", str) : (String) invokeL.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, context) == null) {
            File c2 = c(context);
            try {
                c2.getParentFile().mkdirs();
                c2.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, str, str2) == null) {
            l(str2);
            i(str);
        }
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? a : invokeV.intValue;
    }

    public static File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            return new File(context.getFilesDir().getAbsolutePath() + File.separator + FileDownloadServiceProxy.TAG, ".old_file_converted");
        }
        return (File) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b2 : digest) {
                    int i = b2 & 255;
                    if (i < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i));
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException("Huh, MD5 should be supported?", e3);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) {
            if (str2 != null) {
                if (str != null) {
                    return a("%s%s%s", str, File.separator, str2);
                }
                throw new IllegalStateException("can't generate real path, the directory is null");
            }
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        return (String) invokeLL.objValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? b : invokeV.longValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                Matcher matcher = f.matcher(str);
                if (matcher.find()) {
                    return matcher.group(1);
                }
            } catch (IllegalStateException unused) {
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            if (TextUtils.isEmpty(c)) {
                return (c.a().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory() : c.a().getExternalCacheDir()).getAbsolutePath();
            }
            return c;
        }
        return (String) invokeV.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            int length = str.length();
            int i = 2;
            int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
            int lastIndexOf = str.lastIndexOf(File.separatorChar);
            if (lastIndexOf != -1 || i2 <= 0) {
                i = lastIndexOf;
            }
            if (i != -1) {
                char charAt = str.charAt(length - 1);
                char c2 = File.separatorChar;
                if (charAt == c2) {
                    return null;
                }
                return (str.indexOf(c2) == i && str.charAt(i2) == File.separatorChar) ? str.substring(0, i + 1) : str.substring(0, i);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return "FileDownloader-" + str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) ? c.a().checkCallingOrSelfPermission(str) == 0 : invokeL.booleanValue;
    }

    public static com.kwai.filedownloader.d.a h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("found invalid internal destination path, empty");
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(a("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (file.exists() || file.createNewFile()) {
                return com.kwai.filedownloader.download.b.a().a(file);
            }
            throw new IOException(a("create new file error  %s", file.getAbsolutePath()));
        }
        return (com.kwai.filedownloader.d.a) invokeL.objValue;
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, null, str) == null) || str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) ? c(str) : (String) invokeL.objValue;
    }

    public static long k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65572, null, str) == null) || str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }
}
