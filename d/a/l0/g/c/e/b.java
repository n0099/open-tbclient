package d.a.l0.g.c.e;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47028d = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f47029a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f47030b;

    /* renamed from: c  reason: collision with root package name */
    public d f47031c = new d();

    /* renamed from: d.a.l0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0999b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47032e;

        /* renamed from: f  reason: collision with root package name */
        public String f47033f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().t(this.f47033f);
            d.a.l0.g.c.a.n().l(this.f47032e);
            d.a.l0.g.c.a.n().k();
        }

        public RunnableC0999b(String str, String str2) {
            this.f47032e = str;
            this.f47033f = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f47034e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f47035f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.l0.g.c.f.a f47036g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f47037h;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().G(this.f47035f);
            d.a.l0.g.c.i.c.a(this.f47034e.optString("packageName"), "installApp", null, null, new d.a.l0.g.c.i.a(this.f47035f));
            b.d(this.f47037h, this.f47034e, this.f47036g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.a.l0.g.c.f.a aVar, Activity activity) {
            this.f47034e = jSONObject;
            this.f47035f = jSONObject2;
            this.f47036g = aVar;
            this.f47037h = activity;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f47038a;

        /* renamed from: b  reason: collision with root package name */
        public String f47039b;

        public d() {
        }

        @Override // d.a.l0.g.c.f.a
        public void a(String str) {
            this.f47039b = str;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            if (b.f47028d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f47038a);
            }
            b.this.f(bVar);
            d.a.l0.g.c.c.b.f46988d.execute(new RunnableC0999b(this.f47039b, this.f47038a));
        }

        @Override // d.a.l0.g.c.f.a
        public void setPackageName(String str) {
            this.f47038a = str;
        }
    }

    public static void d(Activity activity, @NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.a aVar) {
        String optString = jSONObject.optString("url");
        boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
        String optString2 = jSONObject.optString("packageName");
        if (d.a.l0.g.c.a.n().y(optString) == null && optBoolean) {
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            d.a.l0.h.t.a.c().d(optString, optString2);
            return;
        }
        d.a.l0.g.c.a.n().r(activity, optString, optString2, aVar);
    }

    public final void e() {
        if (this.f47031c != null) {
            d.a.l0.g.c.a.n().B(this.f47029a, this.f47031c);
            this.f47031c = null;
        }
        this.f47031c = null;
    }

    public final void f(d.a.l0.g.c.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f1974a, bVar.c());
            if (!bVar.d()) {
                d.a.l0.g.c.i.c.a(this.f47029a, "installApp", "fail", String.valueOf(bVar.c()), new d.a.l0.g.c.i.a(this.f47030b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f47028d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f47029a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f47028d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f47030b = w.d(this.mParams.getString("ubc_params", ""));
        JSONObject d2 = w.d(this.mParams.getString("data", ""));
        String optString = d2.optString("packageName");
        this.f47029a = optString;
        this.mResult.putString("packageName", optString);
        d.a.l0.g.c.c.b.f46988d.execute(new c(d2, this.f47030b, this.f47031c, getAgent()));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f47028d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f47029a);
        }
        d.a.l0.g.c.i.c.a(this.f47029a, "installApp", "fail", String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new d.a.l0.g.c.i.a(this.f47030b));
        e();
    }
}
