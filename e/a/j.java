package e.a;

import android.content.SharedPreferences;
import android.util.Log;
import e.a.h;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j extends h<JSONObject> {

    /* loaded from: classes7.dex */
    public class a implements h.a<JSONObject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.a.h.a
        /* renamed from: b */
        public JSONObject create() {
            return new JSONObject();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.a.h.a
        /* renamed from: c */
        public JSONObject load(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                Log.e("Persistent", "failed to load SuperProperties from SharedPreferences.", e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.a.h.a
        /* renamed from: d */
        public String a(JSONObject jSONObject) {
            return jSONObject.toString();
        }
    }

    public j(Future<SharedPreferences> future) {
        super(future, "super_properties", new a());
    }
}
