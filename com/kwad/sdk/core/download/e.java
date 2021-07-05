package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ad;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36074a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f36075a;

        public a(File file, boolean z) {
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
            this.f36075a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(int i2, Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, map) == null) {
            }
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) {
                this.f36075a.write(bArr, i2, i3);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f36075a.close();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a(int i2, int i3, Object obj);
    }

    /* loaded from: classes7.dex */
    public interface c extends Closeable {
        void a(int i2, Map<String, List<String>> map);

        void a(long j);

        void a(byte[] bArr, int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(303278536, "Lcom/kwad/sdk/core/download/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(303278536, "Lcom/kwad/sdk/core/download/e;");
                return;
            }
        }
        f36074a = ad.a(KsAdSDKImpl.get().getContext()) + "/downloadFileSync/.temp";
    }

    public static URLConnection a(String str, int i2, int i3, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            try {
                URLConnection openConnection = new URL(str).openConnection();
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
            } catch (MalformedURLException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return null;
            }
        }
        return (URLConnection) invokeCommon.objValue;
    }

    public static void a(Context context, AdInfo adInfo) {
        AdDownloadProxy proxyForDownload;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, adInfo) == null) || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        DownloadParams transfrom = DownloadParams.transfrom(adInfo);
        proxyForDownload.startDownload(context, transfrom.mDownloadid, transfrom);
    }

    public static void a(Context context, String str) {
        AdDownloadProxy proxyForDownload;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        proxyForDownload.pauseDownload(context, str, null);
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static boolean a(String str, File file, b bVar, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLI = interceptable.invokeLLLI(AdIconUtil.AD_TEXT_ID, null, str, file, bVar, i2)) != null) {
            return invokeLLLI.booleanValue;
        }
        a aVar = null;
        try {
            a aVar2 = new a(file, false);
            try {
                boolean a2 = a(str, (String) null, aVar2, bVar, i2);
                a(aVar2);
                return a2;
            } catch (Throwable th) {
                th = th;
                aVar = aVar2;
                a(aVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, str2, cVar, bVar, Integer.valueOf(i2)})) == null) ? a(str, str2, cVar, bVar, i2, -1L, -1L, false) : invokeCommon.booleanValue;
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i2, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, cVar, bVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) a(str, 10000, i2 > 0 ? i2 : 120000, false, true);
            try {
                if (httpURLConnection2 != null) {
                    boolean a2 = a(httpURLConnection2, str2, cVar, bVar, i2, j, j2, z);
                    a(cVar);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return a2;
                }
                throw new IOException("Fail to createUrlConnection");
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                a(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x016d A[Catch: all -> 0x0197, TryCatch #3 {all -> 0x0197, blocks: (B:84:0x0169, B:86:0x016d, B:88:0x0196, B:87:0x0170), top: B:107:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0170 A[Catch: all -> 0x0197, TryCatch #3 {all -> 0x0197, blocks: (B:84:0x0169, B:86:0x016d, B:88:0x0196, B:87:0x0170), top: B:107:0x0169 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, String str, c cVar, b bVar, int i2, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Object valueOf;
        FileOutputStream fileOutputStream;
        File file;
        FileOutputStream fileOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{httpURLConnection, str, cVar, bVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        BufferedInputStream bufferedInputStream = null;
        int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i3 > 0 || j2 > 0) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                if (j2 > 0) {
                    try {
                        valueOf = Long.valueOf(j2);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                        file = null;
                        try {
                            if (th instanceof IOException) {
                            }
                        } catch (Throwable th2) {
                            a(cVar);
                            a(bufferedInputStream);
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
                file = null;
                if (th instanceof IOException) {
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setInstanceFollowRedirects(false);
            if (httpURLConnection.getResponseCode() == 302) {
                boolean a2 = a(httpURLConnection.getHeaderField("Location"), (String) null, cVar, bVar, i2);
                a(cVar);
                a(null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a(null);
                return a2;
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", k.a());
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
        try {
            int contentLength = httpURLConnection.getContentLength();
            HashMap hashMap = httpURLConnection.getHeaderFields() == null ? new HashMap() : new HashMap(httpURLConnection.getHeaderFields());
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(httpURLConnection.getInputStream());
            if (contentLength <= 0) {
                try {
                    Random random = new Random(System.currentTimeMillis());
                    file = new File(f36074a, random.nextInt() + ".tmp");
                    try {
                        fileOutputStream2 = new FileOutputStream(file);
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        bufferedInputStream = bufferedInputStream3;
                        if (th instanceof IOException) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                    file = null;
                }
                try {
                    byte[] bArr = new byte[10240];
                    int i4 = 0;
                    while (true) {
                        int read = bufferedInputStream3.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        i4 += read;
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    a(bufferedInputStream3);
                    a(fileOutputStream2);
                    BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        hashMap.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                        bufferedInputStream3 = bufferedInputStream4;
                        contentLength = i4;
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream = fileOutputStream2;
                        bufferedInputStream = bufferedInputStream4;
                        if (th instanceof IOException) {
                            throw th;
                        }
                        throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = fileOutputStream2;
                    bufferedInputStream = bufferedInputStream3;
                    if (th instanceof IOException) {
                    }
                }
            } else {
                fileOutputStream2 = null;
                file = null;
            }
            int i5 = (i3 <= 0 || !z) ? 0 : (int) j;
            int i6 = contentLength + i5;
            cVar.a(i6);
            cVar.a(httpURLConnection.getResponseCode(), hashMap);
            if (bVar != null) {
                bVar.a(i5, i6, null);
            }
            byte[] bArr2 = new byte[10240];
            while (true) {
                int read2 = bufferedInputStream3.read(bArr2);
                if (read2 == -1) {
                    break;
                }
                i5 += read2;
                cVar.a(bArr2, 0, read2);
                if (bVar != null) {
                    bVar.a(i5, i6, null);
                }
            }
            if (bVar != null) {
                bVar.a(i6, i6, null);
            }
            a(cVar);
            a(bufferedInputStream3);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            a(fileOutputStream2);
            if (file != null) {
                file.delete();
                return true;
            }
            return true;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
            file = null;
            bufferedInputStream = bufferedInputStream2;
        }
    }
}
