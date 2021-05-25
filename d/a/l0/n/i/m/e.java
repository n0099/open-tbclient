package d.a.l0.n.i.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.n.i.m.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e extends d.a.l0.n.i.m.b {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f48111a;

        /* renamed from: b  reason: collision with root package name */
        public String f48112b;

        /* renamed from: c  reason: collision with root package name */
        public long f48113c = 0;

        public a(String str) {
            this.f48111a = str;
        }

        @NonNull
        public static List<a> f(@Nullable List<d.a.l0.n.h.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (d.a.l0.n.h.g gVar : list) {
                    if (gVar != null) {
                        a aVar = new a(gVar.f48012g);
                        aVar.d(gVar.r ? "independent" : "normal");
                        aVar.e(gVar.f48014i);
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }

        public String a() {
            return this.f48111a;
        }

        public String b() {
            return this.f48112b;
        }

        public long c() {
            return this.f48113c;
        }

        public void d(String str) {
            this.f48112b = str;
        }

        public void e(long j) {
            this.f48113c = j;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends b.a {
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public String[] f48114e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public List<a> f48115f;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] h() {
            return this.f48114e;
        }

        @Nullable
        public List<a> i() {
            return this.f48115f;
        }

        public void j(@Nullable String[] strArr) {
            this.f48114e = strArr;
        }

        public void k(@Nullable List<a> list) {
            this.f48115f = list;
        }
    }

    @WorkerThread
    public e(List<b> list, @Nullable d.a.l0.n.o.a aVar) {
        super((List<? extends b.a>) list, aVar);
    }

    @Override // d.a.l0.n.i.m.b
    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, d.a.l0.n.h.f> map2, @NonNull b.a aVar, @Nullable d.a.l0.n.o.a aVar2) {
        int i2;
        super.g(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.h() == null || bVar.i() != null || (i2 = d.a.l0.n.g.a.h().i(bVar.b())) < 0) {
                return;
            }
            bVar.k(a.f(d.a.l0.n.g.a.h().j(bVar.b(), i2)));
        }
    }
}
