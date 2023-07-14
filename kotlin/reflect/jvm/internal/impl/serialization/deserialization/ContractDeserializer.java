package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
/* loaded from: classes2.dex */
public interface ContractDeserializer {
    public static final Companion Companion = Companion.$$INSTANCE;

    Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(ProtoBuf.Function function, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer);

    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ContractDeserializer DEFAULT = new ContractDeserializer() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$Companion$DEFAULT$1
            @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
            public Pair deserializeContractFromFunction(ProtoBuf.Function function, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer) {
                return null;
            }
        };

        public final ContractDeserializer getDEFAULT() {
            return DEFAULT;
        }
    }
}
