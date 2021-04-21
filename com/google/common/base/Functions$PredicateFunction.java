package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.n;
import d.h.c.a.o;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$PredicateFunction<T> implements g<T, Boolean>, Serializable {
    public static final long serialVersionUID = 0;
    public final o<T> predicate;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.a.g
    public /* bridge */ /* synthetic */ Boolean apply(Object obj) {
        return apply((Functions$PredicateFunction<T>) obj);
    }

    @Override // d.h.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$PredicateFunction) {
            return this.predicate.equals(((Functions$PredicateFunction) obj).predicate);
        }
        return false;
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        return "Functions.forPredicate(" + this.predicate + SmallTailInfo.EMOTION_SUFFIX;
    }

    public Functions$PredicateFunction(o<T> oVar) {
        n.p(oVar);
        this.predicate = oVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.h.c.a.g
    public Boolean apply(T t) {
        return Boolean.valueOf(this.predicate.apply(t));
    }
}
