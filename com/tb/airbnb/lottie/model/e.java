package com.tb.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private final List<String> hD;
    @Nullable
    private f nsz;

    public e(String... strArr) {
        this.hD = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.hD = new ArrayList(eVar.hD);
        this.nsz = eVar.nsz;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e Rx(String str) {
        e eVar = new e(this);
        eVar.hD.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.nsz = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f dHo() {
        return this.nsz;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (P(str)) {
            return true;
        }
        if (i >= this.hD.size()) {
            return false;
        }
        return this.hD.get(i).equals(str) || this.hD.get(i).equals("**") || this.hD.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int d(String str, int i) {
        if (P(str)) {
            return 0;
        }
        if (this.hD.get(i).equals("**")) {
            return (i != this.hD.size() + (-1) && this.hD.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e(String str, int i) {
        if (i >= this.hD.size()) {
            return false;
        }
        boolean z = i == this.hD.size() + (-1);
        String str2 = this.hD.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.hD.size() + (-2) && cl())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.hD.get(i + 1).equals(str)) {
            return i == this.hD.size() + (-2) || (i == this.hD.size() + (-3) && cl());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.hD.size() - 1) {
                return this.hD.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean f(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.hD.size() + (-1) || this.hD.get(i).equals("**");
    }

    private boolean P(String str) {
        return str.equals("__container");
    }

    private boolean cl() {
        return this.hD.get(this.hD.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.hD + ",resolved=" + (this.nsz != null) + '}';
    }
}
