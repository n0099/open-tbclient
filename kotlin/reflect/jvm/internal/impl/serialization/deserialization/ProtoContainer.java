package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes9.dex */
public abstract class ProtoContainer {
    public final NameResolver nameResolver;
    public final SourceElement source;
    public final TypeTable typeTable;

    public abstract FqName debugFqName();

    /* loaded from: classes9.dex */
    public static final class Class extends ProtoContainer {
        public final ClassId classId;
        public final ProtoBuf.Class classProto;
        public final boolean isInner;
        public final ProtoBuf.Class.Kind kind;
        public final Class outerClass;

        public Class(ProtoBuf.Class r2, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, Class r6) {
            super(nameResolver, typeTable, sourceElement, null);
            this.classProto = r2;
            this.outerClass = r6;
            this.classId = NameResolverUtilKt.getClassId(nameResolver, r2.getFqName());
            ProtoBuf.Class.Kind kind = Flags.CLASS_KIND.get(this.classProto.getFlags());
            this.kind = kind == null ? ProtoBuf.Class.Kind.CLASS : kind;
            Boolean bool = Flags.IS_INNER.get(this.classProto.getFlags());
            Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_INNER.get(classProto.flags)");
            this.isInner = bool.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            FqName asSingleFqName = this.classId.asSingleFqName();
            Intrinsics.checkExpressionValueIsNotNull(asSingleFqName, "classId.asSingleFqName()");
            return asSingleFqName;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public final ProtoBuf.Class getClassProto() {
            return this.classProto;
        }

        public final ProtoBuf.Class.Kind getKind() {
            return this.kind;
        }

        public final Class getOuterClass() {
            return this.outerClass;
        }

        public final boolean isInner() {
            return this.isInner;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Package extends ProtoContainer {
        public final FqName fqName;

        public Package(FqName fqName, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
            super(nameResolver, typeTable, sourceElement, null);
            this.fqName = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.fqName;
        }
    }

    public ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.source = sourceElement;
    }

    public /* synthetic */ ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, sourceElement);
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final SourceElement getSource() {
        return this.source;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + debugFqName();
    }
}
