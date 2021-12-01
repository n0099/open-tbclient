package com.tachikoma.core.utility;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.StringUtils;
import com.tachikoma.core.log.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class UnzipUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] PNG_END_CODE;
    public static final byte[] ZIP_HEADER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1915088342, "Lcom/tachikoma/core/utility/UnzipUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1915088342, "Lcom/tachikoma/core/utility/UnzipUtil;");
                return;
            }
        }
        PNG_END_CODE = new byte[]{73, 69, 78, 68};
        ZIP_HEADER = new byte[]{4, 3, 75, 80};
    }

    public UnzipUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0093 A[Catch: IOException -> 0x008f, TRY_LEAVE, TryCatch #4 {IOException -> 0x008f, blocks: (B:45:0x008b, B:49:0x0093), top: B:59:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void copyAssetsFile(Context context, String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65538, null, context, str, str2, str3) != null) {
            return;
        }
        File file = new File(str3 + File.separator + str);
        if (file.exists()) {
            return;
        }
        File file2 = new File(str3);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            try {
                inputStream = context.getAssets().open(str2);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            e2 = e3;
                            Logger.logE("copyAssetsFile exception", e2);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                Logger.logE("copyAssetsFile exception", e4);
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    fileOutputStream = null;
                    e2 = e5;
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    th = th3;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e6) {
                Logger.logE("copyAssetsFile exception", e6);
            }
        } catch (Exception e7) {
            fileOutputStream = null;
            e2 = e7;
            inputStream = null;
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            inputStream = null;
        }
    }

    public static File ensureFile(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, str)) == null) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                FileUtil.deleteContents(file2);
                file2.delete();
            }
            return file2;
        }
        return (File) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static File extractZipFromPng(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) != null) {
            return (File) invokeL.objValue;
        }
        if (Build.VERSION.SDK_INT > 23) {
            return file;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        ByteBuffer allocate2 = ByteBuffer.allocate(4);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            bufferedInputStream.skip(8L);
            do {
                bufferedInputStream.read(allocate.array());
                bufferedInputStream.read(allocate2.array());
                allocate.rewind();
                bufferedInputStream.skip(allocate.getInt() + 4);
            } while (!Arrays.equals(PNG_END_CODE, allocate2.array()));
            String parent = file.getParent();
            File file2 = new File(parent, UUID.randomUUID().toString() + "_png.zip");
            FileUtil.copyInputStreamToFile(bufferedInputStream, file2);
            bufferedInputStream.close();
            return file2;
        } finally {
        }
    }

    public static Charset getKwaiDefaultUnzipFileCharset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return Charset.forName("8859_1");
            } catch (Exception unused) {
                return Charset.defaultCharset();
            }
        }
        return (Charset) invokeV.objValue;
    }

    public static File getRealFileName(String str, String str2, Charset charset) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, charset)) == null) {
            String[] split = str2.split("/");
            File file = new File(str);
            if (split.length >= 1) {
                int i2 = 0;
                while (i2 < split.length - 1) {
                    i2++;
                    file = new File(file, getTextWithCharset(split[i2], charset));
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                return new File(file, getTextWithCharset(split[split.length - 1], charset));
            }
            return file;
        }
        return (File) invokeLLL.objValue;
    }

    public static String getSafeEntryNameOrThrow(ZipEntry zipEntry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, zipEntry)) == null) {
            String name = zipEntry.getName();
            if (name.contains(Constants.PATH_PARENT)) {
                throw new IllegalStateException("file name can't contains ../");
            }
            return name;
        }
        return (String) invokeL.objValue;
    }

    public static String getTextWithCharset(String str, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, charset)) == null) {
            if (charset != null) {
                try {
                    if (charset.equals(getKwaiDefaultUnzipFileCharset())) {
                        return new String(str.getBytes("8859_1"), StringUtils.GB2312);
                    }
                } catch (Throwable unused) {
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void unzipFile(File file, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, file, str) == null) {
            unzipFile(file, str, getKwaiDefaultUnzipFileCharset());
        }
    }

    public static void unzipFile(File file, String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, file, str, str2) == null) {
            unzipFile(file, str, str2, getKwaiDefaultUnzipFileCharset());
        }
    }

    public static void unzipFile(@NonNull File file, @NonNull String str, @NonNull String str2, Charset charset) {
        File file2;
        String str3;
        ZipFile zipFile;
        int i2;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, file, str, str2, charset) == null) {
            ZipFile zipFile2 = null;
            r2 = null;
            BufferedInputStream bufferedInputStream = null;
            zipFile2 = null;
            try {
                str3 = new File(str).getPath() + "_folder_" + System.currentTimeMillis();
                file2 = new File(str3);
                try {
                    file2.mkdirs();
                    if (file.length() > 100000000) {
                        Logger.logE("upzip fileSize: " + file.length() + " targetFile: " + file.getPath(), null);
                    }
                    zipFile = new ZipFile(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                file2 = null;
            }
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                byte[] bArr = new byte[1024];
                while (true) {
                    if (!entries.hasMoreElements()) {
                        break;
                    }
                    ZipEntry nextElement = entries.nextElement();
                    if (TextUtils.isEmpty(nextElement.getName())) {
                        Logger.logE(SchemeCollecter.CLASSIFY_EMPTY + nextElement.getName(), null);
                    }
                    if (nextElement.isDirectory()) {
                        new File(getTextWithCharset(new File(file2, getSafeEntryNameOrThrow(nextElement)).getPath(), charset)).mkdirs();
                    } else {
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getRealFileName(str3, getSafeEntryNameOrThrow(nextElement), charset)));
                            try {
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                while (true) {
                                    try {
                                        int read = bufferedInputStream2.read(bArr, 0, 1024);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedInputStream = bufferedInputStream2;
                                        CloseableUtil.closeQuietly((InputStream) bufferedInputStream);
                                        CloseableUtil.closeQuietly((OutputStream) bufferedOutputStream);
                                        throw th;
                                    }
                                }
                                CloseableUtil.closeQuietly((InputStream) bufferedInputStream2);
                                CloseableUtil.closeQuietly((OutputStream) bufferedOutputStream);
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedOutputStream = null;
                        }
                    }
                }
                File file3 = new File(str);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                File[] listFiles = file2.listFiles();
                if (listFiles.length != 1 || TextUtils.isEmpty(str2)) {
                    for (File file4 : listFiles) {
                        if (!file4.renameTo(ensureFile(file3, file4.getName()))) {
                            throw new IOException("rename failed, " + file3);
                        }
                    }
                } else {
                    if (!listFiles[0].renameTo(ensureFile(file3, str2))) {
                        throw new IOException("rename failed, " + file3);
                    }
                }
                if (file3.length() > 100000000) {
                    Logger.logE("upzip fileSize: " + file3.length() + " targetFile: " + file3.getPath(), null);
                }
                CloseableUtil.closeQuietly(zipFile);
                FileUtil.deleteContents(file2);
                file2.delete();
            } catch (Throwable th6) {
                th = th6;
                zipFile2 = zipFile;
                try {
                    Logger.logE("upzip exception", th);
                    throw th;
                } catch (Throwable th7) {
                    CloseableUtil.closeQuietly(zipFile2);
                    if (file2 != null) {
                        FileUtil.deleteContents(file2);
                        file2.delete();
                    }
                    throw th7;
                }
            }
        }
    }

    public static void unzipFile(File file, String str, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, file, str, charset) == null) {
            File extractZipFromPng = extractZipFromPng(file);
            try {
                unzipFile(extractZipFromPng, str, null, charset);
            } finally {
                if (extractZipFromPng != file) {
                    FileUtil.deleteQuietly(extractZipFromPng);
                }
            }
        }
    }
}
