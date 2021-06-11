package d.a.l0.b.n.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.transition.Transition;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.a2.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.k;
import d.a.l0.a.p.d.v0;
import d.a.l0.t.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements v0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50077b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.b0.a f50078a = new d.a.b0.a();

    /* renamed from: d.a.l0.b.n.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1013a extends d.a.c0.l.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f50079a;

        public C1013a(a aVar, long j) {
            this.f50079a = j;
        }

        @Override // d.a.c0.l.a
        public void a(int i2, String str) {
            if (a.f50077b) {
                Log.d("RebateInfoManager", "requestBatchRebateInfo onResult: " + i2 + " " + str);
            }
            d.i(a.e());
            d.M(String.valueOf(this.f50079a), a.e());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c0.l.a {
        public b(a aVar) {
        }

        @Override // d.a.c0.l.a
        public void a(int i2, String str) {
            if (a.f50077b) {
                Log.d("RebateInfoManager", "requestSingleRebateInfo onResult: " + i2 + " " + str);
            }
        }
    }

    public static File e() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp");
    }

    @Override // d.a.l0.a.p.d.v0
    public boolean a(String str, String str2, String str3) {
        e Q;
        b.a L;
        if (!d.a.l0.a.d2.e.l() || (Q = e.Q()) == null || (L = Q.L()) == null) {
            return false;
        }
        f(str, d.a.l0.r.e.h().v(AppRuntime.getAppContext()), d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()), d.a.l0.b.j.a.i(Q.getApplicationContext()), str2, str3, d.a.l0.a.c1.a.m().a(), L.T());
        return true;
    }

    @Override // d.a.l0.a.p.d.v0
    public void b() {
        String D = d.D(e());
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!TextUtils.isEmpty(D)) {
            try {
                if (currentTimeMillis - Long.parseLong(D) < 86400) {
                    if (f50077b) {
                        Log.d("RebateInfoManager", "requestBatchRebateInfo: 相邻请求时间需要大于一天");
                        return;
                    }
                    return;
                }
            } catch (NumberFormatException e2) {
                if (f50077b) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        this.f50078a.l(new C1013a(this, currentTimeMillis));
    }

    public final void f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("masterId", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("userPassId", str2);
            }
            jSONObject.put("cuid", str3);
            jSONObject.put("bduss", str4);
            jSONObject.put(Transition.MATCH_ITEM_ID_STR, str5);
            jSONObject.put("businessId", str6);
            jSONObject.put("naid", str7);
            jSONObject.put("scene", str8);
            this.f50078a.k(jSONObject, new b(this));
        } catch (JSONException e2) {
            if (f50077b) {
                e2.printStackTrace();
            }
        }
    }
}
