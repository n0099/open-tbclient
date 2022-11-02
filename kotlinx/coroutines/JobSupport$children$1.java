package kotlinx.coroutines;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {949, 951}, m = "invokeSuspend", n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes8.dex */
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public SequenceScope p$;
    public final /* synthetic */ JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, Continuation continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.p$ = (SequenceScope) obj;
        return jobSupport$children$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super ChildJob> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:29:0x009b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:29:0x009b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        LockFreeLinkedListNode list;
        SequenceScope sequenceScope;
        Object obj2;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        JobSupport$children$1 jobSupport$children$1;
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ChildHandleNode childHandleNode = (ChildHandleNode) this.L$5;
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) this.L$4;
                    list = (LockFreeLinkedListHead) this.L$3;
                    lockFreeLinkedListNode2 = (NodeList) this.L$2;
                    obj2 = this.L$1;
                    sequenceScope = (SequenceScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    jobSupport$children$1 = this;
                    lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                    if (!Intrinsics.areEqual(lockFreeLinkedListNode, list)) {
                        if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                            ChildHandleNode childHandleNode2 = (ChildHandleNode) lockFreeLinkedListNode;
                            ChildJob childJob = childHandleNode2.childJob;
                            jobSupport$children$1.L$0 = sequenceScope;
                            jobSupport$children$1.L$1 = obj2;
                            jobSupport$children$1.L$2 = lockFreeLinkedListNode2;
                            jobSupport$children$1.L$3 = list;
                            jobSupport$children$1.L$4 = lockFreeLinkedListNode;
                            jobSupport$children$1.L$5 = childHandleNode2;
                            jobSupport$children$1.label = 2;
                            if (sequenceScope.yield(childJob, jobSupport$children$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                        if (!Intrinsics.areEqual(lockFreeLinkedListNode, list)) {
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope3 = this.p$;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                ChildJob childJob2 = ((ChildHandleNode) state$kotlinx_coroutines_core).childJob;
                this.L$0 = sequenceScope3;
                this.L$1 = state$kotlinx_coroutines_core;
                this.label = 1;
                if (sequenceScope3.yield(childJob2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                Object next = list.getNext();
                if (next != null) {
                    sequenceScope = sequenceScope3;
                    obj2 = state$kotlinx_coroutines_core;
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                    jobSupport$children$1 = this;
                    lockFreeLinkedListNode2 = list;
                    if (!Intrinsics.areEqual(lockFreeLinkedListNode, list)) {
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
            }
        }
        return Unit.INSTANCE;
    }
}
