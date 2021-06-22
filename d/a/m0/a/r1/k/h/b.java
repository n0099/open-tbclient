package d.a.m0.a.r1.k.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.m0.a.r1.l.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f48267f = e.d();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f48268b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.m0.a.r1.k.h.a> f48269c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48270d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.r1.r.c.a f48271e;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void b() {
            b.this.f48270d = false;
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f48270d = false;
            if (b.this.f48269c.isEmpty()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<d.a.m0.a.r1.k.h.a> it = b.this.f48269c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            if (d.a.m0.a.f1.f.a.f45636a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + b.this.f48269c.size());
            }
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void d(String str) {
            b.this.f48270d = true;
        }

        @Override // d.a.m0.a.r1.r.c.a
        public String getName() {
            return "GlobalJsBridge";
        }
    }

    /* renamed from: d.a.m0.a.r1.k.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0866b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f48273a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return C0866b.f48273a;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && f48267f > 0 && this.f48270d) {
            for (String str2 : this.f48268b) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void d(d.a.m0.a.r1.k.h.a aVar) {
        if (aVar == null) {
            return;
        }
        if (f48267f <= 0) {
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.d("SwanPerformance", "pending api close, can't register. duration = " + f48267f);
                return;
            }
            return;
        }
        this.f48269c.add(aVar);
        d.a.m0.a.r1.r.a.f().h(this.f48271e, f48267f);
    }

    public b() {
        this.f48268b = new ArrayList();
        this.f48269c = new CopyOnWriteArrayList<>();
        this.f48270d = false;
        this.f48271e = new a();
        this.f48268b.clear();
        List<String> list = this.f48268b;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }
}
