package d.b.g0.b.m.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.transition.Transition;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import d.b.g0.a.p.c.k0;
import d.b.g0.a.r1.e;
import d.b.g0.a.u1.c;
import d.b.g0.a.y0.e.b;
import d.b.g0.p.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements k0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47441b = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a f47442a = new d.b.b0.a();

    /* renamed from: d.b.g0.b.m.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0914a extends d.b.c0.l.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f47443a;

        public C0914a(a aVar, long j) {
            this.f47443a = j;
        }

        @Override // d.b.c0.l.a
        public void a(int i, String str) {
            if (a.f47441b) {
                Log.d("RebateInfoManager", "requestBatchRebateInfo onResult: " + i + " " + str);
            }
            d.f(a.e());
            d.y(String.valueOf(this.f47443a), a.e());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.c0.l.a {
        public b(a aVar) {
        }

        @Override // d.b.c0.l.a
        public void a(int i, String str) {
            if (a.f47441b) {
                Log.d("RebateInfoManager", "requestSingleRebateInfo onResult: " + i + " " + str);
            }
        }
    }

    public static File e() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp");
    }

    @Override // d.b.g0.a.p.c.k0
    public void a() {
        String r = d.r(e());
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!TextUtils.isEmpty(r)) {
            try {
                if (currentTimeMillis - Long.parseLong(r) < 86400) {
                    if (f47441b) {
                        Log.d("RebateInfoManager", "requestBatchRebateInfo: 相邻请求时间需要大于一天");
                        return;
                    }
                    return;
                }
            } catch (NumberFormatException e2) {
                if (f47441b) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        this.f47442a.l(new C0914a(this, currentTimeMillis));
    }

    @Override // d.b.g0.a.p.c.k0
    public boolean b(String str, String str2, String str3) {
        e O;
        b.a J;
        if (!c.l() || (O = e.O()) == null || (J = O.J()) == null) {
            return false;
        }
        f(str, d.b.g0.n.e.g().q(AppRuntime.getAppContext()), d.b.g0.a.w0.a.O().c(d.b.g0.a.w0.a.c()), d.b.g0.b.i.a.i(O.getApplicationContext()), str2, str3, d.b.g0.a.w0.a.k().g(), J.S());
        return true;
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
            this.f47442a.k(jSONObject, new b(this));
        } catch (JSONException e2) {
            if (f47441b) {
                e2.printStackTrace();
            }
        }
    }
}
