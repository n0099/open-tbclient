package d.a.m0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import d.a.m0.a.a2.e;
import d.a.m0.a.u.c.d;
import d.a.m0.a.u.h.b;
import d.a.m0.a.v2.q;
import d.a.m0.a.v2.u;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.m0.a.u.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0898a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f48690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48691f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48692g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f48693h;

        public RunnableC0898a(File file, int i2, String str, e eVar) {
            this.f48690e = file;
            this.f48691f = i2;
            this.f48692g = str;
            this.f48693h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            File k = u.k(this.f48690e.getName());
            if (!u.b(this.f48690e, k, this.f48691f)) {
                d.a.m0.a.e0.d.b("Api-Image", "compress image failed");
                a.this.d(this.f48692g, new b(1001, "compress image failed"));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempFilePath", d.a.m0.a.k2.b.J(k.getAbsolutePath(), this.f48693h.f44533f));
            } catch (JSONException e2) {
                d.a.m0.a.e0.d.b("Api-Image", e2.toString());
            }
            a.this.d(this.f48692g, new b(0, jSONObject));
        }
    }

    public a(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public b r(String str) {
        Pair<b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-Image", str);
        b bVar = (b) b2.first;
        if (!bVar.isSuccess()) {
            d.a.m0.a.e0.d.b("Api-Image", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("Api-Image", "empty cb");
            return new b(202, "empty cb");
        }
        return s(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
    }

    public final b s(String str, String str2, int i2) {
        e i3 = e.i();
        if (i3 == null) {
            return new b(1001, "swan app is null");
        }
        int i4 = (i2 < 0 || i2 > 100) ? 80 : i2;
        if (TextUtils.isEmpty(str2)) {
            d.a.m0.a.e0.d.b("Api-Image", "src is null");
            return new b(202, "src is null");
        }
        PathType s = d.a.m0.a.k2.b.s(str2);
        String str3 = null;
        if (s == PathType.BD_FILE) {
            str3 = d.a.m0.a.k2.b.M(str2, i3.f44533f);
        } else if (s == PathType.RELATIVE) {
            str3 = d.a.m0.a.k2.b.L(str2, i3, i3.Z());
        }
        if (TextUtils.isEmpty(str3)) {
            d.a.m0.a.e0.d.b("Api-Image", "file path error");
            return new b(2001, "file path error");
        }
        File file = new File(str3);
        if (!file.exists()) {
            d.a.m0.a.e0.d.b("Api-Image", "file does not exist");
            return new b(2001, "file does not exist");
        }
        q.j(new RunnableC0898a(file, i4, str, i3), "compressImage");
        return new b(0);
    }
}
