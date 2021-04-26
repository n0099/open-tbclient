package d.a.h0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import d.a.h0.a.i2.v;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45984d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f45985a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f45986b;

    /* renamed from: c  reason: collision with root package name */
    public d f45987c = new d();

    /* renamed from: d.a.h0.f.f.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0915b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f45988e;

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.f.f.a.l().j(this.f45988e);
            d.a.h0.f.f.a.l().i();
        }

        public RunnableC0915b(String str) {
            this.f45988e = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f45989e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f45990f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.h0.f.f.f.a f45991g;

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.f.f.a.l().y(this.f45990f);
            d.a.h0.f.f.h.c.a(this.f45989e.optString("packageName"), "installApp", null, null, new d.a.h0.f.f.h.a(this.f45990f));
            b.d(this.f45989e, this.f45991g);
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.a.h0.f.f.f.a aVar) {
            this.f45989e = jSONObject;
            this.f45990f = jSONObject2;
            this.f45991g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f45992a;

        /* renamed from: b  reason: collision with root package name */
        public String f45993b;

        public d() {
        }

        @Override // d.a.h0.f.f.f.a
        public void a(String str) {
            this.f45993b = str;
        }

        @Override // d.a.h0.f.f.f.b
        public void b(d.a.h0.f.f.g.b bVar) {
            if (b.f45984d) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f45992a);
            }
            b.this.f(bVar);
            d.a.h0.f.f.c.b.f45950d.execute(new RunnableC0915b(this.f45993b));
        }

        @Override // d.a.h0.f.f.f.a
        public void setPackageName(String str) {
            this.f45992a = str;
        }
    }

    public static void d(@NonNull JSONObject jSONObject, @NonNull d.a.h0.f.f.f.a aVar) {
        d.a.h0.f.f.a.l().n(jSONObject.optString("url"), aVar);
    }

    public final void e() {
        if (this.f45987c != null) {
            d.a.h0.f.f.a.l().u(this.f45985a, this.f45987c);
            this.f45987c = null;
        }
        this.f45987c = null;
    }

    public final void f(d.a.h0.f.f.g.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.a());
            this.mResult.putString("resultData", bVar.b());
            this.mResult.putInt(l.f1974a, bVar.c());
            if (!bVar.d()) {
                d.a.h0.f.f.h.c.a(this.f45985a, "installApp", "fail", String.valueOf(bVar.c()), new d.a.h0.f.f.h.a(this.f45986b));
            }
        }
        e();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (f45984d) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f45985a);
        }
        e();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (f45984d) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.f45986b = v.b(this.mParams.getString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, ""));
        JSONObject b2 = v.b(this.mParams.getString("data", ""));
        String optString = b2.optString("packageName");
        this.f45985a = optString;
        this.mResult.putString("packageName", optString);
        d.a.h0.f.f.c.b.f45950d.execute(new c(b2, this.f45986b, this.f45987c));
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (f45984d) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f45985a);
        }
        d.a.h0.f.f.h.c.a(this.f45985a, "installApp", "fail", String.valueOf(31003), new d.a.h0.f.f.h.a(this.f45986b));
        e();
    }
}
