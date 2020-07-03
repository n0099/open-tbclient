package kotlin.coroutines.intrinsics;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.h;
import kotlin.i;
@h
/* loaded from: classes7.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 extends ContinuationImpl {
    final /* synthetic */ kotlin.jvm.a.b $block;
    final /* synthetic */ kotlin.coroutines.a $completion;
    final /* synthetic */ kotlin.coroutines.c $context;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(kotlin.jvm.a.b bVar, kotlin.coroutines.a aVar, kotlin.coroutines.c cVar, kotlin.coroutines.a aVar2, kotlin.coroutines.c cVar2) {
        super(aVar2, cVar2);
        this.$block = bVar;
        this.$completion = aVar;
        this.$context = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected Object invokeSuspend(Object obj) {
        switch (this.label) {
            case 0:
                this.label = 1;
                i.bH(obj);
                return this.$block.invoke(this);
            case 1:
                this.label = 2;
                i.bH(obj);
                return obj;
            default:
                throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
