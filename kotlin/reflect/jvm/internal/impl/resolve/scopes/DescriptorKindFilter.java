package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.baidu.android.common.others.lang.StringUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class DescriptorKindFilter {
    @JvmField
    public static final DescriptorKindFilter ALL;
    public static final int ALL_KINDS_MASK;
    @JvmField
    public static final DescriptorKindFilter CALLABLES;
    public static final int CALLABLES_MASK;
    @JvmField
    public static final DescriptorKindFilter CLASSIFIERS;
    public static final int CLASSIFIERS_MASK;
    public static final Companion Companion;
    public static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
    public static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    @JvmField
    public static final DescriptorKindFilter FUNCTIONS;
    public static final int FUNCTIONS_MASK;
    @JvmField
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    public static final int NON_SINGLETON_CLASSIFIERS_MASK;
    @JvmField
    public static final DescriptorKindFilter PACKAGES;
    public static final int PACKAGES_MASK;
    @JvmField
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    public static final int SINGLETON_CLASSIFIERS_MASK;
    @JvmField
    public static final DescriptorKindFilter TYPE_ALIASES;
    public static final int TYPE_ALIASES_MASK;
    @JvmField
    public static final DescriptorKindFilter VALUES;
    public static final int VALUES_MASK;
    @JvmField
    public static final DescriptorKindFilter VARIABLES;
    public static final int VARIABLES_MASK;
    public static int nextMaskValue;
    public final List<DescriptorKindExclude> excludes;
    public final int kindMask;

    /* loaded from: classes2.dex */
    public static final class Companion {

        /* loaded from: classes2.dex */
        public static final class MaskToName {
            public final int mask;
            public final String name;

            public MaskToName(int i, String str) {
                this.mask = i;
                this.name = str;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }

        public Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int nextMask() {
            int i = DescriptorKindFilter.nextMaskValue;
            DescriptorKindFilter.nextMaskValue <<= 1;
            return i;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.CLASSIFIERS_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.FUNCTIONS_MASK;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.PACKAGES_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.TYPE_ALIASES_MASK;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.VARIABLES_MASK;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        boolean z;
        Companion.MaskToName maskToName;
        Companion.MaskToName maskToName2;
        Companion companion = new Companion(null);
        Companion = companion;
        nextMaskValue = 1;
        NON_SINGLETON_CLASSIFIERS_MASK = companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = Companion.nextMask();
        TYPE_ALIASES_MASK = Companion.nextMask();
        PACKAGES_MASK = Companion.nextMask();
        FUNCTIONS_MASK = Companion.nextMask();
        VARIABLES_MASK = Companion.nextMask();
        int nextMask = Companion.nextMask() - 1;
        ALL_KINDS_MASK = nextMask;
        int i = NON_SINGLETON_CLASSIFIERS_MASK;
        int i2 = SINGLETON_CLASSIFIERS_MASK;
        CLASSIFIERS_MASK = i | i2 | TYPE_ALIASES_MASK;
        int i3 = FUNCTIONS_MASK;
        int i4 = VARIABLES_MASK;
        VALUES_MASK = i2 | i3 | i4;
        CALLABLES_MASK = i3 | i4;
        ALL = new DescriptorKindFilter(nextMask, null, 2, null);
        CALLABLES = new DescriptorKindFilter(CALLABLES_MASK, null, 2, null);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(NON_SINGLETON_CLASSIFIERS_MASK, null, 2, null);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(SINGLETON_CLASSIFIERS_MASK, null, 2, null);
        TYPE_ALIASES = new DescriptorKindFilter(TYPE_ALIASES_MASK, null, 2, null);
        CLASSIFIERS = new DescriptorKindFilter(CLASSIFIERS_MASK, null, 2, null);
        PACKAGES = new DescriptorKindFilter(PACKAGES_MASK, null, 2, null);
        FUNCTIONS = new DescriptorKindFilter(FUNCTIONS_MASK, null, 2, null);
        VARIABLES = new DescriptorKindFilter(VARIABLES_MASK, null, 2, null);
        VALUES = new DescriptorKindFilter(VALUES_MASK, null, 2, null);
        Field[] fields = DescriptorKindFilter.class.getFields();
        Intrinsics.checkExpressionValueIsNotNull(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field it : fields) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (Modifier.isStatic(it.getModifiers())) {
                arrayList.add(it);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field : arrayList) {
            Object obj = field.get(null);
            if (!(obj instanceof DescriptorKindFilter)) {
                obj = null;
            }
            DescriptorKindFilter descriptorKindFilter = (DescriptorKindFilter) obj;
            if (descriptorKindFilter != null) {
                int i5 = descriptorKindFilter.kindMask;
                Intrinsics.checkExpressionValueIsNotNull(field, "field");
                String name = field.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "field.name");
                maskToName2 = new Companion.MaskToName(i5, name);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                arrayList2.add(maskToName2);
            }
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = CollectionsKt___CollectionsKt.toList(arrayList2);
        Field[] fields2 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkExpressionValueIsNotNull(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field it2 : fields2) {
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            if (Modifier.isStatic(it2.getModifiers())) {
                arrayList3.add(it2);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            Field it3 = (Field) obj2;
            Intrinsics.checkExpressionValueIsNotNull(it3, "it");
            if (Intrinsics.areEqual(it3.getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field2 : arrayList4) {
            Object obj3 = field2.get(null);
            if (obj3 != null) {
                int intValue = ((Integer) obj3).intValue();
                if (intValue == ((-intValue) & intValue)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Intrinsics.checkExpressionValueIsNotNull(field2, "field");
                    String name2 = field2.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name2, "field.name");
                    maskToName = new Companion.MaskToName(intValue, name2);
                } else {
                    maskToName = null;
                }
                if (maskToName != null) {
                    arrayList5.add(maskToName);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        DEBUG_MASK_BIT_NAMES = CollectionsKt___CollectionsKt.toList(arrayList5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude> */
    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int i, List<? extends DescriptorKindExclude> list) {
        this.excludes = list;
        for (DescriptorKindExclude descriptorKindExclude : list) {
            i &= ~descriptorKindExclude.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = i;
    }

    public /* synthetic */ DescriptorKindFilter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public final boolean acceptsKinds(int i) {
        if ((i & this.kindMask) != 0) {
            return true;
        }
        return false;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int i) {
        int i2 = i & this.kindMask;
        if (i2 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i2, this.excludes);
    }

    public String toString() {
        Object obj;
        String str;
        String str2;
        boolean z;
        Iterator<T> it = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Companion.MaskToName) obj).getMask() == this.kindMask) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) obj;
        if (maskToName != null) {
            str = maskToName.getName();
        } else {
            str = null;
        }
        if (str == null) {
            List<Companion.MaskToName> list = DEBUG_MASK_BIT_NAMES;
            ArrayList arrayList = new ArrayList();
            for (Companion.MaskToName maskToName2 : list) {
                if (acceptsKinds(maskToName2.getMask())) {
                    str2 = maskToName2.getName();
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.excludes + ')';
    }
}
