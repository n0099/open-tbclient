package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import ms.bd.c.n;
/* loaded from: classes2.dex */
public class l implements n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ZipFile f79288a;

        /* renamed from: b  reason: collision with root package name */
        public ZipEntry f79289b;

        public a(ZipFile zipFile, ZipEntry zipEntry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zipFile, zipEntry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79288a = zipFile;
            this.f79289b = zipEntry;
        }
    }

    public l() {
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

    public final a a(Context context, String[] strArr, String str, o oVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, strArr, str, oVar)) != null) {
            return (a) invokeLLLL.objValue;
        }
        String[] d2 = d(context);
        int length = d2.length;
        char c2 = 0;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = d2[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        int length2 = strArr.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c2] = str3;
                            objArr[1] = str2;
                            oVar.e("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new a(zipFile, entry);
                            }
                            i7++;
                            c2 = 0;
                        }
                        i5 = i6;
                        c2 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            c2 = 0;
        }
    }

    public void b(Context context, String[] strArr, String str, File file, o oVar) {
        a a2;
        String[] strArr2;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, strArr, str, file, oVar) != null) {
            return;
        }
        a aVar = null;
        r0 = null;
        Closeable closeable = null;
        try {
            a2 = a(context, strArr, str, oVar);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (a2 == null) {
                try {
                    strArr2 = e(context, str);
                } catch (Exception e2) {
                    strArr2 = new String[]{e2.toString()};
                }
                throw new m(str, strArr, strArr2);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    oVar.d("FATAL! Couldn't extract the library from the APK!");
                    try {
                        ZipFile zipFile = a2.f79288a;
                        if (zipFile != null) {
                            zipFile.close();
                            return;
                        }
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                oVar.e("Found %s! Extracting...", str);
                try {
                    if (file.exists() || file.createNewFile()) {
                        try {
                            inputStream = a2.f79288a.getInputStream(a2.f79289b);
                        } catch (FileNotFoundException | IOException unused2) {
                            inputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            j2 = 0;
                        } catch (FileNotFoundException | IOException unused3) {
                            fileOutputStream = null;
                            c(inputStream);
                            c(fileOutputStream);
                            i2 = i3;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                j2 += read;
                            }
                            fileOutputStream.flush();
                            fileOutputStream.getFD().sync();
                            if (j2 == file.length()) {
                                c(inputStream);
                                c(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile2 = a2.f79288a;
                                    if (zipFile2 != null) {
                                        zipFile2.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused4) {
                                    return;
                                }
                            }
                        } catch (FileNotFoundException | IOException unused5) {
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = fileOutputStream;
                            c(inputStream);
                            c(closeable);
                            throw th;
                        }
                        c(inputStream);
                        c(fileOutputStream);
                    }
                } catch (IOException unused6) {
                }
                i2 = i3;
            }
        } catch (Throwable th6) {
            th = th6;
            aVar = a2;
            if (aVar != null) {
                try {
                    ZipFile zipFile3 = aVar.f79288a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused7) {
                }
            }
            throw th;
        }
    }

    public final void c(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public final String[] d(Context context) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null || strArr.length == 0) {
                return new String[]{applicationInfo.sourceDir};
            }
            String[] strArr2 = new String[strArr.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
            return strArr2;
        }
        return (String[]) invokeL.objValue;
    }

    public final String[] e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            Pattern compile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
            HashSet hashSet = new HashSet();
            for (String str2 : d(context)) {
                try {
                    Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                    while (entries.hasMoreElements()) {
                        Matcher matcher = compile.matcher(entries.nextElement().getName());
                        if (matcher.matches()) {
                            hashSet.add(matcher.group(1));
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return (String[]) hashSet.toArray(new String[hashSet.size()]);
        }
        return (String[]) invokeLL.objValue;
    }
}
