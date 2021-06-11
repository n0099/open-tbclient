package kotlinx.android.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "Companion", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public enum CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;
    
    public static final Companion Companion = new Companion(null);
    public static final CacheImplementation DEFAULT = HASH_MAP;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation$Companion;", "Lkotlinx/android/extensions/CacheImplementation;", "DEFAULT", "Lkotlinx/android/extensions/CacheImplementation;", "getDEFAULT", "()Lkotlinx/android/extensions/CacheImplementation;", "<init>", "()V", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public final CacheImplementation getDEFAULT() {
            return CacheImplementation.DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
