package kotlin.reflect;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\b\u0018\u0000 \u001c:\u0001\u001cB\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u0003¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "Lkotlin/reflect/KVariance;", "component1", "()Lkotlin/reflect/KVariance;", "Lkotlin/reflect/KType;", "component2", "()Lkotlin/reflect/KType;", "variance", "type", "copy", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KType;", "getType", "Lkotlin/reflect/KVariance;", "getVariance", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class KTypeProjection {
    public static final Companion Companion = new Companion(null);
    public static final KTypeProjection STAR = new KTypeProjection(null, null);
    public final KType type;
    public final KVariance variance;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0005R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/KTypeProjection;", "contravariant", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "covariant", "invariant", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public final KTypeProjection contravariant(KType kType) {
            return new KTypeProjection(KVariance.IN, kType);
        }

        public final KTypeProjection covariant(KType kType) {
            return new KTypeProjection(KVariance.OUT, kType);
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.STAR;
        }

        public final KTypeProjection invariant(KType kType) {
            return new KTypeProjection(KVariance.INVARIANT, kType);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        this.variance = kVariance;
        this.type = kType;
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int i, Object obj) {
        if ((i & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((i & 2) != 0) {
            kType = kTypeProjection.type;
        }
        return kTypeProjection.copy(kVariance, kType);
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance kVariance, KType kType) {
        return new KTypeProjection(kVariance, kType);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof KTypeProjection) {
                KTypeProjection kTypeProjection = (KTypeProjection) obj;
                return Intrinsics.areEqual(this.variance, kTypeProjection.variance) && Intrinsics.areEqual(this.type, kTypeProjection.type);
            }
            return false;
        }
        return true;
    }

    public final KType getType() {
        return this.type;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        KVariance kVariance = this.variance;
        int hashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        KType kType = this.type;
        return hashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        return "KTypeProjection(variance=" + this.variance + ", type=" + this.type + SmallTailInfo.EMOTION_SUFFIX;
    }
}
