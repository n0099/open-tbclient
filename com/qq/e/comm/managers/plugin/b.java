package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
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
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f7567a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    private final Context b;
    private PM.a.b c;
    private Executor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements NetworkCallBack {

        /* renamed from: a  reason: collision with root package name */
        private final String f7568a;
        private final int b;

        public a(String str, int i) {
            this.f7568a = str;
            this.b = i;
        }

        private static String a(Response response, File file) {
            OutputStream outputStream;
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            MessageDigest messageDigest;
            String str = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                    inputStream = response.getStreamContent();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                            fileOutputStream.write(bArr, 0, read);
                        }
                        FileUtil.tryClose(inputStream);
                        FileUtil.tryClose(fileOutputStream);
                        str = Md5Util.byteArrayToHexString(messageDigest.digest());
                        FileUtil.tryClose(inputStream);
                        FileUtil.tryClose(fileOutputStream);
                    } catch (IOException e) {
                        e = e;
                        GDTLogger.e("IOException While Update Plugin", e);
                        FileUtil.tryClose(inputStream);
                        FileUtil.tryClose(fileOutputStream);
                        return str;
                    } catch (NoSuchAlgorithmException e2) {
                        e = e2;
                        GDTLogger.e("MD5SUMException While Update Plugin", e);
                        FileUtil.tryClose(inputStream);
                        FileUtil.tryClose(fileOutputStream);
                        return str;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(outputStream);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = null;
                inputStream = null;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                inputStream = null;
            }
            return str;
        }

        private void a() {
            if (b.this.c != null) {
                b.this.c.b();
            }
        }

        private boolean a(File file) {
            try {
                StringUtil.writeTo(this.b + "#####" + this.f7568a, file);
                return true;
            } catch (IOException e) {
                GDTLogger.e("IOException While Update Plugin", e);
                return false;
            }
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public final void onException(Exception exc) {
            GDTLogger.w("Exception While Update Plugin", exc);
            a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
            if ((com.qq.e.comm.util.FileUtil.renameTo(r2, com.qq.e.comm.managers.plugin.d.d(r7.c.b)) && com.qq.e.comm.util.FileUtil.renameTo(r3, com.qq.e.comm.managers.plugin.d.g(r7.c.b))) != false) goto L17;
         */
        @Override // com.qq.e.comm.net.NetworkCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onResponse(Request request, Response response) {
            boolean z = true;
            if (response.getStatusCode() != 200) {
                GDTLogger.report("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
                a();
                return;
            }
            try {
                File c = d.c(b.this.b);
                File f = d.f(b.this.b);
                String a2 = a(response, c);
                if (com.qq.e.comm.util.a.a().b(this.f7568a, a2)) {
                    if (a(f)) {
                    }
                    z = false;
                    GDTLogger.d("PluginUpdateSucc:" + z);
                    if (b.this.c != null) {
                        b.this.c.a();
                    }
                } else {
                    c.delete();
                    GDTLogger.report(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", this.f7568a, a2));
                    a();
                }
            } catch (Throwable th) {
                try {
                    GDTLogger.e("UnknownException While Update Plugin", th);
                    a();
                } finally {
                    GDTLogger.d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.f7568a);
                }
            }
        }
    }

    public b(Context context, Executor executor) {
        this.b = context.getApplicationContext();
        this.d = executor;
    }

    public final void a(PM.a.b bVar) {
        this.c = bVar;
    }

    public final void a(String str, String str2) {
        boolean z;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        Matcher matcher = f7567a.matcher(str2);
        int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
        if (parseInteger < 1180) {
            GDTLogger.i("online plugin version is smaller than asset plugin version" + parseInteger + ",1180.download give up");
            z = false;
        } else {
            z = true;
        }
        if (z) {
            GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
            NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(str, parseInteger), this.d);
        }
    }
}
