package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.c.j;
import io.reactivex.p;
/* loaded from: classes7.dex */
public final class ObservableInternalHelper {

    /* loaded from: classes7.dex */
    enum MapToInt implements h<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.c.h
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* loaded from: classes7.dex */
    enum ErrorMapperFilter implements h<p<Object>, Throwable>, j<p<Object>> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        public Throwable apply(p<Object> pVar) throws Exception {
            return pVar.dCE();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.j
        public boolean test(p<Object> pVar) throws Exception {
            return pVar.dCD();
        }
    }
}
