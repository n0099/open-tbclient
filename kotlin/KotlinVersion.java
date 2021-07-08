package kotlin;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dB\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001eJ\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u001a\u0010\u000bR\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006 "}, d2 = {"Lkotlin/KotlinVersion;", "Ljava/lang/Comparable;", "other", "", "compareTo", "(Lkotlin/KotlinVersion;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "major", "minor", "isAtLeast", "(II)Z", SchemeDescPatchListener.PATCH, "(III)Z", "", "toString", "()Ljava/lang/String;", "versionOf", "(III)I", "I", "getMajor", "getMinor", "getPatch", "version", "<init>", "(II)V", "(III)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final int MAX_COMPONENT_VALUE = 255;
    public final int major;
    public final int minor;
    public final int patch;
    public final int version;
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final KotlinVersion CURRENT = new KotlinVersion(1, 4, 10);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "Lkotlin/KotlinVersion;", "CURRENT", "Lkotlin/KotlinVersion;", "", "MAX_COMPONENT_VALUE", "I", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KotlinVersion(int i2, int i3, int i4) {
        this.major = i2;
        this.minor = i3;
        this.patch = i4;
        this.version = versionOf(i2, i3, i4);
    }

    private final int versionOf(int i2, int i3, int i4) {
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + IStringUtil.EXTENSION_SEPARATOR + i3 + IStringUtil.EXTENSION_SEPARATOR + i4).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinVersion)) {
            obj = null;
        }
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        return kotlinVersion != null && this.version == kotlinVersion.version;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return this.version;
    }

    public final boolean isAtLeast(int i2, int i3) {
        int i4 = this.major;
        return i4 > i2 || (i4 == i2 && this.minor >= i3);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r3v0 'this' kotlin.KotlinVersion A[IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.major int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char), (wrap: int : 0x000f: IGET  (r2v0 int A[REMOVE]) = (r3v0 'this' kotlin.KotlinVersion A[IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.minor int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char), (wrap: int : 0x0017: IGET  (r1v2 int A[REMOVE]) = (r3v0 'this' kotlin.KotlinVersion A[IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.patch int)] */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.major);
        sb.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(this.minor);
        sb.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(this.patch);
        return sb.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(KotlinVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.version - other.version;
    }

    public final boolean isAtLeast(int i2, int i3, int i4) {
        int i5;
        int i6 = this.major;
        return i6 > i2 || (i6 == i2 && ((i5 = this.minor) > i3 || (i5 == i3 && this.patch >= i4)));
    }

    public KotlinVersion(int i2, int i3) {
        this(i2, i3, 0);
    }
}
