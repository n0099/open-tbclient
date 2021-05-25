package d.a.d0.b.g;

import android.content.Context;
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
public class d implements d.a.f0.a.g.d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.f0.a.g.b f39640a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f39641b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.d0.b.d f39642c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAdFacade.b f39643d;

    /* renamed from: e  reason: collision with root package name */
    public int f39644e;

    /* renamed from: f  reason: collision with root package name */
    public int f39645f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.d0.b.c f39646g = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.d0.b.c {
        public a() {
        }

        @Override // d.a.d0.b.c
        public void a(Throwable th) {
            if (d.a.d0.a.b.a.f39590a.get().s()) {
                Log.i("PrologueAd", "onAdFailed: " + th.getMessage());
            }
            if (d.this.f39643d != null) {
                d.this.f39643d.onFailed();
            } else if (d.this.f39642c != null) {
                d.this.f39642c.a(th == null ? "unKnow" : th.getMessage());
            }
            b.g(64, th != null ? th.getMessage() : "unKnow");
        }

        @Override // d.a.d0.b.c
        public void b(@NonNull h hVar) {
            if (SplashAdFacade.e().g()) {
                return;
            }
            int e2 = f.e(hVar);
            if (d.a.d0.a.b.a.f39590a.get().s()) {
                Log.i("PrologueAd", "onAdSuccess, statusCode: " + e2);
            }
            if (e2 == 0) {
                d.a.f0.a.b a2 = e.a(hVar);
                d.a.f0.a.g.b a3 = new d.a.f0.a.a().a(d.this.f39641b, a2);
                if (a3 != null) {
                    d.this.f39640a = a3;
                    if (d.this.f39642c != null) {
                        d.a.d0.b.e eVar = new d.a.d0.b.e(a3, d.this.f39642c.d(), hVar);
                        eVar.d(d.this.f39642c);
                        a3.d(eVar);
                        a3.b(eVar);
                        eVar.c(d.this);
                        a3.a();
                    }
                    if (d.this.f39643d != null) {
                        d.this.f39643d.onSuccess();
                        return;
                    }
                    return;
                } else if (d.a.d0.a.b.a.f39590a.get().s()) {
                    Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    return;
                } else {
                    return;
                }
            }
            if (d.a.d0.a.b.a.f39590a.get().s()) {
                Log.e("PrologueAd", "query 后物料效验失败");
            }
            if (d.this.f39643d != null) {
                d.this.f39643d.onFailed();
            } else if (d.this.f39642c != null) {
                d.a.d0.b.d dVar = d.this.f39642c;
                dVar.a("query 后物料效验失败: " + e2);
            }
            b.f(e2);
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, d.a.d0.b.d dVar) {
        this.f39641b = context;
        this.f39642c = dVar;
    }

    public void e() {
        if (this.f39640a != null) {
            this.f39640a = null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("place_id", d.a.d0.a.b.a.f39590a.get().l());
            jSONObject.put("source", "gd");
            jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f39644e);
            jSONObject.put("full_type", this.f39645f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void g() {
        new d.a.d0.b.a().j(d.a.d0.a.b.a.f39590a.get(), this.f39646g);
    }

    public void h(int i2) {
        this.f39644e = i2;
    }

    public void i(d.a.f0.a.g.b bVar) {
        this.f39640a = bVar;
    }

    public void j(int i2) {
        this.f39645f = i2;
    }

    public void k(ViewGroup viewGroup) {
        d.a.f0.a.g.b bVar;
        if (viewGroup != null && (bVar = this.f39640a) != null) {
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
