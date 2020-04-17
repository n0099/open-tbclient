package kotlin.coroutines.intrinsics;

import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.h;
import kotlin.i;
@h
/* loaded from: classes7.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 extends RestrictedContinuationImpl {
    final /* synthetic */ kotlin.jvm.a.b $block;
    final /* synthetic */ kotlin.coroutines.a $completion;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(kotlin.jvm.a.b bVar, kotlin.coroutines.a aVar, kotlin.coroutines.a aVar2) {
        super(aVar2);
        this.$block = bVar;
        this.$completion = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected Object invokeSuspend(Object obj) {
        switch (this.label) {
            case 0:
                this.label = 1;
                i.bz(obj);
                return this.$block.invoke(this);
            case 1:
                this.label = 2;
                i.bz(obj);
                return obj;
            default:
                throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
