package d.b.h0.a.p0;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import d.b.h0.a.t.b.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.p0.b {

        /* renamed from: a  reason: collision with root package name */
        public String f46180a;

        @Override // d.b.h0.a.p0.b
        public void a(@Nullable JSONObject jSONObject) {
            a.this.c(this.f46180a, jSONObject == null ? new d.b.h0.a.t.e.b(0) : new d.b.h0.a.t.e.b(0, jSONObject));
        }

        @Override // d.b.h0.a.p0.b
        public void onFail(int i, @Nullable String str) {
            if (d.f46650c && i == 0) {
                Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
            }
            a.this.c(this.f46180a, str == null ? new d.b.h0.a.t.e.b(i) : new d.b.h0.a.t.e.b(i, str));
        }

        public b(String str) {
            this.f46180a = str;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.p0.b {
        public c(a aVar) {
        }

        @Override // d.b.h0.a.p0.b
        public void a(@Nullable JSONObject jSONObject) {
            if (d.f46650c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onSuccess could not be invoked.");
            }
        }

        @Override // d.b.h0.a.p0.b
        public void onFail(int i, @Nullable String str) {
            if (d.f46650c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onFail could not be invoked.");
            }
        }
    }

    public a(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.h0.a.t.e.b q(String str) {
        if (d.f46650c) {
            Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-GameCenterApi", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.h0.a.c0.c.b("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("Api-GameCenterApi", "empty cb");
            return new d.b.h0.a.t.e.b(202, "empty cb");
        }
        return s(jSONObject, new b(optString));
    }

    public d.b.h0.a.t.e.b r(String str) {
        if (d.f46650c) {
            Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-GameCenterApi", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.h0.a.c0.c.b("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        return s((JSONObject) a2.second, new c());
    }

    public final d.b.h0.a.t.e.b s(@NonNull JSONObject jSONObject, @NonNull d.b.h0.a.p0.b bVar) {
        String optString = jSONObject.optString(RetrieveTaskManager.KEY);
        if (TextUtils.isEmpty(optString)) {
            return new d.b.h0.a.t.e.b(202, "empty api name");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        d.b.h0.a.t.e.b a2 = d.b.h0.a.w0.a.a0().a(optString, optJSONObject, bVar);
        return a2 == null ? new d.b.h0.a.t.e.b(0) : a2;
    }
}
