package io.reactivex.internal.operators.single;

import f.b.s;
import f.b.w.h;
import g.d.b;
/* loaded from: classes7.dex */
public enum SingleInternalHelper$ToFlowable implements h<s, b> {
    INSTANCE;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.b.w.h
    public b apply(s sVar) {
        return new SingleToFlowable(sVar);
    }
}
