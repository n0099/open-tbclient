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
    public static final boolean f47968e = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.w.b f47969a;

    /* renamed from: b  reason: collision with root package name */
    public String f47970b;

    /* renamed from: c  reason: collision with root package name */
    public String f47971c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.c.i.a f47972d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f47968e) {
                Log.e("AudioDownloader", c.this.f47970b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f47972d != null) {
                c.this.f47972d.fail(-1, c.this.f47970b);
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
                        String d2 = f.d(c.this.f47970b);
                        String str = c.this.f47971c + d2.substring(0, d2.lastIndexOf("/"));
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
                                        if (c.f47968e) {
                                            Log.e("AudioDownloader", c.this.f47970b + " load failed", e);
                                        }
                                        if (file != null) {
                                            file.delete();
                                        }
                                        if (c.this.f47972d != null) {
                                            c.this.f47972d.fail(-1, c.this.f47970b);
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
                                if (c.f47968e) {
                                    Log.e("AudioDownloader", c.this.f47970b + " load rename success path = " + absolutePath);
                                }
                                if (c.this.f47972d != null) {
                                    c.this.f47972d.a(c.this.f47970b, absolutePath);
                                }
                            } else {
                                if (c.f47968e) {
                                    Log.e("AudioDownloader", c.this.f47970b + " load rename error path = " + absolutePath);
                                }
                                file.delete();
                                if (c.this.f47972d != null) {
                                    c.this.f47972d.fail(-1, absolutePath);
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
        this.f47970b = "";
        this.f47971c = "";
        this.f47969a = bVar;
        this.f47971c = str;
        this.f47970b = str2;
        this.f47972d = aVar;
    }

    public void e() {
        this.f47969a.b(new Request.Builder().url(this.f47970b).build(), new a());
    }
}
