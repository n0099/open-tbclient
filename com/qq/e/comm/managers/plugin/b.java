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
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f38177a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f38178b;

    /* renamed from: c  reason: collision with root package name */
    public PM.a.b f38179c;

    /* renamed from: d  reason: collision with root package name */
    public Executor f38180d;

    /* loaded from: classes6.dex */
    public class a implements NetworkCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f38181a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38182b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ b f38183c;

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
            this.f38183c = bVar;
            this.f38181a = str;
            this.f38182b = i2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x003b */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x003d */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0060 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.qq.e.comm.net.rr.Response, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
        public static String a(Response response, File file) {
            InterceptResult invokeLL;
            ?? r2;
            FileOutputStream fileOutputStream;
            String str;
            InputStream inputStream;
            MessageDigest messageDigest;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = (r2 = interceptable).invokeLL(65537, null, response, file)) != null) {
                return (String) invokeLL.objValue;
            }
            InputStream inputStream2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    response = response.getStreamContent();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
                response = null;
                fileOutputStream = null;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                response = null;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                FileUtil.tryClose(inputStream2);
                FileUtil.tryClose((OutputStream) r2);
                throw th;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
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
                    str = "IOException While Update Plugin";
                    inputStream = response;
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    str = "MD5SUMException While Update Plugin";
                    inputStream = response;
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream = null;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                Interceptable interceptable2 = null;
                inputStream2 = response;
                r2 = interceptable2;
                FileUtil.tryClose(inputStream2);
                FileUtil.tryClose((OutputStream) r2);
                throw th;
            }
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f38183c.f38179c == null) {
                return;
            }
            this.f38183c.f38179c.b();
        }

        private boolean a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, file)) == null) {
                try {
                    StringUtil.writeTo(this.f38182b + "#####" + this.f38181a, file);
                    return true;
                } catch (IOException e2) {
                    GDTLogger.e("IOException While Update Plugin", e2);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public final void onException(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                GDTLogger.w("Exception While Update Plugin", exc);
                a();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:6:0x0010, B:8:0x0036, B:10:0x003c, B:12:0x004c, B:19:0x0063, B:21:0x007c, B:22:0x0086), top: B:36:0x0010 }] */
        @Override // com.qq.e.comm.net.NetworkCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onResponse(Request request, Response response) {
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, response) == null) {
                if (response.getStatusCode() != 200) {
                    GDTLogger.report("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
                    a();
                    return;
                }
                try {
                    File c2 = d.c(this.f38183c.f38178b);
                    File f2 = d.f(this.f38183c.f38178b);
                    String a2 = a(response, c2);
                    boolean z = true;
                    if (com.qq.e.comm.util.a.a().b(this.f38181a, a2)) {
                        if (a(f2)) {
                            if (FileUtil.renameTo(c2, d.d(this.f38183c.f38178b)) && FileUtil.renameTo(f2, d.g(this.f38183c.f38178b))) {
                                GDTLogger.d("PluginUpdateSucc:" + z);
                                if (this.f38183c.f38179c != null) {
                                    this.f38183c.f38179c.a();
                                }
                            }
                        }
                        z = false;
                        GDTLogger.d("PluginUpdateSucc:" + z);
                        if (this.f38183c.f38179c != null) {
                        }
                    } else {
                        c2.delete();
                        GDTLogger.report(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", this.f38181a, a2));
                        a();
                    }
                    sb = new StringBuilder("TIMESTAMP_AFTER_DOWNPLUGIN:");
                } catch (Throwable th) {
                    try {
                        GDTLogger.e("UnknownException While Update Plugin", th);
                        a();
                        sb = new StringBuilder("TIMESTAMP_AFTER_DOWNPLUGIN:");
                    } catch (Throwable th2) {
                        GDTLogger.d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.f38181a);
                        throw th2;
                    }
                }
                sb.append(System.nanoTime());
                sb.append(";sig=");
                sb.append(this.f38181a);
                GDTLogger.d(sb.toString());
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
        f38177a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
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
        this.f38178b = context.getApplicationContext();
        this.f38180d = executor;
    }

    public final void a(PM.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f38179c = bVar;
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        Matcher matcher = f38177a.matcher(str2);
        boolean z = true;
        int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
        if (parseInteger < 1241) {
            GDTLogger.i("online plugin version is smaller than asset plugin version" + parseInteger + ",1241.download give up");
            z = false;
        }
        if (z) {
            GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
            NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(this, str, parseInteger), this.f38180d);
        }
    }
}
