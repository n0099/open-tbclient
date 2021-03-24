package d.a.a.s;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f41343a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public f f41344b;

    public e(String... strArr) {
        this.f41343a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(String str) {
        e eVar = new e(this);
        eVar.f41343a.add(str);
        return eVar;
    }

    public final boolean b() {
        List<String> list = this.f41343a;
        return list.get(list.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.f41343a.size()) {
            return false;
        }
        boolean z = i == this.f41343a.size() - 1;
        String str2 = this.f41343a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.f41343a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f41343a.get(i + 1).equals(str)) {
            return i == this.f41343a.size() + (-2) || (i == this.f41343a.size() + (-3) && b());
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.f41343a.size() - 1) {
                return false;
            }
            return this.f41343a.get(i2).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f d() {
        return this.f41344b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (this.f41343a.get(i).equals("**")) {
            return (i != this.f41343a.size() - 1 && this.f41343a.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean f(String str) {
        return str.equals("__container");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.f41343a.size()) {
            return false;
        }
        return this.f41343a.get(i).equals(str) || this.f41343a.get(i).equals("**") || this.f41343a.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        return str.equals("__container") || i < this.f41343a.size() - 1 || this.f41343a.get(i).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e i(f fVar) {
        e eVar = new e(this);
        eVar.f41344b = fVar;
        return eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f41343a);
        sb.append(",resolved=");
        sb.append(this.f41344b != null);
        sb.append('}');
        return sb.toString();
    }

    public e(e eVar) {
        this.f41343a = new ArrayList(eVar.f41343a);
        this.f41344b = eVar.f41344b;
    }
}
