package d.b.g0.g.i.m;

import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.g.c.f;
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
    public static final boolean f48197e = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.w.b f48198a;

    /* renamed from: b  reason: collision with root package name */
    public String f48199b;

    /* renamed from: c  reason: collision with root package name */
    public String f48200c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.i.m.a f48201d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f48197e) {
                Log.e("ImageDownloader", c.this.f48199b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f48201d != null) {
                c.this.f48201d.fail(-1, c.this.f48199b);
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
                        String d2 = f.d(c.this.f48199b);
                        String str = c.this.f48200c + d2.substring(0, d2.lastIndexOf("/"));
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
                                        if (c.f48197e) {
                                            Log.e("ImageDownloader", c.this.f48199b + " load failed", e);
                                        }
                                        if (file != null) {
                                            file.delete();
                                        }
                                        if (c.this.f48201d != null) {
                                            c.this.f48201d.fail(-1, c.this.f48199b);
                                        }
                                        d.b.g0.p.d.a(inputStream);
                                        d.b.g0.p.d.a(fileOutputStream);
                                        d.b.g0.p.d.a(response);
                                    } catch (Throwable th) {
                                        th = th;
                                        d.b.g0.p.d.a(inputStream);
                                        d.b.g0.p.d.a(fileOutputStream);
                                        d.b.g0.p.d.a(response);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = byteStream;
                                    d.b.g0.p.d.a(inputStream);
                                    d.b.g0.p.d.a(fileOutputStream);
                                    d.b.g0.p.d.a(response);
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
                                if (c.f48197e) {
                                    Log.e("ImageDownloader", c.this.f48199b + " load rename success path = " + absolutePath);
                                }
                                if (c.this.f48201d != null) {
                                    c.this.f48201d.a(c.this.f48199b, absolutePath);
                                }
                            } else {
                                if (c.f48197e) {
                                    Log.e("ImageDownloader", c.this.f48199b + " load rename error path = " + absolutePath);
                                }
                                file.delete();
                                if (c.this.f48201d != null) {
                                    c.this.f48201d.fail(-1, absolutePath);
                                }
                            }
                            d.b.g0.p.d.a(byteStream);
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
            d.b.g0.p.d.a(fileOutputStream);
            d.b.g0.p.d.a(response);
        }
    }

    public c(d.b.g0.g.w.b bVar, String str, String str2, d.b.g0.g.i.m.a aVar) {
        this.f48199b = "";
        this.f48200c = "";
        this.f48198a = bVar;
        this.f48200c = str;
        this.f48199b = str2;
        this.f48201d = aVar;
    }

    public void e() {
        this.f48198a.b(new Request.Builder().url(this.f48199b).build(), new a());
    }
}
