package d.a.i0.a.u.e.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.a.i0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44984f;

        public a(Context context, String str) {
            this.f44983e = context;
            this.f44984f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                e.this.d(this.f44984f, new d.a.i0.a.u.h.b(0, e.this.t(this.f44983e)));
                return;
            }
            int b2 = iVar.b();
            String f2 = d.a.i0.a.e2.c.d.f(b2);
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.e("Api-DeviceInfo", "getDeviceInfo auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            e.this.d(this.f44984f, new d.a.i0.a.u.h.b(b2, d.a.i0.a.e2.c.d.f(b2)));
        }
    }

    public e(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b s(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-DeviceInfo", "start get device info");
        }
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-DeviceInfo", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-DeviceInfo", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.i0.a.u.h.b(202, "cb is required");
        }
        Context i2 = i();
        Q.T().g(i2, "scope_get_device_info", new a(i2, optString));
        return new d.a.i0.a.u.h.b(0);
    }

    public final JSONObject t(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", d.a.i0.a.c1.a.q().b(context));
            jSONObject.put("androidId", d.a.i0.a.c1.a.q().a(context));
        } catch (JSONException e2) {
            if (d.a.i0.a.u.c.d.f44636c) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
