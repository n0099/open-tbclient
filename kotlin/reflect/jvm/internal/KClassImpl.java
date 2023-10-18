package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001hB\u0015\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000C¢\u0006\u0004\bf\u0010gJ\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\"\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000-0\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010+R;\u00103\u001a$\u0012 \u0012\u001e 2*\u000e\u0018\u000101R\b\u0012\u0004\u0012\u00028\u00000\u000001R\b\u0012\u0004\u0012\u00028\u00000\u0000008\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010<R\u0016\u0010>\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<R\u0016\u0010?\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010<R\u0016\u0010@\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010<R\u0016\u0010A\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010<R\u0016\u0010B\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010<R\"\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000C8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020H8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR \u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010+R \u0010P\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010+R\u0018\u0010S\u001a\u0004\u0018\u00018\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u001d8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u001fR$\u0010W\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010#R\u0018\u0010Y\u001a\u0004\u0018\u00010\u001d8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u001fR\u0016\u0010[\u001a\u00020H8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010JR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\\0 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010#R\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020_0 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010#R\u0018\u0010e\u001a\u0004\u0018\u00010b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006i"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "", "index", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "hashCode", "()I", "value", "isInstance", "", "reportUnresolvedClass", "()Ljava/lang/Void;", "", "toString", "()Ljava/lang/String;", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "classId", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/KFunction;", "getConstructors", "constructors", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "isAbstract", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "Lkotlin/reflect/KCallable;", "getMembers", "members", "getNestedClasses", "nestedClasses", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "getQualifiedName", "qualifiedName", "getSealedSubclasses", "sealedSubclasses", "getSimpleName", "simpleName", "getStaticScope$kotlin_reflection", "staticScope", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility", "<init>", "(Ljava/lang/Class;)V", "Data", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl {
    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> data;
    public final Class<T> jClass;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bP\u0010QJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R'\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR'\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\n\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\fR'\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\fR'\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\fR'\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\fR\u001d\u0010-\u001a\u00020)8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b+\u0010,R'\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\n\u001a\u0004\b/\u0010\fR'\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b2\u0010\fR'\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b6\u0010\fR%\u0010=\u001a\u0004\u0018\u00018\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b8\u00109\u0012\u0004\b<\u0010\u001e\u001a\u0004\b:\u0010;R\u001f\u0010A\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b?\u0010@R+\u0010D\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000040\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bC\u0010\u0018R\u001f\u0010G\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bF\u0010@R#\u0010K\u001a\b\u0012\u0004\u0012\u00020H0\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bJ\u0010\u0018R#\u0010O\u001a\b\u0012\u0004\u0012\u00020L0\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bN\u0010\u0018¨\u0006R"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data", "Ljava/lang/Class;", "jClass", "", "calculateLocalClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getAllMembers", "()Ljava/util/Collection;", "allMembers", "allNonStaticMembers$delegate", "getAllNonStaticMembers", "allNonStaticMembers", "allStaticMembers$delegate", "getAllStaticMembers", "allStaticMembers", "", "", "annotations$delegate", "getAnnotations", "()Ljava/util/List;", "annotations", "Lkotlin/reflect/KFunction;", "constructors$delegate", "getConstructors", "constructors$annotations", "()V", "constructors", "declaredMembers$delegate", "getDeclaredMembers", "declaredMembers", "declaredNonStaticMembers$delegate", "getDeclaredNonStaticMembers", "declaredNonStaticMembers", "declaredStaticMembers$delegate", "getDeclaredStaticMembers", "declaredStaticMembers", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "descriptor$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "inheritedNonStaticMembers$delegate", "getInheritedNonStaticMembers", "inheritedNonStaticMembers", "inheritedStaticMembers$delegate", "getInheritedStaticMembers", "inheritedStaticMembers", "Lkotlin/reflect/KClass;", "nestedClasses$delegate", "getNestedClasses", "nestedClasses", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$annotations", "objectInstance", "qualifiedName$delegate", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName", "sealedSubclasses$delegate", "getSealedSubclasses", "sealedSubclasses", "simpleName$delegate", "getSimpleName", "simpleName", "Lkotlin/reflect/KType;", "supertypes$delegate", "getSupertypes", "supertypes", "Lkotlin/reflect/KTypeParameter;", "typeParameters$delegate", "getTypeParameters", "typeParameters", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        public final ReflectProperties.LazySoftVal allMembers$delegate;
        public final ReflectProperties.LazySoftVal allNonStaticMembers$delegate;
        public final ReflectProperties.LazySoftVal allStaticMembers$delegate;
        public final ReflectProperties.LazySoftVal annotations$delegate;
        public final ReflectProperties.LazySoftVal constructors$delegate;
        public final ReflectProperties.LazySoftVal declaredMembers$delegate;
        public final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate;
        public final ReflectProperties.LazySoftVal declaredStaticMembers$delegate;
        public final ReflectProperties.LazySoftVal descriptor$delegate;
        public final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate;
        public final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate;
        public final ReflectProperties.LazySoftVal nestedClasses$delegate;
        public final ReflectProperties.LazyVal objectInstance$delegate;
        public final ReflectProperties.LazySoftVal qualifiedName$delegate;
        public final ReflectProperties.LazySoftVal sealedSubclasses$delegate;
        public final ReflectProperties.LazySoftVal simpleName$delegate;
        public final ReflectProperties.LazySoftVal supertypes$delegate;
        public final ReflectProperties.LazySoftVal typeParameters$delegate;

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            return (Collection) this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            return (Collection) this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            return (Collection) this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
        }

        public final Collection<KCallableImpl<?>> getAllMembers() {
            return (Collection) this.allMembers$delegate.getValue(this, $$delegatedProperties[17]);
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            return (Collection) this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            return (Collection) this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[15]);
        }

        public final List<Annotation> getAnnotations() {
            return (List) this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        }

        public final Collection<KFunction<T>> getConstructors() {
            return (Collection) this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            return (Collection) this.declaredMembers$delegate.getValue(this, $$delegatedProperties[16]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            return (Collection) this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
        }

        public final ClassDescriptor getDescriptor() {
            return (ClassDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final Collection<KClass<?>> getNestedClasses() {
            return (Collection) this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
        }

        public final T getObjectInstance() {
            return this.objectInstance$delegate.getValue(this, $$delegatedProperties[6]);
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        public final List<KClass<? extends T>> getSealedSubclasses() {
            return (List) this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[9]);
        }

        public final String getSimpleName() {
            return (String) this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final List<KType> getSupertypes() {
            return (List) this.supertypes$delegate.getValue(this, $$delegatedProperties[8]);
        }

        public final List<KTypeParameter> getTypeParameters() {
            return (List) this.typeParameters$delegate.getValue(this, $$delegatedProperties[7]);
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public Data() {
            super();
            this.descriptor$delegate = ReflectProperties.lazySoft(new Function0<ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$descriptor$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final ClassDescriptor invoke() {
                    ClassId classId;
                    ClassDescriptor findClassAcrossModuleDependencies;
                    classId = KClassImpl.this.getClassId();
                    RuntimeModuleData moduleData = ((KClassImpl.Data) KClassImpl.this.getData().invoke()).getModuleData();
                    if (classId.isLocal()) {
                        findClassAcrossModuleDependencies = moduleData.getDeserialization().deserializeClass(classId);
                    } else {
                        findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleData.getModule(), classId);
                    }
                    if (findClassAcrossModuleDependencies == null) {
                        KClassImpl.this.reportUnresolvedClass();
                        throw null;
                    }
                    return findClassAcrossModuleDependencies;
                }
            });
            this.annotations$delegate = ReflectProperties.lazySoft(new Function0<List<? extends Annotation>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$annotations$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<java.lang.annotation.Annotation>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Annotation> invoke() {
                    return UtilKt.computeAnnotations(KClassImpl.Data.this.getDescriptor());
                }
            });
            this.simpleName$delegate = ReflectProperties.lazySoft(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$simpleName$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    ClassId classId;
                    String calculateLocalClassName;
                    if (!KClassImpl.this.getJClass().isAnonymousClass()) {
                        classId = KClassImpl.this.getClassId();
                        if (classId.isLocal()) {
                            KClassImpl.Data data = KClassImpl.Data.this;
                            calculateLocalClassName = data.calculateLocalClassName(KClassImpl.this.getJClass());
                            return calculateLocalClassName;
                        }
                        String asString = classId.getShortClassName().asString();
                        Intrinsics.checkExpressionValueIsNotNull(asString, "classId.shortClassName.asString()");
                        return asString;
                    }
                    return null;
                }
            });
            this.qualifiedName$delegate = ReflectProperties.lazySoft(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$qualifiedName$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    ClassId classId;
                    if (!KClassImpl.this.getJClass().isAnonymousClass()) {
                        classId = KClassImpl.this.getClassId();
                        if (classId.isLocal()) {
                            return null;
                        }
                        return classId.asSingleFqName().asString();
                    }
                    return null;
                }
            });
            this.constructors$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KFunction<? extends T>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$constructors$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final List<KFunction<T>> invoke() {
                    Collection<ConstructorDescriptor> constructorDescriptors = KClassImpl.this.getConstructorDescriptors();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(constructorDescriptors, 10));
                    for (ConstructorDescriptor constructorDescriptor : constructorDescriptors) {
                        arrayList.add(new KFunctionImpl(KClassImpl.this, constructorDescriptor));
                    }
                    return arrayList;
                }
            });
            this.nestedClasses$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KClassImpl<? extends Object>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$nestedClasses$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KClassImpl<? extends java.lang.Object>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KClassImpl<? extends Object>> invoke() {
                    KClassImpl kClassImpl;
                    Collection contributedDescriptors$default = ResolutionScope.DefaultImpls.getContributedDescriptors$default(KClassImpl.Data.this.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
                    ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
                    for (Object obj : contributedDescriptors$default) {
                        if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (DeclarationDescriptor declarationDescriptor : arrayList) {
                        if (declarationDescriptor != null) {
                            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
                            if (javaClass != null) {
                                kClassImpl = new KClassImpl(javaClass);
                            } else {
                                kClassImpl = null;
                            }
                            if (kClassImpl != null) {
                                arrayList2.add(kClassImpl);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        }
                    }
                    return arrayList2;
                }
            });
            this.objectInstance$delegate = ReflectProperties.lazy(new Function0<T>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$objectInstance$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    Field declaredField;
                    ClassDescriptor descriptor = KClassImpl.Data.this.getDescriptor();
                    if (descriptor.getKind() != ClassKind.OBJECT) {
                        return null;
                    }
                    if (descriptor.isCompanionObject() && !CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject(descriptor)) {
                        declaredField = KClassImpl.this.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString());
                    } else {
                        declaredField = KClassImpl.this.getJClass().getDeclaredField("INSTANCE");
                    }
                    T t = (T) declaredField.get(null);
                    if (t != null) {
                        return t;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type T");
                }
            });
            this.typeParameters$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KTypeParameterImpl>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$typeParameters$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KTypeParameterImpl>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KTypeParameterImpl> invoke() {
                    List<TypeParameterDescriptor> declaredTypeParameters = KClassImpl.Data.this.getDescriptor().getDeclaredTypeParameters();
                    Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters, "descriptor.declaredTypeParameters");
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(declaredTypeParameters, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
                        arrayList.add(new KTypeParameterImpl(typeParameterDescriptor));
                    }
                    return arrayList;
                }
            });
            this.supertypes$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$supertypes$2(this));
            this.sealedSubclasses$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KClassImpl<? extends T>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$sealedSubclasses$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final List<KClassImpl<? extends T>> invoke() {
                    KClassImpl kClassImpl;
                    Collection<ClassDescriptor> sealedSubclasses = KClassImpl.Data.this.getDescriptor().getSealedSubclasses();
                    Intrinsics.checkExpressionValueIsNotNull(sealedSubclasses, "descriptor.sealedSubclasses");
                    ArrayList arrayList = new ArrayList();
                    for (ClassDescriptor classDescriptor : sealedSubclasses) {
                        if (classDescriptor != null) {
                            Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
                            if (javaClass != null) {
                                kClassImpl = new KClassImpl(javaClass);
                            } else {
                                kClassImpl = null;
                            }
                            if (kClassImpl != null) {
                                arrayList.add(kClassImpl);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        }
                    }
                    return arrayList;
                }
            });
            this.declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredNonStaticMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.declaredStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredStaticMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedNonStaticMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedStaticMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.allNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allNonStaticMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection inheritedNonStaticMembers;
                    Collection<KCallableImpl<?>> declaredNonStaticMembers = KClassImpl.Data.this.getDeclaredNonStaticMembers();
                    inheritedNonStaticMembers = KClassImpl.Data.this.getInheritedNonStaticMembers();
                    return CollectionsKt___CollectionsKt.plus((Collection) declaredNonStaticMembers, (Iterable) inheritedNonStaticMembers);
                }
            });
            this.allStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allStaticMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection declaredStaticMembers;
                    Collection inheritedStaticMembers;
                    declaredStaticMembers = KClassImpl.Data.this.getDeclaredStaticMembers();
                    inheritedStaticMembers = KClassImpl.Data.this.getInheritedStaticMembers();
                    return CollectionsKt___CollectionsKt.plus(declaredStaticMembers, (Iterable) inheritedStaticMembers);
                }
            });
            this.declaredMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection declaredStaticMembers;
                    Collection<KCallableImpl<?>> declaredNonStaticMembers = KClassImpl.Data.this.getDeclaredNonStaticMembers();
                    declaredStaticMembers = KClassImpl.Data.this.getDeclaredStaticMembers();
                    return CollectionsKt___CollectionsKt.plus((Collection) declaredNonStaticMembers, (Iterable) declaredStaticMembers);
                }
            });
            this.allMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allMembers$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    return CollectionsKt___CollectionsKt.plus((Collection) KClassImpl.Data.this.getAllNonStaticMembers(), (Iterable) KClassImpl.Data.this.getAllStaticMembers());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String calculateLocalClassName(Class<?> cls) {
            String name = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkExpressionValueIsNotNull(name, "name");
                return StringsKt__StringsKt.substringAfter$default(name, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                Intrinsics.checkExpressionValueIsNotNull(name, "name");
                return StringsKt__StringsKt.substringAfter$default(name, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
            }
            Intrinsics.checkExpressionValueIsNotNull(name, "name");
            return StringsKt__StringsKt.substringAfter$default(name, '$', (String) null, 2, (Object) null);
        }
    }

    public KClassImpl(Class<T> cls) {
        this.jClass = cls;
        ReflectProperties.LazyVal<KClassImpl<T>.Data> lazy = ReflectProperties.lazy(new Function0<KClassImpl<T>.Data>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$data$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KClassImpl<T>.Data invoke() {
                return new KClassImpl.Data();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Data() }");
        this.data = lazy;
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object obj) {
        if ((obj instanceof KClassImpl) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) obj))) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        return CollectionsKt___CollectionsKt.plus((Collection) getMemberScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        return CollectionsKt___CollectionsKt.plus((Collection) getMemberScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object obj) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return TypeIntrinsics.isFunctionOfArity(obj, functionClassArity.intValue());
        }
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this.data.invoke().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() != ClassKind.INTERFACE && descriptor.getKind() != ClassKind.OBJECT) {
            Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
            Intrinsics.checkExpressionValueIsNotNull(constructors, "descriptor.constructors");
            return constructors;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<T>> getConstructors() {
        return this.data.invoke().getConstructors();
    }

    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public ClassDescriptor getDescriptor() {
        return this.data.invoke().getDescriptor();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.jClass;
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getAllMembers();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        return this.data.invoke().getNestedClasses();
    }

    @Override // kotlin.reflect.KClass
    public T getObjectInstance() {
        return this.data.invoke().getObjectInstance();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return this.data.invoke().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.data.invoke().getSealedSubclasses();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return this.data.invoke().getSimpleName();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        Intrinsics.checkExpressionValueIsNotNull(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return this.data.invoke().getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return this.data.invoke().getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        Visibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        if (getDescriptor().getModality() == Modality.ABSTRACT) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        if (getDescriptor().getModality() == Modality.FINAL) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        if (getDescriptor().getModality() == Modality.OPEN) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        if (getDescriptor().getModality() == Modality.SEALED) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void reportUnresolvedClass() {
        KotlinClassHeader.Kind kind;
        KotlinClassHeader classHeader;
        ReflectKotlinClass create = ReflectKotlinClass.Factory.create(getJClass());
        if (create != null && (classHeader = create.getClassHeader()) != null) {
            kind = classHeader.getKind();
        } else {
            kind = null;
        }
        if (kind != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + getJClass());
                case 4:
                    throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + getJClass());
                case 5:
                    throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + kind + ')');
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        throw new KotlinReflectionInternalError("Unresolved class: " + getJClass());
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Class<?> declaringClass;
        if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(declaringClass);
            if (kotlinClass != null) {
                return ((KClassImpl) kotlinClass).getLocalProperty(i);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        }
        ClassDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof DeserializedClassDescriptor)) {
            descriptor = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) descriptor;
        if (deserializedClassDescriptor == null) {
            return null;
        }
        ProtoBuf.Class classProto = deserializedClassDescriptor.getClassProto();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.classLocalVariable;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "JvmProtoBuf.classLocalVariable");
        ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(classProto, generatedExtension, i);
        if (property == null) {
            return null;
        }
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName, "classId.packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + ".";
        }
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "classId.relativeClassName.asString()");
        sb.append(str + StringsKt__StringsJVMKt.replace$default(asString, (char) IStringUtil.EXTENSION_SEPARATOR, '$', false, 4, (Object) null));
        return sb.toString();
    }
}
