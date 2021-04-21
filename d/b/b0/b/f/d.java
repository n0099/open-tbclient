package d.b.b0.b.f;

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
public class d implements d.b.d0.a.g.d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.g.b f42143a;

    /* renamed from: c  reason: collision with root package name */
    public final Context f42145c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.b0.b.d f42146d;

    /* renamed from: e  reason: collision with root package name */
    public SplashAdFacade.a f42147e;

    /* renamed from: f  reason: collision with root package name */
    public int f42148f;

    /* renamed from: g  reason: collision with root package name */
    public int f42149g;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f42144b = new Handler();

    /* renamed from: h  reason: collision with root package name */
    public final d.b.b0.b.c f42150h = new a();

    /* loaded from: classes2.dex */
    public class a implements d.b.b0.b.c {
        public a() {
        }

        @Override // d.b.b0.b.c
        public void a(@NonNull g gVar) {
            if (SplashAdFacade.a().c()) {
                return;
            }
            int e2 = f.e(gVar);
            if (d.b.b0.a.b.a.f42106a.get().D()) {
                Log.i("PrologueAd", "onAdSuccess, statusCode: " + e2);
            }
            if (e2 == 0) {
                d.b.d0.a.b a2 = e.a(gVar);
                d.b.d0.a.g.b a3 = new d.b.d0.a.a().a(d.this.f42145c, a2);
                if (a3 != null) {
                    d.this.f42143a = a3;
                    if (d.this.f42146d != null) {
                        d.b.b0.b.e eVar = new d.b.b0.b.e(a3, d.this.f42146d.b(), gVar);
                        eVar.d(d.this.f42146d);
                        a3.d(eVar);
                        a3.a(eVar);
                        eVar.c(d.this);
                        a3.b();
                    }
                    if (d.this.f42147e != null) {
                        d.this.f42147e.onSuccess();
                        return;
                    }
                    return;
                } else if (d.b.b0.a.b.a.f42106a.get().D()) {
                    Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    return;
                } else {
                    return;
                }
            }
            if (d.b.b0.a.b.a.f42106a.get().D()) {
                Log.e("PrologueAd", "query 后物料效验失败");
            }
            if (d.this.f42147e != null) {
                d.this.f42147e.onFailed();
            } else if (d.this.f42146d != null) {
                d.b.b0.b.d dVar = d.this.f42146d;
                dVar.a("query 后物料效验失败: " + e2);
            }
            d.b.b0.b.f.b.f(e2);
        }

        @Override // d.b.b0.b.c
        public void b(Throwable th) {
            if (d.b.b0.a.b.a.f42106a.get().D()) {
                Log.i("PrologueAd", "onAdFailed: " + th.getMessage());
            }
            if (d.this.f42147e != null) {
                d.this.f42147e.onFailed();
            } else if (d.this.f42146d != null) {
                d.this.f42146d.a(th == null ? "unKnow" : th.getMessage());
            }
            d.b.b0.b.f.b.f(64);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b0.b.a.g(d.b.b0.a.b.a.f42106a.get());
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, d.b.b0.b.d dVar) {
        this.f42145c = context;
        this.f42146d = dVar;
    }

    public void e() {
        d.b.d0.a.g.b bVar = this.f42143a;
        if (bVar != null) {
            bVar.destroy();
            this.f42143a = null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("place_id", d.b.b0.a.b.a.f42106a.get().v());
            jSONObject.put("source", "gd");
            jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f42148f);
            jSONObject.put("full_type", this.f42149g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void g() {
        d.b.b0.b.a.e(d.b.b0.a.b.a.f42106a.get(), this.f42150h);
        this.f42144b.postDelayed(new b(this), 5000L);
    }

    public void h(int i) {
        this.f42148f = i;
    }

    public void i(d.b.d0.a.g.b bVar) {
        this.f42143a = bVar;
    }

    public void j(int i) {
        this.f42149g = i;
    }

    public void k(ViewGroup viewGroup) {
        d.b.d0.a.g.b bVar;
        if (viewGroup != null && (bVar = this.f42143a) != null) {
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
