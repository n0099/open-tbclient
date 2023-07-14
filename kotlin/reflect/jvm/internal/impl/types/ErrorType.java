package kotlin.reflect.jvm.internal.impl.types;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public class ErrorType extends SimpleType {
    public final List<TypeProjection> arguments;
    public final TypeConstructor constructor;
    public final boolean isMarkedNullable;
    public final MemberScope memberScope;
    public final String presentableName;

    @JvmOverloads
    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope) {
        this(typeConstructor, memberScope, null, false, null, 28, null);
    }

    @JvmOverloads
    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z) {
        this(typeConstructor, memberScope, list, z, null, 16, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public ErrorType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAnnotations(Annotations annotations) {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z, String str) {
        this.constructor = typeConstructor;
        this.memberScope = memberScope;
        this.arguments = list;
        this.isMarkedNullable = z;
        this.presentableName = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ErrorType(TypeConstructor typeConstructor, MemberScope memberScope, List list, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeConstructor, memberScope, r3, r4, (i & 16) != 0 ? "???" : str);
        boolean z2;
        List emptyList = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        if ((i & 8) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public String getPresentableName() {
        return this.presentableName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        return new ErrorType(getConstructor(), getMemberScope(), getArguments(), z, null, 16, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        String joinToString;
        StringBuilder sb = new StringBuilder();
        sb.append(getConstructor().toString());
        if (getArguments().isEmpty()) {
            joinToString = "";
        } else {
            joinToString = CollectionsKt___CollectionsKt.joinToString(getArguments(), StringUtil.ARRAY_ELEMENT_SEPARATOR, "<", ">", -1, "...", null);
        }
        sb.append(joinToString);
        return sb.toString();
    }
}
