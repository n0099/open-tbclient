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
    public static final boolean f50702d = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f50703a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f50704b;

    /* renamed from: c  reason: collision with root package name */
    public d f50705c = new d();

    /* renamed from: d.a.l0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1055b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f50706e;

        /* renamed from: f  reason: collision with root package name */
        public String f50707f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().t(this.f50707f);
            d.a.l0.g.c.a.n().l(this.f50706e);
            d.a.l0.g.c.a.n().k();
        }

        public RunnableC1055b(String str, String str2) {
            this.f50706e = str;
            this.f50707f = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f50708e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f50709f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.l0.g.c.f.a f50710g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f50711h;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().G(this.f50709f);
            d.a.l0.g.c.i.c.a(this.f50708e.optString("packageName"), "installApp", null, null, new d.a.l0.g.c.i.a(this.f50709f));
            b.d(this.f50711h, this.f50708e, this.f50710g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.a.l0.g.c.f.a aVar, Activity activity) {
            this.f50708e = jSONObject;
            this.f50709f = jSONObject2;
            this.f50710g = aVar;
            this.f50711h = activity;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f50712a;

        /* renamed from: b  reason: collision with root package name */
        public String f50713b;

        public d() {
        }

        @Override // d.a.l0.g.c.f.a
        public void a(String str) {
            this.f50713b = str;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            if (b.f50702d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f50712a);
            }
            b.this.f(bVar);
            d.a.l0.g.c.c.b.f50662d.execute(new RunnableC1055b(this.f50713b, this.f50712a));
        }

        @Override // d.a.l0.g.c.f.a
        public void setPackageName(String str) {
            this.f50712a = str;
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
        if (this.f50705c != null) {
            d.a.l0.g.c.a.n().B(this.f50703a, this.f50705c);
            this.f50705c = null;
        }
        this.f50705c = null;
    }

    public final void f(d.a.l0.g.c.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f1987a, bVar.c());
            if (!bVar.d()) {
                d.a.l0.g.c.i.c.a(this.f50703a, "installApp", com.baidu.pass.biometrics.face.liveness.b.b.g0, String.valueOf(bVar.c()), new d.a.l0.g.c.i.a(this.f50704b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f50702d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f50703a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f50702d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f50704b = w.d(this.mParams.getString("ubc_params", ""));
        JSONObject d2 = w.d(this.mParams.getString("data", ""));
        String optString = d2.optString("packageName");
        this.f50703a = optString;
        this.mResult.putString("packageName", optString);
        d.a.l0.g.c.c.b.f50662d.execute(new c(d2, this.f50704b, this.f50705c, getAgent()));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f50702d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f50703a);
        }
        d.a.l0.g.c.i.c.a(this.f50703a, "installApp", com.baidu.pass.biometrics.face.liveness.b.b.g0, String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new d.a.l0.g.c.i.a(this.f50704b));
        e();
    }
}
