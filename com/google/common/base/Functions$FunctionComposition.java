package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.g;
import d.g.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$FunctionComposition<A, B, C> implements g<A, C>, Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    public final g<A, ? extends B> f30793f;

    /* renamed from: g  reason: collision with root package name */
    public final g<B, C> f30794g;

    public Functions$FunctionComposition(g<B, C> gVar, g<A, ? extends B> gVar2) {
        n.p(gVar);
        this.f30794g = gVar;
        n.p(gVar2);
        this.f30793f = gVar2;
    }

    @Override // d.g.c.a.g
    public C apply(A a2) {
        return this.f30794g.apply(this.f30793f.apply(a2));
    }

    @Override // d.g.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionComposition) {
            Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
            return this.f30793f.equals(functions$FunctionComposition.f30793f) && this.f30794g.equals(functions$FunctionComposition.f30794g);
        }
        return false;
    }

    public int hashCode() {
        return this.f30793f.hashCode() ^ this.f30794g.hashCode();
    }

    public String toString() {
        return this.f30794g + "(" + this.f30793f + SmallTailInfo.EMOTION_SUFFIX;
    }
}
