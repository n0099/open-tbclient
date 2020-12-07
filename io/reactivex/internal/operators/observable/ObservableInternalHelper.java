package io.reactivex.internal.operators.observable;

import io.reactivex.b.h;
import io.reactivex.b.j;
import io.reactivex.p;
/* loaded from: classes9.dex */
public final class ObservableInternalHelper {

    /* loaded from: classes9.dex */
    enum MapToInt implements h<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.b.h
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* loaded from: classes9.dex */
    enum ErrorMapperFilter implements h<p<Object>, Throwable>, j<p<Object>> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        public Throwable apply(p<Object> pVar) throws Exception {
            return pVar.eCT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.j
        public boolean test(p<Object> pVar) throws Exception {
            return pVar.eCS();
        }
    }
}
