package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.g;
import d.g.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$FunctionComposition<A, B, C> implements g<A, C>, Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    public final g<A, ? extends B> f31619f;

    /* renamed from: g  reason: collision with root package name */
    public final g<B, C> f31620g;

    public Functions$FunctionComposition(g<B, C> gVar, g<A, ? extends B> gVar2) {
        n.p(gVar);
        this.f31620g = gVar;
        n.p(gVar2);
        this.f31619f = gVar2;
    }

    @Override // d.g.c.a.g
    public C apply(A a2) {
        return this.f31620g.apply(this.f31619f.apply(a2));
    }

    @Override // d.g.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionComposition) {
            Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
            return this.f31619f.equals(functions$FunctionComposition.f31619f) && this.f31620g.equals(functions$FunctionComposition.f31620g);
        }
        return false;
    }

    public int hashCode() {
        return this.f31619f.hashCode() ^ this.f31620g.hashCode();
    }

    public String toString() {
        return this.f31620g + "(" + this.f31619f + SmallTailInfo.EMOTION_SUFFIX;
    }
}
