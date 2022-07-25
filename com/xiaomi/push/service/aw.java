package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
/* loaded from: classes8.dex */
public class aw {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f910a;

        public a(byte[] bArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f910a = bArr;
            this.a = i;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f911a;

        public b(Bitmap bitmap, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f911a = bitmap;
            this.a = j;
        }
    }

    public static int a(Context context, InputStream inputStream) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, inputStream)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                com.xiaomi.channel.commonutils.logger.b.m89a("decode dimension failed for bitmap.");
                return 1;
            }
            int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
            int i2 = options.outWidth;
            if (i2 <= round || (i = options.outHeight) <= round) {
                return 1;
            }
            return Math.min(i2 / round, i / round);
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x002f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0031 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable, java.io.InputStream] */
    public static Bitmap a(Context context, String str) {
        ?? r1;
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = (r1 = interceptable).invokeLL(65537, null, context, str)) != null) {
            return (Bitmap) invokeLL.objValue;
        }
        Uri parse = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                r1 = context.getContentResolver().openInputStream(parse);
            } catch (Throwable th) {
                th = th;
                r0 = context;
            }
        } catch (IOException e) {
            e = e;
            inputStream = null;
            r1 = 0;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
        }
        try {
            int a2 = a(context, (InputStream) r1);
            inputStream = context.getContentResolver().openInputStream(parse);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                com.xiaomi.push.ab.a(inputStream);
                com.xiaomi.push.ab.a((Closeable) r1);
                return decodeStream;
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.ab.a(inputStream);
                com.xiaomi.push.ab.a((Closeable) r1);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.ab.a((Closeable) r0);
            com.xiaomi.push.ab.a((Closeable) r1);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e1, code lost:
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e3, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0100, code lost:
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0103, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0105: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:66:0x0105 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String str, boolean z) {
        InterceptResult invokeLZ;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) != null) {
            return (a) invokeLZ.objValue;
        }
        Closeable closeable2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
            }
        } catch (SocketTimeoutException unused) {
            httpURLConnection = null;
            inputStream = null;
        } catch (IOException e) {
            e = e;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            if (z && contentLength > 102400) {
                com.xiaomi.channel.commonutils.logger.b.m89a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                com.xiaomi.push.ab.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                com.xiaomi.channel.commonutils.logger.b.m89a("Invalid Http Response Code " + responseCode + " received");
                com.xiaomi.push.ab.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = z ? 102400 : 2048000;
                byte[] bArr = new byte[1024];
                while (i > 0) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    i -= read;
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (i <= 0) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("length 102400 exhausted.");
                    a aVar = new a(null, 102400);
                    com.xiaomi.push.ab.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a aVar2 = new a(byteArray, byteArray.length);
                com.xiaomi.push.ab.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return aVar2;
            } catch (SocketTimeoutException unused2) {
                com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
                com.xiaomi.push.ab.a(inputStream);
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.ab.a(inputStream);
            }
        } catch (SocketTimeoutException unused3) {
            inputStream = null;
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.ab.a(closeable2);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static b a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(65539, null, context, str, z)) != null) {
            return (b) invokeLLZ.objValue;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        Bitmap b2 = b(context, str);
        if (b2 != null) {
            bVar.f911a = b2;
            return bVar;
        }
        try {
            try {
                a2 = a(str, z);
            } catch (Exception e) {
                e = e;
            }
            if (a2 == null) {
                com.xiaomi.push.ab.a((Closeable) null);
                return bVar;
            }
            bVar.a = a2.a;
            byte[] bArr = a2.f910a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f911a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.ab.a(byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.push.ab.a(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f911a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f910a, str);
            com.xiaomi.push.ab.a(byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
            if (file.exists()) {
                if (a == 0) {
                    a = com.xiaomi.push.aa.a(file);
                }
                if (a > 15728640) {
                    try {
                        File[] listFiles = file.listFiles();
                        for (int i = 0; i < listFiles.length; i++) {
                            if (!listFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                                listFiles[i].delete();
                            }
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                    a = 0L;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, bArr, str) == null) {
            if (bArr == null) {
                com.xiaomi.channel.commonutils.logger.b.m89a("cannot save small icon cause bitmap is null");
                return;
            }
            a(context);
            File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, com.xiaomi.push.bp.a(str));
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file2);
                try {
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    com.xiaomi.push.ab.a(bufferedOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.ab.a(bufferedOutputStream2);
                    com.xiaomi.push.ab.a(fileOutputStream);
                    if (a != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    com.xiaomi.push.ab.a(bufferedOutputStream2);
                    com.xiaomi.push.ab.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            com.xiaomi.push.ab.a(fileOutputStream);
            if (a != 0) {
                a = com.xiaomi.push.aa.a(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
            }
        }
    }

    public static Bitmap b(Context context, String str) {
        InterceptResult invokeLL;
        Throwable th;
        FileInputStream fileInputStream;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", com.xiaomi.push.bp.a(str));
            FileInputStream fileInputStream2 = null;
            Bitmap bitmap2 = null;
            fileInputStream2 = null;
            if (file.exists()) {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e) {
                        e = e;
                        bitmap = null;
                    }
                } catch (Throwable th2) {
                    FileInputStream fileInputStream3 = fileInputStream2;
                    th = th2;
                    fileInputStream = fileInputStream3;
                }
                try {
                    bitmap2 = BitmapFactory.decodeStream(fileInputStream);
                    file.setLastModified(System.currentTimeMillis());
                    com.xiaomi.push.ab.a(fileInputStream);
                    return bitmap2;
                } catch (Exception e2) {
                    e = e2;
                    Bitmap bitmap3 = bitmap2;
                    fileInputStream2 = fileInputStream;
                    bitmap = bitmap3;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.ab.a(fileInputStream2);
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    com.xiaomi.push.ab.a(fileInputStream);
                    throw th;
                }
            }
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }
}
