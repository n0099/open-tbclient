package io.reactivex.internal.operators.flowable;
/* loaded from: classes7.dex */
public final class FlowableInternalHelper {

    /* loaded from: classes7.dex */
    public enum RequestMax implements io.reactivex.c.g<org.b.d> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(org.b.d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
