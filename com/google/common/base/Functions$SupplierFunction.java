package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.n;
import d.h.c.a.r;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$SupplierFunction<T> implements g<Object, T>, Serializable {
    public static final long serialVersionUID = 0;
    public final r<T> supplier;

    @Override // d.h.c.a.g
    public T apply(Object obj) {
        return this.supplier.get();
    }

    @Override // d.h.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$SupplierFunction) {
            return this.supplier.equals(((Functions$SupplierFunction) obj).supplier);
        }
        return false;
    }

    public int hashCode() {
        return this.supplier.hashCode();
    }

    public String toString() {
        return "Functions.forSupplier(" + this.supplier + SmallTailInfo.EMOTION_SUFFIX;
    }

    public Functions$SupplierFunction(r<T> rVar) {
        n.p(rVar);
        this.supplier = rVar;
    }
}
