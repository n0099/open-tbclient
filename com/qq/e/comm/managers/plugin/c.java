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
import com.qq.e.comm.constants.Constants;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public f b;
    public Executor c;

    /* loaded from: classes8.dex */
    public class a implements NetworkCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final int b;
        public final /* synthetic */ c c;

        public a(c cVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cVar;
            this.a = str;
            this.b = i;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x003d */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0041 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0043 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0045 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x005e: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:37:0x005e */
        /* JADX WARN: Type inference failed for: r7v0, types: [com.qq.e.comm.net.rr.Response, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
        private String a(Response response, File file) {
            InterceptResult invokeLL;
            Throwable e;
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            MessageDigest messageDigest;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, this, response, file)) != null) {
                return (String) invokeLL.objValue;
            }
            OutputStream outputStream2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    response = response.getStreamContent();
                } catch (Throwable th) {
                    th = th;
                    outputStream2 = outputStream;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                    GDTLogger.e("更新插件出现异常", e);
                    FileUtil.tryClose((InputStream) response);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    fileOutputStream = null;
                    GDTLogger.e("更新插件出现异常", e);
                    FileUtil.tryClose((InputStream) response);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    FileUtil.tryClose((InputStream) response);
                    FileUtil.tryClose(outputStream2);
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
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                response = 0;
            } catch (Throwable th3) {
                th = th3;
                response = 0;
            }
        }

        private void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, this, str) == null) || this.c.b == null) {
                return;
            }
            ((PM.b) this.c.b).a.a();
            com.qq.e.comm.managers.plugin.a.a(new Exception(str), str);
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public void onException(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                GDTLogger.w("更新插件出现异常", exc);
                a(exc.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00a0 A[Catch: all -> 0x00d6, TryCatch #2 {all -> 0x00d6, blocks: (B:6:0x0012, B:8:0x0038, B:9:0x0050, B:13:0x005d, B:15:0x006d, B:22:0x0084, B:24:0x00a0, B:11:0x0055, B:25:0x00ae), top: B:43:0x0012, inners: #1 }] */
        @Override // com.qq.e.comm.net.NetworkCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Request request, Response response) {
            StringBuilder sb;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, response) == null) {
                if (response.getStatusCode() != 200) {
                    GDTLogger.d("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
                    a("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
                    return;
                }
                try {
                    File g = h.g(this.c.a);
                    File h = h.h(this.c.a);
                    String a = a(response, g);
                    boolean z2 = true;
                    if (com.qq.e.comm.util.a.a().a(this.a, a)) {
                        try {
                            StringUtil.writeTo(this.b + "#####" + this.a, h);
                            z = true;
                        } catch (IOException unused) {
                            GDTLogger.d("IOException While Update Plugin");
                            z = false;
                        }
                        if (z) {
                            if (FileUtil.renameTo(g, h.c(this.c.a)) && FileUtil.renameTo(h, h.d(this.c.a))) {
                                GDTLogger.d("PluginUpdateSucc:" + z2);
                                if (this.c.b != null) {
                                    PM.d(((PM.b) this.c.b).a);
                                }
                            }
                        }
                        z2 = false;
                        GDTLogger.d("PluginUpdateSucc:" + z2);
                        if (this.c.b != null) {
                        }
                    } else {
                        g.delete();
                        GDTLogger.d(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", this.a, a));
                        a(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", this.a, a));
                    }
                    sb = new StringBuilder();
                } catch (Throwable th) {
                    try {
                        GDTLogger.d("UnknownException While Update Plugin");
                        a(th.getMessage());
                        sb = new StringBuilder();
                    } catch (Throwable th2) {
                        GDTLogger.d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.a);
                        throw th2;
                    }
                }
                sb.append("TIMESTAMP_AFTER_DOWNPLUGIN:");
                sb.append(System.nanoTime());
                sb.append(";sig=");
                sb.append(this.a);
                GDTLogger.d(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(151737167, "Lcom/qq/e/comm/managers/plugin/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(151737167, "Lcom/qq/e/comm/managers/plugin/c;");
                return;
            }
        }
        d = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    }

    public c(Context context, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.c = executor;
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.b = fVar;
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        Matcher matcher = d.matcher(str2);
        boolean z = true;
        int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
        if (parseInteger < 1292) {
            GDTLogger.i("online plugin version is smaller than asset plugin version" + parseInteger + "," + Constants.PLUGIN.ASSET_PLUGIN_VERSION + ".download give up");
            z = false;
        }
        if (z) {
            GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
            NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(this, str, parseInteger), this.c);
        }
    }
}
