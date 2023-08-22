package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
/* loaded from: classes2.dex */
public final class KotlinClassHeader {
    public final JvmBytecodeBinaryVersion bytecodeVersion;
    public final String[] data;
    public final int extraInt;
    public final String extraString;
    public final String[] incompatibleData;
    public final Kind kind;
    public final JvmMetadataVersion metadataVersion;
    public final String packageName;
    public final String[] strings;

    /* loaded from: classes2.dex */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        public static final Companion Companion = new Companion(null);
        public static final Map<Integer, Kind> entryById;
        public final int id;

        @JvmStatic
        public static final Kind getById(int i) {
            return Companion.getById(i);
        }

        /* loaded from: classes2.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Kind getById(int i) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i));
                if (kind == null) {
                    return Kind.UNKNOWN;
                }
                return kind;
            }
        }

        static {
            Kind[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(values.length), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.id), kind);
            }
            entryById = linkedHashMap;
        }

        Kind(int i) {
            this.id = i;
        }
    }

    public KotlinClassHeader(Kind kind, JvmMetadataVersion jvmMetadataVersion, JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        this.kind = kind;
        this.metadataVersion = jvmMetadataVersion;
        this.bytecodeVersion = jvmBytecodeBinaryVersion;
        this.data = strArr;
        this.incompatibleData = strArr2;
        this.strings = strArr3;
        this.extraString = str;
        this.extraInt = i;
        this.packageName = str2;
    }

    public final String[] getData() {
        return this.data;
    }

    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public final String getMultifileClassName() {
        boolean z;
        String str = this.extraString;
        if (this.kind == Kind.MULTIFILE_CLASS_PART) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return null;
        }
        return str;
    }

    public final List<String> getMultifilePartNames() {
        boolean z;
        String[] strArr = this.data;
        if (this.kind == Kind.MULTIFILE_CLASS) {
            z = true;
        } else {
            z = false;
        }
        List<String> list = null;
        if (!z) {
            strArr = null;
        }
        if (strArr != null) {
            list = ArraysKt___ArraysJvmKt.asList(strArr);
        }
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public final String[] getStrings() {
        return this.strings;
    }

    public final boolean isPreRelease() {
        if ((this.extraInt & 2) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}
