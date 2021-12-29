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
/* loaded from: classes3.dex */
public class a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2068a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ZipFile a;

        /* renamed from: b  reason: collision with root package name */
        public ZipEntry f57515b;

        public C2068a(ZipFile zipFile, ZipEntry zipEntry) {
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
            this.a = zipFile;
            this.f57515b = zipEntry;
        }
    }

    public a() {
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

    private long a(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, this, inputStream, outputStream)) != null) {
            return invokeLL.longValue;
        }
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }

    private C2068a a(Context context, String[] strArr, String str, c cVar) {
        InterceptResult invokeLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, context, strArr, str, cVar)) == null) {
            String[] a = a(context);
            int length = a.length;
            char c2 = 0;
            ZipFile zipFile = null;
            int i3 = 0;
            while (i3 < length) {
                String str2 = a[i3];
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    i2 = 5;
                    if (i4 >= 5) {
                        break;
                    }
                    try {
                        zipFile = new ZipFile(new File(str2), 1);
                        break;
                    } catch (IOException unused) {
                        i4 = i5;
                    }
                }
                if (zipFile != null) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        if (i6 >= i2) {
                            break;
                        }
                        int length2 = strArr.length;
                        int i8 = 0;
                        while (i8 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i8] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c2] = str3;
                            objArr[1] = str2;
                            cVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C2068a(zipFile, entry);
                            }
                            i8++;
                            c2 = 0;
                        }
                        i6 = i7;
                        i2 = 5;
                    }
                }
                i3++;
                c2 = 0;
            }
            return null;
        }
        return (C2068a) invokeLLLL.objValue;
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
        C2068a c2068a = null;
        Closeable closeable2 = null;
        try {
            C2068a a2 = a(context, strArr, str, cVar);
            try {
                if (a2 == null) {
                    throw new RuntimeException(str);
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 >= 5) {
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
                                inputStream = a2.a.getInputStream(a2.f57515b);
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
                                i2 = i3;
                            } catch (IOException unused7) {
                                a(inputStream);
                                a(closeable);
                                i2 = i3;
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
                    i2 = i3;
                }
            } catch (Throwable th4) {
                th = th4;
                c2068a = a2;
                if (c2068a != null) {
                    try {
                        if (c2068a.a != null) {
                            c2068a.a.close();
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
