package com.facebook.imagepipeline.e;

import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.an;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class d<T> extends a<T> {
    public static <T> com.facebook.datasource.b<T> a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        return new d(aiVar, anVar, bVar);
    }

    private d(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        super(aiVar, anVar, bVar);
    }
}
