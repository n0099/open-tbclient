package d.b.g0.g.w.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.g0.a.z0.f;
import d.b.g0.g.w.g.e;
import d.b.g0.p.d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.g.w.a {
    public long l;

    /* loaded from: classes3.dex */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48621a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.w.b f48622b;

        public a(String str, d.b.g0.g.w.b bVar) {
            this.f48621a = str;
            this.f48622b = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f48622b.cancelTag(b.this.f48587g);
            b.this.Z(this.f48621a, 0, iOException.getMessage());
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Call call, Response response) {
            try {
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(b.this.L(response.headers()));
                    b.this.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    try {
                        if (d.b.g0.g.w.a.i) {
                            e2.printStackTrace();
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        if (d.b.g0.g.w.a.i) {
                            Log.d("UploadFileTask", Log.getStackTraceString(e));
                        }
                        b.this.F(this.f48621a, -1, e.getMessage());
                    }
                }
                d.b.g0.g.w.h.a aVar = new d.b.g0.g.w.h.a();
                aVar.statusCode = response.code();
                aVar.header = b.this.L(response.headers());
                aVar.data = b.this.a0(response.body());
                if (d.b.g0.g.w.a.i) {
                    Log.d("UploadFileTask", "onResponse = " + aVar.data);
                }
                b.this.G(aVar);
            } catch (IOException e4) {
                e = e4;
                if (d.b.g0.g.w.a.i) {
                }
                b.this.F(this.f48621a, -1, e.getMessage());
            }
        }
    }

    /* renamed from: d.b.g0.g.w.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0997b implements d.b.g0.a.g1.n.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f48624a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48625b;

        public C0997b(long j, String str) {
            this.f48624a = j;
            this.f48625b = str;
        }

        @Override // d.b.g0.a.g1.n.a
        public void a(long j) {
            b.this.Y(this.f48624a, j, this.f48625b);
        }
    }

    public b(d.b.g0.g.i.b bVar, d.b.g0.g.e.d.c cVar) {
        super(bVar, cVar);
        this.l = 0L;
        this.f48585e = 3;
    }

    public static void b0(MultipartBody.Builder builder, d.b.g0.g.e.d.c cVar) {
        if (builder == null || cVar == null || cVar.l() < 1) {
            return;
        }
        for (String str : cVar.k()) {
            if (!TextUtils.isEmpty(str)) {
                String H = cVar.H(str);
                if (!TextUtils.isEmpty(H)) {
                    builder.addFormDataPart(str, H);
                }
            }
        }
    }

    @Override // d.b.g0.g.w.a
    public void F(String str, int i, String str2) {
        super.F(str, i, str2);
        d.b.g0.g.c0.c.k(str, i, str2, SwanAppNetworkUtils.h(null));
    }

    public final Request W() {
        String C = C();
        if (!TextUtils.isEmpty(C)) {
            String B = this.f48586f.B("filePath");
            if (TextUtils.isEmpty(B)) {
                F(C, -1, "uploadFile:filePath is empty or invalid");
                return null;
            } else if (d.o(B)) {
                F(C, -1, "uploadFile:filePath is empty or invalid");
                return null;
            } else if (this.f48586f.b("header") && this.f48586f.i("header") != 9) {
                F(C, -1, "uploadFile:header is invalid");
                return null;
            } else {
                File X = X(C, B);
                if (X != null) {
                    d.b.g0.g.e.d.c w = this.f48586f.w("formData");
                    Request.Builder builder = new Request.Builder();
                    d.b.g0.a.g1.c cVar = new d.b.g0.a.g1.c(X, IMAudioTransRequest.CONTENT_TYPE, new C0997b(X.length(), C));
                    MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    b0(type, w);
                    type.addFormDataPart(this.f48586f.B("name"), X.getName(), cVar);
                    MultipartBody build = type.build();
                    J(builder, this.f48586f.w("header"), new HashMap(), false);
                    return builder.url(C).tag(this.f48587g).post(build).build();
                }
            }
        }
        return null;
    }

    public final File X(String str, String str2) {
        String m = f.V().y().m(str2);
        if (!TextUtils.isEmpty(m) && !TextUtils.equals(str2, m)) {
            File file = new File(m);
            if (file.exists() && file.isFile()) {
                if (file.length() > 26214400) {
                    F(str, -1, "request:file size > 25 MB");
                    return null;
                } else if (TextUtils.isEmpty(this.f48586f.B("name"))) {
                    F(str, -1, "uploadFile:name is invalid");
                    return null;
                } else if (!this.f48586f.b("formData") || this.f48586f.i("formData") == 9) {
                    return file;
                } else {
                    F(str, -1, "uploadFile:formData is invalid");
                    return null;
                }
            }
            F(str, -1, "request:file not exists or not file");
            return null;
        }
        F(str, -1, "uploadFile:filePath is empty or invalid");
        return null;
    }

    public final void Y(long j, long j2, String str) {
        if (j <= 0 || j2 > j || j2 == 0) {
            return;
        }
        int floor = (int) Math.floor((100 * j2) / j);
        if (System.currentTimeMillis() - this.l > 500 || floor == 100) {
            if (floor <= 100) {
                dispatchEvent(new JSEvent("progressUpdate", new c(floor, j, j2)));
            }
            this.l = System.currentTimeMillis();
        }
    }

    public final void Z(String str, int i, String str2) {
        if (d.b.g0.g.w.a.i) {
            Log.d("UploadFileTask", "onFailure: " + str2);
        }
        F(str, i, ("Socket is closed".equalsIgnoreCase(str2) || ResponseException.CANCELED.equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
    }

    public final Object a0(ResponseBody responseBody) throws IOException {
        if (responseBody == null) {
            return null;
        }
        String string = responseBody.string();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return string;
        }
    }

    public void start() {
        Request W;
        if (this.f48586f == null || (W = W()) == null) {
            return;
        }
        if (d.b.g0.a.r1.e.y() == null) {
            F("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = W.url().toString();
        d.b.g0.g.w.b V = d.b.g0.a.r1.e.y().V();
        V.b(W, new a(httpUrl, V));
    }
}
