package d.b.g0.a.t.c.e;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.storage.PathType;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.p;
import d.b.g0.a.i2.t;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import d.b.g0.a.t.e.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0801a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f45984e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45985f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45986g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f45987h;

        public RunnableC0801a(File file, int i, String str, e eVar) {
            this.f45984e = file;
            this.f45985f = i;
            this.f45986g = str;
            this.f45987h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            File c2 = t.c(this.f45984e.getName());
            if (!t.a(this.f45984e, c2, this.f45985f)) {
                c.b("Api-Image", "compress image failed");
                a.this.c(this.f45986g, new b(1001, "compress image failed"));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempFilePath", d.b.g0.a.a2.b.r(c2.getAbsolutePath(), this.f45987h.f45739f));
            } catch (JSONException e2) {
                c.b("Api-Image", e2.toString());
            }
            a.this.c(this.f45986g, new b(0, jSONObject));
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public b q(String str) {
        Pair<b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Image", str);
        b bVar = (b) a2.first;
        if (!bVar.b()) {
            c.b("Api-Image", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.b("Api-Image", "empty cb");
            return new b(202, "empty cb");
        }
        return r(optString, jSONObject.optString(UserAccountActionItem.KEY_SRC), jSONObject.optInt("quality", 80));
    }

    public final b r(String str, String str2, int i) {
        e y = e.y();
        if (y == null) {
            return new b(1001, "swan app is null");
        }
        int i2 = (i < 0 || i > 100) ? 80 : i;
        if (TextUtils.isEmpty(str2)) {
            c.b("Api-Image", "src is null");
            return new b(202, "src is null");
        }
        PathType c2 = d.b.g0.a.a2.b.c(str2);
        String str3 = null;
        if (c2 == PathType.BD_FILE) {
            str3 = d.b.g0.a.a2.b.u(str2, y.f45739f);
        } else if (c2 == PathType.RELATIVE) {
            str3 = d.b.g0.a.a2.b.t(str2, y, y.W());
        }
        if (TextUtils.isEmpty(str3)) {
            c.b("Api-Image", "file path error");
            return new b(2001, "file path error");
        }
        File file = new File(str3);
        if (!file.exists()) {
            c.b("Api-Image", "file does not exist");
            return new b(2001, "file does not exist");
        }
        p.k(new RunnableC0801a(file, i2, str, y), "compressImage");
        return new b(0);
    }
}
