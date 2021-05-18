package d.a.i0.h.c.i;

import android.util.Log;
import d.a.i0.a.k;
import d.a.i0.h.c.f;
import d.a.i0.t.d;
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
    public static final boolean f47033e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.h.y.b f47034a;

    /* renamed from: b  reason: collision with root package name */
    public String f47035b;

    /* renamed from: c  reason: collision with root package name */
    public String f47036c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.h.c.i.a f47037d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f47033e) {
                Log.e("AudioDownloader", c.this.f47035b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f47037d != null) {
                c.this.f47037d.fail(-1, c.this.f47035b);
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
                        String d2 = f.d(c.this.f47035b);
                        String str = c.this.f47036c + d2.substring(0, d2.lastIndexOf("/"));
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
                                        if (c.f47033e) {
                                            Log.e("AudioDownloader", c.this.f47035b + " load failed", e);
                                        }
                                        if (file != null) {
                                            file.delete();
                                        }
                                        if (c.this.f47037d != null) {
                                            c.this.f47037d.fail(-1, c.this.f47035b);
                                        }
                                        d.d(inputStream);
                                        d.d(fileOutputStream);
                                        d.d(response);
                                    } catch (Throwable th) {
                                        th = th;
                                        d.d(inputStream);
                                        d.d(fileOutputStream);
                                        d.d(response);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = byteStream;
                                    d.d(inputStream);
                                    d.d(fileOutputStream);
                                    d.d(response);
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
                                if (c.f47033e) {
                                    Log.e("AudioDownloader", c.this.f47035b + " load rename success path = " + absolutePath);
                                }
                                if (c.this.f47037d != null) {
                                    c.this.f47037d.a(c.this.f47035b, absolutePath);
                                }
                            } else {
                                if (c.f47033e) {
                                    Log.e("AudioDownloader", c.this.f47035b + " load rename error path = " + absolutePath);
                                }
                                file.delete();
                                if (c.this.f47037d != null) {
                                    c.this.f47037d.fail(-1, absolutePath);
                                }
                            }
                            d.d(byteStream);
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
            d.d(fileOutputStream);
            d.d(response);
        }
    }

    public c(d.a.i0.h.y.b bVar, String str, String str2, d.a.i0.h.c.i.a aVar) {
        this.f47035b = "";
        this.f47036c = "";
        this.f47034a = bVar;
        this.f47036c = str;
        this.f47035b = str2;
        this.f47037d = aVar;
    }

    public void e() {
        this.f47034a.b(new Request.Builder().url(this.f47035b).build(), new a());
    }
}
