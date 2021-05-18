package d.a.i0.g.i.a;

import android.util.Log;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import d.a.i0.a.a2.e;
import d.a.i0.a.f2.a;
import d.a.i0.a.k;
import d.a.i0.a.u0.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.i0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46912c = k.f43025a;

    /* renamed from: d.a.i0.g.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0993a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f46913a;

        public C0993a(a aVar, b bVar) {
            this.f46913a = bVar;
        }

        @Override // d.a.i0.a.f2.a.f
        public void a(int i2) {
            if (i2 == -1) {
                a.c(this.f46913a, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE202);
            } else if (i2 != 1) {
                this.f46913a.onFail(101, "noPermission");
            } else {
                a.c(this.f46913a, BasicPushStatus.SUCCESS_CODE);
            }
        }
    }

    public a() {
        super("addShortcutToDesktop");
    }

    public static void c(b bVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
        } catch (JSONException e2) {
            if (f46912c) {
                e2.printStackTrace();
            }
        }
        bVar.b(jSONObject);
    }

    @Override // d.a.i0.g.f.a
    public d.a.i0.a.u.h.b a(JSONObject jSONObject, b bVar) {
        e Q = e.Q();
        if (Q != null && Q.x() != null && Q.L() != null) {
            if (d.a.i0.a.f2.a.s(Q.x(), Q.L().K(), Q.L().H()) == 1) {
                c(bVar, "201");
                return null;
            }
            d.a.i0.a.f2.a.j(Q.x(), Q.L(), 1, new C0993a(this, bVar));
            return null;
        }
        bVar.onFail(100, "swan or activity is null");
        if (f46912c) {
            Log.d("AddShortcutToDesktop", "swan or activity is null");
            return null;
        }
        return null;
    }
}
