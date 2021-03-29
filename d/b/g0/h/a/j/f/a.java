package d.b.g0.h.a.j.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import d.b.g0.a.c0.c;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.h.a.f.f.d;
import d.b.g0.h.a.j.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.h.a.f.a<d.b.g0.a.a1.c.a> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.a1.b f48792a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.a1.c.a f48793b;

    /* renamed from: d.b.g0.h.a.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1010a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f48794a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48795b;

        public C1010a(d.b.g0.a.a1.b bVar, String str) {
            this.f48794a = bVar;
            this.f48795b = str;
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onFail() {
            c.l("map", "location permission fail");
            this.f48794a.b(this.f48795b, 1003, "location permission fail");
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onSuccess() {
            c.l("map", "location permission success");
            a.this.g();
        }
    }

    static {
        boolean z = k.f45051a;
    }

    public static a h() {
        return new a();
    }

    @Override // d.b.g0.h.a.j.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        d.b.g0.a.a1.c.a aVar;
        d.b.g0.a.a1.b bVar = this.f48792a;
        if (bVar == null || (aVar = this.f48793b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.a());
    }

    public final boolean e(Context context, d.b.g0.a.a1.c.a aVar, d.b.g0.a.a1.b bVar, e eVar) {
        c.g("map", "ChooseLocationAction start");
        if (!aVar.isValid()) {
            c.b("map", "model is invalid");
            return false;
        }
        String str = aVar.D;
        if (TextUtils.isEmpty(str)) {
            c.b("map", "cb is empty");
            return false;
        }
        this.f48792a = bVar;
        this.f48793b = aVar;
        d.b(context, new C1010a(bVar, str));
        c.g("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.h.a.f.a
    /* renamed from: f */
    public boolean b(Context context, d.b.g0.a.a1.c.a aVar, d.b.g0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, aVar, bVar, eVar);
    }

    public final void g() {
        d.b.g0.h.a.j.a I2 = d.b.g0.h.a.j.a.I2(null);
        I2.N2(this);
        I2.P2();
    }

    @Override // d.b.g0.h.a.j.a.b
    public void onCancel() {
        d.b.g0.a.a1.c.a aVar;
        c.g("map", "choose location cancel");
        d.b.g0.a.a1.b bVar = this.f48792a;
        if (bVar == null || (aVar = this.f48793b) == null) {
            return;
        }
        bVar.b(aVar.D, 1002, "choose location canceled");
    }

    @Override // d.b.g0.h.a.j.a.b
    public void onError() {
        d.b.g0.a.a1.c.a aVar;
        c.g("map", "choose location fail");
        d.b.g0.a.a1.b bVar = this.f48792a;
        if (bVar == null || (aVar = this.f48793b) == null) {
            return;
        }
        bVar.b(aVar.D, 1007, "choose location failed");
    }
}
