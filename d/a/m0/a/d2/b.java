package d.a.m0.a.d2;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.u.c.d {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45105f;

        public a(boolean z, String str) {
            this.f45104e = z;
            this.f45105f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (bool.booleanValue()) {
                d.a.m0.a.d2.a.e(this.f45104e);
                b.this.d(this.f45105f, new d.a.m0.a.u.h.b(0));
                return;
            }
            b.this.d(this.f45105f, new d.a.m0.a.u.h.b(10005, "system deny"));
        }
    }

    public b(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b r(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-hideShareDialog", "params: " + str);
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-hideShareDialog", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (bVar.isSuccess()) {
            JSONObject jSONObject = (JSONObject) b2.second;
            d.a.m0.a.d2.a.b(new a(jSONObject.optBoolean("hide"), jSONObject.optString("cb")));
            return new d.a.m0.a.u.h.b(0);
        }
        return bVar;
    }
}
