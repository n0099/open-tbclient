package io.reactivex.internal.operators.flowable;

import f.a.w.g;
import g.d.d;
/* loaded from: classes7.dex */
public enum FlowableInternalHelper$RequestMax implements g<d> {
    INSTANCE;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.g
    public void accept(d dVar) throws Exception {
        dVar.request(Long.MAX_VALUE);
    }
}
