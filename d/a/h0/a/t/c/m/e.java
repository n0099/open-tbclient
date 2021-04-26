package d.a.h0.a.t.c.m;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44282f;

        public a(Context context, String str) {
            this.f44281e = context;
            this.f44282f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                e.this.c(this.f44282f, new d.a.h0.a.t.e.b(0, e.this.s(this.f44281e)));
                return;
            }
            int b2 = hVar.b();
            String f2 = d.a.h0.a.v1.c.c.f(b2);
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.e("Api-DeviceInfo", "getDeviceInfo auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            e.this.c(this.f44282f, new d.a.h0.a.t.e.b(b2, d.a.h0.a.v1.c.c.f(b2)));
        }
    }

    public e(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.a.h0.a.t.e.b r(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-DeviceInfo", "start get device info");
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return new d.a.h0.a.t.e.b(1001, "SwanApp is null");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-DeviceInfo", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-DeviceInfo", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.h0.a.t.e.b(202, "cb is required");
        }
        Context h2 = h();
        O.R().g(h2, "scope_get_device_info", new a(h2, optString));
        return new d.a.h0.a.t.e.b(0);
    }

    public final JSONObject s(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", d.a.h0.a.w0.a.n().b(context));
            jSONObject.put("androidId", d.a.h0.a.w0.a.n().a(context));
        } catch (JSONException e2) {
            if (d.a.h0.a.t.b.d.f44021c) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
