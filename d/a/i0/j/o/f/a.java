package d.a.i0.j.o.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import d.a.i0.a.a2.e;
import d.a.i0.a.h1.b;
import d.a.i0.a.k;
import d.a.i0.j.k.f.d;
import d.a.i0.j.o.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.i0.j.k.a<d.a.i0.a.h1.c.a> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public b f47740a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.h1.c.a f47741b;

    /* renamed from: d.a.i0.j.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1060a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47742a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47743b;

        public C1060a(b bVar, String str) {
            this.f47742a = bVar;
            this.f47743b = str;
        }

        @Override // d.a.i0.j.k.f.d.c
        public void onFail() {
            d.a.i0.a.e0.d.l("map", "location permission fail");
            this.f47742a.b(this.f47743b, 1003, "location permission fail");
        }

        @Override // d.a.i0.j.k.f.d.c
        public void onSuccess() {
            d.a.i0.a.e0.d.l("map", "location permission success");
            a.this.g();
        }
    }

    static {
        boolean z = k.f43025a;
    }

    public static a h() {
        return new a();
    }

    @Override // d.a.i0.j.o.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        d.a.i0.a.h1.c.a aVar;
        b bVar = this.f47740a;
        if (bVar == null || (aVar = this.f47741b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.a());
    }

    public final boolean e(Context context, d.a.i0.a.h1.c.a aVar, b bVar, e eVar) {
        d.a.i0.a.e0.d.g("map", "ChooseLocationAction start");
        if (!aVar.isValid()) {
            d.a.i0.a.e0.d.b("map", "model is invalid");
            return false;
        }
        String str = aVar.D;
        if (TextUtils.isEmpty(str)) {
            d.a.i0.a.e0.d.b("map", "cb is empty");
            return false;
        }
        this.f47740a = bVar;
        this.f47741b = aVar;
        d.b(context, new C1060a(bVar, str));
        d.a.i0.a.e0.d.g("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.j.k.a
    /* renamed from: f */
    public boolean b(Context context, d.a.i0.a.h1.c.a aVar, b bVar, e eVar, JSONObject jSONObject) {
        return e(context, aVar, bVar, eVar);
    }

    public final void g() {
        d.a.i0.j.o.a O2 = d.a.i0.j.o.a.O2(null);
        O2.T2(this);
        O2.V2();
    }

    @Override // d.a.i0.j.o.a.b
    public void onCancel() {
        d.a.i0.a.h1.c.a aVar;
        d.a.i0.a.e0.d.g("map", "choose location cancel");
        b bVar = this.f47740a;
        if (bVar == null || (aVar = this.f47741b) == null) {
            return;
        }
        bVar.b(aVar.D, 1002, "choose location canceled");
    }

    @Override // d.a.i0.j.o.a.b
    public void onError() {
        d.a.i0.a.h1.c.a aVar;
        d.a.i0.a.e0.d.g("map", "choose location fail");
        b bVar = this.f47740a;
        if (bVar == null || (aVar = this.f47741b) == null) {
            return;
        }
        bVar.b(aVar.D, 1007, "choose location failed");
    }
}
