package d.a.i0.a.u.e.o;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.i0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public String f44986d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.v2.e1.b<Integer> f44987e;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<Integer> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 1 || num.intValue() == 0) {
                f.this.t();
            }
        }
    }

    public f(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
        this.f44987e = new a();
    }

    public d.a.i0.a.u.h.b s(String str) {
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-ExitFullScreenApi", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-ExitFullScreenApi", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        this.f44986d = optString;
        if (TextUtils.isEmpty(optString)) {
            return new d.a.i0.a.u.h.b(201);
        }
        k.e().u(this.f44987e);
        k.e().l();
        return new d.a.i0.a.u.h.b(0);
    }

    public final void t() {
        k.e().v();
        k.e().o();
        d(this.f44986d, new d.a.i0.a.u.h.b(0));
    }
}
