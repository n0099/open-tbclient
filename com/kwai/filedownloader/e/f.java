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
import com.kwad.sdk.utils.an;
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
    public static int awU = 65536;
    public static long awV = 2000;
    public static String awW;
    public static Boolean awX;
    public static Boolean awY;
    public static final Pattern awZ;
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
        awZ = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
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

    public static int EN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? awU : invokeV.intValue;
    }

    public static long EO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? awV : invokeV.longValue;
    }

    public static String EP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(awW)) {
                return (c.EJ().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory() : c.EJ().getExternalCacheDir()).getAbsolutePath();
            }
            return awW;
        }
        return (String) invokeV.objValue;
    }

    public static boolean EQ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.EJ().getSystemService("connectivity");
            if (connectivityManager == null) {
                d.f(f.class, "failed to get connectivity manager!", new Object[0]);
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
        }
        return invokeV.booleanValue;
    }

    public static String ER() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? h("FileDownloader/%s", BuildConfig.VERSION_NAME) : (String) invokeV.objValue;
    }

    public static String a(int i, com.kwai.filedownloader.kwai.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i, bVar)) == null) {
            if (bVar != null) {
                String p = bVar.p(Util.ETAG);
                if (d.awL) {
                    d.e(f.class, "etag find %s for task(%d)", p, Integer.valueOf(i));
                }
                return p;
            }
            throw new RuntimeException("connection is null when findEtag");
        }
        return (String) invokeIL.objValue;
    }

    public static String a(com.kwai.filedownloader.kwai.b bVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bVar, str)) == null) {
            String eG = eG(bVar.p("Content-Disposition"));
            if (TextUtils.isEmpty(eG)) {
                eG = eE(str);
            }
            return eG.replaceAll("\\/", "_");
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, boolean z, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, Boolean.valueOf(z), str2})) == null) {
            if (str == null) {
                return null;
            }
            if (z) {
                if (str2 == null) {
                    return null;
                }
                return ac(str, str2);
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar, Boolean bool) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65546, null, i, cVar, bool)) == null) {
            if (cVar == null) {
                if (d.awL) {
                    d.e(f.class, "can't continue %d model == null", Integer.valueOf(i));
                }
                return false;
            } else if (cVar.DE() == null) {
                if (d.awL) {
                    d.e(f.class, "can't continue %d temp path == null", Integer.valueOf(i));
                }
                return false;
            } else {
                return a(i, cVar, cVar.DE(), null);
            }
        }
        return invokeILL.booleanValue;
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar, String str, Boolean bool) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i), cVar, str, bool})) == null) {
            if (str == null) {
                if (d.awL) {
                    d.e(f.class, "can't continue %d path = null", Integer.valueOf(i));
                    return false;
                }
                return false;
            }
            File file = new File(str);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!exists || isDirectory) {
                if (d.awL) {
                    d.e(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
                    return false;
                }
                return false;
            }
            long length = file.length();
            long Em = cVar.Em();
            if (cVar.Eo() <= 1 && Em == 0) {
                if (d.awL) {
                    d.e(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                    return false;
                }
                return false;
            }
            long total = cVar.getTotal();
            if (length < Em || (total != -1 && (length > total || Em >= total))) {
                if (d.awL) {
                    d.e(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(Em), Long.valueOf(total));
                    return false;
                }
                return false;
            } else if (bool == null || bool.booleanValue() || total != length) {
                return true;
            } else {
                if (d.awL) {
                    d.e(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                    return false;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static String ac(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (str2 != null) {
                if (str != null) {
                    return h("%s%s%s", str, File.separator, str2);
                }
                throw new IllegalStateException("can't generate real path, the directory is null");
            }
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        return (String) invokeLL.objValue;
    }

    public static void ac(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, null, j) == null) {
            if (!dE(c.EJ())) {
                throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
            }
            awV = j;
        }
    }

    public static int ad(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) ? com.kwai.filedownloader.download.b.Dp().Dq().k(str, str2, false) : invokeLL.intValue;
    }

    public static void ae(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            eM(str2);
            eN(str);
        }
    }

    public static long b(int i, com.kwai.filedownloader.kwai.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65552, null, i, bVar)) == null) {
            long eK = eK(bVar.p("Content-Length"));
            String p = bVar.p("Transfer-Encoding");
            if (eK < 0) {
                if (!(p != null && p.equals("chunked"))) {
                    if (!e.EL().awO) {
                        throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                    }
                    if (d.awL) {
                        d.e(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                    }
                }
                return -1L;
            }
            return eK;
        }
        return invokeIL.longValue;
    }

    public static boolean b(int i, com.kwai.filedownloader.c.c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65553, null, i, cVar)) == null) ? a(i, cVar, (Boolean) null) : invokeIL.booleanValue;
    }

    public static void cF(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65554, null, i) == null) {
            if (!dE(c.EJ())) {
                throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
            }
            awU = i;
        }
    }

    public static boolean dE(Context context) {
        InterceptResult invokeL;
        boolean endsWith;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            Boolean bool = awX;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (e.EL().awP) {
                endsWith = true;
            } else if (((ActivityManager) context.getSystemService("activity")) == null) {
                d.f(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            } else {
                endsWith = an.getProcessName(context).endsWith(":filedownloader");
            }
            Boolean valueOf = Boolean.valueOf(endsWith);
            awX = valueOf;
            return valueOf.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static void dF(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, context) == null) {
            File dG = dG(context);
            try {
                dG.getParentFile().mkdirs();
                dG.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File dG(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            return new File(context.getFilesDir().getAbsolutePath() + File.separator + FileDownloadServiceProxy.TAG, ".old_file_converted");
        }
        return (File) invokeL.objValue;
    }

    public static String dI(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b : digest) {
                    int i = b & 255;
                    if (i < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i));
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Huh, UTF-8 should be supported?", e);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("Huh, MD5 should be supported?", e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String eD(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) ? ac(EP(), eE(str)) : (String) invokeL.objValue;
    }

    public static String eE(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) ? dI(str) : (String) invokeL.objValue;
    }

    public static String eF(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) ? h("%s.temp", str) : (String) invokeL.objValue;
    }

    public static String eG(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                Matcher matcher = awZ.matcher(str);
                if (matcher.find()) {
                    return matcher.group(1);
                }
            } catch (IllegalStateException unused) {
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String eH(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            int length = str.length();
            int i = 2;
            int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
            int lastIndexOf = str.lastIndexOf(File.separatorChar);
            if (lastIndexOf != -1 || i2 <= 0) {
                i = lastIndexOf;
            }
            if (i != -1) {
                char charAt = str.charAt(length - 1);
                char c = File.separatorChar;
                if (charAt == c) {
                    return null;
                }
                return (str.indexOf(c) == i && str.charAt(i2) == File.separatorChar) ? str.substring(0, i + 1) : str.substring(0, i);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String eI(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            return "FileDownloader-" + str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean eJ(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) ? c.EJ().checkCallingOrSelfPermission(str) == 0 : invokeL.booleanValue;
    }

    public static long eK(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
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

    public static com.kwai.filedownloader.d.a eL(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("found invalid internal destination path, empty");
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(h("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (file.exists() || file.createNewFile()) {
                return com.kwai.filedownloader.download.b.Dp().ad(file);
            }
            throw new IOException(h("create new file error  %s", file.getAbsolutePath()));
        }
        return (com.kwai.filedownloader.d.a) invokeL.objValue;
    }

    public static void eM(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, null, str) == null) || str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void eN(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, null, str) == null) || str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean g(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j > ((long) EN()) && j2 > EO() : invokeCommon.booleanValue;
    }

    public static String h(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, str, objArr)) == null) ? String.format(Locale.ENGLISH, str, objArr) : (String) invokeLL.objValue;
    }

    public static int k(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65572, null, str, str2, z)) == null) ? com.kwai.filedownloader.download.b.Dp().Dq().k(str, str2, z) : invokeLLZ.intValue;
    }
}
