package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$FunctionComposition<A, B, C> implements g<A, C>, Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    public final g<A, ? extends B> f30682f;

    /* renamed from: g  reason: collision with root package name */
    public final g<B, C> f30683g;

    public Functions$FunctionComposition(g<B, C> gVar, g<A, ? extends B> gVar2) {
        n.p(gVar);
        this.f30683g = gVar;
        n.p(gVar2);
        this.f30682f = gVar2;
    }

    @Override // d.h.c.a.g
    public C apply(A a2) {
        return this.f30683g.apply(this.f30682f.apply(a2));
    }

    @Override // d.h.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionComposition) {
            Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
            return this.f30682f.equals(functions$FunctionComposition.f30682f) && this.f30683g.equals(functions$FunctionComposition.f30683g);
        }
        return false;
    }

    public int hashCode() {
        return this.f30682f.hashCode() ^ this.f30683g.hashCode();
    }

    public String toString() {
        return this.f30683g + "(" + this.f30682f + SmallTailInfo.EMOTION_SUFFIX;
    }
}
