package kotlin.coroutines.intrinsics;

import kotlin.TypeCastException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.h;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.w;
@h
/* loaded from: classes20.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 extends ContinuationImpl {
    final /* synthetic */ kotlin.coroutines.a $completion;
    final /* synthetic */ kotlin.coroutines.c $context;
    final /* synthetic */ Object $receiver$inlined;
    final /* synthetic */ m $this_createCoroutineUnintercepted$inlined;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(kotlin.coroutines.a aVar, kotlin.coroutines.c cVar, kotlin.coroutines.a aVar2, kotlin.coroutines.c cVar2, m mVar, Object obj) {
        super(aVar2, cVar2);
        this.$completion = aVar;
        this.$context = cVar;
        this.$this_createCoroutineUnintercepted$inlined = mVar;
        this.$receiver$inlined = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected Object invokeSuspend(Object obj) {
        switch (this.label) {
            case 0:
                this.label = 1;
                i.bJ(obj);
                IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 intrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 = this;
                m mVar = this.$this_createCoroutineUnintercepted$inlined;
                if (mVar == null) {
                    throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
                return ((m) w.k(mVar, 2)).invoke(this.$receiver$inlined, intrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4);
            case 1:
                this.label = 2;
                i.bJ(obj);
                return obj;
            default:
                throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
