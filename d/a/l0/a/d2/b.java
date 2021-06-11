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
        public final /* synthetic */ boolean f44996e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44997f;

        public a(boolean z, String str) {
            this.f44996e = z;
            this.f44997f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (bool.booleanValue()) {
                d.a.l0.a.d2.a.e(this.f44996e);
                b.this.d(this.f44997f, new d.a.l0.a.u.h.b(0));
                return;
            }
            b.this.d(this.f44997f, new d.a.l0.a.u.h.b(10005, "system deny"));
        }
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b r(String str) {
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-hideShareDialog", "params: " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-hideShareDialog", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (bVar.isSuccess()) {
            JSONObject jSONObject = (JSONObject) b2.second;
            d.a.l0.a.d2.a.b(new a(jSONObject.optBoolean("hide"), jSONObject.optString("cb")));
            return new d.a.l0.a.u.h.b(0);
        }
        return bVar;
    }
}
