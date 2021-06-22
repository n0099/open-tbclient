package d.a.m0.a.u.e.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f48941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48942f;

        public a(Context context, String str) {
            this.f48941e = context;
            this.f48942f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                e.this.d(this.f48942f, new d.a.m0.a.u.h.b(0, e.this.t(this.f48941e)));
                return;
            }
            int b2 = iVar.b();
            String f2 = d.a.m0.a.e2.c.d.f(b2);
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.e("Api-DeviceInfo", "getDeviceInfo auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            e.this.d(this.f48942f, new d.a.m0.a.u.h.b(b2, d.a.m0.a.e2.c.d.f(b2)));
        }
    }

    public e(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b s(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-DeviceInfo", "start get device info");
        }
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.m0.a.u.h.b(1001, "SwanApp is null");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-DeviceInfo", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-DeviceInfo", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.m0.a.u.h.b(202, "cb is required");
        }
        Context i2 = i();
        Q.T().g(i2, "scope_get_device_info", new a(i2, optString));
        return new d.a.m0.a.u.h.b(0);
    }

    public final JSONObject t(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", d.a.m0.a.c1.a.q().b(context));
            jSONObject.put("androidId", d.a.m0.a.c1.a.q().a(context));
        } catch (JSONException e2) {
            if (d.a.m0.a.u.c.d.f48594c) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
