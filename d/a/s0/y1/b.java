package d.a.s0.y1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import androidx.multidex.MultiDexExtractor;
import com.alipay.sdk.util.e;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.y1.c;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Method f69600a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f69601a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69601a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? !file.getName().startsWith(this.f69601a) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-621691133, "Ld/a/s0/y1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-621691133, "Ld/a/s0/y1/b;");
                return;
            }
        }
        try {
            f69600a = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException unused) {
            f69600a = null;
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, editor) == null) {
            Method method = f69600a;
            if (method != null) {
                try {
                    method.invoke(editor, new Object[0]);
                    return;
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            editor.commit();
        }
    }

    public static void b(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, closeable) == null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
        }
    }

    public static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, zipFile, zipEntry, file, str) == null) {
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            File createTempFile = File.createTempFile(str, ".zip", file.getParentFile());
            Log.i("MultiDex", "Extracting " + createTempFile.getPath());
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } finally {
                b(inputStream);
                createTempFile.delete();
            }
        }
    }

    public static SharedPreferences d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static long e(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            long lastModified = file.lastModified();
            return lastModified == -1 ? lastModified - 1 : lastModified;
        }
        return invokeL.longValue;
    }

    public static long f(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, file)) == null) {
            long c2 = d.c(file);
            return c2 == -1 ? c2 - 1 : c2;
        }
        return invokeL.longValue;
    }

    public static boolean g(Context context, File file, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, file, Long.valueOf(j)})) == null) {
            SharedPreferences d2 = d(context);
            return (d2.getLong("timestamp", -1L) == e(file) && d2.getLong(MultiDexExtractor.KEY_CRC, -1L) == j) ? false : true;
        }
        return invokeCommon.booleanValue;
    }

    public static List<File> h(Context context, ApplicationInfo applicationInfo, File file, boolean z) throws IOException {
        InterceptResult invokeCommon;
        List<File> k;
        List<File> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, applicationInfo, file, Boolean.valueOf(z)})) == null) {
            Log.i("MultiDex", "MultiDexExtractor.load(" + applicationInfo.sourceDir + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + SmallTailInfo.EMOTION_SUFFIX);
            File file2 = new File(applicationInfo.sourceDir);
            long f2 = f(file2);
            if (!z && !g(context, file2, f2)) {
                try {
                    list = i(context, file2, file);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                    if (context instanceof c.InterfaceC1896c) {
                        ((c.InterfaceC1896c) context).getSplash().j();
                    }
                    k = k(file2, file);
                    m(context, e(file2), f2, k.size() + 1);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            Log.i("MultiDex", "Detected that extraction must be performed.");
            if (context instanceof c.InterfaceC1896c) {
                ((c.InterfaceC1896c) context).getSplash().j();
            }
            k = k(file2, file);
            m(context, e(file2), f2, k.size() + 1);
            list = k;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        return (List) invokeCommon.objValue;
    }

    public static List<File> i(Context context, File file, File file2) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, file, file2)) == null) {
            Log.i("MultiDex", "loading existing secondary dex files");
            String str = file.getName() + ".classes";
            int i2 = d(context).getInt("dex.number", 1);
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 2; i3 <= i2; i3++) {
                File file3 = new File(file2, str + i3 + ".zip");
                if (file3.isFile()) {
                    arrayList.add(file3);
                    if (!n(file3)) {
                        Log.i("MultiDex", "Invalid zip file: " + file3);
                        throw new IOException("Invalid ZIP file.");
                    }
                } else {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public static void j(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, file) == null) {
            file.mkdir();
            if (file.isDirectory()) {
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create cache directory " + file.getPath());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0122, code lost:
        throw new java.io.IOException("Could not create zip file " + r9.getAbsolutePath() + " for secondary dex (" + r14 + com.baidu.tbadk.core.data.SmallTailInfo.EMOTION_SUFFIX);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<File> k(File file, File file2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65547, null, file, file2)) != null) {
            return (List) invokeLL.objValue;
        }
        String str = file.getName() + ".classes";
        l(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        int i2 = 2;
        try {
            String str2 = MultiDexExtractor.DEX_PREFIX + "2.dex";
            while (true) {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry == null) {
                    return arrayList;
                }
                File file3 = new File(file2, str + i2 + ".zip");
                arrayList.add(file3);
                Log.i("MultiDex", "Extraction is needed for file " + file3);
                int i3 = 0;
                boolean z = false;
                while (i3 < 3 && !z) {
                    i3++;
                    c(zipFile, entry, file3, str);
                    z = n(file3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "success" : e.f1966a);
                    sb.append(" - length ");
                    sb.append(file3.getAbsolutePath());
                    sb.append(": ");
                    sb.append(file3.length());
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        file3.delete();
                        if (file3.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + file3.getPath() + "'");
                        }
                    }
                }
                if (!z) {
                    break;
                }
                i2++;
                str2 = MultiDexExtractor.DEX_PREFIX + i2 + ".dex";
            }
        } finally {
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
        }
    }

    public static void l(File file, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, file, str) == null) {
            j(file.getParentFile());
            j(file);
            File[] listFiles = file.listFiles(new a(str));
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
        }
    }

    public static void m(Context context, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            SharedPreferences.Editor edit = d(context).edit();
            edit.putLong("timestamp", j);
            edit.putLong(MultiDexExtractor.KEY_CRC, j2);
            edit.putInt("dex.number", i2);
            a(edit);
        }
    }

    public static boolean n(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, file)) == null) {
            try {
                try {
                    new ZipFile(file).close();
                    return true;
                } catch (IOException unused) {
                    Log.w("MultiDex", "Failed to close zip file: " + file.getAbsolutePath());
                    return false;
                }
            } catch (ZipException e2) {
                Log.w("MultiDex", "File " + file.getAbsolutePath() + " is not a valid zip file.", e2);
                return false;
            } catch (IOException e3) {
                Log.w("MultiDex", "Got an IOException trying to open zip file: " + file.getAbsolutePath(), e3);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
