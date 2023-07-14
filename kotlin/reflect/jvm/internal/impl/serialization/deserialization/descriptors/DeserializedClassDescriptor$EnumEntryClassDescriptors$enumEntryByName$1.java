package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* loaded from: classes2.dex */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends Lambda implements Function1<Name, EnumEntrySyntheticClassDescriptor> {
    public final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors) {
        super(1);
        this.this$0 = enumEntryClassDescriptors;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final EnumEntrySyntheticClassDescriptor invoke(final Name name) {
        Map map;
        NotNullLazyValue notNullLazyValue;
        map = this.this$0.enumEntryProtos;
        final ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) map.get(name);
        if (enumEntry != null) {
            StorageManager storageManager = DeserializedClassDescriptor.this.getC().getStorageManager();
            DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors = this.this$0;
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            notNullLazyValue = enumEntryClassDescriptors.enumMemberNames;
            return EnumEntrySyntheticClassDescriptor.create(storageManager, deserializedClassDescriptor, name, notNullLazyValue, new DeserializedAnnotations(DeserializedClassDescriptor.this.getC().getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends AnnotationDescriptor> invoke() {
                    return CollectionsKt___CollectionsKt.toList(DeserializedClassDescriptor.this.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(DeserializedClassDescriptor.this.getThisAsProtoContainer$deserialization(), ProtoBuf.EnumEntry.this));
                }
            }), SourceElement.NO_SOURCE);
        }
        return null;
    }
}
