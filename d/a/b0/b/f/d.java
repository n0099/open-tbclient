package d.a.b0.b.f;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.SplashAdFacade;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements d.a.d0.a.g.d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.d0.a.g.b f39326a;

    /* renamed from: c  reason: collision with root package name */
    public final Context f39328c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.b0.b.d f39329d;

    /* renamed from: e  reason: collision with root package name */
    public SplashAdFacade.a f39330e;

    /* renamed from: f  reason: collision with root package name */
    public int f39331f;

    /* renamed from: g  reason: collision with root package name */
    public int f39332g;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f39327b = new Handler();

    /* renamed from: h  reason: collision with root package name */
    public final d.a.b0.b.c f39333h = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.b0.b.c {
        public a() {
        }

        @Override // d.a.b0.b.c
        public void a(Throwable th) {
            if (d.a.b0.a.b.a.f39288a.get().s()) {
                Log.i("PrologueAd", "onAdFailed: " + th.getMessage());
            }
            if (d.this.f39330e != null) {
                d.this.f39330e.onFailed();
            } else if (d.this.f39329d != null) {
                d.this.f39329d.a(th == null ? "unKnow" : th.getMessage());
            }
            d.a.b0.b.f.b.f(64);
        }

        @Override // d.a.b0.b.c
        public void b(@NonNull g gVar) {
            if (SplashAdFacade.a().c()) {
                return;
            }
            int e2 = f.e(gVar);
            if (d.a.b0.a.b.a.f39288a.get().s()) {
                Log.i("PrologueAd", "onAdSuccess, statusCode: " + e2);
            }
            if (e2 == 0) {
                d.a.d0.a.b a2 = e.a(gVar);
                d.a.d0.a.g.b a3 = new d.a.d0.a.a().a(d.this.f39328c, a2);
                if (a3 != null) {
                    d.this.f39326a = a3;
                    if (d.this.f39329d != null) {
                        d.a.b0.b.e eVar = new d.a.b0.b.e(a3, d.this.f39329d.d(), gVar);
                        eVar.d(d.this.f39329d);
                        a3.d(eVar);
                        a3.b(eVar);
                        eVar.c(d.this);
                        a3.a();
                    }
                    if (d.this.f39330e != null) {
                        d.this.f39330e.onSuccess();
                        return;
                    }
                    return;
                } else if (d.a.b0.a.b.a.f39288a.get().s()) {
                    Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    return;
                } else {
                    return;
                }
            }
            if (d.a.b0.a.b.a.f39288a.get().s()) {
                Log.e("PrologueAd", "query 后物料效验失败");
            }
            if (d.this.f39330e != null) {
                d.this.f39330e.onFailed();
            } else if (d.this.f39329d != null) {
                d.a.b0.b.d dVar = d.this.f39329d;
                dVar.a("query 后物料效验失败: " + e2);
            }
            d.a.b0.b.f.b.f(e2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.b0.b.a.g(d.a.b0.a.b.a.f39288a.get());
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, d.a.b0.b.d dVar) {
        this.f39328c = context;
        this.f39329d = dVar;
    }

    public void e() {
        d.a.d0.a.g.b bVar = this.f39326a;
        if (bVar != null) {
            bVar.destroy();
            this.f39326a = null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("place_id", d.a.b0.a.b.a.f39288a.get().l());
            jSONObject.put("source", "gd");
            jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f39331f);
            jSONObject.put("full_type", this.f39332g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void g() {
        d.a.b0.b.a.e(d.a.b0.a.b.a.f39288a.get(), this.f39333h);
        this.f39327b.postDelayed(new b(this), 5000L);
    }

    public void h(int i2) {
        this.f39331f = i2;
    }

    public void i(d.a.d0.a.g.b bVar) {
        this.f39326a = bVar;
    }

    public void j(int i2) {
        this.f39332g = i2;
    }

    public void k(ViewGroup viewGroup) {
        d.a.d0.a.g.b bVar;
        if (viewGroup != null && (bVar = this.f39326a) != null) {
            View adView = bVar.getAdView();
            if (adView != null && adView.getParent() == null) {
                viewGroup.addView(adView);
                return;
            } else {
                e();
                return;
            }
        }
        e();
    }
}
