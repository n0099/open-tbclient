package com.squareup.wire;

import com.baidu.android.common.others.lang.StringUtil;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    public transient ExtensionMap<T> extensionMap;

    /* loaded from: classes7.dex */
    public static abstract class ExtendableBuilder<T extends ExtendableMessage<?>> extends Message.Builder<T> {
        public ExtensionMap<T> extensionMap;

        public ExtendableBuilder() {
        }

        public <E> E getExtension(Extension<T, E> extension) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            if (extensionMap == null) {
                return null;
            }
            return (E) extensionMap.get(extension);
        }

        public <E> ExtendableBuilder<T> setExtension(Extension<T, E> extension, E e2) {
            if (this.extensionMap == null) {
                this.extensionMap = new ExtensionMap<>();
            }
            this.extensionMap.put(extension, e2);
            return this;
        }

        public ExtendableBuilder(ExtendableMessage<T> extendableMessage) {
            super(extendableMessage);
            ExtensionMap<T> extensionMap;
            if (extendableMessage == null || (extensionMap = extendableMessage.extensionMap) == null) {
                return;
            }
            this.extensionMap = new ExtensionMap<>(extensionMap);
        }
    }

    public ExtendableMessage(ExtendableBuilder<T> extendableBuilder) {
        super(extendableBuilder);
        ExtensionMap<T> extensionMap = extendableBuilder.extensionMap;
        if (extensionMap != null) {
            this.extensionMap = new ExtensionMap<>(extensionMap);
        }
    }

    public boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        ExtensionMap<T> extensionMap = this.extensionMap;
        if (extensionMap == null) {
            return extendableMessage.extensionMap == null;
        }
        return extensionMap.equals(extendableMessage.extensionMap);
    }

    public int extensionsHashCode() {
        ExtensionMap<T> extensionMap = this.extensionMap;
        if (extensionMap == null) {
            return 0;
        }
        return extensionMap.hashCode();
    }

    public String extensionsToString() {
        ExtensionMap<T> extensionMap = this.extensionMap;
        return extensionMap == null ? StringUtil.EMPTY_ARRAY : extensionMap.toString();
    }

    public <E> E getExtension(Extension<T, E> extension) {
        ExtensionMap<T> extensionMap = this.extensionMap;
        if (extensionMap == null) {
            return null;
        }
        return (E) extensionMap.get(extension);
    }

    public List<Extension<T, ?>> getExtensions() {
        ExtensionMap<T> extensionMap = this.extensionMap;
        return extensionMap == null ? Collections.emptyList() : extensionMap.getExtensions();
    }
}
