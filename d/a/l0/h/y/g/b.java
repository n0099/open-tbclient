package d.a.l0.h.y.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.l0.a.g1.f;
import d.a.l0.h.y.f.e;
import d.a.l0.t.d;
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
public class b extends d.a.l0.h.y.a {
    public long l;

    /* loaded from: classes3.dex */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47756a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.y.b f47757b;

        public a(String str, d.a.l0.h.y.b bVar) {
            this.f47756a = str;
            this.f47757b = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f47757b.cancelTag(b.this.f47722g);
            b.this.Y(this.f47756a, 0, iOException.getMessage());
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
                    jSEvent.data = new e(b.this.K(response.headers()));
                    b.this.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    try {
                        if (d.a.l0.h.y.a.f47719i) {
                            e2.printStackTrace();
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        if (d.a.l0.h.y.a.f47719i) {
                            Log.d("UploadFileTask", Log.getStackTraceString(e));
                        }
                        b.this.E(this.f47756a, -1, e.getMessage());
                    }
                }
                d.a.l0.h.y.g.a aVar = new d.a.l0.h.y.g.a();
                aVar.statusCode = response.code();
                aVar.header = b.this.K(response.headers());
                aVar.data = b.this.Z(response.body());
                if (d.a.l0.h.y.a.f47719i) {
                    Log.d("UploadFileTask", "onResponse = " + aVar.data);
                }
                b.this.F(aVar);
            } catch (IOException e4) {
                e = e4;
                if (d.a.l0.h.y.a.f47719i) {
                }
                b.this.E(this.f47756a, -1, e.getMessage());
            }
        }
    }

    /* renamed from: d.a.l0.h.y.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1059b implements d.a.l0.a.n1.p.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f47759a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47760b;

        public C1059b(long j, String str) {
            this.f47759a = j;
            this.f47760b = str;
        }

        @Override // d.a.l0.a.n1.p.a
        public void a(long j) {
            b.this.X(this.f47759a, j, this.f47760b);
        }
    }

    public b(d.a.l0.a.l0.c cVar, d.a.l0.a.y.b.a aVar) {
        super(cVar, aVar);
        this.l = 0L;
        this.f47720e = 3;
    }

    public static void a0(MultipartBody.Builder builder, d.a.l0.a.y.b.a aVar) {
        if (builder == null || aVar == null || aVar.l() < 1) {
            return;
        }
        for (String str : aVar.k()) {
            if (!TextUtils.isEmpty(str)) {
                String I = aVar.I(str);
                if (!TextUtils.isEmpty(I)) {
                    builder.addFormDataPart(str, I);
                }
            }
        }
    }

    @Override // d.a.l0.h.y.a
    public void E(String str, int i2, String str2) {
        super.E(str, i2, str2);
        d.a.l0.h.f0.e.k(str, i2, str2, SwanAppNetworkUtils.i(null));
    }

    public final Request V() {
        String B = B();
        if (!TextUtils.isEmpty(B)) {
            String C = this.f47721f.C("filePath");
            if (TextUtils.isEmpty(C)) {
                E(B, -1, "uploadFile:filePath is empty or invalid");
                return null;
            } else if (d.w(C)) {
                E(B, -1, "uploadFile:filePath is empty or invalid");
                return null;
            } else if (this.f47721f.b("header") && this.f47721f.i("header") != 9) {
                E(B, -1, "uploadFile:header is invalid");
                return null;
            } else {
                File W = W(B, C);
                if (W != null) {
                    d.a.l0.a.y.b.a x = this.f47721f.x("formData");
                    Request.Builder builder = new Request.Builder();
                    d.a.l0.a.n1.c cVar = new d.a.l0.a.n1.c(W, IMAudioTransRequest.CONTENT_TYPE, new C1059b(W.length(), B));
                    MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    a0(type, x);
                    type.addFormDataPart(this.f47721f.C("name"), W.getName(), cVar);
                    MultipartBody build = type.build();
                    I(builder, this.f47721f.x("header"), new HashMap(), false);
                    return builder.url(B).tag(this.f47722g).post(build).build();
                }
            }
        }
        return null;
    }

    public final File W(String str, String str2) {
        String a2 = f.V().I().a(str2);
        if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
            File file = new File(a2);
            if (file.exists() && file.isFile()) {
                if (file.length() > 26214400) {
                    E(str, -1, "request:file size > 25 MB");
                    return null;
                } else if (TextUtils.isEmpty(this.f47721f.C("name"))) {
                    E(str, -1, "uploadFile:name is invalid");
                    return null;
                } else if (!this.f47721f.b("formData") || this.f47721f.i("formData") == 9) {
                    return file;
                } else {
                    E(str, -1, "uploadFile:formData is invalid");
                    return null;
                }
            }
            E(str, -1, "request:file not exists or not file");
            return null;
        }
        E(str, -1, "uploadFile:filePath is empty or invalid");
        return null;
    }

    public final void X(long j, long j2, String str) {
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

    public final void Y(String str, int i2, String str2) {
        if (d.a.l0.h.y.a.f47719i) {
            Log.d("UploadFileTask", "onFailure: " + str2);
        }
        E(str, i2, ("Socket is closed".equalsIgnoreCase(str2) || ResponseException.CANCELED.equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
    }

    public final Object Z(ResponseBody responseBody) throws IOException {
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
        Request V;
        if (this.f47721f == null || (V = V()) == null) {
            return;
        }
        if (d.a.l0.a.a2.e.i() == null) {
            E("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = V.url().toString();
        d.a.l0.h.y.b bVar = (d.a.l0.h.y.b) d.a.l0.a.a2.e.i().X();
        bVar.b(V, new a(httpUrl, bVar));
    }
}
