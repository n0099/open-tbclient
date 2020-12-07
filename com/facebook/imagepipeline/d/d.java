package com.facebook.imagepipeline.d;

import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public class d<T> extends a<T> {
    public static <T> com.facebook.datasource.b<T> a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        return new d(ajVar, apVar, cVar);
    }

    private d(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        super(ajVar, apVar, cVar);
    }
}
