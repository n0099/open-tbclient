package kotlin;

import com.alipay.sdk.app.statistic.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobstat.Config;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\u00020\u0004B\u001f\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001\u0012\u0006\u0010\u000b\u001a\u00028\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\b\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J@\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00028\u00012\b\b\u0002\u0010\u000b\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0006R\u0019\u0010\n\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u000b\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001f"}, d2 = {"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "component1", "()Ljava/lang/Object;", "component2", "component3", Config.TRACE_VISIT_FIRST, TypeAdapters.AnonymousClass27.SECOND, c.f1810e, "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getFirst", "getSecond", "getThird", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class Triple<A, B, C> implements Serializable {
    public final A first;
    public final B second;
    public final C third;

    public Triple(A a2, B b2, C c2) {
        this.first = a2;
        this.second = b2;
        this.third = c2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.Triple */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple copy$default(Triple triple, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if ((i2 & 1) != 0) {
            obj = triple.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = triple.second;
        }
        if ((i2 & 4) != 0) {
            obj3 = triple.third;
        }
        return triple.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final Triple<A, B, C> copy(A a2, B b2, C c2) {
        return new Triple<>(a2, b2, c2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Triple) {
                Triple triple = (Triple) obj;
                return Intrinsics.areEqual(this.first, triple.first) && Intrinsics.areEqual(this.second, triple.second) && Intrinsics.areEqual(this.third, triple.third);
            }
            return false;
        }
        return true;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a2 = this.first;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        int hashCode2 = (hashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.third;
        return hashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.second + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.third + ')';
    }
}
