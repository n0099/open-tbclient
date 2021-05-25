package d.a.l0.a.d2;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.a.u.c.d {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f41320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41321f;

        public a(boolean z, String str) {
            this.f41320e = z;
            this.f41321f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (bool.booleanValue()) {
                d.a.l0.a.d2.a.e(this.f41320e);
                b.this.d(this.f41321f, new d.a.l0.a.u.h.b(0));
                return;
            }
            b.this.d(this.f41321f, new d.a.l0.a.u.h.b(10005, "system deny"));
        }
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b r(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-hideShareDialog", "params: " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-hideShareDialog", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (bVar.a()) {
            JSONObject jSONObject = (JSONObject) b2.second;
            d.a.l0.a.d2.a.b(new a(jSONObject.optBoolean("hide"), jSONObject.optString("cb")));
            return new d.a.l0.a.u.h.b(0);
        }
        return bVar;
    }
}
