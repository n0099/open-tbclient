package d.b.h0.l.l.k;

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
    public Set<a> f49714d;

    public b(List<? extends a> list, @Nullable d.b.h0.l.r.a aVar) {
        super(-1);
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f49714d = new LinkedHashSet();
        Map<String, PMSAppInfo> s = d.b.h0.l.i.a.h().s();
        Map<String, d.b.h0.l.k.f> o = d.b.h0.l.i.a.h().o();
        for (a aVar2 : list) {
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.b())) {
                g(s, o, aVar2, aVar);
                this.f49714d.add(aVar2);
            }
        }
    }

    @Nullable
    public Set<a> f() {
        return this.f49714d;
    }

    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, d.b.h0.l.k.f> map2, @NonNull a aVar, @Nullable d.b.h0.l.r.a aVar2) {
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
            d.b.h0.l.k.f fVar = map2.get(aVar.b());
            if (fVar != null) {
                aVar.g(fVar.i);
            } else {
                aVar.g(0L);
            }
        }
        if (pMSAppInfo.csProtocolVersion >= d.b.h0.l.e.a()) {
            aVar.e(pMSAppInfo.appSign);
        } else {
            aVar.e(0L);
        }
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49715a;

        /* renamed from: b  reason: collision with root package name */
        public int f49716b;

        /* renamed from: c  reason: collision with root package name */
        public long f49717c;

        /* renamed from: d  reason: collision with root package name */
        public long f49718d;

        public a(String str) {
            this.f49716b = -1;
            this.f49717c = 0L;
            this.f49718d = 0L;
            this.f49715a = str;
        }

        public long a() {
            return this.f49718d;
        }

        public String b() {
            return this.f49715a;
        }

        public int c() {
            return this.f49716b;
        }

        public long d() {
            return this.f49717c;
        }

        public void e(long j) {
            this.f49718d = j;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.b(), this.f49715a) && aVar.c() == this.f49716b;
            }
            return false;
        }

        public void f(int i) {
            this.f49716b = i;
        }

        public void g(long j) {
            this.f49717c = j;
        }

        public int hashCode() {
            return Objects.hash(this.f49715a, Integer.valueOf(this.f49716b));
        }

        public a(String str, int i) {
            this.f49716b = -1;
            this.f49717c = 0L;
            this.f49718d = 0L;
            this.f49715a = str;
            this.f49716b = i;
        }
    }

    public b(Collection<String> collection, @Nullable d.b.h0.l.r.a aVar) {
        super(-1);
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f49714d = new LinkedHashSet();
        Map<String, PMSAppInfo> s = d.b.h0.l.i.a.h().s();
        Map<String, d.b.h0.l.k.f> o = d.b.h0.l.i.a.h().o();
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                a aVar2 = new a(str);
                g(s, o, aVar2, aVar);
                this.f49714d.add(aVar2);
            }
        }
    }
}
