package d.a.l0.a.u2;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.a.u.c.d;
import d.a.l0.a.u2.a;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d implements a.InterfaceC0873a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45250f = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public String f45251d;

    /* renamed from: e  reason: collision with root package name */
    public String f45252e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j1.d.a f45253e;

        public a(d.a.l0.a.j1.d.a aVar) {
            this.f45253e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.a.c1.a.g().a(b.this.f45251d, this.f45253e)) {
                b.this.u(this.f45253e);
                return;
            }
            b bVar = b.this;
            bVar.d(bVar.f45252e, new d.a.l0.a.u.h.b(2003, "upload fail"));
        }
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    @Override // d.a.l0.a.u2.a.InterfaceC0873a
    public void c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            d(this.f45252e, new d.a.l0.a.u.h.b(2003, "upload fail"));
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            d(this.f45252e, new d.a.l0.a.u.h.b(2003, "upload fail"));
            return;
        }
        String optString = jSONObject.optString("errno");
        if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
            d.a.l0.a.j1.d.a a2 = d.a.l0.a.j1.d.a.a(optJSONObject, str);
            if (TextUtils.isEmpty(a2.f43088e)) {
                d(this.f45252e, new d.a.l0.a.u.h.b(2003, "upload fail"));
                return;
            } else {
                ExecutorUtilsExt.postOnElastic(new a(a2), "doBosUpload", 2);
                return;
            }
        }
        d(this.f45252e, new d.a.l0.a.u.h.b(2003, "upload fail"));
    }

    public final void u(d.a.l0.a.j1.d.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bosUrl", aVar.f43088e);
            d(this.f45252e, new d.a.l0.a.u.h.b(0, jSONObject));
        } catch (JSONException e2) {
            if (f45250f) {
                e2.printStackTrace();
            }
            d(this.f45252e, new d.a.l0.a.u.h.b(2003, "upload fail"));
        }
    }

    public final boolean v(File file) {
        return file.length() > 52428800;
    }

    public d.a.l0.a.u.h.b w(String str) {
        if (f45250f) {
            Log.d("Api-UploadBosApi", "handle: " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-UploadBosApi", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (bVar.a()) {
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            this.f45252e = optString;
            if (TextUtils.isEmpty(optString)) {
                return new d.a.l0.a.u.h.b(202);
            }
            String optString2 = jSONObject.optString("filePath");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.l0.a.u.h.b(202);
            }
            f V = f.V();
            String i2 = V.I().i(optString2);
            this.f45251d = i2;
            if (TextUtils.isEmpty(i2)) {
                return new d.a.l0.a.u.h.b(2001, "file not found");
            }
            File file = new File(this.f45251d);
            if (file.exists() && file.isFile()) {
                if (v(file)) {
                    return new d.a.l0.a.u.h.b(2002, "file over size");
                }
                if (!d.a.l0.a.a2.d.g().r().j().e(V.getActivity())) {
                    return new d.a.l0.a.u.h.b(10004, "user not logged in");
                }
                d.a.l0.a.c1.a.g().b(V.getActivity(), this.f45251d, this);
                return new d.a.l0.a.u.h.b(0);
            }
            return new d.a.l0.a.u.h.b(2001, "file not found");
        }
        return bVar;
    }
}
