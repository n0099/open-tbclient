package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class b extends kotlin.random.a {
    private final a nPW = new a();

    @h
    /* loaded from: classes7.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: dQP */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.random.a
    public Random dQO() {
        Random random = this.nPW.get();
        q.l((Object) random, "implStorage.get()");
        return random;
    }
}
