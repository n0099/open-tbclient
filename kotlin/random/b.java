package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class b extends kotlin.random.a {
    private final a nBL = new a();

    /* loaded from: classes5.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: dJp */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.random.a
    public Random dJo() {
        Random random = this.nBL.get();
        q.i(random, "implStorage.get()");
        return random;
    }
}
