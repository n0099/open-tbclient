package com.qq.e.comm.managers.plugin;

import android.content.Context;
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
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f35436a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");

    /* renamed from: b  reason: collision with root package name */
    public final Context f35437b;

    /* renamed from: c  reason: collision with root package name */
    public PM.a.b f35438c;

    /* renamed from: d  reason: collision with root package name */
    public Executor f35439d;

    /* loaded from: classes7.dex */
    public class a implements NetworkCallBack {

        /* renamed from: a  reason: collision with root package name */
        public final String f35440a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35441b;

        public a(String str, int i2) {
            this.f35440a = str;
            this.f35441b = i2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0037 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0039 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x005c */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.qq.e.comm.net.rr.Response] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
        public static String a(Response response, File file) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            String str;
            InputStream inputStream;
            MessageDigest messageDigest;
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
                outputStream = null;
                FileUtil.tryClose(inputStream2);
                FileUtil.tryClose(outputStream);
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
                outputStream = null;
                inputStream2 = response;
                FileUtil.tryClose(inputStream2);
                FileUtil.tryClose(outputStream);
                throw th;
            }
        }

        private void a() {
            if (b.this.f35438c != null) {
                b.this.f35438c.b();
            }
        }

        private boolean a(File file) {
            try {
                StringUtil.writeTo(this.f35441b + "#####" + this.f35440a, file);
                return true;
            } catch (IOException e2) {
                GDTLogger.e("IOException While Update Plugin", e2);
                return false;
            }
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public final void onException(Exception exc) {
            GDTLogger.w("Exception While Update Plugin", exc);
            a();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0078 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:4:0x000c, B:6:0x0032, B:8:0x0038, B:10:0x0048, B:17:0x005f, B:19:0x0078, B:20:0x0082), top: B:31:0x000c }] */
        @Override // com.qq.e.comm.net.NetworkCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onResponse(Request request, Response response) {
            StringBuilder sb;
            if (response.getStatusCode() != 200) {
                GDTLogger.report("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
                a();
                return;
            }
            try {
                File c2 = d.c(b.this.f35437b);
                File f2 = d.f(b.this.f35437b);
                String a2 = a(response, c2);
                boolean z = true;
                if (com.qq.e.comm.util.a.a().b(this.f35440a, a2)) {
                    if (a(f2)) {
                        if (FileUtil.renameTo(c2, d.d(b.this.f35437b)) && FileUtil.renameTo(f2, d.g(b.this.f35437b))) {
                            GDTLogger.d("PluginUpdateSucc:" + z);
                            if (b.this.f35438c != null) {
                                b.this.f35438c.a();
                            }
                        }
                    }
                    z = false;
                    GDTLogger.d("PluginUpdateSucc:" + z);
                    if (b.this.f35438c != null) {
                    }
                } else {
                    c2.delete();
                    GDTLogger.report(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", this.f35440a, a2));
                    a();
                }
                sb = new StringBuilder("TIMESTAMP_AFTER_DOWNPLUGIN:");
            } catch (Throwable th) {
                try {
                    GDTLogger.e("UnknownException While Update Plugin", th);
                    a();
                    sb = new StringBuilder("TIMESTAMP_AFTER_DOWNPLUGIN:");
                } catch (Throwable th2) {
                    GDTLogger.d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.f35440a);
                    throw th2;
                }
            }
            sb.append(System.nanoTime());
            sb.append(";sig=");
            sb.append(this.f35440a);
            GDTLogger.d(sb.toString());
        }
    }

    public b(Context context, Executor executor) {
        this.f35437b = context.getApplicationContext();
        this.f35439d = executor;
    }

    public final void a(PM.a.b bVar) {
        this.f35438c = bVar;
    }

    public final void a(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        Matcher matcher = f35436a.matcher(str2);
        boolean z = true;
        int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
        if (parseInteger < 1203) {
            GDTLogger.i("online plugin version is smaller than asset plugin version" + parseInteger + ",1203.download give up");
            z = false;
        }
        if (z) {
            GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
            NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(str, parseInteger), this.f35439d);
        }
    }
}
