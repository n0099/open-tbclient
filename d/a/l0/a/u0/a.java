package d.a.l0.a.u0;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import d.a.l0.a.u.c.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.u0.b {

        /* renamed from: a  reason: collision with root package name */
        public String f45245a;

        @Override // d.a.l0.a.u0.b
        public void b(@Nullable JSONObject jSONObject) {
            a.this.d(this.f45245a, jSONObject == null ? new d.a.l0.a.u.h.b(0) : new d.a.l0.a.u.h.b(0, jSONObject));
        }

        @Override // d.a.l0.a.u0.b
        public void onFail(int i2, @Nullable String str) {
            if (d.f44812c && i2 == 0) {
                Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
            }
            a.this.d(this.f45245a, str == null ? new d.a.l0.a.u.h.b(i2) : new d.a.l0.a.u.h.b(i2, str));
        }

        public b(String str) {
            this.f45245a = str;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.u0.b {
        public c(a aVar) {
        }

        @Override // d.a.l0.a.u0.b
        public void b(@Nullable JSONObject jSONObject) {
            if (d.f44812c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onSuccess could not be invoked.");
            }
        }

        @Override // d.a.l0.a.u0.b
        public void onFail(int i2, @Nullable String str) {
            if (d.f44812c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onFail could not be invoked.");
            }
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b r(String str) {
        if (d.f44812c) {
            Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-GameCenterApi", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.l0.a.e0.d.b("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("Api-GameCenterApi", "empty cb");
            return new d.a.l0.a.u.h.b(202, "empty cb");
        }
        return t(jSONObject, new b(optString));
    }

    public d.a.l0.a.u.h.b s(String str) {
        if (d.f44812c) {
            Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-GameCenterApi", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.l0.a.e0.d.b("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        return t((JSONObject) b2.second, new c());
    }

    public final d.a.l0.a.u.h.b t(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        String optString = jSONObject.optString(RetrieveTaskManager.KEY);
        if (TextUtils.isEmpty(optString)) {
            return new d.a.l0.a.u.h.b(202, "empty api name");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        d.a.l0.a.u.h.b a2 = d.a.l0.a.c1.a.m0().a(optString, optJSONObject, bVar);
        return a2 == null ? new d.a.l0.a.u.h.b(0) : a2;
    }
}
