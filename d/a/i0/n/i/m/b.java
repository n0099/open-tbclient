package d.a.i0.n.i.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: d  reason: collision with root package name */
    public Set<a> f47921d;

    public b(List<? extends a> list, @Nullable d.a.i0.n.o.a aVar) {
        super(-1);
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f47921d = new LinkedHashSet();
        Map<String, PMSAppInfo> t = d.a.i0.n.g.a.h().t();
        Map<String, d.a.i0.n.h.f> p = d.a.i0.n.g.a.h().p();
        for (a aVar2 : list) {
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.b())) {
                g(t, p, aVar2, aVar);
                this.f47921d.add(aVar2);
            }
        }
    }

    @Nullable
    public Set<a> f() {
        return this.f47921d;
    }

    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, d.a.i0.n.h.f> map2, @NonNull a aVar, @Nullable d.a.i0.n.o.a aVar2) {
        PMSAppInfo pMSAppInfo;
        if (!map.containsKey(aVar.b()) || (pMSAppInfo = map.get(aVar.b())) == null) {
            return;
        }
        if (aVar.c() == -1) {
            aVar.f(pMSAppInfo.appCategory);
        }
        if (!map2.containsKey(aVar.b())) {
            aVar.g(0L);
        } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.a(aVar.b(), aVar.c())) {
            aVar.g(0L);
        } else {
            d.a.i0.n.h.f fVar = map2.get(aVar.b());
            if (fVar != null) {
                aVar.g(fVar.f47838i);
            } else {
                aVar.g(0L);
            }
        }
        if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.a()) {
            aVar.e(pMSAppInfo.appSign);
        } else {
            aVar.e(0L);
        }
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f47922a;

        /* renamed from: b  reason: collision with root package name */
        public int f47923b;

        /* renamed from: c  reason: collision with root package name */
        public long f47924c;

        /* renamed from: d  reason: collision with root package name */
        public long f47925d;

        public a(String str) {
            this.f47923b = -1;
            this.f47924c = 0L;
            this.f47925d = 0L;
            this.f47922a = str;
        }

        public long a() {
            return this.f47925d;
        }

        public String b() {
            return this.f47922a;
        }

        public int c() {
            return this.f47923b;
        }

        public long d() {
            return this.f47924c;
        }

        public void e(long j) {
            this.f47925d = j;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.b(), this.f47922a) && aVar.c() == this.f47923b;
            }
            return false;
        }

        public void f(int i2) {
            this.f47923b = i2;
        }

        public void g(long j) {
            this.f47924c = j;
        }

        public int hashCode() {
            return Objects.hash(this.f47922a, Integer.valueOf(this.f47923b));
        }

        public a(String str, int i2) {
            this.f47923b = -1;
            this.f47924c = 0L;
            this.f47925d = 0L;
            this.f47922a = str;
            this.f47923b = i2;
        }
    }

    public b(Collection<String> collection, @Nullable d.a.i0.n.o.a aVar) {
        super(-1);
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f47921d = new LinkedHashSet();
        Map<String, PMSAppInfo> t = d.a.i0.n.g.a.h().t();
        Map<String, d.a.i0.n.h.f> p = d.a.i0.n.g.a.h().p();
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                a aVar2 = new a(str);
                g(t, p, aVar2, aVar);
                this.f47921d.add(aVar2);
            }
        }
    }
}
