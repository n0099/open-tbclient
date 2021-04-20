package d.b.a0.b.f;

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
public class d implements d.b.c0.a.g.d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c0.a.g.b f41854a;

    /* renamed from: c  reason: collision with root package name */
    public final Context f41856c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.a0.b.d f41857d;

    /* renamed from: e  reason: collision with root package name */
    public SplashAdFacade.a f41858e;

    /* renamed from: f  reason: collision with root package name */
    public int f41859f;

    /* renamed from: g  reason: collision with root package name */
    public int f41860g;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f41855b = new Handler();

    /* renamed from: h  reason: collision with root package name */
    public final d.b.a0.b.c f41861h = new a();

    /* loaded from: classes2.dex */
    public class a implements d.b.a0.b.c {
        public a() {
        }

        @Override // d.b.a0.b.c
        public void a(@NonNull g gVar) {
            if (SplashAdFacade.a().c()) {
                return;
            }
            int e2 = f.e(gVar);
            if (d.b.a0.a.b.a.f41817a.get().D()) {
                Log.i("PrologueAd", "onAdSuccess, statusCode: " + e2);
            }
            if (e2 == 0) {
                d.b.c0.a.b a2 = e.a(gVar);
                d.b.c0.a.g.b a3 = new d.b.c0.a.a().a(d.this.f41856c, a2);
                if (a3 != null) {
                    d.this.f41854a = a3;
                    if (d.this.f41857d != null) {
                        d.b.a0.b.e eVar = new d.b.a0.b.e(a3, d.this.f41857d.b(), gVar);
                        eVar.d(d.this.f41857d);
                        a3.d(eVar);
                        a3.a(eVar);
                        eVar.c(d.this);
                        a3.b();
                    }
                    if (d.this.f41858e != null) {
                        d.this.f41858e.onSuccess();
                        return;
                    }
                    return;
                } else if (d.b.a0.a.b.a.f41817a.get().D()) {
                    Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    return;
                } else {
                    return;
                }
            }
            if (d.b.a0.a.b.a.f41817a.get().D()) {
                Log.e("PrologueAd", "query 后物料效验失败");
            }
            if (d.this.f41858e != null) {
                d.this.f41858e.onFailed();
            } else if (d.this.f41857d != null) {
                d.b.a0.b.d dVar = d.this.f41857d;
                dVar.a("query 后物料效验失败: " + e2);
            }
            d.b.a0.b.f.b.f(e2);
        }

        @Override // d.b.a0.b.c
        public void b(Throwable th) {
            if (d.b.a0.a.b.a.f41817a.get().D()) {
                Log.i("PrologueAd", "onAdFailed: " + th.getMessage());
            }
            if (d.this.f41858e != null) {
                d.this.f41858e.onFailed();
            } else if (d.this.f41857d != null) {
                d.this.f41857d.a(th == null ? "unKnow" : th.getMessage());
            }
            d.b.a0.b.f.b.f(64);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.a0.b.a.g(d.b.a0.a.b.a.f41817a.get());
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, d.b.a0.b.d dVar) {
        this.f41856c = context;
        this.f41857d = dVar;
    }

    public void e() {
        d.b.c0.a.g.b bVar = this.f41854a;
        if (bVar != null) {
            bVar.destroy();
            this.f41854a = null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("place_id", d.b.a0.a.b.a.f41817a.get().v());
            jSONObject.put("source", "gd");
            jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f41859f);
            jSONObject.put("full_type", this.f41860g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void g() {
        d.b.a0.b.a.e(d.b.a0.a.b.a.f41817a.get(), this.f41861h);
        this.f41855b.postDelayed(new b(this), 5000L);
    }

    public void h(int i) {
        this.f41859f = i;
    }

    public void i(d.b.c0.a.g.b bVar) {
        this.f41854a = bVar;
    }

    public void j(int i) {
        this.f41860g = i;
    }

    public void k(ViewGroup viewGroup) {
        d.b.c0.a.g.b bVar;
        if (viewGroup != null && (bVar = this.f41854a) != null) {
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
