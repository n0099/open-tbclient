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
    public static final boolean f47803d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f47804a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f47805b;

    /* renamed from: c  reason: collision with root package name */
    public d f47806c = new d();

    /* renamed from: d.b.g0.f.f.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0944b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47807e;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().j(this.f47807e);
            d.b.g0.f.f.a.l().i();
        }

        public RunnableC0944b(String str) {
            this.f47807e = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f47808e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f47809f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.g0.f.f.f.a f47810g;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().y(this.f47809f);
            d.b.g0.f.f.h.c.a(this.f47808e.optString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME), "installApp", null, null, new d.b.g0.f.f.h.a(this.f47809f));
            b.d(this.f47808e, this.f47810g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.b.g0.f.f.f.a aVar) {
            this.f47808e = jSONObject;
            this.f47809f = jSONObject2;
            this.f47810g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f47811a;

        /* renamed from: b  reason: collision with root package name */
        public String f47812b;

        public d() {
        }

        @Override // d.b.g0.f.f.f.b
        public void a(d.b.g0.f.f.g.b bVar) {
            if (b.f47803d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f47811a);
            }
            b.this.f(bVar);
            d.b.g0.f.f.c.b.f47769d.execute(new RunnableC0944b(this.f47812b));
        }

        @Override // d.b.g0.f.f.f.a
        public void b(String str) {
            this.f47812b = str;
        }

        @Override // d.b.g0.f.f.f.a
        public void setPackageName(String str) {
            this.f47811a = str;
        }
    }

    public static void d(@NonNull JSONObject jSONObject, @NonNull d.b.g0.f.f.f.a aVar) {
        d.b.g0.f.f.a.l().n(jSONObject.optString("url"), aVar);
    }

    public final void e() {
        if (this.f47806c != null) {
            d.b.g0.f.f.a.l().u(this.f47804a, this.f47806c);
            this.f47806c = null;
        }
        this.f47806c = null;
    }

    public final void f(d.b.g0.f.f.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f1992a, bVar.c());
            if (!bVar.d()) {
                d.b.g0.f.f.h.c.a(this.f47804a, "installApp", "fail", String.valueOf(bVar.c()), new d.b.g0.f.f.h.a(this.f47805b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f47803d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f47804a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f47803d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f47805b = v.b(this.mParams.getString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, ""));
        JSONObject b2 = v.b(this.mParams.getString("data", ""));
        String optString = b2.optString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME);
        this.f47804a = optString;
        this.mResult.putString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, optString);
        d.b.g0.f.f.c.b.f47769d.execute(new c(b2, this.f47805b, this.f47806c));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f47803d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f47804a);
        }
        d.b.g0.f.f.h.c.a(this.f47804a, "installApp", "fail", String.valueOf(31003), new d.b.g0.f.f.h.a(this.f47805b));
        e();
    }
}
