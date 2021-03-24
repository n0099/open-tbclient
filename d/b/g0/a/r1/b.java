package d.b.g0.a.r1;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.r1.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class b implements d.b.g0.a.i2.u0.b<i.a> {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45721g = d.b.g0.a.k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.b.g0.a.i2.u0.b<i.a>> f45722e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<d.b.g0.a.i2.u0.c<i.a, Boolean>> f45723f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f45724e;

        public a(d.b.g0.a.i2.u0.b bVar) {
            this.f45724e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.this.f45722e.put(str, this.f45724e);
        }
    }

    /* renamed from: d.b.g0.a.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0776b implements d.b.g0.a.i2.u0.b<String> {
        public C0776b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            b.this.f45722e.remove(str);
        }
    }

    public b b(d.b.g0.a.i2.u0.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.f45723f.add(cVar);
        }
        return this;
    }

    public final boolean c(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (d.b.g0.a.i2.u0.c<i.a, Boolean> cVar : this.f45723f) {
            if (cVar != null && !cVar.a(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.i2.u0.b
    /* renamed from: d */
    public void onCallback(i.a aVar) {
        d.b.g0.a.i2.u0.b<i.a> bVar;
        if (f45721g) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (!c(aVar) || (bVar = this.f45722e.get(aVar.f45744g)) == null) {
            return;
        }
        bVar.onCallback(aVar);
    }

    public b e(d.b.g0.a.i2.u0.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            d.b.g0.a.i2.u0.a.d(new a(bVar), strArr);
        }
        return this;
    }

    public b f(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            d.b.g0.a.i2.u0.a.d(new C0776b(), strArr);
        }
        return this;
    }
}
