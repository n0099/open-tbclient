package kotlin;

import com.baidu.titan.sdk.common.TitanConstant;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\b\u001a/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"T", "Lkotlin/Function0;", "initializer", "Lkotlin/Lazy;", TitanConstant.KEY_LAZY_INIT_CLASS, "(Lkotlin/Function0;)Lkotlin/Lazy;", "", "lock", "(Ljava/lang/Object;Lkotlin/Function0;)Lkotlin/Lazy;", "Lkotlin/LazyThreadSafetyMode;", "mode", "(Lkotlin/LazyThreadSafetyMode;Lkotlin/Function0;)Lkotlin/Lazy;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/LazyKt")
/* loaded from: classes9.dex */
public class LazyKt__LazyJVMKt {
    public static final <T> Lazy<T> lazy(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode mode, Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        int i2 = LazyKt.WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(initializer);
        }
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }

    public static final <T> Lazy<T> lazy(Object obj, Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, obj);
    }
}
