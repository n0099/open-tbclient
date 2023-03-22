package kotlin.reflect.jvm.internal.impl.utils;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class Jsr305State {
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final Jsr305State DEFAULT = new Jsr305State(ReportLevel.WARN, null, MapsKt__MapsKt.emptyMap(), false, 8, null);
    @JvmField
    public static final Jsr305State DISABLED;
    @JvmField
    public static final Jsr305State STRICT;
    public final Lazy description$delegate;
    public final boolean enableCompatqualCheckerFrameworkAnnotations;
    public final ReportLevel global;
    public final ReportLevel migration;
    public final Map<String, ReportLevel> user;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Jsr305State) {
                Jsr305State jsr305State = (Jsr305State) obj;
                return Intrinsics.areEqual(this.global, jsr305State.global) && Intrinsics.areEqual(this.migration, jsr305State.migration) && Intrinsics.areEqual(this.user, jsr305State.user) && this.enableCompatqualCheckerFrameworkAnnotations == jsr305State.enableCompatqualCheckerFrameworkAnnotations;
            }
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ReportLevel reportLevel = this.global;
        int hashCode = (reportLevel != null ? reportLevel.hashCode() : 0) * 31;
        ReportLevel reportLevel2 = this.migration;
        int hashCode2 = (hashCode + (reportLevel2 != null ? reportLevel2.hashCode() : 0)) * 31;
        Map<String, ReportLevel> map = this.user;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z = this.enableCompatqualCheckerFrameworkAnnotations;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Jsr305State(global=" + this.global + ", migration=" + this.migration + ", user=" + this.user + ", enableCompatqualCheckerFrameworkAnnotations=" + this.enableCompatqualCheckerFrameworkAnnotations + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ReportLevel reportLevel = ReportLevel.IGNORE;
        DISABLED = new Jsr305State(reportLevel, reportLevel, MapsKt__MapsKt.emptyMap(), false, 8, null);
        ReportLevel reportLevel2 = ReportLevel.STRICT;
        STRICT = new Jsr305State(reportLevel2, reportLevel2, MapsKt__MapsKt.emptyMap(), false, 8, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends kotlin.reflect.jvm.internal.impl.utils.ReportLevel> */
    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305State(ReportLevel reportLevel, ReportLevel reportLevel2, Map<String, ? extends ReportLevel> map, boolean z) {
        this.global = reportLevel;
        this.migration = reportLevel2;
        this.user = map;
        this.enableCompatqualCheckerFrameworkAnnotations = z;
        this.description$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String[]>() { // from class: kotlin.reflect.jvm.internal.impl.utils.Jsr305State$description$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String[] invoke() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Jsr305State.this.getGlobal().getDescription());
                ReportLevel migration = Jsr305State.this.getMigration();
                if (migration != null) {
                    arrayList.add("under-migration:" + migration.getDescription());
                }
                for (Map.Entry<String, ReportLevel> entry : Jsr305State.this.getUser().entrySet()) {
                    arrayList.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    return (String[]) array;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        });
    }

    public /* synthetic */ Jsr305State(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, reportLevel2, map, (i & 8) != 0 ? true : z);
    }

    public final boolean getDisabled() {
        if (this == DISABLED) {
            return true;
        }
        return false;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.enableCompatqualCheckerFrameworkAnnotations;
    }

    public final ReportLevel getGlobal() {
        return this.global;
    }

    public final ReportLevel getMigration() {
        return this.migration;
    }

    public final Map<String, ReportLevel> getUser() {
        return this.user;
    }
}
