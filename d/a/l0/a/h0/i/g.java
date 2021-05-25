package d.a.l0.a.h0.i;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.h0.i.a f42175e;

    /* renamed from: f  reason: collision with root package name */
    public long f42176f;

    /* renamed from: b  reason: collision with root package name */
    public int f42172b = 0;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f42173c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Integer> f42174d = new TreeMap();

    /* renamed from: a  reason: collision with root package name */
    public int f42171a = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void a(@NonNull g gVar);
    }

    public long a() {
        return this.f42176f;
    }

    public String b() {
        d.a.l0.a.h0.i.a aVar = this.f42175e;
        return aVar != null ? aVar.b() : "";
    }

    public d.a.l0.a.h0.i.a c() {
        return this.f42175e;
    }

    public int d() {
        return this.f42171a & 3;
    }

    public String e() {
        int d2 = d();
        return d2 != 0 ? d2 != 1 ? d2 != 2 ? d2 != 3 ? FrsActivityConfig.GOOD : "unknown" : "offline" : "bad" : FrsActivityConfig.GOOD;
    }

    public int f() {
        return this.f42171a & 12;
    }

    public String g() {
        int f2 = f();
        return f2 != 0 ? f2 != 4 ? f2 != 8 ? "unknown" : "slow" : "failRate" : "ok";
    }

    public void h(long j) {
        this.f42176f = j;
    }

    public void i(d.a.l0.a.h0.i.a aVar) {
        this.f42175e = aVar;
    }

    public void j(int i2) {
        this.f42171a = i2 | f();
    }

    public void k(int i2) {
        this.f42171a = i2 | d();
    }
}
