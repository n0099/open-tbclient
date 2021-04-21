package d.a.a.u;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static final d f41737c = new d("COMPOSITION");

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f41738a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public e f41739b;

    public d(String... strArr) {
        this.f41738a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d a(String str) {
        d dVar = new d(this);
        dVar.f41738a.add(str);
        return dVar;
    }

    public final boolean b() {
        List<String> list = this.f41738a;
        return list.get(list.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.f41738a.size()) {
            return false;
        }
        boolean z = i == this.f41738a.size() - 1;
        String str2 = this.f41738a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.f41738a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f41738a.get(i + 1).equals(str)) {
            return i == this.f41738a.size() + (-2) || (i == this.f41738a.size() + (-3) && b());
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.f41738a.size() - 1) {
                return false;
            }
            return this.f41738a.get(i2).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e d() {
        return this.f41739b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (this.f41738a.get(i).equals("**")) {
            return (i != this.f41738a.size() - 1 && this.f41738a.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.f41738a.size()) {
            return false;
        }
        return this.f41738a.get(i).equals(str) || this.f41738a.get(i).equals("**") || this.f41738a.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        return "__container".equals(str) || i < this.f41738a.size() - 1 || this.f41738a.get(i).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d i(e eVar) {
        d dVar = new d(this);
        dVar.f41739b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f41738a);
        sb.append(",resolved=");
        sb.append(this.f41739b != null);
        sb.append('}');
        return sb.toString();
    }

    public d(d dVar) {
        this.f41738a = new ArrayList(dVar.f41738a);
        this.f41739b = dVar.f41739b;
    }
}
