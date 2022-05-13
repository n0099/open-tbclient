package kotlinx.coroutines.internal;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080@\u0018\u0000*\u0004\b\u0000\u0010\u0001B\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\u0086\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", "E", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Function1;", "", "action", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachReversed", "", TTDownloadField.TT_HASHCODE, "()I", "element", "plus-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "plus", "", "toString", "()Ljava/lang/String;", "holder", "Ljava/lang/Object;", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class InlineList<E> {
    public final Object holder;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.internal.InlineList.box-impl(java.lang.Object):kotlinx.coroutines.internal.InlineList] */
    public /* synthetic */ InlineList(Object obj) {
        this.holder = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ InlineList m2095boximpl(Object obj) {
        return new InlineList(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m2096constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ Object m2097constructorimpl$default(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m2096constructorimpl(obj);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2098equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.areEqual(obj, ((InlineList) obj2).m2104unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2099equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: forEachReversed-impl  reason: not valid java name */
    public static final void m2100forEachReversedimpl(Object obj, Function1<? super E, Unit> function1) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            function1.invoke(obj);
        } else if (obj != null) {
            ArrayList arrayList = (ArrayList) obj;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                function1.invoke((Object) arrayList.get(size));
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
        }
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2101hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: plus-impl  reason: not valid java name */
    public static final Object m2102plusimpl(Object obj, E e) {
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(e instanceof List))) {
            if (obj == null) {
                return m2096constructorimpl(e);
            }
            if (obj instanceof ArrayList) {
                if (obj != null) {
                    ((ArrayList) obj).add(e);
                    return m2096constructorimpl(obj);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            return m2096constructorimpl(arrayList);
        }
        throw new AssertionError();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2103toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + SmallTailInfo.EMOTION_SUFFIX;
    }

    public boolean equals(Object obj) {
        return m2098equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m2101hashCodeimpl(this.holder);
    }

    public String toString() {
        return m2103toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m2104unboximpl() {
        return this.holder;
    }
}
