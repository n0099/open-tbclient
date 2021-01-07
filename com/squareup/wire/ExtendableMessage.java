package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    transient ExtensionMap<T> extensionMap;

    protected ExtendableMessage(ExtendableBuilder<T> extendableBuilder) {
        super(extendableBuilder);
        if (extendableBuilder.extensionMap != null) {
            this.extensionMap = new ExtensionMap<>(extendableBuilder.extensionMap);
        }
    }

    public List<Extension<T, ?>> getExtensions() {
        return this.extensionMap == null ? Collections.emptyList() : this.extensionMap.getExtensions();
    }

    public <E> E getExtension(Extension<T, E> extension) {
        if (this.extensionMap == null) {
            return null;
        }
        return (E) this.extensionMap.get(extension);
    }

    protected boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        if (this.extensionMap == null) {
            return extendableMessage.extensionMap == null;
        }
        return this.extensionMap.equals(extendableMessage.extensionMap);
    }

    protected int extensionsHashCode() {
        if (this.extensionMap == null) {
            return 0;
        }
        return this.extensionMap.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String extensionsToString() {
        return this.extensionMap == null ? "{}" : this.extensionMap.toString();
    }

    /* loaded from: classes6.dex */
    public static abstract class ExtendableBuilder<T extends ExtendableMessage<?>> extends Message.Builder<T> {
        ExtensionMap<T> extensionMap;

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(ExtendableMessage<T> extendableMessage) {
            super(extendableMessage);
            if (extendableMessage != null && extendableMessage.extensionMap != null) {
                this.extensionMap = new ExtensionMap<>(extendableMessage.extensionMap);
            }
        }

        public <E> E getExtension(Extension<T, E> extension) {
            if (this.extensionMap == null) {
                return null;
            }
            return (E) this.extensionMap.get(extension);
        }

        public <E> ExtendableBuilder<T> setExtension(Extension<T, E> extension, E e) {
            if (this.extensionMap == null) {
                this.extensionMap = new ExtensionMap<>();
            }
            this.extensionMap.put(extension, e);
            return this;
        }
    }
}
