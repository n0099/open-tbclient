package d.a.l0.g.i.a;

import android.util.Log;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import d.a.l0.a.a2.e;
import d.a.l0.a.f2.a;
import d.a.l0.a.k;
import d.a.l0.a.u0.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47088c = k.f43199a;

    /* renamed from: d.a.l0.g.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1004a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47089a;

        public C1004a(a aVar, b bVar) {
            this.f47089a = bVar;
        }

        @Override // d.a.l0.a.f2.a.f
        public void a(int i2) {
            if (i2 == -1) {
                a.c(this.f47089a, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE202);
            } else if (i2 != 1) {
                this.f47089a.onFail(101, "noPermission");
            } else {
                a.c(this.f47089a, BasicPushStatus.SUCCESS_CODE);
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
            if (f47088c) {
                e2.printStackTrace();
            }
        }
        bVar.b(jSONObject);
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(JSONObject jSONObject, b bVar) {
        e Q = e.Q();
        if (Q != null && Q.x() != null && Q.L() != null) {
            if (d.a.l0.a.f2.a.s(Q.x(), Q.L().K(), Q.L().H()) == 1) {
                c(bVar, "201");
                return null;
            }
            d.a.l0.a.f2.a.j(Q.x(), Q.L(), 1, new C1004a(this, bVar));
            return null;
        }
        bVar.onFail(100, "swan or activity is null");
        if (f47088c) {
            Log.d("AddShortcutToDesktop", "swan or activity is null");
            return null;
        }
        return null;
    }
}
