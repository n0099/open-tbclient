package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ExtensionRegistryLite {
    public static final ExtensionRegistryLite EMPTY = new ExtensionRegistryLite(true);
    public static volatile boolean eagerlyParseMessageSets = false;
    public final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    /* loaded from: classes6.dex */
    public static final class ObjectIntPair {
        public final int number;
        public final Object object;

        public ObjectIntPair(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ObjectIntPair) {
                ObjectIntPair objectIntPair = (ObjectIntPair) obj;
                return this.object == objectIntPair.object && this.number == objectIntPair.number;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public static void setEagerlyParseMessageSets(boolean z) {
        eagerlyParseMessageSets = z;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.extensionsByNumber.put(new ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.extensionsByNumber.get(new ObjectIntPair(containingtype, i));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == EMPTY) {
            this.extensionsByNumber = Collections.emptyMap();
        } else {
            this.extensionsByNumber = Collections.unmodifiableMap(extensionRegistryLite.extensionsByNumber);
        }
    }

    public ExtensionRegistryLite(boolean z) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
