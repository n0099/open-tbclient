package d.a.h0.g.w.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.h0.a.g1.m.a;
import d.a.h0.a.k;
import d.a.h0.a.t1.k.g;
import d.a.h0.a.z0.f;
import d.a.h0.a.z1.h;
import d.a.h0.g.w.g.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class b extends d.a.h0.g.w.a {
    public static final boolean m = k.f43101a;
    public long l;

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.w.b f46815b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f46816c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a2.f.c f46817d;

        public a(String str, d.a.h0.g.w.b bVar, boolean z, d.a.h0.a.a2.f.c cVar) {
            this.f46814a = str;
            this.f46815b = bVar;
            this.f46816c = z;
            this.f46817d = cVar;
        }

        @Override // d.a.h0.a.g1.m.a.b
        public void a(long j) {
            b.this.F(this.f46814a, -1, "downloadFile:fail exceed max file size");
            this.f46815b.cancelTag(b.this.f46804g);
        }

        @Override // d.a.h0.a.g1.m.a.b
        public void b(int i2, long j, long j2) {
            if (System.currentTimeMillis() - b.this.l > 500) {
                if (j2 <= 52428800 && j <= 52428800) {
                    if (i2 <= 100) {
                        d.a.h0.g.w.e.a aVar = new d.a.h0.g.w.e.a(i2, j2, j);
                        JSEvent jSEvent = new JSEvent("progressUpdate");
                        jSEvent.data = aVar;
                        b.this.dispatchEvent(jSEvent);
                    }
                    if (this.f46816c && this.f46817d.c().a(j)) {
                        b.this.F(this.f46814a, -1, "downloadFile:fail exceed max file size");
                        this.f46815b.cancelTag(b.this.f46804g);
                    }
                } else {
                    b.this.F(this.f46814a, -1, "downloadFile:fail exceed max file size");
                    this.f46815b.cancelTag(b.this.f46804g);
                }
                b.this.l = System.currentTimeMillis();
            }
        }

        @Override // d.a.h0.a.g1.m.a.b
        public void c(long j, long j2) {
            b.this.F(this.f46814a, 0, "progress callback fail()");
            this.f46815b.cancelTag(b.this.f46804g);
        }
    }

    /* renamed from: d.a.h0.g.w.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0967b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46820b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46821c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a2.f.c f46822d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46823e;

        public C0967b(String str, String str2, String str3, d.a.h0.a.a2.f.c cVar, boolean z) {
            this.f46819a = str;
            this.f46820b = str2;
            this.f46821c = str3;
            this.f46822d = cVar;
            this.f46823e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            b.this.F(this.f46819a, 0, iOException.getMessage());
            if (SwanAppNetworkUtils.h(null)) {
                h.s(0, this.f46819a, 1, iOException.getMessage());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String W;
            String str;
            try {
                JSEvent jSEvent = new JSEvent("headersReceived");
                jSEvent.data = new e(b.this.L(response.headers()));
                b.this.dispatchEvent(jSEvent);
            } catch (JSONException e2) {
                if (b.m) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(this.f46820b)) {
                W = g.A(response, this.f46821c);
            } else {
                W = b.this.W(this.f46820b);
            }
            if (!TextUtils.isEmpty(W)) {
                if (b.m) {
                    Log.d("DownloadTask", "the real file path is " + W);
                }
                if (TextUtils.isEmpty(this.f46820b)) {
                    str = this.f46822d.g(W);
                } else {
                    str = this.f46820b;
                }
                if (TextUtils.isEmpty(str)) {
                    b.this.F(this.f46819a, -1, "parse tmpFilePath from realFilePath fail");
                    return;
                }
                int code = response.code();
                String message = response.message();
                c cVar = new c();
                cVar.statusCode = code;
                if (TextUtils.isEmpty(this.f46820b)) {
                    cVar.tempFilePath = str;
                } else {
                    cVar.filePath = str;
                }
                InputStream byteStream = response.body().byteStream();
                File file = new File(W);
                if (file.exists()) {
                    long length = file.length();
                    file.delete();
                    if (this.f46823e) {
                        this.f46822d.c().b(-length);
                    }
                }
                if (b.this.X(byteStream, file)) {
                    if (this.f46823e) {
                        this.f46822d.c().b(file.length());
                    }
                    b.this.G(cVar);
                } else {
                    b.this.F(this.f46819a, -1, "downloadFile:fail abort");
                }
                d.a.h0.p.d.a(byteStream);
                d.a.h0.p.d.a(response);
                if (b.m) {
                    Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.f46819a + ", msg=" + message);
                }
                h.s(code, this.f46819a, 1, message);
                return;
            }
            b.this.F(this.f46819a, -1, "downloadFile:filePath is invalid");
        }
    }

    public b(d.a.h0.g.i.b bVar, d.a.h0.g.e.d.c cVar) {
        super(bVar, cVar);
        this.f46802e = 2;
    }

    @Override // d.a.h0.g.w.a
    public void F(String str, int i2, String str2) {
        super.F(str, i2, str2);
        d.a.h0.g.c0.c.c(str, i2, str2, SwanAppNetworkUtils.h(null));
    }

    public void V(Request request, String str, String str2, d.a.h0.g.w.b bVar, d dVar) {
        String httpUrl = request.url().toString();
        d.a.h0.a.a2.f.c I = f.V().I();
        boolean a2 = I.a(str);
        h.w(httpUrl, 1);
        bVar.a(request, Collections.singletonList(dVar), new C0967b(httpUrl, str, str2, I, a2));
    }

    @Nullable
    public String W(@NonNull String str) {
        String i2 = f.V().I().i(str);
        if (i2 == null) {
            return null;
        }
        boolean endsWith = i2.endsWith(File.separator);
        File parentFile = new File(i2).getParentFile();
        boolean z = parentFile != null && parentFile.exists();
        if (endsWith || !z) {
            return null;
        }
        return i2;
    }

    public boolean X(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (inputStream == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    d.a.h0.p.d.a(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.a.h0.p.d.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.h0.p.d.a(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        if (this.f46803f == null) {
            return;
        }
        String C = C();
        if (TextUtils.isEmpty(C)) {
            return;
        }
        if (d.a.h0.a.r1.e.h() == null) {
            F("", -1, "request:swanApp is null");
            return;
        }
        d.a.h0.g.w.b V = d.a.h0.a.r1.e.h().V();
        String B = this.f46803f.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (d.a.h0.p.d.o(B)) {
                F(C, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                F(C, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        d.a.h0.a.a2.f.c I = f.V().I();
        boolean a2 = I.a(B);
        if (a2 && I.c().a(0L)) {
            F(C, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        J(builder, this.f46803f.w("header"), hashMap, false);
        builder.url(C).tag(this.f46804g).build();
        String l = d.a.h0.p.d.l(C);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(C, V, a2, I));
        V(builder.build(), B, l, V, dVar);
    }
}
