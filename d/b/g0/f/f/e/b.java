package d.b.g0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import d.b.g0.a.i2.v;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48195d = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f48196a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f48197b;

    /* renamed from: c  reason: collision with root package name */
    public d f48198c = new d();

    /* renamed from: d.b.g0.f.f.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0956b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48199e;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().j(this.f48199e);
            d.b.g0.f.f.a.l().i();
        }

        public RunnableC0956b(String str) {
            this.f48199e = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f48200e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f48201f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.g0.f.f.f.a f48202g;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().y(this.f48201f);
            d.b.g0.f.f.h.c.a(this.f48200e.optString("packageName"), "installApp", null, null, new d.b.g0.f.f.h.a(this.f48201f));
            b.d(this.f48200e, this.f48202g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.b.g0.f.f.f.a aVar) {
            this.f48200e = jSONObject;
            this.f48201f = jSONObject2;
            this.f48202g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48203a;

        /* renamed from: b  reason: collision with root package name */
        public String f48204b;

        public d() {
        }

        @Override // d.b.g0.f.f.f.b
        public void a(d.b.g0.f.f.g.b bVar) {
            if (b.f48195d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f48203a);
            }
            b.this.f(bVar);
            d.b.g0.f.f.c.b.f48161d.execute(new RunnableC0956b(this.f48204b));
        }

        @Override // d.b.g0.f.f.f.a
        public void b(String str) {
            this.f48204b = str;
        }

        @Override // d.b.g0.f.f.f.a
        public void setPackageName(String str) {
            this.f48203a = str;
        }
    }

    public static void d(@NonNull JSONObject jSONObject, @NonNull d.b.g0.f.f.f.a aVar) {
        d.b.g0.f.f.a.l().n(jSONObject.optString("url"), aVar);
    }

    public final void e() {
        if (this.f48198c != null) {
            d.b.g0.f.f.a.l().u(this.f48196a, this.f48198c);
            this.f48198c = null;
        }
        this.f48198c = null;
    }

    public final void f(d.b.g0.f.f.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f2017a, bVar.c());
            if (!bVar.d()) {
                d.b.g0.f.f.h.c.a(this.f48196a, "installApp", "fail", String.valueOf(bVar.c()), new d.b.g0.f.f.h.a(this.f48197b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f48195d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f48196a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f48195d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f48197b = v.b(this.mParams.getString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, ""));
        JSONObject b2 = v.b(this.mParams.getString("data", ""));
        String optString = b2.optString("packageName");
        this.f48196a = optString;
        this.mResult.putString("packageName", optString);
        d.b.g0.f.f.c.b.f48161d.execute(new c(b2, this.f48197b, this.f48198c));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f48195d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f48196a);
        }
        d.b.g0.f.f.h.c.a(this.f48196a, "installApp", "fail", String.valueOf(31003), new d.b.g0.f.f.h.a(this.f48197b));
        e();
    }
}
