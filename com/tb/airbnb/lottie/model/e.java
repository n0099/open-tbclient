package com.tb.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes20.dex */
public class e {
    private final List<String> FA;
    @Nullable
    private f pBM;

    public e(String... strArr) {
        this.FA = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.FA = new ArrayList(eVar.FA);
        this.pBM = eVar.pBM;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e ZT(String str) {
        e eVar = new e(this);
        eVar.FA.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.pBM = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f eBg() {
        return this.pBM;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (bo(str)) {
            return true;
        }
        if (i >= this.FA.size()) {
            return false;
        }
        return this.FA.get(i).equals(str) || this.FA.get(i).equals("**") || this.FA.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int i(String str, int i) {
        if (bo(str)) {
            return 0;
        }
        if (this.FA.get(i).equals("**")) {
            return (i != this.FA.size() + (-1) && this.FA.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (i >= this.FA.size()) {
            return false;
        }
        boolean z = i == this.FA.size() + (-1);
        String str2 = this.FA.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.FA.size() + (-2) && jB())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.FA.get(i + 1).equals(str)) {
            return i == this.FA.size() + (-2) || (i == this.FA.size() + (-3) && jB());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.FA.size() - 1) {
                return this.FA.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean k(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.FA.size() + (-1) || this.FA.get(i).equals("**");
    }

    private boolean bo(String str) {
        return str.equals("__container");
    }

    private boolean jB() {
        return this.FA.get(this.FA.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.FA + ",resolved=" + (this.pBM != null) + '}';
    }
}
