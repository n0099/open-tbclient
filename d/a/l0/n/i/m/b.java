package d.a.l0.n.i.m;

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
    public Set<a> f48097d;

    public b(List<? extends a> list, @Nullable d.a.l0.n.o.a aVar) {
        super(-1);
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f48097d = new LinkedHashSet();
        Map<String, PMSAppInfo> t = d.a.l0.n.g.a.h().t();
        Map<String, d.a.l0.n.h.f> p = d.a.l0.n.g.a.h().p();
        for (a aVar2 : list) {
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.b())) {
                g(t, p, aVar2, aVar);
                this.f48097d.add(aVar2);
            }
        }
    }

    @Nullable
    public Set<a> f() {
        return this.f48097d;
    }

    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, d.a.l0.n.h.f> map2, @NonNull a aVar, @Nullable d.a.l0.n.o.a aVar2) {
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
            d.a.l0.n.h.f fVar = map2.get(aVar.b());
            if (fVar != null) {
                aVar.g(fVar.f48014i);
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
        public String f48098a;

        /* renamed from: b  reason: collision with root package name */
        public int f48099b;

        /* renamed from: c  reason: collision with root package name */
        public long f48100c;

        /* renamed from: d  reason: collision with root package name */
        public long f48101d;

        public a(String str) {
            this.f48099b = -1;
            this.f48100c = 0L;
            this.f48101d = 0L;
            this.f48098a = str;
        }

        public long a() {
            return this.f48101d;
        }

        public String b() {
            return this.f48098a;
        }

        public int c() {
            return this.f48099b;
        }

        public long d() {
            return this.f48100c;
        }

        public void e(long j) {
            this.f48101d = j;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.b(), this.f48098a) && aVar.c() == this.f48099b;
            }
            return false;
        }

        public void f(int i2) {
            this.f48099b = i2;
        }

        public void g(long j) {
            this.f48100c = j;
        }

        public int hashCode() {
            return Objects.hash(this.f48098a, Integer.valueOf(this.f48099b));
        }

        public a(String str, int i2) {
            this.f48099b = -1;
            this.f48100c = 0L;
            this.f48101d = 0L;
            this.f48098a = str;
            this.f48099b = i2;
        }
    }

    public b(Collection<String> collection, @Nullable d.a.l0.n.o.a aVar) {
        super(-1);
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f48097d = new LinkedHashSet();
        Map<String, PMSAppInfo> t = d.a.l0.n.g.a.h().t();
        Map<String, d.a.l0.n.h.f> p = d.a.l0.n.g.a.h().p();
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                a aVar2 = new a(str);
                g(t, p, aVar2, aVar);
                this.f48097d.add(aVar2);
            }
        }
    }
}
