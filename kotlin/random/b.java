package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class b extends kotlin.random.a {
    private final a nYF = new a();

    @h
    /* loaded from: classes7.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: dUl */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.random.a
    public Random dUk() {
        Random random = this.nYF.get();
        q.l((Object) random, "implStorage.get()");
        return random;
    }
}
