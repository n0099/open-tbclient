package d.b.h0.a.r1;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.r1.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class b implements d.b.h0.a.i2.u0.b<i.a> {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46443g = d.b.h0.a.k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.b.h0.a.i2.u0.b<i.a>> f46444e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<d.b.h0.a.i2.u0.c<i.a, Boolean>> f46445f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f46446e;

        public a(d.b.h0.a.i2.u0.b bVar) {
            this.f46446e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.this.f46444e.put(str, this.f46446e);
        }
    }

    /* renamed from: d.b.h0.a.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0809b implements d.b.h0.a.i2.u0.b<String> {
        public C0809b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            b.this.f46444e.remove(str);
        }
    }

    public b b(d.b.h0.a.i2.u0.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.f46445f.add(cVar);
        }
        return this;
    }

    public final boolean c(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (d.b.h0.a.i2.u0.c<i.a, Boolean> cVar : this.f46445f) {
            if (cVar != null && !cVar.a(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.i2.u0.b
    /* renamed from: d */
    public void onCallback(i.a aVar) {
        d.b.h0.a.i2.u0.b<i.a> bVar;
        if (f46443g) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (!c(aVar) || (bVar = this.f46444e.get(aVar.f46466g)) == null) {
            return;
        }
        bVar.onCallback(aVar);
    }

    public b e(d.b.h0.a.i2.u0.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            d.b.h0.a.i2.u0.a.d(new a(bVar), strArr);
        }
        return this;
    }

    public b f(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            d.b.h0.a.i2.u0.a.d(new C0809b(), strArr);
        }
        return this;
    }
}
