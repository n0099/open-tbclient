package d.a.i0.a.u.e.p;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.PushManager;
import d.a.i0.a.v2.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.u.c.d {

    /* renamed from: d.a.i0.a.u.e.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0856a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f45012e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45013f;

        public RunnableC0856a(JSONArray jSONArray, String str) {
            this.f45012e = jSONArray;
            this.f45013f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(this.f45013f, a.this.x(this.f45012e));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45016f;

        public b(String str, String str2) {
            this.f45015e = str;
            this.f45016f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(this.f45016f, a.this.v(this.f45015e));
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void t(String str, String str2) {
        q.e().execute(new b(str, str2));
    }

    public d.a.i0.a.u.h.b u(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-CheckAppInstall", "start check app install");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-CheckAppInstall", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-CheckAppInstall", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("name");
        JSONArray optJSONArray = jSONObject.optJSONArray("name");
        String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString) && optJSONArray == null) {
            d.a.i0.a.e0.d.b("Api-CheckAppInstall", "parameter error");
            return new d.a.i0.a.u.h.b(201, "parameter error");
        }
        boolean z = optJSONArray == null;
        if (TextUtils.isEmpty(optString2)) {
            if (z) {
                return v(optString);
            }
            return x(optJSONArray);
        }
        if (z) {
            t(optString, optString2);
        } else {
            w(optJSONArray, optString2);
        }
        return new d.a.i0.a.u.h.b(0);
    }

    public final d.a.i0.a.u.h.b v(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = i().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            d.a.i0.a.e0.d.l("Api-CheckAppInstall", str + " cannot be found");
            packageInfo = null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (packageInfo != null) {
                jSONObject.put("hasApp", true);
                jSONObject.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                jSONObject.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
            } else {
                jSONObject.put("hasApp", false);
            }
            return new d.a.i0.a.u.h.b(0, "success", jSONObject);
        } catch (JSONException e2) {
            d.a.i0.a.e0.d.c("Api-CheckAppInstall", "internal error: " + e2.getMessage(), e2);
            return new d.a.i0.a.u.h.b(1001, "internal error: " + e2.getMessage());
        }
    }

    public final void w(JSONArray jSONArray, String str) {
        q.e().execute(new RunnableC0856a(jSONArray, str));
    }

    public final d.a.i0.a.u.h.b x(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(string, y(string));
                }
            } catch (JSONException e2) {
                d.a.i0.a.e0.d.c("Api-CheckAppInstall", "internal error: " + e2.getMessage(), e2);
            }
        }
        return new d.a.i0.a.u.h.b(0, "success", jSONObject);
    }

    public final boolean y(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = i().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            d.a.i0.a.e0.d.l("Api-CheckAppInstall", str + " cannot be found");
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
