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
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47006e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public HttpManager f47007a;

    /* renamed from: b  reason: collision with root package name */
    public String f47008b;

    /* renamed from: c  reason: collision with root package name */
    public String f47009c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.l0.m.a f47010d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f47006e) {
                Log.e("ImageDownloader", c.this.f47008b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f47010d != null) {
                c.this.f47010d.fail(-1, c.this.f47008b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            InputStream byteStream;
            String c2;
            if (TextUtils.isEmpty(c.this.f47009c)) {
                if (k.f46875a) {
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
                        c2 = d.a.l0.a.c1.b.f().c(c.this.f47008b);
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
                if (k.f46875a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口convertSrc()未实现，直接返回");
                }
                d.a.l0.t.d.d(byteStream);
                d.a.l0.t.d.d(null);
                d.a.l0.t.d.d(response);
                return;
            }
            String str = c.this.f47009c + c2.substring(0, c2.lastIndexOf("/"));
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
                            if (c.f47006e) {
                                Log.e("ImageDownloader", c.this.f47008b + " load failed", e);
                            }
                            if (file != null) {
                                file.delete();
                            }
                            if (c.this.f47010d != null) {
                                c.this.f47010d.fail(-1, c.this.f47008b);
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
                    if (c.f47006e) {
                        Log.e("ImageDownloader", c.this.f47008b + " load rename success path = " + absolutePath);
                    }
                    if (c.this.f47010d != null) {
                        c.this.f47010d.a(c.this.f47008b, absolutePath);
                    }
                } else {
                    if (c.f47006e) {
                        Log.e("ImageDownloader", c.this.f47008b + " load rename error path = " + absolutePath);
                    }
                    file.delete();
                    if (c.this.f47010d != null) {
                        c.this.f47010d.fail(-1, absolutePath);
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
        this.f47008b = "";
        this.f47009c = "";
        this.f47007a = httpManager;
        this.f47009c = str;
        this.f47008b = str2;
        this.f47010d = aVar;
    }

    public void e() {
        d.a.l0.a.c1.b.l().a(this.f47007a, new Request.Builder().url(this.f47008b).build(), new a());
    }
}
