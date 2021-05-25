package d.a.l0.a.l0.m;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import d.a.l0.a.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43330e = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public HttpManager f43331a;

    /* renamed from: b  reason: collision with root package name */
    public String f43332b;

    /* renamed from: c  reason: collision with root package name */
    public String f43333c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.l0.m.a f43334d;

    /* loaded from: classes2.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f43330e) {
                Log.e("ImageDownloader", c.this.f43332b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f43334d != null) {
                c.this.f43334d.fail(-1, c.this.f43332b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            InputStream byteStream;
            String c2;
            if (TextUtils.isEmpty(c.this.f43333c)) {
                if (k.f43199a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口未实现，直接返回");
                    return;
                }
                return;
            }
            byte[] bArr = new byte[2048];
            InputStream inputStream = null;
            try {
                byteStream = response.body().byteStream();
                try {
                    try {
                        c2 = d.a.l0.a.c1.b.f().c(c.this.f43332b);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    file = null;
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                file = null;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            if (TextUtils.isEmpty(c2)) {
                if (k.f43199a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口convertSrc()未实现，直接返回");
                }
                d.a.l0.t.d.d(byteStream);
                d.a.l0.t.d.d(null);
                d.a.l0.t.d.d(response);
                return;
            }
            String str = c.this.f43333c + c2.substring(0, c2.lastIndexOf("/"));
            File file2 = new File(str);
            if (!file2.exists() || !file2.isDirectory()) {
                file2.mkdirs();
            }
            String substring = c2.substring(c2.lastIndexOf("/") + 1);
            file = new File(str, substring + ".bddownload");
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e4) {
                        e = e4;
                        inputStream = byteStream;
                        try {
                            if (c.f43330e) {
                                Log.e("ImageDownloader", c.this.f43332b + " load failed", e);
                            }
                            if (file != null) {
                                file.delete();
                            }
                            if (c.this.f43334d != null) {
                                c.this.f43334d.fail(-1, c.this.f43332b);
                            }
                            d.a.l0.t.d.d(inputStream);
                            d.a.l0.t.d.d(fileOutputStream);
                            d.a.l0.t.d.d(response);
                        } catch (Throwable th3) {
                            th = th3;
                            d.a.l0.t.d.d(inputStream);
                            d.a.l0.t.d.d(fileOutputStream);
                            d.a.l0.t.d.d(response);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = byteStream;
                        d.a.l0.t.d.d(inputStream);
                        d.a.l0.t.d.d(fileOutputStream);
                        d.a.l0.t.d.d(response);
                        throw th;
                    }
                }
                fileOutputStream.flush();
                File file3 = new File(str, substring);
                if (file3.exists() && !file3.isDirectory()) {
                    file3.delete();
                }
                String absolutePath = file3.getAbsolutePath();
                if (file.renameTo(file3)) {
                    if (c.f43330e) {
                        Log.e("ImageDownloader", c.this.f43332b + " load rename success path = " + absolutePath);
                    }
                    if (c.this.f43334d != null) {
                        c.this.f43334d.a(c.this.f43332b, absolutePath);
                    }
                } else {
                    if (c.f43330e) {
                        Log.e("ImageDownloader", c.this.f43332b + " load rename error path = " + absolutePath);
                    }
                    file.delete();
                    if (c.this.f43334d != null) {
                        c.this.f43334d.fail(-1, absolutePath);
                    }
                }
                d.a.l0.t.d.d(byteStream);
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            }
            d.a.l0.t.d.d(fileOutputStream);
            d.a.l0.t.d.d(response);
        }
    }

    public c(HttpManager httpManager, String str, String str2, d.a.l0.a.l0.m.a aVar) {
        this.f43332b = "";
        this.f43333c = "";
        this.f43331a = httpManager;
        this.f43333c = str;
        this.f43332b = str2;
        this.f43334d = aVar;
    }

    public void e() {
        d.a.l0.a.c1.b.l().a(this.f43331a, new Request.Builder().url(this.f43332b).build(), new a());
    }
}
