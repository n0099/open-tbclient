package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
/* loaded from: classes9.dex */
public final class TypeDeserializer$typeConstructor$1 extends Lambda implements Function1<Integer, ClassDescriptor> {
    public final /* synthetic */ ProtoBuf.Type $proto;
    public final /* synthetic */ TypeDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$typeConstructor$1(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        super(1);
        this.this$0 = typeDeserializer;
        this.$proto = type;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ClassDescriptor invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final ClassDescriptor invoke(int i) {
        DeserializationContext deserializationContext;
        DeserializationContext deserializationContext2;
        deserializationContext = this.this$0.c;
        ClassId classId = NameResolverUtilKt.getClassId(deserializationContext.getNameResolver(), i);
        List<Integer> mutableList = SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(SequencesKt__SequencesKt.generateSequence(this.$proto, new Function1<ProtoBuf.Type, ProtoBuf.Type>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$1$typeParametersCount$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final ProtoBuf.Type invoke(ProtoBuf.Type type) {
                DeserializationContext deserializationContext3;
                deserializationContext3 = TypeDeserializer$typeConstructor$1.this.this$0.c;
                return ProtoTypeTableUtilKt.outerType(type, deserializationContext3.getTypeTable());
            }
        }), new Function1<ProtoBuf.Type, Integer>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$1$typeParametersCount$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2(ProtoBuf.Type type) {
                return type.getArgumentCount();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(ProtoBuf.Type type) {
                return Integer.valueOf(invoke2(type));
            }
        }));
        int count = SequencesKt___SequencesKt.count(SequencesKt__SequencesKt.generateSequence(classId, TypeDeserializer$typeConstructor$1$classNestingLevel$1.INSTANCE));
        while (mutableList.size() < count) {
            mutableList.add(0);
        }
        deserializationContext2 = this.this$0.c;
        return deserializationContext2.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }
}
