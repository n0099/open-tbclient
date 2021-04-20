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
    public static final boolean f46114g = d.b.g0.a.k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.b.g0.a.i2.u0.b<i.a>> f46115e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<d.b.g0.a.i2.u0.c<i.a, Boolean>> f46116f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f46117e;

        public a(d.b.g0.a.i2.u0.b bVar) {
            this.f46117e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.this.f46115e.put(str, this.f46117e);
        }
    }

    /* renamed from: d.b.g0.a.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0789b implements d.b.g0.a.i2.u0.b<String> {
        public C0789b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            b.this.f46115e.remove(str);
        }
    }

    public b b(d.b.g0.a.i2.u0.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.f46116f.add(cVar);
        }
        return this;
    }

    public final boolean c(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (d.b.g0.a.i2.u0.c<i.a, Boolean> cVar : this.f46116f) {
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
        if (f46114g) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (!c(aVar) || (bVar = this.f46115e.get(aVar.f46137g)) == null) {
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
            d.b.g0.a.i2.u0.a.d(new C0789b(), strArr);
        }
        return this;
    }
}
