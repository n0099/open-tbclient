package d.a.i0.a.l0.m;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import d.a.i0.a.k;
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
    public static final boolean f43156e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public HttpManager f43157a;

    /* renamed from: b  reason: collision with root package name */
    public String f43158b;

    /* renamed from: c  reason: collision with root package name */
    public String f43159c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.l0.m.a f43160d;

    /* loaded from: classes2.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f43156e) {
                Log.e("ImageDownloader", c.this.f43158b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f43160d != null) {
                c.this.f43160d.fail(-1, c.this.f43158b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            InputStream byteStream;
            String c2;
            if (TextUtils.isEmpty(c.this.f43159c)) {
                if (k.f43025a) {
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
                        c2 = d.a.i0.a.c1.b.f().c(c.this.f43158b);
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
                if (k.f43025a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口convertSrc()未实现，直接返回");
                }
                d.a.i0.t.d.d(byteStream);
                d.a.i0.t.d.d(null);
                d.a.i0.t.d.d(response);
                return;
            }
            String str = c.this.f43159c + c2.substring(0, c2.lastIndexOf("/"));
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
                            if (c.f43156e) {
                                Log.e("ImageDownloader", c.this.f43158b + " load failed", e);
                            }
                            if (file != null) {
                                file.delete();
                            }
                            if (c.this.f43160d != null) {
                                c.this.f43160d.fail(-1, c.this.f43158b);
                            }
                            d.a.i0.t.d.d(inputStream);
                            d.a.i0.t.d.d(fileOutputStream);
                            d.a.i0.t.d.d(response);
                        } catch (Throwable th3) {
                            th = th3;
                            d.a.i0.t.d.d(inputStream);
                            d.a.i0.t.d.d(fileOutputStream);
                            d.a.i0.t.d.d(response);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = byteStream;
                        d.a.i0.t.d.d(inputStream);
                        d.a.i0.t.d.d(fileOutputStream);
                        d.a.i0.t.d.d(response);
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
                    if (c.f43156e) {
                        Log.e("ImageDownloader", c.this.f43158b + " load rename success path = " + absolutePath);
                    }
                    if (c.this.f43160d != null) {
                        c.this.f43160d.a(c.this.f43158b, absolutePath);
                    }
                } else {
                    if (c.f43156e) {
                        Log.e("ImageDownloader", c.this.f43158b + " load rename error path = " + absolutePath);
                    }
                    file.delete();
                    if (c.this.f43160d != null) {
                        c.this.f43160d.fail(-1, absolutePath);
                    }
                }
                d.a.i0.t.d.d(byteStream);
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            }
            d.a.i0.t.d.d(fileOutputStream);
            d.a.i0.t.d.d(response);
        }
    }

    public c(HttpManager httpManager, String str, String str2, d.a.i0.a.l0.m.a aVar) {
        this.f43158b = "";
        this.f43159c = "";
        this.f43157a = httpManager;
        this.f43159c = str;
        this.f43158b = str2;
        this.f43160d = aVar;
    }

    public void e() {
        d.a.i0.a.c1.b.l().a(this.f43157a, new Request.Builder().url(this.f43158b).build(), new a());
    }
}
