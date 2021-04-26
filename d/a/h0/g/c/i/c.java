package d.a.h0.g.c.i;

import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.g.c.f;
import d.a.h0.p.d;
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
    public static final boolean f46155e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.w.b f46156a;

    /* renamed from: b  reason: collision with root package name */
    public String f46157b;

    /* renamed from: c  reason: collision with root package name */
    public String f46158c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.g.c.i.a f46159d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (c.f46155e) {
                Log.e("AudioDownloader", c.this.f46157b + " load failed");
                iOException.printStackTrace();
            }
            if (c.this.f46159d != null) {
                c.this.f46159d.fail(-1, c.this.f46157b);
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
                        String d2 = f.d(c.this.f46157b);
                        String str = c.this.f46158c + d2.substring(0, d2.lastIndexOf("/"));
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
                                        if (c.f46155e) {
                                            Log.e("AudioDownloader", c.this.f46157b + " load failed", e);
                                        }
                                        if (file != null) {
                                            file.delete();
                                        }
                                        if (c.this.f46159d != null) {
                                            c.this.f46159d.fail(-1, c.this.f46157b);
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
                                if (c.f46155e) {
                                    Log.e("AudioDownloader", c.this.f46157b + " load rename success path = " + absolutePath);
                                }
                                if (c.this.f46159d != null) {
                                    c.this.f46159d.a(c.this.f46157b, absolutePath);
                                }
                            } else {
                                if (c.f46155e) {
                                    Log.e("AudioDownloader", c.this.f46157b + " load rename error path = " + absolutePath);
                                }
                                file.delete();
                                if (c.this.f46159d != null) {
                                    c.this.f46159d.fail(-1, absolutePath);
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

    public c(d.a.h0.g.w.b bVar, String str, String str2, d.a.h0.g.c.i.a aVar) {
        this.f46157b = "";
        this.f46158c = "";
        this.f46156a = bVar;
        this.f46158c = str;
        this.f46157b = str2;
        this.f46159d = aVar;
    }

    public void e() {
        this.f46156a.b(new Request.Builder().url(this.f46157b).build(), new a());
    }
}
