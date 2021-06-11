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
    public static final int f48159f = e.d();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f48160b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.l0.a.r1.k.h.a> f48161c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48162d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f48163e;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            b.this.f48162d = false;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f48162d = false;
            if (b.this.f48161c.isEmpty()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<d.a.l0.a.r1.k.h.a> it = b.this.f48161c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            if (d.a.l0.a.f1.f.a.f45528a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + b.this.f48161c.size());
            }
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            b.this.f48162d = true;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "GlobalJsBridge";
        }
    }

    /* renamed from: d.a.l0.a.r1.k.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0863b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f48165a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return C0863b.f48165a;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && f48159f > 0 && this.f48162d) {
            for (String str2 : this.f48160b) {
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
        if (f48159f <= 0) {
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.d("SwanPerformance", "pending api close, can't register. duration = " + f48159f);
                return;
            }
            return;
        }
        this.f48161c.add(aVar);
        d.a.l0.a.r1.r.a.f().h(this.f48163e, f48159f);
    }

    public b() {
        this.f48160b = new ArrayList();
        this.f48161c = new CopyOnWriteArrayList<>();
        this.f48162d = false;
        this.f48163e = new a();
        this.f48160b.clear();
        List<String> list = this.f48160b;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }
}
