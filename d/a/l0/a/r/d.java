package d.a.l0.a.r;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends c {

    /* loaded from: classes2.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47925a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47927c;

        public a(String str, String str2, CallbackHandler callbackHandler) {
            this.f47925a = str;
            this.f47926b = str2;
            this.f47927c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d dVar = d.this;
            CallbackHandler callbackHandler = this.f47927c;
            String str = this.f47926b;
            dVar.r(callbackHandler, str, null, "downloadFile:fail" + exc.getMessage());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            d.this.s(response, this.f47925a, this.f47926b, this.f47927c);
            return response;
        }
    }

    public d(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/cloudDownloadFile");
    }

    @Override // d.a.l0.a.r.c, d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        return super.d(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // d.a.l0.a.r.c
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        if (!response.isSuccessful()) {
            k(callbackHandler, str, 1001, "downloadFile:fail");
            return;
        }
        String header = response.header("Content-Type", "");
        if (header != null && header.contains("application/json")) {
            JSONObject m = d.a.l0.a.r.a.m(response);
            if (m != null && response.isSuccessful()) {
                String optString = m.optString("errno", String.valueOf(0));
                String optString2 = m.optString("errmsg");
                if (d.a.l0.a.r.a.o(optString)) {
                    r(callbackHandler, str, optString, optString2);
                    return;
                }
                String optString3 = m.optString("DownloadUrl");
                if (TextUtils.isEmpty(optString3)) {
                    r(callbackHandler, str, optString, optString2);
                    return;
                } else {
                    p(optString3, callbackHandler, str);
                    return;
                }
            }
            k(callbackHandler, str, 1001, "downloadFile:fail");
            return;
        }
        k(callbackHandler, str, 1001, "downloadFile:fail");
    }

    public void p(String str, CallbackHandler callbackHandler, String str2) {
        if (d.a.l0.a.a2.e.i() == null) {
            r(callbackHandler, str2, null, null);
        } else {
            q(str, str2, callbackHandler);
        }
    }

    public final void q(String str, String str2, CallbackHandler callbackHandler) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(str, new a(str, str2, callbackHandler));
        aVar.f51648f = true;
        aVar.f51649g = false;
        aVar.f51650h = true;
        d.a.l0.m.e.a.g().d(aVar);
    }

    public final void r(CallbackHandler callbackHandler, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            k(callbackHandler, str, 1001, "downloadFile:fail");
        } else {
            k(callbackHandler, str, 1001, d.a.l0.a.r.a.k(str3));
        }
    }

    public final void s(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (!response.isSuccessful()) {
            r(callbackHandler, str2, null, "downloadFile:fail");
            return;
        }
        String A = d.a.l0.a.c2.f.f.A(response, d.a.l0.t.d.s(str));
        if (TextUtils.isEmpty(A)) {
            r(callbackHandler, str2, null, null);
            return;
        }
        String g2 = d.a.l0.a.g1.f.V().I().g(A);
        if (TextUtils.isEmpty(g2)) {
            r(callbackHandler, str2, null, null);
        } else if (t(response, A)) {
            m(callbackHandler, str2, d.a.l0.a.r.a.n(null, g2, "downloadFile:ok"));
        } else {
            r(callbackHandler, str2, null, null);
        }
    }

    public boolean t(Response response, String str) {
        InputStream byteStream = response.body() != null ? response.body().byteStream() : null;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e2) {
                if (c.f47921c) {
                    e2.printStackTrace();
                }
            }
        }
        return d.a.l0.t.g.a(byteStream, file);
    }
}
