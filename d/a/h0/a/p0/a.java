package d.a.h0.a.p0;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import d.a.h0.a.t.b.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.p0.b {

        /* renamed from: a  reason: collision with root package name */
        public String f43527a;

        @Override // d.a.h0.a.p0.b
        public void a(@Nullable JSONObject jSONObject) {
            a.this.c(this.f43527a, jSONObject == null ? new d.a.h0.a.t.e.b(0) : new d.a.h0.a.t.e.b(0, jSONObject));
        }

        @Override // d.a.h0.a.p0.b
        public void onFail(int i2, @Nullable String str) {
            if (d.f44021c && i2 == 0) {
                Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
            }
            a.this.c(this.f43527a, str == null ? new d.a.h0.a.t.e.b(i2) : new d.a.h0.a.t.e.b(i2, str));
        }

        public b(String str) {
            this.f43527a = str;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.p0.b {
        public c(a aVar) {
        }

        @Override // d.a.h0.a.p0.b
        public void a(@Nullable JSONObject jSONObject) {
            if (d.f44021c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onSuccess could not be invoked.");
            }
        }

        @Override // d.a.h0.a.p0.b
        public void onFail(int i2, @Nullable String str) {
            if (d.f44021c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onFail could not be invoked.");
            }
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.a.h0.a.t.e.b q(String str) {
        if (d.f44021c) {
            Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-GameCenterApi", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            d.a.h0.a.c0.c.b("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("Api-GameCenterApi", "empty cb");
            return new d.a.h0.a.t.e.b(202, "empty cb");
        }
        return s(jSONObject, new b(optString));
    }

    public d.a.h0.a.t.e.b r(String str) {
        if (d.f44021c) {
            Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-GameCenterApi", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            d.a.h0.a.c0.c.b("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        return s((JSONObject) a2.second, new c());
    }

    public final d.a.h0.a.t.e.b s(@NonNull JSONObject jSONObject, @NonNull d.a.h0.a.p0.b bVar) {
        String optString = jSONObject.optString(RetrieveTaskManager.KEY);
        if (TextUtils.isEmpty(optString)) {
            return new d.a.h0.a.t.e.b(202, "empty api name");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        d.a.h0.a.t.e.b a2 = d.a.h0.a.w0.a.a0().a(optString, optJSONObject, bVar);
        return a2 == null ? new d.a.h0.a.t.e.b(0) : a2;
    }
}
