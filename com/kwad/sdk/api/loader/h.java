package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.SpeedLimitApiHolder;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f70733a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void a(File file);
    }

    /* loaded from: classes10.dex */
    public static class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f70737a;

        public b(File file, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70737a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(int i2, Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, map) == null) {
            }
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            }
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) {
                this.f70737a.write(bArr, i2, i3);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f70737a.close();
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        boolean a(int i2, int i3, Object obj);
    }

    /* loaded from: classes10.dex */
    public interface d extends Closeable {
        void a(int i2, Map<String, List<String>> map);

        void a(long j2);

        void a(byte[] bArr, int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1711378529, "Lcom/kwad/sdk/api/loader/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1711378529, "Lcom/kwad/sdk/api/loader/h;");
                return;
            }
        }
        f70733a = a(Loader.get().getContext()) + "/apkfileD/dynamic";
    }

    @NonNull
    public static String a(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String str = "";
            try {
                str = Environment.getExternalStorageState();
            } catch (IncompatibleClassChangeError | NullPointerException unused) {
            }
            String str2 = null;
            if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
                try {
                    file = context.getExternalFilesDir(null);
                } catch (Exception unused2) {
                    file = null;
                }
                if (file != null) {
                    str2 = file.getPath();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getFilesDir().getPath();
            }
            return str2 + File.separator + "ksadsdk";
        }
        return (String) invokeL.objValue;
    }

    public static URLConnection a(String str, int i2, int i3, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                TLSConnectionUtils.wrapHttpURLConnection(openConnection);
                openConnection.setRequestProperty("Accept-Language", "zh-CN");
                if (i2 > 0) {
                    openConnection.setConnectTimeout(i2);
                }
                if (i3 > 0) {
                    openConnection.setReadTimeout(i3);
                }
                openConnection.setUseCaches(z);
                openConnection.setDoInput(true);
                openConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                openConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                return openConnection;
            } catch (MalformedURLException unused) {
                return null;
            }
        }
        return (URLConnection) invokeCommon.objValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void a(String str, String str2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, aVar) == null) {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            i.a(new Runnable(str, file, aVar) { // from class: com.kwad.sdk.api.loader.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f70734a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ File f70735b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f70736c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, file, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f70734a = str;
                    this.f70735b = file;
                    this.f70736c = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            boolean a2 = h.a(this.f70734a, this.f70735b, null, 0);
                            if (this.f70736c != null) {
                                if (a2) {
                                    this.f70736c.a(this.f70735b);
                                } else {
                                    this.f70736c.a();
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            a aVar2 = this.f70736c;
                            if (aVar2 != null) {
                                aVar2.a();
                            }
                        }
                    }
                }
            });
        }
    }

    public static boolean a(String str, File file, c cVar, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLI = interceptable.invokeLLLI(AdIconUtil.AD_TEXT_ID, null, str, file, cVar, i2)) != null) {
            return invokeLLLI.booleanValue;
        }
        b bVar = null;
        try {
            b bVar2 = new b(file, false);
            try {
                boolean a2 = a(str, (String) null, bVar2, cVar, i2);
                a(bVar2);
                return a2;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                a(bVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(String str, String str2, d dVar, c cVar, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, str2, dVar, cVar, Integer.valueOf(i2)})) == null) ? a(str, str2, dVar, cVar, i2, -1L, -1L, false) : invokeCommon.booleanValue;
    }

    public static boolean a(String str, String str2, d dVar, c cVar, int i2, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, dVar, cVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) a(str, 10000, i2 > 0 ? i2 : 120000, false, true);
            try {
                if (httpURLConnection2 != null) {
                    boolean a2 = a(httpURLConnection2, str2, dVar, cVar, i2, j2, j3, z);
                    a(dVar);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return a2;
                }
                throw new IOException("Fail to createUrlConnection");
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                a(dVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:107:0x00d9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x0170 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0181 A[Catch: all -> 0x01ab, TryCatch #5 {all -> 0x01ab, blocks: (B:90:0x017d, B:92:0x0181, B:94:0x01aa, B:93:0x0184), top: B:117:0x017d }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0184 A[Catch: all -> 0x01ab, TryCatch #5 {all -> 0x01ab, blocks: (B:90:0x017d, B:92:0x0181, B:94:0x01aa, B:93:0x0184), top: B:117:0x017d }] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, String str, d dVar, c cVar, int i2, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Object valueOf;
        FileOutputStream fileOutputStream;
        File file;
        HashMap hashMap;
        File file2;
        int i3;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{httpURLConnection, str, dVar, cVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        InputStream inputStream = null;
        int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i4 > 0 || j3 > 0) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j2);
                if (j3 > 0) {
                    try {
                        valueOf = Long.valueOf(j3);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                        file = null;
                        try {
                            if (th instanceof IOException) {
                            }
                        } catch (Throwable th2) {
                            a(dVar);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            a(fileOutputStream);
                            if (file != null) {
                                file.delete();
                            }
                            throw th2;
                        }
                    }
                } else {
                    valueOf = "";
                }
                objArr[1] = valueOf;
                httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", objArr));
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                inputStream = null;
                file = null;
                if (th instanceof IOException) {
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setInstanceFollowRedirects(false);
            if (httpURLConnection.getResponseCode() == 302) {
                boolean a2 = a(httpURLConnection.getHeaderField("Location"), (String) null, dVar, cVar, i2);
                a(dVar);
                a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a((Closeable) null);
                return a2;
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", RequestParamsUtils.getUserAgent());
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
        try {
            int contentLength = httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() == null) {
                try {
                    hashMap = new HashMap();
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    file = fileOutputStream;
                    inputStream = bufferedInputStream2;
                    if (th instanceof IOException) {
                    }
                }
            } else {
                hashMap = new HashMap(httpURLConnection.getHeaderFields());
            }
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(httpURLConnection.getInputStream());
            if (contentLength <= 0) {
                try {
                    Random random = new Random(System.currentTimeMillis());
                    file2 = new File(f70733a, random.nextInt() + ".tmp");
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[10240];
                            i3 = 0;
                            while (true) {
                                int read = bufferedInputStream3.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                i3 += read;
                                fileOutputStream.write(bArr, 0, read);
                            }
                            a(bufferedInputStream3);
                            a(fileOutputStream);
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = bufferedInputStream3;
                            file = file2;
                            if (th instanceof IOException) {
                                throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                            }
                            throw th;
                        }
                        try {
                            hashMap.put("Content-Length", Collections.singletonList(String.valueOf(i3)));
                            bufferedInputStream3 = bufferedInputStream;
                            contentLength = i3;
                            file2 = file2;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream = bufferedInputStream;
                            file = file2;
                            if (th instanceof IOException) {
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        fileOutputStream = null;
                        inputStream = bufferedInputStream3;
                        file = file2;
                        if (th instanceof IOException) {
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    fileOutputStream = null;
                    file2 = null;
                }
            } else {
                fileOutputStream = null;
                file2 = null;
            }
            int i5 = (i4 <= 0 || !z) ? 0 : (int) j2;
            int i6 = contentLength + i5;
            dVar.a(i6);
            dVar.a(httpURLConnection.getResponseCode(), hashMap);
            if (cVar != null) {
                cVar.a(i5, i6, null);
            }
            byte[] bArr2 = new byte[10240];
            if (SpeedLimitApiHolder.getInstance() != null) {
                bufferedInputStream3 = SpeedLimitApiHolder.getInstance().wrapInputStream(bufferedInputStream3);
            }
            while (true) {
                int read2 = bufferedInputStream3.read(bArr2);
                if (read2 == -1) {
                    break;
                }
                i5 += read2;
                dVar.a(bArr2, 0, read2);
                if (cVar != null) {
                    cVar.a(i5, i6, null);
                }
            }
            if (cVar != null) {
                cVar.a(i6, i6, null);
            }
            a(dVar);
            a(bufferedInputStream3);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            a(fileOutputStream);
            if (file2 != null) {
                file2.delete();
                return true;
            }
            return true;
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
        }
    }
}
