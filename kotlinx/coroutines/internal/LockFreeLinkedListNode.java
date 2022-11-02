package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\r\b\u0017\u0018\u0000:\u0005JKLMNB\u0007¢\u0006\u0004\bI\u0010&J\u0019\u0010\u0004\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\t\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\nJ4\u0010\r\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\b¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u000f\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00070\u000b2\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0018\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0082\u0010¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\f\b\u0000\u0010\u001a*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J \u0010\"\u001a\u00060\u0000j\u0002`\u00012\n\u0010!\u001a\u00060\u0000j\u0002`\u0001H\u0082\u0010¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00032\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0001H\u0002¢\u0006\u0004\b$\u0010\u0005J\r\u0010%\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0001¢\u0006\u0004\b'\u0010&J,\u0010)\u001a\u00020(2\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0081\b¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0014¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010.J.\u0010/\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001a\u0018\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\b¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b1\u0010,J\u0017\u00102\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0001¢\u0006\u0004\b2\u0010,J\u000f\u00104\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J/\u0010;\u001a\u00020:2\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00012\u0006\u00109\u001a\u00020(H\u0001¢\u0006\u0004\b;\u0010<J'\u0010@\u001a\u00020\u00032\n\u0010=\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010.R\u0013\u0010\u0011\u001a\u00020B8F@\u0006¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0017\u0010F\u001a\u00060\u0000j\u0002`\u00018F@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010,R\u0017\u0010H\u001a\u00060\u0000j\u0002`\u00018F@\u0006¢\u0006\u0006\u001a\u0004\bG\u0010,¨\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", ProgressInfo.JSON_KEY_CURRENT, "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "()V", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "<init>", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public class LockFreeLinkedListNode {
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b \u0010\tJ'\u0010\b\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0006\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u000e2\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00028\u00008\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u001f\u001a\u00060\u0001j\u0002`\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c¨\u0006!"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", ExifInterface.GPS_DIRECTION_TRUE, "kotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc", "affected", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "", HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "queue", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        public static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        public volatile Object _affectedNode;
        @JvmField
        public final T node;
        @JvmField
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(LockFreeLinkedListNode lockFreeLinkedListNode, T t) {
            boolean z;
            this.queue = lockFreeLinkedListNode;
            this.node = t;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                Object obj = this.node._next;
                T t2 = this.node;
                if (obj == t2 && ((LockFreeLinkedListNode) t2._prev) == this.node) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            this._affectedNode = null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            this.node.finishAdd(this.queue);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            if (obj != this.queue) {
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            T t = this.node;
            LockFreeLinkedListNode._prev$FU.compareAndSet(t, t, lockFreeLinkedListNode);
            T t2 = this.node;
            LockFreeLinkedListNode._next$FU.compareAndSet(t2, t2, this.queue);
            return this.node;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(PrepareOp prepareOp) {
            _affectedNode$FU.compareAndSet(this, null, prepareOp.affected);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            return this.queue.correctPrev(opDescriptor);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b!\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", SmsLoginView.f.l, "", TaskProcessData.keyComplete, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "newNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "oldNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    @PublishedApi
    /* loaded from: classes8.dex */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        @JvmField
        public final LockFreeLinkedListNode newNode;
        @JvmField
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                lockFreeLinkedListNode2 = this.newNode;
            } else {
                lockFreeLinkedListNode2 = this.oldNext;
            }
            if (lockFreeLinkedListNode2 != null && LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.oldNext;
                if (lockFreeLinkedListNode4 == null) {
                    Intrinsics.throwNpe();
                }
                lockFreeLinkedListNode3.finishAdd(lockFreeLinkedListNode4);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0006\u001a\u00060\fj\u0002`\r\u0012\n\u0010\u0016\u001a\u00060\fj\u0002`\r\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00060\fj\u0002`\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u001a\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00060\fj\u0002`\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "finishPrepare", "()V", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class PrepareOp extends OpDescriptor {
        @JvmField
        public final LockFreeLinkedListNode affected;
        @JvmField
        public final AbstractAtomicDesc desc;
        @JvmField
        public final LockFreeLinkedListNode next;

        public PrepareOp(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, AbstractAtomicDesc abstractAtomicDesc) {
            this.affected = lockFreeLinkedListNode;
            this.next = lockFreeLinkedListNode2;
            this.desc = abstractAtomicDesc;
        }

        public final void finishPrepare() {
            this.desc.finishPrepare(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> getAtomicOp() {
            return this.desc.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "PrepareOp(op=" + getAtomicOp() + ')';
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object obj) {
            Object atomicOp;
            boolean z;
            boolean z2 = true;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (obj == this.affected) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object onPrepare = this.desc.onPrepare(this);
                if (onPrepare == LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.next;
                    if (LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2.removed())) {
                        lockFreeLinkedListNode2.correctPrev(null);
                    }
                    return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
                }
                if (onPrepare != null) {
                    getAtomicOp().decide(onPrepare);
                } else {
                    z2 = getAtomicOp().isDecided();
                }
                if (z2) {
                    atomicOp = this.next;
                } else {
                    atomicOp = getAtomicOp();
                }
                LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, atomicOp);
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u001f\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\u00112\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001f\u001a\u00060\u0003j\u0002`\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0019\u0010%\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", ExifInterface.GPS_DIRECTION_TRUE, "kotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", SmsLoginView.f.l, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "result$annotations", "()V", TiebaStatic.LogFields.RESULT, "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        public static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        public static final AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        public volatile Object _affectedNode = null;
        public volatile Object _originalNext = null;
        @JvmField
        public final LockFreeLinkedListNode queue;

        public static /* synthetic */ void result$annotations() {
        }

        public RemoveFirstDesc(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.queue = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(PrepareOp prepareOp) {
            _affectedNode$FU.compareAndSet(this, null, prepareOp.affected);
            _originalNext$FU.compareAndSet(this, null, prepareOp.next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor2 = (OpDescriptor) obj;
                    if (opDescriptor.isEarlierThan(opDescriptor2)) {
                        return null;
                    }
                    opDescriptor2.perform(this.queue);
                } else if (obj != null) {
                    return (LockFreeLinkedListNode) obj;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            lockFreeLinkedListNode2.correctPrev(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            if (!(obj instanceof Removed)) {
                return false;
            }
            ((Removed) obj).ref.helpRemovePrev();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            return lockFreeLinkedListNode2.removed();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        public final T getResult() {
            T t = (T) getAffectedNode();
            if (t == null) {
                Intrinsics.throwNpe();
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed == null) {
            Removed removed2 = new Removed(this);
            _removedRef$FU.lazySet(this, removed2);
            return removed2;
        }
        return removed;
    }

    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode correctPrev = correctPrev(null);
        if (correctPrev == null) {
            return findPrevNonRemoved((LockFreeLinkedListNode) this._prev);
        }
        return correctPrev;
    }

    public final void helpRemove() {
        Object next = getNext();
        if (next != null) {
            ((Removed) next).ref.correctPrev(null);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
    }

    @PublishedApi
    public final void helpRemovePrev() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object next = lockFreeLinkedListNode.getNext();
            if (!(next instanceof Removed)) {
                lockFreeLinkedListNode.correctPrev(null);
                return;
            }
            lockFreeLinkedListNode = ((Removed) next).ref;
        }
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public LockFreeLinkedListNode nextIfRemoved() {
        Object next = getNext();
        if (!(next instanceof Removed)) {
            next = null;
        }
        Removed removed = (Removed) next;
        if (removed == null) {
            return null;
        }
        return removed.ref;
    }

    public boolean remove() {
        if (removeOrNext() == null) {
            return true;
        }
        return false;
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                if (lockFreeLinkedListNode.remove()) {
                    return lockFreeLinkedListNode;
                }
                lockFreeLinkedListNode.helpRemove();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    @PublishedApi
    public final LockFreeLinkedListNode removeOrNext() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if (next instanceof Removed) {
                return ((Removed) next).ref;
            }
            if (next == this) {
                return (LockFreeLinkedListNode) next;
            }
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!_next$FU.compareAndSet(this, next, lockFreeLinkedListNode.removed()));
        lockFreeLinkedListNode.correctPrev(null);
        return null;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J#\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0014¢\u0006\u0004\b\u0005\u0010\fJ'\u0010\u000e\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\n\u0010\r\u001a\u00060\tj\u0002`\nH$¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0006\u0010\u0003\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\n\u0010\r\u001a\u00060\tj\u0002`\nH$¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!¨\u0006'"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "", SmsLoginView.f.l, "", TaskProcessData.keyComplete, "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "onPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "prepare", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "", HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode) {
            return null;
        }

        public abstract void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        public abstract void finishPrepare(PrepareOp prepareOp);

        public abstract LockFreeLinkedListNode getAffectedNode();

        public abstract LockFreeLinkedListNode getOriginalNext();

        public boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            return false;
        }

        public abstract Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(AtomicOp<?> atomicOp, Object obj) {
            boolean z;
            Object obj2;
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode != null) {
                LockFreeLinkedListNode originalNext = getOriginalNext();
                if (originalNext != null) {
                    if (z) {
                        obj2 = updatedNext(affectedNode, originalNext);
                    } else {
                        obj2 = originalNext;
                    }
                    if (LockFreeLinkedListNode._next$FU.compareAndSet(affectedNode, atomicOp, obj2) && z) {
                        finishOnSuccess(affectedNode, originalNext);
                    }
                } else if (DebugKt.getASSERTIONS_ENABLED() && !(!z)) {
                    throw new AssertionError();
                }
            } else if (DebugKt.getASSERTIONS_ENABLED() && !(!z)) {
                throw new AssertionError();
            }
        }

        public Object onPrepare(PrepareOp prepareOp) {
            finishPrepare(prepareOp);
            return null;
        }

        public LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null) {
                Intrinsics.throwNpe();
            }
            return affectedNode;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
            if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
            if (r4 != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x005a, code lost:
            if (r7 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
            return null;
         */
        @Override // kotlinx.coroutines.internal.AtomicDesc
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object prepare(AtomicOp<?> atomicOp) {
            while (true) {
                LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(atomicOp);
                if (takeAffectedNode != null) {
                    Object obj = takeAffectedNode._next;
                    if (obj == atomicOp || atomicOp.isDecided()) {
                        return null;
                    }
                    if (obj instanceof OpDescriptor) {
                        OpDescriptor opDescriptor = (OpDescriptor) obj;
                        if (atomicOp.isEarlierThan(opDescriptor)) {
                            return AtomicKt.RETRY_ATOMIC;
                        }
                        opDescriptor.perform(takeAffectedNode);
                    } else {
                        Object failure = failure(takeAffectedNode);
                        if (failure != null) {
                            return failure;
                        }
                        if (retry(takeAffectedNode, obj)) {
                            continue;
                        } else if (obj != null) {
                            PrepareOp prepareOp = new PrepareOp(takeAffectedNode, (LockFreeLinkedListNode) obj, this);
                            if (LockFreeLinkedListNode._next$FU.compareAndSet(takeAffectedNode, obj, prepareOp)) {
                                try {
                                    Object perform = prepareOp.perform(takeAffectedNode);
                                    if (perform != LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                                        break;
                                    }
                                } catch (Throwable th) {
                                    LockFreeLinkedListNode._next$FU.compareAndSet(takeAffectedNode, prepareOp, obj);
                                    throw th;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                    }
                } else {
                    return AtomicKt.RETRY_ATOMIC;
                }
            }
        }
    }

    public final boolean addLastIf(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> function0) {
        int tryCondAddNext;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            tryCondAddNext = getPrevNode().tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode lockFreeLinkedListNode, Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        LockFreeLinkedListNode prevNode;
        do {
            prevNode = getPrevNode();
            if (!function1.invoke(prevNode).booleanValue()) {
                return false;
            }
        } while (!prevNode.addNext(lockFreeLinkedListNode, this));
        return true;
    }

    @PublishedApi
    public final boolean addNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!_next$FU.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.finishAdd(lockFreeLinkedListNode2);
        return true;
    }

    @PublishedApi
    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> function0) {
        return new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
    }

    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        boolean z;
        boolean z2 = true;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (lockFreeLinkedListNode == ((LockFreeLinkedListNode) this._prev)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (lockFreeLinkedListNode2 != this._next) {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
        }
        return lockFreeLinkedListNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
            if (getNext() != lockFreeLinkedListNode) {
                return;
            }
        } while (!_prev$FU.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (isRemoved()) {
            lockFreeLinkedListNode.correctPrev(null);
        }
    }

    public final void addLast(LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!getPrevNode().addNext(lockFreeLinkedListNode, this));
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode lockFreeLinkedListNode) {
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, this);
        while (getNext() == this) {
            if (_next$FU.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(T t) {
        return new AddLastDesc<>(this, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (kotlinx.coroutines.internal.LockFreeLinkedListNode._next$FU.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.Removed) r4).ref) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LockFreeLinkedListNode correctPrev(OpDescriptor opDescriptor) {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) this._prev;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    Object obj = lockFreeLinkedListNode2._next;
                    if (obj == this) {
                        if (lockFreeLinkedListNode == lockFreeLinkedListNode2) {
                            return lockFreeLinkedListNode2;
                        }
                        if (_prev$FU.compareAndSet(this, lockFreeLinkedListNode, lockFreeLinkedListNode2)) {
                            return lockFreeLinkedListNode2;
                        }
                    } else if (isRemoved()) {
                        return null;
                    } else {
                        if (obj == opDescriptor) {
                            return lockFreeLinkedListNode2;
                        }
                        if (obj instanceof OpDescriptor) {
                            if (opDescriptor != null && opDescriptor.isEarlierThan((OpDescriptor) obj)) {
                                return null;
                            }
                            ((OpDescriptor) obj).perform(lockFreeLinkedListNode2);
                        } else if (obj instanceof Removed) {
                            if (lockFreeLinkedListNode3 != null) {
                                break;
                            }
                            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode2._prev;
                        } else if (obj != null) {
                            lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                    }
                }
                lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
            }
        }
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode lockFreeLinkedListNode, Function1<? super LockFreeLinkedListNode, Boolean> function1, Function0<Boolean> function0) {
        int tryCondAddNext;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            LockFreeLinkedListNode prevNode = getPrevNode();
            if (!function1.invoke(prevNode).booleanValue()) {
                return false;
            }
            tryCondAddNext = prevNode.tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    @PublishedApi
    public final int tryCondAddNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.oldNext = lockFreeLinkedListNode2;
        if (!_next$FU.compareAndSet(this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        if (condAddOp.perform(this) == null) {
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public final /* synthetic */ <T> T removeFirstIfIsInstanceOfOrPeekIf(Function1<? super T, Boolean> function1) {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (!(lockFreeLinkedListNode instanceof Object)) {
                    return null;
                }
                if (function1.invoke(lockFreeLinkedListNode).booleanValue() && !lockFreeLinkedListNode.isRemoved()) {
                    return lockFreeLinkedListNode;
                }
                LockFreeLinkedListNode removeOrNext = lockFreeLinkedListNode.removeOrNext();
                if (removeOrNext == null) {
                    return lockFreeLinkedListNode;
                }
                removeOrNext.helpRemovePrev();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }
}
