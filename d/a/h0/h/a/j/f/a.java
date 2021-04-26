package d.a.h0.h.a.j.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import d.a.h0.a.c0.c;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.h.a.f.f.d;
import d.a.h0.h.a.j.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.h0.h.a.f.a<d.a.h0.a.a1.c.a> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.a1.b f47015a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.a1.c.a f47016b;

    /* renamed from: d.a.h0.h.a.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0981a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.b f47017a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47018b;

        public C0981a(d.a.h0.a.a1.b bVar, String str) {
            this.f47017a = bVar;
            this.f47018b = str;
        }

        @Override // d.a.h0.h.a.f.f.d.c
        public void onFail() {
            c.l("map", "location permission fail");
            this.f47017a.b(this.f47018b, 1003, "location permission fail");
        }

        @Override // d.a.h0.h.a.f.f.d.c
        public void onSuccess() {
            c.l("map", "location permission success");
            a.this.g();
        }
    }

    static {
        boolean z = k.f43101a;
    }

    public static a h() {
        return new a();
    }

    @Override // d.a.h0.h.a.j.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        d.a.h0.a.a1.c.a aVar;
        d.a.h0.a.a1.b bVar = this.f47015a;
        if (bVar == null || (aVar = this.f47016b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.a());
    }

    public final boolean e(Context context, d.a.h0.a.a1.c.a aVar, d.a.h0.a.a1.b bVar, e eVar) {
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
        this.f47015a = bVar;
        this.f47016b = aVar;
        d.b(context, new C0981a(bVar, str));
        c.g("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.h.a.f.a
    /* renamed from: f */
    public boolean b(Context context, d.a.h0.a.a1.c.a aVar, d.a.h0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, aVar, bVar, eVar);
    }

    public final void g() {
        d.a.h0.h.a.j.a H2 = d.a.h0.h.a.j.a.H2(null);
        H2.M2(this);
        H2.O2();
    }

    @Override // d.a.h0.h.a.j.a.b
    public void onCancel() {
        d.a.h0.a.a1.c.a aVar;
        c.g("map", "choose location cancel");
        d.a.h0.a.a1.b bVar = this.f47015a;
        if (bVar == null || (aVar = this.f47016b) == null) {
            return;
        }
        bVar.b(aVar.D, 1002, "choose location canceled");
    }

    @Override // d.a.h0.h.a.j.a.b
    public void onError() {
        d.a.h0.a.a1.c.a aVar;
        c.g("map", "choose location fail");
        d.a.h0.a.a1.b bVar = this.f47015a;
        if (bVar == null || (aVar = this.f47016b) == null) {
            return;
        }
        bVar.b(aVar.D, 1007, "choose location failed");
    }
}
