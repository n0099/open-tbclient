package com.tb.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private final List<String> DM;
    @Nullable
    private f nGp;

    public e(String... strArr) {
        this.DM = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.DM = new ArrayList(eVar.DM);
        this.nGp = eVar.nGp;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e RO(String str) {
        e eVar = new e(this);
        eVar.DM.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.nGp = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f dNA() {
        return this.nGp;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i) {
        if (bg(str)) {
            return true;
        }
        if (i >= this.DM.size()) {
            return false;
        }
        return this.DM.get(i).equals(str) || this.DM.get(i).equals("**") || this.DM.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int h(String str, int i) {
        if (bg(str)) {
            return 0;
        }
        if (this.DM.get(i).equals("**")) {
            return (i != this.DM.size() + (-1) && this.DM.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean i(String str, int i) {
        if (i >= this.DM.size()) {
            return false;
        }
        boolean z = i == this.DM.size() + (-1);
        String str2 = this.DM.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.DM.size() + (-2) && hY())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.DM.get(i + 1).equals(str)) {
            return i == this.DM.size() + (-2) || (i == this.DM.size() + (-3) && hY());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.DM.size() - 1) {
                return this.DM.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.DM.size() + (-1) || this.DM.get(i).equals("**");
    }

    private boolean bg(String str) {
        return str.equals("__container");
    }

    private boolean hY() {
        return this.DM.get(this.DM.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.DM + ",resolved=" + (this.nGp != null) + '}';
    }
}
