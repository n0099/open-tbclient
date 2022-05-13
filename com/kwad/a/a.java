package com.kwad.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.a.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes5.dex */
public class a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0280a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ZipFile a;
        public ZipEntry b;

        public C0280a(ZipFile zipFile, ZipEntry zipEntry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zipFile, zipEntry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zipFile;
            this.b = zipEntry;
        }
    }

    public a() {
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

    private long a(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, this, inputStream, outputStream)) != null) {
            return invokeLL.longValue;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    private C0280a a(Context context, String[] strArr, String str, c cVar) {
        InterceptResult invokeLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, context, strArr, str, cVar)) == null) {
            String[] a = a(context);
            int length = a.length;
            char c = 0;
            ZipFile zipFile = null;
            int i2 = 0;
            while (i2 < length) {
                String str2 = a[i2];
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    i = 5;
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
                        if (i5 >= i) {
                            break;
                        }
                        int length2 = strArr.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c] = str3;
                            objArr[1] = str2;
                            cVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C0280a(zipFile, entry);
                            }
                            i7++;
                            c = 0;
                        }
                        i5 = i6;
                        i = 5;
                    }
                }
                i2++;
                c = 0;
            }
            return null;
        }
        return (C0280a) invokeLLLL.objValue;
    }

    private void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private String[] a(Context context) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
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

    @Override // com.kwad.a.b.a
    public void a(Context context, String[] strArr, String str, File file, c cVar) {
        Closeable closeable;
        InputStream inputStream;
        long a;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLLL(1048576, this, context, strArr, str, file, cVar) != null) {
            return;
        }
        C0280a c0280a = null;
        Closeable closeable2 = null;
        try {
            C0280a a2 = a(context, strArr, str, cVar);
            try {
                if (a2 == null) {
                    throw new RuntimeException(str);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 5) {
                        cVar.a("FATAL! Couldn't extract the library from the APK!");
                        if (a2 != null) {
                            try {
                                if (a2.a != null) {
                                    a2.a.close();
                                    return;
                                }
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    cVar.a("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = a2.a.getInputStream(a2.b);
                                try {
                                    closeable = new FileOutputStream(file);
                                } catch (FileNotFoundException unused2) {
                                    closeable = null;
                                } catch (IOException unused3) {
                                    closeable = null;
                                } catch (Throwable th) {
                                    th = th;
                                    closeable = null;
                                }
                            } catch (FileNotFoundException unused4) {
                                inputStream = null;
                                closeable = null;
                            } catch (IOException unused5) {
                                inputStream = null;
                                closeable = null;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = null;
                            }
                            try {
                                a = a(inputStream, closeable);
                                closeable.getFD().sync();
                            } catch (FileNotFoundException unused6) {
                                a(inputStream);
                                a(closeable);
                                i = i2;
                            } catch (IOException unused7) {
                                a(inputStream);
                                a(closeable);
                                i = i2;
                            } catch (Throwable th3) {
                                th = th3;
                                closeable2 = inputStream;
                                a(closeable2);
                                a(closeable);
                                throw th;
                            }
                            if (a == file.length()) {
                                a(inputStream);
                                a(closeable);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                if (a2 != null) {
                                    try {
                                        if (a2.a != null) {
                                            a2.a.close();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused8) {
                                        return;
                                    }
                                }
                                return;
                            }
                            a(inputStream);
                            a(closeable);
                        }
                    } catch (IOException unused9) {
                    }
                    i = i2;
                }
            } catch (Throwable th4) {
                th = th4;
                c0280a = a2;
                if (c0280a != null) {
                    try {
                        if (c0280a.a != null) {
                            c0280a.a.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
