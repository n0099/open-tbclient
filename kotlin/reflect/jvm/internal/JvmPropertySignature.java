package kotlin.reflect.jvm.internal;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000:\u0004\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "<init>", "()V", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public abstract class JvmPropertySignature {
    public abstract String asString();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Field;", "field", "Ljava/lang/reflect/Field;", "getField", "()Ljava/lang/reflect/Field;", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class JavaField extends JvmPropertySignature {
        public final Field field;

        public JavaField(Field field) {
            super(null);
            this.field = field;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            StringBuilder sb = new StringBuilder();
            sb.append(JvmAbi.getterName(this.field.getName()));
            sb.append("()");
            Class<?> type = this.field.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "field.type");
            sb.append(ReflectClassUtilKt.getDesc(type));
            return sb.toString();
        }

        public final Field getField() {
            return this.field;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", "getterMethod", "Ljava/lang/reflect/Method;", "getGetterMethod", "()Ljava/lang/reflect/Method;", "setterMethod", "getSetterMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class JavaMethodProperty extends JvmPropertySignature {
        public final Method getterMethod;
        public final Method setterMethod;

        public JavaMethodProperty(Method method, Method method2) {
            super(null);
            this.getterMethod = method;
            this.setterMethod = method2;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature$p(this.getterMethod);
        }

        public final Method getGetterMethod() {
            return this.getterMethod;
        }

        public final Method getSetterMethod() {
            return this.setterMethod;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "getManglingSuffix", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", DpStatConstants.KEY_PROTO, "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", SocialOperation.GAME_SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", EMABTest.TYPE_STRING, "Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "<init>", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class KotlinProperty extends JvmPropertySignature {
        public final PropertyDescriptor descriptor;
        public final NameResolver nameResolver;
        public final ProtoBuf.Property proto;
        public final JvmProtoBuf.JvmPropertySignature signature;
        public final String string;
        public final TypeTable typeTable;

        public KotlinProperty(PropertyDescriptor propertyDescriptor, ProtoBuf.Property property, JvmProtoBuf.JvmPropertySignature jvmPropertySignature, NameResolver nameResolver, TypeTable typeTable) {
            super(null);
            String str;
            this.descriptor = propertyDescriptor;
            this.proto = property;
            this.signature = jvmPropertySignature;
            this.nameResolver = nameResolver;
            this.typeTable = typeTable;
            if (jvmPropertySignature.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                NameResolver nameResolver2 = this.nameResolver;
                JvmProtoBuf.JvmMethodSignature getter = this.signature.getGetter();
                Intrinsics.checkExpressionValueIsNotNull(getter, "signature.getter");
                sb.append(nameResolver2.getString(getter.getName()));
                NameResolver nameResolver3 = this.nameResolver;
                JvmProtoBuf.JvmMethodSignature getter2 = this.signature.getGetter();
                Intrinsics.checkExpressionValueIsNotNull(getter2, "signature.getter");
                sb.append(nameResolver3.getString(getter2.getDesc()));
                str = sb.toString();
            } else {
                JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, this.proto, this.nameResolver, this.typeTable, false, 8, null);
                if (jvmFieldSignature$default != null) {
                    String component1 = jvmFieldSignature$default.component1();
                    str = JvmAbi.getterName(component1) + getManglingSuffix() + "()" + jvmFieldSignature$default.component2();
                } else {
                    throw new KotlinReflectionInternalError("No field signature for property: " + this.descriptor);
                }
            }
            this.string = str;
        }

        private final String getManglingSuffix() {
            DeclarationDescriptor containingDeclaration = this.descriptor.getContainingDeclaration();
            Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "descriptor.containingDeclaration");
            if (Intrinsics.areEqual(this.descriptor.getVisibility(), Visibilities.INTERNAL) && (containingDeclaration instanceof DeserializedClassDescriptor)) {
                ProtoBuf.Class classProto = ((DeserializedClassDescriptor) containingDeclaration).getClassProto();
                GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> generatedExtension = JvmProtoBuf.classModuleName;
                Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "JvmProtoBuf.classModuleName");
                Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(classProto, generatedExtension);
                String str = (num == null || (str = this.nameResolver.getString(num.intValue())) == null) ? "main" : "main";
                return "$" + NameUtils.sanitizeAsJavaIdentifier(str);
            } else if (Intrinsics.areEqual(this.descriptor.getVisibility(), Visibilities.PRIVATE) && (containingDeclaration instanceof PackageFragmentDescriptor)) {
                PropertyDescriptor propertyDescriptor = this.descriptor;
                if (propertyDescriptor != null) {
                    DeserializedContainerSource containerSource = ((DeserializedPropertyDescriptor) propertyDescriptor).getContainerSource();
                    if (containerSource instanceof JvmPackagePartSource) {
                        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
                        if (jvmPackagePartSource.getFacadeClassName() != null) {
                            return "$" + jvmPackagePartSource.getSimpleName().asString();
                        }
                        return "";
                    }
                    return "";
                }
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            } else {
                return "";
            }
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            return this.string;
        }

        public final PropertyDescriptor getDescriptor() {
            return this.descriptor;
        }

        public final NameResolver getNameResolver() {
            return this.nameResolver;
        }

        public final ProtoBuf.Property getProto() {
            return this.proto;
        }

        public final JvmProtoBuf.JvmPropertySignature getSignature() {
            return this.signature;
        }

        public final TypeTable getTypeTable() {
            return this.typeTable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "getSetterSignature", "<init>", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class MappedKotlinProperty extends JvmPropertySignature {
        public final JvmFunctionSignature.KotlinFunction getterSignature;
        public final JvmFunctionSignature.KotlinFunction setterSignature;

        public MappedKotlinProperty(JvmFunctionSignature.KotlinFunction kotlinFunction, JvmFunctionSignature.KotlinFunction kotlinFunction2) {
            super(null);
            this.getterSignature = kotlinFunction;
            this.setterSignature = kotlinFunction2;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        public String asString() {
            return this.getterSignature.asString();
        }

        public final JvmFunctionSignature.KotlinFunction getGetterSignature() {
            return this.getterSignature;
        }

        public final JvmFunctionSignature.KotlinFunction getSetterSignature() {
            return this.setterSignature;
        }
    }

    public JvmPropertySignature() {
    }

    public /* synthetic */ JvmPropertySignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
