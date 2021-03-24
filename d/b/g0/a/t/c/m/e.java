package d.b.g0.a.t.c.m;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46173f;

        public a(Context context, String str) {
            this.f46172e = context;
            this.f46173f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                e.this.c(this.f46173f, new d.b.g0.a.t.e.b(0, e.this.s(this.f46172e)));
                return;
            }
            int b2 = hVar.b();
            String f2 = d.b.g0.a.v1.c.c.f(b2);
            if (d.b.g0.a.t.b.d.f45928c) {
                Log.e("Api-DeviceInfo", "getDeviceInfo auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            e.this.c(this.f46173f, new d.b.g0.a.t.e.b(b2, d.b.g0.a.v1.c.c.f(b2)));
        }
    }

    public e(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b r(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-DeviceInfo", "start get device info");
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return new d.b.g0.a.t.e.b(1001, "SwanApp is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-DeviceInfo", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-DeviceInfo", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.g0.a.t.e.b(202, "cb is required");
        }
        Context h2 = h();
        O.R().g(h2, "scope_get_device_info", new a(h2, optString));
        return new d.b.g0.a.t.e.b(0);
    }

    public final JSONObject s(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", d.b.g0.a.w0.a.n().a(context));
            jSONObject.put("androidId", d.b.g0.a.w0.a.n().getAndroidId(context));
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45928c) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
