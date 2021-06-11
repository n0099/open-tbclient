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
    public d.a.l0.a.h0.i.a f45851e;

    /* renamed from: f  reason: collision with root package name */
    public long f45852f;

    /* renamed from: b  reason: collision with root package name */
    public int f45848b = 0;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f45849c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Integer> f45850d = new TreeMap();

    /* renamed from: a  reason: collision with root package name */
    public int f45847a = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void a(@NonNull g gVar);
    }

    public long a() {
        return this.f45852f;
    }

    public String b() {
        d.a.l0.a.h0.i.a aVar = this.f45851e;
        return aVar != null ? aVar.b() : "";
    }

    public d.a.l0.a.h0.i.a c() {
        return this.f45851e;
    }

    public int d() {
        return this.f45847a & 3;
    }

    public String e() {
        int d2 = d();
        return d2 != 0 ? d2 != 1 ? d2 != 2 ? d2 != 3 ? FrsActivityConfig.GOOD : "unknown" : "offline" : "bad" : FrsActivityConfig.GOOD;
    }

    public int f() {
        return this.f45847a & 12;
    }

    public String g() {
        int f2 = f();
        return f2 != 0 ? f2 != 4 ? f2 != 8 ? "unknown" : "slow" : "failRate" : "ok";
    }

    public void h(long j) {
        this.f45852f = j;
    }

    public void i(d.a.l0.a.h0.i.a aVar) {
        this.f45851e = aVar;
    }

    public void j(int i2) {
        this.f45847a = i2 | f();
    }

    public void k(int i2) {
        this.f45847a = i2 | d();
    }
}
