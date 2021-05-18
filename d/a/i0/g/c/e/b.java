package d.a.i0.g.c.e;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import d.a.i0.a.k;
import d.a.i0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46852d = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f46853a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f46854b;

    /* renamed from: c  reason: collision with root package name */
    public d f46855c = new d();

    /* renamed from: d.a.i0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0988b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f46856e;

        /* renamed from: f  reason: collision with root package name */
        public String f46857f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.g.c.a.n().t(this.f46857f);
            d.a.i0.g.c.a.n().l(this.f46856e);
            d.a.i0.g.c.a.n().k();
        }

        public RunnableC0988b(String str, String str2) {
            this.f46856e = str;
            this.f46857f = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f46858e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f46859f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.i0.g.c.f.a f46860g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f46861h;

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.g.c.a.n().G(this.f46859f);
            d.a.i0.g.c.i.c.a(this.f46858e.optString("packageName"), "installApp", null, null, new d.a.i0.g.c.i.a(this.f46859f));
            b.d(this.f46861h, this.f46858e, this.f46860g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.a.i0.g.c.f.a aVar, Activity activity) {
            this.f46858e = jSONObject;
            this.f46859f = jSONObject2;
            this.f46860g = aVar;
            this.f46861h = activity;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f46862a;

        /* renamed from: b  reason: collision with root package name */
        public String f46863b;

        public d() {
        }

        @Override // d.a.i0.g.c.f.a
        public void a(String str) {
            this.f46863b = str;
        }

        @Override // d.a.i0.g.c.f.b
        public void b(d.a.i0.g.c.g.b bVar) {
            if (b.f46852d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f46862a);
            }
            b.this.f(bVar);
            d.a.i0.g.c.c.b.f46812d.execute(new RunnableC0988b(this.f46863b, this.f46862a));
        }

        @Override // d.a.i0.g.c.f.a
        public void setPackageName(String str) {
            this.f46862a = str;
        }
    }

    public static void d(Activity activity, @NonNull JSONObject jSONObject, @NonNull d.a.i0.g.c.f.a aVar) {
        String optString = jSONObject.optString("url");
        boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
        String optString2 = jSONObject.optString("packageName");
        if (d.a.i0.g.c.a.n().y(optString) == null && optBoolean) {
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            d.a.i0.h.t.a.c().d(optString, optString2);
            return;
        }
        d.a.i0.g.c.a.n().r(activity, optString, optString2, aVar);
    }

    public final void e() {
        if (this.f46855c != null) {
            d.a.i0.g.c.a.n().B(this.f46853a, this.f46855c);
            this.f46855c = null;
        }
        this.f46855c = null;
    }

    public final void f(d.a.i0.g.c.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f1974a, bVar.c());
            if (!bVar.d()) {
                d.a.i0.g.c.i.c.a(this.f46853a, "installApp", "fail", String.valueOf(bVar.c()), new d.a.i0.g.c.i.a(this.f46854b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f46852d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f46853a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f46852d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f46854b = w.d(this.mParams.getString("ubc_params", ""));
        JSONObject d2 = w.d(this.mParams.getString("data", ""));
        String optString = d2.optString("packageName");
        this.f46853a = optString;
        this.mResult.putString("packageName", optString);
        d.a.i0.g.c.c.b.f46812d.execute(new c(d2, this.f46854b, this.f46855c, getAgent()));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f46852d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f46853a);
        }
        d.a.i0.g.c.i.c.a(this.f46853a, "installApp", "fail", String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new d.a.i0.g.c.i.a(this.f46854b));
        e();
    }
}
