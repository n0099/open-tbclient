package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.g;
import d.g.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$FunctionComposition<A, B, C> implements g<A, C>, Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    public final g<A, ? extends B> f30884f;

    /* renamed from: g  reason: collision with root package name */
    public final g<B, C> f30885g;

    public Functions$FunctionComposition(g<B, C> gVar, g<A, ? extends B> gVar2) {
        n.p(gVar);
        this.f30885g = gVar;
        n.p(gVar2);
        this.f30884f = gVar2;
    }

    @Override // d.g.c.a.g
    public C apply(A a2) {
        return this.f30885g.apply(this.f30884f.apply(a2));
    }

    @Override // d.g.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionComposition) {
            Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
            return this.f30884f.equals(functions$FunctionComposition.f30884f) && this.f30885g.equals(functions$FunctionComposition.f30885g);
        }
        return false;
    }

    public int hashCode() {
        return this.f30884f.hashCode() ^ this.f30885g.hashCode();
    }

    public String toString() {
        return this.f30885g + "(" + this.f30884f + SmallTailInfo.EMOTION_SUFFIX;
    }
}
