package d.a.h0.b.m.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.transition.Transition;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
import d.a.h0.a.p.c.k0;
import d.a.h0.a.r1.e;
import d.a.h0.a.u1.c;
import d.a.h0.a.y0.e.b;
import d.a.h0.p.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements k0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45608b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.z.a f45609a = new d.a.z.a();

    /* renamed from: d.a.h0.b.m.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0885a extends d.a.a0.l.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f45610a;

        public C0885a(a aVar, long j) {
            this.f45610a = j;
        }

        @Override // d.a.a0.l.a
        public void a(int i2, String str) {
            if (a.f45608b) {
                Log.d("RebateInfoManager", "requestBatchRebateInfo onResult: " + i2 + " " + str);
            }
            d.f(a.e());
            d.y(String.valueOf(this.f45610a), a.e());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.a0.l.a {
        public b(a aVar) {
        }

        @Override // d.a.a0.l.a
        public void a(int i2, String str) {
            if (a.f45608b) {
                Log.d("RebateInfoManager", "requestSingleRebateInfo onResult: " + i2 + " " + str);
            }
        }
    }

    public static File e() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp");
    }

    @Override // d.a.h0.a.p.c.k0
    public boolean a(String str, String str2, String str3) {
        e O;
        b.a J;
        if (!c.l() || (O = e.O()) == null || (J = O.J()) == null) {
            return false;
        }
        f(str, d.a.h0.n.e.g().s(AppRuntime.getAppContext()), d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c()), d.a.h0.b.i.a.i(O.getApplicationContext()), str2, str3, d.a.h0.a.w0.a.k().f(), J.S());
        return true;
    }

    @Override // d.a.h0.a.p.c.k0
    public void b() {
        String r = d.r(e());
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!TextUtils.isEmpty(r)) {
            try {
                if (currentTimeMillis - Long.parseLong(r) < 86400) {
                    if (f45608b) {
                        Log.d("RebateInfoManager", "requestBatchRebateInfo: 相邻请求时间需要大于一天");
                        return;
                    }
                    return;
                }
            } catch (NumberFormatException e2) {
                if (f45608b) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        this.f45609a.l(new C0885a(this, currentTimeMillis));
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
            this.f45609a.k(jSONObject, new b(this));
        } catch (JSONException e2) {
            if (f45608b) {
                e2.printStackTrace();
            }
        }
    }
}
