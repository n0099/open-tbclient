package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.g;
import d.g.c.a.k;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Functions$ConstantFunction<E> implements g<Object, E>, Serializable {
    public static final long serialVersionUID = 0;
    public final E value;

    public Functions$ConstantFunction(E e2) {
        this.value = e2;
    }

    @Override // d.g.c.a.g
    public E apply(Object obj) {
        return this.value;
    }

    @Override // d.g.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$ConstantFunction) {
            return k.a(this.value, ((Functions$ConstantFunction) obj).value);
        }
        return false;
    }

    public int hashCode() {
        E e2 = this.value;
        if (e2 == null) {
            return 0;
        }
        return e2.hashCode();
    }

    public String toString() {
        return "Functions.constant(" + this.value + SmallTailInfo.EMOTION_SUFFIX;
    }
}
