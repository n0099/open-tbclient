package d.a.l0.a.a2;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.a2.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class b implements d.a.l0.a.v2.e1.b<i.a> {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f40730g = d.a.l0.a.k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.l0.a.v2.e1.b<i.a>> f40731e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.l0.a.v2.e1.c<i.a, Boolean>> f40732f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f40733e;

        public a(d.a.l0.a.v2.e1.b bVar) {
            this.f40733e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.this.f40731e.put(str, this.f40733e);
        }
    }

    /* renamed from: d.a.l0.a.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0564b implements d.a.l0.a.v2.e1.b<String> {
        public C0564b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            b.this.f40731e.remove(str);
        }
    }

    public b b(d.a.l0.a.v2.e1.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.f40732f.add(cVar);
        }
        return this;
    }

    public final boolean c(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (d.a.l0.a.v2.e1.c<i.a, Boolean> cVar : this.f40732f) {
            if (cVar != null && !cVar.a(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v2.e1.b
    /* renamed from: d */
    public void onCallback(i.a aVar) {
        d.a.l0.a.v2.e1.b<i.a> bVar;
        if (f40730g) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (!c(aVar) || (bVar = this.f40731e.get(aVar.f40755f)) == null) {
            return;
        }
        bVar.onCallback(aVar);
    }

    public b e(d.a.l0.a.v2.e1.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            d.a.l0.a.v2.e1.a.d(new a(bVar), strArr);
        }
        return this;
    }

    public b f(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            d.a.l0.a.v2.e1.a.d(new C0564b(), strArr);
        }
        return this;
    }
}
