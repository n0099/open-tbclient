package d.b.h0.z0;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.UUID;
/* loaded from: classes3.dex */
public class q extends BdAsyncTask<String, String, b> {

    /* renamed from: a  reason: collision with root package name */
    public Activity f51731a;

    /* renamed from: b  reason: collision with root package name */
    public String f51732b;

    /* renamed from: d  reason: collision with root package name */
    public a f51734d;

    /* renamed from: e  reason: collision with root package name */
    public String f51735e;

    /* renamed from: f  reason: collision with root package name */
    public String f51736f;

    /* renamed from: g  reason: collision with root package name */
    public File f51737g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51738h;

    /* renamed from: c  reason: collision with root package name */
    public int f51733c = 0;
    public boolean i = true;
    public boolean j = false;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract void onError(int i, String str);

        public abstract void onSuccess(String str);
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51739a;

        /* renamed from: b  reason: collision with root package name */
        public String f51740b;

        public b(q qVar, boolean z, String str) {
            this.f51739a = z;
            this.f51740b = str;
        }

        public String a() {
            return this.f51740b;
        }

        public boolean b() {
            return this.f51739a;
        }
    }

    public q(Activity activity, String str, a aVar) {
        this.f51731a = activity;
        this.f51732b = str;
        this.f51734d = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public b doInBackground(String... strArr) {
        if (TextUtils.isEmpty(this.f51732b)) {
            return new b(this, false, "url is null");
        }
        if (!j()) {
            return new b(this, false, "make file error");
        }
        if (!this.f51738h) {
            if (!d()) {
                return new b(this, false, "download error");
            }
        } else if (!n()) {
            return new b(this, false, "decode base64 error");
        }
        return new b(this, true, null);
    }

    public final boolean c(String str, String str2, int i) {
        int b2 = d.b.b.c.j.b.d().b().b();
        int b3 = d.b.b.c.j.b.d().c().b();
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            try {
                z = m(str, str2, b3, b2);
                break;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    public final boolean d() {
        return c(this.f51732b, this.f51736f, 3);
    }

    public final HttpURLConnection e(URL url, int i, int i2) throws SocketException, ProtocolException {
        String c2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (d.b.b.e.p.j.z()) {
            if (d.b.b.e.p.j.x() && (c2 = d.b.b.e.p.j.c()) != null && c2.length() > 0) {
                if (d.b.b.e.p.j.F(c2) && d.b.b.e.p.j.D()) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("http://");
                    sb.append(c2);
                    String file = url.getFile();
                    if (file != null && file.startsWith("?")) {
                        sb.append("/");
                    }
                    sb.append(file);
                    httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, d.b.b.e.p.j.d())));
                }
                httpURLConnection2 = httpURLConnection;
            }
            if (httpURLConnection2 == null) {
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(i);
                httpURLConnection2.setReadTimeout(i2);
                return httpURLConnection2;
            }
            throw new SocketException();
        }
        return null;
    }

    public final String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        if (str.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)) {
            return EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
        }
        if (str.endsWith(".PNG")) {
            return ".PNG";
        }
        if (str.endsWith(".jpg")) {
            return ".jpg";
        }
        if (str.endsWith(".jpeg")) {
            return ".jpeg";
        }
        if (str.endsWith(".JPEG")) {
            return ".JPEG";
        }
        if (str.endsWith(".gif")) {
            return ".gif";
        }
        if (str.endsWith(".GIF")) {
            return ".GIF";
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        if (split != null && split.length > 0) {
            String str2 = split[split.length - 1];
            if (str2.startsWith("png")) {
                return EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            }
            if (str2.startsWith("PNG")) {
                return ".PNG";
            }
            if (str2.startsWith("jpg")) {
                return ".jpg";
            }
            if (str2.startsWith("jpeg")) {
                return ".jpeg";
            }
            if (str2.startsWith("JPEG")) {
                return ".JPEG";
            }
            if (str2.startsWith("gif")) {
                return ".gif";
            }
            if (str2.startsWith("GIF")) {
                return ".GIF";
            }
        }
        return ".jpg";
    }

    public final File g(String str) {
        d.b.b.e.p.f.k(str);
        return new File(str);
    }

    public q h(boolean z) {
        this.f51738h = z;
        return this;
    }

    public final boolean i(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.skip(fileInputStream.available() - 1);
            int[] iArr = {fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read()};
            fileInputStream.close();
            if (iArr[0] == 71 && iArr[1] == 73 && iArr[2] == 70 && iArr[3] == 56) {
                return iArr[4] == 59;
            }
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final boolean j() {
        File externalStoragePublicDirectory;
        try {
            if (this.f51733c == 1) {
                FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
                FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/");
                FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                externalStoragePublicDirectory = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
            } else {
                externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            }
            if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                String absolutePath = externalStoragePublicDirectory.getAbsolutePath();
                this.f51735e = absolutePath;
                if (!TextUtils.isEmpty(absolutePath) && !this.f51735e.endsWith("/")) {
                    this.f51735e += "/";
                }
            } else {
                this.f51735e = Environment.getExternalStorageDirectory().getPath() + "/tieba/";
            }
            File file = new File(this.f51735e);
            if (!file.exists()) {
                file.mkdir();
            }
            this.f51736f = this.f51735e + (this.f51733c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(this.f51732b);
            File file2 = new File(this.f51736f);
            this.f51737g = file2;
            if (file2.exists()) {
                this.f51737g.delete();
            }
            if (this.f51737g.exists()) {
                return true;
            }
            this.f51737g.createNewFile();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void k() {
        if (this.f51737g != null) {
            TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.f51737g)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public void onPostExecute(b bVar) {
        super.onPostExecute(bVar);
        if (bVar == null) {
            a aVar = this.f51734d;
            if (aVar != null) {
                aVar.onError(-2, "error");
            }
        } else if (!bVar.b()) {
            a aVar2 = this.f51734d;
            if (aVar2 != null) {
                aVar2.onError(-1, bVar.a());
            }
        } else {
            if (this.j && i(new File(this.f51736f))) {
                String replace = this.f51736f.replace(f(this.f51736f), ".gif");
                this.f51737g.renameTo(new File(replace));
                this.f51736f = replace;
                this.f51737g = new File(this.f51736f);
            }
            k();
            a aVar3 = this.f51734d;
            if (aVar3 != null) {
                aVar3.onSuccess(this.f51736f);
            }
        }
    }

    public final boolean m(String str, String str2, int i, int i2) throws Exception {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        int responseCode;
        InputStream inputStream = null;
        try {
            httpURLConnection = e(new URL(str), i, i2);
            try {
                fileOutputStream = new FileOutputStream(g(str2), true);
                try {
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 302) {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        d.b.b.e.m.a.e(httpURLConnection);
                        try {
                            if (this.f51737g != null) {
                                this.f51737g.delete();
                            }
                        } catch (Exception unused) {
                        }
                        this.f51736f = this.f51735e + (this.f51733c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(headerField);
                        File file = new File(this.f51736f);
                        this.f51737g = file;
                        if (file.exists()) {
                            this.f51737g.delete();
                        }
                        if (!this.f51737g.exists()) {
                            this.f51737g.createNewFile();
                        }
                        d.b.b.e.m.a.d(fileOutputStream);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.f51737g, true);
                        try {
                            httpURLConnection = e(new URL(headerField), i, i2);
                            httpURLConnection.connect();
                            responseCode = httpURLConnection.getResponseCode();
                            fileOutputStream = fileOutputStream2;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            fileOutputStream = null;
        }
        if (responseCode == 200) {
            String headerField2 = httpURLConnection.getHeaderField("Content-Length");
            if ((headerField2 != null ? d.b.b.e.m.b.d(headerField2, 0) : 0) != 0 || !this.i) {
                inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        try {
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Exception unused2) {
                            throw new FileNotFoundException();
                        }
                    } else {
                        try {
                            fileOutputStream.flush();
                            d.b.b.e.m.a.c(inputStream);
                            d.b.b.e.m.a.e(httpURLConnection);
                            d.b.b.e.m.a.d(fileOutputStream);
                            return true;
                        } catch (Exception unused3) {
                            throw new FileNotFoundException();
                        }
                    }
                    th = th2;
                    d.b.b.e.m.a.c(inputStream);
                    d.b.b.e.m.a.e(httpURLConnection);
                    d.b.b.e.m.a.d(fileOutputStream);
                    throw th;
                }
            }
        }
        d.b.b.e.m.a.c(null);
        d.b.b.e.m.a.e(httpURLConnection);
        d.b.b.e.m.a.d(fileOutputStream);
        return false;
    }

    public final boolean n() {
        FileOutputStream fileOutputStream;
        String str = this.f51732b;
        byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1, this.f51732b.length()), 0);
        for (int i = 0; i < decode.length; i++) {
            if (decode[i] < 0) {
                decode[i] = (byte) (decode[i] + 256);
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.f51737g, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            fileOutputStream.write(decode);
            fileOutputStream.flush();
            d.b.b.e.m.a.d(fileOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.b.b.e.m.a.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.b.b.e.m.a.d(fileOutputStream2);
            throw th;
        }
    }

    public void o(boolean z) {
        this.i = z;
    }

    public void p(int i) {
        this.f51733c = i;
    }

    public void q(boolean z) {
        this.j = z;
    }
}
