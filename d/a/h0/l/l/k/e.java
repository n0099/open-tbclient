package d.a.h0.l.l.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.l.l.k.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e extends d.a.h0.l.l.k.b {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f47239a;

        /* renamed from: b  reason: collision with root package name */
        public String f47240b;

        /* renamed from: c  reason: collision with root package name */
        public long f47241c = 0;

        public a(String str) {
            this.f47239a = str;
        }

        @NonNull
        public static List<a> f(@Nullable List<d.a.h0.l.k.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (d.a.h0.l.k.g gVar : list) {
                    if (gVar != null) {
                        a aVar = new a(gVar.f47153g);
                        aVar.d(gVar.r ? "independent" : "normal");
                        aVar.e(gVar.f47155i);
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }

        public String a() {
            return this.f47239a;
        }

        public String b() {
            return this.f47240b;
        }

        public long c() {
            return this.f47241c;
        }

        public void d(String str) {
            this.f47240b = str;
        }

        public void e(long j) {
            this.f47241c = j;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends b.a {
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public String[] f47242e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public List<a> f47243f;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] h() {
            return this.f47242e;
        }

        @Nullable
        public List<a> i() {
            return this.f47243f;
        }

        public void j(@Nullable String[] strArr) {
            this.f47242e = strArr;
        }

        public void k(@Nullable List<a> list) {
            this.f47243f = list;
        }
    }

    @WorkerThread
    public e(List<b> list, @Nullable d.a.h0.l.r.a aVar) {
        super((List<? extends b.a>) list, aVar);
    }

    @Override // d.a.h0.l.l.k.b
    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, d.a.h0.l.k.f> map2, @NonNull b.a aVar, @Nullable d.a.h0.l.r.a aVar2) {
        int i2;
        super.g(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.h() == null || bVar.i() != null || (i2 = d.a.h0.l.i.a.h().i(bVar.b())) < 0) {
                return;
            }
            bVar.k(a.f(d.a.h0.l.i.a.h().j(bVar.b(), i2)));
        }
    }
}
