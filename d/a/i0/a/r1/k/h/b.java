package d.a.i0.a.r1.k.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.i0.a.r1.l.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class b implements d.a.i0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f44309f = e.d();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f44310b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.i0.a.r1.k.h.a> f44311c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44312d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.r1.r.c.a f44313e;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void b() {
            b.this.f44312d = false;
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f44312d = false;
            if (b.this.f44311c.isEmpty()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<d.a.i0.a.r1.k.h.a> it = b.this.f44311c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            if (d.a.i0.a.f1.f.a.f41678a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + b.this.f44311c.size());
            }
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void d(String str) {
            b.this.f44312d = true;
        }

        @Override // d.a.i0.a.r1.r.c.a
        public String getName() {
            return "GlobalJsBridge";
        }
    }

    /* renamed from: d.a.i0.a.r1.k.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0796b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44315a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return C0796b.f44315a;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && f44309f > 0 && this.f44312d) {
            for (String str2 : this.f44310b) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void d(d.a.i0.a.r1.k.h.a aVar) {
        if (aVar == null) {
            return;
        }
        if (f44309f <= 0) {
            if (d.a.i0.a.f1.f.a.f41678a) {
                Log.d("SwanPerformance", "pending api close, can't register. duration = " + f44309f);
                return;
            }
            return;
        }
        this.f44311c.add(aVar);
        d.a.i0.a.r1.r.a.f().h(this.f44313e, f44309f);
    }

    public b() {
        this.f44310b = new ArrayList();
        this.f44311c = new CopyOnWriteArrayList<>();
        this.f44312d = false;
        this.f44313e = new a();
        this.f44310b.clear();
        List<String> list = this.f44310b;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }
}
