package d.b.h0.g.w.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.h0.a.g1.m.a;
import d.b.h0.a.k;
import d.b.h0.a.t1.k.g;
import d.b.h0.a.z0.f;
import d.b.h0.a.z1.h;
import d.b.h0.g.w.g.e;
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
public class b extends d.b.h0.g.w.a {
    public static final boolean m = k.f45772a;
    public long l;

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49318a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.w.b f49319b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f49320c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a2.f.c f49321d;

        public a(String str, d.b.h0.g.w.b bVar, boolean z, d.b.h0.a.a2.f.c cVar) {
            this.f49318a = str;
            this.f49319b = bVar;
            this.f49320c = z;
            this.f49321d = cVar;
        }

        @Override // d.b.h0.a.g1.m.a.b
        public void a(long j) {
            b.this.F(this.f49318a, -1, "downloadFile:fail exceed max file size");
            this.f49319b.cancelTag(b.this.f49308g);
        }

        @Override // d.b.h0.a.g1.m.a.b
        public void b(int i, long j, long j2) {
            if (System.currentTimeMillis() - b.this.l > 500) {
                if (j2 <= 52428800 && j <= 52428800) {
                    if (i <= 100) {
                        d.b.h0.g.w.e.a aVar = new d.b.h0.g.w.e.a(i, j2, j);
                        JSEvent jSEvent = new JSEvent("progressUpdate");
                        jSEvent.data = aVar;
                        b.this.dispatchEvent(jSEvent);
                    }
                    if (this.f49320c && this.f49321d.h().a(j)) {
                        b.this.F(this.f49318a, -1, "downloadFile:fail exceed max file size");
                        this.f49319b.cancelTag(b.this.f49308g);
                    }
                } else {
                    b.this.F(this.f49318a, -1, "downloadFile:fail exceed max file size");
                    this.f49319b.cancelTag(b.this.f49308g);
                }
                b.this.l = System.currentTimeMillis();
            }
        }

        @Override // d.b.h0.a.g1.m.a.b
        public void c(long j, long j2) {
            b.this.F(this.f49318a, 0, "progress callback fail()");
            this.f49319b.cancelTag(b.this.f49308g);
        }
    }

    /* renamed from: d.b.h0.g.w.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1028b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49323a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49324b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49325c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a2.f.c f49326d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49327e;

        public C1028b(String str, String str2, String str3, d.b.h0.a.a2.f.c cVar, boolean z) {
            this.f49323a = str;
            this.f49324b = str2;
            this.f49325c = str3;
            this.f49326d = cVar;
            this.f49327e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            b.this.F(this.f49323a, 0, iOException.getMessage());
            if (SwanAppNetworkUtils.h(null)) {
                h.s(0, this.f49323a, 1, iOException.getMessage());
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
            if (TextUtils.isEmpty(this.f49324b)) {
                W = g.A(response, this.f49325c);
            } else {
                W = b.this.W(this.f49324b);
            }
            if (!TextUtils.isEmpty(W)) {
                if (b.m) {
                    Log.d("DownloadTask", "the real file path is " + W);
                }
                if (TextUtils.isEmpty(this.f49324b)) {
                    str = this.f49326d.b(W);
                } else {
                    str = this.f49324b;
                }
                if (TextUtils.isEmpty(str)) {
                    b.this.F(this.f49323a, -1, "parse tmpFilePath from realFilePath fail");
                    return;
                }
                int code = response.code();
                String message = response.message();
                c cVar = new c();
                cVar.statusCode = code;
                if (TextUtils.isEmpty(this.f49324b)) {
                    cVar.tempFilePath = str;
                } else {
                    cVar.filePath = str;
                }
                InputStream byteStream = response.body().byteStream();
                File file = new File(W);
                if (file.exists()) {
                    long length = file.length();
                    file.delete();
                    if (this.f49327e) {
                        this.f49326d.h().b(-length);
                    }
                }
                if (b.this.X(byteStream, file)) {
                    if (this.f49327e) {
                        this.f49326d.h().b(file.length());
                    }
                    b.this.G(cVar);
                } else {
                    b.this.F(this.f49323a, -1, "downloadFile:fail abort");
                }
                d.b.h0.p.d.a(byteStream);
                d.b.h0.p.d.a(response);
                if (b.m) {
                    Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.f49323a + ", msg=" + message);
                }
                h.s(code, this.f49323a, 1, message);
                return;
            }
            b.this.F(this.f49323a, -1, "downloadFile:filePath is invalid");
        }
    }

    public b(d.b.h0.g.i.b bVar, d.b.h0.g.e.d.c cVar) {
        super(bVar, cVar);
        this.f49306e = 2;
    }

    @Override // d.b.h0.g.w.a
    public void F(String str, int i, String str2) {
        super.F(str, i, str2);
        d.b.h0.g.c0.c.c(str, i, str2, SwanAppNetworkUtils.h(null));
    }

    public void V(Request request, String str, String str2, d.b.h0.g.w.b bVar, d dVar) {
        String httpUrl = request.url().toString();
        d.b.h0.a.a2.f.c y = f.V().y();
        boolean e2 = y.e(str);
        h.w(httpUrl, 1);
        bVar.a(request, Collections.singletonList(dVar), new C1028b(httpUrl, str, str2, y, e2));
    }

    @Nullable
    public String W(@NonNull String str) {
        String d2 = f.V().y().d(str);
        if (d2 == null) {
            return null;
        }
        boolean endsWith = d2.endsWith(File.separator);
        File parentFile = new File(d2).getParentFile();
        boolean z = parentFile != null && parentFile.exists();
        if (endsWith || !z) {
            return null;
        }
        return d2;
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
                    d.b.h0.p.d.a(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.b.h0.p.d.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.b.h0.p.d.a(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        if (this.f49307f == null) {
            return;
        }
        String C = C();
        if (TextUtils.isEmpty(C)) {
            return;
        }
        if (d.b.h0.a.r1.e.y() == null) {
            F("", -1, "request:swanApp is null");
            return;
        }
        d.b.h0.g.w.b V = d.b.h0.a.r1.e.y().V();
        String B = this.f49307f.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (d.b.h0.p.d.o(B)) {
                F(C, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                F(C, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        d.b.h0.a.a2.f.c y = f.V().y();
        boolean e2 = y.e(B);
        if (e2 && y.h().a(0L)) {
            F(C, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        J(builder, this.f49307f.w("header"), hashMap, false);
        builder.url(C).tag(this.f49308g).build();
        String l = d.b.h0.p.d.l(C);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(C, V, e2, y));
        V(builder.build(), B, l, V, dVar);
    }
}
