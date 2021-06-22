package d.a.m0.h.c.i;

import android.util.Log;
import d.a.m0.a.k;
import d.a.m0.h.c.f;
import d.a.m0.t.d;
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
    public static final boolean f50991e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.h.y.b f50992a;

    /* renamed from: b  reason: collision with root package name */
    public String f50993b;

    /* renamed from: c  reason: collision with root package name */
    public String f50994c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.h.c.i.a f50995d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f50991e) {
                Log.e("AudioDownloader", c.this.f50993b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f50995d != null) {
                c.this.f50995d.fail(-1, c.this.f50993b);
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
                        String d2 = f.d(c.this.f50993b);
                        String str = c.this.f50994c + d2.substring(0, d2.lastIndexOf("/"));
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
                                        if (c.f50991e) {
                                            Log.e("AudioDownloader", c.this.f50993b + " load failed", e);
                                        }
                                        if (file != null) {
                                            file.delete();
                                        }
                                        if (c.this.f50995d != null) {
                                            c.this.f50995d.fail(-1, c.this.f50993b);
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
                                if (c.f50991e) {
                                    Log.e("AudioDownloader", c.this.f50993b + " load rename success path = " + absolutePath);
                                }
                                if (c.this.f50995d != null) {
                                    c.this.f50995d.a(c.this.f50993b, absolutePath);
                                }
                            } else {
                                if (c.f50991e) {
                                    Log.e("AudioDownloader", c.this.f50993b + " load rename error path = " + absolutePath);
                                }
                                file.delete();
                                if (c.this.f50995d != null) {
                                    c.this.f50995d.fail(-1, absolutePath);
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

    public c(d.a.m0.h.y.b bVar, String str, String str2, d.a.m0.h.c.i.a aVar) {
        this.f50993b = "";
        this.f50994c = "";
        this.f50992a = bVar;
        this.f50994c = str;
        this.f50993b = str2;
        this.f50995d = aVar;
    }

    public void e() {
        this.f50992a.b(new Request.Builder().url(this.f50993b).build(), new a());
    }
}
