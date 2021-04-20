package d.b.i0.q0.m2;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.d.l;
import java.util.Map;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f59548c;

    /* renamed from: a  reason: collision with root package name */
    public LruCache<String, String> f59549a = new LruCache<>(10);

    /* renamed from: b  reason: collision with root package name */
    public l<String> f59550b = d.b.h0.r.r.a.f().g("tb.recently_vistited_forum_animation");

    /* loaded from: classes4.dex */
    public class a extends d.b.h0.m.g {
        public a() {
        }

        @Override // d.b.h0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == null || !activity.getClass().getName().equals("FrsActivity")) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : d.this.f59549a.snapshot().entrySet()) {
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
                sb.append(",");
            }
            if (sb.length() <= 1) {
                return;
            }
            sb.deleteCharAt(sb.length() - 1);
            d.this.f59550b.a("transition_cache_key", sb.toString());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.a<String> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.d.l.a
        /* renamed from: b */
        public void a(String str, String str2) {
            if (str2 == null || str2.isEmpty()) {
                return;
            }
            for (String str3 : str2.split(",")) {
                String[] split = str3.split("=");
                if (split != null && split.length == 2) {
                    d.this.f59549a.put(split[0], split[1]);
                }
            }
        }
    }

    public d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new a());
        this.f59550b.f("transition_cache_key", new b());
    }

    public static d d() {
        if (f59548c == null) {
            synchronized (d.class) {
                if (f59548c == null) {
                    f59548c = new d();
                }
            }
        }
        return f59548c;
    }

    public e c(String str) {
        if (str == null) {
            return new e(null);
        }
        return new e(this.f59549a.get(str));
    }

    public void e(String str, e eVar) {
        this.f59549a.put(str, eVar.toString());
    }
}
