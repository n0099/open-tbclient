package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class b extends kotlin.random.a {
    private final a oRT = new a();

    @h
    /* loaded from: classes10.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: eoh */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.random.a
    public Random eog() {
        Random random = this.oRT.get();
        q.m(random, "implStorage.get()");
        return random;
    }
}
