package d.a.n0.z0;

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
    public Activity f54850a;

    /* renamed from: b  reason: collision with root package name */
    public String f54851b;

    /* renamed from: d  reason: collision with root package name */
    public a f54853d;

    /* renamed from: e  reason: collision with root package name */
    public String f54854e;

    /* renamed from: f  reason: collision with root package name */
    public String f54855f;

    /* renamed from: g  reason: collision with root package name */
    public File f54856g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54857h;

    /* renamed from: c  reason: collision with root package name */
    public int f54852c = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54858i = true;
    public boolean j = false;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract void onError(int i2, String str);

        public abstract void onSuccess(String str);
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f54859a;

        /* renamed from: b  reason: collision with root package name */
        public String f54860b;

        public b(q qVar, boolean z, String str) {
            this.f54859a = z;
            this.f54860b = str;
        }

        public String a() {
            return this.f54860b;
        }

        public boolean b() {
            return this.f54859a;
        }
    }

    public q(Activity activity, String str, a aVar) {
        this.f54850a = activity;
        this.f54851b = str;
        this.f54853d = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public b doInBackground(String... strArr) {
        if (TextUtils.isEmpty(this.f54851b)) {
            return new b(this, false, "url is null");
        }
        if (!j()) {
            return new b(this, false, "make file error");
        }
        if (!this.f54857h) {
            if (!d()) {
                return new b(this, false, "download error");
            }
        } else if (!n()) {
            return new b(this, false, "decode base64 error");
        }
        return new b(this, true, null);
    }

    public final boolean c(String str, String str2, int i2) {
        int b2 = d.a.c.c.j.b.d().b().b();
        int b3 = d.a.c.c.j.b.d().c().b();
        boolean z = false;
        for (int i3 = 0; i3 < i2; i3++) {
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
        return c(this.f54851b, this.f54855f, 3);
    }

    public final HttpURLConnection e(URL url, int i2, int i3) throws SocketException, ProtocolException {
        String c2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (d.a.c.e.p.j.z()) {
            if (d.a.c.e.p.j.x() && (c2 = d.a.c.e.p.j.c()) != null && c2.length() > 0) {
                if (d.a.c.e.p.j.F(c2) && d.a.c.e.p.j.D()) {
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
                    httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, d.a.c.e.p.j.d())));
                }
                httpURLConnection2 = httpURLConnection;
            }
            if (httpURLConnection2 == null) {
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(i2);
                httpURLConnection2.setReadTimeout(i3);
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
        d.a.c.e.p.f.k(str);
        return new File(str);
    }

    public q h(boolean z) {
        this.f54857h = z;
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
            if (this.f54852c == 1) {
                FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
                FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/");
                FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                externalStoragePublicDirectory = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
            } else {
                externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            }
            if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                String absolutePath = externalStoragePublicDirectory.getAbsolutePath();
                this.f54854e = absolutePath;
                if (!TextUtils.isEmpty(absolutePath) && !this.f54854e.endsWith("/")) {
                    this.f54854e += "/";
                }
            } else {
                this.f54854e = Environment.getExternalStorageDirectory().getPath() + "/tieba/";
            }
            File file = new File(this.f54854e);
            if (!file.exists()) {
                file.mkdir();
            }
            this.f54855f = this.f54854e + (this.f54852c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(this.f54851b);
            File file2 = new File(this.f54855f);
            this.f54856g = file2;
            if (file2.exists()) {
                this.f54856g.delete();
            }
            if (this.f54856g.exists()) {
                return true;
            }
            this.f54856g.createNewFile();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void k() {
        if (this.f54856g != null) {
            TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.f54856g)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public void onPostExecute(b bVar) {
        super.onPostExecute(bVar);
        if (bVar == null) {
            a aVar = this.f54853d;
            if (aVar != null) {
                aVar.onError(-2, "error");
            }
        } else if (!bVar.b()) {
            a aVar2 = this.f54853d;
            if (aVar2 != null) {
                aVar2.onError(-1, bVar.a());
            }
        } else {
            if (this.j && i(new File(this.f54855f))) {
                String replace = this.f54855f.replace(f(this.f54855f), ".gif");
                this.f54856g.renameTo(new File(replace));
                this.f54855f = replace;
                this.f54856g = new File(this.f54855f);
            }
            k();
            a aVar3 = this.f54853d;
            if (aVar3 != null) {
                aVar3.onSuccess(this.f54855f);
            }
        }
    }

    public final boolean m(String str, String str2, int i2, int i3) throws Exception {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        int responseCode;
        InputStream inputStream = null;
        try {
            httpURLConnection = e(new URL(str), i2, i3);
            try {
                fileOutputStream = new FileOutputStream(g(str2), true);
                try {
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 302) {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        d.a.c.e.m.a.e(httpURLConnection);
                        try {
                            if (this.f54856g != null) {
                                this.f54856g.delete();
                            }
                        } catch (Exception unused) {
                        }
                        this.f54855f = this.f54854e + (this.f54852c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(headerField);
                        File file = new File(this.f54855f);
                        this.f54856g = file;
                        if (file.exists()) {
                            this.f54856g.delete();
                        }
                        if (!this.f54856g.exists()) {
                            this.f54856g.createNewFile();
                        }
                        d.a.c.e.m.a.d(fileOutputStream);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.f54856g, true);
                        try {
                            httpURLConnection = e(new URL(headerField), i2, i3);
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
            if ((headerField2 != null ? d.a.c.e.m.b.d(headerField2, 0) : 0) != 0 || !this.f54858i) {
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
                            d.a.c.e.m.a.c(inputStream);
                            d.a.c.e.m.a.e(httpURLConnection);
                            d.a.c.e.m.a.d(fileOutputStream);
                            return true;
                        } catch (Exception unused3) {
                            throw new FileNotFoundException();
                        }
                    }
                    th = th2;
                    d.a.c.e.m.a.c(inputStream);
                    d.a.c.e.m.a.e(httpURLConnection);
                    d.a.c.e.m.a.d(fileOutputStream);
                    throw th;
                }
            }
        }
        d.a.c.e.m.a.c(null);
        d.a.c.e.m.a.e(httpURLConnection);
        d.a.c.e.m.a.d(fileOutputStream);
        return false;
    }

    public final boolean n() {
        FileOutputStream fileOutputStream;
        String str = this.f54851b;
        byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1, this.f54851b.length()), 0);
        for (int i2 = 0; i2 < decode.length; i2++) {
            if (decode[i2] < 0) {
                decode[i2] = (byte) (decode[i2] + 256);
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.f54856g, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            fileOutputStream.write(decode);
            fileOutputStream.flush();
            d.a.c.e.m.a.d(fileOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.a.c.e.m.a.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.c.e.m.a.d(fileOutputStream2);
            throw th;
        }
    }

    public void o(boolean z) {
        this.f54858i = z;
    }

    public void p(int i2) {
        this.f54852c = i2;
    }

    public void q(boolean z) {
        this.j = z;
    }
}
