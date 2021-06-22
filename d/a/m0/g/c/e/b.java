package d.a.m0.g.c.e;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import d.a.m0.a.k;
import d.a.m0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f50810d = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f50811a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f50812b;

    /* renamed from: c  reason: collision with root package name */
    public d f50813c = new d();

    /* renamed from: d.a.m0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1058b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f50814e;

        /* renamed from: f  reason: collision with root package name */
        public String f50815f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.g.c.a.n().t(this.f50815f);
            d.a.m0.g.c.a.n().l(this.f50814e);
            d.a.m0.g.c.a.n().k();
        }

        public RunnableC1058b(String str, String str2) {
            this.f50814e = str;
            this.f50815f = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f50816e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f50817f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.m0.g.c.f.a f50818g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f50819h;

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.g.c.a.n().G(this.f50817f);
            d.a.m0.g.c.i.c.a(this.f50816e.optString("packageName"), "installApp", null, null, new d.a.m0.g.c.i.a(this.f50817f));
            b.d(this.f50819h, this.f50816e, this.f50818g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.a.m0.g.c.f.a aVar, Activity activity) {
            this.f50816e = jSONObject;
            this.f50817f = jSONObject2;
            this.f50818g = aVar;
            this.f50819h = activity;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f50820a;

        /* renamed from: b  reason: collision with root package name */
        public String f50821b;

        public d() {
        }

        @Override // d.a.m0.g.c.f.a
        public void a(String str) {
            this.f50821b = str;
        }

        @Override // d.a.m0.g.c.f.b
        public void b(d.a.m0.g.c.g.b bVar) {
            if (b.f50810d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f50820a);
            }
            b.this.f(bVar);
            d.a.m0.g.c.c.b.f50770d.execute(new RunnableC1058b(this.f50821b, this.f50820a));
        }

        @Override // d.a.m0.g.c.f.a
        public void setPackageName(String str) {
            this.f50820a = str;
        }
    }

    public static void d(Activity activity, @NonNull JSONObject jSONObject, @NonNull d.a.m0.g.c.f.a aVar) {
        String optString = jSONObject.optString("url");
        boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
        String optString2 = jSONObject.optString("packageName");
        if (d.a.m0.g.c.a.n().y(optString) == null && optBoolean) {
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            d.a.m0.h.t.a.c().d(optString, optString2);
            return;
        }
        d.a.m0.g.c.a.n().r(activity, optString, optString2, aVar);
    }

    public final void e() {
        if (this.f50813c != null) {
            d.a.m0.g.c.a.n().B(this.f50811a, this.f50813c);
            this.f50813c = null;
        }
        this.f50813c = null;
    }

    public final void f(d.a.m0.g.c.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f1987a, bVar.c());
            if (!bVar.d()) {
                d.a.m0.g.c.i.c.a(this.f50811a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.m0.g.c.i.a(this.f50812b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f50810d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f50811a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f50810d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f50812b = w.d(this.mParams.getString("ubc_params", ""));
        JSONObject d2 = w.d(this.mParams.getString("data", ""));
        String optString = d2.optString("packageName");
        this.f50811a = optString;
        this.mResult.putString("packageName", optString);
        d.a.m0.g.c.c.b.f50770d.execute(new c(d2, this.f50812b, this.f50813c, getAgent()));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f50810d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f50811a);
        }
        d.a.m0.g.c.i.c.a(this.f50811a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new d.a.m0.g.c.i.a(this.f50812b));
        e();
    }
}
