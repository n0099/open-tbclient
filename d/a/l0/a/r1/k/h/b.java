package d.a.l0.a.r1.k.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.r1.l.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f44485f = e.d();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f44486b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.l0.a.r1.k.h.a> f44487c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44488d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f44489e;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            b.this.f44488d = false;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f44488d = false;
            if (b.this.f44487c.isEmpty()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<d.a.l0.a.r1.k.h.a> it = b.this.f44487c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            if (d.a.l0.a.f1.f.a.f41852a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + b.this.f44487c.size());
            }
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            b.this.f44488d = true;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "GlobalJsBridge";
        }
    }

    /* renamed from: d.a.l0.a.r1.k.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0807b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44491a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return C0807b.f44491a;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && f44485f > 0 && this.f44488d) {
            for (String str2 : this.f44486b) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void d(d.a.l0.a.r1.k.h.a aVar) {
        if (aVar == null) {
            return;
        }
        if (f44485f <= 0) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", "pending api close, can't register. duration = " + f44485f);
                return;
            }
            return;
        }
        this.f44487c.add(aVar);
        d.a.l0.a.r1.r.a.f().h(this.f44489e, f44485f);
    }

    public b() {
        this.f44486b = new ArrayList();
        this.f44487c = new CopyOnWriteArrayList<>();
        this.f44488d = false;
        this.f44489e = new a();
        this.f44486b.clear();
        List<String> list = this.f44486b;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }
}
