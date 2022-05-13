package com.repackage;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class up9 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List b;
    public aq9 c;
    public Context d;
    public boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up9(Context context, String str, List list, aq9 aq9Var) {
        super("resc");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, list, aq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = context;
        this.a = str;
        this.b = list;
        this.c = aq9Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0011 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f6 A[Catch: Exception -> 0x00fa, TRY_ENTER, TryCatch #4 {Exception -> 0x00fa, blocks: (B:36:0x00c2, B:35:0x00bc, B:59:0x00f6, B:62:0x00ff), top: B:86:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ff A[Catch: Exception -> 0x00fa, TRY_LEAVE, TryCatch #4 {Exception -> 0x00fa, blocks: (B:36:0x00c2, B:35:0x00bc, B:59:0x00f6, B:62:0x00ff), top: B:86:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010d A[Catch: Exception -> 0x0115, TryCatch #8 {Exception -> 0x0115, blocks: (B:67:0x0108, B:69:0x010d, B:71:0x0112), top: B:90:0x0108 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112 A[Catch: Exception -> 0x0115, TRY_LEAVE, TryCatch #8 {Exception -> 0x0115, blocks: (B:67:0x0108, B:69:0x010d, B:71:0x0112), top: B:90:0x0108 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0064 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Exception e;
        File file;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.b) {
                String str2 = this.a;
                FileOutputStream fileOutputStream = null;
                r6 = null;
                InputStream inputStream2 = null;
                fileOutputStream = null;
                try {
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(str2, String.valueOf(str.hashCode()));
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = null;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = null;
                }
                if (file.exists() && file.isFile()) {
                    if (file.length() == xp9.b(this.d).a(str)) {
                        z = true;
                        if (z) {
                            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                            try {
                                httpURLConnection.setConnectTimeout(3000);
                                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                                httpURLConnection.setReadTimeout(3000);
                                httpURLConnection.connect();
                                long contentLength = httpURLConnection.getContentLength();
                                if (contentLength > 0) {
                                    xp9.b(this.d).c(str, contentLength);
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        inputStream2 = httpURLConnection.getInputStream();
                                        byte[] bArr = new byte[4096];
                                        while (true) {
                                            int read = inputStream2.read(bArr);
                                            if (read != -1) {
                                                fileOutputStream2.write(bArr, 0, read);
                                            } else {
                                                try {
                                                    break;
                                                } catch (Exception unused) {
                                                }
                                            }
                                        }
                                        fileOutputStream2.close();
                                        inputStream2.close();
                                    } catch (Exception e3) {
                                        e = e3;
                                        InputStream inputStream3 = inputStream2;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream = inputStream3;
                                        try {
                                            if (this.c != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection == null) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (Exception unused2) {
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        InputStream inputStream4 = inputStream2;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream = inputStream4;
                                        if (fileOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                } else if (this.c != null) {
                                    this.e = true;
                                    this.c.a(950, str);
                                }
                            } catch (Exception e4) {
                                e = e4;
                                e = e;
                                inputStream = null;
                                if (this.c != null) {
                                    int i = CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE;
                                    if (httpURLConnection != null) {
                                        try {
                                            i = httpURLConnection.getResponseCode();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    this.e = true;
                                    this.c.a(i, e.getMessage());
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection == null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = null;
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                            httpURLConnection.disconnect();
                        }
                    } else {
                        ro9.q(file);
                    }
                }
                z = false;
                if (z) {
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            aq9 aq9Var = this.c;
            if (aq9Var == null || this.e) {
                return;
            }
            tq9 a = xq9.a(aq9Var.a);
            a.c(new br9(aq9Var.b), 200);
            a.k("dr", currentTimeMillis2);
            a.m();
        }
    }
}
