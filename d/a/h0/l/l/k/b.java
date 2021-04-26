package d.a.h0.l.l.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public Set<a> f47226d;

    public b(List<? extends a> list, @Nullable d.a.h0.l.r.a aVar) {
        super(-1);
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f47226d = new LinkedHashSet();
        Map<String, PMSAppInfo> s = d.a.h0.l.i.a.h().s();
        Map<String, d.a.h0.l.k.f> o = d.a.h0.l.i.a.h().o();
        for (a aVar2 : list) {
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.b())) {
                g(s, o, aVar2, aVar);
                this.f47226d.add(aVar2);
            }
        }
    }

    @Nullable
    public Set<a> f() {
        return this.f47226d;
    }

    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, d.a.h0.l.k.f> map2, @NonNull a aVar, @Nullable d.a.h0.l.r.a aVar2) {
        PMSAppInfo pMSAppInfo;
        if (!map.containsKey(aVar.b()) || (pMSAppInfo = map.get(aVar.b())) == null) {
            return;
        }
        if (aVar.c() != -1) {
            aVar.f(pMSAppInfo.appCategory);
        }
        if (!map2.containsKey(aVar.b())) {
            aVar.g(0L);
        } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.a(aVar.b())) {
            aVar.g(0L);
        } else {
            d.a.h0.l.k.f fVar = map2.get(aVar.b());
            if (fVar != null) {
                aVar.g(fVar.f47155i);
            } else {
                aVar.g(0L);
            }
        }
        if (pMSAppInfo.csProtocolVersion >= d.a.h0.l.e.a()) {
            aVar.e(pMSAppInfo.appSign);
        } else {
            aVar.e(0L);
        }
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f47227a;

        /* renamed from: b  reason: collision with root package name */
        public int f47228b;

        /* renamed from: c  reason: collision with root package name */
        public long f47229c;

        /* renamed from: d  reason: collision with root package name */
        public long f47230d;

        public a(String str) {
            this.f47228b = -1;
            this.f47229c = 0L;
            this.f47230d = 0L;
            this.f47227a = str;
        }

        public long a() {
            return this.f47230d;
        }

        public String b() {
            return this.f47227a;
        }

        public int c() {
            return this.f47228b;
        }

        public long d() {
            return this.f47229c;
        }

        public void e(long j) {
            this.f47230d = j;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.b(), this.f47227a) && aVar.c() == this.f47228b;
            }
            return false;
        }

        public void f(int i2) {
            this.f47228b = i2;
        }

        public void g(long j) {
            this.f47229c = j;
        }

        public int hashCode() {
            return Objects.hash(this.f47227a, Integer.valueOf(this.f47228b));
        }

        public a(String str, int i2) {
            this.f47228b = -1;
            this.f47229c = 0L;
            this.f47230d = 0L;
            this.f47227a = str;
            this.f47228b = i2;
        }
    }

    public b(Collection<String> collection, @Nullable d.a.h0.l.r.a aVar) {
        super(-1);
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f47226d = new LinkedHashSet();
        Map<String, PMSAppInfo> s = d.a.h0.l.i.a.h().s();
        Map<String, d.a.h0.l.k.f> o = d.a.h0.l.i.a.h().o();
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                a aVar2 = new a(str);
                g(s, o, aVar2, aVar);
                this.f47226d.add(aVar2);
            }
        }
    }
}
