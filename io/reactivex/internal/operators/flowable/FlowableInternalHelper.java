package io.reactivex.internal.operators.flowable;
/* loaded from: classes25.dex */
public final class FlowableInternalHelper {

    /* loaded from: classes25.dex */
    public enum RequestMax implements io.reactivex.c.g<org.a.d> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(org.a.d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
