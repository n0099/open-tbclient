package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f74956a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f74957b;

    /* renamed from: c  reason: collision with root package name */
    public PM.a.b f74958c;

    /* renamed from: d  reason: collision with root package name */
    public Executor f74959d;

    /* loaded from: classes10.dex */
    public class a implements NetworkCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f74960a;

        /* renamed from: b  reason: collision with root package name */
        public final int f74961b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ b f74962c;

        public a(b bVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74962c = bVar;
            this.f74960a = str;
            this.f74961b = i2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x003d */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x005e */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r6v0, types: [com.qq.e.comm.net.rr.Response, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStream] */
        public static String a(Response response, File file) {
            InterceptResult invokeLL;
            ?? r3;
            FileOutputStream fileOutputStream;
            MessageDigest messageDigest;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = (r3 = interceptable).invokeLL(65537, null, response, file)) != null) {
                return (String) invokeLL.objValue;
            }
            InputStream inputStream = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    response = response.getStreamContent();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    Interceptable interceptable2 = null;
                    inputStream = response;
                    r3 = interceptable2;
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose((OutputStream) r3);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = response.read(bArr);
                        if (read <= 0) {
                            FileUtil.tryClose((InputStream) response);
                            FileUtil.tryClose(fileOutputStream);
                            String byteArrayToHexString = Md5Util.byteArrayToHexString(messageDigest.digest());
                            FileUtil.tryClose((InputStream) response);
                            FileUtil.tryClose(fileOutputStream);
                            return byteArrayToHexString;
                        }
                        messageDigest.update(bArr, 0, read);
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e4) {
                    e = e4;
                    GDTLogger.e("更新插件出现异常", e);
                    FileUtil.tryClose((InputStream) response);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    GDTLogger.e("更新插件出现异常", e);
                    FileUtil.tryClose((InputStream) response);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                }
            } catch (IOException e6) {
                e = e6;
                response = 0;
                fileOutputStream = null;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                response = 0;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                r3 = 0;
                FileUtil.tryClose(inputStream);
                FileUtil.tryClose((OutputStream) r3);
                throw th;
            }
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f74962c.f74958c == null) {
                return;
            }
            this.f74962c.f74958c.b();
        }

        private boolean a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, file)) == null) {
                try {
                    StringUtil.writeTo(this.f74961b + "#####" + this.f74960a, file);
                    return true;
                } catch (IOException unused) {
                    GDTLogger.d("IOException While Update Plugin");
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public final void onException(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                GDTLogger.w("更新插件出现异常", exc);
                a();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:6:0x0010, B:8:0x0036, B:10:0x003c, B:12:0x004c, B:19:0x0063, B:21:0x007c, B:22:0x0086), top: B:35:0x0010 }] */
        @Override // com.qq.e.comm.net.NetworkCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onResponse(Request request, Response response) {
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, response) == null) {
                if (response.getStatusCode() != 200) {
                    GDTLogger.d("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
                    a();
                    return;
                }
                try {
                    try {
                        File c2 = d.c(this.f74962c.f74957b);
                        File f2 = d.f(this.f74962c.f74957b);
                        String a2 = a(response, c2);
                        boolean z = true;
                        if (com.qq.e.comm.util.a.a().b(this.f74960a, a2)) {
                            if (a(f2)) {
                                if (FileUtil.renameTo(c2, d.d(this.f74962c.f74957b)) && FileUtil.renameTo(f2, d.g(this.f74962c.f74957b))) {
                                    GDTLogger.d("PluginUpdateSucc:" + z);
                                    if (this.f74962c.f74958c != null) {
                                        this.f74962c.f74958c.a();
                                    }
                                }
                            }
                            z = false;
                            GDTLogger.d("PluginUpdateSucc:" + z);
                            if (this.f74962c.f74958c != null) {
                            }
                        } else {
                            c2.delete();
                            GDTLogger.d(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", this.f74960a, a2));
                            a();
                        }
                        sb = new StringBuilder("TIMESTAMP_AFTER_DOWNPLUGIN:");
                    } catch (Throwable unused) {
                        GDTLogger.d("UnknownException While Update Plugin");
                        a();
                        sb = new StringBuilder("TIMESTAMP_AFTER_DOWNPLUGIN:");
                    }
                    sb.append(System.nanoTime());
                    sb.append(";sig=");
                    sb.append(this.f74960a);
                    GDTLogger.d(sb.toString());
                } catch (Throwable th) {
                    GDTLogger.d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.f74960a);
                    throw th;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(151737136, "Lcom/qq/e/comm/managers/plugin/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(151737136, "Lcom/qq/e/comm/managers/plugin/b;");
                return;
            }
        }
        f74956a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    }

    public b(Context context, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74957b = context.getApplicationContext();
        this.f74959d = executor;
    }

    public final void a(PM.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f74958c = bVar;
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        Matcher matcher = f74956a.matcher(str2);
        boolean z = true;
        int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
        if (parseInteger < 1250) {
            GDTLogger.i("online plugin version is smaller than asset plugin version" + parseInteger + ",1250.download give up");
            z = false;
        }
        if (z) {
            GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
            NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(this, str, parseInteger), this.f74959d);
        }
    }
}
