package d.a.i0.b.n.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.transition.Transition;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.a2.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k;
import d.a.i0.a.p.d.v0;
import d.a.i0.t.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements v0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46227b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.z.a f46228a = new d.a.z.a();

    /* renamed from: d.a.i0.b.n.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0946a extends d.a.a0.l.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f46229a;

        public C0946a(a aVar, long j) {
            this.f46229a = j;
        }

        @Override // d.a.a0.l.a
        public void a(int i2, String str) {
            if (a.f46227b) {
                Log.d("RebateInfoManager", "requestBatchRebateInfo onResult: " + i2 + " " + str);
            }
            d.i(a.e());
            d.M(String.valueOf(this.f46229a), a.e());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.a0.l.a {
        public b(a aVar) {
        }

        @Override // d.a.a0.l.a
        public void a(int i2, String str) {
            if (a.f46227b) {
                Log.d("RebateInfoManager", "requestSingleRebateInfo onResult: " + i2 + " " + str);
            }
        }
    }

    public static File e() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp");
    }

    @Override // d.a.i0.a.p.d.v0
    public boolean a(String str, String str2, String str3) {
        e Q;
        b.a L;
        if (!d.a.i0.a.d2.e.l() || (Q = e.Q()) == null || (L = Q.L()) == null) {
            return false;
        }
        f(str, d.a.i0.r.e.h().w(AppRuntime.getAppContext()), d.a.i0.a.c1.a.a0().i(d.a.i0.a.c1.a.b()), d.a.i0.b.j.a.i(Q.getApplicationContext()), str2, str3, d.a.i0.a.c1.a.m().a(), L.T());
        return true;
    }

    @Override // d.a.i0.a.p.d.v0
    public void b() {
        String D = d.D(e());
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!TextUtils.isEmpty(D)) {
            try {
                if (currentTimeMillis - Long.parseLong(D) < 86400) {
                    if (f46227b) {
                        Log.d("RebateInfoManager", "requestBatchRebateInfo: 相邻请求时间需要大于一天");
                        return;
                    }
                    return;
                }
            } catch (NumberFormatException e2) {
                if (f46227b) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        this.f46228a.l(new C0946a(this, currentTimeMillis));
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
            this.f46228a.k(jSONObject, new b(this));
        } catch (JSONException e2) {
            if (f46227b) {
                e2.printStackTrace();
            }
        }
    }
}
