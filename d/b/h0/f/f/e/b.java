package d.b.h0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import d.b.h0.a.i2.v;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48524d = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f48525a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f48526b;

    /* renamed from: c  reason: collision with root package name */
    public d f48527c = new d();

    /* renamed from: d.b.h0.f.f.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0976b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48528e;

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.f.f.a.l().j(this.f48528e);
            d.b.h0.f.f.a.l().i();
        }

        public RunnableC0976b(String str) {
            this.f48528e = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f48529e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f48530f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.h0.f.f.f.a f48531g;

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.f.f.a.l().y(this.f48530f);
            d.b.h0.f.f.h.c.a(this.f48529e.optString("packageName"), "installApp", null, null, new d.b.h0.f.f.h.a(this.f48530f));
            b.d(this.f48529e, this.f48531g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.b.h0.f.f.f.a aVar) {
            this.f48529e = jSONObject;
            this.f48530f = jSONObject2;
            this.f48531g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.h0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48532a;

        /* renamed from: b  reason: collision with root package name */
        public String f48533b;

        public d() {
        }

        @Override // d.b.h0.f.f.f.b
        public void a(d.b.h0.f.f.g.b bVar) {
            if (b.f48524d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f48532a);
            }
            b.this.f(bVar);
            d.b.h0.f.f.c.b.f48490d.execute(new RunnableC0976b(this.f48533b));
        }

        @Override // d.b.h0.f.f.f.a
        public void b(String str) {
            this.f48533b = str;
        }

        @Override // d.b.h0.f.f.f.a
        public void setPackageName(String str) {
            this.f48532a = str;
        }
    }

    public static void d(@NonNull JSONObject jSONObject, @NonNull d.b.h0.f.f.f.a aVar) {
        d.b.h0.f.f.a.l().n(jSONObject.optString("url"), aVar);
    }

    public final void e() {
        if (this.f48527c != null) {
            d.b.h0.f.f.a.l().u(this.f48525a, this.f48527c);
            this.f48527c = null;
        }
        this.f48527c = null;
    }

    public final void f(d.b.h0.f.f.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f2017a, bVar.c());
            if (!bVar.d()) {
                d.b.h0.f.f.h.c.a(this.f48525a, "installApp", "fail", String.valueOf(bVar.c()), new d.b.h0.f.f.h.a(this.f48526b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f48524d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f48525a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f48524d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f48526b = v.b(this.mParams.getString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, ""));
        JSONObject b2 = v.b(this.mParams.getString("data", ""));
        String optString = b2.optString("packageName");
        this.f48525a = optString;
        this.mResult.putString("packageName", optString);
        d.b.h0.f.f.c.b.f48490d.execute(new c(b2, this.f48526b, this.f48527c));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f48524d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f48525a);
        }
        d.b.h0.f.f.h.c.a(this.f48525a, "installApp", "fail", String.valueOf(31003), new d.b.h0.f.f.h.a(this.f48526b));
        e();
    }
}
