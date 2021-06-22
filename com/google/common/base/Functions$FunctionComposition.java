package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.g;
import d.g.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$FunctionComposition<A, B, C> implements g<A, C>, Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    public final g<A, ? extends B> f30982f;

    /* renamed from: g  reason: collision with root package name */
    public final g<B, C> f30983g;

    public Functions$FunctionComposition(g<B, C> gVar, g<A, ? extends B> gVar2) {
        n.p(gVar);
        this.f30983g = gVar;
        n.p(gVar2);
        this.f30982f = gVar2;
    }

    @Override // d.g.c.a.g
    public C apply(A a2) {
        return this.f30983g.apply(this.f30982f.apply(a2));
    }

    @Override // d.g.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionComposition) {
            Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
            return this.f30982f.equals(functions$FunctionComposition.f30982f) && this.f30983g.equals(functions$FunctionComposition.f30983g);
        }
        return false;
    }

    public int hashCode() {
        return this.f30982f.hashCode() ^ this.f30983g.hashCode();
    }

    public String toString() {
        return this.f30983g + "(" + this.f30982f + SmallTailInfo.EMOTION_SUFFIX;
    }
}
