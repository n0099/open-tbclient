package d.a.l0.j.o.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import d.a.l0.a.a2.e;
import d.a.l0.a.h1.b;
import d.a.l0.a.k;
import d.a.l0.j.k.f.d;
import d.a.l0.j.o.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.j.k.a<d.a.l0.a.h1.c.a> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public b f47916a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.h1.c.a f47917b;

    /* renamed from: d.a.l0.j.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1071a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47919b;

        public C1071a(b bVar, String str) {
            this.f47918a = bVar;
            this.f47919b = str;
        }

        @Override // d.a.l0.j.k.f.d.c
        public void onFail() {
            d.a.l0.a.e0.d.l("map", "location permission fail");
            this.f47918a.b(this.f47919b, 1003, "location permission fail");
        }

        @Override // d.a.l0.j.k.f.d.c
        public void onSuccess() {
            d.a.l0.a.e0.d.l("map", "location permission success");
            a.this.g();
        }
    }

    static {
        boolean z = k.f43199a;
    }

    public static a h() {
        return new a();
    }

    @Override // d.a.l0.j.o.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        d.a.l0.a.h1.c.a aVar;
        b bVar = this.f47916a;
        if (bVar == null || (aVar = this.f47917b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.a());
    }

    public final boolean e(Context context, d.a.l0.a.h1.c.a aVar, b bVar, e eVar) {
        d.a.l0.a.e0.d.g("map", "ChooseLocationAction start");
        if (!aVar.isValid()) {
            d.a.l0.a.e0.d.b("map", "model is invalid");
            return false;
        }
        String str = aVar.D;
        if (TextUtils.isEmpty(str)) {
            d.a.l0.a.e0.d.b("map", "cb is empty");
            return false;
        }
        this.f47916a = bVar;
        this.f47917b = aVar;
        d.b(context, new C1071a(bVar, str));
        d.a.l0.a.e0.d.g("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.j.k.a
    /* renamed from: f */
    public boolean b(Context context, d.a.l0.a.h1.c.a aVar, b bVar, e eVar, JSONObject jSONObject) {
        return e(context, aVar, bVar, eVar);
    }

    public final void g() {
        d.a.l0.j.o.a O2 = d.a.l0.j.o.a.O2(null);
        O2.T2(this);
        O2.V2();
    }

    @Override // d.a.l0.j.o.a.b
    public void onCancel() {
        d.a.l0.a.h1.c.a aVar;
        d.a.l0.a.e0.d.g("map", "choose location cancel");
        b bVar = this.f47916a;
        if (bVar == null || (aVar = this.f47917b) == null) {
            return;
        }
        bVar.b(aVar.D, 1002, "choose location canceled");
    }

    @Override // d.a.l0.j.o.a.b
    public void onError() {
        d.a.l0.a.h1.c.a aVar;
        d.a.l0.a.e0.d.g("map", "choose location fail");
        b bVar = this.f47916a;
        if (bVar == null || (aVar = this.f47917b) == null) {
            return;
        }
        bVar.b(aVar.D, 1007, "choose location failed");
    }
}
