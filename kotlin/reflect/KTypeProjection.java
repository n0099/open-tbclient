package kotlin.reflect;

import com.baidu.searchbox.account.contants.AccountConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\b\u0018\u0000 \u001c:\u0001\u001cB\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u0003¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "Lkotlin/reflect/KVariance;", "component1", "()Lkotlin/reflect/KVariance;", "Lkotlin/reflect/KType;", "component2", "()Lkotlin/reflect/KType;", "variance", "type", "copy", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KType;", "getType", "Lkotlin/reflect/KVariance;", "getVariance", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class KTypeProjection {
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final KTypeProjection star = new KTypeProjection(null, null);
    public final KType type;
    public final KVariance variance;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\u0005R\u0013\u0010\n\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u00038\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/KTypeProjection;", "contravariant", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "covariant", "invariant", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "STAR", AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, "Lkotlin/reflect/KTypeProjection;", "getStar$annotations", "()V", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        @PublishedApi
        public static /* synthetic */ void getStar$annotations() {
        }

        @JvmStatic
        public final KTypeProjection contravariant(KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.IN, type);
        }

        @JvmStatic
        public final KTypeProjection covariant(KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.OUT, type);
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.star;
        }

        @JvmStatic
        public final KTypeProjection invariant(KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.INVARIANT, type);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$0[KVariance.IN.ordinal()] = 2;
            $EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        String str;
        this.variance = kVariance;
        this.type = kType;
        if ((kVariance == null) == (this.type == null)) {
            return;
        }
        if (this.variance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + this.variance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @JvmStatic
    public static final KTypeProjection contravariant(KType kType) {
        return Companion.contravariant(kType);
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((i2 & 2) != 0) {
            kType = kTypeProjection.type;
        }
        return kTypeProjection.copy(kVariance, kType);
    }

    @JvmStatic
    public static final KTypeProjection covariant(KType kType) {
        return Companion.covariant(kType);
    }

    @JvmStatic
    public static final KTypeProjection invariant(KType kType) {
        return Companion.invariant(kType);
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
        KVariance kVariance = this.variance;
        if (kVariance == null) {
            return "*";
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "in " + this.type;
            } else if (i2 == 3) {
                return "out " + this.type;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return String.valueOf(this.type);
    }
}
