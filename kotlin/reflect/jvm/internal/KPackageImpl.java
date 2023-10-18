package kotlin.reflect.jvm.internal;

import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u00014B\u001f\u0012\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b2\u00103J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR,\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012 \u001e*\b\u0018\u00010\u001dR\u00020\u00000\u001dR\u00020\u00000\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010\"\u001a\u0006\u0012\u0002\b\u00030!8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001aR\u001a\u0010*\u001a\u0006\u0012\u0002\b\u00030!8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%R\u0016\u0010.\u001a\u00020+8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0017¨\u00065"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "", "index", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/reflect/KCallable;", "getMembers", "members", "getMethodOwner", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "usageModuleName", "Ljava/lang/String;", "getUsageModuleName", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "Data", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {
    public final ReflectProperties.LazyVal<Data> data;
    public final Class<?> jClass;
    public final String usageModuleName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R'\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR1\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00178F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001c8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "members$delegate", "getMembers", "()Ljava/util/Collection;", "members", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getMetadata", "()Lkotlin/Triple;", TtmlNode.TAG_METADATA, "Ljava/lang/Class;", "multifileFacade$delegate", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope$delegate", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "<init>", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), TtmlNode.TAG_METADATA, "getMetadata()Lkotlin/Triple;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        public final ReflectProperties.LazySoftVal kotlinClass$delegate;
        public final ReflectProperties.LazySoftVal members$delegate;
        public final ReflectProperties.LazyVal metadata$delegate;
        public final ReflectProperties.LazyVal multifileFacade$delegate;
        public final ReflectProperties.LazySoftVal scope$delegate;

        /* JADX INFO: Access modifiers changed from: private */
        public final ReflectKotlinClass getKotlinClass() {
            return (ReflectKotlinClass) this.kotlinClass$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final Collection<KCallableImpl<?>> getMembers() {
            return (Collection) this.members$delegate.getValue(this, $$delegatedProperties[4]);
        }

        public final Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> getMetadata() {
            return (Triple) this.metadata$delegate.getValue(this, $$delegatedProperties[3]);
        }

        public final Class<?> getMultifileFacade() {
            return (Class) this.multifileFacade$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final MemberScope getScope() {
            return (MemberScope) this.scope$delegate.getValue(this, $$delegatedProperties[1]);
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public Data() {
            super();
            this.kotlinClass$delegate = ReflectProperties.lazySoft(new Function0<ReflectKotlinClass>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$kotlinClass$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final ReflectKotlinClass invoke() {
                    return ReflectKotlinClass.Factory.create(KPackageImpl.this.getJClass());
                }
            });
            this.scope$delegate = ReflectProperties.lazySoft(new Function0<MemberScope>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$scope$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final MemberScope invoke() {
                    ReflectKotlinClass kotlinClass;
                    kotlinClass = KPackageImpl.Data.this.getKotlinClass();
                    if (kotlinClass != null) {
                        return KPackageImpl.Data.this.getModuleData().getPackagePartScopeCache().getPackagePartScope(kotlinClass);
                    }
                    return MemberScope.Empty.INSTANCE;
                }
            });
            this.multifileFacade$delegate = ReflectProperties.lazy(new Function0<Class<?>>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$multifileFacade$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Class<?> invoke() {
                    ReflectKotlinClass kotlinClass;
                    String str;
                    boolean z;
                    KotlinClassHeader classHeader;
                    kotlinClass = KPackageImpl.Data.this.getKotlinClass();
                    if (kotlinClass != null && (classHeader = kotlinClass.getClassHeader()) != null) {
                        str = classHeader.getMultifileClassName();
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        return null;
                    }
                    if (str.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return null;
                    }
                    return KPackageImpl.this.getJClass().getClassLoader().loadClass(StringsKt__StringsJVMKt.replace$default(str, (char) WebvttCueParser.CHAR_SLASH, (char) IStringUtil.EXTENSION_SEPARATOR, false, 4, (Object) null));
                }
            });
            this.metadata$delegate = ReflectProperties.lazy(new Function0<Triple<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion>>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$metadata$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'kotlin.Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Triple<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion> invoke() {
                    ReflectKotlinClass kotlinClass;
                    KotlinClassHeader classHeader;
                    kotlinClass = KPackageImpl.Data.this.getKotlinClass();
                    if (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) {
                        return null;
                    }
                    String[] data = classHeader.getData();
                    String[] strings = classHeader.getStrings();
                    if (data == null || strings == null) {
                        return null;
                    }
                    Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data, strings);
                    return new Triple<>(readPackageDataFrom.component1(), readPackageDataFrom.component2(), classHeader.getMetadataVersion());
                }
            });
            this.members$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$members$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KPackageImpl.Data data = KPackageImpl.Data.this;
                    return KPackageImpl.this.getMembers(data.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
        }
    }

    public KPackageImpl(Class<?> cls, String str) {
        this.jClass = cls;
        this.usageModuleName = str;
        ReflectProperties.LazyVal<Data> lazy = ReflectProperties.lazy(new Function0<Data>() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$data$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KPackageImpl.Data invoke() {
                return new KPackageImpl.Data();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazy, "ReflectProperties.lazy { Data() }");
        this.data = lazy;
    }

    public /* synthetic */ KPackageImpl(Class cls, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i & 2) != 0 ? null : str);
    }

    private final MemberScope getScope() {
        return this.data.invoke().getScope();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getMembers();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Class<?> getMethodOwner() {
        Class<?> multifileFacade = this.data.invoke().getMultifileFacade();
        if (multifileFacade == null) {
            return getJClass();
        }
        return multifileFacade;
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof KPackageImpl) && Intrinsics.areEqual(getJClass(), ((KPackageImpl) obj).getJClass())) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> */
    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        return getScope().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> */
    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        return getScope().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> metadata = this.data.invoke().getMetadata();
        if (metadata == null) {
            return null;
        }
        JvmNameResolver component1 = metadata.component1();
        ProtoBuf.Package component2 = metadata.component2();
        JvmMetadataVersion component3 = metadata.component3();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.packageLocalVariable;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "JvmProtoBuf.packageLocalVariable");
        ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(component2, generatedExtension, i);
        if (property == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        ProtoBuf.TypeTable typeTable = component2.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(typeTable, "packageProto.typeTable");
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(jClass, property, component1, new TypeTable(typeTable), component3, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
    }
}
