package d.a.l0.h.y.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.l0.a.c2.f.f;
import d.a.l0.a.k;
import d.a.l0.a.n1.o.a;
import d.a.l0.h.y.f.e;
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
public class b extends d.a.l0.h.y.a {
    public static final boolean m = k.f46875a;
    public long l;

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51406a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.y.b f51407b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f51408c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.k2.f.d f51409d;

        public a(String str, d.a.l0.h.y.b bVar, boolean z, d.a.l0.a.k2.f.d dVar) {
            this.f51406a = str;
            this.f51407b = bVar;
            this.f51408c = z;
            this.f51409d = dVar;
        }

        @Override // d.a.l0.a.n1.o.a.b
        public void a(long j) {
            b.this.E(this.f51406a, -1, "downloadFile:fail exceed max file size");
            this.f51407b.cancelTag(b.this.f51396g);
        }

        @Override // d.a.l0.a.n1.o.a.b
        public void b(int i2, long j, long j2) {
            if (System.currentTimeMillis() - b.this.l > 500) {
                if (j2 <= 52428800 && j <= 52428800) {
                    if (i2 <= 100) {
                        d.a.l0.h.y.d.a aVar = new d.a.l0.h.y.d.a(i2, j2, j);
                        JSEvent jSEvent = new JSEvent("progressUpdate");
                        jSEvent.data = aVar;
                        b.this.dispatchEvent(jSEvent);
                    }
                    if (this.f51408c && this.f51409d.d().a(j)) {
                        b.this.E(this.f51406a, -1, "downloadFile:fail exceed max file size");
                        this.f51407b.cancelTag(b.this.f51396g);
                    }
                } else {
                    b.this.E(this.f51406a, -1, "downloadFile:fail exceed max file size");
                    this.f51407b.cancelTag(b.this.f51396g);
                }
                b.this.l = System.currentTimeMillis();
            }
        }

        @Override // d.a.l0.a.n1.o.a.b
        public void c(long j, long j2) {
            b.this.E(this.f51406a, 0, "progress callback fail()");
            this.f51407b.cancelTag(b.this.f51396g);
        }
    }

    /* renamed from: d.a.l0.h.y.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1114b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51411a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51412b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51413c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.k2.f.d f51414d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f51415e;

        public C1114b(String str, String str2, String str3, d.a.l0.a.k2.f.d dVar, boolean z) {
            this.f51411a = str;
            this.f51412b = str2;
            this.f51413c = str3;
            this.f51414d = dVar;
            this.f51415e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            b.this.E(this.f51411a, 0, iOException.getMessage());
            if (SwanAppNetworkUtils.i(null)) {
                d.a.l0.a.j2.k.r(0, this.f51411a, 1, iOException.getMessage());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String V;
            String str;
            try {
                JSEvent jSEvent = new JSEvent("headersReceived");
                jSEvent.data = new e(b.this.K(response.headers()));
                b.this.dispatchEvent(jSEvent);
            } catch (JSONException e2) {
                if (b.m) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(this.f51412b)) {
                V = f.A(response, this.f51413c);
            } else {
                V = b.this.V(this.f51412b);
            }
            if (!TextUtils.isEmpty(V)) {
                if (b.m) {
                    Log.d("DownloadTask", "the real file path is " + V);
                }
                if (TextUtils.isEmpty(this.f51412b)) {
                    str = this.f51414d.g(V);
                } else {
                    str = this.f51412b;
                }
                if (TextUtils.isEmpty(str)) {
                    b.this.E(this.f51411a, -1, "parse tmpFilePath from realFilePath fail");
                    return;
                }
                int code = response.code();
                String message = response.message();
                c cVar = new c();
                cVar.statusCode = code;
                if (TextUtils.isEmpty(this.f51412b)) {
                    cVar.tempFilePath = str;
                } else {
                    cVar.filePath = str;
                }
                InputStream byteStream = response.body().byteStream();
                File file = new File(V);
                if (file.exists()) {
                    long length = file.length();
                    file.delete();
                    if (this.f51415e) {
                        this.f51414d.d().b(-length);
                    }
                }
                if (b.this.W(byteStream, file)) {
                    if (this.f51415e) {
                        this.f51414d.d().b(file.length());
                    }
                    b.this.F(cVar);
                } else {
                    b.this.E(this.f51411a, -1, "downloadFile:fail abort");
                }
                d.a.l0.t.d.d(byteStream);
                d.a.l0.t.d.d(response);
                if (b.m) {
                    Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.f51411a + ", msg=" + message);
                }
                d.a.l0.a.j2.k.r(code, this.f51411a, 1, message);
                return;
            }
            b.this.E(this.f51411a, -1, "downloadFile:filePath is invalid");
        }
    }

    public b(d.a.l0.a.l0.c cVar, d.a.l0.a.y.b.a aVar) {
        super(cVar, aVar);
        this.f51394e = 2;
    }

    @Override // d.a.l0.h.y.a
    public void E(String str, int i2, String str2) {
        super.E(str, i2, str2);
        d.a.l0.h.f0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
    }

    public void U(Request request, String str, String str2, d.a.l0.h.y.b bVar, d dVar) {
        String httpUrl = request.url().toString();
        d.a.l0.a.k2.f.d I = d.a.l0.a.g1.f.V().I();
        boolean b2 = I.b(str);
        d.a.l0.a.j2.k.x(httpUrl, 1);
        bVar.a(request, Collections.singletonList(dVar), new C1114b(httpUrl, str, str2, I, b2));
    }

    @Nullable
    public String V(@NonNull String str) {
        String i2 = d.a.l0.a.g1.f.V().I().i(str);
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

    public boolean W(InputStream inputStream, File file) {
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
                    d.a.l0.t.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.a.l0.t.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.l0.t.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        if (this.f51395f == null) {
            return;
        }
        String B = B();
        if (TextUtils.isEmpty(B)) {
            return;
        }
        if (d.a.l0.a.a2.e.i() == null) {
            E("", -1, "request:swanApp is null");
            return;
        }
        d.a.l0.h.y.b bVar = (d.a.l0.h.y.b) d.a.l0.a.a2.e.i().X();
        String C = this.f51395f.C("filePath");
        if (!TextUtils.isEmpty(C)) {
            if (d.a.l0.t.d.w(C)) {
                E(B, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = C.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                E(B, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        d.a.l0.a.k2.f.d I = d.a.l0.a.g1.f.V().I();
        boolean b2 = I.b(C);
        if (b2 && I.d().a(0L)) {
            E(B, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        I(builder, this.f51395f.x("header"), hashMap, false);
        builder.url(B).tag(this.f51396g).build();
        String s = d.a.l0.t.d.s(B);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(B, bVar, b2, I));
        U(builder.build(), C, s, bVar, dVar);
    }
}
