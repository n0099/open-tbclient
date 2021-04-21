package d.b.h0.h.a.j.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import d.b.h0.a.c0.c;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.h.a.f.f.d;
import d.b.h0.h.a.j.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.h0.h.a.f.a<d.b.h0.a.a1.c.a> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.a1.b f49513a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.a1.c.a f49514b;

    /* renamed from: d.b.h0.h.a.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1042a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.b f49515a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49516b;

        public C1042a(d.b.h0.a.a1.b bVar, String str) {
            this.f49515a = bVar;
            this.f49516b = str;
        }

        @Override // d.b.h0.h.a.f.f.d.c
        public void onFail() {
            c.l("map", "location permission fail");
            this.f49515a.b(this.f49516b, 1003, "location permission fail");
        }

        @Override // d.b.h0.h.a.f.f.d.c
        public void onSuccess() {
            c.l("map", "location permission success");
            a.this.g();
        }
    }

    static {
        boolean z = k.f45772a;
    }

    public static a h() {
        return new a();
    }

    @Override // d.b.h0.h.a.j.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        d.b.h0.a.a1.c.a aVar;
        d.b.h0.a.a1.b bVar = this.f49513a;
        if (bVar == null || (aVar = this.f49514b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.a());
    }

    public final boolean e(Context context, d.b.h0.a.a1.c.a aVar, d.b.h0.a.a1.b bVar, e eVar) {
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
        this.f49513a = bVar;
        this.f49514b = aVar;
        d.b(context, new C1042a(bVar, str));
        c.g("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.h.a.f.a
    /* renamed from: f */
    public boolean b(Context context, d.b.h0.a.a1.c.a aVar, d.b.h0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, aVar, bVar, eVar);
    }

    public final void g() {
        d.b.h0.h.a.j.a I2 = d.b.h0.h.a.j.a.I2(null);
        I2.N2(this);
        I2.P2();
    }

    @Override // d.b.h0.h.a.j.a.b
    public void onCancel() {
        d.b.h0.a.a1.c.a aVar;
        c.g("map", "choose location cancel");
        d.b.h0.a.a1.b bVar = this.f49513a;
        if (bVar == null || (aVar = this.f49514b) == null) {
            return;
        }
        bVar.b(aVar.D, 1002, "choose location canceled");
    }

    @Override // d.b.h0.h.a.j.a.b
    public void onError() {
        d.b.h0.a.a1.c.a aVar;
        c.g("map", "choose location fail");
        d.b.h0.a.a1.b bVar = this.f49513a;
        if (bVar == null || (aVar = this.f49514b) == null) {
            return;
        }
        bVar.b(aVar.D, 1007, "choose location failed");
    }
}
