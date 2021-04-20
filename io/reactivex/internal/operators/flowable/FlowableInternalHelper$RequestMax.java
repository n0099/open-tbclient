package io.reactivex.internal.operators.flowable;

import f.b.w.g;
import g.d.d;
/* loaded from: classes7.dex */
public enum FlowableInternalHelper$RequestMax implements g<d> {
    INSTANCE;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.b.w.g
    public void accept(d dVar) throws Exception {
        dVar.request(Long.MAX_VALUE);
    }
}
