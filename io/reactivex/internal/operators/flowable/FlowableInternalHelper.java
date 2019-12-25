package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.b.g;
import org.a.d;
/* loaded from: classes4.dex */
public final class FlowableInternalHelper {

    /* loaded from: classes4.dex */
    public enum RequestMax implements g<d> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.g
        public void accept(d dVar) throws Exception {
            dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
        }
    }
}
