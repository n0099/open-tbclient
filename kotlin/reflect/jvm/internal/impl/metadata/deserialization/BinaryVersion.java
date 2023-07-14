package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public abstract class BinaryVersion {
    public static final Companion Companion = new Companion(null);
    public final int major;
    public final int minor;
    public final int[] numbers;
    public final int patch;
    public final List<Integer> rest;

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BinaryVersion(int... iArr) {
        int i;
        int i2;
        List<Integer> emptyList;
        this.numbers = iArr;
        Integer orNull = ArraysKt___ArraysKt.getOrNull(iArr, 0);
        if (orNull != null) {
            i = orNull.intValue();
        } else {
            i = -1;
        }
        this.major = i;
        Integer orNull2 = ArraysKt___ArraysKt.getOrNull(this.numbers, 1);
        if (orNull2 != null) {
            i2 = orNull2.intValue();
        } else {
            i2 = -1;
        }
        this.minor = i2;
        Integer orNull3 = ArraysKt___ArraysKt.getOrNull(this.numbers, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : -1;
        int[] iArr2 = this.numbers;
        if (iArr2.length > 3) {
            emptyList = CollectionsKt___CollectionsKt.toList(ArraysKt___ArraysJvmKt.asList(iArr2).subList(3, this.numbers.length));
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.rest = emptyList;
    }

    public boolean equals(Object obj) {
        if (obj != null && Intrinsics.areEqual(getClass(), obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && Intrinsics.areEqual(this.rest, binaryVersion.rest)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isAtLeast(BinaryVersion binaryVersion) {
        return isAtLeast(binaryVersion.major, binaryVersion.minor, binaryVersion.patch);
    }

    public final boolean isCompatibleTo(BinaryVersion binaryVersion) {
        int i = this.major;
        if (i == 0) {
            if (binaryVersion.major == 0 && this.minor == binaryVersion.minor) {
                return true;
            }
        } else if (i == binaryVersion.major && this.minor <= binaryVersion.minor) {
            return true;
        }
        return false;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int i = this.major;
        int i2 = i + (i * 31) + this.minor;
        int i3 = i2 + (i2 * 31) + this.patch;
        return i3 + (i3 * 31) + this.rest.hashCode();
    }

    public final int[] toArray() {
        return this.numbers;
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.major;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.minor;
        if (i5 > i2) {
            return true;
        }
        if (i5 >= i2 && this.patch >= i3) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z;
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        for (int i : array) {
            if (i != -1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
