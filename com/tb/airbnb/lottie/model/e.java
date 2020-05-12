package com.tb.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private final List<String> Dj;
    @Nullable
    private f mPl;

    public e(String... strArr) {
        this.Dj = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.Dj = new ArrayList(eVar.Dj);
        this.mPl = eVar.mPl;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e Pl(String str) {
        e eVar = new e(this);
        eVar.Dj.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.mPl = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f dBn() {
        return this.mPl;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i) {
        if (bf(str)) {
            return true;
        }
        if (i >= this.Dj.size()) {
            return false;
        }
        return this.Dj.get(i).equals(str) || this.Dj.get(i).equals("**") || this.Dj.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int h(String str, int i) {
        if (bf(str)) {
            return 0;
        }
        if (this.Dj.get(i).equals("**")) {
            return (i != this.Dj.size() + (-1) && this.Dj.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean i(String str, int i) {
        if (i >= this.Dj.size()) {
            return false;
        }
        boolean z = i == this.Dj.size() + (-1);
        String str2 = this.Dj.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.Dj.size() + (-2) && hI())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.Dj.get(i + 1).equals(str)) {
            return i == this.Dj.size() + (-2) || (i == this.Dj.size() + (-3) && hI());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.Dj.size() - 1) {
                return this.Dj.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.Dj.size() + (-1) || this.Dj.get(i).equals("**");
    }

    private boolean bf(String str) {
        return str.equals("__container");
    }

    private boolean hI() {
        return this.Dj.get(this.Dj.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.Dj + ",resolved=" + (this.mPl != null) + '}';
    }
}
