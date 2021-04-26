package d.a.h0.a.r1;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.r1.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class b implements d.a.h0.a.i2.u0.b<i.a> {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f43804g = d.a.h0.a.k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.h0.a.i2.u0.b<i.a>> f43805e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.h0.a.i2.u0.c<i.a, Boolean>> f43806f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f43807e;

        public a(d.a.h0.a.i2.u0.b bVar) {
            this.f43807e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.this.f43805e.put(str, this.f43807e);
        }
    }

    /* renamed from: d.a.h0.a.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0748b implements d.a.h0.a.i2.u0.b<String> {
        public C0748b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            b.this.f43805e.remove(str);
        }
    }

    public b b(d.a.h0.a.i2.u0.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.f43806f.add(cVar);
        }
        return this;
    }

    public final boolean c(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (d.a.h0.a.i2.u0.c<i.a, Boolean> cVar : this.f43806f) {
            if (cVar != null && !cVar.a(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.i2.u0.b
    /* renamed from: d */
    public void onCallback(i.a aVar) {
        d.a.h0.a.i2.u0.b<i.a> bVar;
        if (f43804g) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (!c(aVar) || (bVar = this.f43805e.get(aVar.f43829g)) == null) {
            return;
        }
        bVar.onCallback(aVar);
    }

    public b e(d.a.h0.a.i2.u0.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            d.a.h0.a.i2.u0.a.d(new a(bVar), strArr);
        }
        return this;
    }

    public b f(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            d.a.h0.a.i2.u0.a.d(new C0748b(), strArr);
        }
        return this;
    }
}
