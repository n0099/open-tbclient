package d.b.g0.g.c.i;

import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.g.c.f;
import d.b.g0.p.d;
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
    public static final boolean f48360e = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.w.b f48361a;

    /* renamed from: b  reason: collision with root package name */
    public String f48362b;

    /* renamed from: c  reason: collision with root package name */
    public String f48363c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.c.i.a f48364d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f48360e) {
                Log.e("AudioDownloader", c.this.f48362b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f48364d != null) {
                c.this.f48364d.fail(-1, c.this.f48362b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            byte[] bArr = new byte[2048];
            InputStream inputStream = null;
            try {
                InputStream byteStream = response.body().byteStream();
                try {
                    try {
                        String d2 = f.d(c.this.f48362b);
                        String str = c.this.f48363c + d2.substring(0, d2.lastIndexOf("/"));
                        File file2 = new File(str);
                        if (!file2.exists() || !file2.isDirectory()) {
                            file2.mkdirs();
                        }
                        String substring = d2.substring(d2.lastIndexOf("/") + 1);
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
                                } catch (Exception e2) {
                                    e = e2;
                                    inputStream = byteStream;
                                    try {
                                        if (c.f48360e) {
                                            Log.e("AudioDownloader", c.this.f48362b + " load failed", e);
                                        }
                                        if (file != null) {
                                            file.delete();
                                        }
                                        if (c.this.f48364d != null) {
                                            c.this.f48364d.fail(-1, c.this.f48362b);
                                        }
                                        d.a(inputStream);
                                        d.a(fileOutputStream);
                                        d.a(response);
                                    } catch (Throwable th) {
                                        th = th;
                                        d.a(inputStream);
                                        d.a(fileOutputStream);
                                        d.a(response);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = byteStream;
                                    d.a(inputStream);
                                    d.a(fileOutputStream);
                                    d.a(response);
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
                                if (c.f48360e) {
                                    Log.e("AudioDownloader", c.this.f48362b + " load rename success path = " + absolutePath);
                                }
                                if (c.this.f48364d != null) {
                                    c.this.f48364d.a(c.this.f48362b, absolutePath);
                                }
                            } else {
                                if (c.f48360e) {
                                    Log.e("AudioDownloader", c.this.f48362b + " load rename error path = " + absolutePath);
                                }
                                file.delete();
                                if (c.this.f48364d != null) {
                                    c.this.f48364d.fail(-1, absolutePath);
                                }
                            }
                            d.a(byteStream);
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        file = null;
                        fileOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e5) {
                e = e5;
                file = null;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            d.a(fileOutputStream);
            d.a(response);
        }
    }

    public c(d.b.g0.g.w.b bVar, String str, String str2, d.b.g0.g.c.i.a aVar) {
        this.f48362b = "";
        this.f48363c = "";
        this.f48361a = bVar;
        this.f48363c = str;
        this.f48362b = str2;
        this.f48364d = aVar;
    }

    public void e() {
        this.f48361a.b(new Request.Builder().url(this.f48362b).build(), new a());
    }
}
